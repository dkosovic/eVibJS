package OneDOF.Prog9.OOB;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

@SuppressWarnings("serial")
public class CBrianControl extends CPicturePanel {
   Applet mApplet;
   int mSelection;
   Date mSelStart;
   public double mMin;
   public double mValue;
   public double mMax;
   public double mOldValue;
   public double mDeltaPerSec;
   Label mLabel;
   static final int kNoSelection = 0;
   static final int kUpSelection = 1;
   static final int kDownSelection = 2;
   static final double kNearlyZero = 1.0E-10;

   public CBrianControl(Applet app, Label lab, double min, double val, double max) {
      this.mApplet = app;
      this.mLabel = lab;
      this.LoadImage(this.mApplet.getImage(this.mApplet.getCodeBase(), "BrianControl.gif"));
      this.mMin = min;
      this.mValue = val;
      this.mMax = max;
      this.BroadcastValue();
   }

   public Rectangle GridToRect(int which) {
      int ww = super.mImage.getWidth(this);
      int hh = super.mImage.getHeight(this);
      if (ww >= 0 && hh >= 0) {
         switch (which) {
            case 1:
               return new Rectangle(0, 0, ww, hh / 2);
            case 2:
               return new Rectangle(0, hh / 2, ww, hh);
            default:
               return null;
         }
      } else {
         return null;
      }
   }

   public int GetSelection(Point p) {
      for (int i = 1; i <= 2; i++) {
         Rectangle r = this.GridToRect(i);
         if (r == null) {
            return 0;
         }

         if (r.contains(p.x, p.y)) {
            return i;
         }
      }

      return 0;
   }

   public int GetSelection(int xx, int yy) {
      Point p = new Point(xx, yy);
      return this.GetSelection(p);
   }

   public static boolean NearlyEqual(double d1, double d2) {
      return Math.abs(d2 - d1) < 1.0E-10;
   }

   public static String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (NearlyEqual(arg, 0.0)) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + nns(-arg, sig);
      } else {
         double oom = Math.floor(log10(arg));
         double power = Math.pow(10.0, oom - sig + 1.0);
         long intArg = Math.round(arg / power);
         String result = String.valueOf(intArg * power);

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int lastChar;
            for (lastChar = result.length() - 1; result.charAt(lastChar) == '0'; trimmed = true) {
               lastChar--;
            }

            if (trimmed) {
               result = result.substring(0, lastChar + 1);
            }

            String shortStr = result.substring(0, lastChar);

            double newNum;
            try {
               newNum = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException var14) {
               break;
            }

            if (Math.abs(arg - newNum) > power) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public static String nns(double arg) {
      return nns(arg, 4);
   }

   public static double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public void NewSelection(int newSel) {
      this.mSelection = newSel;
      this.mSelStart = new Date();
      this.mOldValue = this.mValue;
      if (this.mSelection == 0) {
         this.mDeltaPerSec = 0.0;
      } else {
         double oom = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
         this.mDeltaPerSec = Math.pow(10.0, oom - 2.0);
         if (this.mSelection == 2) {
            this.mDeltaPerSec = -this.mDeltaPerSec;
         }

         this.NewValue();
      }

      this.repaint();
   }

   void NewValue() {
      if (this.mSelStart != null) {
         long startTime = this.mSelStart.getTime();
         Date nowDate = new Date();
         long nowTime = nowDate.getTime();
         double dT = (nowTime - startTime) / 1000.0;
         boolean turbo = dT > 1.0;
         double delta;
         double quant;
         if (turbo) {
            delta = this.mDeltaPerSec * 10.0 * dT;
            quant = this.mDeltaPerSec;
         } else {
            delta = this.mDeltaPerSec * dT;
            quant = this.mDeltaPerSec / 10.0;
         }

         this.mValue = this.mOldValue + delta;
         this.mValue = MyRound(this.mValue, quant);
         if (this.mValue < this.mMin) {
            this.mValue = this.mMin;
         } else if (this.mValue > this.mMax) {
            this.mValue = this.mMax;
         }

         this.BroadcastValue();
      }
   }

   public static double MyRound(double val, double quant) {
      if (quant == 0.0) {
         return val;
      } else {
         quant = Math.abs(quant);
         return Math.round(val / quant) * quant;
      }
   }

   void BroadcastValue() {
      if (this.mLabel != null) {
         this.mLabel.setText(nns(this.mValue));
      }

      Event e = new Event(this.mApplet, Event.SCROLL_ABSOLUTE, this);
      this.postEvent(e);
   }

   public boolean mouseDown(Event evt, int xx, int yy) {
      this.NewSelection(this.GetSelection(xx, yy));
      return true;
   }

   public boolean mouseDrag(Event evt, int xx, int yy) {
      int newSel = this.GetSelection(xx, yy);
      if (newSel != this.mSelection) {
         this.NewSelection(newSel);
      }

      return true;
   }

   public boolean mouseUp(Event evt, int xx, int yy) {
      this.NewSelection(0);
      return true;
   }

   public void paint(Graphics g) {
      super.paint(g);
      if (this.mSelection != 0) {
         this.NewValue();
         g.setXORMode(Color.black);
         Rectangle selRect = this.GridToRect(this.mSelection);
         g.fillRect(selRect.x, selRect.y, selRect.width, selRect.height);
         g.setPaintMode();
         this.repaint(100L);
      }
   }
}

package OneDOF.Prog12.Abutmentresponse;

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
      int imageWidth = super.mImage.getWidth(this);
      int imageHeight = super.mImage.getHeight(this);
      if (imageWidth >= 0 && imageHeight >= 0) {
         switch (which) {
            case 1:
               return new Rectangle(0, 0, imageWidth, imageHeight / 2);
            case 2:
               return new Rectangle(0, imageHeight / 2, imageWidth, imageHeight);
            default:
               return null;
         }
      } else {
         return null;
      }
   }

   public int GetSelection(Point p) {
      for (int i = 1; i <= 2; i++) {
         Rectangle selectionRect = this.GridToRect(i);
         if (selectionRect == null) {
            return 0;
         }

         if (selectionRect.contains(p.x, p.y)) {
            return i;
         }
      }

      return 0;
   }

   public int GetSelection(int xx, int yy) {
      Point point = new Point(xx, yy);
      return this.GetSelection(point);
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
         double magnitude = Math.floor(log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long var7 = Math.round(arg / stepSize);
         String var9 = String.valueOf(var7 * stepSize);

         while (var9.length() > 1 && var9.indexOf(46) > -1) {
            boolean var10 = false;

            int var11;
            for (var11 = var9.length() - 1; var9.charAt(var11) == '0'; var10 = true) {
               var11--;
            }

            if (var10) {
               var9 = var9.substring(0, var11 + 1);
            }

            String var12 = var9.substring(0, var11);

            double var13;
            try {
               var13 = java.lang.Double.parseDouble(var12);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - var13) > stepSize) {
               break;
            }

            var9 = var12;
         }

         return var9;
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
         double magnitude = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
         this.mDeltaPerSec = Math.pow(10.0, magnitude - 2.0);
         if (this.mSelection == 2) {
            this.mDeltaPerSec = -this.mDeltaPerSec;
         }

         this.NewValue();
      }

      this.repaint();
   }

   void NewValue() {
      if (this.mSelStart != null) {
         long var1 = this.mSelStart.getTime();
         Date now = new Date();
         long currentTime = now.getTime();
         double elapsedSeconds = (currentTime - var1) / 1000.0;
         boolean var8 = elapsedSeconds > 1.0;
         double var9;
         double var11;
         if (var8) {
            var9 = this.mDeltaPerSec * 10.0 * elapsedSeconds;
            var11 = this.mDeltaPerSec;
         } else {
            var9 = this.mDeltaPerSec * elapsedSeconds;
            var11 = this.mDeltaPerSec / 10.0;
         }

         this.mValue = this.mOldValue + var9;
         this.mValue = MyRound(this.mValue, var11);
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

      Event event = new Event(this.mApplet, Event.SCROLL_ABSOLUTE, this);
      this.postEvent(event);
   }

   public boolean mouseDown(Event evt, int xx, int yy) {
      this.NewSelection(this.GetSelection(xx, yy));
      return true;
   }

   public boolean mouseDrag(Event evt, int xx, int yy) {
      int var4 = this.GetSelection(xx, yy);
      if (var4 != this.mSelection) {
         this.NewSelection(var4);
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
         Rectangle selectionRect = this.GridToRect(this.mSelection);
         g.fillRect(selectionRect.x, selectionRect.y, selectionRect.width, selectionRect.height);
         g.setPaintMode();
         this.repaint(100L);
      }
   }
}

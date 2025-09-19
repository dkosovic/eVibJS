package OneDOF.Prog11.AbutmentSin;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

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

   public CBrianControl(Applet var1, Label var2, double var3, double var5, double var7) {
      this.mApplet = var1;
      this.mLabel = var2;
      this.LoadImage(this.mApplet.getImage(this.mApplet.getCodeBase(), "BrianControl.gif"));
      this.mMin = var3;
      this.mValue = var5;
      this.mMax = var7;
      this.BroadcastValue();
   }

   public Rectangle GridToRect(int var1) {
      int var2 = super.mImage.getWidth(this);
      int var3 = super.mImage.getHeight(this);
      if (var2 >= 0 && var3 >= 0) {
         switch (var1) {
            case 1:
               return new Rectangle(0, 0, var2, var3 / 2);
            case 2:
               return new Rectangle(0, var3 / 2, var2, var3);
            default:
               return null;
         }
      } else {
         return null;
      }
   }

   public int GetSelection(Point var1) {
      for (int var2 = 1; var2 <= 2; var2++) {
         Rectangle var3 = this.GridToRect(var2);
         if (var3 == null) {
            return 0;
         }

         if (var3.contains(var1.x, var1.y)) {
            return var2;
         }
      }

      return 0;
   }

   public int GetSelection(int var1, int var2) {
      Point var3 = new Point(var1, var2);
      return this.GetSelection(var3);
   }

   public static boolean NearlyEqual(double var0, double var2) {
      return Math.abs(var2 - var0) < 1.0E-10;
   }

   public static String nns(double var0, int var2) {
      if (var2 <= 0) {
         var2 = 1;
      }

      if (NearlyEqual(var0, 0.0)) {
         return new String("0");
      } else if (var0 < 0.0) {
         return new String("-" + nns(-var0, var2));
      } else {
         double var3 = Math.floor(log10(var0));
         double var5 = Math.pow(10.0, var3 - var2 + 1.0);
         long var7 = Math.round(var0 / var5);
         String var9 = new String(String.valueOf(var7 * var5));

         while (var9.length() > 1 && var9.indexOf(46) > -1) {
            boolean var10 = false;

            int var11;
            for (var11 = var9.length() - 1; var9.charAt(var11) == '0'; var10 = true) {
               var11--;
            }

            if (var10) {
               var9 = new String(var9.substring(0, var11 + 1));
            }

            String var12 = new String(var9.substring(0, var11));

            double var13;
            try {
               var13 = java.lang.Double.parseDouble(var12);
            } catch (NumberFormatException var14) {
               break;
            }

            if (Math.abs(var0 - var13) > var5) {
               break;
            }

            var9 = var12;
         }

         return var9;
      }
   }

   public static String nns(double var0) {
      return nns(var0, 4);
   }

   public static double log10(double var0) {
      return Math.log(var0) / Math.log(10.0);
   }

   public void NewSelection(int var1) {
      this.mSelection = var1;
      this.mSelStart = new Date();
      this.mOldValue = this.mValue;
      if (this.mSelection == 0) {
         this.mDeltaPerSec = 0.0;
      } else {
         double var2 = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
         this.mDeltaPerSec = Math.pow(10.0, var2 - 2.0);
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
         Date var3 = new Date();
         long var4 = var3.getTime();
         double var6 = (var4 - var1) / 1000.0;
         boolean var8 = var6 > 1.0;
         double var9;
         double var11;
         if (var8) {
            var9 = this.mDeltaPerSec * 10.0 * var6;
            var11 = this.mDeltaPerSec;
         } else {
            var9 = this.mDeltaPerSec * var6;
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

   public static double MyRound(double var0, double var2) {
      if (var2 == 0.0) {
         return var0;
      } else {
         var2 = Math.abs(var2);
         return Math.round(var0 / var2) * var2;
      }
   }

   void BroadcastValue() {
      if (this.mLabel != null) {
         this.mLabel.setText(nns(this.mValue));
      }

      Event var1 = new Event(this.mApplet, Event.SCROLL_ABSOLUTE, this);
      this.postEvent(var1);
   }

   public boolean mouseDown(Event var1, int var2, int var3) {
      this.NewSelection(this.GetSelection(var2, var3));
      return true;
   }

   public boolean mouseDrag(Event var1, int var2, int var3) {
      int var4 = this.GetSelection(var2, var3);
      if (var4 != this.mSelection) {
         this.NewSelection(var4);
      }

      return true;
   }

   public boolean mouseUp(Event var1, int var2, int var3) {
      this.NewSelection(0);
      return true;
   }

   public void paint(Graphics var1) {
      super.paint(var1);
      if (this.mSelection != 0) {
         this.NewValue();
         var1.setXORMode(Color.black);
         Rectangle var2 = this.GridToRect(this.mSelection);
         var1.fillRect(var2.x, var2.y, var2.width, var2.height);
         var1.setPaintMode();
         this.repaint(100L);
      }
   }
}

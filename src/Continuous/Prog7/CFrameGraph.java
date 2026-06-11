package Continuous.Prog7.Multiforced;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDoCode = 2;
   public static final int kDLCode = 3;
   public static final int kWanimateCode = 4;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 2.0;
   public static final double kStartDo = 0.05;
   public static final double kStartDL = 0.2;
   public static final double kStartWanimate = 500.0;
   public static final double kStartEta = 0.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 20.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[] mRec = new double[401];
   double[] mxp = new double[31];
   double mL = 2.0;
   double mDo = 0.05;
   double mDL = 0.2;
   double mWanimate = 500.0;
   double mlambda;
   double mw;
   double mArea;
   double mz;
   double mB;
   double mXi;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(40, 370, 440, 370);
      g.drawLine(40, 371, 440, 371);
      g.drawLine(39, 30, 39, 375);
      g.drawLine(40, 30, 40, 375);
      double var3 = 1.0E-5;

      for (int i = 1; i < 8; i++) {
         var3 /= 10.0;
         g.drawLine(40, (int)(-220.0 - Math.log(var3) * 20.0), 37, (int)(-220.0 - Math.log(var3) * 20.0));
      }

      for (int j = 1; j < 6; j++) {
         g.drawLine(40 + j * 80, 370, 40 + j * 80, 367);
      }

      g.setColor(tealColor);
      this.response();

      for (int k = 2; k < 400; k++) {
         g.drawLine(40 + (k - 1), (int)(-220.0 - Math.log(this.mRec[k - 1]) * 20.0), 40 + k, (int)(-220.0 - Math.log(this.mRec[k]) * 20.0));
      }

      int animatePixel = (int)(this.mWanimate * 400.0 / 5000.0);
      g.setColor(Color.blue);
      g.drawLine(40 + animatePixel, 370, 40 + animatePixel, (int)(-220.0 - Math.log(this.mRec[animatePixel]) * 20.0));
      g.drawLine(40 + animatePixel, 373, 40 + animatePixel, 368);
      g.drawString(this.nns(this.mWanimate) + " Hz", 40 + animatePixel + 2, 385);
   }

   public double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + this.nns(-arg, sig);
      } else {
         double magnitude = Math.floor(this.log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long intArg = Math.round(arg / stepSize);
         String result = String.valueOf(intArg * stepSize);

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int trimIdx;
            for (trimIdx = result.length() - 1; result.charAt(trimIdx) == '0'; trimmed = true) {
               trimIdx--;
            }

            if (trimmed) {
               result = result.substring(0, trimIdx + 1);
            }

            String shortStr = result.substring(0, trimIdx);

            double parsedDouble;
            try {
               parsedDouble = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - parsedDouble) > stepSize) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      var1.setColor(Color.white);
      var1.fillRect(0, 390, 600, 190);
      var1.fillRect(0, 0, 450, 20);
      int var12 = 60;
      double var13 = 1.0472;
      short var15 = 430;
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      Color orangeColor = new Color(0.77F, 0.38F, 0.0F);
      var1.setColor(tealColor);
      this.setOmegaDisp(this.mWanimate);
      double var5 = 0.0;

      for (int i = 0; i < 31; i++) {
         var5 = this.mxp[i] * Math.cos(0.7 * this.mTime * 2.0 * Math.PI);
         int var9 = (int)(250.0 * (this.mDo / 2.0 + (this.mDL - this.mDo) * i / 60.0));
         if (i == 0) {
            ;
         }

         var1.drawArc(var12 + (int)(250.0 * i * this.mL / 30.0) - (int)(var9 * Math.cos(var13) - var5), var15 - var9, var9, var9 * 2, 90, 180);
      }

      int var19 = (int)(250.0 * this.mDL / 2.0);
      var1.drawArc(var12 + (int)(250.0 * this.mL) - (int)(var19 * Math.cos(var13) - var5), var15 - var19, var19, var19 * 2, 0, 360);
      var1.setColor(orangeColor);
      var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19, var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 10);
      int var16 = (int)(20.0 * Math.cos(0.7 * this.mTime * 2.0 * Math.PI));
      if (var16 != 0) {
         if (var16 > 0) {
            var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 5, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 5);
            var1.drawLine(
               var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 6, var12 + (int)(250.0 * this.mL) + (int)var5 + var16 + 1, var15 + var19 + 6
            );
            var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 7, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 7);
         }

         if (var16 < 0) {
            var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 5, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 5);
            var1.drawLine(
               var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 6, var12 + (int)(250.0 * this.mL) + (int)var5 + var16 - 1, var15 + var19 + 6
            );
            var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 7, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 7);
         }
      }

      var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 5, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 5);
      var1.drawLine(var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var19 + 6, var12 + (int)(250.0 * this.mL) + (int)var5 + var16, var15 + var19 + 6);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean trimmed = false;
      switch (code) {
         case 1:
            this.mL = val;
            this.response();
            break;
         case 2:
            this.mDo = val;
            if (this.mDo == this.mDL) {
               this.mDo += 0.001;
            }

            this.response();
            break;
         case 3:
            this.mDL = val;
            if (this.mDL == this.mDo) {
               this.mDL += 0.001;
            }

            this.response();
            break;
         case 4:
            this.mWanimate = val;
            this.setOmegaDisp(this.mWanimate);
            trimmed = true;
            break;
         case 5:
            this.mTime += val;
            trimmed = true;
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      for (int i = 1; i < 401; i++) {
         this.mw = i * 5000.0 * 2.0 * Math.PI / 400.0;
         double var8 = this.mw * Math.sqrt(3.9E-8);
         double var2 = this.mDo / 2.0;
         double var4 = this.mDL / 2.0;
         double var6 = (var4 - var2) / this.mL;
         double var10 = var8 * var2 / var6;
         double var12 = var8 * this.mL + var10;
         double var14 = var10 * var10;
         double var16 = var12 * var12;
         double var18 = Math.sin(var10);
         double var20 = Math.cos(var10);
         double var22 = Math.sin(var12);
         double var24 = Math.cos(var12);
         double var26 = var20 / var10 - var18 / var14;
         double var28 = var24 / var16 + var22 / var12;
         double var30 = var20 / var14 + var18 / var10;
         double var32 = var24 / var12 - var22 / var16;
         double var34 = var20 / var10 - var18 / var14;
         double var36 = var26 * var28 - var30 * var32;
         this.mRec[i] = Math.abs(-1.0 * (var30 * var22 + var34 * var24) / (6.283185307179586E11 * var4 * var4 * var8 * var36 * var12));
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void setOmegaDisp(double var1) {
      double var4 = 0.0;
      double omega = var1 * 2.0 * Math.PI * Math.sqrt(3.9E-8);

      for (int i = 0; i < 31; i++) {
         double var8 = this.mDo / 2.0;
         double var10 = this.mDL / 2.0;
         double var12 = (var10 - var8) / this.mL;
         double var24 = omega * (i * this.mL / 30.0 + var8 / var12);
         double var16 = omega * var8 / var12;
         double var18 = omega * this.mL + var16;
         double var20 = var16 * var16;
         double var22 = var18 * var18;
         double var26 = Math.sin(var16);
         double var28 = Math.cos(var16);
         double var30 = Math.sin(var18);
         double var32 = Math.cos(var18);
         double var34 = var28 / var16 - var26 / var20;
         double var36 = var32 / var22 + var30 / var18;
         double var38 = var28 / var20 + var26 / var16;
         double var40 = var32 / var18 - var30 / var22;
         double var42 = var28 / var16 - var26 / var20;
         double var44 = var34 * var36 - var38 * var40;
         this.mxp[i] = -1.0 * (var38 * Math.sin(var24) + var42 * Math.cos(var24)) / (6.283185307179586E11 * var10 * var10 * omega * var44 * var24);
         double var6 = Math.abs(this.mxp[i]);
         if (Math.abs(var6) > Math.abs(var4)) {
            var4 = Math.abs(var6);
         }
      }

      for (int j = 0; j < 31; j++) {
         this.mxp[j] = this.mxp[j] * 20.0 / var4;
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevh1t) {
      if (prevh1t) {
         return false;
      } else {
         // boolean hit = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (code) {
            case 0:
            case 1:
               double newOmega = (super.mFramePanel.mThisPt.x - 40) * 5000.0 / 400.0;
               if (newOmega > 5000.0) {
                  newOmega = 5000.0;
               }

               if (newOmega < 50.0) {
                  newOmega = 50.0;
               }

               this.ControlMessage(this, 4, newOmega);
            default:
               return true;
         }
      }
   }
}

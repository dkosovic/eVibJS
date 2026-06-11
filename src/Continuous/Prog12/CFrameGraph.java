package Continuous.Prog12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kBCode = 2;
   public static final int kHCode = 3;
   public static final int kWanimateCode = 4;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 1.5;
   public static final double kStartB = 0.12;
   public static final double kStartH = 0.12;
   public static final double kStartWanimate = 500.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 30.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[] mRec = new double[401];
   double[] mxp = new double[31];
   double[] mAmp = new double[31];
   double mL = 1.5;
   double mB = 0.12;
   double mH = 0.12;
   double mWanimate = 500.0;
   double mlambda;
   double mw;
   double mArea;
   double mInertia;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(38, 370, 440, 370);
      g.drawLine(38, 371, 440, 371);
      g.drawLine(39, 374, 39, 15);
      g.drawLine(40, 374, 40, 15);

      for (int i = 0; i < 12; i++) {
         g.drawLine(40, 370 - i * 30, 37, 370 - i * 30);
      }

      for (int j = 1; j < 6; j++) {
         g.drawLine(40 + j * 80, 370, 40 + j * 80, 367);
      }

      g.setColor(tealColor);
      this.response();

      for (int k = 2; k < 400; k++) {
         g.drawLine(
            40 + (k - 1),
            (int)(10.0 - Math.log(Math.abs(this.mRec[k - 1])) / Math.log(10.0) * 30.0),
            40 + k,
            (int)(10.0 - Math.log(Math.abs(this.mRec[k])) / Math.log(10.0) * 30.0)
         );
      }

      int animatePixel = (int)(this.mWanimate * 400.0 / 5000.0);
      g.setColor(Color.blue);
      g.drawLine(40 + animatePixel, 370, 40 + animatePixel, (int)(10.0 - Math.log(Math.abs(this.mRec[animatePixel])) / Math.log(10.0) * 30.0));
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
      int blockH = 20;
      int var10 = 30;
      double var11 = 1.0472;
      short var13 = 470;
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      Color var16 = new Color(0.52F, 0.82F, 0.82F);
      Color orangeColor = new Color(0.77F, 0.38F, 0.0F);
      new Color(1.0F, 1.0F, 0.4F);
      int var20 = 90;
      int var21 = (int)(var20 * Math.cos(var11) / 2.0);
      this.setOmegaDisp(this.mWanimate);
      this.mAmp[0] = 0.0;

      for (int i = 0; i < 31; i++) {
         this.mAmp[i] = this.mxp[i] * Math.cos(0.7 * this.mTime * 2.0 * Math.PI);
      }

      var1.setColor(var16);
      Polygon var23 = new Polygon();
      int var24 = (int)(250.0 * this.mB * Math.cos(var11) / 2.0);
      int var25 = (int)(250.0 * this.mB * Math.sin(var11) / 2.0);

      for (int j = 0; j < 31; j++) {
         var23.addPoint(blockH + var10 + var21 + (int)(j * 250.0 * this.mL / 30.0) - var24, var13 - (int)(this.mAmp[j] - this.mH * 250.0 / 2.0) + var25);
      }

      var23.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) - var24, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) + var25);

      for (int k = 29; k > -1; k--) {
         var23.addPoint(blockH + var10 + var21 + (int)(k * 250.0 * this.mL / 30.0) - var24, var13 - (int)(this.mAmp[k] + this.mH * 250.0 / 2.0) + var25);
      }

      var1.drawPolygon(var23);
      var1.fillPolygon(var23);
      var1.setColor(tealColor);
      Polygon var26 = new Polygon();

      for (int var30 = 0; var30 < 31; var30++) {
         var26.addPoint(blockH + var10 + var21 + (int)(var30 * 250.0 * this.mL / 30.0) - var24, var13 - (int)(this.mAmp[var30] + this.mH * 250.0 / 2.0) + var25);
      }

      var26.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) + var24, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) - var25);

      for (int var31 = 29; var31 > -1; var31--) {
         var26.addPoint(blockH + var10 + var21 + (int)(var31 * 250.0 * this.mL / 30.0) + var24, var13 - (int)(this.mAmp[var31] + this.mH * 250.0 / 2.0) - var25);
      }

      var1.drawPolygon(var26);
      var1.fillPolygon(var26);
      var1.setColor(tealColor);
      Polygon var27 = new Polygon();
      var27.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) - var24, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) + var25);
      var27.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) + var24, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) - var25);
      var27.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) + var24, var13 - (int)(this.mAmp[30] - this.mH * 250.0 / 2.0) - var25);
      var27.addPoint(blockH + var10 + var21 + (int)(250.0 * this.mL) - var24, var13 - (int)(this.mAmp[30] - this.mH * 250.0 / 2.0) + var25);
      var1.drawPolygon(var27);
      var1.fillPolygon(var27);
      var1.setColor(orangeColor);
      var1.drawLine(
         blockH + var10 + (int)(250.0 * this.mL) + var21,
         var13 - (int)this.mAmp[30],
         blockH + var10 + (int)(250.0 * this.mL) + var21 + 20,
         var13 - (int)this.mAmp[30]
      );
      int var14 = (int)(20.0 * Math.cos(0.7 * this.mTime * 2.0 * Math.PI));
      if (var14 != 0) {
         if (var14 > 0) {
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 12,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 12,
               var13 - var14 - (int)this.mAmp[30]
            );
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 13,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 13,
               var13 - var14 - (int)this.mAmp[30] - 1
            );
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 14,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 14,
               var13 - var14 - (int)this.mAmp[30]
            );
         }

         if (var14 < 0) {
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 12,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 12,
               var13 - var14 - (int)this.mAmp[30]
            );
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 13,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 13,
               var13 - var14 - (int)this.mAmp[30] + 1
            );
            var1.drawLine(
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 14,
               var13 - (int)this.mAmp[30],
               blockH + var10 + (int)(250.0 * this.mL) + var21 + 14,
               var13 - var14 - (int)this.mAmp[30]
            );
         }
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean trimmed = false;
      switch (code) {
         case 1:
            this.mL = val;
            this.response();
            break;
         case 2:
            this.mB = val;
            this.response();
            break;
         case 3:
            this.mH = val;
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
      this.mArea = Math.PI * this.mB * this.mH;
      this.mInertia = this.mArea * this.mH * this.mH / 12.0;

      for (int i = 1; i < 401; i++) {
         this.mw = i * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double A = this.mlambda * this.mL;
         double var2 = Math.sin(A);
         double var4 = Math.cos(A);
         double var16 = Math.exp(A);
         double var6 = (var16 - 1.0 / var16) / 2.0;
         double var8 = (var16 + 1.0 / var16) / 2.0;
         double var10 = var4 * var8 - 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var18 = 1.0 / (2.0E11 * this.mInertia * this.mL * this.mL * this.mL * var10);
         this.mRec[i] = -var12 * var18;
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void setOmegaDisp(double var1) {
      this.mArea = Math.PI * this.mB * this.mH;
      this.mInertia = this.mArea * this.mH * this.mH / 12.0;
      this.mlambda = Math.sqrt(Math.sqrt(var1 * 2.0 * Math.PI * var1 * 2.0 * Math.PI * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
      double A = this.mlambda * this.mL;
      double var14 = Math.sin(A);
      double var16 = Math.cos(A);
      double var22 = Math.exp(A);
      double var18 = (var22 - 1.0 / var22) / 2.0;
      double var20 = (var22 + 1.0 / var22) / 2.0;
      double var6 = var14 - var18;
      double var8 = var16 - var20;
      double var4 = var16 * var20 - 1.0;
      double var10 = 1.0 / (2.0E11 * this.mInertia * this.mL * this.mL * this.mL * var4);
      double var34 = 0.0;

      for (int i = 0; i < 31; i++) {
         double var24 = this.mlambda * i * this.mL / 30.0;
         double var26 = Math.sin(var24);
         double var28 = Math.cos(var24);
         var22 = Math.exp(var24);
         double var30 = (var22 - 1.0 / var22) / 2.0;
         double var32 = (var22 + 1.0 / var22) / 2.0;
         this.mxp[i] = (var6 * (var28 + var32) - var8 * (var26 + var30)) * var10;
         if (Math.abs(this.mxp[i]) > var34) {
            var34 = Math.abs(this.mxp[i]);
         }
      }

      for (int j = 0; j < 31; j++) {
         this.mxp[j] = this.mxp[j] * 20.0 / var34;
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

               if (newOmega < 20.0) {
                  newOmega = 20.0;
               }

               this.ControlMessage(this, 4, newOmega);
            default:
               return true;
         }
      }
   }
}

package Continuous.Prog3.Multiforced;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kWanimateCode = 3;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 1.0;
   public static final double kStartD = 0.1;
   public static final double kStartWanimate = 500.0;
   public static final double kStartEta = 0.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 20.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[][] mRec = new double[401][2];
   double[] mResponse = new double[401];
   double[][] mxp = new double[31][2];
   public Vector mElements;
   double mL = 1.0;
   double mD = 0.1;
   double mWanimate = 500.0;
   double mEta = 0.0;
   double mlambda;
   double mw;
   double mArea;
   double mXi;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      Color var5 = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      var1.setPaintMode();
      var1.setColor(Color.black);
      var1.drawLine(40, 370, 440, 370);
      var1.drawLine(40, 371, 440, 371);
      var1.drawLine(39, 30, 39, 375);
      var1.drawLine(40, 30, 40, 375);
      double var3 = 1.0E-5;

      for (int var2 = 1; var2 < 8; var2++) {
         var3 /= 10.0;
         var1.drawLine(40, (int)(-220.0 - Math.log(var3) * 20.0), 37, (int)(-220.0 - Math.log(var3) * 20.0));
      }

      for (int var7 = 1; var7 < 6; var7++) {
         var1.drawLine(40 + var7 * 80, 370, 40 + var7 * 80, 367);
      }

      var1.setColor(var5);
      this.response();

      for (int var8 = 2; var8 < 400; var8++) {
         var1.drawLine(
            40 + (var8 - 1), (int)(-220.0 - Math.log(this.mResponse[var8 - 1]) * 20.0), 40 + var8, (int)(-220.0 - Math.log(this.mResponse[var8]) * 20.0)
         );
      }

      int var9 = (int)(this.mWanimate * 400.0 / 5000.0);
      var1.setColor(Color.blue);
      var1.drawLine(40 + var9, 370, 40 + var9, (int)(-220.0 - Math.log(this.mResponse[var9]) * 20.0));
      var1.drawLine(40 + var9, 373, 40 + var9, 368);
      var1.drawString(this.nns(this.mWanimate) + " Hz", 40 + var9 + 2, 385);
   }

   public double log10(double var1) {
      return Math.log(var1) / Math.log(10.0);
   }

   public String nns(double var1, int var3) {
      if (var3 <= 0) {
         var3 = 1;
      }

      if (var1 == 0.0) {
         return new String("0");
      } else if (var1 < 0.0) {
         return new String("-" + this.nns(-var1, var3));
      } else {
         double var4 = Math.floor(this.log10(var1));
         double var6 = Math.pow(10.0, var4 - var3 + 1.0);
         long var8 = Math.round(var1 / var6);
         String var10 = new String(String.valueOf(var8 * var6));

         while (var10.length() > 1 && var10.indexOf(46) > -1) {
            boolean var11 = false;

            int var12;
            for (var12 = var10.length() - 1; var10.charAt(var12) == '0'; var11 = true) {
               var12--;
            }

            if (var11) {
               var10 = new String(var10.substring(0, var12 + 1));
            }

            String var13 = new String(var10.substring(0, var12));

            double var14;
            try {
               var14 = java.lang.Double.parseDouble(var13);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(var1 - var14) > var6) {
               break;
            }

            var10 = var13;
         }

         return var10;
      }
   }

   public String nns(double var1) {
      return this.nns(var1, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      double var9 = this.GetTime();
      var1.setColor(Color.white);
      var1.fillRect(0, 390, 600, 190);
      var1.fillRect(0, 0, 450, 20);
      byte var11 = 60;
      double var12 = 1.0472;
      short var14 = 430;
      Color var16 = new Color(0.18F, 0.58F, 0.58F);
      Color var17 = new Color(0.77F, 0.38F, 0.0F);
      int var18 = (int)(250.0 * this.mD / 2.0);
      var1.setColor(var16);
      this.setOmegaDisp(this.mWanimate);
      double var5 = 0.0;
      double var7 = 0.0;

      for (int var4 = 0; var4 < 31; var4++) {
         var5 = this.mxp[var4][0] * Math.cos(0.7 * this.mTime * 2.0 * Math.PI) + this.mxp[var4][1] * Math.sin(0.7 * this.mTime * 2.0 * Math.PI);
         if (var4 == 0) {
            var7 = var5;
         }

         var1.drawArc(var11 + (int)(250.0 * var4 * this.mL / 30.0) - (int)(var18 * Math.cos(var12) - var5), var14 - var18, var18, var18 * 2, 90, 180);
      }

      var1.drawArc(var11 + (int)(250.0 * this.mL) - (int)(var18 * Math.cos(var12) - var5), var14 - var18, var18, var18 * 2, 0, 360);
      var1.drawLine(var11 + (int)var7, var14 - var18, var11 + (int)(250.0 * this.mL) + (int)var5, var14 - var18);
      var1.drawLine(var11 + (int)var7, var14 + var18, var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18);
      var1.setColor(var17);
      var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18, var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 10);
      int var15 = (int)(20.0 * Math.cos(0.7 * this.mTime * 2.0 * Math.PI));
      if (var15 != 0) {
         if (var15 > 0) {
            var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 5, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 5);
            var1.drawLine(
               var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 6, var11 + (int)(250.0 * this.mL) + (int)var5 + var15 + 1, var14 + var18 + 6
            );
            var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 7, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 7);
         }

         if (var15 < 0) {
            var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 5, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 5);
            var1.drawLine(
               var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 6, var11 + (int)(250.0 * this.mL) + (int)var5 + var15 - 1, var14 + var18 + 6
            );
            var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 7, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 7);
         }
      }

      var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 5, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 5);
      var1.drawLine(var11 + (int)(250.0 * this.mL) + (int)var5, var14 + var18 + 6, var11 + (int)(250.0 * this.mL) + (int)var5 + var15, var14 + var18 + 6);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mL = var3;
            this.response();
            break;
         case 2:
            this.mD = var3;
            this.response();
            break;
         case 3:
            this.mWanimate = var3;
            this.setOmegaDisp(this.mWanimate);
            var5 = true;
         case 4:
         default:
            break;
         case 5:
            this.mTime += var3;
            var5 = true;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      for (int var1 = 1; var1 < 401; var1++) {
         this.mw = var1 * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = this.mw * Math.sqrt(3.9E-8);
         this.mArea = Math.PI * this.mD * this.mD / 4.0;
         double var2 = Math.sqrt(1.0 + this.mEta * this.mEta);
         double var4 = Math.sqrt((var2 + 1.0) / 2.0) / var2;
         double var6 = -Math.sqrt((var2 - 1.0) / 2.0) / var2;
         double var12 = (Math.exp(this.mlambda * var6 * this.mL) - Math.exp(-this.mlambda * var6 * this.mL)) / 2.0;
         double var14 = (Math.exp(this.mlambda * var6 * this.mL) + Math.exp(-this.mlambda * var6 * this.mL)) / 2.0;
         double var8 = Math.cos(this.mlambda * var4 * this.mL) * var12 * (var6 + this.mEta * var4)
            + (this.mEta * var6 - var4) * Math.sin(this.mlambda * var4 * this.mL) * var14;
         var8 = var8 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         double var10 = Math.cos(this.mlambda * var4 * this.mL) * var12 * (this.mEta * var6 - var4)
            - (var6 + this.mEta * var4) * Math.sin(this.mlambda * var4 * this.mL) * var14;
         var10 = var10 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         var2 = 2.0 / (var8 * var8 + var10 * var10);
         this.mRec[var1][0] = var2 * (var8 * var14 * Math.cos(this.mlambda * var4 * this.mL) - var10 * var12 * Math.sin(this.mlambda * var4 * this.mL));
         this.mRec[var1][1] = -var2 * (var8 * var12 * Math.sin(this.mlambda * var4 * this.mL) + var10 * var14 * Math.cos(this.mlambda * var4 * this.mL));
         this.mResponse[var1] = Math.sqrt(this.mRec[var1][0] * this.mRec[var1][0] + this.mRec[var1][1] * this.mRec[var1][1]);
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void setOmegaDisp(double var1) {
      double var4 = 0.0;
      this.mlambda = var1 * 2.0 * Math.PI * Math.sqrt(3.9E-8);

      for (int var3 = 0; var3 < 31; var3++) {
         double var6 = Math.sqrt(1.0 + this.mEta * this.mEta);
         double var8 = Math.sqrt((var6 + 1.0) / 2.0) / var6;
         double var10 = -Math.sqrt((var6 - 1.0) / 2.0) / var6;
         double var16 = (Math.exp(this.mlambda * var10 * this.mL) - Math.exp(-this.mlambda * var10 * this.mL)) / 2.0;
         double var18 = (Math.exp(this.mlambda * var10 * this.mL) + Math.exp(-this.mlambda * var10 * this.mL)) / 2.0;
         double var12 = Math.cos(this.mlambda * var8 * this.mL) * var16 * (var10 + this.mEta * var8)
            + (this.mEta * var10 - var8) * Math.sin(this.mlambda * var8 * this.mL) * var18;
         var12 = var12 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         double var14 = Math.cos(this.mlambda * var8 * this.mL) * var16 * (this.mEta * var10 - var8)
            - (var10 + this.mEta * var8) * Math.sin(this.mlambda * var8 * this.mL) * var18;
         var14 = var14 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         var6 = 2.0 / (var12 * var12 + var14 * var14);
         var16 = (Math.exp(this.mlambda * var10 * this.mL) - Math.exp(-this.mlambda * var10 * this.mL)) / 2.0;
         var18 = (Math.exp(this.mlambda * var10 * this.mL) + Math.exp(-this.mlambda * var10 * this.mL)) / 2.0;
         this.mxp[var3][0] = var6
            * (var12 * var18 * Math.cos(this.mlambda * var8 * this.mL * var3 / 30.0) - var14 * var16 * Math.sin(this.mlambda * var8 * this.mL * var3 / 30.0));
         this.mxp[var3][1] = -var6
            * (var12 * var16 * Math.sin(this.mlambda * var8 * this.mL * var3 / 30.0) + var14 * var18 * Math.cos(this.mlambda * var8 * this.mL * var3 / 30.0));
         double var20 = Math.sqrt(this.mxp[var3][0] * this.mxp[var3][0] + this.mxp[var3][1] * this.mxp[var3][1]);
         if (Math.abs(var20) > Math.abs(var4)) {
            var4 = Math.abs(var20);
         }
      }

      for (int var22 = 0; var22 < 31; var22++) {
         this.mxp[var22][0] = this.mxp[var22][0] * 20.0 / var4;
         this.mxp[var22][1] = this.mxp[var22][1] * 20.0 / var4;
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int var1, boolean var2) {
      if (var2) {
         return false;
      } else {
         boolean var3 = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (var1) {
            case 0:
            case 1:
               double var4 = (super.mFramePanel.mThisPt.x - 40) * 5000.0 / 400.0;
               if (var4 > 5000.0) {
                  var4 = 5000.0;
               }

               if (var4 < 50.0) {
                  var4 = 50.0;
               }

               this.ControlMessage(this, 3, var4);
            default:
               return true;
         }
      }
   }
}

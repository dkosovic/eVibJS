package Continuous.Prog5.Multiforced;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kWanimateCode = 3;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 2.0;
   public static final double kStartD = 0.2;
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
   double[] mResponse = new double[401];
   double[] mxp = new double[31];
   public Vector mElements;
   double mL = 2.0;
   double mD = 0.2;
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
      double var7 = this.GetTime();
      var1.setColor(Color.white);
      var1.fillRect(0, 390, 600, 190);
      var1.fillRect(0, 0, 450, 20);
      byte var9 = 20;
      byte var10 = 20;
      byte var11 = 80;
      byte var12 = 30;
      double var13 = 1.0472;
      short var15 = 430;
      Color var17 = new Color(0.18F, 0.58F, 0.58F);
      Color var18 = new Color(0.77F, 0.38F, 0.0F);
      Color var19 = new Color(1.0F, 1.0F, 0.4F);
      int var20 = (int)(250.0 * this.mD / 2.0);
      byte var21 = 50;
      var1.setColor(var19);
      var1.fillArc(var9 + var12 - 20 - (int)(var21 * Math.cos(var13)), var15 + var11 / 2 - var21, var21, var21 * 2, 0, 360);
      var1.fillRect(var9 + var12 - 20, var15 + var11 / 2 - var21, 20, 2 * var21);
      var1.setColor(Color.orange);
      var1.fillArc(var9 + var12 - (int)(var21 * Math.cos(var13)), var15 + var11 / 2 - var21, var21, var21 * 2, 0, 360);
      var1.setColor(Color.white);
      var1.fillArc(var9 + var12 - (int)(var20 * Math.cos(var13)), var15 + var11 / 2 - var20, var20, var20 * 2, 180, 360);
      var1.fillRect(var9 + var12, var15 + var11 / 2 - var20, 100, 2 * var20);
      var1.setColor(var17);
      this.setOmegaDisp(this.mWanimate);
      double var5 = 0.0;

      for (int var4 = 1; var4 < 31; var4++) {
         var5 = this.mxp[var4] * Math.cos(0.7 * this.mTime * 2.0 * Math.PI);
         var1.drawArc(
            var9 + var12 + (int)(250.0 * var4 * this.mL / 30.0) - (int)(var20 * Math.cos(var13) - var5), var15 + var11 / 2 - var20, var20, var20 * 2, 90, 180
         );
      }

      var1.drawArc(var9 + var12 + (int)(250.0 * this.mL) - (int)(var20 * Math.cos(var13) - var5), var15 + var11 / 2 - var20, var20, var20 * 2, 0, 360);
      var1.drawArc(var9 + var12 - (int)(var20 * Math.cos(var13)), var15 + var11 / 2 - var20, var20, var20 * 2, 90, 180);
      var1.drawLine(var9 + var12, var15 + var11 / 2 - var20, var9 + var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var11 / 2 - var20);
      var1.drawLine(var9 + var12, var15 + var11 / 2 + var20, var9 + var12 + (int)(250.0 * this.mL) + (int)var5, var15 + var11 / 2 + var20);
      var1.setColor(var18);
      var1.drawLine(
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
         var15 + var11 / 2 + var20,
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
         var15 + var11 / 2 + var20 + 10
      );
      int var16 = (int)(20.0 * Math.cos(0.7 * this.mTime * 2.0 * Math.PI));
      if (var16 != 0) {
         if (var16 > 0) {
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 5,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
               var15 + var11 / 2 + var20 + 5
            );
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 6,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16 + 1,
               var15 + var11 / 2 + var20 + 6
            );
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 7,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
               var15 + var11 / 2 + var20 + 7
            );
         }

         if (var16 < 0) {
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 5,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
               var15 + var11 / 2 + var20 + 5
            );
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 6,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16 - 1,
               var15 + var11 / 2 + var20 + 6
            );
            var1.drawLine(
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
               var15 + var11 / 2 + var20 + 7,
               var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
               var15 + var11 / 2 + var20 + 7
            );
         }
      }

      var1.drawLine(
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
         var15 + var11 / 2 + var20 + 5,
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
         var15 + var11 / 2 + var20 + 5
      );
      var1.drawLine(
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5,
         var15 + var11 / 2 + var20 + 6,
         var9 + var12 + (int)(250.0 * this.mL) + (int)var5 + var16,
         var15 + var11 / 2 + var20 + 6
      );
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
         if (var1 == 1) {
            this.mRec[1] = Math.tan(this.mlambda * this.mL) / (this.mArea * 2.0E11 * this.mlambda);
         } else {
            this.mRec[var1] = Math.tan(this.mlambda * this.mL) / (this.mArea * 2.0E11 * this.mlambda);
         }

         this.mResponse[var1] = Math.abs(this.mRec[var1]);
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void setOmegaDisp(double var1) {
      double var4 = 0.0;
      this.mlambda = var1 * 2.0 * Math.PI * Math.sqrt(3.9E-8);

      for (int var3 = 1; var3 < 31; var3++) {
         this.mxp[var3] = Math.sin(this.mlambda * this.mL * var3 / 30.0) / Math.cos(this.mlambda * this.mL);
         if (Math.abs(this.mxp[var3]) > Math.abs(var4)) {
            var4 = Math.abs(this.mxp[var3]);
         }
      }

      for (int var6 = 1; var6 < 31; var6++) {
         this.mxp[var6] = this.mxp[var6] * 20.0 / var4;
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

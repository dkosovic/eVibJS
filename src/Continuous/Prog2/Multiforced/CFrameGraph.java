package Continuous.Prog2.Multiforced;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kWanimateCode = 3;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 2.0;
   public static final double kStartD = 0.2;
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
   double mL = 2.0;
   double mD = 0.2;
   double mWanimate;
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
         var1.drawLine(40 + var7 * 80, 370, 40 + var7 * 80, 374);
      }

      var1.setColor(var5);
      this.response();

      for (int var8 = 2; var8 < 400; var8++) {
         var1.drawLine(
            40 + (var8 - 1), (int)(-220.0 - Math.log(this.mResponse[var8 - 1]) * 20.0), 40 + var8, (int)(-220.0 - Math.log(this.mResponse[var8]) * 20.0)
         );
      }
   }

   public double log10(double var1) {
      return Math.log(var1) / Math.log(10.0);
   }

   public String nns(double var1, int var3) {
      if (var3 <= 0) {
         var3 = 1;
      }

      if (var1 == 0.0) {
         return "0";
      } else if (var1 < 0.0) {
         return "-" + this.nns(-var1, var3);
      } else {
         double var4 = Math.floor(this.log10(var1));
         double var6 = Math.pow(10.0, var4 - var3 + 1.0);
         long var8 = Math.round(var1 / var6);
         String var10 = String.valueOf(var8 * var6);

         while (var10.length() > 1 && var10.indexOf(46) > -1) {
            boolean var11 = false;

            int var12;
            for (var12 = var10.length() - 1; var10.charAt(var12) == '0'; var11 = true) {
               var12--;
            }

            if (var11) {
               var10 = var10.substring(0, var12 + 1);
            }

            String var13 = var10.substring(0, var12);

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
         case 3:
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
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevh1t) {
      if (prevh1t) {
         return false;
      } else {
         boolean hit = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
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

               this.ControlMessage(this, 3, newOmega);
            default:
               return true;
         }
      }
   }
}

package TwoDOF.Prog7.Abutmentresponse_2DOF;

import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int km1Code = 1;
   public static final int kk1Code = 2;
   public static final int kc1Code = 3;
   public static final int km2Code = 4;
   public static final int kk2Code = 5;
   public static final int kc2Code = 6;
   public static final double kStartm1 = 0.1;
   public static final double kStartk1 = 20.0;
   public static final double kStartc1 = 0.05;
   public static final double kStartm2 = 0.1;
   public static final double kStartk2 = 20.0;
   public static final double kStartc2 = 0.05;
   public static final int kXo = 80;
   double[] mAmp;
   double[] mRealAmp;
   double[] mQuadAmp;
   double[] mPhase;
   double mm1 = 0.1;
   double mk1 = 20.0;
   double mc1 = 0.05;
   double mm2 = 0.1;
   double mk2 = 20.0;
   double mc2 = 0.05;
   double mW;
   double mWn1;
   double mWn2;
   double mWmin;
   double mWmax;
   double A = this.mm1 * this.mm2;
   double B = -(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
   double C = this.mk1 * this.mk2;
   int mxpower;
   int mypower;
   double mxscale;
   double myscale;

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mWn1 = Math.sqrt((-this.B - Math.sqrt(this.B * this.B - 4.0 * this.A * this.C)) / (2.0 * this.A)) / (Math.PI * 2);
      this.mWn2 = Math.sqrt((-this.B + Math.sqrt(this.B * this.B - 4.0 * this.A * this.C)) / (2.0 * this.A)) / (Math.PI * 2);
      this.mWmin = 0.1 * this.mWn1;
      this.mWmax = 1.5 * this.mWn2;
      this.mxscale = 60.0;
      this.myscale = 45.0;
   }

   public void Frame(Graphics var1) {
      this.mAmp = new double[602];
      this.mRealAmp = new double[602];
      this.mQuadAmp = new double[602];
      this.mPhase = new double[602];
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      var1.drawLine(77, 340, 563, 340);

      for (int var2 = 1; var2 < 9; var2++) {
         var1.drawLine(80 + var2 * 60, 340, 80 + var2 * 60, 343);
      }

      Color var18 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(var18);
      var1.drawLine(80, 47, 80, 343);

      for (int var20 = 0; var20 < 7; var20++) {
         var1.drawLine(80, 50 + var20 * 45, 77, 50 + var20 * 45);
      }

      this.mAmp[0] = 1.0;
      double var3 = this.mAmp[0];

      for (int var21 = 1; var21 < 481; var21++) {
         double var7 = (Math.PI * 2) * var21 / this.mxscale;
         double var15 = this.mk2 * this.mk2 + var7 * var7 * this.mc2 * this.mc2;
         double var9 = this.mk2 / var15 - 1.0 / (this.mm2 * var7 * var7);
         double var11 = -var7 * this.mc2 / var15;
         double var13 = this.mk1 - this.mm1 * var7 * var7 + var9 / (var9 * var9 + var11 * var11);
         var15 = var7 * this.mc1 - var11 / (var9 * var9 + var11 * var11);
         var9 = var13 / (var13 * var13 + var15 * var15);
         var11 = -var15 / (var13 * var13 + var15 * var15);
         this.mRealAmp[var21] = var9 * this.mk1 - var11 * var7 * this.mc1;
         this.mQuadAmp[var21] = var9 * var7 * this.mc1 + var11 * this.mk1;
         this.mAmp[var21] = Math.sqrt(this.mRealAmp[var21] * this.mRealAmp[var21] + this.mQuadAmp[var21] * this.mQuadAmp[var21]);
         var1.drawLine(
            80 + (var21 - 1),
            (int)(140.0 - Math.log(var3) / Math.log(10.0) * this.myscale),
            80 + var21,
            (int)(140.0 - Math.log(this.mAmp[var21]) / Math.log(10.0) * this.myscale)
         );
         var3 = this.mAmp[var21];
      }

      Color var19 = new Color(0.77F, 0.38F, 0.0F);
      var1.setColor(var19);
      this.mPhase[0] = 0.0;
      double var5 = this.mPhase[0];

      for (int var22 = 1; var22 < 481; var22++) {
         this.mPhase[var22] = 180.0 * Math.atan(this.mQuadAmp[var22] / this.mRealAmp[var22]) / Math.PI;
         if (this.mPhase[var22] > 0.0 && this.mQuadAmp[var22] < 0.0) {
            this.mPhase[var22] = this.mPhase[var22] - 180.0;
         }

         var1.drawLine(80 + (var22 - 1), (int)(130.0 - var5 / 2.0), 80 + var22, (int)(130.0 - this.mPhase[var22] / 2.0));
         var5 = this.mPhase[var22];
         this.mPhase[var22] = this.mPhase[var22] * Math.PI / 180.0;
      }

      var1.drawLine(560, 127, 560, 343);

      for (int var23 = 0; var23 < 9; var23++) {
         var1.drawLine(560, 130 + (int)(var23 * 22.5), 563, 130 + (int)(var23 * 22.5));
      }
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mm1 = var3;
            break;
         case 2:
            this.mk1 = var3;
            break;
         case 3:
            this.mc1 = var3;
            break;
         case 4:
            this.mm2 = var3;
            break;
         case 5:
            this.mk2 = var3;
            break;
         case 6:
            this.mc2 = var3;
      }

      if (var5) {
         this.repaint();
      }
   }
}

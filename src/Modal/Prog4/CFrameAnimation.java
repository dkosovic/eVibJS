package Modal.Prog4;

import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kk1Code = 1;
   public static final int km1Code = 2;
   public static final int kc1Code = 3;
   public static final int kk2Code = 4;
   public static final int km2Code = 5;
   public static final int kc2Code = 6;
   public static final double kStartk1 = 10.0;
   public static final double kStartm1 = 1.0;
   public static final double kStartc1 = 0.4;
   public static final double kStartk2 = 10.0;
   public static final double kStartm2 = 1.0;
   public static final double kStartc2 = 0.08;
   public static final int kXo = 60;
   double[] mAmp;
   double[] mRealAmp;
   double[] mQuadAmp;
   double[] mPhase;
   double mm1;
   double mk1 = 10.0;
   double mc1;
   double mm2;
   double mk2;
   double mc2;
   double mW;
   double mWmin;
   double mWmax;
   double A;
   double B;
   double C;
   int mxpower;
   int mypower;
   double mxscale;
   double myscale;
   Matrix M;
   Matrix K;
   Matrix F;
   Matrix H;
   Matrix J;
   Matrix D;
   double[] lambda_real;
   double[] lambda_imag;
   double[] lambda;
   double[] u;
   double[] u1;
   double[] u2;
   double store;
   double wn1;
   double wn2;
   double Xi1;
   double Xi2;
   double m1;
   double m2;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mm1 = 1.0;
      this.mc1 = 0.4;
      this.mk2 = 10.0;
      this.mm2 = 1.0;
      this.mc2 = 0.08;
      this.mxscale = 480.0;
      this.myscale = 45.0;
   }

   public void Frame(Graphics g) {
      this.mAmp = new double[602];
      this.mRealAmp = new double[602];
      this.mQuadAmp = new double[602];
      this.mPhase = new double[602];
      g.setPaintMode();
      this.u1 = new double[2];
      this.u2 = new double[2];
      Color var21 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      double[][] var22 = new double[2][2];
      var22[0][0] = this.mm1;
      var22[0][1] = 0.0;
      var22[1][0] = 0.0;
      var22[1][1] = this.mm2;
      this.M = new Matrix(var22);
      double[][] var23 = new double[2][2];
      var23[0][0] = this.mk1 + this.mk2;
      var23[0][1] = -this.mk2;
      var23[1][0] = -this.mk2;
      var23[1][1] = this.mk2;
      this.K = new Matrix(var23);
      double[][] var24 = new double[2][2];
      var24[0][0] = this.mc1 + this.mc2;
      var24[0][1] = -this.mc2;
      var24[1][0] = -this.mc2;
      var24[1][1] = this.mc2;
      this.F = new Matrix(var24);
      Matrix var25 = this.M.inverse();
      this.H = var25.times(this.K);
      this.J = var25.times(this.F);
      double[][] var26 = new double[4][4];
      var26[0][0] = 0.0;
      var26[0][1] = 0.0;
      var26[0][2] = -1.0;
      var26[0][3] = 0.0;
      var26[1][0] = 0.0;
      var26[1][1] = 0.0;
      var26[1][2] = 0.0;
      var26[1][3] = -1.0;
      var26[2][0] = this.H.get(0, 0);
      var26[2][1] = this.H.get(0, 1);
      var26[2][2] = this.J.get(0, 0);
      var26[2][3] = this.J.get(0, 1);
      var26[3][0] = this.H.get(1, 0);
      var26[3][1] = this.H.get(1, 1);
      var26[3][2] = this.J.get(1, 0);
      var26[3][3] = this.J.get(1, 1);
      this.D = new Matrix(var26);
      EigenvalueDecomposition var27 = new EigenvalueDecomposition(this.D);
      this.lambda_real = var27.getRealEigenvalues();
      this.lambda_imag = var27.getImagEigenvalues();
      if (this.lambda_real[0] > this.lambda_real[2]) {
         this.store = this.lambda_real[0];
         this.lambda_real[0] = this.lambda_real[2];
         this.lambda_real[2] = this.store;
         this.store = this.lambda_real[1];
         this.lambda_real[1] = this.lambda_real[3];
         this.lambda_real[3] = this.store;
         this.store = this.lambda_imag[0];
         this.lambda_imag[0] = this.lambda_imag[2];
         this.lambda_imag[2] = this.store;
         this.store = this.lambda_imag[1];
         this.lambda_imag[1] = this.lambda_imag[3];
         this.lambda_imag[3] = this.store;
      }

      this.store = this.lambda_imag[0] / this.lambda_real[0];
      this.Xi1 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn1 = this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
      this.store = this.lambda_imag[2] / this.lambda_real[2];
      this.Xi2 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn2 = this.lambda_imag[2] / Math.sqrt(1.0 - this.Xi2 * this.Xi2);
      this.Eigenvalues(this.M, this.K);

      for (int i = 0; i < 2; i++) {
         this.Eigenvector(this.M, this.K, this.lambda[i]);

         for (int j = 0; j < 2; j++) {
            if (i == 0) {
               this.u1[j] = this.u[j];
            } else {
               this.u2[j] = this.u[j];
            }
         }
      }

      this.m1 = this.mm1 * this.u1[0] * this.u1[0] + this.mm2 * this.u1[1] * this.u1[1];
      this.m2 = this.mm1 * this.u2[0] * this.u2[0] + this.mm2 * this.u2[1] * this.u2[1];
      g.setColor(Color.black);
      g.drawLine(57, 340, 543, 340);

      for (int k = 1; k < 9; k++) {
         g.drawLine(60 + k * 60, 340, 60 + k * 60, 343);
      }

      g.setColor(var21);
      g.drawLine(60, 47, 60, 343);

      for (int var29 = 0; var29 < 7; var29++) {
         g.drawLine(60, 50 + var29 * 45, 57, 50 + var29 * 45);
      }

      g.setColor(Color.black);
      this.mAmp[0] = 1.0 / this.mk1;
      double var7 = this.mAmp[0];

      for (int var30 = 1; var30 < 481; var30++) {
         double var11 = (Math.PI * 2) * var30 / this.mxscale;
         double var19 = this.mk2 * this.mk2 + var11 * var11 * this.mc2 * this.mc2;
         double var13 = this.mk2 / var19 - 1.0 / (this.mm2 * var11 * var11);
         double var15 = -var11 * this.mc2 / var19;
         double var17 = this.mk1 - this.mm1 * var11 * var11 + var13 / (var13 * var13 + var15 * var15);
         var19 = var11 * this.mc1 - var15 / (var13 * var13 + var15 * var15);
         this.mRealAmp[var30] = var17 / (var17 * var17 + var19 * var19);
         this.mQuadAmp[var30] = -var19 / (var17 * var17 + var19 * var19);
         this.mAmp[var30] = Math.sqrt(this.mRealAmp[var30] * this.mRealAmp[var30] + this.mQuadAmp[var30] * this.mQuadAmp[var30]);
         if (var30 == 1) {
            var7 = this.mAmp[var30];
         } else {
            g.drawLine(
               60 + (var30 - 1),
               (int)(140.0 - Math.log(var7) / Math.log(10.0) * this.myscale),
               60 + var30,
               (int)(140.0 - Math.log(this.mAmp[var30]) / Math.log(10.0) * this.myscale)
            );
            var7 = this.mAmp[var30];
         }
      }

      Color var28 = new Color(0.77F, 0.38F, 0.0F);
      g.setColor(var28);
      this.mPhase[0] = 0.0;
      double var9 = this.mPhase[0];

      for (int var31 = 1; var31 < 481; var31++) {
         this.mPhase[var31] = 180.0 * Math.atan(this.mQuadAmp[var31] / this.mRealAmp[var31]) / Math.PI;
         if (this.mPhase[var31] >= 0.0) {
            this.mPhase[var31] = this.mPhase[var31] - 180.0;
         }

         g.drawLine(60 + (var31 - 1), (int)(130.0 - var9 / 2.0), 60 + var31, (int)(130.0 - this.mPhase[var31] / 2.0));
         var9 = this.mPhase[var31];
         this.mPhase[var31] = this.mPhase[var31] * Math.PI / 180.0;
      }

      g.drawLine(540, 127, 540, 343);

      for (int var32 = 0; var32 < 9; var32++) {
         g.drawLine(540, 130 + (int)(var32 * 22.5), 543, 130 + (int)(var32 * 22.5));
      }

      g.setColor(Color.red);

      for (int var33 = 2; var33 < 481; var33 += 4) {
         double var41 = (Math.PI * 2) * var33 / this.mxscale;
         double var42 = this.wn1 * this.wn1 - var41 * var41;
         double var43 = 2.0 * this.Xi1 * this.wn1 * var41;
         double var44 = this.wn2 * this.wn2 - var41 * var41;
         double var46 = 2.0 * this.Xi2 * this.wn2 * var41;
         this.mRealAmp[var33] = var42 / (var42 * var42 + var43 * var43) * this.u1[0] * this.u1[0] / this.m1
            + var44 / (var44 * var44 + var46 * var46) * this.u2[0] * this.u2[0] / this.m2;
         this.mQuadAmp[var33] = -var43 / (var42 * var42 + var43 * var43) * this.u1[0] * this.u1[0] / this.m1
            - var46 / (var44 * var44 + var46 * var46) * this.u2[0] * this.u2[0] / this.m2;
         this.mAmp[var33] = Math.sqrt(this.mRealAmp[var33] * this.mRealAmp[var33] + this.mQuadAmp[var33] * this.mQuadAmp[var33]);
         g.drawLine(
            60 + (var33 - 1),
            (int)(141.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale),
            60 + var33 + 1,
            (int)(139.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)
         );
         g.drawLine(
            60 + (var33 - 1),
            (int)(139.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale),
            60 + var33 + 1,
            (int)(141.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)
         );
      }

      g.setColor(Color.blue);

      for (int var34 = 2; var34 < 481; var34 += 4) {
         this.mPhase[var34] = 180.0 * Math.atan(this.mQuadAmp[var34] / this.mRealAmp[var34]) / Math.PI;
         if (this.mPhase[var34] >= 0.0) {
            this.mPhase[var34] = this.mPhase[var34] - 180.0;
         }

         g.drawLine(60 + (var34 - 1), (int)(131.0 - this.mPhase[var34] / 2.0), 60 + var34 + 1, (int)(129.0 - this.mPhase[var34] / 2.0));
         g.drawLine(60 + (var34 - 1), (int)(129.0 - this.mPhase[var34] / 2.0), 60 + var34 + 1, (int)(131.0 - this.mPhase[var34] / 2.0));
      }
   }

   public void Eigenvalues(Matrix var1, Matrix var2) {
      int var3 = var2.getRowDimension();
      Matrix var8 = var1.inverse();
      this.D = var8.times(var2);
      EigenvalueDecomposition var9 = new EigenvalueDecomposition(this.D);
      this.lambda = var9.getRealEigenvalues();

      for (int i = 0; i < var3 - 1; i++) {
         for (int j = 1; j < var3; j++) {
            if (this.lambda[j] < this.lambda[j - 1]) {
               double var6 = this.lambda[j - 1];
               this.lambda[j - 1] = this.lambda[j];
               this.lambda[j] = var6;
            }
         }
      }
   }

   public void Eigenvector(Matrix var1, Matrix var2, double var3) {
      int var5 = var2.getRowDimension();
      double[][] var8 = new double[var5 - 1][var5 - 1];
      double[][] var9 = new double[var5 - 1][1];
      this.u = new double[var5];
      this.u[var5 - 1] = 1.0;
      Matrix var10 = var1.times(var3);
      Matrix var11 = var2.minus(var10);

      for (int i = 0; i < var5 - 1; i++) {
         for (int j = 0; j < var5 - 1; j++) {
            var8[i][j] = var11.get(i, j);
         }
      }

      Matrix var12 = new Matrix(var8);

      for (int k = 0; k < var5 - 1; k++) {
         var9[k][0] = -var11.get(k, var5 - 1);
      }

      Matrix var13 = new Matrix(var9);
      Matrix var14 = var12.solve(var13);

      for (int var16 = 0; var16 < var5 - 1; var16++) {
         this.u[var16] = var14.get(var16, 0);
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 1:
            this.mk1 = val;
            break;
         case 2:
            this.mm1 = val;
            break;
         case 3:
            this.mc1 = val;
            break;
         case 4:
            this.mk2 = val;
            break;
         case 5:
            this.mm2 = val;
            break;
         case 6:
            this.mc2 = val;
      }

      if (var5) {
         this.repaint();
      }
   }
}

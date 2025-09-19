import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kk1Code = 1;
   public static final int km1Code = 2;
   public static final int kc1Code = 3;
   public static final int kk2Code = 4;
   public static final int km2Code = 5;
   public static final int kc2Code = 6;
   public static final int kx10Code = 7;
   public static final int kv10Code = 8;
   public static final int kx20Code = 9;
   public static final int kv20Code = 10;
   public static final double kStartk1 = 10.0;
   public static final double kStartm1 = 1.0;
   public static final double kStartc1 = 0.4;
   public static final double kStartk2 = 10.0;
   public static final double kStartm2 = 1.0;
   public static final double kStartc2 = 0.08;
   public static final double kStartx10 = 1.0;
   public static final double kStartv10 = 10.0;
   public static final double kStartx20 = 0.0;
   public static final double kStartv20 = 0.0;
   public static final int kXo = 30;
   double[] mx11;
   double[] mx12;
   double[] mx21;
   double[] mx22;
   double[] mx_exact1;
   double[] mx_exact2;
   double mm1;
   double mk1 = 10.0;
   double mc1;
   double mm2;
   double mk2;
   double mc2;
   double mx10;
   double mv10;
   double mx20;
   double mv20;
   double A;
   double B;
   double C;
   double mAmp1;
   double mt;
   double mdt;
   double mxscale;
   double myscale;
   double mXi1w1;
   double mXi2w2;
   double mwd1;
   double mwd2;
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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mm1 = 1.0;
      this.mc1 = 0.4;
      this.mk2 = 10.0;
      this.mm2 = 1.0;
      this.mc2 = 0.08;
      this.mx10 = 1.0;
      this.mv10 = 10.0;
      this.mx20 = 0.0;
      this.mv20 = 0.0;
      this.mdt = 0.2;
      this.mxscale = 480.0;
      this.myscale = 10.0;
   }

   public void Frame(Graphics var1) {
      this.mx11 = new double[500];
      this.mx12 = new double[500];
      this.mx21 = new double[500];
      this.mx22 = new double[500];
      this.mx_exact1 = new double[500];
      this.mx_exact2 = new double[500];
      var1.setPaintMode();
      this.u1 = new double[2];
      this.u2 = new double[2];
      new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      double[][] var16 = new double[2][2];
      var16[0][0] = this.mm1;
      var16[0][1] = 0.0;
      var16[1][0] = 0.0;
      var16[1][1] = this.mm2;
      this.M = new Matrix(var16);
      double[][] var17 = new double[2][2];
      var17[0][0] = this.mk1 + this.mk2;
      var17[0][1] = -this.mk2;
      var17[1][0] = -this.mk2;
      var17[1][1] = this.mk2;
      this.K = new Matrix(var17);
      double[][] var18 = new double[2][2];
      var18[0][0] = this.mc1 + this.mc2;
      var18[0][1] = -this.mc2;
      var18[1][0] = -this.mc2;
      var18[1][1] = this.mc2;
      this.F = new Matrix(var18);
      Matrix var19 = this.M.inverse();
      this.H = var19.times(this.K);
      this.J = var19.times(this.F);
      double[][] var20 = new double[4][4];
      var20[0][0] = 0.0;
      var20[0][1] = 0.0;
      var20[0][2] = -1.0;
      var20[0][3] = 0.0;
      var20[1][0] = 0.0;
      var20[1][1] = 0.0;
      var20[1][2] = 0.0;
      var20[1][3] = -1.0;
      var20[2][0] = this.H.get(0, 0);
      var20[2][1] = this.H.get(0, 1);
      var20[2][2] = this.J.get(0, 0);
      var20[2][3] = this.J.get(0, 1);
      var20[3][0] = this.H.get(1, 0);
      var20[3][1] = this.H.get(1, 1);
      var20[3][2] = this.J.get(1, 0);
      var20[3][3] = this.J.get(1, 1);
      this.D = new Matrix(var20);
      EigenvalueDecomposition var21 = new EigenvalueDecomposition(this.D);
      this.lambda_real = var21.getRealEigenvalues();
      this.lambda_imag = var21.getImagEigenvalues();
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

      this.mXi1w1 = this.lambda_real[0];
      this.mwd1 = this.lambda_imag[0];
      this.store = this.lambda_imag[0] / this.lambda_real[0];
      this.Xi1 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn1 = this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
      this.mXi2w2 = this.lambda_real[2];
      this.mwd2 = this.lambda_imag[2];
      this.store = this.lambda_imag[2] / this.lambda_real[2];
      this.Xi2 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn2 = this.lambda_imag[2] / Math.sqrt(1.0 - this.Xi2 * this.Xi2);
      this.Eigenvalues(this.M, this.K);

      for (int var3 = 0; var3 < 2; var3++) {
         this.Eigenvector(this.M, this.K, this.lambda[var3]);

         for (int var4 = 0; var4 < 2; var4++) {
            if (var3 == 0) {
               this.u1[var4] = this.u[var4];
            } else {
               this.u2[var4] = this.u[var4];
            }
         }
      }

      this.m1 = this.mm1 * this.u1[0] * this.u1[0] + this.mm2 * this.u1[1] * this.u1[1];
      this.m2 = this.mm1 * this.u2[0] * this.u2[0] + this.mm2 * this.u2[1] * this.u2[1];
      var1.setColor(Color.black);

      for (int var47 = 1; var47 < 5; var47++) {
         var1.drawLine(27, 100 * var47, 513, 100 * var47);

         for (int var2 = 1; var2 < 10; var2++) {
            var1.drawLine(30 + var2 * 50, 100 * var47 - 2, 30 + var2 * 50, 100 * var47 + 2);
         }

         var1.drawLine(30, 100 * var47 - 42, 30, 100 * var47 + 42);

         for (int var38 = 1; var38 < 10; var38++) {
            var1.drawLine(30, 100 * var47 - 10 * (var38 - 5), 27, 100 * var47 - 10 * (var38 - 5));
         }
      }

      var1.drawLine(27, 480, 513, 480);

      for (int var39 = 0; var39 < 10; var39++) {
         var1.drawLine(30 + var39 * 50, 478, 30 + var39 * 50, 482);
      }

      double var22 = (this.mm1 * this.u1[0] * this.mx10 + this.mm2 * this.u1[1] * this.mx20) / this.m1;
      double var24 = (this.mm1 * this.u1[0] * this.mv10 + this.mm2 * this.u1[1] * this.mv20) / this.m1;
      double var26 = (this.mm1 * this.u2[0] * this.mx10 + this.mm2 * this.u2[1] * this.mx20) / this.m2;
      double var28 = (this.mm1 * this.u2[0] * this.mv10 + this.mm2 * this.u2[1] * this.mv20) / this.m2;
      double var30 = Math.sqrt(var22 * var22 + (var24 + this.mXi1w1 * var22) * (var24 + this.mXi1w1 * var22) / this.mwd1 / this.mwd1);
      double var32 = Math.atan2(var24 + this.mXi1w1 * var22, this.mwd1 * var22);
      double var34 = Math.sqrt(var26 * var26 + (var28 + this.mXi2w2 * var26) * (var28 + this.mXi2w2 * var26) / this.mwd2 / this.mwd2);
      double var36 = Math.atan2(var28 + this.mXi2w2 * var26, this.mwd2 * var26);
      var1.setColor(Color.blue);

      for (int var40 = 0; var40 < 481; var40++) {
         this.mt = var40 * this.mdt;
         this.mx11[var40] = var30 * Math.cos(this.mwd1 * this.mt - var32) * this.u1[0] * Math.exp(-this.mXi1w1 * this.mt);
         if (var40 == 0) {
            this.mAmp1 = this.mx11[var40];
         } else {
            var1.drawLine(30 + (var40 - 1), (int)(100.0 - this.mx11[var40 - 1] * this.myscale), 30 + var40, (int)(100.0 - this.mx11[var40] * this.myscale));
         }
      }

      var1.setColor(Color.green);

      for (int var41 = 0; var41 < 481; var41++) {
         this.mt = var41 * this.mdt;
         this.mx12[var41] = var34 * Math.cos(this.mwd2 * this.mt - var36) * this.u2[0] * Math.exp(-this.mXi2w2 * this.mt);
         if (var41 == 0) {
            this.mAmp1 = this.mx12[var41];
         } else {
            var1.drawLine(30 + (var41 - 1), (int)(200.0 - this.mx12[var41 - 1] * this.myscale), 30 + var41, (int)(200.0 - this.mx12[var41] * this.myscale));
         }
      }

      var1.setColor(Color.red);

      for (byte var42 = 2; var42 < 481; var42 += 2) {
         var1.drawLine(
            30 + (var42 - 1),
            (int)(301.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale),
            30 + var42 + 1,
            (int)(299.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)
         );
         var1.drawLine(
            30 + (var42 - 1),
            (int)(299.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale),
            30 + var42 + 1,
            (int)(301.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)
         );
      }

      var1.setColor(Color.orange);

      for (int var43 = 0; var43 < 481; var43++) {
         this.mt = var43 * this.mdt;
         this.mx21[var43] = var30 * Math.cos(this.mwd1 * this.mt - var32) * this.u1[1] * Math.exp(-this.mXi1w1 * this.mt);
      }

      var1.setColor(Color.green);

      for (int var44 = 0; var44 < 481; var44++) {
         this.mt = var44 * this.mdt;
         this.mx22[var44] = var34 * Math.cos(this.mwd2 * this.mt - var36) * this.u2[1] * Math.exp(-this.mXi2w2 * this.mt);
      }

      var1.setColor(Color.red);

      for (byte var45 = 0; var45 < 481; var45 += 2) {
         var1.drawLine(
            30 + (var45 - 1),
            (int)(401.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale),
            30 + var45 + 1,
            (int)(399.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)
         );
         var1.drawLine(
            30 + (var45 - 1),
            (int)(399.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale),
            30 + var45 + 1,
            (int)(401.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)
         );
      }

      var1.setColor(Color.black);
      this.Response();

      for (int var46 = 0; var46 < 481; var46++) {
         if (var46 == 0) {
            this.mAmp1 = 0.0;
         } else {
            var1.drawLine(
               30 + (var46 - 1), (int)(300.0 - this.mx_exact1[var46 - 1] * this.myscale), 30 + var46, (int)(300.0 - this.mx_exact1[var46] * this.myscale)
            );
         }

         if (var46 == 0) {
            this.mAmp1 = 0.0;
         } else {
            var1.drawLine(
               30 + (var46 - 1), (int)(400.0 - this.mx_exact2[var46 - 1] * this.myscale), 30 + var46, (int)(400.0 - this.mx_exact2[var46] * this.myscale)
            );
         }
      }
   }

   public void Response() {
      double[] var4 = new double[500];
      double[] var5 = new double[500];
      double[] var6 = new double[500];
      double[] var7 = new double[500];
      double[] var8 = new double[500];
      double[] var9 = new double[500];
      double[] var10 = new double[500];
      double[] var11 = new double[500];
      var6[0] = this.mx10;
      var7[0] = this.mv10;
      this.mx_exact1[0] = var6[0];
      var9[0] = this.mx20;
      var10[0] = this.mv20;
      this.mx_exact2[0] = var9[0];

      for (int var1 = 0; var1 < 481; var1++) {
         var8[var1] = (-this.mk1 * var6[var1] - this.mc1 * var7[var1] + this.mk2 * (var9[var1] - var6[var1]) + this.mc2 * (var10[var1] - var7[var1]))
            / this.mm1;
         var11[var1] = (-this.mk2 * (var9[var1] - var6[var1]) - this.mc2 * (var10[var1] - var7[var1])) / this.mm2;
         var6[var1 + 1] = var6[var1] + var7[var1] * this.mdt / 2.0;
         var9[var1 + 1] = var9[var1] + var10[var1] * this.mdt / 2.0;
         var7[var1 + 1] = var7[var1] + var8[var1] * this.mdt / 2.0;
         var10[var1 + 1] = var10[var1] + var11[var1] * this.mdt / 2.0;
         var8[var1 + 1] = (
               -this.mk1 * var6[var1 + 1]
                  - this.mc1 * var7[var1 + 1]
                  + this.mk2 * (var9[var1 + 1] - var6[var1 + 1])
                  + this.mc2 * (var10[var1 + 1] - var7[var1 + 1])
            )
            / this.mm1;
         var11[var1 + 1] = (-this.mk2 * (var9[var1 + 1] - var6[var1 + 1]) - this.mc2 * (var10[var1 + 1] - var7[var1 + 1])) / this.mm2;
         var6[var1 + 2] = var6[var1] + var7[var1 + 1] * this.mdt / 2.0;
         var9[var1 + 2] = var9[var1] + var10[var1 + 1] * this.mdt / 2.0;
         var7[var1 + 2] = var7[var1] + var8[var1 + 1] * this.mdt / 2.0;
         var10[var1 + 2] = var10[var1] + var11[var1 + 1] * this.mdt / 2.0;
         var8[var1 + 2] = (
               -this.mk1 * var6[var1 + 2]
                  - this.mc1 * var7[var1 + 2]
                  + this.mk2 * (var9[var1 + 2] - var6[var1 + 2])
                  + this.mc2 * (var10[var1 + 2] - var7[var1 + 2])
            )
            / this.mm1;
         var11[var1 + 2] = (-this.mk2 * (var9[var1 + 2] - var6[var1 + 2]) - this.mc2 * (var10[var1 + 2] - var7[var1 + 2])) / this.mm2;
         var6[var1 + 3] = var6[var1] + var7[var1 + 2] * this.mdt;
         var9[var1 + 3] = var9[var1] + var10[var1 + 2] * this.mdt;
         var7[var1 + 3] = var7[var1] + var8[var1 + 2] * this.mdt;
         var10[var1 + 3] = var10[var1] + var11[var1 + 2] * this.mdt;
         var8[var1 + 3] = (
               -this.mk1 * var6[var1 + 3]
                  - this.mc1 * var7[var1 + 3]
                  + this.mk2 * (var9[var1 + 3] - var6[var1 + 3])
                  + this.mc2 * (var10[var1 + 3] - var7[var1 + 3])
            )
            / this.mm1;
         var11[var1 + 3] = (-this.mk2 * (var9[var1 + 3] - var6[var1 + 3]) - this.mc2 * (var10[var1 + 3] - var7[var1 + 3])) / this.mm2;
         var6[var1 + 1] = var6[var1] + (var7[var1] + 2.0 * var7[var1 + 1] + 2.0 * var7[var1 + 2] + var7[var1 + 3]) * this.mdt / 6.0;
         var9[var1 + 1] = var9[var1] + (var10[var1] + 2.0 * var10[var1 + 1] + 2.0 * var10[var1 + 2] + var10[var1 + 3]) * this.mdt / 6.0;
         var7[var1 + 1] = var7[var1] + (var8[var1] + 2.0 * var8[var1 + 1] + 2.0 * var8[var1 + 2] + var8[var1 + 3]) * this.mdt / 6.0;
         var10[var1 + 1] = var10[var1] + (var11[var1] + 2.0 * var11[var1 + 1] + 2.0 * var11[var1 + 2] + var11[var1 + 3]) * this.mdt / 6.0;
         var4[var1 + 1] = var6[var1 + 1];
         var5[var1 + 1] = var9[var1 + 1];
         this.mx_exact1[var1 + 1] = var4[var1 + 1];
         this.mx_exact2[var1 + 1] = var5[var1 + 1];
      }
   }

   public void Eigenvalues(Matrix var1, Matrix var2) {
      int var3 = var2.getRowDimension();
      Matrix var8 = var1.inverse();
      this.D = var8.times(var2);
      EigenvalueDecomposition var9 = new EigenvalueDecomposition(this.D);
      this.lambda = var9.getRealEigenvalues();

      for (int var5 = 0; var5 < var3 - 1; var5++) {
         for (int var4 = 1; var4 < var3; var4++) {
            if (this.lambda[var4] < this.lambda[var4 - 1]) {
               double var6 = this.lambda[var4 - 1];
               this.lambda[var4 - 1] = this.lambda[var4];
               this.lambda[var4] = var6;
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

      for (int var6 = 0; var6 < var5 - 1; var6++) {
         for (int var7 = 0; var7 < var5 - 1; var7++) {
            var8[var6][var7] = var11.get(var6, var7);
         }
      }

      Matrix var12 = new Matrix(var8);

      for (int var15 = 0; var15 < var5 - 1; var15++) {
         var9[var15][0] = -var11.get(var15, var5 - 1);
      }

      Matrix var13 = new Matrix(var9);
      Matrix var14 = var12.solve(var13);

      for (int var16 = 0; var16 < var5 - 1; var16++) {
         this.u[var16] = var14.get(var16, 0);
      }
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mk1 = var3;
            break;
         case 2:
            this.mm1 = var3;
            break;
         case 3:
            this.mc1 = var3;
            break;
         case 4:
            this.mk2 = var3;
            break;
         case 5:
            this.mm2 = var3;
            break;
         case 6:
            this.mc2 = var3;
            break;
         case 7:
            this.mx10 = var3;
            break;
         case 8:
            this.mv10 = var3;
            break;
         case 9:
            this.mx20 = var3;
            break;
         case 10:
            this.mv20 = var3;
      }

      if (var5) {
         this.repaint();
      }
   }
}

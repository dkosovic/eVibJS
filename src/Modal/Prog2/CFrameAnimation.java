package Modal.Prog2.Eigen2DOF;

import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int km1Code = 1;
   public static final int km2Code = 2;
   public static final int kk1Code = 3;
   public static final double kStartk1 = 1.0;
   public static final double kStartm1 = 1.0;
   public static final double kStartm2 = 1.0;
   public static final int kXo = 60;
   double[] mAmp;
   double[] mRealAmp;
   double mm1;
   double mk1 = 1.0;
   double mm2;
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
   Matrix D;
   double[] lambda;
   double[] u;
   double[] u1;
   double[] u2;
   double store;
   double wn1;
   double wn2;
   double m1;
   double m2;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mm1 = 1.0;
      this.mm2 = 1.0;
      this.mxscale = 480.0;
      this.myscale = 45.0;
   }

   public void Frame(Graphics g) {
      this.mAmp = new double[602];
      g.setPaintMode();
      this.u1 = new double[2];
      this.u2 = new double[2];
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      double[][] var21 = new double[2][2];
      var21[0][0] = this.mm1;
      var21[0][1] = 0.0;
      var21[1][0] = 0.0;
      var21[1][1] = this.mm2;
      this.M = new Matrix(var21);
      double[][] var22 = new double[2][2];
      var22[0][0] = 2.0 * this.mk1;
      var22[0][1] = -this.mk1;
      var22[1][0] = -this.mk1;
      var22[1][1] = 2.0 * this.mk1;
      this.K = new Matrix(var22);
      this.Eigenvalues(this.M, this.K);
      this.wn1 = Math.sqrt(this.lambda[0]);
      this.wn2 = Math.sqrt(this.lambda[1]);

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
      g.drawLine(57, 360, 543, 360);

      for (int k = 1; k < 7; k++) {
         g.drawLine(60 + k * 76, 360, 60 + k * 76, 363);
      }

      g.drawLine(60, 67, 60, 363);

      for (int var23 = 0; var23 < 7; var23++) {
         g.drawLine(60, 70 + var23 * 45, 57, 70 + var23 * 45);
      }

      g.setColor(Color.red);

      for (int var24 = 2; var24 < 481; var24++) {
         double var11 = (Math.PI * 2) * var24 / this.mxscale;
         double var13 = this.wn1 * this.wn1 - var11 * var11;
         double var17 = this.wn2 * this.wn2 - var11 * var11;
         this.mAmp[var24] = this.u1[0] * this.u1[0] / (this.m1 * var13) + this.u2[0] * this.u2[0] / (this.m2 * var17);
         this.mAmp[var24] = Math.abs(this.mAmp[var24]);
         g.drawLine(
            60 + (var24 - 1),
            (int)(160.0 - Math.log(this.mAmp[var24 - 1]) / Math.log(10.0) * this.myscale),
            60 + var24,
            (int)(160.0 - Math.log(this.mAmp[var24]) / Math.log(10.0) * this.myscale)
         );
      }

      g.setColor(Color.blue);

      for (int var25 = 2; var25 < 481; var25++) {
         double var26 = (Math.PI * 2) * var25 / this.mxscale;
         double var27 = this.wn1 * this.wn1 - var26 * var26;
         double var28 = this.wn2 * this.wn2 - var26 * var26;
         this.mAmp[var25] = this.u1[0] * this.u1[1] / (this.m1 * var27) + this.u2[0] * this.u2[1] / (this.m2 * var28);
         this.mAmp[var25] = Math.abs(this.mAmp[var25]);
         g.drawLine(
            60 + (var25 - 1),
            (int)(160.0 - Math.log(this.mAmp[var25 - 1]) / Math.log(10.0) * this.myscale),
            60 + var25,
            (int)(160.0 - Math.log(this.mAmp[var25]) / Math.log(10.0) * this.myscale)
         );
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
            this.mm1 = val;
            break;
         case 2:
            this.mm2 = val;
            break;
         case 3:
            this.mk1 = val;
      }

      if (var5) {
         this.repaint();
      }
   }
}

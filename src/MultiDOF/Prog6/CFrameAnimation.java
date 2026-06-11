package MultiDOF.Prog6;

import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kk1Code = 1;
   public static final int km1Code = 2;
   public static final int kk2Code = 3;
   public static final int km2Code = 4;
   public static final int kk3Code = 5;
   public static final int km3Code = 6;
   public static final int kk4Code = 7;
   public static final int km4Code = 8;
   public static final int kk5Code = 9;
   public static final int km5Code = 10;
   public static final double kStartk1 = 1.2;
   public static final double kStartm1 = 1.9;
   public static final double kStartk2 = 1.3;
   public static final double kStartm2 = 1.8;
   public static final double kStartk3 = 1.4;
   public static final double kStartm3 = 1.7;
   public static final double kStartk4 = 1.5;
   public static final double kStartm4 = 1.6;
   public static final double kStartk5 = 1.6;
   public static final double kStartm5 = 1.5;
   public static final int kYo = 130;
   double mk1 = 1.2;
   double mm1 = 1.9;
   double mk2 = 1.3;
   double mm2 = 1.8;
   double mk3 = 1.4;
   double mm3 = 1.7;
   double mk4 = 1.5;
   double mm4 = 1.6;
   double mk5 = 1.6;
   double mm5 = 1.5;
   Matrix M;
   Matrix K;
   Matrix D;
   double[] lambda;
   double[] u;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      Color var14 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      double[][] var15 = new double[5][5];

      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            var15[i][j] = 0.0;
         }
      }

      var15[0][0] = this.mm1;
      var15[1][1] = this.mm2;
      var15[2][2] = this.mm3;
      var15[3][3] = this.mm4;
      var15[4][4] = this.mm5;
      this.M = new Matrix(var15);
      g.drawLine(43, 130, 43, 220);
      g.drawLine(44, 130, 44, 220);

      for (int k = 0; k < 5; k++) {
         for (int var23 = 0; var23 < 5; var23++) {
            g.drawString(CUtility.nns(this.M.get(k, var23)), 50 + 42 * var23, 139 + 20 * k);
         }
      }

      g.drawLine(255, 130, 255, 220);
      g.drawLine(256, 130, 256, 220);
      double[][] var16 = new double[5][5];

      for (int var18 = 0; var18 < 5; var18++) {
         for (int var24 = 0; var24 < 5; var24++) {
            var16[var18][var24] = 0.0;
         }
      }

      var16[0][0] = this.mk1 + this.mk2;
      var16[1][1] = this.mk2 + this.mk3;
      var16[2][2] = this.mk3 + this.mk4;
      var16[3][3] = this.mk4 + this.mk5;
      var16[4][4] = this.mk5;
      var16[0][1] = -this.mk2;
      var16[1][0] = -this.mk2;
      var16[1][2] = -this.mk3;
      var16[2][1] = -this.mk3;
      var16[2][3] = -this.mk4;
      var16[3][2] = -this.mk4;
      var16[3][4] = -this.mk5;
      var16[4][3] = -this.mk5;
      this.K = new Matrix(var16);
      g.drawLine(350, 130, 350, 220);
      g.drawLine(351, 130, 351, 220);

      for (int var19 = 0; var19 < 5; var19++) {
         for (int var25 = 0; var25 < 5; var25++) {
            g.drawString(CUtility.nns(this.K.get(var19, var25)), 360 + 42 * var25, 139 + 20 * var19);
         }
      }

      g.drawLine(562, 130, 562, 220);
      g.drawLine(563, 130, 563, 220);
      this.Eigenvalues(this.M, this.K);

      for (int var20 = 0; var20 < 5; var20++) {
         g.drawString(CUtility.nns(this.lambda[var20]), 50 + var20 * 125, 255);
      }

      for (int var21 = 0; var21 < 5; var21++) {
         g.drawString(CUtility.nns(Math.sqrt(this.lambda[var21])) + " rad/s", 50 + var21 * 125, 280);
      }

      g.drawString("Eigen vectors", 13, 310);

      for (int var22 = 0; var22 < 5; var22++) {
         g.setColor(Color.orange);
         g.fillRect(75 + 125 * var22, 314, 30, 10);
         g.setColor(Color.black);
         g.drawLine(90 + 125 * var22, 324, 90 + 125 * var22, 449);
         this.Eigenvector(this.M, this.K, this.lambda[var22]);

         for (int var26 = 0; var26 < 5; var26++) {
            g.setColor(Color.black);
            g.drawString(CUtility.nns(this.u[var26]), 13 + 125 * var22, 355 + 25 * var26);
            g.setColor(var14);
            if (var26 == 0) {
               g.drawLine(90 + 125 * var22, 324, 90 + 125 * var22 - (int)(this.u[var26] * 30.0), 349 + 25 * var26);
               g.drawLine(90 + 125 * var22, 349 + 25 * var26, 90 + 125 * var22 - (int)(this.u[var26] * 30.0), 349 + 25 * var26);
            } else {
               g.drawLine(
                  90 + 125 * var22 - (int)(this.u[var26 - 1] * 30.0), 349 + 25 * (var26 - 1), 90 + 125 * var22 - (int)(this.u[var26] * 30.0), 349 + 25 * var26
               );
               g.drawLine(90 + 125 * var22, 349 + 25 * var26, 90 + 125 * var22 - (int)(this.u[var26] * 30.0), 349 + 25 * var26);
            }
         }
      }

      for (int var27 = 1; var27 < 5; var27++) {
         g.setColor(Color.black);
         g.drawLine(125 * var27, 240, 125 * var27, 460);
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
      double[][] var10 = new double[var5 - 1][var5 - 1];
      double[][] var11 = new double[var5 - 1][1];
      this.u = new double[var5];
      this.u[var5 - 1] = 1.0;
      Matrix var12 = var1.times(var3);
      Matrix var13 = var2.minus(var12);

      for (int i = 0; i < var5 - 1; i++) {
         for (int j = 0; j < var5 - 1; j++) {
            var10[i][j] = var13.get(i, j);
         }
      }

      Matrix var14 = new Matrix(var10);

      for (int k = 0; k < var5 - 1; k++) {
         var11[k][0] = -var13.get(k, var5 - 1);
      }

      Matrix var15 = new Matrix(var11);
      Matrix var16 = var14.solve(var15);

      for (int var18 = 0; var18 < var5 - 1; var18++) {
         this.u[var18] = var16.get(var18, 0);
      }

      double var8 = 0.0;

      for (int var19 = 0; var19 < var5; var19++) {
         if (Math.abs(this.u[var19]) > Math.abs(var8)) {
            var8 = this.u[var19];
         }
      }

      for (int var20 = 0; var20 < var5; var20++) {
         this.u[var20] = this.u[var20] / var8;
      }

      if (this.u[0] < 0.0) {
         for (int var21 = 0; var21 < var5; var21++) {
            this.u[var21] = -this.u[var21];
         }
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
            this.mk2 = val;
            break;
         case 4:
            this.mm2 = val;
            break;
         case 5:
            this.mk3 = val;
            break;
         case 6:
            this.mm3 = val;
            break;
         case 7:
            this.mk4 = val;
            break;
         case 8:
            this.mm4 = val;
            break;
         case 9:
            this.mk5 = val;
            break;
         case 10:
            this.mm5 = val;
      }

      if (var5) {
         this.repaint();
      }
   }
}

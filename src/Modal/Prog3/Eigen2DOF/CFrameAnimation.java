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
   public static final double kStartk1 = 1.0;
   public static final double kStartm1 = 1.0;
   public static final double kStartc1 = 0.08;
   public static final double kStartk2 = 1.0;
   public static final double kStartm2 = 1.0;
   public static final double kStartc2 = 0.08;
   public static final int kXo = 380;
   public static final int kYo = 330;
   double mk1 = 1.0;
   double mm1 = 1.0;
   double mc1 = 0.08;
   double mk2 = 1.0;
   double mm2 = 1.0;
   double mc2 = 0.08;
   Matrix M;
   Matrix K;
   Matrix C;
   Matrix H;
   Matrix J;
   Matrix D;
   double[] lambda_real;
   double[] lambda_imag;
   double[] lambda;
   double store;
   double wn1;
   double wn2;
   double Xi1;
   double Xi2;

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      var1.setPaintMode();
      new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      double[][] var17 = new double[2][2];
      var17[0][0] = this.mm1;
      var17[0][1] = 0.0;
      var17[1][0] = 0.0;
      var17[1][1] = this.mm2;
      this.M = new Matrix(var17);
      double[][] var18 = new double[2][2];
      var18[0][0] = this.mk1 + this.mk2;
      var18[0][1] = -this.mk2;
      var18[1][0] = -this.mk2;
      var18[1][1] = this.mk2;
      this.K = new Matrix(var18);
      double[][] var19 = new double[2][2];
      var19[0][0] = this.mc1 + this.mc2;
      var19[0][1] = -this.mc2;
      var19[1][0] = -this.mc2;
      var19[1][1] = this.mc2;
      this.C = new Matrix(var19);
      Matrix var20 = this.M.inverse();
      this.H = var20.times(this.K);
      this.J = var20.times(this.C);
      double[][] var21 = new double[4][4];
      var21[0][0] = 0.0;
      var21[0][1] = 0.0;
      var21[0][2] = -1.0;
      var21[0][3] = 0.0;
      var21[1][0] = 0.0;
      var21[1][1] = 0.0;
      var21[1][2] = 0.0;
      var21[1][3] = -1.0;
      var21[2][0] = this.H.get(0, 0);
      var21[2][1] = this.H.get(0, 1);
      var21[2][2] = this.J.get(0, 0);
      var21[2][3] = this.J.get(0, 1);
      var21[3][0] = this.H.get(1, 0);
      var21[3][1] = this.H.get(1, 1);
      var21[3][2] = this.J.get(1, 0);
      var21[3][3] = this.J.get(1, 1);
      this.D = new Matrix(var21);
      EigenvalueDecomposition var22 = new EigenvalueDecomposition(this.D);
      this.lambda_real = var22.getRealEigenvalues();
      this.lambda_imag = var22.getImagEigenvalues();
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

      short var4 = 40;
      short var5 = 25;
      var1.drawString(CUtility.nns(this.lambda_real[0]) + " + i" + CUtility.nns(this.lambda_imag[0]), var4, var5);
      var5 = (byte)55;
      var1.drawString(CUtility.nns(this.lambda_real[1]) + " - i" + CUtility.nns(Math.abs(this.lambda_imag[1])), var4, var5);
      var4 = 260;
      var5 = (byte)25;
      var1.drawString(CUtility.nns(this.lambda_real[2]) + " + i" + CUtility.nns(this.lambda_imag[2]), var4, var5);
      var5 = (byte)55;
      var1.drawString(CUtility.nns(this.lambda_real[2]) + " - i" + CUtility.nns(Math.abs(this.lambda_imag[2])), var4, var5);
      short var24 = 126;
      var5 = (byte)109;
      var1.drawString(CUtility.nns(this.lambda_imag[0]) + " rad/s", var24, var5);
      var24 = (byte)54;
      var5 = 140;
      var1.drawString(CUtility.nns(this.lambda_real[0]) + " rad/s", var24, var5);
      var24 = 346;
      short var37 = 109;
      var1.drawString(CUtility.nns(this.lambda_imag[2]) + " rad/s", var24, var37);
      var24 = 274;
      var37 = 140;
      var1.drawString(CUtility.nns(this.lambda_real[2]) + " rad/s", var24, var37);
      this.store = this.lambda_imag[0] / this.lambda_real[0];
      this.Xi1 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn1 = this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
      this.store = this.lambda_imag[2] / this.lambda_real[2];
      this.Xi2 = Math.sqrt(1.0 / (1.0 + this.store * this.store));
      this.wn2 = this.lambda_imag[2] / Math.sqrt(1.0 - this.Xi2 * this.Xi2);
      short var28 = 50;
      var37 = 189;
      var1.drawString(CUtility.nns(this.wn1) + " rad/s", var28, var37);
      var28 = (byte)34;
      var37 = 211;
      var1.drawString(CUtility.nns(this.Xi1), var28, var37);
      var28 = 270;
      var37 = 189;
      var1.drawString(CUtility.nns(this.wn2) + " rad/s", var28, var37);
      var28 = 254;
      var37 = 211;
      var1.drawString(CUtility.nns(this.Xi2), var28, var37);
      this.Eigenvalues(this.M, this.K);
      var1.drawString(CUtility.nns(Math.sqrt(this.lambda[0])) + " rad/s", 50, 279);
      var1.drawString(CUtility.nns(Math.sqrt(this.lambda[1])) + " rad/s", 270, 279);
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
      }

      if (var5) {
         this.repaint();
      }
   }
}

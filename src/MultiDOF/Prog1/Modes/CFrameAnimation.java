package MultiDOF.Prog1.Modes;

import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kmCode = 2;
   public static final int kk1Code = 3;
   public static final int kk2Code = 4;
   public static final int kdCode = 5;
   public static final int km3Code = 6;
   public static final int kk3Code = 7;
   public static final int kxEdge1 = 20;
   public static final int kxEdge2 = 275;
   public static final int kxEdge3 = 530;
   public static final int kyTopAbutment = 235;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 200;
   public static final int kyTopMass = 161;
   public static final int kAmpMax = 25;
   static double dt = 0.01;
   public static final double kStartm = 1.0;
   public static final double kStartk1 = 10.0;
   public static final double kStartc1 = 0.05;
   public static final double kStartk2 = 10.0;
   public static final double kStartd = 0.8;
   public static final double kStartm3 = 0.5;
   public static final double kStartk3 = 10.0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public static final int kPaused = 2;
   public int mState;
   double mTime;
   double mViewTime;
   double mT;
   double myscale;
   double mdispmax;
   double[] mwn = new double[3];
   double[][] mmoden = new double[3][3];
   int mxEdge;
   double mm = 1.0;
   double mk1 = 10.0;
   double mk2 = 10.0;
   double md = 0.8;
   double mm3 = 0.5;
   double mk3 = 10.0;
   double mW;
   public Button mStartButton;
   public Button mPauseButton;
   public Button mStopButton;
   Matrix M;
   Matrix K;
   Matrix D;
   double[] lambda;
   double[] u;
   boolean mDragMain;
   boolean mDragThumb;
   boolean mDragThumbnail;

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mTime = 0.0;
      this.modes();
   }

   public void Frame(Graphics var1) {
      this.mxEdge = 20;
      double var6 = 25.0 * this.mmoden[0][0];
      double var8 = 25.0 * this.mmoden[0][1];
      double var10 = 25.0 * this.mmoden[0][2];
      double var12 = var6 + (var8 - var6) * this.md;
      int var2 = (int)(var6 * Math.sin(this.mwn[0] * this.mTime));
      int var3 = (int)(var8 * Math.sin(this.mwn[0] * this.mTime));
      int var4 = (int)(var10 * Math.sin(this.mwn[0] * this.mTime));
      int var5 = (int)(var12 * Math.sin(this.mwn[0] * this.mTime));
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 235, 220, 20);
      var1.setColor(Color.black);
      double var15 = (163 + var2 - 235) / 10.0;
      var1.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int var14 = 1; var14 < 10; var14++) {
         if (var14 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * var14 - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * var14 + 1) * var15 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * var14 - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * var14 + 1) * var15 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      var1.setColor(Color.black);
      double var17 = (163 + var3 - 235) / 10.0;
      var1.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int var38 = 1; var38 < 10; var38++) {
         if (var38 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * var38 - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * var38 + 1) * var17 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * var38 - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * var38 + 1) * var17 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      Color var19 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(var19);
      var1.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      var1.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      var1.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      var1.setColor(Color.black);
      double var20 = (60 + var5 - var4) / 10.0;
      var1.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int var39 = 1; var39 < 10; var39++) {
         if (var39 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var39 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var39 + 1) * var20 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var39 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var39 + 1) * var20 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      var1.setColor(var19);
      var1.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      this.mxEdge = 275;
      var6 = 25.0 * this.mmoden[1][0];
      var8 = 25.0 * this.mmoden[1][1];
      var10 = 25.0 * this.mmoden[1][2];
      var12 = var6 + (var8 - var6) * this.md;
      var2 = (int)(var6 * Math.sin(this.mwn[1] * this.mTime));
      var3 = (int)(var8 * Math.sin(this.mwn[1] * this.mTime));
      var4 = (int)(var10 * Math.sin(this.mwn[1] * this.mTime));
      var5 = (int)(var12 * Math.sin(this.mwn[1] * this.mTime));
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 235, 220, 20);
      var1.setColor(Color.black);
      var15 = (163 + var2 - 235) / 10.0;
      var1.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int var40 = 1; var40 < 10; var40++) {
         if (var40 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * var40 - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * var40 + 1) * var15 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * var40 - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * var40 + 1) * var15 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      var1.setColor(Color.black);
      var17 = (163 + var3 - 235) / 10.0;
      var1.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int var41 = 1; var41 < 10; var41++) {
         if (var41 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * var41 - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * var41 + 1) * var17 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * var41 - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * var41 + 1) * var17 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      var1.setColor(var19);
      var1.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      var1.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      var1.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      var1.setColor(Color.black);
      var20 = (60 + var5 - var4) / 10.0;
      var1.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int var42 = 1; var42 < 10; var42++) {
         if (var42 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var42 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var42 + 1) * var20 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var42 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var42 + 1) * var20 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      var1.setColor(var19);
      var1.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      this.mxEdge = 530;
      var6 = 25.0 * this.mmoden[2][0];
      var8 = 25.0 * this.mmoden[2][1];
      var10 = 25.0 * this.mmoden[2][2];
      var12 = var6 + (var8 - var6) * this.md;
      var2 = (int)(var6 * Math.sin(this.mwn[2] * this.mTime));
      var3 = (int)(var8 * Math.sin(this.mwn[2] * this.mTime));
      var4 = (int)(var10 * Math.sin(this.mwn[2] * this.mTime));
      var5 = (int)(var12 * Math.sin(this.mwn[2] * this.mTime));
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 235, 220, 20);
      var1.setColor(Color.black);
      var15 = (163 + var2 - 235) / 10.0;
      var1.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int var43 = 1; var43 < 10; var43++) {
         if (var43 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * var43 - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * var43 + 1) * var15 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * var43 - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * var43 + 1) * var15 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      var1.setColor(Color.black);
      var17 = (163 + var3 - 235) / 10.0;
      var1.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int var44 = 1; var44 < 10; var44++) {
         if (var44 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * var44 - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * var44 + 1) * var17 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * var44 - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * var44 + 1) * var17 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      var1.setColor(var19);
      var1.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      var1.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      var1.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      var1.setColor(Color.black);
      var20 = (60 + var5 - var4) / 10.0;
      var1.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int var45 = 1; var45 < 10; var45++) {
         if (var45 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var45 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var45 + 1) * var20 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var45 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var45 + 1) * var20 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      var1.setColor(var19);
      var1.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      var1.setColor(Color.black);
      var1.drawString("First Mode", 90, 275);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mwn[0] / (Math.PI * 2)) + " Hz", 40, 295);
      var1.drawString(
         " Mode shape " + CUtility.nns(this.mmoden[0][0]) + " : " + CUtility.nns(this.mmoden[0][1]) + " : " + CUtility.nns(this.mmoden[0][2]), 25, 315
      );
      var1.drawString("Second Mode", 335, 275);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mwn[1] / (Math.PI * 2)) + " Hz", 295, 295);
      var1.drawString(
         " Mode shape " + CUtility.nns(this.mmoden[1][0]) + " : " + CUtility.nns(this.mmoden[1][1]) + " : " + CUtility.nns(this.mmoden[1][2]), 280, 315
      );
      var1.drawString("Third Mode", 590, 275);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mwn[2] / (Math.PI * 2)) + " Hz", 550, 295);
      var1.drawString(
         " Mode shape " + CUtility.nns(this.mmoden[2][0]) + " : " + CUtility.nns(this.mmoden[2][1]) + " : " + CUtility.nns(this.mmoden[2][2]), 535, 315
      );
   }

   public void modes() {
      double var1 = 1.0;
      double[][] var8 = new double[3][3];
      var8[0][0] = this.mm;
      var8[0][1] = 0.0;
      var8[0][2] = 0.0;
      var8[1][0] = 0.0;
      var8[1][1] = this.mm * var1 * var1 / 12.0;
      var8[1][2] = 0.0;
      var8[2][0] = 0.0;
      var8[2][1] = 0.0;
      var8[2][2] = this.mm3;
      this.M = new Matrix(var8);
      double[][] var9 = new double[3][3];
      var9[0][0] = this.mk1 + this.mk2 + this.mk3;
      var9[0][1] = (this.mk1 - this.mk2) * var1 / 2.0 - this.mk3 * (this.md - var1 / 2.0);
      var9[0][2] = -this.mk3;
      var9[1][0] = var9[0][1];
      var9[1][1] = (this.mk1 + this.mk2) * var1 * var1 / 4.0 + this.mk3 * (this.md - var1 / 2.0) * (this.md - var1 / 2.0);
      var9[1][2] = this.mk3 * (this.md - var1 / 2.0);
      var9[2][0] = var9[0][2];
      var9[2][1] = var9[1][2];
      var9[2][2] = this.mk3;
      this.K = new Matrix(var9);
      this.Eigenvalues(this.M, this.K);

      for (int var6 = 0; var6 < 3; var6++) {
         this.mwn[var6] = Math.sqrt(this.lambda[var6]);
      }

      for (int var10 = 0; var10 < 3; var10++) {
         this.Eigenvector(this.M, this.K, this.lambda[var10]);
         this.mmoden[var10][0] = this.u[0] + this.u[1] * var1 / 2.0;
         double var3 = Math.abs(this.mmoden[var10][0]);
         this.mmoden[var10][1] = this.u[0] - this.u[1] * var1 / 2.0;
         if (Math.abs(this.mmoden[var10][1]) > var3) {
            var3 = Math.abs(this.mmoden[var10][1]);
         }

         this.mmoden[var10][2] = this.u[2];
         if (Math.abs(this.mmoden[var10][2]) > var3) {
            var3 = Math.abs(this.mmoden[var10][2]);
         }

         for (int var7 = 0; var7 < 3; var7++) {
            this.mmoden[var10][var7] = this.mmoden[var10][var7] / var3;
         }
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
         case 0:
            if (this.mState == 1) {
               this.mTime += var3;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)var3);
            break;
         case 2:
            this.mm = var3;
            this.modes();
            break;
         case 3:
            this.mk1 = var3;
            this.modes();
            break;
         case 4:
            this.mk2 = var3;
            this.modes();
            break;
         case 5:
            this.md = var3;
            this.modes();
            break;
         case 6:
            this.mm3 = var3;
            this.modes();
            break;
         case 7:
            this.mk3 = var3;
            this.modes();
      }

      if (var5) {
         this.repaint();
      }
   }

   public void ChangeRunState(int var1) {
      switch (this.mState) {
         case 0:
            if (var1 == 1) {
               this.mTime = 0.0;
               this.mState = 1;
            }
            break;
         case 1:
            if (var1 == 2 || var1 == 0) {
               this.mState = var1;
            }
            break;
         case 2:
            if (var1 == 0 || var1 == 1) {
               this.mState = var1;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }

   public void UserDrag(int var1) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - var1 * dt;
      this.repaint();
   }
}

package MultiDOF.Prog1;

import jama.EigenvalueDecomposition;
import jama.Matrix;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
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

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mTime = 0.0;
      this.modes();
   }

   public void Frame(Graphics g) {
      this.mxEdge = 20;
      double var6 = 25.0 * this.mmoden[0][0];
      double var8 = 25.0 * this.mmoden[0][1];
      double var10 = 25.0 * this.mmoden[0][2];
      double var12 = var6 + (var8 - var6) * this.md;
      int var2 = (int)(var6 * Math.sin(this.mwn[0] * this.mTime));
      int var3 = (int)(var8 * Math.sin(this.mwn[0] * this.mTime));
      int var4 = (int)(var10 * Math.sin(this.mwn[0] * this.mTime));
      int var5 = (int)(var12 * Math.sin(this.mwn[0] * this.mTime));
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 235, 220, 20);
      g.setColor(Color.black);
      double var15 = (163 + var2 - 235) / 10.0;
      g.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int i = 1; i < 10; i++) {
         if (i % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * i - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * i + 1) * var15 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * i - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * i + 1) * var15 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      g.setColor(Color.black);
      double var17 = (163 + var3 - 235) / 10.0;
      g.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int j = 1; j < 10; j++) {
         if (j % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * j - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * j + 1) * var17 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * j - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * j + 1) * var17 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      Color var19 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var19);
      g.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      g.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      g.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      g.setColor(Color.black);
      double var20 = (60 + var5 - var4) / 10.0;
      g.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int k = 1; k < 10; k++) {
         if (k % 2 == 0) {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * k - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * k + 1) * var20 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * k - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * k + 1) * var20 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      g.setColor(var19);
      g.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      this.mxEdge = 275;
      var6 = 25.0 * this.mmoden[1][0];
      var8 = 25.0 * this.mmoden[1][1];
      var10 = 25.0 * this.mmoden[1][2];
      var12 = var6 + (var8 - var6) * this.md;
      var2 = (int)(var6 * Math.sin(this.mwn[1] * this.mTime));
      var3 = (int)(var8 * Math.sin(this.mwn[1] * this.mTime));
      var4 = (int)(var10 * Math.sin(this.mwn[1] * this.mTime));
      var5 = (int)(var12 * Math.sin(this.mwn[1] * this.mTime));
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 235, 220, 20);
      g.setColor(Color.black);
      var15 = (163 + var2 - 235) / 10.0;
      g.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int var40 = 1; var40 < 10; var40++) {
         if (var40 % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * var40 - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * var40 + 1) * var15 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * var40 - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * var40 + 1) * var15 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      g.setColor(Color.black);
      var17 = (163 + var3 - 235) / 10.0;
      g.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int var41 = 1; var41 < 10; var41++) {
         if (var41 % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * var41 - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * var41 + 1) * var17 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * var41 - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * var41 + 1) * var17 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      g.setColor(var19);
      g.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      g.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      g.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      g.setColor(Color.black);
      var20 = (60 + var5 - var4) / 10.0;
      g.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int var42 = 1; var42 < 10; var42++) {
         if (var42 % 2 == 0) {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var42 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var42 + 1) * var20 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var42 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var42 + 1) * var20 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      g.setColor(var19);
      g.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      this.mxEdge = 530;
      var6 = 25.0 * this.mmoden[2][0];
      var8 = 25.0 * this.mmoden[2][1];
      var10 = 25.0 * this.mmoden[2][2];
      var12 = var6 + (var8 - var6) * this.md;
      var2 = (int)(var6 * Math.sin(this.mwn[2] * this.mTime));
      var3 = (int)(var8 * Math.sin(this.mwn[2] * this.mTime));
      var4 = (int)(var10 * Math.sin(this.mwn[2] * this.mTime));
      var5 = (int)(var12 * Math.sin(this.mwn[2] * this.mTime));
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 235, 220, 20);
      g.setColor(Color.black);
      var15 = (163 + var2 - 235) / 10.0;
      g.drawLine(this.mxEdge, 235, this.mxEdge - 6, (int)(235.0 + var15 / 2.0));

      for (int var43 = 1; var43 < 10; var43++) {
         if (var43 % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(235.0 + (2 * var43 - 1) * var15 / 2.0), this.mxEdge - 6, (int)(235.0 + (2 * var43 + 1) * var15 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(235.0 + (2 * var43 - 1) * var15 / 2.0), this.mxEdge + 6, (int)(235.0 + (2 * var43 + 1) * var15 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(235.0 + 19.0 * var15 / 2.0), this.mxEdge, 161 + var2 + 2);
      g.setColor(Color.black);
      var17 = (163 + var3 - 235) / 10.0;
      g.drawLine(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, (int)(235.0 + var17 / 2.0));

      for (int var44 = 1; var44 < 10; var44++) {
         if (var44 % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(235.0 + (2 * var44 - 1) * var17 / 2.0), this.mxEdge + 200 - 6, (int)(235.0 + (2 * var44 + 1) * var17 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(235.0 + (2 * var44 - 1) * var17 / 2.0), this.mxEdge + 200 + 6, (int)(235.0 + (2 * var44 + 1) * var17 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(235.0 + 19.0 * var17 / 2.0), this.mxEdge + 200, 161 + var3 + 2);
      g.setColor(var19);
      g.drawLine(this.mxEdge, 161 + var2 + 1, this.mxEdge + 200, 161 + var3 + 1);
      g.drawLine(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
      g.drawLine(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
      g.setColor(Color.black);
      var20 = (60 + var5 - var4) / 10.0;
      g.drawLine(this.mxEdge + (int)(200.0 * this.md), 99 + var4, this.mxEdge + (int)(200.0 * this.md) - 6, (int)(99 + var4 + var20 / 2.0));

      for (int var45 = 1; var45 < 10; var45++) {
         if (var45 % 2 == 0) {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var45 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var45 + 1) * var20 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + (int)(200.0 * this.md) - 6,
               (int)(99 + var4 + (2 * var45 - 1) * var20 / 2.0),
               this.mxEdge + (int)(200.0 * this.md) + 6,
               (int)(99 + var4 + (2 * var45 + 1) * var20 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + (int)(200.0 * this.md) + 6, (int)(99 + var4 + 19.0 * var20 / 2.0), this.mxEdge + (int)(200.0 * this.md), 160 + var5);
      g.setColor(var19);
      g.fillRect(this.mxEdge + (int)(200.0 * this.md) - 10, 89 + var4, 20, 10);
      g.setColor(Color.black);
      g.drawString("First Mode", 90, 275);
      g.drawString(" Natural frequency " + CUtility.nns(this.mwn[0] / (Math.PI * 2)) + " Hz", 40, 295);
      g.drawString(
         " Mode shape " + CUtility.nns(this.mmoden[0][0]) + " : " + CUtility.nns(this.mmoden[0][1]) + " : " + CUtility.nns(this.mmoden[0][2]), 25, 315
      );
      g.drawString("Second Mode", 335, 275);
      g.drawString(" Natural frequency " + CUtility.nns(this.mwn[1] / (Math.PI * 2)) + " Hz", 295, 295);
      g.drawString(
         " Mode shape " + CUtility.nns(this.mmoden[1][0]) + " : " + CUtility.nns(this.mmoden[1][1]) + " : " + CUtility.nns(this.mmoden[1][2]), 280, 315
      );
      g.drawString("Third Mode", 590, 275);
      g.drawString(" Natural frequency " + CUtility.nns(this.mwn[2] / (Math.PI * 2)) + " Hz", 550, 295);
      g.drawString(
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

      for (int i = 0; i < 3; i++) {
         this.mwn[i] = Math.sqrt(this.lambda[i]);
      }

      for (int j = 0; j < 3; j++) {
         this.Eigenvector(this.M, this.K, this.lambda[j]);
         this.mmoden[j][0] = this.u[0] + this.u[1] * var1 / 2.0;
         double var3 = Math.abs(this.mmoden[j][0]);
         this.mmoden[j][1] = this.u[0] - this.u[1] * var1 / 2.0;
         if (Math.abs(this.mmoden[j][1]) > var3) {
            var3 = Math.abs(this.mmoden[j][1]);
         }

         this.mmoden[j][2] = this.u[2];
         if (Math.abs(this.mmoden[j][2]) > var3) {
            var3 = Math.abs(this.mmoden[j][2]);
         }

         for (int k = 0; k < 3; k++) {
            this.mmoden[j][k] = this.mmoden[j][k] / var3;
         }
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
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)val);
            break;
         case 2:
            this.mm = val;
            this.modes();
            break;
         case 3:
            this.mk1 = val;
            this.modes();
            break;
         case 4:
            this.mk2 = val;
            this.modes();
            break;
         case 5:
            this.md = val;
            this.modes();
            break;
         case 6:
            this.mm3 = val;
            this.modes();
            break;
         case 7:
            this.mk3 = val;
            this.modes();
      }

      if (var5) {
         this.repaint();
      }
   }

   public void ChangeRunState(int newState) {
      switch (this.mState) {
         case 0:
            if (newState == 1) {
               this.mTime = 0.0;
               this.mState = 1;
            }
            break;
         case 1:
            if (newState == 2 || newState == 0) {
               this.mState = newState;
            }
            break;
         case 2:
            if (newState == 0 || newState == 1) {
               this.mState = newState;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }

   public void UserDrag(int offset) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - offset * dt;
      this.repaint();
   }
}

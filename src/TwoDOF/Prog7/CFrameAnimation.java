package TwoDOF.Prog7;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
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

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mWn1 = Math.sqrt((-this.B - Math.sqrt(this.B * this.B - 4.0 * this.A * this.C)) / (2.0 * this.A)) / (Math.PI * 2);
      this.mWn2 = Math.sqrt((-this.B + Math.sqrt(this.B * this.B - 4.0 * this.A * this.C)) / (2.0 * this.A)) / (Math.PI * 2);
      this.mWmin = 0.1 * this.mWn1;
      this.mWmax = 1.5 * this.mWn2;
      this.mxscale = 60.0;
      this.myscale = 45.0;
   }

   public void Frame(Graphics g) {
      this.mAmp = new double[602];
      this.mRealAmp = new double[602];
      this.mQuadAmp = new double[602];
      this.mPhase = new double[602];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(77, 340, 563, 340);

      for (int i = 1; i < 9; i++) {
         g.drawLine(80 + i * 60, 340, 80 + i * 60, 343);
      }

      Color var18 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var18);
      g.drawLine(80, 47, 80, 343);

      for (int j = 0; j < 7; j++) {
         g.drawLine(80, 50 + j * 45, 77, 50 + j * 45);
      }

      this.mAmp[0] = 1.0;
      double var3 = this.mAmp[0];

      for (int k = 1; k < 481; k++) {
         double var7 = (Math.PI * 2) * k / this.mxscale;
         double var15 = this.mk2 * this.mk2 + var7 * var7 * this.mc2 * this.mc2;
         double var9 = this.mk2 / var15 - 1.0 / (this.mm2 * var7 * var7);
         double var11 = -var7 * this.mc2 / var15;
         double var13 = this.mk1 - this.mm1 * var7 * var7 + var9 / (var9 * var9 + var11 * var11);
         var15 = var7 * this.mc1 - var11 / (var9 * var9 + var11 * var11);
         var9 = var13 / (var13 * var13 + var15 * var15);
         var11 = -var15 / (var13 * var13 + var15 * var15);
         this.mRealAmp[k] = var9 * this.mk1 - var11 * var7 * this.mc1;
         this.mQuadAmp[k] = var9 * var7 * this.mc1 + var11 * this.mk1;
         this.mAmp[k] = Math.sqrt(this.mRealAmp[k] * this.mRealAmp[k] + this.mQuadAmp[k] * this.mQuadAmp[k]);
         g.drawLine(
            80 + (k - 1),
            (int)(140.0 - Math.log(var3) / Math.log(10.0) * this.myscale),
            80 + k,
            (int)(140.0 - Math.log(this.mAmp[k]) / Math.log(10.0) * this.myscale)
         );
         var3 = this.mAmp[k];
      }

      Color var19 = new Color(0.77F, 0.38F, 0.0F);
      g.setColor(var19);
      this.mPhase[0] = 0.0;
      double var5 = this.mPhase[0];

      for (int var22 = 1; var22 < 481; var22++) {
         this.mPhase[var22] = 180.0 * Math.atan(this.mQuadAmp[var22] / this.mRealAmp[var22]) / Math.PI;
         if (this.mPhase[var22] > 0.0 && this.mQuadAmp[var22] < 0.0) {
            this.mPhase[var22] = this.mPhase[var22] - 180.0;
         }

         g.drawLine(80 + (var22 - 1), (int)(130.0 - var5 / 2.0), 80 + var22, (int)(130.0 - this.mPhase[var22] / 2.0));
         var5 = this.mPhase[var22];
         this.mPhase[var22] = this.mPhase[var22] * Math.PI / 180.0;
      }

      g.drawLine(560, 127, 560, 343);

      for (int var23 = 0; var23 < 9; var23++) {
         g.drawLine(560, 130 + (int)(var23 * 22.5), 563, 130 + (int)(var23 * 22.5));
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 1:
            this.mm1 = val;
            break;
         case 2:
            this.mk1 = val;
            break;
         case 3:
            this.mc1 = val;
            break;
         case 4:
            this.mm2 = val;
            break;
         case 5:
            this.mk2 = val;
            break;
         case 6:
            this.mc2 = val;
      }

      if (var5) {
         this.repaint();
      }
   }
}

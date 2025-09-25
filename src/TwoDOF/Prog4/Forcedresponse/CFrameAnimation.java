package TwoDOF.Prog4.Forcedresponse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kK2divK1Code = 1;
   public static final int kM2divM1Code = 2;
   public static final int kXo = 40;
   public static final int kY1o = 160;
   public static final int kY2o = 480;
   public static final double kStartK2divK1 = 2.0;
   public static final double kStartM2divM1 = 0.5;
   public static final double kScale = 50.0;
   double mK2divK1;
   double mM2divM1;
   double[] mAmp1 = new double[2];
   double[] mAmp11 = new double[2];
   double[] mAmp12 = new double[2];
   double[] mAmp2 = new double[2];
   double[] mAmp21 = new double[2];
   double[] mAmp22 = new double[2];

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mK2divK1 = 2.0;
      this.mM2divM1 = 0.5;
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(40, 7, 40, 313);
      g.drawLine(37, 160, 343, 160);

      for (int p = -3; p < 4; p++) {
         g.drawLine(40, 160 - (int)(p * 50.0), 37, 160 - (int)(p * 50.0));
      }

      for (int var30 = 1; var30 < 6; var30++) {
         g.drawLine(40 + var30 * 60, 160, 40 + var30 * 60, 157);
      }

      g.drawLine(40, 327, 40, 633);
      g.drawLine(37, 480, 343, 480);

      for (int var31 = -3; var31 < 4; var31++) {
         g.drawLine(40, 480 - (int)(var31 * 50.0), 37, 480 - (int)(var31 * 50.0));
      }

      for (int var32 = 1; var32 < 6; var32++) {
         g.drawLine(40 + var32 * 60, 480, 40 + var32 * 60, 477);
      }

      this.mAmp1[0] = 1.0;
      this.mAmp2[0] = 1.0;
      double Q = this.mM2divM1;
      double R = this.mK2divK1;
      double c3 = Q + Q * R + R;
      double c4 = Math.sqrt(c3 * c3 - 4.0 * R * Q);
      double s1 = (c3 - c4) / (2.0 * Q);
      double s2 = (c3 + c4) / (2.0 * Q);
      double u1 = 1.0 / (1.0 - Q * s1 / R);
      double u2 = 1.0 / (1.0 - Q * s2 / R);
      double w1 = Math.sqrt(s1);
      double w2 = Math.sqrt(s2);
      double C1 = (1.0 - u2) / (u1 - u2);
      double C2 = (u1 - 1.0) / (u1 - u2);

      for (int var33 = 1; var33 < 300; var33++) {
         double mr = var33 / 60.0;
         this.mAmp11[1] = C1 / (1.0 - mr * mr / w1 / w1);
         this.mAmp12[1] = C2 / (1.0 - mr * mr / w2 / w2);
         this.mAmp21[1] = u1 * this.mAmp11[1];
         this.mAmp22[1] = u2 * this.mAmp12[1];
         this.mAmp1[1] = this.mAmp11[1] + this.mAmp12[1];
         this.mAmp2[1] = this.mAmp21[1] + this.mAmp22[1];
         if (var33 > 1) {
            g.setColor(Color.red);
            if (this.mAmp11[0] * this.mAmp11[1] > 0.0 & Math.abs(this.mAmp11[1] * 50.0) < 150.0 & Math.abs(this.mAmp11[0] * 50.0) < 150.0) {
               g.drawLine(40 + (var33 - 1), (int)(160.0 - this.mAmp11[0] * 50.0), 40 + var33, (int)(160.0 - this.mAmp11[1] * 50.0));
            }

            g.setColor(Color.green);
            if (this.mAmp12[0] * this.mAmp12[1] > 0.0 & Math.abs(this.mAmp12[1] * 50.0) < 150.0 & Math.abs(this.mAmp12[0] * 50.0) < 150.0) {
               g.drawLine(40 + (var33 - 1), (int)(160.0 - this.mAmp12[0] * 50.0), 40 + var33, (int)(160.0 - this.mAmp12[1] * 50.0));
            }
         }

         g.setColor(Color.black);
         if (this.mAmp1[0] * this.mAmp1[1] > 0.0 & Math.abs(this.mAmp1[1] * 50.0) < 150.0 & Math.abs(this.mAmp1[0] * 50.0) < 150.0) {
            g.drawLine(40 + (var33 - 1), (int)(160.0 - this.mAmp1[0] * 50.0), 40 + var33, (int)(160.0 - this.mAmp1[1] * 50.0));
         }

         if (var33 > 1) {
            g.setColor(Color.red);
            if (this.mAmp21[0] * this.mAmp21[1] > 0.0 & Math.abs(this.mAmp21[1] * 50.0) < 150.0 & Math.abs(this.mAmp21[0] * 50.0) < 150.0) {
               g.drawLine(40 + (var33 - 1), (int)(480.0 - this.mAmp21[0] * 50.0), 40 + var33, (int)(480.0 - this.mAmp21[1] * 50.0));
            }

            g.setColor(Color.green);
            if (this.mAmp22[0] * this.mAmp22[1] > 0.0 & Math.abs(this.mAmp22[1] * 50.0) < 150.0 & Math.abs(this.mAmp22[0] * 50.0) < 150.0) {
               g.drawLine(40 + (var33 - 1), (int)(480.0 - this.mAmp22[0] * 50.0), 40 + var33, (int)(480.0 - this.mAmp22[1] * 50.0));
            }
         }

         g.setColor(Color.black);
         if (this.mAmp2[0] * this.mAmp2[1] > 0.0 & Math.abs(this.mAmp2[1] * 50.0) < 150.0 & Math.abs(this.mAmp2[0] * 50.0) < 150.0) {
            g.drawLine(40 + (var33 - 1), (int)(480.0 - this.mAmp2[0] * 50.0), 40 + var33, (int)(480.0 - this.mAmp2[1] * 50.0));
         }

         this.mAmp1[0] = this.mAmp1[1];
         this.mAmp11[0] = this.mAmp11[1];
         this.mAmp12[0] = this.mAmp12[1];
         this.mAmp2[0] = this.mAmp2[1];
         this.mAmp21[0] = this.mAmp21[1];
         this.mAmp22[0] = this.mAmp22[1];
      }

      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, 6);
      g.fillRect(0, 313, super.width, 10);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mK2divK1 = val;
            break;
         case 2:
            this.mM2divM1 = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

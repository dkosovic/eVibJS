package Beam.Prog7.Forcedresponse_2DOF;

import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kmCode = 1;
   public static final int kk1Code = 2;
   public static final int kc1Code = 3;
   public static final int kk2Code = 4;
   public static final int kc2Code = 5;
   public static final int kbCode = 6;
   public static final double kStartm = 1.0;
   public static final double kStartk1 = 20.0;
   public static final double kStartc1 = 0.3;
   public static final double kStartk2 = 10.0;
   public static final double kStartc2 = 0.4;
   public static final double kStartb = 0.3;
   public static final int kXo = 80;
   double[] mAmp;
   double[] mX1overF;
   double[] mX2overF;
   double mm = 1.0;
   double mk1 = 20.0;
   double mc1 = 0.3;
   double mk2 = 10.0;
   double mc2 = 0.4;
   double mb = 0.3;
   double mW;
   double mWmin;
   double mWmax;
   int mxpower;
   int mypower;
   double mxscale = 60.0;
   double myscale = 45.0;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mX1overF = new double[602];
      this.mX2overF = new double[602];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(77, 340, 563, 340);

      for (int p = 1; p < 9; p++) {
         g.drawLine(80 + p * 60, 340, 80 + p * 60, 343);
      }

      g.setColor(Color.black);
      g.drawLine(80, 47, 80, 343);

      for (int var18 = 0; var18 < 7; var18++) {
         g.drawLine(80, 50 + var18 * 45, 77, 50 + var18 * 45);
      }

      Color force = new Color(0.77F, 0.38F, 0.0F);
      g.setColor(force);
      g.drawLine(465 + (int)(132.0 * this.mb) - 2, 84, 465 + (int)(132.0 * this.mb) - 2, 86);
      g.drawLine(465 + (int)(132.0 * this.mb) - 1, 82, 465 + (int)(132.0 * this.mb) - 1, 107);
      g.drawLine(465 + (int)(132.0 * this.mb), 80, 465 + (int)(132.0 * this.mb), 107);
      g.drawLine(465 + (int)(132.0 * this.mb) + 1, 82, 465 + (int)(132.0 * this.mb) + 1, 107);
      g.drawLine(465 + (int)(132.0 * this.mb) + 2, 84, 465 + (int)(132.0 * this.mb) + 2, 86);
      g.setColor(Color.black);
      g.drawString("F", 470 + (int)(132.0 * this.mb), 100);
      this.mX1overF[0] = (1.0 - this.mb) / this.mk1;
      double mAmp1 = this.mX1overF[0];
      this.mX2overF[0] = this.mb / this.mk2;
      double mAmp2 = this.mX2overF[0];

      for (int var19 = 1; var19 < 481; var19++) {
         g.setColor(Color.red);
         double mWin = (Math.PI * 2) * var19 / this.mxscale;
         double mA = 12.0 * this.mk2 * (1.0 - this.mb) - this.mm * mWin * mWin * (4.0 - 6.0 * this.mb);
         double mB = 12.0 * mWin * this.mc2 * (1.0 - this.mb);
         double mC = (4.0 * this.mk1 - this.mm * mWin * mWin) * (4.0 * this.mk2 - this.mm * mWin * mWin)
            - 4.0 * this.mk2 * this.mk1
            - 12.0 * mWin * mWin * this.mc1 * this.mc2;
         double mD = 4.0 * mWin * (this.mc1 * (3.0 * this.mk2 - this.mm * mWin * mWin) + this.mc2 * (3.0 * this.mk1 - this.mm * mWin * mWin));
         this.mX1overF[var19] = Math.sqrt((mA * mA + mB * mB) / (mC * mC + mD * mD));
         g.drawLine(
            80 + (var19 - 1),
            (int)(95.0 - Math.log(mAmp1) / Math.log(10.0) * this.myscale),
            80 + var19,
            (int)(95.0 - Math.log(this.mX1overF[var19]) / Math.log(10.0) * this.myscale)
         );
         mAmp1 = this.mX1overF[var19];
         g.setColor(Color.blue);
         mA = 12.0 * this.mk1 * this.mb + this.mm * mWin * mWin * (2.0 - 6.0 * this.mb);
         mB = 12.0 * mWin * this.mc1 * this.mb;
         this.mX2overF[var19] = Math.sqrt((mA * mA + mB * mB) / (mC * mC + mD * mD));
         g.drawLine(
            80 + (var19 - 1),
            (int)(95.0 - Math.log(mAmp2) / Math.log(10.0) * this.myscale),
            80 + var19,
            (int)(95.0 - Math.log(this.mX2overF[var19]) / Math.log(10.0) * this.myscale)
         );
         mAmp2 = this.mX2overF[var19];
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mm = val;
            break;
         case 2:
            this.mk1 = val;
            break;
         case 3:
            this.mc1 = val;
            break;
         case 4:
            this.mk2 = val;
            break;
         case 5:
            this.mc2 = val;
            break;
         case 6:
            this.mb = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

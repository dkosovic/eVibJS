package MultiDOF.Prog4;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kmCode = 1;
   public static final int kk1Code = 2;
   public static final int kc1Code = 3;
   public static final int kk2Code = 4;
   public static final int kc2Code = 5;
   public static final int kbCode = 6;
   public static final int kcCode = 7;
   public static final int kdCode = 8;
   public static final int km3Code = 9;
   public static final int kk3Code = 10;
   public static final double kStartm = 1.0;
   public static final double kStartk1 = 10.0;
   public static final double kStartc1 = 0.05;
   public static final double kStartk2 = 10.0;
   public static final double kStartc2 = 0.05;
   public static final double kStartb = 0.3;
   public static final double kStartc = 0.6;
   public static final double kStartd = 0.8;
   public static final double kStartm3 = 0.5;
   public static final double kStartk3 = 10.0;
   public static final int kXo = 80;
   double[] mAmp;
   double mm = 1.0;
   double mk1 = 10.0;
   double mc1 = 0.05;
   double mk2 = 10.0;
   double mc2 = 0.05;
   double mb = 0.3;
   double mc = 0.6;
   double md = 0.8;
   double mm3 = 0.5;
   double mk3 = 10.0;
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

      for (int i = 0; i < 7; i++) {
         g.drawLine(80, 50 + i * 45, 77, 50 + i * 45);
      }

      Color force = new Color(0.77F, 0.38F, 0.0F);
      g.setColor(force);
      g.drawLine(463 + (int)(190.0 * this.mb) - 2, 125, 463 + (int)(190.0 * this.mb) - 2, 126);
      g.drawLine(463 + (int)(190.0 * this.mb) - 1, 90, 463 + (int)(190.0 * this.mb) - 1, 128);
      g.drawLine(463 + (int)(190.0 * this.mb), 90, 463 + (int)(190.0 * this.mb), 130);
      g.drawLine(463 + (int)(190.0 * this.mb) + 1, 90, 463 + (int)(190.0 * this.mb) + 1, 128);
      g.drawLine(463 + (int)(190.0 * this.mb) + 2, 125, 463 + (int)(190.0 * this.mb) + 2, 126);
      g.setColor(Color.black);
      g.drawString("F", 467 + (int)(190.0 * this.mb), 130);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(mass);
      g.drawLine(463 + (int)(190.0 * this.mc) - 2, 105, 463 + (int)(190.0 * this.mc) - 2, 106);
      g.drawLine(463 + (int)(190.0 * this.mc) - 1, 90, 463 + (int)(190.0 * this.mc) - 1, 108);
      g.drawLine(463 + (int)(190.0 * this.mc), 90, 463 + (int)(190.0 * this.mc), 110);
      g.drawLine(463 + (int)(190.0 * this.mc) + 1, 90, 463 + (int)(190.0 * this.mc) + 1, 108);
      g.drawLine(463 + (int)(190.0 * this.mc) + 2, 105, 463 + (int)(190.0 * this.mc) + 2, 106);
      g.setColor(Color.black);
      g.drawString("X", 467 + (int)(190.0 * this.mc), 110);
      g.drawLine(462 + (int)(190.0 * this.md) + 3, 82, 462 + (int)(190.0 * this.md), 85);
      g.drawLine(462 + (int)(190.0 * this.md) - 3, 76, 462 + (int)(190.0 * this.md) + 3, 82);
      g.drawLine(462 + (int)(190.0 * this.md) + 3, 70, 462 + (int)(190.0 * this.md) - 3, 76);
      g.drawLine(462 + (int)(190.0 * this.md) - 3, 64, 462 + (int)(190.0 * this.md) + 3, 70);
      g.drawLine(462 + (int)(190.0 * this.md), 61, 462 + (int)(190.0 * this.md) - 3, 64);
      g.setColor(mass);
      g.fillRect(462 + (int)(190.0 * this.md) - 10, 51, 20, 10);
      g.setColor(Color.black);
      g.drawString("m3", 462 + (int)(190.0 * this.md) + 12, 59);
      g.drawString("k3", 462 + (int)(190.0 * this.md) + 6, 75);
      double mAmpL = (1.0 - this.mb) / this.mk1;
      double mAmpR = this.mb / this.mk2;
      double mAmp1 = (1.0 - this.mc) * mAmpL + this.mc * mAmpR;
      g.setColor(mass);

      for (int j = 1; j < 481; j++) {
         double mWin = (Math.PI * 2) * j / this.mxscale;
         double mA = 12.0 * this.mk2 * (1.0 - this.mb) - this.mm * mWin * mWin * (4.0 - 6.0 * this.mb);
         double mB = 12.0 * mWin * this.mc2 * (1.0 - this.mb);
         double mC = (4.0 * this.mk1 - this.mm * mWin * mWin) * (4.0 * this.mk2 - this.mm * mWin * mWin)
            - 4.0 * this.mk2 * this.mk1
            - 12.0 * mWin * mWin * this.mc1 * this.mc2;
         double mD = 4.0 * mWin * (this.mc1 * (3.0 * this.mk2 - this.mm * mWin * mWin) + this.mc2 * (3.0 * this.mk1 - this.mm * mWin * mWin));
         double mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         double mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaL1Real = mReal;
         double mBetaL1Imag = mImag;
         mA = 12.0 * this.mk1 * this.mb + this.mm * mWin * mWin * (2.0 - 6.0 * this.mb);
         mB = 12.0 * mWin * this.mc1 * this.mb;
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaR1Real = mReal;
         double mBetaR1Imag = mImag;
         double mBeta12Real = (1.0 - this.mc) * mBetaL1Real + this.mc * mBetaR1Real;
         double mBeta12Imag = (1.0 - this.mc) * mBetaL1Imag + this.mc * mBetaR1Imag;
         double mBeta13Real = (1.0 - this.md) * mBetaL1Real + this.md * mBetaR1Real;
         double mBeta13Imag = (1.0 - this.md) * mBetaL1Imag + this.md * mBetaR1Imag;
         mA = 12.0 * this.mk2 * (1.0 - this.mc) - this.mm * mWin * mWin * (4.0 - 6.0 * this.mc);
         mB = 12.0 * mWin * this.mc2 * (1.0 - this.mc);
         mC = (4.0 * this.mk1 - this.mm * mWin * mWin) * (4.0 * this.mk2 - this.mm * mWin * mWin)
            - 4.0 * this.mk2 * this.mk1
            - 12.0 * mWin * mWin * this.mc1 * this.mc2;
         mD = 4.0 * mWin * (this.mc1 * (3.0 * this.mk2 - this.mm * mWin * mWin) + this.mc2 * (3.0 * this.mk1 - this.mm * mWin * mWin));
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaL2Real = mReal;
         double mBetaL2Imag = mImag;
         mA = 12.0 * this.mk1 * this.mc + this.mm * mWin * mWin * (2.0 - 6.0 * this.mc);
         mB = 12.0 * mWin * this.mc1 * this.mc;
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaR2Real = mReal;
         double mBetaR2Imag = mImag;
         double mBeta23Real = (1.0 - this.md) * mBetaL2Real + this.md * mBetaR2Real;
         double mBeta23Imag = (1.0 - this.md) * mBetaL2Imag + this.md * mBetaR2Imag;
         mA = 12.0 * this.mk2 * (1.0 - this.md) - this.mm * mWin * mWin * (4.0 - 6.0 * this.md);
         mB = 12.0 * mWin * this.mc2 * (1.0 - this.md);
         mC = (4.0 * this.mk1 - this.mm * mWin * mWin) * (4.0 * this.mk2 - this.mm * mWin * mWin)
            - 4.0 * this.mk2 * this.mk1
            - 12.0 * mWin * mWin * this.mc1 * this.mc2;
         mD = 4.0 * mWin * (this.mc1 * (3.0 * this.mk2 - this.mm * mWin * mWin) + this.mc2 * (3.0 * this.mk1 - this.mm * mWin * mWin));
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaL3Real = mReal;
         double mBetaL3Imag = mImag;
         mA = 12.0 * this.mk1 * this.md + this.mm * mWin * mWin * (2.0 - 6.0 * this.md);
         mB = 12.0 * mWin * this.mc1 * this.md;
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mBetaR3Real = mReal;
         double mBetaR3Imag = mImag;
         double mBeta33Real = (1.0 - this.md) * mBetaL3Real + this.md * mBetaR3Real;
         double mBeta33Imag = (1.0 - this.md) * mBetaL3Imag + this.md * mBetaR3Imag;
         double mGamma33Real = 1.0 / this.mk3 - 1.0 / (this.mm3 * mWin * mWin);
         double mGamma33Imag = 0.0;
         mA = mBeta13Real * mBeta23Real - mBeta13Imag * mBeta23Imag;
         mB = mBeta13Real * mBeta23Imag + mBeta13Imag * mBeta23Real;
         mC = mBeta33Real + mGamma33Real;
         mD = mBeta33Imag + mGamma33Imag;
         mReal = (mA * mC + mB * mD) / (mC * mC + mD * mD);
         mImag = (mB * mC - mA * mD) / (mC * mC + mD * mD);
         double mAlpha12Real = mBeta12Real - mReal;
         double mAlpha12Imag = mBeta12Imag - mImag;
         double mAmp2 = Math.sqrt(mAlpha12Real * mAlpha12Real + mAlpha12Imag * mAlpha12Imag);
         g.drawLine(
            80 + (j - 1),
            (int)(95.0 - Math.log(mAmp1) / Math.log(10.0) * this.myscale),
            80 + j,
            (int)(95.0 - Math.log(mAmp2) / Math.log(10.0) * this.myscale)
         );
         mAmp1 = mAmp2;
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
            break;
         case 7:
            this.mc = val;
            break;
         case 8:
            this.md = val;
            break;
         case 9:
            this.mm3 = val;
            break;
         case 10:
            this.mk3 = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int km1Code = 1;
   public static final int kk1Code = 2;
   public static final int kc1Code = 3;
   public static final int km2Code = 4;
   public static final double kStartm1 = 1.0;
   public static final double kStartk1 = 40.0;
   public static final double kStartc1 = 0.05;
   public static final double kStartm2 = 0.1;
   public static final int kXo = 80;
   double[] mAmp;
   double[] mRealAmp;
   double[] mQuadAmp;
   double mm1 = 1.0;
   double mk1 = 40.0;
   double mc1 = 0.05;
   double mm2 = 0.1;
   double mk2;
   double mc2;
   double mW;
   double mWin;
   double mMax;
   double mMax1;
   double mMax2;
   double A;
   double B;
   double C;
   int mxpower;
   int mypower;
   double mxscale = 60.0;
   double myscale = 45.0;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mAmp = new double[602];
      this.mRealAmp = new double[602];
      this.mQuadAmp = new double[602];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(77, 340, 563, 340);

      for (int p = 1; p < 9; p++) {
         g.drawLine(80 + p * 60, 340, 80 + p * 60, 343);
      }

      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(mass);
      g.drawLine(80, 47, 80, 343);

      for (int var9 = 0; var9 < 7; var9++) {
         g.drawLine(80, 50 + var9 * 45, 77, 50 + var9 * 45);
      }

      this.Optimise();
      double mAmp1 = this.mAmp[0];

      for (int var10 = 1; var10 < 481; var10++) {
         g.drawLine(
            80 + (var10 - 1),
            (int)(140.0 - Math.log(mAmp1) / Math.log(10.0) * this.myscale),
            80 + var10,
            (int)(140.0 - Math.log(this.mAmp[var10]) / Math.log(10.0) * this.myscale)
         );
         mAmp1 = this.mAmp[var10];
      }

      g.setColor(Color.black);
      g.drawString(" Optimum values", 345, 54);
      g.drawString(" Absorber stiffness", 345, 70);
      g.drawString(CUtility.nns(this.mk2) + " N/m", 348, 86);
      g.drawString(" Absorber damper", 345, 102);
      g.drawString(CUtility.nns(this.mc2) + " Ns/m", 348, 118);
   }

   public void Response() {
      this.mAmp[0] = 1.0 / this.mk1;

      for (int p = 1; p < 481; p++) {
         this.mWin = (Math.PI * 2) * p / this.mxscale;
         double mD = this.mk2 * this.mk2 + this.mWin * this.mWin * this.mc2 * this.mc2;
         double mA = this.mk2 / mD - 1.0 / (this.mm2 * this.mWin * this.mWin);
         double mB = -this.mWin * this.mc2 / mD;
         double mC = this.mk1 - this.mm1 * this.mWin * this.mWin + mA / (mA * mA + mB * mB);
         mD = this.mWin * this.mc1 - mB / (mA * mA + mB * mB);
         this.mRealAmp[p] = mC / (mC * mC + mD * mD);
         this.mQuadAmp[p] = -mD / (mC * mC + mD * mD);
         this.mAmp[p] = Math.sqrt(this.mRealAmp[p] * this.mRealAmp[p] + this.mQuadAmp[p] * this.mQuadAmp[p]);
      }
   }

   public void Maximum() {
      this.mMax = this.mAmp[0];

      for (int p = 1; p < 481; p++) {
         if (this.mAmp[p] > this.mMax) {
            this.mMax = this.mAmp[p];
         }
      }
   }

   public void Optimise() {
      double Q = this.mm2 / this.mm1;
      double R = Q / ((1.0 + Q) * (1.0 + Q));
      this.mk2 = this.mk1 * R;
      this.mc2 = Math.sqrt(this.mm2 * this.mk2 * 3.0 * Q / (8.0 * (1.0 + Q) * (1.0 + Q) * (1.0 + Q))) * 2.0;
      double minck2 = 0.1 * this.mk2;
      double mincc2 = 0.1 * this.mc2;
      this.Response();
      this.Maximum();
      this.mMax1 = this.mMax;

      for (int p = 1; p < 4; p++) {
         this.mk2 += minck2;
         this.Response();
         this.Maximum();
         this.mMax2 = this.mMax;
         if (this.mMax2 < this.mMax1) {
            while (this.mMax2 < this.mMax1) {
               this.mMax1 = this.mMax2;
               this.mk2 += minck2;
               this.Response();
               this.Maximum();
               this.mMax2 = this.mMax;
            }
         } else {
            this.mk2 -= 2.0 * minck2;
            this.Response();
            this.Maximum();

            for (this.mMax2 = this.mMax; this.mMax2 < this.mMax1; this.mMax2 = this.mMax) {
               this.mMax1 = this.mMax2;
               this.mk2 -= minck2;
               this.Response();
               this.Maximum();
            }
         }

         this.Response();
         this.Maximum();
         this.mMax1 = this.mMax;
         this.mc2 += mincc2;
         this.Response();
         this.Maximum();
         this.mMax2 = this.mMax;
         if (this.mMax2 < this.mMax1) {
            while (this.mMax2 < this.mMax1) {
               this.mMax1 = this.mMax2;
               this.mc2 += mincc2;
               this.Response();
               this.Maximum();
               this.mMax2 = this.mMax;
            }
         } else {
            this.mc2 -= 2.0 * mincc2;
            this.Response();
            this.Maximum();

            for (this.mMax2 = this.mMax; this.mMax2 < this.mMax1; this.mMax2 = this.mMax) {
               this.mMax1 = this.mMax2;
               this.mc2 -= mincc2;
               this.Response();
               this.Maximum();
            }
         }

         minck2 = 0.1 * minck2;
         mincc2 = 0.1 * mincc2;
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
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
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

package Complex.Prog4.Forcedresponse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kLbCode = 1;
   public static final int kDbCode = 2;
   public static final int kLcCode = 3;
   public static final int kDcCode = 4;
   public static final double kStartLb = 0.4;
   public static final double kStartDb = 0.06;
   public static final double kStartLc = 0.6;
   public static final double kStartDc = 0.04;
   public static final double kWmax = 5000.0;
   public static final double kScale = 2.5E10;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final int kXaxis = 163;
   public static final int kXo = 20;
   double mLb = 0.4;
   double mDb = 0.06;
   double mLc = 0.6;
   double mDc = 0.04;
   double[] mRecb;
   double[] mRecc;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mRecb = new double[450];
      this.mRecc = new double[450];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(450, 250, 20, 50);
      g.setColor(Color.blue);
      g.drawLine(
         470 + (int)(200.0 * this.mLb / 2.0),
         275 - (int)(20.0 * this.mDc / 0.2),
         470 + (int)(200.0 * this.mLb / 2.0) + (int)(200.0 * this.mLc / 2.0),
         275 - (int)(20.0 * this.mDc / 0.2)
      );
      g.drawLine(
         470 + (int)(200.0 * this.mLb / 2.0) + (int)(200.0 * this.mLc / 2.0),
         275 - (int)(20.0 * this.mDc / 0.2),
         470 + (int)(200.0 * this.mLb / 2.0) + (int)(200.0 * this.mLc / 2.0),
         275 + (int)(20.0 * this.mDc / 0.2)
      );
      g.drawLine(
         470 + (int)(200.0 * this.mLb / 2.0),
         275 + (int)(20.0 * this.mDc / 0.2),
         470 + (int)(200.0 * this.mLb / 2.0) + (int)(200.0 * this.mLc / 2.0),
         275 + (int)(20.0 * this.mDc / 0.2)
      );
      g.drawLine(
         470 + (int)(200.0 * this.mLb / 2.0), 275 - (int)(20.0 * this.mDc / 0.2), 470 + (int)(200.0 * this.mLb / 2.0), 275 + (int)(20.0 * this.mDc / 0.2)
      );
      g.setColor(Color.red);
      g.drawLine(470, 275 - (int)(20.0 * this.mDb / 0.2), 470 + (int)(200.0 * this.mLb / 2.0), 275 - (int)(20.0 * this.mDb / 0.2));
      g.drawLine(
         470 + (int)(200.0 * this.mLb / 2.0), 275 - (int)(20.0 * this.mDb / 0.2), 470 + (int)(200.0 * this.mLb / 2.0), 275 + (int)(20.0 * this.mDb / 0.2)
      );
      g.drawLine(470, 275 + (int)(20.0 * this.mDb / 0.2), 470 + (int)(200.0 * this.mLb / 2.0), 275 + (int)(20.0 * this.mDb / 0.2));
      g.setColor(Color.black);
      g.drawLine(20, 163, 420, 163);
      g.drawLine(20, 164, 420, 164);
      g.drawLine(19, 8, 19, 413);
      g.drawLine(20, 8, 20, 413);

      for (int p = -5; p < 5; p++) {
         for (p = -5; p < 5; p++) {
            g.drawLine(20, 163 - p * 50, 17, 163 - p * 50);
         }
      }

      for (int var12 = 1; var12 < 6; var12++) {
         g.drawLine(20 + var12 * 80, 163, 20 + var12 * 80, 160);
      }

      g.setColor(Color.red);
      this.mRecb[1] = 0.0;

      for (int var13 = 1; var13 < 400; var13++) {
         double mw = var13 * 5000.0 * 2.0 * Math.PI / 400.0;
         double mlambda = mw * Math.sqrt(3.9E-8);
         double mAreab = Math.PI * this.mDb * this.mDb / 4.0;
         if (var13 == 1) {
            this.mRecb[1] = Math.tan(mlambda * this.mLb) / (mAreab * 2.0E11 * mlambda);
         } else {
            this.mRecb[var13] = Math.tan(mlambda * this.mLb) / (mAreab * 2.0E11 * mlambda);
            if (!(this.mRecb[var13 - 1] > 0.0 & this.mRecb[var13] < 0.0) && Math.abs(this.mRecb[var13 - 1]) < 1.0E-8) {
               g.drawLine(20 + (var13 - 1), (int)(163.0 - this.mRecb[var13 - 1] * 2.5E10), 20 + var13, (int)(163.0 - this.mRecb[var13] * 2.5E10));
            }
         }
      }

      g.setColor(Color.blue);
      this.mRecc[1] = 0.0;

      for (int var14 = 1; var14 < 400; var14++) {
         double mw = var14 * 5000.0 * 2.0 * Math.PI / 400.0;
         double mlambda = mw * Math.sqrt(3.9E-8);
         double mAreac = Math.PI * this.mDc * this.mDc / 4.0;
         if (var14 == 1) {
            this.mRecc[1] = -1.0 / (mAreac * 2.0E11 * mlambda * Math.tan(mlambda * this.mLc));
         } else {
            this.mRecc[var14] = -1.0 / (mAreac * 2.0E11 * mlambda * Math.tan(mlambda * this.mLc));
            if (!(this.mRecc[var14 - 1] > 0.0 & this.mRecc[var14] < 0.0) && Math.abs(this.mRecc[var14 - 1]) < 1.0E-8) {
               g.drawLine(20 + (var14 - 1), (int)(163.0 + this.mRecc[var14 - 1] * 2.5E10), 20 + var14, (int)(163.0 + this.mRecc[var14] * 2.5E10));
            }
         }
      }

      g.setColor(Color.black);

      for (int var15 = 2; var15 < 400; var15++) {
         if (this.mRecb[var15 - 1] < -this.mRecc[var15 - 1] & this.mRecb[var15] > -this.mRecc[var15]) {
            g.drawString(CUtility.nns(var15 * 5000.0 / 400.0) + "Hz", 20 + var15 + 1, (int)(163.0 - this.mRecb[var15] * 2.5E10 + 10.0));
         }
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mLb = val;
            break;
         case 2:
            this.mDb = val;
            break;
         case 3:
            this.mLc = val;
            break;
         case 4:
            this.mDc = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

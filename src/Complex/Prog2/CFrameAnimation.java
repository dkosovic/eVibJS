package Complex.Prog2;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kmCode = 3;
   public static final double kStartL = 1.0;
   public static final double kStartD = 0.1;
   public static final double kStartm = 20.0;
   public static final double kWmax = 5000.0;
   public static final double kScale = 2.5E10;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final int kXaxis = 313;
   public static final int kXo = 20;
   double mL = 1.0;
   double mD = 0.1;
   double mm = 20.0;
   double[] mRec1;
   double[] mRec2;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mRec1 = new double[450];
      this.mRec2 = new double[450];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(20, 313, 420, 313);
      g.drawLine(20, 314, 420, 314);
      g.drawLine(19, -42, 19, 363);
      g.drawLine(20, -42, 20, 363);

      for (int p = -1; p < 7; p++) {
         g.drawLine(20, 313 - p * 50, 17, 313 - p * 50);
      }

      for (int i = 1; i < 6; i++) {
         g.drawLine(20 + i * 80, 313, 20 + i * 80, 317);
      }

      g.setColor(Color.red);
      this.mRec1[1] = 0.0;

      for (int j = 1; j < 400; j++) {
         double mw = j * 5000.0 * 2.0 * Math.PI / 400.0;
         double mlambda = mw * Math.sqrt(3.9E-8);
         double mArea = Math.PI * this.mD * this.mD / 4.0;
         if (j == 1) {
            this.mRec1[1] = Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda);
         } else {
            this.mRec1[j] = Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda);
            if (this.mRec1[j] > this.mRec1[j - 1] & Math.abs(this.mRec1[j - 1]) < 1.2E-8) {
               g.drawLine(20 + (j - 1), (int)(313.0 - this.mRec1[j - 1] * 2.5E10), 20 + j, (int)(313.0 - this.mRec1[j] * 2.5E10));
            }
         }
      }

      g.setColor(Color.blue);
      this.mRec2[1] = 0.0;

      for (int k = 1; k < 400; k++) {
         double mw = k * 5000.0 * 2.0 * Math.PI / 400.0;
         if (k == 1) {
            this.mRec2[1] = -1.0 / (this.mm * mw * mw);
         } else {
            this.mRec2[k] = -1.0 / (this.mm * mw * mw);
            if (-this.mRec2[k - 1] < 5.0E-8) {
               g.drawLine(20 + (k - 1), (int)(313.0 + this.mRec2[k - 1] * 2.5E10), 20 + k, (int)(313.0 + this.mRec2[k] * 2.5E10));
            }
         }
      }

      g.setColor(Color.black);

      for (int var12 = 2; var12 < 400; var12++) {
         if (-this.mRec2[var12 - 1] >= this.mRec1[var12 - 1] & this.mRec1[var12] >= -this.mRec2[var12]) {
            g.drawString(CUtility.nns(var12 * 5000.0 / 400.0) + "Hz", 20 + var12 + 1, (int)(313.0 - this.mRec1[var12] * 2.5E10));
         }
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mL = val;
            break;
         case 2:
            this.mD = val;
            break;
         case 3:
            this.mm = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

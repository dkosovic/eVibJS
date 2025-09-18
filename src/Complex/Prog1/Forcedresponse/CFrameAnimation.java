import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kkCode = 3;
   public static final double kStartL = 1.0;
   public static final double kStartD = 0.05;
   public static final double kStartk = 1.0E9;
   public static final double kWmax = 5000.0;
   public static final double kScale = 2.5E10;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final int kXaxis = 163;
   public static final int kXo = 20;
   double mL = 1.0;
   double mD = 0.05;
   double mk = 1.0E9;
   double[] mRec;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mRec = new double[450];
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
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

      for (int var10 = 1; var10 < 6; var10++) {
         g.drawLine(20 + var10 * 80, 163, 20 + var10 * 80, 160);
      }

      g.setColor(Color.red);
      this.mRec[1] = 0.0;

      for (int var11 = 1; var11 < 400; var11++) {
         double mw = var11 * 5000.0 * 2.0 * Math.PI / 400.0;
         double mlambda = mw * Math.sqrt(3.9E-8);
         double mArea = Math.PI * this.mD * this.mD / 4.0;
         if (var11 == 1) {
            this.mRec[1] = Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda);
         } else {
            this.mRec[var11] = Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda);
            if (!(this.mRec[var11 - 1] > 0.0 & this.mRec[var11] < 0.0) && Math.abs(this.mRec[var11 - 1]) < 1.0E-8) {
               g.drawLine(20 + (var11 - 1), (int)(163.0 - this.mRec[var11 - 1] * 2.5E10), 20 + var11, (int)(163.0 - this.mRec[var11] * 2.5E10));
            }
         }
      }

      g.setColor(Color.blue);
      g.drawLine(20, (int)(163.0 + 1.0 / this.mk * 2.5E10), 420, (int)(163.0 + 1.0 / this.mk * 2.5E10));
      g.setColor(Color.black);

      for (int var12 = 2; var12 < 400; var12++) {
         if (this.mRec[var12 - 1] < -1.0 / this.mk & this.mRec[var12] > -1.0 / this.mk) {
            g.drawString(CUtility.nns(var12 * 5000.0 / 400.0) + "Hz", 20 + var12 + 1, (int)(163.0 + 1.0 / this.mk * 2.5E10 + 10.0));
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
            this.mk = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

package OneDOF.Prog7.Forcedlocus;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kXiCode = 1;
   public static final int kWCode = 2;
   public static final double kStartXi = 0.1;
   public static final double kStartW = 0.9;
   public static final int kXo = 40;
   double[] mAmp;
   double[] mPhase;
   double mXi = 0.1;
   double mW = 0.9;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      this.mAmp = new double[302];
      this.mPhase = new double[302];
      g.setPaintMode();
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(40, 47, 40, 213);
      g.drawLine(37, 210, 343, 210);

      for (int p = 1; p < 9; p++) {
         g.drawLine(40, 210 - p * 20, 37, 210 - p * 20);
      }

      for (int i = 1; i < 7; i++) {
         g.drawLine(40 + i * 50, 210, 40 + i * 50, 213);
      }

      g.setColor(mass);
      this.mAmp[0] = 1.0;
      double mAmp1 = this.mAmp[0];

      for (int j = 1; j < 301; j++) {
         double mr = j / 100.0;
         this.mAmp[j] = 1.0 / Math.sqrt((1.0 - mr * mr) * (1.0 - mr * mr) + 2.0 * mr * this.mXi * (2.0 * mr * this.mXi));
         g.drawLine(40 + (j - 1), (int)(210.0 - mAmp1 * 20.0), 40 + j, (int)(210.0 - this.mAmp[j] * 20.0));
         mAmp1 = this.mAmp[j];
      }

      g.setColor(mass);
      this.mPhase[0] = 0.0;
      double mPhase1 = this.mPhase[0];

      for (int k = 1; k < 301; k++) {
         double mr = k / 100.0;
         this.mPhase[k] = 90.0;
         if (k != 100) {
            this.mPhase[k] = 180.0 * Math.atan(2.0 * mr * this.mXi / (1.0 - mr * mr)) / Math.PI;
            if (this.mPhase[k] < 0.0) {
               this.mPhase[k] = this.mPhase[k] + 180.0;
            }
         }

         g.drawLine(40 + (k - 1), (int)(240.0 + mPhase1 / 2.0), 40 + k, (int)(240.0 + this.mPhase[k] / 2.0));
         mPhase1 = this.mPhase[k];
         this.mPhase[k] = this.mPhase[k] * Math.PI / 180.0;
      }

      g.setColor(Color.black);
      g.drawLine(40, 237, 40, 333);
      g.drawLine(37, 240, 343, 240);

      for (int var14 = 1; var14 < 5; var14++) {
         g.drawLine(40, 240 + (int)(var14 * 22.5), 37, 240 + (int)(var14 * 22.5));
      }

      for (int var15 = 1; var15 < 7; var15++) {
         g.drawLine(40 + var15 * 50, 240, 40 + var15 * 50, 237);
      }

      int var16 = (int)(this.mW * 100.0);
      g.setColor(Color.green);
      g.drawLine(40 + var16, 241, 40 + var16, (int)(239.0 + this.mPhase[var16] * 180.0 / (Math.PI * 2)));
      int mArcRadius = (int)(this.mAmp[var16] * 20.0);
      if (mArcRadius > 26) {
         mArcRadius = 26;
      }

      g.fillArc(520 - mArcRadius, 51 - mArcRadius, mArcRadius * 2, mArcRadius * 2, 0, (int)(-this.mPhase[var16] * 180.0 / Math.PI));
      g.setColor(Color.white);
      mArcRadius -= 2;
      g.fillArc(520 - mArcRadius, 51 - mArcRadius, mArcRadius * 2, mArcRadius * 2, 0, (int)(-this.mPhase[var16] * 180.0 / Math.PI));
      g.setColor(Color.blue);
      g.drawLine(40 + var16, 209, 40 + var16, (int)(211.0 - this.mAmp[var16] * 20.0));
      g.drawLine(
         520, 50, 520 + (int)(this.mAmp[var16] * Math.cos(this.mPhase[var16]) * 20.0), 50 + (int)(this.mAmp[var16] * Math.sin(this.mPhase[var16]) * 20.0)
      );
      g.setColor(Color.black);
      g.drawLine(390, 50, 650, 50);
      g.drawLine(520, 47, 520, 313);
      g.setColor(mass);

      for (int var17 = 0; var17 < 300; var17++) {
         g.drawLine(
            520 + (int)(this.mAmp[var17] * Math.cos(this.mPhase[var17]) * 20.0),
            50 + (int)(this.mAmp[var17] * Math.sin(this.mPhase[var17]) * 20.0),
            520 + (int)(this.mAmp[var17 + 1] * Math.cos(this.mPhase[var17 + 1]) * 20.0),
            50 + (int)(this.mAmp[var17 + 1] * Math.sin(this.mPhase[var17 + 1]) * 20.0)
         );
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mXi = val;
            break;
         case 2:
            this.mW = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

package OneDOF.Prog10.OOBresponse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kXiCode = 1;
   public static final int kmrdivMCode = 2;
   public static final double kStartXi = 0.05;
   public static final double kStartmrdivM = 5.0;
   public static final int kXo = 100;
   double mXi = 0.05;
   double mrdivM = 5.0;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.black);
      g.drawLine(100, 47, 100, 213);
      g.drawLine(97, 210, 403, 210);

      for (int p = 1; p < 7; p++) {
         g.drawLine(100, 210 - p * 25, 97, 210 - p * 25);
      }

      for (int i = 1; i < 7; i++) {
         g.drawLine(100 + i * 50, 210, 100 + i * 50, 213);
      }

      g.setColor(mass);
      double mAmp1 = 0.0;

      for (int j = 1; j < 150; j++) {
         double mr = j / 50.0;
         double mAmp2 = this.mrdivM * mr * mr / Math.sqrt((1.0 - mr * mr) * (1.0 - mr * mr) + 2.0 * mr * this.mXi * (2.0 * mr * this.mXi));
         g.drawLine(100 + (j - 1) * 2, (int)(210.0 - mAmp1 * 5.0), 100 + j * 2, (int)(210.0 - mAmp2 * 5.0));
         mAmp1 = mAmp2;
      }

      g.setColor(mass);
      double mPhase1 = 0.0;
      double mPhase2 = 0.0;

      for (int k = 1; k < 150; k++) {
         double mr = k / 50.0;
         if (k == 50) {
            mPhase2 = 90.0;
         }

         if (k != 50) {
            mPhase2 = 180.0 * Math.atan(2.0 * mr * this.mXi / (1.0 - mr * mr)) / Math.PI;
            if (mPhase2 < 0.0) {
               mPhase2 += 180.0;
            }
         }

         g.drawLine(100 + (k - 1) * 2, (int)(240.0 + mPhase1 / 2.0), 100 + k * 2, (int)(240.0 + mPhase2 / 2.0));
         mPhase1 = mPhase2;
      }

      g.setColor(Color.black);
      g.drawLine(100, 237, 100, 333);
      g.drawLine(97, 240, 403, 240);

      for (int var17 = 1; var17 < 5; var17++) {
         g.drawLine(100, 240 + (int)(var17 * 22.5), 97, 240 + (int)(var17 * 22.5));
      }

      for (int var18 = 1; var18 < 7; var18++) {
         g.drawLine(100 + var18 * 50, 240, 100 + var18 * 50, 237);
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mXi = val;
            break;
         case 2:
            this.mrdivM = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }
}

import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kXiCode = 1;
   public static final double kStartXi = 0.1;
   public static final int kXo = 100;
   double mXi = 0.1;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(100, 47, 100, 213);
      g.drawLine(97, 210, 403, 210);

      for (int p = 1; p < 9; p++) {
         g.drawLine(100, 210 - p * 20, 97, 210 - p * 20);
      }

      for (int var14 = 1; var14 < 7; var14++) {
         g.drawLine(100 + var14 * 50, 210, 100 + var14 * 50, 213);
      }

      g.setColor(mass);
      double mAmp1 = 1.0;

      for (int var15 = 1; var15 < 150; var15++) {
         double mr = var15 / 50.0;
         double mAmp2 = 1.0 / Math.sqrt((1.0 - mr * mr) * (1.0 - mr * mr) + 2.0 * mr * this.mXi * (2.0 * mr * this.mXi));
         g.drawLine(100 + (var15 - 1) * 2, (int)(210.0 - mAmp1 * 20.0), 100 + var15 * 2, (int)(210.0 - mAmp2 * 20.0));
         mAmp1 = mAmp2;
      }

      double mPhase1 = 0.0;
      double mPhase2 = 0.0;

      for (int var16 = 1; var16 < 150; var16++) {
         double mr = var16 / 50.0;
         if (var16 == 50) {
            mPhase2 = 90.0;
         }

         if (var16 != 50) {
            mPhase2 = 180.0 * Math.atan(2.0 * mr * this.mXi / (1.0 - mr * mr)) / Math.PI;
            if (mPhase2 < 0.0) {
               mPhase2 += 180.0;
            }
         }

         g.drawLine(100 + (var16 - 1) * 2, (int)(240.0 + mPhase1 / 2.0), 100 + var16 * 2, (int)(240.0 + mPhase2 / 2.0));
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
         default:
            if (mustRedraw) {
               this.repaint();
            }
      }
   }
}

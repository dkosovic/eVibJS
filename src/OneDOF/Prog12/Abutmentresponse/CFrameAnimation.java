package OneDOF.Prog12.Abutmentresponse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kXiCode = 1;
   public static final double kStartXi = 0.05;
   public static final int kXo = 100;
   double mXi = 0.05;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(100, 47, 100, 213);
      g.drawLine(97, 210, 403, 210);

      for (int i = 1; i < 9; i++) {
         g.drawLine(100, 210 - i * 20, 97, 210 - i * 20);
      }

      for (int j = 1; j < 7; j++) {
         g.drawLine(100 + j * 50, 210, 100 + j * 50, 213);
      }

      Color var13 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var13);
      double var3 = 1.0;

      for (int k = 1; k < 150; k++) {
         double var11 = k / 50.0;
         double var5 = Math.sqrt(
            (1.0 + 4.0 * this.mXi * this.mXi * var11 * var11)
               / ((1.0 - var11 * var11) * (1.0 - var11 * var11) + 2.0 * var11 * this.mXi * (2.0 * var11 * this.mXi))
         );
         g.drawLine(100 + (k - 1) * 2, (int)(210.0 - var3 * 20.0), 100 + k * 2, (int)(210.0 - var5 * 20.0));
         var3 = var5;
      }

      g.setColor(var13);
      double var7 = 0.0;
      double var9 = 0.0;

      for (int var16 = 1; var16 < 150; var16++) {
         double var20 = var16 / 50.0;
         var9 = 180.0 * Math.atan(2.0 * var20 * var20 * var20 * this.mXi / (1.0 - var20 * var20 + 4.0 * this.mXi * this.mXi * var20 * var20)) / Math.PI;
         if (var9 < 0.0) {
            var9 += 180.0;
         }

         g.drawLine(100 + (var16 - 1) * 2, (int)(240.0 + var7 / 2.0), 100 + var16 * 2, (int)(240.0 + var9 / 2.0));
         var7 = var9;
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
      boolean var5 = false;
      switch (code) {
         case 1:
            this.mXi = val;
         default:
            if (var5) {
               this.repaint();
            }
      }
   }
}

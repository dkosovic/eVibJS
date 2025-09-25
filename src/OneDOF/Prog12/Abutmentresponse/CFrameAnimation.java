package OneDOF.Prog12.Abutmentresponse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kXiCode = 1;
   public static final double kStartXi = 0.05;
   public static final int kXo = 100;
   double mXi = 0.05;

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      var1.drawLine(100, 47, 100, 213);
      var1.drawLine(97, 210, 403, 210);

      for (int var2 = 1; var2 < 9; var2++) {
         var1.drawLine(100, 210 - var2 * 20, 97, 210 - var2 * 20);
      }

      for (int var14 = 1; var14 < 7; var14++) {
         var1.drawLine(100 + var14 * 50, 210, 100 + var14 * 50, 213);
      }

      Color var13 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(var13);
      double var3 = 1.0;

      for (int var15 = 1; var15 < 150; var15++) {
         double var11 = var15 / 50.0;
         double var5 = Math.sqrt(
            (1.0 + 4.0 * this.mXi * this.mXi * var11 * var11)
               / ((1.0 - var11 * var11) * (1.0 - var11 * var11) + 2.0 * var11 * this.mXi * (2.0 * var11 * this.mXi))
         );
         var1.drawLine(100 + (var15 - 1) * 2, (int)(210.0 - var3 * 20.0), 100 + var15 * 2, (int)(210.0 - var5 * 20.0));
         var3 = var5;
      }

      var1.setColor(var13);
      double var7 = 0.0;
      double var9 = 0.0;

      for (int var16 = 1; var16 < 150; var16++) {
         double var20 = var16 / 50.0;
         var9 = 180.0 * Math.atan(2.0 * var20 * var20 * var20 * this.mXi / (1.0 - var20 * var20 + 4.0 * this.mXi * this.mXi * var20 * var20)) / Math.PI;
         if (var9 < 0.0) {
            var9 += 180.0;
         }

         var1.drawLine(100 + (var16 - 1) * 2, (int)(240.0 + var7 / 2.0), 100 + var16 * 2, (int)(240.0 + var9 / 2.0));
         var7 = var9;
      }

      var1.setColor(Color.black);
      var1.drawLine(100, 237, 100, 333);
      var1.drawLine(97, 240, 403, 240);

      for (int var17 = 1; var17 < 5; var17++) {
         var1.drawLine(100, 240 + (int)(var17 * 22.5), 97, 240 + (int)(var17 * 22.5));
      }

      for (int var18 = 1; var18 < 7; var18++) {
         var1.drawLine(100 + var18 * 50, 240, 100 + var18 * 50, 237);
      }
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mXi = var3;
         default:
            if (var5) {
               this.repaint();
            }
      }
   }
}

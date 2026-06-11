package Methods.Prog1;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kk1Code = 1;
   public static final int km1Code = 2;
   public static final int kk2Code = 3;
   public static final int km2Code = 4;
   public static final double kStartk1 = 1.0;
   public static final double kStartm1 = 1.0;
   public static final double kStartk2 = 1.0;
   public static final double kStartm2 = 1.0;
   public static final int kXo = 380;
   public static final int kYo = 330;
   double mk1 = 1.0;
   double mm1 = 1.0;
   double mk2 = 1.0;
   double mm2 = 1.0;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      Color var23 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(380, 333, 380, 12);
      g.drawLine(17, 330, 403, 330);

      for (int i = 1; i < 10; i++) {
         g.drawLine(380, 330 - i * 35, 377, 330 - i * 35);
      }

      for (int j = 1; j < 21; j++) {
         g.drawLine(j * 20, 330, j * 20, 333);
      }

      g.setColor(var23);
      double var7 = -18.0;
      double var3 = Math.sqrt((this.mk1 * var7 * var7 + this.mk2 * (1.0 - var7) * (1.0 - var7)) / (this.mm1 * var7 * var7 + this.mm2));

      for (int k = 1; k < 380; k++) {
         var7 = -18.0 + k / 20.0;
         double var5 = Math.sqrt((this.mk1 * var7 * var7 + this.mk2 * (1.0 - var7) * (1.0 - var7)) / (this.mm1 * var7 * var7 + this.mm2));
         g.drawLine(20 + (k - 1), (int)(330.0 - var3 * 70.0), 20 + k, (int)(330.0 - var5 * 70.0));
         var3 = var5;
      }

      double var17 = this.mm1 * this.mm2;
      double var19 = -(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
      double var21 = this.mk1 * this.mk2;
      double var9 = Math.sqrt((-var19 - Math.sqrt(var19 * var19 - 4.0 * var17 * var21)) / (2.0 * var17));
      double var11 = Math.sqrt((-var19 + Math.sqrt(var19 * var19 - 4.0 * var17 * var21)) / (2.0 * var17));
      double var13 = this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var9 * var9);
      double var15 = this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var11 * var11);
      g.setColor(Color.blue);
      g.drawLine(380 + (int)(var13 * 20.0), 330, 380 + (int)(var13 * 20.0), 330 - (int)(var9 * 70.0));
      g.drawLine(380 + (int)(var13 * 20.0), 330 - (int)(var9 * 70.0), 400, 330 - (int)(var9 * 70.0));
      g.drawString(CUtility.nns(var9), 402, 330 - (int)(var9 * 70.0) + 5);
      g.drawString(CUtility.nns(var13), 380 + (int)(var13 * 20.0) + 2, 328);
      g.drawLine(380 + (int)(var15 * 20.0), 330, 380 + (int)(var15 * 20.0), 330 - (int)(var11 * 70.0));
      g.drawString(CUtility.nns(var11), 380 + (int)(var15 * 20.0) - 32, 330 - (int)(var11 * 70.0) - 4);
      g.drawString(CUtility.nns(var15), 380 + (int)(var15 * 20.0) - 40, 328);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 1:
            this.mk1 = val;
            break;
         case 2:
            this.mm1 = val;
            break;
         case 3:
            this.mk2 = val;
            break;
         case 4:
            this.mm2 = val;
      }

      if (var5) {
         this.repaint();
      }
   }
}

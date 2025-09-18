import java.awt.Color;
import java.awt.Graphics;

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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      var1.setPaintMode();
      Color var23 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      var1.drawLine(380, 333, 380, 12);
      var1.drawLine(17, 330, 403, 330);

      for (int var2 = 1; var2 < 10; var2++) {
         var1.drawLine(380, 330 - var2 * 35, 377, 330 - var2 * 35);
      }

      for (int var24 = 1; var24 < 21; var24++) {
         var1.drawLine(var24 * 20, 330, var24 * 20, 333);
      }

      var1.setColor(var23);
      double var7 = -18.0;
      double var3 = Math.sqrt((this.mk1 * var7 * var7 + this.mk2 * (1.0 - var7) * (1.0 - var7)) / (this.mm1 * var7 * var7 + this.mm2));

      for (int var25 = 1; var25 < 380; var25++) {
         var7 = -18.0 + var25 / 20.0;
         double var5 = Math.sqrt((this.mk1 * var7 * var7 + this.mk2 * (1.0 - var7) * (1.0 - var7)) / (this.mm1 * var7 * var7 + this.mm2));
         var1.drawLine(20 + (var25 - 1), (int)(330.0 - var3 * 70.0), 20 + var25, (int)(330.0 - var5 * 70.0));
         var3 = var5;
      }

      double var17 = this.mm1 * this.mm2;
      double var19 = -(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
      double var21 = this.mk1 * this.mk2;
      double var9 = Math.sqrt((-var19 - Math.sqrt(var19 * var19 - 4.0 * var17 * var21)) / (2.0 * var17));
      double var11 = Math.sqrt((-var19 + Math.sqrt(var19 * var19 - 4.0 * var17 * var21)) / (2.0 * var17));
      double var13 = this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var9 * var9);
      double var15 = this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var11 * var11);
      var1.setColor(Color.blue);
      var1.drawLine(380 + (int)(var13 * 20.0), 330, 380 + (int)(var13 * 20.0), 330 - (int)(var9 * 70.0));
      var1.drawLine(380 + (int)(var13 * 20.0), 330 - (int)(var9 * 70.0), 400, 330 - (int)(var9 * 70.0));
      var1.drawString(CUtility.nns(var9), 402, 330 - (int)(var9 * 70.0) + 5);
      var1.drawString(CUtility.nns(var13), 380 + (int)(var13 * 20.0) + 2, 328);
      var1.drawLine(380 + (int)(var15 * 20.0), 330, 380 + (int)(var15 * 20.0), 330 - (int)(var11 * 70.0));
      var1.drawString(CUtility.nns(var11), 380 + (int)(var15 * 20.0) - 32, 330 - (int)(var11 * 70.0) - 4);
      var1.drawString(CUtility.nns(var15), 380 + (int)(var15 * 20.0) - 40, 328);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mk1 = var3;
            break;
         case 2:
            this.mm1 = var3;
            break;
         case 3:
            this.mk2 = var3;
            break;
         case 4:
            this.mm2 = var3;
      }

      if (var5) {
         this.repaint();
      }
   }
}

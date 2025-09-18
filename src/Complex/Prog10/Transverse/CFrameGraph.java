import java.awt.Color;
import java.awt.Graphics;

class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kD1Code = 2;
   public static final int kD2Code = 3;
   public static final int kkCode = 4;
   public static final int kalphaCode = 5;
   public static final double kStartL = 1.2;
   public static final double kStartD1 = 0.15;
   public static final double kStartD2 = 0.1;
   public static final double kStartk = 1380000.0;
   public static final double kStartalpha = 0.4;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 1.0E8;
   public static final double kWmax = 200.0;
   public static final int kResponsePoints = 401;
   double[] mRec1 = new double[401];
   double[] mRec2 = new double[401];
   double[] mRec3 = new double[401];
   double mL = 1.2;
   double mD1 = 0.15;
   double mD2 = 0.1;
   double mk = 1380000.0;
   double malpha = 0.4;
   double mlambda1;
   double mlambda2;
   double mw;
   double mArea1;
   double mInertia1;
   double mArea2;
   double mInertia2;
   double mTime;

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      Color var5 = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      var1.setPaintMode();
      var1.setColor(Color.black);
      var1.drawLine(38, 370, 440, 370);
      var1.drawLine(38, 371, 440, 371);
      var1.drawLine(39, 374, 39, 15);
      var1.drawLine(40, 374, 40, 15);

      for (int var2 = 0; var2 < 8; var2++) {
         var1.drawLine(40, 370 - var2 * 50, 37, 370 - var2 * 50);
      }

      for (int var7 = 1; var7 < 5; var7++) {
         var1.drawLine(40 + var7 * 100, 370, 40 + var7 * 100, 374);
      }

      this.response();
      var1.setColor(Color.red);

      for (int var8 = 2; var8 < 400; var8++) {
         var1.drawLine(40 + (var8 - 1), (int)(370.0 - Math.abs(this.mRec1[var8 - 1] * 1.0E8)), 40 + var8, (int)(370.0 - Math.abs(this.mRec1[var8] * 1.0E8)));
      }

      var1.setColor(Color.blue);

      for (int var9 = 2; var9 < 400; var9++) {
         int var3 = (int)(370.0 - Math.abs(this.mRec2[var9 - 1] * 1.0E8));
         int var4 = (int)(370.0 - Math.abs(this.mRec2[var9] * 1.0E8));
         if (var3 > 0 & var4 > 0) {
            var1.drawLine(40 + (var9 - 1), var3, 40 + var9, var4);
         }
      }

      var1.setColor(var5);

      for (int var10 = 2; var10 < 400; var10++) {
         var1.drawLine(40 + (var10 - 1), (int)(370.0 - this.mRec3[var10 - 1] * 1.0E8), 40 + var10, (int)(370.0 - this.mRec3[var10] * 1.0E8));
      }

      var1.setColor(Color.white);
      var1.fillRect(0, 0, 440, 20);
   }

   public double log10(double var1) {
      return Math.log(var1) / Math.log(10.0);
   }

   public String nns(double var1, int var3) {
      if (var3 <= 0) {
         var3 = 1;
      }

      if (var1 == 0.0) {
         return new String("0");
      } else if (var1 < 0.0) {
         return new String("-" + this.nns(-var1, var3));
      } else {
         double var4 = Math.floor(this.log10(var1));
         double var6 = Math.pow(10.0, var4 - var3 + 1.0);
         long var8 = Math.round(var1 / var6);
         String var10 = new String(String.valueOf(var8 * var6));

         while (var10.length() > 1 && var10.indexOf(46) > -1) {
            boolean var11 = false;

            int var12;
            for (var12 = var10.length() - 1; var10.charAt(var12) == '0'; var11 = true) {
               var12--;
            }

            if (var11) {
               var10 = new String(var10.substring(0, var12 + 1));
            }

            String var13 = new String(var10.substring(0, var12));

            Double var14;
            try {
               var14 = new Double(var13);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(var1 - var14) > var6) {
               break;
            }

            var10 = var13;
         }

         return var10;
      }
   }

   public String nns(double var1) {
      return this.nns(var1, 4);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mL = var3;
            this.response();
            break;
         case 2:
            this.mD1 = var3;
            this.response();
            break;
         case 3:
            this.mD2 = var3;
            this.response();
            break;
         case 4:
            this.mk = var3;
            this.response();
            break;
         case 5:
            this.malpha = var3;
            this.response();
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea1 = Math.PI * this.mD1 * this.mD1 / 4.0;
      this.mInertia1 = this.mArea1 * this.mD1 * this.mD1 / 16.0;
      this.mArea2 = Math.PI * this.mD2 * this.mD2 / 4.0;
      this.mInertia2 = this.mArea2 * this.mD2 * this.mD2 / 16.0;

      for (int var1 = 1; var1 < 401; var1++) {
         this.mw = var1 * 200.0 * 2.0 * Math.PI / 400.0;
         this.mlambda1 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea1 * 7800.0 / (2.0E11 * this.mInertia1)));
         this.mlambda2 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea2 * 7800.0 / (2.0E11 * this.mInertia2)));
         double var14 = this.mlambda1 * this.mL;
         double var16 = this.mlambda2 * this.mL;
         double var2 = Math.sin(var14);
         double var4 = Math.cos(var14);
         double var18 = Math.exp(var14);
         double var6 = (var18 - 1.0 / var18) / 2.0;
         double var8 = (var18 + 1.0 / var18) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var20 = 1.0 / (2.0E11 * this.mInertia1 * this.mlambda1 * this.mlambda1 * this.mlambda1 * var10);
         this.mRec1[var1] = -var12 * var20;
         var2 = Math.sin(var16);
         var4 = Math.cos(var16);
         var18 = Math.exp(var16);
         var6 = (var18 - 1.0 / var18) / 2.0;
         var8 = (var18 + 1.0 / var18) / 2.0;
         var10 = var4 * var8 + 1.0;
         var12 = var4 * var6 - var2 * var8;
         var20 = 1.0 / (2.0E11 * this.mInertia2 * this.mlambda2 * this.mlambda2 * this.mlambda2 * var10);
         this.mRec2[var1] = -var12 * var20;
         double var22 = this.mRec2[var1] + 1.0 / this.mk / (1.0 + this.malpha * this.malpha);
         double var24 = -this.malpha / this.mk / (1.0 + this.malpha * this.malpha);
         double var26 = 1.0 / this.mRec1[var1] + var22 / (var22 * var22 + var24 * var24);
         double var28 = -var24 / (var22 * var22 + var24 * var24);
         this.mRec3[var1] = 1.0 / Math.sqrt(var26 * var26 + var28 * var28);
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int var1, boolean var2) {
      if (var2) {
         return false;
      } else {
         boolean var3 = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (var1) {
            case 0:
            case 1:
               double var4 = (super.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
               if (var4 > 5000.0) {
                  var4 = 5000.0;
               }

               if (var4 < 50.0) {
                  var4 = 50.0;
               }
            default:
               return true;
         }
      }
   }
}

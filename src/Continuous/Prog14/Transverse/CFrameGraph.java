package Continuous.Prog14.Transverse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kDeltaTimeCode = 3;
   public static final double kStartL = 0.7;
   public static final double kStartD = 0.15;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kG = 8.0E10;
   public static final double kDensity = 7800.0;
   public static final double kScale = 40.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[] mRec1 = new double[401];
   double[] mRec2 = new double[401];
   double mL = 0.7;
   double mD = 0.15;
   double mlambda;
   double mw;
   double mArea;
   double mInertia;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      Color var3 = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      var1.setPaintMode();
      var1.setColor(Color.black);
      var1.drawLine(38, 370, 440, 370);
      var1.drawLine(38, 371, 440, 371);
      var1.drawLine(39, 374, 39, 10);
      var1.drawLine(40, 374, 40, 10);

      for (int var2 = 0; var2 < 12; var2++) {
         var1.drawLine(40, 370 - var2 * 40, 37, 370 - var2 * 40);
      }

      for (int var5 = 1; var5 < 6; var5++) {
         var1.drawLine(40 + var5 * 80, 370, 40 + var5 * 80, 367);
      }

      var1.setColor(var3);
      this.response();

      for (int var6 = 2; var6 < 400; var6++) {
         var1.drawLine(
            40 + (var6 - 1),
            (int)(-150.0 - Math.log(Math.abs(this.mRec1[var6 - 1])) / Math.log(10.0) * 40.0),
            40 + var6,
            (int)(-150.0 - Math.log(Math.abs(this.mRec1[var6])) / Math.log(10.0) * 40.0)
         );
      }

      var1.setColor(Color.red);

      for (int var7 = 2; var7 < 400; var7++) {
         var1.drawLine(
            40 + (var7 - 1),
            (int)(-150.0 - Math.log(Math.abs(this.mRec2[var7 - 1])) / Math.log(10.0) * 40.0),
            40 + var7,
            (int)(-150.0 - Math.log(Math.abs(this.mRec2[var7])) / Math.log(10.0) * 40.0)
         );
      }

      var1.setColor(Color.orange);
      var1.fillRect(20, 425, 30, 100);
      var1.setColor(var3);
      var1.drawLine(50, 475 - (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 - (int)(250.0 * this.mD / 2.0));
      var1.drawLine(50 + (int)(250.0 * this.mL), 475 - (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 + (int)(250.0 * this.mD / 2.0));
      var1.drawLine(50, 475 + (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 + (int)(250.0 * this.mD / 2.0));
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

            double var14;
            try {
               var14 = java.lang.Double.parseDouble(var13);
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
            this.mD = var3;
            this.response();
            break;
         case 3:
            this.mTime += var3;
            var5 = true;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea = Math.PI * this.mD * this.mD / 4.0;
      this.mInertia = this.mArea * this.mD * this.mD / 16.0;

      for (int var1 = 1; var1 < 401; var1++) {
         this.mw = var1 * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double var14 = this.mlambda * this.mL;
         double var2 = Math.sin(var14);
         double var4 = Math.cos(var14);
         double var16 = Math.exp(var14);
         double var6 = (var16 - 1.0 / var16) / 2.0;
         double var8 = (var16 + 1.0 / var16) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var18 = 1.0 / (2.0E11 * this.mInertia * this.mlambda * this.mlambda * this.mlambda * var10);
         this.mRec1[var1] = -var12 * var18;
      }

      for (int var118 = 1; var118 < 401; var118++) {
         this.mw = var118 * 5000.0 * 2.0 * Math.PI / 400.0;
         double var80 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double var102;
         double var104;
         double var112;
         double var114;
         double var116;
         if (this.mw < Math.sqrt(var80 * 8.0E10 * this.mArea / (7800.0 * this.mInertia))) {
            double var60 = this.mw * this.mw;
            double var64 = 7800.0 * this.mInertia * var60;
            double var62 = 2.0E11 / (var80 * 8.0E10);
            double var66 = 1.0 / (4.0E11 * this.mInertia);
            double var76 = var64 * (1.0 + var62);
            double var78 = Math.sqrt(var64 * (var64 * (1.0 - var62) * (1.0 - var62) + 8.0E11 * this.mArea));
            double var26 = Math.sqrt((-var76 + var78) * var66);
            double var28 = Math.sqrt((var76 + var78) * var66);
            var76 = 7800.0 * var60 / (var80 * 8.0E10);
            double var22 = var76 / var28 - var28;
            double var24 = var76 / var26 + var26;
            double var48 = Math.sin(var28 * this.mL);
            double var54 = Math.cos(var28 * this.mL);
            double var119 = Math.exp(var26 * this.mL);
            double var50 = (var119 - 1.0 / var119) / 2.0;
            double var56 = (var119 + 1.0 / var119) / 2.0;
            double var30 = var48 * var50;
            double var32 = var54 * var56;
            double var34 = var32 - 1.0;
            double var36 = var48 * var56;
            double var38 = var54 * var50;
            double var40 = var54 - var56;
            double var72 = var24 * var26;
            double var74 = var72 * var26;
            double var68 = var22 * var28;
            double var70 = var68 * var28;
            double var20 = 1.0 / (7800.0 * var60 * this.mArea * (2.0 - 2.0 * var32 + (var74 / var70 - var70 / var74) * var30));
            var76 = var74 / var68 - var26;
            var78 = var70 / var72 - var28;
            double var98 = -(var38 * var76 - var36 * var78) * var20;
            double var100 = (var30 * (var70 / var26 - var74 / var28) + var34 * (var68 + var72)) * var20;
            var102 = -(var50 * var76 - var48 * var78) * var20;
            var104 = var40 * (var72 - var68) * var20;
            double var106 = -(var36 * var72 * (var72 / var28 - var22) + var38 * var68 * (var68 / var26 - var24)) * var20;
            var112 = var98;
            var114 = -var100;
            var116 = var106;
         } else {
            double var134 = this.mw * this.mw;
            double var136 = 7800.0 * this.mInertia * var134;
            double var135 = 2.0E11 / (var80 * 8.0E10);
            double var137 = 1.0 / (4.0E11 * this.mInertia);
            double var144 = var136 * (1.0 + var135);
            double var148 = Math.sqrt(var136 * (var136 * (1.0 - var135) * (1.0 - var135) + 8.0E11 * this.mArea));
            double var124 = Math.sqrt((var144 - var148) * var137);
            double var125 = Math.sqrt((var144 + var148) * var137);
            var144 = 7800.0 * var134 / (var80 * 8.0E10);
            double var122 = var144 / var125 - var125;
            double var123 = var144 / var124 - var124;
            double var132 = Math.sin(var125 * this.mL);
            double var133 = Math.cos(var125 * this.mL);
            double var52 = Math.sin(var124 * this.mL);
            double var58 = Math.cos(var124 * this.mL);
            double var126 = var132 * var52;
            double var127 = var133 * var58;
            double var128 = var127 - 1.0;
            double var129 = var132 * var58;
            double var130 = var133 * var52;
            double var131 = var58 - var133;
            double var140 = var123 * var124;
            double var141 = var140 * var124;
            double var138 = var122 * var125;
            double var139 = var138 * var125;
            double var120 = 1.0 / (7800.0 * var134 * this.mArea * (2.0 - 2.0 * var127 - (var141 / var139 + var139 / var141) * var126));
            var144 = var141 / var138 - var124;
            var148 = var139 / var140 - var125;
            double var150 = (var130 * var144 + var129 * var148) * var120;
            double var151 = (var126 * (var139 / var124 + var141 / var125) + var128 * (var138 + var140)) * var120;
            var102 = (var52 * var144 + var132 * var148) * var120;
            var104 = -var131 * (var140 - var138) * var120;
            double var152 = (var129 * var140 * (var122 - var140 / var125) + var130 * var138 * (var123 - var138 / var124)) * var120;
            var112 = var150;
            var114 = -var151;
            var116 = var152;
         }

         double var121 = var112 * var116 - var114 * var114;
         this.mRec2[var118] = var112 + (var102 * (var104 * var114 - var102 * var116) + var104 * (var102 * var114 - var104 * var112)) / var121;
      }
   }

   public double GetTime() {
      return this.mTime;
   }
}

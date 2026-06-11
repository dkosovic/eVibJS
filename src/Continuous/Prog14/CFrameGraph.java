package Continuous.Prog14;

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

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(38, 370, 440, 370);
      g.drawLine(38, 371, 440, 371);
      g.drawLine(39, 374, 39, 10);
      g.drawLine(40, 374, 40, 10);

      for (int i = 0; i < 12; i++) {
         g.drawLine(40, 370 - i * 40, 37, 370 - i * 40);
      }

      for (int j = 1; j < 6; j++) {
         g.drawLine(40 + j * 80, 370, 40 + j * 80, 367);
      }

      g.setColor(tealColor);
      this.response();

      for (int k = 2; k < 400; k++) {
         g.drawLine(
            40 + (k - 1),
            (int)(-150.0 - Math.log(Math.abs(this.mRec1[k - 1])) / Math.log(10.0) * 40.0),
            40 + k,
            (int)(-150.0 - Math.log(Math.abs(this.mRec1[k])) / Math.log(10.0) * 40.0)
         );
      }

      g.setColor(Color.red);

      for (int var7 = 2; var7 < 400; var7++) {
         g.drawLine(
            40 + (var7 - 1),
            (int)(-150.0 - Math.log(Math.abs(this.mRec2[var7 - 1])) / Math.log(10.0) * 40.0),
            40 + var7,
            (int)(-150.0 - Math.log(Math.abs(this.mRec2[var7])) / Math.log(10.0) * 40.0)
         );
      }

      g.setColor(Color.orange);
      g.fillRect(20, 425, 30, 100);
      g.setColor(tealColor);
      g.drawLine(50, 475 - (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 - (int)(250.0 * this.mD / 2.0));
      g.drawLine(50 + (int)(250.0 * this.mL), 475 - (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 + (int)(250.0 * this.mD / 2.0));
      g.drawLine(50, 475 + (int)(250.0 * this.mD / 2.0), 50 + (int)(250.0 * this.mL), 475 + (int)(250.0 * this.mD / 2.0));
   }

   public double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + this.nns(-arg, sig);
      } else {
         double magnitude = Math.floor(this.log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long intArg = Math.round(arg / stepSize);
         String result = String.valueOf(intArg * stepSize);

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int trimIdx;
            for (trimIdx = result.length() - 1; result.charAt(trimIdx) == '0'; trimmed = true) {
               trimIdx--;
            }

            if (trimmed) {
               result = result.substring(0, trimIdx + 1);
            }

            String shortStr = result.substring(0, trimIdx);

            double parsedDouble;
            try {
               parsedDouble = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - parsedDouble) > stepSize) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean trimmed = false;
      switch (code) {
         case 1:
            this.mL = val;
            this.response();
            break;
         case 2:
            this.mD = val;
            this.response();
            break;
         case 3:
            this.mTime += val;
            trimmed = true;
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea = Math.PI * this.mD * this.mD / 4.0;
      this.mInertia = this.mArea * this.mD * this.mD / 16.0;

      for (int i = 1; i < 401; i++) {
         this.mw = i * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double A = this.mlambda * this.mL;
         double var2 = Math.sin(A);
         double var4 = Math.cos(A);
         double var16 = Math.exp(A);
         double var6 = (var16 - 1.0 / var16) / 2.0;
         double var8 = (var16 + 1.0 / var16) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var18 = 1.0 / (2.0E11 * this.mInertia * this.mlambda * this.mlambda * this.mlambda * var10);
         this.mRec1[i] = -var12 * var18;
      }

      for (int j = 1; j < 401; j++) {
         this.mw = j * 5000.0 * 2.0 * Math.PI / 400.0;
         double var80 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double parsedDouble;
         double parsedDouble2;
         double parsedDouble3;
         double parsedDouble4;
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
            parsedDouble = -(var50 * var76 - var48 * var78) * var20;
            parsedDouble2 = var40 * (var72 - var68) * var20;
            double var106 = -(var36 * var72 * (var72 / var28 - var22) + var38 * var68 * (var68 / var26 - var24)) * var20;
            parsedDouble3 = var98;
            parsedDouble4 = -var100;
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
            parsedDouble = (var52 * var144 + var132 * var148) * var120;
            parsedDouble2 = -var131 * (var140 - var138) * var120;
            double var152 = (var129 * var140 * (var122 - var140 / var125) + var130 * var138 * (var123 - var138 / var124)) * var120;
            parsedDouble3 = var150;
            parsedDouble4 = -var151;
            var116 = var152;
         }

         double var121 = parsedDouble3 * var116 - parsedDouble4 * parsedDouble4;
         this.mRec2[j] = parsedDouble3 + (parsedDouble * (parsedDouble2 * parsedDouble4 - parsedDouble * var116) + parsedDouble2 * (parsedDouble * parsedDouble4 - parsedDouble2 * parsedDouble3)) / var121;
      }
   }

   public double GetTime() {
      return this.mTime;
   }
}

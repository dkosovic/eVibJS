package Complex.Prog10.Transverse;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
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
      g.drawLine(39, 374, 39, 15);
      g.drawLine(40, 374, 40, 15);

      for (int i = 0; i < 8; i++) {
         g.drawLine(40, 370 - i * 50, 37, 370 - i * 50);
      }

      for (int j = 1; j < 5; j++) {
         g.drawLine(40 + j * 100, 370, 40 + j * 100, 374);
      }

      this.response();
      g.setColor(Color.red);

      for (int k = 2; k < 400; k++) {
         g.drawLine(40 + (k - 1), (int)(370.0 - Math.abs(this.mRec1[k - 1] * 1.0E8)), 40 + k, (int)(370.0 - Math.abs(this.mRec1[k] * 1.0E8)));
      }

      g.setColor(Color.blue);

      for (int var9 = 2; var9 < 400; var9++) {
         int var3 = (int)(370.0 - Math.abs(this.mRec2[var9 - 1] * 1.0E8));
         int var4 = (int)(370.0 - Math.abs(this.mRec2[var9] * 1.0E8));
         if (var3 > 0 & var4 > 0) {
            g.drawLine(40 + (var9 - 1), var3, 40 + var9, var4);
         }
      }

      g.setColor(tealColor);

      for (int var10 = 2; var10 < 400; var10++) {
         g.drawLine(40 + (var10 - 1), (int)(370.0 - this.mRec3[var10 - 1] * 1.0E8), 40 + var10, (int)(370.0 - this.mRec3[var10] * 1.0E8));
      }

      g.setColor(Color.white);
      g.fillRect(0, 0, 440, 20);
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
            this.mD1 = val;
            this.response();
            break;
         case 3:
            this.mD2 = val;
            this.response();
            break;
         case 4:
            this.mk = val;
            this.response();
            break;
         case 5:
            this.malpha = val;
            this.response();
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea1 = Math.PI * this.mD1 * this.mD1 / 4.0;
      this.mInertia1 = this.mArea1 * this.mD1 * this.mD1 / 16.0;
      this.mArea2 = Math.PI * this.mD2 * this.mD2 / 4.0;
      this.mInertia2 = this.mArea2 * this.mD2 * this.mD2 / 16.0;

      for (int i = 1; i < 401; i++) {
         this.mw = i * 200.0 * 2.0 * Math.PI / 400.0;
         this.mlambda1 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea1 * 7800.0 / (2.0E11 * this.mInertia1)));
         this.mlambda2 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea2 * 7800.0 / (2.0E11 * this.mInertia2)));
         double A = this.mlambda1 * this.mL;
         double var16 = this.mlambda2 * this.mL;
         double var2 = Math.sin(A);
         double var4 = Math.cos(A);
         double var18 = Math.exp(A);
         double var6 = (var18 - 1.0 / var18) / 2.0;
         double var8 = (var18 + 1.0 / var18) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var20 = 1.0 / (2.0E11 * this.mInertia1 * this.mlambda1 * this.mlambda1 * this.mlambda1 * var10);
         this.mRec1[i] = -var12 * var20;
         var2 = Math.sin(var16);
         var4 = Math.cos(var16);
         var18 = Math.exp(var16);
         var6 = (var18 - 1.0 / var18) / 2.0;
         var8 = (var18 + 1.0 / var18) / 2.0;
         var10 = var4 * var8 + 1.0;
         var12 = var4 * var6 - var2 * var8;
         var20 = 1.0 / (2.0E11 * this.mInertia2 * this.mlambda2 * this.mlambda2 * this.mlambda2 * var10);
         this.mRec2[i] = -var12 * var20;
         double var22 = this.mRec2[i] + 1.0 / this.mk / (1.0 + this.malpha * this.malpha);
         double var24 = -this.malpha / this.mk / (1.0 + this.malpha * this.malpha);
         double var26 = 1.0 / this.mRec1[i] + var22 / (var22 * var22 + var24 * var24);
         double mQuad = -var24 / (var22 * var22 + var24 * var24);
         this.mRec3[i] = 1.0 / Math.sqrt(var26 * var26 + mQuad * mQuad);
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevh1t) {
      if (prevh1t) {
         return false;
      } else {
         // boolean hit = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (code) {
            case 0:
            case 1:
               double newOmega = (super.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
               if (newOmega > 5000.0) {
                  newOmega = 5000.0;
               }

               if (newOmega < 50.0) {
                  newOmega = 50.0;
               }
            default:
               return true;
         }
      }
   }
}

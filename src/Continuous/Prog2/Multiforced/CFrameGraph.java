package Continuous.Prog2.Multiforced;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kDCode = 2;
   public static final int kWanimateCode = 3;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 2.0;
   public static final double kStartD = 0.2;
   public static final double kStartEta = 0.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 20.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[][] mRec = new double[401][2];
   double[] mResponse = new double[401];
   double[][] mxp = new double[31][2];
   double mL = 2.0;
   double mD = 0.2;
   double mWanimate;
   double mEta = 0.0;
   double mlambda;
   double mw;
   double mArea;
   double mXi;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(40, 370, 440, 370);
      g.drawLine(40, 371, 440, 371);
      g.drawLine(39, 30, 39, 375);
      g.drawLine(40, 30, 40, 375);
      double var3 = 1.0E-5;

      for (int i = 1; i < 8; i++) {
         var3 /= 10.0;
         g.drawLine(40, (int)(-220.0 - Math.log(var3) * 20.0), 37, (int)(-220.0 - Math.log(var3) * 20.0));
      }

      for (int j = 1; j < 6; j++) {
         g.drawLine(40 + j * 80, 370, 40 + j * 80, 374);
      }

      g.setColor(tealColor);
      this.response();

      for (int k = 2; k < 400; k++) {
         g.drawLine(
            40 + (k - 1), (int)(-220.0 - Math.log(this.mResponse[k - 1]) * 20.0), 40 + k, (int)(-220.0 - Math.log(this.mResponse[k]) * 20.0)
         );
      }
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
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.mTime += val;
            trimmed = true;
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      for (int i = 1; i < 401; i++) {
         this.mw = i * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = this.mw * Math.sqrt(3.9E-8);
         this.mArea = Math.PI * this.mD * this.mD / 4.0;
         double var2 = Math.sqrt(1.0 + this.mEta * this.mEta);
         double var4 = Math.sqrt((var2 + 1.0) / 2.0) / var2;
         double var6 = -Math.sqrt((var2 - 1.0) / 2.0) / var2;
         double var12 = (Math.exp(this.mlambda * var6 * this.mL) - Math.exp(-this.mlambda * var6 * this.mL)) / 2.0;
         double var14 = (Math.exp(this.mlambda * var6 * this.mL) + Math.exp(-this.mlambda * var6 * this.mL)) / 2.0;
         double var8 = Math.cos(this.mlambda * var4 * this.mL) * var12 * (var6 + this.mEta * var4)
            + (this.mEta * var6 - var4) * Math.sin(this.mlambda * var4 * this.mL) * var14;
         var8 = var8 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         double var10 = Math.cos(this.mlambda * var4 * this.mL) * var12 * (this.mEta * var6 - var4)
            - (var6 + this.mEta * var4) * Math.sin(this.mlambda * var4 * this.mL) * var14;
         var10 = var10 * 2.0 * 2.0E11 * this.mArea * this.mlambda;
         var2 = 2.0 / (var8 * var8 + var10 * var10);
         this.mRec[i][0] = var2 * (var8 * var14 * Math.cos(this.mlambda * var4 * this.mL) - var10 * var12 * Math.sin(this.mlambda * var4 * this.mL));
         this.mRec[i][1] = -var2 * (var8 * var12 * Math.sin(this.mlambda * var4 * this.mL) + var10 * var14 * Math.cos(this.mlambda * var4 * this.mL));
         this.mResponse[i] = Math.sqrt(this.mRec[i][0] * this.mRec[i][0] + this.mRec[i][1] * this.mRec[i][1]);
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
               double newOmega = (super.mFramePanel.mThisPt.x - 40) * 5000.0 / 400.0;
               if (newOmega > 5000.0) {
                  newOmega = 5000.0;
               }

               if (newOmega < 50.0) {
                  newOmega = 50.0;
               }

               this.ControlMessage(this, 3, newOmega);
            default:
               return true;
         }
      }
   }
}

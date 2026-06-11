package MultiDOF.Prog3.Multiforced;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kWanimateCode = 1;
   public static final int kDeltaTimeCode = 2;
   public static final int kmCode = 3;
   public static final int kk1Code = 4;
   public static final int kk2Code = 5;
   public static final int kbCode = 6;
   public static final int kcCode = 7;
   public static final int kdCode = 8;
   public static final int km3Code = 9;
   public static final int kk3Code = 10;
   public static final double kStartm = 1.0;
   public static final double kStartk1 = 10.0;
   public static final double kStartk2 = 10.0;
   public static final double kStartb = 0.3;
   public static final double kStartc = 0.6;
   public static final double kStartd = 0.8;
   public static final double kStartm3 = 0.5;
   public static final double kStartk3 = 10.0;
   public static final double kStartWanimate = 2.0;
   public static final int kXo = 40;
   public static final int kYo = 340;
   public static final int kXdia = 480;
   public static final int kYdia = 100;
   public static final double kScale = 45.0;
   public static final double kWmax = 8.0;
   public static final int kResponsePoints = 481;
   double[] mRec = new double[481];
   double[][] mAmp = new double[4][3];
   double mWanimate = 2.0;
   double mm = 1.0;
   double mk1 = 10.0;
   double mk2 = 10.0;
   double mb = 0.3;
   double mc = 0.6;
   double md = 0.8;
   double mm3 = 0.5;
   double mk3 = 10.0;
   double mW;
   double mWmin;
   double mWmax;
   int mxpower;
   int mypower;
   double myscale;
   double mReal;
   double mImag;
   double mBeta12Real;
   double mBeta12Imag;
   double mBeta13Real;
   double mBeta13Imag;
   double mBeta23Real;
   double mBeta23Imag;
   double mBeta33Real;
   double mBeta33Imag;
   double mBetaL1Real;
   double mBetaL1Imag;
   double mBetaR1Real;
   double mBetaR1Imag;
   double mBetaL2Real;
   double mBetaL2Imag;
   double mBetaR2Real;
   double mBetaR2Imag;
   double mBetaL3Real;
   double mBetaL3Imag;
   double mBetaR3Real;
   double mBetaR3Imag;
   double mGamma33Real;
   double mGamma33Imag;
   double mAlpha12Real;
   double mAlpha12Imag;
   double mXLReal;
   double mXLImag;
   double mXRReal;
   double mXRImag;
   double mX3Real;
   double mX3Imag;
   double mTime = 0.0;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      Color orangeColor = new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.black);
      g.drawLine(37, 340, 523, 340);

      for (int i = 1; i < 9; i++) {
         g.drawLine(40 + i * 60, 340, 40 + i * 60, 343);
      }

      g.setColor(Color.black);
      g.drawLine(40, 67, 40, 342);

      for (int j = 0; j < 7; j++) {
         g.drawLine(40, 340 - j * 45, 37, 340 - j * 45);
      }

      g.setColor(orangeColor);
      g.drawLine(513 + (int)(190.0 * this.mb) - 2, 145, 513 + (int)(190.0 * this.mb) - 2, 146);
      g.drawLine(513 + (int)(190.0 * this.mb) - 1, 110, 513 + (int)(190.0 * this.mb) - 1, 148);
      g.drawLine(513 + (int)(190.0 * this.mb), 110, 513 + (int)(190.0 * this.mb), 150);
      g.drawLine(513 + (int)(190.0 * this.mb) + 1, 110, 513 + (int)(190.0 * this.mb) + 1, 148);
      g.drawLine(513 + (int)(190.0 * this.mb) + 2, 145, 513 + (int)(190.0 * this.mb) + 2, 146);
      g.setColor(Color.black);
      g.drawString("F", 517 + (int)(190.0 * this.mb), 130);
      g.setColor(tealColor);
      g.drawLine(513 + (int)(190.0 * this.mc) - 2, 125, 513 + (int)(190.0 * this.mc) - 2, 126);
      g.drawLine(513 + (int)(190.0 * this.mc) - 1, 110, 513 + (int)(190.0 * this.mc) - 1, 128);
      g.drawLine(513 + (int)(190.0 * this.mc), 110, 513 + (int)(190.0 * this.mc), 130);
      g.drawLine(513 + (int)(190.0 * this.mc) + 1, 110, 513 + (int)(190.0 * this.mc) + 1, 128);
      g.drawLine(513 + (int)(190.0 * this.mc) + 2, 125, 513 + (int)(190.0 * this.mc) + 2, 126);
      g.setColor(Color.black);
      g.drawString("X", 519 + (int)(190.0 * this.mc), 125);
      g.drawLine(513 + (int)(189.0 * this.md) + 3, 102, 513 + (int)(189.0 * this.md), 105);
      g.drawLine(513 + (int)(189.0 * this.md) - 3, 96, 513 + (int)(189.0 * this.md) + 3, 102);
      g.drawLine(513 + (int)(189.0 * this.md) + 3, 90, 513 + (int)(189.0 * this.md) - 3, 96);
      g.drawLine(513 + (int)(189.0 * this.md) - 3, 84, 513 + (int)(189.0 * this.md) + 3, 90);
      g.drawLine(513 + (int)(189.0 * this.md), 81, 513 + (int)(189.0 * this.md) - 3, 84);
      g.setColor(tealColor);
      g.fillRect(513 + (int)(189.0 * this.md) - 10, 71, 20, 10);
      g.setColor(Color.black);
      g.drawString("m3", 513 + (int)(189.0 * this.md) + 12, 79);
      g.drawString("k3", 513 + (int)(189.0 * this.md) + 6, 95);
      g.setColor(tealColor);
      this.response();

      for (int k = 2; k < 480; k++) {
         g.drawLine(
            40 + (k - 1),
            (int)(115.0 - Math.log(this.mRec[k - 1]) / Math.log(10.0) * 45.0),
            40 + k,
            (int)(115.0 - Math.log(this.mRec[k]) / Math.log(10.0) * 45.0)
         );
      }

      int animatePixel = (int)(this.mWanimate * 480.0 / 8.0);
      g.setColor(Color.blue);
      g.drawLine(40 + animatePixel, 340, 40 + animatePixel, (int)(115.0 - Math.log(this.mRec[animatePixel]) / Math.log(10.0) * 45.0));
      g.drawString(this.nns(this.mWanimate) + " Hz", 40 + animatePixel + 2, 337);
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
      }

      if (arg < 0.0) {
         return "-" + this.nns(-arg, sig);
      }

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

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      var1.setColor(Color.white);
      int xo = 40;
      short yBase = 535;
      int blockH = 20;
      short xSpan = 450;
      short yRef = 455;
      Color tealColor = new Color(0.18F, 0.58F, 0.58F);
      Color orangeColor = new Color(0.77F, 0.38F, 0.0F);
      this.setOmegaDisp(this.mWanimate);
      double cosT = Math.cos((Math.PI * 2) * this.mTime);
      double negSinT = -Math.sin((Math.PI * 2) * this.mTime);
      int disp1 = (int)(this.mAmp[1][1] * cosT + this.mAmp[1][2] * negSinT);
      int disp2 = (int)(this.mAmp[2][1] * cosT + this.mAmp[2][2] * negSinT);
      int disp3 = (int)(this.mAmp[3][1] * cosT + this.mAmp[3][2] * negSinT);
      int interpDisp = (int)(disp1 + (disp2 - disp1) * this.md);
      var1.setColor(Color.orange);
      var1.fillRect(xo - 10, yBase, xSpan + 20, blockH);
      var1.setColor(Color.black);
      double spring1Scale = (yRef + 2 + disp1 - yBase) / 10.0;
      var1.drawLine(xo, yBase, xo - 6, (int)(yBase + spring1Scale / 2.0));

      for (int i = 1; i < 10; i++) {
         if (i % 2 == 0) {
            var1.drawLine(xo + 6, (int)(yBase + (2 * i - 1) * spring1Scale / 2.0), xo - 6, (int)(yBase + (2 * i + 1) * spring1Scale / 2.0));
         } else {
            var1.drawLine(xo - 6, (int)(yBase + (2 * i - 1) * spring1Scale / 2.0), xo + 6, (int)(yBase + (2 * i + 1) * spring1Scale / 2.0));
         }
      }

      var1.drawLine(xo + 6, (int)(yBase + 19.0 * spring1Scale / 2.0), xo, yRef + disp1 + 2);
      var1.setColor(Color.black);
      double spring1Scale2 = (yRef + 2 + disp2 - yBase) / 10.0;
      var1.drawLine(xo + xSpan, yBase, xo + xSpan - 6, (int)(yBase + spring1Scale2 / 2.0));

      for (int j = 1; j < 10; j++) {
         if (j % 2 == 0) {
            var1.drawLine(xo + xSpan + 6, (int)(yBase + (2 * j - 1) * spring1Scale2 / 2.0), xo + xSpan - 6, (int)(yBase + (2 * j + 1) * spring1Scale2 / 2.0));
         } else {
            var1.drawLine(xo + xSpan - 6, (int)(yBase + (2 * j - 1) * spring1Scale2 / 2.0), xo + xSpan + 6, (int)(yBase + (2 * j + 1) * spring1Scale2 / 2.0));
         }
      }

      var1.drawLine(xo + xSpan + 6, (int)(yBase + 19.0 * spring1Scale2 / 2.0), xo + xSpan, yRef + disp2 + 2);
      var1.setColor(tealColor);
      var1.drawLine(xo, yRef + disp1 + 1, xo + xSpan, yRef + disp2 + 1);
      var1.drawLine(xo, yRef + disp1, xo + xSpan, yRef + disp2);
      var1.drawLine(xo, yRef + disp1 - 1, xo + xSpan, yRef + disp2 - 1);
      var1.setColor(tealColor);
      var1.fillRect(xo + (int)(xSpan * this.md) - 10, yRef - 61 + disp3, 20, 10);
      var1.setColor(Color.black);
      double spring3Scale = (50 + interpDisp - disp3) / 10.0;
      var1.drawLine(xo + (int)(xSpan * this.md), yRef - 51 + disp3, xo + (int)(xSpan * this.md) - 6, (int)(yRef - 51 + disp3 + spring3Scale / 2.0));

      for (int k = 1; k < 10; k++) {
         if (k % 2 == 0) {
            var1.drawLine(
               xo + (int)(xSpan * this.md) + 6,
               (int)(yRef - 51 + disp3 + (2 * k - 1) * spring3Scale / 2.0),
               xo + (int)(xSpan * this.md) - 6,
               (int)(yRef - 51 + disp3 + (2 * k + 1) * spring3Scale / 2.0)
            );
         } else {
            var1.drawLine(
               xo + (int)(xSpan * this.md) - 6,
               (int)(yRef - 51 + disp3 + (2 * k - 1) * spring3Scale / 2.0),
               xo + (int)(xSpan * this.md) + 6,
               (int)(yRef - 51 + disp3 + (2 * k + 1) * spring3Scale / 2.0)
            );
         }
      }

      var1.drawLine(xo + (int)(xSpan * this.md) + 6, (int)(yRef - 51 + disp3 + 19.0 * spring3Scale / 2.0), xo + (int)(xSpan * this.md), yRef - 1 + interpDisp);
      int forcePixels = (int)(50.0 * Math.cos((Math.PI * 2) * this.mTime));
      var1.setColor(orangeColor);
      if (forcePixels != 0) {
         if (forcePixels > 0) {
            var1.drawLine(
               xo + (int)(xSpan * this.mb) - 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb) - 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels - 1
            );
            var1.drawLine(
               xo + (int)(xSpan * this.mb),
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb),
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels
            );
            var1.drawLine(
               xo + (int)(xSpan * this.mb) + 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb) + 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels - 1
            );
         }

         if (forcePixels < 0) {
            var1.drawLine(
               xo + (int)(xSpan * this.mb) - 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb) - 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels + 1
            );
            var1.drawLine(
               xo + (int)(xSpan * this.mb),
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb),
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels
            );
            var1.drawLine(
               xo + (int)(xSpan * this.mb) + 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)),
               xo + (int)(xSpan * this.mb) + 1,
               yRef + disp1 + (int)(this.mb * (disp2 - disp1)) + forcePixels + 1
            );
         }
      }

      var1.setColor(tealColor);
      var1.drawLine(
         xo + (int)(xSpan * this.mc),
         yRef + disp1 + (int)(this.mc * (disp2 - disp1)) - 4,
         xo + (int)(xSpan * this.mc),
         yRef + disp1 + (int)(this.mc * (disp2 - disp1)) + 4
      );
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean trimmed = false;
      switch (code) {
         case 1:
            this.mWanimate = val;
            this.setOmegaDisp(this.mWanimate);
            trimmed = true;
            break;
         case 2:
            this.mTime += val;
            trimmed = true;
            break;
         case 3:
            this.mm = val;
            break;
         case 4:
            this.mk1 = val;
            break;
         case 5:
            this.mk2 = val;
            break;
         case 6:
            this.mb = val;
            break;
         case 7:
            this.mc = val;
            break;
         case 8:
            this.md = val;
            break;
         case 9:
            this.mm3 = val;
            break;
         case 10:
            this.mk3 = val;
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      for (int i = 1; i < 481; i++) {
         double omega = (Math.PI * 2) * i * 8.0 / 481.0;
         this.receptance(omega);
         this.mRec[i] = Math.sqrt(this.mAlpha12Real * this.mAlpha12Real + this.mAlpha12Imag * this.mAlpha12Imag);
      }
   }

   public void receptance(double var1) {
      double var3 = 12.0 * this.mk2 * (1.0 - this.mb) - this.mm * var1 * var1 * (4.0 - 6.0 * this.mb);
      double var5 = 0.0;
      double denReal = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      double var9 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaL1Real = this.mReal;
      this.mBetaL1Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.mb + this.mm * var1 * var1 * (2.0 - 6.0 * this.mb);
      var5 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaR1Real = this.mReal;
      this.mBetaR1Imag = this.mImag;
      this.mBeta12Real = (1.0 - this.mc) * this.mBetaL1Real + this.mc * this.mBetaR1Real;
      this.mBeta12Imag = (1.0 - this.mc) * this.mBetaL1Imag + this.mc * this.mBetaR1Imag;
      this.mBeta13Real = (1.0 - this.md) * this.mBetaL1Real + this.md * this.mBetaR1Real;
      this.mBeta13Imag = (1.0 - this.md) * this.mBetaL1Imag + this.md * this.mBetaR1Imag;
      var3 = 12.0 * this.mk2 * (1.0 - this.mc) - this.mm * var1 * var1 * (4.0 - 6.0 * this.mc);
      var5 = 0.0;
      denReal = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      var9 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaL2Real = this.mReal;
      this.mBetaL2Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.mc + this.mm * var1 * var1 * (2.0 - 6.0 * this.mc);
      var5 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaR2Real = this.mReal;
      this.mBetaR2Imag = this.mImag;
      this.mBeta23Real = (1.0 - this.md) * this.mBetaL2Real + this.md * this.mBetaR2Real;
      this.mBeta23Imag = (1.0 - this.md) * this.mBetaL2Imag + this.md * this.mBetaR2Imag;
      var3 = 12.0 * this.mk2 * (1.0 - this.md) - this.mm * var1 * var1 * (4.0 - 6.0 * this.md);
      var5 = 0.0;
      denReal = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      var9 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaL3Real = this.mReal;
      this.mBetaL3Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.md + this.mm * var1 * var1 * (2.0 - 6.0 * this.md);
      var5 = 0.0;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mBetaR3Real = this.mReal;
      this.mBetaR3Imag = this.mImag;
      this.mBeta33Real = (1.0 - this.md) * this.mBetaL3Real + this.md * this.mBetaR3Real;
      this.mBeta33Imag = (1.0 - this.md) * this.mBetaL3Imag + this.md * this.mBetaR3Imag;
      this.mGamma33Real = 1.0 / this.mk3 - 1.0 / (this.mm3 * var1 * var1);
      this.mGamma33Imag = 0.0;
      var3 = this.mBeta13Real * this.mBeta23Real - this.mBeta13Imag * this.mBeta23Imag;
      var5 = this.mBeta13Real * this.mBeta23Imag + this.mBeta13Imag * this.mBeta23Real;
      denReal = this.mBeta33Real + this.mGamma33Real;
      var9 = this.mBeta33Imag + this.mGamma33Imag;
      this.mReal = (var3 * denReal + var5 * var9) / (denReal * denReal + var9 * var9);
      this.mImag = (var5 * denReal - var3 * var9) / (denReal * denReal + var9 * var9);
      this.mAlpha12Real = this.mBeta12Real - this.mReal;
      this.mAlpha12Imag = this.mBeta12Imag - this.mImag;
   }

   public void setOmegaDisp(double var1) {
      double omega = var1 * 2.0 * Math.PI;
      this.receptance(omega);
      double force = 1.0;
      double fAlphaReal = this.mAlpha12Real * force;
      double fAlphaImag = this.mAlpha12Imag * force;
      double f3Real = fAlphaReal - this.mBeta12Real * force;
      double f3Imag = fAlphaImag - this.mBeta12Imag * force;
      double b23Real = this.mBeta23Real;
      double b23Imag = this.mBeta23Imag;
      double q3Real = (f3Real * b23Real + f3Imag * b23Imag) / (b23Real * b23Real + b23Imag * b23Imag);
      double q3Imag = (f3Imag * b23Real - f3Real * b23Imag) / (b23Real * b23Real + b23Imag * b23Imag);
      this.mXLReal = this.mBetaL1Real * force + this.mBetaL3Real * q3Real - this.mBetaL3Imag * q3Imag;
      this.mXLImag = this.mBetaL1Imag * force + this.mBetaL3Imag * q3Real + this.mBetaL3Real * q3Imag;
      this.mXRReal = this.mBetaR1Real * force + this.mBetaR3Real * q3Real - this.mBetaR3Imag * q3Imag;
      this.mXRImag = this.mBetaR1Imag * force + this.mBetaR3Imag * q3Real + this.mBetaR3Real * q3Imag;
      this.mX3Real = q3Real / (this.mm3 * omega * omega);
      this.mX3Imag = q3Imag / (this.mm3 * omega * omega);
      double maxAmp = Math.sqrt(this.mXLReal * this.mXLReal + this.mXLImag * this.mXLImag);
      if (maxAmp < Math.sqrt(this.mXRReal * this.mXRReal + this.mXRImag * this.mXRImag)) {
         maxAmp = Math.sqrt(this.mXRReal * this.mXRReal + this.mXRImag * this.mXRImag);
      }

      if (maxAmp < Math.sqrt(this.mX3Real * this.mX3Real + this.mX3Imag * this.mX3Imag)) {
         maxAmp = Math.sqrt(this.mX3Real * this.mX3Real + this.mX3Imag * this.mX3Imag);
      }

      this.mAmp[1][1] = this.mXLReal * 20.0 / maxAmp;
      this.mAmp[1][2] = this.mXLImag * 20.0 / maxAmp;
      this.mAmp[2][1] = this.mXRReal * 20.0 / maxAmp;
      this.mAmp[2][2] = this.mXRImag * 20.0 / maxAmp;
      this.mAmp[3][1] = this.mX3Real * 20.0 / maxAmp;
      this.mAmp[3][2] = this.mX3Imag * 20.0 / maxAmp;
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevHit) {
      if (prevHit) {
         return false;
      }

      switch (code) {
         case 0:
         case 1:
            double freq = (super.mFramePanel.mThisPt.x - 40) * 8.0 / 480.0;
            if (freq > 8.0) {
               freq = 8.0;
            }

            if (freq < 0.05) {
               freq = 0.05;
            }

            this.ControlMessage(this, 1, freq);
         default:
            return true;
      }
   }
}

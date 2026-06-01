package MultiDOF.Prog3.Multiforced;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

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
   public Vector mElements;
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

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      Color var3 = new Color(0.18F, 0.58F, 0.58F);
      Color var4 = new Color(0.77F, 0.38F, 0.0F);
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.black);
      var1.drawLine(37, 340, 523, 340);

      for (int var2 = 1; var2 < 9; var2++) {
         var1.drawLine(40 + var2 * 60, 340, 40 + var2 * 60, 343);
      }

      var1.setColor(Color.black);
      var1.drawLine(40, 67, 40, 342);

      for (int var5 = 0; var5 < 7; var5++) {
         var1.drawLine(40, 340 - var5 * 45, 37, 340 - var5 * 45);
      }

      var1.setColor(var4);
      var1.drawLine(513 + (int)(190.0 * this.mb) - 2, 145, 513 + (int)(190.0 * this.mb) - 2, 146);
      var1.drawLine(513 + (int)(190.0 * this.mb) - 1, 110, 513 + (int)(190.0 * this.mb) - 1, 148);
      var1.drawLine(513 + (int)(190.0 * this.mb), 110, 513 + (int)(190.0 * this.mb), 150);
      var1.drawLine(513 + (int)(190.0 * this.mb) + 1, 110, 513 + (int)(190.0 * this.mb) + 1, 148);
      var1.drawLine(513 + (int)(190.0 * this.mb) + 2, 145, 513 + (int)(190.0 * this.mb) + 2, 146);
      var1.setColor(Color.black);
      var1.drawString("F", 517 + (int)(190.0 * this.mb), 130);
      var1.setColor(var3);
      var1.drawLine(513 + (int)(190.0 * this.mc) - 2, 125, 513 + (int)(190.0 * this.mc) - 2, 126);
      var1.drawLine(513 + (int)(190.0 * this.mc) - 1, 110, 513 + (int)(190.0 * this.mc) - 1, 128);
      var1.drawLine(513 + (int)(190.0 * this.mc), 110, 513 + (int)(190.0 * this.mc), 130);
      var1.drawLine(513 + (int)(190.0 * this.mc) + 1, 110, 513 + (int)(190.0 * this.mc) + 1, 128);
      var1.drawLine(513 + (int)(190.0 * this.mc) + 2, 125, 513 + (int)(190.0 * this.mc) + 2, 126);
      var1.setColor(Color.black);
      var1.drawString("X", 519 + (int)(190.0 * this.mc), 125);
      var1.drawLine(513 + (int)(189.0 * this.md) + 3, 102, 513 + (int)(189.0 * this.md), 105);
      var1.drawLine(513 + (int)(189.0 * this.md) - 3, 96, 513 + (int)(189.0 * this.md) + 3, 102);
      var1.drawLine(513 + (int)(189.0 * this.md) + 3, 90, 513 + (int)(189.0 * this.md) - 3, 96);
      var1.drawLine(513 + (int)(189.0 * this.md) - 3, 84, 513 + (int)(189.0 * this.md) + 3, 90);
      var1.drawLine(513 + (int)(189.0 * this.md), 81, 513 + (int)(189.0 * this.md) - 3, 84);
      var1.setColor(var3);
      var1.fillRect(513 + (int)(189.0 * this.md) - 10, 71, 20, 10);
      var1.setColor(Color.black);
      var1.drawString("m3", 513 + (int)(189.0 * this.md) + 12, 79);
      var1.drawString("k3", 513 + (int)(189.0 * this.md) + 6, 95);
      var1.setColor(var3);
      this.response();

      for (int var6 = 2; var6 < 480; var6++) {
         var1.drawLine(
            40 + (var6 - 1),
            (int)(115.0 - Math.log(this.mRec[var6 - 1]) / Math.log(10.0) * 45.0),
            40 + var6,
            (int)(115.0 - Math.log(this.mRec[var6]) / Math.log(10.0) * 45.0)
         );
      }

      int var7 = (int)(this.mWanimate * 480.0 / 8.0);
      var1.setColor(Color.blue);
      var1.drawLine(40 + var7, 340, 40 + var7, (int)(115.0 - Math.log(this.mRec[var7]) / Math.log(10.0) * 45.0));
      var1.drawString(this.nns(this.mWanimate) + " Hz", 40 + var7 + 2, 337);
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
      }

      if (var1 < 0.0) {
         return new String("-" + this.nns(-var1, var3));
      }

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

   public String nns(double var1) {
      return this.nns(var1, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      double var9 = this.GetTime();
      var1.setColor(Color.white);
      byte var11 = 40;
      short var12 = 535;
      byte var13 = 20;
      short var14 = 450;
      short var15 = 455;
      Color var16 = new Color(0.18F, 0.58F, 0.58F);
      Color var17 = new Color(0.77F, 0.38F, 0.0F);
      this.setOmegaDisp(this.mWanimate);
      double var18 = Math.cos((Math.PI * 2) * this.mTime);
      double var20 = -Math.sin((Math.PI * 2) * this.mTime);
      int var5 = (int)(this.mAmp[1][1] * var18 + this.mAmp[1][2] * var20);
      int var6 = (int)(this.mAmp[2][1] * var18 + this.mAmp[2][2] * var20);
      int var7 = (int)(this.mAmp[3][1] * var18 + this.mAmp[3][2] * var20);
      int var8 = (int)(var5 + (var6 - var5) * this.md);
      var1.setColor(Color.orange);
      var1.fillRect(var11 - 10, var12, var14 + 20, var13);
      var1.setColor(Color.black);
      double var22 = (var15 + 2 + var5 - var12) / 10.0;
      var1.drawLine(var11, var12, var11 - 6, (int)(var12 + var22 / 2.0));

      for (int var4 = 1; var4 < 10; var4++) {
         if (var4 % 2 == 0) {
            var1.drawLine(var11 + 6, (int)(var12 + (2 * var4 - 1) * var22 / 2.0), var11 - 6, (int)(var12 + (2 * var4 + 1) * var22 / 2.0));
         } else {
            var1.drawLine(var11 - 6, (int)(var12 + (2 * var4 - 1) * var22 / 2.0), var11 + 6, (int)(var12 + (2 * var4 + 1) * var22 / 2.0));
         }
      }

      var1.drawLine(var11 + 6, (int)(var12 + 19.0 * var22 / 2.0), var11, var15 + var5 + 2);
      var1.setColor(Color.black);
      double var24 = (var15 + 2 + var6 - var12) / 10.0;
      var1.drawLine(var11 + var14, var12, var11 + var14 - 6, (int)(var12 + var24 / 2.0));

      for (int var29 = 1; var29 < 10; var29++) {
         if (var29 % 2 == 0) {
            var1.drawLine(var11 + var14 + 6, (int)(var12 + (2 * var29 - 1) * var24 / 2.0), var11 + var14 - 6, (int)(var12 + (2 * var29 + 1) * var24 / 2.0));
         } else {
            var1.drawLine(var11 + var14 - 6, (int)(var12 + (2 * var29 - 1) * var24 / 2.0), var11 + var14 + 6, (int)(var12 + (2 * var29 + 1) * var24 / 2.0));
         }
      }

      var1.drawLine(var11 + var14 + 6, (int)(var12 + 19.0 * var24 / 2.0), var11 + var14, var15 + var6 + 2);
      var1.setColor(var16);
      var1.drawLine(var11, var15 + var5 + 1, var11 + var14, var15 + var6 + 1);
      var1.drawLine(var11, var15 + var5, var11 + var14, var15 + var6);
      var1.drawLine(var11, var15 + var5 - 1, var11 + var14, var15 + var6 - 1);
      var1.setColor(var16);
      var1.fillRect(var11 + (int)(var14 * this.md) - 10, var15 - 61 + var7, 20, 10);
      var1.setColor(Color.black);
      double var26 = (50 + var8 - var7) / 10.0;
      var1.drawLine(var11 + (int)(var14 * this.md), var15 - 51 + var7, var11 + (int)(var14 * this.md) - 6, (int)(var15 - 51 + var7 + var26 / 2.0));

      for (int var30 = 1; var30 < 10; var30++) {
         if (var30 % 2 == 0) {
            var1.drawLine(
               var11 + (int)(var14 * this.md) + 6,
               (int)(var15 - 51 + var7 + (2 * var30 - 1) * var26 / 2.0),
               var11 + (int)(var14 * this.md) - 6,
               (int)(var15 - 51 + var7 + (2 * var30 + 1) * var26 / 2.0)
            );
         } else {
            var1.drawLine(
               var11 + (int)(var14 * this.md) - 6,
               (int)(var15 - 51 + var7 + (2 * var30 - 1) * var26 / 2.0),
               var11 + (int)(var14 * this.md) + 6,
               (int)(var15 - 51 + var7 + (2 * var30 + 1) * var26 / 2.0)
            );
         }
      }

      var1.drawLine(var11 + (int)(var14 * this.md) + 6, (int)(var15 - 51 + var7 + 19.0 * var26 / 2.0), var11 + (int)(var14 * this.md), var15 - 1 + var8);
      int var28 = (int)(50.0 * Math.cos((Math.PI * 2) * this.mTime));
      var1.setColor(var17);
      if (var28 != 0) {
         if (var28 > 0) {
            var1.drawLine(
               var11 + (int)(var14 * this.mb) - 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb) - 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28 - 1
            );
            var1.drawLine(
               var11 + (int)(var14 * this.mb),
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb),
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28
            );
            var1.drawLine(
               var11 + (int)(var14 * this.mb) + 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb) + 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28 - 1
            );
         }

         if (var28 < 0) {
            var1.drawLine(
               var11 + (int)(var14 * this.mb) - 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb) - 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28 + 1
            );
            var1.drawLine(
               var11 + (int)(var14 * this.mb),
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb),
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28
            );
            var1.drawLine(
               var11 + (int)(var14 * this.mb) + 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)),
               var11 + (int)(var14 * this.mb) + 1,
               var15 + var5 + (int)(this.mb * (var6 - var5)) + var28 + 1
            );
         }
      }

      var1.setColor(var16);
      var1.drawLine(
         var11 + (int)(var14 * this.mc),
         var15 + var5 + (int)(this.mc * (var6 - var5)) - 4,
         var11 + (int)(var14 * this.mc),
         var15 + var5 + (int)(this.mc * (var6 - var5)) + 4
      );
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mWanimate = var3;
            this.setOmegaDisp(this.mWanimate);
            var5 = true;
            break;
         case 2:
            this.mTime += var3;
            var5 = true;
            break;
         case 3:
            this.mm = var3;
            break;
         case 4:
            this.mk1 = var3;
            break;
         case 5:
            this.mk2 = var3;
            break;
         case 6:
            this.mb = var3;
            break;
         case 7:
            this.mc = var3;
            break;
         case 8:
            this.md = var3;
            break;
         case 9:
            this.mm3 = var3;
            break;
         case 10:
            this.mk3 = var3;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      for (int var1 = 1; var1 < 481; var1++) {
         double var2 = (Math.PI * 2) * var1 * 8.0 / 481.0;
         this.receptance(var2);
         this.mRec[var1] = Math.sqrt(this.mAlpha12Real * this.mAlpha12Real + this.mAlpha12Imag * this.mAlpha12Imag);
      }
   }

   public void receptance(double var1) {
      double var3 = 12.0 * this.mk2 * (1.0 - this.mb) - this.mm * var1 * var1 * (4.0 - 6.0 * this.mb);
      double var5 = 0.0;
      double var7 = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      double var9 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaL1Real = this.mReal;
      this.mBetaL1Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.mb + this.mm * var1 * var1 * (2.0 - 6.0 * this.mb);
      var5 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaR1Real = this.mReal;
      this.mBetaR1Imag = this.mImag;
      this.mBeta12Real = (1.0 - this.mc) * this.mBetaL1Real + this.mc * this.mBetaR1Real;
      this.mBeta12Imag = (1.0 - this.mc) * this.mBetaL1Imag + this.mc * this.mBetaR1Imag;
      this.mBeta13Real = (1.0 - this.md) * this.mBetaL1Real + this.md * this.mBetaR1Real;
      this.mBeta13Imag = (1.0 - this.md) * this.mBetaL1Imag + this.md * this.mBetaR1Imag;
      var3 = 12.0 * this.mk2 * (1.0 - this.mc) - this.mm * var1 * var1 * (4.0 - 6.0 * this.mc);
      var5 = 0.0;
      var7 = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      var9 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaL2Real = this.mReal;
      this.mBetaL2Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.mc + this.mm * var1 * var1 * (2.0 - 6.0 * this.mc);
      var5 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaR2Real = this.mReal;
      this.mBetaR2Imag = this.mImag;
      this.mBeta23Real = (1.0 - this.md) * this.mBetaL2Real + this.md * this.mBetaR2Real;
      this.mBeta23Imag = (1.0 - this.md) * this.mBetaL2Imag + this.md * this.mBetaR2Imag;
      var3 = 12.0 * this.mk2 * (1.0 - this.md) - this.mm * var1 * var1 * (4.0 - 6.0 * this.md);
      var5 = 0.0;
      var7 = (4.0 * this.mk1 - this.mm * var1 * var1) * (4.0 * this.mk2 - this.mm * var1 * var1) - 4.0 * this.mk2 * this.mk1;
      var9 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaL3Real = this.mReal;
      this.mBetaL3Imag = this.mImag;
      var3 = 12.0 * this.mk1 * this.md + this.mm * var1 * var1 * (2.0 - 6.0 * this.md);
      var5 = 0.0;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mBetaR3Real = this.mReal;
      this.mBetaR3Imag = this.mImag;
      this.mBeta33Real = (1.0 - this.md) * this.mBetaL3Real + this.md * this.mBetaR3Real;
      this.mBeta33Imag = (1.0 - this.md) * this.mBetaL3Imag + this.md * this.mBetaR3Imag;
      this.mGamma33Real = 1.0 / this.mk3 - 1.0 / (this.mm3 * var1 * var1);
      this.mGamma33Imag = 0.0;
      var3 = this.mBeta13Real * this.mBeta23Real - this.mBeta13Imag * this.mBeta23Imag;
      var5 = this.mBeta13Real * this.mBeta23Imag + this.mBeta13Imag * this.mBeta23Real;
      var7 = this.mBeta33Real + this.mGamma33Real;
      var9 = this.mBeta33Imag + this.mGamma33Imag;
      this.mReal = (var3 * var7 + var5 * var9) / (var7 * var7 + var9 * var9);
      this.mImag = (var5 * var7 - var3 * var9) / (var7 * var7 + var9 * var9);
      this.mAlpha12Real = this.mBeta12Real - this.mReal;
      this.mAlpha12Imag = this.mBeta12Imag - this.mImag;
   }

   public void setOmegaDisp(double var1) {
      double var12 = var1 * 2.0 * Math.PI;
      this.receptance(var12);
      double var14 = 1.0;
      double var16 = 0.0;
      double var22 = this.mAlpha12Real * var14;
      double var24 = this.mAlpha12Imag * var14;
      double var4 = var22 - this.mBeta12Real * var14;
      double var6 = var24 - this.mBeta12Imag * var14;
      double var8 = this.mBeta23Real;
      double var10 = this.mBeta23Imag;
      double var18 = (var4 * var8 + var6 * var10) / (var8 * var8 + var10 * var10);
      double var20 = (var6 * var8 - var4 * var10) / (var8 * var8 + var10 * var10);
      this.mXLReal = this.mBetaL1Real * var14 + this.mBetaL3Real * var18 - this.mBetaL3Imag * var20;
      this.mXLImag = this.mBetaL1Imag * var14 + this.mBetaL3Imag * var18 + this.mBetaL3Real * var20;
      this.mXRReal = this.mBetaR1Real * var14 + this.mBetaR3Real * var18 - this.mBetaR3Imag * var20;
      this.mXRImag = this.mBetaR1Imag * var14 + this.mBetaR3Imag * var18 + this.mBetaR3Real * var20;
      this.mX3Real = var18 / (this.mm3 * var12 * var12);
      this.mX3Imag = var20 / (this.mm3 * var12 * var12);
      double var26 = Math.sqrt(this.mXLReal * this.mXLReal + this.mXLImag * this.mXLImag);
      if (var26 < Math.sqrt(this.mXRReal * this.mXRReal + this.mXRImag * this.mXRImag)) {
         var26 = Math.sqrt(this.mXRReal * this.mXRReal + this.mXRImag * this.mXRImag);
      }

      if (var26 < Math.sqrt(this.mX3Real * this.mX3Real + this.mX3Imag * this.mX3Imag)) {
         var26 = Math.sqrt(this.mX3Real * this.mX3Real + this.mX3Imag * this.mX3Imag);
      }

      this.mAmp[1][1] = this.mXLReal * 20.0 / var26;
      this.mAmp[1][2] = this.mXLImag * 20.0 / var26;
      this.mAmp[2][1] = this.mXRReal * 20.0 / var26;
      this.mAmp[2][2] = this.mXRImag * 20.0 / var26;
      this.mAmp[3][1] = this.mX3Real * 20.0 / var26;
      this.mAmp[3][2] = this.mX3Imag * 20.0 / var26;
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int var1, boolean var2) {
      if (var2) {
         return false;
      }

      boolean var3 = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      switch (var1) {
         case 0:
         case 1:
            double var4 = (super.mFramePanel.mThisPt.x - 40) * 8.0 / 480.0;
            if (var4 > 8.0) {
               var4 = 8.0;
            }

            if (var4 < 0.05) {
               var4 = 0.05;
            }

            this.ControlMessage(this, 1, var4);
         default:
            return true;
      }
   }
}

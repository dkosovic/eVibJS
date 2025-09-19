package Continuous.Prog11.Vibration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 50;
   public static final int kyTopAbutment = 20;
   public static final int kAbutmentWidth = 0;
   public static final int kBarradius = 30;
   public static final int kBarLength = 400;
   static double dt = 0.01;
   public static final double kWn1Fraction = 3.52;
   public static final double kWn2Fraction = 22.03;
   public static final double kWn3Fraction = 61.7;
   public static final double kWn4Fraction = 120.9;
   public static final double kWn5Fraction = 199.9;
   public static final double kWn6Fraction = 298.6;
   public static final double kStartWn = 0.025;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn;
   double mXo;
   double mx0;
   double mlambdaL;
   double mlambdax;
   double mexp;
   double msh;
   double mch;
   double msn;
   double mcs;
   double msnx;
   double mcsx;
   double mshx;
   double mchx;
   double mF7;
   double mF9;
   double mMax;
   int kyaxis;
   double[] mxp = new double[33];
   double[] mAmp = new double[33];
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   Image mTraceImage;
   Graphics mTraceGC;

   CAnimationPanel() {
      this.mWn = 0.025;
   }

   public void update(Graphics g) {
      if (g != null) {
         this.mScreenGC = g;
         this.paint(this.mScreenGC);
      }
   }

   public void paint(Graphics g) {
      this.mScreenGC = g;
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.size().width, this.size().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(3.52);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int p = 0; p < 31; p++) {
         this.mlambdax = this.mlambdaL * p / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[p] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[p]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[p]);
         }
      }

      for (int var6 = 0; var6 < 31; var6++) {
         this.mxp[var6] = this.mxp[var6] * 20.0 / this.mMax;
      }

      for (int var7 = 0; var7 < 31; var7++) {
         this.mAmp[var7] = this.mxp[var7] * Math.cos(this.mWn * this.mTime * 3.52);
      }

      this.kyaxis = 30;

      for (int var8 = 0; var8 < 30; var8++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var8 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var8],
               50 + (int)((var8 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var8 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 10, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("First mode", 320, 35);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(22.03);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int var9 = 0; var9 < 31; var9++) {
         this.mlambdax = this.mlambdaL * var9 / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[var9] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[var9]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[var9]);
         }
      }

      for (int var10 = 0; var10 < 31; var10++) {
         this.mxp[var10] = this.mxp[var10] * 20.0 / this.mMax;
      }

      for (int var11 = 0; var11 < 31; var11++) {
         this.mAmp[var11] = this.mxp[var11] * Math.cos(this.mWn * this.mTime * 22.03);
      }

      this.kyaxis = 90;

      for (int var12 = 0; var12 < 30; var12++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var12 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var12],
               50 + (int)((var12 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var12 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 70, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("Second mode", 320, 95);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(61.7);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int var13 = 0; var13 < 31; var13++) {
         this.mlambdax = this.mlambdaL * var13 / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[var13] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[var13]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[var13]);
         }
      }

      for (int var14 = 0; var14 < 31; var14++) {
         this.mxp[var14] = this.mxp[var14] * 20.0 / this.mMax;
      }

      for (int var15 = 0; var15 < 31; var15++) {
         this.mAmp[var15] = this.mxp[var15] * Math.cos(this.mWn * this.mTime * 61.7);
      }

      this.kyaxis = 150;

      for (int var16 = 0; var16 < 30; var16++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var16 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var16],
               50 + (int)((var16 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var16 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 130, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("Third mode", 320, 155);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(120.9);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int var17 = 0; var17 < 31; var17++) {
         this.mlambdax = this.mlambdaL * var17 / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[var17] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[var17]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[var17]);
         }
      }

      for (int var18 = 0; var18 < 31; var18++) {
         this.mxp[var18] = this.mxp[var18] * 20.0 / this.mMax;
      }

      for (int var19 = 0; var19 < 31; var19++) {
         this.mAmp[var19] = this.mxp[var19] * Math.cos(this.mWn * this.mTime * 120.9);
      }

      this.kyaxis = 210;

      for (int var20 = 0; var20 < 30; var20++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var20 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var20],
               50 + (int)((var20 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var20 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 190, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("Fourth mode", 320, 215);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(199.9);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int var21 = 0; var21 < 31; var21++) {
         this.mlambdax = this.mlambdaL * var21 / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[var21] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[var21]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[var21]);
         }
      }

      for (int var22 = 0; var22 < 31; var22++) {
         this.mxp[var22] = this.mxp[var22] * 20.0 / this.mMax;
      }

      for (int var23 = 0; var23 < 31; var23++) {
         this.mAmp[var23] = this.mxp[var23] * Math.cos(this.mWn * this.mTime * 199.9);
      }

      this.kyaxis = 270;

      for (int var24 = 0; var24 < 30; var24++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var24 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var24],
               50 + (int)((var24 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var24 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 250, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("Fifth mode", 320, 275);
      this.mOffScreenGC.setColor(mass);
      this.mlambdaL = Math.sqrt(298.6);
      this.mexp = Math.exp(this.mlambdaL);
      this.msh = (this.mexp - 1.0 / this.mexp) / 2.0;
      this.mch = (this.mexp + 1.0 / this.mexp) / 2.0;
      this.msn = Math.sin(this.mlambdaL);
      this.mcs = Math.cos(this.mlambdaL);
      this.mF7 = this.msn + this.msh;
      this.mF9 = this.mcs + this.mch;
      this.mMax = 0.0;

      for (int var25 = 0; var25 < 31; var25++) {
         this.mlambdax = this.mlambdaL * var25 / 30.0;
         this.msnx = Math.sin(this.mlambdax);
         this.mcsx = Math.cos(this.mlambdax);
         this.mexp = Math.exp(this.mlambdax);
         this.mshx = (this.mexp - 1.0 / this.mexp) / 2.0;
         this.mchx = (this.mexp + 1.0 / this.mexp) / 2.0;
         this.mxp[var25] = this.mF7 * (this.mcsx - this.mchx) - this.mF9 * (this.msnx - this.mshx);
         if (Math.abs(this.mxp[var25]) > this.mMax) {
            this.mMax = Math.abs(this.mxp[var25]);
         }
      }

      for (int var26 = 0; var26 < 31; var26++) {
         this.mxp[var26] = this.mxp[var26] * 20.0 / this.mMax;
      }

      for (int var27 = 0; var27 < 31; var27++) {
         this.mAmp[var27] = this.mxp[var27] * Math.cos(this.mWn * this.mTime * 298.6);
      }

      this.kyaxis = 330;

      for (int var28 = 0; var28 < 30; var28++) {
         this.mOffScreenGC
            .drawLine(
               50 + (int)(var28 * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var28],
               50 + (int)((var28 + 1) * 250.0 / 30.0),
               this.kyaxis - (int)this.mAmp[var28 + 1]
            );
      }

      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(30, 310, 20, 40);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawString("Sixth mode", 320, 335);
      g.drawImage(this.mOffScrImage, 0, 0, null);
   }

   public void SetRealParameter(int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 0:
            this.mTime += val;
            mustRedraw = true;
         default:
            if (mustRedraw) {
               this.repaint();
            }
      }
   }
}

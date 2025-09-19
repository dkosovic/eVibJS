package Continuous.Prog8.Vibration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 20;
   public static final int kyTopAbutment = 20;
   public static final int kAbutmentDepth = 80;
   public static final int kAbutmentWidth = 30;
   public static final int kBarradius = 30;
   public static final int kBarLength = 400;
   static double dt = 0.01;
   public static final double kStartWn1Fraction = 1.0;
   public static final double kStartWn2Fraction = 2.0;
   public static final double kStartWn3Fraction = 3.0;
   public static final double kStartWn = 0.25;
   public static final double kStartXo = 0.5236;
   public static final double kalpha = 1.0472;
   public static final double kbeta = 0.2618;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn1Fraction = 1.0;
   double mWn2Fraction = 2.0;
   double mWn3Fraction = 3.0;
   double mWn = 0.25;
   double mXo = 0.5236;
   double[] mtheta;
   double mbeta;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   Image mTraceImage;
   Graphics mTraceGC;

   CAnimationPanel() {
   }

   public void update(Graphics g) {
      if (g != null) {
         this.mScreenGC = g;
         this.paint(this.mScreenGC);
      }
   }

   public void paint(Graphics g) {
      this.mtheta = new double[45];
      this.mScreenGC = g;
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      new Color(1.0F, 1.0F, 0.4F);
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.size().width, this.size().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      new Character('©');
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      int offset = 20;
      this.mOffScreenGC.setColor(mass);
      this.mtheta[0] = 0.0;

      for (int q = 1; q < 19; q++) {
         this.mbeta = Math.PI - Math.PI * (q - 1) / 9.0;

         for (int p = 1; p < 41; p++) {
            this.mtheta[p] = 0.0;
            if (p == 40) {
               this.mOffScreenGC
                  .drawLine(
                     450,
                     offset + 40,
                     50 + p * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[p]) * Math.cos(1.0472)),
                     offset + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[p]))
                  );
            }

            if (this.mbeta + this.mtheta[p] < Math.PI / 2 & this.mbeta + this.mtheta[p] > -Math.PI / 2) {
               this.mOffScreenGC
                  .drawLine(
                     50 + (p - 1) * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[p - 1]) * Math.cos(1.0472)),
                     offset + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[p - 1])),
                     50 + p * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[p]) * Math.cos(1.0472)),
                     offset + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[p]))
                  );
            }
         }
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472)), offset + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), offset + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, offset + 40 - 30, 450, offset + 40 - 30);
      this.mOffScreenGC.drawLine(50, offset + 40 + 30, 450, offset + 40 + 30);
      this.mOffScreenGC.setColor(force);

      for (int p = 1; p < 5; p++) {
         this.mOffScreenGC.drawArc(460 + p - (int)(30.0 * Math.cos(1.0472) / 2.0), offset + 40 - 15, 15, 30, 20 - 5 * p, 180);
      }

      for (int var12 = 1; var12 < 4; var12++) {
         this.mOffScreenGC.drawArc(464 + var12 - (int)(30.0 * Math.cos(1.0472) / 2.0), offset + 40 - 15, 15, 30, 5 * var12, 180);
      }

      int var19 = 130;
      this.mOffScreenGC.setColor(mass);
      this.mtheta[0] = this.mXo * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * Math.PI);

      for (int var16 = 1; var16 < 19; var16++) {
         this.mbeta = Math.PI - Math.PI * (var16 - 1) / 9.0;

         for (int var13 = 1; var13 < 41; var13++) {
            this.mtheta[var13] = this.mXo
               * Math.cos(this.mWn1Fraction * Math.PI * var13 / 40.0)
               * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
            if (var13 == 40) {
               this.mOffScreenGC
                  .drawLine(
                     450,
                     var19 + 40,
                     50 + var13 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var13]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var13]))
                  );
            }

            if (this.mbeta + this.mtheta[var13] < Math.PI / 2 & this.mbeta + this.mtheta[var13] > -Math.PI / 2) {
               this.mOffScreenGC
                  .drawLine(
                     50 + (var13 - 1) * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var13 - 1]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var13 - 1])),
                     50 + var13 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var13]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var13]))
                  );
            }
         }
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var19 + 40 - 30, 450, var19 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var19 + 40 + 30, 450, var19 + 40 + 30);
      var19 = 240;
      this.mOffScreenGC.setColor(mass);
      this.mtheta[0] = this.mXo * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * Math.PI);

      for (int var17 = 1; var17 < 19; var17++) {
         this.mbeta = Math.PI - Math.PI * (var17 - 1) / 9.0;

         for (int var14 = 1; var14 < 41; var14++) {
            this.mtheta[var14] = this.mXo
               * Math.cos(this.mWn2Fraction * Math.PI * var14 / 40.0)
               * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
            if (var14 == 40) {
               this.mOffScreenGC
                  .drawLine(
                     450,
                     var19 + 40,
                     50 + var14 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var14]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var14]))
                  );
            }

            if (this.mbeta + this.mtheta[var14] < Math.PI / 2 & this.mbeta + this.mtheta[var14] > -Math.PI / 2) {
               this.mOffScreenGC
                  .drawLine(
                     50 + (var14 - 1) * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var14 - 1]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var14 - 1])),
                     50 + var14 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var14]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var14]))
                  );
            }
         }
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var19 + 40 - 30, 450, var19 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var19 + 40 + 30, 450, var19 + 40 + 30);
      var19 = 350;
      this.mOffScreenGC.setColor(mass);
      this.mtheta[0] = this.mXo * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * Math.PI);

      for (int var18 = 1; var18 < 19; var18++) {
         this.mbeta = Math.PI - Math.PI * (var18 - 1) / 9.0;

         for (int var15 = 1; var15 < 41; var15++) {
            this.mtheta[var15] = this.mXo
               * Math.cos(this.mWn3Fraction * Math.PI * var15 / 40.0)
               * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
            if (var15 == 40) {
               this.mOffScreenGC
                  .drawLine(
                     450,
                     var19 + 40,
                     50 + var15 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var15]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var15]))
                  );
            }

            if (this.mbeta + this.mtheta[var15] < Math.PI / 2 & this.mbeta + this.mtheta[var15] > -Math.PI / 2) {
               this.mOffScreenGC
                  .drawLine(
                     50 + (var15 - 1) * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var15 - 1]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var15 - 1])),
                     50 + var15 * 10 - (int)(30.0 * Math.cos(this.mbeta + this.mtheta[var15]) * Math.cos(1.0472)),
                     var19 + 40 + (int)(30.0 * Math.sin(this.mbeta + this.mtheta[var15]))
                  );
            }
         }
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var19 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var19 + 40 - 30, 450, var19 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var19 + 40 + 30, 450, var19 + 40 + 30);
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

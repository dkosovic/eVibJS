package Continuous.Prog4.Vibration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

@SuppressWarnings("serial")
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
   public static final double kStartWn2Fraction = 3.0;
   public static final double kStartWn3Fraction = 5.0;
   public static final double kStartWn = 0.25;
   public static final double kStartXo = 30.0;
   public static final double kalpha = 1.0472;
   public static final double kbeta = 0.2618;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn1Fraction = 1.0;
   double mWn2Fraction = 3.0;
   double mWn3Fraction = 5.0;
   double mWn = 0.25;
   double mXo = 30.0;
   double mxp;
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
      this.mScreenGC = g;
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      Color shade = new Color(1.0F, 1.0F, 0.4F);
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.getSize().width, this.getSize().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      int offset = 20;
      this.mOffScreenGC.setColor(shade);
      this.mOffScreenGC.fillArc(30 - (int)(50.0 * Math.cos(1.0472)), offset + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.fillRect(30, offset + 40 - 30 - 20, 20, 100);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillArc(50 - (int)(50.0 * Math.cos(1.0472)), offset + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillArc(50 - (int)(30.0 * Math.cos(1.0472)), offset + 40 - 30, 30, 60, 180, 360);
      this.mOffScreenGC.fillRect(50, offset + 40 - 30, 100, 60);
      this.mOffScreenGC.setColor(mass);

      for (int p = 1; p < 21; p++) {
         this.mxp = 0.0;
         this.mOffScreenGC.drawArc(50 + p * 20 - (int)(30.0 * Math.cos(1.0472) - this.mxp), offset + 40 - 30, 30, 60, 90, 180);
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472) - this.mxp), offset + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), offset + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, offset + 40 - 30, 450 + (int)this.mxp, offset + 40 - 30);
      this.mOffScreenGC.drawLine(50, offset + 40 + 30, 450 + (int)this.mxp, offset + 40 + 30);
      this.mOffScreenGC.setColor(force);

      for (int var10 = 1; var10 < 5; var10++) {
         this.mOffScreenGC.drawLine(451, 56 + var10, 470 + var10, 56 + var10);
      }

      for (int var11 = 1; var11 < 4; var11++) {
         this.mOffScreenGC.drawLine(451, 60 + var11, 474 - var11, 60 + var11);
      }

      this.mOffScreenGC.fillArc(450, 57, 4, 7, 0, 360);
      int var15 = 130;
      this.mOffScreenGC.setColor(shade);
      this.mOffScreenGC.fillArc(30 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.fillRect(30, var15 + 40 - 30 - 20, 20, 100);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillArc(50 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 180, 360);
      this.mOffScreenGC.fillRect(50, var15 + 40 - 30, 100, 60);
      this.mOffScreenGC.setColor(mass);

      for (int var12 = 1; var12 < 21; var12++) {
         this.mxp = this.mXo * Math.sin(this.mWn1Fraction * Math.PI / 2.0 * var12 / 20.0) * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
         this.mOffScreenGC.drawArc(50 + var12 * 20 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 90, 180);
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var15 + 40 - 30, 450 + (int)this.mxp, var15 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var15 + 40 + 30, 450 + (int)this.mxp, var15 + 40 + 30);
      var15 = 240;
      this.mOffScreenGC.setColor(shade);
      this.mOffScreenGC.fillArc(30 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.fillRect(30, var15 + 40 - 30 - 20, 20, 100);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillArc(50 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 180, 360);
      this.mOffScreenGC.fillRect(50, var15 + 40 - 30, 100, 60);
      this.mOffScreenGC.setColor(mass);

      for (int var13 = 1; var13 < 21; var13++) {
         this.mxp = this.mXo * Math.sin(this.mWn2Fraction * Math.PI / 2.0 * var13 / 20.0) * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
         this.mOffScreenGC.drawArc(50 + var13 * 20 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 90, 180);
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var15 + 40 - 30, 450 + (int)this.mxp, var15 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var15 + 40 + 30, 450 + (int)this.mxp, var15 + 40 + 30);
      var15 = 350;
      this.mOffScreenGC.setColor(shade);
      this.mOffScreenGC.fillArc(30 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.fillRect(30, var15 + 40 - 30 - 20, 20, 100);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillArc(50 - (int)(50.0 * Math.cos(1.0472)), var15 + 40 - 50, 50, 100, 0, 360);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 180, 360);
      this.mOffScreenGC.fillRect(50, var15 + 40 - 30, 100, 60);
      this.mOffScreenGC.setColor(mass);

      for (int var14 = 1; var14 < 21; var14++) {
         this.mxp = this.mXo * Math.sin(this.mWn3Fraction * Math.PI / 2.0 * var14 / 20.0) * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * Math.PI);
         this.mOffScreenGC.drawArc(50 + var14 * 20 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 90, 180);
      }

      this.mOffScreenGC.drawArc(450 - (int)(30.0 * Math.cos(1.0472) - this.mxp), var15 + 40 - 30, 30, 60, 0, 360);
      this.mOffScreenGC.drawArc(50 - (int)(30.0 * Math.cos(1.0472)), var15 + 40 - 30, 30, 60, 90, 180);
      this.mOffScreenGC.drawLine(50, var15 + 40 - 30, 450 + (int)this.mxp, var15 + 40 - 30);
      this.mOffScreenGC.drawLine(50, var15 + 40 + 30, 450 + (int)this.mxp, var15 + 40 + 30);
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

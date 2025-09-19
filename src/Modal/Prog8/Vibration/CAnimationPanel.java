package Modal.Prog8.Vibration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 10;
   public static final int kyTopAbutment = 2;
   public static final int kAbutmentDepth = 60;
   public static final int kAbutmentWidth = 30;
   public static final int kStringLength = 500;
   public static final int kN = 8;
   double[] mWnFraction = new double[10];
   int[] yp = new int[10];
   static double dt = 0.01;
   public static final double kStartWn = 1.0;
   public static final double kStartYo = 25.0;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn = 1.0;
   double mYo = 25.0;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   Image mTraceImage;
   Graphics mTraceGC;

   CAnimationPanel() {
      this.yp[0] = 0;
      this.yp[9] = 0;
   }

   public void update(Graphics g) {
      if (g != null) {
         this.mScreenGC = g;
         this.paint(this.mScreenGC);
      }
   }

   public void paint(Graphics g) {
      this.mScreenGC = g;
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.getSize().width, this.getSize().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);

      for (int i = 1; i < 9; i++) {
         this.mWnFraction[i] = Math.sin(i * Math.PI / 2.0 / 9.0);
      }

      Color mass = new Color(0.18F, 0.58F, 0.58F);

      for (int var8 = 1; var8 < 9; var8++) {
         this.mOffScreenGC.setColor(Color.orange);
         this.mOffScreenGC.fillRect(10, 2 + 60 * (var8 - 1) + var8 * 2, 30, 60);
         this.mOffScreenGC.fillRect(540, 2 + 60 * (var8 - 1) + var8 * 2, 30, 60);
         this.mOffScreenGC.setColor(Color.black);

         for (int p = 1; p < 9; p++) {
            this.yp[p] = (int)(this.mYo * Math.sin(var8 * p * Math.PI / 9.0) * Math.sin(this.mWnFraction[var8] * this.mWn * this.mTime * 2.0 * Math.PI));
         }

         for (int var9 = 0; var9 < 9; var9++) {
            this.mOffScreenGC
               .drawLine(
                  40 + 500 * var9 / 9,
                  (int)(2.0 + 60.0 * (var8 - 0.5) + this.yp[var9] + var8 * 2),
                  40 + 500 * (var9 + 1) / 9,
                  (int)(2.0 + 60.0 * (var8 - 0.5) + this.yp[var9 + 1] + var8 * 2)
               );
         }

         this.mOffScreenGC.setColor(mass);

         for (int var10 = 1; var10 < 9; var10++) {
            this.mOffScreenGC.fillArc(40 + 500 * var10 / 9 - 6, (int)(2.0 + 60.0 * (var8 - 0.5) + this.yp[var10] + var8 * 2) - 6, 13, 13, 0, 360);
         }

         this.mOffScreenGC.setColor(Color.black);
         this.mOffScreenGC
            .drawString("This program is copyright, you need permission to use it. © 2003 B J Stone, bjs@mech.uwa.edu.au.", 50, 508);
      }

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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 30;
   public static final int kyTopAbutment = 135;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 200;
   public static final int kyTopMass = 61;
   static double dt = 0.01;
   public static final double kStartWn = 0.6;
   public static final double kStartXo = 5.0;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn = 0.6;
   double mXo = 5.0;
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
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.size().width, this.size().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      new Character('©');
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      double yreal1 = this.mXo * 3.4 * Math.cos(0.71 * this.mWn * this.mTime * 2.0 * Math.PI)
         + this.mXo * 3.4 * Math.cos(1.23 * this.mWn * this.mTime * 2.0 * Math.PI + (Math.PI / 4));
      int y1 = (int)yreal1;
      double yreal2 = this.mXo * 3.4 * Math.cos(0.71 * this.mWn * this.mTime * 2.0 * Math.PI)
         - this.mXo * 3.4 * Math.cos(1.23 * this.mWn * this.mTime * 2.0 * Math.PI + (Math.PI / 4));
      int y2 = (int)yreal2;
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(20, 135, 220, 20);
      this.mOffScreenGC.setColor(Color.black);
      double coil1 = (63 + y1 - 135) / 10.0;
      this.mOffScreenGC.drawLine(30, 135, 24, (int)(135.0 + coil1 / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            this.mOffScreenGC.drawLine(36, (int)(135.0 + (2 * p - 1) * coil1 / 2.0), 24, (int)(135.0 + (2 * p + 1) * coil1 / 2.0));
         } else {
            this.mOffScreenGC.drawLine(24, (int)(135.0 + (2 * p - 1) * coil1 / 2.0), 36, (int)(135.0 + (2 * p + 1) * coil1 / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(36, (int)(135.0 + 19.0 * coil1 / 2.0), 30, 61 + y1 + 2);
      this.mOffScreenGC.setColor(Color.black);
      double coil2 = (63 + y2 - 135) / 10.0;
      this.mOffScreenGC.drawLine(230, 135, 224, (int)(135.0 + coil2 / 2.0));

      for (int var17 = 1; var17 < 10; var17++) {
         if (var17 % 2 == 0) {
            this.mOffScreenGC.drawLine(236, (int)(135.0 + (2 * var17 - 1) * coil2 / 2.0), 224, (int)(135.0 + (2 * var17 + 1) * coil2 / 2.0));
         } else {
            this.mOffScreenGC.drawLine(224, (int)(135.0 + (2 * var17 - 1) * coil2 / 2.0), 236, (int)(135.0 + (2 * var17 + 1) * coil2 / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(236, (int)(135.0 + 19.0 * coil2 / 2.0), 230, 61 + y2 + 2);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.drawLine(30, 61 + y1 + 1, 230, 61 + y2 + 1);
      this.mOffScreenGC.drawLine(30, 61 + y1, 230, 61 + y2);
      this.mOffScreenGC.drawLine(30, 61 + y1 - 1, 230, 61 + y2 - 1);
      g.drawImage(this.mOffScrImage, 0, 0, null);
   }

   public void SetRealParameter(int code, double val) {
      boolean mustgrayraw = false;
      switch (code) {
         case 0:
            this.mTime += val;
            mustgrayraw = true;
         default:
            if (mustgrayraw) {
               this.repaint();
            }
      }
   }
}

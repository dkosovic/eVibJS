import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 10;
   public static final int KyTopAbutment = 10;
   public static final int KyAbutmentDepth = 20;
   public static final int KyTopMass = 200;
   public static final int kMassWidth = 70;
   public static final int kMassDepth = 40;
   static double dt = 0.01;
   public static final double kStartWn = 0.4;
   public static final double kStartXo = 12.0;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn = 0.4;
   double mXo = 12.0;
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
      double yreal = this.mXo * 3.4 * Math.cos(this.mWn * this.mTime * 2.0 * Math.PI);
      int y = (int)yreal;
      int springenergy = (int)(100.0 * yreal * yreal / (this.mXo * 3.4 * this.mXo * 3.4));
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(10, 10, 70, 20);
      this.mOffScreenGC.setColor(Color.black);
      double coil = (200 + y - 10 - 20) / 10.0;
      this.mOffScreenGC.drawLine(45, 30, 57, (int)(30.0 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            this.mOffScreenGC.drawLine(33, (int)(30.0 + (2 * p - 1) * coil / 2.0), 57, (int)(30.0 + (2 * p + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC.drawLine(57, (int)(30.0 + (2 * p - 1) * coil / 2.0), 33, (int)(30.0 + (2 * p + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(33, (int)(30.0 + 19.0 * coil / 2.0), 45, 200 + y);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.fillRect(10, 200 + y, 70, 40);
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

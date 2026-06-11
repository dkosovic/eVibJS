package Home_info.Vibration2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

@SuppressWarnings("serial")
public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 10;
   public static final int kyTopAbutment = 10;
   public static final int kyAbutmentDepth = 20;
   public static final int kyTopMass1 = 100;
   public static final int kyTopMass2 = 170;
   public static final int kMassWidth = 35;
   public static final int kMassDepth = 20;
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
         this.mOffScrImage = this.createImage(this.getSize().width, this.getSize().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      double yreal1 = this.mXo * 3.4 * Math.cos(0.618 * this.mWn * this.mTime * 2.0 * Math.PI)
         + this.mXo * 3.4 * Math.cos(1.618 * this.mWn * this.mTime * 2.0 * Math.PI + (Math.PI / 4));
      int y1 = (int)yreal1;
      double yreal2 = this.mXo * 3.4 * 1.618 * Math.cos(0.618 * this.mWn * this.mTime * 2.0 * Math.PI)
         - 0.618 * this.mXo * 3.4 * Math.cos(1.618 * this.mWn * this.mTime * 2.0 * Math.PI + (Math.PI / 4));
      int y2 = (int)yreal2;
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(10, 10, 35, 20);
      this.mOffScreenGC.setColor(Color.black);
      double coil = (100 + y1 - 10 - 20) / 10.0;
      this.mOffScreenGC.drawLine(27, 30, 33, (int)(30.0 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            this.mOffScreenGC.drawLine(21, (int)(30.0 + (2 * p - 1) * coil / 2.0), 33, (int)(30.0 + (2 * p + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC.drawLine(33, (int)(30.0 + (2 * p - 1) * coil / 2.0), 21, (int)(30.0 + (2 * p + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(21, (int)(30.0 + 19.0 * coil / 2.0), 27, 100 + y1);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.fillRect(10, 100 + y1, 35, 20);
      this.mOffScreenGC.setColor(Color.black);
      coil = (170 + y2 - 100 - 20 - y1) / 10.0;
      this.mOffScreenGC.drawLine(27, 120 + y1, 33, (int)(120 + y1 + coil / 2.0));

      for (int i = 1; i < 10; i++) {
         if (i % 2 == 0) {
            this.mOffScreenGC.drawLine(21, (int)(120 + y1 + (2 * i - 1) * coil / 2.0), 33, (int)(120 + y1 + (2 * i + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC.drawLine(33, (int)(120 + y1 + (2 * i - 1) * coil / 2.0), 21, (int)(120 + y1 + (2 * i + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(21, (int)(120 + y1 + 19.0 * coil / 2.0), 27, 170 + y2);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.fillRect(10, 170 + y2, 35, 20);
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

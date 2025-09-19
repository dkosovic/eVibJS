package OneDOF.Transient.Transient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 10;
   public static final int KyAbutmentDepth = 20;
   public static final int KyTopMass = 200;
   public static final int kMassWidth = 70;
   public static final int kMassDepth = 40;
   static double dt = 0.01;
   public static final double kStartWn = 0.4;
   public static final double kStartXi = 0.15;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn = 0.4;
   double mXo = 50.0;
   double mVo = 0.0;
   double mXi = 0.15;
   double yreal;
   int KyTopAbutment = 10;
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
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      if (this.mTime < 5.0) {
         this.yreal = 0.0;
      }

      if (this.mTime > 2.5) {
         this.KyTopAbutment = 10 + (int)this.mXo;
         double mWnt = this.mWn * 2.0 * Math.PI * 2.0 * (this.mTime - 2.5);
         double mWnTsqrt = mWnt * Math.sqrt(1.0 - this.mXi * this.mXi);
         this.yreal = Math.exp(-this.mXi * mWnt)
            * (
               this.mXo * Math.cos(mWnTsqrt)
                  + (this.mVo + this.mXi * this.mWn * 2.0 * Math.PI * this.mXo)
                     * Math.sin(mWnTsqrt)
                     / (this.mWn * 2.0 * Math.PI * Math.sqrt(1.0 - this.mXi * this.mXi))
            );
         this.yreal = this.mXo - (int)this.yreal;
      }

      if (this.mTime > 10.0) {
         this.KyTopAbutment = 10;
         double mWnt = this.mWn * 2.0 * Math.PI * 2.0 * (this.mTime - 10.0);
         double mWnTsqrt = mWnt * Math.sqrt(1.0 - this.mXi * this.mXi);
         this.yreal = Math.exp(-this.mXi * mWnt)
            * (
               this.mXo * Math.cos(mWnTsqrt)
                  + (this.mVo + this.mXi * this.mWn * 2.0 * Math.PI * this.mXo)
                     * Math.sin(mWnTsqrt)
                     / (this.mWn * 2.0 * Math.PI * Math.sqrt(1.0 - this.mXi * this.mXi))
            );
      }

      if (this.mTime > 17.5) {
         this.KyTopAbutment = 10;
         this.mTime = 0.0;
      }

      int y = (int)this.yreal;
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(10, this.KyTopAbutment, 70, 20);
      this.mOffScreenGC.setColor(Color.black);
      double coil = (200 + y - this.KyTopAbutment - 20) / 10.0;
      this.mOffScreenGC.drawLine(45, this.KyTopAbutment + 20, 57, (int)(this.KyTopAbutment + 20 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            this.mOffScreenGC
               .drawLine(33, (int)(this.KyTopAbutment + 20 + (2 * p - 1) * coil / 2.0), 57, (int)(this.KyTopAbutment + 20 + (2 * p + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC
               .drawLine(57, (int)(this.KyTopAbutment + 20 + (2 * p - 1) * coil / 2.0), 33, (int)(this.KyTopAbutment + 20 + (2 * p + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(33, (int)(this.KyTopAbutment + 20 + 19.0 * coil / 2.0), 45, 200 + y);
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

package TwoDOF.Detuner_2DOF.Transient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

public class CAnimationPanel extends Panel {
   public static final int kDeltaTimeCode = 0;
   public static final int kxEdge = 10;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 35;
   public static final int kMassDepth = 20;
   public static final int kyTopMass1 = 110;
   public static final int kyTopMass2 = 201;
   static double dt = 0.01;
   public static final double kStartWn = 0.6;
   public static final int kRunning = 1;
   public static final int mState = 1;
   double mTime;
   double mWn = 0.6;
   int mXo;
   double mXi;
   double y1real;
   double y2real;
   int kyTopAbutment = 19;
   int Farrow;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   Image mTraceImage;
   Graphics mTraceGC;

   CAnimationPanel() {
      this.mXo = 10;
      this.mXi = 0.05;
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
      double mWnt = this.mWn * 2.0 * Math.PI * 2.0 * (this.mTime - 2.0);
      this.y1real = 0.0;
      this.y2real = 2.0 * this.mXo * Math.sin(this.mWn * this.mTime * 2.0 * Math.PI);
      this.Farrow = (int)(25.0 * Math.sin(this.mWn * this.mTime * 2.0 * Math.PI));
      this.y1real = this.mXo - (int)this.y1real;
      this.y2real = this.mXo - (int)this.y2real;
      int y1 = (int)this.y1real;
      int y2 = (int)this.y2real;
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.orange);
      this.mOffScreenGC.fillRect(10, this.kyTopAbutment, 35, 20);
      this.mOffScreenGC.setColor(Color.black);
      double coil = (110 + y1 - this.kyTopAbutment - 20) / 10.0;
      this.mOffScreenGC.drawLine(18, this.kyTopAbutment + 20, 24, (int)(this.kyTopAbutment + 20 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            this.mOffScreenGC
               .drawLine(12, (int)(this.kyTopAbutment + 20 + (2 * p - 1) * coil / 2.0), 24, (int)(this.kyTopAbutment + 20 + (2 * p + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC
               .drawLine(24, (int)(this.kyTopAbutment + 20 + (2 * p - 1) * coil / 2.0), 12, (int)(this.kyTopAbutment + 20 + (2 * p + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(12, (int)(this.kyTopAbutment + 20 + 19.0 * coil / 2.0), 18, 110 + y1);
      this.mOffScreenGC.setColor(Color.black);
      this.mOffScreenGC.drawLine(32, this.kyTopAbutment + 20, 32, this.kyTopAbutment + 20 + 47);
      this.mOffScreenGC.drawLine(40, this.kyTopAbutment + 20, 40, this.kyTopAbutment + 20 + 47);
      this.mOffScreenGC.drawLine(32, this.kyTopAbutment + 20 + 47, 40, this.kyTopAbutment + 20 + 47);
      this.mOffScreenGC.drawLine(36, 110 + y1 - 48, 36, 110 + y1);
      this.mOffScreenGC.drawLine(33, 110 + y1 - 48, 39, 110 + y1 - 48);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.fillRect(10, 110 + y1, 35, 20);
      this.mOffScreenGC.setColor(force);
      this.mOffScreenGC.drawLine(45, 110 + y1 + 10, 65, 110 + y1 + 10);
      if (this.Farrow != 0) {
         if (this.Farrow > 0) {
            this.mOffScreenGC.drawLine(54, 110 + y1 + 10, 54, 110 + y1 + 10 + this.Farrow - 1);
            this.mOffScreenGC.drawLine(55, 110 + y1 + 10, 55, 110 + y1 + 10 + this.Farrow);
            this.mOffScreenGC.drawLine(56, 110 + y1 + 10, 56, 110 + y1 + 10 + this.Farrow - 1);
         }

         if (this.Farrow < 0) {
            this.mOffScreenGC.drawLine(54, 110 + y1 + 10, 54, 110 + y1 + 10 + this.Farrow + 1);
            this.mOffScreenGC.drawLine(55, 110 + y1 + 10, 55, 110 + y1 + 10 + this.Farrow);
            this.mOffScreenGC.drawLine(56, 110 + y1 + 10, 56, 110 + y1 + 10 + this.Farrow + 1);
         }
      }

      this.mOffScreenGC.setColor(Color.black);
      coil = (201 + y2 - 110 - 20 - y1) / 10.0;
      this.mOffScreenGC.drawLine(27, 130 + y1, 33, (int)(130 + y1 + coil / 2.0));

      for (int var14 = 1; var14 < 10; var14++) {
         if (var14 % 2 == 0) {
            this.mOffScreenGC.drawLine(21, (int)(130 + y1 + (2 * var14 - 1) * coil / 2.0), 33, (int)(130 + y1 + (2 * var14 + 1) * coil / 2.0));
         } else {
            this.mOffScreenGC.drawLine(33, (int)(130 + y1 + (2 * var14 - 1) * coil / 2.0), 21, (int)(130 + y1 + (2 * var14 + 1) * coil / 2.0));
         }
      }

      this.mOffScreenGC.drawLine(21, (int)(130 + y1 + 19.0 * coil / 2.0), 27, 201 + y2);
      this.mOffScreenGC.setColor(mass);
      this.mOffScreenGC.fillRect(10, 201 + y2, 35, 20);
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

package TwoDOF.Prog1.Modes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int km1Code = 2;
   public static final int kk1Code = 3;
   public static final int km2Code = 4;
   public static final int kk2Code = 5;
   public static final int kxEdge1 = 90;
   public static final int kxEdge2 = 290;
   public static final int kyTopAbutment = 49;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 35;
   public static final int kMassDepth = 20;
   public static final int kyTopMass1 = 140;
   public static final int kyTopMass2 = 231;
   static double dt = 0.01;
   public static final double kStartm1 = 1.0;
   public static final double kStartk1 = 8.0;
   public static final double kStartm2 = 1.0;
   public static final double kStartk2 = 8.0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public static final int kPaused = 2;
   public int mState;
   double mTime;
   double mViewTime;
   double mm1 = 1.0;
   double mk1 = 8.0;
   double mm2 = 1.0;
   double mk2 = 8.0;
   double mT;
   double myscale;
   double mdispmax;
   double mA;
   double mB;
   double mC;
   double mw1;
   double mw2;
   double mmode1;
   double mmode2;
   int mxEdge;
   public Button mStartButton;
   public Button mPauseButton;
   public Button mStopButton;
   boolean mDragMain;
   boolean mDragThumb;
   boolean mDragThumbnail;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mTime = 0.0;
      this.mA = this.mm1 * this.mm2;
      this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
      this.mC = this.mk1 * this.mk2;
      this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
      this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
      this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
      this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
   }

   public void Frame(Graphics g) {
      this.mxEdge = 90;
      double var4;
      double var6;
      if (Math.abs(this.mmode1) > 1.0) {
         var4 = 30.0;
         var6 = var4 / this.mmode1;
      } else {
         var6 = 30.0;
         var4 = var6 * this.mmode1;
      }

      int var2 = (int)(var4 * Math.sin(this.mw1 * this.mTime));
      int var3 = (int)(var6 * Math.sin(this.mw1 * this.mTime));
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge, 49, 35, 20);
      g.setColor(Color.black);
      double var9 = (140 + var2 - 49 - 20) / 10.0;
      g.drawLine(this.mxEdge + 17, 69, this.mxEdge + 17 + 6, (int)(69.0 + var9 / 2.0));

      for (int i = 1; i < 10; i++) {
         if (i % 2 == 0) {
            g.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + (2 * i - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(69.0 + (2 * i + 1) * var9 / 2.0));
         } else {
            g.drawLine(this.mxEdge + 17 + 6, (int)(69.0 + (2 * i - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(69.0 + (2 * i + 1) * var9 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + 19.0 * var9 / 2.0), this.mxEdge + 17, 140 + var2);
      Color var11 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var11);
      g.fillRect(this.mxEdge, 140 + var2, 35, 20);
      g.setColor(Color.black);
      var9 = (231 + var3 - 140 - 20 - var2) / 10.0;
      g.drawLine(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6, (int)(160 + var2 + var9 / 2.0));

      for (int j = 1; j < 10; j++) {
         if (j % 2 == 0) {
            g.drawLine(
               this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * j - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * j + 1) * var9 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * j - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * j + 1) * var9 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 17 - 6, (int)(160 + var2 + 19.0 * var9 / 2.0), this.mxEdge + 17, 231 + var3);
      g.setColor(var11);
      g.fillRect(this.mxEdge, 231 + var3, 35, 20);
      this.mxEdge = 290;
      if (Math.abs(this.mmode2) > 1.0) {
         var4 = 30.0;
         var6 = var4 / this.mmode2;
      } else {
         var6 = 30.0;
         var4 = var6 * this.mmode2;
      }

      var2 = (int)(var4 * Math.sin(this.mw2 * this.mTime));
      var3 = (int)(var6 * Math.sin(this.mw2 * this.mTime));
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge, 49, 35, 20);
      g.setColor(Color.black);
      var9 = (140 + var2 - 49 - 20) / 10.0;
      g.drawLine(this.mxEdge + 17, 69, this.mxEdge + 17 + 6, (int)(69.0 + var9 / 2.0));

      for (int k = 1; k < 10; k++) {
         if (k % 2 == 0) {
            g.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + (2 * k - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(69.0 + (2 * k + 1) * var9 / 2.0));
         } else {
            g.drawLine(this.mxEdge + 17 + 6, (int)(69.0 + (2 * k - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(69.0 + (2 * k + 1) * var9 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + 19.0 * var9 / 2.0), this.mxEdge + 17, 140 + var2);
      g.setColor(var11);
      g.fillRect(this.mxEdge, 140 + var2, 35, 20);
      g.setColor(Color.black);
      var9 = (231 + var3 - 140 - 20 - var2) / 10.0;
      g.drawLine(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6, (int)(160 + var2 + var9 / 2.0));

      for (int var18 = 1; var18 < 10; var18++) {
         if (var18 % 2 == 0) {
            g.drawLine(
               this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var18 - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var18 + 1) * var9 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var18 - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var18 + 1) * var9 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 17 - 6, (int)(160 + var2 + 19.0 * var9 / 2.0), this.mxEdge + 17, 231 + var3);
      g.setColor(var11);
      g.fillRect(this.mxEdge, 231 + var3, 35, 20);
      g.setColor(Color.black);
      g.drawString("First Mode", 80, 295);
      g.drawString(" Natural frequency " + CUtility.nns(this.mw1 / (Math.PI * 2)) + " Hz", 30, 315);
      g.drawString(" Mode shape " + CUtility.nns(this.mmode1), 30, 335);
      g.drawString("Second Mode", 280, 295);
      g.drawString(" Natural frequency " + CUtility.nns(this.mw2 / (Math.PI * 2)) + " Hz", 230, 315);
      g.drawString(" Mode shape " + CUtility.nns(this.mmode2), 230, 335);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)val);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mm1 = val;
            this.mA = this.mm1 * this.mm2;
            this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
            this.mC = this.mk1 * this.mk2;
            this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
            this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mk1 = val;
            this.mA = this.mm1 * this.mm2;
            this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
            this.mC = this.mk1 * this.mk2;
            this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
            this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mm2 = val;
            this.mA = this.mm1 * this.mm2;
            this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
            this.mC = this.mk1 * this.mk2;
            this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
            this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mk2 = val;
            this.mA = this.mm1 * this.mm2;
            this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
            this.mC = this.mk1 * this.mk2;
            this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
            this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
            this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void ChangeRunState(int newState) {
      switch (this.mState) {
         case 0:
            if (newState == 1) {
               this.mTime = 0.0;
               this.mState = 1;
            }
            break;
         case 1:
            if (newState == 2 || newState == 0) {
               this.mState = newState;
            }
            break;
         case 2:
            if (newState == 0 || newState == 1) {
               this.mState = newState;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }

   public void UserDrag(int offset) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - offset * dt;
      this.repaint();
   }
}

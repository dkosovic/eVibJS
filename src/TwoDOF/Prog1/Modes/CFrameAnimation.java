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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mTime = 0.0;
      this.mA = this.mm1 * this.mm2;
      this.mB = -(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
      this.mC = this.mk1 * this.mk2;
      this.mw1 = Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
      this.mw2 = Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC)) / (2.0 * this.mA));
      this.mmode1 = 1.0 - this.mm2 * this.mw1 * this.mw1 / this.mk2;
      this.mmode2 = 1.0 - this.mm2 * this.mw2 * this.mw2 / this.mk2;
   }

   public void Frame(Graphics var1) {
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
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge, 49, 35, 20);
      var1.setColor(Color.black);
      double var9 = (140 + var2 - 49 - 20) / 10.0;
      var1.drawLine(this.mxEdge + 17, 69, this.mxEdge + 17 + 6, (int)(69.0 + var9 / 2.0));

      for (int var8 = 1; var8 < 10; var8++) {
         if (var8 % 2 == 0) {
            var1.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + (2 * var8 - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(69.0 + (2 * var8 + 1) * var9 / 2.0));
         } else {
            var1.drawLine(this.mxEdge + 17 + 6, (int)(69.0 + (2 * var8 - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(69.0 + (2 * var8 + 1) * var9 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + 19.0 * var9 / 2.0), this.mxEdge + 17, 140 + var2);
      Color var11 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(var11);
      var1.fillRect(this.mxEdge, 140 + var2, 35, 20);
      var1.setColor(Color.black);
      var9 = (231 + var3 - 140 - 20 - var2) / 10.0;
      var1.drawLine(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6, (int)(160 + var2 + var9 / 2.0));

      for (int var16 = 1; var16 < 10; var16++) {
         if (var16 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var16 - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var16 + 1) * var9 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var16 - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var16 + 1) * var9 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 17 - 6, (int)(160 + var2 + 19.0 * var9 / 2.0), this.mxEdge + 17, 231 + var3);
      var1.setColor(var11);
      var1.fillRect(this.mxEdge, 231 + var3, 35, 20);
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
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge, 49, 35, 20);
      var1.setColor(Color.black);
      var9 = (140 + var2 - 49 - 20) / 10.0;
      var1.drawLine(this.mxEdge + 17, 69, this.mxEdge + 17 + 6, (int)(69.0 + var9 / 2.0));

      for (int var17 = 1; var17 < 10; var17++) {
         if (var17 % 2 == 0) {
            var1.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + (2 * var17 - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(69.0 + (2 * var17 + 1) * var9 / 2.0));
         } else {
            var1.drawLine(this.mxEdge + 17 + 6, (int)(69.0 + (2 * var17 - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(69.0 + (2 * var17 + 1) * var9 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 17 - 6, (int)(69.0 + 19.0 * var9 / 2.0), this.mxEdge + 17, 140 + var2);
      var1.setColor(var11);
      var1.fillRect(this.mxEdge, 140 + var2, 35, 20);
      var1.setColor(Color.black);
      var9 = (231 + var3 - 140 - 20 - var2) / 10.0;
      var1.drawLine(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6, (int)(160 + var2 + var9 / 2.0));

      for (int var18 = 1; var18 < 10; var18++) {
         if (var18 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var18 - 1) * var9 / 2.0), this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var18 + 1) * var9 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 17 + 6, (int)(160 + var2 + (2 * var18 - 1) * var9 / 2.0), this.mxEdge + 17 - 6, (int)(160 + var2 + (2 * var18 + 1) * var9 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 17 - 6, (int)(160 + var2 + 19.0 * var9 / 2.0), this.mxEdge + 17, 231 + var3);
      var1.setColor(var11);
      var1.fillRect(this.mxEdge, 231 + var3, 35, 20);
      var1.setColor(Color.black);
      var1.drawString("First Mode", 80, 295);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mw1 / (Math.PI * 2)) + " Hz", 30, 315);
      var1.drawString(" Mode shape " + CUtility.nns(this.mmode1), 30, 335);
      var1.drawString("Second Mode", 280, 295);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mw2 / (Math.PI * 2)) + " Hz", 230, 315);
      var1.drawString(" Mode shape " + CUtility.nns(this.mmode2), 230, 335);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 0:
            if (this.mState == 1) {
               this.mTime += var3;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)var3);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mm1 = var3;
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
            this.mk1 = var3;
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
            this.mm2 = var3;
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
            this.mk2 = var3;
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

   public void ChangeRunState(int var1) {
      switch (this.mState) {
         case 0:
            if (var1 == 1) {
               this.mTime = 0.0;
               this.mState = 1;
            }
            break;
         case 1:
            if (var1 == 2 || var1 == 0) {
               this.mState = var1;
            }
            break;
         case 2:
            if (var1 == 0 || var1 == 1) {
               this.mState = var1;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }

   public void UserDrag(int var1) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - var1 * dt;
      this.repaint();
   }
}

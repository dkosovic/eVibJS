package Beam.Prog3.Modes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kmCode = 2;
   public static final int kk1Code = 3;
   public static final int kk2Code = 4;
   public static final int kA1Code = 5;
   public static final int kA2Code = 6;
   public static final int kxEdge1 = 20;
   public static final int kxEdge2 = 290;
   public static final int kxEdge3 = 550;
   public static final int kyTopAbutment = 185;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 200;
   public static final int kyTopMass = 111;
   public static final int kFdiagram = 200;
   static double dt = 0.01;
   public static final double kStartm = 2.0;
   public static final double kStartk1 = 20.0;
   public static final double kStartk2 = 20.0;
   public static final double kStartA1 = 40.0;
   public static final double kStartA2 = 0.0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public static final int kPaused = 2;
   public int mState;
   double mTime;
   double mViewTime;
   double mm = 2.0;
   double mk1 = 20.0;
   double mk2 = 20.0;
   double mA1 = 40.0;
   double mA2 = 0.0;
   double mT;
   double myscale;
   double mdispmax;
   double mB;
   double mw1;
   double mw2;
   double mmode1;
   double mmode2;
   double ma11;
   double ma12;
   double ma21;
   double ma22;
   int mxEdge;
   double[] mX1;
   double[] mY1;
   double[] mF1;
   double[] mX2;
   double[] mY2;
   double[] mF2;
   public Button mStartButton;
   public Button mPauseButton;
   public Button mStopButton;
   boolean mDragMain;
   boolean mDragThumb;
   boolean mDragThumbnail;

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mTime = 0.0;
      this.mB = Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2) - 12.0 * this.mk1 * this.mk2);
      this.mw1 = Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
      this.mw2 = Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
      this.mmode1 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1);
      this.mmode2 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2);
      this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
      this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
      this.ma11 = this.mmode1 * this.ma21;
      this.ma12 = this.mmode2 * this.ma22;
   }

   public void Frame(Graphics var1) {
      this.mxEdge = 20;
      int var2 = (int)(this.ma11 * Math.cos(this.mw1 * this.mTime) + this.ma12 * Math.cos(this.mw2 * this.mTime));
      int var3 = (int)(this.ma21 * Math.cos(this.mw1 * this.mTime) + this.ma22 * Math.cos(this.mw2 * this.mTime));
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 185, 220, 20);
      var1.setColor(Color.black);
      double var9 = (113 + var2 - 185) / 10.0;
      var1.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int var8 = 1; var8 < 10; var8++) {
         if (var8 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * var8 - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * var8 + 1) * var9 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * var8 - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * var8 + 1) * var9 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      var1.setColor(Color.black);
      double var11 = (113 + var3 - 185) / 10.0;
      var1.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int var18 = 1; var18 < 10; var18++) {
         if (var18 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * var18 - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * var18 + 1) * var11 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * var18 - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * var18 + 1) * var11 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      Color var13 = new Color(0.18F, 0.58F, 0.58F);
      var1.setColor(var13);
      var1.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      var1.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      var1.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      this.mxEdge = 290;
      var2 = (int)(this.ma11 * Math.cos(this.mw1 * this.mTime));
      var3 = (int)(this.ma21 * Math.cos(this.mw1 * this.mTime));
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 185, 220, 20);
      var1.setColor(Color.black);
      var9 = (113 + var2 - 185) / 10.0;
      var1.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int var19 = 1; var19 < 10; var19++) {
         if (var19 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * var19 - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * var19 + 1) * var9 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * var19 - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * var19 + 1) * var9 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      var1.setColor(Color.black);
      var11 = (113 + var3 - 185) / 10.0;
      var1.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int var20 = 1; var20 < 10; var20++) {
         if (var20 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * var20 - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * var20 + 1) * var11 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * var20 - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * var20 + 1) * var11 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      var1.setColor(var13);
      var1.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      var1.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      var1.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      this.mxEdge = 550;
      var2 = (int)(this.ma12 * Math.cos(this.mw2 * this.mTime));
      var3 = (int)(this.ma22 * Math.cos(this.mw2 * this.mTime));
      var1.setColor(Color.orange);
      var1.fillRect(this.mxEdge - 10, 185, 220, 20);
      var1.setColor(Color.black);
      var9 = (113 + var2 - 185) / 10.0;
      var1.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int var21 = 1; var21 < 10; var21++) {
         if (var21 % 2 == 0) {
            var1.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * var21 - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * var21 + 1) * var9 / 2.0));
         } else {
            var1.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * var21 - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * var21 + 1) * var9 / 2.0));
         }
      }

      var1.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      var1.setColor(Color.black);
      var11 = (113 + var3 - 185) / 10.0;
      var1.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int var22 = 1; var22 < 10; var22++) {
         if (var22 % 2 == 0) {
            var1.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * var22 - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * var22 + 1) * var11 / 2.0)
            );
         } else {
            var1.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * var22 - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * var22 + 1) * var11 / 2.0)
            );
         }
      }

      var1.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      var1.setColor(var13);
      var1.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      var1.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      var1.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      var1.setColor(Color.black);
      var1.drawString(" Resultant motion", 75, 225);
      var1.drawString(" First Mode contribution", 320, 225);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mw1 / (Math.PI * 2)) + " Hz", 320, 245);
      var1.drawString(" Mode shape " + CUtility.nns(this.mmode1), 320, 265);
      var1.drawString(" Second Mode contribution", 580, 225);
      var1.drawString(" Natural frequency " + CUtility.nns(this.mw2 / (Math.PI * 2)) + " Hz", 580, 245);
      var1.drawString(" Mode shape " + CUtility.nns(this.mmode2), 580, 265);
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
            this.mm = var3;
            this.mB = Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2) - 12.0 * this.mk1 * this.mk2);
            this.mw1 = Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
            this.mw2 = Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
            this.mmode1 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1);
            this.mmode2 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2);
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mk1 = var3;
            this.mB = Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2) - 12.0 * this.mk1 * this.mk2);
            this.mw1 = Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
            this.mw2 = Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
            this.mmode1 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1);
            this.mmode2 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2);
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mk2 = var3;
            this.mB = Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2) - 12.0 * this.mk1 * this.mk2);
            this.mw1 = Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
            this.mw2 = Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
            this.mmode1 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1);
            this.mmode2 = 2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2);
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mA1 = var3;
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
            break;
         case 6:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mA2 = var3;
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
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

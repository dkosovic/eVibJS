package Beam.Prog3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
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

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
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

   public void Frame(Graphics g) {
      this.mxEdge = 20;
      int var2 = (int)(this.ma11 * Math.cos(this.mw1 * this.mTime) + this.ma12 * Math.cos(this.mw2 * this.mTime));
      int var3 = (int)(this.ma21 * Math.cos(this.mw1 * this.mTime) + this.ma22 * Math.cos(this.mw2 * this.mTime));
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 185, 220, 20);
      g.setColor(Color.black);
      double var9 = (113 + var2 - 185) / 10.0;
      g.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int i = 1; i < 10; i++) {
         if (i % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * i - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * i + 1) * var9 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * i - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * i + 1) * var9 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      g.setColor(Color.black);
      double var11 = (113 + var3 - 185) / 10.0;
      g.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int j = 1; j < 10; j++) {
         if (j % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * j - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * j + 1) * var11 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * j - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * j + 1) * var11 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      Color var13 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var13);
      g.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      g.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      g.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      this.mxEdge = 290;
      var2 = (int)(this.ma11 * Math.cos(this.mw1 * this.mTime));
      var3 = (int)(this.ma21 * Math.cos(this.mw1 * this.mTime));
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 185, 220, 20);
      g.setColor(Color.black);
      var9 = (113 + var2 - 185) / 10.0;
      g.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int k = 1; k < 10; k++) {
         if (k % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * k - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * k + 1) * var9 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * k - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * k + 1) * var9 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      g.setColor(Color.black);
      var11 = (113 + var3 - 185) / 10.0;
      g.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int var20 = 1; var20 < 10; var20++) {
         if (var20 % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * var20 - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * var20 + 1) * var11 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * var20 - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * var20 + 1) * var11 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      g.setColor(var13);
      g.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      g.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      g.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      this.mxEdge = 550;
      var2 = (int)(this.ma12 * Math.cos(this.mw2 * this.mTime));
      var3 = (int)(this.ma22 * Math.cos(this.mw2 * this.mTime));
      g.setColor(Color.orange);
      g.fillRect(this.mxEdge - 10, 185, 220, 20);
      g.setColor(Color.black);
      var9 = (113 + var2 - 185) / 10.0;
      g.drawLine(this.mxEdge, 185, this.mxEdge - 6, (int)(185.0 + var9 / 2.0));

      for (int var21 = 1; var21 < 10; var21++) {
         if (var21 % 2 == 0) {
            g.drawLine(this.mxEdge + 6, (int)(185.0 + (2 * var21 - 1) * var9 / 2.0), this.mxEdge - 6, (int)(185.0 + (2 * var21 + 1) * var9 / 2.0));
         } else {
            g.drawLine(this.mxEdge - 6, (int)(185.0 + (2 * var21 - 1) * var9 / 2.0), this.mxEdge + 6, (int)(185.0 + (2 * var21 + 1) * var9 / 2.0));
         }
      }

      g.drawLine(this.mxEdge + 6, (int)(185.0 + 19.0 * var9 / 2.0), this.mxEdge, 111 + var2 + 2);
      g.setColor(Color.black);
      var11 = (113 + var3 - 185) / 10.0;
      g.drawLine(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, (int)(185.0 + var11 / 2.0));

      for (int var22 = 1; var22 < 10; var22++) {
         if (var22 % 2 == 0) {
            g.drawLine(
               this.mxEdge + 200 + 6, (int)(185.0 + (2 * var22 - 1) * var11 / 2.0), this.mxEdge + 200 - 6, (int)(185.0 + (2 * var22 + 1) * var11 / 2.0)
            );
         } else {
            g.drawLine(
               this.mxEdge + 200 - 6, (int)(185.0 + (2 * var22 - 1) * var11 / 2.0), this.mxEdge + 200 + 6, (int)(185.0 + (2 * var22 + 1) * var11 / 2.0)
            );
         }
      }

      g.drawLine(this.mxEdge + 200 + 6, (int)(185.0 + 19.0 * var11 / 2.0), this.mxEdge + 200, 111 + var3 + 2);
      g.setColor(var13);
      g.drawLine(this.mxEdge, 111 + var2 + 1, this.mxEdge + 200, 111 + var3 + 1);
      g.drawLine(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
      g.drawLine(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
      g.setColor(Color.black);
      g.drawString(" Resultant motion", 75, 225);
      g.drawString(" First Mode contribution", 320, 225);
      g.drawString(" Natural frequency " + CUtility.nns(this.mw1 / (Math.PI * 2)) + " Hz", 320, 245);
      g.drawString(" Mode shape " + CUtility.nns(this.mmode1), 320, 265);
      g.drawString(" Second Mode contribution", 580, 225);
      g.drawString(" Natural frequency " + CUtility.nns(this.mw2 / (Math.PI * 2)) + " Hz", 580, 245);
      g.drawString(" Mode shape " + CUtility.nns(this.mmode2), 580, 265);
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
            this.mm = val;
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
            this.mk1 = val;
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
            this.mk2 = val;
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
            this.mA1 = val;
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
            break;
         case 6:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mA2 = val;
            this.ma22 = (this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
            this.ma21 = (this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
            this.ma11 = this.mmode1 * this.ma21;
            this.ma12 = this.mmode2 * this.ma22;
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

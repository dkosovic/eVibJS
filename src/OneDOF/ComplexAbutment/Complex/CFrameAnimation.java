package OneDOF.ComplexAbutment.Complex;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kWCode = 2;
   public static final int kXoCode = 3;
   public static final int kXCode = 4;
   public static final int kPhiCode = 5;
   public static final int kXo = 500;
   public static final int kYo = 160;
   public static final int kEdge = 350;
   public static final int kArcRadius = 15;
   static double dt = 0.01;
   public static final double kStartW = 0.5;
   public static final double kStartXo = 85.0;
   public static final double kStartX = 40.0;
   public static final double kStartPhi = -60.0;
   public static final double kStartXoangle = 20.0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public int mState;
   boolean mFirstTime;
   double mTime;
   double mViewTime;
   double mW = 0.5;
   double mXo = 85.0;
   double mX = 40.0;
   double mPhi = -60.0;
   public Button mStartButton;
   public Button mStopButton;
   CFrameHelp mSpringHelp;
   CFrameHelp mDamperHelp;
   CFrameHelp mMassHelp;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mFirstTime = true;
   }

   public void Frame(Graphics g) {
      if (this.mFirstTime) {
         this.mFirstTime = false;
         this.mTime = 0.0;
         this.mViewTime = 0.0;
      }

      Color var8 = new Color(0.18F, 0.58F, 0.58F);
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.lightGray);
      g.drawLine(10, 160, 350, 160);
      g.drawLine(360, 160, 510, 160);
      g.drawLine(500, 150, 500, 170);
      g.setColor(Color.green);
      int var3 = (int)(this.mW * this.mTime * 360.0 + 20.0);
      g.fillArc(485, 145, 30, 30, var3, (int)this.mPhi);
      g.setColor(Color.white);
      g.fillArc(487, 147, 26, 26, var3, (int)this.mPhi);
      g.setColor(Color.orange);
      int var5 = (int)(this.mXo * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      int var4 = (int)(-this.mXo * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      g.drawLine(500, 160, 500 + var5, 160 + var4);
      g.drawLine(500 + var5, 160 + var4, 350, 160 + var4);

      for (int i = 0; i < 170; i++) {
         g.drawLine(
            350 - i * 2,
            160 + (int)(-this.mXo * Math.sin(this.mW * (this.mTime - i * 0.025) * 2.0 * Math.PI + (Math.PI / 9))),
            350 - (i + 1) * 2,
            160 + (int)(-this.mXo * Math.sin(this.mW * (this.mTime - (i + 1) * 0.025) * 2.0 * Math.PI + (Math.PI / 9)))
         );
      }

      g.setColor(var8);
      int var7 = (int)(this.mX * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      int var6 = (int)(-this.mX * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      g.drawLine(500, 160, 500 + var7, 160 + var6);
      g.drawLine(500 + var7, 160 + var6, 350, 160 + var6);

      for (int j = 0; j < 170; j++) {
         g.drawLine(
            350 - j * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - j * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0)),
            350 - (j + 1) * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - (j + 1) * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0))
         );
      }

      g.setColor(Color.black);
      g.drawRect(10, 50, 340, 220);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
               this.mViewTime = this.mTime;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)val);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mW = val;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mXo = val;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mX = val;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mPhi = val;
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
               this.mViewTime = 0.0;
               this.mFirstTime = true;
               this.mState = 1;
            }
            break;
         case 1:
            if (newState == 0) {
               this.mState = newState;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }
}

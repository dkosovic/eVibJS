import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kWCode = 2;
   public static final int kFCode = 3;
   public static final int kXCode = 4;
   public static final int kPhiCode = 5;
   public static final int kXo = 500;
   public static final int kYo = 160;
   public static final int kEdge = 350;
   public static final int kArcRadius = 15;
   static double dt = 0.01;
   public static final double kStartW = 0.5;
   public static final double kStartF = 85.0;
   public static final double kStartX = 40.0;
   public static final double kStartPhi = -60.0;
   public static final double kStartFangle = 20.0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public int mState;
   boolean mFirstTime;
   double mTime;
   double mViewTime;
   double mW = 0.5;
   double mF = 85.0;
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

      Color mass = new Color(0.18F, 0.58F, 0.58F);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.lightGray);
      g.drawLine(10, 160, 350, 160);
      g.drawLine(360, 160, 510, 160);
      g.drawLine(500, 150, 500, 170);
      g.setColor(Color.green);
      int rotation = (int)(this.mW * this.mTime * 360.0 + 20.0);
      g.fillArc(485, 145, 30, 30, rotation, (int)this.mPhi);
      g.setColor(Color.white);
      g.fillArc(487, 147, 26, 26, rotation, (int)this.mPhi);
      g.setColor(force);
      int mxforF = (int)(this.mF * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      int myforF = (int)(-this.mF * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      g.drawLine(500, 160, 500 + mxforF, 160 + myforF);
      g.drawLine(500 + mxforF, 160 + myforF, 350, 160 + myforF);

      for (int p = 0; p < 170; p++) {
         g.drawLine(
            350 - p * 2,
            160 + (int)(-this.mF * Math.sin(this.mW * (this.mTime - p * 0.025) * 2.0 * Math.PI + (Math.PI / 9))),
            350 - (p + 1) * 2,
            160 + (int)(-this.mF * Math.sin(this.mW * (this.mTime - (p + 1) * 0.025) * 2.0 * Math.PI + (Math.PI / 9)))
         );
      }

      g.setColor(mass);
      int mxforX = (int)(this.mX * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      int myforX = (int)(-this.mX * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      g.drawLine(500, 160, 500 + mxforX, 160 + myforX);
      g.drawLine(500 + mxforX, 160 + myforX, 350, 160 + myforX);

      for (int var10 = 0; var10 < 170; var10++) {
         g.drawLine(
            350 - var10 * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - var10 * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0)),
            350 - (var10 + 1) * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - (var10 + 1) * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0))
         );
      }

      g.setColor(Color.black);
      g.drawRect(10, 50, 340, 220);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
               this.mViewTime = this.mTime;
            }

            mustRedraw = true;
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
            this.mF = val;
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

      if (mustRedraw) {
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

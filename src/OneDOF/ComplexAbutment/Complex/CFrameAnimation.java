import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mFirstTime = true;
   }

   public void Frame(Graphics var1) {
      if (this.mFirstTime) {
         this.mFirstTime = false;
         this.mTime = 0.0;
         this.mViewTime = 0.0;
      }

      Color var8 = new Color(0.18F, 0.58F, 0.58F);
      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.lightGray);
      var1.drawLine(10, 160, 350, 160);
      var1.drawLine(360, 160, 510, 160);
      var1.drawLine(500, 150, 500, 170);
      var1.setColor(Color.green);
      int var3 = (int)(this.mW * this.mTime * 360.0 + 20.0);
      var1.fillArc(485, 145, 30, 30, var3, (int)this.mPhi);
      var1.setColor(Color.white);
      var1.fillArc(487, 147, 26, 26, var3, (int)this.mPhi);
      var1.setColor(Color.orange);
      int var5 = (int)(this.mXo * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      int var4 = (int)(-this.mXo * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (Math.PI / 9)));
      var1.drawLine(500, 160, 500 + var5, 160 + var4);
      var1.drawLine(500 + var5, 160 + var4, 350, 160 + var4);

      for (int var2 = 0; var2 < 170; var2++) {
         var1.drawLine(
            350 - var2 * 2,
            160 + (int)(-this.mXo * Math.sin(this.mW * (this.mTime - var2 * 0.025) * 2.0 * Math.PI + (Math.PI / 9))),
            350 - (var2 + 1) * 2,
            160 + (int)(-this.mXo * Math.sin(this.mW * (this.mTime - (var2 + 1) * 0.025) * 2.0 * Math.PI + (Math.PI / 9)))
         );
      }

      var1.setColor(var8);
      int var7 = (int)(this.mX * Math.cos(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      int var6 = (int)(-this.mX * Math.sin(this.mW * this.mTime * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0));
      var1.drawLine(500, 160, 500 + var7, 160 + var6);
      var1.drawLine(500 + var7, 160 + var6, 350, 160 + var6);

      for (int var9 = 0; var9 < 170; var9++) {
         var1.drawLine(
            350 - var9 * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - var9 * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0)),
            350 - (var9 + 1) * 2,
            160 + (int)(-this.mX * Math.sin(this.mW * (this.mTime - (var9 + 1) * 0.025) * 2.0 * Math.PI + (this.mPhi + 20.0) * Math.PI / 180.0))
         );
      }

      var1.setColor(Color.black);
      var1.drawRect(10, 50, 340, 220);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 0:
            if (this.mState == 1) {
               this.mTime += var3;
               this.mViewTime = this.mTime;
            }

            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)var3);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mW = var3;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mXo = var3;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mX = var3;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mPhi = var3;
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
               this.mViewTime = 0.0;
               this.mFirstTime = true;
               this.mState = 1;
            }
            break;
         case 1:
            if (var1 == 0) {
               this.mState = var1;
            }
      }

      this.UpdateButtonAppearance();
   }

   public void UpdateButtonAppearance() {
      super.mFramePanel.repaint();
   }
}

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kMassCode = 2;
   public static final int kKCode = 3;
   public static final int kDeltaCode = 4;
   public static final int kXoCode = 5;
   public static final int kYoCode = 6;
   public static final int kOnOffCode = 7;
   public static final int kabutmentwidth = 30;
   public static final int kY0 = 160;
   public static final int kLo = 100;
   public static final int koffset = 10;
   public static final double kdt = 0.01;
   public static final double kg = 9.81;
   public static final double kStartMass = 1.0;
   public static final double kStartK = 10.0;
   public static final double kStartDelta = -10.0;
   public static final double kStartXo = 6.0;
   public static final double kStartYo = 10.0;
   public static final int kStartOnOff = 0;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public static final int kPaused = 2;
   public int mState;
   boolean mFirstTime;
   double mTime;
   double mMass = 1.0;
   double mK = 10.0;
   double mDelta = -10.0;
   double mXo = 6.0;
   double mYo = 10.0;
   int mOnOff = 0;
   double mt;
   double mXpos;
   double mYpos;
   double mVpos = 0.0;
   double mSpos = 0.0;
   int mXe;
   int mYe;
   double[] mXplot = new double[105];
   double[] mYplot = new double[105];
   int mpoints = 0;
   double[] mXspring;
   double[] mYspring;
   int mspringpoints;
   public Button mStartButton;
   public Button mPauseButton;
   public Button mStopButton;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mXplot[this.mpoints] = this.mXo;
      this.mYplot[this.mpoints] = this.mYo;
      this.mXspring = new double[25];
      this.mYspring = new double[25];
      this.mspringpoints = 1;
      this.mFirstTime = true;
      this.mState = 0;
   }

   public void Frame(Graphics g) {
      if (this.mFirstTime) {
         this.reset();
      }

      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(Color.orange);
      g.fillRect(10, 130, 30, 60);
      g.fillRect(40 + (int)(200.0 * (1.0 + this.mDelta / 100.0)), 130, 30, 60);
      g.setColor(Color.black);
      this.Spring(40.0, 160.0, 40.0 + 100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos, 160.0 + this.mYpos);

      for (int p = 1; p < this.mspringpoints; p++) {
         g.drawLine((int)this.mXspring[p], (int)this.mYspring[p], (int)this.mXspring[p + 1], (int)this.mYspring[p + 1]);
      }

      this.Spring(40.0 + 100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos, 160.0 + this.mYpos, 40.0 + 200.0 * (1.0 + this.mDelta / 100.0), 160.0);

      for (int var14 = 1; var14 < this.mspringpoints; var14++) {
         g.drawLine((int)this.mXspring[var14], (int)this.mYspring[var14], (int)this.mXspring[var14 + 1], (int)this.mYspring[var14 + 1]);
      }

      g.setColor(mass);
      g.fillOval(40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos) - 10, 160 + (int)this.mYpos - 10, 20, 20);
      g.setColor(Color.black);
      this.mXe = 40 + (int)(100.0 * (1.0 + this.mDelta / 100.0));
      double malphasol = 0.0;
      int var15 = 1;
      double malpha = (Math.PI / 2) - Math.PI * var15 / 200.0;
      double mf = 100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha));
      double mylast = mf;

      for (int var16 = 2; var16 < 100; var16++) {
         malpha = (Math.PI / 2) - Math.PI * var16 / 200.0;
         mf = 100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha));
         if (mylast * mf < 0.0) {
            malphasol = (Math.PI / 2) - Math.PI * (var16 - 0.5) / 200.0;
            this.mYe = 160 + (int)(100.0 * (1.0 + this.mDelta / 100.0) * Math.tan(malphasol));
            g.drawLine(this.mXe - 2, this.mYe - 2, this.mXe + 2, this.mYe + 2);
            g.drawLine(this.mXe - 2, this.mYe + 2, this.mXe + 2, this.mYe - 2);
         }

         mylast = mf;
      }

      var15 = 1;
      malpha = -Math.PI * var15 / 200.0;
      mf = 100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha));
      mylast = mf;

      for (int var18 = 2; var18 < 100; var18++) {
         malpha = -Math.PI * var18 / 200.0;
         mf = 100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha));
         if (mylast * mf < 0.0) {
            malphasol = -Math.PI * (var18 - 0.5) / 200.0;
         }

         mylast = mf;
      }

      this.mYe = 160 + (int)(100.0 * (1.0 + this.mDelta / 100.0) * Math.tan(malphasol));
      g.drawLine(this.mXe - 2, this.mYe - 2, this.mXe + 2, this.mYe + 2);
      g.drawLine(this.mXe - 2, this.mYe + 2, this.mXe + 2, this.mYe - 2);
      g.drawLine(418, 398, 422, 402);
      g.drawLine(418, 402, 422, 398);
      g.drawString("-  Equilibrium position(s)", 430, 404);
      this.Increment();
      if (this.mOnOff == 1) {
         g.setColor(Color.black);
         g.drawRect(40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) - Math.abs(this.mXo) - 10.0), 340, (int)(2.0 * Math.abs(this.mXo) + 20.0), 100);
         g.setColor(Color.black);
         g.drawRect(490, 50, 100, 290);
         g.setColor(mass);
         g.drawLine(
            40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos),
            160 + (int)this.mYpos,
            40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos),
            340
         );

         for (int var19 = 1; var19 < this.mpoints; var19++) {
            g.drawLine(
               40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXplot[var19]),
               340 + this.mpoints - var19,
               40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXplot[var19 + 1]),
               340 + this.mpoints - var19 - 1
            );
         }

         g.drawLine(40 + (int)(100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos), 160 + (int)this.mYpos, 490, 160 + (int)this.mYpos);

         for (int var20 = 1; var20 < this.mpoints; var20++) {
            g.drawLine(490 + this.mpoints - var20, 160 + (int)this.mYplot[var20], 490 + this.mpoints - var20 - 1, 160 + (int)this.mYplot[var20 + 1]);
         }
      }

      g.setPaintMode();
   }

   public void reset() {
      this.mFirstTime = false;
      this.mTime = 0.0;
      this.mt = 0.0;
      this.mXpos = this.mXo;
      this.mYpos = this.mYo;
      this.mVpos = 0.0;
      this.mSpos = 0.0;
      this.mpoints = 0;
   }

   public void Increment() {
      if (this.mFirstTime) {
         this.reset();
      }

      if (this.mState == 1) {
         this.mt += 0.01;
         double mdtx2 = 0.02;
         double mX1 = this.mXpos;
         double mY1 = this.mYpos;
         double mV1 = this.mVpos;
         double mS1 = this.mSpos;
         double hypotenuse1 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX1) * (100.0 * (1.0 + this.mDelta / 100.0) + mX1) + mY1 * mY1);
         double hypotenuse2 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX1) * (100.0 * (1.0 + this.mDelta / 100.0) - mX1) + mY1 * mY1);
         double sinalpha1 = mY1 / hypotenuse1;
         double cosalpha1 = (100.0 * (1.0 + this.mDelta / 100.0) + mX1) / hypotenuse1;
         double sinalpha2 = mY1 / hypotenuse2;
         double cosalpha2 = (100.0 * (1.0 + this.mDelta / 100.0) - mX1) / hypotenuse2;
         double delta1 = hypotenuse1 - 100.0;
         double delta2 = hypotenuse2 - 100.0;
         double mF1 = (this.mK * delta2 * cosalpha2 - this.mK * delta1 * cosalpha1) / this.mMass;
         double mX2 = mX1 + mV1 * mdtx2 / 2.0;
         double mV2 = mV1 + mF1 * mdtx2 / 2.0;
         double mP1 = (this.mMass * 9.81 - this.mK * delta2 * sinalpha2 - this.mK * delta1 * sinalpha1) / this.mMass;
         double mY2 = mY1 + mS1 * mdtx2 / 2.0;
         double mS2 = mS1 + mP1 * mdtx2 / 2.0;
         hypotenuse1 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX2) * (100.0 * (1.0 + this.mDelta / 100.0) + mX2) + mY2 * mY2);
         hypotenuse2 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX2) * (100.0 * (1.0 + this.mDelta / 100.0) - mX2) + mY2 * mY2);
         sinalpha1 = mY2 / hypotenuse1;
         cosalpha1 = (100.0 * (1.0 + this.mDelta / 100.0) + mX2) / hypotenuse1;
         sinalpha2 = mY2 / hypotenuse2;
         cosalpha2 = (100.0 * (1.0 + this.mDelta / 100.0) - mX2) / hypotenuse2;
         delta1 = hypotenuse1 - 100.0;
         delta2 = hypotenuse2 - 100.0;
         double mF2 = (this.mK * delta2 * cosalpha2 - this.mK * delta1 * cosalpha1) / this.mMass;
         double mX3 = mX1 + mV2 * mdtx2 / 2.0;
         double mV3 = mV1 + mF2 * mdtx2 / 2.0;
         double mP2 = (this.mMass * 9.81 - this.mK * delta2 * sinalpha2 - this.mK * delta1 * sinalpha1) / this.mMass;
         double mY3 = mY1 + mS2 * mdtx2 / 2.0;
         double mS3 = mS1 + mP2 * mdtx2 / 2.0;
         hypotenuse1 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX3) * (100.0 * (1.0 + this.mDelta / 100.0) + mX3) + mY3 * mY3);
         hypotenuse2 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX3) * (100.0 * (1.0 + this.mDelta / 100.0) - mX3) + mY3 * mY3);
         sinalpha1 = mY3 / hypotenuse1;
         cosalpha1 = (100.0 * (1.0 + this.mDelta / 100.0) + mX3) / hypotenuse1;
         sinalpha2 = mY3 / hypotenuse2;
         cosalpha2 = (100.0 * (1.0 + this.mDelta / 100.0) - mX3) / hypotenuse2;
         delta1 = hypotenuse1 - 100.0;
         delta2 = hypotenuse2 - 100.0;
         double mF3 = (this.mK * delta2 * cosalpha2 - this.mK * delta1 * cosalpha1) / this.mMass;
         double mX4 = mX1 + mV3 * mdtx2;
         double mV4 = mV1 + mF3 * mdtx2;
         double mP3 = (this.mMass * 9.81 - this.mK * delta2 * sinalpha2 - this.mK * delta1 * sinalpha1) / this.mMass;
         double mY4 = mY1 + mS3 * mdtx2;
         double mS4 = mS1 + mP3 * mdtx2;
         hypotenuse1 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX4) * (100.0 * (1.0 + this.mDelta / 100.0) + mX4) + mY4 * mY4);
         hypotenuse2 = Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX4) * (100.0 * (1.0 + this.mDelta / 100.0) - mX4) + mY4 * mY4);
         sinalpha1 = mY4 / hypotenuse1;
         cosalpha1 = (100.0 * (1.0 + this.mDelta / 100.0) + mX4) / hypotenuse1;
         sinalpha2 = mY4 / hypotenuse2;
         cosalpha2 = (100.0 * (1.0 + this.mDelta / 100.0) - mX4) / hypotenuse2;
         delta1 = hypotenuse1 - 100.0;
         delta2 = hypotenuse2 - 100.0;
         double mF4 = (this.mK * delta2 * cosalpha2 - this.mK * delta1 * cosalpha1) / this.mMass;
         double mP4 = (this.mMass * 9.81 - this.mK * delta2 * sinalpha2 - this.mK * delta1 * sinalpha1) / this.mMass;
         this.mXpos = mX1 + (mV1 + 2.0 * mV2 + 2.0 * mV3 + mV4) * mdtx2 / 6.0;
         this.mVpos = mV1 + (mF1 + 2.0 * mF2 + 2.0 * mF3 + mF4) * mdtx2 / 6.0;
         this.mYpos = mY1 + (mS1 + 2.0 * mS2 + 2.0 * mS3 + mS4) * mdtx2 / 6.0;
         this.mSpos = mS1 + (mP1 + 2.0 * mP2 + 2.0 * mP3 + mP4) * mdtx2 / 6.0;
         if (this.mpoints < 100) {
            this.mpoints++;
         } else {
            this.mpoints = 100;

            for (int p = 1; p < 100; p++) {
               this.mXplot[p] = this.mXplot[p + 1];
               this.mYplot[p] = this.mYplot[p + 1];
            }
         }

         this.mXplot[this.mpoints] = this.mXpos;
         this.mYplot[this.mpoints] = this.mYpos;
      }
   }

   public void Spring(double x1, double y1, double x2, double y2) {
      int n = 4;
      double d = 20.0;
      double b = 20.0;
      double mL = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
      double malpha = Math.atan((y2 - y1) / (x2 - x1));
      if (malpha > Math.PI / 2) {
         malpha -= Math.PI;
      }

      double mLs = Math.sqrt(b * b / 4.0 + (mL - 2.0 * d) * (mL - 2.0 * d) / (16.0 * n * n));
      double mbeta = Math.atan(2.0 * n * b / (mL - 2.0 * d));
      if (mbeta > Math.PI / 2) {
         mbeta -= Math.PI;
      }

      this.mspringpoints = 1;
      this.mXspring[this.mspringpoints] = x1;
      this.mYspring[this.mspringpoints] = y1;
      this.mspringpoints++;
      this.mXspring[this.mspringpoints] = this.mXspring[this.mspringpoints - 1] + d * Math.cos(malpha);
      this.mYspring[this.mspringpoints] = this.mYspring[this.mspringpoints - 1] + d * Math.sin(malpha);
      this.mspringpoints++;
      this.mXspring[this.mspringpoints] = this.mXspring[this.mspringpoints - 1] + mLs * Math.cos(malpha + mbeta);
      this.mYspring[this.mspringpoints] = this.mYspring[this.mspringpoints - 1] + mLs * Math.sin(malpha + mbeta);
      this.mspringpoints++;

      for (int p = 1; p < n; p++) {
         this.mXspring[this.mspringpoints] = this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta - malpha);
         this.mYspring[this.mspringpoints] = this.mYspring[this.mspringpoints - 1] - 2.0 * mLs * Math.sin(mbeta - malpha);
         this.mspringpoints++;
         this.mXspring[this.mspringpoints] = this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta + malpha);
         this.mYspring[this.mspringpoints] = this.mYspring[this.mspringpoints - 1] + 2.0 * mLs * Math.sin(mbeta + malpha);
         this.mspringpoints++;
      }

      this.mXspring[this.mspringpoints] = this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta - malpha);
      this.mYspring[this.mspringpoints] = this.mYspring[this.mspringpoints - 1] - 2.0 * mLs * Math.sin(mbeta - malpha);
      this.mspringpoints++;
      this.mXspring[this.mspringpoints] = x2 - d * Math.cos(malpha);
      this.mYspring[this.mspringpoints] = y2 - d * Math.sin(malpha);
      this.mspringpoints++;
      this.mXspring[this.mspringpoints] = x2;
      this.mYspring[this.mspringpoints] = y2;
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
            }

            mustRedraw = true;
            break;
         case 1:
            this.ChangeRunState((int)val);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mMass = val;
            this.reset();
            break;
         case 3:
            this.ChangeRunState(0);
            this.mK = val;
            this.reset();
            break;
         case 4:
            this.ChangeRunState(0);
            this.mDelta = val;
            this.reset();
            break;
         case 5:
            this.ChangeRunState(0);
            this.mXo = (int)val;
            this.reset();
            break;
         case 6:
            this.ChangeRunState(0);
            this.mYo = val;
            this.reset();
            break;
         case 7:
            this.mOnOff = (int)val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }

   public void ChangeRunState(int newState) {
      switch (this.mState) {
         case 0:
            if (newState == 1) {
               this.mState = 1;
               this.mFirstTime = true;
            }
            break;
         case 1:
            if (newState == 0) {
               this.mState = newState;
            }

            if (newState == 2) {
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
}

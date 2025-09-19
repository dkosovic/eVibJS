package OneDOF.Forced.Forced;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kWnCode = 2;
   public static final int kXiCode = 3;
   public static final int kFdivmWn2Code = 4;
   public static final int kPulsewidthCode = 5;
   public static final int kxEdge = 500;
   public static final int KyTopAbutment = 9;
   public static final int KyAbutmentDepth = 20;
   public static final int KyTopMass = 200;
   public static final int kMassWidth = 70;
   public static final int kMassDepth = 40;
   static double dt = 0.01;
   static double yscale = 3.4;
   public static final double kStartWn = 1.5;
   public static final double kStartXi = 0.05;
   public static final double kStartFdivmWn2 = 7.0;
   public static final double kStartPulsewidth = 2.0;
   public static final double mTimedelay = 1.0;
   public static final double Fscale = 3.5;
   static final int kTraceHeight = 120;
   static final int kTraceWidth = 400;
   static final int kTracePaperWidth = 3200;
   static final int kGraphPoints = 1600;
   static final int kBold = 3;
   static final int kScaleThumbnail = 8;
   public static final int kStopped = 0;
   public static final int kRunning = 1;
   public static final int kPaused = 2;
   public int mState;
   boolean mFirstTime;
   double mTime;
   double mViewTime;
   double mWn = 1.5;
   double mXi = 0.05;
   double mXo = 0.0;
   double mVo = 0.0;
   double mFdivmWn2 = 7.0;
   double mPulsewidth = 2.0;
   double mT;
   double[] mDisplacement;
   double[] mX;
   double[] mY;
   double[] mF;
   public Button mStartButton;
   public Button mPauseButton;
   public Button mStopButton;
   Image mTraceImage;
   Graphics mTraceGC;
   Image mTraceThumbnailImage;
   Graphics mTraceThumbnailGC;
   Rectangle mTraceClip;
   Rectangle mTraceThumbnail;
   Rectangle mThumbRect;
   boolean mDragMain;
   boolean mDragThumb;
   boolean mDragThumbnail;
   CFrameHelp mSpringHelp;
   CFrameHelp mDamperHelp;
   CFrameHelp mMassHelp;

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mFirstTime = true;
      this.mTraceClip = new Rectangle(80, 160, 400, 120);
      this.mTraceThumbnail = new Rectangle(
         this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20, this.mTraceClip.width, this.mTraceClip.height / 8
      );
      new CFrameHelp(
         super.mFramePanel,
         this.mTraceThumbnail.x,
         this.mTraceThumbnail.y,
         this.mTraceThumbnail.width,
         this.mTraceThumbnail.height,
         "This is a control for the plot above.\nTry dragging the cursor."
      );
      new CFrameHelp(
         super.mFramePanel,
         this.mTraceClip.x,
         this.mTraceClip.y,
         this.mTraceClip.width,
         this.mTraceClip.height,
         "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."
      );
      new CFrameHelp(super.mFramePanel, 500, 9, 70, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth.");
      this.mSpringHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a massless spring.");
      this.mDamperHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a massless viscous damper.");
      this.mMassHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass.");
   }

   public void Frame(Graphics g) {
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      if (this.mTraceGC == null) {
         this.mTraceImage = super.mFramePanel.createImage(3280, 120);
         this.mTraceGC = this.mTraceImage.getGraphics();
         this.DrawTraceGrid();
         this.DrawForceGraph();
      }

      if (this.mTraceThumbnailGC == null) {
         this.mTraceThumbnailImage = super.mFramePanel.createImage(this.mTraceClip.width, this.mTraceClip.height / 8);
         this.mTraceThumbnailGC = this.mTraceThumbnailImage.getGraphics();
      }

      if (this.mFirstTime) {
         this.mFirstTime = false;
         this.mTime = 0.0;
         this.mViewTime = 0.0;
      }

      int y;
      if (this.mDisplacement == null) {
         y = (int)(yscale * this.mXo);
      } else {
         int pcurrent = (int)(1.0 + this.mTime / 2.0 / dt);
         y = (int)(yscale * this.mDisplacement[pcurrent]);
      }

      int Farrow = (int)(this.mFdivmWn2 * 3.5);
      if (this.mTime < 1.0) {
         Farrow = 0;
      }

      if (this.mTime > 1.0 + this.mPulsewidth) {
         Farrow = 0;
      }

      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(500, 9, 70, 20);
      g.setColor(Color.black);
      double coil = (200 + y - 9 - 20) / 10.0;
      g.drawLine(517, 29, 529, (int)(29.0 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            g.drawLine(505, (int)(29.0 + (2 * p - 1) * coil / 2.0), 529, (int)(29.0 + (2 * p + 1) * coil / 2.0));
         } else {
            g.drawLine(529, (int)(29.0 + (2 * p - 1) * coil / 2.0), 505, (int)(29.0 + (2 * p + 1) * coil / 2.0));
         }
      }

      g.drawLine(505, (int)(29.0 + 19.0 * coil / 2.0), 517, 200 + y);
      this.mSpringHelp.x = 505;
      this.mSpringHelp.y = 29;
      this.mSpringHelp.width = 24;
      this.mSpringHelp.height = 200 + y - 9 - 20 - 1;
      this.mSpringHelp.DefaultArrowPos();
      g.setColor(Color.black);
      g.drawLine(545, 29, 545, 142);
      g.drawLine(559, 29, 559, 142);
      g.drawLine(545, 142, 559, 142);
      g.drawLine(552, 200 + y - 114, 552, 200 + y);
      g.drawLine(547, 200 + y - 114, 557, 200 + y - 114);
      this.mDamperHelp.x = 545;
      this.mDamperHelp.y = 29;
      this.mDamperHelp.width = 14;
      this.mDamperHelp.height = 200 + y - 9 - 20 - 1;
      this.mDamperHelp.DefaultArrowPos();
      g.setColor(mass);
      g.fillRect(500, 200 + y, 70, 40);
      g.drawLine(500, 200 + y + 20, 480, 200 + y + 20);
      g.setColor(force);
      g.drawLine(570, 200 + y + 20, 590, 200 + y + 20);
      if (Farrow != 0) {
         g.drawLine(579, 200 + y + 20, 579, 200 + y + 20 + Farrow - 1);
         g.drawLine(580, 200 + y + 20, 580, 200 + y + 20 + Farrow);
         g.drawLine(581, 200 + y + 20, 581, 200 + y + 20 + Farrow - 1);
      }

      this.mMassHelp.x = 500;
      this.mMassHelp.y = 200 + y;
      this.mMassHelp.width = 70;
      this.mMassHelp.height = 40;
      this.mMassHelp.DefaultArrowPos();
      g.setColor(Color.black);
      g.drawImage(
         this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, super.mFramePanel
      );
      double fraction = this.mViewTime / dt / 3200.0;
      this.mThumbRect = new Rectangle(
         this.mTraceThumbnail.x + (int)(fraction * this.mTraceThumbnail.width),
         this.mTraceThumbnail.y - 3,
         this.mTraceThumbnail.width * this.mTraceThumbnail.width / 3200,
         this.mTraceThumbnail.height + 6
      );
      fraction = this.mTime / dt / 3200.0;
      int intTime = (int)(fraction * this.mTraceThumbnail.width);
      g.setColor(Color.white);
      g.fillRect(
         this.mTraceThumbnail.x + intTime + this.mThumbRect.width,
         this.mTraceThumbnail.y,
         this.mTraceThumbnail.width - intTime - this.mThumbRect.width,
         this.mTraceThumbnail.height
      );
      g.setColor(force);
      g.drawLine(
         this.mTraceThumbnail.x + 50,
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2,
         (int)(this.mTraceThumbnail.x + (400.0 + 1.0 / dt) / 8.0),
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2
      );
      g.drawLine(
         (int)(this.mTraceThumbnail.x + (400.0 + 1.0 / dt) / 8.0),
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2,
         (int)(this.mTraceThumbnail.x + (400.0 + 1.0 / dt) / 8.0),
         (int)(this.mTraceThumbnail.y + (this.mTraceClip.height / 2 + this.mFdivmWn2 * 3.5) / 8.0)
      );
      g.drawLine(
         (int)(this.mTraceThumbnail.x + (400.0 + 1.0 / dt) / 8.0),
         (int)(this.mTraceThumbnail.y + (this.mTraceClip.height / 2 + this.mFdivmWn2 * 3.5) / 8.0),
         (int)(this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / dt) / 8.0),
         (int)(this.mTraceThumbnail.y + (this.mTraceClip.height / 2 + this.mFdivmWn2 * 3.5) / 8.0)
      );
      g.drawLine(
         (int)(this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / dt) / 8.0),
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2,
         (int)(this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / dt) / 8.0),
         (int)(this.mTraceThumbnail.y + (this.mTraceClip.height / 2 + this.mFdivmWn2 * 3.5) / 8.0)
      );
      g.drawLine(
         (int)(this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / dt) / 8.0),
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2,
         (int)(this.mTraceThumbnail.x + (400.0 + (2.0 + this.mPulsewidth) / dt) / 8.0),
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2
      );
      g.setColor(Color.black);
      g.drawRect(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 1);
      g.drawRect(this.mThumbRect.x - 1, this.mThumbRect.y + 1, this.mThumbRect.width, this.mThumbRect.height - 3);
      g.drawRect(this.mThumbRect.x, this.mThumbRect.y + 2, this.mThumbRect.width - 2, this.mThumbRect.height - 4);
      g.setPaintMode();
      Graphics fudge = g.create();
      fudge.clipRect(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
      fudge.drawImage(this.mTraceImage, -((int)(this.mViewTime / dt)), this.mTraceClip.y, super.mFramePanel);
      g.drawRect(80, 160, 400, 120);
   }

   public void Response() {
      this.mDisplacement = new double[1600];
      this.mX = new double[1605];
      this.mY = new double[1605];
      this.mF = new double[1605];
      this.mDisplacement[0] = this.mXo;
      this.mX[0] = this.mDisplacement[0];
      this.mY[0] = this.mVo;
      double mW = this.mWn * 2.0 * Math.PI;
      double mW2 = mW * mW;
      double mdtx2 = 2.0 * dt;
      this.mT = 0.0;

      for (int p = 0; p < 1599; p++) {
         double mFpulse = this.mFdivmWn2 * mW2;
         if (this.mT < 1.0) {
            mFpulse = 0.0;
         }

         if (this.mT > 1.0 + this.mPulsewidth) {
            mFpulse = 0.0;
         }

         this.mF[p] = mFpulse - mW2 * this.mX[p] - 2.0 * mW * this.mXi * this.mY[p];
         this.mX[p + 1] = this.mX[p] + this.mY[p] * mdtx2 / 2.0;
         this.mY[p + 1] = this.mY[p] + this.mF[p] * mdtx2 / 2.0;
         this.mF[p + 1] = mFpulse - mW2 * this.mX[p + 1] - 2.0 * mW * this.mXi * this.mY[p + 1];
         this.mX[p + 2] = this.mX[p] + this.mY[p + 1] * mdtx2 / 2.0;
         this.mY[p + 2] = this.mY[p] + this.mF[p + 1] * mdtx2 / 2.0;
         this.mF[p + 2] = mFpulse - mW2 * this.mX[p + 2] - 2.0 * mW * this.mXi * this.mY[p + 2];
         this.mX[p + 3] = this.mX[p] + this.mY[p + 2] * mdtx2;
         this.mY[p + 3] = this.mY[p] + this.mF[p + 2] * mdtx2;
         this.mF[p + 3] = mFpulse - mW2 * this.mX[p + 3] - 2.0 * mW * this.mXi * this.mY[p + 3];
         this.mX[p + 1] = this.mX[p] + (this.mY[p] + 2.0 * this.mY[p + 1] + 2.0 * this.mY[p + 2] + this.mY[p + 3]) * mdtx2 / 6.0;
         this.mY[p + 1] = this.mY[p] + (this.mF[p] + 2.0 * this.mF[p + 1] + 2.0 * this.mF[p + 2] + this.mF[p + 3]) * mdtx2 / 6.0;
         this.mDisplacement[p + 1] = this.mX[p + 1];
         if (this.mDisplacement[p + 1] > 16.2) {
            this.mDisplacement[p + 1] = 16.2;
            this.mX[p + 1] = 16.2;
            this.mY[p + 1] = -0.7 * this.mY[p + 1];
         }

         if (this.mDisplacement[p + 1] < -16.5) {
            this.mDisplacement[p + 1] = -16.5;
            this.mX[p + 1] = -16.5;
            this.mY[p + 1] = -0.7 * this.mY[p + 1];
         }

         this.mT += mdtx2;
      }
   }

   public void DrawTraceGrid() {
      this.mTraceGC.setPaintMode();
      this.mTraceGC.setColor(Color.white);
      this.mTraceGC.fillRect(0, 0, 3280, 120);
      this.mTraceGC.setColor(Color.black);

      for (int p = 0; p < 3280; p += 50) {
         this.mTraceGC.drawLine(p, 0, p, 120);
      }

      this.mTraceGC.drawLine(0, 60, 3280, 60);
   }

   public void DrawForceGraph() {
      Color force = new Color(0.77F, 0.38F, 0.0F);
      this.mTraceGC.setColor(force);
      this.mTraceGC.drawLine(480, 60, 480 + (int)(1.0 / dt), 60);
      this.mTraceGC.drawLine(480 + (int)(1.0 / dt), 60, 480 + (int)(1.0 / dt), 60 + (int)(this.mFdivmWn2 * 3.5));
      this.mTraceGC
         .drawLine(480 + (int)(1.0 / dt), 60 + (int)(this.mFdivmWn2 * 3.5), 480 + (int)((1.0 + this.mPulsewidth) / dt), 60 + (int)(this.mFdivmWn2 * 3.5));
      this.mTraceGC.drawLine(480 + (int)((1.0 + this.mPulsewidth) / dt), 60 + (int)(this.mFdivmWn2 * 3.5), 480 + (int)((1.0 + this.mPulsewidth) / dt), 60);
      this.mTraceGC.drawLine(480 + (int)((1.0 + this.mPulsewidth) / dt), 60, 3280, 60);
   }

   public void ThumbnailSketch() {
      this.mTraceThumbnailGC.setPaintMode();
      this.mTraceThumbnailGC.setColor(Color.white);
      this.mTraceThumbnailGC.fillRect(0, 0, this.mTraceClip.width, this.mTraceClip.height / 8);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceThumbnailGC.setColor(mass);

      for (int p = 0; p < 1598; p++) {
         this.mTraceThumbnailGC
            .drawLine(
               (p * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 2.0 + this.mDisplacement[p] * yscale / 8.0),
               ((p + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 2.0 + this.mDisplacement[p + 1] * yscale / 8.0)
            );
      }
   }

   public void DrawTraceShape() {
      this.DrawTraceGrid();
      this.DrawForceGraph();
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceGC.setColor(mass);

      for (int p = 0; p < 1598; p++) {
         this.mTraceGC
            .drawLine(p * 2 + 400 + 80, 60 + (int)(yscale * this.mDisplacement[p]), (p + 1) * 2 + 400 + 80, 60 + (int)(yscale * this.mDisplacement[p + 1]));
      }

      this.DrawForceGraph();
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 0:
            if (this.mState == 1) {
               this.mTime += val;
               this.mViewTime = this.mTime;
            }

            this.LimitTimeValue();
            mustRedraw = true;
            break;
         case 1:
            this.ChangeRunState((int)val);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mWn = val;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mXi = val;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mFdivmWn2 = val;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mPulsewidth = val;
      }

      if (mustRedraw) {
         this.repaint();
      }
   }

   public void ChangeRunState(int newState) {
      switch (this.mState) {
         case 0:
            if (newState == 1) {
               this.Response();
               this.DrawTraceShape();
               this.ThumbnailSketch();
               this.mTime = 0.0;
               this.mViewTime = 0.0;
               this.mFirstTime = true;
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

   public boolean MouseEvent(int code, boolean prevHit) {
      boolean hitMain = this.mTraceClip.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean hitThumbnail = this.mTraceThumbnail.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean hitThumb = this.mThumbRect.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      super.mWasHit = hitMain || hitThumbnail;
      int offset = 0;
      switch (code) {
         case 0:
            this.mDragMain = false;
            this.mDragThumb = false;
            this.mDragThumbnail = false;
            if (!super.mWasHit) {
               return false;
            } else {
               if (prevHit) {
                  return false;
               }

               if (hitMain) {
                  this.mDragMain = true;
               } else if (hitThumb) {
                  this.mDragThumb = true;
               } else if (hitThumbnail) {
                  this.mDragThumbnail = true;
               }

               if (this.mDragThumbnail) {
                  offset = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - this.mThumbRect.x);
                  this.UserDrag(offset);
               }

               return true;
            }
         case 1:
            if (!super.mWasHit) {
               return false;
            }

            if (this.mDragMain) {
               offset = super.mFramePanel.mThisPt.x - super.mFramePanel.mLastPt.x;
            } else if (this.mDragThumb) {
               offset = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - super.mFramePanel.mLastPt.x);
            } else if (this.mDragThumbnail) {
               offset = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - this.mThumbRect.x);
            }

            this.UserDrag(offset);
            return true;
         case 2:
            this.mDragMain = false;
            this.mDragThumb = false;
            this.mDragThumbnail = false;
            return true;
         default:
            return false;
      }
   }

   public void UserDrag(int offset) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - offset * dt;
      this.LimitTimeValue();
      this.repaint();
   }

   public void LimitTimeValue() {
      double maxTime = 2800.0 * dt;
      if (this.mTime < 0.0) {
         this.mTime = 0.0;
      } else if (this.mTime > maxTime) {
         this.mTime = maxTime;
      }

      if (this.mViewTime < 0.0) {
         this.mViewTime = 0.0;
      } else if (this.mViewTime > this.mTime) {
         this.mViewTime = this.mTime;
      }
   }
}

package OneDOF.Prog11.AbutmentSin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kWnCode = 2;
   public static final int kXiCode = 3;
   public static final int kXinCode = 4;
   public static final int kWinCode = 5;
   public static final int kxEdge = 500;
   public static final int KyTopAbutment = 39;
   public static final int KyAbutmentDepth = 20;
   public static final int KyTopMass = 230;
   public static final int kMassWidth = 70;
   public static final int kMassDepth = 40;
   static double dt = 0.01;
   static double yscale = 3.4;
   public static final double kStartWn = 0.7;
   public static final double kStartXi = 0.05;
   public static final double kStartXin = 7.0;
   public static final double kStartWin = 1.0;
   public static final double mTimedelay = 2.0;
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
   double mWn = 0.7;
   double mXi = 0.05;
   double mXo = 0.0;
   double mVo = 0.0;
   double mXin = 7.0;
   double mWin = 1.0;
   double mWinrads;
   double mT;
   double[] mDisplacement;
   double[] mX;
   double[] mY;
   double[] mF;
   double[] mInput;
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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mFirstTime = true;
      this.mTraceClip = new Rectangle(80, 190, 400, 120);
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
      new CFrameHelp(super.mFramePanel, 500, 39, 70, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth.");
      this.mSpringHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a massless spring.");
      this.mDamperHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a massless viscous damper.");
      this.mMassHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass.");
   }

   public void Frame(Graphics g) {
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
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

      int var4 = 0;
      int var3;
      if (this.mDisplacement == null) {
         var3 = (int)(yscale * this.mXo);
      } else {
         int var5 = (int)(1.0 + this.mTime / 2.0 / dt);
         var3 = (int)(yscale * this.mDisplacement[var5]);
         var4 = (int)(yscale * this.mInput[var5]);
      }

      g.setPaintMode();
      g.setColor(Color.lightGray);
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(500, 39 + var4, 70, 20);
      g.setColor(Color.black);
      double var6 = (230 + var3 - var4 - 39 - 20) / 10.0;
      g.drawLine(517, 59 + var4, 529, (int)(59 + var4 + var6 / 2.0));

      for (int var13 = 1; var13 < 10; var13++) {
         if (var13 % 2 == 0) {
            g.drawLine(505, (int)(59 + var4 + (2 * var13 - 1) * var6 / 2.0), 529, (int)(59 + var4 + (2 * var13 + 1) * var6 / 2.0));
         } else {
            g.drawLine(529, (int)(59 + var4 + (2 * var13 - 1) * var6 / 2.0), 505, (int)(59 + var4 + (2 * var13 + 1) * var6 / 2.0));
         }
      }

      g.drawLine(505, (int)(59 + var4 + 19.0 * var6 / 2.0), 517, 230 + var3);
      this.mSpringHelp.x = 505;
      this.mSpringHelp.y = 59 + var4;
      this.mSpringHelp.width = 24;
      this.mSpringHelp.height = 230 + var3 - var4 - 39 - 20 - 1;
      this.mSpringHelp.DefaultArrowPos();
      g.setColor(Color.black);
      g.drawLine(545, 59 + var4, 545, 59 + var4 + 113);
      g.drawLine(559, 59 + var4, 559, 59 + var4 + 113);
      g.drawLine(545, 59 + var4 + 113, 559, 59 + var4 + 113);
      g.drawLine(552, 230 + var3 - 114, 552, 230 + var3);
      g.drawLine(547, 230 + var3 - 114, 557, 230 + var3 - 114);
      this.mDamperHelp.x = 545;
      this.mDamperHelp.y = 59 + var4;
      this.mDamperHelp.width = 14;
      this.mDamperHelp.height = 230 + var3 - 39 - 20 - 1;
      this.mDamperHelp.DefaultArrowPos();
      g.setColor(var2);
      g.fillRect(500, 230 + var3, 70, 40);
      g.drawLine(500, 230 + var3 + 20, 480, 230 + var3 + 20);
      this.mMassHelp.x = 500;
      this.mMassHelp.y = 230 + var3;
      this.mMassHelp.width = 70;
      this.mMassHelp.height = 40;
      this.mMassHelp.DefaultArrowPos();
      g.setColor(Color.black);
      g.drawImage(
         this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, super.mFramePanel
      );
      double var8 = this.mViewTime / dt / 3200.0;
      this.mThumbRect = new Rectangle(
         this.mTraceThumbnail.x + (int)(var8 * this.mTraceThumbnail.width),
         this.mTraceThumbnail.y - 3,
         this.mTraceThumbnail.width * this.mTraceThumbnail.width / 3200,
         this.mTraceThumbnail.height + 6
      );
      var8 = this.mTime / dt / 3200.0;
      int var10 = (int)(var8 * this.mTraceThumbnail.width);
      g.setColor(Color.white);
      g.fillRect(
         this.mTraceThumbnail.x + var10 + this.mThumbRect.width,
         this.mTraceThumbnail.y,
         this.mTraceThumbnail.width - var10 - this.mThumbRect.width,
         this.mTraceThumbnail.height
      );
      g.setColor(Color.orange);
      int var11 = (int)(this.mTraceThumbnail.x + (400.0 + 2.0 / dt) / 8.0);
      g.drawLine(
         this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2, var11, this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2
      );
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int var14 = 0; var14 < 1600 - var11 - 144; var14++) {
         g.drawLine(
            var14 * 2 / 8 + var11,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2 + yscale * this.mXin * Math.sin(this.mWinrads * 2.0 * var14 * dt) / 8.0),
            var11 + 2 * (var14 + 1) / 8,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 2 + yscale * this.mXin * Math.sin(this.mWinrads * 2.0 * (var14 + 1) * dt) / 8.0)
         );
      }

      g.setColor(Color.black);
      g.drawRect(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 1);
      g.drawRect(this.mThumbRect.x - 1, this.mThumbRect.y + 1, this.mThumbRect.width, this.mThumbRect.height - 3);
      g.drawRect(this.mThumbRect.x, this.mThumbRect.y + 2, this.mThumbRect.width - 2, this.mThumbRect.height - 4);
      g.setPaintMode();
      Graphics fudge = g.create();
      fudge.clipRect(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
      fudge.drawImage(this.mTraceImage, -((int)(this.mViewTime / dt)), this.mTraceClip.y, super.mFramePanel);
      fudge.dispose();
      g.drawRect(80, 190, 400, 120);
   }

   public void Response() {
      this.mDisplacement = new double[1600];
      this.mX = new double[1605];
      this.mY = new double[1605];
      this.mF = new double[1605];
      this.mInput = new double[1605];
      this.mDisplacement[0] = this.mXo;
      this.mX[0] = this.mDisplacement[0];
      this.mY[0] = this.mVo;
      double var2 = this.mWn * 2.0 * Math.PI;
      double var4 = var2 * var2;
      this.mWinrads = this.mWin * 2.0 * Math.PI;
      double var6 = 2.0 * dt;
      this.mT = 0.0;

      for (int var1 = 0; var1 < 1599; var1++) {
         this.mInput[var1] = this.mXin * Math.sin(this.mWinrads * (this.mT - 2.0));
         if (this.mT < 2.0) {
            this.mInput[var1] = 0.0;
         }

         this.mT += var6;
      }

      this.mT = 0.0;
      this.mY[0] = 0.0;

      for (int var8 = 0; var8 < 1599; var8++) {
         this.mF[var8] = -var4 * (this.mX[var8] - this.mInput[var8])
            - 2.0 * var2 * this.mXi * (this.mY[var8] - (this.mInput[var8 + 1] - this.mInput[var8]) / var6);
         this.mX[var8 + 1] = this.mX[var8] + this.mY[var8] * var6 / 2.0;
         this.mY[var8 + 1] = this.mY[var8] + this.mF[var8] * var6 / 2.0;
         this.mF[var8 + 1] = -var4 * (this.mX[var8 + 1] - this.mInput[var8 + 1])
            - 2.0 * var2 * this.mXi * (this.mY[var8 + 1] - (this.mInput[var8 + 2] - this.mInput[var8 + 1]) / var6);
         this.mX[var8 + 2] = this.mX[var8] + this.mY[var8 + 1] * var6 / 2.0;
         this.mY[var8 + 2] = this.mY[var8] + this.mF[var8 + 1] * var6 / 2.0;
         this.mF[var8 + 2] = -var4 * (this.mX[var8 + 2] - this.mInput[var8 + 2])
            - 2.0 * var2 * this.mXi * (this.mY[var8 + 2] - (this.mInput[var8 + 3] - this.mInput[var8 + 2]) / var6);
         this.mX[var8 + 3] = this.mX[var8] + this.mY[var8 + 2] * var6;
         this.mY[var8 + 3] = this.mY[var8] + this.mF[var8 + 2] * var6;
         this.mF[var8 + 3] = -var4 * (this.mX[var8 + 3] - this.mInput[var8 + 3])
            - 2.0 * var2 * this.mXi * (this.mY[var8 + 3] - (this.mInput[var8 + 4] - this.mInput[var8 + 3]) / var6);
         this.mX[var8 + 1] = this.mX[var8] + (this.mY[var8] + 2.0 * this.mY[var8 + 1] + 2.0 * this.mY[var8 + 2] + this.mY[var8 + 3]) * var6 / 6.0;
         this.mY[var8 + 1] = this.mY[var8] + (this.mF[var8] + 2.0 * this.mF[var8 + 1] + 2.0 * this.mF[var8 + 2] + this.mF[var8 + 3]) * var6 / 6.0;
         this.mDisplacement[var8 + 1] = this.mX[var8 + 1];
         if (this.mDisplacement[var8 + 1] > 16.2) {
            this.mDisplacement[var8 + 1] = 16.2;
            this.mX[var8 + 1] = 16.2;
            this.mY[var8 + 1] = -0.7 * this.mY[var8 + 1];
         }

         if (this.mDisplacement[var8 + 1] < -16.5) {
            this.mDisplacement[var8 + 1] = -16.5;
            this.mX[var8 + 1] = -16.5;
            this.mY[var8 + 1] = -0.7 * this.mY[var8 + 1];
         }

         this.mT += var6;
      }
   }

   public void DrawTraceGrid() {
      this.mTraceGC.setPaintMode();
      this.mTraceGC.setColor(Color.white);
      this.mTraceGC.fillRect(0, 0, 3280, 120);
      this.mTraceGC.setColor(Color.black);

      for (byte var1 = 0; var1 < 3280; var1 += 50) {
         this.mTraceGC.drawLine(var1, 0, var1, 120);
      }

      this.mTraceGC.drawLine(0, 60, 3280, 60);
   }

   public void DrawForceGraph() {
      this.mTraceGC.setColor(Color.orange);
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int var1 = (int)(1.0 / dt); var1 < 1598; var1++) {
         this.mTraceGC
            .drawLine(
               var1 * 2 + 400 + 80,
               60 + (int)(yscale * this.mXin * Math.sin(this.mWinrads * (2 * var1 * dt - 2.0))),
               (var1 + 1) * 2 + 400 + 80,
               60 + (int)(yscale * this.mXin * Math.sin(this.mWinrads * (2 * (var1 + 1) * dt - 2.0)))
            );
      }
   }

   public void ThumbnailSketch() {
      this.mTraceThumbnailGC.setPaintMode();
      this.mTraceThumbnailGC.setColor(Color.white);
      this.mTraceThumbnailGC.fillRect(0, 0, this.mTraceClip.width, this.mTraceClip.height / 8);
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceThumbnailGC.setColor(var2);

      for (int var1 = 0; var1 < 1598; var1++) {
         this.mTraceThumbnailGC
            .drawLine(
               (var1 * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 2.0 + this.mDisplacement[var1] * yscale / 8.0),
               ((var1 + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 2.0 + this.mDisplacement[var1 + 1] * yscale / 8.0)
            );
      }
   }

   public void DrawTraceShape() {
      this.DrawTraceGrid();
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceGC.setColor(var2);

      for (int var1 = 0; var1 < 1598; var1++) {
         this.mTraceGC
            .drawLine(
               var1 * 2 + 400 + 80, 60 + (int)(yscale * this.mDisplacement[var1]), (var1 + 1) * 2 + 400 + 80, 60 + (int)(yscale * this.mDisplacement[var1 + 1])
            );
      }

      this.DrawForceGraph();
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 0:
            if (this.mState == 1) {
               this.mTime += var3;
               this.mViewTime = this.mTime;
            }

            this.LimitTimeValue();
            var5 = true;
            break;
         case 1:
            this.ChangeRunState((int)var3);
            break;
         case 2:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mWn = var3;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mXi = var3;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mXin = var3;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mWin = var3;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void ChangeRunState(int var1) {
      switch (this.mState) {
         case 0:
            if (var1 == 1) {
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

   public boolean MouseEvent(int var1, boolean var2) {
      boolean var3 = this.mTraceClip.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean var4 = this.mTraceThumbnail.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean var5 = this.mThumbRect.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      super.mWasHit = var3 || var4;
      int var6 = 0;
      switch (var1) {
         case 0:
            this.mDragMain = false;
            this.mDragThumb = false;
            this.mDragThumbnail = false;
            if (!super.mWasHit) {
               return false;
            } else {
               if (var2) {
                  return false;
               }

               if (var3) {
                  this.mDragMain = true;
               } else if (var5) {
                  this.mDragThumb = true;
               } else if (var4) {
                  this.mDragThumbnail = true;
               }

               if (this.mDragThumbnail) {
                  var6 = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - this.mThumbRect.x);
                  this.UserDrag(var6);
               }

               return true;
            }
         case 1:
            if (!super.mWasHit) {
               return false;
            }

            if (this.mDragMain) {
               var6 = super.mFramePanel.mThisPt.x - super.mFramePanel.mLastPt.x;
            } else if (this.mDragThumb) {
               var6 = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - super.mFramePanel.mLastPt.x);
            } else if (this.mDragThumbnail) {
               var6 = -((int)(3200.0 / this.mTraceClip.width)) * (super.mFramePanel.mThisPt.x - this.mThumbRect.x);
            }

            this.UserDrag(var6);
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

   public void UserDrag(int var1) {
      if (this.mState == 1) {
         this.ChangeRunState(2);
      }

      this.mViewTime = this.mViewTime - var1 * dt;
      this.LimitTimeValue();
      this.repaint();
   }

   public void LimitTimeValue() {
      double var1 = 2800.0 * dt;
      if (this.mTime < 0.0) {
         this.mTime = 0.0;
      } else if (this.mTime > var1) {
         this.mTime = var1;
      }

      if (this.mViewTime < 0.0) {
         this.mViewTime = 0.0;
      } else if (this.mViewTime > this.mTime) {
         this.mViewTime = this.mTime;
      }
   }
}

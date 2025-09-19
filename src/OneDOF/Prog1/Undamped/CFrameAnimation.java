package OneDOF.Prog1.Undamped;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kWnCode = 2;
   public static final int kXoCode = 3;
   public static final int kVoCode = 4;
   public static final int kxEdge = 500;
   public static final int KyTopAbutment = 9;
   public static final int KyAbutmentDepth = 20;
   public static final int KyTopMass = 200;
   public static final int kMassWidth = 70;
   public static final int kMassDepth = 40;
   static double dt = 0.01;
   static double yscale = 3.4;
   public static final double kStartWn = 0.4;
   public static final double kStartXo = 16.0;
   public static final double kStartVo = 0.0;
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
   double mWn = 0.4;
   double mXo = 16.0;
   double mVo = 0.0;
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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
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
      this.mMassHelp = new CFrameHelp(super.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass.");
   }

   public void Frame(Graphics var1) {
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
      if (this.mTraceGC == null) {
         this.mTraceImage = super.mFramePanel.createImage(3280, 120);
         this.mTraceGC = this.mTraceImage.getGraphics();
         this.DrawTraceGrid();
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

      int var3;
      if (this.mDisplacement == null) {
         var3 = (int)(yscale * this.mXo);
      } else {
         int var4 = (int)(1.0 + this.mTime / 2.0 / dt);
         var3 = (int)(yscale * this.mDisplacement[var4]);
      }

      var1.setPaintMode();
      var1.setColor(Color.white);
      var1.fillRect(0, 0, super.width, super.height);
      var1.setColor(Color.orange);
      var1.fillRect(500, 9, 70, 20);
      var1.setColor(Color.black);
      double var5 = (200 + var3 - 9 - 20) / 10.0;
      var1.drawLine(535, 29, 547, (int)(29.0 + var5 / 2.0));

      for (int var11 = 1; var11 < 10; var11++) {
         if (var11 % 2 == 0) {
            var1.drawLine(523, (int)(29.0 + (2 * var11 - 1) * var5 / 2.0), 547, (int)(29.0 + (2 * var11 + 1) * var5 / 2.0));
         } else {
            var1.drawLine(547, (int)(29.0 + (2 * var11 - 1) * var5 / 2.0), 523, (int)(29.0 + (2 * var11 + 1) * var5 / 2.0));
         }
      }

      var1.drawLine(523, (int)(29.0 + 19.0 * var5 / 2.0), 535, 200 + var3);
      this.mSpringHelp.x = 523;
      this.mSpringHelp.y = 29;
      this.mSpringHelp.width = 24;
      this.mSpringHelp.height = 200 + var3 - 9 - 20 - 1;
      this.mSpringHelp.DefaultArrowPos();
      var1.setColor(var2);
      var1.fillRect(500, 200 + var3, 70, 40);
      var1.drawLine(500, 200 + var3 + 20, 480, 200 + var3 + 20);
      this.mMassHelp.x = 500;
      this.mMassHelp.y = 200 + var3;
      this.mMassHelp.width = 70;
      this.mMassHelp.height = 40;
      this.mMassHelp.DefaultArrowPos();
      var1.setColor(Color.black);
      var1.drawImage(
         this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, super.mFramePanel
      );
      double var7 = this.mViewTime / dt / 3200.0;
      this.mThumbRect = new Rectangle(
         this.mTraceThumbnail.x + (int)(var7 * this.mTraceThumbnail.width),
         this.mTraceThumbnail.y - 3,
         this.mTraceThumbnail.width * this.mTraceThumbnail.width / 3200,
         this.mTraceThumbnail.height + 6
      );
      var7 = this.mTime / dt / 3200.0;
      int var9 = (int)(var7 * this.mTraceThumbnail.width);
      var1.setColor(Color.white);
      var1.fillRect(
         this.mTraceThumbnail.x + var9 + this.mThumbRect.width,
         this.mTraceThumbnail.y,
         this.mTraceThumbnail.width - var9 - this.mThumbRect.width,
         this.mTraceThumbnail.height
      );
      var1.setColor(Color.black);
      var1.drawRect(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 1);
      var1.drawRect(this.mThumbRect.x - 1, this.mThumbRect.y + 1, this.mThumbRect.width, this.mThumbRect.height - 3);
      var1.drawRect(this.mThumbRect.x, this.mThumbRect.y + 2, this.mThumbRect.width - 2, this.mThumbRect.height - 4);
      var1.setPaintMode();
      Graphics var10 = var1.create();
      var10.clipRect(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
      var10.drawImage(this.mTraceImage, -((int)(this.mViewTime / dt)), this.mTraceClip.y, super.mFramePanel);
      var1.drawRect(80, 160, 400, 120);
   }

   public void Response() {
      this.mDisplacement = new double[1600];
      this.mX = new double[1605];
      this.mY = new double[1605];
      this.mF = new double[1605];
      this.mDisplacement[0] = this.mXo;
      this.mX[0] = this.mDisplacement[0];
      this.mY[0] = this.mVo;
      double var2 = this.mWn * 2.0 * Math.PI;
      double var4 = var2 * var2;
      double var6 = 2.0 * dt;

      for (int var1 = 0; var1 < 1599; var1++) {
         this.mF[var1] = -var4 * this.mX[var1];
         this.mX[var1 + 1] = this.mX[var1] + this.mY[var1] * var6 / 2.0;
         this.mY[var1 + 1] = this.mY[var1] + this.mF[var1] * var6 / 2.0;
         this.mF[var1 + 1] = -var4 * this.mX[var1 + 1];
         this.mX[var1 + 2] = this.mX[var1] + this.mY[var1 + 1] * var6 / 2.0;
         this.mY[var1 + 2] = this.mY[var1] + this.mF[var1 + 1] * var6 / 2.0;
         this.mF[var1 + 2] = -var4 * this.mX[var1 + 2];
         this.mX[var1 + 3] = this.mX[var1] + this.mY[var1 + 2] * var6;
         this.mY[var1 + 3] = this.mY[var1] + this.mF[var1 + 2] * var6;
         this.mF[var1 + 3] = -var4 * this.mX[var1 + 3];
         this.mX[var1 + 1] = this.mX[var1] + (this.mY[var1] + 2.0 * this.mY[var1 + 1] + 2.0 * this.mY[var1 + 2] + this.mY[var1 + 3]) * var6 / 6.0;
         this.mY[var1 + 1] = this.mY[var1] + (this.mF[var1] + 2.0 * this.mF[var1 + 1] + 2.0 * this.mF[var1 + 2] + this.mF[var1 + 3]) * var6 / 6.0;
         this.mDisplacement[var1 + 1] = this.mX[var1 + 1];
         if (this.mDisplacement[var1 + 1] > 16.2) {
            this.mDisplacement[var1 + 1] = 16.2;
            this.mX[var1 + 1] = 16.2;
            this.mY[var1 + 1] = -0.7 * this.mY[var1 + 1];
         }

         if (this.mDisplacement[var1 + 1] < -16.5) {
            this.mDisplacement[var1 + 1] = -16.5;
            this.mX[var1 + 1] = -16.5;
            this.mY[var1 + 1] = -0.7 * this.mY[var1 + 1];
         }
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
            this.mXo = var3;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement = null;
            this.mVo = var3;
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

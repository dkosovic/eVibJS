package TwoDOF.Prog2.Undamped;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int km1Code = 2;
   public static final int kk1Code = 3;
   public static final int km2Code = 5;
   public static final int kk2Code = 6;
   public static final int kX1oCode = 8;
   public static final int kX2oCode = 9;
   public static final int kxEdge = 500;
   public static final int kyTopAbutment = 19;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 35;
   public static final int kMassDepth = 20;
   public static final int kyTopMass1 = 110;
   public static final int kyTopMass2 = 201;
   static double dt = 0.01;
   static double yscale = 3.4;
   public static final double kStartm1 = 0.1;
   public static final double kStartk1 = 8.0;
   public static final double kStartm2 = 0.1;
   public static final double kStartk2 = 8.0;
   public static final double kStartX1o = 7.0;
   public static final double kStartX2o = 7.0;
   static final int kTraceHeight = 200;
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
   double mm1 = 0.1;
   double mk1 = 8.0;
   double mc1;
   double mm2 = 0.1;
   double mk2 = 8.0;
   double mc2;
   double mX1o = 7.0;
   double mX2o = 7.0;
   double[] mDisplacement1;
   double[] mDisplacement2;
   double[] mX1;
   double[] mY1;
   double[] mF1;
   double[] mX2;
   double[] mY2;
   double[] mF2;
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

   public CFrameAnimation(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mFirstTime = true;
      this.mTraceClip = new Rectangle(90, 60, 400, 200);
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
      new CFrameHelp(super.mFramePanel, 500, 19, 35, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth.");
   }

   public void Frame(Graphics g) {
      if (this.mTraceGC == null) {
         this.mTraceImage = super.mFramePanel.createImage(3290, 200);
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

      int y1;
      int y2;
      if (this.mDisplacement1 == null) {
         y1 = (int)(yscale * this.mX1o);
         y2 = (int)(yscale * this.mX2o);
      } else {
         int pcurrent = (int)(1.0 + this.mTime / 2.0 / dt);
         y1 = (int)(yscale * this.mDisplacement1[pcurrent]);
         y2 = (int)(yscale * this.mDisplacement2[pcurrent]);
      }

      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(500, 19, 35, 20);
      g.setColor(Color.black);
      double coil = (110 + y1 - 19 - 20) / 10.0;
      g.drawLine(517, 39, 523, (int)(39.0 + coil / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            g.drawLine(511, (int)(39.0 + (2 * p - 1) * coil / 2.0), 523, (int)(39.0 + (2 * p + 1) * coil / 2.0));
         } else {
            g.drawLine(523, (int)(39.0 + (2 * p - 1) * coil / 2.0), 511, (int)(39.0 + (2 * p + 1) * coil / 2.0));
         }
      }

      g.drawLine(511, (int)(39.0 + 19.0 * coil / 2.0), 517, 110 + y1);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(mass);
      g.fillRect(500, 110 + y1, 35, 20);
      g.drawLine(500, 110 + y1 + 10, 480, 110 + y1 + 10);
      g.setColor(Color.black);
      coil = (201 + y2 - 110 - 20 - y1) / 10.0;
      g.drawLine(517, 130 + y1, 523, (int)(130 + y1 + coil / 2.0));

      for (int var13 = 1; var13 < 10; var13++) {
         if (var13 % 2 == 0) {
            g.drawLine(511, (int)(130 + y1 + (2 * var13 - 1) * coil / 2.0), 523, (int)(130 + y1 + (2 * var13 + 1) * coil / 2.0));
         } else {
            g.drawLine(523, (int)(130 + y1 + (2 * var13 - 1) * coil / 2.0), 511, (int)(130 + y1 + (2 * var13 + 1) * coil / 2.0));
         }
      }

      g.drawLine(511, (int)(130 + y1 + 19.0 * coil / 2.0), 517, 201 + y2);
      g.setColor(mass);
      g.fillRect(500, 201 + y2, 35, 20);
      g.drawLine(500, 201 + y2 + 10, 480, 201 + y2 + 10);
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
      g.setColor(Color.black);
      g.drawRect(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 2);
      g.drawRect(this.mThumbRect.x, this.mThumbRect.y, this.mThumbRect.width, this.mThumbRect.height);
      g.drawRect(this.mThumbRect.x + 1, this.mThumbRect.y + 1, this.mThumbRect.width - 2, this.mThumbRect.height - 2);
      g.drawRect(this.mThumbRect.x + 2, this.mThumbRect.y + 2, this.mThumbRect.width - 4, this.mThumbRect.height - 4);
      Graphics fudge = g.create();
      fudge.clipRect(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
      fudge.drawImage(this.mTraceImage, -((int)(this.mViewTime / dt)), this.mTraceClip.y, super.mFramePanel);
      g.drawRect(90, 60, 400, 200);
   }

   public void Response() {
      this.mDisplacement1 = new double[1600];
      this.mDisplacement2 = new double[1600];
      this.mX1 = new double[1605];
      this.mY1 = new double[1605];
      this.mF1 = new double[1605];
      this.mX2 = new double[1605];
      this.mY2 = new double[1605];
      this.mF2 = new double[1605];
      this.mDisplacement1[0] = this.mX1o;
      this.mX1[0] = this.mDisplacement1[0];
      this.mY1[0] = 0.0;
      this.mDisplacement2[0] = this.mX2o;
      this.mX2[0] = this.mDisplacement2[0];
      this.mY2[0] = 0.0;
      double mdtx2 = 2.0 * dt;

      for (int p = 0; p < 1599; p++) {
         this.mF1[p] = (-this.mk1 * this.mX1[p] - this.mc1 * this.mY1[p] + this.mk2 * (this.mX2[p] - this.mX1[p]) + this.mc2 * (this.mY2[p] - this.mY1[p]))
            / this.mm1;
         this.mF2[p] = (-this.mk2 * (this.mX2[p] - this.mX1[p]) - this.mc2 * (this.mY2[p] - this.mY1[p])) / this.mm2;
         this.mX1[p + 1] = this.mX1[p] + this.mY1[p] * mdtx2 / 2.0;
         this.mX2[p + 1] = this.mX2[p] + this.mY2[p] * mdtx2 / 2.0;
         this.mY1[p + 1] = this.mY1[p] + this.mF1[p] * mdtx2 / 2.0;
         this.mY2[p + 1] = this.mY2[p] + this.mF2[p] * mdtx2 / 2.0;
         this.mF1[p + 1] = (
               -this.mk1 * this.mX1[p + 1]
                  - this.mc1 * this.mY1[p + 1]
                  + this.mk2 * (this.mX2[p + 1] - this.mX1[p + 1])
                  + this.mc2 * (this.mY2[p + 1] - this.mY1[p + 1])
            )
            / this.mm1;
         this.mF2[p + 1] = (-this.mk2 * (this.mX2[p + 1] - this.mX1[p + 1]) - this.mc2 * (this.mY2[p + 1] - this.mY1[p + 1])) / this.mm2;
         this.mX1[p + 2] = this.mX1[p] + this.mY1[p + 1] * mdtx2 / 2.0;
         this.mX2[p + 2] = this.mX2[p] + this.mY2[p + 1] * mdtx2 / 2.0;
         this.mY1[p + 2] = this.mY1[p] + this.mF1[p + 1] * mdtx2 / 2.0;
         this.mY2[p + 2] = this.mY2[p] + this.mF2[p + 1] * mdtx2 / 2.0;
         this.mF1[p + 2] = (
               -this.mk1 * this.mX1[p + 2]
                  - this.mc1 * this.mY1[p + 2]
                  + this.mk2 * (this.mX2[p + 2] - this.mX1[p + 2])
                  + this.mc2 * (this.mY2[p + 2] - this.mY1[p + 2])
            )
            / this.mm1;
         this.mF2[p + 2] = (-this.mk2 * (this.mX2[p + 2] - this.mX1[p + 2]) - this.mc2 * (this.mY2[p + 2] - this.mY1[p + 2])) / this.mm2;
         this.mX1[p + 3] = this.mX1[p] + this.mY1[p + 2] * mdtx2;
         this.mX2[p + 3] = this.mX2[p] + this.mY2[p + 2] * mdtx2;
         this.mY1[p + 3] = this.mY1[p] + this.mF1[p + 2] * mdtx2;
         this.mY2[p + 3] = this.mY2[p] + this.mF2[p + 2] * mdtx2;
         this.mF1[p + 3] = (
               -this.mk1 * this.mX1[p + 3]
                  - this.mc1 * this.mY1[p + 3]
                  + this.mk2 * (this.mX2[p + 3] - this.mX1[p + 3])
                  + this.mc2 * (this.mY2[p + 3] - this.mY1[p + 3])
            )
            / this.mm1;
         this.mF2[p + 3] = (-this.mk2 * (this.mX2[p + 3] - this.mX1[p + 3]) - this.mc2 * (this.mY2[p + 3] - this.mY1[p + 3])) / this.mm2;
         this.mX1[p + 1] = this.mX1[p] + (this.mY1[p] + 2.0 * this.mY1[p + 1] + 2.0 * this.mY1[p + 2] + this.mY1[p + 3]) * mdtx2 / 6.0;
         this.mX2[p + 1] = this.mX2[p] + (this.mY2[p] + 2.0 * this.mY2[p + 1] + 2.0 * this.mY2[p + 2] + this.mY2[p + 3]) * mdtx2 / 6.0;
         this.mY1[p + 1] = this.mY1[p] + (this.mF1[p] + 2.0 * this.mF1[p + 1] + 2.0 * this.mF1[p + 2] + this.mF1[p + 3]) * mdtx2 / 6.0;
         this.mY2[p + 1] = this.mY2[p] + (this.mF2[p] + 2.0 * this.mF2[p + 1] + 2.0 * this.mF2[p + 2] + this.mF2[p + 3]) * mdtx2 / 6.0;
         this.mDisplacement1[p + 1] = this.mX1[p + 1];
         this.mDisplacement2[p + 1] = this.mX2[p + 1];
      }
   }

   public void DrawTraceGrid() {
      this.mTraceGC.setPaintMode();
      this.mTraceGC.setColor(Color.white);
      this.mTraceGC.fillRect(0, 0, 3290, 200);
      this.mTraceGC.setColor(Color.black);

      for (int p = 0; p < 3290; p += 50) {
         this.mTraceGC.drawLine(p, 0, p, 200);
      }

      this.mTraceGC.drawLine(0, 60, 3290, 60);
      this.mTraceGC.drawLine(0, 151, 3290, 151);
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
               (int)(this.mTraceClip.height / 8 * 0.3 + this.mDisplacement1[p] * yscale / 8.0),
               ((p + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 0.3 + this.mDisplacement1[p + 1] * yscale / 8.0)
            );
      }

      for (int var3 = 0; var3 < 1598; var3++) {
         this.mTraceThumbnailGC
            .drawLine(
               (var3 * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 0.7 + this.mDisplacement2[var3] * yscale / 8.0),
               ((var3 + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 0.7 + this.mDisplacement2[var3 + 1] * yscale / 8.0)
            );
      }
   }

   public void DrawTraceShape() {
      this.DrawTraceGrid();
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceGC.setColor(mass);

      for (int p = 0; p < 1598; p++) {
         this.mTraceGC
            .drawLine(p * 2 + 400 + 90, 60 + (int)(yscale * this.mDisplacement1[p]), (p + 1) * 2 + 400 + 90, 60 + (int)(yscale * this.mDisplacement1[p + 1]));
      }

      for (int var3 = 0; var3 < 1598; var3++) {
         this.mTraceGC
            .drawLine(
               var3 * 2 + 400 + 90,
               151 + (int)(yscale * this.mDisplacement2[var3]),
               (var3 + 1) * 2 + 400 + 90,
               151 + (int)(yscale * this.mDisplacement2[var3 + 1])
            );
      }
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
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mm1 = val;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk1 = val;
         case 4:
         case 7:
         default:
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mm2 = val;
            break;
         case 6:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk2 = val;
            break;
         case 8:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mX1o = val;
            break;
         case 9:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mX2o = val;
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

package TwoDOF.Prog6.Forced;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int km1Code = 2;
   public static final int kk1Code = 3;
   public static final int kc1Code = 4;
   public static final int km2Code = 5;
   public static final int kk2Code = 6;
   public static final int kc2Code = 7;
   public static final int kXoCode = 8;
   public static final int kWinCode = 9;
   public static final int kxEdge = 500;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 35;
   public static final int kMassDepth = 20;
   public static final int kyTopMass1 = 110;
   public static final int kyTopMass2 = 201;
   static double dt = 0.01;
   static double yscale = 3400.0;
   public static final double kStartm1 = 0.1;
   public static final double kStartk1 = 20.0;
   public static final double kStartc1 = 0.5;
   public static final double kStartm2 = 0.1;
   public static final double kStartk2 = 20.0;
   public static final double kStartc2 = 0.01;
   public static final double kStartXo = 3.0;
   public static final double kStartWin = 1.0;
   public static final double mTimedelay = 1.0;
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
   double mk1 = 20.0;
   double mc1 = 0.5;
   double mm2 = 0.1;
   double mk2 = 20.0;
   double mc2 = 0.01;
   double mXo = 3.0;
   double mWin;
   double mWinrads;
   double mT;
   double[] mDisplacement1;
   double[] mDisplacement2;
   int kyTopAbutment = 19;
   double[] mX1;
   double[] mY1;
   double[] mF1;
   double[] mX2;
   double[] mY2;
   double[] mF2;
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

   public CFrameAnimation(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.mWin = 1.0;
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
      new CFrameHelp(super.mFramePanel, 500, this.kyTopAbutment, 35, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth.");
   }

   public void Frame(Graphics g) {
      if (this.mTraceGC == null) {
         this.mTraceImage = super.mFramePanel.createImage(3290, 200);
         this.mTraceGC = this.mTraceImage.getGraphics();
         this.DrawTraceGrid();
         this.DrawXoGraph();
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

      int var2;
      int var3;
      if (this.mDisplacement1 == null) {
         var2 = 0;
         var3 = 0;
         this.kyTopAbutment = 19;
      } else {
         int var4 = (int)(1.0 + this.mTime / 2.0 / dt);
         var2 = (int)(yscale * this.mDisplacement1[var4]);
         var3 = (int)(yscale * this.mDisplacement2[var4]);
         this.kyTopAbutment = 19 + (int)(this.mInput[var4] * 1000.0);
      }

      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(500, this.kyTopAbutment, 35, 20);
      g.setColor(Color.black);
      double var5 = (110 + var2 - this.kyTopAbutment - 20) / 10.0;
      g.drawLine(508, this.kyTopAbutment + 20, 514, (int)(this.kyTopAbutment + 20 + var5 / 2.0));

      for (int var13 = 1; var13 < 10; var13++) {
         if (var13 % 2 == 0) {
            g.drawLine(
               502, (int)(this.kyTopAbutment + 20 + (2 * var13 - 1) * var5 / 2.0), 514, (int)(this.kyTopAbutment + 20 + (2 * var13 + 1) * var5 / 2.0)
            );
         } else {
            g.drawLine(
               514, (int)(this.kyTopAbutment + 20 + (2 * var13 - 1) * var5 / 2.0), 502, (int)(this.kyTopAbutment + 20 + (2 * var13 + 1) * var5 / 2.0)
            );
         }
      }

      g.drawLine(502, (int)(this.kyTopAbutment + 20 + 19.0 * var5 / 2.0), 508, 110 + var2);
      g.setColor(Color.black);
      g.drawLine(522, this.kyTopAbutment + 20, 522, this.kyTopAbutment + 20 + 47);
      g.drawLine(530, this.kyTopAbutment + 20, 530, this.kyTopAbutment + 20 + 47);
      g.drawLine(522, this.kyTopAbutment + 20 + 47, 530, this.kyTopAbutment + 20 + 47);
      g.drawLine(526, 110 + var2 - 48, 526, 110 + var2);
      g.drawLine(523, 110 + var2 - 48, 529, 110 + var2 - 48);
      Color var7 = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(var7);
      g.fillRect(500, 110 + var2, 35, 20);
      g.drawLine(500, 110 + var2 + 10, 480, 110 + var2 + 10);
      g.setColor(Color.black);
      var5 = (201 + var3 - 110 - 20 - var2) / 10.0;
      g.drawLine(508, 130 + var2, 514, (int)(130 + var2 + var5 / 2.0));

      for (int var14 = 1; var14 < 10; var14++) {
         if (var14 % 2 == 0) {
            g.drawLine(502, (int)(130 + var2 + (2 * var14 - 1) * var5 / 2.0), 514, (int)(130 + var2 + (2 * var14 + 1) * var5 / 2.0));
         } else {
            g.drawLine(514, (int)(130 + var2 + (2 * var14 - 1) * var5 / 2.0), 502, (int)(130 + var2 + (2 * var14 + 1) * var5 / 2.0));
         }
      }

      g.drawLine(502, (int)(130 + var2 + 19.0 * var5 / 2.0), 508, 201 + var3);
      g.setColor(Color.black);
      g.drawLine(522, 130 + var2, 522, 130 + var2 + 47);
      g.drawLine(530, 130 + var2, 530, 130 + var2 + 47);
      g.drawLine(522, 130 + var2 + 47, 530, 130 + var2 + 47);
      g.drawLine(526, 201 + var3 - 48, 526, 201 + var3);
      g.drawLine(523, 201 + var3 - 48, 529, 201 + var3 - 48);
      g.setColor(var7);
      g.fillRect(500, 201 + var3, 35, 20);
      g.drawLine(500, 201 + var3 + 10, 480, 201 + var3 + 10);
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
      int var11 = (int)(this.mTraceThumbnail.x + (400.0 + 1.0 / dt) / 8.0);
      g.drawLine(
         this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 3, var11, this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 3
      );
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int var15 = 0; var15 < 1600 - var11 - 144; var15++) {
         g.drawLine(
            var15 * 2 / 8 + var11,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 3 + yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * 2.0 * var15 * dt) / 8.0),
            var11 + 2 * (var15 + 1) / 8,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 / 3 + yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * 2.0 * (var15 + 1) * dt) / 8.0)
         );
      }

      g.setColor(Color.black);
      g.drawRect(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 2);
      g.drawRect(this.mThumbRect.x, this.mThumbRect.y, this.mThumbRect.width, this.mThumbRect.height);
      g.drawRect(this.mThumbRect.x + 1, this.mThumbRect.y + 1, this.mThumbRect.width - 2, this.mThumbRect.height - 2);
      g.drawRect(this.mThumbRect.x + 2, this.mThumbRect.y + 2, this.mThumbRect.width - 4, this.mThumbRect.height - 4);
      Graphics fudge = g.create();
      fudge.clipRect(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
      fudge.drawImage(this.mTraceImage, -((int)(this.mViewTime / dt)), this.mTraceClip.y, super.mFramePanel);
      fudge.dispose();
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
      this.mInput = new double[1605];
      this.mDisplacement1[0] = 0.0;
      this.mX1[0] = this.mDisplacement1[0];
      this.mY1[0] = 0.0;
      this.mDisplacement2[0] = 0.0;
      this.mX2[0] = this.mDisplacement2[0];
      this.mY2[0] = 0.0;
      double var2 = 2.0 * dt;
      this.mT = 0.0;

      for (int var1 = 0; var1 < 1599; var1++) {
         this.mInput[var1] = this.mXo / 1000.0 * Math.sin(this.mWinrads * (this.mT - 1.0));
         if (this.mT < 1.0) {
            this.mInput[var1] = 0.0;
         }

         this.mT += var2;
      }

      this.mT = 0.0;

      for (int var8 = 0; var8 < 1599; var8++) {
         this.mF1[var8] = (
               -this.mk1 * (this.mX1[var8] - this.mInput[var8])
                  - this.mc1 * (this.mY1[var8] - (this.mInput[var8 + 1] - this.mInput[var8]) / var2)
                  + this.mk2 * (this.mX2[var8] - this.mX1[var8])
                  + this.mc2 * (this.mY2[var8] - this.mY1[var8])
            )
            / this.mm1;
         this.mF2[var8] = (-this.mk2 * (this.mX2[var8] - this.mX1[var8]) - this.mc2 * (this.mY2[var8] - this.mY1[var8])) / this.mm2;
         this.mX1[var8 + 1] = this.mX1[var8] + this.mY1[var8] * var2 / 2.0;
         this.mX2[var8 + 1] = this.mX2[var8] + this.mY2[var8] * var2 / 2.0;
         this.mY1[var8 + 1] = this.mY1[var8] + this.mF1[var8] * var2 / 2.0;
         this.mY2[var8 + 1] = this.mY2[var8] + this.mF2[var8] * var2 / 2.0;
         this.mF1[var8 + 1] = (
               -this.mk1 * (this.mX1[var8 + 1] - this.mInput[var8 + 1])
                  - this.mc1 * (this.mY1[var8 + 1] - (this.mInput[var8 + 2] - this.mInput[var8 + 1]) / var2)
                  + this.mk2 * (this.mX2[var8 + 1] - this.mX1[var8 + 1])
                  + this.mc2 * (this.mY2[var8 + 1] - this.mY1[var8 + 1])
            )
            / this.mm1;
         this.mF2[var8 + 1] = (-this.mk2 * (this.mX2[var8 + 1] - this.mX1[var8 + 1]) - this.mc2 * (this.mY2[var8 + 1] - this.mY1[var8 + 1])) / this.mm2;
         this.mX1[var8 + 2] = this.mX1[var8] + this.mY1[var8 + 1] * var2 / 2.0;
         this.mX2[var8 + 2] = this.mX2[var8] + this.mY2[var8 + 1] * var2 / 2.0;
         this.mY1[var8 + 2] = this.mY1[var8] + this.mF1[var8 + 1] * var2 / 2.0;
         this.mY2[var8 + 2] = this.mY2[var8] + this.mF2[var8 + 1] * var2 / 2.0;
         this.mF1[var8 + 2] = (
               -this.mk1 * (this.mX1[var8 + 2] - this.mInput[var8 + 2])
                  - this.mc1 * (this.mY1[var8 + 2] - (this.mInput[var8 + 3] - this.mInput[var8 + 2]) / var2)
                  + this.mk2 * (this.mX2[var8 + 2] - this.mX1[var8 + 2])
                  + this.mc2 * (this.mY2[var8 + 2] - this.mY1[var8 + 2])
            )
            / this.mm1;
         this.mF2[var8 + 2] = (-this.mk2 * (this.mX2[var8 + 2] - this.mX1[var8 + 2]) - this.mc2 * (this.mY2[var8 + 2] - this.mY1[var8 + 2])) / this.mm2;
         this.mX1[var8 + 3] = this.mX1[var8] + this.mY1[var8 + 2] * var2;
         this.mX2[var8 + 3] = this.mX2[var8] + this.mY2[var8 + 2] * var2;
         this.mY1[var8 + 3] = this.mY1[var8] + this.mF1[var8 + 2] * var2;
         this.mY2[var8 + 3] = this.mY2[var8] + this.mF2[var8 + 2] * var2;
         this.mF1[var8 + 3] = (
               -this.mk1 * (this.mX1[var8 + 3] - this.mInput[var8 + 3])
                  - this.mc1 * (this.mY1[var8 + 3] - (this.mInput[var8 + 4] - this.mInput[var8 + 3]) / var2)
                  + this.mk2 * (this.mX2[var8 + 3] - this.mX1[var8 + 3])
                  + this.mc2 * (this.mY2[var8 + 3] - this.mY1[var8 + 3])
            )
            / this.mm1;
         this.mF2[var8 + 3] = (-this.mk2 * (this.mX2[var8 + 3] - this.mX1[var8 + 3]) - this.mc2 * (this.mY2[var8 + 3] - this.mY1[var8 + 3])) / this.mm2;
         this.mX1[var8 + 1] = this.mX1[var8] + (this.mY1[var8] + 2.0 * this.mY1[var8 + 1] + 2.0 * this.mY1[var8 + 2] + this.mY1[var8 + 3]) * var2 / 6.0;
         this.mX2[var8 + 1] = this.mX2[var8] + (this.mY2[var8] + 2.0 * this.mY2[var8 + 1] + 2.0 * this.mY2[var8 + 2] + this.mY2[var8 + 3]) * var2 / 6.0;
         this.mY1[var8 + 1] = this.mY1[var8] + (this.mF1[var8] + 2.0 * this.mF1[var8 + 1] + 2.0 * this.mF1[var8 + 2] + this.mF1[var8 + 3]) * var2 / 6.0;
         this.mY2[var8 + 1] = this.mY2[var8] + (this.mF2[var8] + 2.0 * this.mF2[var8 + 1] + 2.0 * this.mF2[var8 + 2] + this.mF2[var8 + 3]) * var2 / 6.0;
         this.mDisplacement1[var8 + 1] = this.mX1[var8 + 1];
         this.mDisplacement2[var8 + 1] = this.mX2[var8 + 1];
         if (this.mDisplacement1[var8 + 1] > 0.0073) {
            this.mDisplacement1[var8 + 1] = 0.007;
            this.mX1[var8 + 1] = this.mDisplacement1[var8 + 1];
            this.mY1[var8 + 1] = -0.7 * this.mY1[var8 + 1];
         }

         if (this.mDisplacement1[var8 + 1] < -0.0073) {
            this.mDisplacement1[var8 + 1] = -0.007;
            this.mX1[var8 + 1] = this.mDisplacement1[var8 + 1];
            this.mY1[var8 + 1] = -0.7 * this.mY1[var8 + 1];
         }

         double var4 = this.mDisplacement2[var8 + 1] - this.mDisplacement1[var8 + 1];
         if (var4 > 0.007) {
            this.mDisplacement1[var8 + 1] = this.mDisplacement1[var8 + 1] * 0.007 / var4;
            this.mX1[var8 + 1] = this.mDisplacement1[var8 + 1];
            this.mDisplacement2[var8 + 1] = this.mDisplacement2[var8 + 1] * 0.007 / var4;
            this.mX2[var8 + 1] = this.mDisplacement2[var8 + 1];
            double var6 = this.mm2 * (this.mY1[var8 + 1] + this.mY2[var8 + 1]) * 1.7 / (this.mm1 + this.mm2);
            this.mY2[var8 + 1] = var6 - 0.7 * (this.mY1[var8 + 1] - this.mY2[var8 + 1]);
            this.mY1[var8 + 1] = var6;
         }

         this.mT += var2;
      }
   }

   public void DrawTraceGrid() {
      this.mTraceGC.setPaintMode();
      this.mTraceGC.setColor(Color.white);
      this.mTraceGC.fillRect(0, 0, 3290, 200);
      this.mTraceGC.setColor(Color.black);

      for (int var1 = 0; var1 < 3290; var1 += 50) {
         this.mTraceGC.drawLine(var1, 0, var1, 200);
      }

      this.mTraceGC.drawLine(0, 60, 3290, 60);
      this.mTraceGC.drawLine(0, 151, 3290, 151);
   }

   public void DrawXoGraph() {
      this.mTraceGC.setColor(Color.orange);
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int var1 = (int)(0.5 / dt); var1 < 1598; var1++) {
         this.mTraceGC
            .drawLine(
               var1 * 2 + 400 + 90,
               60 + (int)(yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * (2 * var1 * dt - 1.0))),
               (var1 + 1) * 2 + 400 + 90,
               60 + (int)(yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * (2 * (var1 + 1) * dt - 1.0)))
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
               (int)(this.mTraceClip.height / 8 / 3.0 + this.mDisplacement1[var1] * yscale / 8.0),
               ((var1 + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 3.0 + this.mDisplacement1[var1 + 1] * yscale / 8.0)
            );
      }

      for (int var3 = 0; var3 < 1598; var3++) {
         this.mTraceThumbnailGC
            .drawLine(
               (var3 * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 2.0 / 3.0 + this.mDisplacement2[var3] * yscale / 8.0),
               ((var3 + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 2.0 / 3.0 + this.mDisplacement2[var3 + 1] * yscale / 8.0)
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
               var1 * 2 + 400 + 90,
               60 + (int)(yscale * this.mDisplacement1[var1]),
               (var1 + 1) * 2 + 400 + 90,
               60 + (int)(yscale * this.mDisplacement1[var1 + 1])
            );
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

      this.DrawXoGraph();
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
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mm1 = var3;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk1 = var3;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mc1 = var3;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mm2 = var3;
            break;
         case 6:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk2 = var3;
            break;
         case 7:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mc2 = var3;
            break;
         case 8:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mXo = var3;
            break;
         case 9:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
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

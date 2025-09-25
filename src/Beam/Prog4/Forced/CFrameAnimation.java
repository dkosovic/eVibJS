package Beam.Prog4.Forced;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   public static final int kDeltaTimeCode = 0;
   public static final int kChangeRunCode = 1;
   public static final int kmCode = 2;
   public static final int kk1Code = 3;
   public static final int kk2Code = 4;
   public static final int kbCode = 5;
   public static final int kWinCode = 6;
   public static final int kxEdge = 430;
   public static final int kyTopAbutment = 285;
   public static final int kyAbutmentDepth = 20;
   public static final int kMassWidth = 200;
   public static final int kyTopMass = 211;
   public static final int kFdiagram = 200;
   static double dt = 0.01;
   public static final double kStartm = 2.0;
   public static final double kStartk1 = 20.0;
   public static final double kStartk2 = 20.0;
   public static final double kStartb = 0.3;
   public static final double kStartWin = 1.2;
   public static final double mTimedelay = 2.0;
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
   double mm = 2.0;
   double mk1 = 20.0;
   double mk2 = 20.0;
   double mb = 0.3;
   double mWin = 1.2;
   double mWinrads;
   double mT;
   double[] mDisplacement1;
   double[] mDisplacement2;
   int mforceposition;
   double myscale;
   double mdispmax;
   double[] mX1;
   double[] mY1;
   double[] mF1;
   double[] mX2;
   double[] mY2;
   double[] mF2;
   double[] mF1in;
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
      this.mforceposition = (int)(this.mb * 200.0);
      this.mTraceClip = new Rectangle(10, 60, 400, 200);
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
      new CFrameHelp(super.mFramePanel, 430, 285, 200, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth.");
   }

   public void Frame(Graphics g) {
      if (this.mTraceGC == null) {
         this.mTraceImage = super.mFramePanel.createImage(3210, 200);
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

      int y1;
      int y2;
      if (this.mDisplacement1 == null) {
         y1 = 0;
         y2 = 0;
      } else {
         int pcurrent = (int)(1.0 + this.mTime / 2.0 / dt);
         y1 = (int)this.mDisplacement1[pcurrent];
         y2 = (int)this.mDisplacement2[pcurrent];
      }

      int P1arrow = (int)(25.0 * Math.sin(this.mWin * 2.0 * Math.PI * (this.mTime - 2.0)));
      if (this.mTime < 2.0) {
         P1arrow = 0;
      }

      g.setPaintMode();
      g.setColor(Color.white);
      g.fillRect(0, 0, super.width, super.height);
      g.setColor(Color.orange);
      g.fillRect(420, 285, 220, 20);
      g.setColor(Color.black);
      double coil1 = (213 + y1 - 285) / 10.0;
      g.drawLine(430, 285, 424, (int)(285.0 + coil1 / 2.0));

      for (int p = 1; p < 10; p++) {
         if (p % 2 == 0) {
            g.drawLine(436, (int)(285.0 + (2 * p - 1) * coil1 / 2.0), 424, (int)(285.0 + (2 * p + 1) * coil1 / 2.0));
         } else {
            g.drawLine(424, (int)(285.0 + (2 * p - 1) * coil1 / 2.0), 436, (int)(285.0 + (2 * p + 1) * coil1 / 2.0));
         }
      }

      g.drawLine(436, (int)(285.0 + 19.0 * coil1 / 2.0), 430, 211 + y1 + 2);
      g.setColor(Color.black);
      double coil2 = (213 + y2 - 285) / 10.0;
      g.drawLine(630, 285, 624, (int)(285.0 + coil2 / 2.0));

      for (int var18 = 1; var18 < 10; var18++) {
         if (var18 % 2 == 0) {
            g.drawLine(636, (int)(285.0 + (2 * var18 - 1) * coil2 / 2.0), 624, (int)(285.0 + (2 * var18 + 1) * coil2 / 2.0));
         } else {
            g.drawLine(624, (int)(285.0 + (2 * var18 - 1) * coil2 / 2.0), 636, (int)(285.0 + (2 * var18 + 1) * coil2 / 2.0));
         }
      }

      g.drawLine(636, (int)(285.0 + 19.0 * coil2 / 2.0), 630, 211 + y2 + 2);
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      g.setColor(mass);
      g.drawLine(430, 211 + y1 + 1, 630, 211 + y2 + 1);
      g.drawLine(430, 211 + y1, 630, 211 + y2);
      g.drawLine(430, 211 + y1 - 1, 630, 211 + y2 - 1);
      g.setColor(mass);
      g.drawLine(426, 211 + y1, 410, 211 + y1);
      g.setColor(mass);
      g.drawLine(634, 211 + y2, 644, 211 + y2);
      g.drawLine(644, 211 + y2, 644, 211 + y2 - 91);
      g.drawLine(644, 211 + y2 - 91, 410, 211 + y2 - 91);
      Color force = new Color(0.77F, 0.38F, 0.0F);
      g.setColor(force);
      if (P1arrow != 0) {
         if (P1arrow > 0) {
            g.drawLine(
               430 + this.mforceposition - 1,
               211 + y1 + (int)(this.mb * (y2 - y1)),
               430 + this.mforceposition - 1,
               211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow - 1
            );
            g.drawLine(
               430 + this.mforceposition, 211 + y1 + (int)(this.mb * (y2 - y1)), 430 + this.mforceposition, 211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow
            );
            g.drawLine(
               430 + this.mforceposition + 1,
               211 + y1 + (int)(this.mb * (y2 - y1)),
               430 + this.mforceposition + 1,
               211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow - 1
            );
         }

         if (P1arrow < 0) {
            g.drawLine(
               430 + this.mforceposition - 1,
               211 + y1 + (int)(this.mb * (y2 - y1)),
               430 + this.mforceposition - 1,
               211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow + 1
            );
            g.drawLine(
               430 + this.mforceposition, 211 + y1 + (int)(this.mb * (y2 - y1)), 430 + this.mforceposition, 211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow
            );
            g.drawLine(
               430 + this.mforceposition + 1,
               211 + y1 + (int)(this.mb * (y2 - y1)),
               430 + this.mforceposition + 1,
               211 + y1 + (int)(this.mb * (y2 - y1)) + P1arrow + 1
            );
         }
      }

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
      int sub1 = (int)(this.mTraceThumbnail.x + (400.0 + 2.0 / dt) / 8.0);
      g.drawLine(
         this.mTraceThumbnail.x + 50,
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 * 2 / 3,
         sub1,
         this.mTraceThumbnail.y + this.mTraceClip.height / 8 * 2 / 3
      );
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int var19 = 0; var19 < 1600 - sub1 - 227; var19++) {
         g.drawLine(
            var19 * 2 / 8 + sub1,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 * 2 / 3 + 25.0 * Math.sin(this.mWinrads * 2.0 * var19 * dt) / 8.0),
            sub1 + 2 * (var19 + 1) / 8,
            (int)(this.mTraceThumbnail.y + this.mTraceClip.height / 8 * 2 / 3 + 25.0 * Math.sin(this.mWinrads * 2.0 * (var19 + 1) * dt) / 8.0)
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
      g.drawRect(10, 60, 400, 200);
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
      this.mF1in = new double[1605];
      this.mDisplacement1[0] = 0.0;
      this.mX1[0] = this.mDisplacement1[0];
      this.mY1[0] = 0.0;
      this.mDisplacement2[0] = 0.0;
      this.mX2[0] = this.mDisplacement2[0];
      this.mY2[0] = 0.0;
      this.mWinrads = this.mWin * 2.0 * Math.PI;
      double mdtx2 = 2.0 * dt;
      this.mT = 0.0;

      for (int p = 0; p < 1599; p++) {
         this.mF1in[p] = Math.sin(this.mWinrads * (this.mT - 2.0));
         if (this.mT < 2.0) {
            this.mF1in[p] = 0.0;
         }

         this.mT += mdtx2;
      }

      this.mdispmax = Math.abs(this.mDisplacement1[0]);
      if (this.mdispmax < Math.abs(this.mDisplacement2[0])) {
         this.mdispmax = Math.abs(this.mDisplacement2[0]);
      }

      for (int var4 = 0; var4 < 1599; var4++) {
         this.mF1[var4] = (-4.0 * this.mk1 * this.mX1[var4] + 2.0 * this.mk2 * this.mX2[var4] + this.mF1in[var4] * (4.0 - 6.0 * this.mb)) / this.mm;
         this.mF2[var4] = (2.0 * this.mk1 * this.mX1[var4] - 4.0 * this.mk2 * this.mX2[var4] - this.mF1in[var4] * (2.0 - 6.0 * this.mb)) / this.mm;
         this.mX1[var4 + 1] = this.mX1[var4] + this.mY1[var4] * mdtx2 / 2.0;
         this.mX2[var4 + 1] = this.mX2[var4] + this.mY2[var4] * mdtx2 / 2.0;
         this.mY1[var4 + 1] = this.mY1[var4] + this.mF1[var4] * mdtx2 / 2.0;
         this.mY2[var4 + 1] = this.mY2[var4] + this.mF2[var4] * mdtx2 / 2.0;
         this.mF1[var4 + 1] = (-4.0 * this.mk1 * this.mX1[var4 + 1] + 2.0 * this.mk2 * this.mX2[var4 + 1] + this.mF1in[var4 + 1] * (4.0 - 6.0 * this.mb))
            / this.mm;
         this.mF2[var4 + 1] = (2.0 * this.mk1 * this.mX1[var4 + 1] - 4.0 * this.mk2 * this.mX2[var4 + 1] - this.mF1in[var4 + 1] * (2.0 - 6.0 * this.mb))
            / this.mm;
         this.mX1[var4 + 2] = this.mX1[var4] + this.mY1[var4 + 1] * mdtx2 / 2.0;
         this.mX2[var4 + 2] = this.mX2[var4] + this.mY2[var4 + 1] * mdtx2 / 2.0;
         this.mY1[var4 + 2] = this.mY1[var4] + this.mF1[var4 + 1] * mdtx2 / 2.0;
         this.mY2[var4 + 2] = this.mY2[var4] + this.mF2[var4 + 1] * mdtx2 / 2.0;
         this.mF1[var4 + 2] = (-4.0 * this.mk1 * this.mX1[var4 + 2] + 2.0 * this.mk2 * this.mX2[var4 + 2] + this.mF1in[var4 + 2] * (4.0 - 6.0 * this.mb))
            / this.mm;
         this.mF2[var4 + 2] = (2.0 * this.mk1 * this.mX1[var4 + 2] - 4.0 * this.mk2 * this.mX2[var4 + 2] - this.mF1in[var4 + 2] * (2.0 - 6.0 * this.mb))
            / this.mm;
         this.mX1[var4 + 3] = this.mX1[var4] + this.mY1[var4 + 2] * mdtx2;
         this.mX2[var4 + 3] = this.mX2[var4] + this.mY2[var4 + 2] * mdtx2;
         this.mY1[var4 + 3] = this.mY1[var4] + this.mF1[var4 + 2] * mdtx2;
         this.mY2[var4 + 3] = this.mY2[var4] + this.mF2[var4 + 2] * mdtx2;
         this.mF1[var4 + 3] = (-4.0 * this.mk1 * this.mX1[var4 + 3] + 2.0 * this.mk2 * this.mX2[var4 + 3] + this.mF1in[var4 + 3] * (4.0 - 6.0 * this.mb))
            / this.mm;
         this.mF2[var4 + 3] = (2.0 * this.mk1 * this.mX1[var4 + 3] - 4.0 * this.mk2 * this.mX2[var4 + 3] - this.mF1in[var4 + 3] * (2.0 - 6.0 * this.mb))
            / this.mm;
         this.mX1[var4 + 1] = this.mX1[var4] + (this.mY1[var4] + 2.0 * this.mY1[var4 + 1] + 2.0 * this.mY1[var4 + 2] + this.mY1[var4 + 3]) * mdtx2 / 6.0;
         this.mX2[var4 + 1] = this.mX2[var4] + (this.mY2[var4] + 2.0 * this.mY2[var4 + 1] + 2.0 * this.mY2[var4 + 2] + this.mY2[var4 + 3]) * mdtx2 / 6.0;
         this.mY1[var4 + 1] = this.mY1[var4] + (this.mF1[var4] + 2.0 * this.mF1[var4 + 1] + 2.0 * this.mF1[var4 + 2] + this.mF1[var4 + 3]) * mdtx2 / 6.0;
         this.mY2[var4 + 1] = this.mY2[var4] + (this.mF2[var4] + 2.0 * this.mF2[var4 + 1] + 2.0 * this.mF2[var4 + 2] + this.mF2[var4 + 3]) * mdtx2 / 6.0;
         this.mDisplacement1[var4 + 1] = this.mX1[var4 + 1];
         this.mDisplacement2[var4 + 1] = this.mX2[var4 + 1];
         if (this.mdispmax < Math.abs(this.mDisplacement1[var4 + 1])) {
            this.mdispmax = Math.abs(this.mDisplacement1[var4 + 1]);
         }

         if (this.mdispmax < Math.abs(this.mDisplacement2[var4 + 1])) {
            this.mdispmax = Math.abs(this.mDisplacement2[var4 + 1]);
         }

         this.mT += mdtx2;
      }

      this.myscale = 50.0 / this.mdispmax;

      for (int var5 = 0; var5 < 1599; var5++) {
         this.mDisplacement1[var5] = this.mDisplacement1[var5] * this.myscale;
         this.mDisplacement2[var5] = this.mDisplacement2[var5] * this.myscale;
      }
   }

   public void DrawTraceGrid() {
      this.mTraceGC.setPaintMode();
      this.mTraceGC.setColor(Color.white);
      this.mTraceGC.fillRect(0, 0, 3210, 200);
      this.mTraceGC.setColor(Color.black);

      for (int p = 0; p < 3210; p += 50) {
         this.mTraceGC.drawLine(p, 0, p, 200);
      }

      this.mTraceGC.drawLine(0, 60, 3210, 60);
      this.mTraceGC.drawLine(0, 151, 3210, 151);
   }

   public void DrawForceGraph() {
      Color force = new Color(0.77F, 0.38F, 0.0F);
      this.mTraceGC.setColor(force);
      this.mWinrads = this.mWin * 2.0 * Math.PI;

      for (int p = (int)(1.0 / dt); p < 1598; p++) {
         this.mTraceGC
            .drawLine(
               p * 2 + 400 + 10,
               151 + (int)(200.0 * Math.sin(this.mWinrads * (2 * p * dt - 2.0)) / 10.0),
               (p + 1) * 2 + 400 + 10,
               151 + (int)(200.0 * Math.sin(this.mWinrads * (2 * (p + 1) * dt - 2.0)) / 10.0)
            );
      }
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
               (int)(this.mTraceClip.height / 8 / 3.0 + this.mDisplacement1[p] / 8.0),
               ((p + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 / 3.0 + this.mDisplacement1[p + 1] / 8.0)
            );
      }

      for (int var3 = 0; var3 < 1598; var3++) {
         this.mTraceThumbnailGC
            .drawLine(
               (var3 * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 2.0 / 3.0 + this.mDisplacement2[var3] / 8.0),
               ((var3 + 1) * 2 + 400) / 8,
               (int)(this.mTraceClip.height / 8 * 2.0 / 3.0 + this.mDisplacement2[var3 + 1] / 8.0)
            );
      }
   }

   public void DrawTraceShape() {
      this.DrawTraceGrid();
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      this.mTraceGC.setColor(mass);

      for (int p = 0; p < 1598; p++) {
         this.mTraceGC.drawLine(p * 2 + 400 + 10, 151 + (int)this.mDisplacement1[p], (p + 1) * 2 + 400 + 10, 151 + (int)this.mDisplacement1[p + 1]);
      }

      for (int var3 = 0; var3 < 1598; var3++) {
         this.mTraceGC.drawLine(var3 * 2 + 400 + 10, 60 + (int)this.mDisplacement2[var3], (var3 + 1) * 2 + 400 + 10, 60 + (int)this.mDisplacement2[var3 + 1]);
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
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mm = val;
            break;
         case 3:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk1 = val;
            break;
         case 4:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mk2 = val;
            break;
         case 5:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mb = val;
            this.mforceposition = (int)(this.mb * 200.0);
            break;
         case 6:
            this.ChangeRunState(0);
            this.mTime = 0.0;
            this.mViewTime = 0.0;
            this.mDisplacement1 = null;
            this.mDisplacement2 = null;
            this.mWin = val;
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
      boolean hitMain = this.mTraceClip.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean hitThumbnail = this.mTraceThumbnail.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      boolean hitThumb = this.mThumbRect.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
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

package MultiDOF.Prog9.Multiforced;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kEditInputCode = 1;
   public static final int kWanimateCode = 2;
   public static final int kDeltaTimeCode = 3;
   public static final int kViscousDampingCode = 4;
   public static final int kAddCode = 5;
   public static final int kEditedCode = 6;
   public static final double kStartWanimate = 0.75;
   public static final int kXo = 40;
   public static final int kYo = 70;
   public static final int kYanimate = 5;
   public static final int kXoSystem = 40;
   public static final int kYoSystem = 15;
   public static final int kMaxElements = 12;
   public static final double mFreqScale = 0.005;
   public static final int kMinResponsePoint = 10;
   public static final int kResponsePoints = 601;
   double[] mAmp = new double[601];
   double[][] mAReal = new double[12][12];
   double[][] mAImag = new double[12][12];
   double[][] mBReal = new double[12][12];
   double[][] mBImag = new double[12][12];
   double[][] mCReal = new double[12][12];
   double[][] mCImag = new double[12][12];
   int mXPos;
   int mFPos;
   int mDisplayXPos;
   int mDisplayFPos;
   public Vector<CSpringMassDamper> mElements;
   public CSpringMassDamper mSelectedSMD;
   double mWanimate = 0.75;
   double mMax;
   double mMin;
   double mScale;
   public Button mInstructionButton;
   public Button mInputButton;
   double mTime = 0.0;
   public double mMaxMassAmp;
   boolean mClickedAboveSystem;
   CFrameSmallControl mWControl;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.AddElement(0, 1.0, 0.0, 0.0, false, true);
      this.AddElement(1, 1.5, 1.6, 0.01, true, false);
      this.AddElement(1, 1.6, 1.5, 0.01, true, false);
      this.AddElement(1, 1.7, 1.4, 0.01, true, false);
      this.AddElement(1, 1.8, 1.3, 0.01, true, false);
      this.AddElement(1, 1.9, 1.2, 0.01, true, false);
      this.SetXF(2, 5);
      this.SetSMDPositions();
   }

   public void Frame(Graphics g) {
      int var2 = 7;
      g.setPaintMode();
      g.setColor(Color.black);
      CSpringMassDamper var4 = this.GetSMD(this.mDisplayXPos);
      if (var4 != null) {
         var4.DrawSmallArrow(g, 5, "X");
      }

      var4 = this.GetSMD(this.mDisplayFPos);
      if (var4 != null) {
         var4.DrawSmallArrow(g, 47, "F");
      }

      g.setColor(Color.lightGray);
      g.drawRect(super.x, super.y, super.width, super.height);
      g.setColor(Color.black);
      int var6 = 3;
      if (this.mMax == this.mMin) {
         g.drawString("Please wait, calculating...", super.x + 10, super.y + 10);
      } else {
         this.mScale = 15.0;
         g.drawLine(super.x, super.y, super.x, super.y + super.height + var6);
         g.drawLine(super.x, super.y + super.height, super.x + super.width, super.y + super.height);

         for (int i = 0; i < 20; i++) {
            if ((int)(i * Math.log(10.0) * this.mScale) < super.height) {
               int var7 = super.y + 6 + (int)(i * Math.log(10.0) * this.mScale);
               g.drawLine(super.x, var7, super.x - var6, var7);
            }
         }

         for (int j = 1; j < 7; j++) {
            g.drawLine(super.x + j * 100, super.y + super.height, super.x + j * 100, super.y + super.height + var6);
         }

         Color tealColor = new Color(0.18F, 0.58F, 0.58F);
         g.setColor(tealColor);
         int var8 = (int)(super.y + 5 - (this.mAmp[9] - var2) * this.mScale);

         for (int k = 10; k < 601; k++) {
            int var9 = var8;
            var8 = (int)(super.y + 5 - (this.mAmp[k] - var2) * this.mScale);
            g.drawLine(super.x + (k - 1), var9, super.x + k, var8);
         }
      }

      int var13 = (int)(this.mWanimate / 0.005);
      if (var13 < 10) {
         var13 = 10;
      }

      if (var13 > 600) {
         var13 = 600;
      }

      g.setColor(Color.blue);
      g.drawLine(super.x + var13, super.y + 279, super.x + var13, (int)(super.y + 6 - (this.mAmp[var13] - var2) * this.mScale));
      g.drawString(this.nns(this.mWanimate) + " rad/s", super.x + var13 + 2, super.y + super.height - 2);
   }

   public double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + this.nns(-arg, sig);
      } else {
         double magnitude = Math.floor(this.log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long intArg = Math.round(arg / stepSize);
         String result = String.valueOf(intArg * stepSize);

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int trimIdx;
            for (trimIdx = result.length() - 1; result.charAt(trimIdx) == '0'; trimmed = true) {
               trimIdx--;
            }

            if (trimmed) {
               result = result.substring(0, trimIdx + 1);
            }

            String shortStr = result.substring(0, trimIdx);

            double parsedDouble;
            try {
               parsedDouble = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - parsedDouble) > stepSize) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      int n = 0;
      if (this.mElements != null) {
         n = this.mElements.size();
      }

      double var6 = this.GetTime();
      double parsedDouble;
      if (this.mMaxMassAmp == 0.0) {
         parsedDouble = 0.0;
      } else {
         parsedDouble = 40.0 / (this.mMaxMassAmp * 2.0);
      }

      for (int i = 1; i <= n; i++) {
         CSpringMassDamper var11 = this.GetSMD(i);
         Rectangle rect = new Rectangle(0, 0, 0, 0);
         rect.x = (int)(0.2 + var11.x + var11.width - 15.0 + parsedDouble * var11.mMassAmp * Math.sin(var6 * Math.PI + var11.mMassPhase));
         rect.y = var3;
         rect.width = 15;
         rect.height = 30;
         Color tealColor = new Color(0.18F, 0.58F, 0.58F);
         if (var11.IsAbutment()) {
            var1.setColor(Color.orange);
         } else {
            var1.setColor(tealColor);
         }

         var1.fillRect(rect.x, rect.y, rect.width, rect.height);
      }
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean trimmed = false;
      switch (code) {
         case 1:
            if (this.mSelectedSMD != null) {
               this.mSelectedSMD.ControlMessage(this, 1, 0.0);
            }
            break;
         case 2:
            this.mWanimate = val;
            this.setOmegaDisp(this.mWanimate);
            trimmed = true;
            break;
         case 3:
            this.mTime += val;
            trimmed = true;
         case 4:
         default:
            break;
         case 5:
            int var6 = 99999;
            if (this.mElements != null && this.mSelectedSMD != null) {
               var6 = this.mElements.indexOf(this.mSelectedSMD);
            }

            this.mSelectedSMD = this.AddElement(var6 + 1, 1.0, 1.0, 0.005, true, false);
            this.ForceReasonableSystem();
            this.SetSMDPositions();
            this.response();
            break;
         case 6:
            this.ForceReasonableSystem();
            this.response();
            trimmed = true;
      }

      if (trimmed) {
         this.repaint();
      }
   }

   public void response() {
      this.mMax = -1000.0;
      this.mMin = 1000.0;
      int var2 = this.mFPos;
      int var3 = this.mXPos;
      if (var2 < var3) {
         var2 = this.mXPos;
         var3 = this.mFPos;
      }

      this.mMax = 0.0;
      this.mMin = 0.0;

      for (int i = 1; i < 601; i++) {
         double var4 = i * 0.005;
         this.receptances(var4);
         this.mAmp[i] = Math.log(this.mAReal[var3][var2] * this.mAReal[var3][var2] + this.mAImag[var3][var2] * this.mAImag[var3][var2]) / 2.0;
         if (this.mAmp[i] > this.mMax) {
            this.mMax = this.mAmp[i];
         }

         if (this.mAmp[i] < this.mMin) {
            this.mMin = this.mAmp[i];
         }
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void receptances(double var1) {
      double[] var3 = new double[12];
      double[] var4 = new double[12];
      int var32 = this.mElements.size();
      CSpringMassDamper var33 = this.GetSMD(1);
      if (!var33.IsAbutment()) {
         this.mAReal[1][1] = -1.0 / (var33.mMass * var1 * var1);
         this.mAImag[1][1] = 0.0;
      } else {
         this.mAReal[1][1] = 0.0;
         this.mAImag[1][1] = 0.0;
      }

      for (int i = 2; i < var32 + 1; i++) {
         var33 = this.GetSMD(i);
         double var34 = var33.mSpringConstant;
         double var36 = var33.mDampingConstant;
         if (!var33.IsAbutment()) {
            this.mBReal[i][i] = -1.0 / (var33.mMass * var1 * var1);
            this.mBImag[i][i] = 0.0;
            this.mBReal[i - 1][i] = this.mBReal[i][i];
            this.mBImag[i - 1][i] = this.mBImag[i][i];
            double parsedDouble;
            double parsedDouble2;
            if (var33.mViscous) {
               parsedDouble = var34 / (var34 * var34 + var36 * var36 * var1 * var1);
               parsedDouble2 = -var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1);
            } else {
               parsedDouble = var34 / (var34 * var34 + var36 * var36);
               parsedDouble2 = -var36 / (var34 * var34 + var36 * var36);
            }

            this.mBReal[i - 1][i - 1] = parsedDouble + this.mBReal[i][i];
            this.mBImag[i - 1][i - 1] = parsedDouble2 + this.mBImag[i][i];
         } else {
            this.mBReal[i][i] = 0.0;
            this.mBImag[i][i] = 0.0;
            this.mBReal[i - 1][i] = this.mBReal[i][i];
            this.mBImag[i - 1][i] = this.mBImag[i][i];
            double parsedDouble3;
            double parsedDouble4;
            if (var33.mViscous) {
               parsedDouble3 = var34 / (var34 * var34 + var36 * var36 * var1 * var1);
               parsedDouble4 = -var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1);
            } else {
               parsedDouble3 = var34 / (var34 * var34 + var36 * var36);
               parsedDouble4 = -var36 / (var34 * var34 + var36 * var36);
            }

            this.mBReal[i - 1][i - 1] = parsedDouble3;
            this.mBImag[i - 1][i - 1] = parsedDouble4;
         }

         for (int j = 1; j < i; j++) {
            for (int k = 1; k < j + 1; k++) {
               this.mCReal[k][j] = this.mAReal[k][j];
               this.mCImag[k][j] = this.mAImag[k][j];
            }
         }

         double var25 = this.mBReal[i - 1][i - 1] + this.mCReal[i - 1][i - 1];
         double var27 = this.mBImag[i - 1][i - 1] + this.mCImag[i - 1][i - 1];

         for (int var64 = 1; var64 < i + 1; var64++) {
            var3[var64] = 0.0;
            var4[var64] = 0.0;
         }

         for (int var65 = 1; var65 < i + 1; var65++) {
            for (int var63 = 1; var63 < var65 + 1; var63++) {
               var3[var65] = 1.0;
               if (var65 < i - 1) {
                  double var17 = this.mCReal[var65][i - 1] * var3[var65] - this.mCImag[var65][i - 1] * var4[var65];
                  double var19 = this.mCReal[var65][i - 1] * var4[var65] + this.mCImag[var65][i - 1] * var3[var65];
                  double mC = var25 * var25 + var27 * var27;
                  double var5 = (var17 * var25 + var19 * var27) / mC;
                  double var7 = (var19 * var25 - var17 * var27) / mC;
                  double var9 = -var5;
                  double var11 = -var7;
                  var17 = this.mCReal[var63][i - 1] * var9 - this.mCImag[var63][i - 1] * var11;
                  var19 = this.mCReal[var63][i - 1] * var11 + this.mCImag[var63][i - 1] * var9;
                  double var21 = this.mCReal[var63][var65] * var3[var65] - this.mCImag[var63][var65] * var4[var65];
                  double var23 = this.mCReal[var63][var65] * var4[var65] + this.mCImag[var63][var65] * var3[var65];
                  this.mAReal[var63][var65] = var17 + var21;
                  this.mAImag[var63][var65] = var19 + var23;
               }

               if (var65 == i - 1) {
                  double var52 = this.mCReal[i - 1][i - 1] * var3[i - 1] - this.mCImag[i - 1][i - 1] * var4[i - 1];
                  double var57 = this.mCReal[i - 1][i - 1] * var4[i - 1] + this.mCImag[i - 1][i - 1] * var3[i - 1];
                  double var48 = var25 * var25 + var27 * var27;
                  double var38 = (var52 * var25 + var57 * var27) / var48;
                  double var40 = (var57 * var25 - var52 * var27) / var48;
                  double var42 = var3[i - 1] - var38;
                  double var44 = var4[i - 1] - var40;
                  this.mAReal[var63][var65] = this.mCReal[var63][i - 1] * var42 - this.mCImag[var63][i - 1] * var44;
                  this.mAImag[var63][var65] = this.mCImag[var63][i - 1] * var42 + this.mCReal[var63][i - 1] * var44;
               }

               if (var65 == i) {
                  double var53 = this.mBReal[i - 1][var65] * var3[var65] - this.mBImag[i - 1][var65] * var4[var65];
                  double var58 = this.mBReal[i - 1][var65] * var4[var65] + this.mBImag[i - 1][var65] * var3[var65];
                  var53 = -var53;
                  var58 = -var58;
                  double var49 = var25 * var25 + var27 * var27;
                  double var39 = (var53 * var25 + var58 * var27) / var49;
                  double var41 = (var58 * var25 - var53 * var27) / var49;
                  double var43 = -var39;
                  double var45 = -var41;
                  if (var63 < i) {
                     this.mAReal[var63][var65] = this.mCReal[var63][i - 1] * var43 - this.mCImag[var63][i - 1] * var45;
                     this.mAImag[var63][var65] = this.mCReal[var63][i - 1] * var45 + this.mCImag[var63][i - 1] * var43;
                  } else {
                     var53 = this.mBReal[i - 1][var63] * var39 - this.mBImag[i - 1][var63] * var41;
                     var58 = this.mBReal[i - 1][var63] * var41 + this.mBImag[i - 1][var63] * var39;
                     double var61 = this.mBReal[var63][var65] * var3[var65] - this.mBImag[var63][var65] * var4[var65];
                     double var62 = this.mBReal[var63][var65] * var4[var65] + this.mBImag[var63][var65] * var3[var65];
                     this.mAReal[var63][var65] = var53 + var61;
                     this.mAImag[var63][var65] = var58 + var62;
                  }
               }

               var3[var65] = 0.0;
            }
         }
      }
   }

   public void setOmegaDisp(double var1) {
      this.mWanimate = var1;
      this.receptances(this.mWanimate);
      int n = 0;
      if (this.mElements != null) {
         n = this.mElements.size();
      }

      for (int i = 1; i <= this.mFPos; i++) {
         CSpringMassDamper var5 = this.GetSMD(i);
         var5.mMassAmp = Math.sqrt(
            this.mAReal[i][this.mFPos] * this.mAReal[i][this.mFPos] + this.mAImag[i][this.mFPos] * this.mAImag[i][this.mFPos]
         );
         var5.mMassPhase = Math.atan2(this.mAImag[i][this.mFPos], this.mAReal[i][this.mFPos]);
      }

      for (int j = this.mFPos + 1; j <= n; j++) {
         CSpringMassDamper var8 = this.GetSMD(j);
         var8.mMassAmp = Math.sqrt(
            this.mAReal[this.mFPos][j] * this.mAReal[this.mFPos][j] + this.mAImag[this.mFPos][j] * this.mAImag[this.mFPos][j]
         );
         var8.mMassPhase = Math.atan2(this.mAImag[this.mFPos][j], this.mAReal[this.mFPos][j]);
      }

      this.mMaxMassAmp = 0.0;

      for (int k = 1; k <= n; k++) {
         CSpringMassDamper var9 = this.GetSMD(k);
         if (var9.mMassAmp > this.mMaxMassAmp) {
            this.mMaxMassAmp = var9.mMassAmp;
         }
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public CSpringMassDamper AddElement(int var1, double var2, double var4, double var6, boolean var8, boolean var9) {
      if (this.mElements == null) {
         this.mElements = new Vector<CSpringMassDamper>();
      }

      int var10 = this.mElements.size();
      if (var10 >= 12) {
         return null;
      } else {
         if (var1 < 0) {
            var1 = 0;
         }

         if (var10 < var1) {
            var1 = var10;
         }

         CSpringMassDamper var11 = new CSpringMassDamper(super.mFramePanel, this, var2, var4, var6, var8, var9);
         if (var10 == 0) {
            this.mElements.addElement(var11);
         } else {
            this.mElements.insertElementAt(var11, var1);
         }

         return var11;
      }
   }

   public boolean ForceReasonableSystem() {
      int n = 0;
      if (this.mElements != null) {
         n = this.mElements.size();
      }

      CSpringMassDamper var3 = null;

      for (int i = 2; i < n; i++) {
         var3 = this.GetSMD(i);
         var3.SetAbutment(false);
      }

      int var4 = 1;
      int var5 = n;
      if (n < 2) {
         return false;
      } else {
         var3 = this.GetSMD(1);
         if (var3.IsAbutment()) {
            var4++;
         }

         var3 = this.GetSMD(n);
         if (var3.IsAbutment()) {
            var5 = n - 1;
         }

         if (this.mXPos < var4) {
            this.mXPos = var4;
         }

         if (var5 < this.mXPos) {
            this.mXPos = var5;
         }

         if (this.mFPos < var4) {
            this.mFPos = var4;
         }

         if (var5 < this.mFPos) {
            this.mFPos = var5;
         }

         this.mDisplayXPos = this.mXPos;
         this.mDisplayFPos = this.mFPos;
         return true;
      }
   }

   public void SetSMDPositions() {
      int n = 0;
      if (this.mElements != null) {
         n = this.mElements.size();
      }

      int xo = 40;
      int var4 = 15;

      for (int i = 1; i <= n; i++) {
         CSpringMassDamper var5 = this.GetSMD(i);
         var5.mIndex = i;
         var5.x = xo;
         var5.y = var4;
         var5.height = 30;
         if (i == 1) {
            var5.width = 15;
         } else {
            var5.width = 55;
         }

         xo += var5.width;
      }
   }

   public CSpringMassDamper GetSMD(int var1) {
      if (this.mElements == null) {
         return null;
      } else {
         return var1 >= 1 && this.mElements.size() >= var1 ? this.mElements.elementAt(var1 - 1) : null;
      }
   }

   public void SetXF(int var1, int var2) {
      this.mXPos = var1;
      this.mFPos = var2;
      this.ForceReasonableSystem();
      this.response();
   }

   public void SetSelection(CSpringMassDamper var1) {
      this.mSelectedSMD = var1;
      super.mFramePanel.repaint();
   }

   public boolean MouseEventOutside(int var1, boolean var2) {
      super.mWasHit = false;
      if (var1 == 0) {
         this.mClickedAboveSystem = super.mFramePanel.mThisPt.y < 15;
      }

      switch (var1) {
         case 0:
         case 1:
            int var3 = this.MouseToIndex(super.mFramePanel.mThisPt.x);
            if (var3 < 1) {
               return true;
            }

            if (this.mClickedAboveSystem) {
               this.mDisplayXPos = var3;
            } else {
               this.mDisplayFPos = var3;
            }

            super.mFramePanel.repaint();
            break;
         case 2:
            if (this.mDisplayXPos != this.mXPos || this.mDisplayFPos != this.mFPos) {
               this.SetXF(this.mDisplayXPos, this.mDisplayFPos);
            }
      }

      return true;
   }

   public boolean MouseEvent(int code, boolean prevHit) {
      if (prevHit) {
         return false;
      } else {
         boolean var3 = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         if (!var3) {
            return this.MouseEventOutside(code, prevHit);
         } else {
            super.mWasHit = false;
            switch (code) {
               case 0:
               case 1:
                  double var4 = (super.mFramePanel.mThisPt.x - super.x) * 0.005;
                  this.ControlMessage(this, 2, var4);
                  break;
               case 2:
                  if (this.mDisplayXPos != this.mXPos || this.mDisplayFPos != this.mFPos) {
                     this.SetXF(this.mDisplayXPos, this.mDisplayFPos);
                  }
            }

            return true;
         }
      }
   }

   public int MouseToIndex(int var1) {
      if (this.mElements == null) {
         return 0;
      } else {
         int var3 = this.mElements.size();

         for (int i = 1; i <= var3; i++) {
            CSpringMassDamper var4 = this.GetSMD(i);
            if (var4.InVerticalBand(var1)) {
               return i;
            }
         }

         return 0;
      }
   }
}

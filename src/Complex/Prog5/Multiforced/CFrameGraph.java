package Complex.Prog5.Multiforced;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

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
   public Vector mElements;
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

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
      this.AddElement(0, 1.0, 0.0, 0.0, false, true);
      this.AddElement(1, 1.5, 1.6, 0.01, true, false);
      this.AddElement(1, 1.6, 1.5, 0.01, true, false);
      this.AddElement(1, 1.7, 1.4, 0.01, true, false);
      this.AddElement(1, 1.8, 1.3, 0.01, true, false);
      this.AddElement(1, 1.9, 1.2, 0.01, true, false);
      this.SetXF(2, 5);
      this.SetSMDPositions();
   }

   public void Frame(Graphics var1) {
      byte var2 = 7;
      boolean var3 = false;
      var1.setPaintMode();
      var1.setColor(Color.black);
      CSpringMassDamper var4 = this.GetSMD(this.mDisplayXPos);
      if (var4 != null) {
         var4.DrawSmallArrow(var1, 5, "X");
      }

      var4 = this.GetSMD(this.mDisplayFPos);
      if (var4 != null) {
         var4.DrawSmallArrow(var1, 47, "F");
      }

      var1.setColor(Color.lightGray);
      var1.drawRect(super.x, super.y, super.width, super.height);
      var1.setColor(Color.black);
      byte var6 = 3;
      if (this.mMax == this.mMin) {
         var1.drawString("Please wait, calculating...", super.x + 10, super.y + 10);
      } else {
         this.mScale = 15.0;
         var1.drawLine(super.x, super.y, super.x, super.y + super.height + var6);
         var1.drawLine(super.x, super.y + super.height, super.x + super.width, super.y + super.height);

         for (int var5 = 0; var5 < 20; var5++) {
            if ((int)(var5 * Math.log(10.0) * this.mScale) < super.height) {
               int var7 = super.y + 6 + (int)(var5 * Math.log(10.0) * this.mScale);
               var1.drawLine(super.x, var7, super.x - var6, var7);
            }
         }

         for (int var11 = 1; var11 < 7; var11++) {
            var1.drawLine(super.x + var11 * 100, super.y + super.height, super.x + var11 * 100, super.y + super.height + var6);
         }

         Color var14 = new Color(0.18F, 0.58F, 0.58F);
         var1.setColor(var14);
         int var8 = (int)(super.y + 5 - (this.mAmp[9] - var2) * this.mScale);

         for (int var12 = 10; var12 < 601; var12++) {
            int var9 = var8;
            var8 = (int)(super.y + 5 - (this.mAmp[var12] - var2) * this.mScale);
            var1.drawLine(super.x + (var12 - 1), var9, super.x + var12, var8);
         }
      }

      int var13 = (int)(this.mWanimate / 0.005);
      if (var13 < 10) {
         var13 = 10;
      }

      if (var13 > 600) {
         var13 = 600;
      }

      var1.setColor(Color.blue);
      var1.drawLine(super.x + var13, super.y + 279, super.x + var13, (int)(super.y + 6 - (this.mAmp[var13] - var2) * this.mScale));
      var1.drawString(this.nns(this.mWanimate) + " rad/s", super.x + var13 + 2, super.y + super.height - 2);
   }

   public double log10(double var1) {
      return Math.log(var1) / Math.log(10.0);
   }

   public String nns(double var1, int var3) {
      if (var3 <= 0) {
         var3 = 1;
      }

      if (var1 == 0.0) {
         return new String("0");
      } else if (var1 < 0.0) {
         return new String("-" + this.nns(-var1, var3));
      } else {
         double var4 = Math.floor(this.log10(var1));
         double var6 = Math.pow(10.0, var4 - var3 + 1.0);
         long var8 = Math.round(var1 / var6);
         String var10 = new String(String.valueOf(var8 * var6));

         while (var10.length() > 1 && var10.indexOf(46) > -1) {
            boolean var11 = false;

            int var12;
            for (var12 = var10.length() - 1; var10.charAt(var12) == '0'; var11 = true) {
               var12--;
            }

            if (var11) {
               var10 = new String(var10.substring(0, var12 + 1));
            }

            String var13 = new String(var10.substring(0, var12));

            double var14;
            try {
               var14 = java.lang.Double.parseDouble(var13);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(var1 - var14) > var6) {
               break;
            }

            var10 = var13;
         }

         return var10;
      }
   }

   public String nns(double var1) {
      return this.nns(var1, 4);
   }

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      int var5 = 0;
      if (this.mElements != null) {
         var5 = this.mElements.size();
      }

      double var6 = this.GetTime();
      double var9;
      if (this.mMaxMassAmp == 0.0) {
         var9 = 0.0;
      } else {
         var9 = 40.0 / (this.mMaxMassAmp * 2.0);
      }

      for (int var4 = 1; var4 <= var5; var4++) {
         CSpringMassDamper var11 = this.GetSMD(var4);
         Rectangle var8 = new Rectangle(0, 0, 0, 0);
         var8.x = (int)(0.2 + var11.x + var11.width - 15.0 + var9 * var11.mMassAmp * Math.sin(var6 * Math.PI + var11.mMassPhase));
         var8.y = var3;
         var8.width = 15;
         var8.height = 30;
         Color var12 = new Color(0.18F, 0.58F, 0.58F);
         if (var11.IsAbutment()) {
            var1.setColor(Color.orange);
         } else {
            var1.setColor(var12);
         }

         var1.fillRect(var8.x, var8.y, var8.width, var8.height);
      }
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            if (this.mSelectedSMD != null) {
               this.mSelectedSMD.ControlMessage(this, 1, 0.0);
            }
            break;
         case 2:
            this.mWanimate = var3;
            this.setOmegaDisp(this.mWanimate);
            var5 = true;
            break;
         case 3:
            this.mTime += var3;
            var5 = true;
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
            var5 = true;
      }

      if (var5) {
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

      for (int var1 = 1; var1 < 601; var1++) {
         double var4 = var1 * 0.005;
         this.receptances(var4);
         this.mAmp[var1] = Math.log(this.mAReal[var3][var2] * this.mAReal[var3][var2] + this.mAImag[var3][var2] * this.mAImag[var3][var2]) / 2.0;
         if (this.mAmp[var1] > this.mMax) {
            this.mMax = this.mAmp[var1];
         }

         if (this.mAmp[var1] < this.mMin) {
            this.mMin = this.mAmp[var1];
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

      for (int var29 = 2; var29 < var32 + 1; var29++) {
         var33 = this.GetSMD(var29);
         double var34 = var33.mSpringConstant;
         double var36 = var33.mDampingConstant;
         if (!var33.IsAbutment()) {
            this.mBReal[var29][var29] = -1.0 / (var33.mMass * var1 * var1);
            this.mBImag[var29][var29] = 0.0;
            this.mBReal[var29 - 1][var29] = this.mBReal[var29][var29];
            this.mBImag[var29 - 1][var29] = this.mBImag[var29][var29];
            double var13;
            double var15;
            if (var33.mViscous) {
               var13 = var34 / (var34 * var34 + var36 * var36 * var1 * var1);
               var15 = -var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1);
            } else {
               var13 = var34 / (var34 * var34 + var36 * var36);
               var15 = -var36 / (var34 * var34 + var36 * var36);
            }

            this.mBReal[var29 - 1][var29 - 1] = var13 + this.mBReal[var29][var29];
            this.mBImag[var29 - 1][var29 - 1] = var15 + this.mBImag[var29][var29];
         } else {
            this.mBReal[var29][var29] = 0.0;
            this.mBImag[var29][var29] = 0.0;
            this.mBReal[var29 - 1][var29] = this.mBReal[var29][var29];
            this.mBImag[var29 - 1][var29] = this.mBImag[var29][var29];
            double var46;
            double var50;
            if (var33.mViscous) {
               var46 = var34 / (var34 * var34 + var36 * var36 * var1 * var1);
               var50 = -var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1);
            } else {
               var46 = var34 / (var34 * var34 + var36 * var36);
               var50 = -var36 / (var34 * var34 + var36 * var36);
            }

            this.mBReal[var29 - 1][var29 - 1] = var46;
            this.mBImag[var29 - 1][var29 - 1] = var50;
         }

         for (int var31 = 1; var31 < var29; var31++) {
            for (int var30 = 1; var30 < var31 + 1; var30++) {
               this.mCReal[var30][var31] = this.mAReal[var30][var31];
               this.mCImag[var30][var31] = this.mAImag[var30][var31];
            }
         }

         double var25 = this.mBReal[var29 - 1][var29 - 1] + this.mCReal[var29 - 1][var29 - 1];
         double var27 = this.mBImag[var29 - 1][var29 - 1] + this.mCImag[var29 - 1][var29 - 1];

         for (int var64 = 1; var64 < var29 + 1; var64++) {
            var3[var64] = 0.0;
            var4[var64] = 0.0;
         }

         for (int var65 = 1; var65 < var29 + 1; var65++) {
            for (int var63 = 1; var63 < var65 + 1; var63++) {
               var3[var65] = 1.0;
               if (var65 < var29 - 1) {
                  double var17 = this.mCReal[var65][var29 - 1] * var3[var65] - this.mCImag[var65][var29 - 1] * var4[var65];
                  double var19 = this.mCReal[var65][var29 - 1] * var4[var65] + this.mCImag[var65][var29 - 1] * var3[var65];
                  double var47 = var25 * var25 + var27 * var27;
                  double var5 = (var17 * var25 + var19 * var27) / var47;
                  double var7 = (var19 * var25 - var17 * var27) / var47;
                  double var9 = -var5;
                  double var11 = -var7;
                  var17 = this.mCReal[var63][var29 - 1] * var9 - this.mCImag[var63][var29 - 1] * var11;
                  var19 = this.mCReal[var63][var29 - 1] * var11 + this.mCImag[var63][var29 - 1] * var9;
                  double var21 = this.mCReal[var63][var65] * var3[var65] - this.mCImag[var63][var65] * var4[var65];
                  double var23 = this.mCReal[var63][var65] * var4[var65] + this.mCImag[var63][var65] * var3[var65];
                  this.mAReal[var63][var65] = var17 + var21;
                  this.mAImag[var63][var65] = var19 + var23;
               }

               if (var65 == var29 - 1) {
                  double var52 = this.mCReal[var29 - 1][var29 - 1] * var3[var29 - 1] - this.mCImag[var29 - 1][var29 - 1] * var4[var29 - 1];
                  double var57 = this.mCReal[var29 - 1][var29 - 1] * var4[var29 - 1] + this.mCImag[var29 - 1][var29 - 1] * var3[var29 - 1];
                  double var48 = var25 * var25 + var27 * var27;
                  double var38 = (var52 * var25 + var57 * var27) / var48;
                  double var40 = (var57 * var25 - var52 * var27) / var48;
                  double var42 = var3[var29 - 1] - var38;
                  double var44 = var4[var29 - 1] - var40;
                  this.mAReal[var63][var65] = this.mCReal[var63][var29 - 1] * var42 - this.mCImag[var63][var29 - 1] * var44;
                  this.mAImag[var63][var65] = this.mCImag[var63][var29 - 1] * var42 + this.mCReal[var63][var29 - 1] * var44;
               }

               if (var65 == var29) {
                  double var53 = this.mBReal[var29 - 1][var65] * var3[var65] - this.mBImag[var29 - 1][var65] * var4[var65];
                  double var58 = this.mBReal[var29 - 1][var65] * var4[var65] + this.mBImag[var29 - 1][var65] * var3[var65];
                  var53 = -var53;
                  var58 = -var58;
                  double var49 = var25 * var25 + var27 * var27;
                  double var39 = (var53 * var25 + var58 * var27) / var49;
                  double var41 = (var58 * var25 - var53 * var27) / var49;
                  double var43 = -var39;
                  double var45 = -var41;
                  if (var63 < var29) {
                     this.mAReal[var63][var65] = this.mCReal[var63][var29 - 1] * var43 - this.mCImag[var63][var29 - 1] * var45;
                     this.mAImag[var63][var65] = this.mCReal[var63][var29 - 1] * var45 + this.mCImag[var63][var29 - 1] * var43;
                  } else {
                     var53 = this.mBReal[var29 - 1][var63] * var39 - this.mBImag[var29 - 1][var63] * var41;
                     var58 = this.mBReal[var29 - 1][var63] * var41 + this.mBImag[var29 - 1][var63] * var39;
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
      int var4 = 0;
      if (this.mElements != null) {
         var4 = this.mElements.size();
      }

      for (int var3 = 1; var3 <= this.mFPos; var3++) {
         CSpringMassDamper var5 = this.GetSMD(var3);
         var5.mMassAmp = Math.sqrt(
            this.mAReal[var3][this.mFPos] * this.mAReal[var3][this.mFPos] + this.mAImag[var3][this.mFPos] * this.mAImag[var3][this.mFPos]
         );
         var5.mMassPhase = Math.atan2(this.mAImag[var3][this.mFPos], this.mAReal[var3][this.mFPos]);
      }

      for (int var6 = this.mFPos + 1; var6 <= var4; var6++) {
         CSpringMassDamper var8 = this.GetSMD(var6);
         var8.mMassAmp = Math.sqrt(
            this.mAReal[this.mFPos][var6] * this.mAReal[this.mFPos][var6] + this.mAImag[this.mFPos][var6] * this.mAImag[this.mFPos][var6]
         );
         var8.mMassPhase = Math.atan2(this.mAImag[this.mFPos][var6], this.mAReal[this.mFPos][var6]);
      }

      this.mMaxMassAmp = 0.0;

      for (int var7 = 1; var7 <= var4; var7++) {
         CSpringMassDamper var9 = this.GetSMD(var7);
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
         this.mElements = new Vector();
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
      int var2 = 0;
      if (this.mElements != null) {
         var2 = this.mElements.size();
      }

      CSpringMassDamper var3 = null;

      for (int var1 = 2; var1 < var2; var1++) {
         var3 = this.GetSMD(var1);
         var3.SetAbutment(false);
      }

      int var4 = 1;
      int var5 = var2;
      if (var2 < 2) {
         return false;
      } else {
         var3 = this.GetSMD(1);
         if (var3.IsAbutment()) {
            var4++;
         }

         var3 = this.GetSMD(var2);
         if (var3.IsAbutment()) {
            var5 = var2 - 1;
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
      int var2 = 0;
      if (this.mElements != null) {
         var2 = this.mElements.size();
      }

      int var3 = 40;
      byte var4 = 15;

      for (int var1 = 1; var1 <= var2; var1++) {
         CSpringMassDamper var5 = this.GetSMD(var1);
         var5.mIndex = var1;
         var5.x = var3;
         var5.y = var4;
         var5.height = 30;
         if (var1 == 1) {
            var5.width = 15;
         } else {
            var5.width = 55;
         }

         var3 += var5.width;
      }
   }

   public CSpringMassDamper GetSMD(int var1) {
      if (this.mElements == null) {
         return null;
      } else {
         return var1 >= 1 && this.mElements.size() >= var1 ? (CSpringMassDamper)this.mElements.elementAt(var1 - 1) : null;
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

   public boolean MouseEvent(int var1, boolean var2) {
      if (var2) {
         return false;
      } else {
         boolean var3 = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         if (!var3) {
            return this.MouseEventOutside(var1, var2);
         } else {
            super.mWasHit = false;
            switch (var1) {
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

         for (int var2 = 1; var2 <= var3; var2++) {
            CSpringMassDamper var4 = this.GetSMD(var2);
            if (var4.InVerticalBand(var1)) {
               return var2;
            }
         }

         return 0;
      }
   }
}

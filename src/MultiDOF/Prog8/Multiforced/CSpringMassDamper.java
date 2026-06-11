package MultiDOF.Prog8.Multiforced;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class CSpringMassDamper extends CFrame {
   public static final int kMassWidth = 15;
   public static final int kMassDepth = 30;
   public static final int kSpringWidth = 40;
   public static final int kSpringCL = 8;
   public static final int kdamperCL = 22;
   CFrameGraph mFrameGraph;
   public double mMass;
   public double mSpringConstant;
   public double mDampingConstant;
   public boolean mViscous;
   public boolean mAbutment;
   public int mIndex;
   public double mMassAmp;
   public double mMassPhase;
   CInputDialog mInputFrame;

   public CSpringMassDamper(CFramePanel var1, CFrameGraph var2, double var3, double var5, double var7, boolean var9, boolean var10) {
      super(var1);
      this.mFrameGraph = var2;
      this.mMass = var3;
      this.mSpringConstant = var5;
      this.mDampingConstant = var7;
      this.mViscous = var9;
      this.mAbutment = var10;
   }

   public boolean IsAbutment() {
      return this.mAbutment;
   }

   public boolean AtEnd() {
      int var1 = this.mFrameGraph.mElements.size();
      return this.mIndex == 1 || this.mIndex == var1;
   }

   public void SetAbutment(boolean var1) {
      this.mAbutment = var1;
   }

   public void Frame(Graphics g) {
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
      if (this.IsAbutment()) {
         g.setColor(Color.orange);
      } else {
         g.setColor(var2);
      }

      g.fillRect(super.x + super.width - 15, super.y, 15, super.height);
      g.setColor(Color.black);
      if (this.mIndex > 1) {
         this.DrawSpringAndDamper(g);
      }

      if (this.mFrameGraph.mSelectedSMD == this) {
         this.DrawSelRect(g);
      }
   }

   public void DrawSpringAndDamper(Graphics var1) {
      int var2 = super.y + 6 + 8;
      var1.drawLine(super.x, var2, super.x + 2, var2 - 2);

      for (int i = 1; i < 6; i++) {
         var1.drawLine(super.x + 2 + (i - 1) * 8, var2 - 2, super.x + 2 + (i - 1) * 8 + 4, var2 + 2);
      }

      for (int j = 1; j < 5; j++) {
         var1.drawLine(super.x + 6 + (j - 1) * 8, var2 + 2, super.x + 6 + (j - 1) * 8 + 4, var2 - 2);
      }

      var1.drawLine(super.x + 40 - 2, var2 + 2, super.x + 40, var2);
   }

   public void DrawSelRect(Graphics var1) {
      var1.setColor(Color.blue);
      var1.drawRect(super.x, super.y, super.width, super.height);
      var1.drawRect(super.x + 1, super.y + 1, super.width - 2, super.height - 2);
      var1.setColor(Color.black);
   }

   public void DrawSmallArrow(Graphics var1, int var2, String var3) {
      int var4 = super.x + super.width - 7;
      var1.drawLine(var4, var2, var4, var2 + 10);
      var1.drawLine(var4, var2 + 5, var4 + 10, var2 + 5);
      var1.drawLine(var4 + 10 - 2, var2 + 3, var4 + 10, var2 + 5);
      var1.drawLine(var4 + 10 - 2, var2 + 7, var4 + 10, var2 + 5);
      var1.drawString(var3, var4 + 12, var2 + 10);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean var5 = false;
      switch (code) {
         case 1:
            this.mInputFrame = new CInputDialog(this, "Edit subsystem " + (this.mIndex - 1));
            this.mInputFrame.setLocation(100, 100);
            this.mInputFrame.pack();
            this.mInputFrame.setVisible(true);
         case 2:
         case 3:
         case 4:
         case 5:
         default:
            break;
         case 6:
            this.mFrameGraph.ControlMessage(this, 6, val);
      }

      if (var5) {
         this.repaint();
      }
   }

   public boolean MouseEvent(int code, boolean prevHit) {
      super.mWasHit = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      if (!super.mWasHit) {
         return false;
      }

      switch (code) {
         case 0:
            this.mFrameGraph.SetSelection(this);
         case 1:
         case 2:
         case 3:
         default:
            break;
         case 4:
            this.ControlMessage(this, 1, 0.0);
      }

      return true;
   }

   public boolean InVerticalBand(int var1) {
      return var1 < super.x ? false : super.x + super.width >= var1;
   }
}

import java.awt.Color;
import java.awt.Graphics;

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

   public void Frame(Graphics var1) {
      Color var2 = new Color(0.18F, 0.58F, 0.58F);
      if (this.IsAbutment()) {
         var1.setColor(Color.orange);
      } else {
         var1.setColor(var2);
      }

      var1.fillRect(super.x + super.width - 15, super.y, 15, super.height);
      var1.setColor(Color.black);
      if (this.mIndex > 1) {
         this.DrawSpringAndDamper(var1);
      }

      if (this.mFrameGraph.mSelectedSMD == this) {
         this.DrawSelRect(var1);
      }
   }

   public void DrawSpringAndDamper(Graphics var1) {
      int var2 = super.y + 8;
      var1.drawLine(super.x, var2, super.x + 2, var2 - 2);

      for (int var3 = 1; var3 < 6; var3++) {
         var1.drawLine(super.x + 2 + (var3 - 1) * 8, var2 - 2, super.x + 2 + (var3 - 1) * 8 + 4, var2 + 2);
      }

      for (int var5 = 1; var5 < 5; var5++) {
         var1.drawLine(super.x + 6 + (var5 - 1) * 8, var2 + 2, super.x + 6 + (var5 - 1) * 8 + 4, var2 - 2);
      }

      var1.drawLine(super.x + 40 - 2, var2 + 2, super.x + 40, var2);
      var2 = super.y + 22;
      var1.drawLine(super.x, var2, super.x + 19, var2);
      var1.drawLine(super.x + 19, var2 - 2, super.x + 19, var2 + 2);
      var1.drawLine(super.x + 16, var2 - 4, super.x + 22, var2 - 4);
      var1.drawLine(super.x + 22, var2 - 4, super.x + 22, var2 + 4);
      var1.drawLine(super.x + 16, var2 + 4, super.x + 22, var2 + 4);
      var1.drawLine(super.x + 22, var2, super.x + 40, var2);
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

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mInputFrame = new CInputDialog(this, "Edit subsystem " + (this.mIndex - 1));
            this.mInputFrame.move(100, 100);
            this.mInputFrame.resize(200, 130);
            this.mInputFrame.show();
         case 2:
         case 3:
         case 4:
         case 5:
         default:
            break;
         case 6:
            this.mFrameGraph.ControlMessage(this, 6, var3);
      }

      if (var5) {
         this.repaint();
      }
   }

   public boolean MouseEvent(int var1, boolean var2) {
      super.mWasHit = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
      if (!super.mWasHit) {
         return false;
      } else {
         switch (var1) {
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
   }

   public boolean InVerticalBand(int var1) {
      return var1 < super.x ? false : super.x + super.width >= var1;
   }
}

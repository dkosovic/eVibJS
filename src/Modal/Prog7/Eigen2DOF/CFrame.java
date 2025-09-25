package Modal.Prog7.Eigen2DOF;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
class CFrame extends Rectangle {
   public static final int kMouseDown = 0;
   public static final int kMouseDrag = 1;
   public static final int kMouseUp = 2;
   public static final int kMouseMove = 3;
   public boolean mWasHit;
   CFramePanel mFramePanel;

   public CFrame(CFramePanel var1) {
      super(0, 0, 0, 0);
      this.mFramePanel = var1;
      this.mFramePanel.AddFrame(this);
   }

   public CFrame(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var2, var3, var4, var5);
      this.mFramePanel = var1;
      this.mFramePanel.AddFrame(this);
   }

   public void Frame(Graphics var1) {
   }

   public boolean MouseEvent(int var1, boolean var2) {
      this.mWasHit = this.contains(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
      return false;
   }

   public Point GlobalToLocal(Point var1) {
      return var1 == null ? null : new Point(var1.x - super.x, var1.y - super.y);
   }

   public Rectangle GlobalToLocalR(Rectangle var1) {
      return var1 == null ? null : new Rectangle(var1.x - super.x, var1.y - super.y, var1.width, var1.height);
   }

   public Point LocalToGlobal(Point var1) {
      return var1 == null ? null : new Point(var1.x + super.x, var1.y + super.y);
   }

   public Rectangle LocalToGlobalR(Rectangle var1) {
      return var1 == null ? null : new Rectangle(var1.x + super.x, var1.y + super.y, var1.width, var1.height);
   }

   public void repaint() {
      this.mFramePanel.repaint();
   }

   public void repaint(long var1) {
      this.mFramePanel.repaint(var1);
   }

   public void ControlMessage(int var1, double var2) {
      this.ControlMessage(null, var1, var2);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
   }
}

package Complex.Prog3.Forcedresponse;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
class CFrame extends Rectangle implements MouseListener {
   public static final int kMouseDown = 0;
   public static final int kMouseDrag = 1;
   public static final int kMouseUp = 2;
   public static final int kMouseMove = 3;
   public boolean mWasHit;
   CFramePanel mFramePanel;

   public CFrame(CFramePanel thePanel) {
      super(0, 0, 0, 0);
      this.mFramePanel = thePanel;
      this.mFramePanel.AddFrame(this);
      this.mFramePanel.addMouseListener(this);
   }

   public CFrame(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(xx, yy, ww, hh);
      this.mFramePanel = thePanel;
      this.mFramePanel.AddFrame(this);
      this.mFramePanel.addMouseListener(this);
   }

   public void Frame(Graphics g) {
   }

   @Override
   public void mousePressed(MouseEvent e) {
      this.mWasHit = this.contains(e.getX(), e.getY());
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // Default implementation - can be overridden by subclasses
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // Default implementation - can be overridden by subclasses
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // Default implementation - can be overridden by subclasses
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // Default implementation - can be overridden by subclasses
   }

   public Point GlobalToLocal(Point glob) {
      return glob == null ? null : new Point(glob.x - super.x, glob.y - super.y);
   }

   public Rectangle GlobalToLocalR(Rectangle glob) {
      return glob == null ? null : new Rectangle(glob.x - super.x, glob.y - super.y, glob.width, glob.height);
   }

   public Point LocalToGlobal(Point loc) {
      return loc == null ? null : new Point(loc.x + super.x, loc.y + super.y);
   }

   public Rectangle LocalToGlobalR(Rectangle loc) {
      return loc == null ? null : new Rectangle(loc.x + super.x, loc.y + super.y, loc.width, loc.height);
   }

   public void repaint() {
      this.mFramePanel.repaint();
   }

   public void repaint(long delay) {
      this.mFramePanel.repaint(delay);
   }

   public void ControlMessage(int code, double val) {
      this.ControlMessage(null, code, val);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
   }
}

package Modal.Prog6.Qfactor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CFrameHelp extends CFrame implements ActionListener, MouseListener {
   Timer mTimer;
   boolean mShowtime;
   public String mMessage;
   public double mDelay = 1.5;
   public Point mArrowHead;

   public CFrameHelp(CFramePanel thePanel, int xx, int yy, int ww, int hh, String message) {
      super(thePanel, xx, yy, ww, hh);
      this.mMessage = message;
      this.DefaultArrowPos();

      // Register modern mouse event listeners for direct, responsive mouse handling
      thePanel.addMouseListener(this);
   }

   public void DefaultArrowPos() {
      this.mArrowHead = new Point(super.x + super.width / 2, super.y + super.height / 2);
   }

   public void Frame(Graphics g) {
      g.setPaintMode();
      if (this.mShowtime) {
         Point mArrow;
         if (this.mArrowHead == null) {
            mArrow = super.mFramePanel.mLastPt;
         } else {
            mArrow = this.mArrowHead;
         }

         int wid = super.mFramePanel.getSize().width;
         int hei = super.mFramePanel.getSize().height;
         int kLineSpacing = 12;
         int kLineGap = 5;
         int gap1 = 10;
         int gap2 = 20;
         int ww = 0;
         int hh = 2 * kLineGap;
         StringTokenizer st = new StringTokenizer(this.mMessage, "\n");

         while (st.hasMoreTokens()) {
            hh += kLineSpacing;
            int thisWidth = g.getFontMetrics().stringWidth(st.nextToken());
            if (thisWidth > ww) {
               ww = thisWidth;
            }
         }

         ww += 2 * gap1;
         int xMult = 1;
         int yMult = 1;
         if (mArrow.x + gap1 + ww > wid) {
            xMult = -1;
         }

         if (mArrow.y + gap1 + hh > hei) {
            yMult = -1;
         }

         Polygon p = new Polygon();
         p.addPoint(mArrow.x, mArrow.y);
         p.addPoint(mArrow.x + xMult * gap1, mArrow.y + yMult * gap2);
         p.addPoint(mArrow.x + xMult * gap1, mArrow.y + yMult * (gap1 + hh));
         p.addPoint(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * (gap1 + hh));
         p.addPoint(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * gap1);
         p.addPoint(mArrow.x + xMult * gap2, mArrow.y + yMult * gap1);
         p.addPoint(mArrow.x, mArrow.y);
         g.setColor(Color.white);
         g.fillPolygon(p);
         g.setColor(Color.black);
         g.drawPolygon(p);
         int tx;
         if (xMult > 0) {
            tx = mArrow.x + 2 * gap1;
         } else {
            tx = mArrow.x - ww;
         }

         int ty;
         if (yMult > 0) {
            ty = mArrow.y + gap1 + kLineGap + kLineSpacing;
         } else {
            ty = mArrow.y - gap1 - hh + kLineGap + kLineSpacing;
         }

         int tokenNo = -1;
         st = new StringTokenizer(this.mMessage, "\n");

         while (st.hasMoreTokens()) {
            g.drawString(st.nextToken(), tx, ty + ++tokenNo * kLineSpacing);
         }
      }
   }

   @Override
   public void mousePressed(MouseEvent e) {
      super.mWasHit = false;
      if (this.mShowtime) {
         this.repaint();
      }

      this.mShowtime = false;
      this.mTimer = null;

      // Check if this is a left mouse button click (button 1)
      if (e.getButton() != MouseEvent.BUTTON1) {
         return;
      }

      // Check if click is within component bounds
      if (!this.contains(e.getX(), e.getY())) {
         return;
      }

      this.mTimer = new Timer((int)(this.mDelay * 1000), this);
      this.mTimer.start();
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // Not used
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      // Not used
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // Not used
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // Not used
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mTimer != null) {
         this.mShowtime = true;
         this.repaint();
      }
   }
}

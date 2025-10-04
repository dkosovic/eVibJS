package OneDOF.Forced.Forced;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.Vector;

@SuppressWarnings("serial")
public class CFramePanel extends Panel implements MouseListener, MouseMotionListener {
   public Applet mApplet;
   Vector<CFrame> mFrames;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   public boolean mButton;
   public Point mStartPt;
   public Point mLastPt;
   public Point mThisPt;
   long mLastClickTime;

   CFramePanel(Applet app) {
      this.mApplet = app;
      this.mStartPt = new Point(0, 0);
      this.mLastPt = new Point(0, 0);
      this.mThisPt = new Point(0, 0);

      // Add modern mouse listeners
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
   }

   public void update(Graphics g) {
      if (g != null) {
         this.mScreenGC = g;
         this.paint(this.mScreenGC);
      }
   }

   public void DrawAllFrames(Graphics g) {
      int count = 0;
      if (this.mFrames != null) {
         count = this.mFrames.size();
      }

      for (int i = 0; i < count; i++) {
         CFrame thisFrame = this.mFrames.elementAt(i);
         thisFrame.Frame(g);
      }
   }

   public void AddFrame(CFrame f) {
      if (this.mFrames == null) {
         this.mFrames = new Vector<CFrame>();
      } else if (this.mFrames.contains(f)) {
         this.mFrames.removeElement(f);
      }

      this.mFrames.addElement(f);
   }

   public void RemoveFrame(CFrame f) {
      if (this.mFrames != null) {
         this.mFrames.removeElement(f);
         if (this.mFrames.size() == 0) {
            this.mFrames = null;
         }
      }
   }

   public void paint(Graphics g) {
      this.mScreenGC = g;
      if (this.mOffScreenGC == null) {
         this.mOffScrImage = this.createImage(this.getSize().width, this.getSize().height);
         this.mOffScreenGC = this.mOffScrImage.getGraphics();
      }

      int ww = this.mOffScrImage.getWidth(this);
      int hh = this.mOffScrImage.getHeight(this);
      this.mOffScreenGC.setPaintMode();
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, ww, hh);
      this.mOffScreenGC.setColor(Color.black);
      this.DrawAllFrames(this.mOffScreenGC);
      g.drawImage(this.mOffScrImage, 0, 0, null);
   }

   // Modern MouseListener implementation
   @Override
   public void mousePressed(MouseEvent e) {
      this.mButton = true;
      this.mStartPt.x = e.getX();
      this.mStartPt.y = e.getY();
      this.mLastPt.x = e.getX();
      this.mLastPt.y = e.getY();
      this.mThisPt.x = e.getX();
      this.mThisPt.y = e.getY();

      Date currentTime = new Date();
      long currentTimeMs = currentTime.getTime();
      int eventType;
      if (currentTimeMs - this.mLastClickTime < 500L) {
         eventType = 4; // Double click
      } else {
         eventType = 0; // Mouse down
      }

      this.mLastClickTime = currentTimeMs;
      if (this.SendMouseEvent(eventType)) {
         this.repaint();
      }
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      this.mButton = false;
      if (this.SendMouseEvent(2)) {
         this.repaint();
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // Handled in mousePressed for double-click detection
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // Not used
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // Not used
   }

   // Modern MouseMotionListener implementation
   @Override
   public void mouseDragged(MouseEvent e) {
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = e.getX();
      this.mThisPt.y = e.getY();
      if (this.SendMouseEvent(1)) {
         this.repaint();
      }
   }

   @Override
   public void mouseMoved(MouseEvent e) {
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = e.getX();
      this.mThisPt.y = e.getY();
      this.mButton = false;
      if (this.SendMouseEvent(3)) {
         this.repaint();
      }
   }

   boolean SendMouseEvent(int code) {
      int count = 0;
      if (this.mFrames != null) {
         count = this.mFrames.size();
      }

      boolean result = false;
      boolean prevHit = false;

      for (int i = count - 1; i >= 0; i--) {
         CFrame thisFrame = this.mFrames.elementAt(i);
         if (thisFrame.MouseEvent(code, prevHit)) {
            result = true;
         }

         prevHit = prevHit || thisFrame.mWasHit;
      }

      return result;
   }
}


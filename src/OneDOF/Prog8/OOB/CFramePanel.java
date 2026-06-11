package OneDOF.Prog8.OOB;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.util.Vector;

@SuppressWarnings("serial")
public class CFramePanel extends Panel {
   public Applet mApplet;
   Vector<CFrame> mFrames;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   public boolean mButton;
   public Point mStartPt;
   public Point mLastPt;
   public Point mThisPt;
   public Event mMouseEvent;

   CFramePanel(Applet app) {
      this.mApplet = app;
      this.mStartPt = new Point(0, 0);
      this.mLastPt = new Point(0, 0);
      this.mThisPt = new Point(0, 0);
   }

   public void update(Graphics g) {
      if (g != null) {
         this.mScreenGC = g;
         this.paint(this.mScreenGC);
      }
   }

   public void DrawAllFrames(Graphics g) {
      int var3 = 0;
      if (this.mFrames != null) {
         var3 = this.mFrames.size();
      }

      for (int i = 0; i < var3; i++) {
         CFrame var4 = this.mFrames.elementAt(i);
         var4.Frame(g);
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

      int var2 = this.mOffScrImage.getWidth(this);
      int var3 = this.mOffScrImage.getHeight(this);
      this.mOffScreenGC.setPaintMode();
      this.mOffScreenGC.setColor(Color.white);
      this.mOffScreenGC.fillRect(0, 0, var2, var3);
      this.mOffScreenGC.setColor(Color.black);
      this.DrawAllFrames(this.mOffScreenGC);
      g.drawImage(this.mOffScrImage, 0, 0, null);
   }

   public boolean mouseDown(Event evt, int xx, int yy) {
      this.mMouseEvent = evt;
      this.mButton = true;
      this.mStartPt.x = xx;
      this.mStartPt.y = yy;
      this.mLastPt.x = xx;
      this.mLastPt.y = yy;
      this.mThisPt.x = xx;
      this.mThisPt.y = yy;
      if (this.SendMouseEvent(0)) {
         this.repaint();
      }

      return true;
   }

   public boolean mouseDrag(Event evt, int xx, int yy) {
      this.mMouseEvent = evt;
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = xx;
      this.mThisPt.y = yy;
      if (this.SendMouseEvent(1)) {
         this.repaint();
      }

      return true;
   }

   public boolean mouseUp(Event evt, int xx, int yy) {
      this.mMouseEvent = evt;
      this.mButton = false;
      if (this.SendMouseEvent(2)) {
         this.repaint();
      }

      this.mMouseEvent = null;
      return true;
   }

   public boolean mouseMove(Event evt, int xx, int yy) {
      this.mMouseEvent = evt;
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = xx;
      this.mThisPt.y = yy;
      this.mButton = false;
      if (this.SendMouseEvent(3)) {
         this.repaint();
      }

      return true;
   }

   boolean SendMouseEvent(int code) {
      int var3 = 0;
      if (this.mFrames != null) {
         var3 = this.mFrames.size();
      }

      boolean var4 = false;
      boolean var5 = false;

      for (int i = var3 - 1; i >= 0; i--) {
         CFrame var6 = this.mFrames.elementAt(i);
         if (var6.MouseEvent(code, var5)) {
            var4 = true;
         }

         var5 = var5 || var6.mWasHit;
      }

      return var4;
   }
}

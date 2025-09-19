package Modal.Qhysteretic.Qfactor;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.util.Date;
import java.util.Vector;

public class CFramePanel extends Panel {
   public Applet mApplet;
   Vector mFrames;
   Image mOffScrImage;
   Graphics mScreenGC;
   Graphics mOffScreenGC;
   public boolean mButton;
   public Point mStartPt;
   public Point mLastPt;
   public Point mThisPt;
   public Event mMouseEvent;
   long mLastClickTime;

   CFramePanel(Applet var1) {
      this.mApplet = var1;
      this.mStartPt = new Point(0, 0);
      this.mLastPt = new Point(0, 0);
      this.mThisPt = new Point(0, 0);
   }

   public void update(Graphics var1) {
      if (var1 != null) {
         this.mScreenGC = var1;
         this.paint(this.mScreenGC);
      }
   }

   public void DrawAllFrames(Graphics var1) {
      int var3 = 0;
      if (this.mFrames != null) {
         var3 = this.mFrames.size();
      }

      for (int var2 = 0; var2 < var3; var2++) {
         CFrame var4 = (CFrame)this.mFrames.elementAt(var2);
         var4.Frame(var1);
      }
   }

   public void AddFrame(CFrame var1) {
      if (this.mFrames == null) {
         this.mFrames = new Vector();
      }

      this.mFrames.addElement(var1);
   }

   public void RemoveFrame(CFrame var1) {
      if (this.mFrames != null) {
         this.mFrames.removeElement(var1);
         if (this.mFrames.size() == 0) {
            this.mFrames = null;
         }
      }
   }

   public void paint(Graphics var1) {
      this.mScreenGC = var1;
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
      var1.drawImage(this.mOffScrImage, 0, 0, null);
   }

   public boolean mouseDown(Event var1, int var2, int var3) {
      this.mMouseEvent = var1;
      this.mButton = true;
      this.mStartPt.x = var2;
      this.mStartPt.y = var3;
      this.mLastPt.x = var2;
      this.mLastPt.y = var3;
      this.mThisPt.x = var2;
      this.mThisPt.y = var3;
      Date var4 = new Date();
      long var5 = var4.getTime();
      byte var7;
      if (var5 - this.mLastClickTime < 500L) {
         var7 = 4;
      } else {
         var7 = 0;
      }

      this.mLastClickTime = var5;
      if (this.SendMouseEvent(var7)) {
         this.repaint();
      }

      return true;
   }

   public boolean mouseDrag(Event var1, int var2, int var3) {
      this.mMouseEvent = var1;
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = var2;
      this.mThisPt.y = var3;
      if (this.SendMouseEvent(1)) {
         this.repaint();
      }

      return true;
   }

   public boolean mouseUp(Event var1, int var2, int var3) {
      this.mMouseEvent = var1;
      this.mButton = false;
      if (this.SendMouseEvent(2)) {
         this.repaint();
      }

      this.mMouseEvent = null;
      return true;
   }

   public boolean mouseMove(Event var1, int var2, int var3) {
      this.mMouseEvent = var1;
      this.mLastPt.x = this.mThisPt.x;
      this.mLastPt.y = this.mThisPt.y;
      this.mThisPt.x = var2;
      this.mThisPt.y = var3;
      this.mButton = false;
      if (this.SendMouseEvent(3)) {
         this.repaint();
      }

      return true;
   }

   boolean SendMouseEvent(int var1) {
      int var3 = 0;
      if (this.mFrames != null) {
         var3 = this.mFrames.size();
      }

      boolean var4 = false;
      boolean var5 = false;

      for (int var2 = var3 - 1; var2 >= 0; var2--) {
         CFrame var6 = (CFrame)this.mFrames.elementAt(var2);
         if (var6.MouseEvent(var1, var5)) {
            var4 = true;
         }

         var5 = var5 || var6.mWasHit;
      }

      return var4;
   }
}

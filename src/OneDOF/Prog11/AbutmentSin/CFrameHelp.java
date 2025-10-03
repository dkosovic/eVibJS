package OneDOF.Prog11.AbutmentSin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
class CFrameHelp extends CFrame implements ActionListener {
   Timer mTimer;
   boolean mShowtime;
   public String mMessage;
   public double mDelay = 1.5;
   public Point mArrowHead;

   public CFrameHelp(CFramePanel var1, int var2, int var3, int var4, int var5, String var6) {
      super(var1, var2, var3, var4, var5);
      this.mMessage = var6;
      this.DefaultArrowPos();
   }

   public void DefaultArrowPos() {
      this.mArrowHead = new Point(super.x + super.width / 2, super.y + super.height / 2);
   }

   public void Frame(Graphics var1) {
      var1.setPaintMode();
      if (this.mShowtime) {
         Point var2;
         if (this.mArrowHead == null) {
            var2 = super.mFramePanel.mLastPt;
         } else {
            var2 = this.mArrowHead;
         }

         int var3 = super.mFramePanel.getSize().width;
         int var4 = super.mFramePanel.getSize().height;
         byte var5 = 12;
         byte var6 = 5;
         byte var7 = 10;
         byte var8 = 20;
         int var9 = 0;
         int var10 = 2 * var6;
         StringTokenizer var11 = new StringTokenizer(this.mMessage, "\n");

         while (var11.hasMoreTokens()) {
            var10 += var5;
            int var12 = var1.getFontMetrics().stringWidth(var11.nextToken());
            if (var12 > var9) {
               var9 = var12;
            }
         }

         var9 += 2 * var7;
         byte var20 = 1;
         byte var13 = 1;
         if (var2.x + var7 + var9 > var3) {
            var20 = -1;
         }

         if (var2.y + var7 + var10 > var4) {
            var13 = -1;
         }

         Polygon var14 = new Polygon();
         var14.addPoint(var2.x, var2.y);
         var14.addPoint(var2.x + var20 * var7, var2.y + var13 * var8);
         var14.addPoint(var2.x + var20 * var7, var2.y + var13 * (var7 + var10));
         var14.addPoint(var2.x + var20 * (var7 + var9), var2.y + var13 * (var7 + var10));
         var14.addPoint(var2.x + var20 * (var7 + var9), var2.y + var13 * var7);
         var14.addPoint(var2.x + var20 * var8, var2.y + var13 * var7);
         var14.addPoint(var2.x, var2.y);
         var1.setColor(Color.white);
         var1.fillPolygon(var14);
         var1.setColor(Color.black);
         var1.drawPolygon(var14);
         int var15;
         if (var20 > 0) {
            var15 = var2.x + 2 * var7;
         } else {
            var15 = var2.x - var9;
         }

         int var16;
         if (var13 > 0) {
            var16 = var2.y + var7 + var6 + var5;
         } else {
            var16 = var2.y - var7 - var10 + var6 + var5;
         }

         int var17 = -1;
         var11 = new StringTokenizer(this.mMessage, "\n");

         while (var11.hasMoreTokens()) {
            var1.drawString(var11.nextToken(), var15, var16 + ++var17 * var5);
         }
      }
   }

   public boolean MouseEvent(int var1, boolean var2) {
      super.mWasHit = false;
      if (this.mShowtime) {
         this.repaint();
      }

      this.mShowtime = false;
      this.mTimer = null;
      if (var1 != 3) {
         return false;
      } else if (!this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y)) {
         return false;
      } else {
         this.mTimer = new Timer((int)(this.mDelay * 1000), this);
         this.mTimer.start();
         return true;
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mTimer != null) {
         this.mShowtime = true;
         this.repaint();
      }
   }
}

package OneDOF.Forced.Forced;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;

class CPicturePanel extends Panel {
   public Image mImage;
   MediaTracker mTracker;

   public CPicturePanel() {
   }

   public CPicturePanel(Image img) {
      this.LoadImage(img);
   }

   public void LoadImage(Image img) {
      this.mImage = img;
      this.mTracker = new MediaTracker(this);
      this.mTracker.addImage(this.mImage, 0);

      try {
         this.mTracker.waitForAll();
      } catch (InterruptedException var2) {
      }
   }

   public synchronized Dimension minimumSize() {
      if (this.mImage == null) {
         return new Dimension(20, 24);
      } else {
         int ww = this.mImage.getWidth(this);
         int hh = this.mImage.getHeight(this);
         return ww >= 0 && hh >= 0 ? new Dimension(ww, hh) : new Dimension(20, 24);
      }
   }

   public synchronized Dimension preferredSize() {
      return this.minimumSize();
   }

   public void paint(Graphics g) {
      if (!this.mTracker.checkAll()) {
         g.drawString("...", 0, 20);
         this.repaint(200L);
      } else {
         g.drawImage(this.mImage, 0, 0, this);
      }
   }
}

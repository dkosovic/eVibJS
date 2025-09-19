package TwoDOF.Prog12.Forcedresponse_2DOF;

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

   public CPicturePanel(Image var1) {
      this.LoadImage(var1);
   }

   public void LoadImage(Image var1) {
      this.mImage = var1;
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
         int var1 = this.mImage.getWidth(this);
         int var2 = this.mImage.getHeight(this);
         return var1 >= 0 && var2 >= 0 ? new Dimension(var1, var2) : new Dimension(20, 24);
      }
   }

   public synchronized Dimension preferredSize() {
      return this.minimumSize();
   }

   public void paint(Graphics var1) {
      if (!this.mTracker.checkAll()) {
         var1.drawString("...", 0, 20);
         this.repaint(200L);
      } else {
         var1.drawImage(this.mImage, 0, 0, this);
      }
   }
}

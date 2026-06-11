package OneDOF.Prog8;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Panel;

@SuppressWarnings("serial")
class CPicturePanel extends Panel {
   public Image mImage;
   public CPicturePanel() {
   }

   public CPicturePanel(Image img) {
      this.LoadImage(img);
   }

   public void LoadImage(Image img) {
      // Use ImageIcon to ensure synchronous loading
      if (img != null) {
         ImageIcon icon = new ImageIcon(img);
         this.mImage = icon.getImage();
      } else {
         this.mImage = img;
      }
   }

   public synchronized Dimension minimumSize() {
      if (this.mImage == null) {
         return new Dimension(20, 24);
      } else {
         int width = this.mImage.getWidth(this);
         int height = this.mImage.getHeight(this);
         return width >= 0 && height >= 0 ? new Dimension(width, height) : new Dimension(20, 24);
      }
   }

   public synchronized Dimension preferredSize() {
      return this.minimumSize();
   }

   public void paint(Graphics g) {
      if (this.mImage != null) {
         g.drawImage(this.mImage, 0, 0, this);
      } else {
         g.drawString("...", 0, 20);
      }
   }
}

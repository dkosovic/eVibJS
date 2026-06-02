package MultiDOF.Prog6.Eigen5DOF;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class CPicturePanel extends Panel {
   public Image mImage;

   public CPicturePanel() {
   }

   public CPicturePanel(Image var1) {
      this.LoadImage(var1);
   }

   public void LoadImage(Image var1) {
      // Use ImageIcon to ensure synchronous loading
      if (var1 != null) {
         ImageIcon icon = new ImageIcon(var1);
         this.mImage = icon.getImage();
      } else {
         this.mImage = var1;
      }
   }

   public synchronized Dimension minimumSize() {
      if (this.mImage == null) {
         return new Dimension(20, 24);
      }

      int var1 = this.mImage.getWidth(this);
      int var2 = this.mImage.getHeight(this);
      return var1 >= 0 && var2 >= 0 ? new Dimension(var1, var2) : new Dimension(20, 24);
   }

   public synchronized Dimension preferredSize() {
      return this.minimumSize();
   }

   public void paint(Graphics var1) {
      if (this.mImage != null) {
         var1.drawImage(this.mImage, 0, 0, this);
      } else {
         var1.drawString("...", 0, 20);
      }
   }
}

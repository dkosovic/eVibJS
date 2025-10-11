package OneDOF.ComplexAbutment.Complex;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class CPicturePanel extends JPanel {
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
         int var1 = this.mImage.getWidth(this);
         int var2 = this.mImage.getHeight(this);
         return var1 >= 0 && var2 >= 0 ? new Dimension(var1, var2) : new Dimension(20, 24);
      }
   }

   public synchronized Dimension preferredSize() {
      return this.minimumSize();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (this.mImage != null) {
         g.drawImage(this.mImage, 0, 0, this);
      } else {
         g.drawString("...", 0, 20);
      }
   }
}

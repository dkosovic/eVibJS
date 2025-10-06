package TwoDOF.Prog13.Detuned;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class CFramePicture extends CFrame {
   public Image mImage;
   public boolean mScaleImage;

   public CFramePicture(CFramePanel thePanel, int xx, int yy, int ww, int hh, Image img, boolean scale) {
      super(thePanel, xx, yy, ww, hh);
      this.mScaleImage = scale;
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

   public void Frame(Graphics g) {
      if (this.mImage != null) {
         // Check if image is fully loaded before drawing
         int width = this.mImage.getWidth(super.mFramePanel);
         int height = this.mImage.getHeight(super.mFramePanel);

         // If width/height are -1, image is still loading
         if (width > 0 && height > 0) {
            if (this.mScaleImage) {
               g.drawImage(this.mImage, super.x, super.y, super.width, super.height, super.mFramePanel);
            } else {
               g.drawImage(this.mImage, super.x, super.y, super.mFramePanel);
            }
         }
         // If image is still loading, do nothing - it will repaint when ready
      }
   }
}

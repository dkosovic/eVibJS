package General.Prog1.Tension;

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
      // Use ImageIcon to ensure synchronous loading, with Java2script error handling
      if (img != null) {
         try {
            ImageIcon icon = new ImageIcon(img);
            this.mImage = icon.getImage();
         } catch (Exception e) {
            // Fallback to original image if ImageIcon fails
            this.mImage = img;
         }
      } else {
         this.mImage = null;
      }
   }

   public void Frame(Graphics g) {
      if (this.mScaleImage) {
         g.drawImage(this.mImage, super.x, super.y, super.width, super.height, super.mFramePanel);
      } else {
         g.drawImage(this.mImage, super.x, super.y, super.mFramePanel);
      }
   }
}

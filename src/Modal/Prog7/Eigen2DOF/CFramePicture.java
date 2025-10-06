package Modal.Prog7.Eigen2DOF;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class CFramePicture extends CFrame {
   public Image mImage;
   public boolean mScaleImage;

   public CFramePicture(CFramePanel var1, int var2, int var3, int var4, int var5, Image var6, boolean var7) {
      super(var1, var2, var3, var4, var5);
      this.mScaleImage = var7;
      this.LoadImage(var6);
   }

   public void LoadImage(Image var1) {
      // Use ImageIcon to ensure synchronous loading, with Java2script error handling
      if (var1 != null) {
         try {
            ImageIcon icon = new ImageIcon(var1);
            this.mImage = icon.getImage();
         } catch (Exception e) {
            // Fallback to original image if ImageIcon fails
            this.mImage = var1;
         }
      } else {
         this.mImage = null;
      }
   }

   public void Frame(Graphics var1) {
      if (this.mImage != null) {
         // Check if image is fully loaded before drawing
         int width = this.mImage.getWidth(super.mFramePanel);
         int height = this.mImage.getHeight(super.mFramePanel);

         // If width/height are -1, image is still loading
         if (width > 0 && height > 0) {
            if (this.mScaleImage) {
               var1.drawImage(this.mImage, super.x, super.y, super.width, super.height, super.mFramePanel);
            } else {
               var1.drawImage(this.mImage, super.x, super.y, super.mFramePanel);
            }
         }
         // If image is still loading, do nothing - it will repaint when ready
      }
   }
}

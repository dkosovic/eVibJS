import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

class CFramePicture extends CFrame {
   public Image mImage;
   MediaTracker mTracker;
   public boolean mScaleImage;

   public CFramePicture(CFramePanel var1, int var2, int var3, int var4, int var5, Image var6, boolean var7) {
      super(var1, var2, var3, var4, var5);
      this.mScaleImage = var7;
      this.LoadImage(var6);
   }

   public void LoadImage(Image var1) {
      this.mImage = var1;
      this.mTracker = new MediaTracker(super.mFramePanel);
      this.mTracker.addImage(this.mImage, 0);

      try {
         this.mTracker.waitForAll();
      } catch (InterruptedException var2) {
      }
   }

   public void Frame(Graphics var1) {
      if (this.mScaleImage) {
         var1.drawImage(this.mImage, super.x, super.y, super.width, super.height, super.mFramePanel);
      } else {
         var1.drawImage(this.mImage, super.x, super.y, super.mFramePanel);
      }
   }
}

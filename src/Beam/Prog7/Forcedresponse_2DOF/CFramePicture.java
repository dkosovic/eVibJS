package Beam.Prog7.Forcedresponse_2DOF;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

class CFramePicture extends CFrame {
   public Image mImage;
   MediaTracker mTracker;
   public boolean mScaleImage;

   public CFramePicture(CFramePanel thePanel, int xx, int yy, int ww, int hh, Image img, boolean scale) {
      super(thePanel, xx, yy, ww, hh);
      this.mScaleImage = scale;
      this.LoadImage(img);
   }

   public void LoadImage(Image img) {
      this.mImage = img;
      this.mTracker = new MediaTracker(super.mFramePanel);
      this.mTracker.addImage(this.mImage, 0);

      try {
         this.mTracker.waitForAll();
      } catch (InterruptedException var2) {
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

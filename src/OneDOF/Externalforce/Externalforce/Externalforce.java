package OneDOF.Externalforce.Externalforce;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.util.Date;

public class Externalforce extends Applet implements Runnable {
   static final String kRunString = "Run";
   CAnimationPanel mAnimPanel;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      this.mAnimPanel = new CAnimationPanel();
      this.add("Center", this.mAnimPanel);
      this.validate();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public void run() {
      Date ddd = new Date();
      long thisTime = ddd.getTime();

      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var8) {
            return;
         }

         ddd = new Date();
         long lastTime = thisTime;
         thisTime = ddd.getTime();
         double realSeconds = (thisTime - lastTime) / 1000.0;
         this.mAnimPanel.SetRealParameter(0, realSeconds);
      }
   }
}

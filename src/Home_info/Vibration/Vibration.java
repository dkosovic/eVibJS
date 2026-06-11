package Home_info.Vibration;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Vibration extends Applet implements ActionListener {
   static final String kRunString = "Run";
   CAnimationPanel mAnimPanel;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      this.mAnimPanel = new CAnimationPanel();
      this.add("Center", this.mAnimPanel);
      this.validate();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public void actionPerformed(ActionEvent e) {
      Date ddd = new Date();
      long thisTime = ddd.getTime();
      if (this.mLastTime == 0) {
         this.mLastTime = thisTime;
         return;
      }

      double realSeconds = (thisTime - this.mLastTime) / 1000.0;
      this.mLastTime = thisTime;
      this.mAnimPanel.SetRealParameter(0, realSeconds);
   }

   public void stop() {
      if (this.mTimer != null) {
         this.mTimer.stop();
         this.mTimer = null;
      }
   }
}

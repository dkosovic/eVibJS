package Continuous.Prog10.Vibration;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Label;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Vibration extends Applet implements ActionListener {
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CAnimationPanel mAnimPanel;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      this.mAnimPanel = new CAnimationPanel();
      this.add("Center", this.mAnimPanel);
      Label copyright = new Label("You need permission to use this program. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.validate();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mTimer != null) {
         Date ddd = new Date();
         long thisTime = ddd.getTime();

         if (this.mLastTime == 0) {
            this.mLastTime = thisTime;
         }
         double realSeconds = (thisTime - this.mLastTime) / 1000.0;
         this.mLastTime = thisTime;

         this.mAnimPanel.SetRealParameter(0, realSeconds);
      }
   }

}
package OneDOF.Forced.Forced;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Forced extends Applet implements ActionListener {
   static final double kMinWn = 0.1;
   static final double kMaxWn = 2.0;
   static final double kMinXi = 0.001;
   static final double kMaxXi = 2.0;
   static final double kMinFdivmWn2 = -17.0;
   static final double kMaxFdivmWn2 = 17.0;
   static final double kMinPulsewidth = 0.001;
   static final double kMaxPulsewidth = 10.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl WnControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 1.5, 2.0, "Hz");
      WnControl.SetLabelOffset(20, 10);
      WnControl.SetTextEditable(true);
      Image wnImage = this.getImage(this.getCodeBase(), "wn.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, wnImage, false);
      CFrameSmallControl XiControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 0.001, 0.05, 2.0, " ");
      XiControl.SetLabelOffset(20, 10);
      XiControl.SetTextEditable(true);
      Image XiImage = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, XiImage, false);
      CFrameSmallControl FdivmWn2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, -17.0, 7.0, 17.0, "mm");
      FdivmWn2Control.SetLabelOffset(20, 10);
      FdivmWn2Control.SetTextEditable(true);
      Image FdivmWn2Image = this.getImage(this.getCodeBase(), "FdivmWn2.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, FdivmWn2Image, false);
      CFrameSmallControl PulsewidthControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, 0.001, 2.0, 10.0, "secs");
      PulsewidthControl.SetLabelOffset(20, 10);
      PulsewidthControl.SetTextEditable(true);
      Image PulsewidthImage = this.getImage(this.getCodeBase(), "Pulsewidth.gif");
      new CFramePicture(this.mFramePanel, 304, 25, 0, 0, PulsewidthImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system.");
      new CFrameHelp(this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system.");
      new CFrameHelp(this.mFramePanel, 180, 0, 80, 80, "This is the magnitude of \nthe pulse (N) divided by\nthe mass (kg)\ntimes nat freq. squared.");
      new CFrameHelp(this.mFramePanel, 270, 0, 80, 80, "This is duration of the pulse");
      this.mAnimFrame.mStartButton = new Button("Start");
      buttonPanel.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new Button("Pause");
      buttonPanel.add(this.mAnimFrame.mPauseButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      buttonPanel.add(this.mAnimFrame.mStopButton);
      this.validate();
      this.mAnimFrame.UpdateButtonAppearance();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public boolean action(Event evt, Object arg) {
      if (evt.target instanceof Button) {
         if (arg.equals("Start") || arg.equals("Cont.")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
         } else if (arg.equals("Pause")) {
            this.mAnimFrame.ControlMessage(1, 2.0);
         } else if (arg.equals("Stop")) {
            this.mAnimFrame.ControlMessage(1, 0.0);
         }
      }

      return true;
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
         
         this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }

   public void stop() {
      if (this.mTimer != null) { this.mTimer.stop(); this.mTimer = null; }
   }
}

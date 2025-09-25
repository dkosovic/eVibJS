package OneDOF.Prog9.OOB;

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
public class OOB extends Applet implements ActionListener {
   static final double kMinWn = 0.1;
   static final double kMaxWn = 1.5;
   static final double kMinXi = 0.001;
   static final double kMaxXi = 2.0;
   static final double kMinmrdivM = 0.01;
   static final double kMaxmrdivM = 17.0;
   static final double kMinWin = 0.1;
   static final double kMaxWin = 2.0;
   static final double kMinAlpha = 0.1;
   static final double kMaxAlpha = 20.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl WnControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.7, 1.5, "Hz");
      WnControl.SetLabelOffset(20, 10);
      WnControl.SetTextEditable(true);
      Image wnImage = this.getImage(this.getCodeBase(), "wn.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, wnImage, false);
      CFrameSmallControl XiControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 0.001, 0.05, 2.0, " ");
      XiControl.SetLabelOffset(20, 10);
      XiControl.SetTextEditable(true);
      Image XiImage = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, XiImage, false);
      CFrameSmallControl mrdivMControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, 0.01, 5.0, 17.0, "mm");
      mrdivMControl.SetLabelOffset(20, 10);
      mrdivMControl.SetTextEditable(true);
      Image mrdivMImage = this.getImage(this.getCodeBase(), "mrdivM.gif");
      new CFramePicture(this.mFramePanel, 208, 25, 0, 0, mrdivMImage, false);
      CFrameSmallControl WinControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 285, 10, 0.1, 1.0, 2.0, "Hz");
      WinControl.SetLabelOffset(20, 10);
      WinControl.SetTextEditable(true);
      Image WinImage = this.getImage(this.getCodeBase(), "Win.gif");
      new CFramePicture(this.mFramePanel, 304, 27, 0, 0, WinImage, false);
      CFrameSmallControl AlphaControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 375, 10, 0.1, 10.0, 20.0, "rad/s^2");
      AlphaControl.SetLabelOffset(20, 10);
      AlphaControl.SetTextEditable(true);
      Image AlphaImage = this.getImage(this.getCodeBase(), "Alpha.gif");
      new CFramePicture(this.mFramePanel, 394, 27, 0, 0, AlphaImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system.");
      new CFrameHelp(this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system.");
      new CFrameHelp(this.mFramePanel, 180, 0, 80, 80, "This is the ratio of the o-o-b\n mass divided by the total \nmass times the o-o-b radius.");
      new CFrameHelp(this.mFramePanel, 270, 0, 80, 80, "This is the steady\nangular velocity.");
      new CFrameHelp(this.mFramePanel, 360, 0, 80, 80, "This is the angular acceleration.");
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

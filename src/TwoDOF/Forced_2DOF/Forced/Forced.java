package TwoDOF.Forced_2DOF.Forced;

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
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 40.0;
   static final double kMinc1 = 0.0;
   static final double kMaxc1 = 1.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 2.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 40.0;
   static final double kMinc2 = 0.0;
   static final double kMaxc2 = 1.0;
   static final double kMinP1 = -0.5;
   static final double kMaxP1 = 0.5;
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
      Label copyright = new Label("This program is copyright, you need permission to use it. © 2000 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl m1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.1, 2.0, "kg");
      m1Control.SetLabelOffset(20, 10);
      m1Control.SetTextEditable(true);
      Image m1Image = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, m1Image, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 80, 10, 1.0, 20.0, 40.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl c1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 150, 10, 0.0, 0.5, 1.0, "Ns/m");
      c1Control.SetLabelOffset(20, 10);
      c1Control.SetTextEditable(true);
      Image c1Image = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 175, 26, 0, 0, c1Image, false);
      CFrameSmallControl m2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 250, 10, 0.1, 0.1, 2.0, "kg");
      m2Control.SetLabelOffset(20, 10);
      m2Control.SetTextEditable(true);
      Image m2Image = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 285, 26, 0, 0, m2Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 320, 10, 1.0, 20.0, 40.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 345, 26, 0, 0, k2Image, false);
      CFrameSmallControl c2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 390, 10, 0.0, 0.01, 1.0, "Ns/m");
      c2Control.SetLabelOffset(20, 10);
      c2Control.SetTextEditable(true);
      Image c2Image = this.getImage(this.getCodeBase(), "c2.gif");
      new CFramePicture(this.mFramePanel, 415, 26, 0, 0, c2Image, false);
      CFrameSmallControl P1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 10, 60, -0.5, 0.1, 0.5, "N");
      P1Control.SetLabelOffset(20, 10);
      P1Control.SetTextEditable(true);
      Image P1Image = this.getImage(this.getCodeBase(), "P1.gif");
      new CFramePicture(this.mFramePanel, 35, 76, 0, 0, P1Image, false);
      CFrameSmallControl PulsewidthControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 9, 10, 110, 0.001, 2.0, 10.0, "sec");
      PulsewidthControl.SetLabelOffset(20, 10);
      PulsewidthControl.SetTextEditable(true);
      Image PulsewidthImage = this.getImage(this.getCodeBase(), "Pulsewidth.gif");
      new CFramePicture(this.mFramePanel, 35, 126, 0, 0, PulsewidthImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 60, 50, "This is the top mass.");
      new CFrameHelp(this.mFramePanel, 70, 0, 60, 50, "This is the top stiffness.");
      new CFrameHelp(this.mFramePanel, 140, 0, 60, 50, "This is the top damper.");
      new CFrameHelp(this.mFramePanel, 240, 0, 60, 50, "This is the bottom mass.");
      new CFrameHelp(this.mFramePanel, 310, 0, 60, 50, "This is the bottom stiffness.");
      new CFrameHelp(this.mFramePanel, 380, 0, 60, 50, "This is the bottom damper.");
      new CFrameHelp(this.mFramePanel, 0, 55, 60, 50, "This is the force step\non the top mass.");
      new CFrameHelp(this.mFramePanel, 0, 105, 60, 50, "This is the time duration \nof the step.");
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

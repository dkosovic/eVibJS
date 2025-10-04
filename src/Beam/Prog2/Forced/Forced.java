package Beam.Prog2.Forced;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Forced extends Applet implements ActionListener {
   static final double kMinm = 1.0;
   static final double kMaxm = 10.0;
   static final double kMink1 = 10.0;
   static final double kMaxk1 = 100.0;
   static final double kMink2 = 10.0;
   static final double kMaxk2 = 100.0;
   static final double kMinA1 = -45.0;
   static final double kMaxA1 = 45.0;
   static final double kMinA2 = -45.0;
   static final double kMaxA2 = 45.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("This program is copyright, you need permission to use it. © 2003 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 1.0, 2.0, 10.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, mImage, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 80, 10, 10.0, 20.0, 100.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 160, 10, 10.0, 20.0, 100.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 185, 26, 0, 0, k2Image, false);
      CFrameSmallControl A1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 230, 10, -45.0, 45.0, 45.0, "");
      A1Control.SetLabelOffset(20, 10);
      A1Control.SetTextEditable(true);
      Image A1Image = this.getImage(this.getCodeBase(), "A1.gif");
      new CFramePicture(this.mFramePanel, 255, 26, 0, 0, A1Image, false);
      CFrameSmallControl A2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 300, 10, -45.0, 0.0, 45.0, "");
      A2Control.SetLabelOffset(20, 10);
      A2Control.SetTextEditable(true);
      Image A2Image = this.getImage(this.getCodeBase(), "A2.gif");
      new CFramePicture(this.mFramePanel, 325, 26, 0, 0, A2Image, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 60, 50, "This is the mass.");
      new CFrameHelp(this.mFramePanel, 70, 0, 60, 50, "This is the left stiffness.");
      new CFrameHelp(this.mFramePanel, 150, 0, 60, 50, "This is the right stiffness.");
      new CFrameHelp(this.mFramePanel, 220, 0, 60, 50, "This is the LHS initial displacement.");
      new CFrameHelp(this.mFramePanel, 290, 0, 60, 50, "This is the RHS initial displacement.");
      this.mAnimFrame.mStartButton = new Button("Start");
      this.mAnimFrame.mStartButton.addActionListener(this);
      buttonPanel.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new Button("Pause");
      this.mAnimFrame.mPauseButton.addActionListener(this);
      buttonPanel.add(this.mAnimFrame.mPauseButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      this.mAnimFrame.mStopButton.addActionListener(this);
      buttonPanel.add(this.mAnimFrame.mStopButton);
      this.validate();
      this.mAnimFrame.UpdateButtonAppearance();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public void actionPerformed(ActionEvent e) {
      // Handle button clicks
      if (e.getSource() instanceof Button) {
         Button source = (Button) e.getSource();
         String label = source.getLabel();
         if (label.equals("Start") || label.equals("Cont.")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
         } else if (label.equals("Pause")) {
            this.mAnimFrame.ControlMessage(1, 2.0);
         } else if (label.equals("Stop")) {
            this.mAnimFrame.ControlMessage(1, 0.0);
         }
         return;
      }

      // Handle timer events
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

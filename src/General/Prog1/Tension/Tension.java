package General.Prog1.Tension;

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

public class Tension extends Applet implements ActionListener {
   static final double kMinMass = 0.5;
   static final double kMaxMass = 50.0;
   static final double kMinK = 10.0;
   static final double kMaxK = 500.0;
   static final double kMinDelta = -20.0;
   static final double kMaxDelta = 100.0;
   static final double kMinXo = -80.0;
   static final double kMaxXo = 80.0;
   static final double kMinYo = -80.0;
   static final double kMaxYo = 80.0;
   static final double kMinOnOff = 0.0;
   static final double kMaxOnOff = 1.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label(" This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl MassControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.5, 1.0, 50.0, "kg");
      MassControl.SetLabelOffset(20, 10);
      MassControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "Mass.gif");
      new CFramePicture(this.mFramePanel, 35, 28, 0, 0, mImage, false);
      CFrameSmallControl KControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 10.0, 10.0, 500.0, "N/m");
      KControl.SetLabelOffset(20, 10);
      KControl.SetTextEditable(true);
      Image KIamage = this.getImage(this.getCodeBase(), "K.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, KIamage, false);
      CFrameSmallControl DeltaControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, -20.0, -10.0, 100.0, "%");
      DeltaControl.SetLabelOffset(20, 10);
      DeltaControl.SetTextEditable(true);
      Image DeltaImage = this.getImage(this.getCodeBase(), "Delta.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, DeltaImage, false);
      CFrameSmallControl XoControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, -80.0, 6.0, 80.0, "");
      XoControl.SetLabelOffset(20, 10);
      XoControl.SetTextEditable(true);
      Image XoImage = this.getImage(this.getCodeBase(), "Xo.gif");
      new CFramePicture(this.mFramePanel, 304, 25, 0, 0, XoImage, false);
      CFrameSmallControl YoControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 370, 10, -80.0, 10.0, 80.0, "");
      YoControl.SetLabelOffset(20, 10);
      YoControl.SetTextEditable(true);
      Image YoImage = this.getImage(this.getCodeBase(), "Yo.gif");
      new CFramePicture(this.mFramePanel, 394, 25, 0, 0, YoImage, false);
      CFrameSmallControl OnOffControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 460, 10, 0.0, 0.0, 1.0, "Trace");
      OnOffControl.SetLabelOffset(20, 10);
      OnOffControl.SetTextEditable(true);
      OnOffControl.SetIntegerMode(true);
      Image OnOffImage = this.getImage(this.getCodeBase(), "OnOff.gif");
      new CFramePicture(this.mFramePanel, 484, 25, 0, 0, OnOffImage, false);
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
      this.mTimer = new Timer(10, this);
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

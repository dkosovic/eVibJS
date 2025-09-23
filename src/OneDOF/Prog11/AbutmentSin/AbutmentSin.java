package OneDOF.Prog11.AbutmentSin;

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

public class AbutmentSin extends Applet implements ActionListener {
   static final double kMinWn = 0.1;
   static final double kMaxWn = 1.5;
   static final double kMinXi = 0.001;
   static final double kMaxXi = 2.0;
   static final double kMinXin = 0.01;
   static final double kMaxXin = 10.0;
   static final double kMinWin = 0.1;
   static final double kMaxWin = 2.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.7, 1.5, "Hz");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "wn.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 0.001, 0.05, 2.0, " ");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, 0.01, 7.0, 10.0, "mm");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "Xin.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, 0.1, 1.0, 2.0, "Hz");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "Win.gif");
      new CFramePicture(this.mFramePanel, 304, 27, 0, 0, var14, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system.");
      new CFrameHelp(this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system.");
      new CFrameHelp(this.mFramePanel, 180, 0, 80, 80, "This is the magnitude of \nthe input");
      new CFrameHelp(this.mFramePanel, 270, 0, 80, 80, "This is the excitation frequency.");
      this.mAnimFrame.mStartButton = new Button("Start");
      var1.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new Button("Pause");
      var1.add(this.mAnimFrame.mPauseButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      var1.add(this.mAnimFrame.mStopButton);
      this.validate();
      this.mAnimFrame.UpdateButtonAppearance();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public boolean action(Event var1, Object var2) {
      if (var1.target instanceof Button) {
         if (var2.equals("Start") || var2.equals("Cont.")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
         } else if (var2.equals("Pause")) {
            this.mAnimFrame.ControlMessage(1, 2.0);
         } else if (var2.equals("Stop")) {
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

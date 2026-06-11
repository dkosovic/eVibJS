package MultiDOF.Prog1;

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
public class Modes extends Applet implements ActionListener {
   static final double kMinm = 0.2;
   static final double kMaxm = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 20.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 20.0;
   static final double kMinb = 0.0;
   static final double kMaxb = 1.0;
   static final double kMinc = 0.0;
   static final double kMaxc = 1.0;
   static final double kMind = 0.0;
   static final double kMaxd = 1.0;
   static final double kMinm3 = 0.1;
   static final double kMaxm3 = 1.0;
   static final double kMink3 = 0.5;
   static final double kMaxk3 = 40.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label(" This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 185, 10, 0.2, 1.0, 2.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 210, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 265, 10, 1.0, 10.0, 20.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 290, 26, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 345, 10, 1.0, 10.0, 20.0, "N/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 370, 26, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 425, 10, 0.0, 0.8, 1.0, " ");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "Dpos.gif");
      new CFramePicture(this.mFramePanel, 446, 25, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 505, 10, 0.1, 0.5, 1.0, "kg");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "m3.gif");
      new CFramePicture(this.mFramePanel, 525, 26, 0, 0, var17, false);
      CFrameSmallControl var19 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 585, 10, 0.5, 10.0, 40.0, "N/m");
      var19.SetLabelOffset(20, 10);
      var19.SetTextEditable(true);
      Image var20 = this.getImage(this.getCodeBase(), "k3.gif");
      new CFramePicture(this.mFramePanel, 605, 24, 0, 0, var20, false);
      this.mAnimFrame.mStartButton = new Button("Start");
      this.mAnimFrame.mStartButton.addActionListener(this);
      var1.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      this.mAnimFrame.mStopButton.addActionListener(this);
      var1.add(this.mAnimFrame.mStopButton);
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
         Button source = (Button)e.getSource();
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
      Date now = new Date();
      long currentTime = now.getTime();
      if (this.mLastTime == 0) {
         this.mLastTime = currentTime;
         return;
      }

      double elapsedSeconds = (currentTime - this.mLastTime) / 1000.0;
      this.mLastTime = currentTime;
      this.mAnimFrame.ControlMessage(0, elapsedSeconds);
   }

   public void stop() {
      if (this.mTimer != null) {
         this.mTimer.stop();
         this.mTimer = null;
      }
   }
}

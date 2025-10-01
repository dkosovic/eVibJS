package OneDOF.Abutment.Abutment;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Abutment extends JApplet implements ActionListener {
   static final double kMinWn = 0.1;
   static final double kMaxWn = 2.0;
   static final double kMinXi = 0.001;
   static final double kMaxXi = 2.0;
   static final double kMinXin = -17.0;
   static final double kMaxXin = 17.0;
   static final double kMinPulsewidth = 0.001;
   static final double kMaxPulsewidth = 10.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      JPanel buttonPanel = new JPanel();
      this.add("North", buttonPanel);
      JLabel copyright = new JLabel("This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
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
      CFrameSmallControl XinControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, -17.0, 7.0, 17.0, "mm");
      XinControl.SetLabelOffset(20, 10);
      XinControl.SetTextEditable(true);
      Image XinImage = this.getImage(this.getCodeBase(), "Xin.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, XinImage, false);
      CFrameSmallControl PulsewidthControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, 0.001, 2.0, 10.0, "secs");
      PulsewidthControl.SetLabelOffset(20, 10);
      PulsewidthControl.SetTextEditable(true);
      Image PulsewidthImage = this.getImage(this.getCodeBase(), "Pulsewidth.gif");
      new CFramePicture(this.mFramePanel, 304, 25, 0, 0, PulsewidthImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system.");
      new CFrameHelp(this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system.");
      new CFrameHelp(this.mFramePanel, 180, 0, 80, 80, "This is the magnitude of \nthe input step.");
      new CFrameHelp(this.mFramePanel, 270, 0, 80, 80, "This is duration of the pulse");
      this.mAnimFrame.mStartButton = new JButton("Start");
      this.mAnimFrame.mStartButton.addActionListener(this);
      buttonPanel.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new JButton("Pause");
      this.mAnimFrame.mPauseButton.addActionListener(this);
      buttonPanel.add(this.mAnimFrame.mPauseButton);
      this.mAnimFrame.mStopButton = new JButton("Stop");
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
      if (e.getSource() instanceof JButton) {
         JButton source = (JButton) e.getSource();
         String label = source.getText();
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

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;

public class Damped extends Applet implements Runnable {
   static final double kMinWn = 0.1;
   static final double kMaxWn = 2.0;
   static final double kMinXi = 0.001;
   static final double kMaxXi = 2.0;
   static final double kMinXo = -16.0;
   static final double kMaxXo = 16.0;
   static final double kMinVo = -100.0;
   static final double kMaxVo = 100.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Character copyrightSym = new Character('©');
      Label copyright = new Label("This program is copyright, you need permission to use it. " + copyrightSym + " 1998 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl WnControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.4, 2.0, "Hz");
      WnControl.SetLabelOffset(20, 10);
      WnControl.SetTextEditable(true);
      Image wnImage = this.getImage(this.getCodeBase(), "wn.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, wnImage, false);
      CFrameSmallControl XiControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 0.001, 2.0, 2.0, " ");
      XiControl.SetLabelOffset(20, 10);
      XiControl.SetTextEditable(true);
      Image XiImage = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, XiImage, false);
      CFrameSmallControl XoControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, -16.0, 16.0, 16.0, "mm");
      XoControl.SetLabelOffset(20, 10);
      XoControl.SetTextEditable(true);
      Image XoImage = this.getImage(this.getCodeBase(), "xo.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, XoImage, false);
      CFrameSmallControl VoControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, -100.0, 0.0, 100.0, "mm/s");
      VoControl.SetLabelOffset(20, 10);
      VoControl.SetTextEditable(true);
      Image VoImage = this.getImage(this.getCodeBase(), "vo.gif");
      new CFramePicture(this.mFramePanel, 304, 25, 0, 0, VoImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system.");
      new CFrameHelp(this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system.");
      new CFrameHelp(this.mFramePanel, 180, 0, 80, 80, "This is the initial\ndisplacement of the mass.");
      new CFrameHelp(this.mFramePanel, 270, 0, 80, 80, "This is the initial\nvelocity of the mass.");
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
      this.mThread = new Thread(this);
      this.mThread.start();
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

   public void run() {
      Date ddd = new Date();
      long thisTime = ddd.getTime();

      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var8) {
            return;
         }

         ddd = new Date();
         long lastTime = thisTime;
         thisTime = ddd.getTime();
         double realSeconds = (thisTime - lastTime) / 1000.0;
         this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

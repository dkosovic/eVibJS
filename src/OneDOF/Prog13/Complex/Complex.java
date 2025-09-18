import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;

public class Complex extends Applet implements Runnable {
   static final double kMinW = 0.2;
   static final double kMaxW = 2.0;
   static final double kMinF = 20.0;
   static final double kMaxF = 100.0;
   static final double kMinX = 20.0;
   static final double kMaxX = 100.0;
   static final double kMinPhi = -180.0;
   static final double kMaxPhi = 180.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Character copyrightSym = new Character('©');
      Label copyright = new Label("  This program is copyright, you need permission to use it. " + copyrightSym + " 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl WControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.2, 0.5, 2.0, "Hz");
      WControl.SetLabelOffset(20, 10);
      WControl.SetTextEditable(true);
      Image wnImage = this.getImage(this.getCodeBase(), "W.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, wnImage, false);
      CFrameSmallControl FControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 100, 10, 20.0, 85.0, 100.0, "N ");
      FControl.SetLabelOffset(20, 10);
      FControl.SetTextEditable(true);
      Image FImage = this.getImage(this.getCodeBase(), "F.gif");
      new CFramePicture(this.mFramePanel, 125, 26, 0, 0, FImage, false);
      CFrameSmallControl XControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 190, 10, 20.0, 40.0, 100.0, "mm");
      XControl.SetLabelOffset(20, 10);
      XControl.SetTextEditable(true);
      Image XImage = this.getImage(this.getCodeBase(), "X.gif");
      new CFramePicture(this.mFramePanel, 214, 25, 0, 0, XImage, false);
      CFrameSmallControl PhiControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 280, 10, -180.0, -60.0, 180.0, "degrees");
      PhiControl.SetLabelOffset(20, 10);
      PhiControl.SetTextEditable(true);
      Image PhiImage = this.getImage(this.getCodeBase(), "Phi.gif");
      new CFramePicture(this.mFramePanel, 304, 25, 0, 0, PhiImage, false);
      this.mAnimFrame.mStartButton = new Button("Start");
      buttonPanel.add(this.mAnimFrame.mStartButton);
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
         if (arg.equals("Start")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
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

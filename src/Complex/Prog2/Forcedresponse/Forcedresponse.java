package Complex.Prog2.Forcedresponse;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Forcedresponse extends Applet implements Runnable {
   static final double kMinL = 0.5;
   static final double kMaxL = 2.0;
   static final double kMinD = 0.05;
   static final double kMaxD = 0.2;
   static final double kMinm = 5.0;
   static final double kMaxm = 100.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl LControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 480, 310, 0.5, 1.0, 2.0, "m");
      LControl.SetLabelOffset(20, 10);
      LControl.SetTextEditable(true);
      Image LImage = this.getImage(this.getCodeBase(), "L.gif");
      new CFramePicture(this.mFramePanel, 500, 325, 0, 0, LImage, false);
      CFrameSmallControl DControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 570, 310, 0.05, 0.1, 0.2, "m");
      DControl.SetLabelOffset(20, 10);
      DControl.SetTextEditable(true);
      Image DImage = this.getImage(this.getCodeBase(), "D.gif");
      new CFramePicture(this.mFramePanel, 590, 325, 0, 0, DImage, false);
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 660, 310, 5.0, 20.0, 100.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 680, 325, 0, 0, mImage, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 30, 0, 0, DiagramImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 85, 315, 0, 0, XaxisImage, false);
      Image YaxisImage = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 1, 3, 0, 0, YaxisImage, false);
      this.validate();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public void run() {
      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var1) {
            return;
         }
      }
   }
}

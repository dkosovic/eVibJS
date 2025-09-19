package Beam.Prog5.Forcedresponse_2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Forcedresponse_2DOF extends Applet implements Runnable {
   static final double kMinm = 0.1;
   static final double kMaxm = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 40.0;
   static final double kMinc1 = 0.01;
   static final double kMaxc1 = 1.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 40.0;
   static final double kMinc2 = 0.01;
   static final double kMaxc2 = 1.0;
   static final double kMinb = 0.0;
   static final double kMaxb = 1.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Character copyrightSym = new Character('©');
      Label copyright = new Label("  This program is copyright, you need permission to use it. " + copyrightSym + " 2003 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 1.0, 2.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, mImage, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 20.0, 40.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 160, 10, 1.0, 20.0, 40.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 185, 26, 0, 0, k2Image, false);
      CFrameSmallControl bControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 240, 10, 0.0, 0.3, 1.0, " ");
      bControl.SetLabelOffset(20, 10);
      bControl.SetTextEditable(true);
      Image bImage = this.getImage(this.getCodeBase(), "b.gif");
      new CFramePicture(this.mFramePanel, 265, 24, 0, 0, bImage, false);
      Image diagramImage = this.getImage(this.getCodeBase(), "diagram.gif");
      new CFramePicture(this.mFramePanel, 430, 50, 0, 0, diagramImage, false);
      Image responseImage = this.getImage(this.getCodeBase(), "response.gif");
      new CFramePicture(this.mFramePanel, 27, 44, 0, 0, responseImage, false);
      Image WlabelImage = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 76, 346, 0, 0, WlabelImage, false);
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

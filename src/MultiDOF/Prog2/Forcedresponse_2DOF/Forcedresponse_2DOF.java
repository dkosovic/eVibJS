package MultiDOF.Prog2.Forcedresponse_2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Forcedresponse_2DOF extends Applet implements Runnable {
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
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.2, 1.0, 2.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, mImage, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 10.0, 20.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 155, 10, 1.0, 10.0, 20.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 180, 26, 0, 0, k2Image, false);
      CFrameSmallControl bControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 230, 10, 0.0, 0.3, 1.0, "L");
      bControl.SetLabelOffset(20, 10);
      bControl.SetTextEditable(true);
      Image bImage = this.getImage(this.getCodeBase(), "Fpos.gif");
      new CFramePicture(this.mFramePanel, 250, 24, 0, 0, bImage, false);
      CFrameSmallControl cControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 295, 10, 0.0, 0.6, 1.0, "L");
      cControl.SetLabelOffset(20, 10);
      cControl.SetTextEditable(true);
      Image cImage = this.getImage(this.getCodeBase(), "Xpos.gif");
      new CFramePicture(this.mFramePanel, 316, 24, 0, 0, cImage, false);
      CFrameSmallControl dControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 360, 10, 0.0, 0.8, 1.0, "L");
      dControl.SetLabelOffset(20, 10);
      dControl.SetTextEditable(true);
      Image dImage = this.getImage(this.getCodeBase(), "Dpos.gif");
      new CFramePicture(this.mFramePanel, 380, 25, 0, 0, dImage, false);
      CFrameSmallControl m3Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 425, 10, 0.1, 0.5, 1.0, "kg");
      m3Control.SetLabelOffset(20, 10);
      m3Control.SetTextEditable(true);
      Image m3Image = this.getImage(this.getCodeBase(), "m3.gif");
      new CFramePicture(this.mFramePanel, 450, 26, 0, 0, m3Image, false);
      CFrameSmallControl k3Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 505, 10, 0.5, 10.0, 40.0, "N/m");
      k3Control.SetLabelOffset(20, 10);
      k3Control.SetTextEditable(true);
      Image k3Image = this.getImage(this.getCodeBase(), "k3.gif");
      new CFramePicture(this.mFramePanel, 530, 24, 0, 0, k3Image, false);
      Image diagramImage = this.getImage(this.getCodeBase(), "diagram.gif");
      new CFramePicture(this.mFramePanel, 330, 80, 0, 0, diagramImage, false);
      Image responseImage = this.getImage(this.getCodeBase(), "response.gif");
      new CFramePicture(this.mFramePanel, 7, 44, 0, 0, responseImage, false);
      Image WlabelImage = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 56, 346, 0, 0, WlabelImage, false);
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

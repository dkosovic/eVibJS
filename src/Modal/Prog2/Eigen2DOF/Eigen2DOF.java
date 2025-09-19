package Modal.Prog2.Eigen2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Eigen2DOF extends Applet implements Runnable {
   static final double kMink1 = 0.2;
   static final double kMaxk1 = 10.0;
   static final double kMinm1 = 0.5;
   static final double kMaxm1 = 10.0;
   static final double kMinm2 = 0.5;
   static final double kMaxm2 = 10.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 70, 20, 0.5, 1.0, 10.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 95, 36, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 140, 20, 0.5, 1.0, 10.0, "kg");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 165, 36, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 210, 20, 0.2, 1.0, 10.0, "N/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 235, 36, 0, 0, var11, false);
      Image var13 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 290, 0, 0, 0, var13, false);
      Image var15 = this.getImage(this.getCodeBase(), "response.gif");
      new CFramePicture(this.mFramePanel, 14, 65, 0, 0, var15, false);
      Image var17 = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 133, 365, 0, 0, var17, false);
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

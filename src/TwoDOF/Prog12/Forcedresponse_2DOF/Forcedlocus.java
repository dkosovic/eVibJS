package TwoDOF.Prog12.Forcedresponse_2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Forcedlocus extends Applet implements Runnable {
   static final double kMinXi2 = 0.04;
   static final double kMaxXi2 = 3.0;
   static final double kMinm2m1 = 0.01;
   static final double kMaxm2m1 = 0.5;
   static final double kMink2k1 = 0.01;
   static final double kMaxk2k1 = 0.5;
   static final double kMinW = 5.0;
   static final double kMaxW = 150.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 35, 10, 0.04, 0.25, 3.0, " ");
      var4.SetLabelOffset(20, 10);
      Image var5 = this.getImage(this.getCodeBase(), "Xi2.gif");
      new CFramePicture(this.mFramePanel, 55, 25, 0, 0, var5, false);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 125, 10, 0.01, 0.2, 0.5, " ");
      var6.SetLabelOffset(20, 10);
      Image var7 = this.getImage(this.getCodeBase(), "m2m1.gif");
      new CFramePicture(this.mFramePanel, 145, 25, 0, 0, var7, false);
      CFrameSmallControl var8 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 215, 10, 0.01, 0.13, 0.5, " ");
      var8.SetLabelOffset(20, 10);
      Image var9 = this.getImage(this.getCodeBase(), "k2k1.gif");
      new CFramePicture(this.mFramePanel, 235, 25, 0, 0, var9, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 305, 10, 5.0, 100.0, 150.0, "rad/s");
      var10.SetLabelOffset(20, 10);
      Image var11 = this.getImage(this.getCodeBase(), "WdivWn.gif");
      new CFramePicture(this.mFramePanel, 325, 25, 0, 0, var11, false);
      Image var12 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 37, 220, 0, 0, var12, false);
      Image var13 = this.getImage(this.getCodeBase(), "Yaxes.gif");
      new CFramePicture(this.mFramePanel, 2, 45, 0, 0, var13, false);
      Image var14 = this.getImage(this.getCodeBase(), "kXdivF.gif");
      new CFramePicture(this.mFramePanel, 45, 65, 0, 0, var14, false);
      Image var15 = this.getImage(this.getCodeBase(), "phi.gif");
      new CFramePicture(this.mFramePanel, 45, 320, 0, 0, var15, false);
      Image var16 = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 352, 215, 0, 0, var16, false);
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

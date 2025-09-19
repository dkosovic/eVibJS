package Modal.Prog7.Eigen2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Eigen2DOF extends Applet implements Runnable {
   static final double kMink1 = 0.1;
   static final double kMaxk1 = 40.0;
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 10.0;
   static final double kMinc1 = 0.01;
   static final double kMaxc1 = 5.0;
   static final double kMink2 = 0.1;
   static final double kMaxk2 = 40.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 10.0;
   static final double kMinc2 = 0.01;
   static final double kMaxc2 = 5.0;
   static final double kMinx10 = -5.0;
   static final double kMaxx10 = 5.0;
   static final double kMinv10 = -20.0;
   static final double kMaxv10 = 20.0;
   static final double kMinx20 = -5.0;
   static final double kMaxx20 = 5.0;
   static final double kMinv20 = -20.0;
   static final double kMaxv20 = 20.0;
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
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 1.0, 10.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 80, 10, 0.1, 10.0, 40.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 160, 10, 0.01, 0.4, 5.0, "Ns/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 185, 26, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 250, 10, 0.1, 1.0, 10.0, "kg");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 275, 26, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 320, 10, 0.1, 10.0, 40.0, "N/m");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 345, 26, 0, 0, var17, false);
      CFrameSmallControl var19 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 400, 10, 0.01, 0.08, 5.0, "Ns/m");
      var19.SetLabelOffset(20, 10);
      var19.SetTextEditable(true);
      Image var20 = this.getImage(this.getCodeBase(), "c2.gif");
      new CFramePicture(this.mFramePanel, 425, 26, 0, 0, var20, false);
      CFrameSmallControl var22 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 530, 10, -5.0, 1.0, 5.0, "mm");
      var22.SetLabelOffset(20, 10);
      var22.SetTextEditable(true);
      Image var23 = this.getImage(this.getCodeBase(), "x10.gif");
      new CFramePicture(this.mFramePanel, 555, 26, 0, 0, var23, false);
      CFrameSmallControl var25 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 610, 10, -20.0, 10.0, 20.0, "mm/s");
      var25.SetLabelOffset(20, 10);
      var25.SetTextEditable(true);
      Image var26 = this.getImage(this.getCodeBase(), "v10.gif");
      new CFramePicture(this.mFramePanel, 635, 26, 0, 0, var26, false);
      CFrameSmallControl var28 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 9, 530, 70, -5.0, 0.0, 5.0, "mm");
      var28.SetLabelOffset(20, 10);
      var28.SetTextEditable(true);
      Image var29 = this.getImage(this.getCodeBase(), "x20.gif");
      new CFramePicture(this.mFramePanel, 555, 86, 0, 0, var29, false);
      CFrameSmallControl var31 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 10, 610, 70, -20.0, 0.0, 20.0, "mm/s");
      var31.SetLabelOffset(20, 10);
      var31.SetTextEditable(true);
      Image var32 = this.getImage(this.getCodeBase(), "v20.gif");
      new CFramePicture(this.mFramePanel, 635, 86, 0, 0, var32, false);
      Image var34 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 550, 120, 0, 0, var34, false);
      Image var36 = this.getImage(this.getCodeBase(), "Key.gif");
      new CFramePicture(this.mFramePanel, 560, 365, 0, 0, var36, false);
      Image var38 = this.getImage(this.getCodeBase(), "xlabel.gif");
      new CFramePicture(this.mFramePanel, 12, 43, 0, 0, var38, false);
      Image var40 = this.getImage(this.getCodeBase(), "yaxis.gif");
      new CFramePicture(this.mFramePanel, 75, 465, 0, 0, var40, false);
      Image var42 = this.getImage(this.getCodeBase(), "Time.gif");
      new CFramePicture(this.mFramePanel, 495, 465, 0, 0, var42, false);
      Image var44 = this.getImage(this.getCodeBase(), "Wlable.gif");
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

package MultiDOF.Prog6.Eigen5DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Eigen5DOF extends Applet implements Runnable {
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 100.0;
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 10.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 100.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 10.0;
   static final double kMink3 = 1.0;
   static final double kMaxk3 = 100.0;
   static final double kMinm3 = 0.1;
   static final double kMaxm3 = 10.0;
   static final double kMink4 = 1.0;
   static final double kMaxk4 = 100.0;
   static final double kMinm4 = 0.1;
   static final double kMaxm4 = 10.0;
   static final double kMink5 = 1.0;
   static final double kMaxk5 = 100.0;
   static final double kMinm5 = 0.1;
   static final double kMaxm5 = 10.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 105, 0, 1.0, 1.2, 100.0, "N/m");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 133, 20, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 135, 67, 0.1, 1.9, 10.0, "kg");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 160, 80, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 181, 0, 1.0, 1.3, 100.0, "N/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 209, 20, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 211, 67, 0.1, 1.8, 10.0, "kg");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 233, 80, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 257, 0, 1.0, 1.4, 100.0, "N/m");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "k3.gif");
      new CFramePicture(this.mFramePanel, 285, 20, 0, 0, var17, false);
      CFrameSmallControl var19 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 287, 67, 0.1, 1.7, 10.0, "kg");
      var19.SetLabelOffset(20, 10);
      var19.SetTextEditable(true);
      Image var20 = this.getImage(this.getCodeBase(), "m3.gif");
      new CFramePicture(this.mFramePanel, 309, 80, 0, 0, var20, false);
      CFrameSmallControl var22 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 333, 0, 1.0, 1.5, 100.0, "N/m");
      var22.SetLabelOffset(20, 10);
      var22.SetTextEditable(true);
      Image var23 = this.getImage(this.getCodeBase(), "k4.gif");
      new CFramePicture(this.mFramePanel, 361, 20, 0, 0, var23, false);
      CFrameSmallControl var25 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 363, 67, 0.1, 1.6, 10.0, "kg");
      var25.SetLabelOffset(20, 10);
      var25.SetTextEditable(true);
      Image var26 = this.getImage(this.getCodeBase(), "m4.gif");
      new CFramePicture(this.mFramePanel, 385, 80, 0, 0, var26, false);
      CFrameSmallControl var28 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 9, 409, 0, 1.0, 1.6, 100.0, "N/m");
      var28.SetLabelOffset(20, 10);
      var28.SetTextEditable(true);
      Image var29 = this.getImage(this.getCodeBase(), "k5.gif");
      new CFramePicture(this.mFramePanel, 437, 20, 0, 0, var29, false);
      CFrameSmallControl var31 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 10, 439, 67, 0.1, 1.5, 10.0, "kg");
      var31.SetLabelOffset(20, 10);
      var31.SetTextEditable(true);
      Image var32 = this.getImage(this.getCodeBase(), "m5.gif");
      new CFramePicture(this.mFramePanel, 461, 80, 0, 0, var32, false);
      int var34 = 85;
      Image var35 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, var34, 25, 0, 0, var35, false);
      Image var37 = this.getImage(this.getCodeBase(), "Add.gif");
      new CFramePicture(this.mFramePanel, var34 + 97, 25, 0, 0, var37, false);
      new CFramePicture(this.mFramePanel, var34 + 173, 25, 0, 0, var37, false);
      new CFramePicture(this.mFramePanel, var34 + 249, 25, 0, 0, var37, false);
      new CFramePicture(this.mFramePanel, var34 + 325, 25, 0, 0, var37, false);
      Image var39 = this.getImage(this.getCodeBase(), "M.gif");
      new CFramePicture(this.mFramePanel, 14, 130, 0, 0, var39, false);
      Image var41 = this.getImage(this.getCodeBase(), "K.gif");
      new CFramePicture(this.mFramePanel, 320, 130, 0, 0, var41, false);
      Image var43 = this.getImage(this.getCodeBase(), "lambda1.gif");
      new CFramePicture(this.mFramePanel, 20, 240, 0, 0, var43, false);
      Image var45 = this.getImage(this.getCodeBase(), "lambda2.gif");
      new CFramePicture(this.mFramePanel, 145, 240, 0, 0, var45, false);
      Image var47 = this.getImage(this.getCodeBase(), "lambda3.gif");
      new CFramePicture(this.mFramePanel, 270, 240, 0, 0, var47, false);
      Image var49 = this.getImage(this.getCodeBase(), "lambda4.gif");
      new CFramePicture(this.mFramePanel, 395, 240, 0, 0, var49, false);
      Image var51 = this.getImage(this.getCodeBase(), "lambda5.gif");
      new CFramePicture(this.mFramePanel, 520, 240, 0, 0, var51, false);
      Image var53 = this.getImage(this.getCodeBase(), "wn1.gif");
      new CFramePicture(this.mFramePanel, 10, 272, 0, 0, var53, false);
      Image var55 = this.getImage(this.getCodeBase(), "wn2.gif");
      new CFramePicture(this.mFramePanel, 135, 271, 0, 0, var55, false);
      Image var57 = this.getImage(this.getCodeBase(), "wn3.gif");
      new CFramePicture(this.mFramePanel, 260, 271, 0, 0, var57, false);
      Image var59 = this.getImage(this.getCodeBase(), "wn4.gif");
      new CFramePicture(this.mFramePanel, 385, 271, 0, 0, var59, false);
      Image var61 = this.getImage(this.getCodeBase(), "wn5.gif");
      new CFramePicture(this.mFramePanel, 510, 271, 0, 0, var61, false);
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

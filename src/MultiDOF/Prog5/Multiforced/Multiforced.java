import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.util.Date;

public class Multiforced extends Applet implements Runnable {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   static final double kMinm = 0.2;
   static final double kMaxm = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 20.0;
   static final double kMinc1 = 0.01;
   static final double kMaxc1 = 1.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 20.0;
   static final double kMinc2 = 0.01;
   static final double kMaxc2 = 1.0;
   static final double kMinb = 0.0;
   static final double kMaxb = 1.0;
   static final double kMinc = 0.0;
   static final double kMaxc = 1.0;
   static final double kMind = 0.0;
   static final double kMaxd = 1.0;
   static final double kMinm3 = 0.1;
   static final double kMaxm3 = 1.0;
   static final double kMink3 = 0.5;
   static final double kMaxk3 = 30.0;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Character var1 = new Character('©');
      Label var2 = new Label("  This program is copyright, you need permission to use it. " + var1 + " 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", var2);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 521, 365);
      CFrameSmallControl var3 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 3, 10, 20, 0.2, 0.2, 2.0, "kg");
      var3.SetLabelOffset(20, 10);
      var3.SetTextEditable(true);
      Image var4 = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 35, 36, 0, 0, var4, false);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 4, 80, 20, 1.0, 10.0, 20.0, "N/m");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      Image var7 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 36, 0, 0, var7, false);
      CFrameSmallControl var9 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 5, 160, 20, 0.01, 0.1, 1.0, "Ns/m");
      var9.SetLabelOffset(20, 10);
      var9.SetTextEditable(true);
      Image var10 = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 185, 36, 0, 0, var10, false);
      CFrameSmallControl var12 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 6, 255, 20, 1.0, 10.0, 20.0, "N/m");
      var12.SetLabelOffset(20, 10);
      var12.SetTextEditable(true);
      Image var13 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 280, 36, 0, 0, var13, false);
      CFrameSmallControl var15 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 7, 340, 20, 0.01, 0.1, 1.0, "Ns/m");
      var15.SetLabelOffset(20, 10);
      var15.SetTextEditable(true);
      Image var16 = this.getImage(this.getCodeBase(), "c2.gif");
      new CFramePicture(this.mFramePanel, 365, 36, 0, 0, var16, false);
      CFrameSmallControl var18 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 8, 430, 20, 0.0, 0.3, 1.0, " ");
      var18.SetLabelOffset(20, 10);
      var18.SetTextEditable(true);
      Image var19 = this.getImage(this.getCodeBase(), "Fpos.gif");
      new CFramePicture(this.mFramePanel, 450, 34, 0, 0, var19, false);
      CFrameSmallControl var21 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 9, 485, 20, 0.0, 0.6, 1.0, " ");
      var21.SetLabelOffset(20, 10);
      var21.SetTextEditable(true);
      Image var22 = this.getImage(this.getCodeBase(), "Xpos.gif");
      new CFramePicture(this.mFramePanel, 506, 34, 0, 0, var22, false);
      CFrameSmallControl var24 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 10, 540, 20, 0.0, 0.8, 1.0, " ");
      var24.SetLabelOffset(20, 10);
      var24.SetTextEditable(true);
      Image var25 = this.getImage(this.getCodeBase(), "Dpos.gif");
      new CFramePicture(this.mFramePanel, 560, 35, 0, 0, var25, false);
      CFrameSmallControl var27 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 11, 600, 20, 0.1, 0.5, 1.0, "kg");
      var27.SetLabelOffset(20, 10);
      var27.SetTextEditable(true);
      Image var28 = this.getImage(this.getCodeBase(), "m3.gif");
      new CFramePicture(this.mFramePanel, 625, 36, 0, 0, var28, false);
      CFrameSmallControl var30 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 12, 670, 20, 0.5, 19.74, 30.0, "N/m");
      var30.SetLabelOffset(20, 10);
      var30.SetTextEditable(true);
      Image var31 = this.getImage(this.getCodeBase(), "k3.gif");
      new CFramePicture(this.mFramePanel, 695, 34, 0, 0, var31, false);
      Image var33 = this.getImage(this.getCodeBase(), "diagram.gif");
      new CFramePicture(this.mFramePanel, 480, 100, 0, 0, var33, false);
      Image var35 = this.getImage(this.getCodeBase(), "Notes.gif");
      new CFramePicture(this.mFramePanel, 545, 200, 0, 0, var35, false);
      Image var37 = this.getImage(this.getCodeBase(), "xAxis.gif");
      new CFramePicture(this.mFramePanel, 35, 345, 0, 0, var37, false);
      Image var39 = this.getImage(this.getCodeBase(), "yAxis.gif");
      new CFramePicture(this.mFramePanel, 1, 63, 0, 0, var39, false);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, this.mFrameGraph, 0, 385, this.size().width, 60);
      this.validate();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public void run() {
      Date var1 = new Date();
      long var4 = var1.getTime();

      while (true) {
         try {
            Thread.sleep(50L);
         } catch (InterruptedException var8) {
            return;
         }

         var1 = new Date();
         long var2 = var4;
         var4 = var1.getTime();
         double var6 = (var4 - var2) / 1000.0;
         this.mFrameGraph.ControlMessage(2, var6);
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

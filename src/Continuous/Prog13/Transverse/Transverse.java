import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.util.Date;

public class Transverse extends Applet implements Runnable {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   static final double kMinL = 0.5;
   static final double kMaxL = 2.0;
   static final double kMinB = 0.02;
   static final double kMaxB = 0.2;
   static final double kMinH = 0.08;
   static final double kMaxH = 0.2;
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
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 441, 365);
      CFrameSmallControl var3 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 1, 480, 310, 0.5, 1.5, 2.0, "m");
      var3.SetLabelOffset(20, 10);
      var3.SetTextEditable(true);
      Image var4 = this.getImage(this.getCodeBase(), "L.gif");
      new CFramePicture(this.mFramePanel, 505, 325, 0, 0, var4, false);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 2, 550, 310, 0.02, 0.12, 0.2, "m");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      Image var7 = this.getImage(this.getCodeBase(), "B.gif");
      new CFramePicture(this.mFramePanel, 575, 325, 0, 0, var7, false);
      CFrameSmallControl var9 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 3, 625, 310, 0.08, 0.12, 0.2, "m");
      var9.SetLabelOffset(20, 10);
      var9.SetTextEditable(true);
      Image var10 = this.getImage(this.getCodeBase(), "H.gif");
      new CFramePicture(this.mFramePanel, 650, 325, 0, 0, var10, false);
      Image var12 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 109, 340, 0, 0, var12, false);
      Image var14 = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 10, 25, 0, 0, var14, false);
      Image var16 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 225, 0, 0, var16, false);
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
         this.mFrameGraph.ControlMessage(5, var6);
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

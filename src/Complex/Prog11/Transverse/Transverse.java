package Complex.Prog11.Transverse;

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
   static final double kMinD1 = 0.05;
   static final double kMaxD1 = 0.3;
   static final double kMinD2 = 0.05;
   static final double kMaxD2 = 0.3;
   static final double kMink = 10000.0;
   static final double kMaxk = 1.0E8;
   static final double kMinalpha = 0.0;
   static final double kMaxalpha = 1.0;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 441, 365);
      CFrameSmallControl var3 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 1, 480, 110, 0.5, 1.2, 2.0, "m");
      var3.SetLabelOffset(20, 10);
      var3.SetTextEditable(true);
      Image var4 = this.getImage(this.getCodeBase(), "L.gif");
      new CFramePicture(this.mFramePanel, 505, 125, 0, 0, var4, false);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 2, 580, 110, 0.05, 0.15, 0.3, "m");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      Image var7 = this.getImage(this.getCodeBase(), "D1.gif");
      new CFramePicture(this.mFramePanel, 605, 125, 0, 0, var7, false);
      CFrameSmallControl var9 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 3, 580, 160, 0.05, 0.1, 0.3, "m");
      var9.SetLabelOffset(20, 10);
      var9.SetTextEditable(true);
      Image var10 = this.getImage(this.getCodeBase(), "D2.gif");
      new CFramePicture(this.mFramePanel, 605, 175, 0, 0, var10, false);
      Image var12 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 129, 378, 0, 0, var12, false);
      Image var14 = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 13, 13, 0, 0, var14, false);
      Image var16 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 205, 0, 0, var16, false);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize().width, 60);
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
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

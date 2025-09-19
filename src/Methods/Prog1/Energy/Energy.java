package Methods.Prog1.Energy;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Energy extends Applet implements Runnable {
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 5.0;
   static final double kMinm1 = 1.0;
   static final double kMaxm1 = 5.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 5.0;
   static final double kMinm2 = 1.0;
   static final double kMaxm2 = 5.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Character var2 = new Character('©');
      Label var3 = new Label("  This program is copyright, you need permission to use it. " + var2 + " 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", var3);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 489, 118, 1.0, 1.0, 5.0, "k");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      var4.SetIntegerMode(true);
      CFrameSmallControl var5 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 477, 157, 1.0, 1.0, 5.0, "m");
      var5.SetLabelOffset(20, 10);
      var5.SetTextEditable(true);
      var5.SetIntegerMode(true);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 489, 200, 1.0, 1.0, 5.0, "k");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      var6.SetIntegerMode(true);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 477, 248, 1.0, 1.0, 5.0, "m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      var7.SetIntegerMode(true);
      Image var8 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 520, 60, 0, 0, var8, false);
      Image var10 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 28, 334, 0, 0, var10, false);
      Image var12 = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 356, 4, 0, 0, var12, false);
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

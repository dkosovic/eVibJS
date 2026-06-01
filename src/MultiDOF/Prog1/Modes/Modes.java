import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;

public class Modes extends Applet implements Runnable {
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
      Panel var1 = new Panel();
      this.add("North", var1);
      Character var2 = new Character('©');
      Label var3 = new Label(" This program is copyright, you need permission to use it. " + var2 + " 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", var3);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 185, 10, 0.2, 1.0, 2.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 210, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 265, 10, 1.0, 10.0, 20.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 290, 26, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 345, 10, 1.0, 10.0, 20.0, "N/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 370, 26, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 425, 10, 0.0, 0.8, 1.0, " ");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "Dpos.gif");
      new CFramePicture(this.mFramePanel, 446, 25, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 505, 10, 0.1, 0.5, 1.0, "kg");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "m3.gif");
      new CFramePicture(this.mFramePanel, 525, 26, 0, 0, var17, false);
      CFrameSmallControl var19 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 585, 10, 0.5, 10.0, 40.0, "N/m");
      var19.SetLabelOffset(20, 10);
      var19.SetTextEditable(true);
      Image var20 = this.getImage(this.getCodeBase(), "k3.gif");
      new CFramePicture(this.mFramePanel, 605, 24, 0, 0, var20, false);
      this.mAnimFrame.mStartButton = new Button("Start");
      var1.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      var1.add(this.mAnimFrame.mStopButton);
      this.validate();
      this.mAnimFrame.UpdateButtonAppearance();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public boolean action(Event var1, Object var2) {
      if (var1.target instanceof Button) {
         if (var2.equals("Start") || var2.equals("Cont.")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
         } else if (var2.equals("Pause")) {
            this.mAnimFrame.ControlMessage(1, 2.0);
         } else if (var2.equals("Stop")) {
            this.mAnimFrame.ControlMessage(1, 0.0);
         }
      }

      return true;
   }

   public void run() {
      Date var1 = new Date();
      long var4 = var1.getTime();

      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var8) {
            return;
         }

         var1 = new Date();
         long var2 = var4;
         var4 = var1.getTime();
         double var6 = (var4 - var2) / 1000.0;
         this.mAnimFrame.ControlMessage(0, var6);
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

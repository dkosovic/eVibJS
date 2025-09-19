package TwoDOF.Abutmentsin_2DOF.Forced;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;

public class Forced extends Applet implements Runnable {
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 40.0;
   static final double kMinc1 = 0.0;
   static final double kMaxc1 = 1.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 2.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 40.0;
   static final double kMinc2 = 0.0;
   static final double kMaxc2 = 1.0;
   static final double kMinXo = -10.0;
   static final double kMaxXo = 10.0;
   static final double kMinWin = 1.0E-4;
   static final double kMaxWin = 2.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Character var2 = new Character('©');
      Label var3 = new Label("This program is copyright, you need permission to use it. " + var2 + " 2000 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", var3);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.1, 2.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 80, 10, 1.0, 20.0, 40.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 150, 10, 0.0, 0.5, 1.0, "Ns/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 175, 26, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 250, 10, 0.1, 0.1, 2.0, "kg");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 285, 26, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 320, 10, 1.0, 20.0, 40.0, "N/m");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 345, 26, 0, 0, var17, false);
      CFrameSmallControl var19 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 7, 390, 10, 0.0, 0.01, 1.0, "Ns/m");
      var19.SetLabelOffset(20, 10);
      var19.SetTextEditable(true);
      Image var20 = this.getImage(this.getCodeBase(), "c2.gif");
      new CFramePicture(this.mFramePanel, 415, 26, 0, 0, var20, false);
      CFrameSmallControl var22 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 10, 60, -10.0, 5.0, 10.0, "mm");
      var22.SetLabelOffset(20, 10);
      var22.SetTextEditable(true);
      Image var23 = this.getImage(this.getCodeBase(), "Xo.gif");
      new CFramePicture(this.mFramePanel, 35, 76, 0, 0, var23, false);
      CFrameSmallControl var25 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 9, 10, 110, 1.0E-4, 1.2, 2.0, "Hz");
      var25.SetLabelOffset(20, 10);
      var25.SetTextEditable(true);
      Image var26 = this.getImage(this.getCodeBase(), "Win.gif");
      new CFramePicture(this.mFramePanel, 35, 126, 0, 0, var26, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 60, 50, "This is the top mass.");
      new CFrameHelp(this.mFramePanel, 70, 0, 60, 50, "This is the top stiffness.");
      new CFrameHelp(this.mFramePanel, 140, 0, 60, 50, "This is the top damper.");
      new CFrameHelp(this.mFramePanel, 240, 0, 60, 50, "This is the bottom mass.");
      new CFrameHelp(this.mFramePanel, 310, 0, 60, 50, "This is the bottom stiffness.");
      new CFrameHelp(this.mFramePanel, 380, 0, 60, 50, "This is the bottom damper.");
      new CFrameHelp(this.mFramePanel, 0, 55, 60, 50, "This is the amplitude\nof the input.");
      new CFrameHelp(this.mFramePanel, 0, 105, 60, 50, "This is the frequency \nof the input.");
      this.mAnimFrame.mStartButton = new Button("Start");
      var1.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new Button("Pause");
      var1.add(this.mAnimFrame.mPauseButton);
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

package TwoDOF.Prog12.Forcedresponse_2DOF;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Forcedresponse_2DOF extends Applet implements ActionListener {
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 40.0;
   static final double kMinc1 = 0.01;
   static final double kMaxc1 = 1.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 2.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 40.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2000 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 0.1, 2.0, "kg");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, var5, false);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 20.0, 40.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      Image var8 = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, var8, false);
      CFrameSmallControl var10 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 150, 10, 0.01, 0.05, 1.0, "Ns/m");
      var10.SetLabelOffset(20, 10);
      var10.SetTextEditable(true);
      Image var11 = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 175, 26, 0, 0, var11, false);
      CFrameSmallControl var13 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 250, 10, 0.1, 0.1, 2.0, "kg");
      var13.SetLabelOffset(20, 10);
      var13.SetTextEditable(true);
      Image var14 = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 275, 26, 0, 0, var14, false);
      CFrameSmallControl var16 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 320, 10, 1.0, 20.0, 40.0, "N/m");
      var16.SetLabelOffset(20, 10);
      var16.SetTextEditable(true);
      Image var17 = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 345, 26, 0, 0, var17, false);
      Image var19 = this.getImage(this.getCodeBase(), "response.gif");
      new CFramePicture(this.mFramePanel, 34, 45, 0, 0, var19, false);
      Image var21 = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 76, 346, 0, 0, var21, false);
      this.validate();
   }

   public void start() {
      this.mTimer = new Timer(20, this);
      this.mTimer.start();
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mTimer != null) {
         Date ddd = new Date();
         long thisTime = ddd.getTime();

         if (this.mLastTime == 0) {
            this.mLastTime = thisTime;
         }
         // double realSeconds = (thisTime - this.mLastTime) / 1000.0;
         this.mLastTime = thisTime;

         // this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }
}

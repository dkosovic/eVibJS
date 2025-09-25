package Modal.Prog3.Eigen2DOF;

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
public class Eigen2DOF extends Applet implements ActionListener {
   static final double kMink1 = 0.1;
   static final double kMaxk1 = 10.0;
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 10.0;
   static final double kMinc1 = 0.001;
   static final double kMaxc1 = 1.0;
   static final double kMink2 = 0.1;
   static final double kMaxk2 = 10.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 10.0;
   static final double kMinc2 = 0.001;
   static final double kMaxc2 = 1.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 540, 1, 0.1, 1.0, 10.0, "N/m");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      CFrameSmallControl var5 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 540, 48, 0.1, 1.0, 10.0, "kg");
      var5.SetLabelOffset(20, 10);
      var5.SetTextEditable(true);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 540, 95, 0.001, 0.08, 1.0, "Ns/m");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      CFrameSmallControl var7 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 540, 142, 0.1, 1.0, 10.0, "N/m");
      var7.SetLabelOffset(20, 10);
      var7.SetTextEditable(true);
      CFrameSmallControl var8 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 540, 189, 0.1, 1.0, 10.0, "kg");
      var8.SetLabelOffset(20, 10);
      var8.SetTextEditable(true);
      CFrameSmallControl var9 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 540, 236, 0.001, 0.08, 1.0, "Ns/m");
      var9.SetLabelOffset(20, 10);
      var9.SetTextEditable(true);
      Image var10 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 435, 15, 0, 0, var10, false);
      Image var12 = this.getImage(this.getCodeBase(), "lambda1.gif");
      new CFramePicture(this.mFramePanel, 10, 10, 0, 0, var12, false);
      Image var14 = this.getImage(this.getCodeBase(), "lambda2.gif");
      new CFramePicture(this.mFramePanel, 10, 40, 0, 0, var14, false);
      Image var16 = this.getImage(this.getCodeBase(), "lambda3.gif");
      new CFramePicture(this.mFramePanel, 230, 10, 0, 0, var16, false);
      Image var18 = this.getImage(this.getCodeBase(), "lambda4.gif");
      new CFramePicture(this.mFramePanel, 230, 40, 0, 0, var18, false);
      Image var20 = this.getImage(this.getCodeBase(), "w1.gif");
      new CFramePicture(this.mFramePanel, 10, 90, 0, 0, var20, false);
      Image var22 = this.getImage(this.getCodeBase(), "w1Xi1.gif");
      new CFramePicture(this.mFramePanel, 10, 130, 0, 0, var22, false);
      Image var24 = this.getImage(this.getCodeBase(), "w2.gif");
      new CFramePicture(this.mFramePanel, 230, 90, 0, 0, var24, false);
      Image var26 = this.getImage(this.getCodeBase(), "w2Xi2.gif");
      new CFramePicture(this.mFramePanel, 230, 130, 0, 0, var26, false);
      Image var28 = this.getImage(this.getCodeBase(), "wn1.gif");
      new CFramePicture(this.mFramePanel, 10, 180, 0, 0, var28, false);
      Image var30 = this.getImage(this.getCodeBase(), "Xi1.gif");
      new CFramePicture(this.mFramePanel, 10, 200, 0, 0, var30, false);
      Image var32 = this.getImage(this.getCodeBase(), "wn2.gif");
      new CFramePicture(this.mFramePanel, 230, 180, 0, 0, var32, false);
      Image var34 = this.getImage(this.getCodeBase(), "Xi2.gif");
      new CFramePicture(this.mFramePanel, 230, 200, 0, 0, var34, false);
      Image var36 = this.getImage(this.getCodeBase(), "undamped.gif");
      new CFramePicture(this.mFramePanel, 10, 240, 0, 0, var36, false);
      new CFramePicture(this.mFramePanel, 10, 270, 0, 0, var28, false);
      new CFramePicture(this.mFramePanel, 230, 270, 0, 0, var32, false);
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
         double realSeconds = (thisTime - this.mLastTime) / 1000.0;
         this.mLastTime = thisTime;
         
         //this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }
}

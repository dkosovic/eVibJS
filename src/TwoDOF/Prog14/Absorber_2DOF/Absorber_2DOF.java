package TwoDOF.Prog14.Absorber_2DOF;

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
public class Absorber_2DOF extends Applet implements ActionListener {
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 100.0;
   static final double kMinc1 = 0.001;
   static final double kMaxc1 = 1.0;
   static final double kMinm2 = 0.01;
   static final double kMaxm2 = 2.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2001 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl m1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 1.0, 2.0, "kg");
      m1Control.SetLabelOffset(20, 10);
      m1Control.SetTextEditable(true);
      Image m1Image = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, m1Image, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 40.0, 100.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl c1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 150, 10, 0.001, 0.05, 1.0, "Ns/m");
      c1Control.SetLabelOffset(20, 10);
      c1Control.SetTextEditable(true);
      Image c1Image = this.getImage(this.getCodeBase(), "c1.gif");
      new CFramePicture(this.mFramePanel, 175, 26, 0, 0, c1Image, false);
      CFrameSmallControl m2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 250, 10, 0.01, 0.1, 2.0, "kg");
      m2Control.SetLabelOffset(20, 10);
      m2Control.SetTextEditable(true);
      Image m2Image = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 275, 26, 0, 0, m2Image, false);
      Image responseImage = this.getImage(this.getCodeBase(), "response.gif");
      new CFramePicture(this.mFramePanel, 34, 45, 0, 0, responseImage, false);
      Image WlabelImage = this.getImage(this.getCodeBase(), "Wlable.gif");
      new CFramePicture(this.mFramePanel, 76, 346, 0, 0, WlabelImage, false);
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

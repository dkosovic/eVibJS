package Modal.Qhysteretic.Qfactor;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Qfactor extends Applet implements ActionListener {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 5.0;
   static final double kMink1 = 50000.0;
   static final double kMaxk1 = 450000.0;
   static final double kMinh1 = 2000.0;
   static final double kMaxh1 = 1000000.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 5.0;
   static final double kMink2 = 50000.0;
   static final double kMaxk2 = 450000.0;
   static final double kMinh2 = 2000.0;
   static final double kMaxh2 = 1000000.0;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Label copyright = new Label("  Th1s program is copyright, you need permission to use it. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 1641, 365);
      CFrameSmallControl m1Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 1, 10, 10, 0.1, 1.5, 5.0, "kg");
      m1Control.SetLabelOffset(20, 10);
      m1Control.SetTextEditable(true);
      Image m1Image = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, m1Image, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 2, 80, 10, 50000.0, 400000.0, 450000.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl h1Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 3, 180, 10, 2000.0, 40000.0, 1000000.0, "N/m");
      h1Control.SetLabelOffset(20, 10);
      h1Control.SetTextEditable(true);
      Image h1Image = this.getImage(this.getCodeBase(), "h1.gif");
      new CFramePicture(this.mFramePanel, 205, 26, 0, 0, h1Image, false);
      CFrameSmallControl m2Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 4, 270, 10, 0.1, 1.2, 5.0, "kg");
      m2Control.SetLabelOffset(20, 10);
      m2Control.SetTextEditable(true);
      Image m2Image = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 295, 26, 0, 0, m2Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 5, 340, 10, 50000.0, 200000.0, 450000.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 365, 26, 0, 0, k2Image, false);
      CFrameSmallControl h2Control = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 6, 440, 10, 2000.0, 10000.0, 1000000.0, "N/m");
      h2Control.SetLabelOffset(20, 10);
      h2Control.SetTextEditable(true);
      Image h2Image = this.getImage(this.getCodeBase(), "h2.gif");
      new CFramePicture(this.mFramePanel, 465, 26, 0, 0, h2Image, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 129, 418, 0, 0, XaxisImage, false);
      Image YaxisImage = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 13, 53, 0, 0, YaxisImage, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 480, 65, 0, 0, DiagramImage, false);
      Image KeyImage = this.getImage(this.getCodeBase(), "Key.gif");
      new CFramePicture(this.mFramePanel, 380, 65, 0, 0, KeyImage, false);
      this.validate();
   }

   public void start() {
      this.mTimer = new Timer(50, this);
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



   public void stop() {
      if (this.mTimer != null) { this.mTimer.stop(); this.mTimer = null; }
   }
}

package Modal.Prog5.Qfactor;

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
   static final double kMink = 150000.0;
   static final double kMaxk = 450000.0;
   static final double kMinm = 0.5;
   static final double kMaxm = 2.0;
   static final double kMinc = 1.0;
   static final double kMaxc = 500.0;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2005 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 1641, 365);
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 2, 480, 40, 0.5, 1.0, 2.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 505, 55, 0, 0, mImage, false);
      CFrameSmallControl cControl = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 3, 570, 40, 1.0, 50.0, 500.0, "Ns/m");
      cControl.SetLabelOffset(20, 10);
      cControl.SetTextEditable(true);
      Image cImage = this.getImage(this.getCodeBase(), "c.gif");
      new CFramePicture(this.mFramePanel, 595, 55, 0, 0, cImage, false);
      CFrameSmallControl kControl = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 1, 480, 90, 150000.0, 400000.0, 450000.0, "N/m");
      kControl.SetLabelOffset(20, 10);
      kControl.SetTextEditable(true);
      Image kImage = this.getImage(this.getCodeBase(), "k.gif");
      new CFramePicture(this.mFramePanel, 505, 105, 0, 0, kImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 129, 378, 0, 0, XaxisImage, false);
      Image YaxisImage = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 13, 13, 0, 0, YaxisImage, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 135, 0, 0, DiagramImage, false);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize().width, 60);
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
         double realSeconds = (thisTime - this.mLastTime) / 1000.0;
         this.mLastTime = thisTime;
         
         //this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }



   public void stop() {
      if (this.mTimer != null) { this.mTimer.stop(); this.mTimer = null; }
   }
}

package Continuous.Prog3.Multiforced;

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
public class Multiforced extends Applet implements ActionListener {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   static final double kMinL = 0.5;
   static final double kMaxL = 2.0;
   static final double kMinD = 0.05;
   static final double kMaxD = 0.2;
   static final double kMinEta = 0.01;
   static final double kMaxEta = 1.0;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 0, 20, 441, 365);
      CFrameSmallControl var3 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 1, 480, 310, 0.5, 1.0, 2.0, "m");
      var3.SetLabelOffset(20, 10);
      var3.SetTextEditable(true);
      Image var4 = this.getImage(this.getCodeBase(), "L.gif");
      new CFramePicture(this.mFramePanel, 505, 325, 0, 0, var4, false);
      CFrameSmallControl var6 = new CFrameSmallControl(this.mFramePanel, this.mFrameGraph, 2, 570, 310, 0.05, 0.1, 0.2, "m");
      var6.SetLabelOffset(20, 10);
      var6.SetTextEditable(true);
      Image var7 = this.getImage(this.getCodeBase(), "D.gif");
      new CFramePicture(this.mFramePanel, 595, 325, 0, 0, var7, false);
      Image var9 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 109, 339, 0, 0, var9, false);
      Image var11 = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 5, 27, 0, 0, var11, false);
      Image var13 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 225, 0, 0, var13, false);
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
         
         this.mFrameGraph.ControlMessage(5, realSeconds);
      }
   }

   public void stop() {
      if (this.mTimer != null) { this.mTimer.stop(); this.mTimer = null; }
   }
}

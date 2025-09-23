package TwoDOF.Prog4.Forcedresponse;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class Forcedresponse extends Applet implements ActionListener {
   static final double kMinK2divK1 = 0.2;
   static final double kMaxK2divK1 = 5.0;
   static final double kMinM2divM1 = 0.2;
   static final double kMaxM2divM1 = 5.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl K2divK1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 450, 10, 0.2, 2.0, 5.0, " ");
      K2divK1Control.SetLabelOffset(20, 10);
      K2divK1Control.SetTextEditable(true);
      Image K2divK1Image = this.getImage(this.getCodeBase(), "K2divK1.gif");
      new CFramePicture(this.mFramePanel, 471, 25, 0, 0, K2divK1Image, false);
      CFrameSmallControl M2divM1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 520, 10, 0.2, 0.5, 5.0, " ");
      M2divM1Control.SetLabelOffset(20, 10);
      M2divM1Control.SetTextEditable(true);
      Image M2divM1Image = this.getImage(this.getCodeBase(), "M2divM1.gif");
      new CFramePicture(this.mFramePanel, 541, 25, 0, 0, M2divM1Image, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 460, 60, 0, 0, DiagramImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 96, 145, 0, 0, XaxisImage, false);
      new CFramePicture(this.mFramePanel, 96, 465, 0, 0, XaxisImage, false);
      Image Y1axesImage = this.getImage(this.getCodeBase(), "Y1axis.gif");
      new CFramePicture(this.mFramePanel, 20, 5, 0, 0, Y1axesImage, false);
      Image Y2axesImage = this.getImage(this.getCodeBase(), "Y2axis.gif");
      new CFramePicture(this.mFramePanel, 20, 325, 0, 0, Y2axesImage, false);
      Image LegendImage = this.getImage(this.getCodeBase(), "Legend.gif");
      new CFramePicture(this.mFramePanel, 280, 25, 0, 0, LegendImage, false);
      new CFramePicture(this.mFramePanel, 280, 345, 0, 0, LegendImage, false);
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

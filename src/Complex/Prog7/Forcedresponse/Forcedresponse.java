package Complex.Prog7.Forcedresponse;

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
public class Forcedresponse extends Applet implements ActionListener {
   static final double kMinL = 0.5;
   static final double kMaxL = 2.0;
   static final double kMinD = 0.05;
   static final double kMaxD = 0.2;
   static final double kMinm = 5.0;
   static final double kMaxm = 100.0;
   static final double kMink = 1.5E8;
   static final double kMaxk = 1.0E10;
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
      CFrameSmallControl LControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 450, 310, 0.5, 1.0, 2.0, "m");
      LControl.SetLabelOffset(20, 10);
      LControl.SetTextEditable(true);
      Image LImage = this.getImage(this.getCodeBase(), "L.gif");
      new CFramePicture(this.mFramePanel, 475, 325, 0, 0, LImage, false);
      CFrameSmallControl DControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 530, 310, 0.05, 0.1, 0.2, "m");
      DControl.SetLabelOffset(20, 10);
      DControl.SetTextEditable(true);
      Image DImage = this.getImage(this.getCodeBase(), "D.gif");
      new CFramePicture(this.mFramePanel, 555, 325, 0, 0, DImage, false);
      CFrameSmallControl mControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 610, 310, 5.0, 20.0, 100.0, "kg");
      mControl.SetLabelOffset(20, 10);
      mControl.SetTextEditable(true);
      Image mImage = this.getImage(this.getCodeBase(), "m.gif");
      new CFramePicture(this.mFramePanel, 635, 325, 0, 0, mImage, false);
      CFrameSmallControl kControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 690, 310, 1.5E8, 1.0E9, 1.0E10, "N/m");
      kControl.SetLabelOffset(20, 10);
      kControl.SetTextEditable(true);
      Image kImage = this.getImage(this.getCodeBase(), "k.gif");
      new CFramePicture(this.mFramePanel, 715, 325, 0, 0, kImage, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 30, 0, 0, DiagramImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 87, 185, 0, 0, XaxisImage, false);
      Image YaxisImage = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 0, 3, 0, 0, YaxisImage, false);
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

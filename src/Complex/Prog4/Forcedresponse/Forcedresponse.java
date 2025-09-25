package Complex.Prog4.Forcedresponse;

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
   static final double kMinLb = 0.2;
   static final double kMaxLb = 1.5;
   static final double kMinDb = 0.02;
   static final double kMaxDb = 0.2;
   static final double kMinLc = 0.2;
   static final double kMaxLc = 1.5;
   static final double kMinDc = 0.02;
   static final double kMaxDc = 0.2;
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
      CFrameSmallControl LbControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 430, 330, 0.2, 0.4, 1.5, "m");
      LbControl.SetLabelOffset(20, 10);
      LbControl.SetTextEditable(true);
      Image LbImage = this.getImage(this.getCodeBase(), "Lb.gif");
      new CFramePicture(this.mFramePanel, 450, 345, 0, 0, LbImage, false);
      CFrameSmallControl DbControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 520, 330, 0.02, 0.06, 0.2, "m");
      DbControl.SetLabelOffset(20, 10);
      DbControl.SetTextEditable(true);
      Image DbImage = this.getImage(this.getCodeBase(), "Db.gif");
      new CFramePicture(this.mFramePanel, 540, 345, 0, 0, DbImage, false);
      CFrameSmallControl LcControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 610, 330, 0.2, 0.6, 1.5, "m");
      LcControl.SetLabelOffset(20, 10);
      LcControl.SetTextEditable(true);
      Image LcImage = this.getImage(this.getCodeBase(), "Lc.gif");
      new CFramePicture(this.mFramePanel, 630, 345, 0, 0, LcImage, false);
      CFrameSmallControl DcControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 4, 700, 330, 0.02, 0.04, 0.2, "m");
      DcControl.SetLabelOffset(20, 10);
      DcControl.SetTextEditable(true);
      Image DcImage = this.getImage(this.getCodeBase(), "Dc.gif");
      new CFramePicture(this.mFramePanel, 720, 345, 0, 0, DcImage, false);
      Image DiagramImage = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 0, 0, 0, DiagramImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 75, 135, 0, 0, XaxisImage, false);
      Image YaxisImage = this.getImage(this.getCodeBase(), "Yaxis.gif");
      new CFramePicture(this.mFramePanel, 1, 3, 0, 0, YaxisImage, false);
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

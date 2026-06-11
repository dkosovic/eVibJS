package OneDOF.Prog7.Forcedlocus;

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
public class Forcedlocus extends Applet implements ActionListener {
   static final double kMinXi = 0.04;
   static final double kMaxXi = 3.0;
   static final double kMinW = 0.01;
   static final double kMaxW = 3.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl XiControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 55, 10, 0.04, 0.1, 3.0, " ");
      XiControl.SetLabelOffset(20, 10);
      XiControl.SetTextEditable(true);
      Image XiImage = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 83, 25, 0, 0, XiImage, false);
      CFrameSmallControl WControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 255, 10, 0.01, 0.9, 3.0, " ");
      WControl.SetLabelOffset(20, 10);
      WControl.SetTextEditable(true);
      Image WImage = this.getImage(this.getCodeBase(), "WdivWn.gif");
      new CFramePicture(this.mFramePanel, 283, 25, 0, 0, WImage, false);
      Image XaxisImage = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 37, 220, 0, 0, XaxisImage, false);
      Image YaxesImage = this.getImage(this.getCodeBase(), "Yaxes.gif");
      new CFramePicture(this.mFramePanel, 2, 45, 0, 0, YaxesImage, false);
      Image kXdivFImage = this.getImage(this.getCodeBase(), "kXdivF.gif");
      new CFramePicture(this.mFramePanel, 45, 65, 0, 0, kXdivFImage, false);
      Image phiImage = this.getImage(this.getCodeBase(), "phi.gif");
      new CFramePicture(this.mFramePanel, 45, 320, 0, 0, phiImage, false);
      Image WdivWnImage = this.getImage(this.getCodeBase(), "WdivWn.gif");
      new CFramePicture(this.mFramePanel, 352, 215, 0, 0, WdivWnImage, false);
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

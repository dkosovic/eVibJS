package OneDOF.Prog12.Abutmentresponse;

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
public class Abutmentresponse extends Applet implements ActionListener {
   static final double kMinXi = 0.001;
   static final double kMaxXi = 3.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.getSize().width, this.getSize().height);
      CFrameSmallControl var4 = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 1, 100, 10, 0.001, 0.05, 3.0, " ");
      var4.SetLabelOffset(20, 10);
      var4.SetTextEditable(true);
      Image var5 = this.getImage(this.getCodeBase(), "xi.gif");
      new CFramePicture(this.mFramePanel, 128, 25, 0, 0, var5, false);
      Image var7 = this.getImage(this.getCodeBase(), "Diagram.gif");
      new CFramePicture(this.mFramePanel, 470, 65, 0, 0, var7, false);
      Image var9 = this.getImage(this.getCodeBase(), "Xaxis.gif");
      new CFramePicture(this.mFramePanel, 97, 220, 0, 0, var9, false);
      Image var11 = this.getImage(this.getCodeBase(), "Yaxes.gif");
      new CFramePicture(this.mFramePanel, 62, 45, 0, 0, var11, false);
      Image var13 = this.getImage(this.getCodeBase(), "kXdivXo.gif");
      new CFramePicture(this.mFramePanel, 105, 65, 0, 0, var13, false);
      Image var15 = this.getImage(this.getCodeBase(), "phi.gif");
      new CFramePicture(this.mFramePanel, 105, 320, 0, 0, var15, false);
      Image var17 = this.getImage(this.getCodeBase(), "WdivWn.gif");
      new CFramePicture(this.mFramePanel, 412, 215, 0, 0, var17, false);
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

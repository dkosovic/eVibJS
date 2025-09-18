import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

public class Abutmentresponse extends Applet implements Runnable {
   static final double kMinXi = 0.001;
   static final double kMaxXi = 3.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Character var2 = new Character('©');
      Label var3 = new Label("  This program is copyright, you need permission to use it. " + var2 + " 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", var3);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
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
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public void run() {
      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var1) {
            return;
         }
      }
   }
}

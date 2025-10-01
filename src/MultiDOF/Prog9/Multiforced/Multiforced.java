package MultiDOF.Prog9.Multiforced;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Multiforced extends JApplet implements ActionListener {
   public JFrame mFeedbackWindow = null;
   public JTextField answer1;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      JPanel var1 = new JPanel();
      this.add("North", var1);
      JLabel copyright = new JLabel("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      Image var4 = this.getImage(this.getCodeBase(), "yaxis.gif");
      new CFramePicture(this.mFramePanel, 2, 69, 0, 0, var4, false);
      Image var6 = this.getImage(this.getCodeBase(), "w1axis.gif");
      new CFramePicture(this.mFramePanel, 30, 355, 0, 0, var6, false);
      Image var8 = this.getImage(this.getCodeBase(), "w2axis.gif");
      new CFramePicture(this.mFramePanel, 530, 355, 0, 0, var8, false);
      this.mFrameGraph = new CFrameGraph(this.mFramePanel, 40, 70, 602, 280);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize().width, 60);
      JButton var10 = new JButton("Instructions");
      var10.addActionListener(this);
      var1.add(var10);
      JButton var11 = new JButton("Edit");
      var11.addActionListener(this);
      var1.add(var11);
      this.validate();
   }

   public void start() {
      this.mTimer = new Timer(50, this);
      this.mTimer.start();
   }

   public void actionPerformed(ActionEvent e) {
      // Handle button clicks
      if (e.getSource() instanceof JButton) {
         JButton source = (JButton) e.getSource();
         String label = source.getText();
         if (label.equals("Edit")) {
            this.mFrameGraph.ControlMessage(null, 1, 0.0);
         } else if (label.equals("Instructions")) {
            String var3 = this.getCodeBase().toString() + "instructions.html";
            Object var4 = null;

            try {
               var4 = new URL(var3);
               this.getAppletContext().showDocument((URL)var4, "_blank");
            } catch (MalformedURLException var5) {
               System.out.println("Malformed URL exception");
            }
         }
         return;
      }

      // Handle timer events
      if (this.mTimer != null) {
         Date ddd = new Date();
         long thisTime = ddd.getTime();

         if (this.mLastTime == 0) {
            this.mLastTime = thisTime;
         }
         double realSeconds = (thisTime - this.mLastTime) / 1000.0;
         this.mLastTime = thisTime;

         this.mFrameGraph.ControlMessage(3, realSeconds);
      }
   }

   public void stop() {
      if (this.mTimer != null) { this.mTimer.stop(); this.mTimer = null; }
   }
}

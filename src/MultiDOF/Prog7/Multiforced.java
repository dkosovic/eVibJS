package MultiDOF.Prog7;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Multiforced extends Applet implements ActionListener {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Timer mTimer = null;
   long mLastTime = 0;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 2004 B J Stone, bjs@mech.uwa.edu.au.");
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
      Button var10 = new Button("Instructions");
      var10.addActionListener(this);
      var1.add(var10);
      Button var11 = new Button("Edit");
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
      if (e.getSource() instanceof Button) {
         Button source = (Button) e.getSource();
         String label = source.getLabel();
         if (label.equals("Edit")) {
            this.mFrameGraph.ControlMessage(null, 1, 0.0);
         } else if (label.equals("Instructions")) {
            String currentTime = this.getCodeBase().toString() + "instructions.html";
            URL var4 = null;

            try {
               var4 = new URL(currentTime);
               this.getAppletContext().showDocument(var4, "_blank");
            } catch (MalformedURLException ex) {
               System.out.println("Malformed URL exception");
            }
         }
         return;
      }

      // Handle timer events
      Date now = new Date();
      long currentTime = now.getTime();
      if (this.mLastTime == 0) {
         this.mLastTime = currentTime;
         return;
      }

      double ex = (currentTime - this.mLastTime) / 1000.0;
      this.mLastTime = currentTime;
      this.mFrameGraph.ControlMessage(3, ex);
   }

   public void stop() {
      if (this.mTimer != null) {
         this.mTimer.stop();
         this.mTimer = null;
      }
   }
}

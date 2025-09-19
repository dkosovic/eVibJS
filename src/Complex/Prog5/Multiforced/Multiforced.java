package Complex.Prog5.Multiforced;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Multiforced extends Applet implements Runnable {
   public Frame mFeedbackWindow = null;
   public TextField answer1;
   CFramePanel mFramePanel;
   CFrameGraph mFrameGraph;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel var1 = new Panel();
      this.add("North", var1);
      Label copyright = new Label("  This program is copyright, you need permission to use it. © 1999 B J Stone, bjs@mech.uwa.edu.au.");
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
      var1.add(var10);
      Button var11 = new Button("Edit");
      var1.add(var11);
      this.validate();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public boolean action(Event var1, Object var2) {
      if (var1.target instanceof Button) {
         if (var2.equals("Edit")) {
            this.mFrameGraph.ControlMessage(null, 1, 0.0);
         } else if (var2.equals("Instructions")) {
            String var3 = this.getCodeBase().toString() + "instructions.html";
            Object var4 = null;

            try {
               var4 = new URL(var3);
               this.getAppletContext().showDocument((URL)var4, "_blank");
            } catch (MalformedURLException var5) {
               System.out.println("Malformed URL exception");
            }
         }
      }

      return true;
   }

   public void run() {
      Date var1 = new Date();
      long var4 = var1.getTime();

      while (true) {
         try {
            Thread.sleep(50L);
         } catch (InterruptedException var8) {
            return;
         }

         var1 = new Date();
         long var2 = var4;
         var4 = var1.getTime();
         double var6 = (var4 - var2) / 1000.0;
         this.mFrameGraph.ControlMessage(3, var6);
      }
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

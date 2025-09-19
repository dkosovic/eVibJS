package TwoDOF.Prog3.Undamped;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.Date;

public class Undamped extends Applet implements Runnable {
   static final double kMinm1 = 0.1;
   static final double kMaxm1 = 2.0;
   static final double kMink1 = 1.0;
   static final double kMaxk1 = 20.0;
   static final double kMinc1 = 0.0;
   static final double kMaxc1 = 1.0;
   static final double kMinm2 = 0.1;
   static final double kMaxm2 = 2.0;
   static final double kMink2 = 1.0;
   static final double kMaxk2 = 20.0;
   static final double kMinc2 = 0.0;
   static final double kMaxc2 = 1.0;
   double mMinX1o = -7.0;
   double mMaxX1o = 7.0;
   double mMinX2o = -7.0;
   double mMaxX2o = 7.0;
   static final String kRunString = "Run";
   CFramePanel mFramePanel;
   CFrameAnimation mAnimFrame;
   Thread mThread = null;

   public void init() {
      this.setLayout(new BorderLayout());
      Panel buttonPanel = new Panel();
      this.add("North", buttonPanel);
      Label copyright = new Label("This program is copyright, you need permission to use it. © 2000 B J Stone, bjs@mech.uwa.edu.au.");
      this.add("South", copyright);
      this.mFramePanel = new CFramePanel(this);
      this.add("Center", this.mFramePanel);
      this.mAnimFrame = new CFrameAnimation(this.mFramePanel, 0, 0, this.size().width, this.size().height);
      CFrameSmallControl m1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.1, 2.0, "kg");
      m1Control.SetLabelOffset(20, 10);
      m1Control.SetTextEditable(true);
      Image m1Image = this.getImage(this.getCodeBase(), "m1.gif");
      new CFramePicture(this.mFramePanel, 35, 26, 0, 0, m1Image, false);
      CFrameSmallControl k1Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 3, 80, 10, 1.0, 8.0, 20.0, "N/m");
      k1Control.SetLabelOffset(20, 10);
      k1Control.SetTextEditable(true);
      Image k1Image = this.getImage(this.getCodeBase(), "k1.gif");
      new CFramePicture(this.mFramePanel, 105, 26, 0, 0, k1Image, false);
      CFrameSmallControl m2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 5, 150, 10, 0.1, 0.1, 2.0, "kg");
      m2Control.SetLabelOffset(20, 10);
      m2Control.SetTextEditable(true);
      Image m2Image = this.getImage(this.getCodeBase(), "m2.gif");
      new CFramePicture(this.mFramePanel, 175, 26, 0, 0, m2Image, false);
      CFrameSmallControl k2Control = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 6, 220, 10, 1.0, 8.0, 20.0, "N/m");
      k2Control.SetLabelOffset(20, 10);
      k2Control.SetTextEditable(true);
      Image k2Image = this.getImage(this.getCodeBase(), "k2.gif");
      new CFramePicture(this.mFramePanel, 245, 26, 0, 0, k2Image, false);
      CFrameSmallControl X1oControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 8, 10, 60, this.mMinX1o, 5.0, this.mMaxX1o, "mm");
      X1oControl.SetLabelOffset(20, 10);
      X1oControl.SetTextEditable(true);
      Image X1oImage = this.getImage(this.getCodeBase(), "X1o.gif");
      new CFramePicture(this.mFramePanel, 35, 76, 0, 0, X1oImage, false);
      CFrameSmallControl X2oControl = new CFrameSmallControl(this.mFramePanel, this.mAnimFrame, 9, 10, 110, this.mMinX2o, 0.0, this.mMaxX2o, "mm");
      X2oControl.SetLabelOffset(20, 10);
      X2oControl.SetTextEditable(true);
      Image X2oImage = this.getImage(this.getCodeBase(), "X2o.gif");
      new CFramePicture(this.mFramePanel, 35, 126, 0, 0, X2oImage, false);
      new CFrameHelp(this.mFramePanel, 0, 0, 60, 50, "This is the top mass.");
      new CFrameHelp(this.mFramePanel, 70, 0, 60, 50, "This is the top stiffness.");
      new CFrameHelp(this.mFramePanel, 140, 0, 60, 50, "This is the bottom mass.");
      new CFrameHelp(this.mFramePanel, 210, 0, 60, 50, "This is the bottom stiffness.");
      new CFrameHelp(this.mFramePanel, 0, 55, 60, 50, "This is the initial displacement \nof the top mass.");
      new CFrameHelp(this.mFramePanel, 0, 105, 60, 50, "This is the initial displacement \nof the bottom mass.");
      this.mAnimFrame.mStartButton = new Button("Start");
      buttonPanel.add(this.mAnimFrame.mStartButton);
      this.mAnimFrame.mPauseButton = new Button("Pause");
      buttonPanel.add(this.mAnimFrame.mPauseButton);
      this.mAnimFrame.mStopButton = new Button("Stop");
      buttonPanel.add(this.mAnimFrame.mStopButton);
      this.validate();
      this.mAnimFrame.UpdateButtonAppearance();
   }

   public void start() {
      this.mThread = new Thread(this);
      this.mThread.start();
   }

   public boolean action(Event evt, Object arg) {
      if (evt.target instanceof Button) {
         if (arg.equals("Start") || arg.equals("Cont.")) {
            this.mAnimFrame.ControlMessage(1, 1.0);
         } else if (arg.equals("Pause")) {
            this.mAnimFrame.ControlMessage(1, 2.0);
         } else if (arg.equals("Stop")) {
            this.mAnimFrame.ControlMessage(1, 0.0);
         }
      }

      return true;
   }

   public void run() {
      Date ddd = new Date();
      long thisTime = ddd.getTime();

      while (true) {
         try {
            Thread.sleep(20L);
         } catch (InterruptedException var8) {
            return;
         }

         ddd = new Date();
         long lastTime = thisTime;
         thisTime = ddd.getTime();
         double realSeconds = (thisTime - lastTime) / 1000.0;
         this.mAnimFrame.ControlMessage(0, realSeconds);
      }
   }

   public double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return new String("0");
      } else if (arg < 0.0) {
         return new String("-" + this.nns(-arg, sig));
      } else {
         double oom = Math.floor(this.log10(arg));
         double power = Math.pow(10.0, oom - sig + 1.0);
         long intArg = Math.round(arg / power);
         String result = new String(String.valueOf(intArg * power));

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int lastChar;
            for (lastChar = result.length() - 1; result.charAt(lastChar) == '0'; trimmed = true) {
               lastChar--;
            }

            if (trimmed) {
               result = new String(result.substring(0, lastChar + 1));
            }

            String shortStr = new String(result.substring(0, lastChar));

            double newNum;
            try {
               newNum = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(arg - newNum) > power) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void stop() {
      this.mThread.stop();
      this.mThread = null;
   }
}

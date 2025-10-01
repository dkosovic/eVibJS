package Modal.Prog7.Eigen2DOF;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CFrameSmallControl extends CFramePicture implements ActionListener, KeyListener {
   public CFrame mControlledFrame;
   int mSelection;
   int mCode;
   Date mSelStart;
   public double mMin;
   public double mValue;
   public double mMax;
   public double mOldValue;
   public double mDeltaPerSec;
   public Point mDLabelPos;
   public String mUnits;
   int mLabelWidth;
   int mLabelHeight;
   JTextField mTextField;
   public boolean mTextEditable;
   public boolean mIntegerMode;
   Timer mTimer;
   static final int kNoSelection = 0;
   static final int kUpSelection = 1;
   static final int kDownSelection = 2;
   static final int kTextSelection = 3;
   static final double kNearlyZero = 1.0E-10;

   public CFrameSmallControl(CFramePanel thePanel, CFrame controlThis, int code, int xx, int yy, double min, double val, double max, String units) {
      super(thePanel, xx, yy, 0, 0, thePanel.mApplet.getImage(thePanel.mApplet.getCodeBase(), "BrianControl.gif"), false);
      this.mControlledFrame = controlThis;
      this.mCode = code;
      this.mUnits = units;
      super.width = super.mImage.getWidth(thePanel);
      super.height = super.mImage.getHeight(thePanel);
      this.mMin = min;
      this.mValue = val;
      this.mMax = max;

      // Register modern mouse event listeners for direct, responsive mouse handling
      thePanel.addMouseListener(this);

      this.BroadcastValue();
   }

   public void SetLabelOffset(int dx, int dy) {
      this.mDLabelPos = new Point(dx, dy);
      this.repaint();
   }

   public void SetTextEditable(boolean editable) {
      this.mTextEditable = editable;
   }

   public void SetIntegerMode(boolean intmode) {
      this.mIntegerMode = intmode;
      this.ConstrainValue();
      this.BroadcastValue();
   }

   public void keyPressed(KeyEvent evt) {
      if (evt.getKeyCode() == 10) {
         String text = this.mTextField.getText();
         int end = text.length();

         while (true) {
            String numStr = text.substring(0, end);

            try {
               double newVal = java.lang.Double.parseDouble(numStr);
               this.mValue = newVal;
               break;
            } catch (NumberFormatException var6) {
               if (--end <= 0) {
                  return;
               }
            }
         }

         this.ConstrainValue();
         this.mTextField.removeKeyListener(this);
         super.mFramePanel.remove(this.mTextField);
         this.mTextField = null;
         this.BroadcastValue();
      }
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }

   public Rectangle GridToRect(int which) {
      super.width = super.mImage.getWidth(super.mFramePanel);
      super.height = super.mImage.getHeight(super.mFramePanel);
      if (super.width >= 0 && super.height >= 0) {
         switch (which) {
            case 1:
               return new Rectangle(0, 0, super.width, super.height / 2);
            case 2:
               return new Rectangle(0, super.height / 2, super.width, super.height / 2);
            case 3:
               if (this.mDLabelPos == null) {
                  return null;
               }

               return new Rectangle(this.mDLabelPos.x, this.mDLabelPos.y - this.mLabelHeight, this.mLabelWidth, this.mLabelHeight);
            default:
               return null;
         }
      } else {
         return null;
      }
   }

   public int GetSelection(Point p) {
      for (int i = 1; i <= 3; i++) {
         Rectangle r = this.GridToRect(i);
         if (r == null) {
            return 0;
         }

         if (r.contains(p.x, p.y)) {
            return i;
         }
      }

      return 0;
   }

   public int GetSelection(int xx, int yy) {
      Point p = new Point(xx, yy);
      return this.GetSelection(p);
   }

   public static boolean NearlyEqual(double d1, double d2) {
      return Math.abs(d2 - d1) < 1.0E-10;
   }

   public static String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (NearlyEqual(arg, 0.0)) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + nns(-arg, sig);
      } else {
         double oom = Math.floor(log10(arg));
         double power = Math.pow(10.0, oom - sig + 1.0);
         long intArg = Math.round(arg / power);
         String result = String.valueOf(intArg * power);

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int lastChar;
            for (lastChar = result.length() - 1; result.charAt(lastChar) == '0'; trimmed = true) {
               lastChar--;
            }

            if (trimmed) {
               result = result.substring(0, lastChar + 1);
            }

            String shortStr = result.substring(0, lastChar);

            double newNum;
            try {
               newNum = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException var14) {
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

   public static String nns(double arg) {
      return nns(arg, 4);
   }

   public static double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public void NewSelection(int newSel) {
      this.mSelection = newSel;
      this.mSelStart = new Date();
      this.mOldValue = this.mValue;
      switch (this.mSelection) {
         case 0:
         case 3:
            this.mDeltaPerSec = 0.0;
            break;
         case 1:
         case 2:
         default:
            double oom = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
            this.mDeltaPerSec = Math.pow(10.0, oom - 2.0);
            if (this.mSelection == 2) {
               this.mDeltaPerSec = -this.mDeltaPerSec;
            }

            this.NewValue();
      }

      this.repaint();
   }

   void NewValue() {
      if (this.mSelStart != null) {
         long startTime = this.mSelStart.getTime();
         Date nowDate = new Date();
         long nowTime = nowDate.getTime();
         double dT = (nowTime - startTime) / 1000.0;
         boolean turbo = dT > 1.0;
         double delta;
         double quant;
         if (this.mIntegerMode) {
            if (this.mDeltaPerSec > 0.0) {
               delta = 1.0;
            } else {
               delta = -1.0;
            }

            quant = 1.0;
         } else if (turbo) {
            delta = this.mDeltaPerSec * 10.0 * dT;
            quant = this.mDeltaPerSec;
         } else {
            delta = this.mDeltaPerSec * dT;
            quant = this.mDeltaPerSec / 10.0;
         }

         this.mValue = this.mOldValue + delta;
         this.mValue = MyRound(this.mValue, quant);
         this.ConstrainValue();
         this.BroadcastValue();
      }
   }

   public static double MyRound(double val, double quant) {
      if (quant == 0.0) {
         return val;
      } else {
         quant = Math.abs(quant);
         return Math.round(val / quant) * quant;
      }
   }

   void ConstrainValue() {
      if (this.mIntegerMode) {
         this.mValue = Math.round(this.mValue);
      }

      if (this.mValue < this.mMin) {
         this.mValue = this.mMin;
      } else if (this.mMax < this.mValue) {
         this.mValue = this.mMax;
      }
   }

   void BroadcastValue() {
      if (this.mControlledFrame != null) {
         this.mControlledFrame.ControlMessage(this, this.mCode, this.mValue);
      }

      this.repaint();
   }

   // Modern mouse event handling methods for direct, responsive interaction
   @Override
   public void mousePressed(MouseEvent e) {
      // Check if the click is within this control's bounds
      if (e.getX() >= super.x && e.getX() < super.x + super.width &&
          e.getY() >= super.y && e.getY() < super.y + super.height) {
         Point localPt = new Point(e.getX() - super.x, e.getY() - super.y);
         this.NewSelection(this.GetSelection(localPt.x, localPt.y));
         if (this.mSelection == 3 && this.mTextField == null) {
            if (this.mTextEditable) {
               this.mTextField = new JTextField();
               super.mFramePanel.add(this.mTextField);
               this.mTextField.addKeyListener(this);
               Insets insets = super.mFramePanel.getInsets();
               this.mTextField.setBounds(insets.left + super.x + this.mDLabelPos.x, insets.top + super.y - 2, this.mLabelWidth + 8, 20);
               this.mTextField.setText(this.GetLabelString());
            } else {
               this.mTextField = null;
            }
            this.BroadcastValue();
         } else {
            this.mTimer = new Timer(100, this);
            this.mTimer.start();
         }
      }
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      if (this.mSelection != 0) {
         this.NewSelection(0);
      }
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // Handle mouse clicks if needed
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // Handle mouse enter events if needed
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // Handle mouse exit events if needed
   }

   public void Frame(Graphics var1) {
      super.Frame(var1);
      Rectangle var2 = this.LocalToGlobalR(this.GridToRect(2));
      if (this.mSelection != 0) {
         Rectangle var3 = this.LocalToGlobalR(this.GridToRect(this.mSelection));
         var1.setXORMode(Color.black);
         var1.fillRect(var3.x, var3.y, var3.width, var3.height);
         var1.setPaintMode();
      }

      this.FrameValue(var1);
      super.width = var2.x + var2.width + this.mLabelWidth;
      super.height = var2.y + var2.height;
   }

   public String GetLabelString() {
      return nns(this.mValue) + " " + this.mUnits;
   }

   public void FrameValue(Graphics var1) {
      this.mLabelWidth = 0;
      this.mLabelHeight = 0;
      if (this.mDLabelPos != null) {
         Rectangle var2 = this.GridToRect(3);
         if (var2 != null) {
            Point var3 = new Point(var2.x, var2.y);
            Point var4 = this.LocalToGlobal(var3);
            var2.x = var4.x;
            var2.y = var4.y;
            var1.setColor(CUtility.RatColor(Color.black, Color.white, 0.6));
            if (this.mSelection == 3) {
               var1.fillRect(var2.x, var2.y, var2.width, var2.height);
            } else {
               var1.drawRect(var2.x, var2.y, var2.width, var2.height);
            }

            Point var5 = this.LocalToGlobal(this.mDLabelPos);
            var1.setColor(Color.black);
            String var6 = this.GetLabelString();
            this.mLabelWidth = CUtility.DrawString(var1, var6, var5.x, var5.y) - var5.x;
            this.mLabelHeight = 12;
            var1.setColor(Color.black);
         }
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mSelection != 0) {
         this.NewValue();
      }
   }
}

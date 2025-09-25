package OneDOF.Prog6.Forcedresponse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
   TextField mTextField;
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
      this.mUnits = new String(units);
      super.width = super.mImage.getWidth(thePanel);
      super.height = super.mImage.getHeight(thePanel);
      this.mMin = min;
      this.mValue = val;
      this.mMax = max;
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

   public void keyTyped(KeyEvent evt) {
   }

   public void keyReleased(KeyEvent evt) {
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
         return new String("0");
      } else if (arg < 0.0) {
         return new String("-" + nns(-arg, sig));
      } else {
         double oom = Math.floor(log10(arg));
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

   public boolean MouseEvent(int code, boolean prevHit) {
      super.MouseEvent(code, prevHit);
      Point thisPt = this.GlobalToLocal(super.mFramePanel.mThisPt);
      switch (code) {
         case 0:
            if (!super.mWasHit) {
               return false;
            } else if (prevHit) {
               return false;
            } else {
               this.NewSelection(this.GetSelection(thisPt.x, thisPt.y));
               if (this.mSelection == 3 && this.mTextField == null) {
                  if (this.mTextEditable) {
                     this.mTextField = new TextField();
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

               return true;
            }
         case 1:
            if (!super.mWasHit) {
               this.NewSelection(0);
               return true;
            } else if (this.mSelection == 0) {
               return false;
            } else {
               int newSel = this.GetSelection(thisPt.x, thisPt.y);
               if (newSel == this.mSelection) {
                  return false;
               }

               this.NewSelection(newSel);
               return true;
            }
         case 2:
            this.NewSelection(0);
            return true;
         default:
            return false;
      }
   }

   public void Frame(Graphics g) {
      super.Frame(g);
      Rectangle downRect = this.LocalToGlobalR(this.GridToRect(2));
      if (this.mSelection != 0) {
         Rectangle selRect = this.LocalToGlobalR(this.GridToRect(this.mSelection));
         g.setXORMode(Color.black);
         g.fillRect(selRect.x, selRect.y, selRect.width, selRect.height);
         g.setPaintMode();
      }

      this.FrameValue(g);
      super.width = downRect.x + downRect.width + this.mLabelWidth;
      super.height = downRect.y + downRect.height;
   }

   public String GetLabelString() {
      return new String(nns(this.mValue) + " " + this.mUnits);
   }

   public void FrameValue(Graphics g) {
      this.mLabelWidth = 0;
      this.mLabelHeight = 0;
      if (this.mDLabelPos != null) {
         Rectangle r = this.GridToRect(3);
         if (r != null) {
            Point localPt = new Point(r.x, r.y);
            Point absPt = this.LocalToGlobal(localPt);
            r.x = absPt.x;
            r.y = absPt.y;
            g.setColor(CUtility.RatColor(Color.black, Color.white, 0.6));
            if (this.mSelection == 3) {
               g.fillRect(r.x, r.y, r.width, r.height);
            } else {
               g.drawRect(r.x, r.y, r.width, r.height);
            }

            Point absPos = this.LocalToGlobal(this.mDLabelPos);
            g.setColor(Color.black);
            String lab_str = this.GetLabelString();
            this.mLabelWidth = CUtility.DrawString(g, lab_str, absPos.x, absPos.y) - absPos.x;
            this.mLabelHeight = 12;
            g.setColor(Color.black);
         }
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (this.mSelection != 0) {
         this.NewValue();
      }
   }
}

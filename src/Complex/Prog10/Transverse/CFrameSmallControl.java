package Complex.Prog10.Transverse;

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
      this.mUnits = units;
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
         String var2 = this.mTextField.getText();
         int var3 = var2.length();

         while (true) {
            String var4 = var2.substring(0, var3);

            try {
               double var5 = java.lang.Double.parseDouble(var4);
               this.mValue = var5;
               break;
            } catch (NumberFormatException ex) {
               if (--var3 <= 0) {
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
         Rectangle selectionRect = this.GridToRect(i);
         if (selectionRect == null) {
            return 0;
         }

         if (selectionRect.contains(p.x, p.y)) {
            return i;
         }
      }

      return 0;
   }

   public int GetSelection(int xx, int yy) {
      Point point = new Point(xx, yy);
      return this.GetSelection(point);
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
         double magnitude = Math.floor(log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long var7 = Math.round(arg / stepSize);
         String var9 = String.valueOf(var7 * stepSize);

         while (var9.length() > 1 && var9.indexOf(46) > -1) {
            boolean var10 = false;

            int var11;
            for (var11 = var9.length() - 1; var9.charAt(var11) == '0'; var10 = true) {
               var11--;
            }

            if (var10) {
               var9 = var9.substring(0, var11 + 1);
            }

            String var12 = var9.substring(0, var11);

            double var13;
            try {
               var13 = java.lang.Double.parseDouble(var12);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - var13) > stepSize) {
               break;
            }

            var9 = var12;
         }

         return var9;
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
            double magnitude = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
            this.mDeltaPerSec = Math.pow(10.0, magnitude - 2.0);
            if (this.mSelection == 2) {
               this.mDeltaPerSec = -this.mDeltaPerSec;
            }

            this.NewValue();
      }

      this.repaint();
   }

   void NewValue() {
      if (this.mSelStart != null) {
         long var1 = this.mSelStart.getTime();
         Date now = new Date();
         long currentTime = now.getTime();
         double elapsedSeconds = (currentTime - var1) / 1000.0;
         boolean var8 = elapsedSeconds > 1.0;
         double var9;
         double var11;
         if (this.mIntegerMode) {
            if (this.mDeltaPerSec > 0.0) {
               var9 = 1.0;
            } else {
               var9 = -1.0;
            }

            var11 = 1.0;
         } else if (var8) {
            var9 = this.mDeltaPerSec * 10.0 * elapsedSeconds;
            var11 = this.mDeltaPerSec;
         } else {
            var9 = this.mDeltaPerSec * elapsedSeconds;
            var11 = this.mDeltaPerSec / 10.0;
         }

         this.mValue = this.mOldValue + var9;
         this.mValue = MyRound(this.mValue, var11);
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
      Point localPoint = this.GlobalToLocal(super.mFramePanel.mThisPt);
      switch (code) {
         case 0:
            if (!super.mWasHit) {
               return false;
            } else if (prevHit) {
               return false;
            } else {
               this.NewSelection(this.GetSelection(localPoint.x, localPoint.y));
               if (this.mSelection == 3 && this.mTextField == null) {
                  if (this.mTextEditable) {
                     this.mTextField = new TextField();
                     super.mFramePanel.add(this.mTextField);
                     this.mTextField.addKeyListener(this);
                     Insets var5 = super.mFramePanel.getInsets();
                     this.mTextField.setBounds(var5.left + super.x + this.mDLabelPos.x, var5.top + super.y - 2, this.mLabelWidth + 8, 20);
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
               int var4 = this.GetSelection(localPoint.x, localPoint.y);
               if (var4 == this.mSelection) {
                  return false;
               }

               this.NewSelection(var4);
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
      Rectangle globalRect = this.LocalToGlobalR(this.GridToRect(2));
      if (this.mSelection != 0) {
         Rectangle var3 = this.LocalToGlobalR(this.GridToRect(this.mSelection));
         g.setXORMode(Color.black);
         g.fillRect(var3.x, var3.y, var3.width, var3.height);
         g.setPaintMode();
      }

      this.FrameValue(g);
      super.width = globalRect.x + globalRect.width + this.mLabelWidth;
      super.height = globalRect.y + globalRect.height;
   }

   public String GetLabelString() {
      return nns(this.mValue) + " " + this.mUnits;
   }

   public void FrameValue(Graphics g) {
      this.mLabelWidth = 0;
      this.mLabelHeight = 0;
      if (this.mDLabelPos != null) {
         Rectangle selectionRect = this.GridToRect(3);
         if (selectionRect != null) {
            Point point = new Point(selectionRect.x, selectionRect.y);
            Point globalPoint = this.LocalToGlobal(point);
            selectionRect.x = globalPoint.x;
            selectionRect.y = globalPoint.y;
            g.setColor(CUtility.RatColor(Color.black, Color.white, 0.6));
            if (this.mSelection == 3) {
               g.fillRect(selectionRect.x, selectionRect.y, selectionRect.width, selectionRect.height);
            } else {
               g.drawRect(selectionRect.x, selectionRect.y, selectionRect.width, selectionRect.height);
            }

            Point var5 = this.LocalToGlobal(this.mDLabelPos);
            g.setColor(Color.black);
            String var6 = this.GetLabelString();
            this.mLabelWidth = CUtility.DrawString(g, var6, var5.x, var5.y) - var5.x;
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

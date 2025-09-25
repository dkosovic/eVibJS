package Modal.Prog6.Qfactor;

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

   public CFrameSmallControl(CFramePanel var1, CFrame var2, int var3, int var4, int var5, double var6, double var8, double var10, String var12) {
      super(var1, var4, var5, 0, 0, var1.mApplet.getImage(var1.mApplet.getCodeBase(), "BrianControl.gif"), false);
      this.mControlledFrame = var2;
      this.mCode = var3;
      this.mUnits = new String(var12);
      super.width = super.mImage.getWidth(var1);
      super.height = super.mImage.getHeight(var1);
      this.mMin = var6;
      this.mValue = var8;
      this.mMax = var10;
      this.BroadcastValue();
   }

   public void SetLabelOffset(int var1, int var2) {
      this.mDLabelPos = new Point(var1, var2);
      this.repaint();
   }

   public void SetTextEditable(boolean var1) {
      this.mTextEditable = var1;
   }

   public void SetIntegerMode(boolean var1) {
      this.mIntegerMode = var1;
      this.ConstrainValue();
      this.BroadcastValue();
   }

   public void keyPressed(KeyEvent var1) {
      if (var1.getKeyCode() == 10) {
         String var2 = this.mTextField.getText();
         int var3 = var2.length();

         while (true) {
            String var4 = var2.substring(0, var3);

            try {
               double var5 = java.lang.Double.parseDouble(var4);
               this.mValue = var5;
               break;
            } catch (NumberFormatException var6) {
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

   public void keyTyped(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }

   public Rectangle GridToRect(int var1) {
      super.width = super.mImage.getWidth(super.mFramePanel);
      super.height = super.mImage.getHeight(super.mFramePanel);
      if (super.width >= 0 && super.height >= 0) {
         switch (var1) {
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

   public int GetSelection(Point var1) {
      for (int var2 = 1; var2 <= 3; var2++) {
         Rectangle var3 = this.GridToRect(var2);
         if (var3 == null) {
            return 0;
         }

         if (var3.contains(var1.x, var1.y)) {
            return var2;
         }
      }

      return 0;
   }

   public int GetSelection(int var1, int var2) {
      Point var3 = new Point(var1, var2);
      return this.GetSelection(var3);
   }

   public static boolean NearlyEqual(double var0, double var2) {
      return Math.abs(var2 - var0) < 1.0E-10;
   }

   public static String nns(double var0, int var2) {
      if (var2 <= 0) {
         var2 = 1;
      }

      if (NearlyEqual(var0, 0.0)) {
         return new String("0");
      } else if (var0 < 0.0) {
         return new String("-" + nns(-var0, var2));
      } else {
         double var3 = Math.floor(log10(var0));
         double var5 = Math.pow(10.0, var3 - var2 + 1.0);
         long var7 = Math.round(var0 / var5);
         String var9 = new String(String.valueOf(var7 * var5));

         while (var9.length() > 1 && var9.indexOf(46) > -1) {
            boolean var10 = false;

            int var11;
            for (var11 = var9.length() - 1; var9.charAt(var11) == '0'; var10 = true) {
               var11--;
            }

            if (var10) {
               var9 = new String(var9.substring(0, var11 + 1));
            }

            String var12 = new String(var9.substring(0, var11));

            double var13;
            try {
               var13 = java.lang.Double.parseDouble(var12);
            } catch (NumberFormatException var14) {
               break;
            }

            if (Math.abs(var0 - var13) > var5) {
               break;
            }

            var9 = var12;
         }

         return var9;
      }
   }

   public static String nns(double var0) {
      return nns(var0, 4);
   }

   public static double log10(double var0) {
      return Math.log(var0) / Math.log(10.0);
   }

   public void NewSelection(int var1) {
      this.mSelection = var1;
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
            double var2 = Math.floor(log10(Math.abs(this.mMax - this.mMin)));
            this.mDeltaPerSec = Math.pow(10.0, var2 - 2.0);
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
         Date var3 = new Date();
         long var4 = var3.getTime();
         double var6 = (var4 - var1) / 1000.0;
         boolean var8 = var6 > 1.0;
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
            var9 = this.mDeltaPerSec * 10.0 * var6;
            var11 = this.mDeltaPerSec;
         } else {
            var9 = this.mDeltaPerSec * var6;
            var11 = this.mDeltaPerSec / 10.0;
         }

         this.mValue = this.mOldValue + var9;
         this.mValue = MyRound(this.mValue, var11);
         this.ConstrainValue();
         this.BroadcastValue();
      }
   }

   public static double MyRound(double var0, double var2) {
      if (var2 == 0.0) {
         return var0;
      } else {
         var2 = Math.abs(var2);
         return Math.round(var0 / var2) * var2;
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

   public boolean MouseEvent(int var1, boolean var2) {
      super.MouseEvent(var1, var2);
      Point var3 = this.GlobalToLocal(super.mFramePanel.mThisPt);
      switch (var1) {
         case 0:
            if (!super.mWasHit) {
               return false;
            } else if (var2) {
               return false;
            } else {
               this.NewSelection(this.GetSelection(var3.x, var3.y));
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
               int var4 = this.GetSelection(var3.x, var3.y);
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
      return new String(nns(this.mValue) + " " + this.mUnits);
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

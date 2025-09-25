package Complex.Prog5.Multiforced;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

@SuppressWarnings("serial")
class CInputDialog extends Frame {
   public CSpringMassDamper mSMD;
   CheckboxGroup mViscCheckboxGroup;
   TextField mDampingText;
   TextField mMassText;
   TextField mSpringText;
   Label mDampingUnitLabel;
   Checkbox mAbutmentCheckbox;
   Panel mMassPanel;
   Panel mSpringPanel;
   Panel mDampingPanel;

   public CInputDialog(CSpringMassDamper var1, String var2) {
      super(var2);
      this.mSMD = var1;
      this.setLayout(new BorderLayout());
      Panel var3 = new Panel();
      this.add("South", var3);
      Button var4 = new Button("OK");
      var3.add(var4);
      Button var5 = new Button("Cancel");
      var3.add(var5);
      Panel var6 = new Panel();
      var6.setLayout(new GridLayout(0, 1));
      this.add("North", var6);
      Panel var7 = new Panel();
      var7.setLayout(new GridLayout(0, 1));
      var6.add(var7);
      this.mMassPanel = new Panel();
      var7.add(this.mMassPanel);
      this.mMassPanel.add(new Label("Mass:"));
      this.mMassText = new TextField(String.valueOf(var1.mMass), 10);
      this.mMassPanel.add(this.mMassText);
      this.mMassPanel.add(new Label("kg"));
      Panel var8 = new Panel();
      var8.setLayout(new GridLayout(0, 1));
      var6.add(var8);
      Panel var9 = new Panel();
      var9.setLayout(new GridLayout(0, 1));
      var6.add(var9);
      if (var1.mIndex > 1) {
         this.mSpringPanel = new Panel();
         var8.add(this.mSpringPanel);
         this.mSpringPanel.add(new Label("Spring:"));
         this.mSpringText = new TextField(String.valueOf(var1.mSpringConstant), 10);
         this.mSpringPanel.add(this.mSpringText);
         this.mSpringPanel.add(new Label("N/m"));
         this.mDampingPanel = new Panel();
         var9.add(this.mDampingPanel);
         this.mDampingPanel.add(new Label("Damper:"));
         this.mDampingText = new TextField(String.valueOf(var1.mDampingConstant), 10);
         this.mDampingPanel.add(this.mDampingText);
         this.mDampingPanel.add(new Label("Ns/m"));
      }
   }

   public void SetViscousState(boolean var1) {
      if (this.mDampingUnitLabel != null) {
         if (var1) {
            this.mDampingUnitLabel.setText("Ns/m");
         } else {
            this.mDampingUnitLabel.setText("N/m");
         }
      }
   }

   public void SetAbutmentState(boolean var1) {
      if (var1) {
         this.mMassPanel.setVisible(false);
      } else {
         this.mMassPanel.setVisible(true);
      }

      this.validate();
      this.repaint();
   }

   public boolean action(Event var1, Object var2) {
      if (var1.target instanceof Button) {
         if (var2.equals("OK")) {
            if (this.mDampingText != null) {
               try {
                  double var3 = java.lang.Double.parseDouble(this.mDampingText.getText());
                  if (var3 >= 0.0) {
                     this.mSMD.mDampingConstant = var3;
                  }
               } catch (NumberFormatException var6) {
               }
            }

            if (this.mSpringText != null) {
               try {
                  double var7 = java.lang.Double.parseDouble(this.mSpringText.getText());
                  if (var7 > 0.0) {
                     this.mSMD.mSpringConstant = var7;
                  }
               } catch (NumberFormatException var5) {
               }
            }

            try {
               double var8 = java.lang.Double.parseDouble(this.mMassText.getText());
               if (var8 > 0.0) {
                  this.mSMD.mMass = var8;
               }
            } catch (NumberFormatException var4) {
            }

            this.mSMD.ControlMessage(null, 6, 0.0);
            this.dispose();
         } else if (var2.equals("Cancel")) {
            this.dispose();
         }
      }

      return true;
   }
}

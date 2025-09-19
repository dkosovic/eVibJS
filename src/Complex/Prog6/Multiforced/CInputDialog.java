package Complex.Prog6.Multiforced;

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

class CInputDialog extends Frame {
   public static final String kAbutmentLabel = "Abutment";
   public static final String kViscousDampingLabel = "Viscous";
   public static final String kHystereticDampingLabel = "Hysteretic";
   public CSpringMassDamper mSMD;
   CheckboxGroup mViscCheckboxGroup;
   TextField mDampingText;
   TextField mMassText;
   TextField mSpringText;
   Label mDampingUnitLabel;
   Checkbox mAbutmentCheckbox;
   Panel mMassPanel;

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
      var7.setLayout(new GridLayout(0, 2));
      var6.add(var7);
      this.mAbutmentCheckbox = new Checkbox("Abutment");
      this.mAbutmentCheckbox.setState(var1.IsAbutment());
      var7.add(this.mAbutmentCheckbox);
      if (!var1.AtEnd()) {
         this.mAbutmentCheckbox.setEnabled(false);
      }

      this.mMassPanel = new Panel();
      var7.add(this.mMassPanel);
      this.mMassPanel.add(new Label("Mass:"));
      this.mMassText = new TextField(String.valueOf(var1.mMass), 10);
      this.mMassPanel.add(this.mMassText);
      this.mMassPanel.add(new Label("kg"));
      if (var1.mIndex > 1) {
         Panel var8 = new Panel();
         var8.setLayout(new GridLayout(0, 3));
         var6.add(var8);
         var8.add(new Label("Spring constant:"));
         this.mSpringText = new TextField(String.valueOf(var1.mSpringConstant), 10);
         var8.add(this.mSpringText);
         var8.add(new Label("N/m"));
         var8.add(new Label("Damping constant:"));
         this.mDampingText = new TextField(String.valueOf(var1.mDampingConstant), 10);
         var8.add(this.mDampingText);
         this.mDampingUnitLabel = new Label("units not set");
         var8.add(this.mDampingUnitLabel);
         this.mViscCheckboxGroup = new CheckboxGroup();
         var8.add(new Label("Damping type:"));
         Checkbox var9 = new Checkbox("Viscous");
         var8.add(var9);
         var9.setCheckboxGroup(this.mViscCheckboxGroup);
         Checkbox var10 = new Checkbox("Hysteretic");
         var8.add(var10);
         var10.setCheckboxGroup(this.mViscCheckboxGroup);
         var9.setState(var1.mViscous);
         var10.setState(var1.mViscous ^ true);
      }

      this.SetViscousState(var1.mViscous);
      this.SetAbutmentState(var1.IsAbutment());
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
            if (this.mViscCheckboxGroup != null) {
               Checkbox var3 = this.mViscCheckboxGroup.getSelectedCheckbox();
               String var4 = var3.getLabel();
               this.mSMD.mViscous = var4 == "Viscous";
            }

            if (this.mDampingText != null) {
               try {
                  double var8 = java.lang.Double.parseDouble(this.mDampingText.getText());
                  if (var8 >= 0.0) {
                     this.mSMD.mDampingConstant = var8;
                  }
               } catch (NumberFormatException var7) {
               }
            }

            if (this.mSpringText != null) {
               try {
                  double var9 = java.lang.Double.parseDouble(this.mSpringText.getText());
                  if (var9 > 0.0) {
                     this.mSMD.mSpringConstant = var9;
                  }
               } catch (NumberFormatException var6) {
               }
            }

            try {
               double var10 = java.lang.Double.parseDouble(this.mMassText.getText());
               if (var10 > 0.0) {
                  this.mSMD.mMass = var10;
               }
            } catch (NumberFormatException var5) {
            }

            this.mSMD.SetAbutment(this.mAbutmentCheckbox.getState());
            this.mSMD.ControlMessage(null, 6, 0.0);
            this.dispose();
         } else if (var2.equals("Cancel")) {
            this.dispose();
         }
      } else if (var1.target instanceof Checkbox) {
         Checkbox var11 = (Checkbox)var1.target;
         if (var11.getLabel() == "Viscous") {
            this.SetViscousState(true);
         } else if (var11.getLabel() == "Hysteretic") {
            this.SetViscousState(false);
         } else if (var11.getLabel() == "Abutment") {
            this.SetAbutmentState(var11.getState());
         }
      }

      return true;
   }
}

package Complex.Prog6.Multiforced;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class CInputDialog extends JFrame implements ActionListener, ItemListener {
   public static final String kAbutmentLabel = "Abutment";
   public static final String kViscousDampingLabel = "Viscous";
   public static final String kHystereticDampingLabel = "Hysteretic";
   public CSpringMassDamper mSMD;
   ButtonGroup mViscCheckboxGroup;
   JTextField mDampingText;
   JTextField mMassText;
   JTextField mSpringText;
   JLabel mDampingUnitLabel;
   JCheckBox mAbutmentCheckbox;
   JPanel mMassPanel;

   public CInputDialog(CSpringMassDamper var1, String var2) {
      super(var2);
      this.mSMD = var1;
      this.setLayout(new BorderLayout());
      JPanel var3 = new JPanel();
      this.add("South", var3);
      JButton var4 = new JButton("OK");
      var4.addActionListener(this);
      var3.add(var4);
      JButton var5 = new JButton("Cancel");
      var5.addActionListener(this);
      var3.add(var5);
      JPanel var6 = new JPanel();
      var6.setLayout(new GridLayout(0, 1));
      this.add("North", var6);
      JPanel var7 = new JPanel();
      var7.setLayout(new GridLayout(0, 2));
      var6.add(var7);
      this.mAbutmentCheckbox = new JCheckBox("Abutment");
      this.mAbutmentCheckbox.setSelected(var1.IsAbutment());
      this.mAbutmentCheckbox.addItemListener(this);
      var7.add(this.mAbutmentCheckbox);
      if (!var1.AtEnd()) {
         this.mAbutmentCheckbox.setEnabled(false);
      }

      this.mMassPanel = new JPanel();
      var7.add(this.mMassPanel);
      this.mMassPanel.add(new JLabel("Mass:"));
      this.mMassText = new JTextField(String.valueOf(var1.mMass), 10);
      this.mMassPanel.add(this.mMassText);
      this.mMassPanel.add(new JLabel("kg"));
      if (var1.mIndex > 1) {
         JPanel var8 = new JPanel();
         var8.setLayout(new GridLayout(0, 3));
         var6.add(var8);
         var8.add(new JLabel("Spring constant:"));
         this.mSpringText = new JTextField(String.valueOf(var1.mSpringConstant), 10);
         var8.add(this.mSpringText);
         var8.add(new JLabel("N/m"));
         var8.add(new JLabel("Damping constant:"));
         this.mDampingText = new JTextField(String.valueOf(var1.mDampingConstant), 10);
         var8.add(this.mDampingText);
         this.mDampingUnitLabel = new JLabel("units not set");
         var8.add(this.mDampingUnitLabel);
         this.mViscCheckboxGroup = new ButtonGroup();
         var8.add(new JLabel("Damping type:"));
         JCheckBox var9 = new JCheckBox("Viscous");
         var8.add(var9);
         this.mViscCheckboxGroup.add(var9);
         var9.addItemListener(this);
         JCheckBox var10 = new JCheckBox("Hysteretic");
         var8.add(var10);
         this.mViscCheckboxGroup.add(var10);
         var10.addItemListener(this);
         var9.setSelected(var1.mViscous);
         var10.setSelected(var1.mViscous ^ true);
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

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() instanceof JButton) {
         JButton source = (JButton) e.getSource();
         String label = source.getText();
         if (label.equals("OK")) {
            if (this.mViscCheckboxGroup != null) {
               JCheckBox var3 = this.getSelectedCheckboxFromGroup(mViscCheckboxGroup);
               String var4 = var3.getText();
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

            this.mSMD.SetAbutment(this.mAbutmentCheckbox.isSelected());
            this.mSMD.ControlMessage(null, 6, 0.0);
            this.dispose();
         } else if (label.equals("Cancel")) {
            this.dispose();
         }
      }
   }

   public void itemStateChanged(ItemEvent e) {
      if (e.getSource() instanceof JCheckBox) {
         JCheckBox checkbox = (JCheckBox) e.getSource();
         String label = checkbox.getText();
         if (label.equals("Viscous")) {
            this.SetViscousState(true);
         } else if (label.equals("Hysteretic")) {
            this.SetViscousState(false);
         } else if (label.equals("Abutment")) {
            this.SetAbutmentState(checkbox.isSelected());
         }
      }
   }

    /**
     * Helper method to get selected checkbox from ButtonGroup
     * (ButtonGroup doesn't have direct equivalent to AWT getSelectedCheckboxFromGroup(CheckboxGroup))
     */
    private JCheckBox getSelectedCheckboxFromGroup(ButtonGroup group) {
        for (AbstractButton button : java.util.Collections.list(group.getElements())) {
            if (button.getModel() == group.getSelection()) {
                return (JCheckBox) button;
            }
        }
        return null;
    }
}

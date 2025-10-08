package Complex.Prog5.Multiforced;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class CInputDialog extends JFrame implements ActionListener {
   public CSpringMassDamper mSMD;
   ButtonGroup mViscCheckboxGroup;
   JTextField mDampingText;
   JTextField mMassText;
   JTextField mSpringText;
   JLabel mDampingUnitLabel;
   JCheckBox mAbutmentCheckbox;
   JPanel mMassPanel;
   JPanel mSpringPanel;
   JPanel mDampingPanel;

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
      var7.setLayout(new GridLayout(0, 1));
      var6.add(var7);
      this.mMassPanel = new JPanel();
      var7.add(this.mMassPanel);
      this.mMassPanel.add(new JLabel("Mass:"));
      this.mMassText = new JTextField(String.valueOf(var1.mMass), 10);
      this.mMassPanel.add(this.mMassText);
      this.mMassPanel.add(new JLabel("kg"));
      JPanel var8 = new JPanel();
      var8.setLayout(new GridLayout(0, 1));
      var6.add(var8);
      JPanel var9 = new JPanel();
      var9.setLayout(new GridLayout(0, 1));
      var6.add(var9);
      if (var1.mIndex > 1) {
         this.mSpringPanel = new JPanel();
         var8.add(this.mSpringPanel);
         this.mSpringPanel.add(new JLabel("Spring:"));
         this.mSpringText = new JTextField(String.valueOf(var1.mSpringConstant), 10);
         this.mSpringPanel.add(this.mSpringText);
         this.mSpringPanel.add(new JLabel("N/m"));
         this.mDampingPanel = new JPanel();
         var9.add(this.mDampingPanel);
         this.mDampingPanel.add(new JLabel("Damper:"));
         this.mDampingText = new JTextField(String.valueOf(var1.mDampingConstant), 10);
         this.mDampingPanel.add(this.mDampingText);
         this.mDampingPanel.add(new JLabel("Ns/m"));
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

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() instanceof JButton) {
         JButton source = (JButton) e.getSource();
         String label = source.getText();
         if (label.equals("OK")) {
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
         } else if (label.equals("Cancel")) {
            this.dispose();
         }
      }
   }
}

package OneDOF.Prog8.OOB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class CBrianGroup extends JPanel {
   public CBrianControl mCBC;

   public CBrianGroup(JApplet var1, String var2, double var3, double var5, double var7) {
      this.setLayout(new BorderLayout());
      CMyLabel var9 = new CMyLabel(var1.getGraphics().getFontMetrics(), "xxxxxxxxx", 1);
      this.mCBC = new CBrianControl(var1, var9, var3, var5, var7);
      this.add("West", this.mCBC);
      Image var10 = var1.getImage(var1.getCodeBase(), var2);
      CPicturePanel var11 = new CPicturePanel(var10);
      JPanel var12 = new JPanel();
      var12.setLayout(new GridLayout(2, 0));
      this.add("Center", var12);
      JPanel var13 = new JPanel();
      var12.add(var13);
      var13.add(var11);
      var12.add(var9);
   }
}

package OneDOF.Prog12;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

@SuppressWarnings("serial")
class CBrianGroup extends Panel {
   public CBrianControl mCBC;

   public CBrianGroup(Applet app, String imgName, double min, double val, double max) {
      this.setLayout(new BorderLayout());
      CMyLabel var9 = new CMyLabel(app.getGraphics().getFontMetrics(), "xxxxxxxxx", 1);
      this.mCBC = new CBrianControl(app, var9, min, val, max);
      this.add("West", this.mCBC);
      Image var10 = app.getImage(app.getCodeBase(), imgName);
      CPicturePanel var11 = new CPicturePanel(var10);
      Panel var12 = new Panel();
      var12.setLayout(new GridLayout(2, 0));
      this.add("Center", var12);
      Panel var13 = new Panel();
      var12.add(var13);
      var13.add(var11);
      var12.add(var9);
   }
}

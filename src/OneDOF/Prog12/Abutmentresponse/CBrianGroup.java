package OneDOF.Prog12.Abutmentresponse;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

class CBrianGroup extends Panel {
   public CBrianControl mCBC;

   public CBrianGroup(Applet var1, String var2, double var3, double var5, double var7) {
      this.setLayout(new BorderLayout());
      CMyLabel var9 = new CMyLabel(var1.getGraphics().getFontMetrics(), "xxxxxxxxx", 1);
      this.mCBC = new CBrianControl(var1, var9, var3, var5, var7);
      this.add("West", this.mCBC);
      Image var10 = var1.getImage(var1.getCodeBase(), var2);
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

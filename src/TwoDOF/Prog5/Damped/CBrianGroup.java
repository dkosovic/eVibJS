package TwoDOF.Prog5.Damped;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

class CBrianGroup extends Panel {
   public CBrianControl mCBC;

   public CBrianGroup(Applet app, String imgName, double min, double val, double max) {
      this.setLayout(new BorderLayout());
      CMyLabel lab = new CMyLabel(app.getGraphics().getFontMetrics(), "xxxxxxxxx", 1);
      this.mCBC = new CBrianControl(app, lab, min, val, max);
      this.add("West", this.mCBC);
      Image img = app.getImage(app.getCodeBase(), imgName);
      CPicturePanel pic = new CPicturePanel(img);
      Panel grid = new Panel();
      grid.setLayout(new GridLayout(2, 0));
      this.add("Center", grid);
      Panel dum = new Panel();
      grid.add(dum);
      dum.add(pic);
      grid.add(lab);
   }
}

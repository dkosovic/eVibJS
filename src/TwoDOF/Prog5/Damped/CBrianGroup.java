package TwoDOF.Prog5.Damped;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class CBrianGroup extends JPanel {
   public CBrianControl mCBC;

   public CBrianGroup(JApplet app, String imgName, double min, double val, double max) {
      this.setLayout(new BorderLayout());
      CMyLabel lab = new CMyLabel(app.getGraphics().getFontMetrics(), "xxxxxxxxx", 1);
      this.mCBC = new CBrianControl(app, lab, min, val, max);
      this.add("West", this.mCBC);
      Image img = app.getImage(app.getCodeBase(), imgName);
      CPicturePanel pic = new CPicturePanel(img);
      JPanel grid = new JPanel();
      grid.setLayout(new GridLayout(2, 0));
      this.add("Center", grid);
      JPanel dum = new JPanel();
      grid.add(dum);
      dum.add(pic);
      grid.add(lab);
   }
}

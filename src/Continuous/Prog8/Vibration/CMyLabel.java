package Continuous.Prog8.Vibration;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Label;

class CMyLabel extends Label {
   int mPrefWidth;

   CMyLabel(String lab, int align, Graphics g) {
      super(lab, align);
      FontMetrics fm = g.getFontMetrics();
      this.mPrefWidth = fm.stringWidth(lab);
   }

   public Dimension preferredSize() {
      Dimension oldD = super.preferredSize();
      return new Dimension(this.mPrefWidth, oldD.height);
   }

   public Dimension minimumSize() {
      return this.preferredSize();
   }
}

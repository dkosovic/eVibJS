package OneDOF.Abutment.Abutment;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Label;

public class CMyLabel extends Label {
   Dimension mMinDim;

   public CMyLabel() {
      this.mMinDim = new Dimension(40, 16);
   }

   public CMyLabel(FontMetrics f, String s) {
      super(s);
      this.setMinDim(f, s);
   }

   public CMyLabel(FontMetrics f, String s, int align) {
      super(s, align);
      this.setMinDim(f, s);
   }

   void setMinDim(FontMetrics f, String s) {
      int w = 10 * f.stringWidth(s) / 9;
      int h = f.getMaxAscent() + f.getMaxDescent();
      this.mMinDim = new Dimension(w, h);
   }

   public Dimension minimumSize() {
      return new Dimension(this.mMinDim.width, this.mMinDim.height);
   }

   public Dimension preferredSize() {
      return this.minimumSize();
   }
}

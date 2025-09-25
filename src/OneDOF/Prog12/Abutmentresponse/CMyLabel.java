package OneDOF.Prog12.Abutmentresponse;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Label;

@SuppressWarnings("serial")
public class CMyLabel extends Label {
   Dimension mMinDim;

   public CMyLabel() {
      this.mMinDim = new Dimension(40, 16);
   }

   public CMyLabel(FontMetrics var1, String var2) {
      super(var2);
      this.setMinDim(var1, var2);
   }

   public CMyLabel(FontMetrics var1, String var2, int var3) {
      super(var2, var3);
      this.setMinDim(var1, var2);
   }

   void setMinDim(FontMetrics var1, String var2) {
      int var3 = 10 * var1.stringWidth(var2) / 9;
      int var4 = var1.getMaxAscent() + var1.getMaxDescent();
      this.mMinDim = new Dimension(var3, var4);
   }

   public Dimension minimumSize() {
      return new Dimension(this.mMinDim.width, this.mMinDim.height);
   }

   public Dimension preferredSize() {
      return this.minimumSize();
   }
}

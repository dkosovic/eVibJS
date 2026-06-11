package MultiDOF.Prog9.Multiforced;

import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   static final int kYanimate = 10;
   CFrameGraph mFrameGraph;

   public CFrameAnimation(CFramePanel thePanel, CFrameGraph theGraph, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mFrameGraph = theGraph;
   }

   public void Frame(Graphics g) {
      this.mFrameGraph.DrawModeShape(g, super.x, super.y);
   }
}

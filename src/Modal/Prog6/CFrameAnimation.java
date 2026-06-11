package Modal.Prog6.Qfactor;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   static final int kYanimate = 10;
   CFrameGraph mFrameGraph;

   public CFrameAnimation(CFramePanel thePanel, CFrameGraph theGraph, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
      this.mFrameGraph = theGraph;
   }
}

package Complex.Prog5.Multiforced;

import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameAnimation extends CFrame {
   static final int kYanimate = 10;
   CFrameGraph mFrameGraph;

   public CFrameAnimation(CFramePanel var1, CFrameGraph var2, int var3, int var4, int var5, int var6) {
      super(var1, var3, var4, var5, var6);
      this.mFrameGraph = var2;
   }

   public void Frame(Graphics var1) {
      this.mFrameGraph.DrawModeShape(var1, super.x, super.y);
   }
}

package Continuous.Prog2.Multiforced;

class CFrameAnimation extends CFrame {
   static final int kYanimate = 10;
   CFrameGraph mFrameGraph;

   public CFrameAnimation(CFramePanel var1, CFrameGraph var2, int var3, int var4, int var5, int var6) {
      super(var1, var3, var4, var5, var6);
      this.mFrameGraph = var2;
   }
}

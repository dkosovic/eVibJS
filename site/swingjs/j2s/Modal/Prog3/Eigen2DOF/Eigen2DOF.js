(function(){var P$=Clazz.newPackage("Modal.Prog3.Eigen2DOF"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Modal.Prog3.Eigen2DOF.CFramePanel','Modal.Prog3.Eigen2DOF.CFrameAnimation','Modal.Prog3.Eigen2DOF.CFrameSmallControl','Modal.Prog3.Eigen2DOF.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Eigen2DOF", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Modal.Prog3.Eigen2DOF.CFramePanel','mAnimFrame','Modal.Prog3.Eigen2DOF.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I);
var var4=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 540, 1, 0.1, 1.0, 10.0, "N/m"]);
var4.SetLabelOffset$I$I(20, 10);
var4.SetTextEditable$Z(true);
var var5=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 540, 48, 0.1, 1.0, 10.0, "kg"]);
var5.SetLabelOffset$I$I(20, 10);
var5.SetTextEditable$Z(true);
var var6=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 540, 95, 0.001, 0.08, 1.0, "Ns/m"]);
var6.SetLabelOffset$I$I(20, 10);
var6.SetTextEditable$Z(true);
var var7=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 540, 142, 0.1, 1.0, 10.0, "N/m"]);
var7.SetLabelOffset$I$I(20, 10);
var7.SetTextEditable$Z(true);
var var8=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 540, 189, 0.1, 1.0, 10.0, "kg"]);
var8.SetLabelOffset$I$I(20, 10);
var8.SetTextEditable$Z(true);
var var9=Clazz.new_($I$(6,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$Modal_Prog3_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 540, 236, 0.001, 0.08, 1.0, "Ns/m"]);
var9.SetLabelOffset$I$I(20, 10);
var9.SetTextEditable$Z(true);
var var10=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 435, 15, 0, 0, var10, false]);
var var12=this.getImage$java_net_URL$S(this.getCodeBase$(), "lambda1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 10, 0, 0, var12, false]);
var var14=this.getImage$java_net_URL$S(this.getCodeBase$(), "lambda2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 40, 0, 0, var14, false]);
var var16=this.getImage$java_net_URL$S(this.getCodeBase$(), "lambda3.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 10, 0, 0, var16, false]);
var var18=this.getImage$java_net_URL$S(this.getCodeBase$(), "lambda4.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 40, 0, 0, var18, false]);
var var20=this.getImage$java_net_URL$S(this.getCodeBase$(), "w1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 90, 0, 0, var20, false]);
var var22=this.getImage$java_net_URL$S(this.getCodeBase$(), "w1Xi1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 130, 0, 0, var22, false]);
var var24=this.getImage$java_net_URL$S(this.getCodeBase$(), "w2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 90, 0, 0, var24, false]);
var var26=this.getImage$java_net_URL$S(this.getCodeBase$(), "w2Xi2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 130, 0, 0, var26, false]);
var var28=this.getImage$java_net_URL$S(this.getCodeBase$(), "wn1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 180, 0, 0, var28, false]);
var var30=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xi1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 200, 0, 0, var30, false]);
var var32=this.getImage$java_net_URL$S(this.getCodeBase$(), "wn2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 180, 0, 0, var32, false]);
var var34=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xi2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 200, 0, 0, var34, false]);
var var36=this.getImage$java_net_URL$S(this.getCodeBase$(), "undamped.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 240, 0, 0, var36, false]);
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 270, 0, 0, var28, false]);
Clazz.new_($I$(7,1).c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 230, 270, 0, 0, var32, false]);
this.validate$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(8,1).c$$I$java_awt_event_ActionListener,[20, this]);
this.mTimer.start$();
});

Clazz.newMeth(C$, ['actionPerformed$java_awt_event_ActionEvent','actionPerformed'],  function (e) {
if (this.mTimer != null ) {
var ddd=Clazz.new_(java.util.Date);
var thisTime=ddd.getTime$();
if (Long.$eq(this.mLastTime,0 )) {
this.mLastTime=thisTime;
}this.mLastTime=thisTime;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

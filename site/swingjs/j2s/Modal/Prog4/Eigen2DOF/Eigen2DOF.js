(function(){var P$=Clazz.newPackage("Modal.Prog4.Eigen2DOF"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Modal.Prog4.Eigen2DOF.CFramePanel','Modal.Prog4.Eigen2DOF.CFrameAnimation','Modal.Prog4.Eigen2DOF.CFrameSmallControl','Modal.Prog4.Eigen2DOF.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Eigen2DOF", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Modal.Prog4.Eigen2DOF.CFramePanel','mAnimFrame','Modal.Prog4.Eigen2DOF.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I);
var var4=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 70, 10, 0.1, 1.0, 10.0, "kg"]);
var4.SetLabelOffset$I$I(20, 10);
var4.SetTextEditable$Z(true);
var var5=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 95, 26, 0, 0, var5, false]);
var var7=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 140, 10, 0.1, 10.0, 40.0, "N/m"]);
var7.SetLabelOffset$I$I(20, 10);
var7.SetTextEditable$Z(true);
var var8=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 165, 26, 0, 0, var8, false]);
var var10=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 220, 10, 0.001, 0.4, 5.0, "Ns/m"]);
var10.SetLabelOffset$I$I(20, 10);
var10.SetTextEditable$Z(true);
var var11=this.getImage$java_net_URL$S(this.getCodeBase$(), "c1.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 245, 26, 0, 0, var11, false]);
var var13=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 310, 10, 0.1, 1.0, 10.0, "kg"]);
var13.SetLabelOffset$I$I(20, 10);
var13.SetTextEditable$Z(true);
var var14=this.getImage$java_net_URL$S(this.getCodeBase$(), "m2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 335, 26, 0, 0, var14, false]);
var var16=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 380, 10, 0.1, 10.0, 40.0, "N/m"]);
var16.SetLabelOffset$I$I(20, 10);
var16.SetTextEditable$Z(true);
var var17=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 405, 26, 0, 0, var17, false]);
var var19=Clazz.new_($I$(6,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$Modal_Prog4_Eigen2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 460, 10, 0.001, 0.08, 5.0, "Ns/m"]);
var19.SetLabelOffset$I$I(20, 10);
var19.SetTextEditable$Z(true);
var var20=this.getImage$java_net_URL$S(this.getCodeBase$(), "c2.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 485, 26, 0, 0, var20, false]);
var var22=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 590, 15, 0, 0, var22, false]);
var var24=this.getImage$java_net_URL$S(this.getCodeBase$(), "Key.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 600, 280, 0, 0, var24, false]);
var var26=this.getImage$java_net_URL$S(this.getCodeBase$(), "response.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 14, 45, 0, 0, var26, false]);
var var28=this.getImage$java_net_URL$S(this.getCodeBase$(), "phase.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 540, 83, 0, 0, var28, false]);
var var30=this.getImage$java_net_URL$S(this.getCodeBase$(), "Wlable.gif");
Clazz.new_($I$(7,1).c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 56, 346, 0, 0, var30, false]);
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

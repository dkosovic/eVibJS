(function(){var P$=Clazz.newPackage("TwoDOF.Prog10.Abutmentresponse_2DOF"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','TwoDOF.Prog10.Abutmentresponse_2DOF.CFramePanel','TwoDOF.Prog10.Abutmentresponse_2DOF.CFrameAnimation','TwoDOF.Prog10.Abutmentresponse_2DOF.CFrameSmallControl','TwoDOF.Prog10.Abutmentresponse_2DOF.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Abutmentresponse_2DOF", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','TwoDOF.Prog10.Abutmentresponse_2DOF.CFramePanel','mAnimFrame','TwoDOF.Prog10.Abutmentresponse_2DOF.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2000 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I);
var var4=Clazz.new_($I$(6,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$TwoDOF_Prog10_Abutmentresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 0.1, 2.0, "kg"]);
var4.SetLabelOffset$I$I(20, 10);
var4.SetTextEditable$Z(true);
var var5=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, var5, false]);
var var7=Clazz.new_($I$(6,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$TwoDOF_Prog10_Abutmentresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 20.0, 40.0, "N/m"]);
var7.SetLabelOffset$I$I(20, 10);
var7.SetTextEditable$Z(true);
var var8=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, var8, false]);
var var10=Clazz.new_($I$(6,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$TwoDOF_Prog10_Abutmentresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 150, 10, 0.01, 0.05, 1.0, "Ns/m"]);
var10.SetLabelOffset$I$I(20, 10);
var10.SetTextEditable$Z(true);
var var11=this.getImage$java_net_URL$S(this.getCodeBase$(), "c1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 175, 26, 0, 0, var11, false]);
var var13=Clazz.new_($I$(6,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$TwoDOF_Prog10_Abutmentresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 250, 10, 0.1, 0.1, 2.0, "kg"]);
var13.SetLabelOffset$I$I(20, 10);
var13.SetTextEditable$Z(true);
var var14=this.getImage$java_net_URL$S(this.getCodeBase$(), "m2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 275, 26, 0, 0, var14, false]);
var var16=Clazz.new_($I$(6,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$TwoDOF_Prog10_Abutmentresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 320, 10, 1.0, 20.0, 40.0, "N/m"]);
var16.SetLabelOffset$I$I(20, 10);
var16.SetTextEditable$Z(true);
var var17=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 345, 26, 0, 0, var17, false]);
var var19=this.getImage$java_net_URL$S(this.getCodeBase$(), "response.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 34, 45, 0, 0, var19, false]);
var var21=this.getImage$java_net_URL$S(this.getCodeBase$(), "Wlable.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog10_Abutmentresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 76, 346, 0, 0, var21, false]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

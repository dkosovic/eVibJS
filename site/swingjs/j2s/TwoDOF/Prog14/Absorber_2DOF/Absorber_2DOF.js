(function(){var P$=Clazz.newPackage("TwoDOF.Prog14.Absorber_2DOF"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','TwoDOF.Prog14.Absorber_2DOF.CFramePanel','TwoDOF.Prog14.Absorber_2DOF.CFrameAnimation','TwoDOF.Prog14.Absorber_2DOF.CFrameSmallControl','TwoDOF.Prog14.Absorber_2DOF.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Absorber_2DOF", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','TwoDOF.Prog14.Absorber_2DOF.CFramePanel','mAnimFrame','TwoDOF.Prog14.Absorber_2DOF.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2001 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I);
var m1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$TwoDOF_Prog14_Absorber_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 1.0, 2.0, "kg"]);
m1Control.SetLabelOffset$I$I(20, 10);
m1Control.SetTextEditable$Z(true);
var m1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, m1Image, false]);
var k1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$TwoDOF_Prog14_Absorber_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 40.0, 100.0, "N/m"]);
k1Control.SetLabelOffset$I$I(20, 10);
k1Control.SetTextEditable$Z(true);
var k1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, k1Image, false]);
var c1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$TwoDOF_Prog14_Absorber_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 150, 10, 0.001, 0.05, 1.0, "Ns/m"]);
c1Control.SetLabelOffset$I$I(20, 10);
c1Control.SetTextEditable$Z(true);
var c1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "c1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 175, 26, 0, 0, c1Image, false]);
var m2Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$TwoDOF_Prog14_Absorber_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 250, 10, 0.01, 0.1, 2.0, "kg"]);
m2Control.SetLabelOffset$I$I(20, 10);
m2Control.SetTextEditable$Z(true);
var m2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 275, 26, 0, 0, m2Image, false]);
var responseImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "response.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 34, 45, 0, 0, responseImage, false]);
var WlabelImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Wlable.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 76, 346, 0, 0, WlabelImage, false]);
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

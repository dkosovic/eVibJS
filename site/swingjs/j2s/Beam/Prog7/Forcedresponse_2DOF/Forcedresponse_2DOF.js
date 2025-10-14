(function(){var P$=Clazz.newPackage("Beam.Prog7.Forcedresponse_2DOF"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Beam.Prog7.Forcedresponse_2DOF.CFramePanel','Beam.Prog7.Forcedresponse_2DOF.CFrameAnimation','Beam.Prog7.Forcedresponse_2DOF.CFrameSmallControl','Beam.Prog7.Forcedresponse_2DOF.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forcedresponse_2DOF", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Beam.Prog7.Forcedresponse_2DOF.CFramePanel','mAnimFrame','Beam.Prog7.Forcedresponse_2DOF.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2003 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I);
var mControl=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 10, 10, 0.1, 1.0, 2.0, "kg"]);
mControl.SetLabelOffset$I$I(20, 10);
mControl.SetTextEditable$Z(true);
var mImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "m.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, mImage, false]);
var k1Control=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 80, 10, 1.0, 20.0, 40.0, "N/m"]);
k1Control.SetLabelOffset$I$I(20, 10);
k1Control.SetTextEditable$Z(true);
var k1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, k1Image, false]);
var c1Control=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 150, 10, 0.01, 0.3, 1.0, "Ns/m"]);
c1Control.SetLabelOffset$I$I(20, 10);
c1Control.SetTextEditable$Z(true);
var c1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "c1.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 175, 26, 0, 0, c1Image, false]);
var k2Control=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 240, 10, 1.0, 10.0, 40.0, "N/m"]);
k2Control.SetLabelOffset$I$I(20, 10);
k2Control.SetTextEditable$Z(true);
var k2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 265, 26, 0, 0, k2Image, false]);
var c2Control=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 310, 10, 0.01, 0.4, 1.0, "Ns/m"]);
c2Control.SetLabelOffset$I$I(20, 10);
c2Control.SetTextEditable$Z(true);
var c2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "c2.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 335, 26, 0, 0, c2Image, false]);
var bControl=Clazz.new_($I$(6,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$Beam_Prog7_Forcedresponse_2DOF_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 400, 10, 0.0, 0.3, 1.0, " "]);
bControl.SetLabelOffset$I$I(20, 10);
bControl.SetTextEditable$Z(true);
var bImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "b.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 425, 24, 0, 0, bImage, false]);
var diagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "diagram.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 430, 50, 0, 0, diagramImage, false]);
var responseImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "response.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 27, 44, 0, 0, responseImage, false]);
var WlabelImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Wlable.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog7_Forcedresponse_2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 76, 346, 0, 0, WlabelImage, false]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

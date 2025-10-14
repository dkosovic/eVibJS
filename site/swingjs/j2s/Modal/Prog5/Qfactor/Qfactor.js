(function(){var P$=Clazz.newPackage("Modal.Prog5.Qfactor"),I$=[[0,'java.awt.BorderLayout','java.awt.Label','Modal.Prog5.Qfactor.CFramePanel','Modal.Prog5.Qfactor.CFrameGraph','Modal.Prog5.Qfactor.CFrameSmallControl','Modal.Prog5.Qfactor.CFramePicture','Modal.Prog5.Qfactor.CFrameAnimation','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Qfactor", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','Modal.Prog5.Qfactor.CFramePanel','mFrameGraph','Modal.Prog5.Qfactor.CFrameGraph','mAnimFrame','Modal.Prog5.Qfactor.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var copyright=Clazz.new_($I$(2,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(3,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mFrameGraph=Clazz.new_($I$(4,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I,[this.mFramePanel, 0, 20, 1641, 365]);
var mControl=Clazz.new_($I$(5,1).c$$Modal_Prog5_Qfactor_CFramePanel$Modal_Prog5_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 2, 480, 40, 0.5, 1.0, 2.0, "kg"]);
mControl.SetLabelOffset$I$I(20, 10);
mControl.SetTextEditable$Z(true);
var mImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "m.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 505, 55, 0, 0, mImage, false]);
var cControl=Clazz.new_($I$(5,1).c$$Modal_Prog5_Qfactor_CFramePanel$Modal_Prog5_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 3, 570, 40, 1.0, 50.0, 500.0, "Ns/m"]);
cControl.SetLabelOffset$I$I(20, 10);
cControl.SetTextEditable$Z(true);
var cImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "c.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 595, 55, 0, 0, cImage, false]);
var kControl=Clazz.new_($I$(5,1).c$$Modal_Prog5_Qfactor_CFramePanel$Modal_Prog5_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 1, 480, 90, 150000.0, 400000.0, 450000.0, "N/m"]);
kControl.SetLabelOffset$I$I(20, 10);
kControl.SetTextEditable$Z(true);
var kImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "k.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 505, 105, 0, 0, kImage, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 129, 378, 0, 0, XaxisImage, false]);
var YaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 13, 13, 0, 0, YaxisImage, false]);
var DiagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(6,1).c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 135, 0, 0, DiagramImage, false]);
this.mAnimFrame=Clazz.new_([this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize$().width, 60],$I$(7,1).c$$Modal_Prog5_Qfactor_CFramePanel$Modal_Prog5_Qfactor_CFrameGraph$I$I$I$I);
this.validate$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(8,1).c$$I$java_awt_event_ActionListener,[50, this]);
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

Clazz.newMeth(C$, ['stop$','stop'],  function () {
if (this.mTimer != null ) {
this.mTimer.stop$();
this.mTimer=null;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

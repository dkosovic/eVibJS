(function(){var P$=Clazz.newPackage("Modal.Qhysteretic.Qfactor"),I$=[[0,'java.awt.BorderLayout','java.awt.Label','Modal.Qhysteretic.Qfactor.CFramePanel','Modal.Qhysteretic.Qfactor.CFrameGraph','Modal.Qhysteretic.Qfactor.CFrameSmallControl','Modal.Qhysteretic.Qfactor.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Qfactor", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','Modal.Qhysteretic.Qfactor.CFramePanel','mFrameGraph','Modal.Qhysteretic.Qfactor.CFrameGraph','mAnimFrame','Modal.Qhysteretic.Qfactor.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var copyright=Clazz.new_($I$(2,1).c$$S,["  Th1s program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(3,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mFrameGraph=Clazz.new_($I$(4,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I,[this.mFramePanel, 0, 20, 1641, 365]);
var m1Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 1, 10, 10, 0.1, 1.5, 5.0, "kg"]);
m1Control.SetLabelOffset$I$I(20, 10);
m1Control.SetTextEditable$Z(true);
var m1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, m1Image, false]);
var k1Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 2, 80, 10, 50000.0, 400000.0, 450000.0, "N/m"]);
k1Control.SetLabelOffset$I$I(20, 10);
k1Control.SetTextEditable$Z(true);
var k1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, k1Image, false]);
var h1Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 3, 180, 10, 2000.0, 40000.0, 1000000.0, "N/m"]);
h1Control.SetLabelOffset$I$I(20, 10);
h1Control.SetTextEditable$Z(true);
var h1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "h1.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 205, 26, 0, 0, h1Image, false]);
var m2Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 4, 270, 10, 0.1, 1.2, 5.0, "kg"]);
m2Control.SetLabelOffset$I$I(20, 10);
m2Control.SetTextEditable$Z(true);
var m2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m2.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 295, 26, 0, 0, m2Image, false]);
var k2Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 5, 340, 10, 50000.0, 200000.0, 450000.0, "N/m"]);
k2Control.SetLabelOffset$I$I(20, 10);
k2Control.SetTextEditable$Z(true);
var k2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 365, 26, 0, 0, k2Image, false]);
var h2Control=Clazz.new_($I$(5,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$Modal_Qhysteretic_Qfactor_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 6, 440, 10, 2000.0, 10000.0, 1000000.0, "N/m"]);
h2Control.SetLabelOffset$I$I(20, 10);
h2Control.SetTextEditable$Z(true);
var h2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "h2.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 465, 26, 0, 0, h2Image, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 129, 418, 0, 0, XaxisImage, false]);
var YaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 13, 53, 0, 0, YaxisImage, false]);
var DiagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 480, 65, 0, 0, DiagramImage, false]);
var KeyImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Key.gif");
Clazz.new_($I$(6,1).c$$Modal_Qhysteretic_Qfactor_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 380, 65, 0, 0, KeyImage, false]);
this.validate$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(7,1).c$$I$java_awt_event_ActionListener,[50, this]);
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

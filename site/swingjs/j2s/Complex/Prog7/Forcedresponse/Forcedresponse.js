(function(){var P$=Clazz.newPackage("Complex.Prog7.Forcedresponse"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Complex.Prog7.Forcedresponse.CFramePanel','Complex.Prog7.Forcedresponse.CFrameAnimation','Complex.Prog7.Forcedresponse.CFrameSmallControl','Complex.Prog7.Forcedresponse.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forcedresponse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Complex.Prog7.Forcedresponse.CFramePanel','mAnimFrame','Complex.Prog7.Forcedresponse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I);
var LControl=Clazz.new_($I$(6,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$Complex_Prog7_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 450, 310, 0.5, 1.0, 2.0, "m"]);
LControl.SetLabelOffset$I$I(20, 10);
LControl.SetTextEditable$Z(true);
var LImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "L.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 475, 325, 0, 0, LImage, false]);
var DControl=Clazz.new_($I$(6,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$Complex_Prog7_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 530, 310, 0.05, 0.1, 0.2, "m"]);
DControl.SetLabelOffset$I$I(20, 10);
DControl.SetTextEditable$Z(true);
var DImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "D.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 555, 325, 0, 0, DImage, false]);
var mControl=Clazz.new_($I$(6,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$Complex_Prog7_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 610, 310, 5.0, 20.0, 100.0, "kg"]);
mControl.SetLabelOffset$I$I(20, 10);
mControl.SetTextEditable$Z(true);
var mImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "m.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 635, 325, 0, 0, mImage, false]);
var kControl=Clazz.new_($I$(6,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$Complex_Prog7_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 690, 310, 1.5E8, 1.0E9, 1.0E10, "N/m"]);
kControl.SetLabelOffset$I$I(20, 10);
kControl.SetTextEditable$Z(true);
var kImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "k.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 715, 325, 0, 0, kImage, false]);
var DiagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 30, 0, 0, DiagramImage, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 87, 185, 0, 0, XaxisImage, false]);
var YaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 0, 3, 0, 0, YaxisImage, false]);
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

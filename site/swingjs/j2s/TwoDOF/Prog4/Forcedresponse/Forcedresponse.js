(function(){var P$=Clazz.newPackage("TwoDOF.Prog4.Forcedresponse"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','TwoDOF.Prog4.Forcedresponse.CFramePanel','TwoDOF.Prog4.Forcedresponse.CFrameAnimation','TwoDOF.Prog4.Forcedresponse.CFrameSmallControl','TwoDOF.Prog4.Forcedresponse.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forcedresponse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','TwoDOF.Prog4.Forcedresponse.CFramePanel','mAnimFrame','TwoDOF.Prog4.Forcedresponse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I);
var K2divK1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$TwoDOF_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 450, 10, 0.2, 2.0, 5.0, " "]);
K2divK1Control.SetLabelOffset$I$I(20, 10);
K2divK1Control.SetTextEditable$Z(true);
var K2divK1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "K2divK1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 471, 25, 0, 0, K2divK1Image, false]);
var M2divM1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$TwoDOF_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 520, 10, 0.2, 0.5, 5.0, " "]);
M2divM1Control.SetLabelOffset$I$I(20, 10);
M2divM1Control.SetTextEditable$Z(true);
var M2divM1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "M2divM1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 541, 25, 0, 0, M2divM1Image, false]);
var DiagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 460, 60, 0, 0, DiagramImage, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 96, 145, 0, 0, XaxisImage, false]);
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 96, 465, 0, 0, XaxisImage, false]);
var Y1axesImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Y1axis.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 20, 5, 0, 0, Y1axesImage, false]);
var Y2axesImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Y2axis.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 20, 325, 0, 0, Y2axesImage, false]);
var LegendImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Legend.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 280, 25, 0, 0, LegendImage, false]);
Clazz.new_($I$(7,1).c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 280, 345, 0, 0, LegendImage, false]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

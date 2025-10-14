(function(){var P$=Clazz.newPackage("Complex.Prog4.Forcedresponse"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Complex.Prog4.Forcedresponse.CFramePanel','Complex.Prog4.Forcedresponse.CFrameAnimation','Complex.Prog4.Forcedresponse.CFrameSmallControl','Complex.Prog4.Forcedresponse.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forcedresponse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Complex.Prog4.Forcedresponse.CFramePanel','mAnimFrame','Complex.Prog4.Forcedresponse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I);
var LbControl=Clazz.new_($I$(6,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$Complex_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 430, 330, 0.2, 0.4, 1.5, "m"]);
LbControl.SetLabelOffset$I$I(20, 10);
LbControl.SetTextEditable$Z(true);
var LbImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Lb.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 450, 345, 0, 0, LbImage, false]);
var DbControl=Clazz.new_($I$(6,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$Complex_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 520, 330, 0.02, 0.06, 0.2, "m"]);
DbControl.SetLabelOffset$I$I(20, 10);
DbControl.SetTextEditable$Z(true);
var DbImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Db.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 540, 345, 0, 0, DbImage, false]);
var LcControl=Clazz.new_($I$(6,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$Complex_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 610, 330, 0.2, 0.6, 1.5, "m"]);
LcControl.SetLabelOffset$I$I(20, 10);
LcControl.SetTextEditable$Z(true);
var LcImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Lc.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 630, 345, 0, 0, LcImage, false]);
var DcControl=Clazz.new_($I$(6,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$Complex_Prog4_Forcedresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 700, 330, 0.02, 0.04, 0.2, "m"]);
DcControl.SetLabelOffset$I$I(20, 10);
DcControl.SetTextEditable$Z(true);
var DcImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Dc.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 720, 345, 0, 0, DcImage, false]);
var DiagramImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 0, 0, 0, DiagramImage, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 75, 135, 0, 0, XaxisImage, false]);
var YaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(7,1).c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 1, 3, 0, 0, YaxisImage, false]);
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

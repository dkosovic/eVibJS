(function(){var P$=Clazz.newPackage("OneDOF.Prog7.Forcedlocus"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','OneDOF.Prog7.Forcedlocus.CFramePanel','OneDOF.Prog7.Forcedlocus.CFrameAnimation','OneDOF.Prog7.Forcedlocus.CFrameSmallControl','OneDOF.Prog7.Forcedlocus.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forcedlocus", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','OneDOF.Prog7.Forcedlocus.CFramePanel','mAnimFrame','OneDOF.Prog7.Forcedlocus.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 1999 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I);
var XiControl=Clazz.new_($I$(6,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$OneDOF_Prog7_Forcedlocus_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 55, 10, 0.04, 0.1, 3.0, " "]);
XiControl.SetLabelOffset$I$I(20, 10);
XiControl.SetTextEditable$Z(true);
var XiImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "xi.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 83, 25, 0, 0, XiImage, false]);
var WControl=Clazz.new_($I$(6,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$OneDOF_Prog7_Forcedlocus_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 255, 10, 0.01, 0.9, 3.0, " "]);
WControl.SetLabelOffset$I$I(20, 10);
WControl.SetTextEditable$Z(true);
var WImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "WdivWn.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 283, 25, 0, 0, WImage, false]);
var XaxisImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 37, 220, 0, 0, XaxisImage, false]);
var YaxesImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxes.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 2, 45, 0, 0, YaxesImage, false]);
var kXdivFImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "kXdivF.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 45, 65, 0, 0, kXdivFImage, false]);
var phiImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "phi.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 45, 320, 0, 0, phiImage, false]);
var WdivWnImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "WdivWn.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 352, 215, 0, 0, WdivWnImage, false]);
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

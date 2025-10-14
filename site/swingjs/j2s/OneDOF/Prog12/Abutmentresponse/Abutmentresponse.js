(function(){var P$=Clazz.newPackage("OneDOF.Prog12.Abutmentresponse"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','OneDOF.Prog12.Abutmentresponse.CFramePanel','OneDOF.Prog12.Abutmentresponse.CFrameAnimation','OneDOF.Prog12.Abutmentresponse.CFrameSmallControl','OneDOF.Prog12.Abutmentresponse.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Abutmentresponse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','OneDOF.Prog12.Abutmentresponse.CFramePanel','mAnimFrame','OneDOF.Prog12.Abutmentresponse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 1999 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I);
var var4=Clazz.new_($I$(6,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$OneDOF_Prog12_Abutmentresponse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 100, 10, 0.001, 0.05, 3.0, " "]);
var4.SetLabelOffset$I$I(20, 10);
var4.SetTextEditable$Z(true);
var var5=this.getImage$java_net_URL$S(this.getCodeBase$(), "xi.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 128, 25, 0, 0, var5, false]);
var var7=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 65, 0, 0, var7, false]);
var var9=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 97, 220, 0, 0, var9, false]);
var var11=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxes.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 62, 45, 0, 0, var11, false]);
var var13=this.getImage$java_net_URL$S(this.getCodeBase$(), "kXdivXo.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 65, 0, 0, var13, false]);
var var15=this.getImage$java_net_URL$S(this.getCodeBase$(), "phi.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 320, 0, 0, var15, false]);
var var17=this.getImage$java_net_URL$S(this.getCodeBase$(), "WdivWn.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 412, 215, 0, 0, var17, false]);
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

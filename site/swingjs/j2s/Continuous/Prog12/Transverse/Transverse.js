(function(){var P$=Clazz.newPackage("Continuous.Prog12.Transverse"),I$=[[0,'java.awt.BorderLayout','java.awt.Label','Continuous.Prog12.Transverse.CFramePanel','Continuous.Prog12.Transverse.CFrameGraph','Continuous.Prog12.Transverse.CFrameSmallControl','Continuous.Prog12.Transverse.CFramePicture','Continuous.Prog12.Transverse.CFrameAnimation','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Transverse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','Continuous.Prog12.Transverse.CFramePanel','mFrameGraph','Continuous.Prog12.Transverse.CFrameGraph','mAnimFrame','Continuous.Prog12.Transverse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var copyright=Clazz.new_($I$(2,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(3,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mFrameGraph=Clazz.new_($I$(4,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I,[this.mFramePanel, 0, 20, 441, 365]);
var var3=Clazz.new_($I$(5,1).c$$Continuous_Prog12_Transverse_CFramePanel$Continuous_Prog12_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 1, 480, 310, 0.5, 1.5, 2.0, "m"]);
var3.SetLabelOffset$I$I(20, 10);
var3.SetTextEditable$Z(true);
var var4=this.getImage$java_net_URL$S(this.getCodeBase$(), "L.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 505, 325, 0, 0, var4, false]);
var var6=Clazz.new_($I$(5,1).c$$Continuous_Prog12_Transverse_CFramePanel$Continuous_Prog12_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 2, 550, 310, 0.02, 0.12, 0.2, "m"]);
var6.SetLabelOffset$I$I(20, 10);
var6.SetTextEditable$Z(true);
var var7=this.getImage$java_net_URL$S(this.getCodeBase$(), "B.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 575, 325, 0, 0, var7, false]);
var var9=Clazz.new_($I$(5,1).c$$Continuous_Prog12_Transverse_CFramePanel$Continuous_Prog12_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 3, 625, 310, 0.08, 0.12, 0.2, "m"]);
var9.SetLabelOffset$I$I(20, 10);
var9.SetTextEditable$Z(true);
var var10=this.getImage$java_net_URL$S(this.getCodeBase$(), "D.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 650, 325, 0, 0, var10, false]);
var var12=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 109, 340, 0, 0, var12, false]);
var var14=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 10, 25, 0, 0, var14, false]);
var var16=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(6,1).c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 225, 0, 0, var16, false]);
this.mAnimFrame=Clazz.new_([this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize$().width, 60],$I$(7,1).c$$Continuous_Prog12_Transverse_CFramePanel$Continuous_Prog12_Transverse_CFrameGraph$I$I$I$I);
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
}var realSeconds=(Long.$sub(thisTime,this.mLastTime)) / 1000.0;
this.mLastTime=thisTime;
this.mFrameGraph.ControlMessage$I$D(5, realSeconds);
}});

Clazz.newMeth(C$, ['stop$','stop'],  function () {
if (this.mTimer != null ) {
this.mTimer.stop$();
this.mTimer=null;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

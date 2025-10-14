(function(){var P$=Clazz.newPackage("Methods.Prog1.Energy"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Methods.Prog1.Energy.CFramePanel','Methods.Prog1.Energy.CFrameAnimation','Methods.Prog1.Energy.CFrameSmallControl','Methods.Prog1.Energy.CFramePicture','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Energy", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Methods.Prog1.Energy.CFramePanel','mAnimFrame','Methods.Prog1.Energy.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I);
var var4=Clazz.new_($I$(6,1).c$$Methods_Prog1_Energy_CFramePanel$Methods_Prog1_Energy_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 1, 489, 118, 1.0, 1.0, 5.0, "k"]);
var4.SetLabelOffset$I$I(20, 10);
var4.SetTextEditable$Z(true);
var4.SetIntegerMode$Z(true);
var var5=Clazz.new_($I$(6,1).c$$Methods_Prog1_Energy_CFramePanel$Methods_Prog1_Energy_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 477, 157, 1.0, 1.0, 5.0, "m"]);
var5.SetLabelOffset$I$I(20, 10);
var5.SetTextEditable$Z(true);
var5.SetIntegerMode$Z(true);
var var6=Clazz.new_($I$(6,1).c$$Methods_Prog1_Energy_CFramePanel$Methods_Prog1_Energy_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 489, 200, 1.0, 1.0, 5.0, "k"]);
var6.SetLabelOffset$I$I(20, 10);
var6.SetTextEditable$Z(true);
var6.SetIntegerMode$Z(true);
var var7=Clazz.new_($I$(6,1).c$$Methods_Prog1_Energy_CFramePanel$Methods_Prog1_Energy_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 477, 248, 1.0, 1.0, 5.0, "m"]);
var7.SetLabelOffset$I$I(20, 10);
var7.SetTextEditable$Z(true);
var7.SetIntegerMode$Z(true);
var var8=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(7,1).c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 520, 60, 0, 0, var8, false]);
var var10=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(7,1).c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 28, 334, 0, 0, var10, false]);
var var12=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(7,1).c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 356, 4, 0, 0, var12, false]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

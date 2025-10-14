(function(){var P$=Clazz.newPackage("Complex.Prog8.Transverse"),I$=[[0,'java.awt.BorderLayout','java.awt.Label','Complex.Prog8.Transverse.CFramePanel','Complex.Prog8.Transverse.CFrameGraph','Complex.Prog8.Transverse.CFrameSmallControl','Complex.Prog8.Transverse.CFramePicture','Complex.Prog8.Transverse.CFrameAnimation','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Transverse", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','Complex.Prog8.Transverse.CFramePanel','mFrameGraph','Complex.Prog8.Transverse.CFrameGraph','mAnimFrame','Complex.Prog8.Transverse.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var copyright=Clazz.new_($I$(2,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(3,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mFrameGraph=Clazz.new_($I$(4,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I,[this.mFramePanel, 0, 20, 441, 365]);
var var3=Clazz.new_($I$(5,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 1, 480, 40, 0.5, 1.2, 2.0, "m"]);
var3.SetLabelOffset$I$I(20, 10);
var3.SetTextEditable$Z(true);
var var4=this.getImage$java_net_URL$S(this.getCodeBase$(), "L.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 505, 55, 0, 0, var4, false]);
var var6=Clazz.new_($I$(5,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 2, 570, 40, 0.05, 0.15, 0.3, "m"]);
var6.SetLabelOffset$I$I(20, 10);
var6.SetTextEditable$Z(true);
var var7=this.getImage$java_net_URL$S(this.getCodeBase$(), "D.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 595, 55, 0, 0, var7, false]);
var var9=Clazz.new_($I$(5,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 3, 570, 90, 0.05, 2.0, 5.0, "kg"]);
var9.SetLabelOffset$I$I(20, 10);
var9.SetTextEditable$Z(true);
var var10=this.getImage$java_net_URL$S(this.getCodeBase$(), "m.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 595, 105, 0, 0, var10, false]);
var var12=Clazz.new_($I$(5,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 4, 480, 140, 10000.0, 393000.0, 1000000.0, "N/m"]);
var12.SetLabelOffset$I$I(20, 10);
var12.SetTextEditable$Z(true);
var var13=this.getImage$java_net_URL$S(this.getCodeBase$(), "k.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 505, 155, 0, 0, var13, false]);
var var15=Clazz.new_($I$(5,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mFrameGraph, 5, 570, 140, 0.0, 0.25, 1.0, ""]);
var15.SetLabelOffset$I$I(20, 10);
var15.SetTextEditable$Z(true);
var var16=this.getImage$java_net_URL$S(this.getCodeBase$(), "alpha.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 595, 155, 0, 0, var16, false]);
var var18=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xaxis.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 129, 378, 0, 0, var18, false]);
var var20=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yaxis.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 13, 13, 0, 0, var20, false]);
var var22=this.getImage$java_net_URL$S(this.getCodeBase$(), "Diagram.gif");
Clazz.new_($I$(6,1).c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 470, 205, 0, 0, var22, false]);
this.mAnimFrame=Clazz.new_([this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize$().width, 60],$I$(7,1).c$$Complex_Prog8_Transverse_CFramePanel$Complex_Prog8_Transverse_CFrameGraph$I$I$I$I);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

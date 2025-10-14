(function(){var P$=Clazz.newPackage("MultiDOF.Prog10.Multiforced"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','MultiDOF.Prog10.Multiforced.CFramePanel','MultiDOF.Prog10.Multiforced.CFrameGraph','MultiDOF.Prog10.Multiforced.CFrameAnimation','java.awt.Button','javax.swing.Timer','java.net.URL']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Multiforced", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','MultiDOF.Prog10.Multiforced.CFramePanel','mFrameGraph','MultiDOF.Prog10.Multiforced.CFrameGraph','mAnimFrame','MultiDOF.Prog10.Multiforced.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 1999 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mFrameGraph=Clazz.new_($I$(5,1).c$$MultiDOF_Prog10_Multiforced_CFramePanel$I$I$I$I,[this.mFramePanel, 40, 70, 602, 280]);
this.mAnimFrame=Clazz.new_([this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize$().width, 60],$I$(6,1).c$$MultiDOF_Prog10_Multiforced_CFramePanel$MultiDOF_Prog10_Multiforced_CFrameGraph$I$I$I$I);
var var4=Clazz.new_($I$(7,1).c$$S,["Instructions"]);
var1.add$java_awt_Component(var4);
var var5=Clazz.new_($I$(7,1).c$$S,["Edit"]);
var1.add$java_awt_Component(var5);
var1.add$java_awt_Component(Clazz.new_($I$(7,1).c$$S,["Add"]));
var1.add$java_awt_Component(Clazz.new_($I$(7,1).c$$S,["Delete"]));
this.validate$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(8,1).c$$I$java_awt_event_ActionListener,[50, this]);
this.mTimer.start$();
});

Clazz.newMeth(C$, ['action$java_awt_Event$O','action'],  function (var1, var2) {
if (Clazz.instanceOf(var1.target, "java.awt.Button")) {
if (var2.equals$O("Edit")) {
this.mFrameGraph.ControlMessage$MultiDOF_Prog10_Multiforced_CFrame$I$D(null, 1, 0.0);
} else if (var2.equals$O("Add")) {
this.mFrameGraph.ControlMessage$MultiDOF_Prog10_Multiforced_CFrame$I$D(null, 5, 0.0);
} else if (var2.equals$O("Delete")) {
this.mFrameGraph.DeleteSelected$();
} else if (var2.equals$O("Instructions")) {
var var3=this.getCodeBase$().toString() + "instructions.html";
var var4=null;
try {
var4=Clazz.new_($I$(9,1).c$$S,[var3]);
this.getAppletContext$().showDocument$java_net_URL$S(var4, "_blank");
} catch (var5) {
if (Clazz.exceptionOf(var5,"java.net.MalformedURLException")){
System.out.println$S("Malformed URL exception");
} else {
throw var5;
}
}
}}return true;
});

Clazz.newMeth(C$, ['keyDown$java_awt_Event$I','keyDown'],  function (var1, var2) {
switch (var2) {
case 8:
this.mFrameGraph.DeleteSelected$();
default:
return true;
}
});

Clazz.newMeth(C$, ['actionPerformed$java_awt_event_ActionEvent','actionPerformed'],  function (e) {
if (this.mTimer != null ) {
var ddd=Clazz.new_(java.util.Date);
var thisTime=ddd.getTime$();
if (Long.$eq(this.mLastTime,0 )) {
this.mLastTime=thisTime;
}var realSeconds=(Long.$sub(thisTime,this.mLastTime)) / 1000.0;
this.mLastTime=thisTime;
this.mFrameGraph.ControlMessage$I$D(3, realSeconds);
}});

Clazz.newMeth(C$, ['stop$','stop'],  function () {
if (this.mTimer != null ) {
this.mTimer.stop$();
this.mTimer=null;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

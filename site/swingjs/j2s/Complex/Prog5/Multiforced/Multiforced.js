(function(){var P$=Clazz.newPackage("Complex.Prog5.Multiforced"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Complex.Prog5.Multiforced.CFramePanel','Complex.Prog5.Multiforced.CFramePicture','Complex.Prog5.Multiforced.CFrameGraph','Complex.Prog5.Multiforced.CFrameAnimation','java.awt.Button','javax.swing.Timer','java.net.URL']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Multiforced", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mFeedbackWindow=null;
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFeedbackWindow','java.awt.Frame','answer1','java.awt.TextField','mFramePanel','Complex.Prog5.Multiforced.CFramePanel','mFrameGraph','Complex.Prog5.Multiforced.CFrameGraph','mAnimFrame','Complex.Prog5.Multiforced.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var1=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", var1);
var copyright=Clazz.new_($I$(3,1).c$$S,["  This program is copyright, you need permission to use it. \u00a9 1999 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
var var4=this.getImage$java_net_URL$S(this.getCodeBase$(), "yaxis.gif");
Clazz.new_($I$(5,1).c$$Complex_Prog5_Multiforced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 2, 69, 0, 0, var4, false]);
var var6=this.getImage$java_net_URL$S(this.getCodeBase$(), "w1axis.gif");
Clazz.new_($I$(5,1).c$$Complex_Prog5_Multiforced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 30, 355, 0, 0, var6, false]);
var var8=this.getImage$java_net_URL$S(this.getCodeBase$(), "w2axis.gif");
Clazz.new_($I$(5,1).c$$Complex_Prog5_Multiforced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 530, 355, 0, 0, var8, false]);
this.mFrameGraph=Clazz.new_($I$(6,1).c$$Complex_Prog5_Multiforced_CFramePanel$I$I$I$I,[this.mFramePanel, 40, 70, 602, 280]);
this.mAnimFrame=Clazz.new_([this.mFramePanel, this.mFrameGraph, 0, 385, this.getSize$().width, 60],$I$(7,1).c$$Complex_Prog5_Multiforced_CFramePanel$Complex_Prog5_Multiforced_CFrameGraph$I$I$I$I);
var var10=Clazz.new_($I$(8,1).c$$S,["Instructions"]);
var10.addActionListener$java_awt_event_ActionListener(this);
var1.add$java_awt_Component(var10);
var var11=Clazz.new_($I$(8,1).c$$S,["Edit"]);
var11.addActionListener$java_awt_event_ActionListener(this);
var1.add$java_awt_Component(var11);
this.validate$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(9,1).c$$I$java_awt_event_ActionListener,[50, this]);
this.mTimer.start$();
});

Clazz.newMeth(C$, ['actionPerformed$java_awt_event_ActionEvent','actionPerformed'],  function (e) {
if (Clazz.instanceOf(e.getSource$(), "java.awt.Button")) {
var source=e.getSource$();
var label=source.getLabel$();
if (label.equals$O("Edit")) {
this.mFrameGraph.ControlMessage$Complex_Prog5_Multiforced_CFrame$I$D(null, 1, 0.0);
} else if (label.equals$O("Instructions")) {
var var3=this.getCodeBase$().toString() + "instructions.html";
var var4=null;
try {
var4=Clazz.new_($I$(10,1).c$$S,[var3]);
this.getAppletContext$().showDocument$java_net_URL$S(var4, "_blank");
} catch (var5) {
if (Clazz.exceptionOf(var5,"java.net.MalformedURLException")){
System.out.println$S("Malformed URL exception");
} else {
throw var5;
}
}
}return;
}if (this.mTimer != null ) {
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

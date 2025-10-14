(function(){var P$=Clazz.newPackage("TwoDOF.Prog5.Damped"),I$=[[0,'java.awt.BorderLayout','TwoDOF.Prog5.Damped.CMyLabel','TwoDOF.Prog5.Damped.CBrianControl','TwoDOF.Prog5.Damped.CPicturePanel','java.awt.Panel','java.awt.GridLayout']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CBrianGroup", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mCBC','TwoDOF.Prog5.Damped.CBrianControl']]]

Clazz.newMeth(C$, 'c$$java_applet_Applet$S$D$D$D',  function (app, imgName, min, val, max) {
Clazz.super_(C$, this);
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var lab=Clazz.new_([app.getGraphics$().getFontMetrics$(), "xxxxxxxxx", 1],$I$(2,1).c$$java_awt_FontMetrics$S$I);
this.mCBC=Clazz.new_($I$(3,1).c$$java_applet_Applet$java_awt_Label$D$D$D,[app, lab, min, val, max]);
this.add$S$java_awt_Component("West", this.mCBC);
var img=app.getImage$java_net_URL$S(app.getCodeBase$(), imgName);
var pic=Clazz.new_($I$(4,1).c$$java_awt_Image,[img]);
var grid=Clazz.new_($I$(5,1));
grid.setLayout$java_awt_LayoutManager(Clazz.new_($I$(6,1).c$$I$I,[2, 0]));
this.add$S$java_awt_Component("Center", grid);
var dum=Clazz.new_($I$(5,1));
grid.add$java_awt_Component(dum);
dum.add$java_awt_Component(pic);
grid.add$java_awt_Component(lab);
}, 1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("OneDOF.ComplexAbutment.Complex"),I$=[[0,'java.awt.BorderLayout','OneDOF.ComplexAbutment.Complex.CMyLabel','OneDOF.ComplexAbutment.Complex.CBrianControl','OneDOF.ComplexAbutment.Complex.CPicturePanel','java.awt.Panel','java.awt.GridLayout']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CBrianGroup", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mCBC','OneDOF.ComplexAbutment.Complex.CBrianControl']]]

Clazz.newMeth(C$, 'c$$java_applet_Applet$S$D$D$D',  function (var1, var2, var3, var5, var7) {
Clazz.super_(C$, this);
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var9=Clazz.new_([var1.getGraphics$().getFontMetrics$(), "xxxxxxxxx", 1],$I$(2,1).c$$java_awt_FontMetrics$S$I);
this.mCBC=Clazz.new_($I$(3,1).c$$java_applet_Applet$java_awt_Label$D$D$D,[var1, var9, var3, var5, var7]);
this.add$S$java_awt_Component("West", this.mCBC);
var var10=var1.getImage$java_net_URL$S(var1.getCodeBase$(), var2);
var var11=Clazz.new_($I$(4,1).c$$java_awt_Image,[var10]);
var var12=Clazz.new_($I$(5,1));
var12.setLayout$java_awt_LayoutManager(Clazz.new_($I$(6,1).c$$I$I,[2, 0]));
this.add$S$java_awt_Component("Center", var12);
var var13=Clazz.new_($I$(5,1));
var12.add$java_awt_Component(var13);
var13.add$java_awt_Component(var11);
var12.add$java_awt_Component(var9);
}, 1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

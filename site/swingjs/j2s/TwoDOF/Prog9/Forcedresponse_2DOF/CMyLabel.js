(function(){var P$=Clazz.newPackage("TwoDOF.Prog9.Forcedresponse_2DOF"),I$=[[0,'java.awt.Dimension']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CMyLabel", null, 'java.awt.Label');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mMinDim','java.awt.Dimension']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
this.mMinDim=Clazz.new_($I$(1,1).c$$I$I,[40, 16]);
}, 1);

Clazz.newMeth(C$, 'c$$java_awt_FontMetrics$S',  function (var1, var2) {
;C$.superclazz.c$$S.apply(this,[var2]);C$.$init$.apply(this);
this.setMinDim$java_awt_FontMetrics$S(var1, var2);
}, 1);

Clazz.newMeth(C$, 'c$$java_awt_FontMetrics$S$I',  function (var1, var2, var3) {
;C$.superclazz.c$$S$I.apply(this,[var2, var3]);C$.$init$.apply(this);
this.setMinDim$java_awt_FontMetrics$S(var1, var2);
}, 1);

Clazz.newMeth(C$, 'setMinDim$java_awt_FontMetrics$S',  function (var1, var2) {
var var3=(10 * var1.stringWidth$S(var2)/9|0);
var var4=var1.getMaxAscent$() + var1.getMaxDescent$();
this.mMinDim=Clazz.new_($I$(1,1).c$$I$I,[var3, var4]);
});

Clazz.newMeth(C$, 'minimumSize$',  function () {
return Clazz.new_($I$(1,1).c$$I$I,[this.mMinDim.width, this.mMinDim.height]);
});

Clazz.newMeth(C$, 'preferredSize$',  function () {
return this.minimumSize$();
});
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

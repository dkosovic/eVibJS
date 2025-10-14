(function(){var P$=Clazz.newPackage("OneDOF.Prog13.Complex"),I$=[[0,'java.awt.Dimension']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CMyLabel", null, 'java.awt.Label');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mMinDim','java.awt.Dimension']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
this.mMinDim=Clazz.new_($I$(1,1).c$$I$I,[40, 16]);
}, 1);

Clazz.newMeth(C$, 'c$$java_awt_FontMetrics$S',  function (f, s) {
;C$.superclazz.c$$S.apply(this,[s]);C$.$init$.apply(this);
this.setMinDim$java_awt_FontMetrics$S(f, s);
}, 1);

Clazz.newMeth(C$, 'c$$java_awt_FontMetrics$S$I',  function (f, s, align) {
;C$.superclazz.c$$S$I.apply(this,[s, align]);C$.$init$.apply(this);
this.setMinDim$java_awt_FontMetrics$S(f, s);
}, 1);

Clazz.newMeth(C$, 'setMinDim$java_awt_FontMetrics$S',  function (f, s) {
var w=(10 * f.stringWidth$S(s)/9|0);
var h=f.getMaxAscent$() + f.getMaxDescent$();
this.mMinDim=Clazz.new_($I$(1,1).c$$I$I,[w, h]);
});

Clazz.newMeth(C$, 'minimumSize$',  function () {
return Clazz.new_($I$(1,1).c$$I$I,[this.mMinDim.width, this.mMinDim.height]);
});

Clazz.newMeth(C$, 'preferredSize$',  function () {
return this.minimumSize$();
});
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

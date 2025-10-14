(function(){var P$=Clazz.newPackage("Continuous.Prog9.Vibration"),I$=[[0,'java.awt.Dimension']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CMyLabel", null, 'java.awt.Label');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['I',['mPrefWidth']]]

Clazz.newMeth(C$, 'c$$S$I$java_awt_Graphics',  function (lab, align, g) {
;C$.superclazz.c$$S$I.apply(this,[lab, align]);C$.$init$.apply(this);
var fm=g.getFontMetrics$();
this.mPrefWidth=fm.stringWidth$S(lab);
}, 1);

Clazz.newMeth(C$, 'preferredSize$',  function () {
var oldD=C$.superclazz.prototype.getPreferredSize$.apply(this, []);
return Clazz.new_($I$(1,1).c$$I$I,[this.mPrefWidth, oldD.height]);
});

Clazz.newMeth(C$, 'minimumSize$',  function () {
return this.getPreferredSize$();
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

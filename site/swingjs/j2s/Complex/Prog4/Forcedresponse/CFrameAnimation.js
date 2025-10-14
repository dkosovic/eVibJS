(function(){var P$=Clazz.newPackage("Complex.Prog4.Forcedresponse"),I$=[[0,'java.awt.Color','Complex.Prog4.Forcedresponse.CUtility']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Complex.Prog4.Forcedresponse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mLb=0.4;
this.mDb=0.06;
this.mLc=0.6;
this.mDc=0.04;
},1);

C$.$fields$=[['D',['mLb','mDb','mLc','mDc'],'O',['mRecb','double[]','+mRecc']]]

Clazz.newMeth(C$, 'c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$Complex_Prog4_Forcedresponse_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
this.mRecb=Clazz.array(Double.TYPE, [450]);
this.mRecc=Clazz.array(Double.TYPE, [450]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).orange);
g.fillRect$I$I$I$I(450, 250, 20, 50);
g.setColor$java_awt_Color($I$(1).blue);
g.drawLine$I$I$I$I(470 + ((200.0 * this.mLb / 2.0)|0), 275 - ((20.0 * this.mDc / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0) + ((200.0 * this.mLc / 2.0)|0) , 275 - ((20.0 * this.mDc / 0.2)|0));
g.drawLine$I$I$I$I(470 + ((200.0 * this.mLb / 2.0)|0) + ((200.0 * this.mLc / 2.0)|0) , 275 - ((20.0 * this.mDc / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0) + ((200.0 * this.mLc / 2.0)|0) , 275 + ((20.0 * this.mDc / 0.2)|0));
g.drawLine$I$I$I$I(470 + ((200.0 * this.mLb / 2.0)|0), 275 + ((20.0 * this.mDc / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0) + ((200.0 * this.mLc / 2.0)|0) , 275 + ((20.0 * this.mDc / 0.2)|0));
g.drawLine$I$I$I$I(470 + ((200.0 * this.mLb / 2.0)|0), 275 - ((20.0 * this.mDc / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0), 275 + ((20.0 * this.mDc / 0.2)|0));
g.setColor$java_awt_Color($I$(1).red);
g.drawLine$I$I$I$I(470, 275 - ((20.0 * this.mDb / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0), 275 - ((20.0 * this.mDb / 0.2)|0));
g.drawLine$I$I$I$I(470 + ((200.0 * this.mLb / 2.0)|0), 275 - ((20.0 * this.mDb / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0), 275 + ((20.0 * this.mDb / 0.2)|0));
g.drawLine$I$I$I$I(470, 275 + ((20.0 * this.mDb / 0.2)|0), 470 + ((200.0 * this.mLb / 2.0)|0), 275 + ((20.0 * this.mDb / 0.2)|0));
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(20, 163, 420, 163);
g.drawLine$I$I$I$I(20, 164, 420, 164);
g.drawLine$I$I$I$I(19, 8, 19, 413);
g.drawLine$I$I$I$I(20, 8, 20, 413);
for (var p=-5; p < 5; p++) {
for (p=-5; p < 5; p++) {
g.drawLine$I$I$I$I(20, 163 - p * 50, 17, 163 - p * 50);
}
}
for (var var12=1; var12 < 6; var12++) {
g.drawLine$I$I$I$I(20 + var12 * 80, 163, 20 + var12 * 80, 160);
}
g.setColor$java_awt_Color($I$(1).red);
this.mRecb[1]=0.0;
for (var var13=1; var13 < 400; var13++) {
var mw=var13 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
var mlambda=mw * Math.sqrt(3.9E-8);
var mAreab=3.141592653589793 * this.mDb * this.mDb  / 4.0;
if (var13 == 1) {
this.mRecb[1]=Math.tan(mlambda * this.mLb) / (mAreab * 2.0E11 * mlambda );
} else {
this.mRecb[var13]=Math.tan(mlambda * this.mLb) / (mAreab * 2.0E11 * mlambda );
if (!(!!(this.mRecb[var13 - 1] > 0.0  & this.mRecb[var13] < 0.0 )) && Math.abs(this.mRecb[var13 - 1]) < 1.0E-8  ) {
g.drawLine$I$I$I$I(20 + (var13 - 1), ((163.0 - this.mRecb[var13 - 1] * 2.5E10)|0), 20 + var13, ((163.0 - this.mRecb[var13] * 2.5E10)|0));
}}}
g.setColor$java_awt_Color($I$(1).blue);
this.mRecc[1]=0.0;
for (var var14=1; var14 < 400; var14++) {
var mw=var14 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
var mlambda=mw * Math.sqrt(3.9E-8);
var mAreac=3.141592653589793 * this.mDc * this.mDc  / 4.0;
if (var14 == 1) {
this.mRecc[1]=-1.0 / (mAreac * 2.0E11 * mlambda * Math.tan(mlambda * this.mLc) );
} else {
this.mRecc[var14]=-1.0 / (mAreac * 2.0E11 * mlambda * Math.tan(mlambda * this.mLc) );
if (!(!!(this.mRecc[var14 - 1] > 0.0  & this.mRecc[var14] < 0.0 )) && Math.abs(this.mRecc[var14 - 1]) < 1.0E-8  ) {
g.drawLine$I$I$I$I(20 + (var14 - 1), ((163.0 + this.mRecc[var14 - 1] * 2.5E10)|0), 20 + var14, ((163.0 + this.mRecc[var14] * 2.5E10)|0));
}}}
g.setColor$java_awt_Color($I$(1).black);
for (var var15=2; var15 < 400; var15++) {
if (!!(this.mRecb[var15 - 1] < -this.mRecc[var15 - 1]  & this.mRecb[var15] > -this.mRecc[var15] )) {
g.drawString$S$I$I($I$(2).nns$D(var15 * 5000.0 / 400.0) + "Hz", 20 + var15 + 1 , ((163.0 - this.mRecb[var15] * 2.5E10 + 10.0)|0));
}}
});

Clazz.newMeth(C$, 'ControlMessage$Complex_Prog4_Forcedresponse_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mLb=val;
break;
case 2:
this.mDb=val;
break;
case 3:
this.mLc=val;
break;
case 4:
this.mDc=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

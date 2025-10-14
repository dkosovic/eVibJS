(function(){var P$=Clazz.newPackage("Complex.Prog7.Forcedresponse"),I$=[[0,'java.awt.Color','Complex.Prog7.Forcedresponse.CUtility']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Complex.Prog7.Forcedresponse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mL=1.0;
this.mD=0.1;
this.mm=20.0;
this.mk=1.0E9;
},1);

C$.$fields$=[['D',['mL','mD','mm','mk'],'O',['mRec1','double[]','+mRec2']]]

Clazz.newMeth(C$, 'c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$Complex_Prog7_Forcedresponse_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
this.mRec1=Clazz.array(Double.TYPE, [450]);
this.mRec2=Clazz.array(Double.TYPE, [450]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(20, 213, 420, 213);
g.drawLine$I$I$I$I(20, 214, 420, 214);
g.drawLine$I$I$I$I(19, 418, 19, 8);
g.drawLine$I$I$I$I(20, 418, 20, 8);
for (var p=-4; p < 5; p++) {
g.drawLine$I$I$I$I(20, 213 - p * 50, 17, 213 - p * 50);
}
for (var var9=1; var9 < 6; var9++) {
g.drawLine$I$I$I$I(20 + var9 * 80, 213, 20 + var9 * 80, 210);
}
g.setColor$java_awt_Color($I$(1).red);
this.mRec1[1]=0.0;
for (var var10=1; var10 < 400; var10++) {
var mw=var10 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
var mlambda=mw * Math.sqrt(3.9E-8);
var mArea=3.141592653589793 * this.mD * this.mD  / 4.0;
if (var10 == 1) {
this.mRec1[1]=Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda );
} else {
this.mRec1[var10]=Math.tan(mlambda * this.mL) / (mArea * 2.0E11 * mlambda );
if (!!(this.mRec1[var10] > this.mRec1[var10 - 1]  & Math.abs(this.mRec1[var10 - 1]) < 1.2E-8 )) {
g.drawLine$I$I$I$I(20 + (var10 - 1), ((213.0 - this.mRec1[var10 - 1] * 2.5E10)|0), 20 + var10, ((213.0 - this.mRec1[var10] * 2.5E10)|0));
}}}
g.setColor$java_awt_Color($I$(1).blue);
this.mRec2[1]=0.0;
for (var var11=1; var11 < 400; var11++) {
var mw=var11 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
if (var11 == 1) {
this.mRec2[1]=1.0 / this.mk - 1.0 / (this.mm * mw * mw );
} else {
this.mRec2[var11]=1.0 / this.mk - 1.0 / (this.mm * mw * mw );
if (-this.mRec2[var11 - 1] < 5.0E-8 ) {
g.drawLine$I$I$I$I(20 + (var11 - 1), ((213.0 + this.mRec2[var11 - 1] * 2.5E10)|0), 20 + var11, ((213.0 + this.mRec2[var11] * 2.5E10)|0));
}}}
g.setColor$java_awt_Color($I$(1).black);
for (var var12=2; var12 < 400; var12++) {
if (!!(-this.mRec2[var12 - 1] >= this.mRec1[var12 - 1]  & this.mRec1[var12] >= -this.mRec2[var12] )) {
g.drawString$S$I$I($I$(2).nns$D(var12 * 5000.0 / 400.0) + "Hz", 20 + var12 + 1 , ((213.0 - this.mRec1[var12] * 2.5E10)|0));
}}
});

Clazz.newMeth(C$, 'ControlMessage$Complex_Prog7_Forcedresponse_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mL=val;
break;
case 2:
this.mD=val;
break;
case 3:
this.mm=val;
break;
case 4:
this.mk=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

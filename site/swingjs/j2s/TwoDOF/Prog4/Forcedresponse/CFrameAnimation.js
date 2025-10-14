(function(){var P$=Clazz.newPackage("TwoDOF.Prog4.Forcedresponse"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog4.Forcedresponse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mAmp1=Clazz.array(Double.TYPE, [2]);
this.mAmp11=Clazz.array(Double.TYPE, [2]);
this.mAmp12=Clazz.array(Double.TYPE, [2]);
this.mAmp2=Clazz.array(Double.TYPE, [2]);
this.mAmp21=Clazz.array(Double.TYPE, [2]);
this.mAmp22=Clazz.array(Double.TYPE, [2]);
},1);

C$.$fields$=[['D',['mK2divK1','mM2divM1'],'O',['mAmp1','double[]','+mAmp11','+mAmp12','+mAmp2','+mAmp21','+mAmp22']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$TwoDOF_Prog4_Forcedresponse_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mK2divK1=2.0;
this.mM2divM1=0.5;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
g.setPaintMode$();
Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(40, 7, 40, 313);
g.drawLine$I$I$I$I(37, 160, 343, 160);
for (var p=-3; p < 4; p++) {
g.drawLine$I$I$I$I(40, 160 - ((p * 50.0)|0), 37, 160 - ((p * 50.0)|0));
}
for (var var30=1; var30 < 6; var30++) {
g.drawLine$I$I$I$I(40 + var30 * 60, 160, 40 + var30 * 60, 157);
}
g.drawLine$I$I$I$I(40, 327, 40, 633);
g.drawLine$I$I$I$I(37, 480, 343, 480);
for (var var31=-3; var31 < 4; var31++) {
g.drawLine$I$I$I$I(40, 480 - ((var31 * 50.0)|0), 37, 480 - ((var31 * 50.0)|0));
}
for (var var32=1; var32 < 6; var32++) {
g.drawLine$I$I$I$I(40 + var32 * 60, 480, 40 + var32 * 60, 477);
}
this.mAmp1[0]=1.0;
this.mAmp2[0]=1.0;
var Q=this.mM2divM1;
var R=this.mK2divK1;
var c3=Q + Q * R + R;
var c4=Math.sqrt(c3 * c3 - 4.0 * R * Q );
var s1=(c3 - c4) / (2.0 * Q);
var s2=(c3 + c4) / (2.0 * Q);
var u1=1.0 / (1.0 - Q * s1 / R);
var u2=1.0 / (1.0 - Q * s2 / R);
var w1=Math.sqrt(s1);
var w2=Math.sqrt(s2);
var C1=(1.0 - u2) / (u1 - u2);
var C2=(u1 - 1.0) / (u1 - u2);
for (var var33=1; var33 < 300; var33++) {
var mr=var33 / 60.0;
this.mAmp11[1]=C1 / (1.0 - mr * mr / w1 / w1);
this.mAmp12[1]=C2 / (1.0 - mr * mr / w2 / w2);
this.mAmp21[1]=u1 * this.mAmp11[1];
this.mAmp22[1]=u2 * this.mAmp12[1];
this.mAmp1[1]=this.mAmp11[1] + this.mAmp12[1];
this.mAmp2[1]=this.mAmp21[1] + this.mAmp22[1];
if (var33 > 1) {
g.setColor$java_awt_Color($I$(1).red);
if (!!(!!(this.mAmp11[0] * this.mAmp11[1] > 0.0  & Math.abs(this.mAmp11[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp11[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((160.0 - this.mAmp11[0] * 50.0)|0), 40 + var33, ((160.0 - this.mAmp11[1] * 50.0)|0));
}g.setColor$java_awt_Color($I$(1).green);
if (!!(!!(this.mAmp12[0] * this.mAmp12[1] > 0.0  & Math.abs(this.mAmp12[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp12[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((160.0 - this.mAmp12[0] * 50.0)|0), 40 + var33, ((160.0 - this.mAmp12[1] * 50.0)|0));
}}g.setColor$java_awt_Color($I$(1).black);
if (!!(!!(this.mAmp1[0] * this.mAmp1[1] > 0.0  & Math.abs(this.mAmp1[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp1[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((160.0 - this.mAmp1[0] * 50.0)|0), 40 + var33, ((160.0 - this.mAmp1[1] * 50.0)|0));
}if (var33 > 1) {
g.setColor$java_awt_Color($I$(1).red);
if (!!(!!(this.mAmp21[0] * this.mAmp21[1] > 0.0  & Math.abs(this.mAmp21[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp21[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((480.0 - this.mAmp21[0] * 50.0)|0), 40 + var33, ((480.0 - this.mAmp21[1] * 50.0)|0));
}g.setColor$java_awt_Color($I$(1).green);
if (!!(!!(this.mAmp22[0] * this.mAmp22[1] > 0.0  & Math.abs(this.mAmp22[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp22[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((480.0 - this.mAmp22[0] * 50.0)|0), 40 + var33, ((480.0 - this.mAmp22[1] * 50.0)|0));
}}g.setColor$java_awt_Color($I$(1).black);
if (!!(!!(this.mAmp2[0] * this.mAmp2[1] > 0.0  & Math.abs(this.mAmp2[1] * 50.0) < 150.0 ) & Math.abs(this.mAmp2[0] * 50.0) < 150.0 )) {
g.drawLine$I$I$I$I(40 + (var33 - 1), ((480.0 - this.mAmp2[0] * 50.0)|0), 40 + var33, ((480.0 - this.mAmp2[1] * 50.0)|0));
}this.mAmp1[0]=this.mAmp1[1];
this.mAmp11[0]=this.mAmp11[1];
this.mAmp12[0]=this.mAmp12[1];
this.mAmp2[0]=this.mAmp2[1];
this.mAmp21[0]=this.mAmp21[1];
this.mAmp22[0]=this.mAmp22[1];
}
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, 6);
g.fillRect$I$I$I$I(0, 313, this.width, 10);
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog4_Forcedresponse_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mK2divK1=val;
break;
case 2:
this.mM2divM1=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

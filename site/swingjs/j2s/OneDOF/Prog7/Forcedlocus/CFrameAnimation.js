(function(){var P$=Clazz.newPackage("OneDOF.Prog7.Forcedlocus"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog7.Forcedlocus.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mXi=0.1;
this.mW=0.9;
},1);

C$.$fields$=[['D',['mXi','mW'],'O',['mAmp','double[]','+mPhase']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$OneDOF_Prog7_Forcedlocus_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
this.mAmp=Clazz.array(Double.TYPE, [302]);
this.mPhase=Clazz.array(Double.TYPE, [302]);
g.setPaintMode$();
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(40, 47, 40, 213);
g.drawLine$I$I$I$I(37, 210, 343, 210);
for (var p=1; p < 9; p++) {
g.drawLine$I$I$I$I(40, 210 - p * 20, 37, 210 - p * 20);
}
for (var var11=1; var11 < 7; var11++) {
g.drawLine$I$I$I$I(40 + var11 * 50, 210, 40 + var11 * 50, 213);
}
g.setColor$java_awt_Color(mass);
this.mAmp[0]=1.0;
var mAmp1=this.mAmp[0];
for (var var12=1; var12 < 301; var12++) {
var mr=var12 / 100.0;
this.mAmp[var12]=1.0 / Math.sqrt((1.0 - mr * mr) * (1.0 - mr * mr) + 2.0 * mr * this.mXi * (2.0 * mr * this.mXi ) );
g.drawLine$I$I$I$I(40 + (var12 - 1), ((210.0 - mAmp1 * 20.0)|0), 40 + var12, ((210.0 - this.mAmp[var12] * 20.0)|0));
mAmp1=this.mAmp[var12];
}
g.setColor$java_awt_Color(mass);
this.mPhase[0]=0.0;
var mPhase1=this.mPhase[0];
for (var var13=1; var13 < 301; var13++) {
var mr=var13 / 100.0;
this.mPhase[var13]=90.0;
if (var13 != 100) {
this.mPhase[var13]=180.0 * Math.atan(2.0 * mr * this.mXi  / (1.0 - mr * mr)) / 3.141592653589793;
if (this.mPhase[var13] < 0.0 ) {
this.mPhase[var13]=this.mPhase[var13] + 180.0;
}}g.drawLine$I$I$I$I(40 + (var13 - 1), ((240.0 + mPhase1 / 2.0)|0), 40 + var13, ((240.0 + this.mPhase[var13] / 2.0)|0));
mPhase1=this.mPhase[var13];
this.mPhase[var13]=this.mPhase[var13] * 3.141592653589793 / 180.0;
}
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(40, 237, 40, 333);
g.drawLine$I$I$I$I(37, 240, 343, 240);
for (var var14=1; var14 < 5; var14++) {
g.drawLine$I$I$I$I(40, 240 + ((var14 * 22.5)|0), 37, 240 + ((var14 * 22.5)|0));
}
for (var var15=1; var15 < 7; var15++) {
g.drawLine$I$I$I$I(40 + var15 * 50, 240, 40 + var15 * 50, 237);
}
var var16=((this.mW * 100.0)|0);
g.setColor$java_awt_Color($I$(1).green);
g.drawLine$I$I$I$I(40 + var16, 241, 40 + var16, ((239.0 + this.mPhase[var16] * 180.0 / (6.283185307179586))|0));
var mArcRadius=((this.mAmp[var16] * 20.0)|0);
if (mArcRadius > 26) {
mArcRadius=26;
}g.fillArc$I$I$I$I$I$I(520 - mArcRadius, 51 - mArcRadius, mArcRadius * 2, mArcRadius * 2, 0, ((-this.mPhase[var16] * 180.0 / 3.141592653589793)|0));
g.setColor$java_awt_Color($I$(1).white);
mArcRadius-=2;
g.fillArc$I$I$I$I$I$I(520 - mArcRadius, 51 - mArcRadius, mArcRadius * 2, mArcRadius * 2, 0, ((-this.mPhase[var16] * 180.0 / 3.141592653589793)|0));
g.setColor$java_awt_Color($I$(1).blue);
g.drawLine$I$I$I$I(40 + var16, 209, 40 + var16, ((211.0 - this.mAmp[var16] * 20.0)|0));
g.drawLine$I$I$I$I(520, 50, 520 + ((this.mAmp[var16] * Math.cos(this.mPhase[var16]) * 20.0 )|0), 50 + ((this.mAmp[var16] * Math.sin(this.mPhase[var16]) * 20.0 )|0));
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(390, 50, 650, 50);
g.drawLine$I$I$I$I(520, 47, 520, 313);
g.setColor$java_awt_Color(mass);
for (var var17=0; var17 < 300; var17++) {
g.drawLine$I$I$I$I(520 + ((this.mAmp[var17] * Math.cos(this.mPhase[var17]) * 20.0 )|0), 50 + ((this.mAmp[var17] * Math.sin(this.mPhase[var17]) * 20.0 )|0), 520 + ((this.mAmp[var17 + 1] * Math.cos(this.mPhase[var17 + 1]) * 20.0 )|0), 50 + ((this.mAmp[var17 + 1] * Math.sin(this.mPhase[var17 + 1]) * 20.0 )|0));
}
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog7_Forcedlocus_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mXi=val;
break;
case 2:
this.mW=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

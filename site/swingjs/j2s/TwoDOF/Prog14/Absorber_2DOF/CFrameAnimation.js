(function(){var P$=Clazz.newPackage("TwoDOF.Prog14.Absorber_2DOF"),I$=[[0,'java.awt.Color','TwoDOF.Prog14.Absorber_2DOF.CUtility']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog14.Absorber_2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm1=1.0;
this.mk1=40.0;
this.mc1=0.05;
this.mm2=0.1;
this.mxscale=60.0;
this.myscale=45.0;
},1);

C$.$fields$=[['D',['mm1','mk1','mc1','mm2','mk2','mc2','mW','mWin','mMax','mMax1','mMax2','A','B','C','mxscale','myscale'],'I',['mxpower','mypower'],'O',['mAmp','double[]','+mRealAmp','+mQuadAmp']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$TwoDOF_Prog14_Absorber_2DOF_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
this.mAmp=Clazz.array(Double.TYPE, [602]);
this.mRealAmp=Clazz.array(Double.TYPE, [602]);
this.mQuadAmp=Clazz.array(Double.TYPE, [602]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(77, 340, 563, 340);
for (var p=1; p < 9; p++) {
g.drawLine$I$I$I$I(80 + p * 60, 340, 80 + p * 60, 343);
}
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color(mass);
g.drawLine$I$I$I$I(80, 47, 80, 343);
for (var var9=0; var9 < 7; var9++) {
g.drawLine$I$I$I$I(80, 50 + var9 * 45, 77, 50 + var9 * 45);
}
this.Optimise$();
var mAmp1=this.mAmp[0];
for (var var10=1; var10 < 481; var10++) {
g.drawLine$I$I$I$I(80 + (var10 - 1), ((140.0 - Math.log(mAmp1) / Math.log(10.0) * this.myscale)|0), 80 + var10, ((140.0 - Math.log(this.mAmp[var10]) / Math.log(10.0) * this.myscale)|0));
mAmp1=this.mAmp[var10];
}
g.setColor$java_awt_Color($I$(1).black);
g.drawString$S$I$I(" Optimum values", 345, 54);
g.drawString$S$I$I(" Absorber stiffness", 345, 70);
g.drawString$S$I$I($I$(2).nns$D(this.mk2) + " N/m", 348, 86);
g.drawString$S$I$I(" Absorber damper", 345, 102);
g.drawString$S$I$I($I$(2).nns$D(this.mc2) + " Ns/m", 348, 118);
});

Clazz.newMeth(C$, 'Response$',  function () {
this.mAmp[0]=1.0 / this.mk1;
for (var p=1; p < 481; p++) {
this.mWin=(6.283185307179586) * p / this.mxscale;
var mD=this.mk2 * this.mk2 + this.mWin * this.mWin * this.mc2 * this.mc2 ;
var mA=this.mk2 / mD - 1.0 / (this.mm2 * this.mWin * this.mWin );
var mB=-this.mWin * this.mc2 / mD;
var mC=this.mk1 - this.mm1 * this.mWin * this.mWin  + mA / (mA * mA + mB * mB);
mD=this.mWin * this.mc1 - mB / (mA * mA + mB * mB);
this.mRealAmp[p]=mC / (mC * mC + mD * mD);
this.mQuadAmp[p]=-mD / (mC * mC + mD * mD);
this.mAmp[p]=Math.sqrt(this.mRealAmp[p] * this.mRealAmp[p] + this.mQuadAmp[p] * this.mQuadAmp[p]);
}
});

Clazz.newMeth(C$, 'Maximum$',  function () {
this.mMax=this.mAmp[0];
for (var p=1; p < 481; p++) {
if (this.mAmp[p] > this.mMax ) {
this.mMax=this.mAmp[p];
}}
});

Clazz.newMeth(C$, 'Optimise$',  function () {
var Q=this.mm2 / this.mm1;
var R=Q / ((1.0 + Q) * (1.0 + Q));
this.mk2=this.mk1 * R;
this.mc2=Math.sqrt(this.mm2 * this.mk2 * 3.0 * Q  / (8.0 * (1.0 + Q) * (1.0 + Q) * (1.0 + Q) )) * 2.0;
var minck2=0.1 * this.mk2;
var mincc2=0.1 * this.mc2;
this.Response$();
this.Maximum$();
this.mMax1=this.mMax;
for (var p=1; p < 4; p++) {
this.mk2+=minck2;
this.Response$();
this.Maximum$();
this.mMax2=this.mMax;
if (this.mMax2 < this.mMax1 ) {
while (this.mMax2 < this.mMax1 ){
this.mMax1=this.mMax2;
this.mk2+=minck2;
this.Response$();
this.Maximum$();
this.mMax2=this.mMax;
}
} else {
this.mk2-=2.0 * minck2;
this.Response$();
this.Maximum$();
for (this.mMax2=this.mMax; this.mMax2 < this.mMax1 ; this.mMax2=this.mMax) {
this.mMax1=this.mMax2;
this.mk2-=minck2;
this.Response$();
this.Maximum$();
}
}this.Response$();
this.Maximum$();
this.mMax1=this.mMax;
this.mc2+=mincc2;
this.Response$();
this.Maximum$();
this.mMax2=this.mMax;
if (this.mMax2 < this.mMax1 ) {
while (this.mMax2 < this.mMax1 ){
this.mMax1=this.mMax2;
this.mc2+=mincc2;
this.Response$();
this.Maximum$();
this.mMax2=this.mMax;
}
} else {
this.mc2-=2.0 * mincc2;
this.Response$();
this.Maximum$();
for (this.mMax2=this.mMax; this.mMax2 < this.mMax1 ; this.mMax2=this.mMax) {
this.mMax1=this.mMax2;
this.mc2-=mincc2;
this.Response$();
this.Maximum$();
}
}minck2=0.1 * minck2;
mincc2=0.1 * mincc2;
}
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog14_Absorber_2DOF_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mm1=val;
break;
case 2:
this.mk1=val;
break;
case 3:
this.mc1=val;
break;
case 4:
this.mm2=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

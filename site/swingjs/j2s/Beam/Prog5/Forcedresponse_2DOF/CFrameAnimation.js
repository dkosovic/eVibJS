(function(){var P$=Clazz.newPackage("Beam.Prog5.Forcedresponse_2DOF"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Beam.Prog5.Forcedresponse_2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm=1.0;
this.mk1=20.0;
this.mk2=20.0;
this.mb=0.3;
this.mxscale=60.0;
this.myscale=45.0;
},1);

C$.$fields$=[['D',['mm','mk1','mk2','mb','mW','mWmin','mWmax','mxscale','myscale'],'I',['mxpower','mypower'],'O',['mAmp','double[]','+mX1overF','+mX2overF']]]

Clazz.newMeth(C$, 'c$$Beam_Prog5_Forcedresponse_2DOF_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$Beam_Prog5_Forcedresponse_2DOF_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
this.mX1overF=Clazz.array(Double.TYPE, [602]);
this.mX2overF=Clazz.array(Double.TYPE, [602]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(77, 340, 563, 340);
for (var p=1; p < 9; p++) {
g.drawLine$I$I$I$I(80 + p * 60, 340, 80 + p * 60, 343);
}
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(80, 47, 80, 343);
for (var var18=0; var18 < 7; var18++) {
g.drawLine$I$I$I$I(80, 50 + var18 * 45, 77, 50 + var18 * 45);
}
var force=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
g.setColor$java_awt_Color(force);
g.drawLine$I$I$I$I(465 + ((132.0 * this.mb)|0) - 2, 84, 465 + ((132.0 * this.mb)|0) - 2, 86);
g.drawLine$I$I$I$I(465 + ((132.0 * this.mb)|0) - 1, 82, 465 + ((132.0 * this.mb)|0) - 1, 107);
g.drawLine$I$I$I$I(465 + ((132.0 * this.mb)|0), 80, 465 + ((132.0 * this.mb)|0), 107);
g.drawLine$I$I$I$I(465 + ((132.0 * this.mb)|0) + 1 , 82, 465 + ((132.0 * this.mb)|0) + 1 , 107);
g.drawLine$I$I$I$I(465 + ((132.0 * this.mb)|0) + 2 , 84, 465 + ((132.0 * this.mb)|0) + 2 , 86);
g.setColor$java_awt_Color($I$(1).black);
g.drawString$S$I$I("F", 470 + ((132.0 * this.mb)|0), 100);
this.mX1overF[0]=(1.0 - this.mb) / this.mk1;
var mAmp1=this.mX1overF[0];
this.mX2overF[0]=this.mb / this.mk2;
var mAmp2=this.mX2overF[0];
for (var var19=1; var19 < 481; var19++) {
g.setColor$java_awt_Color($I$(1).red);
var mWin=(6.283185307179586) * var19 / this.mxscale;
var mA=12.0 * this.mk2 * (1.0 - this.mb)  - this.mm * mWin * mWin * (4.0 - 6.0 * this.mb) ;
var mB=0.0;
var mC=(4.0 * this.mk1 - this.mm * mWin * mWin ) * (4.0 * this.mk2 - this.mm * mWin * mWin ) - 4.0 * this.mk2 * this.mk1 ;
var mD=0.0;
this.mX1overF[var19]=Math.sqrt((mA * mA + mB * mB) / (mC * mC + mD * mD));
g.drawLine$I$I$I$I(80 + (var19 - 1), ((95.0 - Math.log(mAmp1) / Math.log(10.0) * this.myscale)|0), 80 + var19, ((95.0 - Math.log(this.mX1overF[var19]) / Math.log(10.0) * this.myscale)|0));
mAmp1=this.mX1overF[var19];
g.setColor$java_awt_Color($I$(1).blue);
mA=12.0 * this.mk1 * this.mb  + this.mm * mWin * mWin * (2.0 - 6.0 * this.mb) ;
mB=0.0;
this.mX2overF[var19]=Math.sqrt((mA * mA + mB * mB) / (mC * mC + mD * mD));
g.drawLine$I$I$I$I(80 + (var19 - 1), ((95.0 - Math.log(mAmp2) / Math.log(10.0) * this.myscale)|0), 80 + var19, ((95.0 - Math.log(this.mX2overF[var19]) / Math.log(10.0) * this.myscale)|0));
mAmp2=this.mX2overF[var19];
}
});

Clazz.newMeth(C$, 'ControlMessage$Beam_Prog5_Forcedresponse_2DOF_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mm=val;
break;
case 2:
this.mk1=val;
break;
case 3:
this.mk2=val;
break;
case 4:
this.mb=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:47 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("TwoDOF.Prog7.Abutmentresponse_2DOF"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog7.Abutmentresponse_2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm1=0.1;
this.mk1=20.0;
this.mc1=0.05;
this.mm2=0.1;
this.mk2=20.0;
this.mc2=0.05;
this.A=this.mm1 * this.mm2;
this.B=-(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
this.C=this.mk1 * this.mk2;
},1);

C$.$fields$=[['D',['mm1','mk1','mc1','mm2','mk2','mc2','mW','mWn1','mWn2','mWmin','mWmax','A','B','C','mxscale','myscale'],'I',['mxpower','mypower'],'O',['mAmp','double[]','+mRealAmp','+mQuadAmp','+mPhase']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog7_Abutmentresponse_2DOF_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$TwoDOF_Prog7_Abutmentresponse_2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mWn1=Math.sqrt((-this.B - Math.sqrt(this.B * this.B - 4.0 * this.A * this.C )) / (2.0 * this.A)) / (6.283185307179586);
this.mWn2=Math.sqrt((-this.B + Math.sqrt(this.B * this.B - 4.0 * this.A * this.C )) / (2.0 * this.A)) / (6.283185307179586);
this.mWmin=0.1 * this.mWn1;
this.mWmax=1.5 * this.mWn2;
this.mxscale=60.0;
this.myscale=45.0;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mAmp=Clazz.array(Double.TYPE, [602]);
this.mRealAmp=Clazz.array(Double.TYPE, [602]);
this.mQuadAmp=Clazz.array(Double.TYPE, [602]);
this.mPhase=Clazz.array(Double.TYPE, [602]);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(77, 340, 563, 340);
for (var var2=1; var2 < 9; var2++) {
var1.drawLine$I$I$I$I(80 + var2 * 60, 340, 80 + var2 * 60, 343);
}
var var18=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var18);
var1.drawLine$I$I$I$I(80, 47, 80, 343);
for (var var20=0; var20 < 7; var20++) {
var1.drawLine$I$I$I$I(80, 50 + var20 * 45, 77, 50 + var20 * 45);
}
this.mAmp[0]=1.0;
var var3=this.mAmp[0];
for (var var21=1; var21 < 481; var21++) {
var var7=(6.283185307179586) * var21 / this.mxscale;
var var15=this.mk2 * this.mk2 + var7 * var7 * this.mc2 * this.mc2 ;
var var9=this.mk2 / var15 - 1.0 / (this.mm2 * var7 * var7 );
var var11=-var7 * this.mc2 / var15;
var var13=this.mk1 - this.mm1 * var7 * var7  + var9 / (var9 * var9 + var11 * var11);
var15=var7 * this.mc1 - var11 / (var9 * var9 + var11 * var11);
var9=var13 / (var13 * var13 + var15 * var15);
var11=-var15 / (var13 * var13 + var15 * var15);
this.mRealAmp[var21]=var9 * this.mk1 - var11 * var7 * this.mc1 ;
this.mQuadAmp[var21]=var9 * var7 * this.mc1  + var11 * this.mk1;
this.mAmp[var21]=Math.sqrt(this.mRealAmp[var21] * this.mRealAmp[var21] + this.mQuadAmp[var21] * this.mQuadAmp[var21]);
var1.drawLine$I$I$I$I(80 + (var21 - 1), ((140.0 - Math.log(var3) / Math.log(10.0) * this.myscale)|0), 80 + var21, ((140.0 - Math.log(this.mAmp[var21]) / Math.log(10.0) * this.myscale)|0));
var3=this.mAmp[var21];
}
var var19=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setColor$java_awt_Color(var19);
this.mPhase[0]=0.0;
var var5=this.mPhase[0];
for (var var22=1; var22 < 481; var22++) {
this.mPhase[var22]=180.0 * Math.atan(this.mQuadAmp[var22] / this.mRealAmp[var22]) / 3.141592653589793;
if (this.mPhase[var22] > 0.0  && this.mQuadAmp[var22] < 0.0  ) {
this.mPhase[var22]=this.mPhase[var22] - 180.0;
}var1.drawLine$I$I$I$I(80 + (var22 - 1), ((130.0 - var5 / 2.0)|0), 80 + var22, ((130.0 - this.mPhase[var22] / 2.0)|0));
var5=this.mPhase[var22];
this.mPhase[var22]=this.mPhase[var22] * 3.141592653589793 / 180.0;
}
var1.drawLine$I$I$I$I(560, 127, 560, 343);
for (var var23=0; var23 < 9; var23++) {
var1.drawLine$I$I$I$I(560, 130 + ((var23 * 22.5)|0), 563, 130 + ((var23 * 22.5)|0));
}
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog7_Abutmentresponse_2DOF_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mm1=var3;
break;
case 2:
this.mk1=var3;
break;
case 3:
this.mc1=var3;
break;
case 4:
this.mm2=var3;
break;
case 5:
this.mk2=var3;
break;
case 6:
this.mc2=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

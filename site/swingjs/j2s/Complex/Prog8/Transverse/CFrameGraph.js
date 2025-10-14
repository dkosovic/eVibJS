(function(){var P$=Clazz.newPackage("Complex.Prog8.Transverse"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Complex.Prog8.Transverse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec1=Clazz.array(Double.TYPE, [401]);
this.mRec2=Clazz.array(Double.TYPE, [401]);
this.mRec3=Clazz.array(Double.TYPE, [401]);
this.mL=1.2;
this.mD1=0.15;
this.mm=2.0;
this.mk=393000.0;
this.malpha=0.25;
},1);

C$.$fields$=[['D',['mL','mD1','mm','mk','malpha','mlambda1','mw','mArea1','mInertia1','mTime'],'O',['mRec1','double[]','+mRec2','+mRec3']]]

Clazz.newMeth(C$, 'c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Complex_Prog8_Transverse_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var var3=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(38, 370, 440, 370);
var1.drawLine$I$I$I$I(38, 371, 440, 371);
var1.drawLine$I$I$I$I(39, 374, 39, 15);
var1.drawLine$I$I$I$I(40, 374, 40, 15);
for (var var2=0; var2 < 8; var2++) {
var1.drawLine$I$I$I$I(40, 370 - var2 * 50, 37, 370 - var2 * 50);
}
for (var var5=1; var5 < 5; var5++) {
var1.drawLine$I$I$I$I(40 + var5 * 100, 370, 40 + var5 * 100, 374);
}
this.response$();
var1.setColor$java_awt_Color($I$(1).red);
for (var var6=2; var6 < 400; var6++) {
var1.drawLine$I$I$I$I(40 + (var6 - 1), ((370.0 - Math.abs(this.mRec1[var6 - 1] * 1.0E8))|0), 40 + var6, ((370.0 - Math.abs(this.mRec1[var6] * 1.0E8))|0));
}
var1.setColor$java_awt_Color(var3);
for (var var7=2; var7 < 400; var7++) {
var1.drawLine$I$I$I$I(40 + (var7 - 1), ((370.0 - this.mRec3[var7 - 1] * 1.0E8)|0), 40 + var7, ((370.0 - this.mRec3[var7] * 1.0E8)|0));
}
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, 440, 20);
});

Clazz.newMeth(C$, 'log10$D',  function (var1) {
return Math.log(var1) / Math.log(10.0);
});

Clazz.newMeth(C$, 'nns$D$I',  function (var1, var3) {
if (var3 <= 0) {
var3=1;
}if (var1 == 0.0 ) {
return "0";
} else if (var1 < 0.0 ) {
return "-" + this.nns$D$I(-var1, var3);
} else {
var var4=Math.floor(this.log10$D(var1));
var var6=Math.pow(10.0, var4 - var3 + 1.0);
var var8=Math.round$D(var1 / var6);
var var10=String.valueOf$D(var8 * var6);
while (var10.length$() > 1 && var10.indexOf$I(46) > -1 ){
var var11=false;
var var12;
for (var12=var10.length$() - 1; var10.charAt$I(var12) == "0"; var11=true) {
--var12;
}
if (var11) {
var10=var10.substring$I$I(0, var12 + 1);
}var var13=var10.substring$I$I(0, var12);
var var14;
try {
var14=java.lang.Double.parseDouble$S(var13);
} catch (var15) {
if (Clazz.exceptionOf(var15,"NumberFormatException")){
break;
} else {
throw var15;
}
}
if (Math.abs(var1 - var14) > var6 ) {
break;
}var10=var13;
}
return var10;
}});

Clazz.newMeth(C$, 'nns$D',  function (var1) {
return this.nns$D$I(var1, 4);
});

Clazz.newMeth(C$, 'ControlMessage$Complex_Prog8_Transverse_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mL=var3;
this.response$();
break;
case 2:
this.mD1=var3;
this.response$();
break;
case 3:
this.mm=var3;
this.response$();
break;
case 4:
this.mk=var3;
this.response$();
break;
case 5:
this.malpha=var3;
this.response$();
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
this.mArea1=3.141592653589793 * this.mD1 * this.mD1  / 4.0;
this.mInertia1=this.mArea1 * this.mD1 * this.mD1  / 16.0;
for (var var1=1; var1 < 401; var1++) {
this.mw=var1 * 200.0 * 2.0 * 3.141592653589793  / 400.0;
this.mlambda1=Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea1 * 7800.0  / (2.0E11 * this.mInertia1)));
var var14=this.mlambda1 * this.mL;
var var2=Math.sin(var14);
var var4=Math.cos(var14);
var var16=Math.exp(var14);
var var6=(var16 - 1.0 / var16) / 2.0;
var var8=(var16 + 1.0 / var16) / 2.0;
var var10=var4 * var8 + 1.0;
var var12=var4 * var6 - var2 * var8;
var var18=1.0 / (2.0E11 * this.mInertia1 * this.mlambda1 * this.mlambda1 * this.mlambda1 * var10 );
this.mRec1[var1]=-var12 * var18;
this.mRec2[var1]=-1.0 / (this.mm * this.mw * this.mw );
var var20=this.mRec2[var1] + 1.0 / this.mk / (1.0 + this.malpha * this.malpha) ;
var var22=-this.malpha / this.mk / (1.0 + this.malpha * this.malpha) ;
var var24=1.0 / this.mRec1[var1] + var20 / (var20 * var20 + var22 * var22);
var var26=-var22 / (var20 * var20 + var22 * var22);
this.mRec3[var1]=Math.abs(1.0 / Math.sqrt(var24 * var24 + var26 * var26));
}
});

Clazz.newMeth(C$, 'GetTime$',  function () {
return this.mTime;
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevh1t) {
if (prevh1t) {
return false;
} else {
switch (code) {
case 0:
case 1:
var newOmega=(this.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
if (newOmega > 5000.0 ) {
newOmega=5000.0;
}if (newOmega < 50.0 ) {
newOmega=50.0;
}default:
return true;
}
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

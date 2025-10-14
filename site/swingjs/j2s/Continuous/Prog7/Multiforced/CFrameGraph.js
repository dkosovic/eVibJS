(function(){var P$=Clazz.newPackage("Continuous.Prog7.Multiforced"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Continuous.Prog7.Multiforced.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec=Clazz.array(Double.TYPE, [401]);
this.mxp=Clazz.array(Double.TYPE, [31]);
this.mL=2.0;
this.mDo=0.05;
this.mDL=0.2;
this.mWanimate=500.0;
this.mTime=0.0;
},1);

C$.$fields$=[['D',['mL','mDo','mDL','mWanimate','mlambda','mw','mArea','mz','mB','mXi','mTime'],'O',['mRec','double[]','+mxp']]]

Clazz.newMeth(C$, 'c$$Continuous_Prog7_Multiforced_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Continuous_Prog7_Multiforced_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var var5=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(40, 370, 440, 370);
var1.drawLine$I$I$I$I(40, 371, 440, 371);
var1.drawLine$I$I$I$I(39, 30, 39, 375);
var1.drawLine$I$I$I$I(40, 30, 40, 375);
var var3=1.0E-5;
for (var var2=1; var2 < 8; var2++) {
var3/=10.0;
var1.drawLine$I$I$I$I(40, ((-220.0 - Math.log(var3) * 20.0)|0), 37, ((-220.0 - Math.log(var3) * 20.0)|0));
}
for (var var7=1; var7 < 6; var7++) {
var1.drawLine$I$I$I$I(40 + var7 * 80, 370, 40 + var7 * 80, 367);
}
var1.setColor$java_awt_Color(var5);
this.response$();
for (var var8=2; var8 < 400; var8++) {
var1.drawLine$I$I$I$I(40 + (var8 - 1), ((-220.0 - Math.log(this.mRec[var8 - 1]) * 20.0)|0), 40 + var8, ((-220.0 - Math.log(this.mRec[var8]) * 20.0)|0));
}
var var9=((this.mWanimate * 400.0 / 5000.0)|0);
var1.setColor$java_awt_Color($I$(1).blue);
var1.drawLine$I$I$I$I(40 + var9, 370, 40 + var9, ((-220.0 - Math.log(this.mRec[var9]) * 20.0)|0));
var1.drawLine$I$I$I$I(40 + var9, 373, 40 + var9, 368);
var1.drawString$S$I$I(this.nns$D(this.mWanimate) + " Hz", 40 + var9 + 2 , 385);
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

Clazz.newMeth(C$, 'DrawModeShape$java_awt_Graphics$I$I',  function (var1, var2, var3) {
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 390, 600, 190);
var1.fillRect$I$I$I$I(0, 0, 450, 20);
var var12=60;
var var13=1.0472;
var var15=($s$[0] = 430, $s$[0]);
var var17=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var var18=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setColor$java_awt_Color(var17);
this.setOmegaDisp$D(this.mWanimate);
var var5=0.0;
for (var var4=0; var4 < 31; var4++) {
var5=this.mxp[var4] * Math.cos(0.7 * this.mTime * 2.0 * 3.141592653589793 );
var var9=((250.0 * (this.mDo / 2.0 + (this.mDL - this.mDo) * var4 / 60.0))|0);
if (var4 == 0) {
;}var1.drawArc$I$I$I$I$I$I(var12 + ((250.0 * var4 * this.mL  / 30.0)|0) - ((var9 * Math.cos(var13) - var5)|0), var15 - var9, var9, var9 * 2, 90, 180);
}
var var19=((250.0 * this.mDL / 2.0)|0);
var1.drawArc$I$I$I$I$I$I(var12 + ((250.0 * this.mL)|0) - ((var19 * Math.cos(var13) - var5)|0), var15 - var19, var19, var19 * 2, 0, 360);
var1.setColor$java_awt_Color(var18);
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19, var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 10 );
var var16=((20.0 * Math.cos(0.7 * this.mTime * 2.0 * 3.141592653589793 ))|0);
if (var16 != 0) {
if (var16 > 0) {
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 5 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 5 );
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 6 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 + 1 , var15 + var19 + 6 );
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 7 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 7 );
}if (var16 < 0) {
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 5 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 5 );
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 6 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16  - 1, var15 + var19 + 6 );
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 7 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 7 );
}}var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 5 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 5 );
var1.drawLine$I$I$I$I(var12 + ((250.0 * this.mL)|0) + (var5|0) , var15 + var19 + 6 , var12 + ((250.0 * this.mL)|0) + (var5|0) + var16 , var15 + var19 + 6 );
});

Clazz.newMeth(C$, 'ControlMessage$Continuous_Prog7_Multiforced_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mL=var3;
this.response$();
break;
case 2:
this.mDo=var3;
if (this.mDo == this.mDL ) {
this.mDo+=0.001;
}this.response$();
break;
case 3:
this.mDL=var3;
if (this.mDL == this.mDo ) {
this.mDL+=0.001;
}this.response$();
break;
case 4:
this.mWanimate=var3;
this.setOmegaDisp$D(this.mWanimate);
var5=true;
break;
case 5:
this.mTime+=var3;
var5=true;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
for (var var1=1; var1 < 401; var1++) {
this.mw=var1 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
var var8=this.mw * Math.sqrt(3.9E-8);
var var2=this.mDo / 2.0;
var var4=this.mDL / 2.0;
var var6=(var4 - var2) / this.mL;
var var10=var8 * var2 / var6;
var var12=var8 * this.mL + var10;
var var14=var10 * var10;
var var16=var12 * var12;
var var18=Math.sin(var10);
var var20=Math.cos(var10);
var var22=Math.sin(var12);
var var24=Math.cos(var12);
var var26=var20 / var10 - var18 / var14;
var var28=var24 / var16 + var22 / var12;
var var30=var20 / var14 + var18 / var10;
var var32=var24 / var12 - var22 / var16;
var var34=var20 / var10 - var18 / var14;
var var36=var26 * var28 - var30 * var32;
this.mRec[var1]=Math.abs(-1.0 * (var30 * var22 + var34 * var24) / (6.283185307179586E11 * var4 * var4 * var8 * var36 * var12 ));
}
this.setOmegaDisp$D(this.mWanimate);
});

Clazz.newMeth(C$, 'setOmegaDisp$D',  function (var1) {
var var4=0.0;
var var14=var1 * 2.0 * 3.141592653589793 * Math.sqrt(3.9E-8) ;
for (var var3=0; var3 < 31; var3++) {
var var8=this.mDo / 2.0;
var var10=this.mDL / 2.0;
var var12=(var10 - var8) / this.mL;
var var24=var14 * (var3 * this.mL / 30.0 + var8 / var12);
var var16=var14 * var8 / var12;
var var18=var14 * this.mL + var16;
var var20=var16 * var16;
var var22=var18 * var18;
var var26=Math.sin(var16);
var var28=Math.cos(var16);
var var30=Math.sin(var18);
var var32=Math.cos(var18);
var var34=var28 / var16 - var26 / var20;
var var36=var32 / var22 + var30 / var18;
var var38=var28 / var20 + var26 / var16;
var var40=var32 / var18 - var30 / var22;
var var42=var28 / var16 - var26 / var20;
var var44=var34 * var36 - var38 * var40;
this.mxp[var3]=-1.0 * (var38 * Math.sin(var24) + var42 * Math.cos(var24)) / (6.283185307179586E11 * var10 * var10 * var14 * var44 * var24 );
var var6=Math.abs(this.mxp[var3]);
if (Math.abs(var6) > Math.abs(var4) ) {
var4=Math.abs(var6);
}}
for (var var46=0; var46 < 31; var46++) {
this.mxp[var46]=this.mxp[var46] * 20.0 / var4;
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
var newOmega=(this.mFramePanel.mThisPt.x - 40) * 5000.0 / 400.0;
if (newOmega > 5000.0 ) {
newOmega=5000.0;
}if (newOmega < 50.0 ) {
newOmega=50.0;
}this.ControlMessage$Continuous_Prog7_Multiforced_CFrame$I$D(this, 4, newOmega);
default:
return true;
}
}});
var $s$ = new Int16Array(1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

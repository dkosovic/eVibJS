(function(){var P$=Clazz.newPackage("Continuous.Prog12.Transverse"),I$=[[0,'java.awt.Color','java.awt.Polygon']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Continuous.Prog12.Transverse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec=Clazz.array(Double.TYPE, [401]);
this.mxp=Clazz.array(Double.TYPE, [31]);
this.mAmp=Clazz.array(Double.TYPE, [31]);
this.mL=1.5;
this.mB=0.12;
this.mH=0.12;
this.mWanimate=500.0;
this.mTime=0.0;
},1);

C$.$fields$=[['D',['mL','mB','mH','mWanimate','mlambda','mw','mArea','mInertia','mTime'],'O',['mRec','double[]','+mxp','+mAmp']]]

Clazz.newMeth(C$, 'c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Continuous_Prog12_Transverse_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
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
for (var var2=0; var2 < 12; var2++) {
var1.drawLine$I$I$I$I(40, 370 - var2 * 30, 37, 370 - var2 * 30);
}
for (var var5=1; var5 < 6; var5++) {
var1.drawLine$I$I$I$I(40 + var5 * 80, 370, 40 + var5 * 80, 367);
}
var1.setColor$java_awt_Color(var3);
this.response$();
for (var var6=2; var6 < 400; var6++) {
var1.drawLine$I$I$I$I(40 + (var6 - 1), ((10.0 - Math.log(Math.abs(this.mRec[var6 - 1])) / Math.log(10.0) * 30.0)|0), 40 + var6, ((10.0 - Math.log(Math.abs(this.mRec[var6])) / Math.log(10.0) * 30.0)|0));
}
var var7=((this.mWanimate * 400.0 / 5000.0)|0);
var1.setColor$java_awt_Color($I$(1).blue);
var1.drawLine$I$I$I$I(40 + var7, 370, 40 + var7, ((10.0 - Math.log(Math.abs(this.mRec[var7])) / Math.log(10.0) * 30.0)|0));
var1.drawLine$I$I$I$I(40 + var7, 373, 40 + var7, 368);
var1.drawString$S$I$I(this.nns$D(this.mWanimate) + " Hz", 40 + var7 + 2 , 385);
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
var var8=20;
var var10=30;
var var11=1.0472;
var var13=($s$[0] = 470, $s$[0]);
var var15=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var var16=Clazz.new_($I$(1,1).c$$F$F$F,[0.52, 0.82, 0.82]);
var var17=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
Clazz.new_($I$(1,1).c$$F$F$F,[1.0, 1.0, 0.4]);
var var20=90;
var var21=((var20 * Math.cos(var11) / 2.0)|0);
this.setOmegaDisp$D(this.mWanimate);
this.mAmp[0]=0.0;
for (var var4=0; var4 < 31; var4++) {
this.mAmp[var4]=this.mxp[var4] * Math.cos(0.7 * this.mTime * 2.0 * 3.141592653589793 );
}
var1.setColor$java_awt_Color(var16);
var var23=Clazz.new_($I$(2,1));
var var24=((250.0 * this.mB * Math.cos(var11)  / 2.0)|0);
var var25=((250.0 * this.mB * Math.sin(var11)  / 2.0)|0);
for (var var28=0; var28 < 31; var28++) {
var23.addPoint$I$I(var8 + var10 + var21 + ((var28 * 250.0 * this.mL  / 30.0)|0)  - var24, var13 - ((this.mAmp[var28] - this.mH * 250.0 / 2.0)|0) + var25);
}
var23.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0)  - var24, var13 - ((this.mAmp[30] + this.mH * 250.0 / 2.0)|0) + var25);
for (var var29=29; var29 > -1; var29--) {
var23.addPoint$I$I(var8 + var10 + var21 + ((var29 * 250.0 * this.mL  / 30.0)|0)  - var24, var13 - ((this.mAmp[var29] + this.mH * 250.0 / 2.0)|0) + var25);
}
var1.drawPolygon$java_awt_Polygon(var23);
var1.fillPolygon$java_awt_Polygon(var23);
var1.setColor$java_awt_Color(var15);
var var26=Clazz.new_($I$(2,1));
for (var var30=0; var30 < 31; var30++) {
var26.addPoint$I$I(var8 + var10 + var21 + ((var30 * 250.0 * this.mL  / 30.0)|0)  - var24, var13 - ((this.mAmp[var30] + this.mH * 250.0 / 2.0)|0) + var25);
}
var26.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0) + var24 , var13 - ((this.mAmp[30] + this.mH * 250.0 / 2.0)|0) - var25 );
for (var var31=29; var31 > -1; var31--) {
var26.addPoint$I$I(var8 + var10 + var21 + ((var31 * 250.0 * this.mL  / 30.0)|0) + var24 , var13 - ((this.mAmp[var31] + this.mH * 250.0 / 2.0)|0) - var25 );
}
var1.drawPolygon$java_awt_Polygon(var26);
var1.fillPolygon$java_awt_Polygon(var26);
var1.setColor$java_awt_Color(var15);
var var27=Clazz.new_($I$(2,1));
var27.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0)  - var24, var13 - ((this.mAmp[30] + this.mH * 250.0 / 2.0)|0) + var25);
var27.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0) + var24 , var13 - ((this.mAmp[30] + this.mH * 250.0 / 2.0)|0) - var25 );
var27.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0) + var24 , var13 - ((this.mAmp[30] - this.mH * 250.0 / 2.0)|0) - var25 );
var27.addPoint$I$I(var8 + var10 + var21 + ((250.0 * this.mL)|0)  - var24, var13 - ((this.mAmp[30] - this.mH * 250.0 / 2.0)|0) + var25);
var1.drawPolygon$java_awt_Polygon(var27);
var1.fillPolygon$java_awt_Polygon(var27);
var1.setColor$java_awt_Color(var17);
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 20 , var13 - (this.mAmp[30]|0));
var var14=((20.0 * Math.cos(0.7 * this.mTime * 2.0 * 3.141592653589793 ))|0);
if (var14 != 0) {
if (var14 > 0) {
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 12 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 12 , var13 - var14 - (this.mAmp[30]|0) );
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 13 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 13 , var13 - var14 - (this.mAmp[30]|0) - 1 );
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 14 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 14 , var13 - var14 - (this.mAmp[30]|0) );
}if (var14 < 0) {
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 12 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 12 , var13 - var14 - (this.mAmp[30]|0) );
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 13 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 13 , var13 - var14 - (this.mAmp[30]|0)  + 1);
var1.drawLine$I$I$I$I(var8 + var10 + ((250.0 * this.mL)|0) + var21 + 14 , var13 - (this.mAmp[30]|0), var8 + var10 + ((250.0 * this.mL)|0) + var21 + 14 , var13 - var14 - (this.mAmp[30]|0) );
}}});

Clazz.newMeth(C$, 'ControlMessage$Continuous_Prog12_Transverse_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mL=var3;
this.response$();
break;
case 2:
this.mB=var3;
this.response$();
break;
case 3:
this.mH=var3;
this.response$();
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
this.mArea=3.141592653589793 * this.mB * this.mH ;
this.mInertia=this.mArea * this.mH * this.mH  / 12.0;
for (var var1=1; var1 < 401; var1++) {
this.mw=var1 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
this.mlambda=Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0  / (2.0E11 * this.mInertia)));
var var14=this.mlambda * this.mL;
var var2=Math.sin(var14);
var var4=Math.cos(var14);
var var16=Math.exp(var14);
var var6=(var16 - 1.0 / var16) / 2.0;
var var8=(var16 + 1.0 / var16) / 2.0;
var var10=var4 * var8 - 1.0;
var var12=var4 * var6 - var2 * var8;
var var18=1.0 / (2.0E11 * this.mInertia * this.mL * this.mL * this.mL * var10 );
this.mRec[var1]=-var12 * var18;
}
this.setOmegaDisp$D(this.mWanimate);
});

Clazz.newMeth(C$, 'setOmegaDisp$D',  function (var1) {
this.mArea=3.141592653589793 * this.mB * this.mH ;
this.mInertia=this.mArea * this.mH * this.mH  / 12.0;
this.mlambda=Math.sqrt(Math.sqrt(var1 * 2.0 * 3.141592653589793 * var1 * 2.0 * 3.141592653589793 * this.mArea * 7800.0  / (2.0E11 * this.mInertia)));
var var12=this.mlambda * this.mL;
var var14=Math.sin(var12);
var var16=Math.cos(var12);
var var22=Math.exp(var12);
var var18=(var22 - 1.0 / var22) / 2.0;
var var20=(var22 + 1.0 / var22) / 2.0;
var var6=var14 - var18;
var var8=var16 - var20;
var var4=var16 * var20 - 1.0;
var var10=1.0 / (2.0E11 * this.mInertia * this.mL * this.mL * this.mL * var4 );
var var34=0.0;
for (var var3=0; var3 < 31; var3++) {
var var24=this.mlambda * var3 * this.mL  / 30.0;
var var26=Math.sin(var24);
var var28=Math.cos(var24);
var22=Math.exp(var24);
var var30=(var22 - 1.0 / var22) / 2.0;
var var32=(var22 + 1.0 / var22) / 2.0;
this.mxp[var3]=(var6 * (var28 + var32) - var8 * (var26 + var30)) * var10;
if (Math.abs(this.mxp[var3]) > var34 ) {
var34=Math.abs(this.mxp[var3]);
}}
for (var var36=0; var36 < 31; var36++) {
this.mxp[var36]=this.mxp[var36] * 20.0 / var34;
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
}if (newOmega < 20.0 ) {
newOmega=20.0;
}this.ControlMessage$Continuous_Prog12_Transverse_CFrame$I$D(this, 4, newOmega);
default:
return true;
}
}});
var $s$ = new Int16Array(1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("Continuous.Prog14.Transverse"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Continuous.Prog14.Transverse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec1=Clazz.array(Double.TYPE, [401]);
this.mRec2=Clazz.array(Double.TYPE, [401]);
this.mL=0.7;
this.mD=0.15;
this.mTime=0.0;
},1);

C$.$fields$=[['D',['mL','mD','mlambda','mw','mArea','mInertia','mTime'],'O',['mRec1','double[]','+mRec2']]]

Clazz.newMeth(C$, 'c$$Continuous_Prog14_Transverse_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Continuous_Prog14_Transverse_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var var3=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(38, 370, 440, 370);
var1.drawLine$I$I$I$I(38, 371, 440, 371);
var1.drawLine$I$I$I$I(39, 374, 39, 10);
var1.drawLine$I$I$I$I(40, 374, 40, 10);
for (var var2=0; var2 < 12; var2++) {
var1.drawLine$I$I$I$I(40, 370 - var2 * 40, 37, 370 - var2 * 40);
}
for (var var5=1; var5 < 6; var5++) {
var1.drawLine$I$I$I$I(40 + var5 * 80, 370, 40 + var5 * 80, 367);
}
var1.setColor$java_awt_Color(var3);
this.response$();
for (var var6=2; var6 < 400; var6++) {
var1.drawLine$I$I$I$I(40 + (var6 - 1), ((-150.0 - Math.log(Math.abs(this.mRec1[var6 - 1])) / Math.log(10.0) * 40.0)|0), 40 + var6, ((-150.0 - Math.log(Math.abs(this.mRec1[var6])) / Math.log(10.0) * 40.0)|0));
}
var1.setColor$java_awt_Color($I$(1).red);
for (var var7=2; var7 < 400; var7++) {
var1.drawLine$I$I$I$I(40 + (var7 - 1), ((-150.0 - Math.log(Math.abs(this.mRec2[var7 - 1])) / Math.log(10.0) * 40.0)|0), 40 + var7, ((-150.0 - Math.log(Math.abs(this.mRec2[var7])) / Math.log(10.0) * 40.0)|0));
}
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(20, 425, 30, 100);
var1.setColor$java_awt_Color(var3);
var1.drawLine$I$I$I$I(50, 475 - ((250.0 * this.mD / 2.0)|0), 50 + ((250.0 * this.mL)|0), 475 - ((250.0 * this.mD / 2.0)|0));
var1.drawLine$I$I$I$I(50 + ((250.0 * this.mL)|0), 475 - ((250.0 * this.mD / 2.0)|0), 50 + ((250.0 * this.mL)|0), 475 + ((250.0 * this.mD / 2.0)|0));
var1.drawLine$I$I$I$I(50, 475 + ((250.0 * this.mD / 2.0)|0), 50 + ((250.0 * this.mL)|0), 475 + ((250.0 * this.mD / 2.0)|0));
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

Clazz.newMeth(C$, 'ControlMessage$Continuous_Prog14_Transverse_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mL=var3;
this.response$();
break;
case 2:
this.mD=var3;
this.response$();
break;
case 3:
this.mTime+=var3;
var5=true;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
this.mArea=3.141592653589793 * this.mD * this.mD  / 4.0;
this.mInertia=this.mArea * this.mD * this.mD  / 16.0;
for (var var1=1; var1 < 401; var1++) {
this.mw=var1 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
this.mlambda=Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0  / (2.0E11 * this.mInertia)));
var var14=this.mlambda * this.mL;
var var2=Math.sin(var14);
var var4=Math.cos(var14);
var var16=Math.exp(var14);
var var6=(var16 - 1.0 / var16) / 2.0;
var var8=(var16 + 1.0 / var16) / 2.0;
var var10=var4 * var8 + 1.0;
var var12=var4 * var6 - var2 * var8;
var var18=1.0 / (2.0E11 * this.mInertia * this.mlambda * this.mlambda * this.mlambda * var10 );
this.mRec1[var1]=-var12 * var18;
}
for (var var118=1; var118 < 401; var118++) {
this.mw=var118 * 5000.0 * 2.0 * 3.141592653589793  / 400.0;
var var80=Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0  / (2.0E11 * this.mInertia)));
var var102;
var var104;
var var112;
var var114;
var var116;
if (this.mw < Math.sqrt(var80 * 8.0E10 * this.mArea  / (7800.0 * this.mInertia)) ) {
var var60=this.mw * this.mw;
var var64=7800.0 * this.mInertia * var60 ;
var var62=2.0E11 / (var80 * 8.0E10);
var var66=1.0 / (4.0E11 * this.mInertia);
var var76=var64 * (1.0 + var62);
var var78=Math.sqrt(var64 * (var64 * (1.0 - var62) * (1.0 - var62)  + 8.0E11 * this.mArea));
var var26=Math.sqrt((-var76 + var78) * var66);
var var28=Math.sqrt((var76 + var78) * var66);
var76=7800.0 * var60 / (var80 * 8.0E10);
var var22=var76 / var28 - var28;
var var24=var76 / var26 + var26;
var var48=Math.sin(var28 * this.mL);
var var54=Math.cos(var28 * this.mL);
var var119=Math.exp(var26 * this.mL);
var var50=(var119 - 1.0 / var119) / 2.0;
var var56=(var119 + 1.0 / var119) / 2.0;
var var30=var48 * var50;
var var32=var54 * var56;
var var34=var32 - 1.0;
var var36=var48 * var56;
var var38=var54 * var50;
var var40=var54 - var56;
var var72=var24 * var26;
var var74=var72 * var26;
var var68=var22 * var28;
var var70=var68 * var28;
var var20=1.0 / (7800.0 * var60 * this.mArea * (2.0 - 2.0 * var32 + (var74 / var70 - var70 / var74) * var30) );
var76=var74 / var68 - var26;
var78=var70 / var72 - var28;
var var98=-(var38 * var76 - var36 * var78) * var20;
var var100=(var30 * (var70 / var26 - var74 / var28) + var34 * (var68 + var72)) * var20;
var102=-(var50 * var76 - var48 * var78) * var20;
var104=var40 * (var72 - var68) * var20 ;
var var106=-(var36 * var72 * (var72 / var28 - var22)  + var38 * var68 * (var68 / var26 - var24) ) * var20;
var112=var98;
var114=-var100;
var116=var106;
} else {
var var134=this.mw * this.mw;
var var136=7800.0 * this.mInertia * var134 ;
var var135=2.0E11 / (var80 * 8.0E10);
var var137=1.0 / (4.0E11 * this.mInertia);
var var144=var136 * (1.0 + var135);
var var148=Math.sqrt(var136 * (var136 * (1.0 - var135) * (1.0 - var135)  + 8.0E11 * this.mArea));
var var124=Math.sqrt((var144 - var148) * var137);
var var125=Math.sqrt((var144 + var148) * var137);
var144=7800.0 * var134 / (var80 * 8.0E10);
var var122=var144 / var125 - var125;
var var123=var144 / var124 - var124;
var var132=Math.sin(var125 * this.mL);
var var133=Math.cos(var125 * this.mL);
var var52=Math.sin(var124 * this.mL);
var var58=Math.cos(var124 * this.mL);
var var126=var132 * var52;
var var127=var133 * var58;
var var128=var127 - 1.0;
var var129=var132 * var58;
var var130=var133 * var52;
var var131=var58 - var133;
var var140=var123 * var124;
var var141=var140 * var124;
var var138=var122 * var125;
var var139=var138 * var125;
var var120=1.0 / (7800.0 * var134 * this.mArea * (2.0 - 2.0 * var127 - (var141 / var139 + var139 / var141) * var126) );
var144=var141 / var138 - var124;
var148=var139 / var140 - var125;
var var150=(var130 * var144 + var129 * var148) * var120;
var var151=(var126 * (var139 / var124 + var141 / var125) + var128 * (var138 + var140)) * var120;
var102=(var52 * var144 + var132 * var148) * var120;
var104=-var131 * (var140 - var138) * var120 ;
var var152=(var129 * var140 * (var122 - var140 / var125)  + var130 * var138 * (var123 - var138 / var124) ) * var120;
var112=var150;
var114=-var151;
var116=var152;
}var var121=var112 * var116 - var114 * var114;
this.mRec2[var118]=var112 + (var102 * (var104 * var114 - var102 * var116) + var104 * (var102 * var114 - var104 * var112)) / var121;
}
});

Clazz.newMeth(C$, 'GetTime$',  function () {
return this.mTime;
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

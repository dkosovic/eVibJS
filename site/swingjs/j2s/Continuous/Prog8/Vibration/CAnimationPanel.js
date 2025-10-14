(function(){var P$=Clazz.newPackage("Continuous.Prog8.Vibration"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn1Fraction=1.0;
this.mWn2Fraction=2.0;
this.mWn3Fraction=3.0;
this.mWn=0.25;
this.mXo=0.5236;
},1);

C$.$fields$=[['D',['mTime','mWn1Fraction','mWn2Fraction','mWn3Fraction','mWn','mXo','mbeta'],'O',['mtheta','double[]','mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
}, 1);

Clazz.newMeth(C$, 'update$java_awt_Graphics',  function (g) {
if (g != null ) {
this.mScreenGC=g;
this.paint$java_awt_Graphics(this.mScreenGC);
}});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (g) {
this.mtheta=Clazz.array(Double.TYPE, [45]);
this.mScreenGC=g;
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var force=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
Clazz.new_($I$(1,1).c$$F$F$F,[1.0, 1.0, 0.4]);
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var ww=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
var offset=20;
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mtheta[0]=0.0;
for (var q=1; q < 19; q++) {
this.mbeta=3.141592653589793 - 3.141592653589793 * (q - 1) / 9.0;
for (var p=1; p < 41; p++) {
this.mtheta[p]=0.0;
if (p == 40) {
this.mOffScreenGC.drawLine$I$I$I$I(450, offset + 40, 50 + p * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[p]) * Math.cos(1.0472) )|0), offset + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[p]))|0) );
}if (!!(this.mbeta + this.mtheta[p] < 1.5707963267948966  & this.mbeta + this.mtheta[p] > -1.5707963267948966 )) {
this.mOffScreenGC.drawLine$I$I$I$I(50 + (p - 1) * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[p - 1]) * Math.cos(1.0472) )|0), offset + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[p - 1]))|0) , 50 + p * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[p]) * Math.cos(1.0472) )|0), offset + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[p]))|0) );
}}
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472))|0), offset + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 - ((30.0 * Math.cos(1.0472))|0), offset + 40 - 30, 30, 60, 90, 180);
this.mOffScreenGC.drawLine$I$I$I$I(50, offset + 40 - 30, 450, offset + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50, offset + 40 + 30 , 450, offset + 40 + 30 );
this.mOffScreenGC.setColor$java_awt_Color(force);
for (var p=1; p < 5; p++) {
this.mOffScreenGC.drawArc$I$I$I$I$I$I(460 + p - ((30.0 * Math.cos(1.0472) / 2.0)|0), offset + 40 - 15, 15, 30, 20 - 5 * p, 180);
}
for (var var12=1; var12 < 4; var12++) {
this.mOffScreenGC.drawArc$I$I$I$I$I$I(464 + var12 - ((30.0 * Math.cos(1.0472) / 2.0)|0), offset + 40 - 15, 15, 30, 5 * var12, 180);
}
var var19=130;
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mtheta[0]=this.mXo * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 );
for (var var16=1; var16 < 19; var16++) {
this.mbeta=3.141592653589793 - 3.141592653589793 * (var16 - 1) / 9.0;
for (var var13=1; var13 < 41; var13++) {
this.mtheta[var13]=this.mXo * Math.cos(this.mWn1Fraction * 3.141592653589793 * var13  / 40.0) * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var13 == 40) {
this.mOffScreenGC.drawLine$I$I$I$I(450, var19 + 40, 50 + var13 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var13]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var13]))|0) );
}if (!!(this.mbeta + this.mtheta[var13] < 1.5707963267948966  & this.mbeta + this.mtheta[var13] > -1.5707963267948966 )) {
this.mOffScreenGC.drawLine$I$I$I$I(50 + (var13 - 1) * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var13 - 1]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var13 - 1]))|0) , 50 + var13 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var13]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var13]))|0) );
}}
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 90, 180);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 - 30, 450, var19 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 + 30 , 450, var19 + 40 + 30 );
var19=240;
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mtheta[0]=this.mXo * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 );
for (var var17=1; var17 < 19; var17++) {
this.mbeta=3.141592653589793 - 3.141592653589793 * (var17 - 1) / 9.0;
for (var var14=1; var14 < 41; var14++) {
this.mtheta[var14]=this.mXo * Math.cos(this.mWn2Fraction * 3.141592653589793 * var14  / 40.0) * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var14 == 40) {
this.mOffScreenGC.drawLine$I$I$I$I(450, var19 + 40, 50 + var14 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var14]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var14]))|0) );
}if (!!(this.mbeta + this.mtheta[var14] < 1.5707963267948966  & this.mbeta + this.mtheta[var14] > -1.5707963267948966 )) {
this.mOffScreenGC.drawLine$I$I$I$I(50 + (var14 - 1) * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var14 - 1]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var14 - 1]))|0) , 50 + var14 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var14]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var14]))|0) );
}}
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 90, 180);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 - 30, 450, var19 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 + 30 , 450, var19 + 40 + 30 );
var19=350;
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mtheta[0]=this.mXo * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 );
for (var var18=1; var18 < 19; var18++) {
this.mbeta=3.141592653589793 - 3.141592653589793 * (var18 - 1) / 9.0;
for (var var15=1; var15 < 41; var15++) {
this.mtheta[var15]=this.mXo * Math.cos(this.mWn3Fraction * 3.141592653589793 * var15  / 40.0) * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var15 == 40) {
this.mOffScreenGC.drawLine$I$I$I$I(450, var19 + 40, 50 + var15 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var15]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var15]))|0) );
}if (!!(this.mbeta + this.mtheta[var15] < 1.5707963267948966  & this.mbeta + this.mtheta[var15] > -1.5707963267948966 )) {
this.mOffScreenGC.drawLine$I$I$I$I(50 + (var15 - 1) * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var15 - 1]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var15 - 1]))|0) , 50 + var15 * 10 - ((30.0 * Math.cos(this.mbeta + this.mtheta[var15]) * Math.cos(1.0472) )|0), var19 + 40 + ((30.0 * Math.sin(this.mbeta + this.mtheta[var15]))|0) );
}}
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 - ((30.0 * Math.cos(1.0472))|0), var19 + 40 - 30, 30, 60, 90, 180);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 - 30, 450, var19 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50, var19 + 40 + 30 , 450, var19 + 40 + 30 );
g.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mOffScrImage, 0, 0, null);
});

Clazz.newMeth(C$, 'SetRealParameter$I$D',  function (code, val) {
var mustRedraw=false;
switch (code) {
case 0:
this.mTime+=val;
mustRedraw=true;
default:
if (mustRedraw) {
this.repaint$();
}}
});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
};
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

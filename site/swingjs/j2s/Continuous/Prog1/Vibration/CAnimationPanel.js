(function(){var P$=Clazz.newPackage("Continuous.Prog1.Vibration"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn1Fraction=1.0;
this.mWn2Fraction=2.0;
this.mWn3Fraction=3.0;
this.mWn=0.25;
this.mXo=30.0;
},1);

C$.$fields$=[['D',['mTime','mWn1Fraction','mWn2Fraction','mWn3Fraction','mWn','mXo','mxp','mx0'],'O',['mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
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
for (var p=0; p < 21; p++) {
this.mxp=0.0;
this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 + p * 20 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), offset + 40 - 30, 30, 60, 90, 180);
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), offset + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawLine$I$I$I$I(50, offset + 40 - 30, 450 + (this.mxp|0), offset + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50, offset + 40 + 30 , 450 + (this.mxp|0), offset + 40 + 30 );
this.mOffScreenGC.setColor$java_awt_Color(force);
for (var var10=1; var10 < 5; var10++) {
this.mOffScreenGC.drawLine$I$I$I$I(451, 56 + var10, 470 + var10, 56 + var10);
}
for (var var11=1; var11 < 4; var11++) {
this.mOffScreenGC.drawLine$I$I$I$I(451, 60 + var11, 474 - var11, 60 + var11);
}
this.mOffScreenGC.fillArc$I$I$I$I$I$I(450, 57, 4, 7, 0, 360);
var var15=130;
this.mOffScreenGC.setColor$java_awt_Color(mass);
for (var var12=0; var12 < 21; var12++) {
this.mxp=this.mXo * Math.cos(this.mWn1Fraction * 3.141592653589793 * var12  / 20.0) * Math.cos(this.mWn1Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var12 == 0) {
this.mx0=this.mxp;
}this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 + var12 * 20 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 90, 180);
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 - 30, 450 + (this.mxp|0), var15 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 + 30 , 450 + (this.mxp|0), var15 + 40 + 30 );
var15=240;
this.mOffScreenGC.setColor$java_awt_Color(mass);
for (var var13=0; var13 < 21; var13++) {
this.mxp=this.mXo * Math.cos(this.mWn2Fraction * 3.141592653589793 * var13  / 20.0) * Math.cos(this.mWn2Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var13 == 0) {
this.mx0=this.mxp;
}this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 + var13 * 20 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 90, 180);
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 - 30, 450 + (this.mxp|0), var15 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 + 30 , 450 + (this.mxp|0), var15 + 40 + 30 );
var15=350;
this.mOffScreenGC.setColor$java_awt_Color(mass);
for (var var14=0; var14 < 21; var14++) {
this.mxp=this.mXo * Math.cos(this.mWn3Fraction * 3.141592653589793 * var14  / 20.0) * Math.cos(this.mWn3Fraction * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
if (var14 == 0) {
this.mx0=this.mxp;
}this.mOffScreenGC.drawArc$I$I$I$I$I$I(50 + var14 * 20 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 90, 180);
}
this.mOffScreenGC.drawArc$I$I$I$I$I$I(450 - ((30.0 * Math.cos(1.0472) - this.mxp)|0), var15 + 40 - 30, 30, 60, 0, 360);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 - 30, 450 + (this.mxp|0), var15 + 40 - 30);
this.mOffScreenGC.drawLine$I$I$I$I(50 + (this.mx0|0), var15 + 40 + 30 , 450 + (this.mxp|0), var15 + 40 + 30 );
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

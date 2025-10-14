(function(){var P$=Clazz.newPackage("TwoDOF.Detuner_2DOF.Transient"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn=0.6;
this.kyTopAbutment=19;
},1);

C$.$fields$=[['D',['mTime','mWn','mXi','y1real','y2real'],'I',['mXo','kyTopAbutment','Farrow'],'O',['mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
this.mXo=10;
this.mXi=0.05;
}, 1);

Clazz.newMeth(C$, 'update$java_awt_Graphics',  function (g) {
if (g != null ) {
this.mScreenGC=g;
this.paint$java_awt_Graphics(this.mScreenGC);
}});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (g) {
this.mScreenGC=g;
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var ww=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
this.y1real=0.0;
this.y2real=2.0 * this.mXo * Math.sin(this.mWn * this.mTime * 2.0 * 3.141592653589793 ) ;
this.Farrow=((25.0 * Math.sin(this.mWn * this.mTime * 2.0 * 3.141592653589793 ))|0);
this.y1real=this.mXo - (this.y1real|0);
this.y2real=this.mXo - (this.y2real|0);
var y1=(this.y1real|0);
var y2=(this.y2real|0);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).orange);
this.mOffScreenGC.fillRect$I$I$I$I(10, this.kyTopAbutment, 35, 20);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
var coil=(110 + y1 - this.kyTopAbutment - 20) / 10.0;
this.mOffScreenGC.drawLine$I$I$I$I(18, this.kyTopAbutment + 20, 24, ((this.kyTopAbutment + 20 + coil / 2.0 )|0));
for (var p=1; p < 10; p++) {
if (p % 2 == 0) {
this.mOffScreenGC.drawLine$I$I$I$I(12, ((this.kyTopAbutment + 20 + (2 * p - 1) * coil / 2.0 )|0), 24, ((this.kyTopAbutment + 20 + (2 * p + 1) * coil / 2.0 )|0));
} else {
this.mOffScreenGC.drawLine$I$I$I$I(24, ((this.kyTopAbutment + 20 + (2 * p - 1) * coil / 2.0 )|0), 12, ((this.kyTopAbutment + 20 + (2 * p + 1) * coil / 2.0 )|0));
}}
this.mOffScreenGC.drawLine$I$I$I$I(12, ((this.kyTopAbutment + 20 + 19.0 * coil / 2.0 )|0), 18, 110 + y1);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawLine$I$I$I$I(32, this.kyTopAbutment + 20, 32, this.kyTopAbutment + 20 + 47 );
this.mOffScreenGC.drawLine$I$I$I$I(40, this.kyTopAbutment + 20, 40, this.kyTopAbutment + 20 + 47 );
this.mOffScreenGC.drawLine$I$I$I$I(32, this.kyTopAbutment + 20 + 47 , 40, this.kyTopAbutment + 20 + 47 );
this.mOffScreenGC.drawLine$I$I$I$I(36, 110 + y1 - 48, 36, 110 + y1);
this.mOffScreenGC.drawLine$I$I$I$I(33, 110 + y1 - 48, 39, 110 + y1 - 48);
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var force=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mOffScreenGC.fillRect$I$I$I$I(10, 110 + y1, 35, 20);
this.mOffScreenGC.setColor$java_awt_Color(force);
this.mOffScreenGC.drawLine$I$I$I$I(45, 110 + y1 + 10 , 65, 110 + y1 + 10 );
if (this.Farrow != 0) {
if (this.Farrow > 0) {
this.mOffScreenGC.drawLine$I$I$I$I(54, 110 + y1 + 10 , 54, 110 + y1 + 10 + this.Farrow  - 1);
this.mOffScreenGC.drawLine$I$I$I$I(55, 110 + y1 + 10 , 55, 110 + y1 + 10 + this.Farrow );
this.mOffScreenGC.drawLine$I$I$I$I(56, 110 + y1 + 10 , 56, 110 + y1 + 10 + this.Farrow  - 1);
}if (this.Farrow < 0) {
this.mOffScreenGC.drawLine$I$I$I$I(54, 110 + y1 + 10 , 54, 110 + y1 + 10 + this.Farrow + 1 );
this.mOffScreenGC.drawLine$I$I$I$I(55, 110 + y1 + 10 , 55, 110 + y1 + 10 + this.Farrow );
this.mOffScreenGC.drawLine$I$I$I$I(56, 110 + y1 + 10 , 56, 110 + y1 + 10 + this.Farrow + 1 );
}}this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
coil=(201 + y2 - 110 - 20 - y1) / 10.0;
this.mOffScreenGC.drawLine$I$I$I$I(27, 130 + y1, 33, ((130 + y1 + coil / 2.0 )|0));
for (var var14=1; var14 < 10; var14++) {
if (var14 % 2 == 0) {
this.mOffScreenGC.drawLine$I$I$I$I(21, ((130 + y1 + (2 * var14 - 1) * coil / 2.0 )|0), 33, ((130 + y1 + (2 * var14 + 1) * coil / 2.0 )|0));
} else {
this.mOffScreenGC.drawLine$I$I$I$I(33, ((130 + y1 + (2 * var14 - 1) * coil / 2.0 )|0), 21, ((130 + y1 + (2 * var14 + 1) * coil / 2.0 )|0));
}}
this.mOffScreenGC.drawLine$I$I$I$I(21, ((130 + y1 + 19.0 * coil / 2.0 )|0), 27, 201 + y2);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mOffScreenGC.fillRect$I$I$I$I(10, 201 + y2, 35, 20);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

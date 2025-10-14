(function(){var P$=Clazz.newPackage("OneDOF.Transient.Transient"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn=0.4;
this.mXo=50.0;
this.mVo=0.0;
this.mXi=0.15;
this.KyTopAbutment=10;
},1);

C$.$fields$=[['D',['mTime','mWn','mXo','mVo','mXi','yreal'],'I',['KyTopAbutment'],'O',['mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
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
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var ww=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (this.mTime < 5.0 ) {
this.yreal=0.0;
}if (this.mTime > 2.5 ) {
this.KyTopAbutment=10 + (this.mXo|0);
var mWnt=this.mWn * 2.0 * 3.141592653589793 * 2.0 * (this.mTime - 2.5) ;
var mWnTsqrt=mWnt * Math.sqrt(1.0 - this.mXi * this.mXi);
this.yreal=Math.exp(-this.mXi * mWnt) * (this.mXo * Math.cos(mWnTsqrt) + (this.mVo + this.mXi * this.mWn * 2.0 * 3.141592653589793 * this.mXo ) * Math.sin(mWnTsqrt) / (this.mWn * 2.0 * 3.141592653589793 * Math.sqrt(1.0 - this.mXi * this.mXi) ));
this.yreal=this.mXo - (this.yreal|0);
}if (this.mTime > 10.0 ) {
this.KyTopAbutment=10;
var mWnt=this.mWn * 2.0 * 3.141592653589793 * 2.0 * (this.mTime - 10.0) ;
var mWnTsqrt=mWnt * Math.sqrt(1.0 - this.mXi * this.mXi);
this.yreal=Math.exp(-this.mXi * mWnt) * (this.mXo * Math.cos(mWnTsqrt) + (this.mVo + this.mXi * this.mWn * 2.0 * 3.141592653589793 * this.mXo ) * Math.sin(mWnTsqrt) / (this.mWn * 2.0 * 3.141592653589793 * Math.sqrt(1.0 - this.mXi * this.mXi) ));
}if (this.mTime > 17.5 ) {
this.KyTopAbutment=10;
this.mTime=0.0;
}var y=(this.yreal|0);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).orange);
this.mOffScreenGC.fillRect$I$I$I$I(10, this.KyTopAbutment, 70, 20);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
var coil=(200 + y - this.KyTopAbutment - 20) / 10.0;
this.mOffScreenGC.drawLine$I$I$I$I(45, this.KyTopAbutment + 20, 57, ((this.KyTopAbutment + 20 + coil / 2.0 )|0));
for (var p=1; p < 10; p++) {
if (p % 2 == 0) {
this.mOffScreenGC.drawLine$I$I$I$I(33, ((this.KyTopAbutment + 20 + (2 * p - 1) * coil / 2.0 )|0), 57, ((this.KyTopAbutment + 20 + (2 * p + 1) * coil / 2.0 )|0));
} else {
this.mOffScreenGC.drawLine$I$I$I$I(57, ((this.KyTopAbutment + 20 + (2 * p - 1) * coil / 2.0 )|0), 33, ((this.KyTopAbutment + 20 + (2 * p + 1) * coil / 2.0 )|0));
}}
this.mOffScreenGC.drawLine$I$I$I$I(33, ((this.KyTopAbutment + 20 + 19.0 * coil / 2.0 )|0), 45, 200 + y);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mOffScreenGC.fillRect$I$I$I$I(10, 200 + y, 70, 40);
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

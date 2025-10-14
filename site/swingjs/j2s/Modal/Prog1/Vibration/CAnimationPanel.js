(function(){var P$=Clazz.newPackage("Modal.Prog1.Vibration"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWnFraction=Clazz.array(Double.TYPE, [10]);
this.yp=Clazz.array(Integer.TYPE, [10]);
this.mWn=1.0;
this.mYo=25.0;
},1);

C$.$fields$=[['D',['mTime','mWn','mYo'],'O',['mWnFraction','double[]','yp','int[]','mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
this.yp[0]=0;
this.yp[3]=0;
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
this.mOffScreenGC.setColor$java_awt_Color($I$(1).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
for (var i=1; i < 3; i++) {
this.mWnFraction[i]=Math.sin(i * 3.141592653589793 / 2.0 / 3.0);
}
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
for (var var8=1; var8 < 3; var8++) {
this.mOffScreenGC.setColor$java_awt_Color($I$(1).orange);
this.mOffScreenGC.fillRect$I$I$I$I(100, 2 + 60 * (var8 - 1) + var8 * 10, 30, 60);
this.mOffScreenGC.fillRect$I$I$I$I(330, 2 + 60 * (var8 - 1) + var8 * 10, 30, 60);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
for (var p=1; p < 3; p++) {
this.yp[p]=((this.mYo * Math.sin(var8 * p * 3.141592653589793  / 3.0) * Math.sin(this.mWnFraction[var8] * this.mWn * this.mTime * 2.0 * 3.141592653589793 ) )|0);
}
for (var var9=0; var9 < 3; var9++) {
this.mOffScreenGC.drawLine$I$I$I$I(130 + (200 * var9/3|0), ((2.0 + 60.0 * (var8 - 0.5) + this.yp[var9] + var8 * 10)|0), 130 + (200 * (var9 + 1)/3|0), ((2.0 + 60.0 * (var8 - 0.5) + this.yp[var9 + 1] + var8 * 10)|0));
}
this.mOffScreenGC.setColor$java_awt_Color(mass);
for (var var10=1; var10 < 3; var10++) {
this.mOffScreenGC.fillArc$I$I$I$I$I$I(130 + (200 * var10/3|0) - 6, ((2.0 + 60.0 * (var8 - 0.5) + this.yp[var10] + var8 * 10)|0) - 6, 13, 13, 0, 360);
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("This program is copyright, you need permission to use it. \u00a9 2005 B J Stone, bjs@mech.uwa.edu.au.", 5, 172);
}
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

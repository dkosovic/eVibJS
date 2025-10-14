(function(){var P$=Clazz.newPackage("OneDOF.Prog7.Forcedlocus"),I$=[[0,'java.awt.Point','java.util.Vector','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFramePanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mButton'],'O',['mApplet','java.applet.Applet','mFrames','java.util.Vector','mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mStartPt','java.awt.Point','+mLastPt','+mThisPt','mMouseEvent','java.awt.Event']]]

Clazz.newMeth(C$, 'c$$java_applet_Applet',  function (app) {
Clazz.super_(C$, this);
this.mApplet=app;
this.mStartPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
this.mLastPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
this.mThisPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
}, 1);

Clazz.newMeth(C$, 'update$java_awt_Graphics',  function (g) {
if (g != null ) {
this.mScreenGC=g;
this.paint$java_awt_Graphics(this.mScreenGC);
}});

Clazz.newMeth(C$, 'DrawAllFrames$java_awt_Graphics',  function (g) {
var count=0;
if (this.mFrames != null ) {
count=this.mFrames.size$();
}for (var i=0; i < count; i++) {
var thisFrame=this.mFrames.elementAt$I(i);
thisFrame.Frame$java_awt_Graphics(g);
}
});

Clazz.newMeth(C$, 'AddFrame$OneDOF_Prog7_Forcedlocus_CFrame',  function (f) {
if (this.mFrames == null ) {
this.mFrames=Clazz.new_($I$(2,1));
} else if (this.mFrames.contains$O(f)) {
this.mFrames.removeElement$O(f);
}this.mFrames.addElement$O(f);
});

Clazz.newMeth(C$, 'RemoveFrame$OneDOF_Prog7_Forcedlocus_CFrame',  function (f) {
if (this.mFrames != null ) {
this.mFrames.removeElement$O(f);
if (this.mFrames.size$() == 0) {
this.mFrames=null;
}}});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (g) {
this.mScreenGC=g;
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var ww=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
this.mOffScreenGC.setPaintMode$();
this.mOffScreenGC.setColor$java_awt_Color($I$(3).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
this.mOffScreenGC.setColor$java_awt_Color($I$(3).black);
this.DrawAllFrames$java_awt_Graphics(this.mOffScreenGC);
g.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mOffScrImage, 0, 0, null);
});

Clazz.newMeth(C$, 'mouseDown$java_awt_Event$I$I',  function (evt, xx, yy) {
this.mMouseEvent=evt;
this.mButton=true;
this.mStartPt.x=xx;
this.mStartPt.y=yy;
this.mLastPt.x=xx;
this.mLastPt.y=yy;
this.mThisPt.x=xx;
this.mThisPt.y=yy;
if (this.SendMouseEvent$I(0)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'mouseDrag$java_awt_Event$I$I',  function (evt, xx, yy) {
this.mMouseEvent=evt;
this.mLastPt.x=this.mThisPt.x;
this.mLastPt.y=this.mThisPt.y;
this.mThisPt.x=xx;
this.mThisPt.y=yy;
if (this.SendMouseEvent$I(1)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'mouseUp$java_awt_Event$I$I',  function (evt, xx, yy) {
this.mMouseEvent=evt;
this.mButton=false;
if (this.SendMouseEvent$I(2)) {
this.repaint$();
}this.mMouseEvent=null;
return true;
});

Clazz.newMeth(C$, 'mouseMove$java_awt_Event$I$I',  function (evt, xx, yy) {
this.mMouseEvent=evt;
this.mLastPt.x=this.mThisPt.x;
this.mLastPt.y=this.mThisPt.y;
this.mThisPt.x=xx;
this.mThisPt.y=yy;
this.mButton=false;
if (this.SendMouseEvent$I(3)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'SendMouseEvent$I',  function (code) {
var count=0;
if (this.mFrames != null ) {
count=this.mFrames.size$();
}var result=false;
var prevHit=false;
for (var i=count - 1; i >= 0; i--) {
var thisFrame=this.mFrames.elementAt$I(i);
if (thisFrame.MouseEvent$I$Z(code, prevHit)) {
result=true;
}prevHit=prevHit || thisFrame.mWasHit ;
}
return result;
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

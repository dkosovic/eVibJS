(function(){var P$=Clazz.newPackage("Modal.Prog4.Eigen2DOF"),I$=[[0,'java.awt.Point','java.util.Vector','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFramePanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mButton'],'O',['mApplet','java.applet.Applet','mFrames','java.util.Vector','mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mStartPt','java.awt.Point','+mLastPt','+mThisPt','mMouseEvent','java.awt.Event']]]

Clazz.newMeth(C$, 'c$$java_applet_Applet',  function (var1) {
Clazz.super_(C$, this);
this.mApplet=var1;
this.mStartPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
this.mLastPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
this.mThisPt=Clazz.new_($I$(1,1).c$$I$I,[0, 0]);
}, 1);

Clazz.newMeth(C$, 'update$java_awt_Graphics',  function (var1) {
if (var1 != null ) {
this.mScreenGC=var1;
this.paint$java_awt_Graphics(this.mScreenGC);
}});

Clazz.newMeth(C$, 'DrawAllFrames$java_awt_Graphics',  function (var1) {
var var3=0;
if (this.mFrames != null ) {
var3=this.mFrames.size$();
}for (var var2=0; var2 < var3; var2++) {
var var4=this.mFrames.elementAt$I(var2);
var4.Frame$java_awt_Graphics(var1);
}
});

Clazz.newMeth(C$, 'AddFrame$Modal_Prog4_Eigen2DOF_CFrame',  function (var1) {
if (this.mFrames == null ) {
this.mFrames=Clazz.new_($I$(2,1));
} else if (this.mFrames.contains$O(var1)) {
this.mFrames.removeElement$O(var1);
}this.mFrames.addElement$O(var1);
});

Clazz.newMeth(C$, 'RemoveFrame$Modal_Prog4_Eigen2DOF_CFrame',  function (var1) {
if (this.mFrames != null ) {
this.mFrames.removeElement$O(var1);
if (this.mFrames.size$() == 0) {
this.mFrames=null;
}}});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (var1) {
this.mScreenGC=var1;
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var var2=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var var3=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
this.mOffScreenGC.setPaintMode$();
this.mOffScreenGC.setColor$java_awt_Color($I$(3).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, var2, var3);
this.mOffScreenGC.setColor$java_awt_Color($I$(3).black);
this.DrawAllFrames$java_awt_Graphics(this.mOffScreenGC);
var1.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mOffScrImage, 0, 0, null);
});

Clazz.newMeth(C$, 'mouseDown$java_awt_Event$I$I',  function (var1, var2, var3) {
this.mMouseEvent=var1;
this.mButton=true;
this.mStartPt.x=var2;
this.mStartPt.y=var3;
this.mLastPt.x=var2;
this.mLastPt.y=var3;
this.mThisPt.x=var2;
this.mThisPt.y=var3;
if (this.SendMouseEvent$I(0)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'mouseDrag$java_awt_Event$I$I',  function (var1, var2, var3) {
this.mMouseEvent=var1;
this.mLastPt.x=this.mThisPt.x;
this.mLastPt.y=this.mThisPt.y;
this.mThisPt.x=var2;
this.mThisPt.y=var3;
if (this.SendMouseEvent$I(1)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'mouseUp$java_awt_Event$I$I',  function (var1, var2, var3) {
this.mMouseEvent=var1;
this.mButton=false;
if (this.SendMouseEvent$I(2)) {
this.repaint$();
}this.mMouseEvent=null;
return true;
});

Clazz.newMeth(C$, 'mouseMove$java_awt_Event$I$I',  function (var1, var2, var3) {
this.mMouseEvent=var1;
this.mLastPt.x=this.mThisPt.x;
this.mLastPt.y=this.mThisPt.y;
this.mThisPt.x=var2;
this.mThisPt.y=var3;
this.mButton=false;
if (this.SendMouseEvent$I(3)) {
this.repaint$();
}return true;
});

Clazz.newMeth(C$, 'SendMouseEvent$I',  function (var1) {
var var3=0;
if (this.mFrames != null ) {
var3=this.mFrames.size$();
}var var4=false;
var var5=false;
for (var var2=var3 - 1; var2 >= 0; var2--) {
var var6=this.mFrames.elementAt$I(var2);
if (var6.MouseEvent$I$Z(var1, var5)) {
var4=true;
}var5=var5 || var6.mWasHit ;
}
return var4;
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

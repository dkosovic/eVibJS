(function(){var P$=Clazz.newPackage("Modal.Prog3.Eigen2DOF"),I$=[[0,'javax.swing.ImageIcon']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFramePicture", null, 'Modal.Prog3.Eigen2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mScaleImage'],'O',['mImage','java.awt.Image']]]

Clazz.newMeth(C$, 'c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I$java_awt_Image$Z',  function (var1, var2, var3, var4, var5, var6, var7) {
;C$.superclazz.c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mScaleImage=var7;
this.LoadImage$java_awt_Image(var6);
}, 1);

Clazz.newMeth(C$, 'LoadImage$java_awt_Image',  function (var1) {
if (var1 != null ) {
try {
var icon=Clazz.new_($I$(1,1).c$$java_awt_Image,[var1]);
this.mImage=icon.getImage$();
} catch (e) {
if (Clazz.exceptionOf(e,"Exception")){
this.mImage=var1;
} else {
throw e;
}
}
} else {
this.mImage=null;
}});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
if (this.mImage != null ) {
var width=this.mImage.getWidth$java_awt_image_ImageObserver(this.mFramePanel);
var height=this.mImage.getHeight$java_awt_image_ImageObserver(this.mFramePanel);
if (width > 0 && height > 0 ) {
if (this.mScaleImage) {
var1.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mImage, this.x, this.y, this.width, this.height, this.mFramePanel);
} else {
var1.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mImage, this.x, this.y, this.mFramePanel);
}}}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

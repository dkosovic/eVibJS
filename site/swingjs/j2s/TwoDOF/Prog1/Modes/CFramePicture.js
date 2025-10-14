(function(){var P$=Clazz.newPackage("TwoDOF.Prog1.Modes"),I$=[[0,'javax.swing.ImageIcon']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFramePicture", null, 'TwoDOF.Prog1.Modes.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mScaleImage'],'O',['mImage','java.awt.Image']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog1_Modes_CFramePanel$I$I$I$I$java_awt_Image$Z',  function (thePanel, xx, yy, ww, hh, img, scale) {
;C$.superclazz.c$$TwoDOF_Prog1_Modes_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mScaleImage=scale;
this.LoadImage$java_awt_Image(img);
}, 1);

Clazz.newMeth(C$, 'LoadImage$java_awt_Image',  function (img) {
if (img != null ) {
var icon=Clazz.new_($I$(1,1).c$$java_awt_Image,[img]);
this.mImage=icon.getImage$();
} else {
this.mImage=img;
}});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
if (this.mImage != null ) {
var width=this.mImage.getWidth$java_awt_image_ImageObserver(this.mFramePanel);
var height=this.mImage.getHeight$java_awt_image_ImageObserver(this.mFramePanel);
if (width > 0 && height > 0 ) {
if (this.mScaleImage) {
g.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mImage, this.x, this.y, this.width, this.height, this.mFramePanel);
} else {
g.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mImage, this.x, this.y, this.mFramePanel);
}}}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

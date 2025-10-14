(function(){var P$=Clazz.newPackage("TwoDOF.Prog7.Abutmentresponse_2DOF"),I$=[[0,'javax.swing.ImageIcon','java.awt.Dimension']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CPicturePanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mImage','java.awt.Image']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
}, 1);

Clazz.newMeth(C$, 'c$$java_awt_Image',  function (img) {
Clazz.super_(C$, this);
this.LoadImage$java_awt_Image(img);
}, 1);

Clazz.newMeth(C$, 'LoadImage$java_awt_Image',  function (img) {
if (img != null ) {
var icon=Clazz.new_($I$(1,1).c$$java_awt_Image,[img]);
this.mImage=icon.getImage$();
} else {
this.mImage=img;
}});

Clazz.newMeth(C$, 'minimumSize$',  function () {
if (this.mImage == null ) {
return Clazz.new_($I$(2,1).c$$I$I,[20, 24]);
} else {
var var1=this.mImage.getWidth$java_awt_image_ImageObserver(this);
var var2=this.mImage.getHeight$java_awt_image_ImageObserver(this);
return var1 >= 0 && var2 >= 0  ? Clazz.new_($I$(2,1).c$$I$I,[var1, var2]) : Clazz.new_($I$(2,1).c$$I$I,[20, 24]);
}});

Clazz.newMeth(C$, 'preferredSize$',  function () {
return this.minimumSize$();
});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (var1) {
if (this.mImage != null ) {
var1.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mImage, 0, 0, this);
} else {
var1.drawString$S$I$I("...", 0, 20);
}});
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

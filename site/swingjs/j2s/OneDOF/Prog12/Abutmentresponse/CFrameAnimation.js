(function(){var P$=Clazz.newPackage("OneDOF.Prog12.Abutmentresponse"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog12.Abutmentresponse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mXi=0.05;
},1);

C$.$fields$=[['D',['mXi']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$OneDOF_Prog12_Abutmentresponse_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(100, 47, 100, 213);
var1.drawLine$I$I$I$I(97, 210, 403, 210);
for (var var2=1; var2 < 9; var2++) {
var1.drawLine$I$I$I$I(100, 210 - var2 * 20, 97, 210 - var2 * 20);
}
for (var var14=1; var14 < 7; var14++) {
var1.drawLine$I$I$I$I(100 + var14 * 50, 210, 100 + var14 * 50, 213);
}
var var13=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var13);
var var3=1.0;
for (var var15=1; var15 < 150; var15++) {
var var11=var15 / 50.0;
var var5=Math.sqrt((1.0 + 4.0 * this.mXi * this.mXi * var11 * var11 ) / ((1.0 - var11 * var11) * (1.0 - var11 * var11) + 2.0 * var11 * this.mXi * (2.0 * var11 * this.mXi ) ));
var1.drawLine$I$I$I$I(100 + (var15 - 1) * 2, ((210.0 - var3 * 20.0)|0), 100 + var15 * 2, ((210.0 - var5 * 20.0)|0));
var3=var5;
}
var1.setColor$java_awt_Color(var13);
var var7=0.0;
var var9=0.0;
for (var var16=1; var16 < 150; var16++) {
var var20=var16 / 50.0;
var9=180.0 * Math.atan(2.0 * var20 * var20 * var20 * this.mXi  / (1.0 - var20 * var20 + 4.0 * this.mXi * this.mXi * var20 * var20 )) / 3.141592653589793;
if (var9 < 0.0 ) {
var9+=180.0;
}var1.drawLine$I$I$I$I(100 + (var16 - 1) * 2, ((240.0 + var7 / 2.0)|0), 100 + var16 * 2, ((240.0 + var9 / 2.0)|0));
var7=var9;
}
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(100, 237, 100, 333);
var1.drawLine$I$I$I$I(97, 240, 403, 240);
for (var var17=1; var17 < 5; var17++) {
var1.drawLine$I$I$I$I(100, 240 + ((var17 * 22.5)|0), 97, 240 + ((var17 * 22.5)|0));
}
for (var var18=1; var18 < 7; var18++) {
var1.drawLine$I$I$I$I(100 + var18 * 50, 240, 100 + var18 * 50, 237);
}
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog12_Abutmentresponse_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mXi=var3;
default:
if (var5) {
this.repaint$();
}}
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

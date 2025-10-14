(function(){var P$=Clazz.newPackage("OneDOF.Prog10.OOBresponse"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog10.OOBresponse.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mXi=0.05;
this.mrdivM=5.0;
},1);

C$.$fields$=[['D',['mXi','mrdivM']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog10_OOBresponse_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$OneDOF_Prog10_OOBresponse_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(100, 47, 100, 213);
g.drawLine$I$I$I$I(97, 210, 403, 210);
for (var p=1; p < 7; p++) {
g.drawLine$I$I$I$I(100, 210 - p * 25, 97, 210 - p * 25);
}
for (var var14=1; var14 < 7; var14++) {
g.drawLine$I$I$I$I(100 + var14 * 50, 210, 100 + var14 * 50, 213);
}
g.setColor$java_awt_Color(mass);
var mAmp1=0.0;
for (var var15=1; var15 < 150; var15++) {
var mr=var15 / 50.0;
var mAmp2=this.mrdivM * mr * mr  / Math.sqrt((1.0 - mr * mr) * (1.0 - mr * mr) + 2.0 * mr * this.mXi * (2.0 * mr * this.mXi ) );
g.drawLine$I$I$I$I(100 + (var15 - 1) * 2, ((210.0 - mAmp1 * 5.0)|0), 100 + var15 * 2, ((210.0 - mAmp2 * 5.0)|0));
mAmp1=mAmp2;
}
g.setColor$java_awt_Color(mass);
var mPhase1=0.0;
var mPhase2=0.0;
for (var var16=1; var16 < 150; var16++) {
var mr=var16 / 50.0;
if (var16 == 50) {
mPhase2=90.0;
}if (var16 != 50) {
mPhase2=180.0 * Math.atan(2.0 * mr * this.mXi  / (1.0 - mr * mr)) / 3.141592653589793;
if (mPhase2 < 0.0 ) {
mPhase2+=180.0;
}}g.drawLine$I$I$I$I(100 + (var16 - 1) * 2, ((240.0 + mPhase1 / 2.0)|0), 100 + var16 * 2, ((240.0 + mPhase2 / 2.0)|0));
mPhase1=mPhase2;
}
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(100, 237, 100, 333);
g.drawLine$I$I$I$I(97, 240, 403, 240);
for (var var17=1; var17 < 5; var17++) {
g.drawLine$I$I$I$I(100, 240 + ((var17 * 22.5)|0), 97, 240 + ((var17 * 22.5)|0));
}
for (var var18=1; var18 < 7; var18++) {
g.drawLine$I$I$I$I(100 + var18 * 50, 240, 100 + var18 * 50, 237);
}
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog10_OOBresponse_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mXi=val;
break;
case 2:
this.mrdivM=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

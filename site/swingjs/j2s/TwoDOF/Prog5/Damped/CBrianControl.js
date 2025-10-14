(function(){var P$=Clazz.newPackage("TwoDOF.Prog5.Damped"),I$=[[0,'java.awt.Rectangle','java.awt.Point','java.awt.Event','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CBrianControl", null, 'TwoDOF.Prog5.Damped.CPicturePanel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['D',['mMin','mValue','mMax','mOldValue','mDeltaPerSec'],'I',['mSelection'],'O',['mApplet','java.applet.Applet','mSelStart','java.util.Date','mLabel','java.awt.Label']]]

Clazz.newMeth(C$, 'c$$java_applet_Applet$java_awt_Label$D$D$D',  function (app, lab, min, val, max) {
Clazz.super_(C$, this);
this.mApplet=app;
this.mLabel=lab;
this.LoadImage$java_awt_Image(this.mApplet.getImage$java_net_URL$S(this.mApplet.getCodeBase$(), "BrianControl.gif"));
this.mMin=min;
this.mValue=val;
this.mMax=max;
this.BroadcastValue$();
}, 1);

Clazz.newMeth(C$, 'GridToRect$I',  function (which) {
var ww=this.mImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mImage.getHeight$java_awt_image_ImageObserver(this);
if (ww >= 0 && hh >= 0 ) {
switch (which) {
case 1:
return Clazz.new_([0, 0, ww, (hh/2|0)],$I$(1,1).c$$I$I$I$I);
case 2:
return Clazz.new_([0, (hh/2|0), ww, hh],$I$(1,1).c$$I$I$I$I);
default:
return null;
}
} else {
return null;
}});

Clazz.newMeth(C$, 'GetSelection$java_awt_Point',  function (p) {
for (var i=1; i <= 2; i++) {
var r=this.GridToRect$I(i);
if (r == null ) {
return 0;
}if (r.contains$I$I(p.x, p.y)) {
return i;
}}
return 0;
});

Clazz.newMeth(C$, 'GetSelection$I$I',  function (xx, yy) {
var p=Clazz.new_($I$(2,1).c$$I$I,[xx, yy]);
return this.GetSelection$java_awt_Point(p);
});

Clazz.newMeth(C$, 'NearlyEqual$D$D',  function (d1, d2) {
return Math.abs(d2 - d1) < 1.0E-10 ;
}, 1);

Clazz.newMeth(C$, 'nns$D$I',  function (arg, sig) {
if (sig <= 0) {
sig=1;
}if (C$.NearlyEqual$D$D(arg, 0.0)) {
return "0";
} else if (arg < 0.0 ) {
return "-" + C$.nns$D$I(-arg, sig);
} else {
var oom=Math.floor(C$.log10$D(arg));
var power=Math.pow(10.0, oom - sig + 1.0);
var intArg=Math.round$D(arg / power);
var result=String.valueOf$D(intArg * power);
while (result.length$() > 1 && result.indexOf$I(46) > -1 ){
var trimmed=false;
var lastChar;
for (lastChar=result.length$() - 1; result.charAt$I(lastChar) == "0"; trimmed=true) {
--lastChar;
}
if (trimmed) {
result=result.substring$I$I(0, lastChar + 1);
}var shortStr=result.substring$I$I(0, lastChar);
var newNum;
try {
newNum=java.lang.Double.parseDouble$S(shortStr);
} catch (var14) {
if (Clazz.exceptionOf(var14,"NumberFormatException")){
break;
} else {
throw var14;
}
}
if (Math.abs(arg - newNum) > power ) {
break;
}result=shortStr;
}
return result;
}}, 1);

Clazz.newMeth(C$, 'nns$D',  function (arg) {
return C$.nns$D$I(arg, 4);
}, 1);

Clazz.newMeth(C$, 'log10$D',  function (arg) {
return Math.log(arg) / Math.log(10.0);
}, 1);

Clazz.newMeth(C$, 'NewSelection$I',  function (newSel) {
this.mSelection=newSel;
this.mSelStart=Clazz.new_(java.util.Date);
this.mOldValue=this.mValue;
if (this.mSelection == 0) {
this.mDeltaPerSec=0.0;
} else {
var oom=Math.floor(C$.log10$D(Math.abs(this.mMax - this.mMin)));
this.mDeltaPerSec=Math.pow(10.0, oom - 2.0);
if (this.mSelection == 2) {
this.mDeltaPerSec=-this.mDeltaPerSec;
}this.NewValue$();
}this.repaint$();
});

Clazz.newMeth(C$, 'NewValue$',  function () {
if (this.mSelStart != null ) {
var startTime=this.mSelStart.getTime$();
var nowDate=Clazz.new_(java.util.Date);
var nowTime=nowDate.getTime$();
var dT=(Long.$sub(nowTime,startTime)) / 1000.0;
var turbo=dT > 1.0 ;
var delta;
var quant;
if (turbo) {
delta=this.mDeltaPerSec * 10.0 * dT ;
quant=this.mDeltaPerSec;
} else {
delta=this.mDeltaPerSec * dT;
quant=this.mDeltaPerSec / 10.0;
}this.mValue=this.mOldValue + delta;
this.mValue=C$.MyRound$D$D(this.mValue, quant);
if (this.mValue < this.mMin ) {
this.mValue=this.mMin;
} else if (this.mValue > this.mMax ) {
this.mValue=this.mMax;
}this.BroadcastValue$();
}});

Clazz.newMeth(C$, 'MyRound$D$D',  function (val, quant) {
if (quant == 0.0 ) {
return val;
} else {
quant=Math.abs(quant);
return Math.round$D(val / quant) * quant;
}}, 1);

Clazz.newMeth(C$, 'BroadcastValue$',  function () {
if (this.mLabel != null ) {
this.mLabel.setText$S(C$.nns$D(this.mValue));
}var e=Clazz.new_($I$(3,1).c$$O$I$O,[this.mApplet, 605, this]);
this.postEvent$java_awt_Event(e);
});

Clazz.newMeth(C$, 'mouseDown$java_awt_Event$I$I',  function (evt, xx, yy) {
this.NewSelection$I(this.GetSelection$I$I(xx, yy));
return true;
});

Clazz.newMeth(C$, 'mouseDrag$java_awt_Event$I$I',  function (evt, xx, yy) {
var newSel=this.GetSelection$I$I(xx, yy);
if (newSel != this.mSelection) {
this.NewSelection$I(newSel);
}return true;
});

Clazz.newMeth(C$, 'mouseUp$java_awt_Event$I$I',  function (evt, xx, yy) {
this.NewSelection$I(0);
return true;
});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (g) {
C$.superclazz.prototype.paint$java_awt_Graphics.apply(this, [g]);
if (this.mSelection != 0) {
this.NewValue$();
g.setXORMode$java_awt_Color($I$(4).black);
var selRect=this.GridToRect$I(this.mSelection);
g.fillRect$I$I$I$I(selRect.x, selRect.y, selRect.width, selRect.height);
g.setPaintMode$();
this.repaint$J(100);
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

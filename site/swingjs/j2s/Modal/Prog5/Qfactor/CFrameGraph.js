(function(){var P$=Clazz.newPackage("Modal.Prog5.Qfactor"),I$=[[0,'java.awt.Color','Modal.Prog5.Qfactor.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Modal.Prog5.Qfactor.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec1=Clazz.array(Double.TYPE, [1601]);
this.mk=400000.0;
this.mm=1.0;
this.mc=50.0;
},1);

C$.$fields$=[['D',['mk','mm','mc','mw','wmax','recptmax','w1','w2','deltaw','mTime'],'I',['smax'],'O',['mRec1','double[]']]]

Clazz.newMeth(C$, 'c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$Modal_Prog5_Qfactor_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(38, 370, 440, 370);
g.drawLine$I$I$I$I(38, 371, 440, 371);
g.drawLine$I$I$I$I(39, 374, 39, 15);
g.drawLine$I$I$I$I(40, 374, 40, 15);
for (var p=0; p < 8; p++) {
g.drawLine$I$I$I$I(40, 370 - p * 50, 37, 370 - p * 50);
}
for (var var5=1; var5 < 5; var5++) {
g.drawLine$I$I$I$I(40 + var5 * 100, 370, 40 + var5 * 100, 374);
}
this.response$();
g.setColor$java_awt_Color(mass);
for (var var6=2; var6 < 400; var6++) {
g.drawLine$I$I$I$I(40 + (var6 - 1), ((370.0 - Math.abs(this.mRec1[(var6 - 1) * 4] * 1.0E7))|0), 40 + var6, ((370.0 - Math.abs(this.mRec1[var6 * 4] * 1.0E7))|0));
}
this.peak$();
g.setColor$java_awt_Color($I$(1).blue);
g.drawLine$I$I$I$I(40 + ((this.wmax / 3.141592653589793)|0), 370, 40 + ((this.wmax / 3.141592653589793)|0), ((370.0 - this.recptmax * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.wmax / 3.141592653589793)|0) - 10, ((369.0 - this.recptmax * 1.0E7)|0), 40 + ((this.wmax / 3.141592653589793)|0) + 10 , ((369.0 - this.recptmax * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.w1 / 3.141592653589793)|0), ((370.0 - this.recptmax * 1.0E7 / Math.sqrt(2.0))|0), 40 + ((this.w2 / 3.141592653589793)|0), ((370.0 - this.recptmax * 1.0E7 / Math.sqrt(2.0))|0));
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, 440, 20);
g.setColor$java_awt_Color($I$(1).black);
g.drawString$S$I$I(" Resonant frequency", 285, 50);
g.drawString$S$I$I($I$(2,"nns$D",[this.wmax / (6.283185307179586)]) + " Hz", 288, 66);
g.drawString$S$I$I(" Delta omega =" + $I$(2,"nns$D",[this.deltaw / (6.283185307179586)]) + " Hz" , 285, 80);
g.drawString$S$I$I(" Q = " + $I$(2).nns$D(this.wmax / this.deltaw), 288, 95);
g.drawString$S$I$I($I$(2,"nns$D",[Math.sqrt(this.mk / this.mm) / (6.283185307179586)]) + " Hz", 525, 225);
g.drawString$S$I$I($I$(2,"nns$D",[this.mc / (2.0 * Math.sqrt(this.mm * this.mk))]), 536, 256);
g.drawString$S$I$I($I$(2,"nns$D",[Math.sqrt(this.mm * this.mk) / this.mc]), 515, 292);
});

Clazz.newMeth(C$, 'log10$D',  function (arg) {
return Math.log(arg) / Math.log(10.0);
});

Clazz.newMeth(C$, 'nns$D$I',  function (arg, sig) {
if (sig <= 0) {
sig=1;
}if (arg == 0.0 ) {
return "0";
} else if (arg < 0.0 ) {
return "-" + this.nns$D$I(-arg, sig);
} else {
var oom=Math.floor(this.log10$D(arg));
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
} catch (var15) {
if (Clazz.exceptionOf(var15,"NumberFormatException")){
break;
} else {
throw var15;
}
}
if (Math.abs(arg - newNum) > power ) {
break;
}result=shortStr;
}
return result;
}});

Clazz.newMeth(C$, 'nns$D',  function (arg) {
return this.nns$D$I(arg, 4);
});

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog5_Qfactor_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mk=val;
this.response$();
break;
case 2:
this.mm=val;
this.response$();
break;
case 3:
this.mc=val;
this.response$();
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
for (var s=1; s < 1601; s++) {
this.mw=s * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
this.mRec1[s]=1.0 / Math.sqrt((this.mk - this.mm * this.mw * this.mw ) * (this.mk - this.mm * this.mw * this.mw ) + this.mc * this.mc * this.mw * this.mw );
}
});

Clazz.newMeth(C$, 'peak$',  function () {
var max=0.0;
for (var s=1; s < 1601; s++) {
if (this.mRec1[s] > max ) {
max=this.mRec1[s];
this.smax=s;
this.wmax=s * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
}}
this.recptmax=max;
this.w1=0.0;
this.w2=200.0;
for (var var4=this.smax; var4 > 0; var4--) {
if (!!(this.mRec1[var4] < max / Math.sqrt(2.0)  & this.mRec1[var4 + 1] > max / Math.sqrt(2.0) )) {
this.w1=var4 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 + (0.7853981633974483) * (max / Math.sqrt(2.0) - this.mRec1[var4]) / (this.mRec1[var4 + 1] - this.mRec1[var4]);
}}
for (var var5=this.smax; var5 < 1601; var5++) {
if (!!(this.mRec1[var5] < max / Math.sqrt(2.0)  & this.mRec1[var5 - 1] > max / Math.sqrt(2.0) )) {
this.w2=var5 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 - (0.7853981633974483) * (max / Math.sqrt(2.0) - this.mRec1[var5]) / (this.mRec1[var5 - 1] - this.mRec1[var5]);
}}
this.deltaw=this.w2 - this.w1;
});

Clazz.newMeth(C$, 'GetTime$',  function () {
return this.mTime;
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevHit) {
if (prevHit) {
return false;
} else {
switch (code) {
case 0:
case 1:
var newOmega=(this.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
if (newOmega > 5000.0 ) {
newOmega=5000.0;
}if (newOmega < 50.0 ) {
newOmega=50.0;
}default:
return true;
}
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

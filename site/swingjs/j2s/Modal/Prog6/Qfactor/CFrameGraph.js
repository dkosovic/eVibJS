(function(){var P$=Clazz.newPackage("Modal.Prog6.Qfactor"),I$=[[0,'java.awt.Color','Modal.Prog6.Qfactor.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'Modal.Prog6.Qfactor.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mRec=Clazz.array(Double.TYPE, [1601]);
this.mRec1=Clazz.array(Double.TYPE, [1601]);
this.mRec2=Clazz.array(Double.TYPE, [1601]);
this.mRec3=Clazz.array(Double.TYPE, [1601]);
this.mm1=1.5;
this.mk1=400000.0;
this.mc1=150.0;
this.mm2=1.2;
this.mk2=200000.0;
this.mc2=3.0;
},1);

C$.$fields$=[['D',['mm1','mk1','mc1','mm2','mk2','mc2','mw','w1max','recpt1max','w11','w12','delta1w','w2max','recpt2max','w21','w22','delta2w','mwn1','mu1','mwn2','mu2','mXi1','mXi2','mTime'],'I',['s1max','s2max'],'O',['mRec','double[]','+mRec1','+mRec2','+mRec3']]]

Clazz.newMeth(C$, 'c$$Modal_Prog6_Qfactor_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$Modal_Prog6_Qfactor_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).black);
g.drawLine$I$I$I$I(38, 410, 440, 410);
g.drawLine$I$I$I$I(38, 411, 440, 411);
g.drawLine$I$I$I$I(39, 414, 39, 55);
g.drawLine$I$I$I$I(40, 414, 40, 55);
for (var p=0; p < 8; p++) {
g.drawLine$I$I$I$I(40, 410 - p * 50, 37, 410 - p * 50);
}
for (var var5=1; var5 < 5; var5++) {
g.drawLine$I$I$I$I(40 + var5 * 100, 410, 40 + var5 * 100, 414);
}
this.response$();
this.peak$();
this.Modes$();
this.Modesum$();
g.setColor$java_awt_Color($I$(1).orange);
for (var var6=2; var6 < 400; var6++) {
g.drawLine$I$I$I$I(40 + (var6 - 1), ((410.0 - Math.abs(this.mRec1[(var6 - 1) * 4] * 1.0E7))|0), 40 + var6, ((410.0 - Math.abs(this.mRec1[var6 * 4] * 1.0E7))|0));
}
g.setColor$java_awt_Color($I$(1).green);
for (var var7=2; var7 < 400; var7++) {
g.drawLine$I$I$I$I(40 + (var7 - 1), ((410.0 - Math.abs(this.mRec2[(var7 - 1) * 4] * 1.0E7))|0), 40 + var7, ((410.0 - Math.abs(this.mRec2[var7 * 4] * 1.0E7))|0));
}
g.setColor$java_awt_Color($I$(1).black);
for (var var8=2; var8 < 400; var8++) {
g.drawLine$I$I$I$I(40 + (var8 - 1), ((410.0 - Math.abs(this.mRec[(var8 - 1) * 4] * 1.0E7))|0), 40 + var8, ((410.0 - Math.abs(this.mRec[var8 * 4] * 1.0E7))|0));
}
g.setColor$java_awt_Color($I$(1).red);
for (var var9=2; var9 < 400; var9++) {
g.drawLine$I$I$I$I(40 + (var9 - 1), ((410.0 - Math.abs(this.mRec3[(var9 - 1) * 4] * 1.0E7))|0), 40 + var9, ((410.0 - Math.abs(this.mRec3[var9 * 4] * 1.0E7))|0));
}
g.setColor$java_awt_Color($I$(1).blue);
g.drawLine$I$I$I$I(40 + ((this.w1max / 3.141592653589793)|0), 410, 40 + ((this.w1max / 3.141592653589793)|0), ((410.0 - this.recpt1max * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.w1max / 3.141592653589793)|0) - 10, ((409.0 - this.recpt1max * 1.0E7)|0), 40 + ((this.w1max / 3.141592653589793)|0) + 10 , ((409.0 - this.recpt1max * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.w11 / 3.141592653589793)|0), ((410.0 - this.recpt1max * 1.0E7 / Math.sqrt(2.0))|0), 40 + ((this.w12 / 3.141592653589793)|0), ((410.0 - this.recpt1max * 1.0E7 / Math.sqrt(2.0))|0));
g.drawLine$I$I$I$I(40 + ((this.w2max / 3.141592653589793)|0), 410, 40 + ((this.w2max / 3.141592653589793)|0), ((410.0 - this.recpt2max * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.w2max / 3.141592653589793)|0) - 10, ((409.0 - this.recpt2max * 1.0E7)|0), 40 + ((this.w2max / 3.141592653589793)|0) + 10 , ((409.0 - this.recpt2max * 1.0E7)|0));
g.drawLine$I$I$I$I(40 + ((this.w21 / 3.141592653589793)|0), ((410.0 - this.recpt2max * 1.0E7 / Math.sqrt(2.0))|0), 40 + ((this.w22 / 3.141592653589793)|0), ((410.0 - this.recpt2max * 1.0E7 / Math.sqrt(2.0))|0));
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, 440, 20);
g.setColor$java_awt_Color($I$(1).black);
g.drawString$S$I$I($I$(2,"nns$D",[this.w1max / (6.283185307179586)]) + " Hz", 24 + ((this.w1max / 3.141592653589793)|0), -5 + ((409.0 - this.recpt1max * 1.0E7)|0));
g.drawString$S$I$I(" Q = " + $I$(2).nns$D(this.w1max / this.delta1w), 56 + ((this.w1max / 3.141592653589793)|0), 9 + ((409.0 - this.recpt1max * 1.0E7)|0));
g.setColor$java_awt_Color($I$(1).black);
g.drawString$S$I$I($I$(2,"nns$D",[this.w2max / (6.283185307179586)]) + " Hz", 24 + ((this.w2max / 3.141592653589793)|0), -5 + ((409.0 - this.recpt2max * 1.0E7)|0));
g.drawString$S$I$I(" Q = " + $I$(2).nns$D(this.w2max / this.delta2w), 56 + ((this.w2max / 3.141592653589793)|0), 9 + ((409.0 - this.recpt2max * 1.0E7)|0));
g.drawString$S$I$I($I$(2,"nns$D",[this.mwn1 / (6.283185307179586)]) + " Hz", 538, 315);
g.drawString$S$I$I($I$(2).nns$D(this.mu1), 538, 335);
g.drawString$S$I$I($I$(2,"nns$D",[this.mwn2 / (6.283185307179586)]) + " Hz", 538, 372);
g.drawString$S$I$I($I$(2).nns$D(this.mu2), 538, 392);
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

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog6_Qfactor_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 1:
this.mm1=val;
this.response$();
break;
case 2:
this.mk1=val;
this.response$();
break;
case 3:
this.mc1=val;
this.response$();
break;
case 4:
this.mm2=val;
this.response$();
break;
case 5:
this.mk2=val;
this.response$();
break;
case 6:
this.mc2=val;
this.response$();
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
for (var s=1; s < 1601; s++) {
this.mw=s * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
var mD=this.mk2 * this.mk2 + this.mw * this.mw * this.mc2 * this.mc2 ;
var mA=this.mk2 / mD - 1.0 / (this.mm2 * this.mw * this.mw );
var mB=-this.mw * this.mc2 / mD;
var mC=this.mk1 - this.mm1 * this.mw * this.mw  + mA / (mA * mA + mB * mB);
mD=this.mw * this.mc1 - mB / (mA * mA + mB * mB);
var mReal=mC / (mC * mC + mD * mD);
var mQuad=-mD / (mC * mC + mD * mD);
this.mRec[s]=Math.sqrt(mReal * mReal + mQuad * mQuad);
}
});

Clazz.newMeth(C$, 'peak$',  function () {
var n=0;
for (var s=3; s < 1601; s++) {
if (!!(this.mRec[s] < this.mRec[s - 1]  & this.mRec[s - 1] > this.mRec[s - 2] )) {
if (++n == 1) {
this.s1max=s - 1;
this.recpt1max=this.mRec[s - 1];
this.w1max=(s - 1) * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
}if (n == 2) {
this.s2max=s - 1;
this.recpt2max=this.mRec[s - 1];
this.w2max=(s - 1) * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
}}}
this.w11=0.0;
this.w12=200.0;
for (var var3=this.s1max; var3 > 0; var3--) {
if (!!(this.mRec[var3] < this.recpt1max / Math.sqrt(2.0)  & this.mRec[var3 + 1] > this.recpt1max / Math.sqrt(2.0) )) {
this.w11=var3 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 + (0.7853981633974483) * (this.recpt1max / Math.sqrt(2.0) - this.mRec[var3]) / (this.mRec[var3 + 1] - this.mRec[var3]);
}}
for (var var4=this.s1max; var4 < this.s2max; var4++) {
if (!!(this.mRec[var4] < this.recpt1max / Math.sqrt(2.0)  & this.mRec[var4 - 1] > this.recpt1max / Math.sqrt(2.0) )) {
this.w12=var4 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 - (0.7853981633974483) * (this.recpt1max / Math.sqrt(2.0) - this.mRec[var4]) / (this.mRec[var4 - 1] - this.mRec[var4]);
}}
this.delta1w=this.w12 - this.w11;
this.mXi1=this.delta1w / (2.0 * this.w1max);
this.w21=0.0;
this.w22=200.0;
for (var var5=this.s2max; var5 > this.s1max; var5--) {
if (!!(this.mRec[var5] < this.recpt2max / Math.sqrt(2.0)  & this.mRec[var5 + 1] > this.recpt2max / Math.sqrt(2.0) )) {
this.w21=var5 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 + (0.7853981633974483) * (this.recpt2max / Math.sqrt(2.0) - this.mRec[var5]) / (this.mRec[var5 + 1] - this.mRec[var5]);
}}
for (var var6=this.s2max; var6 < 1601; var6++) {
if (!!(this.mRec[var6] < this.recpt2max / Math.sqrt(2.0)  & this.mRec[var6 - 1] > this.recpt2max / Math.sqrt(2.0) )) {
this.w22=var6 * 200.0 * 2.0 * 3.141592653589793  / 1600.0 - (0.7853981633974483) * (this.recpt2max / Math.sqrt(2.0) - this.mRec[var6]) / (this.mRec[var6 - 1] - this.mRec[var6]);
}}
this.delta2w=this.w22 - this.w21;
this.mXi2=this.delta2w / (2.0 * this.w2max);
});

Clazz.newMeth(C$, 'Modes$',  function () {
var A=this.mm1 * this.mm2;
var B=-(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
var C=this.mk1 * this.mk2;
this.mwn1=Math.sqrt((-B - Math.sqrt(B * B - 4.0 * A * C )) / 2.0 / A );
this.mwn2=Math.sqrt((-B + Math.sqrt(B * B - 4.0 * A * C )) / 2.0 / A );
this.mu1=this.mk2 / (this.mk2 - this.mm2 * this.mwn1 * this.mwn1 );
this.mu2=this.mk2 / (this.mk2 - this.mm2 * this.mwn2 * this.mwn2 );
});

Clazz.newMeth(C$, 'Modesum$',  function () {
var C1=(1.0 - this.mu2) / (this.mu1 - this.mu2);
var C2=(this.mu1 - 1.0) / (this.mu1 - this.mu2);
var mode1k=this.mk1 / C1;
var mode2k=this.mk1 / C2;
for (var s=1; s < 1601; s++) {
this.mw=s * 200.0 * 2.0 * 3.141592653589793  / 1600.0;
var mA=1.0 - this.mw * this.mw / this.mwn1 / this.mwn1;
var mB=-2.0 * this.mXi1 * this.mw  / this.mwn1;
var mC=mA * mA + mB * mB;
var mReal1=mA / mC / mode1k ;
var mQuad1=mB / mC / mode1k ;
this.mRec1[s]=Math.sqrt(mReal1 * mReal1 + mQuad1 * mQuad1);
mA=1.0 - this.mw * this.mw / this.mwn2 / this.mwn2;
mB=-2.0 * this.mXi2 * this.mw  / this.mwn2;
mC=mA * mA + mB * mB;
var mReal2=mA / mC / mode2k ;
var mQuad2=mB / mC / mode2k ;
this.mRec2[s]=Math.sqrt(mReal2 * mReal2 + mQuad2 * mQuad2);
this.mRec3[s]=Math.sqrt((mReal1 + mReal2) * (mReal1 + mReal2) + (mQuad1 + mQuad2) * (mQuad1 + mQuad2));
}
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

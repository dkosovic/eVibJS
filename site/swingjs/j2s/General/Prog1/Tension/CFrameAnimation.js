(function(){var P$=Clazz.newPackage("General.Prog1.Tension"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'General.Prog1.Tension.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mMass=1.0;
this.mK=10.0;
this.mDelta=-10.0;
this.mXo=6.0;
this.mYo=10.0;
this.mOnOff=0;
this.mVpos=0.0;
this.mSpos=0.0;
this.mXplot=Clazz.array(Double.TYPE, [105]);
this.mYplot=Clazz.array(Double.TYPE, [105]);
this.mpoints=0;
},1);

C$.$fields$=[['Z',['mFirstTime'],'D',['mTime','mMass','mK','mDelta','mXo','mYo','mt','mXpos','mYpos','mVpos','mSpos'],'I',['mState','mOnOff','mXe','mYe','mpoints','mspringpoints'],'O',['mXplot','double[]','+mYplot','+mXspring','+mYspring','mStartButton','java.awt.Button','+mPauseButton','+mStopButton']]]

Clazz.newMeth(C$, 'c$$General_Prog1_Tension_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$General_Prog1_Tension_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mXplot[this.mpoints]=this.mXo;
this.mYplot[this.mpoints]=this.mYo;
this.mXspring=Clazz.array(Double.TYPE, [25]);
this.mYspring=Clazz.array(Double.TYPE, [25]);
this.mspringpoints=1;
this.mFirstTime=true;
this.mState=0;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
if (this.mFirstTime) {
this.reset$();
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color($I$(1).orange);
g.fillRect$I$I$I$I(10, 130, 30, 60);
g.fillRect$I$I$I$I(40 + ((200.0 * (1.0 + this.mDelta / 100.0))|0), 130, 30, 60);
g.setColor$java_awt_Color($I$(1).black);
this.Spring$D$D$D$D(40.0, 160.0, 40.0 + 100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos, 160.0 + this.mYpos);
for (var p=1; p < this.mspringpoints; p++) {
g.drawLine$I$I$I$I((this.mXspring[p]|0), (this.mYspring[p]|0), (this.mXspring[p + 1]|0), (this.mYspring[p + 1]|0));
}
this.Spring$D$D$D$D(40.0 + 100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos, 160.0 + this.mYpos, 40.0 + 200.0 * (1.0 + this.mDelta / 100.0), 160.0);
for (var var14=1; var14 < this.mspringpoints; var14++) {
g.drawLine$I$I$I$I((this.mXspring[var14]|0), (this.mYspring[var14]|0), (this.mXspring[var14 + 1]|0), (this.mYspring[var14 + 1]|0));
}
g.setColor$java_awt_Color(mass);
g.fillOval$I$I$I$I(40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos)|0) - 10, 160 + (this.mYpos|0) - 10, 20, 20);
g.setColor$java_awt_Color($I$(1).black);
this.mXe=40 + ((100.0 * (1.0 + this.mDelta / 100.0))|0);
var malphasol=0.0;
var var15=1;
var malpha=(1.5707963267948966) - 3.141592653589793 * var15 / 200.0;
var mf=100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha) );
var mylast=mf;
for (var var16=2; var16 < 100; var16++) {
malpha=(1.5707963267948966) - 3.141592653589793 * var16 / 200.0;
mf=100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha) );
if (mylast * mf < 0.0 ) {
malphasol=(1.5707963267948966) - 3.141592653589793 * (var16 - 0.5) / 200.0;
this.mYe=160 + ((100.0 * (1.0 + this.mDelta / 100.0) * Math.tan(malphasol) )|0);
g.drawLine$I$I$I$I(this.mXe - 2, this.mYe - 2, this.mXe + 2, this.mYe + 2);
g.drawLine$I$I$I$I(this.mXe - 2, this.mYe + 2, this.mXe + 2, this.mYe - 2);
}mylast=mf;
}
var15=1;
malpha=-3.141592653589793 * var15 / 200.0;
mf=100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha) );
mylast=mf;
for (var var18=2; var18 < 100; var18++) {
malpha=-3.141592653589793 * var18 / 200.0;
mf=100.0 * (1.0 + this.mDelta / 100.0) / Math.cos(malpha) - 100.0 - this.mMass * 9.81 / (2.0 * this.mK * Math.sin(malpha) );
if (mylast * mf < 0.0 ) {
malphasol=-3.141592653589793 * (var18 - 0.5) / 200.0;
}mylast=mf;
}
this.mYe=160 + ((100.0 * (1.0 + this.mDelta / 100.0) * Math.tan(malphasol) )|0);
g.drawLine$I$I$I$I(this.mXe - 2, this.mYe - 2, this.mXe + 2, this.mYe + 2);
g.drawLine$I$I$I$I(this.mXe - 2, this.mYe + 2, this.mXe + 2, this.mYe - 2);
g.drawLine$I$I$I$I(418, 398, 422, 402);
g.drawLine$I$I$I$I(418, 402, 422, 398);
g.drawString$S$I$I("-  Equilibrium position(s)", 430, 404);
this.Increment$();
if (this.mOnOff == 1) {
g.setColor$java_awt_Color($I$(1).black);
g.drawRect$I$I$I$I(40 + ((100.0 * (1.0 + this.mDelta / 100.0) - Math.abs(this.mXo) - 10.0)|0), 340, ((2.0 * Math.abs(this.mXo) + 20.0)|0), 100);
g.setColor$java_awt_Color($I$(1).black);
g.drawRect$I$I$I$I(490, 50, 100, 290);
g.setColor$java_awt_Color(mass);
g.drawLine$I$I$I$I(40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos)|0), 160 + (this.mYpos|0), 40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos)|0), 340);
for (var var19=1; var19 < this.mpoints; var19++) {
g.drawLine$I$I$I$I(40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXplot[var19])|0), 340 + this.mpoints - var19, 40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXplot[var19 + 1])|0), 340 + this.mpoints - var19 - 1);
}
g.drawLine$I$I$I$I(40 + ((100.0 * (1.0 + this.mDelta / 100.0) + this.mXpos)|0), 160 + (this.mYpos|0), 490, 160 + (this.mYpos|0));
for (var var20=1; var20 < this.mpoints; var20++) {
g.drawLine$I$I$I$I(490 + this.mpoints - var20, 160 + (this.mYplot[var20]|0), 490 + this.mpoints - var20 - 1, 160 + (this.mYplot[var20 + 1]|0));
}
}g.setPaintMode$();
});

Clazz.newMeth(C$, 'reset$',  function () {
this.mFirstTime=false;
this.mTime=0.0;
this.mt=0.0;
this.mXpos=this.mXo;
this.mYpos=this.mYo;
this.mVpos=0.0;
this.mSpos=0.0;
this.mpoints=0;
});

Clazz.newMeth(C$, 'Increment$',  function () {
if (this.mFirstTime) {
this.reset$();
}if (this.mState == 1) {
this.mt+=0.01;
var mdtx2=0.02;
var mX1=this.mXpos;
var mY1=this.mYpos;
var mV1=this.mVpos;
var mS1=this.mSpos;
var hypotenuse1=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX1) * (100.0 * (1.0 + this.mDelta / 100.0) + mX1) + mY1 * mY1);
var hypotenuse2=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX1) * (100.0 * (1.0 + this.mDelta / 100.0) - mX1) + mY1 * mY1);
var sinalpha1=mY1 / hypotenuse1;
var cosalpha1=(100.0 * (1.0 + this.mDelta / 100.0) + mX1) / hypotenuse1;
var sinalpha2=mY1 / hypotenuse2;
var cosalpha2=(100.0 * (1.0 + this.mDelta / 100.0) - mX1) / hypotenuse2;
var delta1=hypotenuse1 - 100.0;
var delta2=hypotenuse2 - 100.0;
var mF1=(this.mK * delta2 * cosalpha2  - this.mK * delta1 * cosalpha1 ) / this.mMass;
var mX2=mX1 + mV1 * mdtx2 / 2.0;
var mV2=mV1 + mF1 * mdtx2 / 2.0;
var mP1=(this.mMass * 9.81 - this.mK * delta2 * sinalpha2  - this.mK * delta1 * sinalpha1 ) / this.mMass;
var mY2=mY1 + mS1 * mdtx2 / 2.0;
var mS2=mS1 + mP1 * mdtx2 / 2.0;
hypotenuse1=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX2) * (100.0 * (1.0 + this.mDelta / 100.0) + mX2) + mY2 * mY2);
hypotenuse2=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX2) * (100.0 * (1.0 + this.mDelta / 100.0) - mX2) + mY2 * mY2);
sinalpha1=mY2 / hypotenuse1;
cosalpha1=(100.0 * (1.0 + this.mDelta / 100.0) + mX2) / hypotenuse1;
sinalpha2=mY2 / hypotenuse2;
cosalpha2=(100.0 * (1.0 + this.mDelta / 100.0) - mX2) / hypotenuse2;
delta1=hypotenuse1 - 100.0;
delta2=hypotenuse2 - 100.0;
var mF2=(this.mK * delta2 * cosalpha2  - this.mK * delta1 * cosalpha1 ) / this.mMass;
var mX3=mX1 + mV2 * mdtx2 / 2.0;
var mV3=mV1 + mF2 * mdtx2 / 2.0;
var mP2=(this.mMass * 9.81 - this.mK * delta2 * sinalpha2  - this.mK * delta1 * sinalpha1 ) / this.mMass;
var mY3=mY1 + mS2 * mdtx2 / 2.0;
var mS3=mS1 + mP2 * mdtx2 / 2.0;
hypotenuse1=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX3) * (100.0 * (1.0 + this.mDelta / 100.0) + mX3) + mY3 * mY3);
hypotenuse2=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX3) * (100.0 * (1.0 + this.mDelta / 100.0) - mX3) + mY3 * mY3);
sinalpha1=mY3 / hypotenuse1;
cosalpha1=(100.0 * (1.0 + this.mDelta / 100.0) + mX3) / hypotenuse1;
sinalpha2=mY3 / hypotenuse2;
cosalpha2=(100.0 * (1.0 + this.mDelta / 100.0) - mX3) / hypotenuse2;
delta1=hypotenuse1 - 100.0;
delta2=hypotenuse2 - 100.0;
var mF3=(this.mK * delta2 * cosalpha2  - this.mK * delta1 * cosalpha1 ) / this.mMass;
var mX4=mX1 + mV3 * mdtx2;
var mV4=mV1 + mF3 * mdtx2;
var mP3=(this.mMass * 9.81 - this.mK * delta2 * sinalpha2  - this.mK * delta1 * sinalpha1 ) / this.mMass;
var mY4=mY1 + mS3 * mdtx2;
var mS4=mS1 + mP3 * mdtx2;
hypotenuse1=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) + mX4) * (100.0 * (1.0 + this.mDelta / 100.0) + mX4) + mY4 * mY4);
hypotenuse2=Math.sqrt((100.0 * (1.0 + this.mDelta / 100.0) - mX4) * (100.0 * (1.0 + this.mDelta / 100.0) - mX4) + mY4 * mY4);
sinalpha1=mY4 / hypotenuse1;
cosalpha1=(100.0 * (1.0 + this.mDelta / 100.0) + mX4) / hypotenuse1;
sinalpha2=mY4 / hypotenuse2;
cosalpha2=(100.0 * (1.0 + this.mDelta / 100.0) - mX4) / hypotenuse2;
delta1=hypotenuse1 - 100.0;
delta2=hypotenuse2 - 100.0;
var mF4=(this.mK * delta2 * cosalpha2  - this.mK * delta1 * cosalpha1 ) / this.mMass;
var mP4=(this.mMass * 9.81 - this.mK * delta2 * sinalpha2  - this.mK * delta1 * sinalpha1 ) / this.mMass;
this.mXpos=mX1 + (mV1 + 2.0 * mV2 + 2.0 * mV3 + mV4) * mdtx2 / 6.0;
this.mVpos=mV1 + (mF1 + 2.0 * mF2 + 2.0 * mF3 + mF4) * mdtx2 / 6.0;
this.mYpos=mY1 + (mS1 + 2.0 * mS2 + 2.0 * mS3 + mS4) * mdtx2 / 6.0;
this.mSpos=mS1 + (mP1 + 2.0 * mP2 + 2.0 * mP3 + mP4) * mdtx2 / 6.0;
if (this.mpoints < 100) {
++this.mpoints;
} else {
this.mpoints=100;
for (var p=1; p < 100; p++) {
this.mXplot[p]=this.mXplot[p + 1];
this.mYplot[p]=this.mYplot[p + 1];
}
}this.mXplot[this.mpoints]=this.mXpos;
this.mYplot[this.mpoints]=this.mYpos;
}});

Clazz.newMeth(C$, 'Spring$D$D$D$D',  function (x1, y1, x2, y2) {
var n=4;
var d=20.0;
var b=20.0;
var mL=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
var malpha=Math.atan((y2 - y1) / (x2 - x1));
if (malpha > 1.5707963267948966 ) {
malpha-=3.141592653589793;
}var mLs=Math.sqrt(b * b / 4.0 + (mL - 2.0 * d) * (mL - 2.0 * d) / (16.0 * n * n ));
var mbeta=Math.atan(2.0 * n * b  / (mL - 2.0 * d));
if (mbeta > 1.5707963267948966 ) {
mbeta-=3.141592653589793;
}this.mspringpoints=1;
this.mXspring[this.mspringpoints]=x1;
this.mYspring[this.mspringpoints]=y1;
++this.mspringpoints;
this.mXspring[this.mspringpoints]=this.mXspring[this.mspringpoints - 1] + d * Math.cos(malpha);
this.mYspring[this.mspringpoints]=this.mYspring[this.mspringpoints - 1] + d * Math.sin(malpha);
++this.mspringpoints;
this.mXspring[this.mspringpoints]=this.mXspring[this.mspringpoints - 1] + mLs * Math.cos(malpha + mbeta);
this.mYspring[this.mspringpoints]=this.mYspring[this.mspringpoints - 1] + mLs * Math.sin(malpha + mbeta);
++this.mspringpoints;
for (var p=1; p < n; p++) {
this.mXspring[this.mspringpoints]=this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta - malpha) ;
this.mYspring[this.mspringpoints]=this.mYspring[this.mspringpoints - 1] - 2.0 * mLs * Math.sin(mbeta - malpha) ;
++this.mspringpoints;
this.mXspring[this.mspringpoints]=this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta + malpha) ;
this.mYspring[this.mspringpoints]=this.mYspring[this.mspringpoints - 1] + 2.0 * mLs * Math.sin(mbeta + malpha) ;
++this.mspringpoints;
}
this.mXspring[this.mspringpoints]=this.mXspring[this.mspringpoints - 1] + 2.0 * mLs * Math.cos(mbeta - malpha) ;
this.mYspring[this.mspringpoints]=this.mYspring[this.mspringpoints - 1] - 2.0 * mLs * Math.sin(mbeta - malpha) ;
++this.mspringpoints;
this.mXspring[this.mspringpoints]=x2 - d * Math.cos(malpha);
this.mYspring[this.mspringpoints]=y2 - d * Math.sin(malpha);
++this.mspringpoints;
this.mXspring[this.mspringpoints]=x2;
this.mYspring[this.mspringpoints]=y2;
});

Clazz.newMeth(C$, 'ControlMessage$General_Prog1_Tension_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 0:
if (this.mState == 1) {
this.mTime+=val;
}mustRedraw=true;
break;
case 1:
this.ChangeRunState$I((val|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mMass=val;
this.reset$();
break;
case 3:
this.ChangeRunState$I(0);
this.mK=val;
this.reset$();
break;
case 4:
this.ChangeRunState$I(0);
this.mDelta=val;
this.reset$();
break;
case 5:
this.ChangeRunState$I(0);
this.mXo=(val|0);
this.reset$();
break;
case 6:
this.ChangeRunState$I(0);
this.mYo=val;
this.reset$();
break;
case 7:
this.mOnOff=(val|0);
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (newState) {
switch (this.mState) {
case 0:
if (newState == 1) {
this.mState=1;
this.mFirstTime=true;
}break;
case 1:
if (newState == 0) {
this.mState=newState;
}if (newState == 2) {
this.mState=newState;
}break;
case 2:
if (newState == 0 || newState == 1 ) {
this.mState=newState;
}}
this.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, 'UpdateButtonAppearance$',  function () {
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

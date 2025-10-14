(function(){var P$=Clazz.newPackage("OneDOF.Prog13.Complex"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog13.Complex.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mW=0.5;
this.mF=85.0;
this.mX=40.0;
this.mPhi=-60.0;
},1);

C$.$fields$=[['Z',['mFirstTime'],'D',['mTime','mViewTime','mW','mF','mX','mPhi'],'I',['mState'],'O',['mStartButton','java.awt.Button','+mStopButton','mSpringHelp','OneDOF.Prog13.Complex.CFrameHelp','+mDamperHelp','+mMassHelp']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog13_Complex_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$OneDOF_Prog13_Complex_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mFirstTime=true;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
if (this.mFirstTime) {
this.mFirstTime=false;
this.mTime=0.0;
this.mViewTime=0.0;
}var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var force=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
g.setPaintMode$();
g.setColor$java_awt_Color($I$(1).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(1).lightGray);
g.drawLine$I$I$I$I(10, 160, 350, 160);
g.drawLine$I$I$I$I(360, 160, 510, 160);
g.drawLine$I$I$I$I(500, 150, 500, 170);
g.setColor$java_awt_Color($I$(1).green);
var rotation=((this.mW * this.mTime * 360.0  + 20.0)|0);
g.fillArc$I$I$I$I$I$I(485, 145, 30, 30, rotation, (this.mPhi|0));
g.setColor$java_awt_Color($I$(1).white);
g.fillArc$I$I$I$I$I$I(487, 147, 26, 26, rotation, (this.mPhi|0));
g.setColor$java_awt_Color(force);
var mxforF=((this.mF * Math.cos(this.mW * this.mTime * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0);
var myforF=((-this.mF * Math.sin(this.mW * this.mTime * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0);
g.drawLine$I$I$I$I(500, 160, 500 + mxforF, 160 + myforF);
g.drawLine$I$I$I$I(500 + mxforF, 160 + myforF, 350, 160 + myforF);
for (var p=0; p < 170; p++) {
g.drawLine$I$I$I$I(350 - p * 2, 160 + ((-this.mF * Math.sin(this.mW * (this.mTime - p * 0.025) * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0), 350 - (p + 1) * 2, 160 + ((-this.mF * Math.sin(this.mW * (this.mTime - (p + 1) * 0.025) * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0));
}
g.setColor$java_awt_Color(mass);
var mxforX=((this.mX * Math.cos(this.mW * this.mTime * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0);
var myforX=((-this.mX * Math.sin(this.mW * this.mTime * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0);
g.drawLine$I$I$I$I(500, 160, 500 + mxforX, 160 + myforX);
g.drawLine$I$I$I$I(500 + mxforX, 160 + myforX, 350, 160 + myforX);
for (var var10=0; var10 < 170; var10++) {
g.drawLine$I$I$I$I(350 - var10 * 2, 160 + ((-this.mX * Math.sin(this.mW * (this.mTime - var10 * 0.025) * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0), 350 - (var10 + 1) * 2, 160 + ((-this.mX * Math.sin(this.mW * (this.mTime - (var10 + 1) * 0.025) * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0));
}
g.setColor$java_awt_Color($I$(1).black);
g.drawRect$I$I$I$I(10, 50, 340, 220);
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog13_Complex_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 0:
if (this.mState == 1) {
this.mTime+=val;
this.mViewTime=this.mTime;
}mustRedraw=true;
break;
case 1:
this.ChangeRunState$I((val|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mW=val;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mF=val;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mX=val;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mPhi=val;
}
if (mustRedraw) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (newState) {
switch (this.mState) {
case 0:
if (newState == 1) {
this.mTime=0.0;
this.mViewTime=0.0;
this.mFirstTime=true;
this.mState=1;
}break;
case 1:
if (newState == 0) {
this.mState=newState;
}}
this.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, 'UpdateButtonAppearance$',  function () {
this.mFramePanel.repaint$();
});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

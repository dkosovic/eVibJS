(function(){var P$=Clazz.newPackage("OneDOF.ComplexAbutment.Complex"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.ComplexAbutment.Complex.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mW=0.5;
this.mXo=85.0;
this.mX=40.0;
this.mPhi=-60.0;
},1);

C$.$fields$=[['Z',['mFirstTime'],'D',['mTime','mViewTime','mW','mXo','mX','mPhi'],'I',['mState'],'O',['mStartButton','java.awt.Button','+mStopButton','mSpringHelp','OneDOF.ComplexAbutment.Complex.CFrameHelp','+mDamperHelp','+mMassHelp']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$$OneDOF_ComplexAbutment_Complex_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$OneDOF_ComplexAbutment_Complex_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mFirstTime=true;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
if (this.mFirstTime) {
this.mFirstTime=false;
this.mTime=0.0;
this.mViewTime=0.0;
}var var8=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).lightGray);
var1.drawLine$I$I$I$I(10, 160, 350, 160);
var1.drawLine$I$I$I$I(360, 160, 510, 160);
var1.drawLine$I$I$I$I(500, 150, 500, 170);
var1.setColor$java_awt_Color($I$(1).green);
var var3=((this.mW * this.mTime * 360.0  + 20.0)|0);
var1.fillArc$I$I$I$I$I$I(485, 145, 30, 30, var3, (this.mPhi|0));
var1.setColor$java_awt_Color($I$(1).white);
var1.fillArc$I$I$I$I$I$I(487, 147, 26, 26, var3, (this.mPhi|0));
var1.setColor$java_awt_Color($I$(1).orange);
var var5=((this.mXo * Math.cos(this.mW * this.mTime * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0);
var var4=((-this.mXo * Math.sin(this.mW * this.mTime * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0);
var1.drawLine$I$I$I$I(500, 160, 500 + var5, 160 + var4);
var1.drawLine$I$I$I$I(500 + var5, 160 + var4, 350, 160 + var4);
for (var var2=0; var2 < 170; var2++) {
var1.drawLine$I$I$I$I(350 - var2 * 2, 160 + ((-this.mXo * Math.sin(this.mW * (this.mTime - var2 * 0.025) * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0), 350 - (var2 + 1) * 2, 160 + ((-this.mXo * Math.sin(this.mW * (this.mTime - (var2 + 1) * 0.025) * 2.0 * 3.141592653589793  + (0.3490658503988659)))|0));
}
var1.setColor$java_awt_Color(var8);
var var7=((this.mX * Math.cos(this.mW * this.mTime * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0);
var var6=((-this.mX * Math.sin(this.mW * this.mTime * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0);
var1.drawLine$I$I$I$I(500, 160, 500 + var7, 160 + var6);
var1.drawLine$I$I$I$I(500 + var7, 160 + var6, 350, 160 + var6);
for (var var9=0; var9 < 170; var9++) {
var1.drawLine$I$I$I$I(350 - var9 * 2, 160 + ((-this.mX * Math.sin(this.mW * (this.mTime - var9 * 0.025) * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0), 350 - (var9 + 1) * 2, 160 + ((-this.mX * Math.sin(this.mW * (this.mTime - (var9 + 1) * 0.025) * 2.0 * 3.141592653589793  + (this.mPhi + 20.0) * 3.141592653589793 / 180.0))|0));
}
var1.setColor$java_awt_Color($I$(1).black);
var1.drawRect$I$I$I$I(10, 50, 340, 220);
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_ComplexAbutment_Complex_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 0:
if (this.mState == 1) {
this.mTime+=var3;
this.mViewTime=this.mTime;
}var5=true;
break;
case 1:
this.ChangeRunState$I((var3|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mW=var3;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mXo=var3;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mX=var3;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mPhi=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (var1) {
switch (this.mState) {
case 0:
if (var1 == 1) {
this.mTime=0.0;
this.mViewTime=0.0;
this.mFirstTime=true;
this.mState=1;
}break;
case 1:
if (var1 == 0) {
this.mState=var1;
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

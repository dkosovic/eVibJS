(function(){var P$=Clazz.newPackage("Beam.Prog3.Modes"),I$=[[0,'java.awt.Color','Beam.Prog3.Modes.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Beam.Prog3.Modes.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm=2.0;
this.mk1=20.0;
this.mk2=20.0;
this.mA1=40.0;
this.mA2=0.0;
},1);

C$.$fields$=[['Z',['mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mm','mk1','mk2','mA1','mA2','mT','myscale','mdispmax','mB','mw1','mw2','mmode1','mmode2','ma11','ma12','ma21','ma22'],'I',['mState','mxEdge'],'O',['mX1','double[]','+mY1','+mF1','+mX2','+mY2','+mF2','mStartButton','java.awt.Button','+mPauseButton','+mStopButton']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$$Beam_Prog3_Modes_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Beam_Prog3_Modes_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mTime=0.0;
this.mB=Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2)  - 12.0 * this.mk1 * this.mk2 );
this.mw1=Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
this.mw2=Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
this.mmode1=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1 );
this.mmode2=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2 );
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mxEdge=20;
var var2=((this.ma11 * Math.cos(this.mw1 * this.mTime) + this.ma12 * Math.cos(this.mw2 * this.mTime))|0);
var var3=((this.ma21 * Math.cos(this.mw1 * this.mTime) + this.ma22 * Math.cos(this.mw2 * this.mTime))|0);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 185, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var var9=(113 + var2 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 185, this.mxEdge - 6, ((185.0 + var9 / 2.0)|0));
for (var var8=1; var8 < 10; var8++) {
if (var8 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + (2 * var8 - 1) * var9 / 2.0)|0), this.mxEdge - 6, ((185.0 + (2 * var8 + 1) * var9 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((185.0 + (2 * var8 - 1) * var9 / 2.0)|0), this.mxEdge + 6, ((185.0 + (2 * var8 + 1) * var9 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + 19.0 * var9 / 2.0)|0), this.mxEdge, 111 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var var11=(113 + var3 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, ((185.0 + var11 / 2.0)|0));
for (var var18=1; var18 < 10; var18++) {
if (var18 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + (2 * var18 - 1) * var11 / 2.0)|0), this.mxEdge + 200 - 6, ((185.0 + (2 * var18 + 1) * var11 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((185.0 + (2 * var18 - 1) * var11 / 2.0)|0), this.mxEdge + 200 + 6 , ((185.0 + (2 * var18 + 1) * var11 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + 19.0 * var11 / 2.0)|0), this.mxEdge + 200, 111 + var3 + 2 );
var var13=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var13);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 + 1 , this.mxEdge + 200, 111 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
this.mxEdge=290;
var2=((this.ma11 * Math.cos(this.mw1 * this.mTime))|0);
var3=((this.ma21 * Math.cos(this.mw1 * this.mTime))|0);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 185, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var9=(113 + var2 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 185, this.mxEdge - 6, ((185.0 + var9 / 2.0)|0));
for (var var19=1; var19 < 10; var19++) {
if (var19 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + (2 * var19 - 1) * var9 / 2.0)|0), this.mxEdge - 6, ((185.0 + (2 * var19 + 1) * var9 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((185.0 + (2 * var19 - 1) * var9 / 2.0)|0), this.mxEdge + 6, ((185.0 + (2 * var19 + 1) * var9 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + 19.0 * var9 / 2.0)|0), this.mxEdge, 111 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var11=(113 + var3 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, ((185.0 + var11 / 2.0)|0));
for (var var20=1; var20 < 10; var20++) {
if (var20 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + (2 * var20 - 1) * var11 / 2.0)|0), this.mxEdge + 200 - 6, ((185.0 + (2 * var20 + 1) * var11 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((185.0 + (2 * var20 - 1) * var11 / 2.0)|0), this.mxEdge + 200 + 6 , ((185.0 + (2 * var20 + 1) * var11 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + 19.0 * var11 / 2.0)|0), this.mxEdge + 200, 111 + var3 + 2 );
var1.setColor$java_awt_Color(var13);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 + 1 , this.mxEdge + 200, 111 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
this.mxEdge=550;
var2=((this.ma12 * Math.cos(this.mw2 * this.mTime))|0);
var3=((this.ma22 * Math.cos(this.mw2 * this.mTime))|0);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 185, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var9=(113 + var2 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 185, this.mxEdge - 6, ((185.0 + var9 / 2.0)|0));
for (var var21=1; var21 < 10; var21++) {
if (var21 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + (2 * var21 - 1) * var9 / 2.0)|0), this.mxEdge - 6, ((185.0 + (2 * var21 + 1) * var9 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((185.0 + (2 * var21 - 1) * var9 / 2.0)|0), this.mxEdge + 6, ((185.0 + (2 * var21 + 1) * var9 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((185.0 + 19.0 * var9 / 2.0)|0), this.mxEdge, 111 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var11=(113 + var3 - 185) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 185, this.mxEdge + 200 - 6, ((185.0 + var11 / 2.0)|0));
for (var var22=1; var22 < 10; var22++) {
if (var22 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + (2 * var22 - 1) * var11 / 2.0)|0), this.mxEdge + 200 - 6, ((185.0 + (2 * var22 + 1) * var11 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((185.0 + (2 * var22 - 1) * var11 / 2.0)|0), this.mxEdge + 200 + 6 , ((185.0 + (2 * var22 + 1) * var11 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((185.0 + 19.0 * var11 / 2.0)|0), this.mxEdge + 200, 111 + var3 + 2 );
var1.setColor$java_awt_Color(var13);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 + 1 , this.mxEdge + 200, 111 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2, this.mxEdge + 200, 111 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 111 + var2 - 1, this.mxEdge + 200, 111 + var3 - 1);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawString$S$I$I(" Resultant motion", 75, 225);
var1.drawString$S$I$I(" First Mode contribution", 320, 225);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mw1 / (6.283185307179586)]) + " Hz" , 320, 245);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmode1), 320, 265);
var1.drawString$S$I$I(" Second Mode contribution", 580, 225);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mw2 / (6.283185307179586)]) + " Hz" , 580, 245);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmode2), 580, 265);
});

Clazz.newMeth(C$, 'ControlMessage$Beam_Prog3_Modes_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 0:
if (this.mState == 1) {
this.mTime+=var3;
}var5=true;
break;
case 1:
this.ChangeRunState$I((var3|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mm=var3;
this.mB=Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2)  - 12.0 * this.mk1 * this.mk2 );
this.mw1=Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
this.mw2=Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
this.mmode1=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1 );
this.mmode2=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2 );
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mk1=var3;
this.mB=Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2)  - 12.0 * this.mk1 * this.mk2 );
this.mw1=Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
this.mw2=Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
this.mmode1=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1 );
this.mmode2=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2 );
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mk2=var3;
this.mB=Math.sqrt(4.0 * (this.mk1 + this.mk2) * (this.mk1 + this.mk2)  - 12.0 * this.mk1 * this.mk2 );
this.mw1=Math.sqrt((2.0 * (this.mk1 + this.mk2) - this.mB) / this.mm);
this.mw2=Math.sqrt((2.0 * (this.mk1 + this.mk2) + this.mB) / this.mm);
this.mmode1=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw1 * this.mw1 );
this.mmode2=2.0 * this.mk2 / (4.0 * this.mk1 - this.mm * this.mw2 * this.mw2 );
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mA1=var3;
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
break;
case 6:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mA2=var3;
this.ma22=(this.mmode1 * this.mA2 - this.mA1) / (this.mmode1 - this.mmode2);
this.ma21=(this.mA1 - this.mmode2 * this.mA2) / (this.mmode1 - this.mmode2);
this.ma11=this.mmode1 * this.ma21;
this.ma12=this.mmode2 * this.ma22;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (var1) {
switch (this.mState) {
case 0:
if (var1 == 1) {
this.mTime=0.0;
this.mState=1;
}break;
case 1:
if (var1 == 2 || var1 == 0 ) {
this.mState=var1;
}break;
case 2:
if (var1 == 0 || var1 == 1 ) {
this.mState=var1;
}}
this.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, 'UpdateButtonAppearance$',  function () {
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$, 'UserDrag$I',  function (var1) {
if (this.mState == 1) {
this.ChangeRunState$I(2);
}this.mViewTime=this.mViewTime - var1 * C$.dt;
this.repaint$();
});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:47 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

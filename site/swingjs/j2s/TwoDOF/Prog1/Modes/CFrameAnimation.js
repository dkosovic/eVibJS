(function(){var P$=Clazz.newPackage("TwoDOF.Prog1.Modes"),I$=[[0,'java.awt.Color','TwoDOF.Prog1.Modes.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog1.Modes.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm1=1.0;
this.mk1=8.0;
this.mm2=1.0;
this.mk2=8.0;
},1);

C$.$fields$=[['Z',['mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mm1','mk1','mm2','mk2','mT','myscale','mdispmax','mA','mB','mC','mw1','mw2','mmode1','mmode2'],'I',['mState','mxEdge'],'O',['mStartButton','java.awt.Button','+mPauseButton','+mStopButton']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog1_Modes_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$TwoDOF_Prog1_Modes_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mTime=0.0;
this.mA=this.mm1 * this.mm2;
this.mB=-(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
this.mC=this.mk1 * this.mk2;
this.mw1=Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mw2=Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mmode1=1.0 - this.mm2 * this.mw1 * this.mw1  / this.mk2;
this.mmode2=1.0 - this.mm2 * this.mw2 * this.mw2  / this.mk2;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mxEdge=90;
var var4;
var var6;
if (Math.abs(this.mmode1) > 1.0 ) {
var4=30.0;
var6=var4 / this.mmode1;
} else {
var6=30.0;
var4=var6 * this.mmode1;
}var var2=((var4 * Math.sin(this.mw1 * this.mTime))|0);
var var3=((var6 * Math.sin(this.mw1 * this.mTime))|0);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge, 49, 35, 20);
var1.setColor$java_awt_Color($I$(1).black);
var var9=(140 + var2 - 49 - 20) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 17, 69, this.mxEdge + 17 + 6 , ((69.0 + var9 / 2.0)|0));
for (var var8=1; var8 < 10; var8++) {
if (var8 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((69.0 + (2 * var8 - 1) * var9 / 2.0)|0), this.mxEdge + 17 + 6 , ((69.0 + (2 * var8 + 1) * var9 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 17 + 6 , ((69.0 + (2 * var8 - 1) * var9 / 2.0)|0), this.mxEdge + 17 - 6, ((69.0 + (2 * var8 + 1) * var9 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((69.0 + 19.0 * var9 / 2.0)|0), this.mxEdge + 17, 140 + var2);
var var11=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var11);
var1.fillRect$I$I$I$I(this.mxEdge, 140 + var2, 35, 20);
var1.setColor$java_awt_Color($I$(1).black);
var9=(231 + var3 - 140 - 20 - var2) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6 , ((160 + var2 + var9 / 2.0 )|0));
for (var var16=1; var16 < 10; var16++) {
if (var16 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((160 + var2 + (2 * var16 - 1) * var9 / 2.0 )|0), this.mxEdge + 17 + 6 , ((160 + var2 + (2 * var16 + 1) * var9 / 2.0 )|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 17 + 6 , ((160 + var2 + (2 * var16 - 1) * var9 / 2.0 )|0), this.mxEdge + 17 - 6, ((160 + var2 + (2 * var16 + 1) * var9 / 2.0 )|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((160 + var2 + 19.0 * var9 / 2.0 )|0), this.mxEdge + 17, 231 + var3);
var1.setColor$java_awt_Color(var11);
var1.fillRect$I$I$I$I(this.mxEdge, 231 + var3, 35, 20);
this.mxEdge=290;
if (Math.abs(this.mmode2) > 1.0 ) {
var4=30.0;
var6=var4 / this.mmode2;
} else {
var6=30.0;
var4=var6 * this.mmode2;
}var2=((var4 * Math.sin(this.mw2 * this.mTime))|0);
var3=((var6 * Math.sin(this.mw2 * this.mTime))|0);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge, 49, 35, 20);
var1.setColor$java_awt_Color($I$(1).black);
var9=(140 + var2 - 49 - 20) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 17, 69, this.mxEdge + 17 + 6 , ((69.0 + var9 / 2.0)|0));
for (var var17=1; var17 < 10; var17++) {
if (var17 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((69.0 + (2 * var17 - 1) * var9 / 2.0)|0), this.mxEdge + 17 + 6 , ((69.0 + (2 * var17 + 1) * var9 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 17 + 6 , ((69.0 + (2 * var17 - 1) * var9 / 2.0)|0), this.mxEdge + 17 - 6, ((69.0 + (2 * var17 + 1) * var9 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((69.0 + 19.0 * var9 / 2.0)|0), this.mxEdge + 17, 140 + var2);
var1.setColor$java_awt_Color(var11);
var1.fillRect$I$I$I$I(this.mxEdge, 140 + var2, 35, 20);
var1.setColor$java_awt_Color($I$(1).black);
var9=(231 + var3 - 140 - 20 - var2) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 17, 160 + var2, this.mxEdge + 17 + 6 , ((160 + var2 + var9 / 2.0 )|0));
for (var var18=1; var18 < 10; var18++) {
if (var18 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((160 + var2 + (2 * var18 - 1) * var9 / 2.0 )|0), this.mxEdge + 17 + 6 , ((160 + var2 + (2 * var18 + 1) * var9 / 2.0 )|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 17 + 6 , ((160 + var2 + (2 * var18 - 1) * var9 / 2.0 )|0), this.mxEdge + 17 - 6, ((160 + var2 + (2 * var18 + 1) * var9 / 2.0 )|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 17 - 6, ((160 + var2 + 19.0 * var9 / 2.0 )|0), this.mxEdge + 17, 231 + var3);
var1.setColor$java_awt_Color(var11);
var1.fillRect$I$I$I$I(this.mxEdge, 231 + var3, 35, 20);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawString$S$I$I("First Mode", 80, 295);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mw1 / (6.283185307179586)]) + " Hz" , 30, 315);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmode1), 30, 335);
var1.drawString$S$I$I("Second Mode", 280, 295);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mw2 / (6.283185307179586)]) + " Hz" , 230, 315);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmode2), 230, 335);
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog1_Modes_CFrame$I$D',  function (var1, var2, var3) {
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
this.mm1=var3;
this.mA=this.mm1 * this.mm2;
this.mB=-(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
this.mC=this.mk1 * this.mk2;
this.mw1=Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mw2=Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mmode1=1.0 - this.mm2 * this.mw1 * this.mw1  / this.mk2;
this.mmode2=1.0 - this.mm2 * this.mw2 * this.mw2  / this.mk2;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mk1=var3;
this.mA=this.mm1 * this.mm2;
this.mB=-(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
this.mC=this.mk1 * this.mk2;
this.mw1=Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mw2=Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mmode1=1.0 - this.mm2 * this.mw1 * this.mw1  / this.mk2;
this.mmode2=1.0 - this.mm2 * this.mw2 * this.mw2  / this.mk2;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mm2=var3;
this.mA=this.mm1 * this.mm2;
this.mB=-(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
this.mC=this.mk1 * this.mk2;
this.mw1=Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mw2=Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mmode1=1.0 - this.mm2 * this.mw1 * this.mw1  / this.mk2;
this.mmode2=1.0 - this.mm2 * this.mw2 * this.mw2  / this.mk2;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mk2=var3;
this.mA=this.mm1 * this.mm2;
this.mB=-(this.mk1 * this.mm2 + this.mk2 * this.mm2 + this.mk2 * this.mm2);
this.mC=this.mk1 * this.mk2;
this.mw1=Math.sqrt((-this.mB - Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mw2=Math.sqrt((-this.mB + Math.sqrt(this.mB * this.mB - 4.0 * this.mA * this.mC )) / (2.0 * this.mA));
this.mmode1=1.0 - this.mm2 * this.mw1 * this.mw1  / this.mk2;
this.mmode2=1.0 - this.mm2 * this.mw2 * this.mw2  / this.mk2;
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

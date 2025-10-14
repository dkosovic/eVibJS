(function(){var P$=Clazz.newPackage("OneDOF.Prog11.AbutmentSin"),I$=[[0,'java.awt.Rectangle','OneDOF.Prog11.AbutmentSin.CFrameHelp','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog11.AbutmentSin.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn=0.7;
this.mXi=0.05;
this.mXo=0.0;
this.mVo=0.0;
this.mXin=7.0;
this.mWin=1.0;
},1);

C$.$fields$=[['Z',['mFirstTime','mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mWn','mXi','mXo','mVo','mXin','mWin','mWinrads','mT'],'I',['mState'],'O',['mDisplacement','double[]','+mX','+mY','+mF','+mInput','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics','mTraceThumbnailImage','java.awt.Image','mTraceThumbnailGC','java.awt.Graphics','mTraceClip','java.awt.Rectangle','+mTraceThumbnail','+mThumbRect','mSpringHelp','OneDOF.Prog11.AbutmentSin.CFrameHelp','+mDamperHelp','+mMassHelp']]
,['D',['dt','yscale']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mFirstTime=true;
this.mTraceClip=Clazz.new_($I$(1,1).c$$I$I$I$I,[80, 190, 400, 120]);
this.mTraceThumbnail=Clazz.new_([this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20 , this.mTraceClip.width, (this.mTraceClip.height/8|0)],$I$(1,1).c$$I$I$I$I);
Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, "This is a control for the plot above.\nTry dragging the cursor."]);
Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height, "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."]);
Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 500, 39, 70, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth."]);
this.mSpringHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless spring."]);
this.mDamperHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless viscous damper."]);
this.mMassHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog11_AbutmentSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass."]);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
var var2=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (this.mTraceGC == null ) {
this.mTraceImage=this.mFramePanel.createImage$I$I(3280, 120);
this.mTraceGC=this.mTraceImage.getGraphics$();
this.DrawTraceGrid$();
this.DrawForceGraph$();
}if (this.mTraceThumbnailGC == null ) {
this.mTraceThumbnailImage=this.mFramePanel.createImage$I$I(this.mTraceClip.width, (this.mTraceClip.height/8|0));
this.mTraceThumbnailGC=this.mTraceThumbnailImage.getGraphics$();
}if (this.mFirstTime) {
this.mFirstTime=false;
this.mTime=0.0;
this.mViewTime=0.0;
}var var4=0;
var var3;
if (this.mDisplacement == null ) {
var3=((C$.yscale * this.mXo)|0);
} else {
var var5=((1.0 + this.mTime / 2.0 / C$.dt )|0);
var3=((C$.yscale * this.mDisplacement[var5])|0);
var4=((C$.yscale * this.mInput[var5])|0);
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(3).lightGray);
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(3).orange);
g.fillRect$I$I$I$I(500, 39 + var4, 70, 20);
g.setColor$java_awt_Color($I$(3).black);
var var6=(230 + var3 - var4 - 39 - 20) / 10.0;
g.drawLine$I$I$I$I(517, 59 + var4, 529, ((59 + var4 + var6 / 2.0 )|0));
for (var var13=1; var13 < 10; var13++) {
if (var13 % 2 == 0) {
g.drawLine$I$I$I$I(505, ((59 + var4 + (2 * var13 - 1) * var6 / 2.0 )|0), 529, ((59 + var4 + (2 * var13 + 1) * var6 / 2.0 )|0));
} else {
g.drawLine$I$I$I$I(529, ((59 + var4 + (2 * var13 - 1) * var6 / 2.0 )|0), 505, ((59 + var4 + (2 * var13 + 1) * var6 / 2.0 )|0));
}}
g.drawLine$I$I$I$I(505, ((59 + var4 + 19.0 * var6 / 2.0 )|0), 517, 230 + var3);
this.mSpringHelp.x=505;
this.mSpringHelp.y=59 + var4;
this.mSpringHelp.width=24;
this.mSpringHelp.height=230 + var3 - var4 - 39 - 20 - 1;
this.mSpringHelp.DefaultArrowPos$();
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(545, 59 + var4, 545, 59 + var4 + 113 );
g.drawLine$I$I$I$I(559, 59 + var4, 559, 59 + var4 + 113 );
g.drawLine$I$I$I$I(545, 59 + var4 + 113 , 559, 59 + var4 + 113 );
g.drawLine$I$I$I$I(552, 230 + var3 - 114, 552, 230 + var3);
g.drawLine$I$I$I$I(547, 230 + var3 - 114, 557, 230 + var3 - 114);
this.mDamperHelp.x=545;
this.mDamperHelp.y=59 + var4;
this.mDamperHelp.width=14;
this.mDamperHelp.height=230 + var3 - 39 - 20 - 1;
this.mDamperHelp.DefaultArrowPos$();
g.setColor$java_awt_Color(var2);
g.fillRect$I$I$I$I(500, 230 + var3, 70, 40);
g.drawLine$I$I$I$I(500, 230 + var3 + 20 , 480, 230 + var3 + 20 );
this.mMassHelp.x=500;
this.mMassHelp.y=230 + var3;
this.mMassHelp.width=70;
this.mMassHelp.height=40;
this.mMassHelp.DefaultArrowPos$();
g.setColor$java_awt_Color($I$(3).black);
g.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, this.mFramePanel);
var var8=this.mViewTime / C$.dt / 3200.0 ;
this.mThumbRect=Clazz.new_([this.mTraceThumbnail.x + ((var8 * this.mTraceThumbnail.width)|0), this.mTraceThumbnail.y - 3, (this.mTraceThumbnail.width * this.mTraceThumbnail.width/3200|0), this.mTraceThumbnail.height + 6],$I$(1,1).c$$I$I$I$I);
var8=this.mTime / C$.dt / 3200.0 ;
var var10=((var8 * this.mTraceThumbnail.width)|0);
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(this.mTraceThumbnail.x + var10 + this.mThumbRect.width , this.mTraceThumbnail.y, this.mTraceThumbnail.width - var10 - this.mThumbRect.width , this.mTraceThumbnail.height);
g.setColor$java_awt_Color($I$(3).orange);
var var11=((this.mTraceThumbnail.x + (400.0 + 2.0 / C$.dt) / 8.0)|0);
g.drawLine$I$I$I$I(this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), var11, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0));
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var var14=0; var14 < 1600 - var11 - 144 ; var14++) {
g.drawLine$I$I$I$I((var14 * 2/8|0) + var11, ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0) + C$.yscale * this.mXin * Math.sin(this.mWinrads * 2.0 * var14 * C$.dt )  / 8.0)|0), var11 + (2 * (var14 + 1)/8|0), ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0) + C$.yscale * this.mXin * Math.sin(this.mWinrads * 2.0 * (var14 + 1) * C$.dt )  / 8.0)|0));
}
g.setColor$java_awt_Color($I$(3).black);
g.drawRect$I$I$I$I(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 1);
g.drawRect$I$I$I$I(this.mThumbRect.x - 1, this.mThumbRect.y + 1, this.mThumbRect.width, this.mThumbRect.height - 3);
g.drawRect$I$I$I$I(this.mThumbRect.x, this.mThumbRect.y + 2, this.mThumbRect.width - 2, this.mThumbRect.height - 4);
g.setPaintMode$();
var fudge=g.create$();
fudge.clipRect$I$I$I$I(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
fudge.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mTraceImage, -(((this.mViewTime / C$.dt)|0)), this.mTraceClip.y, this.mFramePanel);
fudge.dispose$();
g.drawRect$I$I$I$I(80, 190, 400, 120);
});

Clazz.newMeth(C$, 'Response$',  function () {
this.mDisplacement=Clazz.array(Double.TYPE, [1600]);
this.mX=Clazz.array(Double.TYPE, [1605]);
this.mY=Clazz.array(Double.TYPE, [1605]);
this.mF=Clazz.array(Double.TYPE, [1605]);
this.mInput=Clazz.array(Double.TYPE, [1605]);
this.mDisplacement[0]=this.mXo;
this.mX[0]=this.mDisplacement[0];
this.mY[0]=this.mVo;
var var2=this.mWn * 2.0 * 3.141592653589793 ;
var var4=var2 * var2;
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
var var6=2.0 * C$.dt;
this.mT=0.0;
for (var var1=0; var1 < 1599; var1++) {
this.mInput[var1]=this.mXin * Math.sin(this.mWinrads * (this.mT - 2.0));
if (this.mT < 2.0 ) {
this.mInput[var1]=0.0;
}this.mT+=var6;
}
this.mT=0.0;
this.mY[0]=0.0;
for (var var8=0; var8 < 1599; var8++) {
this.mF[var8]=-var4 * (this.mX[var8] - this.mInput[var8]) - 2.0 * var2 * this.mXi * (this.mY[var8] - (this.mInput[var8 + 1] - this.mInput[var8]) / var6) ;
this.mX[var8 + 1]=this.mX[var8] + this.mY[var8] * var6 / 2.0;
this.mY[var8 + 1]=this.mY[var8] + this.mF[var8] * var6 / 2.0;
this.mF[var8 + 1]=-var4 * (this.mX[var8 + 1] - this.mInput[var8 + 1]) - 2.0 * var2 * this.mXi * (this.mY[var8 + 1] - (this.mInput[var8 + 2] - this.mInput[var8 + 1]) / var6) ;
this.mX[var8 + 2]=this.mX[var8] + this.mY[var8 + 1] * var6 / 2.0;
this.mY[var8 + 2]=this.mY[var8] + this.mF[var8 + 1] * var6 / 2.0;
this.mF[var8 + 2]=-var4 * (this.mX[var8 + 2] - this.mInput[var8 + 2]) - 2.0 * var2 * this.mXi * (this.mY[var8 + 2] - (this.mInput[var8 + 3] - this.mInput[var8 + 2]) / var6) ;
this.mX[var8 + 3]=this.mX[var8] + this.mY[var8 + 2] * var6;
this.mY[var8 + 3]=this.mY[var8] + this.mF[var8 + 2] * var6;
this.mF[var8 + 3]=-var4 * (this.mX[var8 + 3] - this.mInput[var8 + 3]) - 2.0 * var2 * this.mXi * (this.mY[var8 + 3] - (this.mInput[var8 + 4] - this.mInput[var8 + 3]) / var6) ;
this.mX[var8 + 1]=this.mX[var8] + (this.mY[var8] + 2.0 * this.mY[var8 + 1] + 2.0 * this.mY[var8 + 2] + this.mY[var8 + 3]) * var6 / 6.0;
this.mY[var8 + 1]=this.mY[var8] + (this.mF[var8] + 2.0 * this.mF[var8 + 1] + 2.0 * this.mF[var8 + 2] + this.mF[var8 + 3]) * var6 / 6.0;
this.mDisplacement[var8 + 1]=this.mX[var8 + 1];
if (this.mDisplacement[var8 + 1] > 16.2 ) {
this.mDisplacement[var8 + 1]=16.2;
this.mX[var8 + 1]=16.2;
this.mY[var8 + 1]=-0.7 * this.mY[var8 + 1];
}if (this.mDisplacement[var8 + 1] < -16.5 ) {
this.mDisplacement[var8 + 1]=-16.5;
this.mX[var8 + 1]=-16.5;
this.mY[var8 + 1]=-0.7 * this.mY[var8 + 1];
}this.mT+=var6;
}
});

Clazz.newMeth(C$, 'DrawTraceGrid$',  function () {
this.mTraceGC.setPaintMode$();
this.mTraceGC.setColor$java_awt_Color($I$(3).white);
this.mTraceGC.fillRect$I$I$I$I(0, 0, 3280, 120);
this.mTraceGC.setColor$java_awt_Color($I$(3).black);
for (var var1=0; var1 < 3280; var1+=50) {
this.mTraceGC.drawLine$I$I$I$I(var1, 0, var1, 120);
}
this.mTraceGC.drawLine$I$I$I$I(0, 60, 3280, 60);
});

Clazz.newMeth(C$, 'DrawForceGraph$',  function () {
this.mTraceGC.setColor$java_awt_Color($I$(3).orange);
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var var1=((1.0 / C$.dt)|0); var1 < 1598; var1++) {
this.mTraceGC.drawLine$I$I$I$I(var1 * 2 + 400 + 80, 60 + ((C$.yscale * this.mXin * Math.sin(this.mWinrads * (2 * var1 * C$.dt  - 2.0)) )|0), (var1 + 1) * 2 + 400 + 80, 60 + ((C$.yscale * this.mXin * Math.sin(this.mWinrads * (2 * (var1 + 1) * C$.dt  - 2.0)) )|0));
}
});

Clazz.newMeth(C$, 'ThumbnailSketch$',  function () {
this.mTraceThumbnailGC.setPaintMode$();
this.mTraceThumbnailGC.setColor$java_awt_Color($I$(3).white);
this.mTraceThumbnailGC.fillRect$I$I$I$I(0, 0, this.mTraceClip.width, (this.mTraceClip.height/8|0));
var var2=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceThumbnailGC.setColor$java_awt_Color(var2);
for (var var1=0; var1 < 1598; var1++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((var1 * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 2.0 |0) + this.mDisplacement[var1] * C$.yscale / 8.0)|0), (((var1 + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 2.0 |0) + this.mDisplacement[var1 + 1] * C$.yscale / 8.0)|0));
}
});

Clazz.newMeth(C$, 'DrawTraceShape$',  function () {
this.DrawTraceGrid$();
var var2=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceGC.setColor$java_awt_Color(var2);
for (var var1=0; var1 < 1598; var1++) {
this.mTraceGC.drawLine$I$I$I$I(var1 * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[var1])|0), (var1 + 1) * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[var1 + 1])|0));
}
this.DrawForceGraph$();
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog11_AbutmentSin_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 0:
if (this.mState == 1) {
this.mTime+=var3;
this.mViewTime=this.mTime;
}this.LimitTimeValue$();
var5=true;
break;
case 1:
this.ChangeRunState$I((var3|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mWn=var3;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mXi=var3;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mXin=var3;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mWin=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (var1) {
switch (this.mState) {
case 0:
if (var1 == 1) {
this.Response$();
this.DrawTraceShape$();
this.ThumbnailSketch$();
this.mTime=0.0;
this.mViewTime=0.0;
this.mFirstTime=true;
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

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
var var3=this.mTraceClip.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
var var4=this.mTraceThumbnail.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
var var5=this.mThumbRect.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
this.mWasHit=var3 || var4 ;
var var6=0;
switch (var1) {
case 0:
this.mDragMain=false;
this.mDragThumb=false;
this.mDragThumbnail=false;
if (!this.mWasHit) {
return false;
} else {
if (var2) {
return false;
}if (var3) {
this.mDragMain=true;
} else if (var5) {
this.mDragThumb=true;
} else if (var4) {
this.mDragThumbnail=true;
}if (this.mDragThumbnail) {
var6=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mThumbRect.x);
this.UserDrag$I(var6);
}return true;
}case 1:
if (!this.mWasHit) {
return false;
}if (this.mDragMain) {
var6=this.mFramePanel.mThisPt.x - this.mFramePanel.mLastPt.x;
} else if (this.mDragThumb) {
var6=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mFramePanel.mLastPt.x);
} else if (this.mDragThumbnail) {
var6=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mThumbRect.x);
}this.UserDrag$I(var6);
return true;
case 2:
this.mDragMain=false;
this.mDragThumb=false;
this.mDragThumbnail=false;
return true;
default:
return false;
}
});

Clazz.newMeth(C$, 'UserDrag$I',  function (var1) {
if (this.mState == 1) {
this.ChangeRunState$I(2);
}this.mViewTime=this.mViewTime - var1 * C$.dt;
this.LimitTimeValue$();
this.repaint$();
});

Clazz.newMeth(C$, 'LimitTimeValue$',  function () {
var var1=2800.0 * C$.dt;
if (this.mTime < 0.0 ) {
this.mTime=0.0;
} else if (this.mTime > var1 ) {
this.mTime=var1;
}if (this.mViewTime < 0.0 ) {
this.mViewTime=0.0;
} else if (this.mViewTime > this.mTime ) {
this.mViewTime=this.mTime;
}});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
C$.yscale=3.4;
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

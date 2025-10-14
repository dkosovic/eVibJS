(function(){var P$=Clazz.newPackage("OneDOF.Prog5.ForcedSin"),I$=[[0,'java.awt.Rectangle','OneDOF.Prog5.ForcedSin.CFrameHelp','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Prog5.ForcedSin.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn=0.7;
this.mXi=0.05;
this.mXo=0.0;
this.mVo=0.0;
this.mFdivmWn2=7.0;
this.mWin=1.0;
},1);

C$.$fields$=[['Z',['mFirstTime','mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mWn','mXi','mXo','mVo','mFdivmWn2','mWin','mWinrads','mT'],'I',['mState'],'O',['mDisplacement','double[]','+mX','+mY','+mF','+mFin','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics','mTraceThumbnailImage','java.awt.Image','mTraceThumbnailGC','java.awt.Graphics','mTraceClip','java.awt.Rectangle','+mTraceThumbnail','+mThumbRect','mSpringHelp','OneDOF.Prog5.ForcedSin.CFrameHelp','+mDamperHelp','+mMassHelp']]
,['D',['dt','yscale']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mFirstTime=true;
this.mTraceClip=Clazz.new_($I$(1,1).c$$I$I$I$I,[80, 160, 400, 120]);
this.mTraceThumbnail=Clazz.new_([this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20 , this.mTraceClip.width, (this.mTraceClip.height/8|0)],$I$(1,1).c$$I$I$I$I);
Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, "This is a control for the plot above.\nTry dragging the cursor."]);
Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height, "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."]);
Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 500, 9, 70, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth."]);
this.mSpringHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless spring."]);
this.mDamperHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless viscous damper."]);
this.mMassHelp=Clazz.new_($I$(2,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass."]);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
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
}var y;
if (this.mDisplacement == null ) {
y=((C$.yscale * this.mXo)|0);
} else {
var pcurrent=((1.0 + this.mTime / 2.0 / C$.dt )|0);
y=((C$.yscale * this.mDisplacement[pcurrent])|0);
}var Farrow=((this.mFdivmWn2 * 3.5 * Math.sin(this.mWin * 2.0 * 3.141592653589793 * (this.mTime - 2.0) ) )|0);
if (this.mTime < 2.0 ) {
Farrow=0;
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var force=Clazz.new_($I$(3,1).c$$F$F$F,[0.77, 0.38, 0.0]);
g.setColor$java_awt_Color($I$(3).orange);
g.fillRect$I$I$I$I(500, 9, 70, 20);
g.setColor$java_awt_Color($I$(3).black);
var coil=(200 + y - 9 - 20) / 10.0;
g.drawLine$I$I$I$I(517, 29, 529, ((29.0 + coil / 2.0)|0));
for (var p=1; p < 10; p++) {
if (p % 2 == 0) {
g.drawLine$I$I$I$I(505, ((29.0 + (2 * p - 1) * coil / 2.0)|0), 529, ((29.0 + (2 * p + 1) * coil / 2.0)|0));
} else {
g.drawLine$I$I$I$I(529, ((29.0 + (2 * p - 1) * coil / 2.0)|0), 505, ((29.0 + (2 * p + 1) * coil / 2.0)|0));
}}
g.drawLine$I$I$I$I(505, ((29.0 + 19.0 * coil / 2.0)|0), 517, 200 + y);
this.mSpringHelp.x=505;
this.mSpringHelp.y=29;
this.mSpringHelp.width=24;
this.mSpringHelp.height=200 + y - 9 - 20 - 1;
this.mSpringHelp.DefaultArrowPos$();
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(545, 29, 545, 142);
g.drawLine$I$I$I$I(559, 29, 559, 142);
g.drawLine$I$I$I$I(545, 142, 559, 142);
g.drawLine$I$I$I$I(552, 200 + y - 114, 552, 200 + y);
g.drawLine$I$I$I$I(547, 200 + y - 114, 557, 200 + y - 114);
this.mDamperHelp.x=545;
this.mDamperHelp.y=29;
this.mDamperHelp.width=14;
this.mDamperHelp.height=200 + y - 9 - 20 - 1;
this.mDamperHelp.DefaultArrowPos$();
g.setColor$java_awt_Color(mass);
g.fillRect$I$I$I$I(500, 200 + y, 70, 40);
g.drawLine$I$I$I$I(500, 200 + y + 20 , 480, 200 + y + 20 );
g.setColor$java_awt_Color(force);
g.drawLine$I$I$I$I(570, 200 + y + 20 , 590, 200 + y + 20 );
if (Farrow != 0) {
if (Farrow > 0) {
g.drawLine$I$I$I$I(579, 200 + y + 20 , 579, 200 + y + 20 + Farrow  - 1);
g.drawLine$I$I$I$I(580, 200 + y + 20 , 580, 200 + y + 20 + Farrow );
g.drawLine$I$I$I$I(581, 200 + y + 20 , 581, 200 + y + 20 + Farrow  - 1);
}if (Farrow < 0) {
g.drawLine$I$I$I$I(579, 200 + y + 20 , 579, 200 + y + 20 + Farrow + 1 );
g.drawLine$I$I$I$I(580, 200 + y + 20 , 580, 200 + y + 20 + Farrow );
g.drawLine$I$I$I$I(581, 200 + y + 20 , 581, 200 + y + 20 + Farrow + 1 );
}}this.mMassHelp.x=500;
this.mMassHelp.y=200 + y;
this.mMassHelp.width=70;
this.mMassHelp.height=40;
this.mMassHelp.DefaultArrowPos$();
g.setColor$java_awt_Color($I$(3).black);
g.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, this.mFramePanel);
var fraction=this.mViewTime / C$.dt / 3200.0 ;
this.mThumbRect=Clazz.new_([this.mTraceThumbnail.x + ((fraction * this.mTraceThumbnail.width)|0), this.mTraceThumbnail.y - 3, (this.mTraceThumbnail.width * this.mTraceThumbnail.width/3200|0), this.mTraceThumbnail.height + 6],$I$(1,1).c$$I$I$I$I);
fraction=this.mTime / C$.dt / 3200.0 ;
var intTime=((fraction * this.mTraceThumbnail.width)|0);
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(this.mTraceThumbnail.x + intTime + this.mThumbRect.width , this.mTraceThumbnail.y, this.mTraceThumbnail.width - intTime - this.mThumbRect.width , this.mTraceThumbnail.height);
g.setColor$java_awt_Color(force);
var sub1=((this.mTraceThumbnail.x + (400.0 + 2.0 / C$.dt) / 8.0)|0);
g.drawLine$I$I$I$I(this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), sub1, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0));
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var var15=0; var15 < 1600 - sub1 - 144 ; var15++) {
g.drawLine$I$I$I$I((var15 * 2/8|0) + sub1, ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0) + 3.5 * this.mFdivmWn2 * Math.sin(this.mWinrads * 2.0 * var15 * C$.dt )  / 8.0)|0), sub1 + (2 * (var15 + 1)/8|0), ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0) + 3.5 * this.mFdivmWn2 * Math.sin(this.mWinrads * 2.0 * (var15 + 1) * C$.dt )  / 8.0)|0));
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
g.drawRect$I$I$I$I(80, 160, 400, 120);
});

Clazz.newMeth(C$, 'Response$',  function () {
this.mDisplacement=Clazz.array(Double.TYPE, [1600]);
this.mX=Clazz.array(Double.TYPE, [1605]);
this.mY=Clazz.array(Double.TYPE, [1605]);
this.mF=Clazz.array(Double.TYPE, [1605]);
this.mFin=Clazz.array(Double.TYPE, [1605]);
this.mDisplacement[0]=this.mXo;
this.mX[0]=this.mDisplacement[0];
this.mY[0]=this.mVo;
var mW=this.mWn * 2.0 * 3.141592653589793 ;
var mW2=mW * mW;
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
var mdtx2=2.0 * C$.dt;
this.mT=0.0;
for (var p=0; p < 1599; p++) {
this.mFin[p]=this.mFdivmWn2 * mW2 * Math.sin(this.mWinrads * (this.mT - 2.0)) ;
if (this.mT < 2.0 ) {
this.mFin[p]=0.0;
}this.mT+=mdtx2;
}
this.mT=0.0;
for (var var8=0; var8 < 1599; var8++) {
this.mF[var8]=this.mFin[var8] - mW2 * this.mX[var8] - 2.0 * mW * this.mXi * this.mY[var8] ;
this.mX[var8 + 1]=this.mX[var8] + this.mY[var8] * mdtx2 / 2.0;
this.mY[var8 + 1]=this.mY[var8] + this.mF[var8] * mdtx2 / 2.0;
this.mF[var8 + 1]=this.mFin[var8 + 1] - mW2 * this.mX[var8 + 1] - 2.0 * mW * this.mXi * this.mY[var8 + 1] ;
this.mX[var8 + 2]=this.mX[var8] + this.mY[var8 + 1] * mdtx2 / 2.0;
this.mY[var8 + 2]=this.mY[var8] + this.mF[var8 + 1] * mdtx2 / 2.0;
this.mF[var8 + 2]=this.mFin[var8 + 2] - mW2 * this.mX[var8 + 2] - 2.0 * mW * this.mXi * this.mY[var8 + 2] ;
this.mX[var8 + 3]=this.mX[var8] + this.mY[var8 + 2] * mdtx2;
this.mY[var8 + 3]=this.mY[var8] + this.mF[var8 + 2] * mdtx2;
this.mF[var8 + 3]=this.mFin[var8 + 3] - mW2 * this.mX[var8 + 3] - 2.0 * mW * this.mXi * this.mY[var8 + 3] ;
this.mX[var8 + 1]=this.mX[var8] + (this.mY[var8] + 2.0 * this.mY[var8 + 1] + 2.0 * this.mY[var8 + 2] + this.mY[var8 + 3]) * mdtx2 / 6.0;
this.mY[var8 + 1]=this.mY[var8] + (this.mF[var8] + 2.0 * this.mF[var8 + 1] + 2.0 * this.mF[var8 + 2] + this.mF[var8 + 3]) * mdtx2 / 6.0;
this.mDisplacement[var8 + 1]=this.mX[var8 + 1];
if (this.mDisplacement[var8 + 1] > 16.2 ) {
this.mDisplacement[var8 + 1]=16.2;
this.mX[var8 + 1]=16.2;
this.mY[var8 + 1]=-0.7 * this.mY[var8 + 1];
}if (this.mDisplacement[var8 + 1] < -16.5 ) {
this.mDisplacement[var8 + 1]=-16.5;
this.mX[var8 + 1]=-16.5;
this.mY[var8 + 1]=-0.7 * this.mY[var8 + 1];
}this.mT+=mdtx2;
}
});

Clazz.newMeth(C$, 'DrawTraceGrid$',  function () {
this.mTraceGC.setPaintMode$();
this.mTraceGC.setColor$java_awt_Color($I$(3).white);
this.mTraceGC.fillRect$I$I$I$I(0, 0, 3280, 120);
this.mTraceGC.setColor$java_awt_Color($I$(3).black);
for (var p=0; p < 3280; p+=50) {
this.mTraceGC.drawLine$I$I$I$I(p, 0, p, 120);
}
this.mTraceGC.drawLine$I$I$I$I(0, 60, 3280, 60);
});

Clazz.newMeth(C$, 'DrawForceGraph$',  function () {
var force=Clazz.new_($I$(3,1).c$$F$F$F,[0.77, 0.38, 0.0]);
this.mTraceGC.setColor$java_awt_Color(force);
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var p=((1.0 / C$.dt)|0); p < 1598; p++) {
this.mTraceGC.drawLine$I$I$I$I(p * 2 + 400 + 80, 60 + ((3.5 * this.mFdivmWn2 * Math.sin(this.mWinrads * (2 * p * C$.dt  - 2.0)) )|0), (p + 1) * 2 + 400 + 80, 60 + ((3.5 * this.mFdivmWn2 * Math.sin(this.mWinrads * (2 * (p + 1) * C$.dt  - 2.0)) )|0));
}
});

Clazz.newMeth(C$, 'ThumbnailSketch$',  function () {
this.mTraceThumbnailGC.setPaintMode$();
this.mTraceThumbnailGC.setColor$java_awt_Color($I$(3).white);
this.mTraceThumbnailGC.fillRect$I$I$I$I(0, 0, this.mTraceClip.width, (this.mTraceClip.height/8|0));
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceThumbnailGC.setColor$java_awt_Color(mass);
for (var p=0; p < 1598; p++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((p * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 2.0 |0) + this.mDisplacement[p] * C$.yscale / 8.0)|0), (((p + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 2.0 |0) + this.mDisplacement[p + 1] * C$.yscale / 8.0)|0));
}
});

Clazz.newMeth(C$, 'DrawTraceShape$',  function () {
this.DrawTraceGrid$();
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceGC.setColor$java_awt_Color(mass);
for (var p=0; p < 1598; p++) {
this.mTraceGC.drawLine$I$I$I$I(p * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[p])|0), (p + 1) * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[p + 1])|0));
}
this.DrawForceGraph$();
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Prog5_ForcedSin_CFrame$I$D',  function (controller, code, val) {
var mustgrayraw=false;
switch (code) {
case 0:
if (this.mState == 1) {
this.mTime+=val;
this.mViewTime=this.mTime;
}this.LimitTimeValue$();
mustgrayraw=true;
break;
case 1:
this.ChangeRunState$I((val|0));
break;
case 2:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mWn=val;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mXi=val;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mFdivmWn2=val;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mWin=val;
}
if (mustgrayraw) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (newState) {
switch (this.mState) {
case 0:
if (newState == 1) {
this.Response$();
this.DrawTraceShape$();
this.ThumbnailSketch$();
this.mTime=0.0;
this.mViewTime=0.0;
this.mFirstTime=true;
this.mState=1;
}break;
case 1:
if (newState == 2 || newState == 0 ) {
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

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevHit) {
var hitMain=this.mTraceClip.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
var hitThumbnail=this.mTraceThumbnail.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
var hitThumb=this.mThumbRect.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
this.mWasHit=hitMain || hitThumbnail ;
var offset=0;
switch (code) {
case 0:
this.mDragMain=false;
this.mDragThumb=false;
this.mDragThumbnail=false;
if (!this.mWasHit) {
return false;
} else {
if (prevHit) {
return false;
}if (hitMain) {
this.mDragMain=true;
} else if (hitThumb) {
this.mDragThumb=true;
} else if (hitThumbnail) {
this.mDragThumbnail=true;
}if (this.mDragThumbnail) {
offset=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mThumbRect.x);
this.UserDrag$I(offset);
}return true;
}case 1:
if (!this.mWasHit) {
return false;
}if (this.mDragMain) {
offset=this.mFramePanel.mThisPt.x - this.mFramePanel.mLastPt.x;
} else if (this.mDragThumb) {
offset=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mFramePanel.mLastPt.x);
} else if (this.mDragThumbnail) {
offset=-(((3200.0 / this.mTraceClip.width)|0)) * (this.mFramePanel.mThisPt.x - this.mThumbRect.x);
}this.UserDrag$I(offset);
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

Clazz.newMeth(C$, 'UserDrag$I',  function (offset) {
if (this.mState == 1) {
this.ChangeRunState$I(2);
}this.mViewTime=this.mViewTime - offset * C$.dt;
this.LimitTimeValue$();
this.repaint$();
});

Clazz.newMeth(C$, 'LimitTimeValue$',  function () {
var maxTime=2800.0 * C$.dt;
if (this.mTime < 0.0 ) {
this.mTime=0.0;
} else if (this.mTime > maxTime ) {
this.mTime=maxTime;
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

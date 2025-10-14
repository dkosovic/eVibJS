(function(){var P$=Clazz.newPackage("OneDOF.Abutment.Abutment"),I$=[[0,'java.awt.Rectangle','OneDOF.Abutment.Abutment.CFrameHelp','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'OneDOF.Abutment.Abutment.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mWn=1.5;
this.mXi=0.05;
this.mXo=0.0;
this.mVo=0.0;
this.mXin=7.0;
this.mPulsewidth=2.0;
},1);

C$.$fields$=[['Z',['mFirstTime','mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mWn','mXi','mXo','mVo','mXin','mPulsewidth','mT'],'I',['mState'],'O',['mDisplacement','double[]','+mX','+mY','+mF','+mInput','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics','mTraceThumbnailImage','java.awt.Image','mTraceThumbnailGC','java.awt.Graphics','mTraceClip','java.awt.Rectangle','+mTraceThumbnail','+mThumbRect','mSpringHelp','OneDOF.Abutment.Abutment.CFrameHelp','+mDamperHelp','+mMassHelp']]
,['D',['dt','yscale']]]

Clazz.newMeth(C$, 'c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mFirstTime=true;
this.mTraceClip=Clazz.new_($I$(1,1).c$$I$I$I$I,[80, 160, 400, 120]);
this.mTraceThumbnail=Clazz.new_([this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20 , this.mTraceClip.width, (this.mTraceClip.height/8|0)],$I$(1,1).c$$I$I$I$I);
Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, "This is a control for the plot above.\nTry dragging the cursor."]);
Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height, "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."]);
Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, 500, 9, 70, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth."]);
this.mSpringHelp=Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless spring."]);
this.mDamperHelp=Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a massless viscous damper."]);
this.mMassHelp=Clazz.new_($I$(2,1).c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 0, 0, "This represents a rigid mass."]);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (this.mTraceGC == null ) {
this.mTraceImage=this.mFramePanel.createImage$I$I(3280, 120);
this.mTraceGC=this.mTraceImage.getGraphics$();
this.DrawTraceGrid$();
this.DrawInputGraph$();
}if (this.mTraceThumbnailGC == null ) {
this.mTraceThumbnailImage=this.mFramePanel.createImage$I$I(this.mTraceClip.width, (this.mTraceClip.height/8|0));
this.mTraceThumbnailGC=this.mTraceThumbnailImage.getGraphics$();
}if (this.mFirstTime) {
this.mFirstTime=false;
this.mTime=0.0;
this.mViewTime=0.0;
}var yinput=0;
var y;
if (this.mDisplacement == null ) {
y=((C$.yscale * this.mXo)|0);
} else {
var pcurrent=((1.0 + this.mTime / 2.0 / C$.dt )|0);
y=((C$.yscale * this.mDisplacement[pcurrent])|0);
yinput=((C$.yscale * this.mInput[pcurrent])|0);
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(3).orange);
g.fillRect$I$I$I$I(500, 9 + yinput, 70, 20);
g.setColor$java_awt_Color($I$(3).black);
var coil=(200 + y - yinput - 9 - 20) / 10.0;
g.drawLine$I$I$I$I(517, 29 + yinput, 529, ((29 + yinput + coil / 2.0 )|0));
for (var p=1; p < 10; p++) {
if (p % 2 == 0) {
g.drawLine$I$I$I$I(505, ((29 + yinput + (2 * p - 1) * coil / 2.0 )|0), 529, ((29 + yinput + (2 * p + 1) * coil / 2.0 )|0));
} else {
g.drawLine$I$I$I$I(529, ((29 + yinput + (2 * p - 1) * coil / 2.0 )|0), 505, ((29 + yinput + (2 * p + 1) * coil / 2.0 )|0));
}}
g.drawLine$I$I$I$I(505, ((29 + yinput + 19.0 * coil / 2.0 )|0), 517, 200 + y);
this.mSpringHelp.x=505;
this.mSpringHelp.y=29 + yinput;
this.mSpringHelp.width=24;
this.mSpringHelp.height=200 + y - yinput - 9 - 20 - 1;
this.mSpringHelp.DefaultArrowPos$();
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(545, 29 + yinput, 545, 29 + yinput + 113 );
g.drawLine$I$I$I$I(559, 29 + yinput, 559, 29 + yinput + 113 );
g.drawLine$I$I$I$I(545, 29 + yinput + 113 , 559, 29 + yinput + 113 );
g.drawLine$I$I$I$I(552, 200 + y - 114, 552, 200 + y);
g.drawLine$I$I$I$I(547, 200 + y - 114, 557, 200 + y - 114);
this.mDamperHelp.x=545;
this.mDamperHelp.y=29 + yinput;
this.mDamperHelp.width=14;
this.mDamperHelp.height=200 + y - 9 - 20 - 1;
this.mDamperHelp.DefaultArrowPos$();
g.setColor$java_awt_Color(mass);
g.fillRect$I$I$I$I(500, 200 + y, 70, 40);
g.drawLine$I$I$I$I(500, 200 + y + 20 , 480, 200 + y + 20 );
this.mMassHelp.x=500;
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
g.setColor$java_awt_Color($I$(3).orange);
g.drawLine$I$I$I$I(this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), ((this.mTraceThumbnail.x + (400.0 + 1.0 / C$.dt) / 8.0)|0), this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0));
g.drawLine$I$I$I$I(((this.mTraceThumbnail.x + (400.0 + 1.0 / C$.dt) / 8.0)|0), this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), ((this.mTraceThumbnail.x + (400.0 + 1.0 / C$.dt) / 8.0)|0), ((this.mTraceThumbnail.y + ((this.mTraceClip.height/2|0) + this.mXin * C$.yscale) / 8.0)|0));
g.drawLine$I$I$I$I(((this.mTraceThumbnail.x + (400.0 + 1.0 / C$.dt) / 8.0)|0), ((this.mTraceThumbnail.y + ((this.mTraceClip.height/2|0) + this.mXin * C$.yscale) / 8.0)|0), ((this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / C$.dt) / 8.0)|0), ((this.mTraceThumbnail.y + ((this.mTraceClip.height/2|0) + this.mXin * C$.yscale) / 8.0)|0));
g.drawLine$I$I$I$I(((this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / C$.dt) / 8.0)|0), this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), ((this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / C$.dt) / 8.0)|0), ((this.mTraceThumbnail.y + ((this.mTraceClip.height/2|0) + this.mXin * C$.yscale) / 8.0)|0));
g.drawLine$I$I$I$I(((this.mTraceThumbnail.x + (400.0 + (1.0 + this.mPulsewidth) / C$.dt) / 8.0)|0), this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0), ((this.mTraceThumbnail.x + (400.0 + (2.0 + this.mPulsewidth) / C$.dt) / 8.0)|0), this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 2 |0));
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
this.mInput=Clazz.array(Double.TYPE, [1605]);
this.mDisplacement[0]=this.mXo;
this.mX[0]=this.mDisplacement[0];
this.mY[0]=this.mVo;
var mW=this.mWn * 2.0 * 3.141592653589793 ;
var mW2=mW * mW;
var mdtx2=2.0 * C$.dt;
this.mT=0.0;
for (var p=0; p < 1599; p++) {
this.mInput[p]=this.mXin;
if (this.mT < 1.0 ) {
this.mInput[p]=0.0;
}if (this.mT > 1.0 + this.mPulsewidth ) {
this.mInput[p]=0.0;
}this.mT+=mdtx2;
}
this.mT=0.0;
this.mY[0]=0.0;
for (var var8=0; var8 < 1599; var8++) {
this.mF[var8]=-mW2 * (this.mX[var8] - this.mInput[var8]) - 2.0 * mW * this.mXi * (this.mY[var8] - (this.mInput[var8 + 1] - this.mInput[var8]) / mdtx2) ;
this.mX[var8 + 1]=this.mX[var8] + this.mY[var8] * mdtx2 / 2.0;
this.mY[var8 + 1]=this.mY[var8] + this.mF[var8] * mdtx2 / 2.0;
this.mF[var8 + 1]=-mW2 * (this.mX[var8 + 1] - this.mInput[var8 + 1]) - 2.0 * mW * this.mXi * (this.mY[var8 + 1] - (this.mInput[var8 + 2] - this.mInput[var8 + 1]) / mdtx2) ;
this.mX[var8 + 2]=this.mX[var8] + this.mY[var8 + 1] * mdtx2 / 2.0;
this.mY[var8 + 2]=this.mY[var8] + this.mF[var8 + 1] * mdtx2 / 2.0;
this.mF[var8 + 2]=-mW2 * (this.mX[var8 + 2] - this.mInput[var8 + 2]) - 2.0 * mW * this.mXi * (this.mY[var8 + 2] - (this.mInput[var8 + 3] - this.mInput[var8 + 2]) / mdtx2) ;
this.mX[var8 + 3]=this.mX[var8] + this.mY[var8 + 2] * mdtx2;
this.mY[var8 + 3]=this.mY[var8] + this.mF[var8 + 2] * mdtx2;
this.mF[var8 + 3]=-mW2 * (this.mX[var8 + 3] - this.mInput[var8 + 3]) - 2.0 * mW * this.mXi * (this.mY[var8 + 3] - (this.mInput[var8 + 4] - this.mInput[var8 + 3]) / mdtx2) ;
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

Clazz.newMeth(C$, 'DrawInputGraph$',  function () {
this.mTraceGC.setColor$java_awt_Color($I$(3).orange);
this.mTraceGC.drawLine$I$I$I$I(480, 60, 480 + ((1.0 / C$.dt)|0), 60);
this.mTraceGC.drawLine$I$I$I$I(480 + ((1.0 / C$.dt)|0), 60, 480 + ((1.0 / C$.dt)|0), 60 + ((this.mXin * C$.yscale)|0));
this.mTraceGC.drawLine$I$I$I$I(480 + ((1.0 / C$.dt)|0), 60 + ((this.mXin * C$.yscale)|0), 480 + (((1.0 + this.mPulsewidth) / C$.dt)|0), 60 + ((this.mXin * C$.yscale)|0));
this.mTraceGC.drawLine$I$I$I$I(480 + (((1.0 + this.mPulsewidth) / C$.dt)|0), 60 + ((this.mXin * C$.yscale)|0), 480 + (((1.0 + this.mPulsewidth) / C$.dt)|0), 60);
this.mTraceGC.drawLine$I$I$I$I(480 + (((1.0 + this.mPulsewidth) / C$.dt)|0), 60, 3280, 60);
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
this.DrawInputGraph$();
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceGC.setColor$java_awt_Color(mass);
for (var p=0; p < 1598; p++) {
this.mTraceGC.drawLine$I$I$I$I(p * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[p])|0), (p + 1) * 2 + 400 + 80, 60 + ((C$.yscale * this.mDisplacement[p + 1])|0));
}
});

Clazz.newMeth(C$, 'ControlMessage$OneDOF_Abutment_Abutment_CFrame$I$D',  function (controller, code, val) {
var mustRedraw=false;
switch (code) {
case 0:
if (this.mState == 1) {
this.mTime+=val;
this.mViewTime=this.mTime;
}this.LimitTimeValue$();
mustRedraw=true;
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
this.mXin=val;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement=null;
this.mPulsewidth=val;
}
if (mustRedraw) {
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

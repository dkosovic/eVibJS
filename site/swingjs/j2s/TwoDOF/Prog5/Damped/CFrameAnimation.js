(function(){var P$=Clazz.newPackage("TwoDOF.Prog5.Damped"),I$=[[0,'java.awt.Rectangle','TwoDOF.Prog5.Damped.CFrameHelp','java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog5.Damped.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm1=0.1;
this.mk1=20.0;
this.mc1=0.5;
this.mm2=0.1;
this.mk2=20.0;
this.mc2=0.01;
this.mX1o=3.3;
this.mX2o=3.3;
},1);

C$.$fields$=[['Z',['mFirstTime','mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mm1','mk1','mc1','mm2','mk2','mc2','mX1o','mX2o'],'I',['mState'],'O',['mDisplacement1','double[]','+mDisplacement2','+mX1','+mY1','+mF1','+mX2','+mY2','+mF2','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics','mTraceThumbnailImage','java.awt.Image','mTraceThumbnailGC','java.awt.Graphics','mTraceClip','java.awt.Rectangle','+mTraceThumbnail','+mThumbRect']]
,['D',['dt','yscale']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog5_Damped_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$TwoDOF_Prog5_Damped_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mFirstTime=true;
this.mTraceClip=Clazz.new_($I$(1,1).c$$I$I$I$I,[90, 60, 400, 200]);
this.mTraceThumbnail=Clazz.new_([this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20 , this.mTraceClip.width, (this.mTraceClip.height/8|0)],$I$(1,1).c$$I$I$I$I);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog5_Damped_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, "This is a control for the plot above.\nTry dragging the cursor."]);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog5_Damped_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height, "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."]);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog5_Damped_CFramePanel$I$I$I$I$S,[this.mFramePanel, 500, 19, 35, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth."]);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
if (this.mTraceGC == null ) {
this.mTraceImage=this.mFramePanel.createImage$I$I(3290, 200);
this.mTraceGC=this.mTraceImage.getGraphics$();
this.DrawTraceGrid$();
}if (this.mTraceThumbnailGC == null ) {
this.mTraceThumbnailImage=this.mFramePanel.createImage$I$I(this.mTraceClip.width, (this.mTraceClip.height/8|0));
this.mTraceThumbnailGC=this.mTraceThumbnailImage.getGraphics$();
}if (this.mFirstTime) {
this.mFirstTime=false;
this.mTime=0.0;
this.mViewTime=0.0;
}var y1;
var y2;
if (this.mDisplacement1 == null ) {
y1=((C$.yscale * this.mX1o)|0);
y2=((C$.yscale * this.mX2o)|0);
} else {
var pcurrent=((1.0 + this.mTime / 2.0 / C$.dt )|0);
y1=((C$.yscale * this.mDisplacement1[pcurrent])|0);
y2=((C$.yscale * this.mDisplacement2[pcurrent])|0);
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(3).orange);
g.fillRect$I$I$I$I(500, 19, 35, 20);
g.setColor$java_awt_Color($I$(3).black);
var coil=(110 + y1 - 19 - 20) / 10.0;
g.drawLine$I$I$I$I(508, 39, 514, ((39.0 + coil / 2.0)|0));
for (var p=1; p < 10; p++) {
if (p % 2 == 0) {
g.drawLine$I$I$I$I(502, ((39.0 + (2 * p - 1) * coil / 2.0)|0), 514, ((39.0 + (2 * p + 1) * coil / 2.0)|0));
} else {
g.drawLine$I$I$I$I(514, ((39.0 + (2 * p - 1) * coil / 2.0)|0), 502, ((39.0 + (2 * p + 1) * coil / 2.0)|0));
}}
g.drawLine$I$I$I$I(502, ((39.0 + 19.0 * coil / 2.0)|0), 508, 110 + y1);
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(522, 39, 522, 86);
g.drawLine$I$I$I$I(530, 39, 530, 86);
g.drawLine$I$I$I$I(522, 86, 530, 86);
g.drawLine$I$I$I$I(526, 110 + y1 - 48, 526, 110 + y1);
g.drawLine$I$I$I$I(523, 110 + y1 - 48, 529, 110 + y1 - 48);
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color(mass);
g.fillRect$I$I$I$I(500, 110 + y1, 35, 20);
g.drawLine$I$I$I$I(500, 110 + y1 + 10 , 480, 110 + y1 + 10 );
g.setColor$java_awt_Color($I$(3).black);
coil=(201 + y2 - 110 - 20 - y1) / 10.0;
g.drawLine$I$I$I$I(508, 130 + y1, 514, ((130 + y1 + coil / 2.0 )|0));
for (var var13=1; var13 < 10; var13++) {
if (var13 % 2 == 0) {
g.drawLine$I$I$I$I(502, ((130 + y1 + (2 * var13 - 1) * coil / 2.0 )|0), 514, ((130 + y1 + (2 * var13 + 1) * coil / 2.0 )|0));
} else {
g.drawLine$I$I$I$I(514, ((130 + y1 + (2 * var13 - 1) * coil / 2.0 )|0), 502, ((130 + y1 + (2 * var13 + 1) * coil / 2.0 )|0));
}}
g.drawLine$I$I$I$I(502, ((130 + y1 + 19.0 * coil / 2.0 )|0), 508, 201 + y2);
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(522, 130 + y1, 522, 130 + y1 + 47 );
g.drawLine$I$I$I$I(530, 130 + y1, 530, 130 + y1 + 47 );
g.drawLine$I$I$I$I(522, 130 + y1 + 47 , 530, 130 + y1 + 47 );
g.drawLine$I$I$I$I(526, 201 + y2 - 48, 526, 201 + y2);
g.drawLine$I$I$I$I(523, 201 + y2 - 48, 529, 201 + y2 - 48);
g.setColor$java_awt_Color(mass);
g.fillRect$I$I$I$I(500, 201 + y2, 35, 20);
g.drawLine$I$I$I$I(500, 201 + y2 + 10 , 480, 201 + y2 + 10 );
g.setColor$java_awt_Color($I$(3).black);
g.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, this.mFramePanel);
var fraction=this.mViewTime / C$.dt / 3200.0 ;
this.mThumbRect=Clazz.new_([this.mTraceThumbnail.x + ((fraction * this.mTraceThumbnail.width)|0), this.mTraceThumbnail.y - 3, (this.mTraceThumbnail.width * this.mTraceThumbnail.width/3200|0), this.mTraceThumbnail.height + 6],$I$(1,1).c$$I$I$I$I);
fraction=this.mTime / C$.dt / 3200.0 ;
var intTime=((fraction * this.mTraceThumbnail.width)|0);
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(this.mTraceThumbnail.x + intTime + this.mThumbRect.width , this.mTraceThumbnail.y, this.mTraceThumbnail.width - intTime - this.mThumbRect.width , this.mTraceThumbnail.height);
g.setColor$java_awt_Color($I$(3).black);
g.drawRect$I$I$I$I(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 2);
g.drawRect$I$I$I$I(this.mThumbRect.x, this.mThumbRect.y, this.mThumbRect.width, this.mThumbRect.height);
g.drawRect$I$I$I$I(this.mThumbRect.x + 1, this.mThumbRect.y + 1, this.mThumbRect.width - 2, this.mThumbRect.height - 2);
g.drawRect$I$I$I$I(this.mThumbRect.x + 2, this.mThumbRect.y + 2, this.mThumbRect.width - 4, this.mThumbRect.height - 4);
var fudge=g.create$();
fudge.clipRect$I$I$I$I(this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height);
fudge.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mTraceImage, -(((this.mViewTime / C$.dt)|0)), this.mTraceClip.y, this.mFramePanel);
fudge.dispose$();
g.drawRect$I$I$I$I(90, 60, 400, 200);
});

Clazz.newMeth(C$, 'Response$',  function () {
this.mDisplacement1=Clazz.array(Double.TYPE, [1600]);
this.mDisplacement2=Clazz.array(Double.TYPE, [1600]);
this.mX1=Clazz.array(Double.TYPE, [1605]);
this.mY1=Clazz.array(Double.TYPE, [1605]);
this.mF1=Clazz.array(Double.TYPE, [1605]);
this.mX2=Clazz.array(Double.TYPE, [1605]);
this.mY2=Clazz.array(Double.TYPE, [1605]);
this.mF2=Clazz.array(Double.TYPE, [1605]);
this.mDisplacement1[0]=this.mX1o;
this.mX1[0]=this.mDisplacement1[0];
this.mY1[0]=0.0;
this.mDisplacement2[0]=this.mX2o;
this.mX2[0]=this.mDisplacement2[0];
this.mY2[0]=0.0;
var mdtx2=2.0 * C$.dt;
for (var p=0; p < 1599; p++) {
this.mF1[p]=(-this.mk1 * this.mX1[p] - this.mc1 * this.mY1[p] + this.mk2 * (this.mX2[p] - this.mX1[p]) + this.mc2 * (this.mY2[p] - this.mY1[p])) / this.mm1;
this.mF2[p]=(-this.mk2 * (this.mX2[p] - this.mX1[p]) - this.mc2 * (this.mY2[p] - this.mY1[p])) / this.mm2;
this.mX1[p + 1]=this.mX1[p] + this.mY1[p] * mdtx2 / 2.0;
this.mX2[p + 1]=this.mX2[p] + this.mY2[p] * mdtx2 / 2.0;
this.mY1[p + 1]=this.mY1[p] + this.mF1[p] * mdtx2 / 2.0;
this.mY2[p + 1]=this.mY2[p] + this.mF2[p] * mdtx2 / 2.0;
this.mF1[p + 1]=(-this.mk1 * this.mX1[p + 1] - this.mc1 * this.mY1[p + 1] + this.mk2 * (this.mX2[p + 1] - this.mX1[p + 1]) + this.mc2 * (this.mY2[p + 1] - this.mY1[p + 1])) / this.mm1;
this.mF2[p + 1]=(-this.mk2 * (this.mX2[p + 1] - this.mX1[p + 1]) - this.mc2 * (this.mY2[p + 1] - this.mY1[p + 1])) / this.mm2;
this.mX1[p + 2]=this.mX1[p] + this.mY1[p + 1] * mdtx2 / 2.0;
this.mX2[p + 2]=this.mX2[p] + this.mY2[p + 1] * mdtx2 / 2.0;
this.mY1[p + 2]=this.mY1[p] + this.mF1[p + 1] * mdtx2 / 2.0;
this.mY2[p + 2]=this.mY2[p] + this.mF2[p + 1] * mdtx2 / 2.0;
this.mF1[p + 2]=(-this.mk1 * this.mX1[p + 2] - this.mc1 * this.mY1[p + 2] + this.mk2 * (this.mX2[p + 2] - this.mX1[p + 2]) + this.mc2 * (this.mY2[p + 2] - this.mY1[p + 2])) / this.mm1;
this.mF2[p + 2]=(-this.mk2 * (this.mX2[p + 2] - this.mX1[p + 2]) - this.mc2 * (this.mY2[p + 2] - this.mY1[p + 2])) / this.mm2;
this.mX1[p + 3]=this.mX1[p] + this.mY1[p + 2] * mdtx2;
this.mX2[p + 3]=this.mX2[p] + this.mY2[p + 2] * mdtx2;
this.mY1[p + 3]=this.mY1[p] + this.mF1[p + 2] * mdtx2;
this.mY2[p + 3]=this.mY2[p] + this.mF2[p + 2] * mdtx2;
this.mF1[p + 3]=(-this.mk1 * this.mX1[p + 3] - this.mc1 * this.mY1[p + 3] + this.mk2 * (this.mX2[p + 3] - this.mX1[p + 3]) + this.mc2 * (this.mY2[p + 3] - this.mY1[p + 3])) / this.mm1;
this.mF2[p + 3]=(-this.mk2 * (this.mX2[p + 3] - this.mX1[p + 3]) - this.mc2 * (this.mY2[p + 3] - this.mY1[p + 3])) / this.mm2;
this.mX1[p + 1]=this.mX1[p] + (this.mY1[p] + 2.0 * this.mY1[p + 1] + 2.0 * this.mY1[p + 2] + this.mY1[p + 3]) * mdtx2 / 6.0;
this.mX2[p + 1]=this.mX2[p] + (this.mY2[p] + 2.0 * this.mY2[p + 1] + 2.0 * this.mY2[p + 2] + this.mY2[p + 3]) * mdtx2 / 6.0;
this.mY1[p + 1]=this.mY1[p] + (this.mF1[p] + 2.0 * this.mF1[p + 1] + 2.0 * this.mF1[p + 2] + this.mF1[p + 3]) * mdtx2 / 6.0;
this.mY2[p + 1]=this.mY2[p] + (this.mF2[p] + 2.0 * this.mF2[p + 1] + 2.0 * this.mF2[p + 2] + this.mF2[p + 3]) * mdtx2 / 6.0;
this.mDisplacement1[p + 1]=this.mX1[p + 1];
this.mDisplacement2[p + 1]=this.mX2[p + 1];
if (this.mDisplacement1[p + 1] > 7.3 ) {
this.mDisplacement1[p + 1]=7.3;
this.mX1[p + 1]=7.3;
this.mY1[p + 1]=-0.7 * this.mY1[p + 1];
}if (this.mDisplacement1[p + 1] < -7.3 ) {
this.mDisplacement1[p + 1]=-7.3;
this.mX1[p + 1]=-7.3;
this.mY1[p + 1]=-0.7 * this.mY1[p + 1];
}}
});

Clazz.newMeth(C$, 'DrawTraceGrid$',  function () {
this.mTraceGC.setPaintMode$();
this.mTraceGC.setColor$java_awt_Color($I$(3).white);
this.mTraceGC.fillRect$I$I$I$I(0, 0, 3290, 200);
this.mTraceGC.setColor$java_awt_Color($I$(3).black);
for (var p=0; p < 3290; p+=50) {
this.mTraceGC.drawLine$I$I$I$I(p, 0, p, 200);
}
this.mTraceGC.drawLine$I$I$I$I(0, 60, 3290, 60);
this.mTraceGC.drawLine$I$I$I$I(0, 151, 3290, 151);
});

Clazz.newMeth(C$, 'ThumbnailSketch$',  function () {
this.mTraceThumbnailGC.setPaintMode$();
this.mTraceThumbnailGC.setColor$java_awt_Color($I$(3).white);
this.mTraceThumbnailGC.fillRect$I$I$I$I(0, 0, this.mTraceClip.width, (this.mTraceClip.height/8|0));
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceThumbnailGC.setColor$java_awt_Color(mass);
for (var p=0; p < 1598; p++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((p * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 3.0 |0) + this.mDisplacement1[p] * C$.yscale / 8.0)|0), (((p + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 3.0 |0) + this.mDisplacement1[p + 1] * C$.yscale / 8.0)|0));
}
for (var var3=0; var3 < 1598; var3++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((var3 * 2 + 400)/8|0), (((this.mTraceClip.height/8|0) * 2.0 / 3.0 + this.mDisplacement2[var3] * C$.yscale / 8.0)|0), (((var3 + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8|0) * 2.0 / 3.0 + this.mDisplacement2[var3 + 1] * C$.yscale / 8.0)|0));
}
});

Clazz.newMeth(C$, 'DrawTraceShape$',  function () {
this.DrawTraceGrid$();
var mass=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceGC.setColor$java_awt_Color(mass);
for (var p=0; p < 1598; p++) {
this.mTraceGC.drawLine$I$I$I$I(p * 2 + 400 + 90, 60 + ((C$.yscale * this.mDisplacement1[p])|0), (p + 1) * 2 + 400 + 90, 60 + ((C$.yscale * this.mDisplacement1[p + 1])|0));
}
for (var var3=0; var3 < 1598; var3++) {
this.mTraceGC.drawLine$I$I$I$I(var3 * 2 + 400 + 90, 151 + ((C$.yscale * this.mDisplacement2[var3])|0), (var3 + 1) * 2 + 400 + 90, 151 + ((C$.yscale * this.mDisplacement2[var3 + 1])|0));
}
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog5_Damped_CFrame$I$D',  function (controller, code, val) {
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
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mm1=val;
break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mk1=val;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mc1=val;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mm2=val;
break;
case 6:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mk2=val;
break;
case 7:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mc2=val;
break;
case 8:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mX1o=val;
break;
case 9:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mX2o=val;
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:52 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

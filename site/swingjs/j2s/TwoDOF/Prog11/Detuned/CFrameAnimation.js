(function(){var P$=Clazz.newPackage("TwoDOF.Prog11.Detuned"),I$=[[0,'java.awt.Rectangle','TwoDOF.Prog11.Detuned.CFrameHelp','java.awt.Color','TwoDOF.Prog11.Detuned.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'TwoDOF.Prog11.Detuned.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mm1=0.4;
this.mk1=20.0;
this.mc1=0.5;
this.mm2=0.3;
this.mk2=20.0;
this.mc2=0.0;
this.mXo=5.0;
this.kyTopAbutment=19;
},1);

C$.$fields$=[['Z',['mFirstTime','mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mm1','mk1','mc1','mm2','mk2','mc2','mXo','mWin','mWinrads','mT'],'I',['mState','kyTopAbutment'],'O',['mDisplacement1','double[]','+mDisplacement2','+mX1','+mY1','+mF1','+mX2','+mY2','+mF2','+mInput','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics','mTraceThumbnailImage','java.awt.Image','mTraceThumbnailGC','java.awt.Graphics','mTraceClip','java.awt.Rectangle','+mTraceThumbnail','+mThumbRect','m2Control','TwoDOF.Prog11.Detuned.CFrameSmallControl']]
,['D',['dt','yscale']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Prog11_Detuned_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$TwoDOF_Prog11_Detuned_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mWin=Math.sqrt(this.mk2 / this.mm2) / 2.0 / 3.141592653589793 ;
this.mFirstTime=true;
this.mTraceClip=Clazz.new_($I$(1,1).c$$I$I$I$I,[90, 60, 400, 200]);
this.mTraceThumbnail=Clazz.new_([this.mTraceClip.x, this.mTraceClip.y + this.mTraceClip.height + 20 , this.mTraceClip.width, (this.mTraceClip.height/8|0)],$I$(1,1).c$$I$I$I$I);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog11_Detuned_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, "This is a control for the plot above.\nTry dragging the cursor."]);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog11_Detuned_CFramePanel$I$I$I$I$S,[this.mFramePanel, this.mTraceClip.x, this.mTraceClip.y, this.mTraceClip.width, this.mTraceClip.height, "This shows a plot of the motion of the system.\nTo animate the motion, click the Start button."]);
Clazz.new_($I$(2,1).c$$TwoDOF_Prog11_Detuned_CFramePanel$I$I$I$I$S,[this.mFramePanel, 500, this.kyTopAbutment, 35, 20, "This represents a rigid abutment,\ni.e. a solid block fixed to Earth."]);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
if (this.mTraceGC == null ) {
this.mTraceImage=this.mFramePanel.createImage$I$I(3290, 200);
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
}var var2;
var var3;
if (this.mDisplacement1 == null ) {
var2=0;
var3=0;
} else {
var var4=((1.0 + this.mTime / 2.0 / C$.dt )|0);
var2=((C$.yscale * this.mDisplacement1[var4])|0);
var3=((C$.yscale * this.mDisplacement2[var4])|0);
this.kyTopAbutment=19 + ((this.mInput[var4] * 1000.0)|0);
}g.setPaintMode$();
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(0, 0, this.width, this.height);
g.setColor$java_awt_Color($I$(3).orange);
g.fillRect$I$I$I$I(500, this.kyTopAbutment, 35, 20);
g.setColor$java_awt_Color($I$(3).black);
var var5=(110 + var2 - this.kyTopAbutment - 20) / 10.0;
g.drawLine$I$I$I$I(508, this.kyTopAbutment + 20, 514, ((this.kyTopAbutment + 20 + var5 / 2.0 )|0));
for (var var13=1; var13 < 10; var13++) {
if (var13 % 2 == 0) {
g.drawLine$I$I$I$I(502, ((this.kyTopAbutment + 20 + (2 * var13 - 1) * var5 / 2.0 )|0), 514, ((this.kyTopAbutment + 20 + (2 * var13 + 1) * var5 / 2.0 )|0));
} else {
g.drawLine$I$I$I$I(514, ((this.kyTopAbutment + 20 + (2 * var13 - 1) * var5 / 2.0 )|0), 502, ((this.kyTopAbutment + 20 + (2 * var13 + 1) * var5 / 2.0 )|0));
}}
g.drawLine$I$I$I$I(502, ((this.kyTopAbutment + 20 + 19.0 * var5 / 2.0 )|0), 508, 110 + var2);
g.setColor$java_awt_Color($I$(3).black);
g.drawLine$I$I$I$I(522, this.kyTopAbutment + 20, 522, this.kyTopAbutment + 20 + 47 );
g.drawLine$I$I$I$I(530, this.kyTopAbutment + 20, 530, this.kyTopAbutment + 20 + 47 );
g.drawLine$I$I$I$I(522, this.kyTopAbutment + 20 + 47 , 530, this.kyTopAbutment + 20 + 47 );
g.drawLine$I$I$I$I(526, 110 + var2 - 48, 526, 110 + var2);
g.drawLine$I$I$I$I(523, 110 + var2 - 48, 529, 110 + var2 - 48);
var var7=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
g.setColor$java_awt_Color(var7);
g.fillRect$I$I$I$I(500, 110 + var2, 35, 20);
g.drawLine$I$I$I$I(500, 110 + var2 + 10 , 480, 110 + var2 + 10 );
g.setColor$java_awt_Color($I$(3).black);
var5=(201 + var3 - 110 - 20 - var2) / 10.0;
g.drawLine$I$I$I$I(517, 130 + var2, 523, ((130 + var2 + var5 / 2.0 )|0));
for (var var14=1; var14 < 10; var14++) {
if (var14 % 2 == 0) {
g.drawLine$I$I$I$I(511, ((130 + var2 + (2 * var14 - 1) * var5 / 2.0 )|0), 523, ((130 + var2 + (2 * var14 + 1) * var5 / 2.0 )|0));
} else {
g.drawLine$I$I$I$I(523, ((130 + var2 + (2 * var14 - 1) * var5 / 2.0 )|0), 511, ((130 + var2 + (2 * var14 + 1) * var5 / 2.0 )|0));
}}
g.drawLine$I$I$I$I(511, ((130 + var2 + 19.0 * var5 / 2.0 )|0), 517, 201 + var3);
g.setColor$java_awt_Color(var7);
g.fillRect$I$I$I$I(500, 201 + var3, 35, 20);
g.drawLine$I$I$I$I(500, 201 + var3 + 10 , 480, 201 + var3 + 10 );
g.setColor$java_awt_Color($I$(3).black);
g.drawImage$java_awt_Image$I$I$I$I$java_awt_image_ImageObserver(this.mTraceThumbnailImage, this.mTraceThumbnail.x, this.mTraceThumbnail.y, this.mTraceThumbnail.width, this.mTraceThumbnail.height, this.mFramePanel);
var var8=this.mViewTime / C$.dt / 3200.0 ;
this.mThumbRect=Clazz.new_([this.mTraceThumbnail.x + ((var8 * this.mTraceThumbnail.width)|0), this.mTraceThumbnail.y - 3, (this.mTraceThumbnail.width * this.mTraceThumbnail.width/3200|0), this.mTraceThumbnail.height + 6],$I$(1,1).c$$I$I$I$I);
var8=this.mTime / C$.dt / 3200.0 ;
var var10=((var8 * this.mTraceThumbnail.width)|0);
g.setColor$java_awt_Color($I$(3).white);
g.fillRect$I$I$I$I(this.mTraceThumbnail.x + var10 + this.mThumbRect.width , this.mTraceThumbnail.y, this.mTraceThumbnail.width - var10 - this.mThumbRect.width , this.mTraceThumbnail.height);
g.setColor$java_awt_Color($I$(3).orange);
var var11=((this.mTraceThumbnail.x + (400.0 + 1.0 / C$.dt) / 8.0)|0);
g.drawLine$I$I$I$I(this.mTraceThumbnail.x + 50, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 3 |0), var11, this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 3 |0));
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var var15=0; var15 < 1600 - var11 - 144 ; var15++) {
g.drawLine$I$I$I$I((var15 * 2/8|0) + var11, ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 3 |0) + C$.yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * 2.0 * var15 * C$.dt ) / 8.0)|0), var11 + (2 * (var15 + 1)/8|0), ((this.mTraceThumbnail.y + (this.mTraceClip.height/8 / 3 |0) + C$.yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * 2.0 * (var15 + 1) * C$.dt ) / 8.0)|0));
}
g.setColor$java_awt_Color($I$(3).black);
g.drawRect$I$I$I$I(this.mTraceThumbnail.x - 1, this.mTraceThumbnail.y - 1, this.mTraceThumbnail.width + 1, this.mTraceThumbnail.height + 2);
g.drawRect$I$I$I$I(this.mThumbRect.x, this.mThumbRect.y, this.mThumbRect.width, this.mThumbRect.height);
g.drawRect$I$I$I$I(this.mThumbRect.x + 1, this.mThumbRect.y + 1, this.mThumbRect.width - 2, this.mThumbRect.height - 2);
g.drawRect$I$I$I$I(this.mThumbRect.x + 2, this.mThumbRect.y + 2, this.mThumbRect.width - 4, this.mThumbRect.height - 4);
g.drawString$S$I$I(" Detuned frequency", 395, 20);
g.drawString$S$I$I($I$(4,"nns$D",[Math.sqrt(this.mk2 / this.mm2) / 2.0 / 3.141592653589793 ]) + " Hz", 398, 36);
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
this.mInput=Clazz.array(Double.TYPE, [1605]);
this.mDisplacement1[0]=0.0;
this.mX1[0]=this.mDisplacement1[0];
this.mY1[0]=0.0;
this.mDisplacement2[0]=0.0;
this.mX2[0]=this.mDisplacement2[0];
this.mY2[0]=0.0;
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
var var2=2.0 * C$.dt;
this.mT=0.0;
for (var var1=0; var1 < 1599; var1++) {
this.mInput[var1]=this.mXo / 1000.0 * Math.sin(this.mWinrads * (this.mT - 1.0));
if (this.mT < 1.0 ) {
this.mInput[var1]=0.0;
}this.mT+=var2;
}
for (var var4=0; var4 < 1599; var4++) {
this.mF1[var4]=(-this.mk1 * (this.mX1[var4] - this.mInput[var4]) - this.mc1 * (this.mY1[var4] - (this.mInput[var4 + 1] - this.mInput[var4]) / var2) + this.mk2 * (this.mX2[var4] - this.mX1[var4]) + this.mc2 * (this.mY2[var4] - this.mY1[var4])) / this.mm1;
this.mF2[var4]=(-this.mk2 * (this.mX2[var4] - this.mX1[var4]) - this.mc2 * (this.mY2[var4] - this.mY1[var4])) / this.mm2;
this.mX1[var4 + 1]=this.mX1[var4] + this.mY1[var4] * var2 / 2.0;
this.mX2[var4 + 1]=this.mX2[var4] + this.mY2[var4] * var2 / 2.0;
this.mY1[var4 + 1]=this.mY1[var4] + this.mF1[var4] * var2 / 2.0;
this.mY2[var4 + 1]=this.mY2[var4] + this.mF2[var4] * var2 / 2.0;
this.mF1[var4 + 1]=(-this.mk1 * (this.mX1[var4 + 1] - this.mInput[var4 + 1]) - this.mc1 * (this.mY1[var4 + 1] - (this.mInput[var4 + 2] - this.mInput[var4 + 1]) / var2) + this.mk2 * (this.mX2[var4 + 1] - this.mX1[var4 + 1]) + this.mc2 * (this.mY2[var4 + 1] - this.mY1[var4 + 1])) / this.mm1;
this.mF2[var4 + 1]=(-this.mk2 * (this.mX2[var4 + 1] - this.mX1[var4 + 1]) - this.mc2 * (this.mY2[var4 + 1] - this.mY1[var4 + 1])) / this.mm2;
this.mX1[var4 + 2]=this.mX1[var4] + this.mY1[var4 + 1] * var2 / 2.0;
this.mX2[var4 + 2]=this.mX2[var4] + this.mY2[var4 + 1] * var2 / 2.0;
this.mY1[var4 + 2]=this.mY1[var4] + this.mF1[var4 + 1] * var2 / 2.0;
this.mY2[var4 + 2]=this.mY2[var4] + this.mF2[var4 + 1] * var2 / 2.0;
this.mF1[var4 + 2]=(-this.mk1 * (this.mX1[var4 + 2] - this.mInput[var4 + 2]) - this.mc1 * (this.mY1[var4 + 2] - (this.mInput[var4 + 3] - this.mInput[var4 + 2]) / var2) + this.mk2 * (this.mX2[var4 + 2] - this.mX1[var4 + 2]) + this.mc2 * (this.mY2[var4 + 2] - this.mY1[var4 + 2])) / this.mm1;
this.mF2[var4 + 2]=(-this.mk2 * (this.mX2[var4 + 2] - this.mX1[var4 + 2]) - this.mc2 * (this.mY2[var4 + 2] - this.mY1[var4 + 2])) / this.mm2;
this.mX1[var4 + 3]=this.mX1[var4] + this.mY1[var4 + 2] * var2;
this.mX2[var4 + 3]=this.mX2[var4] + this.mY2[var4 + 2] * var2;
this.mY1[var4 + 3]=this.mY1[var4] + this.mF1[var4 + 2] * var2;
this.mY2[var4 + 3]=this.mY2[var4] + this.mF2[var4 + 2] * var2;
this.mF1[var4 + 3]=(-this.mk1 * (this.mX1[var4 + 3] - this.mInput[var4 + 3]) - this.mc1 * (this.mY1[var4 + 3] - (this.mInput[var4 + 4] - this.mInput[var4 + 3]) / var2) + this.mk2 * (this.mX2[var4 + 3] - this.mX1[var4 + 3]) + this.mc2 * (this.mY2[var4 + 3] - this.mY1[var4 + 3])) / this.mm1;
this.mF2[var4 + 3]=(-this.mk2 * (this.mX2[var4 + 3] - this.mX1[var4 + 3]) - this.mc2 * (this.mY2[var4 + 3] - this.mY1[var4 + 3])) / this.mm2;
this.mX1[var4 + 1]=this.mX1[var4] + (this.mY1[var4] + 2.0 * this.mY1[var4 + 1] + 2.0 * this.mY1[var4 + 2] + this.mY1[var4 + 3]) * var2 / 6.0;
this.mX2[var4 + 1]=this.mX2[var4] + (this.mY2[var4] + 2.0 * this.mY2[var4 + 1] + 2.0 * this.mY2[var4 + 2] + this.mY2[var4 + 3]) * var2 / 6.0;
this.mY1[var4 + 1]=this.mY1[var4] + (this.mF1[var4] + 2.0 * this.mF1[var4 + 1] + 2.0 * this.mF1[var4 + 2] + this.mF1[var4 + 3]) * var2 / 6.0;
this.mY2[var4 + 1]=this.mY2[var4] + (this.mF2[var4] + 2.0 * this.mF2[var4 + 1] + 2.0 * this.mF2[var4 + 2] + this.mF2[var4 + 3]) * var2 / 6.0;
this.mDisplacement1[var4 + 1]=this.mX1[var4 + 1];
this.mDisplacement2[var4 + 1]=this.mX2[var4 + 1];
if (this.mDisplacement1[var4 + 1] > 0.0073 ) {
this.mDisplacement1[var4 + 1]=0.007;
this.mX1[var4 + 1]=this.mDisplacement1[var4 + 1];
this.mY1[var4 + 1]=-0.7 * this.mY1[var4 + 1];
}if (this.mDisplacement1[var4 + 1] < -0.0073 ) {
this.mDisplacement1[var4 + 1]=-0.007;
this.mX1[var4 + 1]=this.mDisplacement1[var4 + 1];
this.mY1[var4 + 1]=-0.7 * this.mY1[var4 + 1];
}this.mT+=var2;
}
});

Clazz.newMeth(C$, 'DrawTraceGrid$',  function () {
this.mTraceGC.setPaintMode$();
this.mTraceGC.setColor$java_awt_Color($I$(3).white);
this.mTraceGC.fillRect$I$I$I$I(0, 0, 3290, 200);
this.mTraceGC.setColor$java_awt_Color($I$(3).black);
for (var var1=0; var1 < 3290; var1+=50) {
this.mTraceGC.drawLine$I$I$I$I(var1, 0, var1, 200);
}
this.mTraceGC.drawLine$I$I$I$I(0, 60, 3290, 60);
this.mTraceGC.drawLine$I$I$I$I(0, 151, 3290, 151);
});

Clazz.newMeth(C$, 'DrawForceGraph$',  function () {
this.mTraceGC.setColor$java_awt_Color($I$(3).orange);
this.mWinrads=this.mWin * 2.0 * 3.141592653589793 ;
for (var var1=((0.5 / C$.dt)|0); var1 < 1598; var1++) {
this.mTraceGC.drawLine$I$I$I$I(var1 * 2 + 400 + 90, 60 + ((C$.yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * (2 * var1 * C$.dt  - 1.0)))|0), (var1 + 1) * 2 + 400 + 90, 60 + ((C$.yscale * this.mXo / 1000.0 * Math.sin(this.mWinrads * (2 * (var1 + 1) * C$.dt  - 1.0)))|0));
}
});

Clazz.newMeth(C$, 'ThumbnailSketch$',  function () {
this.mTraceThumbnailGC.setPaintMode$();
this.mTraceThumbnailGC.setColor$java_awt_Color($I$(3).white);
this.mTraceThumbnailGC.fillRect$I$I$I$I(0, 0, this.mTraceClip.width, (this.mTraceClip.height/8|0));
var var2=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceThumbnailGC.setColor$java_awt_Color(var2);
for (var var1=0; var1 < 1598; var1++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((var1 * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 3.0 |0) + this.mDisplacement1[var1] * C$.yscale / 8.0)|0), (((var1 + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8 / 3.0 |0) + this.mDisplacement1[var1 + 1] * C$.yscale / 8.0)|0));
}
for (var var3=0; var3 < 1598; var3++) {
this.mTraceThumbnailGC.drawLine$I$I$I$I(((var3 * 2 + 400)/8|0), (((this.mTraceClip.height/8|0) * 2.0 / 3.0 + this.mDisplacement2[var3] * C$.yscale / 8.0)|0), (((var3 + 1) * 2 + 400)/8|0), (((this.mTraceClip.height/8|0) * 2.0 / 3.0 + this.mDisplacement2[var3 + 1] * C$.yscale / 8.0)|0));
}
});

Clazz.newMeth(C$, 'DrawTraceShape$',  function () {
this.DrawTraceGrid$();
var var2=Clazz.new_($I$(3,1).c$$F$F$F,[0.18, 0.58, 0.58]);
this.mTraceGC.setColor$java_awt_Color(var2);
for (var var1=0; var1 < 1598; var1++) {
this.mTraceGC.drawLine$I$I$I$I(var1 * 2 + 400 + 90, 60 + ((C$.yscale * this.mDisplacement1[var1])|0), (var1 + 1) * 2 + 400 + 90, 60 + ((C$.yscale * this.mDisplacement1[var1 + 1])|0));
}
for (var var3=0; var3 < 1598; var3++) {
this.mTraceGC.drawLine$I$I$I$I(var3 * 2 + 400 + 90, 151 + ((C$.yscale * this.mDisplacement2[var3])|0), (var3 + 1) * 2 + 400 + 90, 151 + ((C$.yscale * this.mDisplacement2[var3 + 1])|0));
}
this.DrawForceGraph$();
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Prog11_Detuned_CFrame$I$D',  function (var1, var2, var3) {
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
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mm1=var3;
if (this.m2Control != null ) {
this.m2Control.mMax=var3;
this.m2Control.NewValue$();
this.m2Control.repaint$();
}break;
case 3:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mk1=var3;
break;
case 4:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mc1=var3;
break;
case 5:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mm2=var3;
this.mWin=Math.sqrt(this.mk2 / this.mm2) / 2.0 / 3.141592653589793 ;
break;
case 6:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mk2=var3;
this.mWin=Math.sqrt(this.mk2 / this.mm2) / 2.0 / 3.141592653589793 ;
break;
case 7:
this.ChangeRunState$I(0);
this.mTime=0.0;
this.mViewTime=0.0;
this.mDisplacement1=null;
this.mDisplacement2=null;
this.mc2=var3;
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
C$.yscale=3400.0;
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

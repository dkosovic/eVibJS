(function(){var P$=Clazz.newPackage("MultiDOF.Prog10.Multiforced"),I$=[[0,'java.awt.Color','java.awt.Rectangle','java.util.Vector','MultiDOF.Prog10.Multiforced.CSpringMassDamper']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameGraph", null, 'MultiDOF.Prog10.Multiforced.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mAmp=Clazz.array(Double.TYPE, [601]);
this.mAReal=Clazz.array(Double.TYPE, [12, 12]);
this.mAImag=Clazz.array(Double.TYPE, [12, 12]);
this.mBReal=Clazz.array(Double.TYPE, [12, 12]);
this.mBImag=Clazz.array(Double.TYPE, [12, 12]);
this.mCReal=Clazz.array(Double.TYPE, [12, 12]);
this.mCImag=Clazz.array(Double.TYPE, [12, 12]);
this.mWanimate=0.2;
this.mTime=0.0;
},1);

C$.$fields$=[['Z',['mClickedAboveSystem'],'D',['mWanimate','mMax','mMin','mScale','mTime','mMaxMassAmp'],'I',['mXPos','mFPos','mDisplayXPos','mDisplayFPos'],'O',['mAmp','double[]','mAReal','double[][]','+mAImag','+mBReal','+mBImag','+mCReal','+mCImag','mElements','java.util.Vector','mSelectedSMD','MultiDOF.Prog10.Multiforced.CSpringMassDamper','mInstructionButton','java.awt.Button','+mInputButton','mWControl','MultiDOF.Prog10.Multiforced.CFrameSmallControl']]]

Clazz.newMeth(C$, 'c$$MultiDOF_Prog10_Multiforced_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$MultiDOF_Prog10_Multiforced_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.AddElement$I$D$D$D$Z$Z(0, 1.0, 0.0, 0.0, false, true);
this.AddElement$I$D$D$D$Z$Z(1, 1.0, 1.0, 0.005, true, false);
this.AddElement$I$D$D$D$Z$Z(1, 1.0, 1.0, 0.005, true, false);
this.SetXF$I$I(2, 2);
this.SetSMDPositions$();
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var var2=0;
var var3=0;
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).black);
var var4=this.GetSMD$I(this.mDisplayXPos);
if (var4 != null ) {
var4.DrawSmallArrow$java_awt_Graphics$I$S(var1, 5, "X");
}var4=this.GetSMD$I(this.mDisplayFPos);
if (var4 != null ) {
var4.DrawSmallArrow$java_awt_Graphics$I$S(var1, 47, "F");
}var1.setColor$java_awt_Color($I$(1).lightGray);
var1.drawRect$I$I$I$I(this.x, this.y, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var var6=3;
if (this.mMax == this.mMin ) {
var1.drawString$S$I$I("Please wait, calculating...", this.x + 10, this.y + 10);
} else {
var2=(Math.ceil(this.mMax)|0);
var3=(Math.floor(this.mMin)|0);
this.mScale=(this.height/(var2 - var3)|0);
var1.drawLine$I$I$I$I(this.x, this.y, this.x, this.y + this.height + var6 );
var1.drawLine$I$I$I$I(this.x, this.y + this.height, this.x + this.width, this.y + this.height);
for (var var5=0; var5 < 20; var5++) {
if (((var5 * Math.log(10.0) * this.mScale )|0) < this.height) {
var var7=this.y + 5 + ((var5 * Math.log(10.0) * this.mScale )|0) ;
var1.drawLine$I$I$I$I(this.x, var7, this.x - var6, var7);
}}
for (var var12=1; var12 < 7; var12++) {
var1.drawLine$I$I$I$I(this.x + var12 * 100, this.y + this.height, this.x + var12 * 100, this.y + this.height + var6 );
}
var var15=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var15);
var var8=((this.y + 5 - (this.mAmp[9] - var2) * this.mScale)|0);
for (var var13=10; var13 < 601; var13++) {
var var9=var8;
var8=((this.y + 5 - (this.mAmp[var13] - var2) * this.mScale)|0);
var1.drawLine$I$I$I$I(this.x + (var13 - 1), var9, this.x + var13, var8);
}
}var var14=((this.mWanimate / 0.005)|0);
if (var14 < 10) {
var14=10;
}if (var14 > 600) {
var14=600;
}var1.setColor$java_awt_Color($I$(1).blue);
var1.drawLine$I$I$I$I(this.x + var14, this.y + 279, this.x + var14, ((this.y + 6 - (this.mAmp[var14] - var2) * this.mScale)|0));
var1.drawString$S$I$I(this.nns$D(this.mWanimate) + " rad/s", this.x + var14 + 2 , this.y + this.height - 2);
});

Clazz.newMeth(C$, 'log10$D',  function (var1) {
return Math.log(var1) / Math.log(10.0);
});

Clazz.newMeth(C$, 'nns$D$I',  function (var1, var3) {
if (var3 <= 0) {
var3=1;
}if (var1 == 0.0 ) {
return "0";
} else if (var1 < 0.0 ) {
return "-" + this.nns$D$I(-var1, var3);
} else {
var var4=Math.floor(this.log10$D(var1));
var var6=Math.pow(10.0, var4 - var3 + 1.0);
var var8=Math.round$D(var1 / var6);
var var10=String.valueOf$D(var8 * var6);
while (var10.length$() > 1 && var10.indexOf$I(46) > -1 ){
var var11=false;
var var12;
for (var12=var10.length$() - 1; var10.charAt$I(var12) == "0"; var11=true) {
--var12;
}
if (var11) {
var10=var10.substring$I$I(0, var12 + 1);
}var var13=var10.substring$I$I(0, var12);
var var14;
try {
var14=java.lang.Double.parseDouble$S(var13);
} catch (var15) {
if (Clazz.exceptionOf(var15,"NumberFormatException")){
break;
} else {
throw var15;
}
}
if (Math.abs(var1 - var14) > var6 ) {
break;
}var10=var13;
}
return var10;
}});

Clazz.newMeth(C$, 'nns$D',  function (var1) {
return this.nns$D$I(var1, 4);
});

Clazz.newMeth(C$, 'DrawModeShape$java_awt_Graphics$I$I',  function (var1, var2, var3) {
var var5=0;
if (this.mElements != null ) {
var5=this.mElements.size$();
}var var6=this.GetTime$();
var var9;
if (this.mMaxMassAmp == 0.0 ) {
var9=0.0;
} else {
var9=40.0 / (this.mMaxMassAmp * 2.0);
}for (var var4=1; var4 <= var5; var4++) {
var var11=this.GetSMD$I(var4);
var var8=Clazz.new_($I$(2,1).c$$I$I$I$I,[0, 0, 0, 0]);
var8.x=((0.2 + var11.x + var11.width  - 15.0 + var9 * var11.mMassAmp * Math.sin(var6 * 3.141592653589793 + var11.mMassPhase) )|0);
var8.y=var3;
var8.width=15;
var8.height=30;
var var12=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (var11.IsAbutment$()) {
var1.setColor$java_awt_Color($I$(1).orange);
} else {
var1.setColor$java_awt_Color(var12);
}var1.fillRect$I$I$I$I(var8.x, var8.y, var8.width, var8.height);
}
});

Clazz.newMeth(C$, 'ControlMessage$MultiDOF_Prog10_Multiforced_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
if (this.mSelectedSMD != null ) {
this.mSelectedSMD.ControlMessage$MultiDOF_Prog10_Multiforced_CFrame$I$D(this, 1, 0.0);
}break;
case 2:
this.mWanimate=var3;
this.setOmegaDisp$D(this.mWanimate);
var5=true;
break;
case 3:
this.mTime+=var3;
var5=true;
case 4:
default:
break;
case 5:
var var6=99999;
if (this.mElements != null  && this.mSelectedSMD != null  ) {
var6=this.mElements.indexOf$O(this.mSelectedSMD);
}this.mSelectedSMD=this.AddElement$I$D$D$D$Z$Z(var6 + 1, 1.0, 1.0, 0.005, true, false);
this.ForceReasonableSystem$();
this.SetSMDPositions$();
this.response$();
break;
case 6:
this.ForceReasonableSystem$();
this.response$();
var5=true;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'response$',  function () {
this.mMax=-1000.0;
this.mMin=1000.0;
var var2=this.mFPos;
var var3=this.mXPos;
if (var2 < var3) {
var2=this.mXPos;
var3=this.mFPos;
}this.mMax=0.0;
this.mMin=0.0;
for (var var1=1; var1 < 601; var1++) {
var var4=var1 * 0.005;
this.receptances$D(var4);
this.mAmp[var1]=Math.log(this.mAReal[var3][var2] * this.mAReal[var3][var2] + this.mAImag[var3][var2] * this.mAImag[var3][var2]) / 2.0;
if (this.mAmp[var1] > this.mMax ) {
this.mMax=this.mAmp[var1];
}if (this.mAmp[var1] < this.mMin ) {
this.mMin=this.mAmp[var1];
}}
this.setOmegaDisp$D(this.mWanimate);
});

Clazz.newMeth(C$, 'receptances$D',  function (var1) {
var var3=Clazz.array(Double.TYPE, [12]);
var var4=Clazz.array(Double.TYPE, [12]);
var var32=this.mElements.size$();
var var33=this.GetSMD$I(1);
if (!var33.IsAbutment$()) {
this.mAReal[1][1]=-1.0 / (var33.mMass * var1 * var1 );
this.mAImag[1][1]=0.0;
} else {
this.mAReal[1][1]=0.0;
this.mAImag[1][1]=0.0;
}for (var var29=2; var29 < var32 + 1; var29++) {
var33=this.GetSMD$I(var29);
var var34=var33.mSpringConstant;
var var36=var33.mDampingConstant;
if (!var33.IsAbutment$()) {
this.mBReal[var29][var29]=-1.0 / (var33.mMass * var1 * var1 );
this.mBImag[var29][var29]=0.0;
this.mBReal[var29 - 1][var29]=this.mBReal[var29][var29];
this.mBImag[var29 - 1][var29]=this.mBImag[var29][var29];
var var13;
var var15;
if (var33.mViscous) {
var13=var34 / (var34 * var34 + var36 * var36 * var1 * var1 );
var15=-var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1 );
} else {
var13=var34 / (var34 * var34 + var36 * var36);
var15=-var36 / (var34 * var34 + var36 * var36);
}this.mBReal[var29 - 1][var29 - 1]=var13 + this.mBReal[var29][var29];
this.mBImag[var29 - 1][var29 - 1]=var15 + this.mBImag[var29][var29];
} else {
this.mBReal[var29][var29]=0.0;
this.mBImag[var29][var29]=0.0;
this.mBReal[var29 - 1][var29]=this.mBReal[var29][var29];
this.mBImag[var29 - 1][var29]=this.mBImag[var29][var29];
var var46;
var var50;
if (var33.mViscous) {
var46=var34 / (var34 * var34 + var36 * var36 * var1 * var1 );
var50=-var1 * var36 / (var34 * var34 + var36 * var36 * var1 * var1 );
} else {
var46=var34 / (var34 * var34 + var36 * var36);
var50=-var36 / (var34 * var34 + var36 * var36);
}this.mBReal[var29 - 1][var29 - 1]=var46;
this.mBImag[var29 - 1][var29 - 1]=var50;
}for (var var31=1; var31 < var29; var31++) {
for (var var30=1; var30 < var31 + 1; var30++) {
this.mCReal[var30][var31]=this.mAReal[var30][var31];
this.mCImag[var30][var31]=this.mAImag[var30][var31];
}
}
var var25=this.mBReal[var29 - 1][var29 - 1] + this.mCReal[var29 - 1][var29 - 1];
var var27=this.mBImag[var29 - 1][var29 - 1] + this.mCImag[var29 - 1][var29 - 1];
for (var var64=1; var64 < var29 + 1; var64++) {
var3[var64]=0.0;
var4[var64]=0.0;
}
for (var var65=1; var65 < var29 + 1; var65++) {
for (var var63=1; var63 < var65 + 1; var63++) {
var3[var65]=1.0;
if (var65 < var29 - 1) {
var var17=this.mCReal[var65][var29 - 1] * var3[var65] - this.mCImag[var65][var29 - 1] * var4[var65];
var var19=this.mCReal[var65][var29 - 1] * var4[var65] + this.mCImag[var65][var29 - 1] * var3[var65];
var var47=var25 * var25 + var27 * var27;
var var5=(var17 * var25 + var19 * var27) / var47;
var var7=(var19 * var25 - var17 * var27) / var47;
var var9=-var5;
var var11=-var7;
var17=this.mCReal[var63][var29 - 1] * var9 - this.mCImag[var63][var29 - 1] * var11;
var19=this.mCReal[var63][var29 - 1] * var11 + this.mCImag[var63][var29 - 1] * var9;
var var21=this.mCReal[var63][var65] * var3[var65] - this.mCImag[var63][var65] * var4[var65];
var var23=this.mCReal[var63][var65] * var4[var65] + this.mCImag[var63][var65] * var3[var65];
this.mAReal[var63][var65]=var17 + var21;
this.mAImag[var63][var65]=var19 + var23;
}if (var65 == var29 - 1) {
var var52=this.mCReal[var29 - 1][var29 - 1] * var3[var29 - 1] - this.mCImag[var29 - 1][var29 - 1] * var4[var29 - 1];
var var57=this.mCReal[var29 - 1][var29 - 1] * var4[var29 - 1] + this.mCImag[var29 - 1][var29 - 1] * var3[var29 - 1];
var var48=var25 * var25 + var27 * var27;
var var38=(var52 * var25 + var57 * var27) / var48;
var var40=(var57 * var25 - var52 * var27) / var48;
var var42=var3[var29 - 1] - var38;
var var44=var4[var29 - 1] - var40;
this.mAReal[var63][var65]=this.mCReal[var63][var29 - 1] * var42 - this.mCImag[var63][var29 - 1] * var44;
this.mAImag[var63][var65]=this.mCImag[var63][var29 - 1] * var42 + this.mCReal[var63][var29 - 1] * var44;
}if (var65 == var29) {
var var53=this.mBReal[var29 - 1][var65] * var3[var65] - this.mBImag[var29 - 1][var65] * var4[var65];
var var58=this.mBReal[var29 - 1][var65] * var4[var65] + this.mBImag[var29 - 1][var65] * var3[var65];
var53=-var53;
var58=-var58;
var var49=var25 * var25 + var27 * var27;
var var39=(var53 * var25 + var58 * var27) / var49;
var var41=(var58 * var25 - var53 * var27) / var49;
var var43=-var39;
var var45=-var41;
if (var63 < var29) {
this.mAReal[var63][var65]=this.mCReal[var63][var29 - 1] * var43 - this.mCImag[var63][var29 - 1] * var45;
this.mAImag[var63][var65]=this.mCReal[var63][var29 - 1] * var45 + this.mCImag[var63][var29 - 1] * var43;
} else {
var53=this.mBReal[var29 - 1][var63] * var39 - this.mBImag[var29 - 1][var63] * var41;
var58=this.mBReal[var29 - 1][var63] * var41 + this.mBImag[var29 - 1][var63] * var39;
var var61=this.mBReal[var63][var65] * var3[var65] - this.mBImag[var63][var65] * var4[var65];
var var62=this.mBReal[var63][var65] * var4[var65] + this.mBImag[var63][var65] * var3[var65];
this.mAReal[var63][var65]=var53 + var61;
this.mAImag[var63][var65]=var58 + var62;
}}var3[var65]=0.0;
}
}
}
});

Clazz.newMeth(C$, 'setOmegaDisp$D',  function (var1) {
this.mWanimate=var1;
this.receptances$D(this.mWanimate);
var var4=0;
if (this.mElements != null ) {
var4=this.mElements.size$();
}for (var var3=1; var3 <= this.mFPos; var3++) {
var var5=this.GetSMD$I(var3);
var5.mMassAmp=Math.sqrt(this.mAReal[var3][this.mFPos] * this.mAReal[var3][this.mFPos] + this.mAImag[var3][this.mFPos] * this.mAImag[var3][this.mFPos]);
var5.mMassPhase=Math.atan2(this.mAImag[var3][this.mFPos], this.mAReal[var3][this.mFPos]);
}
for (var var6=this.mFPos + 1; var6 <= var4; var6++) {
var var8=this.GetSMD$I(var6);
var8.mMassAmp=Math.sqrt(this.mAReal[this.mFPos][var6] * this.mAReal[this.mFPos][var6] + this.mAImag[this.mFPos][var6] * this.mAImag[this.mFPos][var6]);
var8.mMassPhase=Math.atan2(this.mAImag[this.mFPos][var6], this.mAReal[this.mFPos][var6]);
}
this.mMaxMassAmp=0.0;
for (var var7=1; var7 <= var4; var7++) {
var var9=this.GetSMD$I(var7);
if (var9.mMassAmp > this.mMaxMassAmp ) {
this.mMaxMassAmp=var9.mMassAmp;
}}
});

Clazz.newMeth(C$, 'GetTime$',  function () {
return this.mTime;
});

Clazz.newMeth(C$, 'AddElement$I$D$D$D$Z$Z',  function (var1, var2, var4, var6, var8, var9) {
if (this.mElements == null ) {
this.mElements=Clazz.new_($I$(3,1));
}var var10=this.mElements.size$();
if (var10 >= 12) {
return null;
} else {
if (var1 < 0) {
var1=0;
}if (var10 < var1) {
var1=var10;
}var var11=Clazz.new_($I$(4,1).c$$MultiDOF_Prog10_Multiforced_CFramePanel$MultiDOF_Prog10_Multiforced_CFrameGraph$D$D$D$Z$Z,[this.mFramePanel, this, var2, var4, var6, var8, var9]);
if (var10 == 0) {
this.mElements.addElement$O(var11);
} else {
this.mElements.insertElementAt$O$I(var11, var1);
}return var11;
}});

Clazz.newMeth(C$, 'RemoveElement$I',  function (var1) {
var var2=0;
if (this.mElements != null ) {
var2=this.mElements.size$();
}if (var2 >= 3) {
if (var1 < 1) {
var1=1;
}if (var1 > var2) {
var1=var2;
}var var3=this.mElements.elementAt$I(var1 - 1);
if (var3 === this.mSelectedSMD ) {
this.mSelectedSMD=null;
}this.mFramePanel.RemoveFrame$MultiDOF_Prog10_Multiforced_CFrame(var3);
this.mElements.removeElement$O(var3);
}});

Clazz.newMeth(C$, 'ForceReasonableSystem$',  function () {
var var2=0;
if (this.mElements != null ) {
var2=this.mElements.size$();
}var var3=null;
for (var var1=2; var1 < var2; var1++) {
var3=this.GetSMD$I(var1);
var3.SetAbutment$Z(false);
}
var var4=1;
var var5=var2;
if (var2 < 2) {
return false;
} else {
var3=this.GetSMD$I(1);
if (var3.IsAbutment$()) {
++var4;
}var3=this.GetSMD$I(var2);
if (var3.IsAbutment$()) {
var5=var2 - 1;
}if (this.mXPos < var4) {
this.mXPos=var4;
}if (var5 < this.mXPos) {
this.mXPos=var5;
}if (this.mFPos < var4) {
this.mFPos=var4;
}if (var5 < this.mFPos) {
this.mFPos=var5;
}this.mDisplayXPos=this.mXPos;
this.mDisplayFPos=this.mFPos;
return true;
}});

Clazz.newMeth(C$, 'SetSMDPositions$',  function () {
var var2=0;
if (this.mElements != null ) {
var2=this.mElements.size$();
}var var3=40;
var var4=15;
for (var var1=1; var1 <= var2; var1++) {
var var5=this.GetSMD$I(var1);
var5.mIndex=var1;
var5.x=var3;
var5.y=var4;
var5.height=30;
if (var1 == 1) {
var5.width=15;
} else {
var5.width=55;
}var3+=var5.width;
}
});

Clazz.newMeth(C$, 'GetSMD$I',  function (var1) {
if (this.mElements == null ) {
return null;
} else {
return var1 >= 1 && this.mElements.size$() >= var1  ? this.mElements.elementAt$I(var1 - 1) : null;
}});

Clazz.newMeth(C$, 'SetXF$I$I',  function (var1, var2) {
this.mXPos=var1;
this.mFPos=var2;
this.ForceReasonableSystem$();
this.response$();
});

Clazz.newMeth(C$, 'SetSelection$MultiDOF_Prog10_Multiforced_CSpringMassDamper',  function (var1) {
this.mSelectedSMD=var1;
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$, 'DeleteSelected$',  function () {
if (this.mElements != null  && this.mSelectedSMD != null  ) {
var var1=this.mElements.indexOf$O(this.mSelectedSMD);
this.RemoveElement$I(var1 + 1);
this.ForceReasonableSystem$();
this.SetSMDPositions$();
this.response$();
}});

Clazz.newMeth(C$, 'MouseEventOutside$I$Z',  function (var1, var2) {
this.mWasHit=false;
if (var1 == 0) {
this.mClickedAboveSystem=this.mFramePanel.mThisPt.y < 15;
}switch (var1) {
case 0:
case 1:
var var3=this.MouseToIndex$I(this.mFramePanel.mThisPt.x);
if (var3 < 1) {
return true;
}if (this.mClickedAboveSystem) {
this.mDisplayXPos=var3;
} else {
this.mDisplayFPos=var3;
}this.mFramePanel.repaint$();
break;
case 2:
if (this.mDisplayXPos != this.mXPos || this.mDisplayFPos != this.mFPos ) {
this.SetXF$I$I(this.mDisplayXPos, this.mDisplayFPos);
}}
return true;
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
if (var2) {
return false;
} else {
var var3=this.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
if (!var3) {
return this.MouseEventOutside$I$Z(var1, var2);
} else {
this.mWasHit=false;
switch (var1) {
case 0:
case 1:
var var4=(this.mFramePanel.mThisPt.x - this.x) * 0.005;
this.ControlMessage$MultiDOF_Prog10_Multiforced_CFrame$I$D(this, 2, var4);
break;
case 2:
if (this.mDisplayXPos != this.mXPos || this.mDisplayFPos != this.mFPos ) {
this.SetXF$I$I(this.mDisplayXPos, this.mDisplayFPos);
}}
return true;
}}});

Clazz.newMeth(C$, 'MouseToIndex$I',  function (var1) {
if (this.mElements == null ) {
return 0;
} else {
var var3=this.mElements.size$();
for (var var2=1; var2 <= var3; var2++) {
var var4=this.GetSMD$I(var2);
if (var4.InVerticalBand$I(var1)) {
return var2;
}}
return 0;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("Complex.Prog9.Transverse"),I$=[[0,'java.awt.Point','java.awt.Rectangle','java.awt.TextField','javax.swing.Timer','java.awt.Color','Complex.Prog9.Transverse.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameSmallControl", null, 'Complex.Prog9.Transverse.CFramePicture', ['java.awt.event.ActionListener', 'java.awt.event.KeyListener']);

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mTextEditable','mIntegerMode'],'D',['mMin','mValue','mMax','mOldValue','mDeltaPerSec'],'I',['mSelection','mCode','mLabelWidth','mLabelHeight'],'S',['mUnits'],'O',['mControlledFrame','Complex.Prog9.Transverse.CFrame','mSelStart','java.util.Date','mDLabelPos','java.awt.Point','mTextField','java.awt.TextField','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, 'c$$Complex_Prog9_Transverse_CFramePanel$Complex_Prog9_Transverse_CFrame$I$I$I$D$D$D$S',  function (var1, var2, var3, var4, var5, var6, var8, var10, var12) {
;C$.superclazz.c$$Complex_Prog9_Transverse_CFramePanel$I$I$I$I$java_awt_Image$Z.apply(this,[var1, var4, var5, 0, 0, var1.mApplet.getImage$java_net_URL$S(var1.mApplet.getCodeBase$(), "BrianControl.gif"), false]);C$.$init$.apply(this);
this.mControlledFrame=var2;
this.mCode=var3;
this.mUnits=var12;
this.width=this.mImage.getWidth$java_awt_image_ImageObserver(var1);
this.height=this.mImage.getHeight$java_awt_image_ImageObserver(var1);
this.mMin=var6;
this.mValue=var8;
this.mMax=var10;
this.BroadcastValue$();
}, 1);

Clazz.newMeth(C$, 'SetLabelOffset$I$I',  function (var1, var2) {
this.mDLabelPos=Clazz.new_($I$(1,1).c$$I$I,[var1, var2]);
this.repaint$();
});

Clazz.newMeth(C$, 'SetTextEditable$Z',  function (var1) {
this.mTextEditable=var1;
});

Clazz.newMeth(C$, 'SetIntegerMode$Z',  function (var1) {
this.mIntegerMode=var1;
this.ConstrainValue$();
this.BroadcastValue$();
});

Clazz.newMeth(C$, 'keyPressed$java_awt_event_KeyEvent',  function (var1) {
if (var1.getKeyCode$() == 10) {
var var2=this.mTextField.getText$();
var var3=var2.length$();
while (true){
var var4=var2.substring$I$I(0, var3);
try {
var var5=java.lang.Double.parseDouble$S(var4);
this.mValue=var5;
break;
} catch (var6) {
if (Clazz.exceptionOf(var6,"NumberFormatException")){
if (--var3 <= 0) {
return;
}} else {
throw var6;
}
}
}
this.ConstrainValue$();
this.mTextField.removeKeyListener$java_awt_event_KeyListener(this);
this.mFramePanel.remove$java_awt_Component(this.mTextField);
this.mTextField=null;
this.BroadcastValue$();
}});

Clazz.newMeth(C$, 'keyTyped$java_awt_event_KeyEvent',  function (var1) {
});

Clazz.newMeth(C$, 'keyReleased$java_awt_event_KeyEvent',  function (var1) {
});

Clazz.newMeth(C$, 'GridToRect$I',  function (var1) {
this.width=this.mImage.getWidth$java_awt_image_ImageObserver(this.mFramePanel);
this.height=this.mImage.getHeight$java_awt_image_ImageObserver(this.mFramePanel);
if (this.width >= 0 && this.height >= 0 ) {
switch (var1) {
case 1:
return Clazz.new_([0, 0, this.width, (this.height/2|0)],$I$(2,1).c$$I$I$I$I);
case 2:
return Clazz.new_([0, (this.height/2|0), this.width, (this.height/2|0)],$I$(2,1).c$$I$I$I$I);
case 3:
if (this.mDLabelPos == null ) {
return null;
}return Clazz.new_($I$(2,1).c$$I$I$I$I,[this.mDLabelPos.x, this.mDLabelPos.y - this.mLabelHeight, this.mLabelWidth, this.mLabelHeight]);
default:
return null;
}
} else {
return null;
}});

Clazz.newMeth(C$, 'GetSelection$java_awt_Point',  function (var1) {
for (var var2=1; var2 <= 3; var2++) {
var var3=this.GridToRect$I(var2);
if (var3 == null ) {
return 0;
}if (var3.contains$I$I(var1.x, var1.y)) {
return var2;
}}
return 0;
});

Clazz.newMeth(C$, 'GetSelection$I$I',  function (var1, var2) {
var var3=Clazz.new_($I$(1,1).c$$I$I,[var1, var2]);
return this.GetSelection$java_awt_Point(var3);
});

Clazz.newMeth(C$, 'NearlyEqual$D$D',  function (var0, var2) {
return Math.abs(var2 - var0) < 1.0E-10 ;
}, 1);

Clazz.newMeth(C$, 'nns$D$I',  function (var0, var2) {
if (var2 <= 0) {
var2=1;
}if (C$.NearlyEqual$D$D(var0, 0.0)) {
return "0";
} else if (var0 < 0.0 ) {
return "-" + C$.nns$D$I(-var0, var2);
} else {
var var3=Math.floor(C$.log10$D(var0));
var var5=Math.pow(10.0, var3 - var2 + 1.0);
var var7=Math.round$D(var0 / var5);
var var9=String.valueOf$D(var7 * var5);
while (var9.length$() > 1 && var9.indexOf$I(46) > -1 ){
var var10=false;
var var11;
for (var11=var9.length$() - 1; var9.charAt$I(var11) == "0"; var10=true) {
--var11;
}
if (var10) {
var9=var9.substring$I$I(0, var11 + 1);
}var var12=var9.substring$I$I(0, var11);
var var13;
try {
var13=java.lang.Double.parseDouble$S(var12);
} catch (var14) {
if (Clazz.exceptionOf(var14,"NumberFormatException")){
break;
} else {
throw var14;
}
}
if (Math.abs(var0 - var13) > var5 ) {
break;
}var9=var12;
}
return var9;
}}, 1);

Clazz.newMeth(C$, 'nns$D',  function (var0) {
return C$.nns$D$I(var0, 4);
}, 1);

Clazz.newMeth(C$, 'log10$D',  function (var0) {
return Math.log(var0) / Math.log(10.0);
}, 1);

Clazz.newMeth(C$, 'NewSelection$I',  function (var1) {
this.mSelection=var1;
this.mSelStart=Clazz.new_(java.util.Date);
this.mOldValue=this.mValue;
switch (this.mSelection) {
case 0:
case 3:
this.mDeltaPerSec=0.0;
break;
case 1:
case 2:
default:
var var2=Math.floor(C$.log10$D(Math.abs(this.mMax - this.mMin)));
this.mDeltaPerSec=Math.pow(10.0, var2 - 2.0);
if (this.mSelection == 2) {
this.mDeltaPerSec=-this.mDeltaPerSec;
}this.NewValue$();
}
this.repaint$();
});

Clazz.newMeth(C$, 'NewValue$',  function () {
if (this.mSelStart != null ) {
var var1=this.mSelStart.getTime$();
var var3=Clazz.new_(java.util.Date);
var var4=var3.getTime$();
var var6=(Long.$sub(var4,var1)) / 1000.0;
var var8=var6 > 1.0 ;
var var9;
var var11;
if (this.mIntegerMode) {
if (this.mDeltaPerSec > 0.0 ) {
var9=1.0;
} else {
var9=-1.0;
}var11=1.0;
} else if (var8) {
var9=this.mDeltaPerSec * 10.0 * var6 ;
var11=this.mDeltaPerSec;
} else {
var9=this.mDeltaPerSec * var6;
var11=this.mDeltaPerSec / 10.0;
}this.mValue=this.mOldValue + var9;
this.mValue=C$.MyRound$D$D(this.mValue, var11);
this.ConstrainValue$();
this.BroadcastValue$();
}});

Clazz.newMeth(C$, 'MyRound$D$D',  function (var0, var2) {
if (var2 == 0.0 ) {
return var0;
} else {
var2=Math.abs(var2);
return Math.round$D(var0 / var2) * var2;
}}, 1);

Clazz.newMeth(C$, 'ConstrainValue$',  function () {
if (this.mIntegerMode) {
this.mValue=Long.$dval(Math.round$D(this.mValue));
}if (this.mValue < this.mMin ) {
this.mValue=this.mMin;
} else if (this.mMax < this.mValue ) {
this.mValue=this.mMax;
}});

Clazz.newMeth(C$, 'BroadcastValue$',  function () {
if (this.mControlledFrame != null ) {
this.mControlledFrame.ControlMessage$Complex_Prog9_Transverse_CFrame$I$D(this, this.mCode, this.mValue);
}this.repaint$();
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
C$.superclazz.prototype.MouseEvent$I$Z.apply(this, [var1, var2]);
var var3=this.GlobalToLocal$java_awt_Point(this.mFramePanel.mThisPt);
switch (var1) {
case 0:
if (!this.mWasHit) {
return false;
} else if (var2) {
return false;
} else {
this.NewSelection$I(this.GetSelection$I$I(var3.x, var3.y));
if (this.mSelection == 3 && this.mTextField == null  ) {
if (this.mTextEditable) {
this.mTextField=Clazz.new_($I$(3,1));
this.mFramePanel.add$java_awt_Component(this.mTextField);
this.mTextField.addKeyListener$java_awt_event_KeyListener(this);
var var5=this.mFramePanel.getInsets$();
this.mTextField.setBounds$I$I$I$I(var5.left + this.x + this.mDLabelPos.x , var5.top + this.y - 2, this.mLabelWidth + 8, 20);
this.mTextField.setText$S(this.GetLabelString$());
} else {
this.mTextField=null;
}this.BroadcastValue$();
} else {
this.mTimer=Clazz.new_($I$(4,1).c$$I$java_awt_event_ActionListener,[100, this]);
this.mTimer.start$();
}return true;
}case 1:
if (!this.mWasHit) {
this.NewSelection$I(0);
return true;
} else if (this.mSelection == 0) {
return false;
} else {
var var4=this.GetSelection$I$I(var3.x, var3.y);
if (var4 == this.mSelection) {
return false;
}this.NewSelection$I(var4);
return true;
}case 2:
this.NewSelection$I(0);
return true;
default:
return false;
}
});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
C$.superclazz.prototype.Frame$java_awt_Graphics.apply(this, [var1]);
var var2=this.LocalToGlobalR$java_awt_Rectangle(this.GridToRect$I(2));
if (this.mSelection != 0) {
var var3=this.LocalToGlobalR$java_awt_Rectangle(this.GridToRect$I(this.mSelection));
var1.setXORMode$java_awt_Color($I$(5).black);
var1.fillRect$I$I$I$I(var3.x, var3.y, var3.width, var3.height);
var1.setPaintMode$();
}this.FrameValue$java_awt_Graphics(var1);
this.width=var2.x + var2.width + this.mLabelWidth ;
this.height=var2.y + var2.height;
});

Clazz.newMeth(C$, 'GetLabelString$',  function () {
return C$.nns$D(this.mValue) + " " + this.mUnits ;
});

Clazz.newMeth(C$, 'FrameValue$java_awt_Graphics',  function (var1) {
this.mLabelWidth=0;
this.mLabelHeight=0;
if (this.mDLabelPos != null ) {
var var2=this.GridToRect$I(3);
if (var2 != null ) {
var var3=Clazz.new_($I$(1,1).c$$I$I,[var2.x, var2.y]);
var var4=this.LocalToGlobal$java_awt_Point(var3);
var2.x=var4.x;
var2.y=var4.y;
var1.setColor$java_awt_Color($I$(6,"RatColor$java_awt_Color$java_awt_Color$D",[$I$(5).black, $I$(5).white, 0.6]));
if (this.mSelection == 3) {
var1.fillRect$I$I$I$I(var2.x, var2.y, var2.width, var2.height);
} else {
var1.drawRect$I$I$I$I(var2.x, var2.y, var2.width, var2.height);
}var var5=this.LocalToGlobal$java_awt_Point(this.mDLabelPos);
var1.setColor$java_awt_Color($I$(5).black);
var var6=this.GetLabelString$();
this.mLabelWidth=$I$(6).DrawString$java_awt_Graphics$S$I$I(var1, var6, var5.x, var5.y) - var5.x;
this.mLabelHeight=12;
var1.setColor$java_awt_Color($I$(5).black);
}}});

Clazz.newMeth(C$, 'actionPerformed$java_awt_event_ActionEvent',  function (e) {
if (this.mSelection != 0) {
this.NewValue$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

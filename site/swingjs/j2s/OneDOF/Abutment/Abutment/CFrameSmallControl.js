(function(){var P$=Clazz.newPackage("OneDOF.Abutment.Abutment"),I$=[[0,'java.awt.Point','java.awt.Rectangle','java.awt.TextField','javax.swing.Timer','java.awt.Color','OneDOF.Abutment.Abutment.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameSmallControl", null, 'OneDOF.Abutment.Abutment.CFramePicture', ['java.awt.event.ActionListener', 'java.awt.event.KeyListener']);

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mTextEditable','mIntegerMode'],'D',['mMin','mValue','mMax','mOldValue','mDeltaPerSec'],'I',['mSelection','mCode','mLabelWidth','mLabelHeight'],'S',['mUnits'],'O',['mControlledFrame','OneDOF.Abutment.Abutment.CFrame','mSelStart','java.util.Date','mDLabelPos','java.awt.Point','mTextField','java.awt.TextField','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, 'c$$OneDOF_Abutment_Abutment_CFramePanel$OneDOF_Abutment_Abutment_CFrame$I$I$I$D$D$D$S',  function (thePanel, controlThis, code, xx, yy, min, val, max, units) {
;C$.superclazz.c$$OneDOF_Abutment_Abutment_CFramePanel$I$I$I$I$java_awt_Image$Z.apply(this,[thePanel, xx, yy, 0, 0, thePanel.mApplet.getImage$java_net_URL$S(thePanel.mApplet.getCodeBase$(), "BrianControl.gif"), false]);C$.$init$.apply(this);
this.mControlledFrame=controlThis;
this.mCode=code;
this.mUnits=units;
this.width=this.mImage.getWidth$java_awt_image_ImageObserver(thePanel);
this.height=this.mImage.getHeight$java_awt_image_ImageObserver(thePanel);
this.mMin=min;
this.mValue=val;
this.mMax=max;
this.BroadcastValue$();
}, 1);

Clazz.newMeth(C$, 'SetLabelOffset$I$I',  function (dx, dy) {
this.mDLabelPos=Clazz.new_($I$(1,1).c$$I$I,[dx, dy]);
this.repaint$();
});

Clazz.newMeth(C$, 'SetTextEditable$Z',  function (editable) {
this.mTextEditable=editable;
});

Clazz.newMeth(C$, 'SetIntegerMode$Z',  function (intmode) {
this.mIntegerMode=intmode;
this.ConstrainValue$();
this.BroadcastValue$();
});

Clazz.newMeth(C$, 'keyPressed$java_awt_event_KeyEvent',  function (evt) {
if (evt.getKeyCode$() == 10) {
var text=this.mTextField.getText$();
var end=text.length$();
while (true){
var numStr=text.substring$I$I(0, end);
try {
var newVal=java.lang.Double.parseDouble$S(numStr);
this.mValue=newVal;
break;
} catch (var6) {
if (Clazz.exceptionOf(var6,"NumberFormatException")){
if (--end <= 0) {
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

Clazz.newMeth(C$, 'keyTyped$java_awt_event_KeyEvent',  function (evt) {
});

Clazz.newMeth(C$, 'keyReleased$java_awt_event_KeyEvent',  function (evt) {
});

Clazz.newMeth(C$, 'GridToRect$I',  function (which) {
this.width=this.mImage.getWidth$java_awt_image_ImageObserver(this.mFramePanel);
this.height=this.mImage.getHeight$java_awt_image_ImageObserver(this.mFramePanel);
if (this.width >= 0 && this.height >= 0 ) {
switch (which) {
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

Clazz.newMeth(C$, 'GetSelection$java_awt_Point',  function (p) {
for (var i=1; i <= 3; i++) {
var r=this.GridToRect$I(i);
if (r == null ) {
return 0;
}if (r.contains$I$I(p.x, p.y)) {
return i;
}}
return 0;
});

Clazz.newMeth(C$, 'GetSelection$I$I',  function (xx, yy) {
var p=Clazz.new_($I$(1,1).c$$I$I,[xx, yy]);
return this.GetSelection$java_awt_Point(p);
});

Clazz.newMeth(C$, 'NearlyEqual$D$D',  function (d1, d2) {
return Math.abs(d2 - d1) < 1.0E-10 ;
}, 1);

Clazz.newMeth(C$, 'nns$D$I',  function (arg, sig) {
if (sig <= 0) {
sig=1;
}if (C$.NearlyEqual$D$D(arg, 0.0)) {
return "0";
} else if (arg < 0.0 ) {
return "-" + C$.nns$D$I(-arg, sig);
} else {
var oom=Math.floor(C$.log10$D(arg));
var power=Math.pow(10.0, oom - sig + 1.0);
var intArg=Math.round$D(arg / power);
var result=String.valueOf$D(intArg * power);
while (result.length$() > 1 && result.indexOf$I(46) > -1 ){
var trimmed=false;
var lastChar;
for (lastChar=result.length$() - 1; result.charAt$I(lastChar) == "0"; trimmed=true) {
--lastChar;
}
if (trimmed) {
result=result.substring$I$I(0, lastChar + 1);
}var shortStr=result.substring$I$I(0, lastChar);
var newNum;
try {
newNum=java.lang.Double.parseDouble$S(shortStr);
} catch (var14) {
if (Clazz.exceptionOf(var14,"NumberFormatException")){
break;
} else {
throw var14;
}
}
if (Math.abs(arg - newNum) > power ) {
break;
}result=shortStr;
}
return result;
}}, 1);

Clazz.newMeth(C$, 'nns$D',  function (arg) {
return C$.nns$D$I(arg, 4);
}, 1);

Clazz.newMeth(C$, 'log10$D',  function (arg) {
return Math.log(arg) / Math.log(10.0);
}, 1);

Clazz.newMeth(C$, 'NewSelection$I',  function (newSel) {
this.mSelection=newSel;
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
var oom=Math.floor(C$.log10$D(Math.abs(this.mMax - this.mMin)));
this.mDeltaPerSec=Math.pow(10.0, oom - 2.0);
if (this.mSelection == 2) {
this.mDeltaPerSec=-this.mDeltaPerSec;
}this.NewValue$();
}
this.repaint$();
});

Clazz.newMeth(C$, 'NewValue$',  function () {
if (this.mSelStart != null ) {
var startTime=this.mSelStart.getTime$();
var nowDate=Clazz.new_(java.util.Date);
var nowTime=nowDate.getTime$();
var dT=(Long.$sub(nowTime,startTime)) / 1000.0;
var turbo=dT > 1.0 ;
var delta;
var quant;
if (this.mIntegerMode) {
if (this.mDeltaPerSec > 0.0 ) {
delta=1.0;
} else {
delta=-1.0;
}quant=1.0;
} else if (turbo) {
delta=this.mDeltaPerSec * 10.0 * dT ;
quant=this.mDeltaPerSec;
} else {
delta=this.mDeltaPerSec * dT;
quant=this.mDeltaPerSec / 10.0;
}this.mValue=this.mOldValue + delta;
this.mValue=C$.MyRound$D$D(this.mValue, quant);
this.ConstrainValue$();
this.BroadcastValue$();
}});

Clazz.newMeth(C$, 'MyRound$D$D',  function (val, quant) {
if (quant == 0.0 ) {
return val;
} else {
quant=Math.abs(quant);
return Math.round$D(val / quant) * quant;
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
this.mControlledFrame.ControlMessage$OneDOF_Abutment_Abutment_CFrame$I$D(this, this.mCode, this.mValue);
}this.repaint$();
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevHit) {
C$.superclazz.prototype.MouseEvent$I$Z.apply(this, [code, prevHit]);
var thisPt=this.GlobalToLocal$java_awt_Point(this.mFramePanel.mThisPt);
switch (code) {
case 0:
if (!this.mWasHit) {
return false;
} else if (prevHit) {
return false;
} else {
this.NewSelection$I(this.GetSelection$I$I(thisPt.x, thisPt.y));
if (this.mSelection == 3 && this.mTextField == null  ) {
if (this.mTextEditable) {
this.mTextField=Clazz.new_($I$(3,1));
this.mFramePanel.add$java_awt_Component(this.mTextField);
this.mTextField.addKeyListener$java_awt_event_KeyListener(this);
var insets=this.mFramePanel.getInsets$();
this.mTextField.setBounds$I$I$I$I(insets.left + this.x + this.mDLabelPos.x , insets.top + this.y - 2, this.mLabelWidth + 8, 20);
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
var newSel=this.GetSelection$I$I(thisPt.x, thisPt.y);
if (newSel == this.mSelection) {
return false;
}this.NewSelection$I(newSel);
return true;
}case 2:
this.NewSelection$I(0);
return true;
default:
return false;
}
});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
C$.superclazz.prototype.Frame$java_awt_Graphics.apply(this, [g]);
var downRect=this.LocalToGlobalR$java_awt_Rectangle(this.GridToRect$I(2));
if (this.mSelection != 0) {
var selRect=this.LocalToGlobalR$java_awt_Rectangle(this.GridToRect$I(this.mSelection));
g.setXORMode$java_awt_Color($I$(5).black);
g.fillRect$I$I$I$I(selRect.x, selRect.y, selRect.width, selRect.height);
g.setPaintMode$();
}this.FrameValue$java_awt_Graphics(g);
this.width=downRect.x + downRect.width + this.mLabelWidth ;
this.height=downRect.y + downRect.height;
});

Clazz.newMeth(C$, 'GetLabelString$',  function () {
return C$.nns$D(this.mValue) + " " + this.mUnits ;
});

Clazz.newMeth(C$, 'FrameValue$java_awt_Graphics',  function (g) {
this.mLabelWidth=0;
this.mLabelHeight=0;
if (this.mDLabelPos != null ) {
var r=this.GridToRect$I(3);
if (r != null ) {
var localPt=Clazz.new_($I$(1,1).c$$I$I,[r.x, r.y]);
var absPt=this.LocalToGlobal$java_awt_Point(localPt);
r.x=absPt.x;
r.y=absPt.y;
g.setColor$java_awt_Color($I$(6,"RatColor$java_awt_Color$java_awt_Color$D",[$I$(5).black, $I$(5).white, 0.6]));
if (this.mSelection == 3) {
g.fillRect$I$I$I$I(r.x, r.y, r.width, r.height);
} else {
g.drawRect$I$I$I$I(r.x, r.y, r.width, r.height);
}var absPos=this.LocalToGlobal$java_awt_Point(this.mDLabelPos);
g.setColor$java_awt_Color($I$(5).black);
var lab_str=this.GetLabelString$();
this.mLabelWidth=$I$(6).DrawString$java_awt_Graphics$S$I$I(g, lab_str, absPos.x, absPos.y) - absPos.x;
this.mLabelHeight=12;
g.setColor$java_awt_Color($I$(5).black);
}}});

Clazz.newMeth(C$, 'actionPerformed$java_awt_event_ActionEvent',  function (e) {
if (this.mSelection != 0) {
this.NewValue$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

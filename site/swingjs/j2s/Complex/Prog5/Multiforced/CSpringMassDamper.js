(function(){var P$=Clazz.newPackage("Complex.Prog5.Multiforced"),I$=[[0,'java.awt.Color','Complex.Prog5.Multiforced.CInputDialog']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CSpringMassDamper", null, 'Complex.Prog5.Multiforced.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mViscous','mAbutment'],'D',['mMass','mSpringConstant','mDampingConstant','mMassAmp','mMassPhase'],'I',['mIndex'],'O',['mFrameGraph','Complex.Prog5.Multiforced.CFrameGraph','mInputFrame','Complex.Prog5.Multiforced.CInputDialog']]]

Clazz.newMeth(C$, 'c$$Complex_Prog5_Multiforced_CFramePanel$Complex_Prog5_Multiforced_CFrameGraph$D$D$D$Z$Z',  function (var1, var2, var3, var5, var7, var9, var10) {
;C$.superclazz.c$$Complex_Prog5_Multiforced_CFramePanel.apply(this,[var1]);C$.$init$.apply(this);
this.mFrameGraph=var2;
this.mMass=var3;
this.mSpringConstant=var5;
this.mDampingConstant=var7;
this.mViscous=var9;
this.mAbutment=var10;
}, 1);

Clazz.newMeth(C$, 'IsAbutment$',  function () {
return this.mAbutment;
});

Clazz.newMeth(C$, 'AtEnd$',  function () {
var var1=this.mFrameGraph.mElements.size$();
return this.mIndex == 1 || this.mIndex == var1 ;
});

Clazz.newMeth(C$, 'SetAbutment$Z',  function (var1) {
this.mAbutment=var1;
});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var var2=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (this.IsAbutment$()) {
var1.setColor$java_awt_Color($I$(1).orange);
} else {
var1.setColor$java_awt_Color(var2);
}var1.fillRect$I$I$I$I(this.x + this.width - 15, this.y, 15, this.height);
var1.setColor$java_awt_Color($I$(1).black);
if (this.mIndex > 1) {
this.DrawSpringAndDamper$java_awt_Graphics(var1);
}if (this.mFrameGraph.mSelectedSMD === this ) {
this.DrawSelRect$java_awt_Graphics(var1);
}});

Clazz.newMeth(C$, 'DrawSpringAndDamper$java_awt_Graphics',  function (var1) {
var var2=this.y + 8;
var1.drawLine$I$I$I$I(this.x, var2, this.x + 2, var2 - 2);
for (var var3=1; var3 < 6; var3++) {
var1.drawLine$I$I$I$I(this.x + 2 + (var3 - 1) * 8 , var2 - 2, this.x + 2 + (var3 - 1) * 8  + 4, var2 + 2);
}
for (var var5=1; var5 < 5; var5++) {
var1.drawLine$I$I$I$I(this.x + 6 + (var5 - 1) * 8 , var2 + 2, this.x + 6 + (var5 - 1) * 8  + 4, var2 - 2);
}
var1.drawLine$I$I$I$I(this.x + 40 - 2, var2 + 2, this.x + 40, var2);
var2=this.y + 22;
var1.drawLine$I$I$I$I(this.x, var2, this.x + 19, var2);
var1.drawLine$I$I$I$I(this.x + 19, var2 - 2, this.x + 19, var2 + 2);
var1.drawLine$I$I$I$I(this.x + 16, var2 - 4, this.x + 22, var2 - 4);
var1.drawLine$I$I$I$I(this.x + 22, var2 - 4, this.x + 22, var2 + 4);
var1.drawLine$I$I$I$I(this.x + 16, var2 + 4, this.x + 22, var2 + 4);
var1.drawLine$I$I$I$I(this.x + 22, var2, this.x + 40, var2);
});

Clazz.newMeth(C$, 'DrawSelRect$java_awt_Graphics',  function (var1) {
var1.setColor$java_awt_Color($I$(1).blue);
var1.drawRect$I$I$I$I(this.x, this.y, this.width, this.height);
var1.drawRect$I$I$I$I(this.x + 1, this.y + 1, this.width - 2, this.height - 2);
var1.setColor$java_awt_Color($I$(1).black);
});

Clazz.newMeth(C$, 'DrawSmallArrow$java_awt_Graphics$I$S',  function (var1, var2, var3) {
var var4=this.x + this.width - 7;
var1.drawLine$I$I$I$I(var4, var2, var4, var2 + 10);
var1.drawLine$I$I$I$I(var4, var2 + 5, var4 + 10, var2 + 5);
var1.drawLine$I$I$I$I(var4 + 10 - 2, var2 + 3, var4 + 10, var2 + 5);
var1.drawLine$I$I$I$I(var4 + 10 - 2, var2 + 7, var4 + 10, var2 + 5);
var1.drawString$S$I$I(var3, var4 + 12, var2 + 10);
});

Clazz.newMeth(C$, 'ControlMessage$Complex_Prog5_Multiforced_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mInputFrame=Clazz.new_([this, "Edit subsystem " + (this.mIndex - 1)],$I$(2,1).c$$Complex_Prog5_Multiforced_CSpringMassDamper$S);
this.mInputFrame.setLocation$I$I(100, 100);
this.mInputFrame.setSize$I$I(200, 130);
this.mInputFrame.setVisible$Z(true);
case 2:
case 3:
case 4:
case 5:
default:
break;
case 6:
this.mFrameGraph.ControlMessage$Complex_Prog5_Multiforced_CFrame$I$D(this, 6, var3);
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
this.mWasHit=this.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
if (!this.mWasHit) {
return false;
} else {
switch (var1) {
case 0:
this.mFrameGraph.SetSelection$Complex_Prog5_Multiforced_CSpringMassDamper(this);
case 1:
case 2:
case 3:
default:
break;
case 4:
this.ControlMessage$Complex_Prog5_Multiforced_CFrame$I$D(this, 1, 0.0);
}
return true;
}});

Clazz.newMeth(C$, 'InVerticalBand$I',  function (var1) {
return var1 < this.x ? false : this.x + this.width >= var1;
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("TwoDOF.Abutmentsin_2DOF.Forced"),I$=[[0,'java.awt.Point','java.awt.Rectangle']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrame", null, 'java.awt.Rectangle');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mWasHit'],'O',['mFramePanel','TwoDOF.Abutmentsin_2DOF.Forced.CFramePanel']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Abutmentsin_2DOF_Forced_CFramePanel',  function (var1) {
;C$.superclazz.c$$I$I$I$I.apply(this,[0, 0, 0, 0]);C$.$init$.apply(this);
this.mFramePanel=var1;
this.mFramePanel.AddFrame$TwoDOF_Abutmentsin_2DOF_Forced_CFrame(this);
}, 1);

Clazz.newMeth(C$, 'c$$TwoDOF_Abutmentsin_2DOF_Forced_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$I$I$I$I.apply(this,[var2, var3, var4, var5]);C$.$init$.apply(this);
this.mFramePanel=var1;
this.mFramePanel.AddFrame$TwoDOF_Abutmentsin_2DOF_Forced_CFrame(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
this.mWasHit=this.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
return false;
});

Clazz.newMeth(C$, 'GlobalToLocal$java_awt_Point',  function (var1) {
return var1 == null  ? null : Clazz.new_($I$(1,1).c$$I$I,[var1.x - this.x, var1.y - this.y]);
});

Clazz.newMeth(C$, 'GlobalToLocalR$java_awt_Rectangle',  function (var1) {
return var1 == null  ? null : Clazz.new_($I$(2,1).c$$I$I$I$I,[var1.x - this.x, var1.y - this.y, var1.width, var1.height]);
});

Clazz.newMeth(C$, 'LocalToGlobal$java_awt_Point',  function (var1) {
return var1 == null  ? null : Clazz.new_($I$(1,1).c$$I$I,[var1.x + this.x, var1.y + this.y]);
});

Clazz.newMeth(C$, 'LocalToGlobalR$java_awt_Rectangle',  function (var1) {
return var1 == null  ? null : Clazz.new_($I$(2,1).c$$I$I$I$I,[var1.x + this.x, var1.y + this.y, var1.width, var1.height]);
});

Clazz.newMeth(C$, 'repaint$',  function () {
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$, 'repaint$J',  function (var1) {
this.mFramePanel.repaint$J(var1);
});

Clazz.newMeth(C$, 'ControlMessage$I$D',  function (var1, var2) {
this.ControlMessage$TwoDOF_Abutmentsin_2DOF_Forced_CFrame$I$D(null, var1, var2);
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Abutmentsin_2DOF_Forced_CFrame$I$D',  function (var1, var2, var3) {
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

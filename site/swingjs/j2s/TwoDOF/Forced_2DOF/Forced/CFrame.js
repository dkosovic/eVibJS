(function(){var P$=Clazz.newPackage("TwoDOF.Forced_2DOF.Forced"),I$=[[0,'java.awt.Point','java.awt.Rectangle']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrame", null, 'java.awt.Rectangle');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['Z',['mWasHit'],'O',['mFramePanel','TwoDOF.Forced_2DOF.Forced.CFramePanel']]]

Clazz.newMeth(C$, 'c$$TwoDOF_Forced_2DOF_Forced_CFramePanel',  function (thePanel) {
;C$.superclazz.c$$I$I$I$I.apply(this,[0, 0, 0, 0]);C$.$init$.apply(this);
this.mFramePanel=thePanel;
this.mFramePanel.AddFrame$TwoDOF_Forced_2DOF_Forced_CFrame(this);
}, 1);

Clazz.newMeth(C$, 'c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I',  function (thePanel, xx, yy, ww, hh) {
;C$.superclazz.c$$I$I$I$I.apply(this,[xx, yy, ww, hh]);C$.$init$.apply(this);
this.mFramePanel=thePanel;
this.mFramePanel.AddFrame$TwoDOF_Forced_2DOF_Forced_CFrame(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevHit) {
this.mWasHit=this.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y);
return false;
});

Clazz.newMeth(C$, 'GlobalToLocal$java_awt_Point',  function (glob) {
return glob == null  ? null : Clazz.new_($I$(1,1).c$$I$I,[glob.x - this.x, glob.y - this.y]);
});

Clazz.newMeth(C$, 'GlobalToLocalR$java_awt_Rectangle',  function (glob) {
return glob == null  ? null : Clazz.new_($I$(2,1).c$$I$I$I$I,[glob.x - this.x, glob.y - this.y, glob.width, glob.height]);
});

Clazz.newMeth(C$, 'LocalToGlobal$java_awt_Point',  function (loc) {
return loc == null  ? null : Clazz.new_($I$(1,1).c$$I$I,[loc.x + this.x, loc.y + this.y]);
});

Clazz.newMeth(C$, 'LocalToGlobalR$java_awt_Rectangle',  function (loc) {
return loc == null  ? null : Clazz.new_($I$(2,1).c$$I$I$I$I,[loc.x + this.x, loc.y + this.y, loc.width, loc.height]);
});

Clazz.newMeth(C$, 'repaint$',  function () {
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$, 'repaint$J',  function (delay) {
this.mFramePanel.repaint$J(delay);
});

Clazz.newMeth(C$, 'ControlMessage$I$D',  function (code, val) {
this.ControlMessage$TwoDOF_Forced_2DOF_Forced_CFrame$I$D(null, code, val);
});

Clazz.newMeth(C$, 'ControlMessage$TwoDOF_Forced_2DOF_Forced_CFrame$I$D',  function (controller, code, val) {
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

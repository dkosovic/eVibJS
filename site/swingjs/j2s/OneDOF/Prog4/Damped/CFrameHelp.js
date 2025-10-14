(function(){var P$=Clazz.newPackage("OneDOF.Prog4.Damped"),I$=[[0,'java.awt.Point','java.util.StringTokenizer','java.awt.Polygon','java.awt.Color','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameHelp", null, 'OneDOF.Prog4.Damped.CFrame', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mDelay=1.5;
},1);

C$.$fields$=[['Z',['mShowtime'],'D',['mDelay'],'S',['mMessage'],'O',['mTimer','javax.swing.Timer','mArrowHead','java.awt.Point']]]

Clazz.newMeth(C$, 'c$$OneDOF_Prog4_Damped_CFramePanel$I$I$I$I$S',  function (thePanel, xx, yy, ww, hh, message) {
;C$.superclazz.c$$OneDOF_Prog4_Damped_CFramePanel$I$I$I$I.apply(this,[thePanel, xx, yy, ww, hh]);C$.$init$.apply(this);
this.mMessage=message;
this.DefaultArrowPos$();
}, 1);

Clazz.newMeth(C$, 'DefaultArrowPos$',  function () {
this.mArrowHead=Clazz.new_([this.x + (this.width/2|0), this.y + (this.height/2|0)],$I$(1,1).c$$I$I);
});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (g) {
g.setPaintMode$();
if (this.mShowtime) {
var mArrow;
if (this.mArrowHead == null ) {
mArrow=this.mFramePanel.mLastPt;
} else {
mArrow=this.mArrowHead;
}var wid=this.mFramePanel.getSize$().width;
var hei=this.mFramePanel.getSize$().height;
var kLineSpacing=12;
var kLineGap=5;
var gap1=10;
var gap2=20;
var ww=0;
var hh=2 * kLineGap;
var st=Clazz.new_($I$(2,1).c$$S$S,[this.mMessage, "\n"]);
while (st.hasMoreTokens$()){
hh+=kLineSpacing;
var thisWidth=g.getFontMetrics$().stringWidth$S(st.nextToken$());
if (thisWidth > ww) {
ww=thisWidth;
}}
ww+=2 * gap1;
var xMult=1;
var yMult=1;
if (mArrow.x + gap1 + ww  > wid) {
xMult=-1;
}if (mArrow.y + gap1 + hh  > hei) {
yMult=-1;
}var p=Clazz.new_($I$(3,1));
p.addPoint$I$I(mArrow.x, mArrow.y);
p.addPoint$I$I(mArrow.x + xMult * gap1, mArrow.y + yMult * gap2);
p.addPoint$I$I(mArrow.x + xMult * gap1, mArrow.y + yMult * (gap1 + hh));
p.addPoint$I$I(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * (gap1 + hh));
p.addPoint$I$I(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * gap1);
p.addPoint$I$I(mArrow.x + xMult * gap2, mArrow.y + yMult * gap1);
p.addPoint$I$I(mArrow.x, mArrow.y);
g.setColor$java_awt_Color($I$(4).white);
g.fillPolygon$java_awt_Polygon(p);
g.setColor$java_awt_Color($I$(4).black);
g.drawPolygon$java_awt_Polygon(p);
var tx;
if (xMult > 0) {
tx=mArrow.x + 2 * gap1;
} else {
tx=mArrow.x - ww;
}var ty;
if (yMult > 0) {
ty=mArrow.y + gap1 + kLineGap + kLineSpacing ;
} else {
ty=mArrow.y - gap1 - hh  + kLineGap + kLineSpacing;
}var tokenNo=-1;
st=Clazz.new_($I$(2,1).c$$S$S,[this.mMessage, "\n"]);
while (st.hasMoreTokens$()){
g.drawString$S$I$I(st.nextToken$(), tx, ty + ++tokenNo * kLineSpacing);
}
}});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (code, prevHit) {
this.mWasHit=false;
if (this.mShowtime) {
this.repaint$();
}this.mShowtime=false;
this.mTimer=null;
if (code != 3) {
return false;
} else if (!this.contains$I$I(this.mFramePanel.mThisPt.x, this.mFramePanel.mThisPt.y)) {
return false;
} else {
this.mTimer=Clazz.new_([((this.mDelay * 1000)|0), this],$I$(5,1).c$$I$java_awt_event_ActionListener);
this.mTimer.start$();
return true;
}});

Clazz.newMeth(C$, 'actionPerformed$java_awt_event_ActionEvent',  function (e) {
if (this.mTimer != null ) {
this.mShowtime=true;
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

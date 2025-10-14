(function(){var P$=Clazz.newPackage("Complex.Prog10.Transverse"),I$=[[0,'java.awt.Point','java.util.StringTokenizer','java.awt.Polygon','java.awt.Color','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameHelp", null, 'Complex.Prog10.Transverse.CFrame', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mDelay=1.5;
},1);

C$.$fields$=[['Z',['mShowtime'],'D',['mDelay'],'S',['mMessage'],'O',['mTimer','javax.swing.Timer','mArrowHead','java.awt.Point']]]

Clazz.newMeth(C$, 'c$$Complex_Prog10_Transverse_CFramePanel$I$I$I$I$S',  function (var1, var2, var3, var4, var5, var6) {
;C$.superclazz.c$$Complex_Prog10_Transverse_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mMessage=var6;
this.DefaultArrowPos$();
}, 1);

Clazz.newMeth(C$, 'DefaultArrowPos$',  function () {
this.mArrowHead=Clazz.new_([this.x + (this.width/2|0), this.y + (this.height/2|0)],$I$(1,1).c$$I$I);
});

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var1.setPaintMode$();
if (this.mShowtime) {
var var2;
if (this.mArrowHead == null ) {
var2=this.mFramePanel.mLastPt;
} else {
var2=this.mArrowHead;
}var var3=this.mFramePanel.getSize$().width;
var var4=this.mFramePanel.getSize$().height;
var var5=12;
var var6=5;
var var7=10;
var var8=20;
var var9=0;
var var10=2 * var6;
var var11=Clazz.new_($I$(2,1).c$$S$S,[this.mMessage, "\n"]);
while (var11.hasMoreTokens$()){
var10+=var5;
var var12=var1.getFontMetrics$().stringWidth$S(var11.nextToken$());
if (var12 > var9) {
var9=var12;
}}
var9+=2 * var7;
var var20=1;
var var13=1;
if (var2.x + var7 + var9  > var3) {
var20=-1;
}if (var2.y + var7 + var10  > var4) {
var13=-1;
}var var14=Clazz.new_($I$(3,1));
var14.addPoint$I$I(var2.x, var2.y);
var14.addPoint$I$I(var2.x + var20 * var7, var2.y + var13 * var8);
var14.addPoint$I$I(var2.x + var20 * var7, var2.y + var13 * (var7 + var10));
var14.addPoint$I$I(var2.x + var20 * (var7 + var9), var2.y + var13 * (var7 + var10));
var14.addPoint$I$I(var2.x + var20 * (var7 + var9), var2.y + var13 * var7);
var14.addPoint$I$I(var2.x + var20 * var8, var2.y + var13 * var7);
var14.addPoint$I$I(var2.x, var2.y);
var1.setColor$java_awt_Color($I$(4).white);
var1.fillPolygon$java_awt_Polygon(var14);
var1.setColor$java_awt_Color($I$(4).black);
var1.drawPolygon$java_awt_Polygon(var14);
var var15;
if (var20 > 0) {
var15=var2.x + 2 * var7;
} else {
var15=var2.x - var9;
}var var16;
if (var13 > 0) {
var16=var2.y + var7 + var6 + var5 ;
} else {
var16=var2.y - var7 - var10  + var6 + var5;
}var var17=-1;
var11=Clazz.new_($I$(2,1).c$$S$S,[this.mMessage, "\n"]);
while (var11.hasMoreTokens$()){
var1.drawString$S$I$I(var11.nextToken$(), var15, var16 + ++var17 * var5);
}
}});

Clazz.newMeth(C$, 'MouseEvent$I$Z',  function (var1, var2) {
this.mWasHit=false;
if (this.mShowtime) {
this.repaint$();
}this.mShowtime=false;
this.mTimer=null;
if (var1 != 3) {
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

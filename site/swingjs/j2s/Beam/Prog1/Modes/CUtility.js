(function(){var P$=Clazz.newPackage("Beam.Prog1.Modes"),I$=[[0,'java.awt.Color','java.util.StringTokenizer','java.awt.Polygon','java.awt.Point','java.awt.Rectangle','java.awt.image.PixelGrabber']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CUtility");

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[[]
,['D',['kLog10']]]

Clazz.newMeth(C$, 'log10$D',  function (arg) {
return Math.log(arg) / C$.kLog10;
}, 1);

Clazz.newMeth(C$, 'nns$D$I',  function (arg, sig) {
if (sig <= 0) {
sig=1;
}if (arg == 0.0 ) {
return "0";
} else if (arg < 0.0 ) {
return "-" + C$.nns$D$I(-arg, sig);
} else {
var oom=Math.floor(C$.log10$D(arg));
var power=Math.pow(10.0, oom - sig + 1.0);
var intArg=Math.round$D(arg / power);
var result=String.valueOf$D(intArg * power);
var expStr="";
var expPos=result.indexOf$S("E-");
if (expPos > -1) {
expStr=result.substring$I(expPos);
result=result.substring$I$I(0, expPos);
power=Math.pow(10.0, -sig);
try {
arg=java.lang.Double.parseDouble$S(result);
} catch (var16) {
if (Clazz.exceptionOf(var16,"NumberFormatException")){
} else {
throw var16;
}
}
} else if (result.indexOf$S("E") > -1) {
return result;
}while (result.length$() > 1 && result.indexOf$I(46) > -1 ){
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
} catch (var17) {
if (Clazz.exceptionOf(var17,"NumberFormatException")){
break;
} else {
throw var17;
}
}
if (Math.abs(arg - newNum) > power ) {
break;
}result=shortStr;
}
return result + expStr;
}}, 1);

Clazz.newMeth(C$, 'nns$D',  function (arg) {
return C$.nns$D$I(arg, 4);
}, 1);

Clazz.newMeth(C$, 'RatColor$java_awt_Color$java_awt_Color$D',  function (c1, c2, ratio) {
if (ratio <= 0.0 ) {
return c1;
} else if (ratio >= 1.0 ) {
return c2;
} else {
var newRed=c1.getRed$() + ((ratio * (c2.getRed$() - c1.getRed$()))|0);
var newGreen=c1.getGreen$() + ((ratio * (c2.getGreen$() - c1.getGreen$()))|0);
var newBlue=c1.getBlue$() + ((ratio * (c2.getBlue$() - c1.getBlue$()))|0);
return Clazz.new_($I$(1,1).c$$I$I$I,[newRed, newGreen, newBlue]);
}}, 1);

Clazz.newMeth(C$, 'DrawString$java_awt_Graphics$S$I$I',  function (g, theString, x, y) {
var fm=g.getFontMetrics$();
var wid=fm.stringWidth$S(theString);
g.drawString$S$I$I(theString, x, y);
return x + wid;
}, 1);

Clazz.newMeth(C$, 'JDrawString$java_awt_Graphics$S$I$I$I$I',  function (g, arg, x, y, hAlign, vAlign) {
var fm=g.getFontMetrics$();
var sLen=fm.stringWidth$S(arg);
var maxAsc=fm.getMaxAscent$();
var maxDesc=fm.getMaxDescent$();
switch (hAlign) {
case -1:
x-=sLen;
break;
case 0:
x-=(sLen/2|0);
}
switch (vAlign) {
case -2:
y+=maxAsc;
break;
case -1:
y+=((maxDesc + maxAsc)/2|0);
case 0:
default:
break;
case 1:
y-=maxDesc;
}
g.drawString$S$I$I(arg, x, y);
}, 1);

Clazz.newMeth(C$, 'DrawHelp$java_awt_Graphics$java_awt_Point$I$I$S',  function (g, mArrow, wid, hei, message) {
g.setPaintMode$();
var kLineSpacing=12;
var kLineGap=5;
var gap1=10;
var gap2=20;
var ww=0;
var hh=2 * kLineGap;
var st=Clazz.new_($I$(2,1).c$$S$S,[message, "\n"]);
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
g.setColor$java_awt_Color($I$(1).white);
g.fillPolygon$java_awt_Polygon(p);
g.setColor$java_awt_Color($I$(1).black);
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
st=Clazz.new_($I$(2,1).c$$S$S,[message, "\n"]);
while (st.hasMoreTokens$()){
g.drawString$S$I$I(st.nextToken$(), tx, ty + ++tokenNo * kLineSpacing);
}
}, 1);

Clazz.newMeth(C$, 'DrawStringHalo$java_awt_Graphics$S$I$I',  function (g, s, xx, yy) {
var saveColor=g.getColor$();
g.setColor$java_awt_Color($I$(1).white);
g.drawString$S$I$I(s, xx + 1, yy + 1);
g.drawString$S$I$I(s, xx, yy + 1);
g.drawString$S$I$I(s, xx - 1, yy + 1);
g.drawString$S$I$I(s, xx - 1, yy);
g.drawString$S$I$I(s, xx - 1, yy - 1);
g.drawString$S$I$I(s, xx, yy - 1);
g.drawString$S$I$I(s, xx + 1, yy - 1);
g.drawString$S$I$I(s, xx + 1, yy);
g.setColor$java_awt_Color(saveColor);
g.drawString$S$I$I(s, xx, yy);
}, 1);

Clazz.newMeth(C$, 'DrawDoughnut$java_awt_Graphics$I$I$I$I',  function (g, x, y, rad, thick) {
var saveColor=g.getColor$();
for (var i=-1; i <= thick; i++) {
if (i >= 0 && i != thick ) {
g.setColor$java_awt_Color(saveColor);
} else {
g.setColor$java_awt_Color($I$(1).white);
}g.drawOval$I$I$I$I(x - rad + i, y - rad + i, 2 * (rad - i), 2 * (rad - i));
}
g.setColor$java_awt_Color(saveColor);
}, 1);

Clazz.newMeth(C$, 'RangeRandom$D$D$D',  function (minV, maxV, step) {
var raw=minV + (maxV - minV) * Math.random();
return step <= 0.0  ? raw : step * Math.round$D(raw / step);
}, 1);

Clazz.newMeth(C$, 'DrawThickLine$java_awt_Graphics$I$I$I$I',  function (g, x1, y1, x2, y2) {
var delta=Clazz.new_([Math.abs(x2 - x1), y2 - y1],$I$(4,1).c$$I$I);
if (delta.y <= delta.x && delta.y >= -delta.x ) {
delta.x=0;
delta.y=-1;
} else {
delta.x=-1;
delta.y=0;
}var p1=Clazz.new_($I$(4,1).c$$I$I,[x1, y1]);
var p2=Clazz.new_($I$(4,1).c$$I$I,[x2, y2]);
g.drawLine$I$I$I$I(p1.x, p1.y, p2.x, p2.y);
p1.x=p1.x + delta.x;
p1.y=p1.y + delta.y;
p2.x=p2.x + delta.x;
p2.y=p2.y + delta.y;
g.drawLine$I$I$I$I(p1.x, p1.y, p2.x, p2.y);
}, 1);

Clazz.newMeth(C$, 'TwoPointRect$java_awt_Point$java_awt_Point',  function (p1, p2) {
if (p1 == null  && p2 != null  ) {
p1=p2;
} else if (p1 != null  && p2 == null  ) {
p2=p1;
} else if (p1 == null  && p2 == null  ) {
return null;
}var xx=Math.min(p1.x, p2.x);
var yy=Math.min(p1.y, p2.y);
var ww=Math.abs(p2.x - p1.x);
var hh=Math.abs(p2.y - p1.y);
return Clazz.new_($I$(5,1).c$$I$I$I$I,[xx, yy, ww, hh]);
}, 1);

Clazz.newMeth(C$, 'DiagnosticOut$S',  function (s) {
}, 1);

Clazz.newMeth(C$, 'GetPixelColor$java_awt_Image$I$I$java_awt_image_ImageObserver',  function (im, x, y, ob) {
if (im == null ) {
return null;
} else {
var w=im.getWidth$java_awt_image_ImageObserver(ob);
var h=im.getHeight$java_awt_image_ImageObserver(ob);
if (x >= 0 && w >= x  && y >= 0  && h >= y ) {
var pixels=Clazz.array(Integer.TYPE, [1]);
var pg=Clazz.new_($I$(6,1).c$$java_awt_Image$I$I$I$I$IA$I$I,[im, x, y, 1, 1, pixels, 0, 0]);
try {
pg.grabPixels$();
} catch (var13) {
if (Clazz.exceptionOf(var13,"InterruptedException")){
System.err.println$S("interrupted waiting for pixels!");
return null;
} else {
throw var13;
}
}
if ((pg.status$() & 128) != 0) {
System.err.println$S("image fetch aborted or errored");
return null;
} else {
var pixel=pixels[0];
var red=pixel >> 16 & 255;
var green=pixel >> 8 & 255;
var blue=pixel & 255;
return Clazz.new_($I$(1,1).c$$I$I$I,[red, green, blue]);
}} else {
return null;
}}}, 1);

C$.$static$=function(){C$.$static$=0;
C$.kLog10=Math.log(10.0);
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:47 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

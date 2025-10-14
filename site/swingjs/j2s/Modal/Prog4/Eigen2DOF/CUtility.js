(function(){var P$=Clazz.newPackage("Modal.Prog4.Eigen2DOF"),I$=[[0,'java.awt.Color','java.util.StringTokenizer','java.awt.Polygon','java.awt.Point','java.awt.Rectangle','java.awt.image.PixelGrabber']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CUtility");

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[[]
,['D',['kLog10']]]

Clazz.newMeth(C$, 'log10$D',  function (var0) {
return Math.log(var0) / C$.kLog10;
}, 1);

Clazz.newMeth(C$, 'nns$D$I',  function (var0, var2) {
if (var2 <= 0) {
var2=1;
}if (var0 == 0.0 ) {
return "0";
} else if (var0 < 0.0 ) {
return "-" + C$.nns$D$I(-var0, var2);
} else {
var var3=Math.floor(C$.log10$D(var0));
var var5=Math.pow(10.0, var3 - var2 + 1.0);
var var7=Math.round$D(var0 / var5);
var var9=String.valueOf$D(var7 * var5);
var var10="";
var var11=var9.indexOf$S("E-");
if (var11 > -1) {
var10=var9.substring$I(var11);
var9=var9.substring$I$I(0, var11);
var5=Math.pow(10.0, -var2);
try {
var0=java.lang.Double.parseDouble$S(var9);
} catch (var16) {
if (Clazz.exceptionOf(var16,"NumberFormatException")){
} else {
throw var16;
}
}
} else if (var9.indexOf$S("E") > -1) {
return var9;
}while (var9.length$() > 1 && var9.indexOf$I(46) > -1 ){
var var12=false;
var var13;
for (var13=var9.length$() - 1; var9.charAt$I(var13) == "0"; var12=true) {
--var13;
}
if (var12) {
var9=var9.substring$I$I(0, var13 + 1);
}var var14=var9.substring$I$I(0, var13);
var var15;
try {
var15=java.lang.Double.parseDouble$S(var14);
} catch (var17) {
if (Clazz.exceptionOf(var17,"NumberFormatException")){
break;
} else {
throw var17;
}
}
if (Math.abs(var0 - var15) > var5 ) {
break;
}var9=var14;
}
return var9 + var10;
}}, 1);

Clazz.newMeth(C$, 'nns$D',  function (var0) {
return C$.nns$D$I(var0, 4);
}, 1);

Clazz.newMeth(C$, 'RatColor$java_awt_Color$java_awt_Color$D',  function (var0, var1, var2) {
if (var2 <= 0.0 ) {
return var0;
} else if (var2 >= 1.0 ) {
return var1;
} else {
var var4=var0.getRed$() + ((var2 * (var1.getRed$() - var0.getRed$()))|0);
var var5=var0.getGreen$() + ((var2 * (var1.getGreen$() - var0.getGreen$()))|0);
var var6=var0.getBlue$() + ((var2 * (var1.getBlue$() - var0.getBlue$()))|0);
return Clazz.new_($I$(1,1).c$$I$I$I,[var4, var5, var6]);
}}, 1);

Clazz.newMeth(C$, 'DrawString$java_awt_Graphics$S$I$I',  function (var0, var1, var2, var3) {
var var5=var0.getFontMetrics$();
var var6=var5.stringWidth$S(var1);
var0.drawString$S$I$I(var1, var2, var3);
return var2 + var6;
}, 1);

Clazz.newMeth(C$, 'JDrawString$java_awt_Graphics$S$I$I$I$I',  function (var0, var1, var2, var3, var4, var5) {
var var6=var0.getFontMetrics$();
var var7=var6.stringWidth$S(var1);
var var8=var6.getMaxAscent$();
var var9=var6.getMaxDescent$();
switch (var4) {
case -1:
var2-=var7;
break;
case 0:
var2-=(var7/2|0);
}
switch (var5) {
case -2:
var3+=var8;
break;
case -1:
var3+=((var9 + var8)/2|0);
case 0:
default:
break;
case 1:
var3-=var9;
}
var0.drawString$S$I$I(var1, var2, var3);
}, 1);

Clazz.newMeth(C$, 'DrawHelp$java_awt_Graphics$java_awt_Point$I$I$S',  function (var0, var1, var2, var3, var4) {
var0.setPaintMode$();
var var5=12;
var var6=5;
var var7=10;
var var8=20;
var var9=0;
var var10=2 * var6;
var var11=Clazz.new_($I$(2,1).c$$S$S,[var4, "\n"]);
while (var11.hasMoreTokens$()){
var10+=var5;
var var12=var0.getFontMetrics$().stringWidth$S(var11.nextToken$());
if (var12 > var9) {
var9=var12;
}}
var9+=2 * var7;
var var20=1;
var var13=1;
if (var1.x + var7 + var9  > var2) {
var20=-1;
}if (var1.y + var7 + var10  > var3) {
var13=-1;
}var var14=Clazz.new_($I$(3,1));
var14.addPoint$I$I(var1.x, var1.y);
var14.addPoint$I$I(var1.x + var20 * var7, var1.y + var13 * var8);
var14.addPoint$I$I(var1.x + var20 * var7, var1.y + var13 * (var7 + var10));
var14.addPoint$I$I(var1.x + var20 * (var7 + var9), var1.y + var13 * (var7 + var10));
var14.addPoint$I$I(var1.x + var20 * (var7 + var9), var1.y + var13 * var7);
var14.addPoint$I$I(var1.x + var20 * var8, var1.y + var13 * var7);
var14.addPoint$I$I(var1.x, var1.y);
var0.setColor$java_awt_Color($I$(1).white);
var0.fillPolygon$java_awt_Polygon(var14);
var0.setColor$java_awt_Color($I$(1).black);
var0.drawPolygon$java_awt_Polygon(var14);
var var15;
if (var20 > 0) {
var15=var1.x + 2 * var7;
} else {
var15=var1.x - var9;
}var var16;
if (var13 > 0) {
var16=var1.y + var7 + var6 + var5 ;
} else {
var16=var1.y - var7 - var10  + var6 + var5;
}var var17=-1;
var11=Clazz.new_($I$(2,1).c$$S$S,[var4, "\n"]);
while (var11.hasMoreTokens$()){
var0.drawString$S$I$I(var11.nextToken$(), var15, var16 + ++var17 * var5);
}
}, 1);

Clazz.newMeth(C$, 'DrawStringHalo$java_awt_Graphics$S$I$I',  function (var0, var1, var2, var3) {
var var4=var0.getColor$();
var0.setColor$java_awt_Color($I$(1).white);
var0.drawString$S$I$I(var1, var2 + 1, var3 + 1);
var0.drawString$S$I$I(var1, var2, var3 + 1);
var0.drawString$S$I$I(var1, var2 - 1, var3 + 1);
var0.drawString$S$I$I(var1, var2 - 1, var3);
var0.drawString$S$I$I(var1, var2 - 1, var3 - 1);
var0.drawString$S$I$I(var1, var2, var3 - 1);
var0.drawString$S$I$I(var1, var2 + 1, var3 - 1);
var0.drawString$S$I$I(var1, var2 + 1, var3);
var0.setColor$java_awt_Color(var4);
var0.drawString$S$I$I(var1, var2, var3);
}, 1);

Clazz.newMeth(C$, 'DrawDoughnut$java_awt_Graphics$I$I$I$I',  function (var0, var1, var2, var3, var4) {
var var5=var0.getColor$();
for (var var6=-1; var6 <= var4; var6++) {
if (var6 >= 0 && var6 != var4 ) {
var0.setColor$java_awt_Color(var5);
} else {
var0.setColor$java_awt_Color($I$(1).white);
}var0.drawOval$I$I$I$I(var1 - var3 + var6, var2 - var3 + var6, 2 * (var3 - var6), 2 * (var3 - var6));
}
var0.setColor$java_awt_Color(var5);
}, 1);

Clazz.newMeth(C$, 'RangeRandom$D$D$D',  function (var0, var2, var4) {
var var6=var0 + (var2 - var0) * Math.random();
return var4 <= 0.0  ? var6 : var4 * Math.round$D(var6 / var4);
}, 1);

Clazz.newMeth(C$, 'DrawThickLine$java_awt_Graphics$I$I$I$I',  function (var0, var1, var2, var3, var4) {
var var5=Clazz.new_([Math.abs(var3 - var1), var4 - var2],$I$(4,1).c$$I$I);
if (var5.y <= var5.x && var5.y >= -var5.x ) {
var5.x=0;
var5.y=-1;
} else {
var5.x=-1;
var5.y=0;
}var var6=Clazz.new_($I$(4,1).c$$I$I,[var1, var2]);
var var7=Clazz.new_($I$(4,1).c$$I$I,[var3, var4]);
var0.drawLine$I$I$I$I(var6.x, var6.y, var7.x, var7.y);
var6.x=var6.x + var5.x;
var6.y=var6.y + var5.y;
var7.x=var7.x + var5.x;
var7.y=var7.y + var5.y;
var0.drawLine$I$I$I$I(var6.x, var6.y, var7.x, var7.y);
}, 1);

Clazz.newMeth(C$, 'TwoPointRect$java_awt_Point$java_awt_Point',  function (var0, var1) {
if (var0 == null  && var1 != null  ) {
var0=var1;
} else if (var0 != null  && var1 == null  ) {
var1=var0;
} else if (var0 == null  && var1 == null  ) {
return null;
}var var2=Math.min(var0.x, var1.x);
var var3=Math.min(var0.y, var1.y);
var var4=Math.abs(var1.x - var0.x);
var var5=Math.abs(var1.y - var0.y);
return Clazz.new_($I$(5,1).c$$I$I$I$I,[var2, var3, var4, var5]);
}, 1);

Clazz.newMeth(C$, 'DiagnosticOut$S',  function (var0) {
}, 1);

Clazz.newMeth(C$, 'GetPixelColor$java_awt_Image$I$I$java_awt_image_ImageObserver',  function (var0, var1, var2, var3) {
if (var0 == null ) {
return null;
} else {
var var4=var0.getWidth$java_awt_image_ImageObserver(var3);
var var5=var0.getHeight$java_awt_image_ImageObserver(var3);
if (var1 >= 0 && var4 >= var1  && var2 >= 0  && var5 >= var2 ) {
var var6=Clazz.array(Integer.TYPE, [1]);
var var7=Clazz.new_($I$(6,1).c$$java_awt_Image$I$I$I$I$IA$I$I,[var0, var1, var2, 1, 1, var6, 0, 0]);
try {
var7.grabPixels$();
} catch (var13) {
if (Clazz.exceptionOf(var13,"InterruptedException")){
System.err.println$S("interrupted waiting for pixels!");
return null;
} else {
throw var13;
}
}
if ((var7.status$() & 128) != 0) {
System.err.println$S("image fetch aborted or errored");
return null;
} else {
var var8=var6[0];
var var10=var8 >> 16 & 255;
var var11=var8 >> 8 & 255;
var var12=var8 & 255;
return Clazz.new_($I$(1,1).c$$I$I$I,[var10, var11, var12]);
}} else {
return null;
}}}, 1);

C$.$static$=function(){C$.$static$=0;
C$.kLog10=Math.log(10.0);
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

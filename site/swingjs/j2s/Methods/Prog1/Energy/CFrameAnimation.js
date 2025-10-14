(function(){var P$=Clazz.newPackage("Methods.Prog1.Energy"),I$=[[0,'java.awt.Color','Methods.Prog1.Energy.CUtility']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Methods.Prog1.Energy.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mk1=1.0;
this.mm1=1.0;
this.mk2=1.0;
this.mm2=1.0;
},1);

C$.$fields$=[['D',['mk1','mm1','mk2','mm2']]]

Clazz.newMeth(C$, 'c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Methods_Prog1_Energy_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var1.setPaintMode$();
var var23=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(380, 333, 380, 12);
var1.drawLine$I$I$I$I(17, 330, 403, 330);
for (var var2=1; var2 < 10; var2++) {
var1.drawLine$I$I$I$I(380, 330 - var2 * 35, 377, 330 - var2 * 35);
}
for (var var24=1; var24 < 21; var24++) {
var1.drawLine$I$I$I$I(var24 * 20, 330, var24 * 20, 333);
}
var1.setColor$java_awt_Color(var23);
var var7=-18.0;
var var3=Math.sqrt((this.mk1 * var7 * var7  + this.mk2 * (1.0 - var7) * (1.0 - var7) ) / (this.mm1 * var7 * var7  + this.mm2));
for (var var25=1; var25 < 380; var25++) {
var7=-18.0 + var25 / 20.0;
var var5=Math.sqrt((this.mk1 * var7 * var7  + this.mk2 * (1.0 - var7) * (1.0 - var7) ) / (this.mm1 * var7 * var7  + this.mm2));
var1.drawLine$I$I$I$I(20 + (var25 - 1), ((330.0 - var3 * 70.0)|0), 20 + var25, ((330.0 - var5 * 70.0)|0));
var3=var5;
}
var var17=this.mm1 * this.mm2;
var var19=-(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
var var21=this.mk1 * this.mk2;
var var9=Math.sqrt((-var19 - Math.sqrt(var19 * var19 - 4.0 * var17 * var21 )) / (2.0 * var17));
var var11=Math.sqrt((-var19 + Math.sqrt(var19 * var19 - 4.0 * var17 * var21 )) / (2.0 * var17));
var var13=this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var9 * var9 );
var var15=this.mk2 / (this.mk1 + this.mk2 - this.mm1 * var11 * var11 );
var1.setColor$java_awt_Color($I$(1).blue);
var1.drawLine$I$I$I$I(380 + ((var13 * 20.0)|0), 330, 380 + ((var13 * 20.0)|0), 330 - ((var9 * 70.0)|0));
var1.drawLine$I$I$I$I(380 + ((var13 * 20.0)|0), 330 - ((var9 * 70.0)|0), 400, 330 - ((var9 * 70.0)|0));
var1.drawString$S$I$I($I$(2).nns$D(var9), 402, 330 - ((var9 * 70.0)|0) + 5);
var1.drawString$S$I$I($I$(2).nns$D(var13), 380 + ((var13 * 20.0)|0) + 2 , 328);
var1.drawLine$I$I$I$I(380 + ((var15 * 20.0)|0), 330, 380 + ((var15 * 20.0)|0), 330 - ((var11 * 70.0)|0));
var1.drawString$S$I$I($I$(2).nns$D(var11), 380 + ((var15 * 20.0)|0) - 32, 330 - ((var11 * 70.0)|0) - 4 );
var1.drawString$S$I$I($I$(2).nns$D(var15), 380 + ((var15 * 20.0)|0) - 40, 328);
});

Clazz.newMeth(C$, 'ControlMessage$Methods_Prog1_Energy_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mk1=var3;
break;
case 2:
this.mm1=var3;
break;
case 3:
this.mk2=var3;
break;
case 4:
this.mm2=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

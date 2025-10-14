(function(){var P$=Clazz.newPackage("Continuous.Prog10.Vibration"),I$=[[0,'java.awt.Color']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CAnimationPanel", null, 'java.awt.Panel');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mxp=Clazz.array(Double.TYPE, [33]);
this.mAmp=Clazz.array(Double.TYPE, [33]);
},1);

C$.$fields$=[['D',['mTime','mWn','mXo','mx0','mlambdaL','mlambdax','mexp','msh','mch','msn','mcs','msnx','mcsx','mshx','mchx','mF8','mF10','mMax'],'I',['kyaxis'],'O',['mxp','double[]','+mAmp','mOffScrImage','java.awt.Image','mScreenGC','java.awt.Graphics','+mOffScreenGC','mTraceImage','java.awt.Image','mTraceGC','java.awt.Graphics']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$',  function () {
Clazz.super_(C$, this);
this.mWn=0.025;
}, 1);

Clazz.newMeth(C$, 'update$java_awt_Graphics',  function (g) {
if (g != null ) {
this.mScreenGC=g;
this.paint$java_awt_Graphics(this.mScreenGC);
}});

Clazz.newMeth(C$, 'paint$java_awt_Graphics',  function (g) {
this.mScreenGC=g;
var mass=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
if (this.mOffScreenGC == null ) {
this.mOffScrImage=this.createImage$I$I(this.getSize$().width, this.getSize$().height);
this.mOffScreenGC=this.mOffScrImage.getGraphics$();
}var ww=this.mOffScrImage.getWidth$java_awt_image_ImageObserver(this);
var hh=this.mOffScrImage.getHeight$java_awt_image_ImageObserver(this);
this.mOffScreenGC.setColor$java_awt_Color($I$(1).white);
this.mOffScreenGC.fillRect$I$I$I$I(0, 0, ww, hh);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(22.37);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var p=0; p < 31; p++) {
this.mlambdax=this.mlambdaL * p / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[p]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[p]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[p]);
}}
for (var var6=0; var6 < 31; var6++) {
this.mxp[var6]=this.mxp[var6] * 20.0 / this.mMax;
}
for (var var7=0; var7 < 31; var7++) {
this.mAmp[var7]=this.mxp[var7] * Math.cos(this.mWn * this.mTime * 22.37 );
}
this.kyaxis=30;
for (var var8=0; var8 < 30; var8++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var8 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var8]|0), 20 + (((var8 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var8 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("First non-zero mode", 290, 35);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(61.67);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var var9=0; var9 < 31; var9++) {
this.mlambdax=this.mlambdaL * var9 / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[var9]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[var9]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[var9]);
}}
for (var var10=0; var10 < 31; var10++) {
this.mxp[var10]=this.mxp[var10] * 20.0 / this.mMax;
}
for (var var11=0; var11 < 31; var11++) {
this.mAmp[var11]=this.mxp[var11] * Math.cos(this.mWn * this.mTime * 61.67 );
}
this.kyaxis=90;
for (var var12=0; var12 < 30; var12++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var12 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var12]|0), 20 + (((var12 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var12 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("Second non-zero mode", 290, 95);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(120.9);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var var13=0; var13 < 31; var13++) {
this.mlambdax=this.mlambdaL * var13 / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[var13]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[var13]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[var13]);
}}
for (var var14=0; var14 < 31; var14++) {
this.mxp[var14]=this.mxp[var14] * 20.0 / this.mMax;
}
for (var var15=0; var15 < 31; var15++) {
this.mAmp[var15]=this.mxp[var15] * Math.cos(this.mWn * this.mTime * 120.9 );
}
this.kyaxis=150;
for (var var16=0; var16 < 30; var16++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var16 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var16]|0), 20 + (((var16 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var16 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("Third non-zero mode", 290, 155);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(199.9);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var var17=0; var17 < 31; var17++) {
this.mlambdax=this.mlambdaL * var17 / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[var17]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[var17]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[var17]);
}}
for (var var18=0; var18 < 31; var18++) {
this.mxp[var18]=this.mxp[var18] * 20.0 / this.mMax;
}
for (var var19=0; var19 < 31; var19++) {
this.mAmp[var19]=this.mxp[var19] * Math.cos(this.mWn * this.mTime * 199.9 );
}
this.kyaxis=210;
for (var var20=0; var20 < 30; var20++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var20 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var20]|0), 20 + (((var20 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var20 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("Fourth non-zero mode", 290, 215);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(298.6);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var var21=0; var21 < 31; var21++) {
this.mlambdax=this.mlambdaL * var21 / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[var21]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[var21]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[var21]);
}}
for (var var22=0; var22 < 31; var22++) {
this.mxp[var22]=this.mxp[var22] * 20.0 / this.mMax;
}
for (var var23=0; var23 < 31; var23++) {
this.mAmp[var23]=this.mxp[var23] * Math.cos(this.mWn * this.mTime * 298.6 );
}
this.kyaxis=270;
for (var var24=0; var24 < 30; var24++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var24 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var24]|0), 20 + (((var24 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var24 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("Fifth non-zero mode", 290, 275);
this.mOffScreenGC.setColor$java_awt_Color(mass);
this.mlambdaL=Math.sqrt(417.0);
this.mexp=Math.exp(this.mlambdaL);
this.msh=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mch=(this.mexp + 1.0 / this.mexp) / 2.0;
this.msn=Math.sin(this.mlambdaL);
this.mcs=Math.cos(this.mlambdaL);
this.mF8=this.msn - this.msh;
this.mF10=this.mcs - this.mch;
this.mMax=0.0;
for (var var25=0; var25 < 31; var25++) {
this.mlambdax=this.mlambdaL * var25 / 30.0;
this.msnx=Math.sin(this.mlambdax);
this.mcsx=Math.cos(this.mlambdax);
this.mexp=Math.exp(this.mlambdax);
this.mshx=(this.mexp - 1.0 / this.mexp) / 2.0;
this.mchx=(this.mexp + 1.0 / this.mexp) / 2.0;
this.mxp[var25]=this.mF8 * (this.mcsx + this.mchx) - this.mF10 * (this.msnx + this.mshx);
if (Math.abs(this.mxp[var25]) > this.mMax ) {
this.mMax=Math.abs(this.mxp[var25]);
}}
for (var var26=0; var26 < 31; var26++) {
this.mxp[var26]=this.mxp[var26] * 20.0 / this.mMax;
}
for (var var27=0; var27 < 31; var27++) {
this.mAmp[var27]=this.mxp[var27] * Math.cos(this.mWn * this.mTime * 417.0 );
}
this.kyaxis=330;
for (var var28=0; var28 < 30; var28++) {
this.mOffScreenGC.drawLine$I$I$I$I(20 + ((var28 * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var28]|0), 20 + (((var28 + 1) * 250.0 / 30.0)|0), this.kyaxis - (this.mAmp[var28 + 1]|0));
}
this.mOffScreenGC.setColor$java_awt_Color($I$(1).black);
this.mOffScreenGC.drawString$S$I$I("Sixth non-zero mode", 290, 335);
g.drawImage$java_awt_Image$I$I$java_awt_image_ImageObserver(this.mOffScrImage, 0, 0, null);
});

Clazz.newMeth(C$, 'SetRealParameter$I$D',  function (code, val) {
var mustRedraw=false;
switch (code) {
case 0:
this.mTime+=val;
mustRedraw=true;
default:
if (mustRedraw) {
this.repaint$();
}}
});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
};
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

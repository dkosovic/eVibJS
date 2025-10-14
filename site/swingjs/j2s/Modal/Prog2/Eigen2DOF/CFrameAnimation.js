(function(){var P$=Clazz.newPackage("Modal.Prog2.Eigen2DOF"),I$=[[0,'java.awt.Color','jama.Matrix','jama.EigenvalueDecomposition']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Modal.Prog2.Eigen2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mk1=1.0;
},1);

C$.$fields$=[['D',['mm1','mk1','mm2','mW','mWmin','mWmax','A','B','C','mxscale','myscale','store','wn1','wn2','m1','m2'],'I',['mxpower','mypower'],'O',['mAmp','double[]','+mRealAmp','M','jama.Matrix','+K','+D','lambda','double[]','+u','+u1','+u2']]]

Clazz.newMeth(C$, 'c$$Modal_Prog2_Eigen2DOF_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Modal_Prog2_Eigen2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mm1=1.0;
this.mm2=1.0;
this.mxscale=480.0;
this.myscale=45.0;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mAmp=Clazz.array(Double.TYPE, [602]);
var1.setPaintMode$();
this.u1=Clazz.array(Double.TYPE, [2]);
this.u2=Clazz.array(Double.TYPE, [2]);
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var var21=Clazz.array(Double.TYPE, [2, 2]);
var21[0][0]=this.mm1;
var21[0][1]=0.0;
var21[1][0]=0.0;
var21[1][1]=this.mm2;
this.M=Clazz.new_($I$(2,1).c$$DAA,[var21]);
var var22=Clazz.array(Double.TYPE, [2, 2]);
var22[0][0]=2.0 * this.mk1;
var22[0][1]=-this.mk1;
var22[1][0]=-this.mk1;
var22[1][1]=2.0 * this.mk1;
this.K=Clazz.new_($I$(2,1).c$$DAA,[var22]);
this.Eigenvalues$jama_Matrix$jama_Matrix(this.M, this.K);
this.wn1=Math.sqrt(this.lambda[0]);
this.wn2=Math.sqrt(this.lambda[1]);
for (var var3=0; var3 < 2; var3++) {
this.Eigenvector$jama_Matrix$jama_Matrix$D(this.M, this.K, this.lambda[var3]);
for (var var4=0; var4 < 2; var4++) {
if (var3 == 0) {
this.u1[var4]=this.u[var4];
} else {
this.u2[var4]=this.u[var4];
}}
}
this.m1=this.mm1 * this.u1[0] * this.u1[0]  + this.mm2 * this.u1[1] * this.u1[1] ;
this.m2=this.mm1 * this.u2[0] * this.u2[0]  + this.mm2 * this.u2[1] * this.u2[1] ;
var1.setColor$java_awt_Color($I$(1).black);
var1.drawLine$I$I$I$I(57, 360, 543, 360);
for (var var2=1; var2 < 7; var2++) {
var1.drawLine$I$I$I$I(60 + var2 * 76, 360, 60 + var2 * 76, 363);
}
var1.drawLine$I$I$I$I(60, 67, 60, 363);
for (var var23=0; var23 < 7; var23++) {
var1.drawLine$I$I$I$I(60, 70 + var23 * 45, 57, 70 + var23 * 45);
}
var1.setColor$java_awt_Color($I$(1).red);
for (var var24=2; var24 < 481; var24++) {
var var11=(6.283185307179586) * var24 / this.mxscale;
var var13=this.wn1 * this.wn1 - var11 * var11;
var var17=this.wn2 * this.wn2 - var11 * var11;
this.mAmp[var24]=this.u1[0] * this.u1[0] / (this.m1 * var13) + this.u2[0] * this.u2[0] / (this.m2 * var17);
this.mAmp[var24]=Math.abs(this.mAmp[var24]);
var1.drawLine$I$I$I$I(60 + (var24 - 1), ((160.0 - Math.log(this.mAmp[var24 - 1]) / Math.log(10.0) * this.myscale)|0), 60 + var24, ((160.0 - Math.log(this.mAmp[var24]) / Math.log(10.0) * this.myscale)|0));
}
var1.setColor$java_awt_Color($I$(1).blue);
for (var var25=2; var25 < 481; var25++) {
var var26=(6.283185307179586) * var25 / this.mxscale;
var var27=this.wn1 * this.wn1 - var26 * var26;
var var28=this.wn2 * this.wn2 - var26 * var26;
this.mAmp[var25]=this.u1[0] * this.u1[1] / (this.m1 * var27) + this.u2[0] * this.u2[1] / (this.m2 * var28);
this.mAmp[var25]=Math.abs(this.mAmp[var25]);
var1.drawLine$I$I$I$I(60 + (var25 - 1), ((160.0 - Math.log(this.mAmp[var25 - 1]) / Math.log(10.0) * this.myscale)|0), 60 + var25, ((160.0 - Math.log(this.mAmp[var25]) / Math.log(10.0) * this.myscale)|0));
}
});

Clazz.newMeth(C$, 'Eigenvalues$jama_Matrix$jama_Matrix',  function (var1, var2) {
var var3=var2.getRowDimension$();
var var8=var1.inverse$();
this.D=var8.times$jama_Matrix(var2);
var var9=Clazz.new_($I$(3,1).c$$jama_Matrix,[this.D]);
this.lambda=var9.getRealEigenvalues$();
for (var var5=0; var5 < var3 - 1; var5++) {
for (var var4=1; var4 < var3; var4++) {
if (this.lambda[var4] < this.lambda[var4 - 1] ) {
var var6=this.lambda[var4 - 1];
this.lambda[var4 - 1]=this.lambda[var4];
this.lambda[var4]=var6;
}}
}
});

Clazz.newMeth(C$, 'Eigenvector$jama_Matrix$jama_Matrix$D',  function (var1, var2, var3) {
var var5=var2.getRowDimension$();
var var8=Clazz.array(Double.TYPE, [var5 - 1, var5 - 1]);
var var9=Clazz.array(Double.TYPE, [var5 - 1, 1]);
this.u=Clazz.array(Double.TYPE, [var5]);
this.u[var5 - 1]=1.0;
var var10=var1.times$D(var3);
var var11=var2.minus$jama_Matrix(var10);
for (var var6=0; var6 < var5 - 1; var6++) {
for (var var7=0; var7 < var5 - 1; var7++) {
var8[var6][var7]=var11.get$I$I(var6, var7);
}
}
var var12=Clazz.new_($I$(2,1).c$$DAA,[var8]);
for (var var15=0; var15 < var5 - 1; var15++) {
var9[var15][0]=-var11.get$I$I(var15, var5 - 1);
}
var var13=Clazz.new_($I$(2,1).c$$DAA,[var9]);
var var14=var12.solve$jama_Matrix(var13);
for (var var16=0; var16 < var5 - 1; var16++) {
this.u[var16]=var14.get$I$I(var16, 0);
}
});

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog2_Eigen2DOF_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mm1=var3;
break;
case 2:
this.mm2=var3;
break;
case 3:
this.mk1=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

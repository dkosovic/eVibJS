(function(){var P$=Clazz.newPackage("Modal.Prog4.Eigen2DOF"),I$=[[0,'java.awt.Color','jama.Matrix','jama.EigenvalueDecomposition']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Modal.Prog4.Eigen2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mk1=10.0;
},1);

C$.$fields$=[['D',['mm1','mk1','mc1','mm2','mk2','mc2','mW','mWmin','mWmax','A','B','C','mxscale','myscale','store','wn1','wn2','Xi1','Xi2','m1','m2'],'I',['mxpower','mypower'],'O',['mAmp','double[]','+mRealAmp','+mQuadAmp','+mPhase','M','jama.Matrix','+K','+F','+H','+J','+D','lambda_real','double[]','+lambda_imag','+lambda','+u','+u1','+u2']]]

Clazz.newMeth(C$, 'c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Modal_Prog4_Eigen2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mm1=1.0;
this.mc1=0.4;
this.mk2=10.0;
this.mm2=1.0;
this.mc2=0.08;
this.mxscale=480.0;
this.myscale=45.0;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mAmp=Clazz.array(Double.TYPE, [602]);
this.mRealAmp=Clazz.array(Double.TYPE, [602]);
this.mQuadAmp=Clazz.array(Double.TYPE, [602]);
this.mPhase=Clazz.array(Double.TYPE, [602]);
var1.setPaintMode$();
this.u1=Clazz.array(Double.TYPE, [2]);
this.u2=Clazz.array(Double.TYPE, [2]);
var var21=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var var22=Clazz.array(Double.TYPE, [2, 2]);
var22[0][0]=this.mm1;
var22[0][1]=0.0;
var22[1][0]=0.0;
var22[1][1]=this.mm2;
this.M=Clazz.new_($I$(2,1).c$$DAA,[var22]);
var var23=Clazz.array(Double.TYPE, [2, 2]);
var23[0][0]=this.mk1 + this.mk2;
var23[0][1]=-this.mk2;
var23[1][0]=-this.mk2;
var23[1][1]=this.mk2;
this.K=Clazz.new_($I$(2,1).c$$DAA,[var23]);
var var24=Clazz.array(Double.TYPE, [2, 2]);
var24[0][0]=this.mc1 + this.mc2;
var24[0][1]=-this.mc2;
var24[1][0]=-this.mc2;
var24[1][1]=this.mc2;
this.F=Clazz.new_($I$(2,1).c$$DAA,[var24]);
var var25=this.M.inverse$();
this.H=var25.times$jama_Matrix(this.K);
this.J=var25.times$jama_Matrix(this.F);
var var26=Clazz.array(Double.TYPE, [4, 4]);
var26[0][0]=0.0;
var26[0][1]=0.0;
var26[0][2]=-1.0;
var26[0][3]=0.0;
var26[1][0]=0.0;
var26[1][1]=0.0;
var26[1][2]=0.0;
var26[1][3]=-1.0;
var26[2][0]=this.H.get$I$I(0, 0);
var26[2][1]=this.H.get$I$I(0, 1);
var26[2][2]=this.J.get$I$I(0, 0);
var26[2][3]=this.J.get$I$I(0, 1);
var26[3][0]=this.H.get$I$I(1, 0);
var26[3][1]=this.H.get$I$I(1, 1);
var26[3][2]=this.J.get$I$I(1, 0);
var26[3][3]=this.J.get$I$I(1, 1);
this.D=Clazz.new_($I$(2,1).c$$DAA,[var26]);
var var27=Clazz.new_($I$(3,1).c$$jama_Matrix,[this.D]);
this.lambda_real=var27.getRealEigenvalues$();
this.lambda_imag=var27.getImagEigenvalues$();
if (this.lambda_real[0] > this.lambda_real[2] ) {
this.store=this.lambda_real[0];
this.lambda_real[0]=this.lambda_real[2];
this.lambda_real[2]=this.store;
this.store=this.lambda_real[1];
this.lambda_real[1]=this.lambda_real[3];
this.lambda_real[3]=this.store;
this.store=this.lambda_imag[0];
this.lambda_imag[0]=this.lambda_imag[2];
this.lambda_imag[2]=this.store;
this.store=this.lambda_imag[1];
this.lambda_imag[1]=this.lambda_imag[3];
this.lambda_imag[3]=this.store;
}this.store=this.lambda_imag[0] / this.lambda_real[0];
this.Xi1=Math.sqrt(1.0 / (1.0 + this.store * this.store));
this.wn1=this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
this.store=this.lambda_imag[2] / this.lambda_real[2];
this.Xi2=Math.sqrt(1.0 / (1.0 + this.store * this.store));
this.wn2=this.lambda_imag[2] / Math.sqrt(1.0 - this.Xi2 * this.Xi2);
this.Eigenvalues$jama_Matrix$jama_Matrix(this.M, this.K);
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
var1.drawLine$I$I$I$I(57, 340, 543, 340);
for (var var2=1; var2 < 9; var2++) {
var1.drawLine$I$I$I$I(60 + var2 * 60, 340, 60 + var2 * 60, 343);
}
var1.setColor$java_awt_Color(var21);
var1.drawLine$I$I$I$I(60, 47, 60, 343);
for (var var29=0; var29 < 7; var29++) {
var1.drawLine$I$I$I$I(60, 50 + var29 * 45, 57, 50 + var29 * 45);
}
var1.setColor$java_awt_Color($I$(1).black);
this.mAmp[0]=1.0 / this.mk1;
var var7=this.mAmp[0];
for (var var30=1; var30 < 481; var30++) {
var var11=(6.283185307179586) * var30 / this.mxscale;
var var19=this.mk2 * this.mk2 + var11 * var11 * this.mc2 * this.mc2 ;
var var13=this.mk2 / var19 - 1.0 / (this.mm2 * var11 * var11 );
var var15=-var11 * this.mc2 / var19;
var var17=this.mk1 - this.mm1 * var11 * var11  + var13 / (var13 * var13 + var15 * var15);
var19=var11 * this.mc1 - var15 / (var13 * var13 + var15 * var15);
this.mRealAmp[var30]=var17 / (var17 * var17 + var19 * var19);
this.mQuadAmp[var30]=-var19 / (var17 * var17 + var19 * var19);
this.mAmp[var30]=Math.sqrt(this.mRealAmp[var30] * this.mRealAmp[var30] + this.mQuadAmp[var30] * this.mQuadAmp[var30]);
if (var30 == 1) {
var7=this.mAmp[var30];
} else {
var1.drawLine$I$I$I$I(60 + (var30 - 1), ((140.0 - Math.log(var7) / Math.log(10.0) * this.myscale)|0), 60 + var30, ((140.0 - Math.log(this.mAmp[var30]) / Math.log(10.0) * this.myscale)|0));
var7=this.mAmp[var30];
}}
var var28=Clazz.new_($I$(1,1).c$$F$F$F,[0.77, 0.38, 0.0]);
var1.setColor$java_awt_Color(var28);
this.mPhase[0]=0.0;
var var9=this.mPhase[0];
for (var var31=1; var31 < 481; var31++) {
this.mPhase[var31]=180.0 * Math.atan(this.mQuadAmp[var31] / this.mRealAmp[var31]) / 3.141592653589793;
if (this.mPhase[var31] >= 0.0 ) {
this.mPhase[var31]=this.mPhase[var31] - 180.0;
}var1.drawLine$I$I$I$I(60 + (var31 - 1), ((130.0 - var9 / 2.0)|0), 60 + var31, ((130.0 - this.mPhase[var31] / 2.0)|0));
var9=this.mPhase[var31];
this.mPhase[var31]=this.mPhase[var31] * 3.141592653589793 / 180.0;
}
var1.drawLine$I$I$I$I(540, 127, 540, 343);
for (var var32=0; var32 < 9; var32++) {
var1.drawLine$I$I$I$I(540, 130 + ((var32 * 22.5)|0), 543, 130 + ((var32 * 22.5)|0));
}
var1.setColor$java_awt_Color($I$(1).red);
for (var var33=2; var33 < 481; var33+=4) {
var var41=(6.283185307179586) * var33 / this.mxscale;
var var42=this.wn1 * this.wn1 - var41 * var41;
var var43=2.0 * this.Xi1 * this.wn1 * var41 ;
var var44=this.wn2 * this.wn2 - var41 * var41;
var var46=2.0 * this.Xi2 * this.wn2 * var41 ;
this.mRealAmp[var33]=var42 / (var42 * var42 + var43 * var43) * this.u1[0] * this.u1[0] / this.m1 + var44 / (var44 * var44 + var46 * var46) * this.u2[0] * this.u2[0] / this.m2;
this.mQuadAmp[var33]=-var43 / (var42 * var42 + var43 * var43) * this.u1[0] * this.u1[0] / this.m1 - var46 / (var44 * var44 + var46 * var46) * this.u2[0] * this.u2[0] / this.m2;
this.mAmp[var33]=Math.sqrt(this.mRealAmp[var33] * this.mRealAmp[var33] + this.mQuadAmp[var33] * this.mQuadAmp[var33]);
var1.drawLine$I$I$I$I(60 + (var33 - 1), ((141.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)|0), 60 + var33 + 1 , ((139.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)|0));
var1.drawLine$I$I$I$I(60 + (var33 - 1), ((139.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)|0), 60 + var33 + 1 , ((141.0 - Math.log(this.mAmp[var33]) / Math.log(10.0) * this.myscale)|0));
}
var1.setColor$java_awt_Color($I$(1).blue);
for (var var34=2; var34 < 481; var34+=4) {
this.mPhase[var34]=180.0 * Math.atan(this.mQuadAmp[var34] / this.mRealAmp[var34]) / 3.141592653589793;
if (this.mPhase[var34] >= 0.0 ) {
this.mPhase[var34]=this.mPhase[var34] - 180.0;
}var1.drawLine$I$I$I$I(60 + (var34 - 1), ((131.0 - this.mPhase[var34] / 2.0)|0), 60 + var34 + 1 , ((129.0 - this.mPhase[var34] / 2.0)|0));
var1.drawLine$I$I$I$I(60 + (var34 - 1), ((129.0 - this.mPhase[var34] / 2.0)|0), 60 + var34 + 1 , ((131.0 - this.mPhase[var34] / 2.0)|0));
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

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog4_Eigen2DOF_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 1:
this.mk1=var3;
break;
case 2:
this.mm1=var3;
break;
case 3:
this.mc1=var3;
break;
case 4:
this.mk2=var3;
break;
case 5:
this.mm2=var3;
break;
case 6:
this.mc2=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

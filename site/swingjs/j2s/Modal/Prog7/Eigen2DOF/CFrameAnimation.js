(function(){var P$=Clazz.newPackage("Modal.Prog7.Eigen2DOF"),I$=[[0,'java.awt.Color','jama.Matrix','jama.EigenvalueDecomposition']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Modal.Prog7.Eigen2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mk1=10.0;
},1);

C$.$fields$=[['D',['mm1','mk1','mc1','mm2','mk2','mc2','mx10','mv10','mx20','mv20','A','B','C','mAmp1','mt','mdt','mxscale','myscale','mXi1w1','mXi2w2','mwd1','mwd2','store','wn1','wn2','Xi1','Xi2','m1','m2'],'O',['mx11','double[]','+mx12','+mx21','+mx22','+mx_exact1','+mx_exact2','M','jama.Matrix','+K','+F','+H','+J','+D','lambda_real','double[]','+lambda_imag','+lambda','+u','+u1','+u2']]]

Clazz.newMeth(C$, 'c$$Modal_Prog7_Eigen2DOF_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Modal_Prog7_Eigen2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mm1=1.0;
this.mc1=0.4;
this.mk2=10.0;
this.mm2=1.0;
this.mc2=0.08;
this.mx10=1.0;
this.mv10=10.0;
this.mx20=0.0;
this.mv20=0.0;
this.mdt=0.2;
this.mxscale=480.0;
this.myscale=10.0;
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mx11=Clazz.array(Double.TYPE, [500]);
this.mx12=Clazz.array(Double.TYPE, [500]);
this.mx21=Clazz.array(Double.TYPE, [500]);
this.mx22=Clazz.array(Double.TYPE, [500]);
this.mx_exact1=Clazz.array(Double.TYPE, [500]);
this.mx_exact2=Clazz.array(Double.TYPE, [500]);
var1.setPaintMode$();
this.u1=Clazz.array(Double.TYPE, [2]);
this.u2=Clazz.array(Double.TYPE, [2]);
Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var var16=Clazz.array(Double.TYPE, [2, 2]);
var16[0][0]=this.mm1;
var16[0][1]=0.0;
var16[1][0]=0.0;
var16[1][1]=this.mm2;
this.M=Clazz.new_($I$(2,1).c$$DAA,[var16]);
var var17=Clazz.array(Double.TYPE, [2, 2]);
var17[0][0]=this.mk1 + this.mk2;
var17[0][1]=-this.mk2;
var17[1][0]=-this.mk2;
var17[1][1]=this.mk2;
this.K=Clazz.new_($I$(2,1).c$$DAA,[var17]);
var var18=Clazz.array(Double.TYPE, [2, 2]);
var18[0][0]=this.mc1 + this.mc2;
var18[0][1]=-this.mc2;
var18[1][0]=-this.mc2;
var18[1][1]=this.mc2;
this.F=Clazz.new_($I$(2,1).c$$DAA,[var18]);
var var19=this.M.inverse$();
this.H=var19.times$jama_Matrix(this.K);
this.J=var19.times$jama_Matrix(this.F);
var var20=Clazz.array(Double.TYPE, [4, 4]);
var20[0][0]=0.0;
var20[0][1]=0.0;
var20[0][2]=-1.0;
var20[0][3]=0.0;
var20[1][0]=0.0;
var20[1][1]=0.0;
var20[1][2]=0.0;
var20[1][3]=-1.0;
var20[2][0]=this.H.get$I$I(0, 0);
var20[2][1]=this.H.get$I$I(0, 1);
var20[2][2]=this.J.get$I$I(0, 0);
var20[2][3]=this.J.get$I$I(0, 1);
var20[3][0]=this.H.get$I$I(1, 0);
var20[3][1]=this.H.get$I$I(1, 1);
var20[3][2]=this.J.get$I$I(1, 0);
var20[3][3]=this.J.get$I$I(1, 1);
this.D=Clazz.new_($I$(2,1).c$$DAA,[var20]);
var var21=Clazz.new_($I$(3,1).c$$jama_Matrix,[this.D]);
this.lambda_real=var21.getRealEigenvalues$();
this.lambda_imag=var21.getImagEigenvalues$();
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
}this.mXi1w1=this.lambda_real[0];
this.mwd1=this.lambda_imag[0];
this.store=this.lambda_imag[0] / this.lambda_real[0];
this.Xi1=Math.sqrt(1.0 / (1.0 + this.store * this.store));
this.wn1=this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
this.mXi2w2=this.lambda_real[2];
this.mwd2=this.lambda_imag[2];
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
for (var var47=1; var47 < 5; var47++) {
var1.drawLine$I$I$I$I(27, 100 * var47, 513, 100 * var47);
for (var var2=1; var2 < 10; var2++) {
var1.drawLine$I$I$I$I(30 + var2 * 50, 100 * var47 - 2, 30 + var2 * 50, 100 * var47 + 2);
}
var1.drawLine$I$I$I$I(30, 100 * var47 - 42, 30, 100 * var47 + 42);
for (var var38=1; var38 < 10; var38++) {
var1.drawLine$I$I$I$I(30, 100 * var47 - 10 * (var38 - 5), 27, 100 * var47 - 10 * (var38 - 5));
}
}
var1.drawLine$I$I$I$I(27, 480, 513, 480);
for (var var39=0; var39 < 10; var39++) {
var1.drawLine$I$I$I$I(30 + var39 * 50, 478, 30 + var39 * 50, 482);
}
var var22=(this.mm1 * this.u1[0] * this.mx10  + this.mm2 * this.u1[1] * this.mx20 ) / this.m1;
var var24=(this.mm1 * this.u1[0] * this.mv10  + this.mm2 * this.u1[1] * this.mv20 ) / this.m1;
var var26=(this.mm1 * this.u2[0] * this.mx10  + this.mm2 * this.u2[1] * this.mx20 ) / this.m2;
var var28=(this.mm1 * this.u2[0] * this.mv10  + this.mm2 * this.u2[1] * this.mv20 ) / this.m2;
var var30=Math.sqrt(var22 * var22 + (var24 + this.mXi1w1 * var22) * (var24 + this.mXi1w1 * var22) / this.mwd1 / this.mwd1);
var var32=Math.atan2(var24 + this.mXi1w1 * var22, this.mwd1 * var22);
var var34=Math.sqrt(var26 * var26 + (var28 + this.mXi2w2 * var26) * (var28 + this.mXi2w2 * var26) / this.mwd2 / this.mwd2);
var var36=Math.atan2(var28 + this.mXi2w2 * var26, this.mwd2 * var26);
var1.setColor$java_awt_Color($I$(1).blue);
for (var var40=0; var40 < 481; var40++) {
this.mt=var40 * this.mdt;
this.mx11[var40]=var30 * Math.cos(this.mwd1 * this.mt - var32) * this.u1[0] * Math.exp(-this.mXi1w1 * this.mt) ;
if (var40 == 0) {
this.mAmp1=this.mx11[var40];
} else {
var1.drawLine$I$I$I$I(30 + (var40 - 1), ((100.0 - this.mx11[var40 - 1] * this.myscale)|0), 30 + var40, ((100.0 - this.mx11[var40] * this.myscale)|0));
}}
var1.setColor$java_awt_Color($I$(1).green);
for (var var41=0; var41 < 481; var41++) {
this.mt=var41 * this.mdt;
this.mx12[var41]=var34 * Math.cos(this.mwd2 * this.mt - var36) * this.u2[0] * Math.exp(-this.mXi2w2 * this.mt) ;
if (var41 == 0) {
this.mAmp1=this.mx12[var41];
} else {
var1.drawLine$I$I$I$I(30 + (var41 - 1), ((200.0 - this.mx12[var41 - 1] * this.myscale)|0), 30 + var41, ((200.0 - this.mx12[var41] * this.myscale)|0));
}}
var1.setColor$java_awt_Color($I$(1).red);
for (var var42=2; var42 < 481; var42+=2) {
var1.drawLine$I$I$I$I(30 + (var42 - 1), ((301.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)|0), 30 + var42 + 1 , ((299.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)|0));
var1.drawLine$I$I$I$I(30 + (var42 - 1), ((299.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)|0), 30 + var42 + 1 , ((301.0 - (this.mx11[var42] + this.mx12[var42]) * this.myscale)|0));
}
var1.setColor$java_awt_Color($I$(1).orange);
for (var var43=0; var43 < 481; var43++) {
this.mt=var43 * this.mdt;
this.mx21[var43]=var30 * Math.cos(this.mwd1 * this.mt - var32) * this.u1[1] * Math.exp(-this.mXi1w1 * this.mt) ;
}
var1.setColor$java_awt_Color($I$(1).green);
for (var var44=0; var44 < 481; var44++) {
this.mt=var44 * this.mdt;
this.mx22[var44]=var34 * Math.cos(this.mwd2 * this.mt - var36) * this.u2[1] * Math.exp(-this.mXi2w2 * this.mt) ;
}
var1.setColor$java_awt_Color($I$(1).red);
for (var var45=0; var45 < 481; var45+=2) {
var1.drawLine$I$I$I$I(30 + (var45 - 1), ((401.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)|0), 30 + var45 + 1 , ((399.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)|0));
var1.drawLine$I$I$I$I(30 + (var45 - 1), ((399.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)|0), 30 + var45 + 1 , ((401.0 - (this.mx21[var45] + this.mx22[var45]) * this.myscale)|0));
}
var1.setColor$java_awt_Color($I$(1).black);
this.Response$();
for (var var46=0; var46 < 481; var46++) {
if (var46 == 0) {
this.mAmp1=0.0;
} else {
var1.drawLine$I$I$I$I(30 + (var46 - 1), ((300.0 - this.mx_exact1[var46 - 1] * this.myscale)|0), 30 + var46, ((300.0 - this.mx_exact1[var46] * this.myscale)|0));
}if (var46 == 0) {
this.mAmp1=0.0;
} else {
var1.drawLine$I$I$I$I(30 + (var46 - 1), ((400.0 - this.mx_exact2[var46 - 1] * this.myscale)|0), 30 + var46, ((400.0 - this.mx_exact2[var46] * this.myscale)|0));
}}
});

Clazz.newMeth(C$, 'Response$',  function () {
var var4=Clazz.array(Double.TYPE, [500]);
var var5=Clazz.array(Double.TYPE, [500]);
var var6=Clazz.array(Double.TYPE, [500]);
var var7=Clazz.array(Double.TYPE, [500]);
var var8=Clazz.array(Double.TYPE, [500]);
var var9=Clazz.array(Double.TYPE, [500]);
var var10=Clazz.array(Double.TYPE, [500]);
var var11=Clazz.array(Double.TYPE, [500]);
var6[0]=this.mx10;
var7[0]=this.mv10;
this.mx_exact1[0]=var6[0];
var9[0]=this.mx20;
var10[0]=this.mv20;
this.mx_exact2[0]=var9[0];
for (var var1=0; var1 < 481; var1++) {
var8[var1]=(-this.mk1 * var6[var1] - this.mc1 * var7[var1] + this.mk2 * (var9[var1] - var6[var1]) + this.mc2 * (var10[var1] - var7[var1])) / this.mm1;
var11[var1]=(-this.mk2 * (var9[var1] - var6[var1]) - this.mc2 * (var10[var1] - var7[var1])) / this.mm2;
var6[var1 + 1]=var6[var1] + var7[var1] * this.mdt / 2.0;
var9[var1 + 1]=var9[var1] + var10[var1] * this.mdt / 2.0;
var7[var1 + 1]=var7[var1] + var8[var1] * this.mdt / 2.0;
var10[var1 + 1]=var10[var1] + var11[var1] * this.mdt / 2.0;
var8[var1 + 1]=(-this.mk1 * var6[var1 + 1] - this.mc1 * var7[var1 + 1] + this.mk2 * (var9[var1 + 1] - var6[var1 + 1]) + this.mc2 * (var10[var1 + 1] - var7[var1 + 1])) / this.mm1;
var11[var1 + 1]=(-this.mk2 * (var9[var1 + 1] - var6[var1 + 1]) - this.mc2 * (var10[var1 + 1] - var7[var1 + 1])) / this.mm2;
var6[var1 + 2]=var6[var1] + var7[var1 + 1] * this.mdt / 2.0;
var9[var1 + 2]=var9[var1] + var10[var1 + 1] * this.mdt / 2.0;
var7[var1 + 2]=var7[var1] + var8[var1 + 1] * this.mdt / 2.0;
var10[var1 + 2]=var10[var1] + var11[var1 + 1] * this.mdt / 2.0;
var8[var1 + 2]=(-this.mk1 * var6[var1 + 2] - this.mc1 * var7[var1 + 2] + this.mk2 * (var9[var1 + 2] - var6[var1 + 2]) + this.mc2 * (var10[var1 + 2] - var7[var1 + 2])) / this.mm1;
var11[var1 + 2]=(-this.mk2 * (var9[var1 + 2] - var6[var1 + 2]) - this.mc2 * (var10[var1 + 2] - var7[var1 + 2])) / this.mm2;
var6[var1 + 3]=var6[var1] + var7[var1 + 2] * this.mdt;
var9[var1 + 3]=var9[var1] + var10[var1 + 2] * this.mdt;
var7[var1 + 3]=var7[var1] + var8[var1 + 2] * this.mdt;
var10[var1 + 3]=var10[var1] + var11[var1 + 2] * this.mdt;
var8[var1 + 3]=(-this.mk1 * var6[var1 + 3] - this.mc1 * var7[var1 + 3] + this.mk2 * (var9[var1 + 3] - var6[var1 + 3]) + this.mc2 * (var10[var1 + 3] - var7[var1 + 3])) / this.mm1;
var11[var1 + 3]=(-this.mk2 * (var9[var1 + 3] - var6[var1 + 3]) - this.mc2 * (var10[var1 + 3] - var7[var1 + 3])) / this.mm2;
var6[var1 + 1]=var6[var1] + (var7[var1] + 2.0 * var7[var1 + 1] + 2.0 * var7[var1 + 2] + var7[var1 + 3]) * this.mdt / 6.0;
var9[var1 + 1]=var9[var1] + (var10[var1] + 2.0 * var10[var1 + 1] + 2.0 * var10[var1 + 2] + var10[var1 + 3]) * this.mdt / 6.0;
var7[var1 + 1]=var7[var1] + (var8[var1] + 2.0 * var8[var1 + 1] + 2.0 * var8[var1 + 2] + var8[var1 + 3]) * this.mdt / 6.0;
var10[var1 + 1]=var10[var1] + (var11[var1] + 2.0 * var11[var1 + 1] + 2.0 * var11[var1 + 2] + var11[var1 + 3]) * this.mdt / 6.0;
var4[var1 + 1]=var6[var1 + 1];
var5[var1 + 1]=var9[var1 + 1];
this.mx_exact1[var1 + 1]=var4[var1 + 1];
this.mx_exact2[var1 + 1]=var5[var1 + 1];
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

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog7_Eigen2DOF_CFrame$I$D',  function (var1, var2, var3) {
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
break;
case 7:
this.mx10=var3;
break;
case 8:
this.mv10=var3;
break;
case 9:
this.mx20=var3;
break;
case 10:
this.mv20=var3;
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

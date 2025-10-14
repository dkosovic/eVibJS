(function(){var P$=Clazz.newPackage("Modal.Prog3.Eigen2DOF"),I$=[[0,'java.awt.Color','jama.Matrix','jama.EigenvalueDecomposition','Modal.Prog3.Eigen2DOF.CUtility']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'Modal.Prog3.Eigen2DOF.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mk1=1.0;
this.mm1=1.0;
this.mc1=0.08;
this.mk2=1.0;
this.mm2=1.0;
this.mc2=0.08;
},1);

C$.$fields$=[['D',['mk1','mm1','mc1','mk2','mm2','mc2','store','wn1','wn2','Xi1','Xi2'],'O',['M','jama.Matrix','+K','+C','+H','+J','+D','lambda_real','double[]','+lambda_imag','+lambda']]]

Clazz.newMeth(C$, 'c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$Modal_Prog3_Eigen2DOF_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
var1.setPaintMode$();
Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).black);
var var17=Clazz.array(Double.TYPE, [2, 2]);
var17[0][0]=this.mm1;
var17[0][1]=0.0;
var17[1][0]=0.0;
var17[1][1]=this.mm2;
this.M=Clazz.new_($I$(2,1).c$$DAA,[var17]);
var var18=Clazz.array(Double.TYPE, [2, 2]);
var18[0][0]=this.mk1 + this.mk2;
var18[0][1]=-this.mk2;
var18[1][0]=-this.mk2;
var18[1][1]=this.mk2;
this.K=Clazz.new_($I$(2,1).c$$DAA,[var18]);
var var19=Clazz.array(Double.TYPE, [2, 2]);
var19[0][0]=this.mc1 + this.mc2;
var19[0][1]=-this.mc2;
var19[1][0]=-this.mc2;
var19[1][1]=this.mc2;
this.C=Clazz.new_($I$(2,1).c$$DAA,[var19]);
var var20=this.M.inverse$();
this.H=var20.times$jama_Matrix(this.K);
this.J=var20.times$jama_Matrix(this.C);
var var21=Clazz.array(Double.TYPE, [4, 4]);
var21[0][0]=0.0;
var21[0][1]=0.0;
var21[0][2]=-1.0;
var21[0][3]=0.0;
var21[1][0]=0.0;
var21[1][1]=0.0;
var21[1][2]=0.0;
var21[1][3]=-1.0;
var21[2][0]=this.H.get$I$I(0, 0);
var21[2][1]=this.H.get$I$I(0, 1);
var21[2][2]=this.J.get$I$I(0, 0);
var21[2][3]=this.J.get$I$I(0, 1);
var21[3][0]=this.H.get$I$I(1, 0);
var21[3][1]=this.H.get$I$I(1, 1);
var21[3][2]=this.J.get$I$I(1, 0);
var21[3][3]=this.J.get$I$I(1, 1);
this.D=Clazz.new_($I$(2,1).c$$DAA,[var21]);
var var22=Clazz.new_($I$(3,1).c$$jama_Matrix,[this.D]);
this.lambda_real=var22.getRealEigenvalues$();
this.lambda_imag=var22.getImagEigenvalues$();
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
}var var4=($s$[0] = 40, $s$[0]);
var var5=($s$[0] = 25, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[0]) + " + i" + $I$(4).nns$D(this.lambda_imag[0]) , var4, var5);
var5=($s$[0] = 55, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[1]) + " - i" + $I$(4,"nns$D",[Math.abs(this.lambda_imag[1])]) , var4, var5);
var4=($s$[0] = 260, $s$[0]);
var5=($s$[0] = 25, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[2]) + " + i" + $I$(4).nns$D(this.lambda_imag[2]) , var4, var5);
var5=($s$[0] = 55, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[2]) + " - i" + $I$(4,"nns$D",[Math.abs(this.lambda_imag[2])]) , var4, var5);
var var24=($s$[0] = 126, $s$[0]);
var5=($s$[0] = 109, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_imag[0]) + " rad/s", var24, var5);
var24=($s$[0] = 54, $s$[0]);
var5=($s$[0] = 140, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[0]) + " rad/s", var24, var5);
var24=($s$[0] = 346, $s$[0]);
var var37=($s$[0] = 109, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_imag[2]) + " rad/s", var24, var37);
var24=($s$[0] = 274, $s$[0]);
var37=($s$[0] = 140, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.lambda_real[2]) + " rad/s", var24, var37);
this.store=this.lambda_imag[0] / this.lambda_real[0];
this.Xi1=Math.sqrt(1.0 / (1.0 + this.store * this.store));
this.wn1=this.lambda_imag[0] / Math.sqrt(1.0 - this.Xi1 * this.Xi1);
this.store=this.lambda_imag[2] / this.lambda_real[2];
this.Xi2=Math.sqrt(1.0 / (1.0 + this.store * this.store));
this.wn2=this.lambda_imag[2] / Math.sqrt(1.0 - this.Xi2 * this.Xi2);
var var28=($s$[0] = 50, $s$[0]);
var37=($s$[0] = 189, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.wn1) + " rad/s", var28, var37);
var28=($s$[0] = 34, $s$[0]);
var37=($s$[0] = 211, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.Xi1), var28, var37);
var28=($s$[0] = 270, $s$[0]);
var37=($s$[0] = 189, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.wn2) + " rad/s", var28, var37);
var28=($s$[0] = 254, $s$[0]);
var37=($s$[0] = 211, $s$[0]);
var1.drawString$S$I$I($I$(4).nns$D(this.Xi2), var28, var37);
this.Eigenvalues$jama_Matrix$jama_Matrix(this.M, this.K);
var1.drawString$S$I$I($I$(4,"nns$D",[Math.sqrt(this.lambda[0])]) + " rad/s", 50, 279);
var1.drawString$S$I$I($I$(4,"nns$D",[Math.sqrt(this.lambda[1])]) + " rad/s", 270, 279);
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

Clazz.newMeth(C$, 'ControlMessage$Modal_Prog3_Eigen2DOF_CFrame$I$D',  function (var1, var2, var3) {
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
var $s$ = new Int16Array(1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

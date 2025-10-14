(function(){var P$=Clazz.newPackage("MultiDOF.Prog1.Modes"),I$=[[0,'java.awt.Color','MultiDOF.Prog1.Modes.CUtility','jama.Matrix','jama.EigenvalueDecomposition']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CFrameAnimation", null, 'MultiDOF.Prog1.Modes.CFrame');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mwn=Clazz.array(Double.TYPE, [3]);
this.mmoden=Clazz.array(Double.TYPE, [3, 3]);
this.mm=1.0;
this.mk1=10.0;
this.mk2=10.0;
this.md=0.8;
this.mm3=0.5;
this.mk3=10.0;
},1);

C$.$fields$=[['Z',['mDragMain','mDragThumb','mDragThumbnail'],'D',['mTime','mViewTime','mT','myscale','mdispmax','mm','mk1','mk2','md','mm3','mk3','mW'],'I',['mState','mxEdge'],'O',['mwn','double[]','mmoden','double[][]','mStartButton','java.awt.Button','+mPauseButton','+mStopButton','M','jama.Matrix','+K','+D','lambda','double[]','+u']]
,['D',['dt']]]

Clazz.newMeth(C$, 'c$$MultiDOF_Prog1_Modes_CFramePanel$I$I$I$I',  function (var1, var2, var3, var4, var5) {
;C$.superclazz.c$$MultiDOF_Prog1_Modes_CFramePanel$I$I$I$I.apply(this,[var1, var2, var3, var4, var5]);C$.$init$.apply(this);
this.mTime=0.0;
this.modes$();
}, 1);

Clazz.newMeth(C$, 'Frame$java_awt_Graphics',  function (var1) {
this.mxEdge=20;
var var6=25.0 * this.mmoden[0][0];
var var8=25.0 * this.mmoden[0][1];
var var10=25.0 * this.mmoden[0][2];
var var12=var6 + (var8 - var6) * this.md;
var var2=((var6 * Math.sin(this.mwn[0] * this.mTime))|0);
var var3=((var8 * Math.sin(this.mwn[0] * this.mTime))|0);
var var4=((var10 * Math.sin(this.mwn[0] * this.mTime))|0);
var var5=((var12 * Math.sin(this.mwn[0] * this.mTime))|0);
var1.setPaintMode$();
var1.setColor$java_awt_Color($I$(1).white);
var1.fillRect$I$I$I$I(0, 0, this.width, this.height);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 235, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var var15=(163 + var2 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 235, this.mxEdge - 6, ((235.0 + var15 / 2.0)|0));
for (var var14=1; var14 < 10; var14++) {
if (var14 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + (2 * var14 - 1) * var15 / 2.0)|0), this.mxEdge - 6, ((235.0 + (2 * var14 + 1) * var15 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((235.0 + (2 * var14 - 1) * var15 / 2.0)|0), this.mxEdge + 6, ((235.0 + (2 * var14 + 1) * var15 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + 19.0 * var15 / 2.0)|0), this.mxEdge, 161 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var var17=(163 + var3 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, ((235.0 + var17 / 2.0)|0));
for (var var38=1; var38 < 10; var38++) {
if (var38 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + (2 * var38 - 1) * var17 / 2.0)|0), this.mxEdge + 200 - 6, ((235.0 + (2 * var38 + 1) * var17 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((235.0 + (2 * var38 - 1) * var17 / 2.0)|0), this.mxEdge + 200 + 6 , ((235.0 + (2 * var38 + 1) * var17 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + 19.0 * var17 / 2.0)|0), this.mxEdge + 200, 161 + var3 + 2 );
var var19=Clazz.new_($I$(1,1).c$$F$F$F,[0.18, 0.58, 0.58]);
var1.setColor$java_awt_Color(var19);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 + 1 , this.mxEdge + 200, 161 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
var1.setColor$java_awt_Color($I$(1).black);
var var20=(60 + var5 - var4) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0), 99 + var4, this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + var20 / 2.0 )|0));
for (var var39=1; var39 < 10; var39++) {
if (var39 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var39 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var39 + 1) * var20 / 2.0 )|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var39 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var39 + 1) * var20 / 2.0 )|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + 19.0 * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0), 160 + var5);
var1.setColor$java_awt_Color(var19);
var1.fillRect$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 10, 89 + var4, 20, 10);
this.mxEdge=275;
var6=25.0 * this.mmoden[1][0];
var8=25.0 * this.mmoden[1][1];
var10=25.0 * this.mmoden[1][2];
var12=var6 + (var8 - var6) * this.md;
var2=((var6 * Math.sin(this.mwn[1] * this.mTime))|0);
var3=((var8 * Math.sin(this.mwn[1] * this.mTime))|0);
var4=((var10 * Math.sin(this.mwn[1] * this.mTime))|0);
var5=((var12 * Math.sin(this.mwn[1] * this.mTime))|0);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 235, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var15=(163 + var2 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 235, this.mxEdge - 6, ((235.0 + var15 / 2.0)|0));
for (var var40=1; var40 < 10; var40++) {
if (var40 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + (2 * var40 - 1) * var15 / 2.0)|0), this.mxEdge - 6, ((235.0 + (2 * var40 + 1) * var15 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((235.0 + (2 * var40 - 1) * var15 / 2.0)|0), this.mxEdge + 6, ((235.0 + (2 * var40 + 1) * var15 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + 19.0 * var15 / 2.0)|0), this.mxEdge, 161 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var17=(163 + var3 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, ((235.0 + var17 / 2.0)|0));
for (var var41=1; var41 < 10; var41++) {
if (var41 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + (2 * var41 - 1) * var17 / 2.0)|0), this.mxEdge + 200 - 6, ((235.0 + (2 * var41 + 1) * var17 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((235.0 + (2 * var41 - 1) * var17 / 2.0)|0), this.mxEdge + 200 + 6 , ((235.0 + (2 * var41 + 1) * var17 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + 19.0 * var17 / 2.0)|0), this.mxEdge + 200, 161 + var3 + 2 );
var1.setColor$java_awt_Color(var19);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 + 1 , this.mxEdge + 200, 161 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
var1.setColor$java_awt_Color($I$(1).black);
var20=(60 + var5 - var4) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0), 99 + var4, this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + var20 / 2.0 )|0));
for (var var42=1; var42 < 10; var42++) {
if (var42 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var42 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var42 + 1) * var20 / 2.0 )|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var42 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var42 + 1) * var20 / 2.0 )|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + 19.0 * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0), 160 + var5);
var1.setColor$java_awt_Color(var19);
var1.fillRect$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 10, 89 + var4, 20, 10);
this.mxEdge=530;
var6=25.0 * this.mmoden[2][0];
var8=25.0 * this.mmoden[2][1];
var10=25.0 * this.mmoden[2][2];
var12=var6 + (var8 - var6) * this.md;
var2=((var6 * Math.sin(this.mwn[2] * this.mTime))|0);
var3=((var8 * Math.sin(this.mwn[2] * this.mTime))|0);
var4=((var10 * Math.sin(this.mwn[2] * this.mTime))|0);
var5=((var12 * Math.sin(this.mwn[2] * this.mTime))|0);
var1.setColor$java_awt_Color($I$(1).orange);
var1.fillRect$I$I$I$I(this.mxEdge - 10, 235, 220, 20);
var1.setColor$java_awt_Color($I$(1).black);
var15=(163 + var2 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge, 235, this.mxEdge - 6, ((235.0 + var15 / 2.0)|0));
for (var var43=1; var43 < 10; var43++) {
if (var43 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + (2 * var43 - 1) * var15 / 2.0)|0), this.mxEdge - 6, ((235.0 + (2 * var43 + 1) * var15 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge - 6, ((235.0 + (2 * var43 - 1) * var15 / 2.0)|0), this.mxEdge + 6, ((235.0 + (2 * var43 + 1) * var15 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 6, ((235.0 + 19.0 * var15 / 2.0)|0), this.mxEdge, 161 + var2 + 2 );
var1.setColor$java_awt_Color($I$(1).black);
var17=(163 + var3 - 235) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + 200, 235, this.mxEdge + 200 - 6, ((235.0 + var17 / 2.0)|0));
for (var var44=1; var44 < 10; var44++) {
if (var44 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + (2 * var44 - 1) * var17 / 2.0)|0), this.mxEdge + 200 - 6, ((235.0 + (2 * var44 + 1) * var17 / 2.0)|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + 200 - 6, ((235.0 + (2 * var44 - 1) * var17 / 2.0)|0), this.mxEdge + 200 + 6 , ((235.0 + (2 * var44 + 1) * var17 / 2.0)|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + 200 + 6 , ((235.0 + 19.0 * var17 / 2.0)|0), this.mxEdge + 200, 161 + var3 + 2 );
var1.setColor$java_awt_Color(var19);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 + 1 , this.mxEdge + 200, 161 + var3 + 1 );
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2, this.mxEdge + 200, 161 + var3);
var1.drawLine$I$I$I$I(this.mxEdge, 161 + var2 - 1, this.mxEdge + 200, 161 + var3 - 1);
var1.setColor$java_awt_Color($I$(1).black);
var20=(60 + var5 - var4) / 10.0;
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0), 99 + var4, this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + var20 / 2.0 )|0));
for (var var45=1; var45 < 10; var45++) {
if (var45 % 2 == 0) {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var45 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var45 + 1) * var20 / 2.0 )|0));
} else {
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 6, ((99 + var4 + (2 * var45 - 1) * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + (2 * var45 + 1) * var20 / 2.0 )|0));
}}
var1.drawLine$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) + 6 , ((99 + var4 + 19.0 * var20 / 2.0 )|0), this.mxEdge + ((200.0 * this.md)|0), 160 + var5);
var1.setColor$java_awt_Color(var19);
var1.fillRect$I$I$I$I(this.mxEdge + ((200.0 * this.md)|0) - 10, 89 + var4, 20, 10);
var1.setColor$java_awt_Color($I$(1).black);
var1.drawString$S$I$I("First Mode", 90, 275);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mwn[0] / (6.283185307179586)]) + " Hz" , 40, 295);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmoden[0][0]) + " : " + $I$(2).nns$D(this.mmoden[0][1]) + " : " + $I$(2).nns$D(this.mmoden[0][2]) , 25, 315);
var1.drawString$S$I$I("Second Mode", 335, 275);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mwn[1] / (6.283185307179586)]) + " Hz" , 295, 295);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmoden[1][0]) + " : " + $I$(2).nns$D(this.mmoden[1][1]) + " : " + $I$(2).nns$D(this.mmoden[1][2]) , 280, 315);
var1.drawString$S$I$I("Third Mode", 590, 275);
var1.drawString$S$I$I(" Natural frequency " + $I$(2,"nns$D",[this.mwn[2] / (6.283185307179586)]) + " Hz" , 550, 295);
var1.drawString$S$I$I(" Mode shape " + $I$(2).nns$D(this.mmoden[2][0]) + " : " + $I$(2).nns$D(this.mmoden[2][1]) + " : " + $I$(2).nns$D(this.mmoden[2][2]) , 535, 315);
});

Clazz.newMeth(C$, 'modes$',  function () {
var var1=1.0;
var var8=Clazz.array(Double.TYPE, [3, 3]);
var8[0][0]=this.mm;
var8[0][1]=0.0;
var8[0][2]=0.0;
var8[1][0]=0.0;
var8[1][1]=this.mm * var1 * var1  / 12.0;
var8[1][2]=0.0;
var8[2][0]=0.0;
var8[2][1]=0.0;
var8[2][2]=this.mm3;
this.M=Clazz.new_($I$(3,1).c$$DAA,[var8]);
var var9=Clazz.array(Double.TYPE, [3, 3]);
var9[0][0]=this.mk1 + this.mk2 + this.mk3 ;
var9[0][1]=(this.mk1 - this.mk2) * var1 / 2.0 - this.mk3 * (this.md - var1 / 2.0);
var9[0][2]=-this.mk3;
var9[1][0]=var9[0][1];
var9[1][1]=(this.mk1 + this.mk2) * var1 * var1  / 4.0 + this.mk3 * (this.md - var1 / 2.0) * (this.md - var1 / 2.0) ;
var9[1][2]=this.mk3 * (this.md - var1 / 2.0);
var9[2][0]=var9[0][2];
var9[2][1]=var9[1][2];
var9[2][2]=this.mk3;
this.K=Clazz.new_($I$(3,1).c$$DAA,[var9]);
this.Eigenvalues$jama_Matrix$jama_Matrix(this.M, this.K);
for (var var6=0; var6 < 3; var6++) {
this.mwn[var6]=Math.sqrt(this.lambda[var6]);
}
for (var var10=0; var10 < 3; var10++) {
this.Eigenvector$jama_Matrix$jama_Matrix$D(this.M, this.K, this.lambda[var10]);
this.mmoden[var10][0]=this.u[0] + this.u[1] * var1 / 2.0;
var var3=Math.abs(this.mmoden[var10][0]);
this.mmoden[var10][1]=this.u[0] - this.u[1] * var1 / 2.0;
if (Math.abs(this.mmoden[var10][1]) > var3 ) {
var3=Math.abs(this.mmoden[var10][1]);
}this.mmoden[var10][2]=this.u[2];
if (Math.abs(this.mmoden[var10][2]) > var3 ) {
var3=Math.abs(this.mmoden[var10][2]);
}for (var var7=0; var7 < 3; var7++) {
this.mmoden[var10][var7]=this.mmoden[var10][var7] / var3;
}
}
});

Clazz.newMeth(C$, 'Eigenvalues$jama_Matrix$jama_Matrix',  function (var1, var2) {
var var3=var2.getRowDimension$();
var var8=var1.inverse$();
this.D=var8.times$jama_Matrix(var2);
var var9=Clazz.new_($I$(4,1).c$$jama_Matrix,[this.D]);
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
var var12=Clazz.new_($I$(3,1).c$$DAA,[var8]);
for (var var15=0; var15 < var5 - 1; var15++) {
var9[var15][0]=-var11.get$I$I(var15, var5 - 1);
}
var var13=Clazz.new_($I$(3,1).c$$DAA,[var9]);
var var14=var12.solve$jama_Matrix(var13);
for (var var16=0; var16 < var5 - 1; var16++) {
this.u[var16]=var14.get$I$I(var16, 0);
}
});

Clazz.newMeth(C$, 'ControlMessage$MultiDOF_Prog1_Modes_CFrame$I$D',  function (var1, var2, var3) {
var var5=false;
switch (var2) {
case 0:
if (this.mState == 1) {
this.mTime+=var3;
}var5=true;
break;
case 1:
this.ChangeRunState$I((var3|0));
break;
case 2:
this.mm=var3;
this.modes$();
break;
case 3:
this.mk1=var3;
this.modes$();
break;
case 4:
this.mk2=var3;
this.modes$();
break;
case 5:
this.md=var3;
this.modes$();
break;
case 6:
this.mm3=var3;
this.modes$();
break;
case 7:
this.mk3=var3;
this.modes$();
}
if (var5) {
this.repaint$();
}});

Clazz.newMeth(C$, 'ChangeRunState$I',  function (var1) {
switch (this.mState) {
case 0:
if (var1 == 1) {
this.mTime=0.0;
this.mState=1;
}break;
case 1:
if (var1 == 2 || var1 == 0 ) {
this.mState=var1;
}break;
case 2:
if (var1 == 0 || var1 == 1 ) {
this.mState=var1;
}}
this.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, 'UpdateButtonAppearance$',  function () {
this.mFramePanel.repaint$();
});

Clazz.newMeth(C$, 'UserDrag$I',  function (var1) {
if (this.mState == 1) {
this.ChangeRunState$I(2);
}this.mViewTime=this.mViewTime - var1 * C$.dt;
this.repaint$();
});

C$.$static$=function(){C$.$static$=0;
C$.dt=0.01;
};

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:50 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

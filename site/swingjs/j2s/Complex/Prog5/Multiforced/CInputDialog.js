(function(){var P$=Clazz.newPackage("Complex.Prog5.Multiforced"),I$=[[0,'java.awt.BorderLayout','javax.swing.JPanel','javax.swing.JButton','java.awt.GridLayout','javax.swing.JLabel','javax.swing.JTextField']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CInputDialog", null, 'javax.swing.JFrame', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mSMD','Complex.Prog5.Multiforced.CSpringMassDamper','mViscCheckboxGroup','javax.swing.ButtonGroup','mDampingText','javax.swing.JTextField','+mMassText','+mSpringText','mDampingUnitLabel','javax.swing.JLabel','mAbutmentCheckbox','javax.swing.JCheckBox','mMassPanel','javax.swing.JPanel','+mSpringPanel','+mDampingPanel']]]

Clazz.newMeth(C$, 'c$$Complex_Prog5_Multiforced_CSpringMassDamper$S',  function (var1, var2) {
;C$.superclazz.c$$S.apply(this,[var2]);C$.$init$.apply(this);
this.mSMD=var1;
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var var3=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("South", var3);
var var4=Clazz.new_($I$(3,1).c$$S,["OK"]);
var4.addActionListener$java_awt_event_ActionListener(this);
var3.add$java_awt_Component(var4);
var var5=Clazz.new_($I$(3,1).c$$S,["Cancel"]);
var5.addActionListener$java_awt_event_ActionListener(this);
var3.add$java_awt_Component(var5);
var var6=Clazz.new_($I$(2,1));
var6.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 1]));
this.add$S$java_awt_Component("North", var6);
var var7=Clazz.new_($I$(2,1));
var7.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 1]));
var6.add$java_awt_Component(var7);
this.mMassPanel=Clazz.new_($I$(2,1));
var7.add$java_awt_Component(this.mMassPanel);
this.mMassPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["Mass:"]));
this.mMassText=Clazz.new_([String.valueOf$D(var1.mMass), 10],$I$(6,1).c$$S$I);
this.mMassPanel.add$java_awt_Component(this.mMassText);
this.mMassPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["kg"]));
var var8=Clazz.new_($I$(2,1));
var8.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 1]));
var6.add$java_awt_Component(var8);
var var9=Clazz.new_($I$(2,1));
var9.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 1]));
var6.add$java_awt_Component(var9);
if (var1.mIndex > 1) {
this.mSpringPanel=Clazz.new_($I$(2,1));
var8.add$java_awt_Component(this.mSpringPanel);
this.mSpringPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["Spring:"]));
this.mSpringText=Clazz.new_([String.valueOf$D(var1.mSpringConstant), 10],$I$(6,1).c$$S$I);
this.mSpringPanel.add$java_awt_Component(this.mSpringText);
this.mSpringPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["N/m"]));
this.mDampingPanel=Clazz.new_($I$(2,1));
var9.add$java_awt_Component(this.mDampingPanel);
this.mDampingPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["Damper:"]));
this.mDampingText=Clazz.new_([String.valueOf$D(var1.mDampingConstant), 10],$I$(6,1).c$$S$I);
this.mDampingPanel.add$java_awt_Component(this.mDampingText);
this.mDampingPanel.add$java_awt_Component(Clazz.new_($I$(5,1).c$$S,["Ns/m"]));
}}, 1);

Clazz.newMeth(C$, 'SetViscousState$Z',  function (var1) {
if (this.mDampingUnitLabel != null ) {
if (var1) {
this.mDampingUnitLabel.setText$S("Ns/m");
} else {
this.mDampingUnitLabel.setText$S("N/m");
}}});

Clazz.newMeth(C$, 'SetAbutmentState$Z',  function (var1) {
if (var1) {
this.mMassPanel.setVisible$Z(false);
} else {
this.mMassPanel.setVisible$Z(true);
}this.validate$();
this.repaint$();
});

Clazz.newMeth(C$, 'actionPerformed$java_awt_event_ActionEvent',  function (e) {
if (Clazz.instanceOf(e.getSource$(), "javax.swing.JButton")) {
var source=e.getSource$();
var label=source.getText$();
if (label.equals$O("OK")) {
if (this.mDampingText != null ) {
try {
var var3=java.lang.Double.parseDouble$S(this.mDampingText.getText$());
if (var3 >= 0.0 ) {
this.mSMD.mDampingConstant=var3;
}} catch (var6) {
if (Clazz.exceptionOf(var6,"NumberFormatException")){
} else {
throw var6;
}
}
}if (this.mSpringText != null ) {
try {
var var7=java.lang.Double.parseDouble$S(this.mSpringText.getText$());
if (var7 > 0.0 ) {
this.mSMD.mSpringConstant=var7;
}} catch (var5) {
if (Clazz.exceptionOf(var5,"NumberFormatException")){
} else {
throw var5;
}
}
}try {
var var8=java.lang.Double.parseDouble$S(this.mMassText.getText$());
if (var8 > 0.0 ) {
this.mSMD.mMass=var8;
}} catch (var4) {
if (Clazz.exceptionOf(var4,"NumberFormatException")){
} else {
throw var4;
}
}
this.mSMD.ControlMessage$Complex_Prog5_Multiforced_CFrame$I$D(null, 6, 0.0);
this.dispose$();
} else if (label.equals$O("Cancel")) {
this.dispose$();
}}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

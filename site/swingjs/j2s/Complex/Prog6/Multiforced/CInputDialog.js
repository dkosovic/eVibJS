(function(){var P$=Clazz.newPackage("Complex.Prog6.Multiforced"),p$1={},I$=[[0,'java.awt.BorderLayout','javax.swing.JPanel','javax.swing.JButton','java.awt.GridLayout','javax.swing.JCheckBox','javax.swing.JLabel','javax.swing.JTextField','javax.swing.ButtonGroup','java.util.Collections']],I$0=I$[0],$I$=function(i,n,m){return m?$I$(i)[n].apply(null,m):((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "CInputDialog", null, 'javax.swing.JFrame', ['java.awt.event.ActionListener', 'java.awt.event.ItemListener']);

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['mSMD','Complex.Prog6.Multiforced.CSpringMassDamper','mViscCheckboxGroup','javax.swing.ButtonGroup','mDampingText','javax.swing.JTextField','+mMassText','+mSpringText','mDampingUnitLabel','javax.swing.JLabel','mAbutmentCheckbox','javax.swing.JCheckBox','mMassPanel','javax.swing.JPanel']]]

Clazz.newMeth(C$, 'c$$Complex_Prog6_Multiforced_CSpringMassDamper$S',  function (var1, var2) {
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
var7.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 2]));
var6.add$java_awt_Component(var7);
this.mAbutmentCheckbox=Clazz.new_($I$(5,1).c$$S,["Abutment"]);
this.mAbutmentCheckbox.setSelected$Z(var1.IsAbutment$());
this.mAbutmentCheckbox.addItemListener$java_awt_event_ItemListener(this);
var7.add$java_awt_Component(this.mAbutmentCheckbox);
if (!var1.AtEnd$()) {
this.mAbutmentCheckbox.setEnabled$Z(false);
}this.mMassPanel=Clazz.new_($I$(2,1));
var7.add$java_awt_Component(this.mMassPanel);
this.mMassPanel.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["Mass:"]));
this.mMassText=Clazz.new_([String.valueOf$D(var1.mMass), 10],$I$(7,1).c$$S$I);
this.mMassPanel.add$java_awt_Component(this.mMassText);
this.mMassPanel.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["kg"]));
if (var1.mIndex > 1) {
var var8=Clazz.new_($I$(2,1));
var8.setLayout$java_awt_LayoutManager(Clazz.new_($I$(4,1).c$$I$I,[0, 3]));
var6.add$java_awt_Component(var8);
var8.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["Spring constant:"]));
this.mSpringText=Clazz.new_([String.valueOf$D(var1.mSpringConstant), 10],$I$(7,1).c$$S$I);
var8.add$java_awt_Component(this.mSpringText);
var8.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["N/m"]));
var8.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["Damping constant:"]));
this.mDampingText=Clazz.new_([String.valueOf$D(var1.mDampingConstant), 10],$I$(7,1).c$$S$I);
var8.add$java_awt_Component(this.mDampingText);
this.mDampingUnitLabel=Clazz.new_($I$(6,1).c$$S,["units not set"]);
var8.add$java_awt_Component(this.mDampingUnitLabel);
this.mViscCheckboxGroup=Clazz.new_($I$(8,1));
var8.add$java_awt_Component(Clazz.new_($I$(6,1).c$$S,["Damping type:"]));
var var9=Clazz.new_($I$(5,1).c$$S,["Viscous"]);
var8.add$java_awt_Component(var9);
this.mViscCheckboxGroup.add$javax_swing_AbstractButton(var9);
var9.addItemListener$java_awt_event_ItemListener(this);
var var10=Clazz.new_($I$(5,1).c$$S,["Hysteretic"]);
var8.add$java_awt_Component(var10);
this.mViscCheckboxGroup.add$javax_swing_AbstractButton(var10);
var10.addItemListener$java_awt_event_ItemListener(this);
var9.setSelected$Z(var1.mViscous);
var10.setSelected$Z(!!(var1.mViscous ^ true));
}this.SetViscousState$Z(var1.mViscous);
this.SetAbutmentState$Z(var1.IsAbutment$());
}, 1);

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
if (this.mViscCheckboxGroup != null ) {
var var3=p$1.getSelectedCheckboxFromGroup$javax_swing_ButtonGroup.apply(this, [this.mViscCheckboxGroup]);
var var4=var3.getText$();
this.mSMD.mViscous=var4 === "Viscous" ;
}if (this.mDampingText != null ) {
try {
var var8=java.lang.Double.parseDouble$S(this.mDampingText.getText$());
if (var8 >= 0.0 ) {
this.mSMD.mDampingConstant=var8;
}} catch (var7) {
if (Clazz.exceptionOf(var7,"NumberFormatException")){
} else {
throw var7;
}
}
}if (this.mSpringText != null ) {
try {
var var9=java.lang.Double.parseDouble$S(this.mSpringText.getText$());
if (var9 > 0.0 ) {
this.mSMD.mSpringConstant=var9;
}} catch (var6) {
if (Clazz.exceptionOf(var6,"NumberFormatException")){
} else {
throw var6;
}
}
}try {
var var10=java.lang.Double.parseDouble$S(this.mMassText.getText$());
if (var10 > 0.0 ) {
this.mSMD.mMass=var10;
}} catch (var5) {
if (Clazz.exceptionOf(var5,"NumberFormatException")){
} else {
throw var5;
}
}
this.mSMD.SetAbutment$Z(this.mAbutmentCheckbox.isSelected$());
this.mSMD.ControlMessage$Complex_Prog6_Multiforced_CFrame$I$D(null, 6, 0.0);
this.dispose$();
} else if (label.equals$O("Cancel")) {
this.dispose$();
}}});

Clazz.newMeth(C$, 'itemStateChanged$java_awt_event_ItemEvent',  function (e) {
if (Clazz.instanceOf(e.getSource$(), "javax.swing.JCheckBox")) {
var checkbox=e.getSource$();
var label=checkbox.getText$();
if (label.equals$O("Viscous")) {
this.SetViscousState$Z(true);
} else if (label.equals$O("Hysteretic")) {
this.SetViscousState$Z(false);
} else if (label.equals$O("Abutment")) {
this.SetAbutmentState$Z(checkbox.isSelected$());
}}});

Clazz.newMeth(C$, 'getSelectedCheckboxFromGroup$javax_swing_ButtonGroup',  function (group) {
for (var button, $button = $I$(9,"list$java_util_Enumeration",[group.getElements$()]).iterator$(); $button.hasNext$()&&((button=($button.next$())),1);) {
if (button.getModel$() === group.getSelection$() ) {
return button;
}}
return null;
}, p$1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:48 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

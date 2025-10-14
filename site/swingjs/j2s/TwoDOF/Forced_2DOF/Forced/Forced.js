(function(){var P$=Clazz.newPackage("TwoDOF.Forced_2DOF.Forced"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','TwoDOF.Forced_2DOF.Forced.CFramePanel','TwoDOF.Forced_2DOF.Forced.CFrameAnimation','TwoDOF.Forced_2DOF.Forced.CFrameSmallControl','TwoDOF.Forced_2DOF.Forced.CFramePicture','TwoDOF.Forced_2DOF.Forced.CFrameHelp','java.awt.Button','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forced", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','TwoDOF.Forced_2DOF.Forced.CFramePanel','mAnimFrame','TwoDOF.Forced_2DOF.Forced.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["This program is copyright, you need permission to use it. \u00a9 2000 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I);
var m1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.1, 2.0, "kg"]);
m1Control.SetLabelOffset$I$I(20, 10);
m1Control.SetTextEditable$Z(true);
var m1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, m1Image, false]);
var k1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 80, 10, 1.0, 20.0, 40.0, "N/m"]);
k1Control.SetLabelOffset$I$I(20, 10);
k1Control.SetTextEditable$Z(true);
var k1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, k1Image, false]);
var c1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 150, 10, 0.0, 0.5, 1.0, "Ns/m"]);
c1Control.SetLabelOffset$I$I(20, 10);
c1Control.SetTextEditable$Z(true);
var c1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "c1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 175, 26, 0, 0, c1Image, false]);
var m2Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 250, 10, 0.1, 0.1, 2.0, "kg"]);
m2Control.SetLabelOffset$I$I(20, 10);
m2Control.SetTextEditable$Z(true);
var m2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "m2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 285, 26, 0, 0, m2Image, false]);
var k2Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 320, 10, 1.0, 20.0, 40.0, "N/m"]);
k2Control.SetLabelOffset$I$I(20, 10);
k2Control.SetTextEditable$Z(true);
var k2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 345, 26, 0, 0, k2Image, false]);
var c2Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 7, 390, 10, 0.0, 0.01, 1.0, "Ns/m"]);
c2Control.SetLabelOffset$I$I(20, 10);
c2Control.SetTextEditable$Z(true);
var c2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "c2.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 415, 26, 0, 0, c2Image, false]);
var P1Control=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 8, 10, 60, -0.5, 0.1, 0.5, "N"]);
P1Control.SetLabelOffset$I$I(20, 10);
P1Control.SetTextEditable$Z(true);
var P1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "P1.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 76, 0, 0, P1Image, false]);
var PulsewidthControl=Clazz.new_($I$(6,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$TwoDOF_Forced_2DOF_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 9, 10, 110, 0.001, 2.0, 10.0, "sec"]);
PulsewidthControl.SetLabelOffset$I$I(20, 10);
PulsewidthControl.SetTextEditable$Z(true);
var PulsewidthImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Pulsewidth.gif");
Clazz.new_($I$(7,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 126, 0, 0, PulsewidthImage, false]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 60, 50, "This is the top mass."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 70, 0, 60, 50, "This is the top stiffness."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 140, 0, 60, 50, "This is the top damper."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 240, 0, 60, 50, "This is the bottom mass."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 310, 0, 60, 50, "This is the bottom stiffness."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 380, 0, 60, 50, "This is the bottom damper."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 55, 60, 50, "This is the force step\non the top mass."]);
Clazz.new_($I$(8,1).c$$TwoDOF_Forced_2DOF_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 105, 60, 50, "This is the time duration \nof the step."]);
this.mAnimFrame.mStartButton=Clazz.new_($I$(9,1).c$$S,["Start"]);
this.mAnimFrame.mStartButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mStartButton);
this.mAnimFrame.mPauseButton=Clazz.new_($I$(9,1).c$$S,["Pause"]);
this.mAnimFrame.mPauseButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mPauseButton);
this.mAnimFrame.mStopButton=Clazz.new_($I$(9,1).c$$S,["Stop"]);
this.mAnimFrame.mStopButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mStopButton);
this.validate$();
this.mAnimFrame.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(10,1).c$$I$java_awt_event_ActionListener,[20, this]);
this.mTimer.start$();
});

Clazz.newMeth(C$, ['actionPerformed$java_awt_event_ActionEvent','actionPerformed'],  function (e) {
if (Clazz.instanceOf(e.getSource$(), "java.awt.Button")) {
var source=e.getSource$();
var label=source.getLabel$();
if (label.equals$O("Start") || label.equals$O("Cont.") ) {
this.mAnimFrame.ControlMessage$I$D(1, 1.0);
} else if (label.equals$O("Pause")) {
this.mAnimFrame.ControlMessage$I$D(1, 2.0);
} else if (label.equals$O("Stop")) {
this.mAnimFrame.ControlMessage$I$D(1, 0.0);
}return;
}if (this.mTimer != null ) {
var ddd=Clazz.new_(java.util.Date);
var thisTime=ddd.getTime$();
if (Long.$eq(this.mLastTime,0 )) {
this.mLastTime=thisTime;
}var realSeconds=(Long.$sub(thisTime,this.mLastTime)) / 1000.0;
this.mLastTime=thisTime;
this.mAnimFrame.ControlMessage$I$D(0, realSeconds);
}});

Clazz.newMeth(C$, ['stop$','stop'],  function () {
if (this.mTimer != null ) {
this.mTimer.stop$();
this.mTimer=null;
}});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:51 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

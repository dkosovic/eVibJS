(function(){var P$=Clazz.newPackage("Beam.Prog4.Forced"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','Beam.Prog4.Forced.CFramePanel','Beam.Prog4.Forced.CFrameAnimation','Beam.Prog4.Forced.CFrameSmallControl','Beam.Prog4.Forced.CFramePicture','Beam.Prog4.Forced.CFrameHelp','java.awt.Button','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Forced", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','Beam.Prog4.Forced.CFramePanel','mAnimFrame','Beam.Prog4.Forced.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["This program is copyright, you need permission to use it. \u00a9 2003 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I);
var mControl=Clazz.new_($I$(6,1).c$$Beam_Prog4_Forced_CFramePanel$Beam_Prog4_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 10, 10, 1.0, 2.0, 10.0, "kg"]);
mControl.SetLabelOffset$I$I(20, 10);
mControl.SetTextEditable$Z(true);
var mImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "m1.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, mImage, false]);
var k1Control=Clazz.new_($I$(6,1).c$$Beam_Prog4_Forced_CFramePanel$Beam_Prog4_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 80, 10, 10.0, 20.0, 100.0, "N/m"]);
k1Control.SetLabelOffset$I$I(20, 10);
k1Control.SetTextEditable$Z(true);
var k1Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k1.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 105, 26, 0, 0, k1Image, false]);
var k2Control=Clazz.new_($I$(6,1).c$$Beam_Prog4_Forced_CFramePanel$Beam_Prog4_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 160, 10, 10.0, 20.0, 100.0, "N/m"]);
k2Control.SetLabelOffset$I$I(20, 10);
k2Control.SetTextEditable$Z(true);
var k2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "k2.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 185, 26, 0, 0, k2Image, false]);
var bControl=Clazz.new_($I$(6,1).c$$Beam_Prog4_Forced_CFramePanel$Beam_Prog4_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 240, 10, 0.0, 0.3, 1.0, " "]);
bControl.SetLabelOffset$I$I(20, 10);
bControl.SetTextEditable$Z(true);
var bImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "b.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 265, 24, 0, 0, bImage, false]);
var WinControl=Clazz.new_($I$(6,1).c$$Beam_Prog4_Forced_CFramePanel$Beam_Prog4_Forced_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 310, 10, 0.1, 1.2, 5.0, "Hz"]);
WinControl.SetLabelOffset$I$I(20, 10);
WinControl.SetTextEditable$Z(true);
var WinImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Win.gif");
Clazz.new_($I$(7,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 335, 26, 0, 0, WinImage, false]);
Clazz.new_($I$(8,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 60, 50, "This is the mass."]);
Clazz.new_($I$(8,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 70, 0, 60, 50, "This is the left stiffness."]);
Clazz.new_($I$(8,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 150, 0, 60, 50, "This is the right stiffness."]);
Clazz.new_($I$(8,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 230, 0, 60, 50, "This is the force position."]);
Clazz.new_($I$(8,1).c$$Beam_Prog4_Forced_CFramePanel$I$I$I$I$S,[this.mFramePanel, 300, 0, 60, 50, "This is the forcing \nfrequency."]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:47 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

(function(){var P$=Clazz.newPackage("General.Prog1.Tension"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','General.Prog1.Tension.CFramePanel','General.Prog1.Tension.CFrameAnimation','General.Prog1.Tension.CFrameSmallControl','General.Prog1.Tension.CFramePicture','java.awt.Button','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "Tension", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','General.Prog1.Tension.CFramePanel','mAnimFrame','General.Prog1.Tension.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,[" This program is copyright, you need permission to use it. \u00a9 2004 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I);
var MassControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.5, 1.0, 50.0, "kg"]);
MassControl.SetLabelOffset$I$I(20, 10);
MassControl.SetTextEditable$Z(true);
var mImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Mass.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 28, 0, 0, mImage, false]);
var KControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 100, 10, 10.0, 10.0, 500.0, "N/m"]);
KControl.SetLabelOffset$I$I(20, 10);
KControl.SetTextEditable$Z(true);
var KIamage=this.getImage$java_net_URL$S(this.getCodeBase$(), "K.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 128, 25, 0, 0, KIamage, false]);
var DeltaControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 190, 10, -20.0, -10.0, 100.0, "%"]);
DeltaControl.SetLabelOffset$I$I(20, 10);
DeltaControl.SetTextEditable$Z(true);
var DeltaImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Delta.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 214, 25, 0, 0, DeltaImage, false]);
var XoControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 280, 10, -80.0, 6.0, 80.0, ""]);
XoControl.SetLabelOffset$I$I(20, 10);
XoControl.SetTextEditable$Z(true);
var XoImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Xo.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 304, 25, 0, 0, XoImage, false]);
var YoControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 6, 370, 10, -80.0, 10.0, 80.0, ""]);
YoControl.SetLabelOffset$I$I(20, 10);
YoControl.SetTextEditable$Z(true);
var YoImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Yo.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 394, 25, 0, 0, YoImage, false]);
var OnOffControl=Clazz.new_($I$(6,1).c$$General_Prog1_Tension_CFramePanel$General_Prog1_Tension_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 7, 460, 10, 0.0, 0.0, 1.0, "Trace"]);
OnOffControl.SetLabelOffset$I$I(20, 10);
OnOffControl.SetTextEditable$Z(true);
OnOffControl.SetIntegerMode$Z(true);
var OnOffImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "OnOff.gif");
Clazz.new_($I$(7,1).c$$General_Prog1_Tension_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 484, 25, 0, 0, OnOffImage, false]);
this.mAnimFrame.mStartButton=Clazz.new_($I$(8,1).c$$S,["Start"]);
this.mAnimFrame.mStartButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mStartButton);
this.mAnimFrame.mPauseButton=Clazz.new_($I$(8,1).c$$S,["Pause"]);
this.mAnimFrame.mPauseButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mPauseButton);
this.mAnimFrame.mStopButton=Clazz.new_($I$(8,1).c$$S,["Stop"]);
this.mAnimFrame.mStopButton.addActionListener$java_awt_event_ActionListener(this);
buttonPanel.add$java_awt_Component(this.mAnimFrame.mStopButton);
this.validate$();
this.mAnimFrame.UpdateButtonAppearance$();
});

Clazz.newMeth(C$, ['start$','start'],  function () {
this.mTimer=Clazz.new_($I$(9,1).c$$I$java_awt_event_ActionListener,[10, this]);
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
;Clazz.setTVer('5.0.1-v7');//Created 2025-10-14 19:43:49 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7

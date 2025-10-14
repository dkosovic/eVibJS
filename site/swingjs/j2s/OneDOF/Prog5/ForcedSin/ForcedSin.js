(function(){var P$=Clazz.newPackage("OneDOF.Prog5.ForcedSin"),I$=[[0,'java.awt.BorderLayout','java.awt.Panel','java.awt.Label','OneDOF.Prog5.ForcedSin.CFramePanel','OneDOF.Prog5.ForcedSin.CFrameAnimation','OneDOF.Prog5.ForcedSin.CFrameSmallControl','OneDOF.Prog5.ForcedSin.CFramePicture','OneDOF.Prog5.ForcedSin.CFrameHelp','java.awt.Button','javax.swing.Timer']],I$0=I$[0],$I$=function(i,n){return((i=(I$[i]||(I$[i]=Clazz.load(I$0[i])))),!n&&i.$load$&&Clazz.load(i,2),i)};
/*c*/var C$=Clazz.newClass(P$, "ForcedSin", null, 'java.applet.Applet', 'java.awt.event.ActionListener');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
this.mTimer=null;
this.mLastTime=0;
},1);

C$.$fields$=[['J',['mLastTime'],'O',['mFramePanel','OneDOF.Prog5.ForcedSin.CFramePanel','mAnimFrame','OneDOF.Prog5.ForcedSin.CFrameAnimation','mTimer','javax.swing.Timer']]]

Clazz.newMeth(C$, ['init$','init'],  function () {
this.setLayout$java_awt_LayoutManager(Clazz.new_($I$(1,1)));
var buttonPanel=Clazz.new_($I$(2,1));
this.add$S$java_awt_Component("North", buttonPanel);
var copyright=Clazz.new_($I$(3,1).c$$S,["This program is copyright, you need permission to use it. \u00a9 1999 B J Stone, bjs@mech.uwa.edu.au."]);
this.add$S$java_awt_Component("South", copyright);
this.mFramePanel=Clazz.new_($I$(4,1).c$$java_applet_Applet,[this]);
this.add$S$java_awt_Component("Center", this.mFramePanel);
this.mAnimFrame=Clazz.new_([this.mFramePanel, 0, 0, this.getSize$().width, this.getSize$().height],$I$(5,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I);
var WnControl=Clazz.new_($I$(6,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$OneDOF_Prog5_ForcedSin_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 2, 10, 10, 0.1, 0.7, 1.5, "Hz"]);
WnControl.SetLabelOffset$I$I(20, 10);
WnControl.SetTextEditable$Z(true);
var wnImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "wn.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 35, 26, 0, 0, wnImage, false]);
var XiControl=Clazz.new_($I$(6,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$OneDOF_Prog5_ForcedSin_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 3, 100, 10, 0.001, 0.05, 2.0, " "]);
XiControl.SetLabelOffset$I$I(20, 10);
XiControl.SetTextEditable$Z(true);
var XiImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "xi.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 128, 25, 0, 0, XiImage, false]);
var FdivmWn2Control=Clazz.new_($I$(6,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$OneDOF_Prog5_ForcedSin_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 4, 190, 10, 0.01, 7.0, 17.0, "mm"]);
FdivmWn2Control.SetLabelOffset$I$I(20, 10);
FdivmWn2Control.SetTextEditable$Z(true);
var FdivmWn2Image=this.getImage$java_net_URL$S(this.getCodeBase$(), "FdivmWn2.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 214, 25, 0, 0, FdivmWn2Image, false]);
var WinControl=Clazz.new_($I$(6,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$OneDOF_Prog5_ForcedSin_CFrame$I$I$I$D$D$D$S,[this.mFramePanel, this.mAnimFrame, 5, 280, 10, 0.1, 1.0, 2.0, "Hz"]);
WinControl.SetLabelOffset$I$I(20, 10);
WinControl.SetTextEditable$Z(true);
var WinImage=this.getImage$java_net_URL$S(this.getCodeBase$(), "Win.gif");
Clazz.new_($I$(7,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$java_awt_Image$Z,[this.mFramePanel, 304, 27, 0, 0, WinImage, false]);
Clazz.new_($I$(8,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 0, 0, 80, 80, "This is the natural frequency\nof the system."]);
Clazz.new_($I$(8,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 90, 0, 80, 80, "This is the damping\nratio for the system."]);
Clazz.new_([this.mFramePanel, 180, 0, 80, 80, "This is the magnitude of \nthe force (N) divided by\nthe mass (kg)\ntimes nat freq. squagray."],$I$(8,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S);
Clazz.new_($I$(8,1).c$$OneDOF_Prog5_ForcedSin_CFramePanel$I$I$I$I$S,[this.mFramePanel, 270, 0, 80, 80, "This is the excitation frequency."]);
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

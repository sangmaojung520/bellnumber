package com.BellNumber;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return com.BellNumber.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="Activity.Title=\"Bell Number\"";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Bell Number"));
 BA.debugLineNum = 45;BA.debugLine="Spinner1.Add(\"2\")";
Debug.ShouldStop(4096);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("2")));
 BA.debugLineNum = 46;BA.debugLine="Spinner1.Add(\"10\")";
Debug.ShouldStop(8192);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("10")));
 BA.debugLineNum = 47;BA.debugLine="Spinner1.Add(\"22\")";
Debug.ShouldStop(16384);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("22")));
 BA.debugLineNum = 48;BA.debugLine="Spinner1.Add(\"24\")";
Debug.ShouldStop(32768);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("24")));
 BA.debugLineNum = 49;BA.debugLine="Spinner1.Add(\"79\")";
Debug.ShouldStop(65536);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("79")));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,57);
if (RapidSub.canDelegate("activity_pause")) { return com.BellNumber.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) { return com.BellNumber.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("button1_click")) { return com.BellNumber.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 62;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="If Spinner1.SelectedIndex = 0 And EditText1.Text";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 64;BA.debugLine="Label3.Text = \"Chemical Name: Helium\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Chemical Name: Helium"));
 };
 BA.debugLineNum = 66;BA.debugLine="If Spinner1.SelectedIndex = 0 And EditText1.Text";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("2"))) { 
 BA.debugLineNum = 67;BA.debugLine="Label3.Text = \"Calculated Result: Hydrogen\"";
Debug.ShouldStop(4);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Hydrogen"));
 };
 BA.debugLineNum = 69;BA.debugLine="If Spinner1.SelectedIndex = 1 And EditText1.Text";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("3"))) { 
 BA.debugLineNum = 70;BA.debugLine="Label3.Text = \"Calculated Result: Water\"";
Debug.ShouldStop(32);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Water"));
 };
 BA.debugLineNum = 72;BA.debugLine="If Spinner1.SelectedIndex = 1 And EditText1.Text";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("4"))) { 
 BA.debugLineNum = 73;BA.debugLine="Label3.Text = \"Calculated Result: Ammonia\"";
Debug.ShouldStop(256);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Ammonia"));
 };
 BA.debugLineNum = 75;BA.debugLine="If Spinner1.SelectedIndex = 2 And EditText1.Text";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 2)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 76;BA.debugLine="Label3.Text = \"Calculated Result: Titanium\"";
Debug.ShouldStop(2048);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Titanium"));
 };
 BA.debugLineNum = 78;BA.debugLine="If Spinner1.SelectedIndex = 3 And EditText1.Text";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 3)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("5"))) { 
 BA.debugLineNum = 79;BA.debugLine="Label3.Text = \"Calculated Result: Formic Acid\"";
Debug.ShouldStop(16384);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Formic Acid"));
 };
 BA.debugLineNum = 81;BA.debugLine="If Spinner1.SelectedIndex = 4 And EditText1.Text";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 4)) && RemoteObject.solveBoolean("=",main.mostCurrent._edittext1.runMethod(true,"getText"),BA.ObjectToString("1"))) { 
 BA.debugLineNum = 82;BA.debugLine="Label3.Text = \"Calculated Result: Gold\"";
Debug.ShouldStop(131072);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Calculated Result: Gold"));
 };
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Dim Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim Label3 As Label";
main.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim Spinner1 As Spinner";
main.mostCurrent._spinner1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim EditText1 As EditText";
main.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim text1 As String";
main.mostCurrent._text1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Dim text2 As String";
main.mostCurrent._text2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 33;BA.debugLine="Dim text3 As String";
main.mostCurrent._text3 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 34;BA.debugLine="Dim text4 As String";
main.mostCurrent._text4 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 35;BA.debugLine="Dim text5 As String";
main.mostCurrent._text5 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.BellNumber.main");
starter.myClass = BA.getDeviceClass ("com.BellNumber.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _spinner1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Spinner1_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("spinner1_itemclick")) { return com.BellNumber.main.remoteMe.runUserSub(false, "main","spinner1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 87;BA.debugLine="Sub Spinner1_ItemClick(Position As Int,Value As Ob";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Select Position";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_position,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4))) {
case 0: {
 BA.debugLineNum = 89;BA.debugLine="Case 0 : text1 = \"Enter 1 or 2\"";
Debug.ShouldStop(16777216);
main.mostCurrent._text1 = BA.ObjectToString("Enter 1 or 2");
 break; }
case 1: {
 BA.debugLineNum = 90;BA.debugLine="Case 1 : text2 = \"Enter 3 or 4\"";
Debug.ShouldStop(33554432);
main.mostCurrent._text2 = BA.ObjectToString("Enter 3 or 4");
 break; }
case 2: {
 BA.debugLineNum = 91;BA.debugLine="Case 2 : text3 = \"Enter 1\"";
Debug.ShouldStop(67108864);
main.mostCurrent._text3 = BA.ObjectToString("Enter 1");
 break; }
case 3: {
 BA.debugLineNum = 92;BA.debugLine="Case 3 : text4 = \"Enter 5\"";
Debug.ShouldStop(134217728);
main.mostCurrent._text4 = BA.ObjectToString("Enter 5");
 break; }
case 4: {
 BA.debugLineNum = 93;BA.debugLine="Case 4 : text5 = \"Enter 1\"";
Debug.ShouldStop(268435456);
main.mostCurrent._text5 = BA.ObjectToString("Enter 1");
 break; }
}
;
 BA.debugLineNum = 96;BA.debugLine="If Spinner1.SelectedIndex = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 97;BA.debugLine="EditText1.Hint = text1";
Debug.ShouldStop(1);
main.mostCurrent._edittext1.runMethod(true,"setHint",main.mostCurrent._text1);
 };
 BA.debugLineNum = 100;BA.debugLine="If Spinner1.SelectedIndex = 1 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 101;BA.debugLine="EditText1.Hint = text2";
Debug.ShouldStop(16);
main.mostCurrent._edittext1.runMethod(true,"setHint",main.mostCurrent._text2);
 };
 BA.debugLineNum = 104;BA.debugLine="If Spinner1.SelectedIndex = 2 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 105;BA.debugLine="EditText1.Hint = text3";
Debug.ShouldStop(256);
main.mostCurrent._edittext1.runMethod(true,"setHint",main.mostCurrent._text3);
 };
 BA.debugLineNum = 108;BA.debugLine="If Spinner1.SelectedIndex = 3 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 109;BA.debugLine="EditText1.Hint = text4";
Debug.ShouldStop(4096);
main.mostCurrent._edittext1.runMethod(true,"setHint",main.mostCurrent._text4);
 };
 BA.debugLineNum = 112;BA.debugLine="If Spinner1.SelectedIndex = 4 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._spinner1.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 4))) { 
 BA.debugLineNum = 113;BA.debugLine="EditText1.Hint = text5";
Debug.ShouldStop(65536);
main.mostCurrent._edittext1.runMethod(true,"setHint",main.mostCurrent._text5);
 };
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
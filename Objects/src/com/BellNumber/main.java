package com.BellNumber;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.BellNumber", "com.BellNumber.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.BellNumber", "com.BellNumber.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.BellNumber.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public static String _text1 = "";
public static String _text2 = "";
public static String _text3 = "";
public static String _text4 = "";
public static String _text5 = "";
public com.BellNumber.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.Title=\"Bell Number\"";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Bell Number"));
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Spinner1.Add(\"2\")";
mostCurrent._spinner1.Add("2");
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Spinner1.Add(\"10\")";
mostCurrent._spinner1.Add("10");
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Spinner1.Add(\"22\")";
mostCurrent._spinner1.Add("22");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Spinner1.Add(\"24\")";
mostCurrent._spinner1.Add("24");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Spinner1.Add(\"79\")";
mostCurrent._spinner1.Add("79");
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="If Spinner1.SelectedIndex = 0 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==0 && (mostCurrent._edittext1.getText()).equals("1")) { 
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Label3.Text = \"Chemical Name: Helium\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Chemical Name: Helium"));
 };
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="If Spinner1.SelectedIndex = 0 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==0 && (mostCurrent._edittext1.getText()).equals("2")) { 
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Label3.Text = \"Calculated Result: Hydrogen\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Hydrogen"));
 };
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="If Spinner1.SelectedIndex = 1 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==1 && (mostCurrent._edittext1.getText()).equals("3")) { 
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="Label3.Text = \"Calculated Result: Water\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Water"));
 };
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="If Spinner1.SelectedIndex = 1 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==1 && (mostCurrent._edittext1.getText()).equals("4")) { 
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="Label3.Text = \"Calculated Result: Ammonia\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Ammonia"));
 };
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="If Spinner1.SelectedIndex = 2 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==2 && (mostCurrent._edittext1.getText()).equals("1")) { 
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="Label3.Text = \"Calculated Result: Titanium\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Titanium"));
 };
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="If Spinner1.SelectedIndex = 3 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==3 && (mostCurrent._edittext1.getText()).equals("5")) { 
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="Label3.Text = \"Calculated Result: Formic Acid\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Formic Acid"));
 };
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="If Spinner1.SelectedIndex = 4 And EditText1.Text";
if (mostCurrent._spinner1.getSelectedIndex()==4 && (mostCurrent._edittext1.getText()).equals("1")) { 
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="Label3.Text = \"Calculated Result: Gold\"";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Calculated Result: Gold"));
 };
RDebugUtils.currentLine=327702;
 //BA.debugLineNum = 327702;BA.debugLine="End Sub";
return "";
}
public static String  _spinner1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spinner1_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spinner1_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Spinner1_ItemClick(Position As Int,Value As Ob";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Case 0 : text1 = \"Enter 1 or 2\"";
mostCurrent._text1 = "Enter 1 or 2";
 break; }
case 1: {
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Case 1 : text2 = \"Enter 3 or 4\"";
mostCurrent._text2 = "Enter 3 or 4";
 break; }
case 2: {
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Case 2 : text3 = \"Enter 1\"";
mostCurrent._text3 = "Enter 1";
 break; }
case 3: {
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="Case 3 : text4 = \"Enter 5\"";
mostCurrent._text4 = "Enter 5";
 break; }
case 4: {
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Case 4 : text5 = \"Enter 1\"";
mostCurrent._text5 = "Enter 1";
 break; }
}
;
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="If Spinner1.SelectedIndex = 0 Then";
if (mostCurrent._spinner1.getSelectedIndex()==0) { 
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="EditText1.Hint = text1";
mostCurrent._edittext1.setHint(mostCurrent._text1);
 };
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="If Spinner1.SelectedIndex = 1 Then";
if (mostCurrent._spinner1.getSelectedIndex()==1) { 
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="EditText1.Hint = text2";
mostCurrent._edittext1.setHint(mostCurrent._text2);
 };
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="If Spinner1.SelectedIndex = 2 Then";
if (mostCurrent._spinner1.getSelectedIndex()==2) { 
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="EditText1.Hint = text3";
mostCurrent._edittext1.setHint(mostCurrent._text3);
 };
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="If Spinner1.SelectedIndex = 3 Then";
if (mostCurrent._spinner1.getSelectedIndex()==3) { 
RDebugUtils.currentLine=393238;
 //BA.debugLineNum = 393238;BA.debugLine="EditText1.Hint = text4";
mostCurrent._edittext1.setHint(mostCurrent._text4);
 };
RDebugUtils.currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="If Spinner1.SelectedIndex = 4 Then";
if (mostCurrent._spinner1.getSelectedIndex()==4) { 
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="EditText1.Hint = text5";
mostCurrent._edittext1.setHint(mostCurrent._text5);
 };
RDebugUtils.currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="End Sub";
return "";
}
}
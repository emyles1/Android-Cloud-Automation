package objectrepository;

import io.appium.java_client.android.AndroidKeyCode;

public class Strings {

	// NavBarRepository strings  
	public final static String homeHamburger = "//android.widget.ImageButton[@index ='0']";
	public final static String PicAndVids = "//android.widget.TextView[@index = '1' and contains(@text,'Photos & Videos (')]";
	public final static String Documents = "//android.widget.TextView[@index = '3' and contains(@text,'Documents')]";
	public final static String Appsusingcloud = "//android.widget.TextView[@text = 'Apps Using Cloud')]";

	// PhotoAndVideoRespository strings
	public final static String allHeader = "//android.widget.TextView[@text = 'All']";
	public final static String timelineHeader = "//android.widget.TextView[@text = 'Timeline']";
	public final static String albumHeader = "//android.widget.TextView[@text = 'Albums']";
	public final static String favAlbum = "//android.widget.ImageView[@index = '0' and contains(@content-desc,'Favorites : Count')]";
	public final static String firstAllitem = "//android.widget.ImageView[@resource-id = 'com.vcast.mediamanager:id/icon' and @index ='0']";
	public final static String firstTimelineitem = "//android.widget.ImageView[@resource-id = 'com.vcast.mediamanager:id/icon' and @index ='1']";
	public final static String enterAlbumName = "//android.widget.EditText[@resource-id = 'com.vcast.mediamanager:id/new_album_edit']";
	public final static String addAlbumContent = "//android.widget.Button[@text = 'Add Content']";
	public final static String longPressPic = "//android.widget.ImageView[@index='2']";
	public final static String duplicateFile = "//android.widget.TextView[@text='Duplicate file']";
	public final static String infodatetaken = "//android.widget.TextView[@text = 'Date Taken']";

	// DocRespository strings
	public final static String longPressDoc = "//android.widget.RelativeLayout[@index= '0']";
	public final static String sortByDateUploaded = "//android.widget.RelativeLayout[@index ='0']";
	public final static String sortByExt = "//android.widget.RelativeLayout[@index ='2']";
	public final static String sortBySize = "//android.widget.RelativeLayout[@index ='3']";
	public final static String sortByFileName = "//android.widget.RelativeLayout[@index ='1']";
	public final static String sortByOK = "//android.widget.Button[@text ='OK']";
	public final static String sortByRadioBtnSize = "//android.widget.CheckedTextView[@text ='Size' and @checkable = 'true']";

	// ContextMenuRespostitory strings
	public final static String addFavMenu = "//android.widget.TextView[@text ='Add to Favorites']";
	public final static String removeFavMenu = "//android.widget.TextView[@text ='Remove from Favorites']";
	public final static String Elipses = "//android.widget.ImageView[@content-desc = 'OVERFLOW']";
	public final static String overflowdownload = "//android.widget.TextView[@text ='Download']";
	public final static String overflowOpen = "//android.widget.TextView[@text = 'Open']";
	public final static String SortView = "//android.widget.TextView[@text ='Sort View']";
	public final static String share = "//android.widget.TextView[@content-desc ='Share']";
	public final static String overflowcopysharelink = "//android.widget.TextView[@text ='Copy Share Link']";
	public final static String overflowdelete = "//android.widget.TextView[@text ='Delete']";
	public final static String overflowinfo = "//android.widget.TextView[@text ='Info']";
	public final static String createAlbum = "//android.widget.TextView[@resource-id ='com.vcast.mediamanager:id/new_album']";
	public final static String makeSelection = "//android.widget.ImageView[@index='0']";
	public final static String tapFullview = "//android.widget.ImageView[@resource-id = 'com.vcast.mediamanager:id/flipper_image_view_0']";
	public final static String Copyright = "//android.widget.Button[@text = 'OK']";
	public final static String selectioncheckmark = "com.vcast.mediamanager:id/action_mode_close_button";
	public final static String completeactionusing = "//android.widget.TextView[@text = 'Complete action using']";
	public final static String copyrightNotice = "//android.widget.TextView[@text = 'Copyright Notice']";

	// CommonMethods strings
	public final static String deleteYes = "//android.widget.Button[@text ='YES']";
	public final static String deleteNo = "//android.widget.Button[@text ='NO']";
	public final static String infoClose = "//android.widget.Button[@text ='CLOSE']";
	public final static String deleting = "//android.widget.TextView[@text ='Deleting. Please wait…']";
	
	//Notifications strings
	public final static String downloadComplete = "//android.widget.TextView[@text ='Download complete']";

}

// driver.findElementByXPath("//android.widget.ImageView[@index = '0' and contains(@content-desc,'Favorites : Count')]")
//driver.findElementByXPath("//android.widget.CheckedTextView[@text ='Size' and @checkable = 'true']")
// driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
// driver.findElementByAndroidUIAutomator("resourceId(\"com.raaga.android:id/music_home_raaga_live\")").click();
// driver.findElementById("com.raaga.android:id/toolbar_logo").click();
// 	CONTENT DESC driver.findElementByXPath("//android.widget.ImageView[@content-desc='Photo : IMAG0159.jpg]").click();
//driver.openNotifications();
//driver.pressKeyCode(AndroidKeyCode.BACK);
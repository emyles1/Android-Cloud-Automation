package objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidKeyCode;

public class Strings {
	
	
	
	public final static String TextView = "//android.widget.TextView";
	public final static String ImageView = "//android.widget.ImageView";
	public final static String LinerLayout = "//android.widget.LinearLayout";
	public final static String Text = "@text =";
	public final static String ContentDesc = "@content-desc = ";
	public final static String Index = "@index =";



	// NavBarRepository strings  
	public final static String homeHamburger = "//android.widget.ImageButton[@index ='0']";
	public final static String Home = "//android.widget.TextView[@index = '0' and contains(@text,'Home')]";
	public final static String PicAndVids = "//android.widget.TextView[@index = '1' and contains(@text,'Photos & Videos (')]";
	public final static String Music = "//android.widget.TextView[@index = '2' and contains(@text,'Music')]";
	public final static String Documents = "//android.widget.TextView[@index = '3' and contains(@text,'Documents')]";
	public final static String Appsusingcloud = "//android.widget.TextView[@text = 'Apps Using Cloud')]";
	public final static String AllFiles = "//android.widget.TextView[@index = '8' and contains(@text,'All Files')]";
	public final static String Settings = "//android.widget.TextView[@index = '9' and contains(@text,'Settings')]";
	public final static String Cloudicon = "com.vcast.mediamanager:id/status_icon";
	public final static String Backupnow = "com.vcast.mediamanager:id/back_up_status";


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
	
	//MusicRespository strings
	public final static String artistsHeader = "//android.widget.TextView[@text = 'Artists']";
	public final static String albumsHeader = "//android.widget.TextView[@text = 'Albums']";
	public final static String songsHeader = "//android.widget.TextView[@text = 'Songs']";
	public final static String genresHeader = "//android.widget.TextView[@text = 'Genres']";
	public final static String playlistsHeader = "//android.widget.TextView[@text = 'Playlists']";
	public final static String listItem = "com.vcast.mediamanager:id/item_wraper";
	public final static String longPressMusic = "//android.widget.LinearLayout[@index= 0]";
	public final static String addPlaylistContent = "//android.widget.Button[@text = 'Add Songs']";
	public final static String nowPlaying = "//android.widget.TextView[@text = 'Now Playing']";
	

	

	//DocRespository strings
	public final static String longPressDoc = "//android.widget.RelativeLayout[@index= '0']";
	public final static String sortByDateUploaded = "//android.widget.RelativeLayout[@index ='0']";
	public final static String sortByExt = "//android.widget.RelativeLayout[@index ='2']";
	public final static String sortBySize = "//android.widget.RelativeLayout[@index ='3']";
	public final static String sortByFileName = "//android.widget.RelativeLayout[@index ='1']";
	public final static String sortByRadioBtnSize = "//android.widget.CheckedTextView[@text ='Size' and @checkable = 'true']";
	
	//All files Strings
	public final static String mobileRepro = "//android.widget.TextView[@text= 'Mobile']";
	public final static String folderTitle = "//android.widget.TextView[@index = '1' and @resource-id = 'com.vcast.mediamanager:id/title']";
	public final static String allfileItem = "//android.widget.TextView[@index = '1' and @resource-id = 'com.vcast.mediamanager:id/title']";

	//ContextMenuRespostitory strings 
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
	public final static String selectioncheckmark = "com.vcast.mediamanager:id/action_mode_close_button";
	public final static String completeactionusing = "//android.widget.TextView[@text = 'Complete action using']";
	public final static String copyrightNotice = "//android.widget.TextView[@text = 'Copyright Notice']";
	public final static String AddtoPlaylist = "//android.widget.TextView[@text = 'Add to Playlist']";
	public final static String CreateCollage = "//android.widget.TextView[@text = 'Create Collage']";

	// CommonMethods strings
	public final static String deleteYes = "//android.widget.Button[@text ='YES']";
	public final static String deleteNo = "//android.widget.Button[@text ='NO']";
	public final static String infoClose = "//android.widget.Button[@text ='CLOSE']";
	public final static String deleting = "//android.widget.TextView[@text ='Deleting. Please wait…']";
	public final static String ButtonOK = "//android.widget.Button[@text ='OK']";
	public final static String ButtonCancel = "//android.widget.Button[@text ='CANCEL']";
	public final static String Save = "//android.widget.Button[@text ='Save']";
	
	
	//Notifications strings
	public final static String downloadComplete = "//android.widget.TextView[@text ='Download complete']";
	
	//Settings strings
	public final static String WhattoBackup = "//android.widget.TextView[@text ='What to Back Up']";
	public final static String WhatPhotos = "//android.widget.RelativeLayout[@index ='1']";
	public final static String HowtoBackup = "//android.widget.TextView[@text ='How to Back Up']";
	public final static String WhentoBackup = "//android.widget.TextView[@text ='When to Back Up']";
	public final static String MyAccount = "//android.widget.TextView[@text ='My Account']";
	public final static String ManageStorage = "//android.widget.TextView[@text ='Manage Storage']";
	public final static String Tools = "//android.widget.TextView[@text ='Tools']";
	public final static String HowToDisable = "//android.widget.TextView[@text ='How to Disable']";
	public final static String About = "//android.widget.TextView[@text ='About']";
	public final static String BackupChecks="//android.widget.CheckBox";

}

// driver.findElementByXPath("//android.widget.ImageView[@index = '0' and contains(@content-desc,'Favorites : Count')]")
//driver.findElementByXPath("//android.widget.CheckedTextView[@text ='Size' and @checkable = 'true']")
//driver.findElementByXPath("//android.widget.ImageView[@index= '0' and @resource-id='com.vcast.mediamanager:id/icon']")
// driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
// driver.findElementByAndroidUIAutomator("resourceId(\"com.raaga.android:id/music_home_raaga_live\")").click();
// driver.findElementById("com.raaga.android:id/toolbar_logo").click();
// 	CONTENT DESC driver.findElementByXPath("//android.widget.ImageView[@content-desc='Photo : IMAG0159.jpg]").click();
//driver.openNotifications();
//driver.pressKeyCode(AndroidKeyCode.BACK);
//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Documents\"));");
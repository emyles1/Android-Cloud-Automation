package testcases;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.util.Scanner;


import android.net.Uri;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import objectrepository.CommonMethods;
import objectrepository.Strings;

@SuppressWarnings("unused")
//public class Playground extends CloudBase {
	

public class Playground extends CloudBase{ 
	
	
	
	
	int waitinsec = 30;
	
	//@Test
	public void FindExt() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Home,waitinsec).click();
		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.AllFiles,waitinsec).click();
		get.Xpath(Strings.mobileRepro,waitinsec).click();
		String foldername = get.GetText(Strings.folderTitle);
		String devicefolder = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);
		get.Xpath(devicefolder,waitinsec).click();
		String RepoTitle = get.XpathBuilder(Strings.TextView, Strings.Text, "My "+foldername);
		
		String s = get.GetText(Strings.allfileItem);
		
		
		s.substring(s.lastIndexOf('.') + 1);
		
		System.out.println("printed output: "+ s.substring(s.lastIndexOf('.') + 1));
		
		
		//get.Xpath(Strings.allfileItem).click();
		


	}
	
	
	@Test
	public void waitforbackup() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);
		
		get.BackupNow();
		
	}

	
	//User input
	
	//@Test
	public void OpenSettings() throws MalformedURLException, InterruptedException {
	
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	System.out.println("Enter a number: ");
	int n = reader.nextInt(); // Scans the next token of the input as an int.
	//once finished
	reader.close();

	}
	
	
	//@Test
	public void Swipe() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		int isFoundElement = get.GetAttributeCount(Strings.PicAndVids, "text");
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
	//	get.Xpath(Strings.firstAllitem, waitinsec).click();
		//get.WaitForIt(Strings.tapFullview, waitinsec);
		
		
		
		//int isFoundElement = get.GetNavCount(Strings.PicAndVids, "text");
		double swipes = isFoundElement *0.04;
		System.out.println(swipes);
		System.out.println(isFoundElement);

		int x = 0;
		while (x <= swipes){

			Dimension size = driver.manage().window().getSize();
			int startX = size.getWidth() / 2;
			int startY = size.getHeight() / 2;
			int endX = 0;
			int endY = (int) (startY * -1 * .30);
			

			TouchAction action = new TouchAction(driver);
			action.press(startX, startY).moveTo(endX, endY).release().perform();
	
			System.out.println("Item found " + isFoundElement);
			x++;
			Thread.sleep(2000);

		}
		//get.SwipeRight();
	}
	 
	
//	public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
//	     String typeOfDay;
//	     switch (dayOfWeekArg) {
//	         case "Monday":
//	             typeOfDay = "Start of work week";
//	             break;
//	         case "Tuesday":
//	         case "Wednesday":
//	         case "Thursday":
//	             typeOfDay = "Midweek";
//	             break;
//	         case "Friday":
//	             typeOfDay = "End of work week";
//	             break;
//	         case "Saturday":
//	         case "Sunday":
//	             typeOfDay = "Weekend";
//	             break;
//	         default:
//	             throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
//	     }
//	     return typeOfDay;
//	}
//
//
//	//@Test(priority=1)
//	public void ViewItem2() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//		CommonMethods Create = new CommonMethods(driver);
//		
//		Strings string = new Strings();
//
//		Create.Xpath(Strings.homeHamburger,waitinsec).click();
//		Create.Xpath(Strings.PicAndVids,waitinsec).click();
//		Create.Xpath(Strings.allHeader,waitinsec).click();
//		Create.Xpath(Strings.firstAllitem,waitinsec).click();
//		Create.Xpath(Strings.tapFullview,waitinsec).click();
//
//		Assert.assertEquals(Create.AssertXpathExists(string.Elipses), 1);
//
//	}
//	
//	
//
//	/*
//	 * public static void main(String[] args) throws MalformedURLException,
//	 * InterruptedException {
//	 * 
//	 * @Test public void LogIn() throws IOException, MalformedURLException,
//	 * InterruptedException {
//	 * 
//	 * 
//	 * AndroidDriver<WebElement> driver = Capabilities();
//	 * PhotoAndVideoRepository photoVideo = new PhotoAndVideoRepository(driver);
//	 * ContextMenuRepository contextMenu = new ContextMenuRepository(driver);
//	 * TouchAction t = new TouchAction(driver);
//	 * 
//	 * photoVideo.SelectAlbums().click(); contextMenu.CreateAlbum().click();
//	 * photoVideo.EnterAlbumName().sendKeys("Automated Album");
//	 * photoVideo.AddAlbumContent().click();
//	 * 
//	 * List<WebElement> webElements =
//	 * driver.findElementsById("com.vcast.mediamanager:id/icon");
//	 * System.out.println(webElements.size());
//	 * 
//	 * //for (WebElement webElement : webElements) {
//	 * //System.out.println(webElements); for(int i=0; i<3; i++){
//	 * t.press(((WebElement)
//	 * webElements.get(i))).waitAction(Duration.ofMillis(1000)).release().
//	 * perform(); //} }
//	 */
//
//	// public static void main(String[] args) throws InterruptedException,
//	// IOException {
//
//	private Object driver;
//
//	//@Test
//	public void OpenMobileRepro() throws MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		CommonMethods Create = new CommonMethods(driver);
//
//		// Create.XpathBuilder(Strings.ANDROIDWIDGETIMAGEBUTTON,Strings.INDEX,Strings.ZERO).click();
//		Create.XpathBuilder("//android.widget.ImageButton", "@index =", "0");
//
//	}
//
//	// @Test
//	public void DocumentsShare() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		CommonMethods Create = new CommonMethods(driver);
//
//		Create.Xpath(Strings.homeHamburger,waitinsec).click();
//		String data_option = Create.Xpath(Strings.PicAndVids,waitinsec).getAttribute("text");
//		System.out.println("The value is: " + data_option);
//
//		// System.out.println(Str.replace('(','y'));
//		// System.out.println(Str.substring(10,11));
//		// System.out.println(Str.length());
//
//		int openbracket = (data_option.indexOf('('));
//		int closebracket = (data_option.indexOf(')'));
//		String count = (data_option.substring(openbracket + 1, closebracket));
//		int result = Integer.parseInt(count);
//		System.out.println(result);
//
//	}
//
//	// @Test
//	public void scroll() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		CommonMethods Create = new CommonMethods(driver);
//
//		verticalSwipe();
//
//		// Create.Xpath("//android.widget.ImageView[@content-desc='Photo :
//		// IMAG0168.jpg]").click();
//
//		// Actions actions = new Actions(driver);
//		// actions.moveToElement(element);
//		// actions.perform();
//		//
//	}
//
//	private void verticalSwipe() {
//		// TODO Auto-generated method stub
//
//	}
//
//	// @Test
//	public void Test() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		TouchAction t = new TouchAction(driver);
//
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Albums']")));
//		driver.findElementByXPath(
//				"//android.widget.ImageView[@index = '0' and contains(@content-desc,'Favorites : Count')]").click();
//
//		// String documents = "//android.widget.ImageView[@index = '0' and
//		// contains(@content-desc,'Favorites : Count 4')]";
//
//	}
//
//	// @Test
//	public void Push() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		TouchAction t = new TouchAction(driver);
//
//		File file = new File("/Users/eamon.myles/Desktop/cloud-01.png");
//		byte[] content = FileUtils.readFileToByteArray(file);
//		driver.pushFile("/sdcard/download/cloud-01.png", content);
//		Thread.sleep(100);
//		System.out.println("playground");
//		driver.findElementByXPath("//android.widget.TextView[@text ='Photos & Videos']").click();
//		System.out.println("Afterclick");
//
//	}
//
//	/*
//	 * public static void main(String args[]){ String s1="  hello string   ";
//	 * System.out.println(s1+"javatpoint");//without trim()
//	 * System.out.println(s1.trim()+"javatpoint");//with trim() }
//	 */
//
//	 public static void main(String[] args) throws InterruptedException,
//	 IOException {
//	 AndroidDriver driver = Capabilities();
//	 var screenshotFile = takeScreenshot(driver);

	
	//@Test
	public void captureScreenshot() throws IOException {

		AndroidDriver driver = Capabilities();

		// Screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/eamon.myles/Desktop/jars/test3.png"));

		File file = new File("/Users/eamon.myles/Desktop/jars/test3.png");
		byte[] content = FileUtils.readFileToByteArray(file); // file -> stream
																// -> byte array
		driver.pushFile("/sdcard/Pictures/Screenshots/test3.png", content); // works
		
//		Needs a media scan in order to get this working correctly.
//		adb will work for this adb shell am broadcast -a android.intent.action.MEDIA_MOUNTED -d file:////sdcard/Pictures/Screenshots/
		
//		Intent intent = 
//			      new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//			intent.setData(Uri.fromFile(file));
//			sendBroadcast(intent);
		
    }
	
	
	//@BeforeSuite
	public void takeAPic() throws IOException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		// adb shell input keyevent 3 Homescreen
		//adb shell input keyevent 27 Takes a pic if camera is open
		get.Xpath(Strings.homeHamburger,waitinsec).click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		String CameraPath = get.XpathBuilder("//android.widget.TextView", Strings.Text, "Camera");
		System.out.println(CameraPath);
		get.Xpath(CameraPath, 30).click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
    }
}
	  
//
//
//
//
//
//
//	 //@Test
//	public void pasttime() throws IOException, MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//
//		CommonMethods use = new CommonMethods(driver);
//		TouchAction t = new TouchAction(driver);
//
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index = '0']")));
//
//		// navBar.Time("//android.widget.ImageButton[@index='0']");
//		// navBar.OpenChicken().click();
//		// driver.findElementByXPath("//android.widget.ImageButton[@index =
//		// '0']").click();
//		// String test = "//android.widget.ImageButton[@index = '0']";
//		// driver.findElement(By.xpath("//android.widget.ImageButton[@index =
//		// '0']")).click();
//		// System.out.println(test);
//		// driver.findElement(By.xpath(test)).click();
//		// System.out.println(navBar.pastXpath());
//		// driver.findElement(By.xpath(navBar.pastXpath())).click();
//
//	}
//
//	// @Test
//	public void multidelete() throws MalformedURLException, InterruptedException {
//
//		AndroidDriver driver = Capabilities();
//		// navBarPRepository navBarP = new navBarPRepository(driver);
//
//		CommonMethods use = new CommonMethods(driver);
//
//		int i = 0;
//		while (i <= 5000) {
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(
//					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='0']")));
//			driver.findElementByXPath("//android.widget.TextView[@index='0']").click();
//			WebDriverWait wait1 = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='More options']")));
//			driver.findElementByXPath("//android.widget.Button[@content-desc='More options']").click();
//			WebDriverWait wait2 = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Delete']")));
//			driver.findElementByXPath("//android.widget.TextView[@text='Delete']").click();
//			WebDriverWait wait3 = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Group and members']")));
//			driver.findElementByXPath("//android.widget.TextView[@text='Group and members']").click();
//			i++;
//			System.out.println(i);
//		}
//	}
//
//}

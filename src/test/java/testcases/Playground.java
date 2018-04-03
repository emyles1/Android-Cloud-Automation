package testcases;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import objectrepository.CommonMethods;
import objectrepository.Strings;




@SuppressWarnings("unused")
public class Playground extends CloudBase {

	/*
	 * public static void main(String[] args) throws MalformedURLException,
	 * InterruptedException {
	 * 
	 * @Test public void LogIn() throws IOException, MalformedURLException,
	 * InterruptedException {
	 * 
	 * 
	 * AndroidDriver<WebElement> driver = Capabilities();
	 * PhotoAndVideoRepository photoVideo = new PhotoAndVideoRepository(driver);
	 * ContextMenuRepository contextMenu = new ContextMenuRepository(driver);
	 * TouchAction t = new TouchAction(driver);
	 * 
	 * photoVideo.SelectAlbums().click(); contextMenu.CreateAlbum().click();
	 * photoVideo.EnterAlbumName().sendKeys("Automated Album");
	 * photoVideo.AddAlbumContent().click();
	 * 
	 * List<WebElement> webElements =
	 * driver.findElementsById("com.vcast.mediamanager:id/icon");
	 * System.out.println(webElements.size());
	 * 
	 * //for (WebElement webElement : webElements) {
	 * //System.out.println(webElements); for(int i=0; i<3; i++){
	 * t.press(((WebElement)
	 * webElements.get(i))).waitAction(Duration.ofMillis(1000)).release().
	 * perform(); //} }
	 */

	// public static void main(String[] args) throws InterruptedException,
	// IOException {
	
	
	
	//@Test
	public void DocumentsShare() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		String data_option = Create.Xpath(Strings.PicAndVids).getAttribute("text");
		System.out.println("The value is: "+ data_option);
		
		
//	      System.out.println(Str.replace('(','y'));
//	      System.out.println(Str.substring(10,11));
//	      System.out.println(Str.length());

	      int openbracket = (data_option.indexOf('('));
	      int closebracket =(data_option.indexOf(')'));
	      String count =(data_option.substring(openbracket +1,closebracket));
	      int result = Integer.parseInt(count);	
	      System.out.println(result);
	          
	          }

	@Test
	public void scroll() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);
		
		
		Create.Xpath("//android.widget.ImageView[@content-desc='Photo : IMAG0168.jpg]").click();

//		WebElement element = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Photo : IMAG0159.jpg']");
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element);
//		actions.perform();
//	
	}
	
	

	//@Test
	public void Test() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		TouchAction t = new TouchAction(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Albums']")));
		driver.findElementByXPath(
				"//android.widget.ImageView[@index = '0' and contains(@content-desc,'Favorites : Count')]").click();

		// String documents = "//android.widget.ImageView[@index = '0' and
		// contains(@content-desc,'Favorites : Count 4')]";

	}

	// @Test
	public void Push() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		TouchAction t = new TouchAction(driver);

		File file = new File("/Users/eamon.myles/Desktop/cloud-01.png");
		byte[] content = FileUtils.readFileToByteArray(file);
		driver.pushFile("/sdcard/download/cloud-01.png", content);
		Thread.sleep(100);
		System.out.println("playground");
		driver.findElementByXPath("//android.widget.TextView[@text ='Photos & Videos']").click();
		System.out.println("Afterclick");

	}

	/*
	 * public static void main(String args[]){ String s1="  hello string   ";
	 * System.out.println(s1+"javatpoint");//without trim()
	 * System.out.println(s1.trim()+"javatpoint");//with trim() }
	 */

	// public static void main(String[] args) throws InterruptedException,
	// IOException {
	// AndroidDriver driver = Capabilities();
	// var screenshotFile = takeScreenshot(driver);

	/*
	 * @Test public void captureScreenshot(String testName) throws
	 * MalformedURLException { AndroidDriver driver = Capabilities(); String
	 * imagesLocation = "/Users/eamon.myles/Desktop/"; new
	 * File(imagesLocation).mkdirs(); // Insure directory is there String
	 * filename = imagesLocation + testName + ".jpg";
	 * System.out.println(filename);
	 * 
	 * try { Thread.sleep(500); WebDriver augmentedDriver = new
	 * Augmenter().augment(driver); File scrFile =
	 * ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(scrFile, new File(filename), true); } catch (Exception
	 * e) { System.out.println("Error capturing screen shot of " + testName +
	 * " test failure."); // remove old pic to prevent wrong assumptions File f
	 * = new File(filename); f.delete(); // don't really care if this doesn't
	 * succeed, but would like it to. } }
	 */

	/*
	 * }
	 * 
	 */
	// @Test
	public void Scroll() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@index='0']")));

		int startx = driver.findElement(By.xpath("//android.widget.ImageView[@text='Flashbacks']")).getLocation()
				.getX();
		int starty = driver.findElement(By.xpath("//android.widget.ImageView[@text='Flashbacks']")).getLocation()
				.getY();
		int endx = driver.findElement(By.xpath("//android.widget.ImageView[@text='Albums']")).getLocation().getX();
		int endy = driver.findElement(By.xpath("//android.widget.ImageView[@text='Albums']")).getLocation().getY();
		System.out.println(startx + " ::::::: " + starty + " ::::::: " + endx + " ::::::: " + endy);
		t.press(startx, starty).moveTo(endx, endy).release().perform();
	}

	// @Test
	public void pasttime() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();



		CommonMethods use = new CommonMethods(driver);
		TouchAction t = new TouchAction(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index = '0']")));

		// navBar.Time("//android.widget.ImageButton[@index='0']");
		// navBar.OpenChicken().click();
		// driver.findElementByXPath("//android.widget.ImageButton[@index =
		// '0']").click();
		// String test = "//android.widget.ImageButton[@index = '0']";
		// driver.findElement(By.xpath("//android.widget.ImageButton[@index =
		// '0']")).click();
		// System.out.println(test);
		// driver.findElement(By.xpath(test)).click();
		// System.out.println(navBar.pastXpath());
		// driver.findElement(By.xpath(navBar.pastXpath())).click();

	}

	// @Test
	public void multidelete() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		// navBarPRepository navBarP = new navBarPRepository(driver);


		CommonMethods use = new CommonMethods(driver);

		int i = 0;
		while (i <= 5000) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='0']")));
			driver.findElementByXPath("//android.widget.TextView[@index='0']").click();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='More options']")));
			driver.findElementByXPath("//android.widget.Button[@content-desc='More options']").click();
			WebDriverWait wait2 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Delete']")));
			driver.findElementByXPath("//android.widget.TextView[@text='Delete']").click();
			WebDriverWait wait3 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Group and members']")));
			driver.findElementByXPath("//android.widget.TextView[@text='Group and members']").click();
			i++;
			System.out.println(i);
		}

	}
}

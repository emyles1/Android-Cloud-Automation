package objectrepository;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectrepository.CommonMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class CommonMethods   {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;

	public CommonMethods(AndroidDriver driver) {
		this.driver = driver;
		
		// add for the Factory object model
		// PageFactory.initElements(driver, this);
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void BackupNow() throws MalformedURLException, InterruptedException {

		Xpath(Strings.homeHamburger, waitinsec).click();
		Xpath(Strings.Home, waitinsec).click();
		ResourceID(Strings.Cloudicon).click();
		ResourceID(Strings.Backupnow).click();

	}

	public WebElement Xpath(String string, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		//System.out.println("String" +string);
		WebElement webElement = driver.findElementByXPath(string);
		return webElement;

	}
	

	public void WaitForIt(String string, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));

	}

	public String XpathBuilder(String classpath, String attribute, String value) {

		String webElement = (classpath + "[" + attribute + "'" + value + "'" + "]");
		return webElement;

	}

	public void ScrollDowntoFind(String string1, String string2, String result, double scrollhgt)
			throws InterruptedException {

		Boolean isFoundElement;
		String string = XpathBuilder(string1, string2, result);
		List<WebElement> webElements = driver.findElementsByXPath(XpathBuilder(string1, string2, result));
		System.out.println(string);

		isFoundElement = webElements.size() > 0;

		while (isFoundElement == false) {

			Dimension size = driver.manage().window().getSize();
			int startX = size.getWidth() / 2;
			int startY = size.getHeight() / 2;
			int endX = 0;
			int endY = (int) (startY * -1 * scrollhgt);

			TouchAction action = new TouchAction(driver);
			action.press(startX, startY).moveTo(endX, endY).release().perform();

			isFoundElement = webElements.size() > 0;
			System.out.println("Item found " + isFoundElement);
			webElements = driver.findElementsByXPath(XpathBuilder(string1, string2, result));
			Thread.sleep(3000);
		}
	}

	public void ScrolltoEnd() throws MalformedURLException, InterruptedException {

		Xpath(Strings.homeHamburger, waitinsec).click();
		int NavCount = GetAttributeCount(Strings.PicAndVids, "text");
		Xpath(Strings.PicAndVids, waitinsec).click();
		double swipes = NavCount * 0.04;

		int x = 0;
		while (x <= swipes) {

			Dimension size = driver.manage().window().getSize();
			int startX = size.getWidth() / 2;
			int startY = size.getHeight() / 2;
			int endX = 0;
			int endY = (int) (startY * -1 * .30);

			TouchAction action = new TouchAction(driver);
			action.press(startX, startY).moveTo(endX, endY).release().perform();

			System.out.println("Item found " + NavCount);
			x++;
			Thread.sleep(2000);
		}
	}

	public void SwipeRight(int swipes) throws MalformedURLException, InterruptedException {

		Dimension size = driver.manage().window().getSize();

		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = (int) (startY * -1 * 0.75);
		int endY = 0;

		int i = 0;
		while (i < swipes) {
			TouchAction action = new TouchAction(driver);
			action.press(startX, startY).moveTo(endX, endY).release().perform();
			++i;
		}

	}

	public void Checkboxes(String string, int seconds, String choice) {
		List<WebElement> webElements = driver.findElementsByXPath(string);

		for (int i = 0; i < webElements.size(); i++) {

			String result = webElements.get(i).getAttribute("checked");

			if (result.equals(choice)) {
				webElements.get(i).click();
			}
		}
	}

	public WebElement TouchActionPress(String string) {
		TouchAction t = new TouchAction(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		t.press(driver.findElementByXPath(string)).waitAction(Duration.ofMillis(1000)).release().perform();
		return null;

	}

	public WebElement ResourceID(String string) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(string)));

		WebElement webElement = driver.findElementById(string);
		return webElement;

	}
	
	public void RateMyAppDisplay(String string) throws InterruptedException {

		Xpath(Strings.homeHamburger, waitinsec).click();
		Xpath(Strings.Home, waitinsec).click();
		Thread.sleep(2000L);
		List<WebElement> webElements = driver.findElementsByXPath(string);
		if (webElements.size() == 1) {
			Xpath(Strings.RateNoThanks,30).click();
		}

		else {
			System.out.println("Rate My App not displayed");
		}
	}
	
	public void AlbumExist(String string) {
	
		Xpath(Strings.homeHamburger, 30).click();
		Xpath(Strings.PicAndVids, 30).click();
		Xpath(Strings.albumHeader, 30).click();
		List<WebElement> webElements = driver.findElementsByXPath(string);
		System.out.println("exists or not"+webElements);
		System.out.println("exists or not and size"+webElements.size());
		
		if (webElements.size() == 1) {
			Xpath(Strings.newAlbum,30).click();
			Xpath(Strings.enterAlbumName, waitinsec).sendKeys("FirstAlbum");
			Xpath(Strings.addAlbumContent, waitinsec).click();
			multiSelect(2);
			Xpath(Strings.makeSelection, waitinsec).click();
			WaitForIt(Strings.createAlbum, 30);
		}
		else {
			System.out.println("Albums Exist");
		}
	}
	
	public void TVDisplay(String string) {
		

		Xpath(Strings.homeHamburger, 30).click();
		Xpath(Strings.PicAndVids, 30).click();
		List<WebElement> webElements = driver.findElementsByXPath(string);
		if (webElements.size() == 1) {
			Xpath(Strings.TV,30).click();
		}
//		else {
//			System.out.println("TV Pop up not displayed");
//		}
	}
	

	public int GetAttributeCount(String string, String attribute) {

		String data_option = Xpath(string, 30).getAttribute(attribute);
		int openbracket = (data_option.indexOf('('));
		int closebracket = (data_option.indexOf(')'));
		String count = (data_option.substring(openbracket + 1, closebracket));
		int beforeDelete = Integer.parseInt(count);

		return beforeDelete;
	}

	public String GetAttribute(String string, String attribute) {

		String retattribute = Xpath(string, 30).getAttribute(attribute);

		return retattribute;

	}

	public String GetText(String string) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));

		String text = Xpath(string, 30).getText();

		return text;
	}
	

	public void multiSelect(int x) {

//		TouchActions tnew = new TouchActions(driver);
		TouchAction told = new TouchAction(driver);
//		
	    WaitForIt("//android.widget.ImageView[@index= '1' and @resource-id='com.vcast.mediamanager:id/icon']",20);
//		
//
//		tnew.longPress(driver.findElementByXPath(
//				"//android.widget.ImageView[@index= '1' and @resource-id='com.vcast.mediamanager:id/icon']"));
//		tnew.perform();

		
		told.press(driver.findElementByXPath(
				"//android.widget.ImageView[@index= '1' and @resource-id='com.vcast.mediamanager:id/icon']"))
				.waitAction(Duration.ofMillis(1000)).release().perform();

		for (int i = 2; i <= x; i++) {

			driver.findElementByXPath(
					"//android.widget.ImageView[@index = '" + i + "' and @resource-id='com.vcast.mediamanager:id/icon']")
					.click();
		}
	}


	public void DuplicateFile() throws InterruptedException {
		
		System.out.println("did i get here?");

		TimeUnit.SECONDS.sleep(5);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.duplicateFile);
		System.out.println(webElements.size());
		if (webElements.size() == 1) {
			Xpath(Strings.deleteYes, 30).click();
		}

		else {
			System.out.println("failed to find");
		}
	}

	public int AssertXpathExists(String string) {

		WaitForIt(string, 30); // added back in the timelimit for
										// Download photo test
		List<WebElement> webElements = driver.findElementsByXPath(string);

		if (webElements.size() >= 1) {
			return 1;
		}

		else {
			return 0;
		}
	}

}

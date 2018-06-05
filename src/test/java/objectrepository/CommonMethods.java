package objectrepository;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonMethods {
    AndroidDriver driver;
    public CommonMethods(AndroidDriver driver) {
	this.driver = driver;
		
		// add for the Factory object model
		// PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
    int waitinsec = 30;

	
	public String XpathBuilder(String classpath, String attribute, String value) {
		
		
		//The scrolling method fail with the wait is commented in. It will wait forever for an items thats not there
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(classpath+  "["   + attribute+   "'"  + value +   "'" +  "]" )));
		
		String webElement = (classpath+  "["   + attribute+   "'"  + value +   "'" +  "]"   );
		return webElement;

	}
	
	
	public void BackupNow() throws MalformedURLException, InterruptedException {

		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Home,waitinsec).click();
		get.ResourceID(Strings.Cloudicon).click();
		get.ResourceID(Strings.Backupnow).click();
		
	}
	
	
	public void ScrollDowntoFind(String string1, String string2, String result, double scrollhgt) throws InterruptedException {
		
	CommonMethods Create = new CommonMethods(driver);
	Boolean isFoundElement;
	String string = Create.XpathBuilder(string1, string2, result);
	List<WebElement> webElements = driver.findElementsByXPath(Create.XpathBuilder(string1, string2, result));
	System.out.println(string);

	isFoundElement = webElements.size() > 0;
	
	while (isFoundElement == false){

	Dimension size = driver.manage().window().getSize();
	int startX = size.getWidth() / 2;
	int startY = size.getHeight() / 2;
	int endX = 0;
	int endY = (int) (startY * -1 * scrollhgt);

	TouchAction action = new TouchAction(driver);
	action.press(startX, startY).moveTo(endX, endY).release().perform();
	
	isFoundElement = webElements.size() > 0;
	System.out.println("Item found " + isFoundElement);
	webElements = driver.findElementsByXPath(Create.XpathBuilder(string1, string2, result));
	Thread.sleep(3000);
		}
	}
	

	public void ScrolltoEnd() throws MalformedURLException, InterruptedException {

		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		int NavCount = get.GetAttributeCount(Strings.PicAndVids, "text");
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		double swipes = NavCount *0.04;

		int x = 0;
		while (x <= swipes){

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

		CommonMethods get = new CommonMethods(driver);

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

	
	public void WaitForIt(String string, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));

	}

	public WebElement Xpath(String string, int seconds) {
		CommonMethods Create = new CommonMethods(driver);
		Create.WaitForIt(string,seconds);
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		WebElement webElement = driver.findElementByXPath(string);
		return webElement;

	}
	
	
	public void Checkboxes(String string, int seconds, String choice) {
	List<WebElement> webElements = driver.findElementsByXPath(string);
	
	for (int i = 0; i < webElements.size(); i++) {

		String result =webElements.get(i).getAttribute("checked");

			if (result.equals(choice)){
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


	
	public int GetAttributeCount(String string, String attribute) {

		CommonMethods Create = new CommonMethods(driver);
		String data_option = Create.Xpath(string,30).getAttribute(attribute);
		int openbracket = (data_option.indexOf('('));
		int closebracket = (data_option.indexOf(')'));
		String count = (data_option.substring(openbracket + 1, closebracket));
		int beforeDelete = Integer.parseInt(count);

		return beforeDelete;
	}
	
	public String GetAttribute (String string, String attribute) {

		CommonMethods Create = new CommonMethods(driver);
		String retattribute = Create.Xpath(string,30).getAttribute(attribute);

		return  retattribute;

	}
	
	public String GetText(String string) {

		CommonMethods Create = new CommonMethods(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		
		String text = Create.Xpath(string,30).getText();
		

		return text;
	}

	public void multiSelect(int x) {
		CommonMethods Create = new CommonMethods(driver);

		TouchAction t = new TouchAction(driver);

		// for (int i = 0; i < x; i++) {
		// t.press(driver.findElementByXPath("//android.widget.ImageView[@index=
		// '" + i
		// + "' and
		// @resource-id='com.vcast.mediamanager:id/icon']")).waitAction(Duration.ofMillis(1000))
		// .release().perform();
		// }

		Create.WaitForIt("//android.widget.ImageView[@index= '0' and @resource-id='com.vcast.mediamanager:id/icon']", 20);
		t.press(driver.findElementByXPath(
				"//android.widget.ImageView[@index= '0' and @resource-id='com.vcast.mediamanager:id/icon']"))
				.waitAction(Duration.ofMillis(1000)).release().perform();

		for (int i = 1; i < x; i++) {
			// Create.WaitForIt("//android.widget.ImageView[@index = '2' ]",30);

			driver.findElementByXPath(
					"//android.widget.ImageView[@index = '" + i + "'and @resource-id='com.vcast.mediamanager:id/icon']")
					.click();

		}
	}
	   
	
	

	public void DuplicateFile() throws InterruptedException {

		CommonMethods Create = new CommonMethods(driver);

		TimeUnit.SECONDS.sleep(5);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.duplicateFile);
		if (webElements.size() == 1) {
			Create.Xpath(Strings.deleteYes,30).click();
		}

		else {
			System.out.println("failed to find");
		}
	}

	public int AssertXpathExists(String string) {

		CommonMethods Create = new CommonMethods(driver);

		Create.WaitForIt(string,30); //added back in the timelimit for Download photo test 
		List<WebElement> webElements = driver.findElementsByXPath(string);

		if (webElements.size() == 1) {
			return 1;
		}

		else {
			return 0;
		}
	}

}

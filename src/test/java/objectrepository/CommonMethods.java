package objectrepository;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public String XpathBuilder(String classpath, String attribute, String value) {
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(classpath+  "["   + attribute+   "'"  + value +   "'" +  "]" )));
		
		String webElement = (classpath+  "["   + attribute+   "'"  + value +   "'" +  "]"   );
		return webElement;

	}
	

	public void ScrolltoFind(String string1, String string2, String result) throws InterruptedException {
		
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
	int endY = (int) (startY * -1 * 0.05);

	TouchAction action = new TouchAction(driver);
	action.press(startX, startY).moveTo(endX, endY).release().perform();
	
	isFoundElement = webElements.size() > 0;
	System.out.println(isFoundElement);
	 webElements = driver.findElementsByXPath(Create.XpathBuilder(Strings.ImageView, Strings.ContentDesc, result));
	Thread.sleep(3000);
	}

	}

	public WebElement Xpath(String string) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		WebElement webElement = driver.findElementByXPath(string);
		return webElement;

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

	public void WaitForIt(String string) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));

	}
	
	public int GetNavCount(String string, String attribute) {

		CommonMethods Create = new CommonMethods(driver);
		String data_option = Create.Xpath(string).getAttribute(attribute);
		int openbracket = (data_option.indexOf('('));
		int closebracket = (data_option.indexOf(')'));
		String count = (data_option.substring(openbracket + 1, closebracket));
		int beforeDelete = Integer.parseInt(count);

		return beforeDelete;

	}
	
	public String GetText(String string) {

		CommonMethods Create = new CommonMethods(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		
		String text = Create.Xpath(string).getText();

		return text;
	}

	public void multiSelect(int x) {

		TouchAction t = new TouchAction(driver);

		for (int i = 0; i < x; i++) {
			t.press(driver.findElementByXPath("//android.widget.ImageView[@index= '" + i
					+ "' and @resource-id='com.vcast.mediamanager:id/icon']")).waitAction(Duration.ofMillis(1000))
					.release().perform();
		}
	}
	

	public void DuplicateFile() throws InterruptedException {

		CommonMethods Create = new CommonMethods(driver);

		TimeUnit.SECONDS.sleep(5);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.duplicateFile);
		if (webElements.size() == 1) {
			Create.Xpath(Strings.deleteYes).click();
		}

		else {
			System.out.println("failed to find");
		}
	}

	public int AssertXpathExists(String string) {

		CommonMethods Create = new CommonMethods(driver);

		Create.WaitForIt(string);
		List<WebElement> webElements = driver.findElementsByXPath(string);
		System.out.println(webElements);

		if (webElements.size() == 1) {
			return 1;
		}

		else {
			return 0;
		}
	}

}

package objectrepository;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	public WebElement Xpath(String string) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
		WebElement webElement = driver.findElementByXPath(string);
		return webElement;

	}

	public WebElement TouchActionPress(String string) {
		TouchAction t = new TouchAction(driver);
		t.press(driver.findElementByXPath(string)).waitAction(Duration.ofMillis(1000)).release().perform();
		return null;

	}
	
	public void WaitForIt(String string) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));

	}
	
	
	public void multiSelect(int x) {
		
		TouchAction t = new TouchAction(driver);

		for (int i = 0; i < x; i++) {
			// System.out.println("XPATH = " +
			// "//android.widget.ImageView[@index= '"+i);
			

			t.press(driver.findElementByXPath("//android.widget.ImageView[@index= '" + i
					+ "' and @resource-id='com.vcast.mediamanager:id/icon']")).waitAction(Duration.ofMillis(1000))
					.release().perform();
		}
	}

	public void DuplicateFile() throws InterruptedException {

		CommonMethods Create = new CommonMethods(driver);

		TimeUnit.SECONDS.sleep(5);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.duplicateFile);
		// System.out.println(webElements.size());
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

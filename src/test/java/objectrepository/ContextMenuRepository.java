package objectrepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import testcases.CloudBase;

public class ContextMenuRepository {

	AndroidDriver driver;

	public ContextMenuRepository(AndroidDriver driver) {

		this.driver = driver;
		// add for the Factory object model
		PageFactory.initElements(driver, this);
		// needed to update the pagefactory bit to allow touch t driver stuff
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// factory object model



	public void Copyright() {
		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		List<WebElement> webElements = driver.findElementsByXPath(Strings.copyrightNotice);

		if (webElements.size() == 1) {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));
			Create.Xpath(Strings.Copyright).click();

		}

		else {

			WebDriverWait waitq = new WebDriverWait(driver, 30);
			waitq.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));

		}
	}

	public void DocFavSwitch() throws InterruptedException {
		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);
		// List<WebElement> webElements =
		// driver.findElementsByXPath("//android.widget.TextView[@text='Add to
		// Favorites']");
		TimeUnit.SECONDS.sleep(5);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);

		if (webElements.size() == 1) {
			Create.Xpath(Strings.addFavMenu).click();
			System.out.println("is here");
		} else {
			
			Create.Xpath(Strings.removeFavMenu).click();
		}

	}

}

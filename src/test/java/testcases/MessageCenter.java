package testcases;

import java.net.MalformedURLException;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.CommonMethods;
import objectrepository.Strings;

public class MessageCenter extends CloudBase {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;
	
	@BeforeSuite
	public void Setup() throws MalformedURLException {
	driver = Capabilities();
	get = new CommonMethods(driver);


	}

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		get.Xpath(Strings.homeHamburger, waitinsec).click();


	}
	
	@Test
	public void MessageCenter2() throws MalformedURLException, InterruptedException {
		
		// get.Xpath(Strings.homeHamburger, waitinsec);
		driver.findElementByXPath(Strings.homeHamburger).click();
		Thread.sleep(3000);
		driver.findElementByXPath(Strings.Documents).click();


	}
}

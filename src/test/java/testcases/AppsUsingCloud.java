package testcases;


import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.CommonMethods;
import objectrepository.Strings;

public class AppsUsingCloud extends CloudBase {

	int waitinsec = 15;
	private AndroidDriver driver;
	private CommonMethods get;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
	driver = Capabilities();
	get = new CommonMethods(driver);

	}

	@Test
	public void AppsUsingCloud() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.APPSUSINGCLOUD, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.APPSUSINGTITLE), 1);
	}
	
	@Test
	public void ClickConnected() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.APPSUSINGCLOUD, waitinsec).click();
		get.Xpath(Strings.CONNECTED, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.APPSUSINGTITLE), 1);
	}
	
	@Test
	public void ClickRecommended() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.APPSUSINGCLOUD, waitinsec).click();
		get.Xpath(Strings.RECOMMENDED, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.APPSUSINGTITLE), 1);
	}
}

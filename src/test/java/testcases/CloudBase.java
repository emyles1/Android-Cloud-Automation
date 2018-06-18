package testcases;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("unused")
public class CloudBase {

	@SuppressWarnings("rawtypes")
	@Test
	// public static AndroidDriver Capabilities() throws MalformedURLException {
	public static AndroidDriver Capabilities() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.vcast.mediamanager");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.newbay.syncdrive.android.ui.nab.NabSplashLogoActivity");

		// cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
		// "com.samsung.android.contacts");
		// cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
		// "com.samsung.contacts.detail.SetDefaultActivity");

		// cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("autoGrantPermissions", true);
		// The below capability will stop the automation reinstalling the app
		cap.setCapability("noReset", true);
		//cap.setCapability("platformVersion", "7.0 ");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");


		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
	

		return driver;

	}

}

package testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("unused")
public class Auth extends CloudBase {

	// public static void main(String[] args) throws MalformedURLException,
	// InterruptedException {
	// @Test
	public void LogIn() throws IOException, MalformedURLException, InterruptedException {

		@SuppressWarnings("rawtypes")
		AndroidDriver driver = Capabilities();

		driver.findElementByXPath("//android.widget.Button[@text='Get Started']").click();
		int len = driver.findElementsByClassName("android.widget.CheckBox").size();
		for (int i = 0; i < len; i++) {
			((WebElement) driver.findElementsByClassName("android.widget.CheckBox").get(i)).click();
		}
		driver.findElementByXPath("//android.widget.TextView[@index='0']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='NEXT']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Dismiss']").click();
		System.out.println(driver.findElementById("com.vcast.mediamanager:id/appTitle").getText());

		WebElement result = (WebElement) driver.findElementById("com.vcast.mediamanager:id/appTitle");
		System.out.println(result);
		// Assert.assertEquals(result.getText(), "Verizon Cloud");

	}

}

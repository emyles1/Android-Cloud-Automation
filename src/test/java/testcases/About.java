package testcases;


import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;

import objectrepository.Strings;

public class About extends CloudBase {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
	driver = Capabilities();
	get = new CommonMethods(driver);

	}


}

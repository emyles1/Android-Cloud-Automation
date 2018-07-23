package testcases;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.CommonMethods;
import objectrepository.Strings;

public class Settings extends CloudBase {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
		driver = Capabilities();
		get = new CommonMethods(driver);

	}

	@Test
	public void SetBackUp() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.WhattoBackup, waitinsec).click();
		get.Checkboxes(Strings.BackupChecks, waitinsec, "true");
		get.Xpath(Strings.ButtonOK, waitinsec).click();

	}

	// ANDRVC-8798
	@Test
	public void SettingsPageLayout() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();

		Assert.assertEquals(get.AssertXpathExists(Strings.WhattoBackup), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.HowtoBackup), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.WhentoBackup), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.MyAccount), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.ManageStorage), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.Tools), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.HowToDisable), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.About), 1);
	}

	// ANDRVC-45
	@Test
	public void Tools() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.Tools, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.ContentRestore), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.VOBS), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.Merge), 1);
	}

	// ANDRVC-1066
	@Test
	public void ToDisable() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.HowToDisable, waitinsec).click();
		get.Xpath(Strings.HowToDisable, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.HowToEnable), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.HowToDisable), 1);
	}
}

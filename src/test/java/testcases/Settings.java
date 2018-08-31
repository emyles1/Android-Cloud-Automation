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
	public void AppNotification() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.NOTIFICATIONMANAGER, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.APPNOTIFICATIONS), 1);
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

	}
	
	@Test
	public void AppVersion() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.About, waitinsec).click();
		get.Xpath(Strings.APPVERSION, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.APPVERSION), 1);
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

	}

	@Test
	public void Help() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Help, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.Help), 1);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();


	}
	
	@Test
	public void ManageStorage() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.ManageStorage, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.ManageStorage), 1);
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

	}

	@Test
	public void PrivacyPolicy() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.About, waitinsec).click();
		get.Xpath(Strings.POLICY, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.POLICY), 1);
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

	}

	@Test
	public void SetBackUp() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.WhattoBackup, waitinsec).click();
		get.Checkboxes(Strings.BackupChecks, waitinsec, "true");
		Assert.assertEquals(get.AssertXpathExists(Strings.ButtonOK), 1);
		get.Xpath(Strings.ButtonOK, waitinsec).click();
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

	}//How to Back Up and When to Back Up HAS NOT BEEN IMPLEMENTED YET.

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
		Assert.assertEquals(get.AssertXpathExists(Strings.NOTIFICATIONMANAGER), 1);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
		
	}

	@Test
	public void TermCond() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.About, waitinsec).click();
		get.Xpath(Strings.TERMSCOND, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.TERMSCOND), 1);
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();

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
		get.BackKey(2);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
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
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
	}
}

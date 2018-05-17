package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.apache.bcel.Repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.CommonMethods;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectrepository.Strings;

public class Settings extends CloudBase {
	int waitinsec = 30;

	@Test
	public void SetBackUp() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.WhattoBackup, waitinsec).click();
		get.Checkboxes(Strings.BackupChecks, waitinsec, "true");
		get.Xpath(Strings.ButtonOK, waitinsec).click();
	}

	// ANDRVC-8798
	@Test
	public void SettingsPageLayout() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);
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
}

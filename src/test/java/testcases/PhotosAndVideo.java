package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;
import testcases.PhotosAndVideo;
import objectrepository.Strings;

public class PhotosAndVideo extends CloudBase {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;

	@BeforeMethod
	public void AppState() throws IOException, MalformedURLException, InterruptedException {
		driver = Capabilities();
		get = new CommonMethods(driver);

//		get.Xpath(Strings.homeHamburger, waitinsec).click();
//		get.Xpath(Strings.Music, waitinsec).click();
		System.out.println("Before test");

		get.RateMyAppDisplay(Strings.RateMyApp);
		get.TVDisplay(Strings.TV);

	}
	

	@Test
	public void Fullview() throws IOException, MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.firstAllitem, waitinsec).click();
		get.Xpath(Strings.tapFullview, waitinsec).click();

		Assert.assertEquals(get.AssertXpathExists(Strings.Elipses), 1);
		
		//have to add this as the next case fails if stopped in fullview
		driver.pressKeyCode(AndroidKeyCode.BACK);


	}

	// ANDRVC-5799
	@Test
	public void Info() throws IOException, MalformedURLException, InterruptedException {
		
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.firstAllitem, waitinsec).click();
		get.Xpath(Strings.tapFullview, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.overflowinfo, waitinsec).click();

		Assert.assertEquals(get.AssertXpathExists(Strings.infodatetaken), 1);

	}
	

	// ANDRVC-87
	@Test
	public void CreateAlbums() throws IOException, MalformedURLException, InterruptedException {

		int rannum = (int) (Math.random() * 256);
		System.out.println(rannum);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.albumHeader, waitinsec).click();
		get.Xpath(Strings.createAlbum, waitinsec).click();
		// adding the following block to ensure at least 2 albums exist for
		// following test cases.
		get.Xpath(Strings.enterAlbumName, waitinsec).sendKeys("TestAlbum" + rannum);
		get.Xpath(Strings.addAlbumContent, waitinsec).click();
		int multiNumber = 3;
		get.multiSelect(multiNumber);
		get.Xpath(Strings.makeSelection, waitinsec).click();
		get.WaitForIt(Strings.createAlbum, 30);
		get.Xpath(Strings.createAlbum, waitinsec).click();

		get.Xpath(Strings.enterAlbumName, waitinsec).sendKeys("Auto Album" + rannum);
		String result = ("Album Auto Album" + rannum + " : Count " + multiNumber);
		get.Xpath(Strings.addAlbumContent, waitinsec).click();
		get.multiSelect(multiNumber);
		get.Xpath(Strings.makeSelection, waitinsec).click();
		Thread.sleep(5000);
		get.ScrollDowntoFind(Strings.ImageView, Strings.ContentDesc, result, 0.05);
		Assert.assertEquals(get.AssertXpathExists(get.XpathBuilder(Strings.ImageView, Strings.ContentDesc, result)), 1);
		// return result; (allow-return-values="true" <==Google this. not good
		// practice to return values for testNG)

	}

	// ANDRVC-734 not complete
	@Test(dependsOnMethods = { "CreateAlbums" })
	public void DeleteAlbum() throws IOException, MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.albumHeader, waitinsec).click();

		get.TouchActionPress(Strings.AlbumSelect);
		String Albumname = get.Xpath(Strings.AlbumSelect, waitinsec).getAttribute("contentDescription");
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.overflowdelete, waitinsec).click();
		get.Xpath(Strings.deleteYes, waitinsec).click();
		Thread.sleep(3000);
		int itemDeleted = driver
				.findElementsByXPath(get.XpathBuilder(Strings.ImageView, Strings.ContentDesc, Albumname)).size();

		Assert.assertEquals(itemDeleted, 0);

	}

	// ANDRVC-669
	@Test
	public void SwipeRight() throws IOException, MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		int swipecount = get.GetAttributeCount(Strings.PicAndVids, "text");
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.firstAllitem, waitinsec).click();
		get.WaitForIt(Strings.tapFullview, waitinsec);
		get.SwipeRight(swipecount);
		get.Xpath(Strings.tapFullview, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.overflowinfo, waitinsec).click();
		String title = (get.GetAttribute(Strings.InfoTitle, "text"));
		get.Xpath(Strings.infoClose, waitinsec).click();
		System.out.println(title);
		get.SwipeRight(2);
		get.Xpath(Strings.tapFullview, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.overflowinfo, waitinsec).click();
		String title2 = (get.GetAttribute(Strings.InfoTitle, "text"));

		Assert.assertEquals(title, title2);

	}

	@Test
	public void PhotoVidDownload() throws IOException, MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.TouchActionPress(Strings.overflowdownload);
		get.DuplicateFile();
		driver.openNotifications();


		Assert.assertEquals(get.AssertXpathExists(Strings.downloadComplete), 1);

	}

	// ANDRVC-6423
	@Test
	public void PhotoVidDelete() throws IOException, MalformedURLException, InterruptedException {

		int x = 3;

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		int beforeDelete = get.GetAttributeCount(Strings.PicAndVids, "text");

		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.multiSelect(x);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.TouchActionPress(Strings.overflowdelete);
		get.Xpath(Strings.deleteYes, waitinsec).click();

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		int afterDelete = get.GetAttributeCount(Strings.PicAndVids, "text");
		// the assertion here will take the after delete and add the number
		// deleted to make them equal.
		Assert.assertEquals(beforeDelete, afterDelete + x);

	}

	// ANDRVC-656 Precon: Videos should be available. need a precon if they dont exist
	@Test
	public void LaunchVideo() throws IOException, MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.FilterBy, waitinsec).click();
		get.Xpath(Strings.filterByVideo, waitinsec).click();
		get.Xpath(Strings.ButtonOK, waitinsec).click();
		get.Xpath(Strings.firstAllitem, waitinsec).click();
		get.Xpath(Strings.tapFullview, waitinsec).click();
		driver.pressKeyCode(AndroidKeyCode.BACK);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.FilterBy, waitinsec).click();
		get.Xpath(Strings.filterByEverything, waitinsec).click();
		get.Xpath(Strings.ButtonOK, waitinsec).click();
	}

	// WHY DO I HAVE THE TOUCH SCTION HERE
	@Test
	public void PhotoVidFav() throws IOException, MalformedURLException, InterruptedException {

		// TouchAction t = new TouchAction(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses, waitinsec).click();

		WebDriverWait wait = new WebDriverWait(driver, waitinsec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.overflowdelete)));
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);
		System.out.println(webElements);

		if (webElements.size() == 1) {
			get.Xpath(Strings.addFavMenu, waitinsec).click();
			get.Xpath(Strings.albumHeader, waitinsec).click();

			Assert.assertEquals(get.AssertXpathExists(Strings.favAlbum), 1);

		}

		else {

			driver.pressKeyCode(AndroidKeyCode.BACK);
			get.ResourceID(Strings.selectioncheckmark).click();
			get.Xpath(Strings.albumHeader, waitinsec).click();
			get.WaitForIt("//android.widget.ImageView[@index = '0']", waitinsec);
			get.Xpath(Strings.favAlbum, waitinsec).click();
			get.multiSelect(1);
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.removeFavMenu, waitinsec).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);

			get.Xpath(Strings.allHeader, waitinsec).click();
			get.multiSelect(1);
			get.Xpath(Strings.Elipses, waitinsec).click();
			Assert.assertEquals(get.AssertXpathExists(Strings.addFavMenu), 1);

		}

	}

	@Test
	public void FavExist() throws MalformedURLException, InterruptedException {

		Strings string = new Strings();

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.TouchActionPress(Strings.longPressPic);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.WaitForIt(Strings.overflowdelete, waitinsec);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);
		if (webElements.size() == 0) {
			System.out.println("favorite album exists");
			// Press the back button twice
			int count = 0;
			while (count < 2) {
				TimeUnit.SECONDS.sleep(3);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				System.out.println(count);
				count++;
			}
			get.Xpath(Strings.albumHeader, waitinsec).click();
			Assert.assertEquals(get.AssertXpathExists(Strings.favAlbum), 1);
		} else {
			System.out.println("favorite album may not exists");
			get.Xpath(Strings.addFavMenu, waitinsec).click();
			get.Xpath(Strings.albumHeader, waitinsec).click();
			Assert.assertEquals(get.AssertXpathExists(Strings.favAlbum), 1);
		}
	}

	// ANDRVC-8100  NO ASSERTION HERE
	@Test
	public void ShareCollage() throws MalformedURLException, InterruptedException {

		Strings string = new Strings();

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.FilterBy, waitinsec).click();
		get.Xpath(Strings.filterByPhotos, waitinsec).click();
		get.Xpath(Strings.ButtonOK, waitinsec).click();
		get.multiSelect(3);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.CreateCollage, waitinsec).click();
		get.Xpath(Strings.Save, waitinsec).click();
		driver.pressKeyCode(AndroidKeyCode.BACK);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Settings, waitinsec).click();
		get.Xpath(Strings.WhattoBackup, waitinsec).click();
		List<WebElement> webElements = driver.findElementsByXPath(Strings.BackupChecks);
		String result = webElements.get(1).getAttribute("checked");
		if (result.equals("false")) {
			webElements.get(1).click();
		}
		get.Xpath(Strings.ButtonOK, waitinsec).click();
		get.BackupNow();
		driver.pressKeyCode(AndroidKeyCode.BACK);
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.PicAndVids, waitinsec).click();
		get.Xpath(Strings.allHeader, waitinsec).click();
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.Xpath(Strings.FilterBy, waitinsec).click();
		get.Xpath(Strings.filterByEverything, waitinsec).click();
		get.Xpath(Strings.ButtonOK, waitinsec).click();

	}
}

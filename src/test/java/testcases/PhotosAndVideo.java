package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;
import objectrepository.Strings;

public class PhotosAndVideo extends CloudBase {

	// @Test(priority=0)
	public void ViewItem() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);
		Strings string = new Strings();

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.allHeader).click();
		get.Xpath(Strings.firstAllitem).click();
		get.Xpath(Strings.tapFullview).click();

		Assert.assertEquals(get.AssertXpathExists(string.Elipses), 1);

	}

	// @Test(priority=1)
	public void BInfo() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.allHeader).click();
		get.Xpath(Strings.firstAllitem).click();
		get.Xpath(Strings.tapFullview).click();
		get.Xpath(Strings.Elipses).click();
		get.Xpath(Strings.overflowinfo).click();

		Assert.assertEquals(get.AssertXpathExists(Strings.infodatetaken), 1);

	}

	@Test(priority = 2)
	public void CCreateAlbum() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);

		int rannum = (int) (Math.random() * 256);
		System.out.println(rannum);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.albumHeader).click();
		get.Xpath(Strings.createAlbum).click();
		get.Xpath(Strings.enterAlbumName).sendKeys("Auto Album" + rannum);
		String result = ("Album Auto Album" + rannum + " : Count 3");
		get.Xpath(Strings.addAlbumContent).click();
		get.multiSelect(3);
		get.Xpath(Strings.makeSelection).click();
		Thread.sleep(5000);
		get.ScrolltoFind(Strings.ImageView, Strings.ContentDesc, result);
		Assert.assertEquals(
				get.AssertXpathExists(get.XpathBuilder(Strings.ImageView, Strings.ContentDesc, result)), 1);
	}

	// @Test
	public void PhotoVidDownload() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.timelineHeader).click();
		get.Xpath(Strings.firstTimelineitem).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses).click();
		get.TouchActionPress(Strings.overflowdownload);
		get.DuplicateFile();
		driver.openNotifications();

		Assert.assertEquals(get.AssertXpathExists(Strings.downloadComplete), 1);

	}

	// @Test
	public void PhotoVidDelete() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger).click();
		int beforeDelete = get.GetNavCount(Strings.PicAndVids, "text");

		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.allHeader).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses).click();
		get.TouchActionPress(Strings.overflowdelete);
		get.Xpath(Strings.deleteYes).click();

		get.Xpath(Strings.homeHamburger).click();
		int afterDelete = get.GetNavCount(Strings.PicAndVids, "text");

		Assert.assertEquals(beforeDelete, afterDelete + 1);

	}

	// @Test
	public void PhotoVidFav() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);
		TouchAction t = new TouchAction(driver);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.allHeader).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.overflowdelete)));
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);
		System.out.println(webElements);

		if (webElements.size() == 1) {
			get.Xpath(Strings.addFavMenu).click();
			get.Xpath(Strings.albumHeader).click();

			Assert.assertEquals(get.AssertXpathExists(Strings.favAlbum), 1);

		}

		else {

			driver.pressKeyCode(AndroidKeyCode.BACK);
			get.ResourceID(Strings.selectioncheckmark).click();
			get.Xpath(Strings.albumHeader).click();
			get.WaitForIt("//android.widget.ImageView[@index = '0']");
			get.Xpath(Strings.favAlbum).click();
			get.multiSelect(1);
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.removeFavMenu).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);

		}

		get.Xpath(Strings.allHeader).click();
		get.multiSelect(1);
		get.Xpath(Strings.Elipses).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.addFavMenu), 1);

	}

	// @Test
	public void FavExist() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);
		Strings string = new Strings();

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.PicAndVids).click();
		get.Xpath(Strings.allHeader).click();
		get.TouchActionPress(Strings.longPressPic);
		get.Xpath(Strings.Elipses).click();
		get.WaitForIt(Strings.overflowdelete);
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
		} else {
			System.out.println("favorite album does not exists");
			get.Xpath(Strings.addFavMenu).click();
		}

		get.Xpath(Strings.albumHeader).click();

		Assert.assertEquals(get.AssertXpathExists(Strings.favAlbum), 1);

	}

}

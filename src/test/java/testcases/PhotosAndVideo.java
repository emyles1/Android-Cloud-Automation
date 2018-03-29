package testcases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;
import objectrepository.ContextMenuRepository;

import objectrepository.Strings;

public class PhotosAndVideo extends CloudBase {
	



	//@Test(priority=0)
	public void ViewItem() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);
		Strings string = new Strings();

		// navBar.OpenHamburger().click();
		Create.Xpath(Strings.homeHamburger).click();
		// navBar.picAndVids().click();
		Create.Xpath(Strings.PicAndVids).click();
		// photoVideo.SelectAll().click();
		Create.Xpath(Strings.allHeader).click();
		// photoVideo.FullView().click();
		Create.Xpath(Strings.firstAllitem).click();
		Create.Xpath(Strings.tapFullview).click();
		
		Assert.assertEquals(Create.AssertXpathExists(string.Elipses), 1);

	}

    //@Test(priority=1)
	public void BInfo() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.allHeader).click();
		Create.Xpath(Strings.firstAllitem).click();
		Create.Xpath(Strings.tapFullview).click();
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowinfo).click();

		Assert.assertEquals(Create.AssertXpathExists(Strings.infodatetaken), 1);

	}

    //@Test(priority=2)
	public void CCreateAlbum() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		int rannum = (int) (Math.random() * 256);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.albumHeader).click();
		Create.Xpath(Strings.createAlbum).click();
		Create.Xpath(Strings.enterAlbumName).sendKeys("Auto Album " + rannum);
		String result = ("Auto Album " + rannum);
		Create.Xpath(Strings.addAlbumContent).click();
		Create.multiSelect(3);
		Create.Xpath(Strings.makeSelection).click();

		Assert.assertEquals(result, ("Auto Album " + rannum));

	}

	//@Test
	public void PhotoVidDownload() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.timelineHeader).click();
		Create.Xpath(Strings.firstTimelineitem).click();
		Create.multiSelect(1);
		Create.Xpath(Strings.Elipses).click();
		Create.TouchActionPress(Strings.overflowdownload);
		Create.DuplicateFile();
		driver.openNotifications();
		
		Assert.assertEquals(Create.AssertXpathExists(Strings.downloadComplete), 1);

	}
		


	//@Test
	public void PhotoVidDelete() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);
		TouchAction t = new TouchAction(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.allHeader).click();
		Create.multiSelect(1);
		Create.Xpath(Strings.Elipses).click();
		t.press(Create.Xpath(Strings.overflowdelete)).waitAction(Duration.ofMillis(1000)).release().perform();
		Create.Xpath(Strings.deleteYes).click();
		
		Assert.assertEquals(Create.AssertXpathExists(Strings.deleting), 1);


	}

	@Test
	public void PhotoVidFav() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);
		TouchAction t = new TouchAction(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.allHeader).click();
		Create.multiSelect(1);
		Create.Xpath(Strings.Elipses).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.overflowdelete)));
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);
		System.out.println(webElements);

		if (webElements.size() == 1) {
			Create.Xpath(Strings.addFavMenu).click();
			Create.Xpath(Strings.albumHeader).click();
			
			Assert.assertEquals(Create.AssertXpathExists(Strings.favAlbum), 1);
			
		}

		else {

			driver.pressKeyCode(AndroidKeyCode.BACK);
			Create.ResourceID(Strings.selectioncheckmark).click();
			Create.Xpath(Strings.albumHeader).click();
			Create.WaitForIt("//android.widget.ImageView[@index = '0']");
			Create.Xpath(Strings.favAlbum).click();
			Create.multiSelect(1);
			Create.Xpath(Strings.Elipses).click();
			Create.Xpath(Strings.removeFavMenu).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
		}
		
		Create.Xpath(Strings.allHeader).click();
		Create.multiSelect(1);
		Create.Xpath(Strings.Elipses).click();
		Assert.assertEquals(Create.AssertXpathExists(Strings.addFavMenu), 1);


	}
	
//	@Test
	public void FavExist() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);
		Strings string = new Strings();

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.PicAndVids).click();
		Create.Xpath(Strings.allHeader).click();
		Create.TouchActionPress(Strings.longPressPic);
		Create.Xpath(Strings.Elipses).click();
		Create.WaitForIt(Strings.overflowdelete);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu); // Make a method in common for this
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
			Create.Xpath(Strings.addFavMenu).click();
		}

		Create.Xpath(Strings.albumHeader).click();

		Assert.assertEquals(Create.AssertXpathExists(Strings.favAlbum), 1);

	}
	
	
}

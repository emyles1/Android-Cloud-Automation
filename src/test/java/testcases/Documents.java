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



import objectrepository.Strings;

public class Documents extends CloudBase {
	int waitinsec = 30;
	@Test
	public void DocumentsSort() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.SortView,waitinsec).click();
		get.Xpath(Strings.sortByDateUploaded,waitinsec).click();
		get.Xpath(Strings.ButtonOK,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.SortView,waitinsec).click();
		get.Xpath(Strings.sortByFileName,waitinsec).click();
		get.Xpath(Strings.ButtonOK,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.SortView,waitinsec).click();
		get.Xpath(Strings.sortByExt,waitinsec).click();
		get.Xpath(Strings.ButtonOK,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.SortView,waitinsec).click();
		get.Xpath(Strings.sortBySize,waitinsec).click();
		get.Xpath(Strings.ButtonOK,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.SortView,waitinsec).click();
		
		Assert.assertEquals(get.AssertXpathExists(Strings.sortByRadioBtnSize), 1);
	}

	//ANDRVC-16
	@Test
	public void DocumentsShare() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.share,waitinsec).click();
		//context.Copyright();
		
		//List<WebElement> webElements = driver.findElementsByXPath(Strings.copyrightNotice);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.copyrightNotice);

		if (webElements.size() == 1) {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));
			get.Xpath(Strings.ButtonOK,waitinsec).click();

		}

		else {

			WebDriverWait waitq = new WebDriverWait(driver, 30);
			waitq.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));

		}
		
		Assert.assertEquals(get.AssertXpathExists(Strings.completeactionusing), 1);
	}


	@Test
	public void DocumentsCopyShareLink() throws MalformedURLException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowcopysharelink,waitinsec).click();
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.overflowcopysharelink), 1);

	}

	@Test
	public void DocFavSwitch() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods get = new CommonMethods(driver);


		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		//context.DocFavSwitch();
		TimeUnit.SECONDS.sleep(3);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);

		if (webElements.size() == 1) {
			get.Xpath(Strings.addFavMenu,waitinsec).click();
			System.out.println("is here");
		} else {	
			get.Xpath(Strings.removeFavMenu,waitinsec).click();
		}
		
		get.Xpath(Strings.Elipses,waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.SortView), 1);
	}



	@Test
	public void DocumentDownload() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowdownload,waitinsec).click();
		get.DuplicateFile();
	}

	@Test
	public void DocInfo() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowinfo,waitinsec).click();

	}

	@Test
	public void DocumentDelete() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);


		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowdelete,waitinsec).click();
		get.Xpath(Strings.deleteYes,waitinsec).click();

	}

	@Test
	public void DocDeleteCancel() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowdelete,waitinsec).click();
		get.Xpath(Strings.deleteNo,waitinsec).click();

	}

	@Test
	public void DocumentsOpen() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger,waitinsec).click();
		get.Xpath(Strings.Documents,waitinsec).click();
		get.TouchActionPress(Strings.longPressDoc);
		get.Xpath(Strings.Elipses,waitinsec).click();
		get.Xpath(Strings.overflowOpen,waitinsec).click();

	}
}


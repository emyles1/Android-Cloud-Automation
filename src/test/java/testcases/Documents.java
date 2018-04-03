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

	//@Test
	public void DocumentsSort() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();

		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.SortView).click();
		Create.Xpath(Strings.sortByDateUploaded).click();
		Create.Xpath(Strings.sortByOK).click();
		
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.SortView).click();
		Create.Xpath(Strings.sortByFileName).click();
		Create.Xpath(Strings.sortByOK).click();
		
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.SortView).click();
		Create.Xpath(Strings.sortByExt).click();
		Create.Xpath(Strings.sortByOK).click();
		
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.SortView).click();
		Create.Xpath(Strings.sortBySize).click();
		Create.Xpath(Strings.sortByOK).click();
		
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.SortView).click();
		
		Assert.assertEquals(Create.AssertXpathExists(Strings.sortByRadioBtnSize), 1);
	}

	//@Test
	public void DocumentsShare() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.share).click();
		//context.Copyright();
		
		//List<WebElement> webElements = driver.findElementsByXPath(Strings.copyrightNotice);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.copyrightNotice);

		if (webElements.size() == 1) {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));
			Create.Xpath(Strings.Copyright).click();

		}

		else {

			WebDriverWait waitq = new WebDriverWait(driver, 30);
			waitq.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings.completeactionusing)));

		}
		
		Assert.assertEquals(Create.AssertXpathExists(Strings.completeactionusing), 1);
	}


	//@Test
	public void DocumentsCopyShareLink() throws MalformedURLException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowcopysharelink).click();
		
		Create.Xpath(Strings.Elipses).click();
		Assert.assertEquals(Create.AssertXpathExists(Strings.overflowcopysharelink), 1);

	}

	@Test
	public void DocFavSwitch() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		CommonMethods Create = new CommonMethods(driver);


		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		//context.DocFavSwitch();
		TimeUnit.SECONDS.sleep(3);
		List<WebElement> webElements = driver.findElementsByXPath(Strings.addFavMenu);

		if (webElements.size() == 1) {
			Create.Xpath(Strings.addFavMenu).click();
			System.out.println("is here");
		} else {	
			Create.Xpath(Strings.removeFavMenu).click();
		}
		
		Create.Xpath(Strings.Elipses).click();
		Assert.assertEquals(Create.AssertXpathExists(Strings.SortView), 1);
	}



	@Test
	public void DocumentDownload() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowdownload).click();
		Create.DuplicateFile();
	}

	@Test
	public void DocInfo() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowinfo).click();

	}

	@Test
	public void DocumentDelete() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);


		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowdelete).click();
		Create.Xpath(Strings.deleteYes).click();

	}

	@Test
	public void DocDeleteCancel() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowdelete).click();
		Create.Xpath(Strings.deleteNo).click();

	}

	@Test
	public void DocumentsOpen() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowOpen).click();

	}
}


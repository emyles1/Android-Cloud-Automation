package testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.aspectj.apache.bcel.Repository;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectrepository.CommonMethods;
import objectrepository.ContextMenuRepository;


import objectrepository.Strings;

public class Documents extends CloudBase {

	@Test
	public void DocumentsSort() throws IOException, MalformedURLException, InterruptedException {
		AndroidDriver driver = Capabilities();
		ContextMenuRepository context = new ContextMenuRepository(driver);
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

	}

	@Test
	public void DocumentsShare() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.share).click();
		context.Copyright();

	}

	@Test
	public void DocumentsCopyShareLink() throws MalformedURLException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowcopysharelink).click();

	}

	@Test
	public void DocFavSwitch() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();


		CommonMethods Create = new CommonMethods(driver);
		ContextMenuRepository context = new ContextMenuRepository(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		context.DocFavSwitch();

	}

	@Test
	public void DocumentDownload() throws IOException, MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();

		ContextMenuRepository context = new ContextMenuRepository(driver);
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

		ContextMenuRepository context = new ContextMenuRepository(driver);
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

		ContextMenuRepository context = new ContextMenuRepository(driver);
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

		ContextMenuRepository context = new ContextMenuRepository(driver);
		CommonMethods Create = new CommonMethods(driver);

		Create.Xpath(Strings.homeHamburger).click();
		Create.Xpath(Strings.Documents).click();
		Create.TouchActionPress(Strings.longPressDoc);
		Create.Xpath(Strings.Elipses).click();
		Create.Xpath(Strings.overflowOpen).click();

	}
}

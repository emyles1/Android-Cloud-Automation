package testcases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;

import objectrepository.Strings;

public class AllFiles extends CloudBase {
	int waitinsec = 30;
	private AndroidDriver driver;
	private CommonMethods get;

//	@BeforeSuite
//	public void Setup() throws MalformedURLException {
//		driver = Capabilities();
//		get = new CommonMethods(driver);
//
//	}
	
	
	@BeforeMethod
	public void Setup() throws MalformedURLException {
	driver = Capabilities();
	get = new CommonMethods(driver);

	}

	//@Test
	public void OpenMobileRepro() throws MalformedURLException, InterruptedException {
		
//		driver = Capabilities();
//		get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.AllFiles, waitinsec).click();
		get.Xpath(Strings.mobileRepro, waitinsec).click();
		String foldername = get.GetText(Strings.folderTitle);
		String devicefolder = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);
		get.Xpath(devicefolder, waitinsec).click();
		String RepoTitle = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);

		Assert.assertEquals(get.AssertXpathExists(RepoTitle), 1);
	}

	
	//music plays all the way before stopping
	
	//@Test
	public void FindExt() throws MalformedURLException, InterruptedException {
		
		System.out.println("FindExt");
//		driver = Capabilities();
//		get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.AllFiles, waitinsec).click();
		get.Xpath(Strings.mobileRepro, waitinsec).click();
		String foldername = get.GetText(Strings.folderTitle);
		String devicefolder = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);
		get.Xpath(devicefolder, waitinsec).click();
		String RepoTitle = get.XpathBuilder(Strings.TextView, Strings.Text, "My " + foldername);

		System.out.println(get.GetText(Strings.allfileItem));

		String s = get.GetText(Strings.allfileItem);

		String ext = s.substring(s.lastIndexOf('.') + 1);

		String extention;

		switch (ext) {
		case "jpg":
			extention = "jpg";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			get.Xpath(Strings.tapFullview, waitinsec).click();
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			String Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "gif":
			extention = "gif";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			get.Xpath(Strings.tapFullview, waitinsec).click();
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "png":
			extention = "png";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			get.Xpath(Strings.tapFullview, waitinsec).click();
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mp3":
			extention = "mp3";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mp4":
			extention = "mp4";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			get.Xpath(Strings.tapFullview, waitinsec).click();
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "ogg":
			extention = "ogg";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mid":
			extention = "mid";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s), waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "docx":
			extention = "docx";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "doc":
			extention = "doc";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "pdf":
			extention = "pdf";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "xls":
			extention = "xls";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "ppt":
			extention = "ppt";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses, waitinsec).click();
			get.Xpath(Strings.overflowinfo, waitinsec).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		default:
			throw new IllegalArgumentException("Invalid extention: " + ext);
		}
//		
//		get.Xpath(Strings.infoClose, waitinsec).click();
//		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

	@Test
	public void MobileName() throws InterruptedException, IOException {
		
//		driver = Capabilities();
//		get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Home, waitinsec).click();
		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.AllFiles, waitinsec).click();
		get.Xpath(Strings.mobileRepro, waitinsec).click();

		// CODE TO ACTIVATE ADB
		String line = "null";
		String[] command = { Strings.ADB, "shell", "getprop", "ro.product.model" };
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(command);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		while ((line = buf.readLine()) != null) {
			System.out.println(line);

			String Mobile = "//android.widget.TextView[contains(@text,'" + line + "')]";
			driver.findElementByXPath(Mobile).click();
			Assert.assertEquals(get.AssertXpathExists(Mobile), 1);

		}
	}

}

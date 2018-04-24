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

public class AllFiles extends CloudBase {

	//@Test
	public void OpenMobileRepro() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.Home).click();
		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.AllFiles).click();
		get.Xpath(Strings.mobileRepro).click();

		String foldername = get.GetText(Strings.folderTitle);

		String devicefolder = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);
		get.Xpath(devicefolder).click();
		String RepoTitle = get.XpathBuilder(Strings.TextView, Strings.Text, "My "+foldername);

		Assert.assertEquals(get.AssertXpathExists(RepoTitle), 1);
	}
	
	@Test
	public void FindExt() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = Capabilities();
		CommonMethods get = new CommonMethods(driver);

		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.Home).click();
		get.Xpath(Strings.homeHamburger).click();
		get.Xpath(Strings.AllFiles).click();
		get.Xpath(Strings.mobileRepro).click();
		String foldername = get.GetText(Strings.folderTitle);
		String devicefolder = get.XpathBuilder(Strings.TextView, Strings.Text, foldername);
		get.Xpath(devicefolder).click();
		String RepoTitle = get.XpathBuilder(Strings.TextView, Strings.Text, "My "+foldername);
		
		System.out.println(get.GetText(Strings.allfileItem));
		
		String s = get.GetText(Strings.allfileItem);
		//s.substring(s.lastIndexOf('.') + 1);
		String ext = s.substring(s.lastIndexOf('.') + 1);
		
        String extention;

		switch (ext) {
		case "jpg":
			extention = "jpg";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			get.Xpath(Strings.tapFullview).click();
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			String Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "png":
			extention = "png";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			get.Xpath(Strings.tapFullview).click();
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mp3":
			extention = "mp3";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mp4":
			extention = "mp4";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			get.Xpath(Strings.tapFullview).click();
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "ogg":
			extention = "ogg";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "mid":
			extention = "mid";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.Xpath(get.XpathBuilder(Strings.TextView, Strings.Text, s)).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "docx":
			extention = "docx";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "pdf":
			extention = "pdf";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "xls":
			extention = "xls";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		case "ppt":
			extention = "ppt";
			get.XpathBuilder(Strings.TextView, Strings.Text, s);
			get.TouchActionPress(get.XpathBuilder(Strings.TextView, Strings.Text, s));
			get.Xpath(Strings.Elipses).click();
			get.Xpath(Strings.overflowinfo).click();
			Title = get.XpathBuilder(Strings.TextView, Strings.Text, s);
			Assert.assertEquals(get.AssertXpathExists(Title), 1);
			break;
		default:
			throw new IllegalArgumentException("Invalid extention: " + ext);
		}
	}  
}

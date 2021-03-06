package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.apache.bcel.Repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import objectrepository.CommonMethods;

import objectrepository.Strings;

public class Music extends CloudBase {

	int waitinsec = 15;
	private AndroidDriver driver;
	private CommonMethods get;

	@BeforeMethod
	public void Setup() throws MalformedURLException {
	driver = Capabilities();
	get = new CommonMethods(driver);

	}

	@Test
	public void ArtistView() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.artistsHeader, waitinsec).click();
		get.ResourceID(Strings.listItem).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.albumHeader), 1);
		Assert.assertEquals(get.AssertXpathExists(Strings.songsHeader), 1);
	}

	// PROBLEM HERE. the next test cant run cos the notification screen is
	// always displayed
	@Test
	public void ArtistDownload() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.artistsHeader, waitinsec).click();
		get.TouchActionPress(Strings.longPressMusic);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.TouchActionPress(Strings.overflowdownload);
		get.DuplicateFile();
		driver.openNotifications();
		get.WaitForIt(Strings.downloadComplete, 120);
		Assert.assertEquals(get.AssertXpathExists(Strings.downloadComplete), 1);
		get.BackKey(1);

	}

	@Test
	public void ArtistAddtoPlaylist() throws MalformedURLException, InterruptedException {

		int rannum = (int) (Math.random() * 256);
		System.out.println(rannum);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.artistsHeader, waitinsec).click();
		get.TouchActionPress(Strings.longPressMusic);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.TouchActionPress(Strings.AddtoPlaylist);
		get.Xpath(Strings.createAlbum, 120).click();
		get.Xpath(Strings.enterAlbumName, waitinsec).sendKeys("Auto Album" + rannum);
		String result = ("Auto Album" + rannum);
		get.Xpath(Strings.ButtonOK, waitinsec).click();
		get.Xpath(Strings.playlistsHeader, waitinsec).click();
		String album = get.XpathBuilder(Strings.TextView, Strings.Text, result);
		
		Assert.assertEquals(get.AssertXpathExists(album), 1);

	}

	// Add in the delete count from nav bar.
	@Test
	public void DeleteSong() throws MalformedURLException, InterruptedException {

		int rannum = (int) (Math.random() * 256);
		System.out.println(rannum);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.songsHeader, waitinsec).click();
		get.TouchActionPress(Strings.longPressMusic);
		get.Xpath(Strings.Elipses, waitinsec).click();
		get.TouchActionPress(Strings.overflowdelete);
		get.Xpath(Strings.deleteYes, waitinsec).click();

	}

	@Test
	public void CreatePlaylist() throws IOException, MalformedURLException, InterruptedException {

		int rannum = (int) (Math.random() * 256);
		System.out.println(rannum);

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.playlistsHeader, waitinsec).click();
		get.Xpath(Strings.createAlbum, waitinsec).click();
		get.Xpath(Strings.enterAlbumName, waitinsec).sendKeys("Auto Album" + rannum);
		String result = ("Auto Album" + rannum);
		get.Xpath(Strings.addPlaylistContent, waitinsec).click();
		get.TouchActionPress(Strings.longPressMusic);
		get.Xpath(Strings.makeSelection, waitinsec).click();
		Thread.sleep(5000);
		get.ScrollDowntoFind(Strings.TextView, Strings.Text, result, 0.05);
		Assert.assertEquals(get.AssertXpathExists(get.XpathBuilder(Strings.TextView, Strings.Text, result)), 1);
	}

	// ANDRVC-807 - Not complete as per testcase
	@Test
	public void PlaySong() throws MalformedURLException, InterruptedException {

		get.Xpath(Strings.homeHamburger, waitinsec).click();
		get.Xpath(Strings.Music, waitinsec).click();
		get.Xpath(Strings.songsHeader, waitinsec).click();
		get.Xpath(Strings.longPressMusic, waitinsec).click();
		Assert.assertEquals(get.AssertXpathExists(Strings.nowPlaying), 1);
	}
}

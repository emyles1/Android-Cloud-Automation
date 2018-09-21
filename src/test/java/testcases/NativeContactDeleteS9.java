package testcases;

import android.content.Context;
import android.content.Intent;
import android.content.*;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import java.util.Scanner;
import android.net.Uri;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import static io.appium.java_client.touch.offset.PointOption.point;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import objectrepository.CommonMethods;
import objectrepository.Strings;

@SuppressWarnings("unused")
public class NativeContactDeleteS9 extends CloudBase {
	int waitinsec = 10;
	private AndroidDriver driver;
	private CommonMethods get;


	@BeforeMethod
	public void Setup() throws MalformedURLException {
		driver = Capabilities();
		get = new CommonMethods(driver);

	}

@Test(priority = 1)
public void DeleteContact() throws IOException, MalformedURLException, InterruptedException {

	int i = 0;
	while (i < 5000) {
	get.WaitForIt("//android.widget.LinearLayout[@resource-id = 'com.samsung.android.contacts:id/group_list_item' and @index ='0']", 30);
	driver.findElementByXPath("//android.widget.LinearLayout[@resource-id = 'com.samsung.android.contacts:id/group_list_item' and @index ='0']").click();
	
	get.WaitForIt("//android.widget.Button[@index ='0'and @content-desc ='More options']", 30);
	driver.findElementByXPath("//android.widget.Button[@index ='0'and @content-desc ='More options']").click();
	
	get.WaitForIt("//android.widget.TextView[@text ='Delete']", 30);
	driver.findElementByXPath("//android.widget.TextView[@text ='Delete']").click();
	
	get.WaitForIt("//android.widget.TextView[@text ='Group and members']", 30);
	driver.findElementByXPath("//android.widget.TextView[@text ='Group and members']").click();
	
	++i;
	}
}
}
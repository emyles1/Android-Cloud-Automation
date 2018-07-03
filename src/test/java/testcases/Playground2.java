package testcases;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.util.Scanner;
import android.net.Uri;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import objectrepository.CommonMethods;
import objectrepository.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressWarnings("unused")
public class Playground2 extends CloudBase {
	
	//CommonMethods Create = new CommonMethods(Capabilities());
//	public static AndroidDriver Capabilities() throws MalformedURLException  {
//
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
//			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.vcast.mediamanager");
//			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
//					"com.newbay.syncdrive.android.ui.nab.NabSplashLogoActivity");
//			cap.setCapability("autoGrantPermissions", true);
//			cap.setCapability("noReset", true);
//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//
//			return driver;
//		}
	
	
	public void FindExt() throws MalformedURLException, InterruptedException {
		
		CommonMethods Create = new CommonMethods(Capabilities());
		
		Capabilities().findElementByXPath("//android.widget.ImageButton[@index ='0']");
		Create.WaitForIt(Strings.Home, 10);



	}
	
}




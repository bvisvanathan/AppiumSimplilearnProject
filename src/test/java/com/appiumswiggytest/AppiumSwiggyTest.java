package com.appiumswiggytest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class AppiumSwiggyTest {

	private AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {	
		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "10.0");
		desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
		desiredCapabilities.setCapability("appPackage", "in.swiggy.android");
		desiredCapabilities.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod  
	public void beforeMethod() throws InterruptedException {
		performLoginCheckAction();
	}

	@Test
	public void sampleTest() {
		System.out.println("Appium Test Setup Success");
	}

	@Test
	public void swiggyAccountTest() throws InterruptedException {

		//Thread.sleep(10000);		
		MobileElement el1 = (MobileElement) driver.findElementById("in.swiggy.android:id/bottom_bar_account");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("EDIT");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("in.swiggy.android:id/edit_account__email_et");
		//Assert.assertEquals(el3.getText(), "bindia.visvanathan@gmail.com");
		Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(669, 130)).perform();
		System.out.println("Appium Account Test Success");
	}

	@Test
	public void swiggyLinkTest() throws InterruptedException {

		//Thread.sleep(10000);
		MobileElement elswiggy = (MobileElement) driver.findElementById("in.swiggy.android:id/bottom_bar_restaurant");
		elswiggy.click();
		MobileElement elloc = (MobileElement) driver.findElementById("in.swiggy.android:id/address_description_textview");
		elloc.click();
		MobileElement elmyloc = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
		elmyloc.click();
		Thread.sleep(3000);
		Assert.assertEquals(elloc.getText(),"No 55 Kumaran St Vivekanada Nagar Ramapuram 600078, Pink Fitness Ramapuram, Rajaram St, Vivekanandha Nagar, Nehru Nagar, Ramapuram, Chennai, Tamil Nadu 600088, India");
		Thread.sleep(10000);
		System.out.println("Appium Swiggy Link Test Success");
	}

	@Test
	public void swiggySearchTest() throws InterruptedException {

		System.out.println("Appium Swiggy search Test Starts");
		//Thread.sleep(10000);
		MobileElement elsearch = (MobileElement) driver.findElementById("in.swiggy.android:id/bottom_bar_explore");
		elsearch.click();
		MobileElement elsearchtxt = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id='in.swiggy.android:id/search_query']");
		Assert.assertEquals(elsearchtxt.getText(), "Search for restaurants and food");
		elsearchtxt.click();
		elsearchtxt.sendKeys("Biryani");		
		driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		//Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));		
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//elsearchtxt.click();
		Thread.sleep(5000);		
		int searchcount = driver.findElementsByXPath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup").size();
		Assert.assertTrue(searchcount >= 1);
		Thread.sleep(5000);
		System.out.println("Appium Search Link Test Success");
	}

	public boolean isLoginDisplay() {
		try {
			MobileElement elogincheck = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name3");
			return elogincheck.isDisplayed();

		} catch (Exception e) {
			// System.out.println(e);
			return false;
		}
	}
	
	public void performLoginCheckAction() throws InterruptedException {
		
		if (isLoginDisplay()) {
		MobileElement elogin = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name3");
		elogin.click();
		MobileElement ephone = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckPhoneNumberEditText");
		ephone.sendKeys("9940572156");
		MobileElement econtinue = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckButton");
		econtinue.click();
		Thread.sleep(30000);
		}
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

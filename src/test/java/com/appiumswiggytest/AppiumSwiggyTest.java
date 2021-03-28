package com.appiumswiggytest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.MobileElement;

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
	
	
	@Test
	  public void sampleTest() {
		System.out.println("Appium Test Success");
	}
	
	@Test
	  public void swiggyAccountTest() throws InterruptedException {
		
		    if(isLoginDisplay()) {
		    	
		    	MobileElement elogin = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name3");
	            boolean isDisplayed = elogin.isDisplayed();
	            if(isDisplayed)
	            elogin.click();
	            MobileElement ephone = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckPhoneNumberEditText");
	            ephone.sendKeys("9940572156");
	            MobileElement econtinue = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckButton");
	            econtinue.click();	
			    Thread.sleep(30000);		    	
		    }
            Thread.sleep(10000);
		    MobileElement el1 = (MobileElement) driver.findElementById("in.swiggy.android:id/bottom_bar_account");
		    el1.click();
		   /*MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("EDIT");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementById("in.swiggy.android:id/edit_account__email_et");
		    Assert.assertEquals(el3.getText(), "bindia.visvanathan@gmail.com");
		    Thread.sleep(10000);
		    System.out.println("Appium Account Test Success");*/
	}
	
	@Test
	  public void swiggyAccountTest2() throws InterruptedException {
		
		    if(isLoginDisplay()) {
		    	
		    	MobileElement elogin = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name3");
	            boolean isDisplayed = elogin.isDisplayed();
	            if(isDisplayed)
	            elogin.click();
	            MobileElement ephone = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckPhoneNumberEditText");
	            ephone.sendKeys("9940572156");
	            MobileElement econtinue = (MobileElement) driver.findElementById("in.swiggy.android:id/loginCheckButton");
	            econtinue.click();	
			    Thread.sleep(30000);		    	
		    }
          Thread.sleep(10000);
		    MobileElement el1 = (MobileElement) driver.findElementById("in.swiggy.android:id/bottom_bar_account");
		    el1.click();
		    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("EDIT");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementById("in.swiggy.android:id/edit_account__email_et");
		    Assert.assertEquals(el3.getText(), "bindia.visvanathan@gmail.com");
		    Thread.sleep(10000);
		    System.out.println("Appium Account Test Success");
	}
	
	
	public boolean isLoginDisplay(){
	    try{
	    	 MobileElement elogincheck = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name3");
	    	 return elogincheck .isDisplayed();

	    }catch(Exception e){
	        //System.out.println(e);
	        return false;
	    }
	}
	
	@AfterClass
	  public void tearDown() {
	    driver.quit();
	  }

}

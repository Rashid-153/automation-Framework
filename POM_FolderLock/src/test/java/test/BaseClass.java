package test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static WebDriver driver;
	static DesiredCapabilities dc;

	@BeforeSuite
	public void setup() throws Exception {
		
		
		dc = new DesiredCapabilities();
		
		//dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G950U");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-A515F");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    dc.setCapability(MobileCapabilityType.APP,"C:\\Users\\Fariz Anjum\\Desktop\\folder lock(ANDR)\\folderLockv1-release-vn-2.5.8-vc-112.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.newsoftwares.folderlock_v1");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashActvity");
		dc.setCapability(MobileCapabilityType.NO_RESET,true);
		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}

package base;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.ExcelReader;

public class BaseClass {

	public static WebDriver driver;
	public static DesiredCapabilities dc;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;

	@BeforeSuite
	public void setup() throws Exception {

		if (driver == null) {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);

			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
			log.info("This is information log ");
			log.info("config file loaded");

			// log.debug("config file loaded")
			log.error("here the error log printed");

			// second we load object repository file Or.proeprtis means locator
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);

			log.info("OR file loades");

		}

		// SAMSANG a51
		if (config.getProperty("device").equals("Android10")) {
			dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("device_name"));
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("device_plateform"));
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getProperty("device_version"));
		}

		// SAMSANG s8
		else if (config.getProperty("device").equals("Android9")) {
			dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G950U");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

		}

		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		dc.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\Fariz Anjum\\Desktop\\folder lock(ANDR)\\folderLockv1-release-vn-2.5.9-vc-113.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.newsoftwares.folderlock_v1");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashActvity");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}

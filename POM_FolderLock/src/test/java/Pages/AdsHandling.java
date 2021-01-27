package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AdsHandling {
	WebDriver driver;
	
	@FindBy(className = "android.webkit.WebView")
	List<WebElement> ads;
	
	public AdsHandling(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void checkAdsAppear() {
		boolean adsCheck=ads.size()>0;
		if(adsCheck==true)
		{
			String checkBtn=driver.findElement(By.xpath("//*[@text='Close']")).getText();
			if(checkBtn=="Close")
			{
				driver.findElement(By.xpath("//*[@text='Close']")).click();
			}
			else {
				driver.findElement(By.xpath("//*[@class='android.widget.Image']")).click();
			}
			
		}
		else {
			Reporter.log("Ads Not Appear");
		}
	}

}

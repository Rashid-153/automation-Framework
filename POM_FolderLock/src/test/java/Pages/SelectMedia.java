package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class SelectMedia {
	WebDriver driver;

	@FindBy(className = ("android.widget.GridView"))
	WebElement imageGridView;
	List<WebElement> totalImages;
	WebElement abc;

	public SelectMedia(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public int coutLibraryImages() {
		totalImages = imageGridView.findElements(By.className("android.widget.LinearLayout"));
		return totalImages.size();
	}

	public void longPress() {
		abc= imageGridView.findElement(By.className("android.widget.LinearLayout"));
		 new AndroidTouchAction((PerformsTouchActions) driver).press(ElementOption.element(abc)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();
	}
	public void selectImages() {
		totalImages = imageGridView.findElements(By.className("android.widget.LinearLayout"));
		for (int image = 0; image < totalImages.size(); image++) {
			totalImages.get(image).click();
		}
	}

	public int countUploadedImages() {
		totalImages = imageGridView
				.findElements(By.xpath("//*[@resource-id='com.newsoftwares.folderlock_v1:id/ll_dark_on_click']"));
		return totalImages.size();

	}
}

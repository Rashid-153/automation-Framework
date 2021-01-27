package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

public class CheckMediaInDevice {

	WebDriver driver;

	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/album_import_ListView']"))
	WebElement libraryPage;

	public CheckMediaInDevice(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public boolean countMediaFolder() {
		List<WebElement> libraryFolderCount = libraryPage.findElements(By.className("android.widget.TextView"));

		if (libraryFolderCount.isEmpty()) {
			return libraryFolderCount.isEmpty();

		} else {
			System.out.println("Total Folder in library " + libraryFolderCount.size());
			Reporter.log("Total Folder : "+libraryFolderCount.size());
			return true;

		}

	}

	public void openMediaFolder() {
		List<WebElement> libraryFolderCount = libraryPage.findElements(By.className("android.widget.TextView"));
		String folderName = libraryFolderCount.get(0).getText();
		Reporter.log("Use " + folderName + " Folder for uploading images");
		System.out.println("Use " + folderName + " Folder for uploading images");
		libraryFolderCount.get(0).click();
	}

}

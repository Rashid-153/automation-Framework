package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateFolder {

	WebDriver driver;

	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/btn_Add_Album']"))
	WebElement btnCreateNewFolder;

	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/et_AlbumName']"))
	WebElement txtFolderName;
	
	@FindBy(xpath = ("//*[@text='YES']"))
	WebElement btnYes;

	@FindBy(xpath = ("//*[@text='AutoCreate']"))
	List<WebElement> checkPresentFolder;

	public CreateFolder(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public void CheckAndCreateFolder(String FolderName) {
		boolean verifyFolderExist = checkPresentFolder.size() > 0;
		if (verifyFolderExist == true) {
			Reporter.log("'AutoCreate' Folder Already present in device");
		}
		else {
			btnCreateNewFolder.click();
			txtFolderName.sendKeys(FolderName);
			btnYes.click();
			Reporter.log("'AutoCreate' Folder created successfully");
		}
	}
	

}

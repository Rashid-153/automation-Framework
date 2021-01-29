package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlbumEditButton {
    
	WebDriver driver;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/iv_EditOptions']"))
	WebElement editButtton;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/tv_AlbumDelete']"))
	WebElement deleteButtton;
	
	@FindBy(xpath = ("//*[@text='YES']"))
	WebElement deletePopupYess;
	
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/tv_AlbumRename']"))
	WebElement renameButtton;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/et_AlbumName']"))
	WebElement renameText;
	
	
	
	
	public AlbumEditButton(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnEditBtn() {
		editButtton.click();
		
	}
	public void clickOnDeleteButton() {
		deleteButtton.click();
		deletePopupYess.click();
	}
	public void clickOnRenameButton() {
		renameButtton.click();
		renameText.clear();
		renameText.sendKeys("Album Rename");
		deletePopupYess.click();
	}
}

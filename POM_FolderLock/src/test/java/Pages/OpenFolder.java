package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenFolder {
	WebDriver driver;
	
	@FindBy(xpath = ("//*[@text='AutoCreate']"))
	WebElement clickOnFolder;
	
	@FindBy(xpath = ("//*[@text='AutoCreate']"))
	WebElement getOpenFolderName;

	
	public OpenFolder(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFolder() {
		clickOnFolder.click();
	}
	public String VerifyFolderTitle() {
		return getOpenFolderName.getText();
	}
}

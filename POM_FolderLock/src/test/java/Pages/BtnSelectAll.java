package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BtnSelectAll {
	WebDriver driver;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/action_select_unselectall']"))
	WebElement btnSelectAll;
	
	public BtnSelectAll(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSelectAllBtn() {
		btnSelectAll.click();
	}
}

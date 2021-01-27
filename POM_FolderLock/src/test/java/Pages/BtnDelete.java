package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BtnDelete {
	WebDriver driver;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/action_delete']"))
	WebElement btnDelete;
	
	@FindBy(xpath = ("//*[@text='YES']"))
	WebElement btnYes;
	
	public BtnDelete(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnDeleteBtn() {
		btnDelete.click();
		btnYes.click();
	}
}

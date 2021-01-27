package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithPin {

	WebDriver driver;
   
	/*PIN Text Field*/
	@FindBy(xpath = "//*[@id='txtPassword']")
	WebElement txtEnterPin;
	
	/*Verify home page Title*/
	@FindBy(xpath = ("//*[@text='Folder Lock']"))
	WebElement dashBoardTitle;
	
	

	public LoginWithPin(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void performLogin(String txtPin) {
		txtEnterPin.sendKeys(txtPin);
		
	}
	
	
	public String get_Dashboard_title() {
		return dashBoardTitle.getText();
	}

}

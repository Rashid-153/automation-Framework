package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginWithPin extends BaseClass {

	public LoginWithPin(WebDriver webDriver) {
		BaseClass.driver = webDriver;

		PageFactory.initElements(driver, this);
	}
	
	public void performLogin(String txtPin) {
		 WebElement TextBoxEnterPin =  driver.findElement(By.xpath(OR.getProperty("enterpin")));
		 TextBoxEnterPin.sendKeys(txtPin);
	}
	
	
	public String get_Dashboard_title() {
		WebElement dashboardTitle=driver.findElement(By.xpath(OR.getProperty("dashboard.title")));
		return dashboardTitle.getText();
	}

}

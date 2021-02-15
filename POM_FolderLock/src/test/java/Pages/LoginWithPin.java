package Pages;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithPin {

	WebDriver driver;
	Properties properties;
	/*PIN Text Field*/

	/*Verify home page Title*/
	@FindBy(xpath = ("//*[@text='Folder Lock']"))
	WebElement dashBoardTitle;
	
	

	public LoginWithPin(WebDriver webDriver) throws IOException {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
		 this.properties = new Properties();
		 InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties_RW_Configration\\Locator.properties");
		 this.properties.load(input);
	}
	
	public void performLogin(String txtPin) {
		By txtEnterPin=By.xpath((String) properties.get("enterPin"));
		 WebElement TextBoxEnterPin =  driver.findElement(txtEnterPin);
		 TextBoxEnterPin.sendKeys(txtPin);
	}
	
	
	public String get_Dashboard_title() {
		return dashBoardTitle.getText();
	}

}

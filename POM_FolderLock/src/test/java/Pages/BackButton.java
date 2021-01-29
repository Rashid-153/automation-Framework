package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackButton {
WebDriver driver;
	
	@FindBy(xpath = ("//*[@class='android.widget.ImageButton' and ./parent::*[@id='toolbar']]"))
	WebElement backButtton;
	
	public BackButton(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void pressBackButton() {
		backButtton.click();
		
	}
}

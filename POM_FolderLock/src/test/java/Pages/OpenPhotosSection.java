package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenPhotosSection {

	WebDriver driver;

	/* Open photos */
	@FindBy(xpath = ("//*[@text='Photos']"))
	WebElement clickOnPhotos;

	/* Tutorial Screen */

	@FindBy(xpath = ("//*[@text=concat('Don', \"'\", 't Show')]"))
	List<WebElement> popUpSkipButton;

	@FindBy(xpath = ("//*[@text='Photos']"))
	WebElement getPhotosPageTitle;

	public OpenPhotosSection(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public void OpenPhotos() {
		clickOnPhotos.click();
	}

	public void skipTutorialPopUp() {
		boolean checkPopUp = popUpSkipButton.size()>0;
		if (checkPopUp==true) {
			popUpSkipButton.get(0).click();
			Reporter.log("Tutorial Popup Skipped");
		}
		else
		{
			Reporter.log("Rating PopUp Does't Appear");
		}

	}

	public String GetPhotosTitle() {
		return getPhotosPageTitle.getText();
	}

}

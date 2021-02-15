package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenVideosSection {
	WebDriver driver;

	@FindBy(xpath = ("//*[@text='Videos']"))
	WebElement clickOnVideos;

	/* Tutorial Screen */

	@FindBy(xpath = ("//*[@text=concat('Don', \"'\", 't Show')]"))
	List<WebElement> popUpSkipButton;

	@FindBy(xpath = ("//*[@text='Videos']"))
	WebElement getVideosPageTitle;

	public OpenVideosSection(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public void OpenVideos() {
		clickOnVideos.click();
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

	public String GetVideosTitle() {
		return getVideosPageTitle.getText();
	}
}

package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RatingPopUp {

	WebDriver driver;
	/* Rating PopUp */
	@FindBy(xpath = ("//*[@text='Enjoying FolderLock']"))
	List<WebElement> ratingPopUp;

	/* Rating skip button */
	@FindBy(xpath = ("//*[@text='Not Now']"))
	WebElement ratingSkipButton;

	public RatingPopUp(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	public void skipRatingPopUp() {
		boolean checkRating = ratingPopUp.size() > 0;
		if (checkRating == true) {
			ratingSkipButton.click();
			Reporter.log("Rating PopUp skipped");
		}
		else {
			Reporter.log("Rating PopUp does't appear");
		}

	}

}

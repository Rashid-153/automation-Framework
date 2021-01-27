package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.LoginWithPin;
import Pages.RatingPopUp;

public class TestLoginWithPin extends BaseClass {

	LoginWithPin enterPin;
	LoginWithPin getDashBoardTitle;
	RatingPopUp ratingPopUp;

	@Test(priority = 1)
	public void validate_pin_working_correct() {

		enterPin = new LoginWithPin(driver);
		enterPin.performLogin("0000");
		Reporter.log("Pin Enter into text box successfully");
	}

	@Test(priority = 2)
	public void validate_ratingPopUpSkiped() {
		ratingPopUp = new RatingPopUp(driver);
		ratingPopUp.skipRatingPopUp();

	}

	@Test(priority = 3)
	public void validate_DashboardApear_Correct() {
		getDashBoardTitle = new LoginWithPin(driver);
		String title = getDashBoardTitle.get_Dashboard_title();
		Assert.assertEquals("Folder Lock", title);
		Reporter.log("Dashoard Title 'Folder Lock' is correct");
	}

}

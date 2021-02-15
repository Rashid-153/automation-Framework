package test.PhotosSection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.AdsHandling;
import base.BaseClass;
import Pages.LoginWithPin;
import Pages.RatingPopUp;

public class TestLoginWithPin extends BaseClass {

	LoginWithPin enterPin;
	LoginWithPin getDashBoardTitle;
	RatingPopUp ratingPopUp;
	AdsHandling adsCheck;
	

	@Test(priority = 1)
	public void validate_pin_working_correct() throws IOException {

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
	public void validate_DashboardApear_Correct() throws IOException {
		getDashBoardTitle = new LoginWithPin(driver);
		String title = getDashBoardTitle.get_Dashboard_title();
		Assert.assertEquals("Folder Lock", title);
		Reporter.log("Dashoard Title 'Folder Lock' is correct");
	}
	/*
	 * @Test(priority = 4) public void validate_AdsAppear() { adsCheck=new
	 * AdsHandling(driver); adsCheck.checkAdsAppear(); }
	 */

}

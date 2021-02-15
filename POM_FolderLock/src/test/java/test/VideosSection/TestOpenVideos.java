package test.VideosSection;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import base.BaseClass;
import Pages.OpenVideosSection;

public class TestOpenVideos extends BaseClass{
	OpenVideosSection openVideos;
	OpenVideosSection skipTutorialScreen;
	OpenVideosSection verifyPageTitle;
	
	@Test(priority = 1)
	public void validate_ClickOnVideosSection() {
		openVideos = new OpenVideosSection(driver);
		openVideos.OpenVideos();
		Reporter.log("Videos Section open succesfully");

	}

	@Test(priority = 2,dependsOnMethods = "validate_ClickOnVideosSection")
	public void validate_TutorialPopUpSkipped() {
		skipTutorialScreen = new OpenVideosSection(driver);
		skipTutorialScreen.skipTutorialPopUp();

	}

	@Test(priority = 3,dependsOnMethods = "validate_TutorialPopUpSkipped")
	public void validate_VideosPageTitle_correct() {
		verifyPageTitle = new OpenVideosSection(driver);

		String pageTitle = verifyPageTitle.GetVideosTitle();
		Assert.assertEquals("Videos", pageTitle);
		Reporter.log("Title Equal as per Expected");
	}

	
}

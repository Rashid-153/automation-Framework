package test.PhotosSection;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.OpenPhotosSection;

public class TestOpenPhotos extends BaseClass {

	OpenPhotosSection openPhotos;
	OpenPhotosSection skipTutorialScreen;
	OpenPhotosSection verifyPageTitle;
	
	
	
	

	@Test(priority = 1)
	public void validate_ClickOnPhotosSection() {
		openPhotos = new OpenPhotosSection(driver);
		openPhotos.OpenPhotos();
		Reporter.log("Photos Section open succesfully");

	}

	@Test(priority = 2)
	public void validate_TutorialPopUpSkipped() {
		skipTutorialScreen = new OpenPhotosSection(driver);
		skipTutorialScreen.skipTutorialPopUp();

	}

	@Test(priority = 3)
	public void validate_PhotosPageTitle_correct() {
		verifyPageTitle = new OpenPhotosSection(driver);

		String pageTitle = verifyPageTitle.GetPhotosTitle();
		Assert.assertEquals("Photos", pageTitle);
		Reporter.log("Title Equal as per Expected");
	}

	
	
	
}

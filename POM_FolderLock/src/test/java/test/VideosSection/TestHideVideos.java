package test.VideosSection;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.HideButton;
import Pages.SelectMedia;

public class TestHideVideos extends BaseClass{

	SelectMedia countVideos;
	HideButton hidebtn;
	int beforeImport;

	@Test(priority = 1)
	public void Validate_CountVideos() {
		countVideos = new SelectMedia(driver);
		 beforeImport = countVideos.coutLibraryImages();
		assertTrue(beforeImport > 0);
		System.out.println(beforeImport);
		String video="before upload :"+beforeImport;
		Reporter.log(video);

	}

	@Test(priority = 2,dependsOnMethods = "Validate_CountVideos")
	public void Validate_VideosSelected() {
		countVideos = new SelectMedia(driver);
		countVideos.selectImages();
		Reporter.log("All images selected");
	}

	@Test(priority = 3,dependsOnMethods = "Validate_VideosSelected")
	public void Validate_HideButton_working() {
		hidebtn=new HideButton(driver);
		hidebtn.clickOnHideButton();
		Reporter.log("Hide buttton working");
	}

	@Test(priority = 4,dependsOnMethods = "Validate_HideButton_working")
	public void Validate_All_VideosImported() {
		countVideos = new SelectMedia(driver);
		int afterImport = countVideos.countUploadedImages();
		System.out.println(afterImport + " Videos select for Uploading");
		System.out.println(afterImport + " Videos are uploaded into App");
		Assert.assertEquals(beforeImport, afterImport);
		String video="Uploaded Images :"+afterImport;
		Reporter.log(video);

	}

}

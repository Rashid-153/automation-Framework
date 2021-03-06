package test.PhotosSection;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.HideButton;
import Pages.SelectMedia;

public class TestVerifyHidePhotos extends BaseClass {

	SelectMedia countImages;
	HideButton hidebtn;
	int beforeUpload;

	@Test(priority = 1)
	public void Validate_CountImages() {
		countImages = new SelectMedia(driver);
		 beforeUpload = countImages.coutLibraryImages();
		assertTrue(beforeUpload > 0);
		System.out.println(beforeUpload);
		String image="before upload :"+beforeUpload;
		Reporter.log(image);

	}

	@Test(priority = 2)
	public void Validate_ImagesSelected() {
		countImages = new SelectMedia(driver);
		countImages.selectImages();
		Reporter.log("All images selected");
	}

	@Test(priority = 3)
	public void Validate_HideButton_working() {
		hidebtn=new HideButton(driver);
		hidebtn.clickOnHideButton();
		Reporter.log("Hide buttton working");
	}

	@Test(priority = 4)
	public void Validate_All_ImagesUpladed() {
		countImages = new SelectMedia(driver);
		int afterUpload = countImages.countUploadedImages();
		System.out.println(beforeUpload + " Images select for Uploading");
		System.out.println(afterUpload + " Images are uploaded into App");
		Assert.assertEquals(beforeUpload, afterUpload);
		String image="Uploaded Images :"+afterUpload;
		Reporter.log(image);

	}

}

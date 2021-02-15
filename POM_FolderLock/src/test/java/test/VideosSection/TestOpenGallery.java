package test.VideosSection;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import base.BaseClass;
import Pages.CheckMediaInDevice;
import Pages.HideImagesFromGallery;

public class TestOpenGallery extends BaseClass{
	HideImagesFromGallery hideVideos;
	CheckMediaInDevice checkMedia;
	
	@Test(priority = 1)
	public void validate_PlusButton_Working() {
		hideVideos=new HideImagesFromGallery(driver);
		hideVideos.clickOnPlusButton();
		Reporter.log("Import Plus Button Working fine");
	}
	@Test(priority = 2,dependsOnMethods = "validate_PlusButton_Working")
	public void validate_ImportFromGalleryBtn_Working() {
		hideVideos=new HideImagesFromGallery(driver);
		hideVideos.clickOnGalleryButton();
		Reporter.log("import From gallery working");
	}
	@Test(priority = 3,dependsOnMethods = "validate_ImportFromGalleryBtn_Working")
	public void validate_GalleryTitle_Correct() {
		hideVideos=new HideImagesFromGallery(driver);
		String galleryTitle=hideVideos.getGalleryTitle();
		Assert.assertEquals("Select Albums", galleryTitle);
		Reporter.log("Open Gallery Title of videos Library is correct");
		
	}

	
	@Test(priority = 4,dependsOnMethods = "validate_GalleryTitle_Correct")
	public void validate_VideosFoundOnDevice() {
		checkMedia=new CheckMediaInDevice(driver);
		Assert.assertTrue(checkMedia.countMediaFolder(),"No media on attached device");
	}
	
	@Test(priority = 5 ,dependsOnMethods = "validate_VideosFoundOnDevice")
	public void validate_VideosFolder_Open() {
		checkMedia=new CheckMediaInDevice(driver);
		checkMedia.openMediaFolder();
	}
	
}

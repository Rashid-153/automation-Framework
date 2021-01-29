package test.PhotosSection;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Pages.CheckMediaInDevice;
import Pages.HideImagesFromGallery;

public class TestOpenGallery extends BaseClass{
	HideImagesFromGallery hideImages;
	CheckMediaInDevice checkMedia;
	
	@Test(priority = 1)
	public void validate_PlusButton_Working() {
		hideImages=new HideImagesFromGallery(driver);
		hideImages.clickOnPlusButton();
		Reporter.log("Import Plus Button Working fine");
	}
	@Test(priority = 2)
	public void validate_ImportFromGalleryBtn_Working() {
		hideImages=new HideImagesFromGallery(driver);
		hideImages.clickOnGalleryButton();
		Reporter.log("import From gallery working");
	}
	@Test(priority = 3)
	public void validate_GalleryTitle_Correct() {
		hideImages=new HideImagesFromGallery(driver);
		String galleryTitle=hideImages.getGalleryTitle();
		Assert.assertEquals("Select Albums", galleryTitle);
		Reporter.log("Open Gallery Title of image Library is correct");
		
	}

	
	@Test(priority = 4)
	public void validate_ImagesFoundOnDevice() {
		checkMedia=new CheckMediaInDevice(driver);
		Assert.assertTrue(checkMedia.countMediaFolder(),"No media on attached device");
	}
	@Test(priority = 5 ,dependsOnMethods = "validate_ImagesFoundOnDevice")
	public void validate_ImageFolder_Open() {
		checkMedia=new CheckMediaInDevice(driver);
		checkMedia.openMediaFolder();
	}
}

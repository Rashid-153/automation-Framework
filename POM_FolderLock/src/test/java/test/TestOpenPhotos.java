package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.CheckMediaInDevice;
import Pages.CreateFolder;
import Pages.HideImagesFromGallery;
import Pages.OpenFolder;
import Pages.OpenPhotosSection;

public class TestOpenPhotos extends BaseClass {

	OpenPhotosSection openPhotos;
	OpenPhotosSection skipTutorialScreen;
	OpenPhotosSection verifyPageTitle;
	CreateFolder createNewFolder;
	OpenFolder clickOnFolder;
	HideImagesFromGallery hideImages;
	CheckMediaInDevice checkMedia;

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

	@Test(priority = 4)
	public void validate_NewFolderCreated() {
		createNewFolder = new CreateFolder(driver);
		createNewFolder.CheckAndCreateFolder("AutoCreate");

	}

	@Test(priority = 5)
	public void validate_FolderIsOpen() {
		clickOnFolder = new OpenFolder(driver);
		clickOnFolder.clickOnFolder();
		Reporter.log("Folder Open succesfully");

	}
	@Test(priority = 6)
	public void validate_FolderTitle_correct() {
		clickOnFolder = new OpenFolder(driver);
		String FolderTitle=clickOnFolder.VerifyFolderTitle();
		
		Assert.assertEquals("AutoCreate", FolderTitle);
		Reporter.log("'AutoCreate' title same as expected");
	}
	
	@Test(priority = 7)
	public void validate_PlusButton_Working() {
		hideImages=new HideImagesFromGallery(driver);
		hideImages.clickOnPlusButton();
		Reporter.log("Import Plus Button Working fine");
	}
	@Test(priority = 8)
	public void validate_ImportFromGalleryBtn_Working() {
		hideImages=new HideImagesFromGallery(driver);
		hideImages.clickOnGalleryButton();
		Reporter.log("import From gallery working");
	}
	@Test(priority = 9)
	public void validate_GalleryTitle_Correct() {
		hideImages=new HideImagesFromGallery(driver);
		String galleryTitle=hideImages.getGalleryTitle();
		Assert.assertEquals("Select Albums", galleryTitle);
		Reporter.log("Open Gallery Title of image Library is correct");
		
	}
	
	@Test(priority = 10)
	public void validate_ImagesFoundOnDevice() {
		checkMedia=new CheckMediaInDevice(driver);
		Assert.assertTrue(checkMedia.countMediaFolder(),"No media on attached device");
	}
	@Test(priority = 11 ,dependsOnMethods = "validate_ImagesFoundOnDevice")
	public void validate_ImageFolder_Open() {
		checkMedia=new CheckMediaInDevice(driver);
		checkMedia.openMediaFolder();
	}
	
}

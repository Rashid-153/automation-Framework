package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Pages.CreateFolder;
import Pages.OpenFolder;
import Pages.OpenPhotosSection;

public class TestOpenPhotos extends BaseClass {

	OpenPhotosSection openPhotos;
	OpenPhotosSection skipTutorialScreen;
	OpenPhotosSection verifyPageTitle;
	CreateFolder createNewFolder;
	OpenFolder clickOnFolder;
	

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
	
	
	
}

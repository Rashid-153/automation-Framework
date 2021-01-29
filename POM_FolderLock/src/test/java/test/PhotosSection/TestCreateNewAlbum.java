package test.PhotosSection;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.CreateFolder;
import Pages.OpenFolder;

public class TestCreateNewAlbum extends BaseClass {
	CreateFolder createNewFolder;
	OpenFolder clickOnFolder;
	
	@Test(priority = 1)
	public void validate_NewFolderCreated() {
		createNewFolder = new CreateFolder(driver);
		createNewFolder.CheckAndCreateFolder("AutoCreate");

	}

	@Test(priority = 2)
	public void validate_FolderIsOpen() {
		clickOnFolder = new OpenFolder(driver);
		clickOnFolder.clickOnFolder();
		Reporter.log("Folder Open succesfully");

	}
	@Test(priority = 3)
	public void validate_FolderTitle_correct() {
		clickOnFolder = new OpenFolder(driver);
		String FolderTitle=clickOnFolder.VerifyFolderTitle();
		
		Assert.assertEquals("AutoCreate", FolderTitle);
		Reporter.log("'AutoCreate' title same as expected");
	}
	

}

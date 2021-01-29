package test.PhotosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.AlbumEditButton;
import Pages.CreateFolder;

public class TestEditAlbum extends BaseClass {
	AlbumEditButton albumEdit;
	CreateFolder createNewFolder;
	@Test(priority=1)
	public void validate_NewFolderCreated() {
		createNewFolder = new CreateFolder(driver);
		createNewFolder.CheckAndCreateFolder("AutoCreateEdit");

	}
	@Test(priority=2)
	public void clickOnEditAlbum() {
		albumEdit=new AlbumEditButton(driver);
		 albumEdit.clickOnEditBtn();
		 Reporter.log("Edit Album button working");
	}
	
	@Test(priority=3)
	public void varify_AlbumRenameWorking() {
		albumEdit=new AlbumEditButton(driver);
		albumEdit.clickOnRenameButton();
		Reporter.log("Album Rename working");
	}
	
	@Test(priority=4)
	public void varify_AlbumDeleteWorking() {
		albumEdit=new AlbumEditButton(driver);
		albumEdit.clickOnEditBtn();
		albumEdit.clickOnDeleteButton();
		Reporter.log("Album Delete button Working");
	}
}

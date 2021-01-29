package test.PhotosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.BtnSelectAll;
import Pages.SelectMedia;
import Pages.BtnDelete;
public class TestDeletePhotos extends BaseClass{
	
	SelectMedia selectImages;
	BtnSelectAll BtnUnhide;
	BtnDelete BtnDelete;
	
	@Test(priority=1)
	public void VerifyImageSelected() {
		selectImages=new SelectMedia(driver);
		selectImages.longPress();
		Reporter.log("Image Selected");
		
	}
	@Test(priority=2)
	public void VeryDeletePhotosBtn_working() {
		BtnDelete=new BtnDelete(driver);
		BtnDelete.clickOnDeleteBtn();
		Reporter.log("Delete Button Working (Deleted)");
	}
	

}

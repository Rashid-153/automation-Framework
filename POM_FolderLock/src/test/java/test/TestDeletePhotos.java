package test;

import org.testng.annotations.Test;

import Pages.BtnSelectAll;
import Pages.SelectMedia;
import Pages.BtnDelete;
public class TestDeletePhotos extends BaseClass{
	
	SelectMedia selectImages;
	BtnSelectAll BtnUnhide;
	BtnDelete BtnDelete;
	
	@Test(priority=1)
	public void VerifyAllPhotos_Selected() {
		selectImages=new SelectMedia(driver);
		selectImages.longPress();
		BtnUnhide=new BtnSelectAll(driver);
		BtnUnhide.clickOnSelectAllBtn();
	}
	@Test(priority=2)
	public void VeryDeletePhotos_working() {
		BtnDelete=new BtnDelete(driver);
		BtnDelete.clickOnDeleteBtn();
	}
	

}

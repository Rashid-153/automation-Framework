package test.VideosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.BtnDelete;
import Pages.BtnSelectAll;
import Pages.SelectMedia;

public class TestDeleteVideos extends BaseClass{
	SelectMedia selectVideos;
	BtnSelectAll BtnUnhide;
	BtnDelete BtnDelete;
	
	@Test(priority=1)
	public void VerifyVideosSelected() {
		selectVideos=new SelectMedia(driver);
		selectVideos.longPress();
		Reporter.log("Videos Selected");
		
	}
	@Test(priority=2,dependsOnMethods = "VerifyVideosSelected")
	public void VerifyDeleteVideosBtn_working() {
		BtnDelete=new BtnDelete(driver);
		BtnDelete.clickOnDeleteBtn();
		Reporter.log("Delete Button Working (Deleted)");
	}
	
}

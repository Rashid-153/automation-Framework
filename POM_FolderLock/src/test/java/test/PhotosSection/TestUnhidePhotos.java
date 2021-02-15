package test.PhotosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.BtnSelectAll;
import Pages.SelectMedia;
import Pages.UnhideButton;

public class TestUnhidePhotos extends BaseClass{
	
	SelectMedia selMedia;
	BtnSelectAll selAll;
	UnhideButton unhidebtn;
	@Test(priority=1)
	public void verify_MediaSelectedToUnhide() {
		selMedia=new SelectMedia(driver);
		selMedia.longPress();
		selAll=new BtnSelectAll(driver);
		selAll.clickOnSelectAllBtn();
		Reporter.log("All Images are selected");
	}
	@Test(priority=2)
	public void verify_UnhideBtnWorking() {
		unhidebtn=new UnhideButton(driver);
		unhidebtn.clickOnUnhideButton();
		unhidebtn.clickOnYes();
		Reporter.log("Unhide button working fine");
		
	}
	

}

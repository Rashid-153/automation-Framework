package test.VideosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import Pages.BtnSelectAll;
import Pages.SelectMedia;
import Pages.UnhideButton;

public class TestUnhideVideos extends BaseClass{
	
	SelectMedia selMedia;
	BtnSelectAll selAll;
	UnhideButton unhidebtn;
	
	@Test(priority=1)
	public void verify_MediaSelectedToUnhide() {
		selMedia=new SelectMedia(driver);
		selMedia.longPress();
		selAll=new BtnSelectAll(driver);
		selAll.clickOnSelectAllBtn();
		Reporter.log("All Videos are selected");
	}
	@Test(priority=2 ,dependsOnMethods = "verify_MediaSelectedToUnhide")
	public void verify_UnhideBtnWorking() {
		unhidebtn=new UnhideButton(driver);
		unhidebtn.clickOnUnhideButton();
		unhidebtn.clickOnYes();
		Reporter.log("Unhide button working fine");
		
	}
}

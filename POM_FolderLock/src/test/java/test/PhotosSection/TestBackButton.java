package test.PhotosSection;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.BackButton;
import base.BaseClass;

public class TestBackButton extends BaseClass {
	BackButton backBtn;
	@Test
	public void pressBackButton() {
		backBtn=new  BackButton(driver);
		backBtn.pressBackButton();
		backBtn.pressBackButton();
		Reporter.log("Press back button two time to go back main screen");
	}

}

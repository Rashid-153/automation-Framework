package test.VideosSection;


import org.testng.annotations.Test;

import base.BaseClass;

import Pages.CameraImport;
public class TestImportFromCamera extends BaseClass {
	
	CameraImport cameraImport;
	
	
	@Test
	public void CameraImport() {
		cameraImport =new CameraImport(driver);
		cameraImport.clickOnPlusBtn();
		cameraImport.clickOnCamera();
		cameraImport.clickOnVideoRecording();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		cameraImport.clickOnStopRecording();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		cameraImport.clickOnSaveRecording();
		
	}

}

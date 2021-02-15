package test.PhotosSection;



import org.testng.annotations.Test;

import base.BaseClass;

import Pages.CameraImport;
public class TestImportPicFromCamera extends BaseClass {
	
	CameraImport cameraImport;
	
	
	@Test
	public void CameraImport() {
		cameraImport =new CameraImport(driver);
		cameraImport.clickOnPlusBtn();
		cameraImport.clickOnCamera();
		cameraImport.clickOnTakePicture();
		cameraImport.clickOnSaveRecording();
		
	}

}

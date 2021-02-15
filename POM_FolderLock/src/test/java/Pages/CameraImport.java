package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CameraImport {
	WebDriver driver;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/fab_expand_menu_button']"))
	WebElement btnPlus;
	
	@FindBy(xpath = ("//*[@resource-id='com.newsoftwares.folderlock_v1:id/btn_impCam']"))
	WebElement btnCameraOpen;
	
	@FindBy(xpath = ("//*[@text='Take picture']"))
	WebElement btnTakePic;
	
	@FindBy(xpath = ("//*[@text='Start recording']"))
	WebElement btnRecordVideo;
	
	@FindBy(xpath = ("//*[@text='Stop recording']"))
	WebElement btnStopRecord;

	@FindBy(xpath = ("//*[@resource-id='com.sec.android.app.camera:id/okay']"))
	WebElement btnSaveVideo;
	
	public CameraImport(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPlusBtn() {
		btnPlus.click();
	}
	public void clickOnCamera() {
		btnCameraOpen.click();
	}
	public void clickOnTakePicture() {
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(btnTakePic)).click();
	
	}
	public void clickOnVideoRecording() {
		btnRecordVideo.click();
	}
	public void clickOnStopRecording() {
		btnStopRecord.click();
	}
	public void clickOnSaveRecording() {
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) btnSaveVideo)).click();
	}
	

}

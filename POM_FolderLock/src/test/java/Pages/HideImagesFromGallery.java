package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HideImagesFromGallery {
	WebDriver driver;

	@FindBy(xpath = ("//*[@id='fab_expand_menu_button']"))
	WebElement btnImportImages;

	@FindBy(xpath = ("//*[@id='btn_impGallery']"))
	WebElement btnGalleryImport;

	@FindBy(xpath = ("//*[@text='Select Albums']"))
	WebElement galleryTitle;

	public HideImagesFromGallery(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlusButton() {
		btnImportImages.click();
	}
	public void clickOnGalleryButton() {
		btnGalleryImport.click();
	}
	public String getGalleryTitle() {
		return galleryTitle.getText();
	}

}

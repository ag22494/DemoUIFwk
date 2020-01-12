/**
 * 
 */
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

/**
 * @author gupta.aakash
 *
 */
public class HomePage {
	
	WebDriver driver;
	CommonUtils commonUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils=new CommonUtils(driver);
	}

	@FindBy(xpath = "//a[@class='btn buy']")
	public WebElement buyNowButton;
	
	@FindBy(xpath = ".//h1/a[text()='Coco']")
	public WebElement cocoTextHeader ;
	
	public boolean isCocoTextHeaderPresent(WebDriver driver) {
		return commonUtils.isElementPresent(cocoTextHeader);
	}
	
	public void clickBuyButton() {
		commonUtils.click(buyNowButton);
	}
	
	@FindBy (xpath = "//span[contains(text(),'Thank you')]")
	public WebElement thankYouMsg;
	
	public boolean isThankYouMsgPresent() {
		commonUtils.switchToParentFromPopup();
		return commonUtils.isElementPresent(thankYouMsg);
	}
	
	
	
}

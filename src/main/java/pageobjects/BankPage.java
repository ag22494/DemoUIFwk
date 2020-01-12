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
public class BankPage {

	WebDriver driver;
	CommonUtils commonUtils;

	public BankPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils=new CommonUtils(driver);
	}	
	
	@FindBy (xpath  = "//h1[text()='Issuing Bank']")
	public WebElement bankPageHeader;
	
	public boolean isBankPagePasswordPresent() {
		return commonUtils.isDisplayed(bankPasswordInputBox);
	}
	
	@FindBy (xpath = "//input[@type='password']")
	public WebElement bankPasswordInputBox;
	
	public void enterPasswordOnBankPage(String text) {
		commonUtils.sendKeys(bankPasswordInputBox, text);
	}
	
	@FindBy (xpath = "//button[@type='submit' and @name='ok']")
	public WebElement okButton;
	
	public void clickOkButton() {
		commonUtils.click(okButton);
	}
	
	@FindBy (xpath = "//p[@id = 'card_number']")
	public WebElement bankCardNumber;
	
	public String cardNumber() {
		String[] arr = commonUtils.getText(bankCardNumber).split("-");
		return arr[0]+arr[1];
	}
	
	@FindBy (xpath = "//p[@id = 'txn_amount']")
	public WebElement txnAmount;
	
	public String getTxnAmount() {
		return commonUtils.getText(txnAmount);
	}
	
	@FindBy (xpath = "//iframe[contains(@src,'https://api.sandbox.veritrans.co.id/v2')]")
	public WebElement iframe;
	
	public void switchToIframe() {
		commonUtils.isElementPresent(iframe);
		commonUtils.switchToIframe(iframe);
	}
	
}

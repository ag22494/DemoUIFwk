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
public class PaymentPage {

	WebDriver driver;
	CommonUtils commonUtils;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils=new CommonUtils(driver);
	}
	
	
	@FindBy (xpath = "//a[contains(@href,'credit-card')]")
	public WebElement creditCardOption;
	
	public void clickCreditCardOption() {
		commonUtils.click(creditCardOption);
	}
	
	@FindBy (xpath = "//strong[text()='Order ID']/following-sibling::div")
	public WebElement orderId;
	
	public String getOrderId() {
		return commonUtils.getText(orderId);
	}

	@FindBy (xpath = "//label[text()='Phone number']/..//input[@type='tel']")
	public WebElement phone;
	
	public String getPhone() {
		return commonUtils.getAttribute(phone, "placeholder");
	}
	
	@FindBy (xpath = "//label[text()='Email']/..//input[@type='email']")
	public WebElement email;
	
	public String getEmail() {
		return commonUtils.getAttribute(email, "placeholder");
	}
	
	@FindBy (xpath = "//div[@class='button-main show']/a")
	public WebElement payNowButton;
	
	public void clickPayNowButton() {
		commonUtils.isElementPresent(payNowButton);
		commonUtils.click(payNowButton);
	}
	
	public boolean isPayNowButtonPresent() {
		return commonUtils.isDisplayed(payNowButton);
	}
	
	@FindBy (xpath = "//input[@name='cardnumber']")
	public WebElement cardNumber;
	
	public void enterCardNumber(String text) {
		commonUtils.sendKeys(cardNumber, text);
	}
	
	@FindBy (xpath = "//input[@placeholder='MM / YY']")
	public WebElement expiryDate;
	
	public void enterExpiryDate(String text) {
		commonUtils.sendKeys(expiryDate, text);
	}
	
	@FindBy (xpath = "//input[contains(@style,'cvvpass')]")
	public WebElement cvvNumber;
	
	public void enterCvvNumber(String text) {
		commonUtils.sendKeys(cvvNumber, text);
	}
	
	@FindBy (xpath = "//span[@class='text-amount-amount']")
	public WebElement txnAmount;
	
	public String getTxnAmountFromPaymentPage() {
		String[] arr = commonUtils.getText(txnAmount).split(",");
		return arr[0]+arr[1];
	}
	
	@FindBy (xpath = "//div[@class='notice danger']//span[text()='Invalid card number']")
	public WebElement invalidMessage;
	
	public boolean isInvalidMessagePresent() {
		return commonUtils.isElementPresent(invalidMessage);
	}
	
	
}

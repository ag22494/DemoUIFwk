/**
 * 
 */
package pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

/**
 * @author gupta.aakash
 *
 */
public class OrderSummaryPage {

	WebDriver driver;
	CommonUtils commonUtils;

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils=new CommonUtils(driver);
	}
	
	@FindBy (xpath = "//span/p[text()='Order Summary']")
	public WebElement orderSummaryHeader;
	
	public boolean isOrderSummaryHeaderPresent() {
		return commonUtils.isElementPresent(orderSummaryHeader);
	}

	@FindBy (xpath = "//div[@class='button-main show']/a")
	public WebElement continueButton;
	
	public void clickContinueButton() {
		commonUtils.isElementPresent(continueButton);
		commonUtils.click(continueButton);
	}
	
	public boolean isContinueButtonPresent() {
		return commonUtils.isDisplayed(continueButton);
	}
	@FindBy (xpath="//iframe[@id='snap-midtrans']")
	public WebElement modalElement;
	
	public void jumpToModal() {
		commonUtils.switchToIframe(modalElement);
	}
	
	@FindBy (xpath = "//span[@class='item-name']")
	public WebElement itemName;
	
	public String getItemName() {
		return commonUtils.getText(itemName);
	}
	
	@FindBy (xpath = "//span[@class='item-name']/../following-sibling::td")
	public WebElement amount;
	
	public String getAmount() {
		return commonUtils.getText(amount);
	}
	
	@FindBy (xpath = "//span[text()='shipping details']/..")
	public WebElement shippingDetails;
	
	public void clickShippingDetailsButton() {
		commonUtils.click(shippingDetails);
	}
	
	@FindBy (xpath = "//div[text()='Name']/following-sibling::div")
	public WebElement name;
	
	public String getName() {
		return commonUtils.getText(name);
	}
	
	@FindBy (xpath = "//div[text()='Phone number']/following-sibling::div")
	public WebElement phone;
	
	public String getPhone() {
		return commonUtils.getText(phone);
	}
	
	@FindBy (xpath = "//div[text()='Email']/following-sibling::div")
	public WebElement email;
	
	public String getEmail() {
		return commonUtils.getText(email);
	}
	
	@FindBy (xpath = "//div[text()='Address']/following-sibling::div")
	public WebElement address;
	
	public String getAddress() {
		return commonUtils.getText(address);
	}
	
	public Map<String, String> checkoutDetatils() {
		Map<String, String> orderSummaryDetails = new HashMap<>();
		orderSummaryDetails.put("totalAmount", getAmount());
		orderSummaryDetails.put("customerName", getName());
		orderSummaryDetails.put("customerEmail", getEmail());
		orderSummaryDetails.put("customerPhone", getPhone());
		orderSummaryDetails.put("customerAddress", getAddress());
		orderSummaryDetails.put("item", getItemName());
		//System.out.println("Cart Checkout Details "+ checkoutDetails.toString());
		return orderSummaryDetails;
	}
	
	@FindBy (xpath = "//strong[text()='Order ID']/following-sibling::div")
	public WebElement orderId;
	
	public String getOrderId() {
		return commonUtils.getText(orderId);
	}
	
	
	
	
	
	
}

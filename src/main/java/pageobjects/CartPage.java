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
public class CartPage {
	
	
	WebDriver driver;
	CommonUtils commonUtils;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils=new CommonUtils(driver);
	}

	@FindBy(xpath = "//div[@class='cart-checkout']")
	public WebElement checkoutButton;
	
	public boolean verifyCheckoutButton() {
		return commonUtils.isElementPresent(checkoutButton);
	}
	
	public void clickCheckoutButton() {
		commonUtils.click(checkoutButton);
	}
	
	@FindBy(xpath = "//td[@class='amount']")
	public WebElement totalAmount;
	
	public String getTotalCheckoutAmount() {
		return commonUtils.getText(totalAmount);
	}
	
	@FindBy(xpath="//tr/td[text()='Name']/following-sibling::td/input")
	public WebElement customerName;
	
	public String getCustomerName() {
		return commonUtils.getAttribute(customerName, "value");
	}
	
	@FindBy(xpath="//tr/td[text()='Email']/following-sibling::td/input")
	public WebElement customerEmail;
	
	public String getCustomerEmail() {
		return commonUtils.getAttribute(customerEmail, "value");
	}
	
	@FindBy(xpath="//tr/td[text()='Phone no']/following-sibling::td/input")
	public WebElement customerMobile;
	
	public String getCustomerMobile() {
		return commonUtils.getAttribute(customerMobile, "value");
	}
	
	@FindBy(xpath="//tr/td[text()='Address']/following-sibling::td")
	public WebElement customerAddress;
	
	public String getCustomerAddress() {
		return commonUtils.getText(customerAddress);
	}
	
	@FindBy(xpath="//tr/td[text()='City']/following-sibling::td/input")
	public WebElement city;
	
	public String getCity() {
		return commonUtils.getAttribute(city, "value");
	}

	@FindBy(xpath="//tr/td[text()='Postal Code']/following-sibling::td/input")
	public WebElement postCode;
	
	public String getPostalCode() {
		return commonUtils.getAttribute(postCode, "value");
	}
	
	@FindBy (xpath="//input[@type='number']/../preceding-sibling::td[2]")
	public WebElement itemName;
	
	public String getItemName() {
		return commonUtils.getText(itemName);
	}
	
	public Map<String, String> checkoutDetatils() {
		Map<String, String> checkoutDetails = new HashMap<>();
		checkoutDetails.put("totalAmount", getTotalCheckoutAmount());
		checkoutDetails.put("customerName", getCustomerName());
		checkoutDetails.put("customerEmail", getCustomerEmail());
		checkoutDetails.put("customerPhone", getCustomerMobile());
		checkoutDetails.put("customerAddress", getCustomerAddress());
		checkoutDetails.put("city",getCity());
		checkoutDetails.put("postalCode", getPostalCode());
		checkoutDetails.put("item", getItemName());
		//System.out.println("Cart Checkout Details "+ checkoutDetails.toString());
		return checkoutDetails;
	}

}

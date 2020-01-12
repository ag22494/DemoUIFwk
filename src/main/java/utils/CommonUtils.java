/**
 * 
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author gupta.aakash
 *
 */
public class CommonUtils {

	WebDriverWait wait = null;
	String parentWindowHandler = null;
	String subWindowHandler = null;
	private WebDriver webDriver;

	public CommonUtils(WebDriver driver) {
		if ((driver != null)) {
			this.wait = new WebDriverWait(driver, 40);
			this.webDriver = driver;
			this.parentWindowHandler = webDriver.getWindowHandle();
		}
	}

	public CommonUtils() {
	}

	public void getUrl(String url) {
		webDriver.get(url);
	}

	public void selectDropDownByVisibleText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	public void selectDropDownByValue(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void selectDropDownByIndex(WebElement element, int index) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void selectCheckbox(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		boolean checkstatus;
		checkstatus = element.isSelected();
		if (!checkstatus) 
			element.click();
	}

	public boolean validateUrl(String url) {
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public void unselectCheckbox(WebElement element) {
		boolean checkstatus;
		wait.until(ExpectedConditions.elementToBeClickable(element));
		checkstatus = element.isSelected();
		if (checkstatus) 
			element.click();

	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void sendKeys(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	public boolean isEnabled(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Boolean state = false;
		state = element.isEnabled();
		return state;
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void sendKeysWithoutClear(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public void sendKeys(WebElement element, int value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

	public void sendKeys(WebElement element, boolean value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

	public void clickUsingJS(WebDriver driver, WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public String getAttribute(WebElement element, String attributeName) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute(attributeName);
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public String getTitle() {
		return webDriver.getTitle();

	}

	public void getScreenshot(WebElement element, String fileName)
			throws IOException {
		wait.until(ExpectedConditions.visibilityOf(element));
		File scrFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fileName));
	}

	public String getAlertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void switchToPopUp() {

		Set<String> handles = webDriver.getWindowHandles(); // get all window
		// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		webDriver.switchTo().window(subWindowHandler); // switch to popup window
	}

	public void clickBrowserBack() {
		webDriver.navigate().back();
	}

	public void switchToParentFromPopup() {
		webDriver.switchTo().window(parentWindowHandler);
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public boolean isElementPresent(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	public boolean isElementClickable(WebElement element) {
		boolean clickable;
		clickable = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		return clickable;
	}

	/*This function will take format type like "dd/mm/yy" etc and the expected future date
	 * as input and will return the date in a desired format as output
	 * */
	public static String getFutureDate(String format, int futureDays){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDate localDate = LocalDate.now();  
		return dtf.format(localDate.plusDays(futureDays));
	}

	/*This function will take format type like "dd/mm/yy" etc and the expected Past
	 * as input and will return the date in a desired format as output
	 * */
	public String getPastDate(String format, int futureDays){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate.minusDays(futureDays));
	}

	public void switchToIframe(WebElement element) {
		webDriver.switchTo().frame(element);
	}

	public boolean isDisplayed(WebElement element) {
		try {
			//isElementPresent(element);
			if(element.isDisplayed())
				return element.isDisplayed();
		}catch (NoSuchElementException ex) {
			return false;
		}
		return false;
	}

}

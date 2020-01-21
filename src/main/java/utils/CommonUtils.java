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

	public void clickUsingJS(WebDriver driver, WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void getScreenshot(WebElement element, String fileName)
			throws IOException {
		wait.until(ExpectedConditions.visibilityOf(element));
		File scrFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fileName));
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

}

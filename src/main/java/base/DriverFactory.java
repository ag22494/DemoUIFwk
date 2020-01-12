/**
 * 
 */
package base;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author gupta.aakash
 *
 */
public class DriverFactory {
	WebDriver driver;

	public WebDriver openLocalBowser(String browserName, String osName){

		if(browserName.equalsIgnoreCase("chrome")){
			return chromeInit(osName);
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			return firefoxInit();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			return ieInit();
		}
		else{
			System.out.println("Enter Correct Browser name");
			return null;
		}
	}

	private WebDriver ieInit() {

		return null;
	}

	private WebDriver firefoxInit() {
		WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
		FirefoxOptions options = new FirefoxOptions();
		driver = new FirefoxDriver(options);
		return driver;
	}

	private WebDriver chromeInit(String osName) {
		WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		if(osName.toLowerCase().contains("mac"))
			options.addArguments("--kiosk");
		options.setExperimentalOption("excludeSwitches",
				Collections.singletonList("enable-automation"));
		options.addArguments("chrome.switches", "-disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Constants.DRIVER_TIME_OUT, TimeUnit.SECONDS);	
		return driver;

	}

}

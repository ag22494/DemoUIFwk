/**
 * 
 */
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author gupta.aakash
 *
 */
public class TestBase {
	
	public String env;
	public String browser;
	
	@BeforeClass
	@Parameters({"browser"})
	public void baseBeforeClass( @Optional("chrome") String browserType) {
		env= System.getProperty("os.name").toLowerCase();
		System.out.println("Env on which test running "+ env);
		browser= browserType;
		System.out.println("Browser on which test running "+ browser);
	}
	
	public WebDriver setUpDriver() {
		DriverFactory driverFactory = new DriverFactory();
		return driverFactory.openLocalBowser(browser,env);
	}

	//@AfterClass
	public void tearDown() {
		setUpDriver().close();
		setUpDriver().quit();
	}
}

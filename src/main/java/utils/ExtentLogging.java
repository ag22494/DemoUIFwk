/**
 * 
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
/**
 * @author gupta.aakash
 *
 */
public class ExtentLogging {

	int i=0;
	static String currentTestStep="";
	static ExtentReports report;
	static ExtentTest logger;
	CommonUtils commonUtils ;
	WebDriver driver;

	public ExtentLogging (WebDriver driver) {
		this.driver =driver;
		commonUtils = new CommonUtils(driver);
	}

	//to put pass logs
	public void passLog(String testStep,ExtentReports report,ExtentTest logger)
	{
		currentTestStep = testStep;
		logger.log(Status.PASS, "Step: "+(++i)+" "+testStep );
		report.flush();
	}

	//to put information logs
	public void infoLog(String testStep,ExtentReports report,ExtentTest logger)
	{
		currentTestStep = testStep;
		logger.log(Status.INFO, "Step: "+(++i)+" "+testStep );
		report.flush();
	}

	//update the test step for logging
	public void updateTestStep(String teststep,ExtentReports r,ExtentTest l,WebDriver driver)
	{
		currentTestStep=teststep;

	}

	//takes screenshot on failure and logs it as failure along with test-step
		public void sendScreenShotOnFailure(String testStepName,ExtentReports r,ExtentTest l) throws Exception {
		  
		String screenshot_path = captureScreenshot(driver, testStepName);
		
				try {
					report=r;
					logger=l;
					logger.fail("Failed test Step: "+testStepName,MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build());
					report.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		}

	public String captureScreenshot(WebDriver driver, String testStepName) throws IOException{

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");
		String formatedDateAndTime = now.format(format);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\" + formatedDateAndTime.toString() +testStepName+".png"));
		return System.getProperty("user.dir")+"\\Screenshots\\" + formatedDateAndTime.toString() +testStepName+".png";
	}

}


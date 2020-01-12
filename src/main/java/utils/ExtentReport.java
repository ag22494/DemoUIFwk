package utils;///**
// * 
// */
//package utils;
//
//import java.io.File;
//
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
///**
// * @author gupta.aakash
// *
// */
//public class ExtentReport {
//	private static ExtentReport report = null;
//
//	private ExtentReport() {
//
//	}
//
//	// initialize the report and return it to the classes
//	public static ExtentReport getInstance() {
//		
//		//so that threads are executed one by one
//		 synchronized(ExtentReport.class) {
//		if (report == null) {
//			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Listen.file);
//			String configFileDir = System.getProperty("user.dir");
//			htmlReporter.loadXMLConfig(new File(configFileDir+"\\config.xml"));
//			htmlReporter.setAppendExisting(true);
//			report = new ExtentReport();
//			report.attachReporter(htmlReporter);
//			report.setSystemInfo("OS", System.getProperty("os.name"));
//			report.setSystemInfo("Host Name", "Test Machine");
//			report.setSystemInfo("Environment", "Automation");
//		}
//
//		// System.out.println(report);
//		return report;
//	}
//}
//
//}

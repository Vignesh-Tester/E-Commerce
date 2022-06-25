package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports addReport;
	public static ExtentReports getReportObject() {
		
		String reportsPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Testfolder\\reports.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportsPath);
		reporter.config().setReportName("Project Flipkart Results");
		reporter.config().setDocumentTitle("E-Commerce");
		
		addReport = new ExtentReports();
		addReport.attachReporter(reporter);
		addReport.setSystemInfo("Tester", "Ajinesh");
		
		return addReport;
	}
}

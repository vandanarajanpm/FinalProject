package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //folder for save report inside project, format of report help to the extentsparkreportclass 
	reporter.config().setReportName("7RMartSupermarketProject"); //name of report store separate
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura"); //additional information 
	extentReports.setSystemInfo("Name", " vandana"); // provides context of the report
	return extentReports;

	}


}

package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Test_Base;
import freemarker.template.SimpleDate;

public class ExtentReportManager extends Test_Base

{
	// but here humne extend report ka object Globally Liya hai
	// globaly isliye lete hai ki jitne bhi classes hai sabme hum extent report use kr sakte 
static ExtentReports report;
public static ExtentReports getReportInstance()
{
	if(report==null)
	{
		// object create kia report simpleDateformate lia  and formate yahi rahega same
		String reportname=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		// object we took extenthtml report and then in path we added \\report.html  this report.html is name jo humne dia hai
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("G:\\JAR FILES\\eclipse-workspace\\Selenium_Framework_Project\\Extent_Report\\report.html");
		// extend report ka object yaha create kia hai bottom
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		// to add full information, system, OS , Id pass , every detail sab flash hogi report per 
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Environment", "SIT");
		report.setSystemInfo("Build Number", "102.02.02.126");
		report.setSystemInfo("Browser", "Chrome");
		// Report Document Name
		htmlReporter.config().setDocumentTitle("UI Testing Document");
		// report Name
		htmlReporter.config().setReportName("UI Test Report");
		
	}
	return report;
}
}

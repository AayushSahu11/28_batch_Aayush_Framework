package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.Read_Data;

public class Test_Base 
{
	public ExtentReports report=ExtentReportManager.getReportInstance();
	//extendTest ka object Create kia Logger
	public ExtentTest logger;
	
	public static WebDriver driver;
	public void initialization() throws InterruptedException, IOException
	{
		String browser=Read_Data.ReadPropertyFile("Browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup(); // this will do the steup of My Chrome driver Through WebDriverManager
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.get(Read_Data.ReadPropertyFile("URL"));
	driver.manage().deleteAllCookies();
	Thread.sleep(3000);
	}
}

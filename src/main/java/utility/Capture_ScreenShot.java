package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Test_Base;

public class Capture_ScreenShot extends Test_Base
{
	// code to get the Date and Time as well of that Screenshot
	public static String getDate()
	{
		// Predefine Method - Jesa formate hai same code use hoga har jagha 
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
				
	}
	// code for Screenshot
	public static void screenShot(String nameOfMethod) throws IOException
	{
		// method which will capture the screenshot
	 File souce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 // it will save the screenshot in destination with Method Name means jis method me testcase Fail huwa hai  in jpeg with date and time
	 File destination=new File("G:\\JAR FILES\\eclipse-workspace\\Selenium_Framework_Project\\screenShot\\"+nameOfMethod+"--"+getDate()+".jpeg");
	 FileHandler.copy(souce, destination);
	}
}

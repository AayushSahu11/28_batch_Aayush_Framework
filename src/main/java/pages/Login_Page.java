package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Test_Base;
import utility.Read_Data;

public class Login_Page extends Test_Base
{
	// for Application login Test
	// these 3 findby ko we say object Repository @findby method use krni hai toh initialize/to identify our elements
	// below @findby 3 lines are Called as"Object Repository"
	// Repository Means Hum yaha apne sare elements ko Store krte hai
	// sare elements ko inpect se find kia and likha hai
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginbtn;
	public Login_Page() // Constructer
	{
		PageFactory.initElements(driver, this); // this will refer current object
	}
	// encapsulation where we keep variable means credentials pvt and method ko public rakhte hai
	public String lognToApplication() throws IOException
	{
		logger=report.createTest("Login To Sauce Lab Application");
		userTxtBox.sendKeys(Read_Data.ReadPropertyFile("Username"));
		logger.log(Status.INFO, "User Name is Entered"); // .log (status, status) string details
		passwordTxtBox.sendKeys(Read_Data.ReadPropertyFile("Password"));
		logger.log(Status.INFO, "Password Is Entered");
		loginbtn.click();
		logger.log(Status.INFO, "Login Button Is Clicked");
		logger.log(Status.PASS, "Login Is Successfull");
		// after clicking on login button we want the current URL of our login page
		return driver.getCurrentUrl(); 
	}
	
	public String loginToMultipleCredentials(String un, String pass)
	{
		userTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginbtn.click();
		// after clicking on login button we want the current URL of our login page
		return driver.getCurrentUrl(); 
	}
	
// first testcase to find out the title of our application 
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	// for URL verification
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}

}

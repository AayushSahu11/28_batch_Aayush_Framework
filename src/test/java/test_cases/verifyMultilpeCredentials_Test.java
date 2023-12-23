package test_cases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Test_Base;
import pages.Login_Page;
import utility.Capture_ScreenShot;

public class verifyMultilpeCredentials_Test extends Test_Base
{
		Login_Page login; // here Login ko Global Declare kia and its a object, agar login = new k pass krte Login login-new Login_page yse krke toh wo Private hota Now we can declare it in all test
	@BeforeMethod (alwaysRun = true) // alwaysrun true means sab fail ho jaye but this will execute 
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new Login_Page();
	}
	// Yeh Method Khud se run ni hota isko run krne k liye jis method me run kr rhe hai uska name and do by Below
	// konse me apply krna hai usme bhi data provider ka name hoga (name= data provider name , khud se de sakte hai name)
	// @DataProvider is Annotation provided By TestNG
	@DataProvider(name= "Credentials")
	// Object is data [][] is Two dimensional Array for String Datatype
	public Object[][]getData() // object  put kia and [] first me un username [] me pass store hoga
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
				};
	}
	
	
	@Test (dataProvider="Credentials") // Data provider name will be copid and paste here
	public void loginToMultipleCredentials(String un, String pass)
	{
		SoftAssert soft=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToMultipleCredentials(un, pass);
		soft.assertEquals(expURL, actURL);
		soft.assertAll();
	}
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_ScreenShot.screenShot(it.getName()); // this it.getname will give the name of the method
		}
			
		driver.close();
	}
}

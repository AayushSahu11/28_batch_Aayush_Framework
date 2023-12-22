package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Login_Page;
import utility.Capture_ScreenShot;
import utility.Read_Data;

public class Login_Page_Test extends Test_Base
{
	Login_Page login; // here Login ko Global Declare kia and its a object, agar login = new k pass krte Login login-new Login_page yse krke toh wo Private hota Now we can declare it in all test
	// Before method (alwaysRun = true) means kuch bhi ho but before method run hona chaiye 
@BeforeMethod(alwaysRun = true)
public void setup() throws InterruptedException, IOException
{
	initialization();
	login=new Login_Page();
}
//Test Case for Title Verification of Application
//(priroty = rank) Its ki konsa test pehle run hoga and enabled=true/false means true krne per wahi run hoga false per nahi
@Test (priority=2, enabled=true, groups = "Sanity" )
public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
{
	String expTitle=Read_Data.readExcel(0,0); // Swag Labs (row 0 ,col 0)
	String actTitle=login.verifyTitleOfApplication();
	Assert.assertEquals(expTitle, actTitle);
}

//Test Case for URL Verification of Application
//(priroty = rank) Its ki konsa test pehle run hoga and enabled=true/false means true krne per wahi run hoga false per nahi

// (priority=1, enabled=true, dependsOnMethods = "test case name")
// depends on se hum sari method or test cae ko ek test per depend krte hai
@Test (priority=1, enabled=true, groups = {"Sanity","Retesting"})
public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
{
	String expURL=Read_Data.readExcel(0,1); // https://www.saucedemo.com/ (row 0 ,col 1)
	String actURL=login.verifyURLOfApplication();
	Assert.assertEquals(expURL, actURL);
}

// Test Case for Login of Application
//(priroty = rank) Its ki konsa test pehle run hoga and enabled=true/false means true krne per wahi run hoga false per nahi

@Test (priority=3, enabled=true, groups = "Regression")
public void lognToApplicationTest() throws IOException
{
	String expURL=Read_Data.readExcel(0,2); //https://www.saucedemo.com/inventory.html, (row 0 ,col 2)
	String actURL=login.lognToApplication();
	Assert.assertEquals(expURL , actURL);
}
@AfterMethod (alwaysRun = true)
public void closeBrowser(ITestResult it) throws IOException
{
	if(it.FAILURE==it.getStatus())
	{
		Capture_ScreenShot.screenShot(it.getName()); // this it.getname will give the name of the method
	}
		report.flush(); // extent report Method
	driver.close();
}
}

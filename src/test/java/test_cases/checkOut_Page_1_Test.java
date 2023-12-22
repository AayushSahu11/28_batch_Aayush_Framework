package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Inventory_Page_2;
import pages.Login_Page;
import pages.cart_Page_3;
import pages.checkout_Page_1;
import utility.Capture_ScreenShot;
import utility.Read_Data;

public class checkOut_Page_1_Test extends Test_Base
{
	Login_Page login;
	Inventory_Page_2 invent;
	cart_Page_3 cart;
	checkout_Page_1 check1;
	
	@BeforeMethod (alwaysRun = true)
	
	public void setup() throws InterruptedException, IOException
	{
		// object creation for both the pages, ek application me first page ka object har next page me upper add hoga
		// OBJECT CREATION FOR ALL 3 Pages Till Now
		initialization();
		login=new Login_Page();
		invent=new Inventory_Page_2();
		cart=new cart_Page_3();
		check1=new checkout_Page_1();
		login.lognToApplication();	
		invent.add6Product();
		invent.verifyAddTOCart();
		cart.clickOnCheckOutBtn();
	}
	
	@Test
	public void verifyURLofCheckOutPage1Test() throws EncryptedDocumentException, IOException
	{
		String expURL=Read_Data.readExcel(2,0); //"https://www.saucedemo.com/checkout-step-one.html" , (row 2 ,col 0)
		String actURL=check1.verifyURLofCheckOutPage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL Of CheckOut Page 1 =" + actURL);
	}
	
	@Test
	public void verifycheckoutpage1Logo() throws EncryptedDocumentException, IOException
	{
		String explogo=Read_Data.readExcel(2,1); //"Swag Labs" ,(row 2 ,col 1)
		String actlogo=check1.verifycheckoutpage1Logo();
		Assert.assertEquals(explogo, actlogo);
		Reporter.log("Logo of the Checkout Page 1 =" + actlogo);
	}
	
	@Test
	public void verifycheckoutYourInformationLable() throws EncryptedDocumentException, IOException
	{
		String expInfoLable=Read_Data.readExcel(2,2);// "Checkout: Your Information",(row 2 ,col 2)
		String actInfoLable=check1.verifycheckoutYourInformationLable();
		Assert.assertEquals(expInfoLable, actInfoLable);
		Reporter.log("Information lable Of Checkout Page 1 =" + actInfoLable);
	}
	
	@Test
	public void inputInformation() throws EncryptedDocumentException, IOException
	{
		String exptextbox=Read_Data.readExcel(2,3); // "https://www.saucedemo.com/checkout-step-two.html",(row 2 ,col 3)
		String acttextbox=check1.inputInformation();
		Assert.assertEquals(exptextbox, acttextbox);
		Reporter.log("TextBox is Working =" + acttextbox);
	}
	
	@Test
	public void verifycancleButton() throws EncryptedDocumentException, IOException
	{
		String expCancleBtn=Read_Data.readExcel(2,4 );//"https://www.saucedemo.com/cart.html", (row 2 ,col 4)
		String actCancleBtn=check1.verifycancleButton();
		Assert.assertEquals(expCancleBtn, actCancleBtn);
		Reporter.log("Cancle Button is Working =" + actCancleBtn);
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

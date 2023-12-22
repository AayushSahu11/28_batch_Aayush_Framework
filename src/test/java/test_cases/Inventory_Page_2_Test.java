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
import utility.Capture_ScreenShot;
import utility.Read_Data;

public class Inventory_Page_2_Test extends Test_Base
{
Login_Page login;
Inventory_Page_2 invent;

// (alwaysRun = true) means kuch bhi ho but before method run hogi hi even test case fail ho jaye
@BeforeMethod (alwaysRun = true)
public void setup() throws InterruptedException, IOException
{
	// object creation for both the pages, ek application me first page ka object har next page me upper add hoga
	initialization();
	login=new Login_Page();
	invent=new Inventory_Page_2();
	login.lognToApplication();
	
}
@Test (priority=1, enabled=true, groups = "Sanity" )
	public void verifyappLogoTest() // App Logo
{
	String expLogo="Swag Labs";
	String actLogo= invent.verifyappLogo();
	Assert.assertEquals(expLogo, actLogo);
	// Reporter- or.testing -
	Reporter.log("Logo of inventory page = " + actLogo);
}
	// Product Lable
@Test (priority=2, enabled=true, groups = "Sanity" )
	public void productLableTest() throws EncryptedDocumentException, IOException
{
	String expLabel=Read_Data.readExcel(0,3); // Products, (row 0. col 3)
	String actLabel=invent.verifyproductLable();
	Assert.assertEquals(expLabel, actLabel);
	// Reporter- or.testing
	Reporter.log("Label of inventory page = " + actLabel);
	
}	
	// Twitter logo
@Test (priority=3, enabled=true, groups = "Sanity" )
	public void verifytwitterLogoTest()
	{
		// always use boolean result= Page_object_name.elementName whenever we are doing test on image or logo
		boolean result=invent.verifytwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Twitter Logo = " + result);
	}
	// Facebook Logo
@Test (priority=4, enabled=true, groups = "Sanity" )
	public void verifyfacebookLogoTest()
	{
		boolean result=invent.verifyfacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook Logo = " + result);
	}

	// Linkedin Logo
@Test (priority=5, enabled=true, groups = "Sanity" )
	public void verifylinkedinLogo()
	{
		boolean result=invent.verifylinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Linkedin Logo = " + result);
	}
	@Test (priority=6, enabled=true, groups = "Retesting" )
	public void verifymenuButtonTest()
	{
		boolean result=invent.verifymenuButton();
		Assert.assertEquals(result, true);
		Reporter.log("Menu Button is Visible = " + result);
	}
	@Test (priority=11, enabled=true, groups = "Sanity" )
	public void verifywebPageFooterTest()
	{
		String expFooter="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooter=invent.verifywebPageFooter();
		Assert.assertEquals(expFooter, actFooter);
		Reporter.log("Visibility of FOOTER = " + actFooter);
	}
	
	@Test (priority=7, enabled=true, groups = {"Retesting","Regression"} )
	// test Case to ADD ALL PRODUCT in CART
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=Read_Data.readExcel(0,4); // 6, (row 0,col 4)
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Added To Cart = " + actCount);
	}
	@Test (priority=8, enabled=true, groups = {"Retesting","Regression"} )
	public void verifyAddTOCartTest()
	{
	String expURL="https://www.saucedemo.com/cart.html";
	String actURL=invent.verifyAddTOCart();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Add To Cart Button is Working = " + actURL);
	}
	
	@Test (priority=9, enabled=true, groups = "Sanity" )// Test For QTY Lebel and Description Lebel after click Add To Cart Button
	public void verifyquantityLableTest() throws EncryptedDocumentException, IOException // QTY Label
	{
		String expQtyLable=Read_Data.readExcel(0,6); // QTY (row0,col 6)
		String actQtyLable=invent.verifyquantityLable();
		Assert.assertEquals(expQtyLable, actQtyLable);
		Reporter.log("Quantity Label is Visible = " + actQtyLable);
	}
	
	@Test (priority=10, enabled=true, groups = "Sanity" )
	//Description Label
	public void verifydescriptionLableTest()
	{
		String expdescpLable="Description";
		String actdescpLable=invent.verifydescriptionLable();
		Assert.assertEquals(expdescpLable, actdescpLable);
		Reporter.log("Description Label is Visible = " + actdescpLable);
	}
	
	@Test (priority=12, enabled=true, groups = {"Retesting","Regression"} )
	//Continue Shopping Button Test Case
	public void verifycontinueShoppingBTNTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=invent.verifycontinueShoppingBTN();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Continue Shopping Button is Working = " + actURL);
	}
	
	// Check Out Button Test Case
	@Test (priority=13, enabled=true, groups = {"Retesting","Regression"} )
	public void verifycheckOutBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=invent.verifycheckOutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Check Out Button is Working = " + actURL);
	}
	
	// REMOVE PRODUCT TEST CASE
	@Test (priority=14, enabled=true, groups = {"Retesting","Regression"} )
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=Read_Data.readExcel(0,5); // 4 isliye 2 product remove from 6 , 6product - 2 product = 4 product // 4(row 0, col 5)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count Of Product After Removing = " + actCount);
	}
	
@AfterMethod  @BeforeMethod (alwaysRun = true)// we will write screenshot code here because its a aftermethod process for failed test case
public void closeBrowser(ITestResult it) throws IOException
{
	if(it.FAILURE==it.getStatus())
	{
		Capture_ScreenShot.screenShot(it.getName()); // this it.getname will give the name of the method
	}
		
	driver.close();
}
}

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
import utility.Capture_ScreenShot;
import utility.Read_Data;

public class cart_Page_3_Test extends Test_Base
{
Login_Page login;
Inventory_Page_2 invent;
cart_Page_3 cart;

@BeforeMethod (alwaysRun = true)

public void setup() throws IOException, InterruptedException
{
	// OBJECT CREATION FOR ALL 3 Pages Till Now
	initialization();
	login=new Login_Page();
	invent=new Inventory_Page_2();
	cart=new cart_Page_3();
	login.lognToApplication();	
	
}
// TO CLICK TO THE NEXT PAGE 
@Test
public void verifyaddTOCart() throws EncryptedDocumentException, IOException
{
String expURL=Read_Data.readExcel(1,0); // "https://www.saucedemo.com/cart.html" (row 1 ,col 0)
String actURL=cart.verifyaddTOCart();
Assert.assertEquals(expURL, actURL);
Reporter.log("Add To Cart Button is Working = " + actURL);
}

// VERIFY LOGO OF CART PAGE TEST CASE
@Test
public void verifyappLogo() throws EncryptedDocumentException, IOException
{
	String expAppLogo=Read_Data.readExcel(1,1);//"Swag Labs", (row 1 ,col 1)
	String actAppLogo=cart.verifyappLogo();
	Assert.assertEquals(expAppLogo, actAppLogo);
	Reporter.log("SWAG LAB LOGO IS VERIFIED = " + actAppLogo);
}

// VERIFY YOUR CART LABLE TEST CASE
public void verifyyourcartLable() throws EncryptedDocumentException, IOException
{
	String expYourCart=Read_Data.readExcel(1,2);// "Your Cart",(row 1 ,col 2)
	String actYourCart=cart.verifyyourcartLable();
	Assert.assertEquals(expYourCart, actYourCart);
	Reporter.log("Your Cart Lable Is Visible = " + actYourCart);
}

//VERIFY QTY LABLE TEST CASE
@Test
public void verifyquantityLable() throws EncryptedDocumentException, IOException
{
	String expQTY=Read_Data.readExcel(1, 3); //"QTY" , (row 1 ,col 3)
	String actQTYt=cart.verifyquantityLable();
	Assert.assertEquals(expQTY, actQTYt);
	Reporter.log("QTY Is Visible = " + actQTYt);
}

// VERIFY DESCRIPTION LABLE TEST CASE
@Test
public void verifydescriptionLable() throws EncryptedDocumentException, IOException
{
	String expdesc=Read_Data.readExcel(1, 4);//"Description",(row 1 ,col 4)
	String actdesc=cart.verifydescriptionLable();
	Assert.assertEquals(expdesc, actdesc);
	Reporter.log("Description Lable Is Visible = " + actdesc);
}


//VERIFY TWITTER LOGO  TEST CASE
@Test
 public void verifytwitterLogo()
{
	boolean result=cart.verifytwitterLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Twitter Logo Is Visible = " + result);
}

///VERIFY FACEBOOK LOGO  TEST CASE
@Test
public void verifyfacebookLogo()
{
	boolean result=cart.verifyfacebookLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Facebook Logo Is Visible = " + result);
}

//VERIFY LINKEDIN LOGO  TEST CASE
@Test
public void verifylinkedinLogo()
{
	boolean result=cart.verifylinkedinLogo();
	Assert.assertEquals(result, true);
	Reporter.log("Linkdin Logo Is Visible = " + result);
}

// VERIFY MENU BUTTON TEST CASE
@Test
public void  verifymenuButton()
{
	boolean result=cart.verifymenuButton();
	Assert.assertEquals(result, true);
	Reporter.log("Menu Button is Visible = " + result);
}


// VERIFY CONTINUE SHOPPING BUTTON TEST CASE
@Test
public void verifycontinueShoppingBTN() throws EncryptedDocumentException, IOException
{
	String expURL=Read_Data.readExcel(1, 5); //"https://www.saucedemo.com/inventory.html" , (row 1 ,col 5)
	String actURL=cart.verifycontinueShoppingBTN();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Continue Shopping Button is Working = " + actURL);
}

// VERIFY CHECKOUT BUTTON TEST CASE
@Test
public void verifycheckOutBtn() throws EncryptedDocumentException, IOException
{
	String expURL=Read_Data.readExcel(1, 6);//"https://www.saucedemo.com/checkout-step-one.html" ,(row 1 ,col 6)
	String actURL=cart.verifycheckOutBtn();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("Checkout Button is Working = " + actURL);
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

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
import pages.checkoutPage_2;
import pages.checkout_Page_1;
import utility.Capture_ScreenShot;
import utility.Read_Data;

public class checkOut_Page_2_Test extends Test_Base
{

	Login_Page login;
	Inventory_Page_2 invent;
	cart_Page_3 cart;
	checkout_Page_1 check1;
	checkoutPage_2 check2;
	
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
		check2=new checkoutPage_2();
		login.lognToApplication();	
		invent.add6Product();
		invent.verifyAddTOCart();
		cart.clickOnCheckOutBtn();
		check1.inputInformation();
	}
@Test
// VERIFY verifycheckoutPage2OverviewLable
public void verifycheckoutPage2OverviewLable() throws EncryptedDocumentException, IOException
{
	String expOverviewLable=Read_Data.readExcel(3,0); // "Checkout: Overview",(row 3 ,col 0)
	String actOverviewLable=check2.verifycheckoutPage2OverviewLable();
	Assert.assertEquals(expOverviewLable, actOverviewLable);
	Reporter.log("Overview Lable of CheckoutPage 2 =" + actOverviewLable);
}

@Test
public void checkoutPage2QTYLable() throws EncryptedDocumentException, IOException
{
	String expQTY=Read_Data.readExcel(3,1); // "QTY", (row 3 ,col 1)
	String actQTY=check2.checkoutPage2QTYLable();
	Assert.assertEquals(expQTY, actQTY);
	Reporter.log("QTY Lable is Presnet =" + actQTY);
}


@Test
public void checkoutPage2DescriptionLable() throws EncryptedDocumentException, IOException
{
	String expDesc=Read_Data.readExcel(3,2);// "Description", (row 3 ,col 2)
	String actDesc=check2.checkoutPage2DescriptionLable();
	Assert.assertEquals(expDesc, actDesc);
	Reporter.log("Description Lable is Presnet =" + actDesc);

}

@Test
public void checkoutPage2BikeLightProduct() throws EncryptedDocumentException, IOException
{
	String expLightPro=Read_Data.readExcel(3,3); // "https://www.saucedemo.com/inventory-item.html?id=0" (row 3 ,col 3) 
	String actLightPro=check2.checkoutPage2BikeLightProduct();
	Assert.assertEquals(expLightPro, actLightPro);
	Reporter.log("Bike Light Product is Verified =" + actLightPro);

}

@Test
public void checkoutPage2BoltTshirtProduct() throws EncryptedDocumentException, IOException
{
	String expBoltShirtPro=Read_Data.readExcel(3,4); // "https://www.saucedemo.com/inventory-item.html?id=1" ,(row 3 ,col 4)  
	String actBoltShirtPro=check2.checkoutPage2BoltTshirtProduct();
	Assert.assertEquals(expBoltShirtPro, actBoltShirtPro);
	Reporter.log("Bolt T Shirt Product is Verified =" + actBoltShirtPro);

}


@Test
public void checkoutPage2TshirtRedProduct() throws EncryptedDocumentException, IOException
{
	String expRedShirtPro=Read_Data.readExcel(3,5);// "https://www.saucedemo.com/inventory-item.html?id=3" , (row 3 ,col 5) 
	String actRedShirtPro=check2.checkoutPage2TshirtRedProduct();
	Assert.assertEquals(expRedShirtPro, actRedShirtPro);
	Reporter.log("Red T-Shirt Product is Verified =" + actRedShirtPro);

}


@Test
public void checkoutPage2FleeceJacketProduct() throws EncryptedDocumentException, IOException
{
	String expFjacketPro=Read_Data.readExcel(3,6); // "https://www.saucedemo.com/inventory-item.html?id=5" , (row 3 ,col 6)
	String actFjacketPro=check2.checkoutPage2FleeceJacketProduct();
	Assert.assertEquals(expFjacketPro, actFjacketPro);
	Reporter.log("Fleece Jacket Product Is Verified =" + actFjacketPro);

}


@Test
public void checkoutPage2OnesieProduct() throws EncryptedDocumentException, IOException
{
	String expOnesiePro=Read_Data.readExcel(3,7); // "https://www.saucedemo.com/inventory-item.html?id=2", (row 3 ,col 7)
	String actOnesiePro=check2.checkoutPage2OnesieProduct();
	Assert.assertEquals(expOnesiePro, actOnesiePro);
	Reporter.log("Onesie Product is Verified =" + actOnesiePro);

}


@Test
public void checkoutPage2BackpackProduct() throws EncryptedDocumentException, IOException
{
	String expBackPackPro=Read_Data.readExcel(3,8); //"https://www.saucedemo.com/inventory-item.html?id=4" , (row 3 ,col 8)
	String actBackPackPro=check2.checkoutPage2BackpackProduct();
	Assert.assertEquals(expBackPackPro, actBackPackPro);
	Reporter.log("BackPack Product is Verified =" + actBackPackPro);

}


@Test
public void checkoutPage2PaymentInfoLable() throws EncryptedDocumentException, IOException
{
	String expPayInfoLable=Read_Data.readExcel(3,9); //"Payment Information" , (row 3 ,col 9)
	String actPayInfoLable=check2.checkoutPage2PaymentInfoLable();
	Assert.assertEquals(expPayInfoLable, actPayInfoLable);
	Reporter.log("Payment Information Lable is Visible =" + actPayInfoLable);

}


@Test
public void checkoutPage2ShippingInfoLable() throws EncryptedDocumentException, IOException
{
	String expShipInfoLable=Read_Data.readExcel(3,10);  //"Shipping Information", (row 3 ,col 10)
	String actShipInfoLable=check2.checkoutPage2ShippingInfoLable();
	Assert.assertEquals(expShipInfoLable, actShipInfoLable);
	Reporter.log("Shipping Information lable is Visible =" + actShipInfoLable);

}


@Test
public void checkoutPage2PriceTotalLable() throws EncryptedDocumentException, IOException
{
	String expPriceTotalLable=Read_Data.readExcel(3,11); // "Price Total" , (row 3 ,col 11)
	String actPriceTotalLable=check2.checkoutPage2PriceTotalLable();
	Assert.assertEquals(expPriceTotalLable, actPriceTotalLable);
	Reporter.log("Price Total Lable is Visible =" + actPriceTotalLable);

}


@Test
public void checkoutPage2TotalAmountLable() throws EncryptedDocumentException, IOException
{
	String expSumTL=Read_Data.readExcel(3,12);//"Total: $140.34" , (row 3 ,col 12)
	String actSumTL=check2.checkoutPage2TotalAmountLable();
	Assert.assertEquals(expSumTL, actSumTL);
	Reporter.log("Summary Total Lable is Visible =" + actSumTL);

}


@Test
public void checkoutPage2CancleBTN() throws EncryptedDocumentException, IOException
{
	String expCancleBTN=Read_Data.readExcel(3,13); // "https://www.saucedemo.com/inventory.html", (row 3 ,col 13)
	String actCancleBTN=check2.checkoutPage2CancleBTN();
	Assert.assertEquals(expCancleBTN, actCancleBTN);
	Reporter.log("Cancle Button is Verified =" + actCancleBTN);

}


@Test
public void checkoutPage2FinishBTN() throws EncryptedDocumentException, IOException
{
	String expFinishBTN=Read_Data.readExcel(3,14);//"https://www.saucedemo.com/checkout-complete.html" , (row 3 ,col 14)
	String actFinishBTN=check2.checkoutPage2FinishBTN();
	Assert.assertEquals(expFinishBTN, actFinishBTN);
	Reporter.log("Finish Button is Verified =" + actFinishBTN);

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

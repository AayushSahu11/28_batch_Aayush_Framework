package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class checkoutPage_2 extends Test_Base
{
	// these all findby ko we say object Repository @findby method use krni hai toh initialize/to identify our elements
		// below @findby 3 lines are Called as"Object Repository"
		// Repository Means Hum yaha apne sare elements ko Store krte hai
		// sare elements ko inpect se find kia and likha hai
		
		//Object Repository below -
	// TOP LABLES
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutPage2OverviewLable;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement checkoutPage2QTYLable;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement checkoutPage2DescriptionLable;
	
	// PRODUCTS
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']") private WebElement checkoutPage2BikeLightProduct;
	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']") private WebElement checkoutPage2BoltTshirtProduct;
	@FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']") private WebElement checkoutPage2TshirtRedProduct;
	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']") private WebElement checkoutPage2FleeceJacketProduct;
	@FindBy(xpath = "//div[text()='Sauce Labs Onesie']") private WebElement checkoutPage2OnesieProduct;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement checkoutPage2BackpackProduct;
	
	// BOTTOM LABLES
	@FindBy(xpath = "//div[text()='Payment Information']") private WebElement checkoutPage2PaymentInfoLable;
	@FindBy(xpath = "//div[text()='Shipping Information']") private WebElement checkoutPage2ShippingInfoLable;
	@FindBy(xpath = "//div[text()='Price Total']") private WebElement checkoutPage2PriceTotalLable;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement checkoutPage2TotalAmountLable;
	
	// CANCLE AND FINISH BUTTON
	@FindBy(xpath = "//button[@name='cancel']") private WebElement checkoutPage2CancleBTN;
	@FindBy(xpath = "//button[@name='finish']") private WebElement checkoutPage2FinishBTN;

	// This is a Constructor = yeh batyega ki aage ka part/ Codes available hai ki nahi.
public  checkoutPage_2()
{
	PageFactory.initElements(driver, this);// this current object ko point out karega
}

// Verify OVERVIEW Lable
public String verifycheckoutPage2OverviewLable()
{
	return checkoutPage2OverviewLable.getText();
}

// Verify QYT Lable
public String checkoutPage2QTYLable()
{
	return checkoutPage2QTYLable.getText();
}

// Verify Description Lable
public String checkoutPage2DescriptionLable()
{
	return checkoutPage2DescriptionLable.getText();
}

// VERIFY PRODUCTS

public String checkoutPage2BikeLightProduct()
{
	checkoutPage2BikeLightProduct.click();
	return driver.getCurrentUrl();
}

public String checkoutPage2BoltTshirtProduct()
{
	checkoutPage2BoltTshirtProduct.click();
	return driver.getCurrentUrl();
}
public String checkoutPage2TshirtRedProduct()
{
	checkoutPage2TshirtRedProduct.click();
	return driver.getCurrentUrl();
}

public String checkoutPage2FleeceJacketProduct()
{
	checkoutPage2FleeceJacketProduct.click();
	return driver.getCurrentUrl();
}

public String checkoutPage2OnesieProduct()
{
	checkoutPage2OnesieProduct.click();
	return driver.getCurrentUrl();
}

public String checkoutPage2BackpackProduct()
{
	checkoutPage2BackpackProduct.click();
	return driver.getCurrentUrl();
}

// VERIFY BOTTOM LABLES TOTAL, PRICE TOTAL, SHIPPING INFORMATION , PAYMENT INFORMATION

public String checkoutPage2PaymentInfoLable()
{
	return checkoutPage2PaymentInfoLable.getText();
}

public String checkoutPage2ShippingInfoLable()
{
	return checkoutPage2ShippingInfoLable.getText();
}

public String checkoutPage2PriceTotalLable()
{
	return checkoutPage2PriceTotalLable.getText();
}

public String checkoutPage2TotalAmountLable()
{
	return checkoutPage2TotalAmountLable.getText();
}

// VERIFY CANCLE BUTTON
public String checkoutPage2CancleBTN()
{
checkoutPage2CancleBTN.click();
return driver.getCurrentUrl();
}

// VERIFY FINISH BUTTON
public String checkoutPage2FinishBTN()
{
	checkoutPage2FinishBTN.click();
	return driver.getCurrentUrl();
}

}

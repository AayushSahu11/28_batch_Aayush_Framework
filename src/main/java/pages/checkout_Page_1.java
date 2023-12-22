package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class checkout_Page_1 extends Test_Base
{
	// these all findby ko we say object Repository @findby method use krni hai toh initialize/to identify our elements
	// below @findby 3 lines are Called as"Object Repository"
	// Repository Means Hum yaha apne sare elements ko Store krte hai
	// sare elements ko inpect se find kia and likha hai
	
	//Object Repository below -
	
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement checkoutpage1Logo;
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutYourInformationLable;
	@FindBy(xpath = "//input[@name='firstName']") private WebElement firstNameTextBox;
	@FindBy(xpath = "//input[@name='lastName']") private WebElement lastNameTextBox;
	@FindBy(xpath = "//input[@name='postalCode']") private WebElement postalCodeTextBox;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancleButton;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueButton;
	
	// This is a Constructor = yeh batyega ki aage ka part/ Codes available hai ki nahi.
	public checkout_Page_1()
	{
		PageFactory.initElements(driver, this); // this current object ko point out karega
	}
	
	// verify URL
	public String verifyURLofCheckOutPage1()
	{
		return driver.getCurrentUrl();
	}
	
	// Verify CHECKOUT PAGE LOGO
	public String verifycheckoutpage1Logo()
	{
		return checkoutpage1Logo.getText();
	}
	
	// Verify YOUR INFORMATION LABLE
	public String verifycheckoutYourInformationLable()
	{
		return checkoutYourInformationLable.getText();
	}
	
	// Combaining All 3 xpath into One Method
	// Verify FirstName, LastName, Postal Code Testbox
	public String inputInformation()
	{
		firstNameTextBox.sendKeys("Aayush");
		lastNameTextBox.sendKeys("Sahu");
		postalCodeTextBox.sendKeys("482001");
		continueButton.click();
		return driver.getCurrentUrl();
	}
	
	// VERIFY CANCLE BUTTON
	public String verifycancleButton()
	{
		cancleButton.click();
		return driver.getCurrentUrl();

	}
	
}

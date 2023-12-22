package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class cart_Page_3  extends Test_Base
{
	// these all findby ko we say object Repository @findby method use krni hai toh initialize/to identify our elements
	// below @findby 3 lines are Called as"Object Repository"
	// Repository Means Hum yaha apne sare elements ko Store krte hai
	// sare elements ko inpect se find kia and likha hai
	
	//Object Repository below -
	// LOGO and Label and Footer
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement yourcartLable;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuButton;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement quantityLable;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionLable;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement cartpagefooter;
	
	// Buttons
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBTN;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkOutBtn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement addTOCart;
	
	
	// this is a Constructor - To call each and every Element
	public cart_Page_3()
	{
		PageFactory.initElements(driver , this);
	}
	
	// To VERIFY APP LOGO
	public String verifyappLogo()
	{
		addTOCart.click();
		return appLogo.getText();
	}

	// TO VERIFY YOUR CART LABLE
	public String verifyyourcartLable()
	{
		addTOCart.click();
		return yourcartLable.getText();
	}
	
	// TO VERIFY QTY LABLE
		public String verifyquantityLable()
		{
			addTOCart.click();
			return quantityLable.getText();
		}

		// TO VERIFY DESCRIPTION LABLE
		public String verifydescriptionLable()
		{
			addTOCart.click();
			return descriptionLable.getText();
		}
		
		
		// TO VERIFY TWITTER LOGO
		public boolean verifytwitterLogo()
		{
			addTOCart.click();
			return twitterLogo.isDisplayed();
		}
		
		// TO VERIFY FACEBOOK LOGO
		public boolean verifyfacebookLogo()
		{
			addTOCart.click();
			return facebookLogo.isDisplayed();
		}
		
		// TO VERIFY LINKEDIN LOGO
		public boolean verifylinkedinLogo()
		{
			addTOCart.click();
			return linkedinLogo.isDisplayed();
		}
		
		// TO VERIFY MENU BUTTON
		public boolean verifymenuButton()
		{
			addTOCart.click();
			return menuButton.isDisplayed();
		}
		

		// TO VERIFY CONTINUE SHOPPING BUTTON
		public String verifycontinueShoppingBTN()
		{
			addTOCart.click();
			continueShoppingBTN.click();
			return driver.getCurrentUrl();
		}
		
		// TO VERIFY CHECKOUT BUTTON
		public String verifycheckOutBtn()
		{
			addTOCart.click();
			checkOutBtn.click();
			return driver.getCurrentUrl();
		}
		
		// ADD TO CART BUTTON TO CLICK on next page
		public String verifyaddTOCart()
		{
			addTOCart.click();
			return driver.getCurrentUrl();
		}
		
		public void clickOnCheckOutBtn()
		{
			checkOutBtn.click();
		}
}	
		
		


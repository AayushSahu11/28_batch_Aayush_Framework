package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;
import utility.handle_DropDown_List;

public class Inventory_Page_2 extends Test_Base
{
	//Object Repository below -
	// objects
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement addTOCart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	// Product Added To Cart - 
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProductAddToCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProductAddtoCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement bTshirtProductAddtoCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fJackatProductAddToCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProductAddtoCartBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProductAddToCartBtn;
	// Logos and Label
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//span[@class='title']") private WebElement productLable;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement menuButton;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement webPageFooter;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement quantityLable;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement descriptionLable;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBTN;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkOutBtn;
	// Remove Product xpaths
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackPackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLightProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeFleeceJacketProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeOnesieProduct;
	@FindBy(xpath ="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeRedTshirtProduct;
	// this is a Constructor - To call each and every Element
	public Inventory_Page_2()
	{
		PageFactory.initElements(driver , this);
	}
	
	// App Logo Verification using .gettext method
	public String verifyappLogo()
	{
		return appLogo.getText();
	}
	
	// Product Header lable Verification using .gettext method
	public String verifyproductLable()
	{
		return productLable.getText();
	}
	
	// Twitter Logo Verification using .isDisplayed method
	public boolean verifytwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	// Facebook Logo Verification using .isDisplayed method
	public boolean verifyfacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	// Linkedin Logo Verification using .isDisplayed method
	public boolean verifylinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	
	// Menu Button
	public boolean verifymenuButton()
	{
		return menuButton.isDisplayed();
	}
	
	// Web Page Footer verification using .getText method to see text is visible or not
	public String verifywebPageFooter()
	{
		return webPageFooter.getText();
	}
	
	// verification of add to cart button using .click >> return driver.getCurrentURL()
	public String verifyAddTOCart() // add to cart button verification
	{
		addTOCart.click();
		return driver.getCurrentUrl();
		
	}
	
	
	// Cart Count option inside add to card button after adding product to card 
	public String add6Product() // product page per hai select kiye
	{
		handle_DropDown_List.handleSelectClass(dropDown, "Price (low to high)");
		backPackProductAddToCartBtn.click();
		bikeLightProductAddtoCartBtn.click();
		bTshirtProductAddtoCartBtn.click();
		fJackatProductAddToCartBtn.click();
		onesieProductAddtoCartBtn.click();
		redTshirtProductAddToCartBtn.click();
		return cartCount.getText();
	}
	
	// Verify QUANTITY LABEL
	public String verifyquantityLable()
	{
		addTOCart.click();
		return quantityLable.getText();
	}
	
	// Verify Description Label
	public String verifydescriptionLable()
	{
		addTOCart.click();
		return descriptionLable.getText();
	}
	
	// Check out Button verification 
	public String verifycheckOutBtn()
	{
		addTOCart.click();
		checkOutBtn.click();
		return driver.getCurrentUrl();
	}
	
	// Continue Shopping button Verification 
	public String verifycontinueShoppingBTN()
	{
		addTOCart.click(); // first cart button per click 
	continueShoppingBTN.click(); // fir shopping buttong per click
	return driver.getCurrentUrl();
	}
		


// if you want to Verify Label from next page then we have to use .click method first
// above codes are used for adding to card, and label Verification

// To REMOVE PRODUCTS 

	public String remove2Products() throws InterruptedException
	{
		add6Product();
		Thread.sleep(2000);
		removeBackPackProduct.click();
		removeBikeLightProduct.click();
		return cartCount.getText();
	}
	
	public void checkOutBtn()
	{
		checkOutBtn.click();
	}
}
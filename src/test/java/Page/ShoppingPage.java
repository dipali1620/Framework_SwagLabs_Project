package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
	
	WebDriver driver;
	
	public ShoppingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addtocart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartlink;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement checkoutfirstname;
	
	@FindBy(id="last-name")
	WebElement checkoutlastname;
	
	@FindBy(id="postal-code")
	WebElement zipcode;
	
	@FindBy(id="continue")
	WebElement continuetag;
	
	@FindBy(id="finish")
	WebElement completetrasction;
	
	@FindBy(id="back-to-products")
	WebElement backhomepage;
	
	@FindBy(className="app_logo")
	WebElement header;
	
	
	
	public void product()
	{
	
		addtocart.click();
	}
	
	public void cartlink()
	{
	
		cartlink.click();
	}
	
	
	public void cart()
	{
		checkout.click();
	}
	
	public void checkoutfirstname(String firstname)
	{
		checkoutfirstname.sendKeys(firstname);
	}
	
	public void checkoutlastname(String lastname)
	{
		checkoutlastname.sendKeys(lastname);
	}

	
	public void postalcode(String postalcode)
	{
		zipcode.sendKeys(postalcode);
	}
	
	public void continuetag()
	{
		continuetag.click();
	}

	public void finish()
	{
		completetrasction.click();
	}
	
	public void homepage()
	{
		backhomepage.click();
	}
	
	public boolean logo() {
		header.isDisplayed();
		return true;
	}
}

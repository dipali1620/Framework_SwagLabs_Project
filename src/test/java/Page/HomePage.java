package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
	public class HomePage {

		WebDriver driver;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@id='user-name']")
		WebElement txtEmailAddress;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@id='login-button']")
		WebElement btnLogin;
		
		@FindBy(xpath="//h3[@data-test='error']")
		WebElement requiredfieldError;	
		
		
	
		
		public void setEmail(String username)
		{
			txtEmailAddress.sendKeys(username);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}
		
		
		public String readErr() {
			String actual=requiredfieldError.getText();
			System.out.println(actual);
			return actual;
		}
		
		
	}
	
	

package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.HomePage;
import Page.ShoppingPage;
import TestBase.BaseClass;

public class TC_004_ChangeStatusCart extends BaseClass{
	
@Test
public void test_ChangeStatusOfItem()
{
		
	
	try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.setEmail(rb.getString("username"));
			hp.setPassword(rb.getString("password"));
			hp.clickLogin();
			
			ShoppingPage sp=new ShoppingPage(driver);
			sp.product();
			
			WebElement buttonText=driver.findElement(By.id("remove-sauce-labs-backpack"));
			if(buttonText.getText().equalsIgnoreCase("Remove"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
			
			
			
		
		}	
		catch(Exception e)
		{
			Assert.fail();
		}


	}
}

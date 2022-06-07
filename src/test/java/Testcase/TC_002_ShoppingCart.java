package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.HomePage;
import Page.ShoppingPage;
import TestBase.BaseClass;

public class TC_002_ShoppingCart extends BaseClass
{
	@Test
	public void test_AddItem()
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
			sp.cartlink();
			sp.cart();
			sp.checkoutfirstname(rb.getString("firstname"));
			sp.checkoutlastname(rb.getString("lastname"));
			sp.postalcode(rb.getString("postalcode"));
			sp.continuetag();
			Thread.sleep(3000);
			sp.finish();
			Thread.sleep(3000);
			sp.homepage();
			Thread.sleep(3000);
			

			boolean targetpage=sp.logo();
			System.out.println(targetpage);
			if(targetpage==true)
			{
				System.out.println("test pass-snap");
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("test failed-snap");
				Assert.assertTrue(false);
			}
		
		}	
		catch(Exception e)
		{
			Assert.fail();
		}

		
	}
	

}

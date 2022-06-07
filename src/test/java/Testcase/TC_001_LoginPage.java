package Testcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import Page.HomePage;
import TestBase.BaseClass;

public class TC_001_LoginPage extends BaseClass{
	
	@Test
	public void test_Login()
	{

		
		try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.setEmail(rb.getString("username"));
			hp.setPassword(rb.getString("password"));
			hp.clickLogin();
			
		
		}	
		catch(Exception e)
		{
			Assert.fail();
		}

		
	}
	@Test
	public void test_Login_Requirefield()
	{
		try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.setEmail("");
			hp.setPassword("");
			hp.clickLogin();
			Thread.sleep(2000);
			
			String expectedmsg= hp.readErr();
			if(expectedmsg.equals(rb.getString("actualfielderror"))){
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	@Test
	public void test_Login_Wrong_Input()
	{
		try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.setEmail(rb.getString("wrongusername"));
			hp.setPassword(rb.getString("wrongpassword"));
			hp.clickLogin();
			Thread.sleep(2000);
			String expectedmsg=hp.readErr();	
			if(expectedmsg.equals(rb.getString("actualwrongloginerror"))){
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	

}

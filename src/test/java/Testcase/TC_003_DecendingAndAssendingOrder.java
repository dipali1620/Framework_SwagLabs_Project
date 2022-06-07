package Testcase;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.HomePage;
import TestBase.BaseClass;

public class TC_003_DecendingAndAssendingOrder extends BaseClass{


	@Test
	public void test_Filter()
	{
		try
		{
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.setEmail(rb.getString("username"));
			hp.setPassword(rb.getString("password"));
			hp.clickLogin();
			Thread.sleep(3000);
			
			List<String> selectoptiontypes=new ArrayList<String>();
			selectoptiontypes.add("Price (low to high)");
			selectoptiontypes.add("Price (high to low)");
			selectoptiontypes.add("Name (Z to A)");
			selectoptiontypes.add("Name (A to Z)");
			
			
			for(int i=0;i<selectoptiontypes.size();i++)
			{
				System.out.println("i value="+i);
				
				filterOrderTest(selectoptiontypes.get(i));
				
			}
		
 
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}

		
	}
	public void filterOrderTest(String selectedOption) throws InterruptedException
	{
		
		
		
		WebElement dropdown =driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select s=new Select(dropdown);
	
		s.selectByVisibleText(selectedOption);
		Thread.sleep(3000);
		
		List<WebElement> all=driver.findElements(By.tagName("option"));
		boolean flag=false;
		for(WebElement a:all)
		{
			if(a.isSelected())
			  flag=true;
				
		}
		
		if(flag)
			Assert.assertTrue(true);
		else
			Assert.fail();
		

			
	}
		
}

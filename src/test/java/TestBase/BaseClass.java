package TestBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public ResourceBundle rb; //to read config.properties
	
	@BeforeClass() 
	@Parameters({"browser"})
	public void setup(String br)
	{
		
		System.out.println("browser: "+br);
		
		//Load config.properties
		rb= ResourceBundle.getBundle("config"); 

		
		//Drivers
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
		}
		
		else if(br.equals("firefox"))
		{	
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown()
	{
	driver.quit();
	}
	
	
	
	
	
}

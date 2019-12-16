package mytest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTestClass {
	
	WebDriver driver;
	
	
	@BeforeMethod
	 public void setUp() throws InterruptedException
	 {
		  System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		  
		  driver = new ChromeDriver();
		  
		   driver.manage().window().maximize();
		    Thread.sleep(3000);
		     
		    driver.manage().deleteAllCookies();
		     
		    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    
		    driver.get("https://www.spicejet.com/");
		     Thread.sleep(3000);
		 
	 }
	
	
	@Test(retryAnalyzer=analyzer.RetryAnalyzer.class)
	
	 public void getTitle()
	 {
		String title =  driver.getTitle();
		
		 Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air");
		
	 }
	
	@AfterMethod
	 public void tearDown()
	 {
		driver.close();
	 }

}

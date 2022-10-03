package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.search_filter;

public class Test_search_filter {
		String url = "https://www.jiomart.com/";
		WebDriver driver;
		search_filter s;
		
		@BeforeTest
		  public void beforeTest() {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			s=new search_filter(driver);
		  }
//		
//		@Test(priority=1)
//		  public void login() throws InterruptedException {
//			s.login();
//		}

	  @Test(priority=2)
	  public void popularity() throws InterruptedException {
		  s.popularity();
		  
	  }
	  
	  @Test(priority=3)
	  public void high_to_low() throws InterruptedException {
		  s.high_to_low();	  
	  }
	  @Test(priority=4)
	  public void low_to_high() throws InterruptedException
	  {
		  s.low_to_high();
	  }
	  @Test(priority=5)
	  public void discount() throws InterruptedException
	  {
		  s.discount();
			
	  }
	  
	  @Test(priority=6)
	  public void all_products() throws InterruptedException
	  {
		  s.all_products();
	  }
	  @Test(priority=7)
	  public void multiple_search_options() throws InterruptedException
	  {
		  
		  s.multiple_search_options();
	  }
	  
	  @Test(priority=8)
	  public void brands_multiple_checkbox() throws InterruptedException
	  {
		 
		  s.brands_multiple_checkbox();
	  }
	  
	  @Test(priority=9)
	  public void availablity() throws InterruptedException
	  {
		  
		 s.availablity();
		  
	  }
		
		@Test(priority=10)
	  public void category() throws InterruptedException
	  {
		  
		  s.category();
		  
	  }
		
		@Test(priority=11)
		  public void size() throws InterruptedException
		  {
			s.size();
		  }
//		@Test(priority=12)
//		  public void logout() throws InterruptedException
//		  {
//			s.logout();
//			}
	  
	
	@AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

	}
package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import pages.category;


public class Test_category {

	String url = "https://www.jiomart.com/all-category";
	WebDriver driver;
	
	category c;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		c=new category(driver);
	  }
	@Test(priority = 1)
	  public void launch() throws InterruptedException{
		c.launch();
	      }
	  @Test(priority = 2)
	  public void categories_check() throws InterruptedException{
		  c.categories_check();
	  }
	  @Test(priority = 3)
	  public void  subcategory() throws InterruptedException{
		  c.subcategory();
	  }
	 
	  @AfterTest
	  public void afterTest() {
	driver.quit();
	  }
}

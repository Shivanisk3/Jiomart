package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.wishlist;

public class Test_wishlist {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	wishlist w;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		w=new wishlist(driver);
	  }
	
	  @Test(priority = 1)
	  public void login() throws InterruptedException{
	  w.login();
	}
	  @Test(priority = 2)
	  public void Add_To_Wishlist() throws InterruptedException{
	  w.Add_To_Wishlist();
	 
	}
	  @Test(priority = 3)
	  public void Delete_From_Wishlist() throws InterruptedException{
	  w.Delete_From_Wishlist();
	  }
	  
	  @AfterTest
	  public void afterTest() {
	driver.quit();
	  }

}

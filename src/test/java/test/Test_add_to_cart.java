package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;


import pages.add_to_cart;


public class Test_add_to_cart {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	add_to_cart a;
	
	@BeforeTest
	  public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		a=new add_to_cart(driver);
	  }
	
	 
	  @Test(priority = 1)
	  public void AddCartClick() throws InterruptedException{
		  a.AddCartClick();
	  }
	  
	  @Test(priority = 2)
	  public void searchproduct() throws InterruptedException{
		  a.searchproduct();
	  }
	  
	  @Test(priority = 3)
	  public void visibleAddToCartProduct() throws InterruptedException{
		  a.visibleAddToCartProduct();
	  }
	  
	  public int count=1;
	  
	  @Test(priority = 4)
	  public void CountProduct() throws InterruptedException{
		  a.CountProduct();
	  }
	 
	  @Test(priority = 5)
	  public void deleteProduct() throws InterruptedException{
		  a.deleteProduct();
	  }
	  
	  @Test(priority = 6)
	  public void TotalProductINCart() throws InterruptedException{
		  a.TotalProductINCart();
	  }
	 
	  @Test(priority = 7)
	  public void TotalAmount() throws InterruptedException{
		  a.TotalAmount();
	  }
	  
	  @Test(priority = 8)
	  public void TotalSavingAmount() throws InterruptedException{
	  a.TotalSavingAmount();
	  }
	  
	  @AfterTest
	  public void afterTest() {
	 driver.close();
	  }

	}

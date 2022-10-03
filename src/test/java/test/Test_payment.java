package test;
/*
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.payment;


public class Test_payment {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	payment p;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		p=new payment(driver);
	  }
	
	 @Test(priority = 1)
	  public void signIn() throws InterruptedException{
		 p.signIn();
	  }
	  @Test(priority = 2)
	  public void AddCartClick() throws InterruptedException{
	     p.AddCartClick();
	  }
	  @Test(priority = 3)
	  public void ProductAddToCart() throws InterruptedException{
		  p.ProductAddToCart();
	  }
	  @Test(priority = 4)
	  public void visibleAddToCartProduct() throws InterruptedException{
		  p.visibleAddToCartProduct();
	  }
	 
	  @Test(priority = 5)
	  public void TotalAmount() throws InterruptedException{
		  p.TotalAmount();
	  }
	  @Test(priority = 6)
	  public void placeorderclick() throws InterruptedException{
		  p.placeorderclick();
	  }
	  @Test(priority=7)
	  public void paymentMode() {
		  p.paymentMode();
	  }
	 
	  @AfterTest
	  public void afterTest() {
	driver.quit();
	  }
}
*/


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_payment {
public String baseUrl = "https://www.jiomart.com/";
    String driverPath = "D:\\D downloads\\chromedriver_win321\\chromedriver.exe";
    public WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
      //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test(priority = 1)
  public void launch() throws InterruptedException{

driver.get(baseUrl);
driver.manage().window().maximize();
Thread.sleep(2000);
 System.out.println("Test case 1:Browser open Successfully");
     
  }
 
  @Test(priority = 2)
  public void signIn() throws InterruptedException{
 driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[5]/div/a[1]")).click();
 Thread.sleep(2000);
  driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8975670419");
  driver.findElement(By.cssSelector("button.btn-signpass.arrowbtn")).click();
  Thread.sleep(25000);
  driver.findElement(By.className("btn-login")).click();
 Thread.sleep(2000);
  System.out.println("Login Sucessfully");
 
  }
  @Test(priority = 3)
  public void AddCartClick() throws InterruptedException{

 driver.findElement(By.id("minicart_btn")).click();
 Thread.sleep(2000);
      System.out.println("Test Case 2:Add To Cart Button Clickable Successfully");
     
  }
  @Test(priority = 4)
  public void ProductAddToCart() throws InterruptedException{
/*
 WebElement mainMenu = driver.findElement( By.id("nav_cat_1687") );
 Actions actions = new Actions(driver);
 actions.moveToElement(mainMenu);
 Thread.sleep(2000);
 WebElement subMenu = driver.findElement(By.id("nav_link_1696"));
 actions.moveToElement(subMenu);
 actions.click().build().perform();
 Thread.sleep(2000);
 JavascriptExecutor s=(JavascriptExecutor)driver;//casting
 s.executeScript("window.scrollBy(0,150)");
// Thread.sleep(2000);
 driver.findElement(By.className("add_plus")).click();
 Thread.sleep(2000);
 driver.findElement(By.className("add_plus")).click();
      System.out.println("Test Case 3:Product added to the cart ");
     */
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 WebElement r =  driver.findElement(By.id("mat-input-0"));
      r.click();
      Thread.sleep(2000);
      r.sendKeys("Handwash");
     Thread.sleep(3000);
      r.sendKeys(Keys.RETURN);
    JavascriptExecutor js=(JavascriptExecutor)driver;//casting
      js.executeScript("window.scrollBy(0,100)");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/div[1]/button")).click();
  }
  @Test(priority = 5)
  public void visibleAddToCartProduct() throws InterruptedException{

	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.findElement(By.id("minicart_btn")).click();
    Thread.sleep(4000);
    System.out.println("Test Case 4:Product is visible in Cart ");
     
  }
 
  @Test(priority = 6)
  public void TotalAmount() throws InterruptedException{
 JavascriptExecutor s=(JavascriptExecutor)driver;//casting
 s.executeScript("window.scrollBy(0,150)");
 System.out.println("Test case 5 :Total amount to Pay:"+driver.findElement(By.id("cart_netpay_amt1")).getText());
 
  }
  @Test(priority = 7)
  public void placeorderclick() throws InterruptedException{
 //driver.findElement(By.id("minicart_btn")).click();
      //JavascriptExecutor s2=(JavascriptExecutor)driver;//casting
 //s2.executeScript("window.scrollBy(0,150)");
 //place order
 driver.findElement(By.className("process-checkout")).click();
 Thread.sleep(2000);
 System.out.println("PlaceOrder button clicked successfully");
 //delivery
 driver.findElement(By.xpath("//*[@id=\"addressmodal\"]/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/button")).click();
 System.out.println("Deliver here button clicked successfully");
  }
  @Test(priority=8)
  public void paymentMode() {
 driver.findElement(By.cssSelector("button.btn-checkout.btn.btn_to_checkout.m-0")).click();
 JavascriptExecutor s1=(JavascriptExecutor)driver;//casting
 s1.executeScript("window.scrollBy(0,700)");
 driver.findElement(By.id("9")).click();
 driver.findElement(By.className("css-128hug4")).click();
 driver.findElement(By.className("css-100scwx")).click();
 //driver.findElement(By.cssSelector("button.btn-track.btn.m-0")).click();
 //driver.findElement(By.cssSelector("button.primary-btn")).click();
 //driver.findElement(By.cssSelector("button.btn.btn-help.ng-star-inserted")).click();
 //driver.findElement(By.xpath("//*[@id=\"frameModalBottom\"]/div/div/div[2]/div[1]/div[1]/div[2]/label")).click();
 //driver.
 //driver.navigate().back();
 
 

  }
 
   
}

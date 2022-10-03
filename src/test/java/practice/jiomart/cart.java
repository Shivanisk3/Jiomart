package practice.jiomart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class cart {
public String baseUrl = "https://www.jiomart.com/";
    String driverPath = "D:\\D downloads\\chromedriver_win321\\chromedriver.exe";
    public WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {

 //System.setProperty("webdriver.chrome.driver", driverPath);
      //driver= new ChromeDriver();
	  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
  }
  @Test(priority = 1)
  public void launch() throws InterruptedException{

driver.get(baseUrl);
driver.manage().window().maximize();
Thread.sleep(2000);
 System.out.println("Test case 1:Browser open Successfully");
     
  }
 
  @Test(priority = 2)
  public void AddCartClick() throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.findElement(By.id("minicart_btn")).click();
 Thread.sleep(2000);
      System.out.println("Test Case 2:Add To Cart Button Clickable Successfully");
     
  }
  @Test(priority = 3)
  public void searchproduct() throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement r =  driver.findElement(By.id("mat-input-0"));
      r.click();
      Thread.sleep(2000);
      r.sendKeys("banana");
     Thread.sleep(2000);
      r.sendKeys(Keys.RETURN);
    JavascriptExecutor js=(JavascriptExecutor)driver;//casting
      js.executeScript("window.scrollBy(0,100)");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/div[1]/button")).click();
     
    //  Thread.sleep(1000);
      //Thread.sleep(2000);
      System.out.println("Test Case 3: Searching done ");
  }
  @Test(priority = 4)
  public void ProductAddToCart() throws InterruptedException{


     //Thread.sleep(1000);
      System.out.println("Test Case 4:Product added to the cart ");
     
  }
  @Test(priority = 5)
  public void visibleAddToCartProduct() throws InterruptedException{


 driver.findElement(By.id("minicart_btn")).click();
    Thread.sleep(4000);
    System.out.println("Test Case 5:Product is visible in Cart ");
     
  }
  public int count=1;
 // public int count=Integer.parseInt(driver.findElement(By.className("current-qty")).getText());
  @Test(priority = 6)
  public void CountProduct() throws InterruptedException{

	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  String Price=driver.findElement(By.className("special-price")).getText();
  System.out.println("Test case 6: Count of Product Added to cart "+ count +"Price of Product"+ Price );
  driver.findElement(By.className("plus")).click();
  Thread.sleep(2000);
  count=count+1;
  if(count== Integer.parseInt(driver.findElement(By.className("current-qty")).getText())) {
  System.out.println("Count of sub product Product Added to cart: "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
 
  }

 count=count+1;
  driver.findElement(By.className("plus")).click();
  Thread.sleep(2000);
  if(count== Integer.parseInt(driver.findElement(By.className("current-qty")).getText())) {
  System.out.println("Count of sub product Product Added to cart: "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
 
  }
  }
 
  @Test(priority = 7)
  public void deleteProduct() throws InterruptedException{

 count=count-1;
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.className("minus")).click();
 
   //System.out.println("After delete one sub product : "+ count +" Price of Product: "+ driver.findElement(By.className("available-amt")).getText()+""+driver.findElement(By.xpath("//*[@id=\"itemid-590001285\"]/div[2]/div[3]/div[3]/div/span[2]")).getText() );
    if(count== Integer.parseInt(driver.findElement(By.className("current-qty")).getText())) {
    System.out.println("Test case 7: After delete one sub product : "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
   
    }
 
  }
  @Test(priority = 8)
  public void TotalProductINCart() throws InterruptedException{
 
  WebElement mainMenu = driver.findElement(By.id("nav_cat_1687"));

  //Instantiating Actions class
  Actions actions = new Actions(driver);

  //Hovering on main menu
  actions.moveToElement(mainMenu);

  // Locating the element from Sub Menu
  WebElement subMenu = driver.findElement(By.id("nav_link_1712"));

  //To mouseover on sub menu
  actions.moveToElement(subMenu);

  //build()- used to compile all the actions into a single step
  actions.click().build().perform();
  Thread.sleep(2000);
  JavascriptExecutor s=(JavascriptExecutor)driver;//casting
  s.executeScript("window.scrollBy(0,150)");
  Thread.sleep(2000);
  driver.findElement(By.className("add_plus")).click();
  Thread.sleep(2000);
  driver.findElement(By.className("add_plus")).click();
  //System.out.println(driver.findElement(By.xpath("//*[@id=\"itemid-590826416\"]/div[2]/div[1]/a")).getText());
  Thread.sleep(2000);
 
  driver.navigate().back();
 
  System.out.println("Test case 8:Total number of Product added to Cart"+ driver.findElement(By.className("available-count")).getText());
 
  }
 
  @Test(priority = 9)
  public void TotalAmount() throws InterruptedException{
 JavascriptExecutor s=(JavascriptExecutor)driver;//casting
 System.out.println("Test case 9 :Total amount to Pay:"+driver.findElement(By.id("cart_netpay_amt1")).getText());
 s.executeScript("window.scrollBy(0,150)");
  }
  @Test(priority = 10)
  public void TotalSavingAmount() throws InterruptedException{
  System.out.println("Test case 10:Saving Amount "+driver.findElement(By.cssSelector("div.save-amount.cart-savings.ng-star-inserted")).getText());
  Thread.sleep(3000);
  }
  @AfterTest
  public void afterTest() {
 driver.quit();
  }

}
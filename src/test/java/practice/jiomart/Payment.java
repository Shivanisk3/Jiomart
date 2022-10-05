//package Sample.Sample_Practice;
package practice.jiomart;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Payment {
public String baseUrl = "https://www.jiomart.com/";
    String driverPath = "D:\\D downloads\\chromedriver_win321\\chromedriver.exe";
    public WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
 System.setProperty("webdriver.chrome.driver", driverPath);
      driver= new ChromeDriver();
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
  public void signIn() throws InterruptedException{
 driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[5]/div/a[1]")).click();
 Thread.sleep(2000);
 // driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668335762");
 driver.findElement(By.id("loginfirst_mobileno")).sendKeys("9359746720");
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

 WebElement r =  driver.findElement(By.id("mat-input-0"));
      r.click();
      Thread.sleep(2000);
      r.sendKeys("Surfexel");
     Thread.sleep(3000);
      r.sendKeys(Keys.RETURN);
    JavascriptExecutor js=(JavascriptExecutor)driver;//casting
      js.executeScript("window.scrollBy(0,100)");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/div[1]/button")).click();
  }
  @Test(priority = 5)
  public void visibleAddToCartProduct() throws InterruptedException{


 driver.findElement(By.id("minicart_btn")).click();
 //driver.findElement(By.className("logo")).click();
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
 driver.findElement(By.className("deliver")).click();
 System.out.println("Deliver here button clicked successfully");
  }
  @Test(priority=8)
  public void paymentMode() throws InterruptedException, IOException {
 driver.findElement(By.cssSelector("button.btn-checkout.btn.btn_to_checkout.m-0")).click();
 Thread.sleep(2000);
 JavascriptExecutor s1=(JavascriptExecutor)driver;//casting
 s1.executeScript("window.scrollBy(0,400)");
 driver.findElement(By.id("9")).click();
 //s1.executeScript("window.scrollBy(0,-300)");
 Thread.sleep(2000);
 WebElement radio1=driver.findElement(By.xpath("//*[@id=\"vertical-tabpanel-9\"]/div/div/div[2]"));
 radio1.click();
Thread.sleep(2000);
 
 driver.findElement(By.className("css-100scwx")).click();
 //view and manage
 //driver.findElement(By.cssSelector("button.btn-track.btn.m-0")).click();
 Thread.sleep(3000);
 //cancel order
 //view details
 //driver.findElement(By.className("primary-btn")).click();
 //cancel
 //driver.findElement(By.cssSelector("button.btn.btn-help.ng-star-inserted")).click();
 //select radio button
 //driver.findElement(By.cssSelector("input.ng-pristine.ng-valid.ng-touched")).click();
 //submit cancel
 //driver.findElement(By.className("primary")).click();
 //logo to go homepage
driver.findElement(By.cssSelector("a.logo.ng-star-inserted")).click();
//menu
driver.findElement(By.className("menu_section")).click();
//orders
driver.findElement(By.linkText("Orders")).click();
Thread.sleep(5000);
//view detail
driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-orderhistory/div[1]/div/div[2]/div[2]/div/app-order-list/div/section/app-order-card[1]/div[1]/div[3]/div[2]/div/div[1]/button")).click();

Thread.sleep(3000);
TakesScreenshot scrShot=((TakesScreenshot)driver);

//Call getScreenShotAs method to create image file
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

//Copy file to Desired Location
FileUtils.copyFile(SrcFile,new File("C:/Users/divya_shinde/eclipse-workspace/Selenium/Screenshots/Screenshot2.png"));

//cancel order
driver.findElement(By.xpath("//*[@id='app']/main/div/app-order-detail/div[1]/div[2]/div[1]/div[1]/div[2]/div/div[1]/button")).click();



//no longer
WebElement radio2 =driver.findElement(By.name("reasonselect"));
radio2.click();
//submit cancel
driver.findElement(By.className("primary")).click();

  }
   
}

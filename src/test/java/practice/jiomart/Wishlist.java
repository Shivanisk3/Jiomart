package Sample.Sample_Practice;

import java.io.File;
import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;



public class Wishlist1 {
	//private static final String FileUtils = null;
	public String baseUrl = "https://www.jiomart.com/customer/account/login";
    String driverPath="D:\\geckodriver-v0.31.0-win64\\geckodriver.exe";
    public WebDriver driver; 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", driverPath);
     driver=new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
  }
  @Test(priority = 1)
  public void launch() throws InterruptedException{
	driver.get(baseUrl);
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
	  System.out.println("Test case 1:Browser open Successfully");
	 }
  @Test(priority = 2)
  public void login() throws InterruptedException{
  driver.findElement(By.xpath("//*[@id=\"loginfirst_mobileno\"]")).sendKeys("9359746720");
  driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]")).click();
  Thread.sleep(35000);
  driver.findElement(By.className("btn-login")).click();
  System.out.println("login Successfully");
}
  @Test(priority = 3)
  public void Add_To_Wishlist() throws InterruptedException, IOException{
  Thread.sleep(10000);
  driver.findElement(By.xpath("//*[@id=\"autocomplete-0-input\"]")).click();
  WebElement r = driver.findElement(By.xpath("//*[@id=\"autocomplete-0-input\"]"));
  r.sendKeys("kurti");
  Thread.sleep(2000);
  r.sendKeys(Keys.RETURN);
  Thread.sleep(5000);
  driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/a/span[4]")).click();
  Thread.sleep(3000);
  driver.findElement(By.id("wishlist_btn")).click();
  Thread.sleep(10000);
  driver.findElement(By.id("logged_user")).click();
  Thread.sleep(4000);
  driver.findElement(By.xpath("//*[@id=\"js-leftblk-cmsblk\"]/div/a[2]")).click();
  Thread.sleep(4000);
  
  JavascriptExecutor js=(JavascriptExecutor)driver;//casting
	//js.executeScript("window.scrollBy(0,500)");
	
  String s1= driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/h1")).getText();
  System.out.println("Wishlist item count after adding : "+s1.charAt(10));
  Thread.sleep(4000);
}
  @Test(priority = 4)
  public void Delete_From_Wishlist() throws InterruptedException{
  driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/div/div/div[1]/div/div/div[2]/div[4]/div[1]/button")).click();    
  //Thread.sleep(3000);
  String s2=driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/h1")).getText();
 System.out.println("Wishlist item count after deleting : "+s2.charAt(10));
  System.out.println("Item removed from wishlist successfully");
  //Thread.sleep(10000);
  }
  @AfterTest
  public void afterTest() {
	driver.quit();
  }

}

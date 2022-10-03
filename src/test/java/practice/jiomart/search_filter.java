package practice.jiomart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class search_filter {
String url = "https://www.jiomart.com/";
WebDriver driver;
public void connect(WebDriver driver)
{
this.driver=driver;
}
@BeforeTest
 public void beforeTest() {
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
driver.manage().window().maximize();
 }

@Test(priority=1)
 public void login() throws InterruptedException {
driver.get(url);
/*driver.findElement(By.className("logged")).click();
System.out.println("done....");
driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668335762");
driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]")).click();
Thread.sleep(35000);
driver.findElement(By.className("btn-login")).click();*/

}

  @Test(priority=2)
  public void f() throws InterruptedException {
 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 Thread.sleep(1000);
 WebElement p=driver.findElement(By.id("autocomplete-0-input"));
p.sendKeys("home");
Thread.sleep(2000);
p.sendKeys(Keys.ENTER);
Thread.sleep(1000);
   
//popularity
driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[1]")).click();
System.out.println("Popularity option done");
Thread.sleep(1500);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
   int j = 0;
   for(int i=0;i<=300;i+=50) {
    js2.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
 
  }
 
  @Test(priority=3)
  public void f2() throws InterruptedException {
 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 Thread.sleep(10000);
//High to Low
driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[2]")).click();
System.out.println("High to Low option done");
Thread.sleep(1500);
JavascriptExecutor js2 = (JavascriptExecutor) driver;
   int j = 0;
   for(int i=0;i<=300;i+=50) {
    js2.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
   
   List<WebElement> high1 = driver.findElements(By.id("final_price"));

        System.out.println(high1.size());

        for (WebElement webElement : high1) {
            String name = webElement.getText();
            System.out.println(name);
        }
   js2.executeScript("window.scrollBy(0,-300)");
 
  }
  @Test(priority=4)
  public void f3() throws InterruptedException
  {
 //driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   Thread.sleep(1000);
//Low to High
driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[3]")).click();
System.out.println("Low to High option done");
Thread.sleep(1500);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
   int j = 0;
   for(int i=0;i<=300;i+=50) {
    js3.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
   List<WebElement> low = driver.findElements(By.id("final_price"));

      System.out.println(low.size());

      for (WebElement webElement : low) {
          String name = webElement.getText();
          System.out.println(name);
      }
   js3.executeScript("window.scrollBy(0,-300)");
  }
  @Test(priority=5)
  public void f4() throws InterruptedException
  {
 //driver.manage().timeouts().implicitlyWait(13000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Discount
 Thread.sleep(10000);
driver.findElement(By.xpath("//*[@id=\"sort_container\"]/button[4]")).click();
System.out.println("Discount option done");
Thread.sleep(1000);
JavascriptExecutor js4 = (JavascriptExecutor) driver;
   int j = 0;
   for(int i=0;i<=300;i+=50) {
    js4.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
   List<WebElement> discounts = driver.findElements(By.className("dis_section"));

      System.out.println(discounts.size());

      for (WebElement webElement : discounts) {
          String name = webElement.getText();
          System.out.println(name);
      }
   js4.executeScript("window.scrollBy(0,-300)");

  }
 
  @Test(priority=6)
  public void f5() throws InterruptedException
  {
 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//All products
driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[7]/div/div/button[5]")).click();
System.out.println("All products option done");
Thread.sleep(1500);
JavascriptExecutor js5 = (JavascriptExecutor)driver;
   int j = 0;
   for(int i=0;i<=300;i+=100) {
    js5.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
   js5.executeScript("window.scrollBy(0,-300)");
  }
  @Test(priority=7)
  public void multiple_search_options() throws InterruptedException
  {
 
 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//searching multiple products
 driver.findElement(By.className("search_list")).click();
 driver.findElement(By.id("rel_search_val")).sendKeys("milk,bread");
 Thread.sleep(3000);
 driver.findElement(By.xpath("//*[@id=\"rel_search_form\"]/button[2]")).click();
 Thread.sleep(8000);
 System.out.println("Multiple search option is available");  
 Thread.sleep(1500);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
   int j = 0;
   for(int i=0;i<=300;i+=50) {
    js3.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
  }
 
  @Test(priority=8)
  public void brands_multiple_checkbox() throws InterruptedException
  {

 WebElement p=driver.findElement(By.id("autocomplete-0-input"));
p.sendKeys("tv");
Thread.sleep(2000);
p.sendKeys(Keys.ENTER);
Thread.sleep(5000);
WebElement check1 = driver.findElement(By.xpath("//*[@id=\"brand_filter\"]/div/ul/li[1]/div/div/label/input"));
   check1.click();
WebElement check2 = driver.findElement(By.xpath("//*[@id=\"brand_filter\"]/div/ul/li[2]/div/div/label/input"));
   check2.click();
System.out.println("Clicked multiple Check Boxes..");
Thread.sleep(1000);
  }
 
  @Test(priority=9)
  public void availablity() throws InterruptedException
  {
 
 WebElement p=driver.findElement(By.id("autocomplete-0-input"));
 p.sendKeys("headphones");
Thread.sleep(1000);
p.sendKeys(Keys.ENTER);
Thread.sleep(5000);
WebElement check1 = driver.findElement(By.xpath("//*[@id=\"in_stock_filter\"]/div/ul/li/div/div/div/label/input"));
   check1.click();

System.out.println("Clicked availability option..");
Thread.sleep(3000);
 
  }

@Test(priority=10)
  public void category() throws InterruptedException
  {
 
 WebElement p=driver.findElement(By.id("autocomplete-0-input"));
 p.sendKeys("slippers");
Thread.sleep(1000);
p.sendKeys(Keys.ENTER);
Thread.sleep(5000);
WebElement check1 = driver.findElement(By.xpath("//*[@id=\"category_filter\"]/div/ul/li[1]/div/div/label/input"));
   check1.click();
WebElement check2 = driver.findElement(By.xpath("//*[@id=\"category_filter\"]/div/ul/li[2]/div/div/label/input"));
check2.click();

System.out.println("Clicked women & fashion option from category..");
Thread.sleep(3000);
 
  }

@Test(priority=11)
 public void shoes_size() throws InterruptedException
 {

 //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 WebElement p=driver.findElement(By.id("autocomplete-0-input"));
 p.sendKeys("kurti");
Thread.sleep(1000);
p.sendKeys(Keys.ENTER);
Thread.sleep(5000);
WebElement check1 = driver.findElement(By.xpath("//*[@id=\"size_filter\"]/div/ul/li[2]/div/div/label/input"));
   check1.click();

System.out.println("Clicked 'M' option from size..");
Thread.sleep(3000);
 
 }
@Test(priority=12)
 public void logout() throws InterruptedException
 {
/*driver.findElement(By.id("logged_user")).click();
Thread.sleep(1000);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
int j=0;
for(int i=0;i<=300;i+=50) {
   
js3.executeScript("window.scrollBy("+j+","+i+")", "");
    j=i;
   Thread.sleep(1500);
   }
driver.findElement(By.xpath("//*[@id=\"js-leftblk-cmsblk\"]/a")).click();

//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
System.out.println("Logged Out");
// driver.get(url);*/
}
 




@AfterTest
  public void afterTest() {
 driver.quit();
  }

}
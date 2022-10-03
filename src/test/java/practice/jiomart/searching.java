/*package practice.jiomart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searching {
      String url = "https://www.jiomart.com/";
      public static WebDriver driver;
      
      
      @BeforeTest
        public void beforeTest() {
//          System.setProperty("webdriver.gecko.driver", "D:\\Firefoxdriver\\geckodriver.exe");
//          driver = new FirefoxDriver();
            
            //System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
            //driver = new ChromeDriver();
	
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
        }
  @Test(priority=1)
  public void f() {
        driver.get(url);
        WebElement p=driver.findElement(By.id("autocomplete-0-input"));
            p.sendKeys("home");
            
            p.sendKeys(Keys.ENTER);

          driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            //popularity
            driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[7]/div/div/button[1]")).click();
            
            
            System.out.println("Popularity option done");
            
        
  }
 
  @Test(priority=2)
  public void f2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
          
            //High to Low
            driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[7]/div/div/button[2]")).click();
            System.out.println("High to Low option done");
            Thread.sleep(1500);
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
  @Test(priority=3)
  public void f3() throws InterruptedException
  {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
          
            //Low to High
            driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[7]/div/div/button[3]")).click();
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
  @Test(priority=4)
  public void f4() throws InterruptedException
  {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            //Discount
            driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[7]/div/div/button[4]")).click();
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
 
  @Test(priority=5)
  public void f5() throws InterruptedException
  {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
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
 
  @AfterTest
  public void afterTest() {
        driver.quit();
  }

}
*/
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
import org.testng.annotations.AfterTest;

public class category {
public String baseUrl = "https://www.jiomart.com/all-category";
    //String driverPath = "D:\\D downloads\\chromedriver_win321\\chromedriver.exe";
    public WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
      //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test(priority = 1)
  public void launch() throws InterruptedException{

driver.get(baseUrl);
driver.manage().window().maximize();
Thread.sleep(3000);
 System.out.println("Test case 1:Browser open Successfully");
 System.out.println(driver.findElement(By.xpath("//*[@id=\'accordion\']/div[1]/div[1]/div[2]/span[1]")).getText());
 
      }
  @Test(priority = 2)
  public void categories_check() throws InterruptedException{
 System.out.println("......... Available Categories ...........\n");
 for(int i=1;i<=7;i++) {
 //System.out.println(i);
 String m=String.valueOf(i);
 Thread.sleep(2000);
 String xpath="//*[@id=\'accordion\']/div["+m+"]/div[1]/div[2]/span[1]";
 //System.out.println(driver.findElement(By.xpath(xpath)).getText());
 //String category="//*[@id=\\\"accordion\\\"]/div["+i+"]/div[1]/div[2]/span[1]";
//*[@id="accordion"]/div[1]/div[1]/div[2]/span[1]
 
 boolean t=driver.findElement(By.xpath(xpath)).isDisplayed();
 if (t) {
 String s=driver.findElement(By.xpath(xpath)).getText();
 System.out.println(s);
 
 }
 }
  }
  @Test(priority = 3)
  public void  subcategory() throws InterruptedException{
 System.out.println("--------------------------------");

//--------------------Sub categories check----------------------------
String[][] id={{"219","61","13","10","33","91","36","2551","3346"},
{"7470","7473","7479","7483","7489"},
{"1710","1712","1696","2335","1706"},
{"496","493","499","563","550"},
{"757","746","724","719","736"},
{"3102","3154","3158","3175","3186"},
{"1531","5308"}};
for(int j=1;j<=7;j++) {
String c1="//*[@id=\"accordion\"]/div["+j+"]/div[1]/div[2]/span[1]";
driver.findElement(By.xpath(c1)).click();
boolean t1=driver.findElement(By.xpath(c1)).isDisplayed();
if(t1) {
System.out.println("\n"+driver.findElement(By.xpath(c1)).getText()+" is clicked..........");
System.out.println("......... Sub Categories ..........");
for(String i: id[j-1]) {
String sub ="//*[@id=\"child_accordion_"+i+"\"]/div/div/div[2]/a/span";
boolean t=driver.findElement(By.xpath(sub)).isDisplayed();
if (t) {
String s=driver.findElement(By.xpath(sub)).getText();
System.out.println(s);
}
}
}
  }
  }
 
 
  }

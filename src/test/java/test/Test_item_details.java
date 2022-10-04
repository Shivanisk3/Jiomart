package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.item_details;

/*class TestFailedException  extends Exception  
{  
    public TestFailedException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  */
public class Test_item_details {
	String url = "https://www.jiomart.com/";
	WebDriver driver=null;
	
	item_details i;
	
	@BeforeClass
	  public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		i=new item_details(driver);
	  }
	/*@Test(priority = 1)
	public void getURL() throws InterruptedException
	{
		driver.get("https://www.jiomart.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}*/
	
	@Test(priority = 2)
	public void getTitle() throws InterruptedException
	{
		i.getTitle();
	}
	@Test(priority = 3)
	public void search() throws InterruptedException
	{
		i.search();
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void getItem()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		i.getItem();
	}
	
	@Test(priority = 5)
	public void slideShow() throws InterruptedException
	{
		i.slideShow();

	}
	@Test(priority =6)
	public void zoomImage() throws InterruptedException
	{
		i.zoomImage();

	}
	
	@Test(priority = 7)
	public void discount() throws TestFailedException
	{
		i.discount();
		
		
	}
	
	@Test(priority = 8)
	public void addToCart() throws TestFailedException, InterruptedException
	{
		i.addToCart();
	}
	
	/*@Test(priority = 9)
	public void addToCartMultiple()
	{
		//gotocart
	}*/
	
	@Test(priority = 10)
	public void pincode() throws InterruptedException
	{
		i.pincode();
	}
	
	@Test(priority= 11)
	public void offers() throws InterruptedException
	{
		i.offers();
	}
	
	@Test(priority= 12)
	public void compare() throws InterruptedException
	{
		i.compare();

	}
	@Test(priority= 13)
	public void dress() throws InterruptedException
	{
		i.dress();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Test successfully passes");
	}

}

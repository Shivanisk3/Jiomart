package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homepage;


public class Test_homepage {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	homepage h;
	
	@BeforeTest
	  public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		h=new homepage(driver);
	  }
	
	@Test(priority=1)
	public void getTitle() throws InterruptedException
	{
	String title = driver.getTitle();
	System.out.println(title);
	driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
	Thread.sleep(1000);

	}
	//1
	@Test(priority=2)
	public void working() throws InterruptedException
	{
	Actions actions =new Actions(driver);

	List<WebElement> cursor;
	List<WebElement> items;

	cursor=driver.findElements(By.className("o-menu"));
	int count=cursor.size();
	System.out.println(count);

	int count1=cursor.size();
	System.out.println(count1);
	//WebElement temp;
	for(int i=0;i<count1;i++)
	{
	
	actions.moveToElement(cursor.get(i));
	actions.build().perform();
	Thread.sleep(1000);
	items=driver.findElements(By.xpath("//*[@id=\"nav_link_219\"]"));
	int count2=items.size();
	System.out.println(count2);

	}

	WebElement var=driver.findElement(By.id("nav_link_2"));
	actions.moveToElement(var);
	actions.build().perform();


	JavascriptExecutor js1=(JavascriptExecutor) driver;//casting
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	
	driver.findElement(By.className("menu_section")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/div/a[1]")).click();
	Thread.sleep(2000);
	}
	 @AfterTest
	  public void afterTest() {
	driver.quit();
	  }
}

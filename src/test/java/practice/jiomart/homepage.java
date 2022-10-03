package practice.jiomart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class homepage {
	
	WebDriver driver=null;
	
	@Test(priority=1)
	public void driverSetup()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	@Test(priority=2)
	public void getURL() throws InterruptedException
	{
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//opening url
		driver.get("https://www.jiomart.com/");
	}
	
	@Test(priority=3)
	public void getTitle() throws InterruptedException
	{
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
		Thread.sleep(1000);

	}
	@Test(priority=4)
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
		//System.out.println(cursor.get(i));
		//temp = cursor.get(i).getAttribute("id");
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
		//Reverse Scrolling
		/*JavascriptExecutor js2=(JavascriptExecutor) driver;

		js2.executeScript("window.scrollBy(500,0)");
		Thread.sleep(1000);
		js2.executeScript("window.scrollBy(500,0)");
		Thread.sleep(1000);
		js2.executeScript("window.scrollBy(500,0)");
		Thread.sleep(1000);*/



		driver.findElement(By.className("menu_section")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/div/a[1]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=5)
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Test successfully passes");
	}

}

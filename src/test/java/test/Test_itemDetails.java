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
import org.testng.annotations.Test;

class TestFailedException  extends Exception  
{  
    public TestFailedException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  
public class Test_itemDetails {
WebDriver driver=null;
	
	@BeforeClass
	public void driverSetup()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani_kulkarni2\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver=new ChromeDriver();
		
		//System.setProperty("webdriver.edge.driver", "D:\\selenium\\msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void getURL() throws InterruptedException
	{
		driver.get("https://www.jiomart.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 2)
	public void getTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority = 3)
	public void search() throws InterruptedException
	{
		WebElement item = driver.findElement(By.id("autocomplete-0-input"));
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"tv").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void getItem()
	{
		//driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[9]/div/div/ol/li[1]/div/a/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[2]/div/a/span[4]")).click();
	}
	
	@Test(priority = 5)
	public void slideShow() throws InterruptedException
	{
		List <WebElement> slides;
		
		//driver.findElement(By.className("largeimage.lazyautosizes.lazyloaded")).click();
		slides = driver.findElements(By.className("swiper-wrapper"));
		int count=slides.size();
		System.out.println("slides"+count);
		for(int i=1;i<count-1;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"left_col\"]/div[2]/div/div/div["+i+"]/img")).click();
			Thread.sleep(2000);
		}
		for(int j=count-1;j<2;j--)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"left_col\"]/div[2]/div/div/div["+j+"]/img")).click();
			Thread.sleep(2000);
		}

	}
	@Test(priority =6)
	public void zoomImage() throws InterruptedException
	{
		List <WebElement> slides;
		driver.findElement(By.xpath("//*[@id=\"left_col\"]/div[1]/div[1]/div[3]")).click();
		slides = driver.findElements(By.className("swiper-wrapper"));
		int count=slides.size();
		System.out.println("slides"+count);
		for(int i=1;i<count;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/button[2]")).click();
			Thread.sleep(2000);
		}
		for(int i=1;i<count;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/button[1]")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.className("pswp__zoom-wrap")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("pswp__zoom-wrap")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/div[1]/button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/div[1]/button[3]")).click();
		Thread.sleep(3000);

		Actions a = new Actions(driver);		
		Action Aseries = a.keyDown(Keys.ESCAPE).build();
		Aseries.perform();
		Thread.sleep(4000);

	}
	
	@Test(priority = 7)
	public void discount() throws TestFailedException
	{
		//price of item
		System.out.println(driver.findElement(By.xpath("//*[@id=\"alg_price\"]/span[1]/span")).getAttribute("innerHTML"));
		String[] p = driver.findElement(By.xpath("//*[@id=\"alg_price\"]/span[1]/span")).getAttribute("innerHTML").split(" ");
		double price = Double.parseDouble(p[p.length-1]);
		System.out.println(price);
		
		
		//actual price and discount if present
		Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"alg_price\"]/span[2]/strike")).size() > 0;
		if(isPresent)
		{
			String[] a = driver.findElement(By.xpath("//*[@id=\"alg_price\"]/span[2]/strike")).getAttribute("innerHTML").split(" ");
			double actualPrice = Double.parseDouble(a[a.length-1]);
			System.out.println(actualPrice);
			
			String[] w = driver.findElement(By.xpath("//*[@id=\"alg_price\"]/span[3]/span")).getAttribute("innerHTML").split(" ");
			double discountWeb = Double.parseDouble(w[w.length-1]);
			
			//calculate discount
			double discount = actualPrice - price;
			System.out.println("Discount is : "+ discount);
			
			//check if both same
			if(discount!=discountWeb)
			{
				throw new TestFailedException("Discount is not correct");    
			}
		}
		
		
	}
	
	@Test(priority = 8)
	public void addToCart() throws TestFailedException, InterruptedException
	{
		String cartItems, beforeCount;
		beforeCount = driver.findElement(By.className("counter-number")).getAttribute("innerHTML");
		driver.findElement(By.className("txt_btn")).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cartItems = driver.findElement(By.className("counter-number")).getAttribute("innerHTML");
		int before = Integer.parseInt(beforeCount);
		int added = Integer.parseInt(cartItems);
		System.out.println(cartItems);
		if(added!=before+1)
		{
			throw new TestFailedException("Item cannot be added in cart");    
		}
	}
	
	@Test(priority = 9)
	public void addToCartMultiple()
	{
		//gotocart
	}
	
	@Test(priority = 10)
	public void pincode() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; //casting
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		WebElement item = driver.findElement(By.xpath("//*[@id=\"prod_rel_pincode\"]"));
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().doubleClick().sendKeys(Keys.BACK_SPACE).build();
				//sendKeys(item,"earphone").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Aseries = a.moveToElement(item).click().sendKeys(item,"413001").build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"prod_pin_form\"]/div[1]/button[2]")).click();
		
		System.out.println(driver.findElement(By.className("form-success")).getAttribute("innerHTML"));
	}
	
	@Test(priority= 11)
	public void offers() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("cms_offers")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"avail_offers_dialog\"]/div/div/div[1]/div/button/span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("coupon_offers")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"avail_offers_dialog\"]/div/div/div[1]/div/button/span")).click();
		Thread.sleep(4000);
	}
	
	@Test(priority= 12)
	public void compare() throws InterruptedException
	{
		driver.findElement(By.className("iconText")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("iconText")).click();
		Thread.sleep(2000);
		
		WebElement item = driver.findElement(By.id("autocomplete-0-input"));
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"tv").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[2]/div/a/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/a/span[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("iconText")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("iconText")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver; //casting
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

	}
	@Test(priority= 13)
	public void dress() throws InterruptedException
	{
		driver.findElement(By.className("logo")).click();
		Thread.sleep(2000);
		WebElement item = driver.findElement(By.id("autocomplete-0-input"));
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"kurti").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[9]/div/div/ol/li[1]/div/a/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/a/span[4]")).click();
		Thread.sleep(2000);
		
		List <WebElement> colours;
		//driver.findElement(By.xpath("//*[@id=\"left_col\"]/div[1]/div[1]/div[3]")).click();
		colours = driver.findElements(By.className("image-variant"));
		int count=colours.size();
		System.out.println("colours"+count);
		for(int i=1;i<count;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"variant_colour\"]/div/ul/li["+i+"]/a/div/img")).click();
			Thread.sleep(4000);
		}
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Test successfully passes");
	}

}

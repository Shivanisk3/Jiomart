package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

//import test.TestFailedException;
class TestFailedException  extends Exception  
{  
    public TestFailedException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  
public class item_details {
	WebDriver driver;
	By search_id = By.id("autocomplete-0-input");
	By item_xpath1 = By.xpath("//*[@id=\"hits\"]/div/div/ol/li[2]/div/a/span[4]");
	
	By slides_class = By.className("swiper-wrapper");
	By zoom_xpath1 = By.xpath("//*[@id=\"left_col\"]/div[1]/div[1]/div[3]");
	By arrow1 = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/button[2]");
	By arrow2 = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/button[1]");
	By zoom_class = By.className("pswp__zoom-wrap");
	By zoom_xpath2 = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div[2]/div[2]/div[1]/button[3]");
	By price_xpath = By.xpath("//*[@id=\"alg_price\"]/span[1]/span");
	By ori_price_xpath = By.xpath("//*[@id=\"alg_price\"]/span[2]/strike");
	By discount_xpath = By.xpath("//*[@id=\"alg_price\"]/span[3]/span");
	By cart_count = By.className("counter-number");
	By cart_class = By.className("txt_btn");
	By pincode_xpath = By.xpath("//*[@id=\"prod_rel_pincode\"]");
	By pin_search_xpath = By.xpath("//*[@id=\"prod_pin_form\"]/div[1]/button[2]");
	By  pin_available = By.className("form-success");
	By offers_id = By.id("cms_offers");
	By offers_xpath = By.xpath("//*[@id=\"avail_offers_dialog\"]/div/div/div[1]/div/button/span");
	By coupon_id = By.id("coupon_offers");
	By compare_id = By.className("iconText");
	By item_xpath2 = By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/a/span[4]");
	By logo = By.className("logo");
	By colours_class = By.className("image-variant");
	
	public item_details(WebDriver driver)
	{
		this.driver=driver;
	}
	public void getTitle() throws InterruptedException{

		String title = driver.getTitle();
		System.out.println(title);
		     
		  }
	
	public void search() throws InterruptedException
	{
		WebElement item = driver.findElement(search_id);
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"tv").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
	}
	
	public void getItem()
	{
		//driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[9]/div/div/ol/li[1]/div/a/span[4]")).click();
		driver.findElement(item_xpath1).click();
	}
	
	public void slideShow() throws InterruptedException
	{
		List <WebElement> slides;
		
		//driver.findElement(By.className("largeimage.lazyautosizes.lazyloaded")).click();
		slides = driver.findElements(slides_class);
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
	
	public void zoomImage() throws InterruptedException
	{
		List <WebElement> slides;
		driver.findElement(zoom_xpath1).click();
		slides = driver.findElements(slides_class);
		int count=slides.size();
		System.out.println("slides"+count);
		for(int i=1;i<count;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(arrow1).click();
			Thread.sleep(2000);
		}
		for(int i=1;i<count;i++)
		{
			//System.out.println(slides.get(i).getAttribute("src"));
			//slides.get(i).click();
			driver.findElement(arrow2).click();
			Thread.sleep(2000);
		}
		driver.findElement(zoom_class).click();
		Thread.sleep(2000);
		driver.findElement(zoom_class).click();
		Thread.sleep(2000);
		driver.findElement(zoom_xpath2).click();
		Thread.sleep(2000);
		driver.findElement(zoom_xpath2).click();
		Thread.sleep(3000);

		Actions a = new Actions(driver);		
		Action Aseries = a.keyDown(Keys.ESCAPE).build();
		Aseries.perform();
		Thread.sleep(4000);

	}
	
	public void discount() 
	{
		//price of item
		System.out.println(driver.findElement(price_xpath).getAttribute("innerHTML"));
		String[] p = driver.findElement(price_xpath).getAttribute("innerHTML").split(" ");
		double price = Double.parseDouble(p[p.length-1]);
		System.out.println(price);
		
		
		//actual price and discount if present
		Boolean isPresent = driver.findElements(ori_price_xpath).size() > 0;
		if(isPresent)
		{
			String[] a = driver.findElement(ori_price_xpath).getAttribute("innerHTML").split(" ");
			double actualPrice = Double.parseDouble(a[a.length-1]);
			System.out.println(actualPrice);
			
			String[] w = driver.findElement(discount_xpath).getAttribute("innerHTML").split(" ");
			double discountWeb = Double.parseDouble(w[w.length-1]);
			
			//calculate discount
			double discount = actualPrice - price;
			System.out.println("Discount is : "+ discount);
			
			//check if both same
			if(discount!=discountWeb)
			{
				//throw new TestFailedException("Discount is not correct");    
				System.out.println("Item cannot be added in cart");
			}
		}
		
		
	}
	
	public void addToCart() throws InterruptedException
	{
		String cartItems, beforeCount;
		beforeCount = driver.findElement(cart_count).getAttribute("innerHTML");
		driver.findElement(cart_class).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cartItems = driver.findElement(cart_count).getAttribute("innerHTML");
		int before = Integer.parseInt(beforeCount);
		int added = Integer.parseInt(cartItems);
		System.out.println(cartItems);
		if(added!=before+1)
		{
			//throw new TestFailedException("Item cannot be added in cart");   
			System.out.println("Item cannot be added in cart");
		}
	}
	
	public void pincode() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; //casting
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		WebElement item = driver.findElement(pincode_xpath);
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().doubleClick().sendKeys(Keys.BACK_SPACE).build();
				//sendKeys(item,"earphone").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Aseries = a.moveToElement(item).click().sendKeys(item,"413001").build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(5000);
		driver.findElement(pin_search_xpath).click();
		
		System.out.println(driver.findElement(pin_available).getAttribute("innerHTML"));
	}
	
	public void offers() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(offers_id).click();
		Thread.sleep(2000);
		driver.findElement(offers_xpath).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("coupon_offers")).click();
		Thread.sleep(2000);
		driver.findElement(offers_xpath).click();
		Thread.sleep(4000);
	}
	
	public void compare() throws InterruptedException
	{
		driver.findElement(compare_id).click();
		Thread.sleep(2000);
		driver.findElement(compare_id).click();
		Thread.sleep(2000);
		
		WebElement item = driver.findElement(search_id);
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"tv").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li[2]/div/a/span[4]")).click();
		driver.findElement(item_xpath2).click();
		Thread.sleep(2000);
		driver.findElement(compare_id).click();
		Thread.sleep(2000);
		driver.findElement(compare_id).click();
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
	
	public void dress() throws InterruptedException
	{
		driver.findElement(logo).click();
		Thread.sleep(2000);
		WebElement item = driver.findElement(search_id);
		Actions a = new Actions(driver);		
		Action Aseries = a.moveToElement(item).click().sendKeys(item,"kurti").keyDown(Keys.ENTER).build();
		Thread.sleep(5000);
		Aseries.perform();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[9]/div/div/ol/li[1]/div/a/span[4]")).click();
		driver.findElement(item_xpath2).click();
		Thread.sleep(2000);
		
		List <WebElement> colours;
		//driver.findElement(By.xpath("//*[@id=\"left_col\"]/div[1]/div[1]/div[3]")).click();
		colours = driver.findElements(colours_class);
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
	
	
	
	
}

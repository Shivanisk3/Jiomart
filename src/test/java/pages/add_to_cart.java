package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class add_to_cart {
	WebDriver driver;
	By amt=By.id("cart_netpay_amt1");
	  By saving=By.cssSelector("div.save-amount.cart-savings.ng-star-inserted");
	  By proid1=By.id("nav_cat_1687");
	  By proid2=By.id("nav_link_1712");
	  By proclass1=By.className("add_plus");
	  By proclass2=By.className("available-count");
	  By del=By.className("current-qty");
	  By countclass1=By.className("special-price");
	  By countclass2=By.className("plus");
	  By countclass3=By.className("current-qty");
	  By visible=By.id("minicart_btn");
	  By search1=By.id("mat-input-0");
	  By search2=By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/div[1]/button");
	  By addcart=By.id("minicart_btn");
	public add_to_cart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	  public void AddCartClick() throws InterruptedException{

	 driver.findElement(addcart).click();
	 Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      System.out.println("Test Case 2:Add To Cart Button Clickable Successfully");
	     
	  }
	  
	  
	  public void searchproduct() throws InterruptedException{
	WebElement r =  driver.findElement(search1);
	      r.click();
	      Thread.sleep(2000);
	      r.sendKeys("banana");
	     Thread.sleep(2000);
	      r.sendKeys(Keys.RETURN);
	    JavascriptExecutor js=(JavascriptExecutor)driver;//casting
	      js.executeScript("window.scrollBy(0,100)");
	      Thread.sleep(2000);
	      driver.findElement(search2).click();
	    
	      System.out.println("Test Case 3: Searching done ");
	  }
	  
	  public void visibleAddToCartProduct() throws InterruptedException{


	 driver.findElement(visible).click();
	    Thread.sleep(4000);
	    System.out.println("Test Case 5:Product is visible in Cart ");
	     
	  }
	  public int count=1;
	
	  
	  public void CountProduct() throws InterruptedException{
	  String Price=driver.findElement(countclass1).getText();
	  System.out.println("Test case 6: Count of Product Added to cart "+ count +"Price of Product"+ Price );
	  driver.findElement(countclass2).click();
	  Thread.sleep(1000);
	  count=count+1;
	  if(count== Integer.parseInt(driver.findElement(countclass3).getText())) {
	  System.out.println("Count of sub product Product Added to cart: "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
	 
	  }
	 count=count+1;
	  driver.findElement(By.className("plus")).click();
	  Thread.sleep(1000);
	  if(count== Integer.parseInt(driver.findElement(By.className("current-qty")).getText())) {
	  System.out.println("Count of sub product Product Added to cart: "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
	 
	  }
	  }
	 
	  
	  public void deleteProduct() throws InterruptedException{

	 count=count-1;
	    driver.findElement(By.className("minus")).click();
	 
	   //System.out.println("After delete one sub product : "+ count +" Price of Product: "+ driver.findElement(By.className("available-amt")).getText()+""+driver.findElement(By.xpath("//*[@id=\"itemid-590001285\"]/div[2]/div[3]/div[3]/div/span[2]")).getText() );
	    if(count== Integer.parseInt(driver.findElement(del).getText())) {
	    System.out.println("Test case 7: After delete one sub product : "+ count +" Price of Product: "+ driver.findElement(By.className("special-price")).getText() );
	   
	    }
	 
	  }
	  
	  
	  public void TotalProductINCart() throws InterruptedException{
	 
	  WebElement mainMenu = driver.findElement(proid1);
	  Actions actions = new Actions(driver);
	  actions.moveToElement(mainMenu);
	  WebElement subMenu = driver.findElement(proid2);
	  actions.moveToElement(subMenu);
	  actions.click().build().perform();
	  Thread.sleep(2000);
	  JavascriptExecutor s=(JavascriptExecutor)driver;//casting
	  s.executeScript("window.scrollBy(0,150)");
	  Thread.sleep(2000);
	  driver.findElement(proclass1).click();
	  Thread.sleep(2000);
	  driver.findElement(proclass1).click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  System.out.println("Test case 8:Total number of Product added to Cart"+ driver.findElement(proclass2).getText());
	  }
	 
	 
	  public void TotalAmount() throws InterruptedException{
	 JavascriptExecutor s=(JavascriptExecutor)driver;//casting
	 System.out.println("Test case 9 :Total amount to Pay:"+driver.findElement(amt).getText());
	 s.executeScript("window.scrollBy(0,150)");
	  }


	 
	  public void TotalSavingAmount() throws InterruptedException{
	  System.out.println("Test case 10:Saving Amount "+driver.findElement(saving).getText());
	  Thread.sleep(3000);
	  }
	
}
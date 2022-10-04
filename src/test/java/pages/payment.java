package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class payment {
	WebDriver driver;
	By payment_id=By.id("9");
	  By pay_css=By.cssSelector("button.btn-checkout.btn.btn_to_checkout.m-0");
	  By pay_class1=By.className("css-128hug4");
	  By pay_class2=By.className("css-100scwx");
	  By pay_css1=By.cssSelector("button.btn-track.btn.m-0");
	  By pay_css2=By.cssSelector("button.primary-btn");
	  By pay_css3=By.cssSelector("button.btn.btn-help.ng-star-inserted");
	  By pay_xpath=By.xpath("//*[@id=\"frameModalBottom\"]/div/div/div[2]/div[1]/div[1]/div[2]/label");
	  By order_class=By.className("process-checkout");
	  By order_class1=By.className("deliver");
	  By amt_id=By.id("cart_netpay_amt1");
	  By visible=By.id("minicart_btn");
	  By pro_id=By.id("mat-input-0");
	  By pro_xpath=By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/div[1]/button");
	  By click_id=By.id("minicart_btn");
	  By sign_xpath=By.xpath("/html/body/div[1]/div[1]/header/div/div[5]/div/a[1]");
	  By sign_id=By.id("loginfirst_mobileno");
	  By sign_css=By.cssSelector("button.btn-signpass.arrowbtn");
	  By sign_class=By.className("btn-login");
	
	  public payment(WebDriver driver) {
		this.driver=driver;
	}
	 
	  public void signIn() throws InterruptedException{
	 driver.findElement(sign_xpath).click();
	 Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //driver.findElement(sign_id).sendKeys("8668335762");
	  driver.findElement(sign_id).sendKeys("9359317483");
	  driver.findElement(sign_css).click();
	  Thread.sleep(25000);
	  driver.findElement(sign_class).click();
	 Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  System.out.println("Login Sucessfully");
	 
	  }
	 
	  public void AddCartClick() throws InterruptedException{

	 driver.findElement(click_id).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 Thread.sleep(2000);
	      System.out.println("Test Case 2:Add To Cart Button Clickable Successfully");
	     
	  }
	 
	  
	  public void ProductAddToCart() throws InterruptedException{
	
	 WebElement r =  driver.findElement(pro_id);
	      r.click();
	      Thread.sleep(2000);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      r.sendKeys("banana");
	     Thread.sleep(2000);
	      r.sendKeys(Keys.RETURN);
	    JavascriptExecutor js=(JavascriptExecutor)driver;//casting
	      js.executeScript("window.scrollBy(0,100)");
	      Thread.sleep(2000);
	      driver.findElement(pro_xpath).click();
	  }
	 
	  
	  
	  public void visibleAddToCartProduct() throws InterruptedException{
	 driver.findElement(visible).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Thread.sleep(4000);
	    System.out.println("Test Case 4:Product is visible in Cart ");
	     
	  }
	 
	  
	  public void TotalAmount() throws InterruptedException{
	 JavascriptExecutor s=(JavascriptExecutor)driver;//casting
	 s.executeScript("window.scrollBy(0,150)");
	 System.out.println("Test case 5 :Total amount to Pay:"+driver.findElement(amt_id).getText());
	 
	  }
	  
	  
	  public void placeorderclick() throws InterruptedException{
	 driver.findElement(order_class).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 Thread.sleep(2000);
	 System.out.println("PlaceOrder button clicked successfully");
	 //delivery
	 driver.findElement(order_class1).click();
	 System.out.println("Deliver here button clicked successfully");
	  }
	  
	  
	  public void paymentMode() {
	 driver.findElement(pay_css).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 JavascriptExecutor s1=(JavascriptExecutor)driver;//casting
	 s1.executeScript("window.scrollBy(0,700)");
	 driver.findElement(payment_id).click();
	 driver.findElement(pay_class1).click();
	 driver.findElement(pay_class2).click();
	 driver.findElement(pay_css1).click();
	 driver.findElement(pay_css2).click();
	 driver.findElement(pay_css3).click();
	 driver.findElement(pay_xpath).click();
	 
	  }
}

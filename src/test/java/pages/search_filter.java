package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class search_filter {
	
		WebDriver driver;
		By log_name=By.className("logged");
		By login_id=By.id("loginfirst_mobileno");
		By login_arrow=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]");
		By login_button=By.className("btn-login");
		By search_id=By.id("autocomplete-0-input");
		By price=By.id("final_price");
		By popularity=By.xpath("//*[@id=\"sort_container\"]/button[1]");
		By high_low=By.xpath("//*[@id=\"sort_container\"]/button[2]");
		By low_high=By.xpath("//*[@id=\"sort_container\"]/button[3]");
		By discount=By.xpath("//*[@id=\"sort_container\"]/button[4]");
		By all_products=By.xpath("//*[@id=\"sort_container\"]/button[5]");
		By multiple_class=By.className("search_list");
		By multiple_id=By.id("rel_search_val");
		By multiple_xpath=By.xpath("//*[@id=\"rel_search_form\"]/button[2]");
		By brand1=By.xpath("//*[@id=\"brand_filter\"]/div/ul/li[1]/div/div/label/input");
		By brand2=By.xpath("//*[@id=\"brand_filter\"]/div/ul/li[2]/div/div/label/input");
		By avail=By.xpath("//*[@id=\"in_stock_filter\"]/div/ul/li/div/div/div/label/input");
		By cat1=By.xpath("//*[@id=\"category_filter\"]/div/ul/li[1]/div/div/label/input");
		By cat2=By.xpath("//*[@id=\"category_filter\"]/div/ul/li[2]/div/div/label/input");
		By size=By.xpath("//*[@id=\"size_filter\"]/div/ul/li[2]/div/div/label/input");
		
		public search_filter(WebDriver driver) {
			this.driver=driver;
		}
		
		 public void login() throws InterruptedException{
			
			driver.findElement(log_name).click();
			driver.findElement(login_id).sendKeys("8668335762");
			driver.findElement(login_arrow).click();
			Thread.sleep(25000);
			driver.findElement(login_button).click();
			System.out.println("login done....");
		}
		 
		 public void popularity() throws InterruptedException {
			  Thread.sleep(1000);
			  WebElement p=driver.findElement(search_id);
				p.sendKeys("home");
				Thread.sleep(2000);
				p.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
			    
				//popularity
				driver.findElement(popularity).click();
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
		  
		  
		  public void high_to_low() throws InterruptedException {
			  Thread.sleep(10000);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//High to Low
				driver.findElement(high_low).click();
				System.out.println("High to Low option done");
				Thread.sleep(1500);
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
			    int j = 0;
			    for(int i=0;i<=300;i+=50) {
			    	js2.executeScript("window.scrollBy("+j+","+i+")", "");
			    	j=i;
				    Thread.sleep(1500);
			    }
			    
			    List<WebElement> high1 = driver.findElements(price);
		
		        System.out.println(high1.size());
		
		        for (WebElement webElement : high1) {
		            String name = webElement.getText();
		            System.out.println(name);
		        }
			    js2.executeScript("window.scrollBy(0,-300)");
			  
		  }
		  
		  public void low_to_high() throws InterruptedException
		  {
			  Thread.sleep(1000);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//Low to High
				driver.findElement(low_high).click();
				System.out.println("Low to High option done");
				Thread.sleep(1500);
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    int j = 0;
			    for(int i=0;i<=300;i+=50) {
			    	js3.executeScript("window.scrollBy("+j+","+i+")", "");
			    	j=i;
				    Thread.sleep(1500);
			    }
			    List<WebElement> low = driver.findElements(price);
		
		      System.out.println(low.size());
		
		      for (WebElement webElement : low) {
		          String name = webElement.getText();
		          System.out.println(name);
		      }
			    js3.executeScript("window.scrollBy(0,-300)");
		  }
		  
		  
		  public void discount() throws InterruptedException
		  {
				//Discount
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  Thread.sleep(10000);
				driver.findElement(discount).click();
				System.out.println("Discount option done");
				Thread.sleep(1000);
				JavascriptExecutor js4 = (JavascriptExecutor) driver;
			    int j = 0;
			    for(int i=0;i<=300;i+=50) {
			    	js4.executeScript("window.scrollBy("+j+","+i+")", "");
			    	j=i;
				    Thread.sleep(1500);
			    }
			    List<WebElement> discounts = driver.findElements(price);
		
		      System.out.println(discounts.size());
		
		      for (WebElement webElement : discounts) {
		          String name = webElement.getText();
		          System.out.println(name);
		      }
			    js4.executeScript("window.scrollBy(0,-300)");
				
		  }
		  public void all_products() throws InterruptedException
			  {
					//All products
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.findElement(all_products).click();
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
		  
		  public void multiple_search_options() throws InterruptedException
		  {
				//searching multiple products
			  Thread.sleep(1000);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.findElement(multiple_class).click();
			  driver.findElement(multiple_id).sendKeys("milk,bread");
			  Thread.sleep(3000);
			  driver.findElement(multiple_xpath).click();
			  Thread.sleep(1000);
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
		  
		  
		  public void brands_multiple_checkbox() throws InterruptedException
		  {
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			  WebElement p=driver.findElement(search_id);
				p.sendKeys("tv");
				Thread.sleep(2000);
				p.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement check1 = driver.findElement(brand1);
				    check1.click();
				WebElement check2 = driver.findElement(brand2);
				    check2.click();
			System.out.println("Clicked multiple Check Boxes..");	
			Thread.sleep(1000);
		  }
		  
		
		  public void availablity() throws InterruptedException
		  {
			  
			  WebElement p=driver.findElement(search_id);
			  p.sendKeys("headphones");
				Thread.sleep(1000);
				p.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement check1 = driver.findElement(avail);
				    check1.click();
				
			System.out.println("Clicked availability option..");	
			Thread.sleep(3000);
			  
		  }
			
			
		  public void category() throws InterruptedException
		  {
			  
			  WebElement p=driver.findElement(search_id);
			  p.sendKeys("slippers");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				p.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				WebElement check1 = driver.findElement(cat1);
				    check1.click();
				WebElement check2 = driver.findElement(cat2);
				 check2.click();
				
			System.out.println("Clicked women & fashion option from category..");	
			Thread.sleep(3000);
			  
		  }
			
			
			  public void size() throws InterruptedException
			  {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  WebElement p=driver.findElement(search_id);
				  p.sendKeys("kurti");
					Thread.sleep(1000);
					p.sendKeys(Keys.ENTER);
					Thread.sleep(5000);
					WebElement check1 = driver.findElement(size);
					    check1.click();
					
				System.out.println("Clicked 'M' option from size..");	
				Thread.sleep(3000);
				  
			  }
			
			  public void logout() throws InterruptedException
			  {
				driver.findElement(By.id("logged_user")).click();
				Thread.sleep(1000);
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				int j=0;
				for(int i=0;i<=300;i+=50) {
			    	
					js3.executeScript("window.scrollBy("+j+","+i+")", "");
			    	j=i;
				    Thread.sleep(1500);
			    }
				driver.findElement(By.xpath("//*[@id=\"js-leftblk-cmsblk\"]/a")).click();
				System.out.println("Logged Out");
//				driver.get(url);
				}
		  
		
	
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wishlist {
	
	WebDriver driver;
	By del_id=By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/div/div/div[1]/div/div/div[2]/div[4]/div[1]/button");
	  By del_xpath=By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/h1");
	  By addxpath1=By.xpath("//*[@id=\"autocomplete-0-input\"]");
	  By addxpath2=By.xpath("//*[@id=\"autocomplete-0-input\"]");
	  By addxpath3=By.xpath("//*[@id=\"hits\"]/div/div/ol/li[1]/div/a/span[4]");
	  By addxpath4=By.xpath("//*[@id=\"wishlist_btn\"]");
	  By addxpath5=By.xpath("//*[@id=\"js-leftblk-cmsblk\"]/div/a[2]");
	  By addxpath6=By.xpath("//*[@id=\"app\"]/main/div/app-mywishlist/div/h1");
	  By addid=By.id("logged_user");
	  
	  By login1=By.xpath("//*[@id=\"loginfirst_mobileno\"]");
	  By login2=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]");
	  By login_class=By.className("btn-login");
	  
		public wishlist(WebDriver driver)
		{
			this.driver=driver;
		}
	

		  public void login() throws InterruptedException{
		  driver.findElement(login1).sendKeys("9359746720");
		  driver.findElement(login2).click();
		  Thread.sleep(35000);
		  driver.findElement(login_class).click();
		  System.out.println("login Successfully");
		}
		  
		  public void Add_To_Wishlist() throws InterruptedException{
		  Thread.sleep(10000);
		  driver.findElement(addxpath1).click();
		  WebElement r = driver.findElement(addxpath2);
		  r.sendKeys("kurti");
		  r.sendKeys(Keys.RETURN);
		  Thread.sleep(10000);
		  driver.findElement(addxpath3).click();
		  driver.findElement(addxpath4).click();
		  Thread.sleep(10000);
		  driver.findElement(addid).click();
		  driver.findElement(addxpath5).click();
		  Thread.sleep(1000);
		  String s1= driver.findElement(addxpath6).getText();
		  System.out.println("Wishlist item count after adding : "+s1.charAt(10));
		  Thread.sleep(2000);
		 
		}
		  
		  public void Delete_From_Wishlist() throws InterruptedException{
		  driver.findElement(del_id).click();    
		  Thread.sleep(2000);
		  String s2=driver.findElement(del_xpath).getText();
		  System.out.println("Wishlist item count after deleting : "+s2.charAt(10));
		  Thread.sleep(10000);
		  }
}

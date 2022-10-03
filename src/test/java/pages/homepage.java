package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class homepage {
	WebDriver driver;
	By homename=By.className("menu_section");
	By homeid=By.xpath("//*[@id=\"mySidenav\"]/div/a[1]");
	By var_id=By.id("nav_link_2");
	By action_id=By.xpath("//*[@id=\"nav_link_219\"]");
	By action_name=By.className("o-menu");
	By title_xpath1=By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]");
	By title_xpath2=By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]");
			
	public homepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getTitle() throws InterruptedException
	{
	String title = driver.getTitle();
	System.out.println(title);
	driver.findElement(title_xpath1).click();
	Thread.sleep(1000);
	driver.findElement(title_xpath2).click();
	Thread.sleep(1000);

	}
	
	public void working() throws InterruptedException
	{
	Actions actions =new Actions(driver);

	List<WebElement> cursor;
	List<WebElement> items;
	
	cursor=driver.findElements(action_name);
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
	items=driver.findElements(action_id);
	int count2=items.size();
	System.out.println(count2);

	}

	
	WebElement var=driver.findElement(var_id);
	actions.moveToElement(var);
	actions.build().perform();


	JavascriptExecutor js1=(JavascriptExecutor) driver;//casting
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	js1.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
	
	driver.findElement(homename).click();
	Thread.sleep(1000);
	driver.findElement(homeid).click();
	Thread.sleep(2000);
	}
	
}

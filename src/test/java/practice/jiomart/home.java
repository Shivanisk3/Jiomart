package practice.jiomart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class home {
public static void main(String[] args) throws InterruptedException {

WebDriver driver=null;
//System.setProperty("webdriver.chrome.driver","C:\\Users\\tejashri_adam\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//WebDriver driver=new ChromeDriver();
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(2000);
//opening url
driver.get("https://www.jiomart.com/");
//for hover
driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"section_3100\"]/div[2]/div[4]")).click();
Thread.sleep(1000);


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

driver.close();

}
}
/*Test cases:
1. Scroll the page - page should scroll
2. dropdown should open after hovering (arrow should be upside down)
3. after clicking on a item from dropdown, should be redirected to that page
4.hamburger icon should open after clicking 3 lines
5. close after clicking cross*/


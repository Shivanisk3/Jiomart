package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class category {
	
	WebDriver driver;
	By launch=By.xpath("//*[@id=\'accordion\']/div[1]/div[1]/div[2]/span[1]");
	public category (WebDriver driver) {
		this.driver=driver;
	}
	
	  public void launch() throws InterruptedException{
	driver.manage().window().maximize();
	Thread.sleep(3000);
	 System.out.println("Test case 1:Browser open Successfully");
	 System.out.println(driver.findElement(launch).getText());
	 
	      }
	  
	  public void categories_check() throws InterruptedException{
	 System.out.println("......... Available Categories ...........\n");
	 for(int i=1;i<=7;i++) {
	 //System.out.println(i);
	 String m=String.valueOf(i);
	 String xpath="//*[@id=\'accordion\']/div["+m+"]/div[1]/div[2]/span[1]";
	 By cate_id=By.xpath(xpath);
	 Thread.sleep(2000);
	 
	 
	 boolean t=driver.findElement(cate_id).isDisplayed();
	 if (t) {
	 String s=driver.findElement(cate_id).getText();
	 System.out.println(s);
	 
	 }
	 }
	  }
	 
	  public void  subcategory() throws InterruptedException{
	 System.out.println("--------------------------------");

	//--------------------Sub categories check----------------------------
	String[][] id={{"219","61","13","10","33","91","36","2551","3346"},
	{"7470","7473","7479","7483","7489"},
	{"1710","1712","1696","2335","1706"},
	{"496","493","499","563","550"},
	{"757","746","724","719","736"},
	{"3102","3154","3158","3175","3186"},
	{"1531","5308"}};
	for(int j=1;j<=7;j++) {
	String c1="//*[@id=\"accordion\"]/div["+j+"]/div[1]/div[2]/span[1]";
	By sub1=By.xpath(c1);
	
	driver.findElement(sub1).click();
	boolean t1=driver.findElement(sub1).isDisplayed();
	if(t1) {
	System.out.println("\n"+driver.findElement(sub1).getText()+" is clicked..........");
	System.out.println("......... Sub Categories ..........");
	for(String i: id[j-1]) {
	String sub ="//*[@id=\"child_accordion_"+i+"\"]/div/div/div[2]/a/span";
	By sub2=By.xpath(sub);
	boolean t=driver.findElement(sub2).isDisplayed();
	if (t) {
	String s=driver.findElement(sub2).getText();
	System.out.println(s);
	}
	}
	}
	  }
	  }
	 
	
}

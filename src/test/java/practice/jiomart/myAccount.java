package practice.jiomart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class myAccount {
WebDriver driver=null;
	
	@BeforeClass
	public void driverSetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani_kulkarni2\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void getURL() throws InterruptedException
	{
		driver.get("https://www.jiomart.com/");
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void getTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority = 3)
	public void openprofile()
	{
		driver.findElement(By.className("logged")).click();
	}
	
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Test successfully passes");
	}

}

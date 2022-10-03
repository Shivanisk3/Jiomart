package practice.jiomart;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserProfile {
	WebDriver driver;
	public static String baseUrl ="https://www.jiomart.com/";
	public static String errorresult1,errorresult2,errorresult3,firstname,lastname,email,dob,name,phone;
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	public void TestLogin() throws InterruptedException {

		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Sign in / Sign up")).click();
		//driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668298946");
		driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668335762");
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]")).click();
		Thread.sleep(35000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void TestUpdateUserProfile01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("logged_user")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		Thread.sleep(3000);
		
		//Updating profile details with null value
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(" ");
		Thread.sleep(3000);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(" ");
		Thread.sleep(3000);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(" ");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(text(),'Save Changes')]")).click();
		Thread.sleep(3000);
		
		errorresult1=driver.findElement(By.id("mat-error-6")).getText();
		System.out.println(errorresult1);
		errorresult2=driver.findElement(By.id("mat-error-7")).getText();
		System.out.println(errorresult2);
		errorresult3=driver.findElement(By.id("mat-error-8")).getText();
		System.out.println(errorresult3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
		
			}
	
	//Login and update profile in JioMart with valid details
	@Test(priority=3)
	public void TestUpdateUserProfile02() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("logged_user")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		
		//Updating profile details with valid details
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Dattatray");
		Thread.sleep(3000);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Patil");
		Thread.sleep(3000);
	
		driver.findElement(By.id("date_of_birth")).sendKeys("18/05/2000");
		Thread.sleep(3000);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("jiomart@gmail.com");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(text(),'Save Changes')]")).click();
		Thread.sleep(3000);
	
		name=driver.findElement(By.xpath("//body/app-root[1]/app-layout[1]/div[1]/main[1]/div[1]/app-account[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[2]")).getText();
		email=driver.findElement(By.xpath("//body/app-root[1]/app-layout[1]/div[1]/main[1]/div[1]/app-account[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[2]/div[2]")).getText();
		phone=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/main[1]/div[1]/app-account[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[2]")).getText();
	
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(phone);
			}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

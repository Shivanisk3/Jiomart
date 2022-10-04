package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.userprofile;


public class Test_userprofile {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	userprofile u;
	
	@BeforeTest
	  public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		u=new userprofile(driver);
	  }
	@Test(priority=1)
	public void TestLogin() throws InterruptedException {
		u.TestLogin();
	}

	@Test(priority=2)
	public void TestUpdateUserProfile01() throws InterruptedException {
		u.TestUpdateUserProfile01();
	}

	//Login and update profile in JioMart with valid details
	@Test(priority=3)
	public void TestUpdateUserProfile02() throws InterruptedException {
	 u.TestUpdateUserProfile02();
	}
	
	@AfterTest
	public void tearDown() {
	driver.quit();
	}
}

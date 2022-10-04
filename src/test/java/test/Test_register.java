package test;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.register;



public class Test_register {
	String url = "https://www.jiomart.com/";
	WebDriver driver;
	
	register r;
	
	@BeforeTest
	  public void beforeTest() throws SQLException,ClassNotFoundException{
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		r=new register(driver);
	  }

	@Test(priority=1)
	public void Main() throws InterruptedException,SQLException,ClassNotFoundException {
		r.Main();
	}
	
	@Test(priority=2)
	public void TestAboutUs0() throws InterruptedException,SQLException,ClassNotFoundException {
		r.TestAboutUs0();
	}
	
	@Test(priority=3)
	public void TestAboutUs1() throws InterruptedException, SQLException {
		r.TestAboutUs1();
	}
	
	@Test(priority=4)
	public void TestAboutUs2() throws InterruptedException, SQLException {
		r.TestAboutUs2();
	}
	
	@Test(priority=5)
	public void TestAboutUs3() throws InterruptedException, SQLException {
	r.TestAboutUs3();
	}
	
	@Test(priority=6)
	public void TestAboutUs4() throws InterruptedException, SQLException {
		r.TestAboutUs4();
	}
	 
	@Test(priority=7)
	public void TestAboutUs5() throws InterruptedException, SQLException {
		r.TestAboutUs5();
	}
	
	@AfterTest
	public void tearDown() {
	driver.quit();

}
}

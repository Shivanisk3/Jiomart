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
import java.sql.*;

public class signup {
	WebDriver driver;
	public static String baseUrl ="https://www.jiomart.com/";
	String r1,r2,r3,r4,r5,r6;
	//Class.forName("com.mysql.jdbc.Driver");
	Connection conn;
	Statement s;
	
	

	@BeforeTest
	public void setUp() throws Exception,SQLException,ClassNotFoundException {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
  
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_users", "root", "");//Establishing connection
		 s= conn.createStatement();
		
		
	}
	
	
	@Test(priority=1)
	public void Main() throws InterruptedException,SQLException,ClassNotFoundException {
		driver.get(baseUrl);
		
		driver.findElement(By.linkText("Sign in / Sign up")).click();
		//driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8008114208");
		driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668335760");
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]")).click();
	}
	@Test(priority=2)
	public void TestAboutUs0() throws InterruptedException, SQLException,ClassNotFoundException {
		
		ResultSet user1= s.executeQuery("select * from users_for_login where id=1");
		String name,name2,email,pass1,pass2,otp;
		while(user1.next())
		{
			//System.out.println(user1.getString("firstname"));
			//System.out.println(user1.getString("lastname"));
			name= user1.getString("firstname");
			name2= user1.getString("lastname");
			email= user1.getString("email");
			pass1= user1.getString("password");
			pass2= user1.getString("confirm_password");
			otp= user1.getString("otp");
		
        driver.findElement(By.id("reg_firstname")).sendKeys(name);
    
		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		driver.findElement(By.id("reg_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
		}
	  r1= driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[1]/div[1]/div")).getText();
      Thread.sleep(3000);
      System.out.println(r1);
      driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(" ");
	driver.navigate().refresh();
		
	}
	@Test(priority=3)
	public void TestAboutUs1() throws InterruptedException, SQLException,ClassNotFoundException {
		
		ResultSet user2= s.executeQuery("select * from users_for_login where id=2");
		while(user2.next())
		{
			System.out.println(user2.getString("firstname"));
			System.out.println(user2.getString("lastname"));
			String name= user2.getString("firstname");
			String name2= user2.getString("lastname");
			String email= user2.getString("email");
			String pass1= user2.getString("password");
			String pass2= user2.getString("confirm_password");
			String otp= user2.getString("otp");
		System.out.println(user2.getString("firstname"));
		System.out.println(user2.getString("lastname"));
        driver.findElement(By.id("reg_firstname")).sendKeys(name);
        
		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		driver.findElement(By.id("reg_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
		}
	r2= driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[1]/div[1]/div")).getText();
    Thread.sleep(3000);
    System.out.println(r2);
    driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(" ");
	driver.navigate().refresh();
		
	}
	@Test(priority=4)
	public void TestAboutUs2() throws InterruptedException, SQLException,ClassNotFoundException {
	
		ResultSet user3= s.executeQuery("select * from users_for_login where id=3");
		while(user3.next())
		{
			System.out.println(user3.getString("firstname"));
			System.out.println(user3.getString("lastname"));
			String name= user3.getString("firstname");
			String name2= user3.getString("lastname");
			String email= user3.getString("email");
			String pass1= user3.getString("password");
			String pass2= user3.getString("confirm_password");
			String otp= user3.getString("otp");
        driver.findElement(By.id("reg_firstname")).sendKeys(name);
        Thread.sleep(3000);

		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		driver.findElement(By.id("reg_email")).sendKeys(email);
		
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	    Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
	    r3=driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[1]/div[3]/div")).getText();
		Thread.sleep(3000);
	System.out.println(r3);
	
	driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(" ");
	driver.navigate().refresh();
		}
	}
	@Test(priority=5)
	public void TestAboutUs3() throws InterruptedException,SQLException,ClassNotFoundException {
		
		ResultSet user4= s.executeQuery("select * from users_for_login where id=5");
		while(user4.next())
		{
			System.out.println(user4.getString("firstname"));
			System.out.println(user4.getString("lastname"));
			String name= user4.getString("firstname");
			String name2= user4.getString("lastname");
			String email= user4.getString("email");
			String pass1= user4.getString("password");
			String pass2= user4.getString("confirm_password");
			String otp= user4.getString("otp");
	
        driver.findElement(By.id("reg_firstname")).sendKeys(name);
        Thread.sleep(3000);

		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		
		driver.findElement(By.id("reg_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		
	    driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	    Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
	    r4=driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/div/div")).getText();
		Thread.sleep(3000);
   System.out.println(r4);
   driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(" ");
	    driver.navigate().refresh();
		}
	}
	@Test(priority=6)
	public void TestAboutUs4() throws InterruptedException,SQLException,ClassNotFoundException {
		
		ResultSet user5= s.executeQuery("select * from users_for_login where id=6");
		while(user5.next())
		{
			System.out.println(user5.getString("firstname"));
			System.out.println(user5.getString("lastname"));
			String name= user5.getString("firstname");
			String name2= user5.getString("lastname");
			String email= user5.getString("email");
			String pass1= user5.getString("password");
			String pass2= user5.getString("confirm_password");
			String otp= user5.getString("otp");
	
driver.findElement(By.id("reg_firstname")).sendKeys(name);
Thread.sleep(3000);

		

		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		driver.findElement(By.id("reg_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
		}
	r5=driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/div")).getText();
	Thread.sleep(3000);
	System.out.println(r5);
	driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(" ");
	driver.navigate().refresh();
	}
	  
	@Test(priority=7)
	public void TestAboutUs5() throws InterruptedException,SQLException,ClassNotFoundException {
		
		ResultSet user6= s.executeQuery("select * from users_for_login where id=7");
		while(user6.next())
		{
			System.out.println(user6.getString("firstname"));
			System.out.println(user6.getString("lastname"));
			String name= user6.getString("firstname");
			String name2= user6.getString("lastname");
			String email= user6.getString("email");
			String pass1= user6.getString("password");
			String pass2= user6.getString("confirm_password");
			String otp= user6.getString("otp");
driver.findElement(By.id("reg_firstname")).sendKeys(name);
Thread.sleep(3000);

		driver.findElement(By.id("reg_lastname")).sendKeys(name2);
		Thread.sleep(3000);
		driver.findElement(By.id("reg_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("register_pwd")).sendKeys(pass1);
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a")).click();
	Thread.sleep(3000);
		driver.findElement(By.id("register_confirm_pwd")).sendKeys(pass2);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys(otp);
		Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button")).click();
		}
	r6=driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/div")).getText();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input")).sendKeys("234567 ");
	System.out.println(r5);
	//driver.navigate().refresh();
	
	}
	
	@AfterTest
	public void tearDown() {
		 driver.quit();

	}
}

package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class register {
	WebDriver driver;
	String baseUrl = "https://www.jiomart.com/";
	String r1,r2,r3,r4,r5,r6;
	Connection conn;
	Statement s;
	public register(WebDriver driver) throws SQLException,ClassNotFoundException{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_users", "root", "");//Establishing connection
		 s= conn.createStatement();
	}
	
	By main_link=By.linkText("Sign in / Sign up");
	By main_id=By.id("loginfirst_mobileno");
	By main_xpath=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]");
	By abt0_id1=By.id("reg_firstname");
	By abt0_id2=By.id("reg_lastname");
	By abt0_id3=By.id("reg_email");
	By abt0_id4=By.id("register_pwd");
	By abt0_id5=By.id("register_confirm_pwd");
	By abt0_xpath1=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[2]/div/a");
	By abt0_xpath2=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[3]/div/a");
	By abt0_xpath3=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[6]/div/button");
	By abt0_xpath4=By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[1]/div[1]/div");
	By abt0_xpath5=By.xpath("/html/body/app-root/app-layout/div/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input");
	By abt0_xpath6=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/form/div[5]/div/div[1]/input");
	
	
	public void Main() throws InterruptedException,SQLException,ClassNotFoundException{
	driver.get(baseUrl);
	driver.findElement(main_link).click();
	//driver.findElement(main_id).sendKeys("9175910391");
	//driver.findElement(main_id).sendKeys("9359746720");
	driver.findElement(main_id).sendKeys("8668335760");
	driver.findElement(main_xpath).click();
	}
	
	public void TestAboutUs0() throws InterruptedException, SQLException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	driver.findElement(abt0_id1).sendKeys(name);
	   
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	driver.findElement(abt0_id3).sendKeys(email);
	Thread.sleep(3000);
	driver.findElement(abt0_id4).sendKeys(pass1);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath1).click();
	Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	driver.findElement(abt0_xpath3).click();
		}
	 r1= driver.findElement(abt0_xpath4).getText();
	      Thread.sleep(3000);
	      System.out.println(r1);
	      driver.findElement(abt0_xpath5).sendKeys(" ");
	driver.navigate().refresh();
	}
	
	
	public void TestAboutUs1() throws InterruptedException, SQLException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	driver.findElement(abt0_id1).sendKeys(name);
	       
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	driver.findElement(abt0_id3).sendKeys(email);
	Thread.sleep(3000);
	driver.findElement(abt0_id4).sendKeys(pass1);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath1).click();
	Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	driver.findElement(abt0_xpath3).click();
		}
	r2= driver.findElement(abt0_xpath4).getText();
	    Thread.sleep(3000);
	    System.out.println(r2);
	    driver.findElement(abt0_xpath5).sendKeys(" ");
	driver.navigate().refresh();
	}
	
	
	public void TestAboutUs2() throws InterruptedException, SQLException {
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
			
	driver.findElement(abt0_id1).sendKeys(name);
	Thread.sleep(3000);
	
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	driver.findElement(abt0_id3).sendKeys(email);
	
	driver.findElement(abt0_id4).sendKeys(pass1);
	Thread.sleep(3000);
	   driver.findElement(abt0_xpath1).click();
	   Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	   driver.findElement(abt0_xpath3).click();
		}
	   r3=driver.findElement(abt0_xpath4).getText();
	Thread.sleep(3000);
	System.out.println(r3);
	
	driver.findElement(abt0_xpath5).sendKeys(" ");
	driver.navigate().refresh();
	}
	
	public void TestAboutUs3() throws InterruptedException, SQLException {
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
	
	driver.findElement(abt0_id1).sendKeys(name);
	Thread.sleep(3000);
	
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	
	driver.findElement(abt0_id3).sendKeys(email);
	Thread.sleep(3000);
	driver.findElement(abt0_id4).sendKeys(pass1);
	
	   driver.findElement(abt0_xpath1).click();
	   Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	   driver.findElement(abt0_xpath3).click();
		}
	   r4=driver.findElement(abt0_xpath4).getText();
	Thread.sleep(3000);
	   System.out.println(r4);
	   driver.findElement(abt0_xpath5).sendKeys(" ");
	   driver.navigate().refresh();
	}
	
	public void TestAboutUs4() throws InterruptedException, SQLException {
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
	
	driver.findElement(abt0_id1).sendKeys(name);
	Thread.sleep(3000);
	
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	driver.findElement(abt0_id3).sendKeys(email);
	Thread.sleep(3000);
	driver.findElement(abt0_id4).sendKeys(pass1);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath1).click();
	Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	driver.findElement(abt0_xpath3).click();
		}
	r5=driver.findElement(abt0_xpath4).getText();
	Thread.sleep(3000);
	System.out.println(r5);
	driver.findElement(abt0_xpath5).sendKeys(" ");
	driver.navigate().refresh();
	}
	 
	
	public void TestAboutUs5() throws InterruptedException, SQLException {
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
	
	driver.findElement(abt0_id1).sendKeys(name);
	Thread.sleep(3000);
	
	driver.findElement(abt0_id2).sendKeys(name2);
	Thread.sleep(3000);
	driver.findElement(abt0_id3).sendKeys(email);
	Thread.sleep(3000);
	driver.findElement(abt0_id4).sendKeys(pass1);
	Thread.sleep(3000);
	driver.findElement(abt0_xpath1).click();
	Thread.sleep(3000);
	driver.findElement(abt0_id5).sendKeys(pass2);
	
	driver.findElement(abt0_xpath2).click();
	Thread.sleep(3000);
	driver.findElement(abt0_xpath3).click();
	driver.findElement(abt0_xpath6).sendKeys("234567 ");
	Thread.sleep(3000);
		}
	JavascriptExecutor js=(JavascriptExecutor)driver; //casting
	js.executeScript("window.scrollBy(0,100)");
	Thread.sleep(3000);
	//r6=driver.findElement(abt0_xpath4).getText();
	Thread.sleep(3000);
	//driver.findElement(abt0_xpath4).sendKeys("234567 ");
	System.out.println(r5);
	//driver.navigate().refresh();
	
	}

}

package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;

public class userprofile {
	WebDriver driver;
	public static String errorresult1,errorresult2,errorresult3,firstname,lastname,email,dob,name,phone;
	String url = "https://www.jiomart.com/";
	By login_link=By.linkText("Sign in / Sign up");
	By login_id=By.id("loginfirst_mobileno");
	By login_xpath=By.xpath("//*[@id=\"app\"]/main/div/app-login/div[1]/div/div[1]/div[2]/div/div[1]/form/div[2]/button[1]");
	By login_class=By.className("btn-login");
	By pro1_id=By.id("logged_user");
	By pro1_xpath=By.xpath("//a[contains(text(),'Edit')]");
	By pro1_xpath1=By.xpath("//button[contains(text(),'Save Changes')]");
	By pro1_id1=By.id("mat-error-6");
	By pro1_id2=By.id("mat-error-7");
	By pro1_id3=By.id("mat-error-8");
	By pro2_xpath1=By.xpath("//body/app-root[1]/app-layout[1]/div[1]/main[1]/div[1]/app-account[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[2]");
	By pro2_xpath2=By.xpath("/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/main[1]/div[1]/app-account[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[2]");
	By pro2_xpath3=By.xpath("//button[contains(text(),'Save Changes')]");
	By pro2_first=By.id("firstname");
	By pro2_last=By.id("lastname");
	By pro2_dob=By.id("date_of_birth");
	By pro2_email=By.id("email");
	By pro2_id=By.id("logged_user");
	By pro2_xpath4=By.xpath("//a[contains(text(),'Edit')]");
	
	public userprofile(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void TestLogin() throws InterruptedException {

	driver.get(url);
	driver.findElement(login_link).click();
	//driver.findElement(By.id("loginfirst_mobileno")).sendKeys("8668298946");
	driver.findElement(login_id).sendKeys("8668335762");
	driver.findElement(login_xpath).click();
	Thread.sleep(35000);
	driver.findElement(login_class).click();
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	public void TestUpdateUserProfile01() throws InterruptedException {
		
	driver.findElement(pro1_id).click();
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(pro1_xpath).click();
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//Updating profile details with null value
	driver.findElement(pro2_first).clear();
	driver.findElement(pro2_first).sendKeys(" ");
	Thread.sleep(3000);

	driver.findElement(pro2_last).clear();
	driver.findElement(pro2_last).sendKeys(" ");
	Thread.sleep(3000);

	driver.findElement(pro2_email).clear();
	driver.findElement(pro2_email).sendKeys(" ");
	Thread.sleep(3000);

	
	driver.findElement(pro1_xpath).click();
	Thread.sleep(3000);

	errorresult1=driver.findElement(pro1_id1).getText();
	System.out.println(errorresult1);
	errorresult2=driver.findElement(pro1_id2).getText();
	System.out.println(errorresult2);
	errorresult3=driver.findElement(pro1_id3).getText();
	System.out.println(errorresult3);
	driver.navigate().refresh();

	}

	//Login and update profile in JioMart with valid details
	
	public void TestUpdateUserProfile02() throws InterruptedException {
		
	driver.get(url);
	driver.findElement(pro2_id).click();
	Thread.sleep(3000);
	driver.findElement(pro2_xpath4).click();

	//Updating profile details with valid details
	driver.findElement(pro2_first).clear();
	driver.findElement(pro2_first).sendKeys("Mike");
	Thread.sleep(3000);

	driver.findElement(pro2_last).clear();
	driver.findElement(pro2_last).sendKeys("Johnson");
	Thread.sleep(3000);

	driver.findElement(pro2_dob).sendKeys("18/05/2000");
	Thread.sleep(3000);

	driver.findElement(pro2_email).clear();
	driver.findElement(pro2_email).sendKeys("jiomart@gmail.com");
	Thread.sleep(3000);
	
	
	
	driver.findElement(pro2_xpath3).click();
	Thread.sleep(3000);
	
	name=driver.findElement(pro2_xpath1).getText();
	email=driver.findElement(pro2_xpath1).getText();
	phone=driver.findElement(pro2_xpath2).getText();


	System.out.println(name);
	System.out.println(email);
	System.out.println(phone);
	}
	
	
}

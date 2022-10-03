package mainpackage;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SuiteRunner;
import org.testng.TestNG;
import org.testng.collections.Lists;

import practice.jiomart.cart;
import practice.jiomart.search_filter;
public class mainjiomart extends search_filter {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
// System.setProperty("webdriver.gecko.driver", "D:\\Firefoxdriver\\geckodriver.exe");
// FirefoxDriver driver = new FirefoxDriver();
//
// driver.manage().window().maximize();
// driver.get("https://www.jiomart.com/");
search_filter s=new search_filter();
// add_to_cart a=new add_to_cart();
// s.connect(driver);
// a.connect(driver);
TestNG testng = new TestNG();
List<String> suites = Lists.newArrayList();
//suites.add("C:\\Users\\shivani_kulkarni2\\eclipse-workspace\\jiomart\\testng.xml");//path to xml..
suites.add("C:\\Users\\shivani_kulkarni2\\eclipse-workspace\\jiomart\\testngnew.xml");//path to xml..
testng.setTestSuites(suites);
testng.run();
// s.beforeTest(driver);
// s.login();
// s.f();



}

}
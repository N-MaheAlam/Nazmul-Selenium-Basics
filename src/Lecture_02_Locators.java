import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*-
 * 
 *  if you try to run all this code together it may show errors.
 *  try to one bye one after line number 30
 *  driver.get("https://rahulshettyacademy.com/locatorspractice/");
 */

public class Lecture_02_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		// This helps to wait at least for 5 seconds to get any kind of information from
		// the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// getting the web page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Putting a value("Nazmul Mahe Alam") in an input field where
		// we catch the input by its "id" (attribute) and the id value is
		// "inputUsername"
		driver.findElement(By.id("inputUsername")).sendKeys("Nazmul Mahe Alam");

		// Putting a value("Nazmul Mahe Alam") in an input field where
		// we catch the input by its "name" (attribute) and the id value is
		// "inputPassword"
		driver.findElement(By.name("inputPassword")).sendKeys("12345");

		// Clicking in a button by its class Name "signInBtn". There can be multiple
		// class name but we have to select only
		// the unique one. Here "signInBtn" is the unique class name among all other
		// class names on that particular
		// attribute
		driver.findElement(By.className("signInBtn")).click();

		// Here we are using cssSelector a method to uniquely identify a particular
		// html. To write a correct cssSelector
		// we can use "tagname.class" or "tagname#id"
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();

		// When selenium will click on "For got your password" then it will wait at
		// least 1000 mili seconds (1 second)
		// to change the format in that page becuase in react and angular, multiple
		// changes happen in a single url
		Thread.sleep(1000);

		// We use the xPath locators and we write this syntax like "//tagname[@attribute
		// ='attributename']'"
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Montreal");

		// using a different format of cssSelector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("nalam@gmail.com");

		// using a different format of xpath
		driver.findElement(By.xpath("(//input[@placeholder='Phone Number'])[1]")).sendKeys("123456");

		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());

	}

}

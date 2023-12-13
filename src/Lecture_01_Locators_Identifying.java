import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*-
 * This just a normal description of how to automate a website.
 * website contents can be changed according to the owner decision 
 * I am not responsible for anything wrong here of wrong use
 * I just use it to educate myself and others to understand  
 */

public class Lecture_01_Locators_Identifying {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out

		// 1st argument is which webdriver I am going to use like chorme or firefox or
		// another
		// 2nd argument is the path of folder where I Have installed my chrome webdriver
		System.setProperty("webdriver.chrome.driver", "/Users/nazmulmahealam/Desktop/Coding/QA/"
				+ "Selenium Test Automation/All Browers Driver/chromedriver");

		// Here "driver" is a WebDriver(Webdriver is an interface) object who is going
		// to use
		// the ChromeDriver()'s method that have come from WebDriver.
		// I Mean Webdriver interface has many abstract method which are implemented in
		// ChromeDriver
		// and this WebDriver type object "driver" has access to use all the method that
		// have come from Webdriver to
		// ChromeDriver() but this driver doesn't have access to the other methods of
		// ChromeDriver which are Chorome Drivers
		// personal Method
		WebDriver driver = new ChromeDriver();

		// An implicit wait , if anywhere anything is not displayed to load in the page
		// ,
		// selenium will wait for 5 seconds to load it properly and if it doesnt get
		// then it will declare it as a failure

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// the link where the automation will be performed
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// grapping that id and sending "rahul" on it ( as it a text box according to
		// the website0
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		// grapping that id and sending "hello123" on it ( as it a password box
		// according to the website0
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");

		// click the sign in button
		driver.findElement(By.className("signInBtn")).click();

		// get the error text and print it in console
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// click the link text
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);//

		// This a way to write a unique xpath for a certain html element
		// - //tageName[@attributeName ='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

		// This a way to write a unique Css Selector path for a certain html element
		// - tageName[attributeName ='value']
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		// This a way to write a unique xpath for a certain html element
		// - //tageName[@attributeName ='value' indexNo]
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		// This another way to write a unique xpath for a certain html element
		// - //tageName[@attributeName ='value' childNo]
		// This is almost same like above index but parent child relationship
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

		// This another way to write a unique xpath for a certain html element
		// - //parentTageName/childTagName indexNo
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		// This a way to write a unique Css Selector path for a certain html element
		// - .className
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// prenttag childTag
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		// --//parenttagLocator/childTagName indexNo
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);

		// #IDName
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		// match the "pass" only a type value then rest of it("word") don't need to
		// match
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		// id
		driver.findElement(By.id("chkboxOne")).click();

		// xpath for a button which class contains "submit"
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

}

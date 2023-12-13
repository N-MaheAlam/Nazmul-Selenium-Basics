import java.time.Duration;
/*-
 * 
 * If there is No comment on any locator, check the first Lecture "Lecture_01_Locators_Identifying"
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_02_Locators_Practice {

	public static void main(String[] args) throws InterruptedException {

		String name = "rahul";
		System.setProperty("webdriver.chorme.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c1 = new ChromeDriver();
		c1.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		c1.manage().window().maximize();
		c1.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(c1);
		Thread.sleep(1000);
		
		
		// Click on go to login button from reset password page
		c1.findElement(By.xpath("//button[text()='Go to Login']")).click();
		Thread.sleep(1000);
		
		// put the user name "rahul" as mentioned in variable "name" above
		c1.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		Thread.sleep(1000);
		
		//deliver the password that we have obtained from "getPassword" method
		c1.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Thread.sleep(1000);
		
		//click on submit button
		c1.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(1000);
		
		// Get the text "You are successfully logged in." & print in 
		// console
		System.out.println(c1.findElement(By.tagName("p")).getText());
		Thread.sleep(1000);
		
		// Check if the text message we got is same as we have mentioned below in Assert.
		// If same, then pass that line & control goes to the next line
		Assert.assertEquals(c1.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Thread.sleep(1000);
		
		// Print "Hello rahul" to the console.
		System.out.println(c1.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Thread.sleep(1000);
		
		// Match if the value of "Hello rahul" is same as the second argument 
		Assert.assertEquals(c1.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		Thread.sleep(1000);

		// Click on log out button
		c1.findElement(By.xpath("//button[text()='Log Out']")).click();
		Thread.sleep(1000);

		//
	}

	// with this method I am grabbing a text from website and splitting that text to
	// find my password
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		
		// Click on forget password
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		// Click on "Reset Login" button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);

		// Storing "Please use temporary password 'rahulshettyacademy' to Login."
		String wholeText = driver.findElement(By.xpath("(//p[@class='infoMsg'])[1]")).getText();

		// divied into "Please use temporary password" and "rahulshettyacademy' to
		// Login."
		String[] divideText = wholeText.split("'");
		

		// dividing the divideText index 1 into multiple indexes and only storing new
		// index 0 in password string
		String password = divideText[1].split("'")[0];
		return password;
	}
}

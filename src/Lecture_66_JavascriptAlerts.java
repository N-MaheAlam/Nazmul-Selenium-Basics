import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_66_JavascriptAlerts {

	public static void main(String[] args) throws InterruptedException {

		String nameVariable = "Nazmul";
		String nameVariable2 = "Alam";
		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c6 = new ChromeDriver();
		c6.get("https://rahulshettyacademy.com/AutomationPractice/");

		c6.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// --------LECTURE 66-----(JavaScript Alert handing) ----//

		System.out.println("--------LECTURE 66-----(JavaScript Alert handing)---------");
		// Sending Value "Nazmul"
		c6.findElement(By.id("name")).sendKeys(nameVariable);
		Thread.sleep(1000);

		// Clicking Alert Button
		c6.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);

		// converting webdriver into alert to Grab the text of Javascript message and
		// printing it
		System.out.println(c6.switchTo().alert().getText());
		

		// pressing the OK button in javascript alert
		c6.switchTo().alert().accept();
		Thread.sleep(1000);

		// Sending Value "Alam"
		c6.findElement(By.id("name")).sendKeys(nameVariable2);
		Thread.sleep(1000);

		// Click confirm button
		c6.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);

		// grab the text from the Javascript Pop Up and print
		System.out.println(c6.switchTo().alert().getText());

		// click to cancel button
		c6.switchTo().alert().dismiss();

		// ----------00000----------------//

		///
	}

}

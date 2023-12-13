
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_07_Scrolling_ValuePrintingOfRow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().fullscreen();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println("------Top Left Table-----");

		// printing the total size of table row size of "Web Table Example"
		System.out.println(
				"Total Row: " + d.findElements(By.xpath("//table[@class='table-display'][1]/tbody/tr")).size());

		// Storing the table data of each column of table row 3 in a list
		List<WebElement> eachValueOfRow3 = d
				.findElements(By.xpath("//table[@class='table-display'][1]/tbody/tr[3]/td"));

		// get the text of each table data and print it on console
		for (int i = 0; i < eachValueOfRow3.size(); i++) {
			System.out.println(eachValueOfRow3.get(i).getText());
		}
	}// Main method

}

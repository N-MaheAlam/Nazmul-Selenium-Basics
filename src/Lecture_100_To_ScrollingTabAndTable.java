import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_100_To_ScrollingTabAndTable {

	public static void main(String[] args) throws InterruptedException {

		

		WebDriver d = new ChromeDriver();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().fullscreen();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// create a javaScript variable to use it for javascript operations in selenium
		JavascriptExecutor js = (JavascriptExecutor) d;

		// scroll the page to down
		js.executeScript("window.scrollBy(0,500)");
		

		Thread.sleep(1000);

		// there is a table with a class name "tableFixHead" and now I am scrolling it
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// scrolling table 's last column storing in a list
		List<WebElement> tableData = d.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));

		int sum = 0;
		for (int i = 0; i < tableData.size(); i++) {

			// converting text into integer
			sum = sum + Integer.parseInt(tableData.get(i).getText().trim());

		}
		// printing total value of those columns
		System.out.println(sum);

		// getting the whole text of that class ["Total Amount Collected: 296"]
		System.out.println(d.findElement(By.className("totalAmount")).getText());

		// trimmed , split , collect index 1, trim() which will give 296
		String netAmount = d.findElement(By.className("totalAmount")).getText().trim().split(":")[1].trim();

		// converting String value into integer so that we can compare two values of the
		// website
		int netAmountInteger = Integer.parseInt(netAmount);
		System.out.println(netAmount);

		// equalling both collected value from the website and if the actual value is
		// same as expected
		// then it will pass the text without any error
		Assert.assertEquals(sum, netAmountInteger);

		System.out.println("------Top Left Table-----");

		// printing the total size of table table row
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

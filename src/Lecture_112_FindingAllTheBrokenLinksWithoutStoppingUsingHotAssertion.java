
//public class Lecture_112_FindingAllTheBrokenLinksWithoutStoppingUsingHotAssertion {

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Lecture_112_FindingAllTheBrokenLinksWithoutStoppingUsingHotAssertion {

	public static void main(String[] args) throws IOException {

		

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// get the url of href attribute
		System.out.println(
				"URL of that class: " + d.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href"));

		// storing the attribute value
		List<WebElement> urls = d.findElements(By.cssSelector("li[class='gf-li'] a"));

		// We already know about assertion when we try to compare two things
		// there are hot and soft assertion. Hot assertion immediately fails the test
		// when the actual result
		// is not same as expected. But in soft assertion, if the script gets errors, it
		// executes the test till last
		// and then it shows in console the failures
		SoftAssert chekAllLink = new SoftAssert();

		// its an enhanced for loop
		for (WebElement url : urls) {

			String urlMain = url.getAttribute("href");

			HttpURLConnection con = (HttpURLConnection) new URL(urlMain).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int val = con.getResponseCode();
			System.out.println(val);

			chekAllLink.assertTrue(val < 400, "The link: " + url.getText() + " Response Code " + val);
			

			/*-
			if (val > 400) {
			
				System.out.println("The link: " + url.getText() + " Response Code " + val);
				Assert.assertTrue(false);
			} // if
			*/

		} // for loop

		// after scanning all the links it will capture the failures and will show in
		// console.
		chekAllLink.assertAll();

	}// Main Method

}

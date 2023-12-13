import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_111_FindingArokenLinkByHotAssert {

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

		for (WebElement url : urls) {

			String urlMain = url.getAttribute("href");

			HttpURLConnection con = (HttpURLConnection) new URL(urlMain).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int val = con.getResponseCode();
			System.out.println("Value : " + val);

			if (val > 400) {

				System.out.println("The link: " + url.getText() + " Response Code " + val);
				Assert.assertTrue(false);
			} // if
		} // for loop

	}// Main Method

}

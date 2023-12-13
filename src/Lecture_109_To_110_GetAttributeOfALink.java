import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_109_To_110_GetAttributeOfALink {

	public static void main(String[] args) throws MalformedURLException, IOException {

		
		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// get the url of href attribute
		System.out.println(
				"URL of that class: " + d.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href"));

		// storing the attribute value
		String url = d.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href");

		// creating and Http connection opening the connection
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

		// Requesting a method which is HEAD type (it can be GET,POST,HEAD etc type)
		conn.setRequestMethod("HEAD");

		// now connecting to the url
		conn.connect();

		// get a reponse code is good or bad ( bad is greater than 400 and below are
		// good,
		int resCode = conn.getResponseCode();

		// printing response code 301
		System.out.println("Response type of this url is : " + resCode);

	} // main method

}

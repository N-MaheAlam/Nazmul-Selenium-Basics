
//public class Lecture_118_StreamAPI_paggination {

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_118_StreamAPI_paggination {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// click on the link
		d.findElement(By.xpath("//thead/tr/th[1]")).click();

		// Store web elements into the list

		List<WebElement> list = d.findElements(By.xpath("//tbody/tr/td[1]"));
		// using stream API pass list into the stream then using map get the text , then
		// collect the texts
		// and collect these intoa new list which is "orginalList"
		List<String> orginalList = list.stream().map(m -> m.getText()).collect(Collectors.toList());

		// "orginalList" pass through stream the sort and collect in a new list call
		// "sortedOrginalList"
		List<String> sortedOrginalList = orginalList.stream().sorted().collect(Collectors.toList());

		// Compare the value it its true then pass the test if fails then show errors
		Assert.assertTrue(orginalList.equals(sortedOrginalList));

		System.out.println("========Lecture 118===============");

		List<String> price;

		do {
			List<WebElement> list2 = d.findElements(By.xpath("//tbody/tr/td[1]"));
			// passing list into stream, then using filter getting text and if it contains
			// "Beans"
			// we are calling the below method , then collectiing the values as a list and
			// storing in "price"
			price = list2.stream().filter(s -> s.getText().contains("Strawberry")).map(p -> getPrice(p))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				d.findElement(By.cssSelector("a[aria-label='Next']")).click();
				Thread.sleep(1000);
			}

		} while (price.size() < 1);

	}

	public static String getPrice(WebElement l) {

		// --->// tbody/tr/td[1]/following-sibling::td[1]
		// above is the whole path but as we have given has path on "list" , we are just
		// showing the rest of the path
		// because when we are calling the method its already have the half
		// path(//tbody/tr/td[1]) check line
		// 33,(list -variable)
		String price = l.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}

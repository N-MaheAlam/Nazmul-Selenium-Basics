import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_120_StreamUsingToSearchBar {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// send Rice value to the search bar of that page
		d.findElement(By.id("search-field")).sendKeys("Rice");

		// collect all the elements which matches with rice
		List<WebElement> vegies = d.findElements(By.xpath("//tr/td[1]"));

		// print that list of collected rice macthes values
		vegies.forEach(v -> System.out.println("Search List: " + v.getText()));

		// pass vegies into stream then filter the text of each web element if it
		// contains rice or not
		// then store the values in a new collection list filteredVegies
		List<WebElement> filteredVegies = vegies.stream().filter(v -> v.getText().contains("Rice"))
				.collect(Collectors.toList());

		// print each value of new list
		filteredVegies.forEach(f -> System.out.println("Filtered List: " + f.getText()));

		// if both list has same amount of value I mean if there size is same then it
		// will pass the test
		Assert.assertEquals(vegies.size(), filteredVegies.size());

	}

}

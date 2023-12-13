import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_73_DetailsOfAddToCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// Making full screen
		d.manage().window().fullscreen();

		// waiting 5 seconds to load the page
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String[] itemsNeeded = { "Carrot", "Beans", "Brinjal" };

		int j = 0;

		// Strong all elements in to this "cards" list
		List<WebElement> cards = d.findElements(By.cssSelector("h4.product-name"));
		
		System.out.println("List holdings total vegitables in website is : "+cards.size());

		// using for loop I am going to split the web element and matching with them
		// with the "itemsNeeded" array
		// then click on the item that matches the array
		for (int i = 0; i < cards.size(); i++) {

			// Splitting every web element by "-"
			String[] name = cards.get(i).getText().split("-");

			// Storing the first index and triming to remove any white space
			String formattedName = name[0].trim();

			// Converting itemsNeeded String array into List
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			// if list contains the string values one bye one
			if (itemsNeededList.contains(formattedName))

			{
				// in crease j value by one
				j++;

				// click on the button
				d.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// print the product name that has been clicked
				System.out.println(d.findElements(By.cssSelector("h4.product-name")).get(i).getText());

				// if j equals the length of String array then break
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

		//
	}
}

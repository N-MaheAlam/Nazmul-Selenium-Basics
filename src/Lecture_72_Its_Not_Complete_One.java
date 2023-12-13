
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_72_Its_Not_Complete_One {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c7 = new ChromeDriver();
		c7.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// To take wait to load the page at least 2 seconds
		c7.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// if the screen size is small, its going to make it full screen.
		c7.manage().window().fullscreen();

		String[] iteams = { "Cucumber", "Brocolli" };

		List<WebElement> cards = c7.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < cards.size(); i++) {
			String name = cards.get(i).getText();

			// convert iteams array into iteamsList ArrayList
			List<String> iteamsList = Arrays.asList(iteams);

			if (iteamsList.contains(name)) {
				c7.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				// we didn't use any break here beacuse in List we dont use it
			}

			/*----- when we compare with array not ArrayList
			 
			if (name.contains("Brocolli - 1 Kg")) {
				c7.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			
			} // condition
			
			*/

		} // loop
		Thread.sleep(1000);

		//
	}

}

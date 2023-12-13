import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* - 
 * This code doesn't select everything correctly because I have used "ADD TO CARD" text to find the xpath 
 * its not recommend to use text as xpath because text can be changed dynamically after any execution
 */

public class Lecture_70_To_ {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c7 = new ChromeDriver();
		c7.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// To take wait to load the page at least 2 seconds
		c7.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// if the screen size is small, its going to make it full screen.
		c7.manage().window().fullscreen();
		
		// Store all the vegitables title
		List<WebElement> cards = c7.findElements(By.cssSelector("h4.product-name"));

		// Iterate through List of Web Elements "cards" variable
		for (int i = 0; i < cards.size(); i++) {
			String name = cards.get(i).getText();
			

			// if the any of the card list value is same as "Brocolli - 1 Kg", then
			// click the Add to cart button then break the loop
			if (name.contains("Brocolli - 1 Kg")) {
				c7.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;

			} // condition

		} // loop
		Thread.sleep(1000);

		for (int i = 0; i < cards.size(); i++) {
			String name = cards.get(i).getText();

			// if the any of the card list value is same as "Cucumber - 1 Kg", then
			// click the Add to cart button then break the loop
			if (name.contains("Cucumber - 1 Kg")) {
				c7.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;

			} // condition

		} // loop
		Thread.sleep(1000);
		
		for(int i =0; i < cards.size(); i++) {
			String name = cards.get(i).getText();
			
			// if the any of the card list value is same as "Apple - 1 Kg", then
			// click the Add to cart button then break the loop
			if(name.contains("Apple - 1 Kg")){
				c7.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			} // if ends
		}// for loop
		
		// when all the products had been clicked , then store the total "item" number from
		// cart in "cartValue" variable
		 String cartValue = c7.findElement(By.xpath("//div/table/tbody/tr[1]/td[3]")).getText();
		 // print the total Item number
		 System.out.println("Total Items in card: "+cartValue);

		//
	}

}

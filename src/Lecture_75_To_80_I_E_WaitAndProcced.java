import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lecture_75_To_80_I_E_WaitAndProcced {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		WebDriverWait waitToLoad = new WebDriverWait(d, Duration.ofSeconds(5));

		// Making full screen
		d.manage().window().fullscreen();

		// waiting 5 seconds to load the page
		// d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String[] VegiArray = { "Mushroom", "Beans", "Brinjal", "Onion" };

		// Calling method
		clickVegiTable(d, VegiArray);

		//click on Shopping button
		d.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//proceed to checkout button
		d.findElement(By.cssSelector("div[class='action-block'] button[type='button']")).click();
		//wait until the promo code text field is appeared
		waitToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		
		//send the value "NazmulMahe"
		d.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("NazmulMahe");

		d.findElement(By.className("promoBtn")).click();
		//Wait Untill the promo code " Invalid code..!" appear
		waitToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		// get the text and print it in console.
		System.out.println(d.findElement(By.className("promoInfo")).getText());

	} // main method

	// this method performs to select all the items in an array
	public static void clickVegiTable(WebDriver d, String[] arr) {
		
		// Store all the product name in this list "vegiName"
		List<WebElement> vegiName = d.findElements(By.cssSelector("h4.product-name"));

		// declare a variable outside the loop
		int j = 0;
		
		// iterate till the vegetable size
		for (int i = 0; i < vegiName.size(); i++) {

			// Store vegetables  name in String array where name will be divided 
			// by "-" and will be stored in index
			String[] fullName = vegiName.get(i).getText().split("-");
			// trim the vegetables name if is there any white space
			String name = fullName[0].trim();

			// convert "arr" into List
			List<String> VegiArryToList = Arrays.asList(arr);

			// if "VegiArryToList" contains "name"
			if (VegiArryToList.contains(name)) {

				j++;
				// click on "Add to Cart" button
				d.findElements(By.cssSelector("div[class='product-action'] button[type='button']"))
				.get(i).click();
				//print the full title name of the product
				System.out.println(d.findElements(By.cssSelector("h4.product-name")).get(i).getText());

				if (j == VegiArryToList.size()) {
					break;
				} // 2nd if

			} // 1st if

		} // for loop

	}// Method closed

}

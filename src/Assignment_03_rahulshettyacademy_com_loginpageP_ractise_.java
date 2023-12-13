import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*-
 * I used an extra work where I have removed a product from cart
 * 
 */

public class Assignment_03_rahulshettyacademy_com_loginpageP_ractise_ {

	public static void main(String[] args) throws InterruptedException {

		
		//setting the web driver & its location
		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		
		// go to this rahulshetty web site
		d.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		// make the window bigger
		d.manage().window().maximize();
		Thread.sleep(1000);

		//user name send
		d.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		
		//password send
		d.findElement(By.id("password")).sendKeys("learning");
		Thread.sleep(1000);
		
		// click on "user radio" button
		d.findElement(By.xpath("//label[@class='customradio'] [2]")).click();
		Thread.sleep(1000);

		
		WebDriverWait wai = new WebDriverWait(d, Duration.ofSeconds(10));
		
		//Wait untill "OKAY" button pops up
		wai.until(ExpectedConditions.elementToBeClickable(d.findElement(By.cssSelector(".btn.btn-success"))));
		

		//Get the "OKAY" button text
		System.out.println(d.findElement(By.cssSelector(".btn.btn-success")).getText());

		//Click on "Okay"
		d.findElement(By.cssSelector(".btn.btn-success")).click();
		Thread.sleep(1000);

		//Store Drop down menu locator into a WebElement
		WebElement a = d.findElement(By.xpath("//select[@data-style='btn-info']"));

		
		// Use Select class to store the WebElement "a" to perform various task
		Select sel = new Select(a);
		
		// Select the "Consultant" from drop down menu bye selecting the index
		sel.selectByIndex(2);
		

		//Click in terms & conditions button
		d.findElement(By.cssSelector("input[name='terms']")).click();
		Thread.sleep(1000);
		
		// Now, press the "Sign In" Button
		d.findElement(By.cssSelector("input[type='submit']")).click();
		
		// Wait now until all the cards are present in Web Page by checking the 
		// "Add" button
		wai.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".card.h-100")));

		
		// Store all the "Add" buttons in this List
		List<WebElement> allCards = d.findElements(By.cssSelector(".btn.btn-info"));

		// Now, Using the for loop to click in each button & print 
		// the text of card title such as "iPhone X"
		for (int i = 0; i < allCards.size(); i++) {

			d.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
			Thread.sleep(1000);
			System.out.println(d.findElements(By.cssSelector("h4.card-title")).get(i).getText());

		} // for loop

		//Then, press the "checkout" button
		d.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		Thread.sleep(1000);

		//An item will be removed from the card but before that print the item which you would
		//like to remove [Nokia Edge]
		System.out.println("Removed Item : " + d.findElements(By.cssSelector(
				"div.container div.row div.col-sm-12.col-md-10.col-md-offset-1 table.table.table-hover "
				+ "td.col-sm-8.col-md-6:nth-child(1) "
						+ "div.media div.media-body h4.media-heading:nth-child(1) > a:nth-child(1)"))
				.get(2).getText());
		
		
		// click the remove button of "Nokia Edge"
		d.findElements(By.cssSelector(".btn.btn-danger")).get(2).click();
		Thread.sleep(1000);
		
		//After that, press the "checkout" button of that page
		d.findElement(By.cssSelector(".btn.btn-success")).click();
		Thread.sleep(1000);

		
		//When it will go to the next page, In text box, "a" will be send &
		// few suggestion of countries will pop up which has a letter "a"
		d.findElement(By.id("country")).sendKeys("a");
		wai.until(ExpectedConditions.presenceOfElementLocated(By.className("suggestions")));
		//// a[contains(text(),'Bangladesh')]

		// Store all the Web elements means, that has a tag of "a"
		List<WebElement> countries = d.findElements(By.tagName("a"));

		// print the total tag "a" present in that page
		System.out.println(countries.size());
		
		// print the country name in console
		countries.forEach(country -> System.out.println(country.getText()));

		//Now, run a for loop which will get the text of each country as well as will
		// match with "Bangladesh" and In addition it will ignore the case.
		// Once it finds Bangladesh, click on that.
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("Bangladesh")) {
				country.click();
				break;
			}
		} // for loop

		// Click on terms & conditions button
		d.findElement(By.xpath("//body/app-root[1]/app-shop[1]/div[1]/app-checkout[1]"
				+ "/div[1]/div[2]/label[1]")).click();
		
		// click on Purchase button
		d.findElement(By.xpath("//input[@value='Purchase']")).click();
		Thread.sleep(5000);
		
		// After click on purchase button a success message will pop up & get that message
		System.out.println(d.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}// Main Method

}

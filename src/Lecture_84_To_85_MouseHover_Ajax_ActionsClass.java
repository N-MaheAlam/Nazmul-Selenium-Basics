import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lecture_84_To_85_MouseHover_Ajax_ActionsClass {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		d.get("https://www.amazon.ca");
		d.manage().window().fullscreen();

		// this class we need when we try to perform something by automation like hover,
		// accessing the keys vaia selenium

		Actions act = new Actions(d);

		// Just moving my mouse in a specific location by my selenium webdriver control.
		// to do that I have move my mouse by selenium
		// i mean Automation. then build the situation and perform the task
		act.moveToElement(d.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"))).build().perform();
		
		Thread.sleep(1000);

		// same like above
		act.moveToElement(d.findElement(
				By.xpath("//div[@id='nav-xshop-container']//a[@data-csa-c-content-id='nav_cs_newreleases']"))).build()
				.perform();
		Thread.sleep(1000);

		// moving my cursor, holding the shift key(To make the words in capital) typing
		// "Nazmul", double clicking the text building and performing
		act.moveToElement(d.findElement(By.cssSelector("div.nav-search-field "))).click().keyDown(Keys.SHIFT)
				.sendKeys("Nazmul").doubleClick().build().perform();

	}// Main method

}

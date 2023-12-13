import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_91_To_94_WebDriver_Scope_Defining {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// printing the total number of a tags in this page
		System.out.println("Total a tag in the page: " + d.findElements(By.tagName("a")).size());

		// selecting the footer section and storing as a web element in footerTotalLinks
		WebElement footerTotalLinks = d.findElement(By.id("gf-BIG"));

		// footerTotalLinks web element entering another elements and calculating
		// printing total a tag
		System.out.println("Total tag in footer: " + footerTotalLinks.findElements(By.tagName("a")).size());

		// selecting the Discount Coupons link selection of footer tag
		WebElement socialMediaFooter = footerTotalLinks.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));

		// printing all the a tag of Discount Coupons section(first left section)
		System.out.println("Social Media total Links: " + socialMediaFooter.findElements(By.tagName("a")).size());

		// int totalLinksInSocialSize =
		// socialMediaFooterTotalLinks.findElements(By.tagName("a")).size();

		for (int i = 1; i < socialMediaFooter.findElements(By.tagName("a")).size(); i++) {

			String newTabs = Keys.chord(Keys.COMMAND, Keys.ENTER);
			

// Lecture-- 92 ---socialMediaFooterTotalLinks.findElements(By.tagName("a")).get(i).click();

			socialMediaFooter.findElements(By.tagName("a")).get(i).sendKeys(newTabs);

			Thread.sleep(2000);
		} // for loop

		System.out.println("--------Title of every page-------");
		Set<String> storeTabs = d.getWindowHandles();
		Iterator<String> everyTab = storeTabs.iterator();

		while (everyTab.hasNext()) {

			d.switchTo().window(everyTab.next());
			System.out.println(d.getTitle());

		} // while loop

	} // Main Method

}

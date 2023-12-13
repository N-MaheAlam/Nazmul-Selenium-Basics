import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lecture_81_To_83_ExplicitWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(15));
		d.get("https://the-internet.herokuapp.com/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().fullscreen();
		d.findElement(By.linkText("Dynamic Loading")).click();
		w.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[class='example'] a[href='/dynamic_loading/2']")));

		d.findElement(By.cssSelector("div[class='example'] a[href='/dynamic_loading/2']")).click();

		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']//button")));

		d.findElement(By.xpath("//div[@id='start']//button")).click();

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(d).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement fool = fluentWait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())

					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				else
					return null;
			}
		});

		System.out.println(d.findElement(By.cssSelector("div[id='finish'] h4")).getText());

	}// Main Method

}

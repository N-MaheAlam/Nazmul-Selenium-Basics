import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*-
 * This sections talk about how to handle frames in a website.
 * frames are the things that when we  put an website inside a website such as in my personal website i put a frame section
 * where it will display how my linkedin profile looks like.
 */

public class Lecture_89_To_90_IframesExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();
		d.get("https://jqueryui.com/droppable/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// inside the website I giving control my selenium to inside frame
		d.switchTo().frame(d.findElement(By.cssSelector("iframe.demo-frame")));

		// storing a web element which will be dragged into a dropped box
		WebElement source = d.findElement(By.id("draggable"));

		// a drop box where the dropable box will be dropped
		WebElement dest = d.findElement(By.cssSelector(".ui-widget-header.ui-droppable"));

		// Creating an Actions class instance to use the method drag and drop
		Actions act = new Actions(d);

		// now drag and dropping and building the code and performing the code
		act.dragAndDrop(source, dest).build().perform();

		// Switching back to the main website from iframe.
		d.switchTo().defaultContent();

	}

}

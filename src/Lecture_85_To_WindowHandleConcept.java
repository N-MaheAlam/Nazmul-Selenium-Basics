
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Lecture_85_To_WindowHandleConcept {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");
		//WebDriverManager.chromedriver().setup();

		WebDriver d = new ChromeDriver();
		d.get("https://rahulshettyacademy.com/loginpagePractise/#");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Click on the blinking top-right text
		d.findElement(By.cssSelector(".blinkingText")).click();

		// Storing all the windows parent child windows all such as ( when we click on
		// something it, Opens in a new window
		// so the new window is called the child window and from the window it was
		// opened is called the parent window

		// Here Storing all the windows including parent and child
		Set<String> windows = d.getWindowHandles();

		// Iterator class which selects all the indexes of "windows" Set to perform some
		// steps
		Iterator<String> goPlease = windows.iterator();

		// Here I am going to the first index of windows and storing in parentId to use
		// later to perform some steps
		String parentId = goPlease.next();
		

		// this is the 2nd index of windows and storing in "childId" to use it in later
		// purpose
		String childId = goPlease.next();

		// Taking my selenium driver control from parent window to child window so that
		// I can control like click, send text etc
		d.switchTo().window(childId);

		// collecting text from my child window and printing in console
		System.out.println(d.findElement(By.cssSelector(".im-para.red")).getText());

		// collecting text from child window
		d.findElement(By.cssSelector(".im-para.red")).getText();

		// first collecting the text,then spliting the text in "at" and taking index 1,
		// then trimming the whole text to remove
		// white space from first and last, then splitting the rest String by white
		// space (" ") inside of it like(Nazmul Mahe Alam)
		// colleting the index 0 and its done.
		String emailId = d.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

		// Now switching my driver control from child window to parent window. here
		// "parentId" just a variable name
		d.switchTo().window(parentId);
		d.findElement(By.id("username")).sendKeys(emailId);
	}

}

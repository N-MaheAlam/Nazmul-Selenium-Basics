import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_125_Multiple_Windows_Open_And_handle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/angularpractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// opening a blank new tab
		d.switchTo().newWindow(WindowType.TAB);

		// now there are two windows in browser one is main another is blank. storing
		// them in a set
		Set<String> allWindows = d.getWindowHandles();

		// creating an iteration when we will need we will iterate
		Iterator<String> allWindowsIterate = allWindows.iterator();

		// this the first window
		String parentWindowId = allWindowsIterate.next();

		// this is the second window
		String childWindowId = allWindowsIterate.next();

		// switching from main window to child window
		d.switchTo().window(childWindowId);

		// putting this url
		d.get("https://www.rahulshettyacademy.com/#/index");

		// getting the text from child window
		String nameOfCourse = d.findElements(By.xpath("//h2/a")).get(1).getText();

		// switching to parent window
		d.switchTo().window(parentWindowId);
		// putting the value that we have grabbed from child window to parent window
		d.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys(nameOfCourse);

	}

}

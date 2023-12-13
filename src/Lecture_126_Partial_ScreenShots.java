
//public class Lecture_126_Partial_ScreenShots {

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_126_Partial_ScreenShots {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/angularpractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d.switchTo().newWindow(WindowType.TAB);

		Set<String> allWindows = d.getWindowHandles();
		Iterator<String> allWindowsIterate = allWindows.iterator();

		String parentWindowId = allWindowsIterate.next();
		String childWindowId = allWindowsIterate.next();
		d.switchTo().window(childWindowId);
		d.get("https://www.rahulshettyacademy.com/#/index");
		String nameOfCourse = d.findElements(By.xpath("//h2/a")).get(1).getText();
		d.switchTo().window(parentWindowId);
		WebElement nameForm = d.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']"));
		nameForm.sendKeys(nameOfCourse);
		File srcFile = nameForm.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/Users/nazmulmahealam/Desktop/naz.png"));

		System.out.println(nameForm.getRect().getHeight());
		System.out.println(nameForm.getRect().getWidth());

	}

}

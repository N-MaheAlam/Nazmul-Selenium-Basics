



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmen_04_Windows_Handle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		d.get("https://the-internet.herokuapp.com/");
		
		// full screen the window
		d.manage().window().maximize();
		
		
		//wait at least 5 seconds to load the web page 
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Thread.sleep(1000);
		d.findElement(By.xpath("//a[@href='/windows']")).click();
		Thread.sleep(1000);
		d.findElement(By.cssSelector("body:nth-child(2) div.row:nth-child(2) "
				+ "div.large-12.columns:nth-child(2) div.example > a:nth-child(2)")).click();
		Thread.sleep(1000);

		Set<String> allWindowsTap = d.getWindowHandles();

		Iterator<String> goOneByOneWindow = allWindowsTap.iterator();

		String parentWindow = goOneByOneWindow.next();
		
		String childWindow = goOneByOneWindow.next();
		// String grandChildWindow = goOneByOneWindow.next();

		d.switchTo().window(childWindow);
		Thread.sleep(2000);

		System.out.println(d.findElement(By.xpath("//body/div[1]")).getText());
		Thread.sleep(2000);
		d.switchTo().window(parentWindow);
		Thread.sleep(2000);

		System.out.println(d.findElement(By.cssSelector("body:nth-child(2) div.row:nth-child(2) "
				+ "div.large-12.columns:nth-child(2) div.example > h3:nth-child(1)")).getText());

	}// Main Method

}

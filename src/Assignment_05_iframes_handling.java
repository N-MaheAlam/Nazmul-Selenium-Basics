import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_05_iframes_handling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium "
				+ "Test Automation/All Browers Driver/chromedriver");

		WebDriver d = new ChromeDriver();

		//Go to the web site
		d.get("https://the-internet.herokuapp.com/");
		
		//maximise the window
		d.manage().window().maximize();
		//wait for 5 seconds to load the page.
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//Click on "Nested Frame" button
		d.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		
		//Switch  from parent frame "Top" to the middle frame
		d.switchTo().frame("frame-top").switchTo().frame("frame-middle");
		
		System.out.println(d.findElement(By.id("content")).getText());
		
		//Now as the control is now in middle frame, it will switch the control 
		// to parent frame "Top". From there it will move to the right frame.
		d.switchTo().parentFrame().switchTo().frame("frame-right");
		
		// print the text in right frame.
		System.out.println(d.findElement(By.xpath("(//body)[1]")).getText());
		
		// Control from right frame will go to the top frame, then it will switch
		//"top" frames parent frame( the whole page), Next it goes towards the bottom
		//frame.
		d.switchTo().parentFrame().switchTo().parentFrame().switchTo().frame("frame-bottom");
		
		// Print everything which are present in bottom frame's body [BOTTOM]
		System.out.println(d.findElement(By.xpath("(//body)[1]")).getText());
		
		
		

	}// Main Method

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumClass01 {

	/*
	 * Here I have written some rules for which are created by me so that I becomes
	 * easier for anyone to read my code easily
	 * 
	 * RULE 01- inside the [] square brackets I am showing the output
	 * 
	 * 
	 */

	public static void main(String[] args) {

		// setting the 1st argument for the chrome driver inside the webdriver
		// interface
		// 2nd argument is for the path where we have installed the crhomedriver in our
		// // pc

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		// Creating an object of WebDriver() type where this Webdriver() 'drive01' will
		// have the all
		// implemented method of Webdriver() which are implemented in ChromeDriver()
		WebDriver driver01 = new ChromeDriver();

		// it will direct to the path of youtube.com in chrome browsers
		driver01.get("https://www.youtube.com");

		// printing the title of the web page [YouTube]
		System.out.println(driver01.getTitle());

		// it will show the exact output of the page [https://www.youtube.com/]
		// Bowers can lead you to the other links or other page but it will be directed
		// in the exact page
		System.out.println(driver01.getCurrentUrl());

		// it will close the current window
		driver01.close();

		// it will close all the window associated with this url
		driver01.quit();

		/*-  
		 below code is for Firefox, Almost same just the change of name 
		 
		 --------
		System.setProperty("webdriver.gecko.driver", "/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.oracletutorial.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		-------
		*/

		/*-
		System.setProperty("webdriver.edge.driver",
				"/Users/nazmulmahealam/Desktop/Selenium Test Automation/All Browers Driver/msedgedriver");
		
		WebDriver driver02 = new EdgeDriver();
		
		driver02.get("https://www.youtube.com");
		System.out.println(driver02.getTitle());
		System.out.println(driver02.getCurrentUrl());
		driver02.quit();
		
		*/

	}

}

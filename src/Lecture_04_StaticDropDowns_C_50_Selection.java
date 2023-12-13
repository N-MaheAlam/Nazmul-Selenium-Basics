import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Lecture_04_StaticDropDowns_C_50_Selection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c4 = new ChromeDriver();

		c4.get("https://rahulshettyacademy.com/dropdownsPractise/");

		c4.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		c4.manage().window().fullscreen();

		// Sorting a certain web sites element (this can be a tag, a box, a menus, a
		// buttons locators I mean address to
		// perform on it. Here I have stored a manual selectors location to perform
		// automation
		WebElement selectManu = c4.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));

		// Select class for a select manu in website. if there any select manu like
		// (country= BD,CAD,USA)
		// Those time we use "Select" class to perform automation
		Select dropDown = new Select(selectManu);

		Thread.sleep(500);
		// select the 3rd index from the select manus
		dropDown.selectByIndex(2);
		

		// print that selection
		System.out.println(dropDown.getFirstSelectedOption().getText());
		Thread.sleep(500);

		// select something according to value("USD)[ This value is HTML value not the
		// value that shown in the website
		dropDown.selectByValue("USD");

		// print value
		System.out.println(dropDown.getFirstSelectedOption().getText());
		Thread.sleep(500);

		// this according to the text shown in html
		dropDown.selectByVisibleText("Select");
		System.out.println(dropDown.getFirstSelectedOption().getText());

		//
	}

}

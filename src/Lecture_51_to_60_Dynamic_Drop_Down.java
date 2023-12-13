import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lecture_51_to_60_Dynamic_Drop_Down {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver c5 = new ChromeDriver();

		c5.get("https://www.google.com/");

		// To take wait to load the page at least 2 seconds
		c5.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// It will take you from google.com to rahulshettyacademy.com
		c5.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

		// if the screen size is small, its going to make it full screen.
		c5.manage().window().fullscreen();

		Thread.sleep(1000);

		// Click on the button "Adult"
		c5.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		// Print How many adults are automatic selected before increasing
		System.out.println("Before selection: " + c5.findElement(By.id("divpaxinfo")).getText());

		// Continue to increase the adult person until the i = 5
		int i = 1;
		while (i < 5) {
			c5.findElement(By.id("hrefIncAdt")).click();
			i++;
			Thread.sleep(1000);
		}

		// Click on the DONE button
		c5.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(1000);

		// print now how many adults are selected after the loop
		System.out.println("After Selection: " + c5.findElement(By.id("divpaxinfo")).getText());

		// new Line

		// ------- Dynamic drop down Start ------//

		Thread.sleep(1000);

		// It Clicks on "FROM" Button
		c5.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		Thread.sleep(1000);

		// dynamic drop down with index. This selects the "Delhi" from the "FROM" here
		// [1] is the index number of delhi
		// becasue there is another Delhi in "From " button which is index [2]
		c5.findElement(By.xpath("(//a[@value ='DEL'])[1]")).click();
		Thread.sleep(1000);

		// dynamic drop down with index This selects the "Jammu(IXJ)" from the "TO"
		// button.This selects
		// the "Jammu(IXJ)" from the "TO" here [2] is the index number of "Jammu(IXJ)"
		// becasue there is another "Jammu(IXJ)" in "From " button which is index [1]
		// This way writing xpath helps to identify the dynamic Xpath of a selection
		c5.findElement(By.xpath("(//a[@value ='IXJ'])[2]")).click();

		Thread.sleep(1000);
		// departure city

		// -- //a[@value='MAA'] this is the child xpath for

		// Again clicking on the "From " button
		c5.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		Thread.sleep(1000);

		//// -------LECTURE 55-----//////

		// -- //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] = this is parent
		// xpath the whole top down menu of
		// Departure city
		// ---// //a[@value='AIP'] this is the child xpath. both of these xpath parent
		// and child make this dyanmic selection
		// easy to test
		c5.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='AIP']")).click();
		Thread.sleep(1000);

		// Parent and chil xpath to test dynamic selections
		c5.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']"))
				.click();
		Thread.sleep(1000);
		/// ------ LECTURE 56-----///

		// Send value "can" in search bar at the top-left
		c5.findElement(By.id("autosuggest")).sendKeys("can");
		Thread.sleep(1000);

		// here I use "findElements" not "findElement" ( plural not singular) because it
		// will select here
		// multiple values thats
		List<WebElement> options = c5.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		System.out.println("---------Lecture 56---------");

		// Printing each value of options array that we have collected from web search
		// suggestion
		options.forEach(option -> System.out.println(option.getText()));

		// when we put "can" in search bar we run an loop and if we found "Canada" ,
		// ignore the case and put it in search ber and break the loop
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("canada")) {
				option.click();
				break;
			}
		}
		Thread.sleep(1000);

		// ----------00000----------------//

		/// ----------LECTURE 58---------//

		System.out.println("---------Lecture 58---------");

		// checks and prints the boolean value false as it is not selected "Indian Arm Forces" check box
		System.out.println("Prints FALSE as it is not selected: "
				+ c5.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		c5.findElement(By.cssSelector("input[id*='IndArm']")).click();
		Thread.sleep(1000);

		// Checks and prints boolean value true as it is selected
		System.out.println("Prints TRUE as it is  selected: "
				+ c5.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Thread.sleep(1000);

		// print how many check boxes are there
		System.out.println(
				"Total number of Check boxex : " + c5.findElements(By.cssSelector("input[type='checkbox']")).size());
		Thread.sleep(1000);

		// ----------END OF 58----------------//

		/// ---------- START LECTURE 59---------//

		// I am expecting false. If it is false then the test will pass perfectly but
		// this statement is wrong so it
		// will through an expection --"expected [false] but found [true]"-----

		// - Its a code ---
		// Assert.assertFalse(c5.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());

		// I am expecting TRUE.If it is true then the test will pass perfectly
		Assert.assertTrue(c5.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		///

	}

}

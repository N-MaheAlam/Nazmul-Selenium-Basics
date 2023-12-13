import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_122_To_Selenium_Version_4_New_Features_R_Locators {

	public static void main(String[] args) {

		

		WebDriver d = new ChromeDriver();

		d.get("https://rahulshettyacademy.com/angularpractice/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement boxName = d.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		System.out.println(d.findElement(with(By.tagName("label")).above(boxName)).getText());
		System.out.println(d.findElement(with(By.tagName("label")).below(boxName)).getText());

		WebElement leftBoxFinding = d.findElement(By.cssSelector("label[for='exampleCheck1']"));

		d.findElement(with(By.tagName("input")).toLeftOf(leftBoxFinding)).click();

		WebElement rightElement = d.findElement(By.id("inlineRadio1"));

		System.out.println(d.findElement(with(By.tagName("label")).toRightOf(rightElement)).getText());

	}

}

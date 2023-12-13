import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment02_rahulshettyacademy_com_angularpractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");

		WebDriver a2 = new ChromeDriver();

		a2.get("https://rahulshettyacademy.com/angularpractice/");
		a2.manage().window().maximize();
		a2.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//Send "Nazmul Mahe Alam" value to the label "Name"
		a2.findElement(By.xpath("//div[@class ='form-group'] //input[@name='name']")).sendKeys("Nazmul Mahe Alam");
		Thread.sleep(1000);

		//Send "nazmul@gmail.com" value to the label "Email"
		a2.findElement(By.cssSelector("input[name='email']")).sendKeys("nazmul@gmail.com");
		Thread.sleep(1000);

		//Send "12345" value to the label "Password"
		a2.findElement(By.xpath("//div[@class='form-group'] //input[@id='exampleInputPassword1']")).sendKeys("12345");
		Thread.sleep(1000);

		//click on "Check me out if you Love IceCreams" radio button
		a2.findElement(By.cssSelector("input[id ='exampleCheck1']")).click();
		Thread.sleep(1000);

		// Store the web element of "Gender" selection
		WebElement option = a2.findElement(By.id("exampleFormControlSelect1"));

		//create an object for select option "Gender" to pick the desire sex identifier
		Select s1 = new Select(option);
		
		//Pick the "Female" from gender selection
		s1.selectByIndex(1);
		Thread.sleep(1000);

		//press in "Student" radio button of "employee status"
		a2.findElement(By.id("inlineRadio1")).click();
		Thread.sleep(1000);

		//Place date of birth in "Date of birth" label
		a2.findElement(By.cssSelector("input[type='date']")).sendKeys("1994-01-12");
		Thread.sleep(1000);

		// click on "Submit" button
		a2.findElement(By.cssSelector(".btn.btn-success")).click();
		Thread.sleep(1000);
		
		// As our informations are correct in every field, A success message will pop up.
		//Grab that successful message and print it in console.
		System.out.println(a2.findElement(By.cssSelector(".alert-success")).getText());

		///
	}

}

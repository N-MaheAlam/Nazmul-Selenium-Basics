import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lecture_03_WindowsAcitivities_Size_Forward_back {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/Users/nazmulmahealam/Desktop/Coding/QA/Selenium Test Automation/All Browers Driver/chromedriver");
		WebDriver c3 = new ChromeDriver();

		// Maximising the broswer size
		c3.manage().window().maximize();
	
		c3.get("https://www.google.com/");
		Thread.sleep(1000);

		// from google , it navigates to facebook
		c3.navigate().to("https://www.facebook.com/");
		Thread.sleep(500);
		c3.findElement(By.xpath("//input[@id='email']")).sendKeys("Nazmul Mahe Alam");
		Thread.sleep(500);
		c3.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		Thread.sleep(500);
		// c3.findElement(By.xpath("//div[@id='u_0_c_pc']")).click();
		Thread.sleep(500);
		// c3.findElement(By.id("u_0_d_14")).click();
		System.out.println(c3.findElement(By.xpath("//button[@name='login']")).getText());
		
		// Shows the current page url (https://www.facebook.com/)
		System.out.println(c3.getCurrentUrl());

		//Print the title of the page "Facebook - log in or sign up"
		System.out.println(c3.getTitle());
		
		//Convert the c3 web driver chrome object in string which value is 
		// "ChromeDriver: chrome on mac (8481dad3818c31af43b6a566e7b610c1)"
		System.out.println(c3.toString()+"\n\n\n");
		
		// provides the page source of facebook that particular URL which is a long
		// html code 
		System.out.println(c3.getPageSource());
	

		///
	}

}

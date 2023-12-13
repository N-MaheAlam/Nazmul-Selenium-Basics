import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lecture_104_To_108_UnSecureWebsiteGoing_HTTP {

	public static void main(String[] args) throws IOException {

		// when we try to put some behaviour in the broswer those time we use this
		// options
		// For Edge - EdgeOptions
		// For FireFox - FirefoxOptions
		// For safari - SafariOptions

		ChromeOptions option = new ChromeOptions();
		// make it true so that the browser can access in an insecure website
		option.setAcceptInsecureCerts(true);

		

		// put the behaviour in the arguement
		WebDriver d = new ChromeDriver(option);

		// maximize the broswer
		d.manage().window().maximize();

		// to delete all the cookies for the automation in browser
		d.manage().deleteAllCookies();

		// such as when we log out and try to click a page, it should show log in
		// I have to see a little video about it than I will put the full description
		d.manage().deleteCookieNamed("put the name");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.get("https://expired.badssl.com/");

		System.out.println(d.getTitle());

		
		// It Takes the screen shots
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		// it stores in the destination place
		FileUtils.copyFile(src, new File("/Users/nazmulmahealam/Desktop/my.png"));

	}

}

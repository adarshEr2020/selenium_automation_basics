package automation.fb;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakeScreenshot {

	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void takeScreenshot() throws IOException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
//		screen shots------------>
		Date d = new Date();
		String currentdate = d.toString().replaceAll(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".//screenshots//"+currentdate + "sign_page.png");
		Files.copy(srcFile, destFile);
	}

}

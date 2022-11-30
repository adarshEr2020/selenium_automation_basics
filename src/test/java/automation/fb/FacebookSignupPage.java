package automation.fb;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;

public class FacebookSignupPage {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void signupPage() throws InterruptedException, IOException {

//		System.setProperty("webdriver.chrome.driver",
//				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(3000);

//		--------SIGNUP PAGE------------------->
//		--------first name-------------------->

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("adarsh");

		WebElement lNameEle = driver.findElement(By.xpath("//input[@name='lastname']"));
		lNameEle.sendKeys("prajapati");

		WebElement regEmailEle = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		regEmailEle.sendKeys("afs@gmail.com");

		WebElement reEnterEmailEle = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		reEnterEmailEle.sendKeys("afs@gmail.com");

		WebElement regPasswdEle = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		regPasswdEle.sendKeys("42121212");

//		------date of birth-------
		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("12");
		driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Oct");
		driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("2000");

//		--------Gender------------->
		driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();

//		--------signup-------------->
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(2000);

//		screen shots------------>
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".//screenshots//" + "signup_page.png");
		Files.copy(srcFile, destFile);
		driver.close();
	}

	
//	-------text() function---------------------------------->
	@Test
	public void xpath_text_function() throws InterruptedException {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();	 

	}

//	-------contains() function-----
	@Test
	public void xpath_contains_function() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();	
		Thread.sleep(3000);
	}
	
//	------starts-with()------------------------------------->
	@Test
	public void xpath_startwith() throws InterruptedException {
		driver.findElement(By.xpath("//a[starts-with(text(),'Create New Account')]")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
}

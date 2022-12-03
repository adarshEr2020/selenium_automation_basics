package automation.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptExecutor {
	public static ChromeDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public static void enterText_intoDisabledTextbox() throws InterruptedException {

		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/test.html");
		// Typecast the driver object to JavascriptExecutor interface type
		ChromeDriver js = driver;
		Thread.sleep(2000);

//		 enter "admin" in first textbox using javascript
		js.executeScript("document.getElementById('t1').value='adarsh'");
		Thread.sleep(2000);

		// clear the value
		js.executeScript("document.getElementById('t2').value=''");
		Thread.sleep(2000);
		// enter "login"
		js.executeScript("document.getElementById('t2').value='login'");
		Thread.sleep(2000);

		// change the second text box to button type
		js.executeScript("document.getElementById('t2').type='button'");
		Thread.sleep(2000);
	}

	@Test
	public static void ScrollUpandDow() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		ChromeDriver js = driver;

		// scroll down on the webpage
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);

		// scroll up on the webpage
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public static void ScrollUpandDowntospecificElementonWebpage() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		ChromeDriver js = driver;
		
		WebElement ele  = driver.findElement(By.id("u_0_5_sT"));
		
		// find the log in 
//		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		
		// get the X-coordinate
		int x = ele.getLocation().getX();

		// get the Y-coordinate 
		int y = ele.getLocation().getY();

		// Scroll to log in element’s x and y coordinate
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
		Thread.sleep(3000);
	}
}

package automation.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frame {
	
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public static void frameUsingIndexAttribute() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/frame.html");
		driver.manage().window().maximize();
		
		//using index of the frame - [ int value] [ index of frames starts with zero]
		driver.switchTo().frame(0);
		Thread.sleep(2000);

		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).sendKeys("inner frame input");
		Thread.sleep(2000);
		
//		switch to main or default
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("t2")).sendKeys("outer frame input");
		Thread.sleep(2000);
		driver.quit();
		}
	@Test
	public static void frameUsingIdAttribute() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/frame.html");
		driver.manage().window().maximize();
		
		//using frame id
		driver.switchTo().frame("pframe");
		Thread.sleep(2000);

		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).sendKeys("inner frame input");
		Thread.sleep(2000);
		
//		switch to main or default
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("t2")).sendKeys("outer frame input");
		Thread.sleep(2000);
		driver.quit();
		}
	
	@Test
	public static void frameUsingNameAttribute() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/frame.html");
		driver.manage().window().maximize();
		
		//using frame name  -
		driver.switchTo().frame("frame1");
		Thread.sleep(2000);

		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).sendKeys("inner frame input");
		Thread.sleep(2000);
		
//		switch to main or default
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("t2")).sendKeys("outer frame input");
		Thread.sleep(2000);
		driver.quit();
		}
	
	@Test
	public static void frameUsingWebElement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/frame.html");
		driver.manage().window().maximize();
		
		//using web element -
		WebElement frameInput = driver.findElement(By.className("outer"));
		driver.switchTo().frame(frameInput);
		Thread.sleep(2000);

		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).sendKeys("inner frame input");
		Thread.sleep(2000);
		
//		switch to main or default
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.id("t2")).sendKeys("outer frame input");
		Thread.sleep(2000);
		driver.close();
		}
}

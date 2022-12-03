package automation.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementFunction {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void webElementFunctions() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
//		sendkeys()
		driver.findElement(By.cssSelector("[class='inputtext _55r1 _6luy']")).sendKeys("adarsh");
		
//		sleep()
		Thread.sleep(3000);
		
//		clear()
;		driver.findElement(By.cssSelector("[class='inputtext _55r1 _6luy']")).clear();
	}
	
	@Test
	public void isDisplayedFunction() {
		driver.get("https://www.facebook.com/");
		boolean isDisplayed = driver.findElement(By.name("email")).isDisplayed();
		System.out.println("is Displayed menthod return :"+ isDisplayed);
	}
	
	@Test
	public void isEnabledFunction() {
		driver.get("https://www.facebook.com/");
		boolean isEnabled = driver.findElement(By.cssSelector("[class='inputtext _55r1 _6luy']")).isEnabled();
		System.out.println("is enabled menthod return :"+ isEnabled);
	}
	
	@Test
	public void getTagNameFunction() {
		driver.get("https://www.facebook.com/");
		String getTagName = driver.findElement(By.name("email")).getTagName();
		System.out.println("getTagName menthod return :"+ getTagName);
	}
	
	@Test
	public void isSelectedFunction() {
		driver.get("https://www.facebook.com/");
		boolean isSelected = driver.findElement(By.cssSelector("[class='inputtext _55r1 _6luy']")).isSelected();
		System.out.println("isSelected menthod return :"+ isSelected);
	}
	
	@Test
	public void getAttributeFunction() {
		driver.get("https://www.facebook.com/");
		String getAttribute = driver.findElement(By.cssSelector("[class='inputtext _55r1 _6luy']")).getAttribute("name");
		System.out.println("getAttribute menthod return :"+ getAttribute);
	}
	
	@Test
	public void getSizeFunction() {
		driver.get("https://www.facebook.com/");
		Dimension getSize = driver.findElement(By.cssSelector("[id='pass']")).getSize();
		System.out.println("getSize width :"+ getSize.width);
		System.out.println("getSize width :"+ getSize.height);
		System.out.println("getSize getHeight :"+ getSize.getHeight());
		System.out.println("getSize getWidth :"+ getSize.getWidth());
		System.out.println("getSize toString :"+ getSize.toString());
	}	
	@Test
	public void getLocationFunction() {
		driver.get("https://www.facebook.com/");
		Point point  = driver.findElement(By.partialLinkText("log")).getLocation();
		System.out.println("X cordinate : " + point.x + "Y cordinate: " + point.y);
	}
	
	@Test
	public void submitFunction() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		 driver.findElement(By.name("email")).sendKeys("adarsh");
		 driver.findElement(By.cssSelector("[id='pass']")).sendKeys("1234566");
		 Thread.sleep(3000);
		driver.findElement(By.cssSelector("[type=submit]")).submit();
	}
	
}

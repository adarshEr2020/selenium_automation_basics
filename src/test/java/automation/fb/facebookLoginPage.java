package automation.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class facebookLoginPage {
	@Test
	public void loginPage() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		driver.manage().window().maximize();

		// find elements
		System.out.printf("title of the page is:  " + title + "\n");
		WebElement idEle = driver.findElement(By.id("email"));
		idEle.sendKeys("adarshprajapati");
		WebElement passEle = driver.findElement(By.id("pass"));
		passEle.sendKeys("123456789");
		WebElement loginEle = driver.findElement(By.name("login"));
		loginEle.click();
	}
	
//	css selector

	@Test
	public void loginPageCssSelecotor() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
//		Css selector by (id)
//		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("adarshprajapati");
		driver.findElement(By.cssSelector("#email")).sendKeys("adarshprajapati");
		
//		Css selector by (class)
		driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy _9npi']")).sendKeys("123456789");
//		driver.findElement(By.cssSelector(".inputtext _55r1 _6luy _9npi")).sendKeys("123456789");
		
//		Css selector by (value)
		driver.findElement(By.cssSelector("button[value='1']")).click();
		Thread.sleep(3000);
		
//		Css selector by (type)
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		Thread.sleep(3000);
		driver.close();
		
	}

}

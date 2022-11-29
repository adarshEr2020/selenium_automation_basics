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
		System.out.printf("title of the page is:  "+ title +"\n");
		WebElement idEle = driver.findElement(By.id("email"));
		idEle.sendKeys("adarshprajapati");
		WebElement passEle = driver.findElement(By.id("pass"));
		passEle.sendKeys("123456789");
		WebElement loginEle = driver.findElement(By.name("login"));
		loginEle.click();
	}
}

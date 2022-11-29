package automation.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookSignupPage {
	@Test
	public void signupPage() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement signuppElement = driver.findElement(By.linkText("Create New Account"));
		signuppElement.click();	 
		Thread.sleep(2000);
		
//		--------first name------
	    WebElement fNameEle = driver.findElement(By.xpath("//input[@name='firstname']"));
	    fNameEle.sendKeys("adarsh");
		 
		WebElement lNameEle = driver.findElement(By.xpath("//input[@name='lastname']"));
		lNameEle.sendKeys("prajapati");
		
		WebElement regEmailEle = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		regEmailEle.sendKeys("afs@gmail.com");
		
//		if(regEmailEle != null) {
			WebElement reEnterEmailEle = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
			reEnterEmailEle.sendKeys("afs@gmail.com");
//		}
		
		Thread.sleep(2000);
		
		
		WebElement regPasswdEle = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		regPasswdEle.sendKeys("42121212");
		
//		------date of birth-------
		
//		WebElement dayEle = driver.findElement(By.xpath("//select[@name='birthday_day']"));
//		dayEle.sendKeys("1");
//		
//		WebElement monthEle = driver.findElement(By.xpath("//select[@name='birthday_month']"));
//		monthEle.sendKeys("Oct");
//
//		WebElement yearEle = driver.findElement(By.xpath("//select[@name='birthday_year']"));
//		yearEle.sendKeys("2000");

		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("12");
		driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Oct");
		driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("2000");
		
//		Gender
		driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();
		
//		signup
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(2000);
	}
}

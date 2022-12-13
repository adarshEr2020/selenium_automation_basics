package automation.popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingJavascriptPopup {
	public static ChromeDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void alertPromptpopup() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		WebElement ele = driver.findElement(By.id("promtButton"));
		// get the X-coordinate
		int x = ele.getLocation().getX();
		// get the Y-coordinate
		int y = ele.getLocation().getY();

		// Scroll to promtButton element’s x and y coordinate
		driver.executeScript("window.scrollBy(" + x + ", " + y + ")");
		ele.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("adarsh");
		Thread.sleep(2000);
		String text = alert.getText();
		System.out.println("text  " + text);
		alert.accept();
		Thread.sleep(2000);
//		alert.dismiss();
	}

	@Test
	public void alertPopup() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
//		driver.close();
	}

	@Test
	public void confirmAlertBox() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("text" + alert.getText());
		alert.accept();	
//		alert.dismiss();
	}
}

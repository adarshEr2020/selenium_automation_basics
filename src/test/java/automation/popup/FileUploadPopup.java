package automation.popup;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadPopup {
	public static WebDriver driver;

	@BeforeTest
	public void drive() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	void fileUploadPopup() throws InterruptedException {	
		driver.get("https://www.filemail.com/share/upload-file");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@multiple='']"))
				.sendKeys("C:\\Users\\welcome\\Pictures\\Saved Pictures\\Screenshot_Emaill_2022-11.png");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sendBtn']/span")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	
	@Test
	public void fileUploadPopupByAutoit() throws InterruptedException, IOException {
		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		driver.manage().window().maximize();
		
		WebElement upload = driver.findElement(By.xpath("//span[@class='btn-label']"));
		upload.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\ADARSH Testing\\a.exe" + " " + "E:\\ADARSH Testing\\notes\\API_Testing_Document.pdf");
		Thread.sleep(2000);
		driver.close();
	}
}

package automation.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HiddenDivisionPopup {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void hiddenDivisionPopup() throws InterruptedException {
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();

		WebElement datePiker = driver.findElement(By.id("datePickerMonthYearInput"));
		datePiker.click();
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--013'][@aria-label='Choose Tuesday, December 13th, 2022']"));
		date.click();
	}

}

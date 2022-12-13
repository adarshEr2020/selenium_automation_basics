package automation.popup;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChildBrowserPopup {
	public static WebDriver driver;

	@BeforeTest
	public void drive() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void print_windowHandle() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		String windowHandle = driver.getWindowHandle();
		System.out.println("current window id:  " + windowHandle);
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void windowHandles() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='ntc__chip-label'][@title='Remote']")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Total browser windows : " + count);
		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			System.out.println("Window handle id of page:" + title + " : is : " + windowHandle);
			driver.close();
		}
		// driver.quit();
	}

	@Test
	public void huandleTabsUsingGetWindowHandles() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();

		String parentWindowId = driver.getWindowHandle();
		System.out.println("parentWindow:   " + parentWindowId);
		String mainPagetitle = driver.getTitle();
		System.out.println("Window handle id of page:" + mainPagetitle);
		driver.findElement(By.xpath("//span[@class='ntc__chip-label'][@title='Remote']")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();

		int count = allWindowHandles.size();
		System.out.println("Total browser windows : " + count);

		for (String windowHandle : allWindowHandles) {
			// switch to each browser window
			driver.switchTo().window(windowHandle);
			String title = driver.getTitle();
			if(!parentWindowId.equals(windowHandle)) {
				System.out.println("Window handle id of page:" + title + " : is : " + windowHandle);
				Thread.sleep(3000);
				driver.close();
			}
		}
	}
}

package automation.fb;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrouserNavigation {
	@Test
	public void mainBrouserNavigation() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Enter the url
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		String currentUrl =driver.getCurrentUrl();
		
		System.out.printf("title of the page is:  "+ title +
				"\n"
				+ "Get CurrentUrl:  " + currentUrl 
				+ "\n"
				);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String currentBrouserWindowId = driver.getWindowHandle();
		Set <String> allBrouserWindowId = driver.getWindowHandles();
		System.out.println("currentBrouserWindowId:   "+currentBrouserWindowId 
				+ "\n" 
				+  "allBrouserWindowId   " +  allBrouserWindowId);
		
		driver.navigate().to("http://www.gmail.com");
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();
//		driver.close();
	}
	
}

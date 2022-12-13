package automation.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action {
	public static WebDriver driver;
	
	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void contextClickusingActionsClass() throws InterruptedException, AWTException {
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();

		// find the Log in link
		WebElement query = driver.findElement(By.className("gLFyf"));
		Actions actions = new Actions(driver);
		actions.contextClick(query).perform();
		Thread.sleep(3000);
		// opening in a new window
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		Thread.sleep(3000);
//		driver.close();
	}

	@Test
	public void dropdownMenu() {
		driver.get("http://www.actimind.com/");
		driver.manage().window().maximize();
		String xp = "//a[contains(text(),'AREAS OF EXPERTISE')]";
		WebElement menu = driver.findElement(By.xpath(xp));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement submenu = driver.findElement(By.linkText("Web Crawling"));
		submenu.click();
	}

	@Test
	public void dragAndDrop() {
		
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		driver.manage().window().maximize();
		String xp1 = "//h1[.='Block 1']";
		WebElement block1 = driver.findElement(By.xpath(xp1));
		String xp2 = "//h1[.='Block 3']";
		WebElement block3 = driver.findElement(By.xpath(xp2));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(block1, block3).perform();
	}

	@Test
	public void mouseHover() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		// movetoElement - used for mouse hover
		WebElement more = driver.findElement(By.className("exehdJ"));
		action.moveToElement(more).perform();
		Thread.sleep(2000);
	}

	@Test
	public void doubleClick() throws InterruptedException {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/doubleClickPage.html");
		driver.manage().window().maximize();
		
		WebElement btn = driver.findElement(By.id("dblClickdemo"));
		Actions actions= new Actions(driver);
		Thread.sleep(3000);
		actions.doubleClick(btn).click().perform();
		Thread.sleep(3000);
//		driver.close();
	}
	
	@Test
	public void dragAndDropbyOffset() {
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		driver.manage().window().maximize();
		String xp1 = "//h1[.='Block 1']";
		WebElement block1 = driver.findElement(By.xpath(xp1));
		String xp2 = "//h1[.='Block 3']";
		WebElement block3 = driver.findElement(By.xpath(xp2));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(block1, block3.getLocation().getX() + 10, block3.getSize().getHeight() + 10).perform();
//		driver.close();
	}
}

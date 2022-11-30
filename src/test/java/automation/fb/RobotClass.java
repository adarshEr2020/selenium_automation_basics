package automation.fb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RobotClass {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

//	Handling Mouse and Keyboard Operations

	@Test
	public void keyboardOperations() throws InterruptedException, AWTException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();


//		 Creating an object of Robot Class-------------->
		Robot robot = new Robot();
		
//		User name Feild-------------
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		Thread.sleep(3000);
		
//		Password Feild-------------
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_3);
		robot.keyPress(KeyEvent.VK_4);
		robot.keyRelease(KeyEvent.VK_4);
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		
//		Login btn------------------
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.close();
	}
	

//	mouse operation------------------->
	@Test
	public void mouseOperations() throws AWTException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		Robot robot = new Robot();
	
//		Mouse move------------------->
		Thread.sleep(3000);
		robot.mouseMove(500,700);
		Thread.sleep(3000);
//		driver.close();
		
//		Mouse scroll----------------->
		robot.mouseWheel(100);
		robot.mouseWheel(50);
		
	}
}

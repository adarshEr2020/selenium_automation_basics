package automation.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void webTableOperations() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/WebTable.html");
		driver.manage().window().maximize();

		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("total rows :" + totalRows);
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total number of columns :" + totalColumns);
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total cells  :" + totalCells);
		driver.close();
	}

	@Test
	public void verifyStudentTotalMarks() {

		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/WebTable_StudentMarks.html");
		driver.manage().window().maximize();
		List<WebElement> allColls = driver.findElements(By.xpath("//th"));
		int totalColls = allColls.size();
		System.out.println("Total coll  present in the table:  " + totalColls);

		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
//		int totalRows = allRows.size();
		System.out.println("Total rows  present in the table:  " + allRows.size());
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total number of cells present in the table :" + totalCells);

		int totalmarks = 0;
		int toatalnumeric = 0;
		for (WebElement cell : allCells) {
			String cellValue = cell.getText();
			try {
				System.out.println("cellValue:  " + cellValue);
				int numericValue = Integer.parseInt(cellValue);
				toatalnumeric++;
				totalmarks = totalmarks + numericValue;
			} catch (Exception e) {
			}

		}
		System.out.println("Total count of numeric values :" + toatalnumeric);
		System.out.println("Total marks of the student present in table:  " + totalmarks);
	}

	@Test
	public void autosuggestionEx_GoogleSearch() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
		int count = options.size();
		System.out.println("Number of values present in the dropdown is : " + count);
	}
}

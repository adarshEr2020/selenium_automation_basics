package automation.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectListBox {
	public static WebDriver driver;

	@BeforeTest
	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void selectListBox() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/cars.html");
		driver.manage().window().maximize();
		
		WebElement list = driver.findElement(By.id("Cvehicle"));
		Select s = new Select(list);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		System.out.println("elements inside the listbox is : " + size);
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		s.selectByIndex(4);
		s.selectByValue("sedan");
		s.selectByVisibleText("Suv");

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items : " + size2);
		System.out.println(" Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}
//		driver.close();
	}

	@Test
	public void printListValuesSortedOrder() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/cars.html");
		WebElement listElement = driver.findElement(By.id("Cvehicle"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
			String cars = option.getText();
			System.out.println(cars);
			list.add(cars);
		}
		Collections.sort(list);
		System.out.println(list); 
//		driver.close();
	}
	
	@Test
	public void printUniqueElement() {

		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/cars.html");
		WebElement listElement = driver.findElement(By.id("Cvehicle"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println(" print the values in the list");
		TreeSet<String> allElements = new TreeSet<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			allElements.add(text);
		}
		System.out.println(allElements);
//		driver.close();
	}
	
	@Test
	public void selectExample() throws InterruptedException {
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		WebElement developers_dropdown = driver.findElement(By.id("developers-menu-toggle"));
		Select objSelect = new Select(developers_dropdown);
		objSelect.selectByIndex(2);
		Thread.sleep(3000);
		driver.navigate().to("https://www.browserstack.com/");
		WebElement solutions_dropdown = driver.findElement(By.id("solutions-menu-dropdown"));
		Select solutions = new Select(solutions_dropdown);
		solutions.selectByValue("4000");
		Thread.sleep(3000);
		WebElement solutions_d = driver.findElement(By.id("solutions-menu-dropdown"));
		Select s1 = new Select(solutions_d);
		s1.selectByVisibleText("Geolocation Testing");
	}
	
	@Test
	public void printListValues_SortedOrder() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/ListBox_Breakfast.html");
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select s = new Select(listElement);
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		
		System.out.println("print the values in the list");
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(text);
			list.add(text);
		}
		Collections.sort(list);
		System.out.println("print the value in sorted order");
		for (String value : list) {
			System.out.println(value);
		}
	}

	@Test
	public void checklisthasDuplicatevalues_HashSet() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/ListBox_Breakfast.html");
		WebElement listbox = driver.findElement(By.id("mtr"));
		Select s = new Select(listbox);
		List<WebElement> allOptions = s.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list is :" + count1);
		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count1; i++) {
			String text = allOptions.get(i).getText();
			System.out.println(text);
			allElementText.add(text);
		}
		int count2 = allElementText.size();
		System.out.println("Number of elements in the hashset is :" + count2);
		if (count1 == count2) {
			System.out.println("list box has NO duplicate values");
		} else {
			System.out.println("list box has duplicate values");
		}

		System.out.println(allElementText);
		driver.close();
	}

	@Test
	public void printtheDuplicateItemIntheListHashSet() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/ListBox_Breakfast.html");
		driver.manage().window().maximize();
		WebElement listbox = driver.findElement(By.id("mtr"));
		Select s = new Select(listbox);
		List<WebElement> allOptions = s.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list is :" + count1);
		HashSet<String> allElementText = new HashSet<String>();
		for (int i = 0; i < count1; i++) {
			String text = allOptions.get(i).getText();

			if (!allElementText.add(text)) {
				System.out.println(text + " is the duplicate item in the list box");
			}
		}
		System.out.println(allElementText.size());
		// print all the unique values
		System.out.println(allElementText);
		driver.close();
	}

	@Test
	public void hashMapExamplePrinttheOcuuranceOfPoori() {
		driver.get("file:///E:/ADARSH%20Current%20data/fb/js/ListBox_Breakfast.html");
		driver.manage().window().maximize();

		WebElement list = driver.findElement(By.id("mtr"));
		Select s = new Select(list);
		List<WebElement> allElements = s.getOptions();

		HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();
		for (WebElement element : allElements) {
			String text = element.getText();
			if (hashMapObj.containsKey(text)) {
				Integer value = hashMapObj.get(text);
				value++;
				hashMapObj.put(text, value);
			} else {
				hashMapObj.put(text, 1);
			}
		}
		Set<String> allKeys = hashMapObj.keySet();
		for (String key : allKeys) {
			Integer value = hashMapObj.get(key);
			System.out.println(key + " " + value);

			if (value > 1) {
				System.out.println("Occurance of " + key + " is :" + value);
			}
		}

	}

}

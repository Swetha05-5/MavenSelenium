package dealwithdropdown;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MutilPlay {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/sweth/Downloads/MultiSelect.html");
		WebElement passportDropdown = driver.findElement(By.id("dcdrLocation"));
		Select passPortSelect = new Select(passportDropdown);
		// selectByVisibleText
//		passPortSelect.selectByVisibleText("Chennai");
//		passPortSelect.selectByVisibleText("Coimbatore");
	  //passPortSelect.selectByVisibleText("Cochin");

		// selectByIndex
//		passPortSelect.selectByIndex(8); //chennai
//		passPortSelect.selectByIndex(9); //cochin 
//		passPortSelect.selectByIndex(10); //coim
		// selectByValue
		passPortSelect.selectByValue("26"); // chennai 
		passPortSelect.selectByValue("11"); // cochin
		passPortSelect.selectByValue("9");  //coimbatore
		// getallselectedOptions
		Thread.sleep(4000);
		List<WebElement> allSelectedOptions = passPortSelect.getAllSelectedOptions();
		System.out.println("No of Options Selected: " + allSelectedOptions.size());
		for (WebElement selectedOption : allSelectedOptions) {
			System.out.println(selectedOption.getText());
		}
		// deselectAll
		Thread.sleep(4000);
		passPortSelect.deselectAll();
	}
}
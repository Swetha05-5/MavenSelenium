package dealwithdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectType {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/sweth/Downloads/MultiSelect.html");
		WebElement passportDropdown = driver.findElement(By.id("dcdrLocation"));
		Select passPortSelect = new Select(passportDropdown);
		if (passPortSelect.isMultiple()) {
			System.out.println("Boolean True - Multi Select");
		} else {
			System.out.println("Boolean False - Single Select");
		}
	}
}

package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activeelement {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement activeelement=driver.switchTo().activeElement();
		
		activeelement.sendKeys("123");
		

	}

}

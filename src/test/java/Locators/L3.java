package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L3 {

		public static void main(String[] args) {
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.facebook.com/");
			
			//driver.findElement(By.name("login")).click();
			
			WebElement emailtextfield=driver.switchTo().activeElement();
			System.out.println(emailtextfield.getTagName());
			
		}

}

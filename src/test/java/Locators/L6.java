package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L6 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");

		// identify the password textfield
		WebElement passwordtextfield=driver.findElement(By.id("pass"));
		passwordtextfield.sendKeys("12");
		//identify the flutter button 
		//flutter button - static component (visible in webpage even before entering password)
		WebElement flutterbutton=driver.findElement(By.className("_9lsa"));
		flutterbutton.click();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
		
		
	}
}

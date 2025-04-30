package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Active2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		
		WebElement activeelement=driver.switchTo().activeElement();
		
		System.out.println(activeelement.getTagName());
		
		
		
		

	}

}

package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L5 {

	public static void main(String[] args) throws InterruptedException {
				
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/");
		
		// driver.findElement(By.className("Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr"));
		
		WebElement login=driver.findElement(By.cssSelector("a[class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
		login.click();
		Thread.sleep(3000);
		
		
		WebElement emailtextfield=driver.switchTo().activeElement();
		emailtextfield.sendKeys("swethanice95@gmail.com");
		Thread.sleep(3000);
		
		WebElement ctnbutton=driver.findElement(By.xpath("//button[.='Continue']"));
		ctnbutton.click();
		Thread.sleep(3000);
		
		WebElement pwd=driver.switchTo().activeElement();
		pwd.sendKeys("Netflix@95");
		WebElement loginbutton=driver.findElement(By.xpath("//button[contains(.,'Log in')]"));
		loginbutton.click();
					
				
				

	}

}

package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.naukri.com/");
		WebElement loginButton=driver.findElement(By.id("login_Layer"));
		loginButton.click();
		WebElement emailTextField=driver.findElement(By.cssSelector("[placeholder='Enter your active Email ID / Username']"));
		Thread.sleep(3000); // getting ElementNotInteractableException without thread.sleep
		emailTextField.sendKeys("swethainc95@gmail.com");
		WebElement passwordTextField=driver.findElement(By.cssSelector("input[type='password']"));
		passwordTextField.sendKeys("Netflix@95");
		WebElement loginSubmitButton=driver.findElement(By.cssSelector("button[type='submit']"));		
		loginSubmitButton.click();
		driver.quit();
	}

}

package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class L7 {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://goldensandindia.com/");
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			//identify smartphone cases option in the context menu
			WebElement smartPhoneCases = driver.findElement(By.xpath("//a[contains(.,'Smartphone Cases') and not(@class)]"));
			// mouse hover on Smartphonecases option
			actions.moveToElement(smartPhoneCases).perform();
			//identify iphone16 option and click -----> 
			//When the application contains dynamic features so to freeze the context menu use f8 or Go to Sources then press ctrl+\
			WebElement iphone16=driver.findElement(By.xpath("//a[contains(@href,'apple-cases')]/following::span[text()='iPhone 16']"));
			Thread.sleep(2000);  // if we dont give thread.sleep we get element not interactable exception 
			actions.moveToElement(iphone16).click().perform();
			Thread.sleep(2000);
			//We need to find and click this cover's Aramid Fibre Series Shockproof Armor Back Cover for Apple iPhone 16, 6.1 inch, Black - add to cart button 
			WebElement addtoCartButton = driver.findElement(By.xpath(
					"//a[contains(.,'Aramid Fibre Series Shockproof Armor Back Cover for Apple iPhone 16, 6.1 inch, Black') and not(@title)]/../..//button[contains(.,'ADD TO CART')]"));
			//scroll to add to cart button and click on it 
			actions.scrollToElement(addtoCartButton).pause(2000).click(addtoCartButton).perform();
			Thread.sleep(2000);
			//click proceed to checkout button 
			WebElement proceedToCheckOut = driver.findElement(By.xpath(
					"//div[@id='modalAddToCartProduct']//a[text()='PROCEED TO CHECKOUT' and @class='btn ttmodalbtn']"));
			// it was not working in single click so force and click two times 
			actions.moveToElement(proceedToCheckOut).pause(200).click(proceedToCheckOut).click().perform();
		}
}
			


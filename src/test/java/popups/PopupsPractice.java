package popups;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PopupsPractice {

	@Test
	public void notificationPopup() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.pib.gov.in/");
		Thread.sleep(2000);
		String alertmMessage = driver.switchTo().alert().getText();
		System.out.println("alertmMessage: " + alertmMessage);
		driver.switchTo().alert().accept();
		WebElement hyperLink = driver.findElement(By.linkText("Ministry of Textiles"));
//		Actions actions = new Actions(driver);
//		actions.scrollToElement(hyperLink).pause(2000).scrollToElement(hyperLink).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object scrollheight = js.executeScript("return document.body.scrollHeight");
		System.out.println(String.valueOf(scrollheight));
		Object scrollWidth = js.executeScript("return document.body.scrollWidth");
		System.out.println(String.valueOf(scrollWidth));
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,3000)");
		hyperLink.click();
		Thread.sleep(3000);
		String cfrmPopupMessage = driver.switchTo().alert().getText();
		System.out.println("cfrmPopupMessage: " + cfrmPopupMessage);
		driver.switchTo().alert().accept();
		//Close the min of Textiles
		for (String wid : driver.getWindowHandles()) {
			String windowUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (windowUrl.contains("https://www.pib.gov.in/")) {
				driver.manage().window().maximize(); // here the maximize will work for both the tabs 
			}else if (windowUrl.equals("https://ministryoftextiles.gov.in/")) {
//				driver.manage().window().setSize(new Dimension(500, 500));
				Thread.sleep(3000);
				driver.close();
			}
		}

	}
}
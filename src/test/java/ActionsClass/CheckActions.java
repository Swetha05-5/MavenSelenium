package ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckActions {
	
	@Test
	public void moveCursorOnToMen()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		//identify the men section
		WebElement menSection=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		Actions actions= new Actions(driver);
		// move to men 
		//actions.moveToElement(menSection).perform();
		//move to women form men
		actions.moveToElement(menSection, 73, 0).perform();
	}

	@Test
	public void moveToHyperLink()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement hyperLink=driver.findElement(By.linkText("Forgotten password?"));
		//to get the location of the element
		Point hyperLinkLocation=hyperLink.getLocation();
		System.out.println(hyperLinkLocation);
		Actions actions= new Actions(driver);
		actions.moveToLocation(hyperLinkLocation.getX(), hyperLinkLocation.getY()).perform();    
		
	}
	
	
	@Test
	public void appendingData()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		
		// Enter username without address
		WebElement emailTextField=driver.switchTo().activeElement();
		Actions actions= new Actions(driver);
		//actions.sendKeys("swetha").perform();
		
		// Enter username and password without address
		actions.sendKeys("swetha").sendKeys(Keys.TAB, "1234").build().perform();
		
		// Enter username and password and delete and re-enter the username without address 
		actions.pause(2000).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE, "nivetha").build().perform();
		
		
	}
	
}

package Snap;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;

public class TakeSnap extends BaseClass{
	
	@Test
	public void webPageScreenshot() throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
	//	System.out.println(webPageScreenShot.getAbsolutePath());
	//	Thread.sleep(20000);
		File destFile=new File("./errorshots/facebooklogin.png");
		//will copy the file form src to dest 
		FileUtils.copyFile(srcFile, destFile);
	}
	
	@Test
	public void webElementScreenshot() throws IOException
	{
		WebElement loginButton=driver.findElement(By.name("login"));
		File srcFile=loginButton.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./errorshots/loginButton.png");
		FileUtils.copyFile(srcFile, destFile);	
			
	}	

	
	@Test
	public void incognito() 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("incognito");		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().fullscreen();
		driver.get("https://www.facebook.com/");
		
}}

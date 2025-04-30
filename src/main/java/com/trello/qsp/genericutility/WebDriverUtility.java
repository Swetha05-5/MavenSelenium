package com.trello.qsp.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class will be used to derive the capability of Selenium WebDriver [I]
 * All the methods are browser controlling features given by Selenium WebDriver
 */
public class WebDriverUtility {
/**
 * It will be used to maximize the browser as a pre-condition
 * @param driver
 */
	public void max(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
/**
 * It will be used to minimize the browser as a post-condition
 * @param driver
 */
	public void min(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
/**
 * 	It will be used to set the browser to full screen 
 * @param driver
 */	
	public void fullScreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * 	It will be used to createNewTab 
	 * @param driver
	 */		
	public WebDriver createNewTab(WebDriver driver)
	{
		WebDriver newTabDriver=driver.switchTo().newWindow(WindowType.TAB);
		return newTabDriver;
	}
	/**
	 * 	It will be used to createNewWindow 
	 * @param driver
	 */	
	public  WebDriver createNewWindow(WebDriver driver)
	{
		WebDriver newWindowDriver=driver.switchTo().newWindow(WindowType.WINDOW);
		return newWindowDriver;
	}
	/**
	 * 	It will be used to switch to new window 
	 * @param driver
	 * @param wid
	 */	
	public void switchToNewWindow(WebDriver driver,String wid)
	{
		driver.switchTo().window(wid);
	}
	
	/**
	 * This method will be used to set implicitWait time for the webdriver.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	/**
	 * This method will be used to wait for the DOM Title to load
	 * @param driver
	 */
	public boolean waitForCompleteTitle(WebDriver driver,String expectedTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		boolean result=wait.until(ExpectedConditions.titleIs(expectedTitle));
		return result;
	}
	/**
	 * This method will be used to wait for the DOM PartialUrl to load
	 * @param driver
	 * @param expectedPartialUrl
	 * @return
	 */
	public boolean waitForPartialUrl(WebDriver driver,String expectedPartialUrl)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean result=wait.until(ExpectedConditions.urlContains(expectedPartialUrl));
		return result;
	}
	

}

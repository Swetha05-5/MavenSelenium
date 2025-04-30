package com.trello.qsp.genericutility;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	public JavaUtility javaUtils=new JavaUtility();
	public ExcelUtility excelUtils=new ExcelUtility();
	public WebDriverUtility webdriverUtils=new WebDriverUtility();
	
	@BeforeMethod
	public void configBeforeMethod() throws FileNotFoundException, IOException
	{
		//Get the Browser name from the property file
		String browserName=javaUtils.readDataFromPropertyFile("browsername");
		//Choose the Browser to Launch
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		//Maximize the launched browser
		webdriverUtils.max(driver);
		//Trigger the url
		driver.get(javaUtils.readDataFromPropertyFile("url2"));
	}
	
	@AfterMethod
		public void configAfterMethod()
		{
			webdriverUtils.min(driver);
			driver.quit();
		}		
}

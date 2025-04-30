package com.trello.qsp.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogoutPage {

WebDriver driver;
	
	public TrelloLogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='logout-submit']")
	private WebElement logoutSubmitButton;

	public WebElement getLogoutSubmitButton() {
		return logoutSubmitButton;
	}

	
	
	
}

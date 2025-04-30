package com.trello.qsp.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {
	
	WebDriver driver;
	
	public TrelloLoginToContinuePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement emailTextField;
	
	@FindBy(xpath="//button[@id='login-submit' and .='Continue']")
	private WebElement continueButton;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[@id='login-submit' and .='Log in']")
	private WebElement loginButton;
	
	@FindBy(name="remember")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//button[.='Show password']")
	private WebElement flutterButton;
	

	
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
    }
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getFlutterButton() {
		return flutterButton;
	}
	
	
}
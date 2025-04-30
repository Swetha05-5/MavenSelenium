package com.trello.qsp.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	
	
	WebDriver driver;
	
	
	public TrelloHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//find by is a selenium annotation -> used in place of find element and find elements
	
	@FindBy(xpath = "//button[.='Features' and @data-testid]")
	private WebElement featuresButton;
	
	@FindBy(xpath = "//button[.='Solutions' and @data-testid]")
	private WebElement solutionsButton;
	
	@FindBy(xpath = "//button[.='Plans' and @data-testid]")
	private WebElement plansButton;
	
	@FindBy(xpath = "//button[.='Resources' and @data-testid]")
	private WebElement resourcesButton;
	
	@FindBy(xpath = "//a[.='Get Trello for free']/preceding-sibling::a[.='Log in']")
	private WebElement loginOption;



	public WebElement getFeaturesButton() {
		return featuresButton;
	}

	public WebElement getSolutionsButton() {
		return solutionsButton;
	}

	public WebElement getPlansButton() {
		return plansButton;
	}

	public WebElement getResourcesButton() {
		return resourcesButton;
	}
	
	public WebElement getLoginOption() {
		return loginOption;
	}
	
	

}

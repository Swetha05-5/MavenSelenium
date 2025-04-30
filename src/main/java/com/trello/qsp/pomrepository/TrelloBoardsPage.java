package com.trello.qsp.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	
WebDriver driver;
	
	public TrelloBoardsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='DweEFaF5owOe02 S7RWiPL9Qgl9P9 kFZ3hS99jGmKWk' and contains(@style,'height: 24px')]")
	private WebElement profileIconMenu;

	
	
	@FindBy(xpath="//button[@data-testid='account-menu-logout']")
	private WebElement logoutOption;
	
	//direct create new board option
	@FindBy(xpath="//div[@class='board-tile mod-add']")
	private WebElement createNewBoardOption;

	//create button
	@FindBy(xpath="//p[contains(.,'Create')and@class='szBTSFrvPTLGHM']")
	private WebElement createButton;
	
	@FindBy(xpath="//button[@data-testid='header-create-board-button']")
	private WebElement createBoardOption;
	
	@FindBy(xpath="//input[@data-testid='create-board-title-input']")
	private WebElement boardTitleTextField;
	

	@FindBy(xpath="//button[@data-testid='create-board-submit-button']")
	private WebElement popupCreateButton;
	
	
	public WebElement getProfileIconMenu() {
		return profileIconMenu;
	}
	
	public WebElement getLogoutOption() {
		return logoutOption;
	}
	
	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getCreateBoardOption() {
		return createBoardOption;
	}

	public WebElement getBoardTitleTextField() {
		return boardTitleTextField;
	}

	public WebElement getPopupCreateButton() {
		return popupCreateButton;
	}

	
	
	
}

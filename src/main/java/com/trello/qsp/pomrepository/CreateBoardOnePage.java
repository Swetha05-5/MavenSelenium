package com.trello.qsp.pomrepository;


	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class CreateBoardOnePage {
		
	WebDriver driver;
		
		public CreateBoardOnePage (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="button[aria-label='Show menu']")
		private WebElement showMenu;
		
		@FindBy(xpath="//span[@data-testid='RemoveIcon']")
		private WebElement closeBoardOption;
		
		@FindBy(xpath="//button[@data-testid='popover-close-board-confirm']")
		private WebElement closeboardconfirmbutton;
		
		@FindBy(xpath="//button[@data-testid='close-board-delete-board-button']")
		private WebElement permanentlyDeleteBoardOption;
		
		@FindBy(xpath="//button[text()='Delete']")
		private WebElement permanantlyDeleteBoardButton;
		
		@FindBy(css="textarea[name='Enter list name…']")
		private WebElement listTextBox;
		
		@FindBy(xpath="//button[text()='Add list']")
		private WebElement addList;

		public WebElement getShowMenu() {
			return showMenu;
		}

		public WebElement getCloseBoardOption() {
			return closeBoardOption;
		}
		
		public WebElement getCloseboardconfirmbutton() {
			return closeboardconfirmbutton;
		}

		public WebElement getPermanentlyDeleteBoardOption() {
			return permanentlyDeleteBoardOption;
		}

		public WebElement getPermanantlyDeleteBoardButton() {
			return permanantlyDeleteBoardButton;
		}

		public WebElement getListTextBox() {
			return listTextBox;
		}

		public WebElement getAddList() {
			return addList;
		}

		


}

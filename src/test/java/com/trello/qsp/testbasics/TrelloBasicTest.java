package com.trello.qsp.testbasics;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepository.CreateBoardOnePage;
import com.trello.qsp.pomrepository.TrelloBoardsPage;
import com.trello.qsp.pomrepository.TrelloHomePage;
import com.trello.qsp.pomrepository.TrelloLoginToContinuePage;
import com.trello.qsp.pomrepository.TrelloLogoutPage;

public class TrelloBasicTest extends BaseClass{
	
	@Test
	public void trelloHomePageCheck() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page is displayed");
	}
	
	@Test
	public void trelloLoginPageCheck() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page is displayed");
		//Step 3: Click on login Option
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is displayed");
	}

	@Test
	public void trelloBoardPageCheck() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page should is displayed");
		//Step 3: Click on login Option
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is displayed");
		//Step 4: Enter the valid registerd Email to username text field
		TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		//Step 5: Click on Continue button
		loginToCont.getContinueButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 3, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 4, 1)), true,"LoginToContinue Page Url is incorrect");
		//Step 6: Enter the valid password Email to password text field
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//Step 7: Click on fluttered button
		loginToCont.getFlutterButton().click();
		//step8: Click on login button
		loginToCont.getLoginButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 6, 1)), true,"Boards Page Url is incorrect");
				
		SoftAssert softAssert=new SoftAssert();
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getProfileIconMenu().click();
		softAssert.assertEquals(boardsPage.getLogoutOption().isDisplayed(),true,"The Logout Option is not displayed by default and its verified");
		Reporter.log("Boards Profile Home Page is displayed");
		softAssert.assertAll();
		//Step9: Click on profile icon menu
		Reporter.log("Profile Menu Options is displayed");
		//Step 10: Click on Logout option
		boardsPage.getLogoutOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Logout Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Logout Page Url is incorrect");
		Reporter.log("Atlassian logout page is displayed");
		//Step 11: Click on logout button
		TrelloLogoutPage logOutbutton=new TrelloLogoutPage(driver);
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Home Page is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Home Page Url is incorrect");
		Reporter.log("Home Page is displayed");
		
	}
	
	@Test
	public void trelloCreateAndDeleteBoard() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page is displayed");
		//Step 3: Click on login Option
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is displayed");
		//Step 4: Enter the valid registerd Email to username text field
		TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
	    //Step 5: Click on Continue button
		loginToCont.getContinueButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 3, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 4, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is maintained");
		//Step 6: Enter the valid password Email to password text field
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//Step 7: Click on fluttered button
		loginToCont.getFlutterButton().click();	
		//Step 8: Click on login button
		loginToCont.getLoginButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 6, 1)), true,"Boards Page Url is incorrect");
				
		SoftAssert softAssert=new SoftAssert();
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getProfileIconMenu().click();
		softAssert.assertEquals(boardsPage.getLogoutOption().isDisplayed(),true,"The Logout Option is not displayed by default and its verified");
		Reporter.log("Boards Profile Home Page is displayed");
		softAssert.assertAll(); 
		
		//Step9: Click on the Create button present in the navigation Menu.
		boardsPage.getCreateButton().click();
		softAssert.assertEquals(boardsPage.getCreateBoardOption().isDisplayed(),true,"The CreateBoard Option is not displayed by default and its verified");
		//Step 10: Click on create board option in the popup
		boardsPage.getCreateBoardOption().click();
		softAssert.assertEquals(boardsPage.getBoardTitleTextField().isDisplayed(),true,"The boardtitle text field is not displayed by default and its verified");	
		Reporter.log("CreateBoards Popup is displayed");
		//Step 11: Enter the board title
		boardsPage.getBoardTitleTextField().sendKeys("CreateBoardOne");
		//Step 12: Click on create button after entering the board title in the create board popup 
		Thread.sleep(3000);
		boardsPage.getPopupCreateButton().click();
		Thread.sleep(6000);
    	Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 7, 1)), true,"Created board title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 8, 1)), true,"Created board Url is incorrect");
		Reporter.log("CreatedBoards Page is displayed");
		//Step 13: Click on show menu options
		CreateBoardOnePage createboardone=new CreateBoardOnePage(driver);
		createboardone.getShowMenu().click();
		Reporter.log("Menu Options is displayed");
		//Step 15: Click on close board option
		Thread.sleep(3000);
		createboardone.getCloseBoardOption().click();
		//Step 16:Click on close board confirmation button
		createboardone.getCloseboardconfirmbutton().click();
		//Step 17:Click on Permanently delete board option
		createboardone.getPermanentlyDeleteBoardOption().click();
		//Step 18: Click on permanently delete board confirmation button
		createboardone.getPermanantlyDeleteBoardButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Reporter.log("Boards Home Page is displayed");
		//Step 19: Click on profile icon menu
		boardsPage.getProfileIconMenu().click();
		Reporter.log("Profile Menu Options is displayed");
		//Step 20: Click on Logout option
		boardsPage.getLogoutOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Logout Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Logout Page Url is incorrect");
		Reporter.log("Atlassian logout page is displayed");
		//Step 21: Click on logout button
		TrelloLogoutPage logOutbutton=new TrelloLogoutPage(driver);
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Home Page is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Home Page Url is incorrect");
		Reporter.log("Home Page is displayed");
	
	}
	
	@Test
	public void trelloCreateMultipleListInCreatedBoard() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page is displayed");
		//Step 3: Click on login Option
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is displayed");
		//Step 4: Enter the valid registerd Email to username text field
		TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
	    //Step 5: Click on Continue button
		loginToCont.getContinueButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 3, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 4, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is maintained");
		//Step 6: Enter the valid password Email to password text field
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//Step 7: Click on fluttered button
		loginToCont.getFlutterButton().click();	
		//Step 8: Click on login button
		loginToCont.getLoginButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 6, 1)), true,"Boards Page Url is incorrect");
				
		SoftAssert softAssert=new SoftAssert();
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getProfileIconMenu().click();
		softAssert.assertEquals(boardsPage.getLogoutOption().isDisplayed(),true,"The Logout Option is not displayed by default and its verified");
		Reporter.log("Boards Profile Home Page is displayed");
		softAssert.assertAll(); 
		
		//Step9: Click on the Create button present in the navigation Menu.
		boardsPage.getCreateButton().click();
		softAssert.assertEquals(boardsPage.getCreateBoardOption().isDisplayed(),true,"The CreateBoard Option is not displayed by default and its verified");
		//Step 10: Click on create board option in the popup
		boardsPage.getCreateBoardOption().click();
		softAssert.assertEquals(boardsPage.getBoardTitleTextField().isDisplayed(),true,"The boardtitle text field is not displayed by default and its verified");	
		Reporter.log("CreateBoards Popup is displayed");
		//Step 11: Enter the board title
		boardsPage.getBoardTitleTextField().sendKeys("CreateBoardOne");
		//Step 12: Click on create button after entering the board title in the create board popup 
		boardsPage.getPopupCreateButton().click();
		//Step 13: Enter the list name to the enter list text field
		CreateBoardOnePage createboardone=new CreateBoardOnePage(driver);
		Thread.sleep(5000);
		createboardone.getListTextBox().sendKeys("CreatedListOne");
		createboardone.getAddList();
		//Step 14: Enter the list name to the enter list text field
		Reporter.log("CreatedListOne list is created 1st time");
		createboardone.getListTextBox().sendKeys("CreatedListTwo");
		createboardone.getAddList();
		Reporter.log("CreatedListOne list is created 2nd time");
		//Step 15: Click on show menu options
		createboardone.getShowMenu().click();
		Reporter.log("Menu Options is displayed");
		//Step 16: Click on close board option
		createboardone.getCloseBoardOption().click();
		//Step 17:Click on close board confirmation button
		createboardone.getCloseboardconfirmbutton().click();
		//Step 18:Click on Permanently delete board option
		createboardone.getPermanentlyDeleteBoardOption().click();
		//Step 19: Click on permanently delete board confirmation button
		createboardone.getPermanantlyDeleteBoardButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Reporter.log("Boards Home Page is displayed");
		//Step 20: Click on profile icon menu
		boardsPage.getProfileIconMenu().click();
		Reporter.log("Profile Menu Options is displayed");
		//Step 21: Click on Logout option
		boardsPage.getLogoutOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Logout Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Logout Page Url is incorrect");
		Reporter.log("Atlassian logout page is displayed");
		//Step 22: Click on logout button
		TrelloLogoutPage logOutbutton=new TrelloLogoutPage(driver);
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Home Page is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Home Page Url is incorrect");
		Reporter.log("Home Page is displayed");			
		
	}
	
	@Test
	public void trelloCreateMultipleListAndSwapInCreatedBoard() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
	{
		webdriverUtils.implicitWait(driver);
		//Step 1: Launch the browser
		//Step 2: Pass the main URL of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)), true,"Home Page is not displayed");
		Reporter.log("Home Page is displayed");
		//Step 3: Click on login Option
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is displayed");
		//Step 4: Enter the valid registerd Email to username text field
		TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
	    //Step 5: Click on Continue button
		loginToCont.getContinueButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 3, 1)), true,"LoginToContinue Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 4, 1)), true,"LoginToContinue Page Url is incorrect");
		Reporter.log("LoginToContinue Page is maintained");
		//Step 6: Enter the valid password Email to password text field
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//Step 7: Click on fluttered button
		loginToCont.getFlutterButton().click();	
		//Step 8: Click on login button
		loginToCont.getLoginButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 6, 1)), true,"Boards Page Url is incorrect");
				
		SoftAssert softAssert=new SoftAssert();
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getProfileIconMenu().click();
		softAssert.assertEquals(boardsPage.getLogoutOption().isDisplayed(),true,"The Logout Option is not displayed by default and its verified");
		Reporter.log("Boards Profile Home Page is displayed");
		softAssert.assertAll(); 
		
		//Step9: Click on the Create button present in the navigation Menu.
		boardsPage.getCreateButton().click();
		softAssert.assertEquals(boardsPage.getCreateBoardOption().isDisplayed(),true,"The CreateBoard Option is not displayed by default and its verified");
		//Step 10: Click on create board option in the popup
		boardsPage.getCreateBoardOption().click();
		softAssert.assertEquals(boardsPage.getBoardTitleTextField().isDisplayed(),true,"The boardtitle text field is not displayed by default and its verified");	
		Reporter.log("CreateBoards Popup is displayed");
		//Step 11: Enter the board title
		boardsPage.getBoardTitleTextField().sendKeys("CreateBoardOne");
		//Step 12: Click on create button after entering the board title in the create board popup 
		boardsPage.getPopupCreateButton().click();
		//Step 13: Enter the list name to the enter list text field
		CreateBoardOnePage createboardone=new CreateBoardOnePage(driver);
		Thread.sleep(3000);
		createboardone.getListTextBox().sendKeys("CreatedListOne");
		createboardone.getAddList();
		//Step 14: Enter the list name to the enter list text field
		Reporter.log("CreatedListOne list is created 1st time");
		createboardone.getListTextBox().sendKeys("CreatedListTwo");
		createboardone.getAddList();
		Reporter.log("CreatedListOne list is created 2nd time");
		
		//Action class 
		Actions actions = new Actions(driver);
		
		
		
		//Step 15: Click on show menu options
		createboardone.getShowMenu().click();
		Reporter.log("Menu Options is displayed");
		//Step 16: Click on close board option
		createboardone.getCloseBoardOption().click();
		//Step 17:Click on close board confirmation button
		createboardone.getCloseboardconfirmbutton().click();
		//Step 18:Click on Permanently delete board option
		createboardone.getPermanentlyDeleteBoardOption().click();
		//Step 19: Click on permanently delete board confirmation button
		createboardone.getPermanantlyDeleteBoardButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 5, 1)), true,"Boards Page title is incorrect");
		Reporter.log("Boards Home Page is displayed");
		//Step 20: Click on profile icon menu
		boardsPage.getProfileIconMenu().click();
		Reporter.log("Profile Menu Options is displayed");
		//Step 21: Click on Logout option
		boardsPage.getLogoutOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Logout Page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Logout Page Url is incorrect");
		Reporter.log("Atlassian logout page is displayed");
		//Step 22: Click on logout button
		TrelloLogoutPage logOutbutton=new TrelloLogoutPage(driver);
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 9, 1)), true,"Home Page is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 10, 1)), true,"Home Page Url is incorrect");
		Reporter.log("Home Page is displayed");			
		
	}
	
	
}
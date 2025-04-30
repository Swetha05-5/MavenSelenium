package Sync;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepository.FaceBookSignUpPage;
import com.trello.qsp.pomrepository.TrelloBoardsPage;
import com.trello.qsp.pomrepository.TrelloHomePage;
import com.trello.qsp.pomrepository.TrelloLoginToContinuePage;
import com.trello.qsp.pomrepository.TrelloLogoutPage;

public class TrelloAutomation extends BaseClass{
		
		@Test
		public void trelloLoginAndLogoutImplicit() throws FileNotFoundException, IOException
		{
			webdriverUtils.implicitWait(driver);
			//Click on login option in HomePage
			TrelloHomePage homePage=new TrelloHomePage(driver);
			homePage.getLoginOption().click();
			//Enter the user name
			TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
			loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
			//Click on continue button
			loginToCont.getContinueButton().click();
			//Enter the password
			loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
			//Click on login button
			loginToCont.getLoginButton().submit();
			TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
			boardsPage.getProfileIconMenu().click();
			//Click on logout
			boardsPage.getLogoutOption().click();
			//Click on logout
			TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
			logoutPage.getLogoutSubmitButton().click();
			
			
		}
		
		@Test
		public void trelloLoginAndLogoutExplicit() throws FileNotFoundException, IOException
		{
			webdriverUtils.implicitWait(driver);
			
			//Click on login option in HomePage
			String homePageActualTitle=driver.getTitle();
			String homePageExpectedTitle="Capture, organize, and tackle your to-dos from anywhere | Trello";
			if(webdriverUtils.waitForCompleteTitle(driver, homePageExpectedTitle))
			{
				System.out.println("Pass: The Home Page is displayed and its verified upon its title");
				TrelloHomePage homePage=new TrelloHomePage(driver);
				homePage.getLoginOption().click();
				
				
				//Enter the user name
				String loginToContinuePageActualTitle=driver.getTitle();
				String loginToContinuePageExpectedTitle="Log in to continue - Log in with Atlassian account";
				if(webdriverUtils.waitForCompleteTitle(driver, loginToContinuePageExpectedTitle))
				{
					System.out.println("Pass: The LogintoContinue Page is displayed and its verified upon its title");
					TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
					loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
					//Click on continue button
					loginToCont.getContinueButton().click();
					//Enter the password
					loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
					//Click on login button
					loginToCont.getLoginButton().submit();
					
					String BoardsPageActualTitle=driver.getTitle();
					String BoardsPageExpectedTitle="Boards | Trello";
					if(webdriverUtils.waitForCompleteTitle(driver, BoardsPageExpectedTitle))
					{
						System.out.println("Pass: Boards | Trello");
						TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
						boardsPage.getProfileIconMenu().click();
						//Click on logout
						boardsPage.getLogoutOption().click();
						//Click on logout
						
						String LogoutPageActualTitle=driver.getTitle();
						String LogoutPageExpectedTitle="Log out of your Atlassian account - Log in with Atlassian account";
						if(webdriverUtils.waitForCompleteTitle(driver, LogoutPageExpectedTitle))
						{
						TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
						logoutPage.getLogoutSubmitButton().click();
						}
						else
						{
							System.out.println("Fail: The Logout Page is not displayed and its verified upon its title");
							System.out.println("LogoutPageActualTitle:"+ LogoutPageActualTitle);
							System.out.println("LogoutPageExpectedTitle:"+ LogoutPageExpectedTitle);
						}
					}
					else
					{
						System.out.println("Fail: The Boards Page is not displayed and its verified upon its title");
						System.out.println("BoardsPageActualTitle:"+ BoardsPageActualTitle);
						System.out.println("BoardsPageExpectedTitle:"+ BoardsPageExpectedTitle);
					}
					}
				else
				{
					System.out.println("Fail: The LoginToContinue Page is not displayed and its verified upon its title");
					System.out.println("loginToContinuePageActualTitle:"+ loginToContinuePageActualTitle);
					System.out.println("loginToContinuePageExpectedTitle:"+ loginToContinuePageExpectedTitle);
				}
				}
				
			else
			{
				System.out.println("Fail: The Home Page is not displayed and its verified upon its title");
				System.out.println("homePageActualTitle:"+ homePageActualTitle);
				System.out.println("homePageExpecteTitle:"+ homePageExpectedTitle);
			}
			
			
		}
		
		
		@Test
		public void trelloLoginAndLogoutWithReporter() throws FileNotFoundException, IOException
		{
			webdriverUtils.implicitWait(driver);
			
			//Click on login option in HomePage
			String homePageActualTitle=driver.getTitle();
			String homePageExpectedTitle="Capture, organize, and tackle your to-dos from anywhere | Trello";
			if(webdriverUtils.waitForCompleteTitle(driver, homePageExpectedTitle))
			{
				Reporter.log("Pass: The Home Page is displayed and its verified upon its title");
				TrelloHomePage homePage=new TrelloHomePage(driver);
				homePage.getLoginOption().click();
				
				
				//Enter the user name
				String loginToContinuePageActualTitle=driver.getTitle();
				String loginToContinuePageExpectedTitle="Log in to continue - Log in with Atlassian account";
				if(webdriverUtils.waitForCompleteTitle(driver, loginToContinuePageExpectedTitle))
				{
					Reporter.log("Pass: The LogintoContinue Page is displayed and its verified upon its title");
					TrelloLoginToContinuePage loginToCont=new TrelloLoginToContinuePage(driver);
					loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
					//Click on continue button
					loginToCont.getContinueButton().click();
					//Enter the password
					loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
					//Click on login button
					loginToCont.getLoginButton().submit();
					
					String BoardsPageActualTitle=driver.getTitle();
					String BoardsPageExpectedTitle="Boards | Trello";
					if(webdriverUtils.waitForCompleteTitle(driver, BoardsPageExpectedTitle))
					{
						Reporter.log("Pass: Boards | Trello");
						TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
						boardsPage.getProfileIconMenu().click();
						//Click on logout
						boardsPage.getLogoutOption().click();
						//Click on logout
						
						String LogoutPageActualTitle=driver.getTitle();
						String LogoutPageExpectedTitle="Log out of your Atlassian account - Log in with Atlassian account";
						if(webdriverUtils.waitForCompleteTitle(driver, LogoutPageExpectedTitle))
						{
							Reporter.log("Pass: Log out of your Atlassian account - Log in with Atlassian account");
						TrelloLogoutPage logoutPage=new TrelloLogoutPage(driver);
						logoutPage.getLogoutSubmitButton().click();
						}
						else
						{
							Reporter.log("Fail: The Logout Page is not displayed and its verified upon its title");
							Reporter.log("LogoutPageActualTitle:"+ LogoutPageActualTitle);
							Reporter.log("LogoutPageExpectedTitle:"+ LogoutPageExpectedTitle);
						}
					}
					else
					{
						Reporter.log("Fail: The Boards Page is not displayed and its verified upon its title");
						Reporter.log("BoardsPageActualTitle:"+ BoardsPageActualTitle);
						Reporter.log("BoardsPageExpectedTitle:"+ BoardsPageExpectedTitle);
					}
					}
				else
				{
					Reporter.log("Fail: The Boards Page is not displayed and its verified upon its title");
					Reporter.log("loginToContinuePageActualTitle:"+ loginToContinuePageActualTitle);
					Reporter.log("loginToContinuePageExpectedTitle:"+ loginToContinuePageExpectedTitle);
				}
				}
				
			else
			{
				Reporter.log("Fail: The Home Page is not displayed and its verified upon its title");
				Reporter.log("homePageActualTitle:"+ homePageActualTitle);
				Reporter.log("homePageExpecteTitle:"+ homePageExpectedTitle);
			}
			
			
		}	
		
		@Test
		public void learnAssertion() throws FileNotFoundException, IOException
		{
			webdriverUtils.implicitWait(driver);
			SoftAssert softAssert=new SoftAssert();
			FaceBookSignUpPage signUpPage= new FaceBookSignUpPage(driver);
			//Instead of if statement --assertequals method is used
			softAssert.assertEquals(signUpPage.getSignUpSubmitButton().isEnabled(),true,"The Signup Button is disabled by default and its verified");
			Reporter.log("The Signup Button is status is verified");
			softAssert.assertAll();
		}
}


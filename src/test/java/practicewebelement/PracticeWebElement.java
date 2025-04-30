package practicewebelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepository.TrelloBoardsPage;
import com.trello.qsp.pomrepository.TrelloHomePage;
import com.trello.qsp.pomrepository.TrelloLoginToContinuePage;

public class PracticeWebElement extends BaseClass{
	
	
	@Test
	public void usageOfClick() throws Throwable 
	{
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getFeaturesButton().click();
		Thread.sleep(3000);
		homePage.getSolutionsButton().click();
		Thread.sleep(3000);
		homePage.getPlansButton().click();
		Thread.sleep(3000);
		homePage.getResourcesButton().click();
		Thread.sleep(3000);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		
	}
		
	
	@Test
	public void usageOfisSelected() throws Throwable 
	{
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		// -ve scenario - Before Click
		if (loginToContPage.getRememberMeCheckBox().isSelected()) {
			System.out.println("-ve - functional - Fail - true - selected");
		} else {
			System.out.println("-ve - functional - Pass - false - not selected");
		}
		loginToContPage.getRememberMeCheckBox().click();
		// +ve Funactionality Testing after click
		if (loginToContPage.getRememberMeCheckBox().isSelected()) {
			System.out.println("+ve - functional - pass - true - selected");
		} else {
			System.out.println("+ve - functional - fail - false - not selected");
		}
		
		
}
	
	@Test
	public void Task() throws Throwable 
	{
     driver.get("https://www.w3schools.com/html/html_forms.asp");
    WebElement emailTextfield=driver.findElement(By.id("fname"));
    emailTextfield.clear();
    emailTextfield.sendKeys("abraham");
    Thread.sleep(3000);
     
	
	}
	
	@Test
	public void Task1() throws Throwable 
	{
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		loginToContPage.getEmailTextField().clear();
		System.out.println(loginToContPage.getEmailTextField().getDomAttribute("placeholder"));
		System.out.println(loginToContPage.getEmailTextField().getDomAttribute("type"));
		loginToContPage.getEmailTextField().clear();
		loginToContPage.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		loginToContPage.getContinueButton().click();
		Thread.sleep(3000);
		System.out.println(loginToContPage.getPasswordTextField().getDomAttribute("placeholder"));
		System.out.println(loginToContPage.getPasswordTextField().getDomAttribute("type"));
		loginToContPage.getPasswordTextField().clear();
		loginToContPage.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		loginToContPage.getLoginButton().click();
		Thread.sleep(3000);
		
	}

	
	@Test
	public void Task2() throws Throwable 
	{
     driver.get("https://www.w3schools.com/html/html_forms.asp");
    WebElement emailTextfield=driver.findElement(By.id("fname"));
    emailTextfield.clear();
    emailTextfield.sendKeys("abraham");
    Thread.sleep(3000);
     
	
	}
	
	@Test
	public void Task5() throws Throwable 
	{
		TrelloHomePage homePage = new TrelloHomePage(driver);
		System.out.println(homePage.getLoginOption().getText());
	}
	
	@Test
	public void colorOfContButton() throws Throwable {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		String color = loginToContPage.getContinueButton().getCssValue("background-color");
		System.out.println("background-color: " + color);
		String fontType = loginToContPage.getContinueButton().getCssValue("font-family");
		String fontSize = loginToContPage.getContinueButton().getCssValue("font-size");
		String fontWeight = loginToContPage.getContinueButton().getCssValue("font-weight");
		System.out.println("fontType: " + fontType);
		System.out.println("fontSize: " + fontSize);
		System.out.println("fontWeight: " + fontWeight);
	} 

	
	
	@Test
	public void usageOfIsDisplayed() {
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		int count = allDropDowns.size();
		System.out.println("count: " + count);
		for (WebElement dropdown : allDropDowns) {
			String dropDownName = dropdown.getDomAttribute("title");
			if (dropdown.isDisplayed()) {
				System.out.println("visible: " + dropDownName);
			} else {
				System.out.println("Invisible: " + dropDownName);
			}
		}
	} 
	
	@Test
	public void Task3() throws Throwable 
	{
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		//enter username 
		loginToContPage.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		loginToContPage.getContinueButton().click();
		Thread.sleep(3000);
		//enter password
		loginToContPage.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		loginToContPage.getLoginButton().click();
		Thread.sleep(3000);
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		Thread.sleep(3000);
		//click on create new board 
		Actions actions=new Actions(driver);
		actions.moveToElement(boardsPage.getCreateNewBoardOption()).click().perform();		
		Thread.sleep(3000);
		String ButtonName = boardsPage.getPopupCreateButton().getDomAttribute("data-testid");
		if(boardsPage.getPopupCreateButton().isDisplayed())
		{
			System.out.println("The Create Board Button is visible" + ButtonName);
		}
		else
		{
			System.out.println("The Create Board Button is invisible"+ ButtonName);
		}

		
	}
	

	@Test
	public void usageOfIsEnabled() throws Throwable, Throwable {
		Thread.sleep(2000);
		//click on Login option in trello home page
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(2000);
		//enter the user name in trello login to cont page
		TrelloLoginToContinuePage loginToCont = new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		//click on continue  button in trello login to cont page
		loginToCont.getContinueButton().click();
		Thread.sleep(2000);
		//enter the password in trello login to cont page
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//click on login  button in trello login to cont page
		loginToCont.getLoginButton().submit();
		Thread.sleep(2000);
		//click on create new board in trello boards page
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Thread.sleep(3000);
		//boardsPage.getCreateNewBoardOption().click();-----> not working 
		Actions actions=new Actions(driver);
		actions.moveToElement(boardsPage.getCreateNewBoardOption()).click().perform();
		Thread.sleep(3000);
		boardsPage.getBoardTitleTextField().sendKeys("a");
		Thread.sleep(2000);
		//check create button is enabled or not in trello boards page
		if (boardsPage.getPopupCreateButton().isEnabled()) {
			System.out.println("The Create Board Button is enabled");
		}else {
			System.out.println("The Create Board Button is Disabled");
		}
		Thread.sleep(2000);
	} 


@Test
public void usageOfGetSize() throws Throwable{
	Thread.sleep(2000);
	//click on Login option in trellohomeopage
	TrelloHomePage homePage = new TrelloHomePage(driver);
	homePage.getLoginOption().click();
	Thread.sleep(2000);
	driver.navigate().refresh();
	//enter the user name in trellologin to cont page\
	TrelloLoginToContinuePage loginToCont = new TrelloLoginToContinuePage(driver);
	Thread.sleep(2000);
	Dimension emailTextfieldSize = loginToCont.getEmailTextField().getSize();
	System.out.println("emailTextfieldSize: " + emailTextfieldSize);
	System.out.println("emailTextField Width is: " + emailTextfieldSize.getWidth());
	System.out.println("emailTextField height is: " + emailTextfieldSize.getHeight());
	Point emailTextfieldLocation = loginToCont.getEmailTextField().getLocation();
	System.out.println("emailTextfieldLocation: "+ emailTextfieldLocation);
	System.out.println("emailTextfieldLocation x axis is"+emailTextfieldLocation.getX());
	System.out.println("emailTextfieldLocation Y axis is"+emailTextfieldLocation.getY());
	} 




@Test
public void usageOfGetRect() throws Throwable{
	//Identify the email address text field
	driver.get("https://www.facebook.com/");
	WebElement emailTextField=driver.findElement(By.id("email"));
	Point emailLocation=emailTextField.getLocation();
	System.out.println("emailLocation: "+ emailLocation);
	int startX=emailLocation.getX();
	int startY=emailLocation.getY();
	System.out.println("emailstartX: " + startX);
	System.out.println("emailstartY: " + startY);
	
	Dimension emailSize=emailTextField.getSize();
	System.out.println("emailSize: "+ emailSize);
	int emailWidth=emailSize.getWidth();
	int emailHeight=emailSize.getHeight();
	System.out.println("emailWidth: " + emailWidth );
	System.out.println("emailHeight: " +  emailHeight);
	
	System.out.println("===============");
	
	Rectangle emailRect=emailTextField.getRect();
	System.out.println(emailRect.getX());
	System.out.println(emailRect.getY());
	System.out.println(emailRect.getPoint());
	System.out.println(emailRect.getWidth());
	System.out.println(emailRect.getHeight());
	System.out.println(emailRect.getDimension());
	
	
}

}
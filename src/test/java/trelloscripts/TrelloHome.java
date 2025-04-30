package trelloscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepository.TrelloHomePage;

public class TrelloHome extends BaseClass{
		
	@Test
	public void homepageclick()
	{
		TrelloHomePage homePage=new TrelloHomePage(driver);
		homePage.getLoginOption().click();
	}
	
}
	

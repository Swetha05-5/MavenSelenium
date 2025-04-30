package com.trello.qsp.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookSignUpPage {
	
		WebDriver driver;
		
		public FaceBookSignUpPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	//Address 
		
		@FindBy(xpath = "//span[@data-type='selectors']//select")
		private List<WebElement> dropDowns;
		
		@FindBy(name = "websubmit")
		private WebElement signUpSubmitButton;
		
		@FindBy(xpath="//label[.='Female']/input[@type='radio']")
		private WebElement femaleRadioButton;
		
		@FindBy(xpath="//label[.='Male']/input[@type='radio']")
		private WebElement maleRadioButton;
		
		@FindBy(xpath="//label[.='Custom']/input[@type='radio']")
		private WebElement customRadioButton;
		
		@FindBy(id="prefered_pronoun")
		private WebElement preferedPronounListBox;
				
			
		
	//getter methods	
		
		public List<WebElement> getDobDropDowns() {
			return dropDowns;
		}	
		public WebElement getSignUpSubmitButton()
		{
			return signUpSubmitButton;
		}
		public WebElement getFemaleRadioButton() {
			return femaleRadioButton;
		}
		public WebElement getMaleRadioButton() {
			return maleRadioButton;
		}
		public WebElement getCustomRadioButton() {
			return customRadioButton;
		}
		public WebElement getPreferedPronounListBox() {
			return preferedPronounListBox;
		}
		
		
}

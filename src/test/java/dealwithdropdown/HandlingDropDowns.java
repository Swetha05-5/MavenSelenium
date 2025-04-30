package dealwithdropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;

public class HandlingDropDowns extends BaseClass{
	
	
	
	@Test
	public void noOptionsInDropDown() {
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select daySelect = new Select(dayDropDown);
	// get options() it will capture a the options in the dropdown list box
	List<WebElement> allDayOptions = daySelect.getOptions();
	int noOfDayOption = allDayOptions.size();
	System.out.println("noOfDayOption: " + noOfDayOption);
	}
	
	
	@Test
	public void printAllOptionsInTheListBox() {
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select daySelect = new Select(dayDropDown);
	// get options() it will capture the options in the dropdown list box
	List<WebElement> allDayOptions = daySelect.getOptions();
	// System.out.println(allDayOptions);Not to do before iteration
	for (WebElement dayOption : allDayOptions) {
	// every option in dropdown is made with <option> and it's tag text
	String dayOptionName = dayOption.getText();
	System.out.println(dayOptionName);
	}
	}
	
	
	@Test
	public void selectAnOptionByName() throws InterruptedException {
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select daySelect = new Select(dayDropDown);
	// By using <Option> tagtext select an option - selectByVisibleText()
	daySelect.selectByVisibleText("11");
	daySelect.selectByContainsVisibleText("0");
	Thread.sleep(3000);
	}

	
	//-------------Select your date of birth
	
	@Test
	public void Task1() throws InterruptedException {
	WebElement dayDropDown = driver.findElement(By.id("day"));
	WebElement monthDropDown = driver.findElement(By.id("month"));
	WebElement yearDropDown = driver.findElement(By.id("year"));
	Select daySelect = new Select(dayDropDown);
	// By using <Option> tagtext select an option - selectByVisibleText()
	daySelect.selectByVisibleText("5");	
	Thread.sleep(3000);
	
	//month
	Select monthSelect = new Select(monthDropDown);
	// By using <Option> tagtext select an option - selectByVisibleText()
	monthSelect.selectByVisibleText("Jan");	
	Thread.sleep(3000);
	
	Select yearSelect = new Select(yearDropDown);
	// By using <Option> tagtext select an option - selectByVisibleText()
	yearSelect.selectByVisibleText("1995");	
	Thread.sleep(3000);
	}
	
	
	
	@Test
public void selectDOB() throws Throwable{

	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));  //1 address many elements 
	System.out.println("allDropDowns Count is: " + allDropDowns.size());
	for (WebElement dropdown : allDropDowns) 
	{
		if (dropdown.isDisplayed()) 
		{
			System.out.println("Dropdown is Visible");
			Select dropdownselect = new Select(dropdown);
				if (dropdown.getDomAttribute("title").equals("Day")) 
				{
					dropdownselect.selectByVisibleText("8");
					Thread.sleep(5000);
				} 
				else if (dropdown.getDomAttribute("title").equals("Month")) {
					dropdownselect.selectByVisibleText("Aug");
					Thread.sleep(5000);
				} 			
				else if (dropdown.getDomAttribute("title").equals("Year")) 
				{
					dropdownselect.selectByVisibleText("2000");
					Thread.sleep(5000);
				}
		} 
		else 
		{
			System.out.println("Dropdown is Invisible");
		}
	}
	}
	
	
	
	
	
	@Test
	public void selectYourDOBBySelectByValue() {

	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	System.out.println("allDropDowns Count is: " + allDropDowns.size());
	for (WebElement dropdown : allDropDowns) {
	if (dropdown.isDisplayed()) {
	System.out.println("Dropdown is Visible");
	Select dropdownselect = new Select(dropdown);
	if (dropdown.getDomAttribute("title").equals("Day")) {
	dropdownselect.selectByValue("22");
	} else if (dropdown.getDomAttribute("title").equals("Month")) {
	dropdownselect.selectByValue("6");
	} else if (dropdown.getDomAttribute("title").equals("Year")) {
	dropdownselect.selectByValue("1974");
	}
	} else {
	System.out.println("Dropdown is Invisible");
	}
	}
	}

	@Test
	public void selectYourDOBByselectByIndex() throws InterruptedException {

	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	System.out.println("allDropDowns Count is: " + allDropDowns.size());
	for (WebElement dropdown : allDropDowns) {
	if (dropdown.isDisplayed()) {
	System.out.println("Dropdown is Visible");
	Select dropdownselect = new Select(dropdown);
	if (dropdown.getDomAttribute("title").equals("Day")) {
	dropdownselect.selectByIndex(3);
	} else if (dropdown.getDomAttribute("title").equals("Month")) {
	dropdownselect.selectByIndex(7);
	} else if (dropdown.getDomAttribute("title").equals("Year")) {
	dropdownselect.selectByIndex(51);
	Thread.sleep(2000);
	}
	} else {
	System.out.println("Dropdown is Invisible");
	}
	}
	}
	
	
	
	@Test
	public void defaultselectedOptionInListBox() {
	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	System.out.println("allDropDowns Count is: " + allDropDowns.size());
	 for (WebElement dropdown : allDropDowns) 
	 {
		if (dropdown.isDisplayed()) 
		{
			// System.out.println("Dropdown is Visible");
			Select dropdownselect = new Select(dropdown);
			String defaultselectedOptionName = dropdownselect.getFirstSelectedOption().getText();
			System.out.println("defaultselectedOptionName: " + defaultselectedOptionName);
		}
	 }
	}
	
	
	
	
	@Test
	public void selectedOptionIsselected() {
	List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
	//System.out.println("allDropDowns Count is: " + allDropDowns.size());
		for (WebElement dropdown : allDropDowns) 
		{
			if (dropdown.isDisplayed()) 
			{
				System.out.println("Dropdown is Visible");
				Select dropdownselect = new Select(dropdown);
					if (dropdown.getDomAttribute("title").equals("Month")) 
					{
					dropdownselect.selectByVisibleText("Jan");
					}
					WebElement selectedOptionName = dropdownselect.getFirstSelectedOption();
					if(selectedOptionName.isSelected()) 
					{
					System.out.println("selectedOptionName: " + selectedOptionName.getText());
					}
			}
		}
	}	
	
	
	@Test
	public void typeOfDropdown() {
		WebElement dayDropdown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropdown);
		if (daySelect.isMultiple()) {
			System.out.println("Boolean True - Multi Select");
		} else {
			System.out.println("Boolean False - Single Select");
		}
	} 
	
		
	
		
}

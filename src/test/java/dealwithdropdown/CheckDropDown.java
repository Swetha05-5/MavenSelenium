package dealwithdropdown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepository.FaceBookSignUpPage;

public class CheckDropDown extends BaseClass {

	@Test
public void checkOptionsOrder() throws Throwable {
    List<String> expectedDayOptionName = new ArrayList<String>();
    List<String> actualDayOptionName = new ArrayList<String>();

    FaceBookSignUpPage fbSignUp = new FaceBookSignUpPage(driver);
    List<WebElement> allDropDowns = fbSignUp.getDobDropDowns();

    for (WebElement dropdown : allDropDowns) 
    {
        if (dropdown.getDomAttribute("title").equals("Day")) 
        {
            Select daySelect = new Select(dropdown);
            List<WebElement> allDayOptions = daySelect.getOptions();
            
            for (WebElement dayOption : allDayOptions) {
            	String actualDayOptionText = dayOption.getText();
            	System.out.println("actualDayOptionName: " + actualDayOptionText);
            	actualDayOptionName.add(actualDayOptionText);
            }
        }
    }

    short cellLimit = excelUtils.sheetCellLimit("dobdata", 0);
    for (short i = 0; i < cellLimit; i++) 
    {
        long expectedDayOption = (long) excelUtils.readNumericData("dobdata", 0, i);
        expectedDayOptionName.add(String.valueOf(expectedDayOption));
    }

    if (expectedDayOptionName.equals(actualDayOptionName)) {
        System.out.println("The Day DropDown Order is correct and it is verified");
        System.out.println(expectedDayOptionName);
        System.out.println(actualDayOptionName);
    }

    else 
    {
        System.out.println("The Day DropDown Order is Incorrect and it is verified");
        System.out.println(expectedDayOptionName);
        System.out.println(actualDayOptionName);
    }
		
		
	}
}

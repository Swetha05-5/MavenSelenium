package Excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel3 {

	public static void main(String[] args) throws Throwable {
		
		Workbook workbook= WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
				
		Sheet sheet=workbook.getSheet("dobdata");
		
		int firstRowIndex=sheet.getFirstRowNum();
		int lastRowIndex=sheet.getLastRowNum();
				
		
		for(int i=firstRowIndex;i<=lastRowIndex;i++)
		{
			Row row=sheet.getRow(i);
			short firstCellIndexCount=row.getFirstCellNum();
			System.out.println(firstCellIndexCount);
			short lastCellCount=row.getLastCellNum();
			System.out.println(lastCellCount);
		}
	}

}

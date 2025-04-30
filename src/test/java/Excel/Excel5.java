package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel5 {

	public static void main(String[] args) throws Throwable, Throwable, IOException {
		Workbook workbook= WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		
		Sheet sheet=workbook.getSheet("dobdata");
		
		int firstRowIndex=sheet.getFirstRowNum();
		int lastRowIndex=sheet.getLastRowNum();

		
		for(int i=firstRowIndex;i<=lastRowIndex;i++)
		{
			Row row=sheet.getRow(i);
			System.out.println("Row index is:"+ i);
			
			short firstCellIndexCount=row.getFirstCellNum();
			short lastCellCount=row.getLastCellNum();
			
			
			for(short j=firstCellIndexCount;j<lastCellCount;j++) 
			{
				CellType cellType=row.getCell(j).getCellType();
			
				if(String.valueOf(cellType).equals("NUMERIC"))
				{
					long numericData=(long)row.getCell(j).getNumericCellValue();
					System.out.println(numericData);
				}
				else if(String.valueOf(cellType).equals("STRING"))
				{
					String stringData=row.getCell(j).getStringCellValue();
					System.out.println(stringData);
				}
			}
		}
		workbook.close();
	}

}


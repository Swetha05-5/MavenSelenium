package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel4 {

	public static void main(String[] args) throws Throwable, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Workbook workbook= WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		
		Sheet sheet=workbook.getSheet("dobdata");
		
		Row row=sheet.getRow(5);
		Cell cell=row.getCell(5);
		
		
		CellType cellType=cell.getCellType();
		System.out.println(cellType);
		
	}

}

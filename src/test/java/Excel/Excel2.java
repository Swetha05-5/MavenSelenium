package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/trellodata.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("dobdata");
		
		int firstRowIndexCount=sheet.getFirstRowNum();
		System.out.println("firstrow="+firstRowIndexCount);
		
		int lastRowIndexCount=sheet.getLastRowNum();
		System.out.println("lastrow="+lastRowIndexCount);
		
		workbook.close();

	}
}

package com.trello.qsp.genericutility;

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

/**
 * @author Swetha P
 * This Class will be used to read the data from Excel Workbook.
 */
public class ExcelUtility {
	/**
	 * This method will be used to read the string data from the specific cell of
	 * the Excel workbook sheet.
	 * @param sheetName
	 * @param rowIndexCount
	 * @param cellIndexCount
	 * @return stringCellData
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readStringData(String sheetName, int rowIndexCount, int cellIndexCount)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workBook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		String cellData = workBook.getSheet(sheetName).getRow(rowIndexCount).getCell(cellIndexCount)
				.getStringCellValue();
		workBook.close();
		return cellData;
	}

	/**
	 * This method will be used to read the numeric data from the specific cell of
	 * the Excel workbook sheet.
	 * @param sheetName
	 * @param rowIndexCount
	 * @param cellIndexCount
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public double readNumericData(String sheetName, int rowIndexCount, int cellIndexCount)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		double cellData = workbook.getSheet(sheetName).getRow(rowIndexCount).getCell(cellIndexCount)
				.getNumericCellValue();
		workbook.close();
		return cellData;
	}

	/**
	 * This method will be used to check the cell data type.
	 * @param sheetName
	 * @param rowIndexCount
	 * @param cellIndexCount
	 * @return CellType
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public CellType checkCellType(String sheetName, int rowIndexCount, int cellIndexCount)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		CellType cellType = workbook.getSheet(sheetName).getRow(rowIndexCount).getCell(cellIndexCount).getCellType();
		workbook.close();
		return cellType;
	}
	/**
	 * This method will let us know the number of rows used in the grid sheet with it's index count.
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int sheetRowLimit(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		Sheet selectedSheet = workbook.getSheet(sheetName);
//		int firstRowIndex = selectedSheet.getFirstRowNum();
		int lastRowIndex = selectedSheet.getLastRowNum();
		workbook.close();
		return lastRowIndex;	
	}
	/**
	 * This method will let us know the number of cells used in each specific row of a selected sheet.
	 * @param sheetName
	 * @param rowIndexCount
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public short sheetCellLimit(String sheetName, int rowIndexCount) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		Row row=workbook.getSheet(sheetName).getRow(rowIndexCount);
//		short firstCellIndex = row.getFirstCellNum();
		short lastCellCount = row.getLastCellNum();
		workbook.close();
		return lastCellCount;
	}
	/**
	 * This method will be used to read the data from the cell of any type generally.
	 * @param sheetName
	 * @param rowIndexCount
	 * @param cellIndexCount
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDataFromCell(String sheetName, int rowIndexCount, int cellIndexCount) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/trellodata.xlsx"));
		Cell selectedCell = workbook.getSheet(sheetName).getRow(rowIndexCount).getCell(cellIndexCount);
		String cellType = String.valueOf(selectedCell.getCellType());
		String cellData = null;
		if (cellType.equals("NUMERIC")) {
			 cellData = String.valueOf((long)selectedCell.getNumericCellValue());
		}else if (cellType.equals("STRING")) {
			 cellData=selectedCell.getStringCellValue();
		}
		return cellData;
	}
	
}

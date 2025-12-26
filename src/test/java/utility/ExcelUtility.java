package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	// FileInputStream is used to read data from the Excel file
	static FileInputStream fle;
	
	// Workbook object represents the entire Excel workbook
	static XSSFWorkbook workbook;
	
	 // Sheet object represents a specific sheet inside the workbook
	static XSSFSheet sheet;
	
	public static String readExcel(int row,int cols) throws IOException {
		fle= new FileInputStream("C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\src\\test\\resources\\LoginData.xlsx");
		workbook=new XSSFWorkbook(fle);
		sheet=workbook.getSheetAt(0);
		
		//Reads data from an Excel cell using row and column index
		return sheet.getRow(row).getCell(cols).getStringCellValue();
		
	}
	
}

package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream fle;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public static String readExcel(int row,int cols) throws IOException {
		fle= new FileInputStream("C:\\Users\\Samitha Fathima\\OneDrive\\Pictures\\Desktop\\SDET\\Craftyfy\\CraftyfyProject\\src\\test\\resources\\LoginData.xlsx");
		workbook=new XSSFWorkbook(fle);
		sheet=workbook.getSheetAt(0);
		return sheet.getRow(row).getCell(cols).getStringCellValue();
		
	}
	
}

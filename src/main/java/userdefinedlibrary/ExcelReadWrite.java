package userdefinedlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	public static File src;
//	public static String exefilepath = "C:\\Users\\HP\\Downloads\\Booksearch.xlsx";
	public static String exefilepath = System.getProperty("user.dir") + "/Excel/SearchResult.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String va11;
	public static int row;
	public static int cell;
	public static XSSFRow Row;
	public static String category1;
	public static String category2;
	public static String category3;

	// READING THE DATA FROM AN EXCEL FILE

	public static String readexcel() {
		try {
			src = new File(exefilepath);
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {

				category1 = (sheet.getRow(i).getCell(0)).getStringCellValue();
				category2 = (sheet.getRow(i).getCell(1)).getStringCellValue();
				category3 = (sheet.getRow(i).getCell(2)).getStringCellValue();
//				System.out.println(category1);
//				System.out.println(category2);
//				System.out.println(category3);
			

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return category3;
	}

	// WRITING THE DATA TO AN EXCELFILE

	public static void writeexcel() {
		try {
			
			Property property = new Property();
	
			String col1 = null;
			String col2 = null;
			String col3 = null;
			
			try {
				col1 = property.readPropertiesFile("ExcelHeader1");
				col2 = property.readPropertiesFile("ExcelHeader2");
				col3 = property.readPropertiesFile("ExcelHeader3");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			List<String> colValue = new ArrayList<String>();
			colValue.add("Selenium Automation - Google Search");
			colValue.add("29");
			colValue.add("Success");


			// Create blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();

			// Create a blank sheet
			XSSFSheet spreadsheet = workbook.createSheet("test results ");

			// Create row object
			XSSFRow row;

			for (int i = 0; i < 2; i++) {

				row = spreadsheet.createRow(i);
				if (i == 0) {
					Cell cell = row.createCell(0);
					cell.setCellValue(col1);
					cell = row.createCell(1);
					cell.setCellValue(col2);
					cell = row.createCell(2);
					cell.setCellValue(col3);
				} else {
					int j = 0;
					for (String S : colValue) {

						Cell cell = row.createCell(j);
						cell.setCellValue(S);

						j++;
					}
				}

			}

			// Write the workbook in file system
//			FileOutputStream out = new FileOutputStream(new File("C:\\\\Users\\\\HP\\\\Downloads\\\\Booksearch.xlsx"));
			FileOutputStream out = new FileOutputStream(new File(exefilepath));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
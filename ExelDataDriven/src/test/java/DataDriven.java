
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int columnIndex = 0;
		int rowIndex = 0;
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"//src//XMLData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		int sheets = workbook.getNumberOfSheets();
		for(int i =0; i< sheets; i++) {
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("testData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> firstCell = firstRow.cellIterator();
				int k = 0;
				while(firstCell.hasNext()){
					Cell value = firstCell.next(); 
					if(value.getStringCellValue().equals("Testcases")) {
						columnIndex = k;
						break;
					}
					
					k++;
				};
				System.out.println(columnIndex);
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(columnIndex).getStringCellValue().equals("Purchase")){
						Iterator<Cell> cv = r.iterator();
						while(cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue()); 
						}
					}
				}
			}
		}

	}



}

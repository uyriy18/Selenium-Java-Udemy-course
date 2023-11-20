
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		// TODO Auto-generated method stub
		int columnIndex = 0;
		ArrayList<String> array = new ArrayList<String>();
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
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(columnIndex).getStringCellValue().equals(testcaseName)){
						Iterator<Cell> cv = r.iterator();
						while(cv.hasNext()) {
							Cell c = cv.next();
							if(c.getCellType() == CellType.STRING) {
								array.add(c.getStringCellValue());
							}
							else {
								array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return array;

	}



}

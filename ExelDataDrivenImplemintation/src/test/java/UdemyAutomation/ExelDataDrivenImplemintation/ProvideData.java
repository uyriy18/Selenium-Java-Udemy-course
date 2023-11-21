package UdemyAutomation.ExelDataDrivenImplemintation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProvideData {
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "exelDriven")
	public void testImplementation(String index, String testCase, String creds, String id) {
		System.out.println(index + " " + testCase + " " + creds + " " + id);
	}

	@DataProvider(name = "exelDriven")
	public Object[][] provideData() throws IOException {
		int columnNumber = 0;
		int rowsNumber = 0;
		Object[][] dataArray = null;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//java//UdemyAutomation//ExelDataDrivenImplemintation//TestExel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				rowsNumber = sheet.getPhysicalNumberOfRows();
				Row title = sheet.getRow(0);
				columnNumber = title.getPhysicalNumberOfCells();
				dataArray = new Object[rowsNumber - 1][columnNumber];
				for (int r = 0; r < rowsNumber - 1; r++) {
					Row row = sheet.getRow(r+1);
					for (int c = 0; c < columnNumber; c++) {
						Cell cell = row.getCell(c);
						String cellValue = formatter.formatCellValue(cell);
						dataArray[r][c] = cellValue;
					}
				}
			}

		}
		return dataArray;
	}

}

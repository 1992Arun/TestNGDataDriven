package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXL {


	public static Workbook wb;

	public static Sheet sheet;

	public static void main(String[] args) throws IOException {
		read();
	}

	
	@DataProvider(name="Search")
	public static String[][] read() throws IOException{

		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\Search.xlsx");
		
		FileInputStream is = new FileInputStream(f);

		wb = new XSSFWorkbook(is);

		sheet = wb.getSheet("Search");

		int rowno = sheet.getPhysicalNumberOfRows();

		short columnno = wb.getSheet("Search").getRow(0).getLastCellNum();

		String data[][] = new String[rowno-1][columnno];

		for(int i=1; i<rowno; i++) {

			Row row = sheet.getRow(i);

			for(int j=0; j<columnno; j++ ) {

				data[i-1][j]= cell(i,j);

             
			}

		}
			
		return data;	





	}

	public static String cell(int row, int column){

		Row row2 = sheet.getRow(row);

		String value;

		Cell cell = row2.getCell(column);

		int cellType = cell.getCellType();  

		if(cellType==1) {

			value = cell.getStringCellValue();

		} else if(DateUtil.isCellDateFormatted(cell)){

			Date date = cell.getDateCellValue();
			
			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
			
			 value = sd.format(date);



		} else {

			double num = cell.getNumericCellValue();

			long l = (long)num;

			value = String.valueOf(l);

		}

      
		
		

		return value;

	}
	
	
	
	@DataProvider(name="booking")
	public static String[][] read1() throws IOException{

		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\booking.xlsx");
		
		FileInputStream is = new FileInputStream(f);

		wb = new XSSFWorkbook(is);

		sheet = wb.getSheet("Search");

		int rowno = sheet.getPhysicalNumberOfRows();

		short columnno = wb.getSheet("Search").getRow(0).getLastCellNum();

		String data[][] = new String[rowno-1][columnno];

		for(int i=1; i<rowno; i++) {

			Row row = sheet.getRow(i);

			for(int j=0; j<columnno; j++ ) {

				data[i-1][j]= cell(i,j);

             
			}

		}
			
		return data;	





	}

	
	
	
}

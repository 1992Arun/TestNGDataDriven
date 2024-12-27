package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateXL {
	
	public static void main(String[] args) throws IOException {
		
		// write();
		
	//	write3();
		
		
	}
	
	
	public static void write() throws IOException{
		
		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\Search.xlsx");
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet sheet = wb.createSheet("Search");
		
		String data[][]= new String[][] 
				
				{{"Location", "Hotels","RoomType", "NoRooms", "ChekinDate","CheckOutdate", "Adults per Room", "Children per Room" },
			
			      {"Sydney", "Hotel Sunshine", "Standard", "1", "20/12/2024","21/12/2024", "2", "1"},
			      
			      {"London", "Hotel Hervey", "Deluxe", "2", "26/12/2024", "28/12/2024", "3", "2"},
			      
			      {"New York", "Hotel Cornice","Super Deluxe", "3", "30/12/2024", "31/12/2024", "4", "3" } };
		
		for(int i=0; i<data.length; i++) {
		
		Row row = sheet.createRow(i);
		
		
		
		short lastCellNum = row.getLastCellNum();
		
		for (int j=0; j<data[0].length; j++) {
		
		 Cell Cell0 = row.createCell(j);
		
		 Cell0.setCellValue(data[i][j]);
		 
		}
		 
		}
		
		FileOutputStream os = new FileOutputStream(f);
		
		wb.write(os);
		
		System.out.println("done");
		
	}
	
	
public static void write1() throws IOException{
		
		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\booking.xlsx");
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet sheet = wb.createSheet("Search");
		
		String data[][]= new String[][] 
				
				{{"FirstName", "Lastname", "Address", "CardNo", "CardType", "Expirymonth", "ExpiryYear", "Cvv"   },
			
			      { "Arun","Kumar","Tindivanam","1219027389274398", "VISA", "March", "2026", "213" },
			      
			      {"Kevin","France","Chennai","4927038729387498", "Master Card", "April", "2027", "726"},
			      
			      {"Navin","De","Bangalore","1982719827912808", "American Express", "May", "2028", "152"} };
		
		for(int i=0; i<data.length; i++) {
		
		Row row = sheet.createRow(i);
		
		
		
		short lastCellNum = row.getLastCellNum();
		
		for (int j=0; j<data[0].length; j++) {
		
		 Cell Cell0 = row.createCell(j);
		
		 Cell0.setCellValue(data[i][j]);
		 
		}
		 
		}
		
		FileOutputStream os = new FileOutputStream(f);
		
		wb.write(os);
		
		System.out.println("done");
		
	}


public static void write3(String OrderNo, String FirstName) throws IOException{
	
	File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\booking.xlsx");
	
	FileInputStream is = new FileInputStream(f);
	
	Workbook wb = new XSSFWorkbook(is);
	
	Sheet sheet = wb.getSheet("Search");
		
	Row row = sheet.getRow(0);
	
	Cell createCell = row.createCell(8);
	
	createCell.setCellValue("OrderNo");
          
  		int rowno = sheet.getPhysicalNumberOfRows()+1;

  		for(int i=1; i<rowno; i++) {
  			
  			Row row1 = sheet.getRow(i);
  			
  			int lastCellNum = row1.getLastCellNum()+1;
  			
  			Cell cell = row1.getCell(0);
  			
  			String stringCellValue = cell.getStringCellValue();
  			
  			if(stringCellValue.contains(FirstName)) {
  				
  				Cell createCell2 = row1.createCell(lastCellNum);
  				
  				createCell2.setCellValue(OrderNo);
  			}
  			
  			
  		}
		
	FileOutputStream os = new FileOutputStream(f);
	
	wb.write(os);
	
	System.out.println("done");
	
}




	

}
	
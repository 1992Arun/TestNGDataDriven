package org.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateXL {
	
	public static void main(String[] args) throws IOException {
		
		write();
		
	}
	
	
	public static void write() throws IOException{
		
		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\Search.xlsx");
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet sheet = wb.createSheet("Search");
		
		String data[][]= new String[][] 
				
				{{"Location", "Hotels","RoomType", "NoRooms", "ChekinDate","CheckOutdate", "Adults per Room", "Children per Room" },
			
			      {"Sydney", "Hotel Sunshine", "Standard", "1", "20/12/2024","21/12/2024", "2", "1"  },
			      
			      {"London", "Hotel Hervey", "Deluxe", "2", "26/12/2024", "28/12/2024", "3", "2" },
			      
			      {"New York", "Hotel Cornice","Super Deluxe", "3", "30/12/2024", "31/12/2024", "4", "3"  } };
		
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

}
	
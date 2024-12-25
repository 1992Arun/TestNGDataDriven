package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Adactlogin extends BaseClass {
	
	public static Workbook wb;
	
	public static Sheet sheet ;

	public static POMclass p;

	@BeforeClass
	public static void beforeClass() {


	}




	@BeforeMethod

	public void beforeMethod() {


	}



	@Test(dataProvider= "login", groups ="smoke", enabled=false )
	public void login(String user, String pass ) throws InterruptedException {

		SoftAssert s = new SoftAssert();

		browser("Chrome");

		//Login

		POMclass p = new POMclass();

		getURL("https://adactinhotelapp.com/");

		s.assertEquals(getCurrectURL(), "https://adactinhotelapp.com/");

		jsendKeys(p.getUsername(), user);

		s.assertEquals(getAttribute(p.getUsername()), user);



		jsendKeys(p.getPassword(), pass);

		s.assertEquals(getAttribute(p.getPassword()), pass);

		jClick(p.getLogin());

		s.assertTrue(getCurrectURL().contains("SearchHotel.php"));
		
		if(!getCurrectURL().contains("SearchHotel.php")) {
		
		quit();
		
		}
		
		
	}

		//SearchRoom
	
        @Test (dataProvider = "Search", dataProviderClass=ReadXL.class)
    		
	      public void search(String Location, String Hotels, String RoomType, String NoRooms, String Checkin, String Checkout, String Adult, String Child ) throws InterruptedException {
		
		  SoftAssert s = new SoftAssert();
        
	    	browser("Chrome");

	    	POMclass p = new POMclass();

		getURL("https://adactinhotelapp.com/");
		
		jsendKeys(p.getUsername(), "1992Arun");
		
		jsendKeys(p.getPassword(), "9862762829");


		jClick(p.getLogin());
		
		selectByText(p.getLocation(), Location);


		s.assertEquals(getAttribute(p.getLocation()), Location, "Location incorrect:");

		selectByText(p.getHotels(), Hotels);

		s.assertEquals(getAttribute(p.getHotels()), Hotels, "Hotel Name incorrect:");

		selectByText(p.getRoomType(), RoomType);

		s.assertEquals(getAttribute(p.getRoomType()), RoomType, "Hotel type incorrect:");
		
		SelectbyIndexs(p.getRoomNos(),  NoRooms);

		s.assertEquals(getAttribute(p.getRoomNos()), NoRooms, "Invalid number selected");

		jsendKeys(p.getCheckIN(), Checkin);

		s.assertEquals(getAttribute(p.getCheckIN()), Checkin, "Invalid date Given");

		jsendKeys(p.getCheckOut(), Checkout);

		s.assertEquals(getAttribute(p.getCheckOut()), Checkout, "Invalid date Given");

		SelectbyIndexs(p.getAdultRoom(), Adult);

		s.assertEquals(getAttribute(p.getAdultRoom()), Adult, "Invalid number selected");

				SelectbyIndexs(p.getChildtRoom(), Child);

		s.assertEquals(getAttribute(p.getChildtRoom()), Child, "Invalid number selected");

		jClick(p.getSearchRoom());

		s.assertTrue(getCurrectURL().contains("SelectHotel.php"),"Search button not cliked");
		

	
		jClick(p.getRadioButoon());

		s.assertTrue(p.getRadioButoon().isSelected(), "Search button not selected");

		jClick(p.getContinueButton());

//		s.assertTrue(getCurrectURL().contains("BookHotel.php"), "Continue button not cliked");
//
//		jsendKeys(p.getFirst_name(), "Arun" );
//
//		s.assertEquals(getAttribute(p.getFirst_name()), "Arun", "Invalid first name");
//
//		jsendKeys(p.getLast_name(), "Arun");
//
//		s.assertEquals(getAttribute(p.getLast_name()), "Arun", "Invalid last name");
//
//		jsendKeys(p.getAddress(), "Chennai" );
//
//		s.assertEquals(getAttribute(p.getAddress()), "Chennai", "Invalid address given");
//
//		jsendKeys(p.getCcNumber(), "9876762367326745");
//
//		s.assertEquals(getAttribute(p.getCcNumber()), "9876762367326745",  "Invalid cardnumber given");
//
//		selectByText(p.getCc_type(), "American Express");
//
//		s.assertEquals( getSelectbyText(p.getCc_type()), "American Express",  "Invalid CardType given");
//
//		selectByIndex(p.getCc_exp_month(), 8);
//
//		s.assertEquals( getSelectbyText(p.getCc_exp_month()), "August",  "Invalid month selected");
//
//		selectByText(p.getCc_exp_year(), "2029");
//
//		s.assertEquals(getAttribute(p.getCc_exp_year()), "2029", "Invalid year selected");
//
//		jsendKeys(p.getCc_cvv(), "928");
//
//		s.assertEquals(getAttribute(p.getCc_cvv()), "928", "Invalid Cvv given");
//
//		click(p.getBook_now());
//
//		sleep(5);
//
//		s.assertTrue(getCurrectURL().contains("BookingConfirm.php"), "Booking not confirmed");
//
//		printText(p.getOrder_no());
//
//
//
//		s.assertEquals(webStringlength(p.getOrder_no()), 10, "Order number not generated ");
//
//		s.assertAll();
//		
		quit();
		
        }





	

	@DataProvider(name ="login")
	public static String[][] read() throws InvalidFormatException, IOException{
		
		
		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\adact.xlsx");
		
		FileInputStream is = new FileInputStream(f);

		 wb = new XSSFWorkbook(is);

		 sheet = wb.getSheet("Login");
		 
		 int rowno = sheet.getPhysicalNumberOfRows();
		 
		 Row row2 = sheet.getRow(0);
		 
		 int columnno = row2.getLastCellNum();
		
		
		String data[][]= new String[rowno-1][columnno];

			//	{{"UserName", "PassWord"}, {"Arun", "237923"}, {"Kevin", "120812"}, {"Navin", "12081"}, {"1992Arun", "9862762829"}   };


				for(int i=1; i<rowno; i++) {

				
					Row row1 = sheet.getRow(i);
					
					

					data[i-1][0]= cell(i,0);
					
					data[i-1][1]= cell(i,1);

					


				}
				return data;		
		
		
	}
	
	
	
	public static String cell(int r, int column){
		
		String value;
		 
		 Row row = sheet.getRow(r);
		 
		 Cell cell = row.getCell(column);
		 
		 int cellType = cell.getCellType();
		 
		 if(cellType==1) {
			 
			  value = cell.getStringCellValue();
			  
		 } else if (DateUtil.isCellDateFormatted(cell)) {
			 
			 Date date = cell.getDateCellValue();
			 
			  SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
			  
			   value = sm.format(date);
			   
		 } else {
			 
			 double num = cell.getNumericCellValue();
			 
			   long l = (long)num;
			   
			    value = String.valueOf(l);
		 }
		 
		return value;
			 
			 
			 
		 }
		 
		 
		
		
		
		
		

	
	@Test(enabled=false)
	public static void print() throws IOException, InvalidFormatException {


		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\adact.xlsx");

		Workbook wb = new XSSFWorkbook();

		Sheet sheet = wb.createSheet("Login");

		String data[][]= new String[][] 

				{{"UserName", "PassWord"}, {"Arun", "237923"}, {"Kevin", "120812"}, {"Navin", "12081"}, {"1992Arun", "9862762829"}   };


				for(int i=0; i<data.length; i++) {

					Row row = sheet.createRow(i);
					
					Row row1 = sheet.getRow(i);

					Cell cell = row.createCell(0);

					cell.setCellValue(data[i][0]);

					Cell cell1 = row.createCell(1);

					cell1.setCellValue(data[i][1]);


				}		

				FileOutputStream os = new FileOutputStream(f);

				wb.write(os);



	}
	
	
	 @Test (dataProvider = "Search", dataProviderClass=ReadXL.class, enabled=false)

	 public void search1(String Location, String Hotels, String RoomType, String NoRooms, String Checkin, String Checkout, String Adult, String Child){
		 
		 System.out.println(Location);
		 System.out.println(Hotels);
		 System.out.println(NoRooms);
		 System.out.println(Checkin);
		 System.out.println(Checkout);
		 System.out.println(Adult);
		
		 
		 
	 }


	@AfterMethod
	public void afterMethod() {


	}

	@AfterClass
	public static void afterClass() {

		//quit();
	}

}
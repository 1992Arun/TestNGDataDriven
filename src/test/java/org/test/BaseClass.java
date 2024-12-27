package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browser(String browser) {


		if(browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();

		} else if(browser.equalsIgnoreCase("Edger")) {

			driver = new EdgeDriver();

		}else if(browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		}

		return driver;

	}

	public static String getURL(String URL){

		driver.get(URL);

		return URL;


	}


	public static String getText(WebElement e){


		String text = e.getText();



		return text;


	}

	public static int webStringlength(WebElement e){

		String attribute = e.getAttribute("value");


		return attribute.length();
	}

	public static String printText(WebElement e){

		String text = e.getAttribute("value");

		System.out.println(text);

		return text;
	}


	public static String getCurrectURL() {

		return driver.getCurrentUrl();
	}

	public static void implicitWait(int time){

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		driver.manage().window().maximize();
	}


	public static String getAttribute(WebElement e) {

		return e.getAttribute("value");
	}

	public static void selectByText(WebElement e, String text) {

		Select s = new Select(e);

		s.selectByVisibleText(text);

	}


	public static void selectByIndex(WebElement e, int num) {

		Select s = new Select(e);

		s.selectByIndex(num);


	}


	public static void click(WebElement e) {

		Actions a = new Actions(driver);

		a.click(e).perform();
	}


	public static void mouseover(WebElement e) {

		Actions a = new Actions(driver);

		a.moveToElement(e).perform();
	}


	public static void rightClick(WebElement e) {

		Actions a = new Actions(driver);

		a.contextClick(e).perform();
	}


	public static void dragAndDrop(WebElement src, WebElement des) {

		Actions a = new Actions(driver);

		a.dragAndDrop(src, des).perform();


	}

	public static void doubleClick(WebElement e){

		Actions a = new Actions(driver);

		a.doubleClick(e).perform();

	}

	public static void copy() throws AWTException {

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

	}

	public static void paste() throws AWTException {

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	public static String timeStamp() {

		SimpleDateFormat s = new SimpleDateFormat("ss-mm-hh");

		return s.format(new Date());


	}





	public static void clickSaveImage(String search) throws AWTException, InterruptedException{

		Robot r = new Robot();



		for(int i=0; i<7; i++) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_V);
		}

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		StringSelection	FileSelection  = new StringSelection("C:\\Users\\Arun\\Pictures\\");



		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileSelection, null);

		sleep(5);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);



		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		sleep(5);

		StringSelection	FileSelection1  = new StringSelection(search);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileSelection1, null);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}



	public static void upload(WebElement e) throws AWTException, InterruptedException {

		click(e);

		StringSelection	FileSelection  = new StringSelection("C:\\Users\\Arun\\Pictures\\ima.png");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileSelection, null);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		sleep(5);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);



	}

	public static void download(WebElement e) throws AWTException, InterruptedException {

		click(e);





	}



	public static void sleep(int time) throws InterruptedException{

		Thread.sleep(time*1000);
	}


	public static void sendKeys(WebElement e, String value){

		e.sendKeys(value);
	}

	public static void jClick(WebElement e){

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();", e);


	}

	public static void jsendKeys(WebElement e, String value){

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].value='"+ value +"';", e);


	}


	public static String getSelectbyText(WebElement e){

		Select s = new Select(e);

		String text = s.getFirstSelectedOption().getText();


		return text;
	} 



	public static String SelectbyValue(WebElement e, String value){

		Select s = new Select(e);

		s.selectByValue(value);


		return value;
	} 




	public static String SelectbyIndexs(WebElement e, String value){

		Select s = new Select(e);

		int parseInt = Integer.parseInt(value);

		s.selectByIndex(parseInt);


		return value;
	} 

	public static void takeScreenshot() throws IOException{

		TakesScreenshot ts = (TakesScreenshot)driver;

		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(screenshotAs, new File("F:\\Arun\\Screenshots"));


	}
	
	


	public static void write(String OrderNo, String name ) throws IOException{
		
		File f = new File("C:\\Users\\Arun\\Desktop\\Datadriven\\booking.xlsx");
		
		FileInputStream is = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(is);
		
		Sheet sheet = wb.getSheet("Search");
			
		Row row = sheet.getRow(0);
		
		Cell createCell = row.createCell(8);
		
		createCell.setCellValue("OrderNo");
	          
	  		int rowno = sheet.getPhysicalNumberOfRows();
	  		
	  		System.out.println(rowno);

	  		for(int i=1; i<rowno; i++) {
	  			
	  			Row row1 = sheet.getRow(i);
	  				
	  			int lastCellNum = row1.getLastCellNum();
	  			
	  			System.out.println(lastCellNum);
	  			
	  			Cell cell = row1.getCell(0);
	  			
	  			String stringCellValue = cell.getStringCellValue();
	  			
	  			if(stringCellValue.contains(name)) {
	  				
	  				Cell createCell2 = row1.createCell(lastCellNum);
	  				
	  				createCell2.setCellValue(OrderNo);
	  			}
	  			
	  			
	  		}
			
		FileOutputStream os = new FileOutputStream(f);
		
		wb.write(os);
		
		//System.out.println("done");
		
	}



	public static void quit() {

		driver.quit();
	}

}

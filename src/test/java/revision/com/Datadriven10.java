package revision.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import base.com.Baseclass;

public class Datadriven10 {

	public static void main(String[] args) throws Exception {
		
		Baseclass global=new Baseclass();
		
		WebDriver driver = global.launchBrowser();
		global.loadurl(driver, "http://www.adactin.com/HotelApp");
		
		File exloc=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx");
		FileInputStream stream=new FileInputStream(exloc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet0");
		
	
		WebElement username = driver.findElement(By.id("username"));
		global.insertText(username, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 0));

		WebElement passw = driver.findElement(By.id("password"));
		global.insertText(passw, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 1));
		
		WebElement logbtn = driver.findElement(By.id("login"));
		global.btnclic(logbtn);
		
		WebElement loc = driver.findElement(By.id("location"));
		global.insertText(loc, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 2));
		
		WebElement hotel = driver.findElement(By.id("hotels"));
		global.insertText(hotel, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 3));
		
		WebElement roomtype = driver.findElement(By.id("room_type"));
		global.insertText(roomtype, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 4));
		
		WebElement noofrooms = driver.findElement(By.id("room_nos"));
   global.insertText(noofrooms, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 5));
   
   WebElement checkin = driver.findElement(By.id("datepick_in"));
   global.insertText(checkin, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 6));
   
   WebElement checkout = driver.findElement(By.id("datepick_out"));
   global.insertText(checkout, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 7));

   WebElement adultroom = driver.findElement(By.id("adult_room"));
   global.insertText(adultroom, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 8));
   
   WebElement submit = driver.findElement(By.id("Submit"));
   global.webdriverWait(driver, submit);
   
   WebElement radio = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
   global.btnclic(radio);
   
   WebElement cont = driver.findElement(By.id("continue"));
   global.webdriverWait(driver, cont);

WebElement firsname = driver.findElement(By.id("first_name"));
global.insertText(firsname,global.getDatafromExcel( "C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 9));
   
WebElement lastname = driver.findElement(By.id("last_name"));
global.insertText(lastname,global.getDatafromExcel( "C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 10));

WebElement addr = driver.findElement(By.id("address"));
global.insertText(addr, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 11));

WebElement cardno = driver.findElement(By.xpath("//input[@name='cc_num']"));
global.insertText(cardno,global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 12));

WebElement cardtype = driver.findElement(By.xpath("//select[@name='cc_type']"));
global.insertText(cardtype, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 13));

WebElement expmonth = driver.findElement(By.id("cc_exp_month"));
global.insertText(expmonth, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 14));

WebElement expyr = driver.findElement(By.id("cc_exp_year"));
global.insertText(expyr, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 15));

WebElement cvv = driver.findElement(By.id("cc_cvv"));
global.insertText(cvv, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adap04.xlsx", "Sheet0", 0, 16));

WebElement booknow = driver.findElement(By.id("book_now"));
global.webdriverWait(driver, booknow);

Thread.sleep(10000);
  WebElement orderno = driver.findElement(By.xpath("//input[@name='order_no']")); 
  String at =orderno.getAttribute("value"); 
  System.out.println(at);
 


Row r1 = s.getRow(0);
int lastCellNum = r1.getLastCellNum();
Cell c1 = r1.createCell(lastCellNum);
c1.setCellValue(at);


FileOutputStream o=new FileOutputStream(exloc);
w.write(o);



	}

}
/*
URL :  http://www.adactin.com/HotelApp
NOTE: Create an excel sheet with all details required for Hotel Booking .
  Create a maven project. 
  Book a hotel using above url by getting the input data  from excel sheet.
  Update the orderNo generated after hotel booking in excel sheet using DataDriven.*/
package revision.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriventask5 {

	public static void main(String[] args) throws Exception {
		
	File exloc	=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\adaptin3.xlsx");
	
	Workbook w=new XSSFWorkbook();
	Sheet sh = w.createSheet("adaptin");
	Row cr = sh.createRow(0);
	Cell c1 = cr.createCell(0);
	Cell c2 = cr.createCell(1);
	Cell c3 = cr.createCell(2);
	Cell c4 = cr.createCell(3);
	Cell c5 = cr.createCell(4);
	Cell c6 = cr.createCell(5);
	Cell c7 = cr.createCell(6);
	Cell c8 = cr.createCell(7);
	Cell c9 = cr.createCell(8);
	
	c1.setCellValue("sam202203");
	c2.setCellValue("123456789");
	c3.setCellValue("Sydney");
	c4.setCellValue("Hotel Creek");
	c5.setCellValue("Double");
	c6.setCellValue("1 - One");
	c7.setCellValue("17/02/2024");
	c8.setCellValue("17/02/2024");
	c9.setCellValue("1 - One");
     
	FileOutputStream o=new FileOutputStream(exloc);
	w.write(o);
System.out.println("done");
	}

}
/*
 * URL : http://www.adactin.com/HotelApp/
 * NOTE: Create an excel sheet with all details required for Hotel Booking .
 */
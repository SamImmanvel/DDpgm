package revision.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.com.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatadriverTask8 {

	public static void main(String[] args) throws Exception {
		
		Baseclass global=new Baseclass();
	File exloc=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\demoreg.xlsx");
	FileInputStream stream=new FileInputStream(exloc);
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Logindetails");
	Row r = s.getRow(0);
	Cell c = r.getCell(0);
	int type = c.getCellType().getCode();
	if (type==1) {
		String value = c.getStringCellValue();
	}
	else {
		double d = c.getNumericCellValue();
		long l=(long)d;
		String value = String.valueOf(l);
	}
	WebDriver driver = global.launchBrowser();

global.loadurl(driver, "https://demoqa.com/register/");
	

WebElement fn = driver.findElement(By.id("firstname"));
global.insertText(fn, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\demoreg.xlsx", "Logindetails", 0, 0));
WebElement ln = driver.findElement(By.id("lastname"));
global.insertText(ln, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\demoreg.xlsx", "Logindetails", 0, 1));
WebElement un = driver.findElement(By.id("userName"));
global.insertText(un, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\demoreg.xlsx", "Logindetails", 0, 2));
WebElement psw = driver.findElement(By.id("password"));
global.insertText(psw, global.getDatafromExcel("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\demoreg.xlsx", "Logindetails", 0, 3));




}
	
	}


/*
 * URL : https://demoqa.com/register/
 * NOTE: Create an excel sheet with all required details for registration .
 * Register the form by getting the input data from excel sheet using DataDriven
 * and execute in maven.
 */
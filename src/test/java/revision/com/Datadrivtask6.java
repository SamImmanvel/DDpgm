package revision.com;

import java.io.File;
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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datadrivtask6 {

	public static void main(String[] args) throws Exception {

		File exloc=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\fb.xlsx");
		Workbook w=new XSSFWorkbook();
		Sheet s = w.createSheet("Logindetails");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("sam");
		Cell c1 = r.createCell(1);
		c1.setCellValue("12356");
		
		FileOutputStream o=new FileOutputStream(exloc);
		w.write(o);
		System.out.println("done");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement email = driver.findElement(By.id("email"));
		
		WebElement pass = driver.findElement(By.id("pass"));
		Row rr = s.getRow(0);
		Cell cc = rr.getCell(0);
		String username = cc.getStringCellValue();
		Cell cc1 = rr.getCell(1);
		String pswdd = cc.getStringCellValue();
		
		email.sendKeys(username);
		pass.sendKeys(pswdd);
		
		
	}

}
/*
 * URL : https://www.facebook.com/
 * NOTE: Create an excel sheet for facebook email and password. Login in to
 * facebook by getting the input data from excel sheet using DataDriven and
 * execute in maven.
 */


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

public class Datadriven7 {

	public static void main(String[] args) throws Exception {
File exloc=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\fb1.xlsx");

Workbook w=new XSSFWorkbook();
Sheet s = w.createSheet("fbdetailssheet");
Row r = s.createRow(0);
Cell c = r.createCell(0);
Cell c1 = r.createCell(1);
c.setCellValue("sam");
c1.setCellValue("123456");

FileOutputStream o=new FileOutputStream(exloc);
w.write(o);

WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
WebElement email = driver.findElement(By.id("email"));
WebElement pass = driver.findElement(By.id("pass"));

Row rr = s.getRow(0);
Cell cc = rr.getCell(0);
String username = cc.getStringCellValue();

Row rr1 = s.getRow(0);
Cell cc1 = rr1.getCell(1);
String passs = cc1.getStringCellValue();


email.sendKeys(username);
pass.sendKeys(passs);

WebElement btnclic = driver.findElement(By.xpath("//button[@value='1']"));
btnclic.click();


WebElement erroal = driver.findElement(By.xpath("//div[contains(text(),'to an account')]"));
String text = erroal.getText();
System.out.println(text);

Row errordetai = s.createRow(1);
Cell cellupdate = errordetai.createCell(0);
cellupdate.setCellValue(text);
FileOutputStream o1=new FileOutputStream(exloc);
w.write(o1);





	}

}

/*
 * URL : https://www.facebook.com/
 * NOTE: Create an excel sheet for facebook email and password. Create a project
 * in maven. Login in to facebook by getting the input data from excel sheet.
 * Update the successful login or error message generated after login in excel
 * sheet using DataDriven.
 */
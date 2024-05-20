package revision.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amzonprintall {

	public static void main(String[] args) throws Exception, IOException {
 WebDriverManager.chromedriver().setup();
 WebDriver driver=new ChromeDriver();
 driver.get("https://www.amazon.in/");
	
	 WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
	  searchbox.sendKeys("iphone",Keys.ENTER);
	 
	  List<WebElement> liamz = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		/*
		 * for (WebElement we : liamz) { String text = we.getText();
		 * System.out.println(text); }
		 */
     
     
    Workbook w=new XSSFWorkbook();
    Sheet s = w.createSheet("iphonelist");
    Row r = s.createRow(0);
    Cell c = r.createCell(0);
    c.setCellValue("product name");
    
    for (int i = 0; i <liamz.size(); i++) {
    	Row datarow = s.createRow(i+1);
    	Cell datacell = datarow.createCell(i);
    	datacell.setCellValue(liamz.get(i).getText());
		
	}
    
    
    File exloc =new File ("amazon.xlsx");
    FileOutputStream o=new FileOutputStream(exloc);
    w.write(o);
 
		
		
		
		
	}

}

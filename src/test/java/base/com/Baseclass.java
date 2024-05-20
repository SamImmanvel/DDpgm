package base.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
static WebDriver driver;
	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		return driver;
	}
	public void loadurl(WebDriver driver ,String url) {
    driver.get(url);
	}
	public void insertText(WebElement re,String data) {
		re.sendKeys(data);

	}
	public String getDatafromExcel(String loc, String sheet,int row,int cell) throws Exception {
		String value = null;
		File excloc=new File(loc);
		FileInputStream stream=new FileInputStream(excloc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType().getCode();
		
		if (type==1) {
			 value = c.getStringCellValue();
		}if (type==0) {
			boolean cf = DateUtil.isCellDateFormatted(c);
			if (cf) {
				Date dcv = c.getDateCellValue();
				SimpleDateFormat form=new SimpleDateFormat("dd-mm-yyyy");
				 value = form.format(dcv);
			}
		
		else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			 value = String.valueOf(l);
		}
		}
		
		return value;
     
	}
		
public void btnclic(WebElement ee) {
	ee.click();
}
public void webdriverWait(WebDriver driver,WebElement submit2) {
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submit2));
submit.click();
		
}	

public void getattri(WebElement ee,String data) {
String at = ee.getAttribute(data);
System.out.println(at);
}

}

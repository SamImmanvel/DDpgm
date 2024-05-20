package revision.com;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;




public class Revisiontask1 {
	public static void main(String [] args) throws Exception {
		String value;
File exl=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\Excel\\bookin.xlsx");
FileInputStream stream=new FileInputStream(exl);

Workbook w=new XSSFWorkbook(stream);
Sheet s = w.getSheet("Sheet1");
for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
	Row r = s.getRow(i);
	for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
		Cell c = r.getCell(j);
		int type = c.getCellType().getCode();
		if (type ==1) {
			 value = c.getStringCellValue();
			System.out.println(value);
		}if (type==0) {
			boolean cdf = DateUtil.isCellDateFormatted(c);
			if (cdf) {
				Date dcv = c.getDateCellValue();
				SimpleDateFormat f=new SimpleDateFormat("dd-MM-YYYY");
				 value = f.format(dcv);
						}
		else {
			double ncv = c.getNumericCellValue();
			long l=(long)ncv;
			 value = String.valueOf(l);
			System.out.println(value);
		}
		
	}
	
}

}}}
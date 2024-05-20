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

public class Tas1 {

	public static void main(String[] args) throws Exception {
File exloc=new File("C:\\Users\\OCS-28\\eclipse-workspace\\DataDriven\\Studentdetails.xlsx");
FileInputStream stream=new FileInputStream(exloc);
Workbook w=new XSSFWorkbook(stream);
Sheet s = w.getSheet("iphonelist");

  int pnr = s.getPhysicalNumberOfRows();
  System.out.println("Total no of rows :"+pnr);
  
  Row r = s.getRow(0);
  int pnc = r.getPhysicalNumberOfCells();
  System.out.println("Total no of cells :"+pnc);
  
  for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
	  Row rr = s.getRow(i);
	  for (int j = 0; j <rr.getPhysicalNumberOfCells(); j++) {
		  Cell cc = rr.getCell(j);
		System.out.println(cc);
	}
}
  Row createrow = s.createRow(5);
	Cell createcell = createrow.createCell(0);
	createcell.setCellValue("hola");
	Cell createcell1 = createrow.createCell(1);
	createcell1.setCellValue("MA");
	FileOutputStream o=new FileOutputStream(exloc);
	w.write(o);
	System.out.println("done");
  

	}

}

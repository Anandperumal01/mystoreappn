package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
	
		fi=new FileInputStream(xlfile);  //Loading the Particular file
		wb=new XSSFWorkbook(fi);   // Worbook
		ws=wb.getSheet(xlsheet);   // sheet
		int rowcount=ws.getLastRowNum();  //in worksheet it will go and bring last used data
		//int physicalrowcount=ws.getPhysicalNumberOfRows();
		return rowcount;
		
	}
	
	
	public static int getcolCount(String xlfile, String xlsheet, int rownum) throws IOException {
		// the column number starts from zero
		// when it is returning the count ====> actual output will be plus one
		fi=new FileInputStream(xlfile);  //Loading the Particular file
		wb=new XSSFWorkbook(fi);   // Worbook
		ws=wb.getSheet(xlsheet);   // sheet
		row=ws.getRow(rownum);    // to set any row in xl
		int colcount=row.getLastCellNum();  //in worksheet it will go and bring last used last column
		return colcount;
		
	}
	public static String getcellvalue(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		// rum num-0
		// col num -0
		fi=new FileInputStream(xlfile);  //Loading the Particular file
		wb=new XSSFWorkbook(fi);   // Worbook
		ws=wb.getSheet(xlsheet);   // sheet
		row=ws.getRow(rownum);    // to set any row in xl
		cell=row.getCell(colnum);  // to set any col value
		String data;
		try {
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
		}catch(Exception e) {
			data="";
			//e.printStackTrace();
		}
		
		
		return data;
		
	}
	

	
}

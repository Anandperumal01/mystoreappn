package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class DataProviders {
	
	@DataProvider(name="Userdata")
	public String[][] getData() throws IOException {
		System.out.println("output of sysytem getproperty "+System.getProperty("user.dir"));
		String excelFilePath=System.getProperty("user.dir")+"\\TestData\\UserData.xlsx";
		String sheetName="Sheet1";
		int rowCount=XLUtils.getRowCount(excelFilePath, sheetName);
		int colCount=XLUtils.getcolCount(excelFilePath, sheetName,1);
		System.out.println("the row count is ==>"+rowCount);
		System.out.println("the row count is ==>"+colCount);
		String[][] data=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				data[i-1][j]=XLUtils.getcellvalue(excelFilePath, sheetName, i, j);
				System.out.println("the value of each cell"+data[i-1][j]);
			}
		}
		
		
		return data;
		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		System.out.println("output of sysytem getproperty "+System.getProperty("user.dir"));
		String excelFilePath=System.getProperty("user.dir")+"\\TestData\\UserData.xlsx";
		String sheetName="Sheet1";
		int rowCount=XLUtils.getRowCount(excelFilePath, sheetName);
		//int colCount=XLUtils.getcolCount(excelFilePath, sheetName,1);
		System.out.println("the row count is ==>"+rowCount);
	//	System.out.println("the row count is ==>"+colCount);
		String[] data=new String[rowCount];
		for(int i=1;i<=rowCount;i++) {
				
				data[i-1]=XLUtils.getcellvalue(excelFilePath, sheetName, i, 0);
				System.out.println("the value of each cell"+data[i-1]);
		
		}
		
		
		return data;
		
	}


}

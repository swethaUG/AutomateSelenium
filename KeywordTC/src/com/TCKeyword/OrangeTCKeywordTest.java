package com.TCKeyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class OrangeTCKeywordTest {
	OrangeKeywordTCLogin keys = new OrangeKeywordTCLogin ();
	OrangeTCKeywordTest() throws IOException
	{
	FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/KeywordTC/ReadKeywordTC.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	int rcount = sheet.getLastRowNum();
	for(int i=1;i<rcount;i++)
	{
		Row r=sheet.getRow(i);
		String runmode = r.getCell(4).getStringCellValue();
		if(runmode.equals("Y"))
		{
			String keyword = r.getCell(3).getStringCellValue();
			if(keyword.equals("launchBrowser"))
			{
				keys.launchBrowser();
			}
			else if(keyword.equals("navigate"))
			{
				keys.navigate();
			}
			else if(keyword.equals("loginName"))
			{
				keys.loginName();
			}
			else if(keyword.equals("password"))
			{
				keys.password();
			}
			else if(keyword.equals("login"))
			{
				keys.login();
			}
	   }
	
	}
}

}

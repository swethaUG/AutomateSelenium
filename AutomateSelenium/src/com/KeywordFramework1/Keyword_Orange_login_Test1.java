package com.KeywordFramework1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Keyword_Orange_login_Test1 extends Keyword_Orange_Login1{
	@Test
	public Keyword_Orange_login_Test1() throws IOException 
	{
		Keyword_Orange_Login1 keys = new Keyword_Orange_Login1();
		FileInputStream f = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/OrangeLogin.properties");
		Properties pr = new Properties();		
		pr.load(f);
		String pname = pr.getProperty("LoginName");
		System.out.println(pname);
		String ppassword = pr.getProperty("pword");
		System.out.println(ppassword);
		String press = pr.getProperty("submit");
		System.out.println(press);
		FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/ReadKeywordTC.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row r = null;
		int rcount = sheet.getLastRowNum();
		System.out.println("r count is"+rcount);
		FileInputStream file1 = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/ReadKeywordTC.xlsx");
		XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
		XSSFSheet sheet1 = workbook.getSheet("Sheet2");
		Row r1 = null;
		int rcount1 = sheet1.getLastRowNum();
		System.out.println("r1 count is"+rcount1);
		for(int j=1;j<=rcount1;j++)
		{ 
    	  r1=sheet1.getRow(j);
		     for(int i=1;i<=rcount;i++)
		     {
			      r= sheet.getRow(i);
			      String runmode = r.getCell(4).getStringCellValue();
			      if(runmode.equals("Y"))
			      {
				        String keyword = r.getCell(3).getStringCellValue();
				        if(keyword.equals("browserlaunch"))
				        {
					      keys.browserLaunch();
				        }
				        else if(keyword.equals("browsernavigate"))
				        {
					      keys.browserNavigate();
				        }
				        else if(keyword.equals("loginname"))
				        {
				    	  keys.loginname(pname,r1.getCell(0).getStringCellValue());
				        }
				       else if(keyword.equals("Pass"))
				        {
				 	      keys.password(ppassword,r1.getCell(1).getStringCellValue());
				        }
				       else if(keyword.equals("login"))
				        {
					      keys.click(press);
					     
				        }
				        
			       }
			      
			  }
		     
   
		 }	
		
	}


}

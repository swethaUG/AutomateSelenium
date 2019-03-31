package com.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Valid {

	
		public static void main(String[] args) throws IOException, InterruptedException {
			WebDriver driver=null;
			String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
			System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/Readfile.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			int rcount = sheet.getLastRowNum();
			Row r= sheet.getRow(1);
			int ccount = r.getLastCellNum();
			System.out.println(ccount);
			String Expected_Element="Welcome admin";
			for(int i=1;i <=rcount;i++)
				{
				   for(int j=0;j<ccount-1;j++)
				   {
				System.out.println(i);
				driver.findElement(By.name("txtUserName")).sendKeys(sheet.getRow(i).getCell(j).getStringCellValue());
				driver.findElement(By.name("txtPassword")).sendKeys(sheet.getRow(i).getCell(i).getStringCellValue());
				driver.findElement(By.name("Submit")).click();
				String Actual_Element = driver.getPageSource();
				if(Actual_Element.contains(Expected_Element))
				{
					 System.out.println("Login validation is sucessfull,PASS");
					 sheet.getRow(i).createCell(2).setCellValue("Login validation is sucessfull,PASS");
				}
				else
				{
					System.out.println("Login validation is unsucessfull,Fail");
					sheet.getRow(i).createCell(2).setCellValue("Login validation is sucessfull,FAIL");
					File ErrorScreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(ErrorScreen,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/ErrorScreens/"+i+".png"));
				}
				FileOutputStream file1= new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Result.xlsx");
				workbook.write(file1);
			    Thread.sleep(2000);
				driver.navigate().back();
				driver.findElement(By.name("clear")).click();
				
			}		
	     }			

	}

}

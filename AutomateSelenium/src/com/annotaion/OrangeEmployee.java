package com.annotaion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OrangeEmployee extends OrangeBase {
@Test(priority=0)
public void logIn() throws IOException
{
	FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/OrangeBAseLOgin.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("sheet1");
	Row r = sheet.getRow(1);
	driver.findElement(By.name("txtUserName")).sendKeys(r.getCell(0).getStringCellValue());
	driver.findElement(By.name("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
	driver.findElement(By.name("Submit")).click();
}
@Test(priority=1)
public void addEmployee() throws Throwable
{
	FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/Employeedata.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("sheet1");
	int rcount = sheet.getLastRowNum();
	for(int i=1;i <=rcount;i++)
	{
		System.out.println(i);
		Row r=sheet.getRow(i);
		WebElement a=driver.findElement(By.cssSelector("#pim > a > span"));
	    Actions act= new Actions(driver);
	    act.moveToElement(a).perform();
	    driver.findElement(By.cssSelector("#pim > ul > li:nth-child(2) > a > span")).click();
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    String ExpectedCode = driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		System.out.println("Expected Employee code is"+ExpectedCode );
	    driver.findElement(By.id("txtEmpLastName")).sendKeys(r.getCell(2).getStringCellValue());;
	    driver.findElement(By.name("txtEmpFirstName")).sendKeys(r.getCell(3).getStringCellValue());
	    driver.findElement(By.id("txtEmpMiddleName")).sendKeys(r.getCell(4).getStringCellValue());
	    driver.findElement(By.id("txtEmpNickName")).sendKeys(r.getCell(5).getStringCellValue());
	    driver.findElement(By.id("btnEdit")).click();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
	    String ActualCode = driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
	    System.out.println("The Actual Employee Code is"+ActualCode);
	    try
	    {
	        if(ActualCode.equals(ExpectedCode))
	          {
		          System.out.println("Employee is added sucessfully");
		          r.createCell(6).setCellValue("Employee is added sucessfully");
	          }
	        else 
	          {
	    	   throw new Exception();
		      }
	    }    
	   catch(Exception e)
	   {
               System.out.println("Employee is not added sucessfully");
               r.createCell(6).setCellValue("Employee is not added sucessfully");
               File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/ErroeScreen.png"));
	   }
	    
	  driver.switchTo().defaultContent(); 
	  FileOutputStream file1= new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Employee Result.xlsx");
	  workbook.write(file1);
      driver.navigate().back();
	}
	
	driver.findElement(By.xpath("//*[@id='option-menu']/li[3]/a")).click();
}

}

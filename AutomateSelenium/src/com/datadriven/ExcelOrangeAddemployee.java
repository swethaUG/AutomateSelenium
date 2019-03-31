package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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

public class ExcelOrangeAddemployee extends Base{
	@Test(priority=0)
	public void logIn() throws IOException
	{
		FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/OrangeBAseLOgin.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		FileInputStream filep =new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/OrangeAddEmployee.properties");
	    Properties pr = new Properties();
	    pr.load(filep);
		Row r = sheet.getRow(1);
		driver.findElement(By.name(pr.getProperty("LoginName"))).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys(r.getCell(1).getStringCellValue());
		driver.findElement(By.name(pr.getProperty("Login"))).click();
	}
	@Test(priority=1)
	public void addEmployee() throws Throwable
	{
		FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/Employeedata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rcount = sheet.getLastRowNum();
		FileInputStream filep =new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/OrangeAddEmployee.properties");
	    Properties pr = new Properties();
	    pr.load(filep);
		for(int i=1;i <=rcount;i++)
		{
			System.out.println(i);
			Row r=sheet.getRow(i);
			WebElement a=driver.findElement(By.cssSelector(pr.getProperty("PIM")));
		    Actions act= new Actions(driver);
		    act.moveToElement(a).perform();
		    driver.findElement(By.cssSelector(pr.getProperty("ADDEMPLOYEE"))).click();
		    String Expected_AddEmployee_Text ="Add Employee";
		    System.out.println(Expected_AddEmployee_Text);
		    driver.switchTo().frame(driver.findElement(By.id(pr.getProperty("FRAME"))));
		    String Actual_AddEmployee_Text = driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText();
		    System.out.println(Actual_AddEmployee_Text);
		    try
		    {
		          if(Actual_AddEmployee_Text.contains(Expected_AddEmployee_Text))
		          {
		    	      System.out.println("Redirected to correct AddEmployee Page");
		    	      r.createCell(6).setCellValue("Redirected to correct AddEmployee Page");
		              String ExpectedCode = driver.findElement(By.id(pr.getProperty("CODE"))).getAttribute("value");
			          System.out.println("Expected Employee code is"+ExpectedCode );
		              driver.findElement(By.id(pr.getProperty("LASTNAME"))).sendKeys(r.getCell(2).getStringCellValue());
		              driver.findElement(By.name(pr.getProperty("FIRSTNAME"))).sendKeys(r.getCell(3).getStringCellValue());
		              driver.findElement(By.id(pr.getProperty("MIDDLENAME"))).sendKeys(r.getCell(4).getStringCellValue());
		              driver.findElement(By.id(pr.getProperty("NICKNAME"))).sendKeys(r.getCell(5).getStringCellValue());
		              driver.findElement(By.id(pr.getProperty("SAVE"))).click();
		              driver.switchTo().defaultContent();
		              String Expected_Employee_PersonalDetails = "Personal Details";
		              System.out.println(Expected_Employee_PersonalDetails);
		              driver.switchTo().frame(driver.findElement(By.id(pr.getProperty("PDFRAME"))));
		              String Actual_Employee_PersonalDetails = driver.findElement(By.cssSelector("#personal > div.outerbox > div.maincontent > div.mainHeading > h2")).getText();
		              System.out.println(Actual_Employee_PersonalDetails);
		             try
		              {
		                 if(Actual_Employee_PersonalDetails.contains(Expected_Employee_PersonalDetails))
				          {
				             System.out.println("Redirected to correct Personal Details Page");
				             r.createCell(7).setCellValue("Redirected to correct Personal Details Page");
		                     String ActualCode = driver.findElement(By.id(pr.getProperty("PDCODE"))).getAttribute("value");
		                     System.out.println("The Actual Employee Code is"+ActualCode);
		                     try
		                     {
		                       if(ActualCode.equals(ExpectedCode))
		                          {
			                        System.out.println("Employee is added sucessfully");
			                        r.createCell(8).setCellValue("Employee is added sucessfully");
		                          }
		       
		                     }    
		                    catch(Exception e)
		                    {
	                            System.out.println("Employee is not added sucessfully");
	                            r.createCell(8).setCellValue("Employee is not added sucessfully");
	                            File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                            FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/ErrorScreen.png"));
		                    }
		                 }
		                 
		              }
		             catch(Exception e)
		              {
		            	  System.out.println("Redirected to incorrect Personal Details Page");
		            	  r.createCell(7).setCellValue("Redirected to incorrect Personal Details Page");
		            	  File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		                  FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/WrongDetailsPage.png"));
		  		    	
		              }
		          }
		      }  
		    catch(Exception e)
		    {
		    	System.out.println("Redirected to wrong AddEmployee Page");
		    	r.createCell(6).setCellValue("Redirected to wrong AddEmployee Page");
		    	File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/WrongAddEmployee.png"));
		    	
		    }
		    driver.switchTo().defaultContent(); 
            FileOutputStream file1= new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Employee Result.xlsx");
            workbook.write(file1);
            driver.navigate().back(); 
           // driver.findElement(By.xpath(pr.getProperty("LOGOUT"))).click(); 
	    }
     }		    

}

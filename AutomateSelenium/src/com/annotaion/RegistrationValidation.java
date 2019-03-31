package com.annotaion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationValidation extends NewToursBaseclass{
	@Test(priority=0)
	public void register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
	}
	@Test(priority=1)
	public void aNewRegistration() throws Throwable
	{
		FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/Regiatration data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			System.out.println(i);
			Row r =sheet.getRow(i);
			driver.findElement(By.name("firstName")).clear();
			driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.name("lastName")).clear();
			driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
			double x = r.getCell(2).getNumericCellValue();
			long y=(long)x;
			String PhoneNumber = Long.toString(y);
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys(PhoneNumber);
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.name("address1")).clear();
			driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
			driver.findElement(By.name("state")).clear();
			driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
			driver.findElement(By.name("postalCode")).clear();
			double m = r.getCell(7).getNumericCellValue();
			long n = (long)m;
			String PostalCode = Long.toString(n);
			driver.findElement(By.name("postalCode")).sendKeys( PostalCode);
			WebElement country = driver.findElement(By.name("country"));
			Select sc = new Select(country);
			sc.selectByVisibleText(r.getCell(8).getStringCellValue());
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
			driver.findElement(By.name("confirmPassword")).clear();
			driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
			driver.findElement(By.name("register")).click();
			//driver.navigate().back();
		    //driver.navigate().refresh();
			String Actual_RegisteredUserName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			System.out.println( Actual_RegisteredUserName);
			String Expected_RegisteredUserName = r.getCell(9).getStringCellValue();
			try
			{
			      if(Actual_RegisteredUserName.contains(Expected_RegisteredUserName))
			      {
				         System.out.println("Sucessfull Registration");
				         r.createCell(12).setCellValue("Sucessfull Registration");
				  }
			      
			     else
			      {
				        throw new Exception();
			      }
			}
			catch(Exception e)
			{
				System.out.println("UnSucessfull Registration");
				r.createCell(12).setCellValue("UnSucessfull Registration");
				File ErrorScreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(ErrorScreen,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/RegistrationScreens"+i+".png"));
			}
			FileOutputStream file1= new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Registration result.xlsx");
			workbook.write(file1);
			driver.navigate().back();
			
		}
	}
	

}

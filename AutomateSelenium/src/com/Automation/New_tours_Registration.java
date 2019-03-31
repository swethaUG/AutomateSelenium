package com.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class New_tours_Registration {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Expected_Element = "bindu";
		FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/NTRegistrationdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row r = sheet.getRow(1);
		//<a href="mercuryregister.php">REGISTER</a>
		driver.findElement(By.linkText("REGISTER")).click();
		//<input maxlength="60" name="firstName" size="20">
		driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		//<input maxlength="60" name="lastName" size="20">
		driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
		//<input maxlength="20" name="phone" size="15">
		double x = r.getCell(2).getNumericCellValue();
		long y=(long)x;
		String PhoneNumber = Long.toString(y);
		driver.findElement(By.name("phone")).sendKeys(PhoneNumber);
		//<input name="userName" id="userName" size="35" maxlength="64">
		driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());
		//<input maxlength="60" name="address1" size="40">
		driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
		//<input maxlength="60" name="city" size="15">
		driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
		//<input maxlength="40" name="state">
		driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
		//<input maxlength="20" name="postalCode" size="15">
		double m = r.getCell(7).getNumericCellValue();
		long n = (long)m;
		String PostalCode = Long.toString(n);
		driver.findElement(By.name("postalCode")).sendKeys( PostalCode);
		//<select name="country" size="1">
		WebElement country = driver.findElement(By.name("country"));
		Select sc = new Select(country);
		sc.selectByVisibleText(r.getCell(8).getStringCellValue());
		//<input name="email" id="email" size="20" maxlength="60">
		driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
		//<input maxlength="60" name="password" size="20" type="password">
		driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
		//<input maxlength="60" name="confirmPassword" size="20" type="password">
		driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
		//<input type="image" name="register" src="/images/forms/submit.gif" width="60" height="23" border="0">
		driver.findElement(By.name("register")).click();
		String Actual_Element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
		System.out.println(Actual_Element);
		try
		{
			
		    if(Actual_Element.contains(Expected_Element))
		    {
			    System.out.println("Sucessfull Registration");
		    }
		    else
		    {
		    	throw new Exception();
		    }
		}    
		catch(Exception e)
		{
			System.out.println("UnSucessfull Registration");
		}
				
		
	}

	
}

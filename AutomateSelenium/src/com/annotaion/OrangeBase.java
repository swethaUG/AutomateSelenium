package com.annotaion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeBase {
	WebDriver driver;
	String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(enabled=false)
	public void Login() throws IOException
	{
		FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/OrangeBAseLOgin.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		Row r = sheet.getRow(1);
		driver.findElement(By.name("txtUserName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
		driver.findElement(By.name("Submit")).click();
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}

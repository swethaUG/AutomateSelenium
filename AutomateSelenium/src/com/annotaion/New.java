package com.annotaion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New extends OrangeBase{
	/*WebDriver driver;
	String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}*/
	
	@Test
	public void main() throws IOException, InterruptedException
	{
		FileInputStream file= new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/Readfile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rcount = sheet.getLastRowNum();
	
		String Expected_Element="Welcome admin";
		String Expected_Element1="Invalid Login";
		
		for(int i=1;i <=rcount;i++)
		{
			System.out.println(i);
			Row r=sheet.getRow(i);
			driver.findElement(By.name("txtUserName")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.name("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.name("Submit")).click();
			try
			{
			        if((driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText()).contains(Expected_Element))
			        {
				
				          System.out.println("Login validation is sucessfull,PASS");
				          r.createCell(2).setCellValue("Login validation is sucessfull,PASS");
				    }
			        else if((driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/strong/font")).getText()).contains(Expected_Element1))
			        {
				          
			        	throw new Exception();
				         
			        }
		     }
		
		catch (Exception e)
		            {
			             System.out.println("Login validation is unsucessfull,Fail" );
			             r.createCell(2).setCellValue("Login validation is sucessfull,FAIL");
			             File ErrorScreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			             FileUtils.copyFile(ErrorScreen,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/Screen/"+i+".png"));
			
		             }
			FileOutputStream file1= new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Result.xlsx");
			workbook.write(file1);
			driver.navigate().back();
			driver.findElement(By.name("clear")).click();
	    }		
		   
			   
		}
	/*@AfterTest
	public void teardown()
	{
		//driver.quit();
	}*/
	}



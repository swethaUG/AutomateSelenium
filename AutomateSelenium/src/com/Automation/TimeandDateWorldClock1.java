package com.Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TimeandDateWorldClock1 {
          
			public static void main(String[] args) throws IOException {
			WebDriver driver= null;
			String URL = " https://www.timeanddate.com/worldclock/"
					;
			System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Timeand date output.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			//Row r = sheet.createRow(0);
			//Cell c=r.createCell(0);
			//c.setCellValue("swetha");
			
			WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for(int i=0;i<rows.size();i++)
			{
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				Row r = sheet.createRow(i);
				for(int j=0;j<cols.size();j++)
				{
					String data = cols.get(j).getText();
					System.out.print(data);
					//Row r = sheet.createRow(1);
					Cell c=r.createCell(j);
					c.setCellValue(data);
				}
				System.out.println( );
				FileOutputStream file1 = new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/Timeand date output.xlsx");
				workbook.write(file1);
			}
           driver.quit();
	}

}

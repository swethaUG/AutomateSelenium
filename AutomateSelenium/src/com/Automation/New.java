package com.Automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class New {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		String URL ="http://newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		//<a href="mercuryregister.php">REGISTER</a>
	    driver.findElement(By.linkText("REGISTER")).click();
		///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select
		WebElement Country = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
		Select se= new Select(Country);
		List<WebElement> Names = se.getOptions();
		int Count = Names.size();
		System.out.println(Count);
	 
		FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		//Row r =sheet.createRow(2);
		//Cell c = r.createCell(3);
		//c.setCellValue("UGswetha");
		 for(int i=0;i<Count;i++)
		 {
			 String countryname = Names.get(i).getText();
			 System.out.println(countryname);
			 //int rownum=2;
			 //int cellnum=1;
			 Row r =sheet.createRow(i);
				Cell c = r.createCell(1);
				c.setCellValue(countryname);
				//c.setCellValue("swetha");
		 }
		FileOutputStream file1 = new FileOutputStream("C:/Users/admin/Desktop/Book1.xlsx");
        workbook.write(file1);
	}

}

package com.POM;

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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewTours_WelcomeMercuryTours extends BaseTest {
	@Test
	public void homePage() throws InterruptedException, IOException
	{
	   WelcomeMercuryTours wmt = PageFactory.initElements(driver, WelcomeMercuryTours.class);
	   wmt.signOn();
	   String SignOn_ActualURL = driver.getCurrentUrl();
	   System.out.println(SignOn_ActualURL);
	   //<a href="mercurysignon.php">SIGN-ON</a>
	   String SignOn_ExpectedURL = driver.findElement(By.linkText("SIGN-ON")).getAttribute("href");
	   System.out.println( SignOn_ExpectedURL);
	   try
	   {
	        if(SignOn_ActualURL.contains(SignOn_ExpectedURL))
	        {
		          System.out.println("SignOn link redirected to correct URL");
	        }
	   }     
	   catch(Exception e)
	   {
		   System.out.println("Signon link redirected to incorrect URL");
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source, new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/POMScreens/Signon.png"));
		  
	   }
	   driver.navigate().back();
	   wmt.register();
	   String Register_ActualURL = driver.getCurrentUrl();
	   System.out.println(Register_ActualURL);
	   //<a href="mercuryregister.php">REGISTER</a>
	   String Register_ExpectedURL = driver.findElement(By.linkText("REGISTER")).getAttribute("href");
	   System.out.println( Register_ExpectedURL);
	   try
	   {
	         if(Register_ActualURL.contains(Register_ExpectedURL))
	         {
		        System.out.println("Register link redirected to correct URL");
	         }
	   }      
	   catch(Exception e)
	   {
		   System.out.println("Register link redirected to incorrect URL");
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source, new  File("C:/UsersadminDesktop/New folder (2)/AutomateSelenium/POMScreens/Register.png"));
	   }
	   driver.navigate().back();
	   wmt.support();
	   String Support_ActualURL = driver.getCurrentUrl();
	   System.out.println(Support_ActualURL);
	   //<a href="mercuryunderconst.php">SUPPORT</a>
	   String Support_ExpectedURL = driver.findElement(By.linkText("SUPPORT")).getAttribute("href");
	   System.out.println(Support_ExpectedURL);
	   try
	   {
	         if(Support_ActualURL.contains(Support_ExpectedURL))
	         {
		        System.out.println("Support link redirected to correct URL");
	         }
	   }      
	   catch(Exception e)
	   {
		   System.out.println("Support link redirected to incorrect URL");
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source, new  File("C:/UsersadminDesktop/New folder (2)/AutomateSelenium/POMScreens/Support.png"));
	   }
	   driver.navigate().back();
	   wmt.contact();
	   String Contact_ActualURL = driver.getCurrentUrl();
	   System.out.println(Contact_ActualURL);
	   //<a href="mercuryunderconst.php">CONTACT</a>
	   String Contact_ExpectedURL = driver.findElement(By.linkText("CONTACT")).getAttribute("href");
	   System.out.println(Support_ExpectedURL);
	   try
	   {
	         if(Contact_ActualURL.contains(Contact_ExpectedURL))
	         {
		         System.out.println("Contact link redirected to correct URL");
	         }
	   }      
	   catch(Exception e)
	   {
		   System.out.println("Contact link redirected to incorrect URL");
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(source, new  File("C:/UsersadminDesktop/New folder (2)/AutomateSelenium/POMScreens/contact.png"));
	   }
	   driver.navigate().back();
	  
	  FileInputStream file = new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/Readdata/POMReadfile.xlsx");
	   XSSFWorkbook workbook = new XSSFWorkbook(file);
	   XSSFSheet sheet = workbook.getSheet("sheet1");
	   int rowcount = sheet.getLastRowNum();
	   System.out.println(rowcount);
	   for(int i=1;i<=rowcount;i++)
	   {
		   Row r = sheet.getRow(i);
		   wmt.logIn(r.getCell(0).getStringCellValue(),r.getCell(1).getStringCellValue());
		   String Expected_Text ="Welcome back to Mercury Tours";
		   System.out.println(Expected_Text);
		   
		   String Actual_Text = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText();
		   System.out.println(Actual_Text);
		       try
		       {
		    	   
			   if(Actual_Text.contains(Expected_Text))
			   {
				   System.out.println("Login is sucessfull");
				   r.createCell(2).setCellValue("Login is sucessfull");
				  
			   }
		       }
		   
			   catch(Exception e)
		       {
			       System.out.println("Login is not Sucessfull");
			       r.createCell(2).setCellValue("Login is not sucessfull");
			       TakesScreenshot ts=(TakesScreenshot)driver;
				   File source = ts.getScreenshotAs(OutputType.FILE);
			       FileUtils.copyFile(source, new  File("C:/UsersadminDesktop/New folder (2)/AutomateSelenium/POMScreens/contact.png"));
			      
		       }
			  FileOutputStream file1=new FileOutputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/src/com/TestResult/POMResultFile.xlsx");
			  workbook.write(file1);
			  driver.navigate().back();
	       }
	  
		
	}
	}

	


	


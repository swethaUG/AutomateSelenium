package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ObjectArrayOrangeAddEmployee extends Base{
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "admin";
		data[0][1] = "admin";
		return data;
	}
	@Test(dataProvider="getData",priority=0)
	public void logIn(String Uname,String pwd) throws IOException
	{
		FileInputStream filep =new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/OrangeAddEmployee.properties");
	    Properties pr = new Properties();
	    pr.load(filep);
		driver.findElement(By.name(pr.getProperty("LoginName"))).sendKeys(Uname);
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys(pwd);
		driver.findElement(By.name(pr.getProperty("Login"))).click();
	}
	@DataProvider
	public Object[][] getValue()
	{
		Object[][] value = new Object[3][4];
		value[0][0]="bindu";
		value[0][1]="sagar";
		value[0][2]="nirmal";
		value[0][3]="scooby";
		value[0][1]="preeti";
		value[0][1]="sagar";
		value[0][1]="nirmal";
		value[0][1]="scooby";
		return value;
	}
	@Test(dataProvider="getValue",priority=1)
	public void addEmployee(String Lname,String Fname,String Mname,String Nname) throws Throwable
	{
		
		FileInputStream filep =new FileInputStream("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/OrangeAddEmployee.properties");
	    Properties pr = new Properties();
	    pr.load(filep);
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
		              String ExpectedCode = driver.findElement(By.id(pr.getProperty("CODE"))).getAttribute("value");
			          System.out.println("Expected Employee code is"+ExpectedCode );
		              driver.findElement(By.id(pr.getProperty("LASTNAME"))).sendKeys(Lname);
		              driver.findElement(By.name(pr.getProperty("FIRSTNAME"))).sendKeys(Fname);
		              driver.findElement(By.id(pr.getProperty("MIDDLENAME"))).sendKeys(Mname);
		              driver.findElement(By.id(pr.getProperty("NICKNAME"))).sendKeys(Nname);
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
		                     String ActualCode = driver.findElement(By.id(pr.getProperty("PDCODE"))).getAttribute("value");
		                     System.out.println("The Actual Employee Code is"+ActualCode);
		                     try
		                     {
		                       if(ActualCode.equals(ExpectedCode))
		                          {
			                        System.out.println("Employee is added sucessfully");
		                          }
		       
		                     }    
		                    catch(Exception e)
		                    {
	                            System.out.println("Employee is not added sucessfully");
	                            File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                            FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/ErrorScreen.png"));
		                    }
		                 }
		                 
		              }
		             catch(Exception e)
		              {
		            	  System.out.println("Redirected to incorrect Personal Details Page");
		            	  File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		                  FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/WrongDetailsPage.png"));
		  		    	
		              }
		          }
		      }  
		    catch(Exception e)
		    {
		    	System.out.println("Redirected to wrong AddEmployee Page");
		    	File Error_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(Error_Screenshot,new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/WrongAddEmployee.png"));
		    	
		    }
		    driver.switchTo().defaultContent(); 
            driver.navigate().back(); 
           // driver.findElement(By.xpath(pr.getProperty("LOGOUT"))).click(); 
	    }
     }		    

	
	



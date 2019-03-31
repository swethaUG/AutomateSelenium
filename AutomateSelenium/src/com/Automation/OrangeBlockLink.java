package com.Automation;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeBlockLink {


	public static void main(String[] args) throws Exception {
		WebDriver driver=null;
		String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String LoginName="admin";
		String Password="admin";
		//<input name="txtUserName" type="text" class="loginText" tabindex="1">
		driver.findElement(By.name("txtUserName")).sendKeys(LoginName);
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		driver.findElement(By.name("txtPassword")).sendKeys(Password);
		//<input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		driver.findElement(By.name("Submit")).click();
		//<span class="drop">Leave</span>
		//<span class="drop">Reports</span>
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		int Links_Count = Links.size();
		System.out.println(Links_Count);
		for(int i=2;i<=Links_Count;i++)
		{
			if(Links.get(i).isDisplayed())
			{
			String Links_Name = Links.get(i).getText();
			System.out.println(Links_Name);
			Links.get(i).click();
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/"+Links_Name+".png"));
			driver.navigate().back();
			Links = driver.findElements(By.tagName("a"));
		    }
		}
	}
}
	

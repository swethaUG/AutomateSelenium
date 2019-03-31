package com.TCKeyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeKeywordTCLogin {
	WebDriver driver=null;
	String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver= new ChromeDriver();
	}
   public void navigate()
   {
	   driver.get(url);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
   public void loginName()
   {
	   driver.findElement(By.name("txtUserName")).sendKeys("admin");
   }
   public void password()
   {
	   driver.findElement(By.name("txtPassword")).sendKeys("admin");
   } 
   public void login()
   {
	   driver.findElement(By.name("Submit")).click();
   }

}

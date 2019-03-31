package com.KeywordFramework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyword_Orange_Login1 {
	WebDriver driver=null;
	public void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
    public void browserNavigate()
    {
    	driver.get("http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php");
    }
    public void loginname(String pname,String Uname)
    {
    	//<input name="txtUserName" type="text" class="loginText" tabindex="1">
    	driver.findElement(By.name(pname)).clear();
    	driver.findElement(By.name(pname)).sendKeys(Uname);
    }
    public void password(String ppassword, String Password)
    {
    	//<input name="txtPassword" type="password" class="loginText" tabindex="2">
    	driver.findElement(By.name(ppassword)).clear();
    	driver.findElement(By.name(ppassword)).sendKeys(Password);
    }
    public void click(String press)
    {
    	//<input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
    	driver.findElement(By.name(press)).click();
    }

}

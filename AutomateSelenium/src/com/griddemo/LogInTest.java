package com.griddemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInTest {
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "admin";
		data[0][1] = "admin";
		data[0][2] = "chrome";
		data[1][0] = "admin";
		data[1][1] = "admin";
		data[1][2] = "chrome";
		return data;
	}
	@Test(dataProvider = "getData", priority=0)
	public void LogIn(String Uname,String pwd, String browser) throws MalformedURLException
	{
		DesiredCapabilities cap = null;
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.6:4444/wd/hub"),cap);
		driver.get("http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php");
	
		//<input name="txtUserName" type="text" class="loginText" tabindex="1">
		driver.findElement(By.name("txtUserName")).sendKeys(Uname);
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		//<input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		driver.findElement(By.name("Submit")).click();
		
		
	}
			
			
	

}

package com.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeLoginValidation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String LoginName="admin";
		String Password="admin";
		//<input name="txtUserName" type="text" class="loginText" tabindex="1">
	    WebElement Username = driver.findElement(By.name("txtUserName"));
		Username.sendKeys(LoginName);
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		WebElement password = driver.findElement(By.name("txtPassword"));
		password.sendKeys(Password);
		//<input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		WebElement Button = driver.findElement(By.name("Submit"));
		Button.click();
		//<a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		String Expected_Text="Welcome";
		//<li>Welcome admin</li>
	   String Actual_Text="Welcome admin";
	   if(Actual_Text.contains(Expected_Text))
	   {
		   System.out.println("Sucessful Login,PASS");
	   }
	   else
	   {
		   System.out.println("Login Failed,FAil");
	   }
	   //<a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
	   Thread.sleep(1000);
	   driver.findElement(By.linkText("Logout")).click();
	   driver.quit();
	   
	   		
	}

}

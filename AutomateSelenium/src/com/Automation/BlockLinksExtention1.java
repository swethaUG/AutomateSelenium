package com.Automation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BlockLinksExtention1 {

	public static void main(String[] args) throws InterruptedException, IOException {
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
		WebElement Benfits = driver.findElement(By.linkText("Benefits"));
		Actions act = new Actions(driver);
		act.moveToElement(Benfits).perform();
		for(int i=1;i<=2;i++)
		{
			WebElement names = driver.findElement(By.xpath("//*[@id='benefits']/ul/li["+i+"]/a/span"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(names).perform();
			Thread.sleep(2000);
			for(int j=1;j<=5;j++)
			{
				WebElement subnames = driver.findElement(By.xpath("//*[@id='benefits']/ul/li["+i+"]/ul/li["+j+"]/a/span"));
				Actions act2 = new Actions(driver);
				act2.moveToElement(subnames).perform();
				subnames.click();
				Benfits = driver.findElement(By.linkText("Benefits"));
				act.moveToElement(Benfits).perform();
				driver.findElement(By.xpath("//*[@id='benefits']/ul/li["+i+"]/a/span"));
				act1.moveToElement(names).perform();
				Thread.sleep(2000);
			}
			
		}
		
		
		
	}

}

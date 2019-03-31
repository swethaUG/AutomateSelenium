package com.Automation;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BlockLinksEXtention {

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
		WebElement Benfits = driver.findElement(By.xpath("//*[@id='benefits']/a/span"));
		Actions act = new Actions(driver);
		act.moveToElement(Benfits).perform();
		WebElement Healthsavingsplan = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[1]/a/span"));
		act.moveToElement(Healthsavingsplan).perform();
		
		//#benefits > ul > li:nth-child(1) > ul > li:nth-child(1) > a > span
		//#benefits > ul > li:nth-child(1) > ul > li:nth-child(2) > a > span
		//#benefits > ul > li:nth-child(1) > ul > li:nth-child(5) > a > span
		for(int i=1;i<5;i++)
		     {
			WebElement Names = driver.findElement(By.cssSelector("#benefits > ul > li:nth-child(1) > ul > li:nth-child("+ i +") > a > span"));
			act.moveToElement(Names).perform();
			Names.click();
			//Thread.sleep(2000);
			File Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/BlockHeaderScreen/"+i+".png"));
		
			//driver.navigate().back();
			Benfits = driver.findElement(By.xpath("//*[@id='benefits']/a/span"));
			act.moveToElement(Benfits).perform();
			
			Healthsavingsplan = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[1]/a/span"));
			act.moveToElement(Healthsavingsplan).perform();
            }
		Benfits = driver.findElement(By.xpath("//*[@id='benefits']/a/span"));
		act.moveToElement(Benfits).perform();
		
		WebElement Payrollschedule = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[2]/a/span"));
		act.moveToElement(Payrollschedule).perform();
		//*[@id="benefits"]/ul/li[2]/ul/li[1]/a/span
		//*[@id="benefits"]/ul/li[2]/ul/li[2]/a/span
		for(int j=1;j<=2;j++)
		{
			WebElement Names1 = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[2]/ul/li["+j+"]/a/span"));
			act.moveToElement(Names1).perform();
			Names1.click();
			File Source1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source1, new File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/block/"+j+".png"));
	        //Thread.sleep(2000);
			//driver.navigate().back();
			Benfits = driver.findElement(By.xpath("//*[@id='benefits']/a/span"));
			act.moveToElement(Benfits).perform();
	        Payrollschedule = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[2]/a/span"));
			act.moveToElement(Payrollschedule).perform();
			
			
		}
		

	}

}

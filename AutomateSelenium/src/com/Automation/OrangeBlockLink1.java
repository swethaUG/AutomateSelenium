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

public class OrangeBlockLink1 {

		public static void main(String[] args) throws InterruptedException, Exception {
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
			//<span class="drop">Recruitment</span>
			WebElement Recruitment = driver.findElement(By.xpath("//*[@id='recruit']/a/span"));
			Actions act = new Actions(driver);
			act.moveToElement(Recruitment).perform();
			//*[@id="recruit"]/ul/li[1]/a/span
			//*[@id="recruit"]/ul/li[2]/a/span
			for(int i=1;i<=2;i++)
			{
			   WebElement recruitblock = Recruitment.findElement(By.xpath("//*[@id='recruit']/ul/li[" + i + "]/a/span"));
			   String Names = recruitblock.getText();
			    recruitblock.click(); 
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				File Screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Screen, new  File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/Linkscreen/"+Names+".png"));
				driver.navigate().back();
                ////*[@id="recruit"]/a/span
				//WebElement recruit = driver.findElement(By.xpath("//*[@id='recruit']/a/span"));
				Recruitment = driver.findElement(By.xpath("//*[@id='recruit']/a/span"));
				Actions act1=  new Actions(driver);
				act1.moveToElement(Recruitment).perform();
		   }
			
			
			
					
	}

}

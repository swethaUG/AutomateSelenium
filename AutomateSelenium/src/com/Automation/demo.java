package com.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo {

	public static void main(String[] args) {
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
		List<WebElement> HSV = Healthsavingsplan.findElements(By.tagName("a"));
		int count  = HSV.size();
		System.out.println(count);
		for(int i=0;i<=HSV.size();i++)
		{
		      HSV.get(i).click();
		      Benfits = driver.findElement(By.xpath("//*[@id='benefits']/a/span"));
		      act.moveToElement(Benfits).perform();
		      Healthsavingsplan = driver.findElement(By.xpath("//*[@id='benefits']/ul/li[1]/a/span"));
			  act.moveToElement(Healthsavingsplan).perform();
		      
		}

	}

}

package com.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//<a href="mercuryregister.php">REGISTER</a>
		driver.findElement(By.partialLinkText("REGIS")).click();
		WebElement Country = driver.findElement(By.name("country"));
		List<WebElement> Countries = Country.findElements(By.tagName("option"));
		for(int i=0;i<Countries.size();i++)
		{
			String CountryNames=Countries.get(i).getText();
			System.out.println(CountryNames);
			if(Countries.get(i).isSelected())
			{
				System.out.println("Element Active");
			}
			else
			{
				System.out.println("Element is Inactive");
			}
		}

	}

}

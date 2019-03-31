package com.Automation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class One {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com";
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		int Links_count = Links.size();
		System.out.println("Number of links"+Links_count);
		for(WebElement Link: Links)
		{
			String Link_Name = Link.getText();
			System.out.println("Names of String are"+Link_Name);
		}
		
		driver.quit();
		
		
		
		
	}

}

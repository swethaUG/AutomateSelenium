package com.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeandDateWorldClock {

	public static void main(String[] args) {
	WebDriver driver= null;
	String URL = " https://www.timeanddate.com/worldclock/";
	System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
	///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table
	///html/body/div[1]/div[6]/section[1]/div/section
	for(int i=1;i<36;i++)
	{
		for(int j=1;j<=7;j+=2)
		{
			String  Names = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[" + i + "]/td[" + j+ "]/a")).getText();
			System.out.println(Names);
			
		}
	}
	

	}

}

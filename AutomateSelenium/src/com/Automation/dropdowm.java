package com.Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowm {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country = driver.findElement(By.name("country"));
		Select sc = new Select(country);
		boolean value = sc.isMultiple();
		System.out.println(value);
		List<WebElement> countrynames = sc.getOptions();
		for(int i=0;i<countrynames.size();i++)
		{
			String options = countrynames.get(i).getText();
			System.out.println(options);
		}
		sc.selectByVisibleText("ALGERIA");
		sc.selectByIndex(0);
		sc.selectByValue("236");
		sc.getFirstSelectedOption();

	}

}

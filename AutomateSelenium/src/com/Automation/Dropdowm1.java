package com.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class Dropdowm1 {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("REGIS")).click();
		WebElement Country = driver.findElement(By.name("country"));
		Select selection = new Select(Country);
		//selection.selectByValue("4");
		//selection.selectByIndex(0);
		selection.selectByVisibleText("ANDORRA");
		selection.selectByValue("7");
      List<WebElement> element = selection.getOptions();
      element.size();
      for(int i=0;i<=element.size();i++)
    	  {
    		  String element1 = element.get(i).getText();
    		  System.out.println(element1);
    	  }
	if(selection.isMultiple())
	{
		System.out.println(" is multiple");
	}
	else
	{
		System.out.println("is not multiple");
	}
      
	}

}

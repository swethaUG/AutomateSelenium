package com.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffNameBoxValidation {

	public static void main(String[] args) {
		 
			
				WebDriver driver=null;
				String url="http://register.rediff.com/register/register.php?FormName=user_details";
				System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				String Name = "swetha";
				//<input type="text" onblur="fieldTrack(this);" name="name2a4652b4" value="" style="width:185px;" maxlength="61">
				//<input type="text" onblur="fieldTrack(this);" name="nameeade50ee" value="" style="width:185px;" maxlength="61">
				//<input type="text" onblur="fieldTrack(this);" name="name1c4dfd2a" value="" style="width:185px;" maxlength="61">
				  //driver.findElement(By.xpath("//*[@name='name2a4652b4']")).sendKeys("swetha");
				driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(Name);//relative path
				driver.findElement(By.xpath("html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input")).sendKeys(Name);//Absolute path
				
	}

}

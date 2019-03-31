package com.Automation;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orangescreenshot {

	public static void main(String[] args) throws Exception {
		WebDriver driver=null;
		String url="http://localhost/orangehrm/orangehrm-2.6/orangehrm-2.6/login.php";
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/New folder (3)/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new  File("C:/Users/admin/Desktop/New folder (2)/AutomateSelenium/screenshot/orange.png"));
        
	}	
}

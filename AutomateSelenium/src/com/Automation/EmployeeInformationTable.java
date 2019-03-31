package com.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeInformationTable {

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
		///html/body/div/div[2]
		////*[@id="standardView"]
		//<iframe style="display:block;margin-left:auto;margin-right:auto;width:100%;" src="./lib/controllers/CentralController.php?reqcode=EMP&amp;VIEW=MAIN&amp;sortField=0&amp;sortOrder0=ASC&amp;VIEW=MAIN" id="rightMenu" name="rightMenu" height="100%;" frameborder="0"></iframe>
		driver.switchTo().frame(driver.findElement(By.id("rightMenu")));
		WebElement table = driver.findElement(By.xpath("//*[@id='standardView']/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=0;i<=rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++)
			{
				String data = cols.get(j).getText();
				System.out.print(data +"   ");
			}
			System.out.println();
		}
	}
}	



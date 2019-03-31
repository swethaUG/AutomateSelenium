package com.datadriven;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM extends Base{
	@FindBy(xpath="//*[@id='rightMenu']")
	WebElement employeeframe;
	public void enterFrame()
	{
		driver.switchTo().frame(employeeframe);
	}

	@FindBy(xpath="//*[@id='loc_code']")
	WebElement Searchby;
	@FindBy(xpath="//*[@id='loc_name']")
	WebElement Searchto;
	@FindBy(xpath="//*[@id='standardView']/div[2]/input[2]")
    WebElement Sbutton;
	public void search(String selection,String selection1)
	{
		Select sc = new Select(Searchby);
		sc.selectByVisibleText(selection);
		Searchto.sendKeys(selection1);
		Sbutton.click();
	}
	

	

}

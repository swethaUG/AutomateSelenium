package com.datadriven;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OrangeHRM_Employeeinformation extends Base{
	
	@Test
	public void employeeinformation()
	{
		OrangeHRM ohrm = PageFactory.initElements(driver, OrangeHRM.class);
		ohrm.enterFrame();
		ohrm.search("Emp.ID","0003");
		
	}

}

package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeMercuryTours {
	
	//<a href="mercurysignon.php?osCsid=dda732ccd84e4e4d529d7e7cdbbf39c6">SIGN-ON</a>
	@FindBy(linkText="SIGN-ON")
	WebElement signon;
	public void signOn()
	{
		signon.click();
	
	}

	//<a href="mercuryregister.php">REGISTER</a>
	@FindBy(linkText="REGISTER")
	WebElement Register;
	public void register()
	{
		Register.click();
	}

	//<a href="mercuryunderconst.php?osCsid=85ec7e06bc2737f8f1bfb7ad9ac620a4">SUPPORT</a>
	@FindBy(linkText="SUPPORT")
	WebElement Support;
	public void support()
	{
		Support.click();
	}

	//<a href="mercuryunderconst.php?osCsid=85ec7e06bc2737f8f1bfb7ad9ac620a4">CONTACT</a>
	@FindBy(linkText="CONTACT")
	WebElement Contact;
	public void contact()
	{
		Contact.click();
	}
	//<input type="text" name="userName" size="10">
	//<input type="password" name="password" size="10">
	//<input type="image" name="login" value="Login" src="/images/btn_signin.gif" width="58" height="17" alt="Sign-In" border="0">
	@FindBy(name="userName")
	WebElement  Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(name="login")
	WebElement Login;
	public void logIn(String Uname,String password)
	{
		Username.clear();
		Username.sendKeys(Uname);
		Password.clear();
		Password.sendKeys(password);
		Login.click();
	}
}	
	//<a href="mercurywelcome.php">Home</a>
	/*@FindBy(linkText="Home")
	WebElement Home;
	public void home()
	{
		Home.click();
	}
	//<a href="mercuryreservation.php">Flights</a>
	@FindBy(linkText="Flights")
	WebElement Flight;
	public void flight()
	{
		Flight.click();
	}
	//<a href="mercuryunderconst.php">Hotels</a>
	@FindBy(linkText="Hotels")
	WebElement Hotels;
	public void hotels()
	{
		Hotels.click();
	}
	//<a href="mercuryunderconst.php">Car Rentals</a>
	@FindBy(linkText="Car Rentals")
	WebElement Carrentals;
	public void carRentals()
	{
		Carrentals.click();
	}
	//<a href="mercurycruise.php">Cruises</a>
	@FindBy(linkText="Cruises")
	WebElement Cruises;
	public void cruises()
	{
		Cruises.click();
	}
	//<a href="mercuryunderconst.php">Destinations</a>
	@FindBy(linkText="Destinations")
	WebElement Destination;
	public void destination()
	{
		Destination.click();
	}
	//<a href="mercuryunderconst.php">Vacations</a>
	@FindBy(linkText="Vacations")
	WebElement Vacations;
	public void vacations()
	{
		Vacations.click();
	}
	//<a href="mercuryunderconst.php">your destination</a>
	@FindBy(linkText="your destination")
	WebElement Yourdestination;
	public void yourdestination()
	{
		Yourdestination.click();
	}
	/*<font face="Arial, Helvetica, sans-serif, Verdana" size="2">Read
  /*  about our <a href="mercuryunderconst.php">featured vacation destinations</a>.</font>*/
	/*@FindBy(linkText="featured vacation destinations")
	WebElement FVdestination;
	public void fvacationdestination()
	{
		FVdestination.click();
	}
    /*<a href="mercuryregister.php">Register here</a>*/
	/*@FindBy(linkText="Register here")
	WebElement Registerhere;
	public void Registerhere()
	{
		Registerhere.click();
		
    }
	///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img")
	WebElement Backtohome;
	public void backtohome()
	{
		Backtohome.click();
	}*/
	


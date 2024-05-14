package TestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom.Homepage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;


public class Testhome extends Baseclass
{
	
	Homepage hp;

	@BeforeClass
	private void PassUrl() throws Customexception
	{
		try
			{
				if(driver!=null)
				{
					ActionsMethod.Get(driver, p.getProperty("HomePageUrl"));
					Loggerclass.info("Launch Home Page");
				}
			}
			catch (WebDriverException e) {
				Loggerclass.error("Internet Connection OFF Please check Internet Connection");
				throw new Customexception("Internet Connection OFF Please check Internet Connection: "+e.getMessage());
			}
			catch (NullPointerException e) {
				Loggerclass.error("WebDriver is NULL");
				throw new Customexception("WebDriver is NULL: "+e.getMessage());
			}
		
	}
	 
	
	@Test(priority=0)
	private void skipSing() throws Customexception
	{
	
		Loggerclass.StartTest("skip signIn method");
		hp=PageFactory.initElements(driver, Homepage.class);
		hp.skipSignInbtn();
		Loggerclass.EndTest("skip signIn method");
		
	}
	
	
	
	
}

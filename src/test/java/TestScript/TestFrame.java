package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.Framepage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.ListenerClass;
import UtilityClass.Loggerclass;

@Listeners(ListenerClass.class)
public class TestFrame extends Baseclass
{
	/**
	 * Method is used to open frame page and handle exceptions
	 * @throws Customexception
	 */
	@BeforeClass
	void navigateFramePage() throws Customexception
	{
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver,"https://demo.automationtesting.in/Frames.html");
				Loggerclass.info("Launch Frame Page");
			}
			else
			{
				Loggerclass.error("Driver is Null");
				System.out.println("driver is null");
			}
		}
		catch (NullPointerException e) {
			Loggerclass.error("Driver is null");
			throw new Customexception("Driver is null: "+e.getMessage());
		}
		catch (WebDriverException e) {
			Loggerclass.error("Internet Connection OFF Please check Internet Connection");
			throw new Customexception("Internet Connection OFF Please check Internet Connection: "+e.getMessage());
		}
		catch(Exception e)
		{
			Loggerclass.error("URL Issue");
			throw new Customexception("URL Issure: "+e.getMessage());
		}
	}
	
	
	/**
	 * Method is used to verify Single frame handling
	 * @throws InterruptedException
	 * @throws Customexception
	 */
	@Test(priority=1)
	void performSingleFrameHandling() throws InterruptedException, Customexception
	{
		Loggerclass.StartTest("Handle Single Frame Method");
		Framepage fP=PageFactory.initElements(driver, Framepage.class);
		fP.firstFrame();
		fP.passText("Vaibhav");
		driver.switchTo().defaultContent();//switch to parent frame 
		Loggerclass.EndTest("Handle Single Frame Method");
	}
	
	
	/**
	 * class is used to verify nested frame
	 * @throws InterruptedException
	 * @throws Customexception 
	 */
	@Test(priority=2)
	void performNestedFrame() throws InterruptedException, Customexception
	{
		Loggerclass.StartTest("Perform Nested Frame");
		Framepage fP=PageFactory.initElements(driver,Framepage.class);
		fP.clickOnNestedFrameBtn();
		fP.switchToNestedFirstFrame();
		fP.switchToNestedSecondFrame();
		fP.passText("Deshmukh");
		driver.switchTo().defaultContent();
		Loggerclass.EndTest("Perform Nested Frame");
	}
	
	@AfterClass
	void tearDown()
	{
		teardown();
	}
}

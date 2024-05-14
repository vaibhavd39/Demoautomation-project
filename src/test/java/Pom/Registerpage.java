/**
 * Register Page is used to create object repository
 */

package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage 
{

	//creaet webdriver variable
	WebDriver driver;
	
	//create parameterized constructor
	public Registerpage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//find webelemets
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	private WebElement Address;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement phoneTextBox;
	
	@FindBy(xpath="//form[@id='basicBootstrapForm']/div[5]/div/label[1]/input[1]")
	private WebElement male;
	
	@FindBy(xpath="//form[@id='basicBootstrapForm']/div[5]/div/label[2]/input")
	private WebElement female;
	
	
}

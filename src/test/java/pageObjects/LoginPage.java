package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	// TODO Auto-generated constructor stub
	public LoginPage(WebDriver driver) {super(driver);}

	//Locators
	@FindBy(xpath="//input[@id=\"input-email\"]") WebElement txtEmailAddress;
	@FindBy(xpath="//input[@name=\"password\"]") WebElement txtPassword;
	@FindBy(xpath="//input[@type=\"submit\"]") WebElement btnLogin;
	
	
	//Methods
	public void setEmail(String email) 
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginBTN() 
	{
		btnLogin.click();
	}
	
	
}


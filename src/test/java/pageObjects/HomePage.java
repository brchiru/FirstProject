package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	// TODO Auto-generated constructor stub
	public HomePage(WebDriver driver) {super(driver);}

	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccBtn;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement LoginBtn;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement accRegBtn;
	
	//Methods
	
	public void clickMyAccount() { myAccBtn.click();}
	
	public void clickLogin() { LoginBtn.click();}
	
	public void clickRegister() { accRegBtn.click();} 
	
}

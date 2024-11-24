package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC03_LoginValidationTest extends BaseClass 
{
	
	
	@Test(groups="Regression")
	public void validLogin() 
	{
		try 
		{
				HomePage hp = new HomePage(driver);
	
				hp.clickMyAccount();
	
				hp.clickLogin();
	
				LoginPage lp = new LoginPage(driver);
	
				lp.setEmail(p.getProperty("email"));
	
				lp.setPassword(p.getProperty("password")); 
	
				lp.clickLoginBTN();
	
				MyAccountPage map = new MyAccountPage(driver);
	
				boolean targetPage = map.isMyAccountPageExists();
	
				Assert.assertEquals(targetPage, true, "Login Failed");
		} 
		catch (Exception e) 
		{
			Assert.fail();
		}

	}

}

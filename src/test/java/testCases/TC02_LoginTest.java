package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass
{

		// TODO Auto-generated constructor stub
		@Test(groups="Sanity")
		public void verify_login() 
		{
			try 
			{
				HomePage hp = new HomePage(driver);
				
				hp.clickMyAccount();
				
				hp.clickLogin();
				
				/*
				 * LoginPage lp = new LoginPage(driver);
				 * 
				 * lp.setEmail(p.getProperty("email"));
				 * 
				 * lp.setPassword(p.getProperty("password"));
				 * 
				 * lp.clickLoginBTN();
				 * 
				 * MyAccountPage map = new MyAccountPage(driver);
				 * 
				 * boolean targetPage = map.isMyAccountPageExists();
				 * 
				 * Assert.assertEquals(targetPage, true, "Login Faileds");
				 */
			} 
			catch (Exception e)  
			{
				Assert.fail();
			}
		}
}


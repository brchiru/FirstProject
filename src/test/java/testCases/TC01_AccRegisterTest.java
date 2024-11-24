package testCases;


import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccRegisterTest extends BaseClass
{
	

	@Test(groups={"Sanity","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
	
		hp.clickMyAccount();
		
		hp.clickRegister();

	}

}

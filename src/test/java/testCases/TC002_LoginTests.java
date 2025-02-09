package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTests extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() 
	{
		logger.info("**TC002_LoginTests**");
		
		try {
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("**Clicked Login**");

		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("**Logging in**");
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//macc.clickMyacc();
        //Thread.sleep(5000);

		// Logout after verifying login
        macc.clickLogout();  // Log out
        
        Thread.sleep(5000);
        logger.info("**Logged out successfully**");
	
		
		Assert.assertTrue(targetPage);
		
			}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**Finished TC002_LoginTests**");

	}
	
	

}

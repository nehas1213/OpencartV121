package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) 
	{
		
		logger.info("**Starting TC003_LoginDDT**");
		
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("clicked login from dropdown");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		logger.info("clicked login");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		logger.info("entered myaccountpage");
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true) 
			{
				macc.clickLogout();
				logger.info("clicked logout");
				Assert.assertTrue(true);
				
			}
			else 
			{
				logger.info("cant logout");
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) 
		{
			if(targetPage==true) 
			{
				macc.clickLogout();
				logger.info("clicked logout");
				Assert.assertTrue(false);
			}
			else 
			{
				logger.info("cant logout");
				Assert.assertTrue(true);
			}
		}
		
		
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("**Finished TC003_LoginDDT**");
	}

}

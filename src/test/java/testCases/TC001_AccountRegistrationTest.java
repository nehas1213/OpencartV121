package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("***Strating TC001_AccountRegistrationTest***");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAcccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		Thread.sleep(5000);

		regpage.setPrivacyPolicy();
		Thread.sleep(5000);
		regpage.clickContinue();
		Thread.sleep(5000);
		
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		
		}
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("***Finished TC001_AccountRegistrationTest***");

	}
	
	
	
	/*public String randomeString() 
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomeNumber() 
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomeAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return(generatedstring+"$"+generatedNumber);

	}*/
	
	
	
}









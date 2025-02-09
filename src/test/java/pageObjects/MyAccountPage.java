package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void scrollToElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    try {
	        // Scroll to top first (if needed)
	      //  js.executeScript("window.scrollTo(0, 0);");
	        Thread.sleep(1000);  // Optional: wait for the scroll to complete

	        // Scroll to the desired element
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        Thread.sleep(1000);  // Optional: wait for the scroll to complete
	    } catch (Exception e) {
	        System.out.println("Error while scrolling: " + e.getMessage());
	    }
	}
	

	@FindBy(xpath = "//h1[normalize-space()='My Account']") WebElement msgHeading;
	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogout;
	//@FindBy(xpath ="//a[@class='dropdown-item'][normalize-space()='Logout']") WebElement lnkLogout;
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement Accdrp;
	public boolean isMyAccountPageExists() 
	{
		try
		{
		return(msgHeading.isDisplayed());
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	
	public void clickMyacc() 
	{
		Accdrp.click();
	}
	
	public void clickLogout() 
	{
		scrollToElement(lnkLogout);
		lnkLogout.click();
	}
}

package hrm;

import java.io.IOException;


import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;

public class homePage extends base{

	public homePagePattern hp;
	
	@BeforeMethod
	
	public void before() throws IOException {
	
	getDriver();	
	log.info("Successfully get driver.");
    hp = new homePagePattern(driver);
	LogIn();
	log.info("Get Login class from base.");
	
	}
	
	@Test(priority=0)
	
	public void verifyhomePageBar() {
		
		Assert.assertTrue(hp.homePageBar().isDisplayed());
		log.info("homePageBar is displayed.");
	}
	
	@Test(priority=1)
	
	public void StaticDropdowns() {
	
	
		hp.homePagePIM().click();
	    Select sel = new Select(hp.PIMEmplJobTitle());
	    sel.selectByValue("4");
	    sel.selectByIndex(5);
	    sel.selectByVisibleText("CEO");
	    log.info("Verify Static dropdowns.");
	  
		
		
	}
	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
}

package hrm;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;

public class userCheckBox extends base {
	
	public  homePagePattern hp;
	
	@BeforeMethod
	public void before() throws IOException {
		getDriver();
		LogIn();
		hp= new homePagePattern(driver);
	}
	
	
   @Test
   
   public void checkBoxes() {
	   
	   hp.adminUserCheckBoxes().click();
	  Assert.assertTrue( hp.adminUserCheckBoxes().isSelected());
   }
	

   @AfterMethod
   
   public void tearDown() {
	   
	   driver.quit();
   }
   
   
}

package hrm;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class loginPage extends base {
	public loginPagePattern lp;
	public homePagePattern hp;
	
	public Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeMethod
	
	public void before() throws IOException {
		getDriver();
		
		 lp = new loginPagePattern(driver);
		 hp = new homePagePattern(driver);
		 driver.get(prop.getProperty("url"));
		
	}
	
   @Test
   
   public void loginLogout() {
	   
	   lp.username().sendKeys(prop.getProperty("username"));
	   lp.userpassword().sendKeys(prop.getProperty("password"));
	   lp.LogInBtn().click();
	   Assert.assertEquals(hp.WelcomeAdmin().getText(), "Welcome Admin" );
	   hp.WelcomeAdmin().click();
	   wait.until(ExpectedConditions.elementToBeClickable(hp.LogOut())).click();
	   Assert.assertEquals(lp.LOGINPanel().getText(), "LOGIN Panel");
	   log.info("Successfully Logged in and Logged out.");
	  
}
   
   @Test(dataProvider="getData")
   
   public void NegLogIn(String username, String password) {
	   
	   lp.username().sendKeys(username);
	   lp.userpassword().sendKeys(password);
       lp.LogInBtn().click();
       Assert.assertEquals(lp.InvalidCredentials().getText(),"Invalid credentials");
       
       log.info("Negative log in is denied.");
   }
   
   @Test(dependsOnMethods={"loginLogout"})
   
   public void EmptyUserNameUserPassword() {
	   
	   lp.LogInBtn().click();
	   Assert.assertEquals(lp.EmptyUserNameText().getText(), "Username cannot be empty");
	   log.info("Validated Empty User Name and User Password");
   }

   @Test
   
   public void EmptyUserName() {
	   
	   lp.username().sendKeys("");
	   lp.userpassword().sendKeys(prop.getProperty("password"));
	   lp.LogInBtn().click();
	   Assert.assertEquals(lp.EmptyUserNameText().getText(), "Username cannot be empty");
	   log.info("Validated Empty User Name. ");    
   
   }
   
   
   @Test
   
   public void EmptyUserPassword() {
	   
	   lp.username().sendKeys(prop.getProperty("username"));
	   lp.userpassword().sendKeys("");
	   lp.LogInBtn().click();
	   Assert.assertEquals(lp.EmptyUserPasswordText().getText(), "Password cannot be empty");
       log.info("Validated Empty User Password. ");
   }
   
   @DataProvider
   
   public Object[][] getData() {
	   
	   Object[][] data = {{"admi","admin"},{"admin","admi"}};
	   return data;
	   
   }
   
   @AfterMethod
   
   public void tearDown() {
	   driver.quit();
   }
}
